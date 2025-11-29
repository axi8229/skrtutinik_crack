package androidx.camera.camera2.internal;

import android.hardware.camera2.CameraDevice;
import android.hardware.camera2.CaptureRequest;
import android.util.Size;
import androidx.arch.core.util.Function;
import androidx.camera.camera2.impl.Camera2ImplConfig;
import androidx.camera.camera2.internal.compat.params.DynamicRangesCompat;
import androidx.camera.camera2.interop.CaptureRequestOptions;
import androidx.camera.core.ImageAnalysis;
import androidx.camera.core.ImageCapture;
import androidx.camera.core.Logger;
import androidx.camera.core.Preview;
import androidx.camera.core.impl.CameraCaptureCallback;
import androidx.camera.core.impl.CaptureConfig;
import androidx.camera.core.impl.Config;
import androidx.camera.core.impl.DeferrableSurface;
import androidx.camera.core.impl.DeferrableSurfaces;
import androidx.camera.core.impl.OutputSurface;
import androidx.camera.core.impl.SessionConfig;
import androidx.camera.core.impl.SessionProcessor;
import androidx.camera.core.impl.SessionProcessorSurface;
import androidx.camera.core.impl.utils.executor.CameraXExecutors;
import androidx.camera.core.impl.utils.futures.AsyncFunction;
import androidx.camera.core.impl.utils.futures.FutureCallback;
import androidx.camera.core.impl.utils.futures.FutureChain;
import androidx.camera.core.impl.utils.futures.Futures;
import androidx.core.util.Preconditions;
import com.google.android.gms.location.DeviceOrientationRequest;
import com.google.common.util.concurrent.ListenableFuture;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.util.Objects;
import java.util.concurrent.Executor;
import java.util.concurrent.ScheduledExecutorService;

/* loaded from: classes.dex */
final class ProcessingCaptureSession implements CaptureSessionInterface {
    private static List<DeferrableSurface> sHeldProcessorSurfaces = new ArrayList();
    private static int sNextInstanceId = 0;
    private final Camera2CameraInfoImpl mCamera2CameraInfoImpl;
    private final CaptureSession mCaptureSession;
    final Executor mExecutor;
    private int mInstanceId;
    private SessionConfig mProcessorSessionConfig;
    private Camera2RequestProcessor mRequestProcessor;
    private final ScheduledExecutorService mScheduledExecutorService;
    private SessionConfig mSessionConfig;
    private final SessionProcessor mSessionProcessor;
    private List<DeferrableSurface> mOutputSurfaces = new ArrayList();
    private volatile List<CaptureConfig> mPendingCaptureConfigs = null;
    volatile boolean mIsExecutingStillCaptureRequest = false;
    private CaptureRequestOptions mSessionOptions = new CaptureRequestOptions.Builder().build();
    private CaptureRequestOptions mStillCaptureOptions = new CaptureRequestOptions.Builder().build();
    private ProcessorState mProcessorState = ProcessorState.UNINITIALIZED;
    private final SessionProcessorCaptureCallback mSessionProcessorCaptureCallback = new SessionProcessorCaptureCallback();

    private enum ProcessorState {
        UNINITIALIZED,
        SESSION_INITIALIZED,
        ON_CAPTURE_SESSION_STARTED,
        ON_CAPTURE_SESSION_ENDED,
        DE_INITIALIZED
    }

    @Override // androidx.camera.camera2.internal.CaptureSessionInterface
    public void setStreamUseCaseMap(Map<DeferrableSurface, Long> map) {
    }

    ProcessingCaptureSession(SessionProcessor sessionProcessor, Camera2CameraInfoImpl camera2CameraInfoImpl, DynamicRangesCompat dynamicRangesCompat, Executor executor, ScheduledExecutorService scheduledExecutorService) {
        this.mInstanceId = 0;
        this.mCaptureSession = new CaptureSession(dynamicRangesCompat);
        this.mSessionProcessor = sessionProcessor;
        this.mCamera2CameraInfoImpl = camera2CameraInfoImpl;
        this.mExecutor = executor;
        this.mScheduledExecutorService = scheduledExecutorService;
        int i = sNextInstanceId;
        sNextInstanceId = i + 1;
        this.mInstanceId = i;
        Logger.d("ProcessingCaptureSession", "New ProcessingCaptureSession (id=" + this.mInstanceId + ")");
    }

    @Override // androidx.camera.camera2.internal.CaptureSessionInterface
    public ListenableFuture<Void> open(final SessionConfig sessionConfig, final CameraDevice cameraDevice, final SynchronizedCaptureSessionOpener synchronizedCaptureSessionOpener) {
        Preconditions.checkArgument(this.mProcessorState == ProcessorState.UNINITIALIZED, "Invalid state state:" + this.mProcessorState);
        Preconditions.checkArgument(sessionConfig.getSurfaces().isEmpty() ^ true, "SessionConfig contains no surfaces");
        Logger.d("ProcessingCaptureSession", "open (id=" + this.mInstanceId + ")");
        List<DeferrableSurface> surfaces = sessionConfig.getSurfaces();
        this.mOutputSurfaces = surfaces;
        return FutureChain.from(DeferrableSurfaces.surfaceListWithTimeout(surfaces, false, DeviceOrientationRequest.OUTPUT_PERIOD_FAST, this.mExecutor, this.mScheduledExecutorService)).transformAsync(new AsyncFunction() { // from class: androidx.camera.camera2.internal.ProcessingCaptureSession$$ExternalSyntheticLambda2
            @Override // androidx.camera.core.impl.utils.futures.AsyncFunction
            public final ListenableFuture apply(Object obj) {
                return this.f$0.lambda$open$2(sessionConfig, cameraDevice, synchronizedCaptureSessionOpener, (List) obj);
            }
        }, this.mExecutor).transform(new Function() { // from class: androidx.camera.camera2.internal.ProcessingCaptureSession$$ExternalSyntheticLambda3
            @Override // androidx.arch.core.util.Function
            public final Object apply(Object obj) {
                return this.f$0.lambda$open$3((Void) obj);
            }
        }, this.mExecutor);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public /* synthetic */ ListenableFuture lambda$open$2(SessionConfig sessionConfig, CameraDevice cameraDevice, SynchronizedCaptureSessionOpener synchronizedCaptureSessionOpener, List list) throws Exception {
        Logger.d("ProcessingCaptureSession", "-- getSurfaces done, start init (id=" + this.mInstanceId + ")");
        if (this.mProcessorState == ProcessorState.DE_INITIALIZED) {
            return Futures.immediateFailedFuture(new IllegalStateException("SessionProcessorCaptureSession is closed."));
        }
        OutputSurface outputSurfaceCreate = null;
        if (list.contains(null)) {
            return Futures.immediateFailedFuture(new DeferrableSurface.SurfaceClosedException("Surface closed", sessionConfig.getSurfaces().get(list.indexOf(null))));
        }
        OutputSurface outputSurfaceCreate2 = null;
        OutputSurface outputSurfaceCreate3 = null;
        for (int i = 0; i < sessionConfig.getSurfaces().size(); i++) {
            DeferrableSurface deferrableSurface = sessionConfig.getSurfaces().get(i);
            if (Objects.equals(deferrableSurface.getContainerClass(), Preview.class)) {
                outputSurfaceCreate = OutputSurface.create(deferrableSurface.getSurface().get(), new Size(deferrableSurface.getPrescribedSize().getWidth(), deferrableSurface.getPrescribedSize().getHeight()), deferrableSurface.getPrescribedStreamFormat());
            } else if (Objects.equals(deferrableSurface.getContainerClass(), ImageCapture.class)) {
                outputSurfaceCreate2 = OutputSurface.create(deferrableSurface.getSurface().get(), new Size(deferrableSurface.getPrescribedSize().getWidth(), deferrableSurface.getPrescribedSize().getHeight()), deferrableSurface.getPrescribedStreamFormat());
            } else if (Objects.equals(deferrableSurface.getContainerClass(), ImageAnalysis.class)) {
                outputSurfaceCreate3 = OutputSurface.create(deferrableSurface.getSurface().get(), new Size(deferrableSurface.getPrescribedSize().getWidth(), deferrableSurface.getPrescribedSize().getHeight()), deferrableSurface.getPrescribedStreamFormat());
            }
        }
        this.mProcessorState = ProcessorState.SESSION_INITIALIZED;
        try {
            DeferrableSurfaces.incrementAll(this.mOutputSurfaces);
            Logger.w("ProcessingCaptureSession", "== initSession (id=" + this.mInstanceId + ")");
            try {
                SessionConfig sessionConfigInitSession = this.mSessionProcessor.initSession(this.mCamera2CameraInfoImpl, outputSurfaceCreate, outputSurfaceCreate2, outputSurfaceCreate3);
                this.mProcessorSessionConfig = sessionConfigInitSession;
                sessionConfigInitSession.getSurfaces().get(0).getTerminationFuture().addListener(new Runnable() { // from class: androidx.camera.camera2.internal.ProcessingCaptureSession$$ExternalSyntheticLambda0
                    @Override // java.lang.Runnable
                    public final void run() {
                        this.f$0.lambda$open$0();
                    }
                }, CameraXExecutors.directExecutor());
                for (final DeferrableSurface deferrableSurface2 : this.mProcessorSessionConfig.getSurfaces()) {
                    sHeldProcessorSurfaces.add(deferrableSurface2);
                    deferrableSurface2.getTerminationFuture().addListener(new Runnable() { // from class: androidx.camera.camera2.internal.ProcessingCaptureSession$$ExternalSyntheticLambda1
                        @Override // java.lang.Runnable
                        public final void run() {
                            ProcessingCaptureSession.lambda$open$1(deferrableSurface2);
                        }
                    }, this.mExecutor);
                }
                SessionConfig.ValidatingBuilder validatingBuilder = new SessionConfig.ValidatingBuilder();
                validatingBuilder.add(sessionConfig);
                validatingBuilder.clearSurfaces();
                validatingBuilder.add(this.mProcessorSessionConfig);
                Preconditions.checkArgument(validatingBuilder.isValid(), "Cannot transform the SessionConfig");
                ListenableFuture<Void> listenableFutureOpen = this.mCaptureSession.open(validatingBuilder.build(), (CameraDevice) Preconditions.checkNotNull(cameraDevice), synchronizedCaptureSessionOpener);
                Futures.addCallback(listenableFutureOpen, new FutureCallback<Void>() { // from class: androidx.camera.camera2.internal.ProcessingCaptureSession.1
                    @Override // androidx.camera.core.impl.utils.futures.FutureCallback
                    public void onSuccess(Void r1) {
                    }

                    @Override // androidx.camera.core.impl.utils.futures.FutureCallback
                    public void onFailure(Throwable th) {
                        Logger.e("ProcessingCaptureSession", "open session failed ", th);
                        ProcessingCaptureSession.this.close();
                        ProcessingCaptureSession.this.release(false);
                    }
                }, this.mExecutor);
                return listenableFutureOpen;
            } catch (Throwable th) {
                DeferrableSurfaces.decrementAll(this.mOutputSurfaces);
                throw th;
            }
        } catch (DeferrableSurface.SurfaceClosedException e) {
            return Futures.immediateFailedFuture(e);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public /* synthetic */ void lambda$open$0() {
        DeferrableSurfaces.decrementAll(this.mOutputSurfaces);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static /* synthetic */ void lambda$open$1(DeferrableSurface deferrableSurface) {
        sHeldProcessorSurfaces.remove(deferrableSurface);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public /* synthetic */ Void lambda$open$3(Void r1) {
        onConfigured(this.mCaptureSession);
        return null;
    }

    private static void cancelRequests(List<CaptureConfig> list) {
        Iterator<CaptureConfig> it = list.iterator();
        while (it.hasNext()) {
            Iterator<CameraCaptureCallback> it2 = it.next().getCameraCaptureCallbacks().iterator();
            while (it2.hasNext()) {
                it2.next().onCaptureCancelled();
            }
        }
    }

    void issueTriggerRequest(final CaptureConfig captureConfig) {
        Logger.d("ProcessingCaptureSession", "issueTriggerRequest");
        CaptureRequestOptions captureRequestOptionsBuild = CaptureRequestOptions.Builder.from(captureConfig.getImplementationOptions()).build();
        Iterator<Config.Option<?>> it = captureRequestOptionsBuild.listOptions().iterator();
        while (it.hasNext()) {
            CaptureRequest.Key key = (CaptureRequest.Key) it.next().getToken();
            if (key.equals(CaptureRequest.CONTROL_AF_TRIGGER) || key.equals(CaptureRequest.CONTROL_AE_PRECAPTURE_TRIGGER)) {
                this.mSessionProcessor.startTrigger(captureRequestOptionsBuild, new SessionProcessor.CaptureCallback() { // from class: androidx.camera.camera2.internal.ProcessingCaptureSession.2
                });
                return;
            }
        }
        cancelRequests(Arrays.asList(captureConfig));
    }

    @Override // androidx.camera.camera2.internal.CaptureSessionInterface
    public void issueCaptureRequests(List<CaptureConfig> list) {
        if (list.isEmpty()) {
            return;
        }
        Logger.d("ProcessingCaptureSession", "issueCaptureRequests (id=" + this.mInstanceId + ") + state =" + this.mProcessorState);
        int i = AnonymousClass4.$SwitchMap$androidx$camera$camera2$internal$ProcessingCaptureSession$ProcessorState[this.mProcessorState.ordinal()];
        if (i == 1 || i == 2) {
            this.mPendingCaptureConfigs = list;
            return;
        }
        if (i == 3) {
            for (CaptureConfig captureConfig : list) {
                if (captureConfig.getTemplateType() == 2) {
                    issueStillCaptureRequest(captureConfig);
                } else {
                    issueTriggerRequest(captureConfig);
                }
            }
            return;
        }
        if (i == 4 || i == 5) {
            Logger.d("ProcessingCaptureSession", "Run issueCaptureRequests in wrong state, state = " + this.mProcessorState);
            cancelRequests(list);
        }
    }

    /* renamed from: androidx.camera.camera2.internal.ProcessingCaptureSession$4, reason: invalid class name */
    static /* synthetic */ class AnonymousClass4 {
        static final /* synthetic */ int[] $SwitchMap$androidx$camera$camera2$internal$ProcessingCaptureSession$ProcessorState;

        static {
            int[] iArr = new int[ProcessorState.values().length];
            $SwitchMap$androidx$camera$camera2$internal$ProcessingCaptureSession$ProcessorState = iArr;
            try {
                iArr[ProcessorState.UNINITIALIZED.ordinal()] = 1;
            } catch (NoSuchFieldError unused) {
            }
            try {
                $SwitchMap$androidx$camera$camera2$internal$ProcessingCaptureSession$ProcessorState[ProcessorState.SESSION_INITIALIZED.ordinal()] = 2;
            } catch (NoSuchFieldError unused2) {
            }
            try {
                $SwitchMap$androidx$camera$camera2$internal$ProcessingCaptureSession$ProcessorState[ProcessorState.ON_CAPTURE_SESSION_STARTED.ordinal()] = 3;
            } catch (NoSuchFieldError unused3) {
            }
            try {
                $SwitchMap$androidx$camera$camera2$internal$ProcessingCaptureSession$ProcessorState[ProcessorState.ON_CAPTURE_SESSION_ENDED.ordinal()] = 4;
            } catch (NoSuchFieldError unused4) {
            }
            try {
                $SwitchMap$androidx$camera$camera2$internal$ProcessingCaptureSession$ProcessorState[ProcessorState.DE_INITIALIZED.ordinal()] = 5;
            } catch (NoSuchFieldError unused5) {
            }
        }
    }

    void issueStillCaptureRequest(final CaptureConfig captureConfig) {
        CaptureRequestOptions.Builder builderFrom = CaptureRequestOptions.Builder.from(captureConfig.getImplementationOptions());
        Config implementationOptions = captureConfig.getImplementationOptions();
        Config.Option<Integer> option = CaptureConfig.OPTION_ROTATION;
        if (implementationOptions.containsOption(option)) {
            builderFrom.setCaptureRequestOption(CaptureRequest.JPEG_ORIENTATION, (Integer) captureConfig.getImplementationOptions().retrieveOption(option));
        }
        Config implementationOptions2 = captureConfig.getImplementationOptions();
        Config.Option<Integer> option2 = CaptureConfig.OPTION_JPEG_QUALITY;
        if (implementationOptions2.containsOption(option2)) {
            builderFrom.setCaptureRequestOption(CaptureRequest.JPEG_QUALITY, Byte.valueOf(((Integer) captureConfig.getImplementationOptions().retrieveOption(option2)).byteValue()));
        }
        CaptureRequestOptions captureRequestOptionsBuild = builderFrom.build();
        this.mStillCaptureOptions = captureRequestOptionsBuild;
        updateParameters(this.mSessionOptions, captureRequestOptionsBuild);
        this.mSessionProcessor.startCapture(new SessionProcessor.CaptureCallback() { // from class: androidx.camera.camera2.internal.ProcessingCaptureSession.3
        });
    }

    @Override // androidx.camera.camera2.internal.CaptureSessionInterface
    public ListenableFuture<Void> release(boolean z) {
        Logger.d("ProcessingCaptureSession", "release (id=" + this.mInstanceId + ") mProcessorState=" + this.mProcessorState);
        ListenableFuture<Void> listenableFutureRelease = this.mCaptureSession.release(z);
        int i = AnonymousClass4.$SwitchMap$androidx$camera$camera2$internal$ProcessingCaptureSession$ProcessorState[this.mProcessorState.ordinal()];
        if (i == 2 || i == 4) {
            listenableFutureRelease.addListener(new Runnable() { // from class: androidx.camera.camera2.internal.ProcessingCaptureSession$$ExternalSyntheticLambda4
                @Override // java.lang.Runnable
                public final void run() {
                    this.f$0.lambda$release$4();
                }
            }, CameraXExecutors.directExecutor());
        }
        this.mProcessorState = ProcessorState.DE_INITIALIZED;
        return listenableFutureRelease;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public /* synthetic */ void lambda$release$4() {
        Logger.d("ProcessingCaptureSession", "== deInitSession (id=" + this.mInstanceId + ")");
        this.mSessionProcessor.deInitSession();
    }

    private static List<SessionProcessorSurface> getSessionProcessorSurfaceList(List<DeferrableSurface> list) {
        ArrayList arrayList = new ArrayList();
        for (DeferrableSurface deferrableSurface : list) {
            Preconditions.checkArgument(deferrableSurface instanceof SessionProcessorSurface, "Surface must be SessionProcessorSurface");
            arrayList.add((SessionProcessorSurface) deferrableSurface);
        }
        return arrayList;
    }

    void onConfigured(CaptureSession captureSession) {
        Preconditions.checkArgument(this.mProcessorState == ProcessorState.SESSION_INITIALIZED, "Invalid state state:" + this.mProcessorState);
        this.mRequestProcessor = new Camera2RequestProcessor(captureSession, getSessionProcessorSurfaceList(this.mProcessorSessionConfig.getSurfaces()));
        Logger.d("ProcessingCaptureSession", "== onCaptureSessinStarted (id = " + this.mInstanceId + ")");
        this.mSessionProcessor.onCaptureSessionStart(this.mRequestProcessor);
        this.mProcessorState = ProcessorState.ON_CAPTURE_SESSION_STARTED;
        SessionConfig sessionConfig = this.mSessionConfig;
        if (sessionConfig != null) {
            setSessionConfig(sessionConfig);
        }
        if (this.mPendingCaptureConfigs != null) {
            issueCaptureRequests(this.mPendingCaptureConfigs);
            this.mPendingCaptureConfigs = null;
        }
    }

    @Override // androidx.camera.camera2.internal.CaptureSessionInterface
    public SessionConfig getSessionConfig() {
        return this.mSessionConfig;
    }

    @Override // androidx.camera.camera2.internal.CaptureSessionInterface
    public List<CaptureConfig> getCaptureConfigs() {
        return this.mPendingCaptureConfigs != null ? this.mPendingCaptureConfigs : Collections.emptyList();
    }

    @Override // androidx.camera.camera2.internal.CaptureSessionInterface
    public void cancelIssuedCaptureRequests() {
        Logger.d("ProcessingCaptureSession", "cancelIssuedCaptureRequests (id=" + this.mInstanceId + ")");
        if (this.mPendingCaptureConfigs != null) {
            Iterator<CaptureConfig> it = this.mPendingCaptureConfigs.iterator();
            while (it.hasNext()) {
                Iterator<CameraCaptureCallback> it2 = it.next().getCameraCaptureCallbacks().iterator();
                while (it2.hasNext()) {
                    it2.next().onCaptureCancelled();
                }
            }
            this.mPendingCaptureConfigs = null;
        }
    }

    @Override // androidx.camera.camera2.internal.CaptureSessionInterface
    public void close() {
        Logger.d("ProcessingCaptureSession", "close (id=" + this.mInstanceId + ") state=" + this.mProcessorState);
        if (this.mProcessorState == ProcessorState.ON_CAPTURE_SESSION_STARTED) {
            Logger.d("ProcessingCaptureSession", "== onCaptureSessionEnd (id = " + this.mInstanceId + ")");
            this.mSessionProcessor.onCaptureSessionEnd();
            Camera2RequestProcessor camera2RequestProcessor = this.mRequestProcessor;
            if (camera2RequestProcessor != null) {
                camera2RequestProcessor.close();
            }
            this.mProcessorState = ProcessorState.ON_CAPTURE_SESSION_ENDED;
        }
        this.mCaptureSession.close();
    }

    @Override // androidx.camera.camera2.internal.CaptureSessionInterface
    public void setSessionConfig(SessionConfig sessionConfig) {
        Logger.d("ProcessingCaptureSession", "setSessionConfig (id=" + this.mInstanceId + ")");
        this.mSessionConfig = sessionConfig;
        if (sessionConfig == null) {
            return;
        }
        Camera2RequestProcessor camera2RequestProcessor = this.mRequestProcessor;
        if (camera2RequestProcessor != null) {
            camera2RequestProcessor.updateSessionConfig(sessionConfig);
        }
        if (this.mProcessorState == ProcessorState.ON_CAPTURE_SESSION_STARTED) {
            CaptureRequestOptions captureRequestOptionsBuild = CaptureRequestOptions.Builder.from(sessionConfig.getImplementationOptions()).build();
            this.mSessionOptions = captureRequestOptionsBuild;
            updateParameters(captureRequestOptionsBuild, this.mStillCaptureOptions);
            if (!hasPreviewSurface(sessionConfig.getRepeatingCaptureConfig())) {
                this.mSessionProcessor.stopRepeating();
            } else {
                this.mSessionProcessor.startRepeating(this.mSessionProcessorCaptureCallback);
            }
        }
    }

    private boolean hasPreviewSurface(CaptureConfig captureConfig) {
        Iterator<DeferrableSurface> it = captureConfig.getSurfaces().iterator();
        while (it.hasNext()) {
            if (Objects.equals(it.next().getContainerClass(), Preview.class)) {
                return true;
            }
        }
        return false;
    }

    private void updateParameters(CaptureRequestOptions captureRequestOptions, CaptureRequestOptions captureRequestOptions2) {
        Camera2ImplConfig.Builder builder = new Camera2ImplConfig.Builder();
        builder.insertAllOptions(captureRequestOptions);
        builder.insertAllOptions(captureRequestOptions2);
        this.mSessionProcessor.setParameters(builder.build());
    }

    private static class SessionProcessorCaptureCallback implements SessionProcessor.CaptureCallback {
        SessionProcessorCaptureCallback() {
        }
    }
}

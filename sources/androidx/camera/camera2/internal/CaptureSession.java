package androidx.camera.camera2.internal;

import android.hardware.camera2.CameraAccessException;
import android.hardware.camera2.CameraCaptureSession;
import android.hardware.camera2.CameraDevice;
import android.hardware.camera2.CaptureRequest;
import android.hardware.camera2.TotalCaptureResult;
import android.hardware.camera2.params.DynamicRangeProfiles;
import android.os.Build;
import android.view.Surface;
import androidx.camera.camera2.impl.Camera2ImplConfig;
import androidx.camera.camera2.impl.CameraEventCallbacks;
import androidx.camera.camera2.internal.CameraBurstCaptureCallback;
import androidx.camera.camera2.internal.SynchronizedCaptureSession;
import androidx.camera.camera2.internal.SynchronizedCaptureSessionStateCallbacks;
import androidx.camera.camera2.internal.compat.params.DynamicRangeConversions;
import androidx.camera.camera2.internal.compat.params.DynamicRangesCompat;
import androidx.camera.camera2.internal.compat.params.InputConfigurationCompat;
import androidx.camera.camera2.internal.compat.params.OutputConfigurationCompat;
import androidx.camera.camera2.internal.compat.params.SessionConfigurationCompat;
import androidx.camera.camera2.internal.compat.workaround.StillCaptureFlow;
import androidx.camera.camera2.internal.compat.workaround.TorchStateReset;
import androidx.camera.core.DynamicRange;
import androidx.camera.core.Logger;
import androidx.camera.core.impl.CameraCaptureCallback;
import androidx.camera.core.impl.CaptureConfig;
import androidx.camera.core.impl.Config;
import androidx.camera.core.impl.DeferrableSurface;
import androidx.camera.core.impl.MutableOptionsBundle;
import androidx.camera.core.impl.OptionsBundle;
import androidx.camera.core.impl.SessionConfig;
import androidx.camera.core.impl.utils.futures.AsyncFunction;
import androidx.camera.core.impl.utils.futures.FutureCallback;
import androidx.camera.core.impl.utils.futures.FutureChain;
import androidx.camera.core.impl.utils.futures.Futures;
import androidx.concurrent.futures.CallbackToFutureAdapter;
import androidx.core.util.Preconditions;
import com.google.android.gms.location.DeviceOrientationRequest;
import com.google.common.util.concurrent.ListenableFuture;
import java.util.ArrayList;
import java.util.Collections;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.util.Objects;
import java.util.concurrent.CancellationException;

/* loaded from: classes.dex */
final class CaptureSession implements CaptureSessionInterface {
    private final DynamicRangesCompat mDynamicRangesCompat;
    CallbackToFutureAdapter.Completer<Void> mReleaseCompleter;
    ListenableFuture<Void> mReleaseFuture;
    SessionConfig mSessionConfig;
    State mState;
    SynchronizedCaptureSession mSynchronizedCaptureSession;
    SynchronizedCaptureSessionOpener mSynchronizedCaptureSessionOpener;
    final Object mSessionLock = new Object();
    private final List<CaptureConfig> mCaptureConfigs = new ArrayList();
    private final CameraCaptureSession.CaptureCallback mCaptureCallback = new CameraCaptureSession.CaptureCallback() { // from class: androidx.camera.camera2.internal.CaptureSession.1
        @Override // android.hardware.camera2.CameraCaptureSession.CaptureCallback
        public void onCaptureCompleted(CameraCaptureSession cameraCaptureSession, CaptureRequest captureRequest, TotalCaptureResult totalCaptureResult) {
        }
    };
    Config mCameraEventOnRepeatingOptions = OptionsBundle.emptyBundle();
    CameraEventCallbacks mCameraEventCallbacks = CameraEventCallbacks.createEmptyCallback();
    private final Map<DeferrableSurface, Surface> mConfiguredSurfaceMap = new HashMap();
    List<DeferrableSurface> mConfiguredDeferrableSurfaces = Collections.emptyList();
    Map<DeferrableSurface, Long> mStreamUseCaseMap = new HashMap();
    final StillCaptureFlow mStillCaptureFlow = new StillCaptureFlow();
    final TorchStateReset mTorchStateReset = new TorchStateReset();
    private final StateCallback mCaptureSessionStateCallback = new StateCallback();

    enum State {
        UNINITIALIZED,
        INITIALIZED,
        GET_SURFACE,
        OPENING,
        OPENED,
        CLOSED,
        RELEASING,
        RELEASED
    }

    CaptureSession(DynamicRangesCompat dynamicRangesCompat) {
        this.mState = State.UNINITIALIZED;
        this.mState = State.INITIALIZED;
        this.mDynamicRangesCompat = dynamicRangesCompat;
    }

    @Override // androidx.camera.camera2.internal.CaptureSessionInterface
    public void setStreamUseCaseMap(Map<DeferrableSurface, Long> map) {
        synchronized (this.mSessionLock) {
            this.mStreamUseCaseMap = map;
        }
    }

    @Override // androidx.camera.camera2.internal.CaptureSessionInterface
    public SessionConfig getSessionConfig() {
        SessionConfig sessionConfig;
        synchronized (this.mSessionLock) {
            sessionConfig = this.mSessionConfig;
        }
        return sessionConfig;
    }

    /* renamed from: androidx.camera.camera2.internal.CaptureSession$4, reason: invalid class name */
    static /* synthetic */ class AnonymousClass4 {
        static final /* synthetic */ int[] $SwitchMap$androidx$camera$camera2$internal$CaptureSession$State;

        static {
            int[] iArr = new int[State.values().length];
            $SwitchMap$androidx$camera$camera2$internal$CaptureSession$State = iArr;
            try {
                iArr[State.UNINITIALIZED.ordinal()] = 1;
            } catch (NoSuchFieldError unused) {
            }
            try {
                $SwitchMap$androidx$camera$camera2$internal$CaptureSession$State[State.INITIALIZED.ordinal()] = 2;
            } catch (NoSuchFieldError unused2) {
            }
            try {
                $SwitchMap$androidx$camera$camera2$internal$CaptureSession$State[State.GET_SURFACE.ordinal()] = 3;
            } catch (NoSuchFieldError unused3) {
            }
            try {
                $SwitchMap$androidx$camera$camera2$internal$CaptureSession$State[State.OPENING.ordinal()] = 4;
            } catch (NoSuchFieldError unused4) {
            }
            try {
                $SwitchMap$androidx$camera$camera2$internal$CaptureSession$State[State.OPENED.ordinal()] = 5;
            } catch (NoSuchFieldError unused5) {
            }
            try {
                $SwitchMap$androidx$camera$camera2$internal$CaptureSession$State[State.CLOSED.ordinal()] = 6;
            } catch (NoSuchFieldError unused6) {
            }
            try {
                $SwitchMap$androidx$camera$camera2$internal$CaptureSession$State[State.RELEASING.ordinal()] = 7;
            } catch (NoSuchFieldError unused7) {
            }
            try {
                $SwitchMap$androidx$camera$camera2$internal$CaptureSession$State[State.RELEASED.ordinal()] = 8;
            } catch (NoSuchFieldError unused8) {
            }
        }
    }

    @Override // androidx.camera.camera2.internal.CaptureSessionInterface
    public void setSessionConfig(SessionConfig sessionConfig) {
        synchronized (this.mSessionLock) {
            try {
                switch (AnonymousClass4.$SwitchMap$androidx$camera$camera2$internal$CaptureSession$State[this.mState.ordinal()]) {
                    case 1:
                        throw new IllegalStateException("setSessionConfig() should not be possible in state: " + this.mState);
                    case 2:
                    case 3:
                    case 4:
                        this.mSessionConfig = sessionConfig;
                        break;
                    case 5:
                        this.mSessionConfig = sessionConfig;
                        if (sessionConfig != null) {
                            if (!this.mConfiguredSurfaceMap.keySet().containsAll(sessionConfig.getSurfaces())) {
                                Logger.e("CaptureSession", "Does not have the proper configured lists");
                                return;
                            } else {
                                Logger.d("CaptureSession", "Attempting to submit CaptureRequest after setting");
                                issueRepeatingCaptureRequests(this.mSessionConfig);
                                break;
                            }
                        } else {
                            return;
                        }
                    case 6:
                    case 7:
                    case 8:
                        throw new IllegalStateException("Session configuration cannot be set on a closed/released session.");
                }
            } finally {
            }
        }
    }

    @Override // androidx.camera.camera2.internal.CaptureSessionInterface
    public ListenableFuture<Void> open(final SessionConfig sessionConfig, final CameraDevice cameraDevice, SynchronizedCaptureSessionOpener synchronizedCaptureSessionOpener) {
        synchronized (this.mSessionLock) {
            try {
                if (AnonymousClass4.$SwitchMap$androidx$camera$camera2$internal$CaptureSession$State[this.mState.ordinal()] == 2) {
                    this.mState = State.GET_SURFACE;
                    ArrayList arrayList = new ArrayList(sessionConfig.getSurfaces());
                    this.mConfiguredDeferrableSurfaces = arrayList;
                    this.mSynchronizedCaptureSessionOpener = synchronizedCaptureSessionOpener;
                    FutureChain futureChainTransformAsync = FutureChain.from(synchronizedCaptureSessionOpener.startWithDeferrableSurface(arrayList, DeviceOrientationRequest.OUTPUT_PERIOD_FAST)).transformAsync(new AsyncFunction() { // from class: androidx.camera.camera2.internal.CaptureSession$$ExternalSyntheticLambda2
                        @Override // androidx.camera.core.impl.utils.futures.AsyncFunction
                        public final ListenableFuture apply(Object obj) {
                            return this.f$0.lambda$open$0(sessionConfig, cameraDevice, (List) obj);
                        }
                    }, this.mSynchronizedCaptureSessionOpener.getExecutor());
                    Futures.addCallback(futureChainTransformAsync, new FutureCallback<Void>() { // from class: androidx.camera.camera2.internal.CaptureSession.2
                        @Override // androidx.camera.core.impl.utils.futures.FutureCallback
                        public void onSuccess(Void r1) {
                        }

                        @Override // androidx.camera.core.impl.utils.futures.FutureCallback
                        public void onFailure(Throwable th) {
                            synchronized (CaptureSession.this.mSessionLock) {
                                try {
                                    CaptureSession.this.mSynchronizedCaptureSessionOpener.stop();
                                    int i = AnonymousClass4.$SwitchMap$androidx$camera$camera2$internal$CaptureSession$State[CaptureSession.this.mState.ordinal()];
                                    if ((i == 4 || i == 6 || i == 7) && !(th instanceof CancellationException)) {
                                        Logger.w("CaptureSession", "Opening session with fail " + CaptureSession.this.mState, th);
                                        CaptureSession.this.finishClose();
                                    }
                                } finally {
                                }
                            }
                        }
                    }, this.mSynchronizedCaptureSessionOpener.getExecutor());
                    return Futures.nonCancellationPropagating(futureChainTransformAsync);
                }
                Logger.e("CaptureSession", "Open not allowed in state: " + this.mState);
                return Futures.immediateFailedFuture(new IllegalStateException("open() should not allow the state: " + this.mState));
            } catch (Throwable th) {
                throw th;
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* renamed from: openCaptureSession, reason: merged with bridge method [inline-methods] */
    public ListenableFuture<Void> lambda$open$0(List<Surface> list, SessionConfig sessionConfig, CameraDevice cameraDevice) {
        synchronized (this.mSessionLock) {
            try {
                int i = AnonymousClass4.$SwitchMap$androidx$camera$camera2$internal$CaptureSession$State[this.mState.ordinal()];
                if (i != 1 && i != 2) {
                    if (i == 3) {
                        this.mConfiguredSurfaceMap.clear();
                        for (int i2 = 0; i2 < list.size(); i2++) {
                            this.mConfiguredSurfaceMap.put(this.mConfiguredDeferrableSurfaces.get(i2), list.get(i2));
                        }
                        this.mState = State.OPENING;
                        Logger.d("CaptureSession", "Opening capture session.");
                        SynchronizedCaptureSession.StateCallback stateCallbackCreateComboCallback = SynchronizedCaptureSessionStateCallbacks.createComboCallback(this.mCaptureSessionStateCallback, new SynchronizedCaptureSessionStateCallbacks.Adapter(sessionConfig.getSessionStateCallbacks()));
                        Camera2ImplConfig camera2ImplConfig = new Camera2ImplConfig(sessionConfig.getImplementationOptions());
                        CameraEventCallbacks cameraEventCallback = camera2ImplConfig.getCameraEventCallback(CameraEventCallbacks.createEmptyCallback());
                        this.mCameraEventCallbacks = cameraEventCallback;
                        List<CaptureConfig> listOnInitSession = cameraEventCallback.createComboCallback().onInitSession();
                        CaptureConfig.Builder builderFrom = CaptureConfig.Builder.from(sessionConfig.getRepeatingCaptureConfig());
                        Iterator<CaptureConfig> it = listOnInitSession.iterator();
                        while (it.hasNext()) {
                            builderFrom.addImplementationOptions(it.next().getImplementationOptions());
                        }
                        ArrayList arrayList = new ArrayList();
                        String physicalCameraId = camera2ImplConfig.getPhysicalCameraId(null);
                        for (SessionConfig.OutputConfig outputConfig : sessionConfig.getOutputConfigs()) {
                            OutputConfigurationCompat outputConfigurationCompat = getOutputConfigurationCompat(outputConfig, this.mConfiguredSurfaceMap, physicalCameraId);
                            if (this.mStreamUseCaseMap.containsKey(outputConfig.getSurface())) {
                                outputConfigurationCompat.setStreamUseCase(this.mStreamUseCaseMap.get(outputConfig.getSurface()).longValue());
                            }
                            arrayList.add(outputConfigurationCompat);
                        }
                        SessionConfigurationCompat sessionConfigurationCompatCreateSessionConfigurationCompat = this.mSynchronizedCaptureSessionOpener.createSessionConfigurationCompat(0, getUniqueOutputConfigurations(arrayList), stateCallbackCreateComboCallback);
                        if (sessionConfig.getTemplateType() == 5 && sessionConfig.getInputConfiguration() != null) {
                            sessionConfigurationCompatCreateSessionConfigurationCompat.setInputConfiguration(InputConfigurationCompat.wrap(sessionConfig.getInputConfiguration()));
                        }
                        try {
                            CaptureRequest captureRequestBuildWithoutTarget = Camera2CaptureRequestBuilder.buildWithoutTarget(builderFrom.build(), cameraDevice);
                            if (captureRequestBuildWithoutTarget != null) {
                                sessionConfigurationCompatCreateSessionConfigurationCompat.setSessionParameters(captureRequestBuildWithoutTarget);
                            }
                            return this.mSynchronizedCaptureSessionOpener.openCaptureSession(cameraDevice, sessionConfigurationCompatCreateSessionConfigurationCompat, this.mConfiguredDeferrableSurfaces);
                        } catch (CameraAccessException e) {
                            return Futures.immediateFailedFuture(e);
                        }
                    }
                    if (i != 5) {
                        return Futures.immediateFailedFuture(new CancellationException("openCaptureSession() not execute in state: " + this.mState));
                    }
                }
                return Futures.immediateFailedFuture(new IllegalStateException("openCaptureSession() should not be possible in state: " + this.mState));
            } catch (Throwable th) {
                throw th;
            }
        }
    }

    private List<OutputConfigurationCompat> getUniqueOutputConfigurations(List<OutputConfigurationCompat> list) {
        ArrayList arrayList = new ArrayList();
        ArrayList arrayList2 = new ArrayList();
        for (OutputConfigurationCompat outputConfigurationCompat : list) {
            if (!arrayList.contains(outputConfigurationCompat.getSurface())) {
                arrayList.add(outputConfigurationCompat.getSurface());
                arrayList2.add(outputConfigurationCompat);
            }
        }
        return arrayList2;
    }

    private OutputConfigurationCompat getOutputConfigurationCompat(SessionConfig.OutputConfig outputConfig, Map<DeferrableSurface, Surface> map, String str) {
        long jLongValue;
        DynamicRangeProfiles dynamicRangeProfiles;
        Surface surface = map.get(outputConfig.getSurface());
        Preconditions.checkNotNull(surface, "Surface in OutputConfig not found in configuredSurfaceMap.");
        OutputConfigurationCompat outputConfigurationCompat = new OutputConfigurationCompat(outputConfig.getSurfaceGroupId(), surface);
        if (str != null) {
            outputConfigurationCompat.setPhysicalCameraId(str);
        } else {
            outputConfigurationCompat.setPhysicalCameraId(outputConfig.getPhysicalCameraId());
        }
        if (!outputConfig.getSharedSurfaces().isEmpty()) {
            outputConfigurationCompat.enableSurfaceSharing();
            Iterator<DeferrableSurface> it = outputConfig.getSharedSurfaces().iterator();
            while (it.hasNext()) {
                Surface surface2 = map.get(it.next());
                Preconditions.checkNotNull(surface2, "Surface in OutputConfig not found in configuredSurfaceMap.");
                outputConfigurationCompat.addSurface(surface2);
            }
        }
        if (Build.VERSION.SDK_INT < 33 || (dynamicRangeProfiles = this.mDynamicRangesCompat.toDynamicRangeProfiles()) == null) {
            jLongValue = 1;
        } else {
            DynamicRange dynamicRange = outputConfig.getDynamicRange();
            Long lDynamicRangeToFirstSupportedProfile = DynamicRangeConversions.dynamicRangeToFirstSupportedProfile(dynamicRange, dynamicRangeProfiles);
            if (lDynamicRangeToFirstSupportedProfile == null) {
                Logger.e("CaptureSession", "Requested dynamic range is not supported. Defaulting to STANDARD dynamic range profile.\nRequested dynamic range:\n  " + dynamicRange);
                jLongValue = 1;
            } else {
                jLongValue = lDynamicRangeToFirstSupportedProfile.longValue();
            }
        }
        outputConfigurationCompat.setDynamicRangeProfile(jLongValue);
        return outputConfigurationCompat;
    }

    @Override // androidx.camera.camera2.internal.CaptureSessionInterface
    public void close() {
        synchronized (this.mSessionLock) {
            int i = AnonymousClass4.$SwitchMap$androidx$camera$camera2$internal$CaptureSession$State[this.mState.ordinal()];
            if (i == 1) {
                throw new IllegalStateException("close() should not be possible in state: " + this.mState);
            }
            if (i == 2) {
                this.mState = State.RELEASED;
            } else if (i == 3) {
                Preconditions.checkNotNull(this.mSynchronizedCaptureSessionOpener, "The Opener shouldn't null in state:" + this.mState);
                this.mSynchronizedCaptureSessionOpener.stop();
                this.mState = State.RELEASED;
            } else if (i == 4) {
                Preconditions.checkNotNull(this.mSynchronizedCaptureSessionOpener, "The Opener shouldn't null in state:" + this.mState);
                this.mSynchronizedCaptureSessionOpener.stop();
                this.mState = State.CLOSED;
                this.mSessionConfig = null;
            } else if (i == 5) {
                if (this.mSessionConfig != null) {
                    List<CaptureConfig> listOnDisableSession = this.mCameraEventCallbacks.createComboCallback().onDisableSession();
                    if (!listOnDisableSession.isEmpty()) {
                        try {
                            issueCaptureRequests(setupConfiguredSurface(listOnDisableSession));
                        } catch (IllegalStateException e) {
                            Logger.e("CaptureSession", "Unable to issue the request before close the capture session", e);
                        }
                    }
                }
                Preconditions.checkNotNull(this.mSynchronizedCaptureSessionOpener, "The Opener shouldn't null in state:" + this.mState);
                this.mSynchronizedCaptureSessionOpener.stop();
                this.mState = State.CLOSED;
                this.mSessionConfig = null;
            }
        }
    }

    /* JADX WARN: Can't fix incorrect switch cases order, some code will duplicate */
    /* JADX WARN: Removed duplicated region for block: B:19:0x0059 A[Catch: all -> 0x001c, TryCatch #1 {, blocks: (B:4:0x0003, B:5:0x000d, B:28:0x0091, B:7:0x0012, B:10:0x0018, B:16:0x0027, B:15:0x0020, B:17:0x002c, B:19:0x0059, B:20:0x005d, B:22:0x0061, B:23:0x006c, B:24:0x006e, B:26:0x0070, B:27:0x008d, B:31:0x0098, B:32:0x00b1), top: B:37:0x0003, inners: #0 }] */
    /* JADX WARN: Removed duplicated region for block: B:22:0x0061 A[Catch: all -> 0x001c, TryCatch #1 {, blocks: (B:4:0x0003, B:5:0x000d, B:28:0x0091, B:7:0x0012, B:10:0x0018, B:16:0x0027, B:15:0x0020, B:17:0x002c, B:19:0x0059, B:20:0x005d, B:22:0x0061, B:23:0x006c, B:24:0x006e, B:26:0x0070, B:27:0x008d, B:31:0x0098, B:32:0x00b1), top: B:37:0x0003, inners: #0 }] */
    @Override // androidx.camera.camera2.internal.CaptureSessionInterface
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    public com.google.common.util.concurrent.ListenableFuture<java.lang.Void> release(boolean r4) {
        /*
            r3 = this;
            java.lang.Object r0 = r3.mSessionLock
            monitor-enter(r0)
            int[] r1 = androidx.camera.camera2.internal.CaptureSession.AnonymousClass4.$SwitchMap$androidx$camera$camera2$internal$CaptureSession$State     // Catch: java.lang.Throwable -> L1c
            androidx.camera.camera2.internal.CaptureSession$State r2 = r3.mState     // Catch: java.lang.Throwable -> L1c
            int r2 = r2.ordinal()     // Catch: java.lang.Throwable -> L1c
            r1 = r1[r2]     // Catch: java.lang.Throwable -> L1c
            switch(r1) {
                case 1: goto L98;
                case 2: goto L8d;
                case 3: goto L70;
                case 4: goto L2c;
                case 5: goto L12;
                case 6: goto L12;
                case 7: goto L5d;
                default: goto L10;
            }     // Catch: java.lang.Throwable -> L1c
        L10:
            goto L91
        L12:
            androidx.camera.camera2.internal.SynchronizedCaptureSession r1 = r3.mSynchronizedCaptureSession     // Catch: java.lang.Throwable -> L1c
            if (r1 == 0) goto L2c
            if (r4 == 0) goto L27
            r1.abortCaptures()     // Catch: java.lang.Throwable -> L1c android.hardware.camera2.CameraAccessException -> L1f
            goto L27
        L1c:
            r4 = move-exception
            goto Lb2
        L1f:
            r4 = move-exception
            java.lang.String r1 = "CaptureSession"
            java.lang.String r2 = "Unable to abort captures."
            androidx.camera.core.Logger.e(r1, r2, r4)     // Catch: java.lang.Throwable -> L1c
        L27:
            androidx.camera.camera2.internal.SynchronizedCaptureSession r4 = r3.mSynchronizedCaptureSession     // Catch: java.lang.Throwable -> L1c
            r4.close()     // Catch: java.lang.Throwable -> L1c
        L2c:
            androidx.camera.camera2.impl.CameraEventCallbacks r4 = r3.mCameraEventCallbacks     // Catch: java.lang.Throwable -> L1c
            androidx.camera.camera2.impl.CameraEventCallbacks$ComboCameraEventCallback r4 = r4.createComboCallback()     // Catch: java.lang.Throwable -> L1c
            r4.onDeInitSession()     // Catch: java.lang.Throwable -> L1c
            androidx.camera.camera2.internal.CaptureSession$State r4 = androidx.camera.camera2.internal.CaptureSession.State.RELEASING     // Catch: java.lang.Throwable -> L1c
            r3.mState = r4     // Catch: java.lang.Throwable -> L1c
            androidx.camera.camera2.internal.SynchronizedCaptureSessionOpener r4 = r3.mSynchronizedCaptureSessionOpener     // Catch: java.lang.Throwable -> L1c
            java.lang.StringBuilder r1 = new java.lang.StringBuilder     // Catch: java.lang.Throwable -> L1c
            r1.<init>()     // Catch: java.lang.Throwable -> L1c
            java.lang.String r2 = "The Opener shouldn't null in state:"
            r1.append(r2)     // Catch: java.lang.Throwable -> L1c
            androidx.camera.camera2.internal.CaptureSession$State r2 = r3.mState     // Catch: java.lang.Throwable -> L1c
            r1.append(r2)     // Catch: java.lang.Throwable -> L1c
            java.lang.String r1 = r1.toString()     // Catch: java.lang.Throwable -> L1c
            androidx.core.util.Preconditions.checkNotNull(r4, r1)     // Catch: java.lang.Throwable -> L1c
            androidx.camera.camera2.internal.SynchronizedCaptureSessionOpener r4 = r3.mSynchronizedCaptureSessionOpener     // Catch: java.lang.Throwable -> L1c
            boolean r4 = r4.stop()     // Catch: java.lang.Throwable -> L1c
            if (r4 == 0) goto L5d
            r3.finishClose()     // Catch: java.lang.Throwable -> L1c
            goto L91
        L5d:
            com.google.common.util.concurrent.ListenableFuture<java.lang.Void> r4 = r3.mReleaseFuture     // Catch: java.lang.Throwable -> L1c
            if (r4 != 0) goto L6c
            androidx.camera.camera2.internal.CaptureSession$$ExternalSyntheticLambda1 r4 = new androidx.camera.camera2.internal.CaptureSession$$ExternalSyntheticLambda1     // Catch: java.lang.Throwable -> L1c
            r4.<init>()     // Catch: java.lang.Throwable -> L1c
            com.google.common.util.concurrent.ListenableFuture r4 = androidx.concurrent.futures.CallbackToFutureAdapter.getFuture(r4)     // Catch: java.lang.Throwable -> L1c
            r3.mReleaseFuture = r4     // Catch: java.lang.Throwable -> L1c
        L6c:
            com.google.common.util.concurrent.ListenableFuture<java.lang.Void> r4 = r3.mReleaseFuture     // Catch: java.lang.Throwable -> L1c
            monitor-exit(r0)     // Catch: java.lang.Throwable -> L1c
            return r4
        L70:
            androidx.camera.camera2.internal.SynchronizedCaptureSessionOpener r4 = r3.mSynchronizedCaptureSessionOpener     // Catch: java.lang.Throwable -> L1c
            java.lang.StringBuilder r1 = new java.lang.StringBuilder     // Catch: java.lang.Throwable -> L1c
            r1.<init>()     // Catch: java.lang.Throwable -> L1c
            java.lang.String r2 = "The Opener shouldn't null in state:"
            r1.append(r2)     // Catch: java.lang.Throwable -> L1c
            androidx.camera.camera2.internal.CaptureSession$State r2 = r3.mState     // Catch: java.lang.Throwable -> L1c
            r1.append(r2)     // Catch: java.lang.Throwable -> L1c
            java.lang.String r1 = r1.toString()     // Catch: java.lang.Throwable -> L1c
            androidx.core.util.Preconditions.checkNotNull(r4, r1)     // Catch: java.lang.Throwable -> L1c
            androidx.camera.camera2.internal.SynchronizedCaptureSessionOpener r4 = r3.mSynchronizedCaptureSessionOpener     // Catch: java.lang.Throwable -> L1c
            r4.stop()     // Catch: java.lang.Throwable -> L1c
        L8d:
            androidx.camera.camera2.internal.CaptureSession$State r4 = androidx.camera.camera2.internal.CaptureSession.State.RELEASED     // Catch: java.lang.Throwable -> L1c
            r3.mState = r4     // Catch: java.lang.Throwable -> L1c
        L91:
            monitor-exit(r0)     // Catch: java.lang.Throwable -> L1c
            r4 = 0
            com.google.common.util.concurrent.ListenableFuture r4 = androidx.camera.core.impl.utils.futures.Futures.immediateFuture(r4)
            return r4
        L98:
            java.lang.IllegalStateException r4 = new java.lang.IllegalStateException     // Catch: java.lang.Throwable -> L1c
            java.lang.StringBuilder r1 = new java.lang.StringBuilder     // Catch: java.lang.Throwable -> L1c
            r1.<init>()     // Catch: java.lang.Throwable -> L1c
            java.lang.String r2 = "release() should not be possible in state: "
            r1.append(r2)     // Catch: java.lang.Throwable -> L1c
            androidx.camera.camera2.internal.CaptureSession$State r2 = r3.mState     // Catch: java.lang.Throwable -> L1c
            r1.append(r2)     // Catch: java.lang.Throwable -> L1c
            java.lang.String r1 = r1.toString()     // Catch: java.lang.Throwable -> L1c
            r4.<init>(r1)     // Catch: java.lang.Throwable -> L1c
            throw r4     // Catch: java.lang.Throwable -> L1c
        Lb2:
            monitor-exit(r0)     // Catch: java.lang.Throwable -> L1c
            throw r4
        */
        throw new UnsupportedOperationException("Method not decompiled: androidx.camera.camera2.internal.CaptureSession.release(boolean):com.google.common.util.concurrent.ListenableFuture");
    }

    /* JADX INFO: Access modifiers changed from: private */
    public /* synthetic */ Object lambda$release$1(CallbackToFutureAdapter.Completer completer) throws Exception {
        String str;
        synchronized (this.mSessionLock) {
            Preconditions.checkState(this.mReleaseCompleter == null, "Release completer expected to be null");
            this.mReleaseCompleter = completer;
            str = "Release[session=" + this + "]";
        }
        return str;
    }

    @Override // androidx.camera.camera2.internal.CaptureSessionInterface
    public void issueCaptureRequests(List<CaptureConfig> list) {
        synchronized (this.mSessionLock) {
            try {
                switch (AnonymousClass4.$SwitchMap$androidx$camera$camera2$internal$CaptureSession$State[this.mState.ordinal()]) {
                    case 1:
                        throw new IllegalStateException("issueCaptureRequests() should not be possible in state: " + this.mState);
                    case 2:
                    case 3:
                    case 4:
                        this.mCaptureConfigs.addAll(list);
                        break;
                    case 5:
                        this.mCaptureConfigs.addAll(list);
                        issuePendingCaptureRequest();
                        break;
                    case 6:
                    case 7:
                    case 8:
                        throw new IllegalStateException("Cannot issue capture request on a closed/released session.");
                }
            } finally {
            }
        }
    }

    @Override // androidx.camera.camera2.internal.CaptureSessionInterface
    public List<CaptureConfig> getCaptureConfigs() {
        List<CaptureConfig> listUnmodifiableList;
        synchronized (this.mSessionLock) {
            listUnmodifiableList = Collections.unmodifiableList(this.mCaptureConfigs);
        }
        return listUnmodifiableList;
    }

    void finishClose() {
        State state = this.mState;
        State state2 = State.RELEASED;
        if (state == state2) {
            Logger.d("CaptureSession", "Skipping finishClose due to being state RELEASED.");
            return;
        }
        this.mState = state2;
        this.mSynchronizedCaptureSession = null;
        CallbackToFutureAdapter.Completer<Void> completer = this.mReleaseCompleter;
        if (completer != null) {
            completer.set(null);
            this.mReleaseCompleter = null;
        }
    }

    int issueRepeatingCaptureRequests(SessionConfig sessionConfig) {
        synchronized (this.mSessionLock) {
            try {
            } catch (Throwable th) {
                throw th;
            }
            if (sessionConfig == null) {
                Logger.d("CaptureSession", "Skipping issueRepeatingCaptureRequests for no configuration case.");
                return -1;
            }
            if (this.mState != State.OPENED) {
                Logger.d("CaptureSession", "Skipping issueRepeatingCaptureRequests due to session closed");
                return -1;
            }
            CaptureConfig repeatingCaptureConfig = sessionConfig.getRepeatingCaptureConfig();
            if (repeatingCaptureConfig.getSurfaces().isEmpty()) {
                Logger.d("CaptureSession", "Skipping issueRepeatingCaptureRequests for no surface.");
                try {
                    this.mSynchronizedCaptureSession.stopRepeating();
                } catch (CameraAccessException e) {
                    Logger.e("CaptureSession", "Unable to access camera: " + e.getMessage());
                    Thread.dumpStack();
                }
                return -1;
            }
            try {
                Logger.d("CaptureSession", "Issuing request for session.");
                CaptureConfig.Builder builderFrom = CaptureConfig.Builder.from(repeatingCaptureConfig);
                Config configMergeOptions = mergeOptions(this.mCameraEventCallbacks.createComboCallback().onRepeating());
                this.mCameraEventOnRepeatingOptions = configMergeOptions;
                builderFrom.addImplementationOptions(configMergeOptions);
                CaptureRequest captureRequestBuild = Camera2CaptureRequestBuilder.build(builderFrom.build(), this.mSynchronizedCaptureSession.getDevice(), this.mConfiguredSurfaceMap);
                if (captureRequestBuild == null) {
                    Logger.d("CaptureSession", "Skipping issuing empty request for session.");
                    return -1;
                }
                return this.mSynchronizedCaptureSession.setSingleRepeatingRequest(captureRequestBuild, createCamera2CaptureCallback(repeatingCaptureConfig.getCameraCaptureCallbacks(), this.mCaptureCallback));
            } catch (CameraAccessException e2) {
                Logger.e("CaptureSession", "Unable to access camera: " + e2.getMessage());
                Thread.dumpStack();
                return -1;
            }
            throw th;
        }
    }

    void issuePendingCaptureRequest() {
        if (this.mCaptureConfigs.isEmpty()) {
            return;
        }
        try {
            issueBurstCaptureRequest(this.mCaptureConfigs);
        } finally {
            this.mCaptureConfigs.clear();
        }
    }

    int issueBurstCaptureRequest(List<CaptureConfig> list) {
        CameraBurstCaptureCallback cameraBurstCaptureCallback;
        ArrayList arrayList;
        boolean z;
        synchronized (this.mSessionLock) {
            try {
                if (this.mState != State.OPENED) {
                    Logger.d("CaptureSession", "Skipping issueBurstCaptureRequest due to session closed");
                    return -1;
                }
                if (list.isEmpty()) {
                    return -1;
                }
                try {
                    cameraBurstCaptureCallback = new CameraBurstCaptureCallback();
                    arrayList = new ArrayList();
                    Logger.d("CaptureSession", "Issuing capture request.");
                    z = false;
                    for (CaptureConfig captureConfig : list) {
                        if (captureConfig.getSurfaces().isEmpty()) {
                            Logger.d("CaptureSession", "Skipping issuing empty capture request.");
                        } else {
                            Iterator<DeferrableSurface> it = captureConfig.getSurfaces().iterator();
                            while (true) {
                                if (it.hasNext()) {
                                    DeferrableSurface next = it.next();
                                    if (!this.mConfiguredSurfaceMap.containsKey(next)) {
                                        Logger.d("CaptureSession", "Skipping capture request with invalid surface: " + next);
                                        break;
                                    }
                                } else {
                                    if (captureConfig.getTemplateType() == 2) {
                                        z = true;
                                    }
                                    CaptureConfig.Builder builderFrom = CaptureConfig.Builder.from(captureConfig);
                                    if (captureConfig.getTemplateType() == 5 && captureConfig.getCameraCaptureResult() != null) {
                                        builderFrom.setCameraCaptureResult(captureConfig.getCameraCaptureResult());
                                    }
                                    SessionConfig sessionConfig = this.mSessionConfig;
                                    if (sessionConfig != null) {
                                        builderFrom.addImplementationOptions(sessionConfig.getRepeatingCaptureConfig().getImplementationOptions());
                                    }
                                    builderFrom.addImplementationOptions(this.mCameraEventOnRepeatingOptions);
                                    builderFrom.addImplementationOptions(captureConfig.getImplementationOptions());
                                    CaptureRequest captureRequestBuild = Camera2CaptureRequestBuilder.build(builderFrom.build(), this.mSynchronizedCaptureSession.getDevice(), this.mConfiguredSurfaceMap);
                                    if (captureRequestBuild == null) {
                                        Logger.d("CaptureSession", "Skipping issuing request without surface.");
                                        return -1;
                                    }
                                    ArrayList arrayList2 = new ArrayList();
                                    Iterator<CameraCaptureCallback> it2 = captureConfig.getCameraCaptureCallbacks().iterator();
                                    while (it2.hasNext()) {
                                        CaptureCallbackConverter.toCaptureCallback(it2.next(), arrayList2);
                                    }
                                    cameraBurstCaptureCallback.addCamera2Callbacks(captureRequestBuild, arrayList2);
                                    arrayList.add(captureRequestBuild);
                                }
                            }
                        }
                    }
                } catch (CameraAccessException e) {
                    Logger.e("CaptureSession", "Unable to access camera: " + e.getMessage());
                    Thread.dumpStack();
                }
                if (!arrayList.isEmpty()) {
                    if (this.mStillCaptureFlow.shouldStopRepeatingBeforeCapture(arrayList, z)) {
                        this.mSynchronizedCaptureSession.stopRepeating();
                        cameraBurstCaptureCallback.setCaptureSequenceCallback(new CameraBurstCaptureCallback.CaptureSequenceCallback() { // from class: androidx.camera.camera2.internal.CaptureSession$$ExternalSyntheticLambda0
                            @Override // androidx.camera.camera2.internal.CameraBurstCaptureCallback.CaptureSequenceCallback
                            public final void onCaptureSequenceCompletedOrAborted(CameraCaptureSession cameraCaptureSession, int i, boolean z2) {
                                this.f$0.lambda$issueBurstCaptureRequest$2(cameraCaptureSession, i, z2);
                            }
                        });
                    }
                    if (this.mTorchStateReset.isTorchResetRequired(arrayList, z)) {
                        cameraBurstCaptureCallback.addCamera2Callbacks((CaptureRequest) arrayList.get(arrayList.size() - 1), Collections.singletonList(new CameraCaptureSession.CaptureCallback() { // from class: androidx.camera.camera2.internal.CaptureSession.3
                            @Override // android.hardware.camera2.CameraCaptureSession.CaptureCallback
                            public void onCaptureCompleted(CameraCaptureSession cameraCaptureSession, CaptureRequest captureRequest, TotalCaptureResult totalCaptureResult) {
                                synchronized (CaptureSession.this.mSessionLock) {
                                    try {
                                        SessionConfig sessionConfig2 = CaptureSession.this.mSessionConfig;
                                        if (sessionConfig2 == null) {
                                            return;
                                        }
                                        CaptureConfig repeatingCaptureConfig = sessionConfig2.getRepeatingCaptureConfig();
                                        Logger.d("CaptureSession", "Submit FLASH_MODE_OFF request");
                                        CaptureSession captureSession = CaptureSession.this;
                                        captureSession.issueCaptureRequests(Collections.singletonList(captureSession.mTorchStateReset.createTorchResetRequest(repeatingCaptureConfig)));
                                    } catch (Throwable th) {
                                        throw th;
                                    }
                                }
                            }
                        }));
                    }
                    return this.mSynchronizedCaptureSession.captureBurstRequests(arrayList, cameraBurstCaptureCallback);
                }
                Logger.d("CaptureSession", "Skipping issuing burst request due to no valid request elements");
                return -1;
            } catch (Throwable th) {
                throw th;
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public /* synthetic */ void lambda$issueBurstCaptureRequest$2(CameraCaptureSession cameraCaptureSession, int i, boolean z) {
        synchronized (this.mSessionLock) {
            try {
                if (this.mState == State.OPENED) {
                    issueRepeatingCaptureRequests(this.mSessionConfig);
                }
            } catch (Throwable th) {
                throw th;
            }
        }
    }

    @Override // androidx.camera.camera2.internal.CaptureSessionInterface
    public void cancelIssuedCaptureRequests() {
        ArrayList arrayList;
        synchronized (this.mSessionLock) {
            try {
                if (this.mCaptureConfigs.isEmpty()) {
                    arrayList = null;
                } else {
                    arrayList = new ArrayList(this.mCaptureConfigs);
                    this.mCaptureConfigs.clear();
                }
            } catch (Throwable th) {
                throw th;
            }
        }
        if (arrayList != null) {
            Iterator it = arrayList.iterator();
            while (it.hasNext()) {
                Iterator<CameraCaptureCallback> it2 = ((CaptureConfig) it.next()).getCameraCaptureCallbacks().iterator();
                while (it2.hasNext()) {
                    it2.next().onCaptureCancelled();
                }
            }
        }
    }

    private CameraCaptureSession.CaptureCallback createCamera2CaptureCallback(List<CameraCaptureCallback> list, CameraCaptureSession.CaptureCallback... captureCallbackArr) {
        ArrayList arrayList = new ArrayList(list.size() + captureCallbackArr.length);
        Iterator<CameraCaptureCallback> it = list.iterator();
        while (it.hasNext()) {
            arrayList.add(CaptureCallbackConverter.toCaptureCallback(it.next()));
        }
        Collections.addAll(arrayList, captureCallbackArr);
        return Camera2CaptureCallbacks.createComboCallback(arrayList);
    }

    private static Config mergeOptions(List<CaptureConfig> list) {
        MutableOptionsBundle mutableOptionsBundleCreate = MutableOptionsBundle.create();
        Iterator<CaptureConfig> it = list.iterator();
        while (it.hasNext()) {
            Config implementationOptions = it.next().getImplementationOptions();
            for (Config.Option<?> option : implementationOptions.listOptions()) {
                Object objRetrieveOption = implementationOptions.retrieveOption(option, null);
                if (mutableOptionsBundleCreate.containsOption(option)) {
                    Object objRetrieveOption2 = mutableOptionsBundleCreate.retrieveOption(option, null);
                    if (!Objects.equals(objRetrieveOption2, objRetrieveOption)) {
                        Logger.d("CaptureSession", "Detect conflicting option " + option.getId() + " : " + objRetrieveOption + " != " + objRetrieveOption2);
                    }
                } else {
                    mutableOptionsBundleCreate.insertOption(option, objRetrieveOption);
                }
            }
        }
        return mutableOptionsBundleCreate;
    }

    final class StateCallback extends SynchronizedCaptureSession.StateCallback {
        StateCallback() {
        }

        @Override // androidx.camera.camera2.internal.SynchronizedCaptureSession.StateCallback
        public void onConfigured(SynchronizedCaptureSession synchronizedCaptureSession) {
            synchronized (CaptureSession.this.mSessionLock) {
                try {
                    switch (AnonymousClass4.$SwitchMap$androidx$camera$camera2$internal$CaptureSession$State[CaptureSession.this.mState.ordinal()]) {
                        case 1:
                        case 2:
                        case 3:
                        case 5:
                        case 8:
                            throw new IllegalStateException("onConfigured() should not be possible in state: " + CaptureSession.this.mState);
                        case 4:
                            CaptureSession captureSession = CaptureSession.this;
                            captureSession.mState = State.OPENED;
                            captureSession.mSynchronizedCaptureSession = synchronizedCaptureSession;
                            if (captureSession.mSessionConfig != null) {
                                List<CaptureConfig> listOnEnableSession = captureSession.mCameraEventCallbacks.createComboCallback().onEnableSession();
                                if (!listOnEnableSession.isEmpty()) {
                                    CaptureSession captureSession2 = CaptureSession.this;
                                    captureSession2.issueBurstCaptureRequest(captureSession2.setupConfiguredSurface(listOnEnableSession));
                                }
                            }
                            Logger.d("CaptureSession", "Attempting to send capture request onConfigured");
                            CaptureSession captureSession3 = CaptureSession.this;
                            captureSession3.issueRepeatingCaptureRequests(captureSession3.mSessionConfig);
                            CaptureSession.this.issuePendingCaptureRequest();
                            break;
                        case 6:
                            CaptureSession.this.mSynchronizedCaptureSession = synchronizedCaptureSession;
                            break;
                        case 7:
                            synchronizedCaptureSession.close();
                            break;
                    }
                    Logger.d("CaptureSession", "CameraCaptureSession.onConfigured() mState=" + CaptureSession.this.mState);
                } catch (Throwable th) {
                    throw th;
                }
            }
        }

        @Override // androidx.camera.camera2.internal.SynchronizedCaptureSession.StateCallback
        public void onReady(SynchronizedCaptureSession synchronizedCaptureSession) {
            synchronized (CaptureSession.this.mSessionLock) {
                try {
                    if (AnonymousClass4.$SwitchMap$androidx$camera$camera2$internal$CaptureSession$State[CaptureSession.this.mState.ordinal()] == 1) {
                        throw new IllegalStateException("onReady() should not be possible in state: " + CaptureSession.this.mState);
                    }
                    Logger.d("CaptureSession", "CameraCaptureSession.onReady() " + CaptureSession.this.mState);
                } catch (Throwable th) {
                    throw th;
                }
            }
        }

        @Override // androidx.camera.camera2.internal.SynchronizedCaptureSession.StateCallback
        public void onSessionFinished(SynchronizedCaptureSession synchronizedCaptureSession) {
            synchronized (CaptureSession.this.mSessionLock) {
                try {
                    if (CaptureSession.this.mState == State.UNINITIALIZED) {
                        throw new IllegalStateException("onSessionFinished() should not be possible in state: " + CaptureSession.this.mState);
                    }
                    Logger.d("CaptureSession", "onSessionFinished()");
                    CaptureSession.this.finishClose();
                } catch (Throwable th) {
                    throw th;
                }
            }
        }

        @Override // androidx.camera.camera2.internal.SynchronizedCaptureSession.StateCallback
        public void onConfigureFailed(SynchronizedCaptureSession synchronizedCaptureSession) {
            synchronized (CaptureSession.this.mSessionLock) {
                try {
                    switch (AnonymousClass4.$SwitchMap$androidx$camera$camera2$internal$CaptureSession$State[CaptureSession.this.mState.ordinal()]) {
                        case 1:
                        case 2:
                        case 3:
                        case 5:
                            throw new IllegalStateException("onConfigureFailed() should not be possible in state: " + CaptureSession.this.mState);
                        case 4:
                        case 6:
                        case 7:
                            CaptureSession.this.finishClose();
                            break;
                        case 8:
                            Logger.d("CaptureSession", "ConfigureFailed callback after change to RELEASED state");
                            break;
                    }
                    Logger.e("CaptureSession", "CameraCaptureSession.onConfigureFailed() " + CaptureSession.this.mState);
                } catch (Throwable th) {
                    throw th;
                }
            }
        }
    }

    List<CaptureConfig> setupConfiguredSurface(List<CaptureConfig> list) {
        ArrayList arrayList = new ArrayList();
        Iterator<CaptureConfig> it = list.iterator();
        while (it.hasNext()) {
            CaptureConfig.Builder builderFrom = CaptureConfig.Builder.from(it.next());
            builderFrom.setTemplateType(1);
            Iterator<DeferrableSurface> it2 = this.mSessionConfig.getRepeatingCaptureConfig().getSurfaces().iterator();
            while (it2.hasNext()) {
                builderFrom.addSurface(it2.next());
            }
            arrayList.add(builderFrom.build());
        }
        return arrayList;
    }
}

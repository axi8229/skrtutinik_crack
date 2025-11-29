package androidx.camera.lifecycle;

import android.content.Context;
import androidx.arch.core.util.Function;
import androidx.camera.core.Camera;
import androidx.camera.core.CameraEffect;
import androidx.camera.core.CameraFilter;
import androidx.camera.core.CameraSelector;
import androidx.camera.core.CameraX;
import androidx.camera.core.CameraXConfig;
import androidx.camera.core.UseCase;
import androidx.camera.core.ViewPort;
import androidx.camera.core.impl.CameraConfig;
import androidx.camera.core.impl.CameraInternal;
import androidx.camera.core.impl.ExtendedCameraConfigProviderStore;
import androidx.camera.core.impl.utils.ContextUtil;
import androidx.camera.core.impl.utils.Threads;
import androidx.camera.core.impl.utils.executor.CameraXExecutors;
import androidx.camera.core.impl.utils.futures.AsyncFunction;
import androidx.camera.core.impl.utils.futures.FutureCallback;
import androidx.camera.core.impl.utils.futures.FutureChain;
import androidx.camera.core.impl.utils.futures.Futures;
import androidx.camera.core.internal.CameraUseCaseAdapter;
import androidx.concurrent.futures.CallbackToFutureAdapter;
import androidx.core.util.Preconditions;
import androidx.lifecycle.LifecycleOwner;
import com.google.common.util.concurrent.ListenableFuture;
import java.util.Arrays;
import java.util.Collection;
import java.util.Collections;
import java.util.Iterator;
import java.util.LinkedHashSet;
import java.util.List;

/* loaded from: classes.dex */
public final class ProcessCameraProvider {
    private static final ProcessCameraProvider sAppInstance = new ProcessCameraProvider();
    private CameraX mCameraX;
    private ListenableFuture<CameraX> mCameraXInitializeFuture;
    private Context mContext;
    private final Object mLock = new Object();
    private CameraXConfig.Provider mCameraXConfigProvider = null;
    private ListenableFuture<Void> mCameraXShutdownFuture = Futures.immediateFuture(null);
    private final LifecycleCameraRepository mLifecycleCameraRepository = new LifecycleCameraRepository();

    public static ListenableFuture<ProcessCameraProvider> getInstance(final Context context) {
        Preconditions.checkNotNull(context);
        return Futures.transform(sAppInstance.getOrCreateCameraXInstance(context), new Function() { // from class: androidx.camera.lifecycle.ProcessCameraProvider$$ExternalSyntheticLambda0
            @Override // androidx.arch.core.util.Function
            public final Object apply(Object obj) {
                return ProcessCameraProvider.lambda$getInstance$0(context, (CameraX) obj);
            }
        }, CameraXExecutors.directExecutor());
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static /* synthetic */ ProcessCameraProvider lambda$getInstance$0(Context context, CameraX cameraX) {
        ProcessCameraProvider processCameraProvider = sAppInstance;
        processCameraProvider.setCameraX(cameraX);
        processCameraProvider.setContext(ContextUtil.getApplicationContext(context));
        return processCameraProvider;
    }

    private ListenableFuture<CameraX> getOrCreateCameraXInstance(Context context) {
        synchronized (this.mLock) {
            try {
                ListenableFuture<CameraX> listenableFuture = this.mCameraXInitializeFuture;
                if (listenableFuture != null) {
                    return listenableFuture;
                }
                final CameraX cameraX = new CameraX(context, this.mCameraXConfigProvider);
                ListenableFuture<CameraX> future = CallbackToFutureAdapter.getFuture(new CallbackToFutureAdapter.Resolver() { // from class: androidx.camera.lifecycle.ProcessCameraProvider$$ExternalSyntheticLambda1
                    @Override // androidx.concurrent.futures.CallbackToFutureAdapter.Resolver
                    public final Object attachCompleter(CallbackToFutureAdapter.Completer completer) {
                        return this.f$0.lambda$getOrCreateCameraXInstance$2(cameraX, completer);
                    }
                });
                this.mCameraXInitializeFuture = future;
                return future;
            } catch (Throwable th) {
                throw th;
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public /* synthetic */ Object lambda$getOrCreateCameraXInstance$2(final CameraX cameraX, final CallbackToFutureAdapter.Completer completer) throws Exception {
        synchronized (this.mLock) {
            Futures.addCallback(FutureChain.from(this.mCameraXShutdownFuture).transformAsync(new AsyncFunction() { // from class: androidx.camera.lifecycle.ProcessCameraProvider$$ExternalSyntheticLambda2
                @Override // androidx.camera.core.impl.utils.futures.AsyncFunction
                public final ListenableFuture apply(Object obj) {
                    return ProcessCameraProvider.lambda$getOrCreateCameraXInstance$1(cameraX, (Void) obj);
                }
            }, CameraXExecutors.directExecutor()), new FutureCallback<Void>() { // from class: androidx.camera.lifecycle.ProcessCameraProvider.1
                @Override // androidx.camera.core.impl.utils.futures.FutureCallback
                public void onSuccess(Void r2) {
                    completer.set(cameraX);
                }

                @Override // androidx.camera.core.impl.utils.futures.FutureCallback
                public void onFailure(Throwable th) {
                    completer.setException(th);
                }
            }, CameraXExecutors.directExecutor());
        }
        return "ProcessCameraProvider-initializeCameraX";
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static /* synthetic */ ListenableFuture lambda$getOrCreateCameraXInstance$1(CameraX cameraX, Void r1) throws Exception {
        return cameraX.getInitializeFuture();
    }

    private void setCameraX(CameraX cameraX) {
        this.mCameraX = cameraX;
    }

    private void setContext(Context context) {
        this.mContext = context;
    }

    public Camera bindToLifecycle(LifecycleOwner lifecycleOwner, CameraSelector cameraSelector, UseCase... useCaseArr) {
        if (getCameraOperatingMode() == 2) {
            throw new UnsupportedOperationException("bindToLifecycle for single camera is not supported in concurrent camera mode, call unbindAll() first");
        }
        setCameraOperatingMode(1);
        return bindToLifecycle(lifecycleOwner, cameraSelector, null, Collections.emptyList(), useCaseArr);
    }

    Camera bindToLifecycle(LifecycleOwner lifecycleOwner, CameraSelector cameraSelector, ViewPort viewPort, List<CameraEffect> list, UseCase... useCaseArr) {
        CameraConfig cameraConfig;
        CameraConfig config;
        Threads.checkMainThread();
        CameraSelector.Builder builderFromSelector = CameraSelector.Builder.fromSelector(cameraSelector);
        int length = useCaseArr.length;
        int i = 0;
        while (true) {
            cameraConfig = null;
            if (i >= length) {
                break;
            }
            CameraSelector cameraSelector2 = useCaseArr[i].getCurrentConfig().getCameraSelector(null);
            if (cameraSelector2 != null) {
                Iterator<CameraFilter> it = cameraSelector2.getCameraFilterSet().iterator();
                while (it.hasNext()) {
                    builderFromSelector.addCameraFilter(it.next());
                }
            }
            i++;
        }
        LinkedHashSet<CameraInternal> linkedHashSetFilter = builderFromSelector.build().filter(this.mCameraX.getCameraRepository().getCameras());
        if (linkedHashSetFilter.isEmpty()) {
            throw new IllegalArgumentException("Provided camera selector unable to resolve a camera for the given use case");
        }
        LifecycleCamera lifecycleCamera = this.mLifecycleCameraRepository.getLifecycleCamera(lifecycleOwner, CameraUseCaseAdapter.generateCameraId(linkedHashSetFilter));
        Collection<LifecycleCamera> lifecycleCameras = this.mLifecycleCameraRepository.getLifecycleCameras();
        for (UseCase useCase : useCaseArr) {
            for (LifecycleCamera lifecycleCamera2 : lifecycleCameras) {
                if (lifecycleCamera2.isBound(useCase) && lifecycleCamera2 != lifecycleCamera) {
                    throw new IllegalStateException(String.format("Use case %s already bound to a different lifecycle.", useCase));
                }
            }
        }
        if (lifecycleCamera == null) {
            lifecycleCamera = this.mLifecycleCameraRepository.createLifecycleCamera(lifecycleOwner, new CameraUseCaseAdapter(linkedHashSetFilter, this.mCameraX.getCameraFactory().getCameraCoordinator(), this.mCameraX.getCameraDeviceSurfaceManager(), this.mCameraX.getDefaultConfigFactory()));
        }
        Iterator<CameraFilter> it2 = cameraSelector.getCameraFilterSet().iterator();
        while (it2.hasNext()) {
            CameraFilter next = it2.next();
            if (next.getIdentifier() != CameraFilter.DEFAULT_ID && (config = ExtendedCameraConfigProviderStore.getConfigProvider(next.getIdentifier()).getConfig(lifecycleCamera.getCameraInfo(), this.mContext)) != null) {
                if (cameraConfig != null) {
                    throw new IllegalArgumentException("Cannot apply multiple extended camera configs at the same time.");
                }
                cameraConfig = config;
            }
        }
        lifecycleCamera.setExtendedConfig(cameraConfig);
        if (useCaseArr.length == 0) {
            return lifecycleCamera;
        }
        this.mLifecycleCameraRepository.bindToLifecycleCamera(lifecycleCamera, viewPort, list, Arrays.asList(useCaseArr), this.mCameraX.getCameraFactory().getCameraCoordinator());
        return lifecycleCamera;
    }

    public void unbindAll() {
        Threads.checkMainThread();
        setCameraOperatingMode(0);
        this.mLifecycleCameraRepository.unbindAll();
    }

    private int getCameraOperatingMode() {
        CameraX cameraX = this.mCameraX;
        if (cameraX == null) {
            return 0;
        }
        return cameraX.getCameraFactory().getCameraCoordinator().getCameraOperatingMode();
    }

    private void setCameraOperatingMode(int i) {
        CameraX cameraX = this.mCameraX;
        if (cameraX == null) {
            return;
        }
        cameraX.getCameraFactory().getCameraCoordinator().setCameraOperatingMode(i);
    }

    private ProcessCameraProvider() {
    }
}

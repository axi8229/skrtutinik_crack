package androidx.camera.core.processing;

import androidx.camera.core.CameraEffect;
import androidx.camera.core.ProcessingException;
import androidx.camera.core.SurfaceOutput;
import androidx.camera.core.SurfaceProcessor;
import androidx.camera.core.SurfaceRequest;
import androidx.camera.core.impl.utils.futures.Futures;
import androidx.core.util.Consumer;
import com.google.common.util.concurrent.ListenableFuture;
import java.util.Objects;
import java.util.concurrent.Executor;

/* loaded from: classes.dex */
public class SurfaceProcessorWithExecutor implements SurfaceProcessorInternal {
    private final Consumer<Throwable> mErrorListener;
    private final Executor mExecutor;
    private final SurfaceProcessor mSurfaceProcessor;

    @Override // androidx.camera.core.processing.SurfaceProcessorInternal
    public void release() {
    }

    public SurfaceProcessorWithExecutor(CameraEffect cameraEffect) {
        SurfaceProcessor surfaceProcessor = cameraEffect.getSurfaceProcessor();
        Objects.requireNonNull(surfaceProcessor);
        this.mSurfaceProcessor = surfaceProcessor;
        this.mExecutor = cameraEffect.getExecutor();
        this.mErrorListener = cameraEffect.getErrorListener();
    }

    @Override // androidx.camera.core.SurfaceProcessor
    public void onInputSurface(final SurfaceRequest surfaceRequest) {
        this.mExecutor.execute(new Runnable() { // from class: androidx.camera.core.processing.SurfaceProcessorWithExecutor$$ExternalSyntheticLambda0
            @Override // java.lang.Runnable
            public final void run() throws ProcessingException {
                this.f$0.lambda$onInputSurface$0(surfaceRequest);
            }
        });
    }

    /* JADX INFO: Access modifiers changed from: private */
    public /* synthetic */ void lambda$onInputSurface$0(SurfaceRequest surfaceRequest) throws ProcessingException {
        this.mSurfaceProcessor.onInputSurface(surfaceRequest);
    }

    @Override // androidx.camera.core.SurfaceProcessor
    public void onOutputSurface(final SurfaceOutput surfaceOutput) {
        this.mExecutor.execute(new Runnable() { // from class: androidx.camera.core.processing.SurfaceProcessorWithExecutor$$ExternalSyntheticLambda1
            @Override // java.lang.Runnable
            public final void run() throws ProcessingException {
                this.f$0.lambda$onOutputSurface$1(surfaceOutput);
            }
        });
    }

    /* JADX INFO: Access modifiers changed from: private */
    public /* synthetic */ void lambda$onOutputSurface$1(SurfaceOutput surfaceOutput) throws ProcessingException {
        this.mSurfaceProcessor.onOutputSurface(surfaceOutput);
    }

    @Override // androidx.camera.core.processing.SurfaceProcessorInternal
    public ListenableFuture<Void> snapshot(int i, int i2) {
        return Futures.immediateFailedFuture(new Exception("Snapshot not supported by external SurfaceProcessor"));
    }
}

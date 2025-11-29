package androidx.camera.core;

import androidx.camera.core.processing.SurfaceProcessorInternal;
import androidx.camera.core.processing.SurfaceProcessorWithExecutor;
import androidx.core.util.Consumer;
import java.util.Arrays;
import java.util.List;
import java.util.concurrent.Executor;

/* loaded from: classes.dex */
public abstract class CameraEffect {
    private static final List<Integer> SURFACE_PROCESSOR_TARGETS = Arrays.asList(1, 2, 3, 7);
    private final Consumer<Throwable> mErrorListener;
    private final Executor mExecutor;
    private final ImageProcessor mImageProcessor;
    private final SurfaceProcessor mSurfaceProcessor;
    private final int mTargets;

    public int getTargets() {
        return this.mTargets;
    }

    public Executor getExecutor() {
        return this.mExecutor;
    }

    public Consumer<Throwable> getErrorListener() {
        return this.mErrorListener;
    }

    public SurfaceProcessor getSurfaceProcessor() {
        return this.mSurfaceProcessor;
    }

    public ImageProcessor getImageProcessor() {
        return this.mImageProcessor;
    }

    public SurfaceProcessorInternal createSurfaceProcessorInternal() {
        return new SurfaceProcessorWithExecutor(this);
    }
}

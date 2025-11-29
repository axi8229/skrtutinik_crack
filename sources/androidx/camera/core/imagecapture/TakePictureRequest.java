package androidx.camera.core.imagecapture;

import android.graphics.Matrix;
import android.graphics.Rect;
import androidx.camera.core.ImageCapture;
import androidx.camera.core.ImageCaptureException;
import androidx.camera.core.ImageProxy;
import androidx.camera.core.impl.CameraCaptureCallback;
import androidx.camera.core.impl.utils.Threads;
import androidx.camera.core.internal.compat.workaround.CaptureFailedRetryEnabler;
import java.util.List;
import java.util.Objects;
import java.util.concurrent.Executor;

/* loaded from: classes.dex */
public abstract class TakePictureRequest {
    private int mRemainingRetires = new CaptureFailedRetryEnabler().getRetryCount();

    interface RetryControl {
        void retryRequest(TakePictureRequest takePictureRequest);
    }

    abstract Executor getAppExecutor();

    abstract int getCaptureMode();

    abstract Rect getCropRect();

    abstract ImageCapture.OnImageCapturedCallback getInMemoryCallback();

    abstract int getJpegQuality();

    abstract ImageCapture.OnImageSavedCallback getOnDiskCallback();

    abstract ImageCapture.OutputFileOptions getOutputFileOptions();

    abstract int getRotationDegrees();

    abstract Matrix getSensorToBufferTransform();

    abstract List<CameraCaptureCallback> getSessionConfigCameraCaptureCallbacks();

    boolean decrementRetryCounter() {
        Threads.checkMainThread();
        int i = this.mRemainingRetires;
        if (i <= 0) {
            return false;
        }
        this.mRemainingRetires = i - 1;
        return true;
    }

    void onError(final ImageCaptureException imageCaptureException) {
        getAppExecutor().execute(new Runnable() { // from class: androidx.camera.core.imagecapture.TakePictureRequest$$ExternalSyntheticLambda0
            @Override // java.lang.Runnable
            public final void run() {
                this.f$0.lambda$onError$0(imageCaptureException);
            }
        });
    }

    /* JADX INFO: Access modifiers changed from: private */
    public /* synthetic */ void lambda$onError$0(ImageCaptureException imageCaptureException) {
        getInMemoryCallback();
        if (getOnDiskCallback() != null) {
            ImageCapture.OnImageSavedCallback onDiskCallback = getOnDiskCallback();
            Objects.requireNonNull(onDiskCallback);
            onDiskCallback.onError(imageCaptureException);
            return;
        }
        throw new IllegalStateException("One and only one callback is allowed.");
    }

    /* JADX INFO: Access modifiers changed from: private */
    public /* synthetic */ void lambda$onResult$1(ImageCapture.OutputFileResults outputFileResults) {
        ImageCapture.OnImageSavedCallback onDiskCallback = getOnDiskCallback();
        Objects.requireNonNull(onDiskCallback);
        Objects.requireNonNull(outputFileResults);
        onDiskCallback.onImageSaved(outputFileResults);
    }

    void onResult(final ImageCapture.OutputFileResults outputFileResults) {
        getAppExecutor().execute(new Runnable() { // from class: androidx.camera.core.imagecapture.TakePictureRequest$$ExternalSyntheticLambda2
            @Override // java.lang.Runnable
            public final void run() {
                this.f$0.lambda$onResult$1(outputFileResults);
            }
        });
    }

    /* JADX INFO: Access modifiers changed from: private */
    public /* synthetic */ void lambda$onResult$2(ImageProxy imageProxy) {
        ImageCapture.OnImageCapturedCallback inMemoryCallback = getInMemoryCallback();
        Objects.requireNonNull(inMemoryCallback);
        Objects.requireNonNull(imageProxy);
        inMemoryCallback.onCaptureSuccess(imageProxy);
    }

    void onResult(final ImageProxy imageProxy) {
        getAppExecutor().execute(new Runnable() { // from class: androidx.camera.core.imagecapture.TakePictureRequest$$ExternalSyntheticLambda1
            @Override // java.lang.Runnable
            public final void run() {
                this.f$0.lambda$onResult$2(imageProxy);
            }
        });
    }
}

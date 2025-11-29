package androidx.camera.core.processing;

import androidx.camera.core.ImageProcessor;
import androidx.camera.core.ImageProxy;

/* loaded from: classes.dex */
public class ImageProcessorRequest implements ImageProcessor.Request {
    private final ImageProxy mImageProxy;
    private final int mOutputFormat;

    public ImageProcessorRequest(ImageProxy imageProxy, int i) {
        this.mImageProxy = imageProxy;
        this.mOutputFormat = i;
    }
}

package androidx.camera.core;

/* loaded from: classes.dex */
public interface ImageProcessor {

    public interface Request {
    }

    public interface Response {
        ImageProxy getOutputImage();
    }

    Response process(Request request) throws ProcessingException;
}

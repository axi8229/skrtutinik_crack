package androidx.camera.core;

/* loaded from: classes.dex */
public class CameraUnavailableException extends Exception {
    private final int mReason;

    public CameraUnavailableException(int i, Throwable th) {
        super(th);
        this.mReason = i;
    }
}

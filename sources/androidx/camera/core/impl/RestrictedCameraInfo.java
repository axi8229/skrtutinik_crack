package androidx.camera.core.impl;

/* loaded from: classes.dex */
public class RestrictedCameraInfo extends ForwardingCameraInfo {
    private final CameraInfoInternal mCameraInfo;
    private final RestrictedCameraControl mRestrictedCameraControl;

    public RestrictedCameraInfo(CameraInfoInternal cameraInfoInternal, RestrictedCameraControl restrictedCameraControl) {
        super(cameraInfoInternal);
        this.mCameraInfo = cameraInfoInternal;
        this.mRestrictedCameraControl = restrictedCameraControl;
    }

    @Override // androidx.camera.core.impl.CameraInfoInternal
    public CameraInfoInternal getImplementation() {
        return this.mCameraInfo;
    }
}

package androidx.camera.core.impl;

import java.util.Set;

/* loaded from: classes.dex */
public class RestrictedCameraControl extends ForwardingCameraControl {
    private final CameraControlInternal mCameraControl;
    private volatile Set<Integer> mRestrictedCameraOperations;
    private volatile boolean mUseRestrictedCameraOperations;

    public RestrictedCameraControl(CameraControlInternal cameraControlInternal) {
        super(cameraControlInternal);
        this.mUseRestrictedCameraOperations = false;
        this.mCameraControl = cameraControlInternal;
    }

    public void enableRestrictedOperations(boolean z, Set<Integer> set) {
        this.mUseRestrictedCameraOperations = z;
        this.mRestrictedCameraOperations = set;
    }
}

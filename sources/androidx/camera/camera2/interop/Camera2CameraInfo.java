package androidx.camera.camera2.interop;

import androidx.camera.camera2.internal.Camera2CameraInfoImpl;
import androidx.camera.core.CameraInfo;
import androidx.camera.core.impl.CameraInfoInternal;
import androidx.core.util.Preconditions;

/* loaded from: classes.dex */
public final class Camera2CameraInfo {
    private final Camera2CameraInfoImpl mCamera2CameraInfoImpl;

    public Camera2CameraInfo(Camera2CameraInfoImpl camera2CameraInfoImpl) {
        this.mCamera2CameraInfoImpl = camera2CameraInfoImpl;
    }

    public static Camera2CameraInfo from(CameraInfo cameraInfo) {
        CameraInfoInternal implementation = ((CameraInfoInternal) cameraInfo).getImplementation();
        Preconditions.checkArgument(implementation instanceof Camera2CameraInfoImpl, "CameraInfo doesn't contain Camera2 implementation.");
        return ((Camera2CameraInfoImpl) implementation).getCamera2CameraInfo();
    }

    public String getCameraId() {
        return this.mCamera2CameraInfoImpl.getCameraId();
    }
}

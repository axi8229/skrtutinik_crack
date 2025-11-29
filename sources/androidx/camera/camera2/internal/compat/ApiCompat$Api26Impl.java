package androidx.camera.camera2.internal.compat;

import android.hardware.camera2.CameraCaptureSession;
import android.hardware.camera2.params.OutputConfiguration;
import android.util.Size;

/* loaded from: classes.dex */
public class ApiCompat$Api26Impl {
    public static void onCaptureQueueEmpty(CameraCaptureSession.StateCallback stateCallback, CameraCaptureSession cameraCaptureSession) {
        stateCallback.onCaptureQueueEmpty(cameraCaptureSession);
    }

    public static <T> OutputConfiguration newOutputConfiguration(Size size, Class<T> cls) {
        return ApiCompat$Api26Impl$$ExternalSyntheticApiModelOutline1.m(size, cls);
    }
}

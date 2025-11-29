package androidx.camera.core.impl;

import android.util.Size;
import androidx.camera.core.CameraInfo;
import java.util.List;
import java.util.concurrent.Executor;

/* loaded from: classes.dex */
public interface CameraInfoInternal extends CameraInfo {
    void addSessionCaptureCallback(Executor executor, CameraCaptureCallback cameraCaptureCallback);

    String getCameraId();

    Quirks getCameraQuirks();

    default CameraInfoInternal getImplementation() {
        return this;
    }

    List<Size> getSupportedHighResolutions(int i);

    List<Size> getSupportedResolutions(int i);

    void removeSessionCaptureCallback(CameraCaptureCallback cameraCaptureCallback);
}

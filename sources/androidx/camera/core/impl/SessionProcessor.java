package androidx.camera.core.impl;

import androidx.camera.core.CameraInfo;
import java.util.Collections;
import java.util.Set;

/* loaded from: classes.dex */
public interface SessionProcessor {

    public interface CaptureCallback {
    }

    void deInitSession();

    SessionConfig initSession(CameraInfo cameraInfo, OutputSurface outputSurface, OutputSurface outputSurface2, OutputSurface outputSurface3);

    void onCaptureSessionEnd();

    void onCaptureSessionStart(RequestProcessor requestProcessor);

    void setParameters(Config config);

    int startCapture(CaptureCallback captureCallback);

    int startRepeating(CaptureCallback captureCallback);

    default int startTrigger(Config config, CaptureCallback captureCallback) {
        return -1;
    }

    void stopRepeating();

    default Set<Integer> getSupportedCameraOperations() {
        return Collections.emptySet();
    }
}

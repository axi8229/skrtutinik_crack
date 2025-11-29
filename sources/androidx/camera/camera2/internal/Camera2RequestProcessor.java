package androidx.camera.camera2.internal;

import androidx.camera.camera2.internal.CaptureSession;
import androidx.camera.core.impl.RequestProcessor;
import androidx.camera.core.impl.SessionConfig;
import androidx.camera.core.impl.SessionProcessorSurface;
import androidx.core.util.Preconditions;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

/* loaded from: classes.dex */
public class Camera2RequestProcessor implements RequestProcessor {
    private final CaptureSession mCaptureSession;
    private volatile boolean mIsClosed = false;
    private final List<SessionProcessorSurface> mProcessorSurfaces;
    private volatile SessionConfig mSessionConfig;

    public Camera2RequestProcessor(CaptureSession captureSession, List<SessionProcessorSurface> list) {
        Preconditions.checkArgument(captureSession.mState == CaptureSession.State.OPENED, "CaptureSession state must be OPENED. Current state:" + captureSession.mState);
        this.mCaptureSession = captureSession;
        this.mProcessorSurfaces = Collections.unmodifiableList(new ArrayList(list));
    }

    public void close() {
        this.mIsClosed = true;
    }

    public void updateSessionConfig(SessionConfig sessionConfig) {
        this.mSessionConfig = sessionConfig;
    }
}

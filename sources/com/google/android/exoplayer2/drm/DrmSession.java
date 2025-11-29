package com.google.android.exoplayer2.drm;

import com.google.android.exoplayer2.util.MediaSourceEventDispatcher;
import java.io.IOException;
import java.util.Map;

/* loaded from: classes2.dex */
public interface DrmSession {
    void acquire(MediaSourceEventDispatcher eventDispatcher);

    DrmSessionException getError();

    ExoMediaCrypto getMediaCrypto();

    int getState();

    default boolean playClearSamplesWithoutKeys() {
        return false;
    }

    Map<String, String> queryKeyStatus();

    void release(MediaSourceEventDispatcher eventDispatcher);

    static void replaceSession(DrmSession previousSession, DrmSession newSession) {
        if (previousSession == newSession) {
            return;
        }
        if (newSession != null) {
            newSession.acquire(null);
        }
        if (previousSession != null) {
            previousSession.release(null);
        }
    }

    public static class DrmSessionException extends IOException {
        public DrmSessionException(Throwable cause) {
            super(cause);
        }
    }
}

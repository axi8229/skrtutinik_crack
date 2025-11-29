package com.google.android.exoplayer2.drm;

import com.google.android.exoplayer2.drm.DrmSession;
import com.google.android.exoplayer2.util.Assertions;
import com.google.android.exoplayer2.util.MediaSourceEventDispatcher;
import java.util.Map;

/* loaded from: classes2.dex */
public final class ErrorStateDrmSession implements DrmSession {
    private final DrmSession.DrmSessionException error;

    @Override // com.google.android.exoplayer2.drm.DrmSession
    public void acquire(MediaSourceEventDispatcher eventDispatcher) {
    }

    @Override // com.google.android.exoplayer2.drm.DrmSession
    public ExoMediaCrypto getMediaCrypto() {
        return null;
    }

    @Override // com.google.android.exoplayer2.drm.DrmSession
    public int getState() {
        return 1;
    }

    @Override // com.google.android.exoplayer2.drm.DrmSession
    public boolean playClearSamplesWithoutKeys() {
        return false;
    }

    @Override // com.google.android.exoplayer2.drm.DrmSession
    public Map<String, String> queryKeyStatus() {
        return null;
    }

    @Override // com.google.android.exoplayer2.drm.DrmSession
    public void release(MediaSourceEventDispatcher eventDispatcher) {
    }

    public ErrorStateDrmSession(DrmSession.DrmSessionException error) {
        this.error = (DrmSession.DrmSessionException) Assertions.checkNotNull(error);
    }

    @Override // com.google.android.exoplayer2.drm.DrmSession
    public DrmSession.DrmSessionException getError() {
        return this.error;
    }
}

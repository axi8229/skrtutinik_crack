package com.google.android.exoplayer2.drm;

import android.os.Looper;
import com.google.android.exoplayer2.drm.DrmSession;
import com.google.android.exoplayer2.util.MediaSourceEventDispatcher;

/* loaded from: classes2.dex */
public interface DrmSessionManager {
    public static final DrmSessionManager DUMMY = new DrmSessionManager() { // from class: com.google.android.exoplayer2.drm.DrmSessionManager.1
        @Override // com.google.android.exoplayer2.drm.DrmSessionManager
        public Class<ExoMediaCrypto> getExoMediaCryptoType(DrmInitData drmInitData) {
            return null;
        }

        @Override // com.google.android.exoplayer2.drm.DrmSessionManager
        public DrmSession acquireSession(Looper playbackLooper, MediaSourceEventDispatcher eventDispatcher, DrmInitData drmInitData) {
            return new ErrorStateDrmSession(new DrmSession.DrmSessionException(new UnsupportedDrmException(1)));
        }
    };

    default DrmSession acquirePlaceholderSession(Looper playbackLooper, int trackType) {
        return null;
    }

    DrmSession acquireSession(Looper playbackLooper, MediaSourceEventDispatcher eventDispatcher, DrmInitData drmInitData);

    Class<? extends ExoMediaCrypto> getExoMediaCryptoType(DrmInitData drmInitData);

    default void prepare() {
    }

    default void release() {
    }

    static DrmSessionManager getDummyDrmSessionManager() {
        return DUMMY;
    }
}

package com.google.android.exoplayer2.source;

import com.google.android.exoplayer2.MediaItem;
import com.google.android.exoplayer2.drm.DrmSessionManager;
import com.google.android.exoplayer2.offline.StreamKey;
import java.util.List;

/* loaded from: classes2.dex */
public interface MediaSourceFactory {
    MediaSource createMediaSource(MediaItem mediaItem);

    MediaSourceFactory setDrmSessionManager(DrmSessionManager drmSessionManager);

    @Deprecated
    default MediaSourceFactory setStreamKeys(List<StreamKey> streamKeys) {
        return this;
    }
}

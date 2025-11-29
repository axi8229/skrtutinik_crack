package com.google.android.exoplayer2.source;

import com.google.android.exoplayer2.Format;

/* loaded from: classes2.dex */
public final class MediaLoadData {
    public final int dataType;
    public final long mediaEndTimeMs;
    public final long mediaStartTimeMs;
    public final Format trackFormat;
    public final Object trackSelectionData;
    public final int trackSelectionReason;
    public final int trackType;

    public MediaLoadData(int dataType, int trackType, Format trackFormat, int trackSelectionReason, Object trackSelectionData, long mediaStartTimeMs, long mediaEndTimeMs) {
        this.dataType = dataType;
        this.trackType = trackType;
        this.trackFormat = trackFormat;
        this.trackSelectionReason = trackSelectionReason;
        this.trackSelectionData = trackSelectionData;
        this.mediaStartTimeMs = mediaStartTimeMs;
        this.mediaEndTimeMs = mediaEndTimeMs;
    }
}

package com.google.android.exoplayer2.source.dash;

import com.google.android.exoplayer2.source.dash.manifest.RangedUri;

/* loaded from: classes2.dex */
public interface DashSegmentIndex {
    long getDurationUs(long segmentNum, long periodDurationUs);

    long getFirstSegmentNum();

    int getSegmentCount(long periodDurationUs);

    long getSegmentNum(long timeUs, long periodDurationUs);

    RangedUri getSegmentUrl(long segmentNum);

    long getTimeUs(long segmentNum);

    boolean isExplicit();
}

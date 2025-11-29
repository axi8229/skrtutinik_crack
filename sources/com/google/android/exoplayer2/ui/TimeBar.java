package com.google.android.exoplayer2.ui;

/* loaded from: classes2.dex */
public interface TimeBar {

    public interface OnScrubListener {
        void onScrubMove(TimeBar timeBar, long position);

        void onScrubStart(TimeBar timeBar, long position);

        void onScrubStop(TimeBar timeBar, long position, boolean canceled);
    }

    void addListener(OnScrubListener listener);

    long getPreferredUpdateDelay();

    void setAdGroupTimesMs(long[] adGroupTimesMs, boolean[] playedAdGroups, int adGroupCount);

    void setBufferedPosition(long bufferedPosition);

    void setDuration(long duration);

    void setEnabled(boolean enabled);

    void setPosition(long position);
}

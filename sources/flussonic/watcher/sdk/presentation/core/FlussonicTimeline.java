package flussonic.watcher.sdk.presentation.core;

import flussonic.watcher.sdk.domain.pojo.PlaybackSpeed;
import flussonic.watcher.sdk.domain.pojo.Quality;
import flussonic.watcher.sdk.domain.pojo.Range;
import flussonic.watcher.sdk.domain.pojo.Ranges;
import flussonic.watcher.sdk.domain.pojo.VisibleRangeChangedEvent;

/* loaded from: classes3.dex */
public interface FlussonicTimeline {

    public interface TimelineListener {
        void onChartBarYChanged(int yInWindow);

        void onDownloadRequest(long from, long to);

        void onLiveClick();

        void onMuteClick();

        void onPlayClick(long position);

        void onPlaybackSpeedChanged(PlaybackSpeed speed);

        void onPlaybackSpeedClick();

        void onQualityChanged(Quality quality);

        void onQualityClick(Quality quality);

        void onUnmuteClick();

        void onVisibleIntervalChanged(VisibleRangeChangedEvent event);

        void showDatePicker(long minDateTimeInSecs, long maxDateTimeInSecs, long nowInSecs);
    }

    void clearPosition();

    void moveToPosition(long position);

    void setAllowDownload(boolean allowDownload);

    void setBorders(Range range);

    void setCalendarClickable(boolean clickable);

    void setCameraStatus(boolean isActive);

    void setMute(boolean mute);

    void setMuteVisibility(boolean visible);

    void setPlaybackSpeedVisibility(boolean visible);

    void setQuality(Quality quality);

    void setRanges(Ranges ranges);

    void setTimelineListener(TimelineListener timelineListener);

    void showPlaybackSpeedMenu(PlaybackSpeed checkedSpeed);

    void showQualityMenu(Quality quality);

    void updateProgress(long currentPosition);
}

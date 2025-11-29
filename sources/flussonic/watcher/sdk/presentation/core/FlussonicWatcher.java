package flussonic.watcher.sdk.presentation.core;

import flussonic.watcher.sdk.domain.pojo.PlaybackStatus;
import flussonic.watcher.sdk.domain.pojo.Track;
import flussonic.watcher.sdk.presentation.core.listeners.FlussonicBufferingListener;
import flussonic.watcher.sdk.presentation.core.listeners.FlussonicDownloadRequestListener;
import flussonic.watcher.sdk.presentation.core.listeners.FlussonicPlayerSessionListener;
import flussonic.watcher.sdk.presentation.core.listeners.FlussonicUpdateProgressEventListener;
import java.util.List;

/* loaded from: classes3.dex */
public interface FlussonicWatcher {
    void clearCache();

    void disableAudio(boolean audioDisabled);

    void enableTimelineMarkersV2(boolean markersV2Enabled);

    List<Track> getAvailableTracks();

    Track getCurrentTrack();

    long getCurrentUtcInSeconds();

    PlaybackStatus getPlaybackStatus();

    float getSpeed();

    void release();

    void seek(long seconds);

    void setAllowDownload(boolean allowDownload);

    void setBufferingListener(FlussonicBufferingListener bufferingListener);

    void setDownloadRequestListener(FlussonicDownloadRequestListener downloadRequestListener);

    void setPlayerSessionListener(FlussonicPlayerSessionListener sessionListener);

    void setStartPosition(long dateTimeInSecs);

    void setUpdateProgressEventListener(FlussonicUpdateProgressEventListener updateProgressEventListener);
}

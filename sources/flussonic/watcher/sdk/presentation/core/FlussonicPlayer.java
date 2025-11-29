package flussonic.watcher.sdk.presentation.core;

import com.google.android.exoplayer2.Format;
import flussonic.watcher.sdk.domain.pojo.PlaybackStatus;
import flussonic.watcher.sdk.domain.pojo.Quality;
import flussonic.watcher.sdk.presentation.player.exo.FlussonicPlaybackStatsListener;
import flussonic.watcher.sdk.presentation.player.exo.PlayerStateListener;
import flussonic.watcher.sdk.presentation.watcher.StreamerUrlProvider;
import java.util.List;

/* loaded from: classes3.dex */
public interface FlussonicPlayer {

    public interface PlayerListener extends PlayerStateListener {
        void onBufferingStart();

        void onBufferingStop();

        void onTapConfirmed();

        void onTrackChanged();
    }

    void continuePlayArchive(long from);

    void continuePlayLive();

    void disableAudioTrack(boolean audioDisabled);

    List<Format> getAvailableTracks();

    Format getCurrentTrack();

    long getFrom();

    PlaybackStatus getPlaybackStatus();

    long getPlaybackTimeUtcInSeconds();

    Quality getQuality();

    boolean isAudioTrackDisabled();

    boolean isSwitchToLive();

    void moveToBackground();

    void moveToForeground();

    void pause();

    void playArchive(long from);

    void playLive();

    void resume();

    void setFlussonicPlaybackStatsListener(FlussonicPlaybackStatsListener playbackStatsListener);

    int setMaxFrameRate(int maxFPS);

    void setPlayerListener(PlayerListener playerListener);

    void setQuality(Quality quality);

    void setResizeMode(int resizeMode);

    void setSpeed(float speed);

    void setStreamerUrlProvider(StreamerUrlProvider streamerUrlProvider);

    void setVolume(float volume);

    void stop();
}

package flussonic.watcher.sdk.presentation.player.exo;

import com.google.android.exoplayer2.ExoPlaybackException;
import com.google.android.exoplayer2.PlaybackParameters;
import com.google.android.exoplayer2.Player;
import com.google.android.exoplayer2.Timeline;
import com.google.android.exoplayer2.source.TrackGroupArray;
import com.google.android.exoplayer2.trackselection.TrackSelectionArray;
import com.huawei.hms.android.SystemUtils;
import flussonic.watcher.sdk.presentation.core.FlussonicPlayer;
import timber.log.Timber;

/* loaded from: classes3.dex */
class PlayerEventListener implements Player.EventListener {
    private boolean isBuffering;
    private FlussonicPlayer.PlayerListener playerListener;

    PlayerEventListener(FlussonicPlayer.PlayerListener playerListener) {
        this.playerListener = playerListener;
    }

    private static String toString(int playbackState) {
        if (playbackState == 1) {
            return "idle";
        }
        if (playbackState == 2) {
            return "buffering";
        }
        if (playbackState == 3) {
            return "ready";
        }
        if (playbackState == 4) {
            return "ended";
        }
        return SystemUtils.UNKNOWN;
    }

    @Override // com.google.android.exoplayer2.Player.EventListener
    public void onTimelineChanged(Timeline timeline, int reason) {
        Timber.d("onTimelineChanged", new Object[0]);
    }

    @Override // com.google.android.exoplayer2.Player.EventListener
    public void onTracksChanged(TrackGroupArray trackGroups, TrackSelectionArray trackSelections) {
        Timber.d("onTracksChanged", new Object[0]);
        FlussonicPlayer.PlayerListener playerListener = this.playerListener;
        if (playerListener != null) {
            playerListener.onTrackChanged();
        }
    }

    @Override // com.google.android.exoplayer2.Player.EventListener
    public void onIsLoadingChanged(boolean isLoading) {
        Timber.d("onIsLoadingChanged: isLoading=%s", Boolean.valueOf(isLoading));
    }

    @Override // com.google.android.exoplayer2.Player.EventListener
    public void onIsPlayingChanged(boolean isPlaying) {
        Timber.d("onIsPlayingChanged: isPlaying=%s", Boolean.valueOf(isPlaying));
    }

    @Override // com.google.android.exoplayer2.Player.EventListener
    public void onPlayerStateChanged(boolean playWhenReady, int playbackState) {
        Timber.d("onPlayerStateChanged: playWhenReady=%s, playbackState=%d %s", Boolean.valueOf(playWhenReady), Integer.valueOf(playbackState), toString(playbackState));
        FlussonicPlayer.PlayerListener playerListener = this.playerListener;
        if (playerListener != null) {
            if (playbackState == 2 && !this.isBuffering) {
                playerListener.onBufferingStart();
                this.isBuffering = true;
            } else if (this.isBuffering) {
                this.isBuffering = false;
                playerListener.onBufferingStop();
            }
            if (playbackState == 1) {
                this.playerListener.onVideoIdle();
                return;
            }
            if (playbackState == 3 && playWhenReady) {
                this.playerListener.onVideoPlayingStarted();
            } else if (playbackState == 4) {
                this.playerListener.onVideoCompleted();
            }
        }
    }

    @Override // com.google.android.exoplayer2.Player.EventListener
    public void onRepeatModeChanged(int repeatMode) {
        Timber.d("onRepeatModeChanged", new Object[0]);
    }

    @Override // com.google.android.exoplayer2.Player.EventListener
    public void onShuffleModeEnabledChanged(boolean shuffleModeEnabled) {
        Timber.d("onSnuffleModeEnabledChanged", new Object[0]);
    }

    @Override // com.google.android.exoplayer2.Player.EventListener
    public void onPlayerError(ExoPlaybackException error) {
        this.playerListener.onVideoLoadingFailed(error);
    }

    @Override // com.google.android.exoplayer2.Player.EventListener
    public void onPositionDiscontinuity(int reason) {
        Timber.d("onPositionDiscontinuity", new Object[0]);
    }

    @Override // com.google.android.exoplayer2.Player.EventListener
    public void onPlaybackParametersChanged(PlaybackParameters playbackParameters) {
        Timber.d("onPlaybackParametersChanged", new Object[0]);
    }

    @Override // com.google.android.exoplayer2.Player.EventListener
    public void onSeekProcessed() {
        Timber.d("onSeekProcessed", new Object[0]);
    }

    void setPlayerListener(FlussonicPlayer.PlayerListener playerListener) {
        this.playerListener = playerListener;
    }
}

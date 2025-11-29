package flussonic.watcher.sdk.presentation.player.exo;

import com.google.android.exoplayer2.ExoPlaybackException;

/* loaded from: classes3.dex */
public interface PlayerStateListener {
    void onVideoCompleted();

    void onVideoIdle();

    void onVideoLoadingFailed(ExoPlaybackException error);

    void onVideoPlayingStarted();
}

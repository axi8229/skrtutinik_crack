package flussonic.watcher.sdk.presentation.core.listeners;

/* loaded from: classes3.dex */
public interface FlussonicPlayerSessionListener {
    void onMediaSessionChanged(String mediaSession);

    void onPlaybackSessionActive(String playbackSession);

    void onPlaybackSessionCreated(String playbackSession);

    void onPlaybackSessionFinished(String playbackSession);
}

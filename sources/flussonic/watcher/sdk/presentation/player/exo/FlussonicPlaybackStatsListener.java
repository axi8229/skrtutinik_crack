package flussonic.watcher.sdk.presentation.player.exo;

import com.google.android.exoplayer2.analytics.AnalyticsListener;
import com.google.android.exoplayer2.analytics.PlaybackStatsListener;
import com.google.android.exoplayer2.source.MediaSourceEventListener;
import flussonic.watcher.sdk.presentation.core.listeners.FlussonicPlayerSessionListener;
import java.util.List;
import java.util.Map;
import java.util.UUID;

/* loaded from: classes3.dex */
public class FlussonicPlaybackStatsListener extends PlaybackStatsListener implements AnalyticsListener, MediaSourceEventListener {
    private final FlussonicPlayerSessionListener sessionListener;
    private String xsid;

    public FlussonicPlaybackStatsListener(FlussonicPlayerSessionListener sessionListener) {
        super(false, null);
        this.sessionListener = sessionListener;
    }

    @Override // com.google.android.exoplayer2.analytics.PlaybackSessionManager.Listener
    public void onSessionCreated(AnalyticsListener.EventTime eventTime, String session) {
        this.sessionListener.onPlaybackSessionCreated(UUID.nameUUIDFromBytes(session.getBytes()).toString());
    }

    @Override // com.google.android.exoplayer2.analytics.PlaybackSessionManager.Listener
    public void onSessionActive(AnalyticsListener.EventTime eventTime, String session) {
        this.sessionListener.onPlaybackSessionActive(UUID.nameUUIDFromBytes(session.getBytes()).toString());
    }

    @Override // com.google.android.exoplayer2.analytics.PlaybackSessionManager.Listener
    public void onSessionFinished(AnalyticsListener.EventTime eventTime, String session, boolean automaticTransition) {
        this.sessionListener.onPlaybackSessionFinished(UUID.nameUUIDFromBytes(session.getBytes()).toString());
    }

    void handleResponseHeaders(Map<String, List<String>> headers) {
        String str;
        List<String> list = headers.get("X-Sid");
        if (list == null || list.isEmpty() || (str = list.get(0)) == null || str.equals(this.xsid)) {
            return;
        }
        this.xsid = str;
        this.sessionListener.onMediaSessionChanged(str);
    }
}

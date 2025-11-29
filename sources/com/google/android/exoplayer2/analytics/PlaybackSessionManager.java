package com.google.android.exoplayer2.analytics;

import com.google.android.exoplayer2.analytics.AnalyticsListener;

/* loaded from: classes2.dex */
public interface PlaybackSessionManager {

    public interface Listener {
        void onAdPlaybackStarted(AnalyticsListener.EventTime eventTime, String contentSessionId, String adSessionId);

        void onSessionActive(AnalyticsListener.EventTime eventTime, String sessionId);

        void onSessionCreated(AnalyticsListener.EventTime eventTime, String sessionId);

        void onSessionFinished(AnalyticsListener.EventTime eventTime, String sessionId, boolean automaticTransitionToNextPlayback);
    }

    boolean belongsToSession(AnalyticsListener.EventTime eventTime, String sessionId);

    void handlePositionDiscontinuity(AnalyticsListener.EventTime eventTime, int reason);

    void handleTimelineUpdate(AnalyticsListener.EventTime eventTime);

    void setListener(Listener listener);

    void updateSessions(AnalyticsListener.EventTime eventTime);
}

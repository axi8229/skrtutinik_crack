package com.google.android.exoplayer2.analytics;

import android.util.Base64;
import com.google.android.exoplayer2.Timeline;
import com.google.android.exoplayer2.analytics.AnalyticsListener;
import com.google.android.exoplayer2.analytics.PlaybackSessionManager;
import com.google.android.exoplayer2.source.MediaSource;
import com.google.android.exoplayer2.util.Assertions;
import com.google.android.exoplayer2.util.Supplier;
import com.google.android.exoplayer2.util.Util;
import java.util.HashMap;
import java.util.Iterator;
import java.util.Random;

/* loaded from: classes2.dex */
public final class DefaultPlaybackSessionManager implements PlaybackSessionManager {
    public static final Supplier<String> DEFAULT_SESSION_ID_GENERATOR = new Supplier() { // from class: com.google.android.exoplayer2.analytics.DefaultPlaybackSessionManager$$ExternalSyntheticLambda0
        @Override // com.google.android.exoplayer2.util.Supplier
        public final Object get() {
            return DefaultPlaybackSessionManager.generateDefaultSessionId();
        }
    };
    private static final Random RANDOM = new Random();
    private String currentSessionId;
    private Timeline currentTimeline;
    private PlaybackSessionManager.Listener listener;
    private final Timeline.Period period;
    private final Supplier<String> sessionIdGenerator;
    private final HashMap<String, SessionDescriptor> sessions;
    private final Timeline.Window window;

    public DefaultPlaybackSessionManager() {
        this(DEFAULT_SESSION_ID_GENERATOR);
    }

    public DefaultPlaybackSessionManager(Supplier<String> sessionIdGenerator) {
        this.sessionIdGenerator = sessionIdGenerator;
        this.window = new Timeline.Window();
        this.period = new Timeline.Period();
        this.sessions = new HashMap<>();
        this.currentTimeline = Timeline.EMPTY;
    }

    @Override // com.google.android.exoplayer2.analytics.PlaybackSessionManager
    public void setListener(PlaybackSessionManager.Listener listener) {
        this.listener = listener;
    }

    @Override // com.google.android.exoplayer2.analytics.PlaybackSessionManager
    public synchronized boolean belongsToSession(AnalyticsListener.EventTime eventTime, String sessionId) {
        SessionDescriptor sessionDescriptor = this.sessions.get(sessionId);
        if (sessionDescriptor == null) {
            return false;
        }
        sessionDescriptor.maybeSetWindowSequenceNumber(eventTime.windowIndex, eventTime.mediaPeriodId);
        return sessionDescriptor.belongsToSession(eventTime.windowIndex, eventTime.mediaPeriodId);
    }

    /* JADX WARN: Code restructure failed: missing block: B:15:0x0035, code lost:
    
        if (r6.mediaPeriodId.windowSequenceNumber < r0.windowSequenceNumber) goto L16;
     */
    @Override // com.google.android.exoplayer2.analytics.PlaybackSessionManager
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    public synchronized void updateSessions(com.google.android.exoplayer2.analytics.AnalyticsListener.EventTime r6) {
        /*
            r5 = this;
            monitor-enter(r5)
            com.google.android.exoplayer2.analytics.PlaybackSessionManager$Listener r0 = r5.listener     // Catch: java.lang.Throwable -> L29
            com.google.android.exoplayer2.util.Assertions.checkNotNull(r0)     // Catch: java.lang.Throwable -> L29
            java.util.HashMap<java.lang.String, com.google.android.exoplayer2.analytics.DefaultPlaybackSessionManager$SessionDescriptor> r0 = r5.sessions     // Catch: java.lang.Throwable -> L29
            java.lang.String r1 = r5.currentSessionId     // Catch: java.lang.Throwable -> L29
            java.lang.Object r0 = r0.get(r1)     // Catch: java.lang.Throwable -> L29
            com.google.android.exoplayer2.analytics.DefaultPlaybackSessionManager$SessionDescriptor r0 = (com.google.android.exoplayer2.analytics.DefaultPlaybackSessionManager.SessionDescriptor) r0     // Catch: java.lang.Throwable -> L29
            com.google.android.exoplayer2.source.MediaSource$MediaPeriodId r1 = r6.mediaPeriodId     // Catch: java.lang.Throwable -> L29
            if (r1 == 0) goto L39
            if (r0 == 0) goto L39
            long r1 = com.google.android.exoplayer2.analytics.DefaultPlaybackSessionManager.SessionDescriptor.access$100(r0)     // Catch: java.lang.Throwable -> L29
            r3 = -1
            int r1 = (r1 > r3 ? 1 : (r1 == r3 ? 0 : -1))
            if (r1 != 0) goto L2b
            int r0 = com.google.android.exoplayer2.analytics.DefaultPlaybackSessionManager.SessionDescriptor.access$200(r0)     // Catch: java.lang.Throwable -> L29
            int r1 = r6.windowIndex     // Catch: java.lang.Throwable -> L29
            if (r0 == r1) goto L39
            goto L37
        L29:
            r6 = move-exception
            goto L7e
        L2b:
            com.google.android.exoplayer2.source.MediaSource$MediaPeriodId r1 = r6.mediaPeriodId     // Catch: java.lang.Throwable -> L29
            long r1 = r1.windowSequenceNumber     // Catch: java.lang.Throwable -> L29
            long r3 = com.google.android.exoplayer2.analytics.DefaultPlaybackSessionManager.SessionDescriptor.access$100(r0)     // Catch: java.lang.Throwable -> L29
            int r0 = (r1 > r3 ? 1 : (r1 == r3 ? 0 : -1))
            if (r0 >= 0) goto L39
        L37:
            monitor-exit(r5)
            return
        L39:
            int r0 = r6.windowIndex     // Catch: java.lang.Throwable -> L29
            com.google.android.exoplayer2.source.MediaSource$MediaPeriodId r1 = r6.mediaPeriodId     // Catch: java.lang.Throwable -> L29
            com.google.android.exoplayer2.analytics.DefaultPlaybackSessionManager$SessionDescriptor r0 = r5.getOrAddSession(r0, r1)     // Catch: java.lang.Throwable -> L29
            java.lang.String r1 = r5.currentSessionId     // Catch: java.lang.Throwable -> L29
            if (r1 != 0) goto L4b
            java.lang.String r1 = com.google.android.exoplayer2.analytics.DefaultPlaybackSessionManager.SessionDescriptor.access$000(r0)     // Catch: java.lang.Throwable -> L29
            r5.currentSessionId = r1     // Catch: java.lang.Throwable -> L29
        L4b:
            boolean r1 = com.google.android.exoplayer2.analytics.DefaultPlaybackSessionManager.SessionDescriptor.access$300(r0)     // Catch: java.lang.Throwable -> L29
            r2 = 1
            if (r1 != 0) goto L5e
            com.google.android.exoplayer2.analytics.DefaultPlaybackSessionManager.SessionDescriptor.access$302(r0, r2)     // Catch: java.lang.Throwable -> L29
            com.google.android.exoplayer2.analytics.PlaybackSessionManager$Listener r1 = r5.listener     // Catch: java.lang.Throwable -> L29
            java.lang.String r3 = com.google.android.exoplayer2.analytics.DefaultPlaybackSessionManager.SessionDescriptor.access$000(r0)     // Catch: java.lang.Throwable -> L29
            r1.onSessionCreated(r6, r3)     // Catch: java.lang.Throwable -> L29
        L5e:
            java.lang.String r1 = com.google.android.exoplayer2.analytics.DefaultPlaybackSessionManager.SessionDescriptor.access$000(r0)     // Catch: java.lang.Throwable -> L29
            java.lang.String r3 = r5.currentSessionId     // Catch: java.lang.Throwable -> L29
            boolean r1 = r1.equals(r3)     // Catch: java.lang.Throwable -> L29
            if (r1 == 0) goto L7c
            boolean r1 = com.google.android.exoplayer2.analytics.DefaultPlaybackSessionManager.SessionDescriptor.access$400(r0)     // Catch: java.lang.Throwable -> L29
            if (r1 != 0) goto L7c
            com.google.android.exoplayer2.analytics.DefaultPlaybackSessionManager.SessionDescriptor.access$402(r0, r2)     // Catch: java.lang.Throwable -> L29
            com.google.android.exoplayer2.analytics.PlaybackSessionManager$Listener r1 = r5.listener     // Catch: java.lang.Throwable -> L29
            java.lang.String r0 = com.google.android.exoplayer2.analytics.DefaultPlaybackSessionManager.SessionDescriptor.access$000(r0)     // Catch: java.lang.Throwable -> L29
            r1.onSessionActive(r6, r0)     // Catch: java.lang.Throwable -> L29
        L7c:
            monitor-exit(r5)
            return
        L7e:
            monitor-exit(r5)     // Catch: java.lang.Throwable -> L29
            throw r6
        */
        throw new UnsupportedOperationException("Method not decompiled: com.google.android.exoplayer2.analytics.DefaultPlaybackSessionManager.updateSessions(com.google.android.exoplayer2.analytics.AnalyticsListener$EventTime):void");
    }

    @Override // com.google.android.exoplayer2.analytics.PlaybackSessionManager
    public synchronized void handleTimelineUpdate(AnalyticsListener.EventTime eventTime) {
        try {
            Assertions.checkNotNull(this.listener);
            Timeline timeline = this.currentTimeline;
            this.currentTimeline = eventTime.timeline;
            Iterator<SessionDescriptor> it = this.sessions.values().iterator();
            while (it.hasNext()) {
                SessionDescriptor next = it.next();
                if (!next.tryResolvingToNewTimeline(timeline, this.currentTimeline)) {
                    it.remove();
                    if (next.isCreated) {
                        if (next.sessionId.equals(this.currentSessionId)) {
                            this.currentSessionId = null;
                        }
                        this.listener.onSessionFinished(eventTime, next.sessionId, false);
                    }
                }
            }
            handlePositionDiscontinuity(eventTime, 4);
        } catch (Throwable th) {
            throw th;
        }
    }

    @Override // com.google.android.exoplayer2.analytics.PlaybackSessionManager
    public synchronized void handlePositionDiscontinuity(AnalyticsListener.EventTime eventTime, int reason) {
        try {
            Assertions.checkNotNull(this.listener);
            boolean z = reason == 0 || reason == 3;
            Iterator<SessionDescriptor> it = this.sessions.values().iterator();
            while (it.hasNext()) {
                SessionDescriptor next = it.next();
                if (next.isFinishedAtEventTime(eventTime)) {
                    it.remove();
                    if (next.isCreated) {
                        boolean zEquals = next.sessionId.equals(this.currentSessionId);
                        boolean z2 = z && zEquals && next.isActive;
                        if (zEquals) {
                            this.currentSessionId = null;
                        }
                        this.listener.onSessionFinished(eventTime, next.sessionId, z2);
                    }
                }
            }
            SessionDescriptor sessionDescriptor = this.sessions.get(this.currentSessionId);
            SessionDescriptor orAddSession = getOrAddSession(eventTime.windowIndex, eventTime.mediaPeriodId);
            this.currentSessionId = orAddSession.sessionId;
            MediaSource.MediaPeriodId mediaPeriodId = eventTime.mediaPeriodId;
            if (mediaPeriodId != null && mediaPeriodId.isAd() && (sessionDescriptor == null || sessionDescriptor.windowSequenceNumber != eventTime.mediaPeriodId.windowSequenceNumber || sessionDescriptor.adMediaPeriodId == null || sessionDescriptor.adMediaPeriodId.adGroupIndex != eventTime.mediaPeriodId.adGroupIndex || sessionDescriptor.adMediaPeriodId.adIndexInAdGroup != eventTime.mediaPeriodId.adIndexInAdGroup)) {
                MediaSource.MediaPeriodId mediaPeriodId2 = eventTime.mediaPeriodId;
                SessionDescriptor orAddSession2 = getOrAddSession(eventTime.windowIndex, new MediaSource.MediaPeriodId(mediaPeriodId2.periodUid, mediaPeriodId2.windowSequenceNumber));
                if (orAddSession2.isCreated && orAddSession.isCreated) {
                    this.listener.onAdPlaybackStarted(eventTime, orAddSession2.sessionId, orAddSession.sessionId);
                }
            }
        } catch (Throwable th) {
            throw th;
        }
    }

    private SessionDescriptor getOrAddSession(int windowIndex, MediaSource.MediaPeriodId mediaPeriodId) {
        SessionDescriptor sessionDescriptor = null;
        long j = Long.MAX_VALUE;
        for (SessionDescriptor sessionDescriptor2 : this.sessions.values()) {
            sessionDescriptor2.maybeSetWindowSequenceNumber(windowIndex, mediaPeriodId);
            if (sessionDescriptor2.belongsToSession(windowIndex, mediaPeriodId)) {
                long j2 = sessionDescriptor2.windowSequenceNumber;
                if (j2 == -1 || j2 < j) {
                    sessionDescriptor = sessionDescriptor2;
                    j = j2;
                } else if (j2 == j && ((SessionDescriptor) Util.castNonNull(sessionDescriptor)).adMediaPeriodId != null && sessionDescriptor2.adMediaPeriodId != null) {
                    sessionDescriptor = sessionDescriptor2;
                }
            }
        }
        if (sessionDescriptor != null) {
            return sessionDescriptor;
        }
        String str = this.sessionIdGenerator.get();
        SessionDescriptor sessionDescriptor3 = new SessionDescriptor(str, windowIndex, mediaPeriodId);
        this.sessions.put(str, sessionDescriptor3);
        return sessionDescriptor3;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static String generateDefaultSessionId() {
        byte[] bArr = new byte[12];
        RANDOM.nextBytes(bArr);
        return Base64.encodeToString(bArr, 10);
    }

    private final class SessionDescriptor {
        private MediaSource.MediaPeriodId adMediaPeriodId;
        private boolean isActive;
        private boolean isCreated;
        private final String sessionId;
        private int windowIndex;
        private long windowSequenceNumber;

        public SessionDescriptor(String sessionId, int windowIndex, MediaSource.MediaPeriodId mediaPeriodId) {
            this.sessionId = sessionId;
            this.windowIndex = windowIndex;
            this.windowSequenceNumber = mediaPeriodId == null ? -1L : mediaPeriodId.windowSequenceNumber;
            if (mediaPeriodId == null || !mediaPeriodId.isAd()) {
                return;
            }
            this.adMediaPeriodId = mediaPeriodId;
        }

        public boolean tryResolvingToNewTimeline(Timeline oldTimeline, Timeline newTimeline) {
            int iResolveWindowIndexToNewTimeline = resolveWindowIndexToNewTimeline(oldTimeline, newTimeline, this.windowIndex);
            this.windowIndex = iResolveWindowIndexToNewTimeline;
            if (iResolveWindowIndexToNewTimeline == -1) {
                return false;
            }
            MediaSource.MediaPeriodId mediaPeriodId = this.adMediaPeriodId;
            return mediaPeriodId == null || newTimeline.getIndexOfPeriod(mediaPeriodId.periodUid) != -1;
        }

        public boolean belongsToSession(int eventWindowIndex, MediaSource.MediaPeriodId eventMediaPeriodId) {
            if (eventMediaPeriodId == null) {
                return eventWindowIndex == this.windowIndex;
            }
            MediaSource.MediaPeriodId mediaPeriodId = this.adMediaPeriodId;
            return mediaPeriodId == null ? !eventMediaPeriodId.isAd() && eventMediaPeriodId.windowSequenceNumber == this.windowSequenceNumber : eventMediaPeriodId.windowSequenceNumber == mediaPeriodId.windowSequenceNumber && eventMediaPeriodId.adGroupIndex == mediaPeriodId.adGroupIndex && eventMediaPeriodId.adIndexInAdGroup == mediaPeriodId.adIndexInAdGroup;
        }

        public void maybeSetWindowSequenceNumber(int eventWindowIndex, MediaSource.MediaPeriodId eventMediaPeriodId) {
            if (this.windowSequenceNumber == -1 && eventWindowIndex == this.windowIndex && eventMediaPeriodId != null) {
                this.windowSequenceNumber = eventMediaPeriodId.windowSequenceNumber;
            }
        }

        public boolean isFinishedAtEventTime(AnalyticsListener.EventTime eventTime) {
            long j = this.windowSequenceNumber;
            if (j == -1) {
                return false;
            }
            MediaSource.MediaPeriodId mediaPeriodId = eventTime.mediaPeriodId;
            if (mediaPeriodId == null) {
                return this.windowIndex != eventTime.windowIndex;
            }
            if (mediaPeriodId.windowSequenceNumber > j) {
                return true;
            }
            if (this.adMediaPeriodId == null) {
                return false;
            }
            int indexOfPeriod = eventTime.timeline.getIndexOfPeriod(mediaPeriodId.periodUid);
            int indexOfPeriod2 = eventTime.timeline.getIndexOfPeriod(this.adMediaPeriodId.periodUid);
            MediaSource.MediaPeriodId mediaPeriodId2 = eventTime.mediaPeriodId;
            if (mediaPeriodId2.windowSequenceNumber < this.adMediaPeriodId.windowSequenceNumber || indexOfPeriod < indexOfPeriod2) {
                return false;
            }
            if (indexOfPeriod > indexOfPeriod2) {
                return true;
            }
            if (mediaPeriodId2.isAd()) {
                MediaSource.MediaPeriodId mediaPeriodId3 = eventTime.mediaPeriodId;
                int i = mediaPeriodId3.adGroupIndex;
                int i2 = mediaPeriodId3.adIndexInAdGroup;
                MediaSource.MediaPeriodId mediaPeriodId4 = this.adMediaPeriodId;
                int i3 = mediaPeriodId4.adGroupIndex;
                return i > i3 || (i == i3 && i2 > mediaPeriodId4.adIndexInAdGroup);
            }
            int i4 = eventTime.mediaPeriodId.nextAdGroupIndex;
            return i4 == -1 || i4 > this.adMediaPeriodId.adGroupIndex;
        }

        private int resolveWindowIndexToNewTimeline(Timeline oldTimeline, Timeline newTimeline, int windowIndex) {
            if (windowIndex < oldTimeline.getWindowCount()) {
                oldTimeline.getWindow(windowIndex, DefaultPlaybackSessionManager.this.window);
                for (int i = DefaultPlaybackSessionManager.this.window.firstPeriodIndex; i <= DefaultPlaybackSessionManager.this.window.lastPeriodIndex; i++) {
                    int indexOfPeriod = newTimeline.getIndexOfPeriod(oldTimeline.getUidOfPeriod(i));
                    if (indexOfPeriod != -1) {
                        return newTimeline.getPeriod(indexOfPeriod, DefaultPlaybackSessionManager.this.period).windowIndex;
                    }
                }
                return -1;
            }
            if (windowIndex < newTimeline.getWindowCount()) {
                return windowIndex;
            }
            return -1;
        }
    }
}

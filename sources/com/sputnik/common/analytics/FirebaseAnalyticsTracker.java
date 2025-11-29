package com.sputnik.common.analytics;

import com.sputnik.common.analytics.AnalyticsTracker;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

/* compiled from: FirebaseAnalyticsTracker.kt */
@Metadata(d1 = {"\u0000\u0018\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\u0018\u00002\u00020\u0001B\u0007\b\u0007¢\u0006\u0002\u0010\u0002J\u0010\u0010\u0003\u001a\u00020\u00042\u0006\u0010\u0005\u001a\u00020\u0006H\u0016¨\u0006\u0007"}, d2 = {"Lcom/sputnik/common/analytics/FirebaseAnalyticsTracker;", "Lcom/sputnik/common/analytics/AnalyticsTracker;", "()V", "trackEvent", "", "event", "Lcom/sputnik/common/analytics/AnalyticsTracker$Event;", "common_release"}, k = 1, mv = {1, 9, 0}, xi = 48)
/* loaded from: classes3.dex */
public final class FirebaseAnalyticsTracker implements AnalyticsTracker {
    @Override // com.sputnik.common.analytics.AnalyticsTracker
    public void trackEvent(AnalyticsTracker.Event event) {
        Intrinsics.checkNotNullParameter(event, "event");
    }

    @Override // com.sputnik.common.analytics.AnalyticsTracker
    public void trackEventWithNewWay(AnalyticsTracker.EventWithMap eventWithMap) {
        AnalyticsTracker.DefaultImpls.trackEventWithNewWay(this, eventWithMap);
    }
}

package com.sputnik.common.analytics;

import com.google.android.gms.measurement.api.AppMeasurementSdk;
import java.util.Map;
import kotlin.Metadata;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;

/* compiled from: AnalyticsTracker.kt */
@Metadata(d1 = {"\u0000\u001e\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\bf\u0018\u00002\u00020\u0001:\u0002\b\tJ\u0010\u0010\u0002\u001a\u00020\u00032\u0006\u0010\u0004\u001a\u00020\u0005H&J\u0010\u0010\u0006\u001a\u00020\u00032\u0006\u0010\u0004\u001a\u00020\u0007H\u0016¨\u0006\n"}, d2 = {"Lcom/sputnik/common/analytics/AnalyticsTracker;", "", "trackEvent", "", "event", "Lcom/sputnik/common/analytics/AnalyticsTracker$Event;", "trackEventWithNewWay", "Lcom/sputnik/common/analytics/AnalyticsTracker$EventWithMap;", "Event", "EventWithMap", "common_release"}, k = 1, mv = {1, 9, 0}, xi = 48)
/* loaded from: classes3.dex */
public interface AnalyticsTracker {

    /* compiled from: AnalyticsTracker.kt */
    @Metadata(k = 3, mv = {1, 9, 0}, xi = 48)
    public static final class DefaultImpls {
        public static void trackEventWithNewWay(AnalyticsTracker analyticsTracker, EventWithMap event) {
            Intrinsics.checkNotNullParameter(event, "event");
        }
    }

    void trackEvent(Event event);

    void trackEventWithNewWay(EventWithMap event);

    /* compiled from: AnalyticsTracker.kt */
    @Metadata(d1 = {"\u0000\u0012\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\u000e\n\u0002\b\b\b\u0016\u0018\u00002\u00020\u0001B!\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\u0006\u0010\u0004\u001a\u00020\u0003\u0012\n\b\u0002\u0010\u0005\u001a\u0004\u0018\u00010\u0003¢\u0006\u0002\u0010\u0006R\u0011\u0010\u0002\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u0007\u0010\bR\u0011\u0010\u0004\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\t\u0010\bR\u0013\u0010\u0005\u001a\u0004\u0018\u00010\u0003¢\u0006\b\n\u0000\u001a\u0004\b\n\u0010\b¨\u0006\u000b"}, d2 = {"Lcom/sputnik/common/analytics/AnalyticsTracker$Event;", "", "category", "", AppMeasurementSdk.ConditionalUserProperty.NAME, AppMeasurementSdk.ConditionalUserProperty.VALUE, "(Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;)V", "getCategory", "()Ljava/lang/String;", "getName", "getValue", "common_release"}, k = 1, mv = {1, 9, 0}, xi = 48)
    public static class Event {
        private final String category;
        private final String name;
        private final String value;

        public Event(String category, String name, String str) {
            Intrinsics.checkNotNullParameter(category, "category");
            Intrinsics.checkNotNullParameter(name, "name");
            this.category = category;
            this.name = name;
            this.value = str;
        }

        public /* synthetic */ Event(String str, String str2, String str3, int i, DefaultConstructorMarker defaultConstructorMarker) {
            this(str, str2, (i & 4) != 0 ? null : str3);
        }

        public final String getCategory() {
            return this.category;
        }

        public final String getName() {
            return this.name;
        }

        public final String getValue() {
            return this.value;
        }
    }

    /* compiled from: AnalyticsTracker.kt */
    @Metadata(d1 = {"\u0000\u0018\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010$\n\u0002\b\u0006\b\u0016\u0018\u00002\u00020\u0001B#\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\u0014\b\u0002\u0010\u0004\u001a\u000e\u0012\u0004\u0012\u00020\u0003\u0012\u0004\u0012\u00020\u00010\u0005¢\u0006\u0002\u0010\u0006R\u001d\u0010\u0004\u001a\u000e\u0012\u0004\u0012\u00020\u0003\u0012\u0004\u0012\u00020\u00010\u0005¢\u0006\b\n\u0000\u001a\u0004\b\u0007\u0010\bR\u0011\u0010\u0002\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\t\u0010\n¨\u0006\u000b"}, d2 = {"Lcom/sputnik/common/analytics/AnalyticsTracker$EventWithMap;", "", AppMeasurementSdk.ConditionalUserProperty.NAME, "", "map", "", "(Ljava/lang/String;Ljava/util/Map;)V", "getMap", "()Ljava/util/Map;", "getName", "()Ljava/lang/String;", "common_release"}, k = 1, mv = {1, 9, 0}, xi = 48)
    public static class EventWithMap {
        private final Map<String, Object> map;
        private final String name;

        public EventWithMap(String name, Map<String, ? extends Object> map) {
            Intrinsics.checkNotNullParameter(name, "name");
            Intrinsics.checkNotNullParameter(map, "map");
            this.name = name;
            this.map = map;
        }

        public final String getName() {
            return this.name;
        }

        public final Map<String, Object> getMap() {
            return this.map;
        }
    }
}

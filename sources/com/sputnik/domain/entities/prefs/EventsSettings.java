package com.sputnik.domain.entities.prefs;

import com.huawei.hms.framework.common.hianalytics.CrashHianalyticsData;
import java.util.LinkedHashMap;
import java.util.Map;
import kotlin.Metadata;
import kotlin.collections.MapsKt;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;

/* compiled from: EventsSettings.kt */
@Metadata(d1 = {"\u0000(\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0010%\n\u0002\u0010\u000e\n\u0002\u0010\t\n\u0002\b\u000f\n\u0002\u0010\b\n\u0002\b\u0003\n\u0002\u0010\u000b\n\u0002\b\u0006\b\u0086\b\u0018\u00002\u00020\u0001B\u001d\u0012\u0014\b\u0002\u0010\u0005\u001a\u000e\u0012\u0004\u0012\u00020\u0003\u0012\u0004\u0012\u00020\u00040\u0002¢\u0006\u0004\b\u0006\u0010\u0007J/\u0010\f\u001a\u00020\u00002\u0006\u0010\b\u001a\u00020\u00032\u0006\u0010\t\u001a\u00020\u00032\u0006\u0010\n\u001a\u00020\u00032\b\b\u0002\u0010\u000b\u001a\u00020\u0004¢\u0006\u0004\b\f\u0010\rJ%\u0010\u000e\u001a\u00020\u00042\u0006\u0010\b\u001a\u00020\u00032\u0006\u0010\n\u001a\u00020\u00032\u0006\u0010\t\u001a\u00020\u0003¢\u0006\u0004\b\u000e\u0010\u000fJ&\u0010\u0010\u001a\u00020\u00002\u0014\b\u0002\u0010\u0005\u001a\u000e\u0012\u0004\u0012\u00020\u0003\u0012\u0004\u0012\u00020\u00040\u0002HÆ\u0001¢\u0006\u0004\b\u0010\u0010\u0011J\u0010\u0010\u0012\u001a\u00020\u0003HÖ\u0001¢\u0006\u0004\b\u0012\u0010\u0013J\u0010\u0010\u0015\u001a\u00020\u0014HÖ\u0001¢\u0006\u0004\b\u0015\u0010\u0016J\u001a\u0010\u0019\u001a\u00020\u00182\b\u0010\u0017\u001a\u0004\u0018\u00010\u0001HÖ\u0003¢\u0006\u0004\b\u0019\u0010\u001aR#\u0010\u0005\u001a\u000e\u0012\u0004\u0012\u00020\u0003\u0012\u0004\u0012\u00020\u00040\u00028\u0006¢\u0006\f\n\u0004\b\u0005\u0010\u001b\u001a\u0004\b\u001c\u0010\u001d¨\u0006\u001e"}, d2 = {"Lcom/sputnik/domain/entities/prefs/EventsSettings;", "", "", "", "", "lastClickMap", "<init>", "(Ljava/util/Map;)V", "accountId", "deviceId", "eventType", CrashHianalyticsData.TIME, "setLastClick", "(Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;J)Lcom/sputnik/domain/entities/prefs/EventsSettings;", "getLastClick", "(Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;)J", "copy", "(Ljava/util/Map;)Lcom/sputnik/domain/entities/prefs/EventsSettings;", "toString", "()Ljava/lang/String;", "", "hashCode", "()I", "other", "", "equals", "(Ljava/lang/Object;)Z", "Ljava/util/Map;", "getLastClickMap", "()Ljava/util/Map;", "domain"}, k = 1, mv = {1, 9, 0}, xi = 48)
/* loaded from: classes3.dex */
public final /* data */ class EventsSettings {
    private final Map<String, Long> lastClickMap;

    public EventsSettings() {
        this(null, 1, 0 == true ? 1 : 0);
    }

    public final EventsSettings copy(Map<String, Long> lastClickMap) {
        Intrinsics.checkNotNullParameter(lastClickMap, "lastClickMap");
        return new EventsSettings(lastClickMap);
    }

    public boolean equals(Object other) {
        if (this == other) {
            return true;
        }
        return (other instanceof EventsSettings) && Intrinsics.areEqual(this.lastClickMap, ((EventsSettings) other).lastClickMap);
    }

    public int hashCode() {
        return this.lastClickMap.hashCode();
    }

    public String toString() {
        return "EventsSettings(lastClickMap=" + this.lastClickMap + ")";
    }

    public EventsSettings(Map<String, Long> lastClickMap) {
        Intrinsics.checkNotNullParameter(lastClickMap, "lastClickMap");
        this.lastClickMap = lastClickMap;
    }

    public /* synthetic */ EventsSettings(Map map, int i, DefaultConstructorMarker defaultConstructorMarker) {
        this((i & 1) != 0 ? new LinkedHashMap() : map);
    }

    public static /* synthetic */ EventsSettings setLastClick$default(EventsSettings eventsSettings, String str, String str2, String str3, long j, int i, Object obj) {
        if ((i & 8) != 0) {
            j = System.currentTimeMillis();
        }
        return eventsSettings.setLastClick(str, str2, str3, j);
    }

    public final EventsSettings setLastClick(String accountId, String deviceId, String eventType, long time) {
        Intrinsics.checkNotNullParameter(accountId, "accountId");
        Intrinsics.checkNotNullParameter(deviceId, "deviceId");
        Intrinsics.checkNotNullParameter(eventType, "eventType");
        String str = accountId + "_" + deviceId + "_" + eventType;
        Map<String, Long> mutableMap = MapsKt.toMutableMap(this.lastClickMap);
        mutableMap.put(str, Long.valueOf(time));
        return copy(mutableMap);
    }

    public final long getLastClick(String accountId, String eventType, String deviceId) {
        Intrinsics.checkNotNullParameter(accountId, "accountId");
        Intrinsics.checkNotNullParameter(eventType, "eventType");
        Intrinsics.checkNotNullParameter(deviceId, "deviceId");
        Long l = this.lastClickMap.get(accountId + "_" + deviceId + "_" + eventType);
        if (l != null) {
            return l.longValue();
        }
        return 0L;
    }
}

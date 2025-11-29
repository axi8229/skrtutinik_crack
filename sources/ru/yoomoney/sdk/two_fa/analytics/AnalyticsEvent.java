package ru.yoomoney.sdk.two_fa.analytics;

import java.util.Map;
import kotlin.Metadata;
import kotlin.jvm.internal.DefaultConstructorMarker;

/* compiled from: AnalyticsEvent.kt */
@Metadata(d1 = {"\u0000&\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010$\n\u0002\b\u0006\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\b7\u0018\u00002\u00020\u0001B'\b\u0004\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\u0016\b\u0002\u0010\u0004\u001a\u0010\u0012\u0004\u0012\u00020\u0003\u0012\u0004\u0012\u00020\u0003\u0018\u00010\u0005¢\u0006\u0002\u0010\u0006J\b\u0010\u000b\u001a\u00020\u0003H\u0016R\u0011\u0010\u0002\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u0007\u0010\bR\u001f\u0010\u0004\u001a\u0010\u0012\u0004\u0012\u00020\u0003\u0012\u0004\u0012\u00020\u0003\u0018\u00010\u0005¢\u0006\b\n\u0000\u001a\u0004\b\t\u0010\n\u0082\u0001\u0003\f\r\u000e¨\u0006\u000f"}, d2 = {"Lru/yoomoney/sdk/two_fa/analytics/AnalyticsEvent;", "", "eventName", "", "params", "", "(Ljava/lang/String;Ljava/util/Map;)V", "getEventName", "()Ljava/lang/String;", "getParams", "()Ljava/util/Map;", "toString", "Lru/yoomoney/sdk/two_fa/analytics/RegistrationEnterCallCode;", "Lru/yoomoney/sdk/two_fa/analytics/RegistrationEnterEmailCode;", "Lru/yoomoney/sdk/two_fa/analytics/RegistrationEnterSmsCode;", "two-fa_release"}, k = 1, mv = {1, 9, 0}, xi = 48)
/* loaded from: classes5.dex */
public abstract class AnalyticsEvent {
    public static final int $stable = 8;
    private final String eventName;
    private final Map<String, String> params;

    public /* synthetic */ AnalyticsEvent(String str, Map map, DefaultConstructorMarker defaultConstructorMarker) {
        this(str, map);
    }

    private AnalyticsEvent(String str, Map<String, String> map) {
        this.eventName = str;
        this.params = map;
    }

    public /* synthetic */ AnalyticsEvent(String str, Map map, int i, DefaultConstructorMarker defaultConstructorMarker) {
        this(str, (i & 2) != 0 ? null : map, null);
    }

    public final String getEventName() {
        return this.eventName;
    }

    public final Map<String, String> getParams() {
        return this.params;
    }

    public String toString() {
        Object objEntrySet;
        String str = this.eventName;
        Map<String, String> map = this.params;
        if (map == null || (objEntrySet = map.entrySet()) == null) {
            objEntrySet = "";
        }
        return str + " " + objEntrySet;
    }
}

package com.sputnik.common.analytics;

import android.util.Log;
import com.huawei.hms.framework.common.ContainerUtils;
import com.sputnik.common.analytics.AnalyticsTracker;
import com.sputnik.common.utils.LogUtilsKt;
import java.util.Iterator;
import java.util.Map;
import java.util.Set;
import kotlin.Metadata;
import kotlin.collections.CollectionsKt;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.Intrinsics;

/* compiled from: Analytics.kt */
@Metadata(d1 = {"\u0000*\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0010\"\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0004\b\u0007\u0018\u00002\u00020\u0001B\u0017\b\u0007\u0012\f\u0010\u0004\u001a\b\u0012\u0004\u0012\u00020\u00030\u0002¢\u0006\u0004\b\u0005\u0010\u0006J\u0015\u0010\n\u001a\u00020\t2\u0006\u0010\b\u001a\u00020\u0007¢\u0006\u0004\b\n\u0010\u000bJ\u0015\u0010\r\u001a\u00020\t2\u0006\u0010\b\u001a\u00020\f¢\u0006\u0004\b\r\u0010\u000eR\u001a\u0010\u0004\u001a\b\u0012\u0004\u0012\u00020\u00030\u00028\u0002X\u0082\u0004¢\u0006\u0006\n\u0004\b\u0004\u0010\u000f¨\u0006\u0010"}, d2 = {"Lcom/sputnik/common/analytics/Analytics;", "", "", "Lcom/sputnik/common/analytics/AnalyticsTracker;", "trackers", "<init>", "(Ljava/util/Set;)V", "Lcom/sputnik/common/analytics/AnalyticsTracker$Event;", "event", "", "trackLogEvent", "(Lcom/sputnik/common/analytics/AnalyticsTracker$Event;)V", "Lcom/sputnik/common/analytics/AnalyticsTracker$EventWithMap;", "trackNewEvent", "(Lcom/sputnik/common/analytics/AnalyticsTracker$EventWithMap;)V", "Ljava/util/Set;", "common_release"}, k = 1, mv = {1, 9, 0}, xi = 48)
/* loaded from: classes3.dex */
public final class Analytics {
    private final Set<AnalyticsTracker> trackers;

    public Analytics(Set<AnalyticsTracker> trackers) {
        Intrinsics.checkNotNullParameter(trackers, "trackers");
        this.trackers = trackers;
        Log.e("DAGGER", "Analytics");
    }

    public final void trackLogEvent(AnalyticsTracker.Event event) {
        Intrinsics.checkNotNullParameter(event, "event");
        LogUtilsKt.writeLog("Event", event.getCategory() + "-" + event.getName() + "-" + event.getValue());
        Iterator<T> it = this.trackers.iterator();
        while (it.hasNext()) {
            ((AnalyticsTracker) it.next()).trackEvent(event);
        }
    }

    public final void trackNewEvent(AnalyticsTracker.EventWithMap event) {
        Intrinsics.checkNotNullParameter(event, "event");
        String strJoinToString$default = CollectionsKt.joinToString$default(event.getMap().entrySet(), ", ", null, null, 0, null, new Function1<Map.Entry<? extends String, ? extends Object>, CharSequence>() { // from class: com.sputnik.common.analytics.Analytics$trackNewEvent$paramsString$1
            /* renamed from: invoke, reason: avoid collision after fix types in other method */
            public final CharSequence invoke2(Map.Entry<String, ? extends Object> it) {
                Intrinsics.checkNotNullParameter(it, "it");
                String key = it.getKey();
                return ((Object) key) + ContainerUtils.KEY_VALUE_DELIMITER + it.getValue();
            }

            @Override // kotlin.jvm.functions.Function1
            public /* bridge */ /* synthetic */ CharSequence invoke(Map.Entry<? extends String, ? extends Object> entry) {
                return invoke2((Map.Entry<String, ? extends Object>) entry);
            }
        }, 30, null);
        LogUtilsKt.writeLog("Event", event.getName() + " - params: {" + strJoinToString$default + "}");
        Iterator<T> it = this.trackers.iterator();
        while (it.hasNext()) {
            ((AnalyticsTracker) it.next()).trackEventWithNewWay(event);
        }
    }
}

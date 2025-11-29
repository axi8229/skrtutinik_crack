package com.sputnik.common.analytics;

import com.google.android.gms.measurement.api.AppMeasurementSdk;
import com.sputnik.common.analytics.AnalyticsTracker;
import java.util.Map;
import kotlin.Metadata;
import kotlin.TuplesKt;
import kotlin.collections.MapsKt;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;

/* compiled from: SupportNewEvents.kt */
@Metadata(d1 = {"\u0000\"\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010$\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\b6\u0018\u00002\u00020\u0001:\u0002\u0007\bB#\b\u0004\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\u0012\u0010\u0004\u001a\u000e\u0012\u0004\u0012\u00020\u0003\u0012\u0004\u0012\u00020\u00030\u0005¢\u0006\u0002\u0010\u0006\u0082\u0001\u0002\t\n¨\u0006\u000b"}, d2 = {"Lcom/sputnik/common/analytics/SupportNewEvents;", "Lcom/sputnik/common/analytics/AnalyticsTracker$EventWithMap;", AppMeasurementSdk.ConditionalUserProperty.NAME, "", "map", "", "(Ljava/lang/String;Ljava/util/Map;)V", "ClickSupportCategory", "ClickSupportSubcategory", "Lcom/sputnik/common/analytics/SupportNewEvents$ClickSupportCategory;", "Lcom/sputnik/common/analytics/SupportNewEvents$ClickSupportSubcategory;", "common_release"}, k = 1, mv = {1, 9, 0}, xi = 48)
/* loaded from: classes3.dex */
public abstract class SupportNewEvents extends AnalyticsTracker.EventWithMap {
    public /* synthetic */ SupportNewEvents(String str, Map map, DefaultConstructorMarker defaultConstructorMarker) {
        this(str, map);
    }

    private SupportNewEvents(String str, Map<String, String> map) {
        super(str, map);
    }

    /* compiled from: SupportNewEvents.kt */
    @Metadata(d1 = {"\u0000\u0012\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0002\u0018\u00002\u00020\u0001B\r\u0012\u0006\u0010\u0002\u001a\u00020\u0003¢\u0006\u0002\u0010\u0004¨\u0006\u0005"}, d2 = {"Lcom/sputnik/common/analytics/SupportNewEvents$ClickSupportCategory;", "Lcom/sputnik/common/analytics/SupportNewEvents;", "id", "", "(Ljava/lang/String;)V", "common_release"}, k = 1, mv = {1, 9, 0}, xi = 48)
    public static final class ClickSupportCategory extends SupportNewEvents {
        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        public ClickSupportCategory(String id) {
            super("clickFaqCategory", MapsKt.mapOf(TuplesKt.to("id", id)), null);
            Intrinsics.checkNotNullParameter(id, "id");
        }
    }

    /* compiled from: SupportNewEvents.kt */
    @Metadata(d1 = {"\u0000\u0012\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0002\u0018\u00002\u00020\u0001B\r\u0012\u0006\u0010\u0002\u001a\u00020\u0003¢\u0006\u0002\u0010\u0004¨\u0006\u0005"}, d2 = {"Lcom/sputnik/common/analytics/SupportNewEvents$ClickSupportSubcategory;", "Lcom/sputnik/common/analytics/SupportNewEvents;", "id", "", "(Ljava/lang/String;)V", "common_release"}, k = 1, mv = {1, 9, 0}, xi = 48)
    public static final class ClickSupportSubcategory extends SupportNewEvents {
        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        public ClickSupportSubcategory(String id) {
            super("clickFaqSubcategory", MapsKt.mapOf(TuplesKt.to("id", id)), null);
            Intrinsics.checkNotNullParameter(id, "id");
        }
    }
}

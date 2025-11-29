package com.sputnik.subscriptions.analytics;

import com.google.android.gms.measurement.api.AppMeasurementSdk;
import com.sputnik.common.analytics.AnalyticsTracker;
import java.util.Map;
import kotlin.Metadata;
import kotlin.TuplesKt;
import kotlin.collections.MapsKt;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;

/* compiled from: NewSubscriptionsEvents.kt */
@Metadata(d1 = {"\u0000\u001e\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010$\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\b6\u0018\u00002\u00020\u0001:\u0001\u0007B#\b\u0004\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\u0012\u0010\u0004\u001a\u000e\u0012\u0004\u0012\u00020\u0003\u0012\u0004\u0012\u00020\u00030\u0005¢\u0006\u0002\u0010\u0006\u0082\u0001\u0001\b¨\u0006\t"}, d2 = {"Lcom/sputnik/subscriptions/analytics/NewSubscriptionsEvents;", "Lcom/sputnik/common/analytics/AnalyticsTracker$EventWithMap;", AppMeasurementSdk.ConditionalUserProperty.NAME, "", "map", "", "(Ljava/lang/String;Ljava/util/Map;)V", "StateSuccessSubscriptionPurchase", "Lcom/sputnik/subscriptions/analytics/NewSubscriptionsEvents$StateSuccessSubscriptionPurchase;", "subscriptions_release"}, k = 1, mv = {1, 9, 0}, xi = 48)
/* loaded from: classes3.dex */
public abstract class NewSubscriptionsEvents extends AnalyticsTracker.EventWithMap {
    public /* synthetic */ NewSubscriptionsEvents(String str, Map map, DefaultConstructorMarker defaultConstructorMarker) {
        this(str, map);
    }

    private NewSubscriptionsEvents(String str, Map<String, String> map) {
        super(str, map);
    }

    /* compiled from: NewSubscriptionsEvents.kt */
    @Metadata(d1 = {"\u0000\u0012\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0004\u0018\u00002\u00020\u0001B\u001d\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\u0006\u0010\u0004\u001a\u00020\u0003\u0012\u0006\u0010\u0005\u001a\u00020\u0003¢\u0006\u0002\u0010\u0006¨\u0006\u0007"}, d2 = {"Lcom/sputnik/subscriptions/analytics/NewSubscriptionsEvents$StateSuccessSubscriptionPurchase;", "Lcom/sputnik/subscriptions/analytics/NewSubscriptionsEvents;", "paymentMethod", "", "subscriptionIdentifier", "price", "(Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;)V", "subscriptions_release"}, k = 1, mv = {1, 9, 0}, xi = 48)
    public static final class StateSuccessSubscriptionPurchase extends NewSubscriptionsEvents {
        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        public StateSuccessSubscriptionPurchase(String paymentMethod, String subscriptionIdentifier, String price) {
            super("stateSuccessSubscriptionPurchase", MapsKt.mapOf(TuplesKt.to("payment_method", paymentMethod), TuplesKt.to("subscription_identifier", subscriptionIdentifier), TuplesKt.to("price", price)), null);
            Intrinsics.checkNotNullParameter(paymentMethod, "paymentMethod");
            Intrinsics.checkNotNullParameter(subscriptionIdentifier, "subscriptionIdentifier");
            Intrinsics.checkNotNullParameter(price, "price");
        }
    }
}

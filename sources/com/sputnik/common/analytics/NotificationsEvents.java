package com.sputnik.common.analytics;

import com.google.android.gms.measurement.api.AppMeasurementSdk;
import com.sputnik.common.analytics.AnalyticsTracker;
import kotlin.Metadata;
import kotlin.jvm.internal.DefaultConstructorMarker;

/* compiled from: NotificationsEvents.kt */
@Metadata(d1 = {"\u0000\u001c\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\b6\u0018\u00002\u00020\u0001:\u0002\u0006\u0007B\u001b\b\u0004\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\n\b\u0002\u0010\u0004\u001a\u0004\u0018\u00010\u0003¢\u0006\u0002\u0010\u0005\u0082\u0001\u0002\b\t¨\u0006\n"}, d2 = {"Lcom/sputnik/common/analytics/NotificationsEvents;", "Lcom/sputnik/common/analytics/AnalyticsTracker$Event;", AppMeasurementSdk.ConditionalUserProperty.NAME, "", AppMeasurementSdk.ConditionalUserProperty.VALUE, "(Ljava/lang/String;Ljava/lang/String;)V", "ClickBtnFromNotificationsTransitionMarketStandart", "ClickNotificationPromo1rubTrial", "Lcom/sputnik/common/analytics/NotificationsEvents$ClickBtnFromNotificationsTransitionMarketStandart;", "Lcom/sputnik/common/analytics/NotificationsEvents$ClickNotificationPromo1rubTrial;", "common_release"}, k = 1, mv = {1, 9, 0}, xi = 48)
/* loaded from: classes3.dex */
public abstract class NotificationsEvents extends AnalyticsTracker.Event {
    public /* synthetic */ NotificationsEvents(String str, String str2, DefaultConstructorMarker defaultConstructorMarker) {
        this(str, str2);
    }

    public /* synthetic */ NotificationsEvents(String str, String str2, int i, DefaultConstructorMarker defaultConstructorMarker) {
        this(str, (i & 2) != 0 ? null : str2, null);
    }

    private NotificationsEvents(String str, String str2) {
        super("Notifications", str, str2);
    }

    /* compiled from: NotificationsEvents.kt */
    @Metadata(d1 = {"\u0000\f\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\u0018\u00002\u00020\u0001B\u0005¢\u0006\u0002\u0010\u0002¨\u0006\u0003"}, d2 = {"Lcom/sputnik/common/analytics/NotificationsEvents$ClickBtnFromNotificationsTransitionMarketStandart;", "Lcom/sputnik/common/analytics/NotificationsEvents;", "()V", "common_release"}, k = 1, mv = {1, 9, 0}, xi = 48)
    public static final class ClickBtnFromNotificationsTransitionMarketStandart extends NotificationsEvents {
        public ClickBtnFromNotificationsTransitionMarketStandart() {
            super("clickBtnFromNotificationsTransitionMarketStandart", null, 2, 0 == true ? 1 : 0);
        }
    }

    /* compiled from: NotificationsEvents.kt */
    @Metadata(d1 = {"\u0000\f\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\u0018\u00002\u00020\u0001B\u0005¢\u0006\u0002\u0010\u0002¨\u0006\u0003"}, d2 = {"Lcom/sputnik/common/analytics/NotificationsEvents$ClickNotificationPromo1rubTrial;", "Lcom/sputnik/common/analytics/NotificationsEvents;", "()V", "common_release"}, k = 1, mv = {1, 9, 0}, xi = 48)
    public static final class ClickNotificationPromo1rubTrial extends NotificationsEvents {
        public ClickNotificationPromo1rubTrial() {
            super("clickNotificationPromo1rubTrial", null, 2, 0 == true ? 1 : 0);
        }
    }
}

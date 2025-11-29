package com.sputnik.subscriptions.analytics;

import com.google.android.gms.measurement.api.AppMeasurementSdk;
import com.sputnik.common.analytics.AnalyticsTracker;
import kotlin.Metadata;
import kotlin.jvm.internal.DefaultConstructorMarker;

/* compiled from: OnlySubscriptionEvents.kt */
@Metadata(d1 = {"\u0000@\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0002\b\r\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\b6\u0018\u00002\u00020\u0001:\u000b\u0006\u0007\b\t\n\u000b\f\r\u000e\u000f\u0010B\u001b\b\u0004\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\n\b\u0002\u0010\u0004\u001a\u0004\u0018\u00010\u0003¢\u0006\u0002\u0010\u0005\u0082\u0001\u000b\u0011\u0012\u0013\u0014\u0015\u0016\u0017\u0018\u0019\u001a\u001b¨\u0006\u001c"}, d2 = {"Lcom/sputnik/subscriptions/analytics/OnlySubscriptionEvents;", "Lcom/sputnik/common/analytics/AnalyticsTracker$Event;", AppMeasurementSdk.ConditionalUserProperty.NAME, "", AppMeasurementSdk.ConditionalUserProperty.VALUE, "(Ljava/lang/String;Ljava/lang/String;)V", "ClickAddNewTempCode", "ClickArchiveDownload", "ClickArchiveView", "ClickCallLog", "ClickCallLogEventArchive", "ClickDeleteCallLogEvent", "ClickDeleteTempCode", "ClickProfileArchive", "ClickRenewPermCode", "ClickRenewTempCode", "ClickShareTempCode", "Lcom/sputnik/subscriptions/analytics/OnlySubscriptionEvents$ClickAddNewTempCode;", "Lcom/sputnik/subscriptions/analytics/OnlySubscriptionEvents$ClickArchiveDownload;", "Lcom/sputnik/subscriptions/analytics/OnlySubscriptionEvents$ClickArchiveView;", "Lcom/sputnik/subscriptions/analytics/OnlySubscriptionEvents$ClickCallLog;", "Lcom/sputnik/subscriptions/analytics/OnlySubscriptionEvents$ClickCallLogEventArchive;", "Lcom/sputnik/subscriptions/analytics/OnlySubscriptionEvents$ClickDeleteCallLogEvent;", "Lcom/sputnik/subscriptions/analytics/OnlySubscriptionEvents$ClickDeleteTempCode;", "Lcom/sputnik/subscriptions/analytics/OnlySubscriptionEvents$ClickProfileArchive;", "Lcom/sputnik/subscriptions/analytics/OnlySubscriptionEvents$ClickRenewPermCode;", "Lcom/sputnik/subscriptions/analytics/OnlySubscriptionEvents$ClickRenewTempCode;", "Lcom/sputnik/subscriptions/analytics/OnlySubscriptionEvents$ClickShareTempCode;", "subscriptions_release"}, k = 1, mv = {1, 9, 0}, xi = 48)
/* loaded from: classes3.dex */
public abstract class OnlySubscriptionEvents extends AnalyticsTracker.Event {
    public /* synthetic */ OnlySubscriptionEvents(String str, String str2, DefaultConstructorMarker defaultConstructorMarker) {
        this(str, str2);
    }

    public /* synthetic */ OnlySubscriptionEvents(String str, String str2, int i, DefaultConstructorMarker defaultConstructorMarker) {
        this(str, (i & 2) != 0 ? null : str2, null);
    }

    private OnlySubscriptionEvents(String str, String str2) {
        super("subs_users_standard", str, str2);
    }

    /* compiled from: OnlySubscriptionEvents.kt */
    @Metadata(d1 = {"\u0000\f\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\u0018\u00002\u00020\u0001B\u0005¢\u0006\u0002\u0010\u0002¨\u0006\u0003"}, d2 = {"Lcom/sputnik/subscriptions/analytics/OnlySubscriptionEvents$ClickCallLog;", "Lcom/sputnik/subscriptions/analytics/OnlySubscriptionEvents;", "()V", "subscriptions_release"}, k = 1, mv = {1, 9, 0}, xi = 48)
    public static final class ClickCallLog extends OnlySubscriptionEvents {
        public ClickCallLog() {
            super("clickCallLogSubsOnly", null, 2, 0 == true ? 1 : 0);
        }
    }

    /* compiled from: OnlySubscriptionEvents.kt */
    @Metadata(d1 = {"\u0000\f\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\u0018\u00002\u00020\u0001B\u0005¢\u0006\u0002\u0010\u0002¨\u0006\u0003"}, d2 = {"Lcom/sputnik/subscriptions/analytics/OnlySubscriptionEvents$ClickDeleteCallLogEvent;", "Lcom/sputnik/subscriptions/analytics/OnlySubscriptionEvents;", "()V", "subscriptions_release"}, k = 1, mv = {1, 9, 0}, xi = 48)
    public static final class ClickDeleteCallLogEvent extends OnlySubscriptionEvents {
        public ClickDeleteCallLogEvent() {
            super("clickDeleteCallLogEvent", null, 2, 0 == true ? 1 : 0);
        }
    }

    /* compiled from: OnlySubscriptionEvents.kt */
    @Metadata(d1 = {"\u0000\f\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\u0018\u00002\u00020\u0001B\u0005¢\u0006\u0002\u0010\u0002¨\u0006\u0003"}, d2 = {"Lcom/sputnik/subscriptions/analytics/OnlySubscriptionEvents$ClickCallLogEventArchive;", "Lcom/sputnik/subscriptions/analytics/OnlySubscriptionEvents;", "()V", "subscriptions_release"}, k = 1, mv = {1, 9, 0}, xi = 48)
    public static final class ClickCallLogEventArchive extends OnlySubscriptionEvents {
        public ClickCallLogEventArchive() {
            super("clickCallLogEventArchiveSubsOnly", null, 2, 0 == true ? 1 : 0);
        }
    }

    /* compiled from: OnlySubscriptionEvents.kt */
    @Metadata(d1 = {"\u0000\f\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\u0018\u00002\u00020\u0001B\u0005¢\u0006\u0002\u0010\u0002¨\u0006\u0003"}, d2 = {"Lcom/sputnik/subscriptions/analytics/OnlySubscriptionEvents$ClickProfileArchive;", "Lcom/sputnik/subscriptions/analytics/OnlySubscriptionEvents;", "()V", "subscriptions_release"}, k = 1, mv = {1, 9, 0}, xi = 48)
    public static final class ClickProfileArchive extends OnlySubscriptionEvents {
        public ClickProfileArchive() {
            super("clickProfileArchiveSubsOnly", null, 2, 0 == true ? 1 : 0);
        }
    }

    /* compiled from: OnlySubscriptionEvents.kt */
    @Metadata(d1 = {"\u0000\f\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\u0018\u00002\u00020\u0001B\u0005¢\u0006\u0002\u0010\u0002¨\u0006\u0003"}, d2 = {"Lcom/sputnik/subscriptions/analytics/OnlySubscriptionEvents$ClickArchiveView;", "Lcom/sputnik/subscriptions/analytics/OnlySubscriptionEvents;", "()V", "subscriptions_release"}, k = 1, mv = {1, 9, 0}, xi = 48)
    public static final class ClickArchiveView extends OnlySubscriptionEvents {
        public ClickArchiveView() {
            super("clickArchiveViewSubsOnly", null, 2, 0 == true ? 1 : 0);
        }
    }

    /* compiled from: OnlySubscriptionEvents.kt */
    @Metadata(d1 = {"\u0000\f\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\u0018\u00002\u00020\u0001B\u0005¢\u0006\u0002\u0010\u0002¨\u0006\u0003"}, d2 = {"Lcom/sputnik/subscriptions/analytics/OnlySubscriptionEvents$ClickArchiveDownload;", "Lcom/sputnik/subscriptions/analytics/OnlySubscriptionEvents;", "()V", "subscriptions_release"}, k = 1, mv = {1, 9, 0}, xi = 48)
    public static final class ClickArchiveDownload extends OnlySubscriptionEvents {
        public ClickArchiveDownload() {
            super("clickArchiveDownloadSubsOnly", null, 2, 0 == true ? 1 : 0);
        }
    }

    /* compiled from: OnlySubscriptionEvents.kt */
    @Metadata(d1 = {"\u0000\f\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\u0018\u00002\u00020\u0001B\u0005¢\u0006\u0002\u0010\u0002¨\u0006\u0003"}, d2 = {"Lcom/sputnik/subscriptions/analytics/OnlySubscriptionEvents$ClickRenewPermCode;", "Lcom/sputnik/subscriptions/analytics/OnlySubscriptionEvents;", "()V", "subscriptions_release"}, k = 1, mv = {1, 9, 0}, xi = 48)
    public static final class ClickRenewPermCode extends OnlySubscriptionEvents {
        public ClickRenewPermCode() {
            super("clickRenewPermCode", null, 2, 0 == true ? 1 : 0);
        }
    }

    /* compiled from: OnlySubscriptionEvents.kt */
    @Metadata(d1 = {"\u0000\f\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\u0018\u00002\u00020\u0001B\u0005¢\u0006\u0002\u0010\u0002¨\u0006\u0003"}, d2 = {"Lcom/sputnik/subscriptions/analytics/OnlySubscriptionEvents$ClickAddNewTempCode;", "Lcom/sputnik/subscriptions/analytics/OnlySubscriptionEvents;", "()V", "subscriptions_release"}, k = 1, mv = {1, 9, 0}, xi = 48)
    public static final class ClickAddNewTempCode extends OnlySubscriptionEvents {
        public ClickAddNewTempCode() {
            super("clickAddNewTempCode", null, 2, 0 == true ? 1 : 0);
        }
    }

    /* compiled from: OnlySubscriptionEvents.kt */
    @Metadata(d1 = {"\u0000\f\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\u0018\u00002\u00020\u0001B\u0005¢\u0006\u0002\u0010\u0002¨\u0006\u0003"}, d2 = {"Lcom/sputnik/subscriptions/analytics/OnlySubscriptionEvents$ClickDeleteTempCode;", "Lcom/sputnik/subscriptions/analytics/OnlySubscriptionEvents;", "()V", "subscriptions_release"}, k = 1, mv = {1, 9, 0}, xi = 48)
    public static final class ClickDeleteTempCode extends OnlySubscriptionEvents {
        public ClickDeleteTempCode() {
            super("clickDeleteTempCode", null, 2, 0 == true ? 1 : 0);
        }
    }

    /* compiled from: OnlySubscriptionEvents.kt */
    @Metadata(d1 = {"\u0000\f\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\u0018\u00002\u00020\u0001B\u0005¢\u0006\u0002\u0010\u0002¨\u0006\u0003"}, d2 = {"Lcom/sputnik/subscriptions/analytics/OnlySubscriptionEvents$ClickShareTempCode;", "Lcom/sputnik/subscriptions/analytics/OnlySubscriptionEvents;", "()V", "subscriptions_release"}, k = 1, mv = {1, 9, 0}, xi = 48)
    public static final class ClickShareTempCode extends OnlySubscriptionEvents {
        public ClickShareTempCode() {
            super("clickShareTempCode", null, 2, 0 == true ? 1 : 0);
        }
    }

    /* compiled from: OnlySubscriptionEvents.kt */
    @Metadata(d1 = {"\u0000\f\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\u0018\u00002\u00020\u0001B\u0005¢\u0006\u0002\u0010\u0002¨\u0006\u0003"}, d2 = {"Lcom/sputnik/subscriptions/analytics/OnlySubscriptionEvents$ClickRenewTempCode;", "Lcom/sputnik/subscriptions/analytics/OnlySubscriptionEvents;", "()V", "subscriptions_release"}, k = 1, mv = {1, 9, 0}, xi = 48)
    public static final class ClickRenewTempCode extends OnlySubscriptionEvents {
        public ClickRenewTempCode() {
            super("clickRenewTempCode", null, 2, 0 == true ? 1 : 0);
        }
    }
}

package com.sputnik.common.analytics;

import com.google.android.gms.measurement.api.AppMeasurementSdk;
import com.sputnik.common.analytics.AnalyticsTracker;
import kotlin.Metadata;
import kotlin.jvm.internal.DefaultConstructorMarker;

/* compiled from: GeneralEvents.kt */
@Metadata(d1 = {"\u0000B\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u000e\n\u0002\b\u000e\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\b6\u0018\u00002\u00020\u0001:\n\u0007\b\t\n\u000b\f\r\u000e\u000f\u0010B\u001d\b\u0004\u0012\u0006\u0010\u0003\u001a\u00020\u0002\u0012\n\b\u0002\u0010\u0004\u001a\u0004\u0018\u00010\u0002¢\u0006\u0004\b\u0005\u0010\u0006\u0082\u0001\f\u0011\u0012\u0013\u0014\u0015\u0016\u0017\u0018\u0019\u001a\u001b\u001c¨\u0006\u001d"}, d2 = {"Lcom/sputnik/common/analytics/GeneralEvents;", "Lcom/sputnik/common/analytics/AnalyticsTracker$Event;", "", AppMeasurementSdk.ConditionalUserProperty.NAME, AppMeasurementSdk.ConditionalUserProperty.VALUE, "<init>", "(Ljava/lang/String;Ljava/lang/String;)V", "ClickArchiveFromHistory", "ClickBetaPromoBecomeATester", "ClickLogOutWhenBlocked", "ClickMarketRedDot", "ClickProfile", "ClickProfileBetaPromo", "ClickProfileNotifications", "ClickProfileNotificationsRedDot", "ClickWidgetOpen", "ViewCallLog", "Lcom/sputnik/common/analytics/ExperimentalEvents$ClickWebrtcOff;", "Lcom/sputnik/common/analytics/ExperimentalEvents$ClickWebrtcOn;", "Lcom/sputnik/common/analytics/GeneralEvents$ClickArchiveFromHistory;", "Lcom/sputnik/common/analytics/GeneralEvents$ClickBetaPromoBecomeATester;", "Lcom/sputnik/common/analytics/GeneralEvents$ClickLogOutWhenBlocked;", "Lcom/sputnik/common/analytics/GeneralEvents$ClickMarketRedDot;", "Lcom/sputnik/common/analytics/GeneralEvents$ClickProfile;", "Lcom/sputnik/common/analytics/GeneralEvents$ClickProfileBetaPromo;", "Lcom/sputnik/common/analytics/GeneralEvents$ClickProfileNotifications;", "Lcom/sputnik/common/analytics/GeneralEvents$ClickProfileNotificationsRedDot;", "Lcom/sputnik/common/analytics/GeneralEvents$ClickWidgetOpen;", "Lcom/sputnik/common/analytics/GeneralEvents$ViewCallLog;", "common_release"}, k = 1, mv = {1, 9, 0}, xi = 48)
/* loaded from: classes3.dex */
public abstract class GeneralEvents extends AnalyticsTracker.Event {
    public /* synthetic */ GeneralEvents(String str, String str2, DefaultConstructorMarker defaultConstructorMarker) {
        this(str, str2);
    }

    public /* synthetic */ GeneralEvents(String str, String str2, int i, DefaultConstructorMarker defaultConstructorMarker) {
        this(str, (i & 2) != 0 ? null : str2, null);
    }

    /* compiled from: GeneralEvents.kt */
    @Metadata(d1 = {"\u0000\f\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\u0018\u00002\u00020\u0001B\u0005¢\u0006\u0002\u0010\u0002¨\u0006\u0003"}, d2 = {"Lcom/sputnik/common/analytics/GeneralEvents$ClickWidgetOpen;", "Lcom/sputnik/common/analytics/GeneralEvents;", "()V", "common_release"}, k = 1, mv = {1, 9, 0}, xi = 48)
    public static final class ClickWidgetOpen extends GeneralEvents {
        public ClickWidgetOpen() {
            super("clickWidgetOpen", null, 2, 0 == true ? 1 : 0);
        }
    }

    private GeneralEvents(String str, String str2) {
        super("General", str, str2);
    }

    /* compiled from: GeneralEvents.kt */
    @Metadata(d1 = {"\u0000\f\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\u0018\u00002\u00020\u0001B\u0005¢\u0006\u0002\u0010\u0002¨\u0006\u0003"}, d2 = {"Lcom/sputnik/common/analytics/GeneralEvents$ClickMarketRedDot;", "Lcom/sputnik/common/analytics/GeneralEvents;", "()V", "common_release"}, k = 1, mv = {1, 9, 0}, xi = 48)
    public static final class ClickMarketRedDot extends GeneralEvents {
        public ClickMarketRedDot() {
            super("clickMarketRedDot", null, 2, 0 == true ? 1 : 0);
        }
    }

    /* compiled from: GeneralEvents.kt */
    @Metadata(d1 = {"\u0000\f\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\u0018\u00002\u00020\u0001B\u0005¢\u0006\u0002\u0010\u0002¨\u0006\u0003"}, d2 = {"Lcom/sputnik/common/analytics/GeneralEvents$ClickArchiveFromHistory;", "Lcom/sputnik/common/analytics/GeneralEvents;", "()V", "common_release"}, k = 1, mv = {1, 9, 0}, xi = 48)
    public static final class ClickArchiveFromHistory extends GeneralEvents {
        public ClickArchiveFromHistory() {
            super("clickArchiveFromHistory", null, 2, 0 == true ? 1 : 0);
        }
    }

    /* compiled from: GeneralEvents.kt */
    @Metadata(d1 = {"\u0000\f\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\u0018\u00002\u00020\u0001B\u0005¢\u0006\u0002\u0010\u0002¨\u0006\u0003"}, d2 = {"Lcom/sputnik/common/analytics/GeneralEvents$ClickProfile;", "Lcom/sputnik/common/analytics/GeneralEvents;", "()V", "common_release"}, k = 1, mv = {1, 9, 0}, xi = 48)
    public static final class ClickProfile extends GeneralEvents {
        public ClickProfile() {
            super("clickProfile", null, 2, 0 == true ? 1 : 0);
        }
    }

    /* compiled from: GeneralEvents.kt */
    @Metadata(d1 = {"\u0000\f\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\u0018\u00002\u00020\u0001B\u0005¢\u0006\u0002\u0010\u0002¨\u0006\u0003"}, d2 = {"Lcom/sputnik/common/analytics/GeneralEvents$ClickProfileBetaPromo;", "Lcom/sputnik/common/analytics/GeneralEvents;", "()V", "common_release"}, k = 1, mv = {1, 9, 0}, xi = 48)
    public static final class ClickProfileBetaPromo extends GeneralEvents {
        public ClickProfileBetaPromo() {
            super("clickProfileBetaPromo", null, 2, 0 == true ? 1 : 0);
        }
    }

    /* compiled from: GeneralEvents.kt */
    @Metadata(d1 = {"\u0000\f\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\u0018\u00002\u00020\u0001B\u0005¢\u0006\u0002\u0010\u0002¨\u0006\u0003"}, d2 = {"Lcom/sputnik/common/analytics/GeneralEvents$ClickBetaPromoBecomeATester;", "Lcom/sputnik/common/analytics/GeneralEvents;", "()V", "common_release"}, k = 1, mv = {1, 9, 0}, xi = 48)
    public static final class ClickBetaPromoBecomeATester extends GeneralEvents {
        public ClickBetaPromoBecomeATester() {
            super("clickBetaPromoBecomeATester", null, 2, 0 == true ? 1 : 0);
        }
    }

    /* compiled from: GeneralEvents.kt */
    @Metadata(d1 = {"\u0000\f\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\u0018\u00002\u00020\u0001B\u0005¢\u0006\u0002\u0010\u0002¨\u0006\u0003"}, d2 = {"Lcom/sputnik/common/analytics/GeneralEvents$ClickLogOutWhenBlocked;", "Lcom/sputnik/common/analytics/GeneralEvents;", "()V", "common_release"}, k = 1, mv = {1, 9, 0}, xi = 48)
    public static final class ClickLogOutWhenBlocked extends GeneralEvents {
        public ClickLogOutWhenBlocked() {
            super("clickLogOutWhenBlocked", null, 2, 0 == true ? 1 : 0);
        }
    }

    /* compiled from: GeneralEvents.kt */
    @Metadata(d1 = {"\u0000\f\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\u0018\u00002\u00020\u0001B\u0005¢\u0006\u0002\u0010\u0002¨\u0006\u0003"}, d2 = {"Lcom/sputnik/common/analytics/GeneralEvents$ClickProfileNotifications;", "Lcom/sputnik/common/analytics/GeneralEvents;", "()V", "common_release"}, k = 1, mv = {1, 9, 0}, xi = 48)
    public static final class ClickProfileNotifications extends GeneralEvents {
        public ClickProfileNotifications() {
            super("clickProfileNotifications", null, 2, 0 == true ? 1 : 0);
        }
    }

    /* compiled from: GeneralEvents.kt */
    @Metadata(d1 = {"\u0000\f\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\u0018\u00002\u00020\u0001B\u0005¢\u0006\u0002\u0010\u0002¨\u0006\u0003"}, d2 = {"Lcom/sputnik/common/analytics/GeneralEvents$ClickProfileNotificationsRedDot;", "Lcom/sputnik/common/analytics/GeneralEvents;", "()V", "common_release"}, k = 1, mv = {1, 9, 0}, xi = 48)
    public static final class ClickProfileNotificationsRedDot extends GeneralEvents {
        public ClickProfileNotificationsRedDot() {
            super("clickProfileNotificationsRedDot", null, 2, 0 == true ? 1 : 0);
        }
    }

    /* compiled from: GeneralEvents.kt */
    @Metadata(d1 = {"\u0000\f\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\u0018\u00002\u00020\u0001B\u0005¢\u0006\u0002\u0010\u0002¨\u0006\u0003"}, d2 = {"Lcom/sputnik/common/analytics/GeneralEvents$ViewCallLog;", "Lcom/sputnik/common/analytics/GeneralEvents;", "()V", "common_release"}, k = 1, mv = {1, 9, 0}, xi = 48)
    public static final class ViewCallLog extends GeneralEvents {
        public ViewCallLog() {
            super("viewCallLog", null, 2, 0 == true ? 1 : 0);
        }
    }
}

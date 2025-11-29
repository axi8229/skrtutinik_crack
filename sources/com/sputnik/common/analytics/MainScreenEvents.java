package com.sputnik.common.analytics;

import com.google.android.gms.measurement.api.AppMeasurementSdk;
import com.sputnik.common.analytics.AnalyticsTracker;
import kotlin.Metadata;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;

/* compiled from: MainScreenEvents.kt */
@Metadata(d1 = {"\u00006\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u000e\n\u0002\b\r\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\b6\u0018\u00002\u00020\u0001:\t\u0007\b\t\n\u000b\f\r\u000e\u000fB\u001d\b\u0004\u0012\u0006\u0010\u0003\u001a\u00020\u0002\u0012\n\b\u0002\u0010\u0004\u001a\u0004\u0018\u00010\u0002¢\u0006\u0004\b\u0005\u0010\u0006\u0082\u0001\t\u0010\u0011\u0012\u0013\u0014\u0015\u0016\u0017\u0018¨\u0006\u0019"}, d2 = {"Lcom/sputnik/common/analytics/MainScreenEvents;", "Lcom/sputnik/common/analytics/AnalyticsTracker$Event;", "", AppMeasurementSdk.ConditionalUserProperty.NAME, AppMeasurementSdk.ConditionalUserProperty.VALUE, "<init>", "(Ljava/lang/String;Ljava/lang/String;)V", "ClickAddressFamily", "ClickAddressStandart", "ClickArhiveFamily", "ClickArhiveStandart", "ClickCodeFamily", "ClickCodeStandart", "ClickStoryTile", "ClickVisitHistoryFamily", "ClickVisitHistoryStandart", "Lcom/sputnik/common/analytics/MainScreenEvents$ClickAddressFamily;", "Lcom/sputnik/common/analytics/MainScreenEvents$ClickAddressStandart;", "Lcom/sputnik/common/analytics/MainScreenEvents$ClickArhiveFamily;", "Lcom/sputnik/common/analytics/MainScreenEvents$ClickArhiveStandart;", "Lcom/sputnik/common/analytics/MainScreenEvents$ClickCodeFamily;", "Lcom/sputnik/common/analytics/MainScreenEvents$ClickCodeStandart;", "Lcom/sputnik/common/analytics/MainScreenEvents$ClickStoryTile;", "Lcom/sputnik/common/analytics/MainScreenEvents$ClickVisitHistoryFamily;", "Lcom/sputnik/common/analytics/MainScreenEvents$ClickVisitHistoryStandart;", "common_release"}, k = 1, mv = {1, 9, 0}, xi = 48)
/* loaded from: classes3.dex */
public abstract class MainScreenEvents extends AnalyticsTracker.Event {
    public /* synthetic */ MainScreenEvents(String str, String str2, DefaultConstructorMarker defaultConstructorMarker) {
        this(str, str2);
    }

    public /* synthetic */ MainScreenEvents(String str, String str2, int i, DefaultConstructorMarker defaultConstructorMarker) {
        this(str, (i & 2) != 0 ? null : str2, null);
    }

    private MainScreenEvents(String str, String str2) {
        super("Main_Screen", str, str2);
    }

    /* compiled from: MainScreenEvents.kt */
    @Metadata(d1 = {"\u0000\u0012\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0002\u0018\u00002\u00020\u0001B\r\u0012\u0006\u0010\u0002\u001a\u00020\u0003¢\u0006\u0002\u0010\u0004¨\u0006\u0005"}, d2 = {"Lcom/sputnik/common/analytics/MainScreenEvents$ClickStoryTile;", "Lcom/sputnik/common/analytics/MainScreenEvents;", "id", "", "(Ljava/lang/String;)V", "common_release"}, k = 1, mv = {1, 9, 0}, xi = 48)
    public static final class ClickStoryTile extends MainScreenEvents {
        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        public ClickStoryTile(String id) {
            super("clickStoryTile", id, null);
            Intrinsics.checkNotNullParameter(id, "id");
        }
    }

    /* compiled from: MainScreenEvents.kt */
    @Metadata(d1 = {"\u0000\f\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\u0018\u00002\u00020\u0001B\u0005¢\u0006\u0002\u0010\u0002¨\u0006\u0003"}, d2 = {"Lcom/sputnik/common/analytics/MainScreenEvents$ClickVisitHistoryStandart;", "Lcom/sputnik/common/analytics/MainScreenEvents;", "()V", "common_release"}, k = 1, mv = {1, 9, 0}, xi = 48)
    public static final class ClickVisitHistoryStandart extends MainScreenEvents {
        public ClickVisitHistoryStandart() {
            super("clickVisitHistoryStandart", null, 2, 0 == true ? 1 : 0);
        }
    }

    /* compiled from: MainScreenEvents.kt */
    @Metadata(d1 = {"\u0000\f\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\u0018\u00002\u00020\u0001B\u0005¢\u0006\u0002\u0010\u0002¨\u0006\u0003"}, d2 = {"Lcom/sputnik/common/analytics/MainScreenEvents$ClickVisitHistoryFamily;", "Lcom/sputnik/common/analytics/MainScreenEvents;", "()V", "common_release"}, k = 1, mv = {1, 9, 0}, xi = 48)
    public static final class ClickVisitHistoryFamily extends MainScreenEvents {
        public ClickVisitHistoryFamily() {
            super("clickVisitHistoryFamily", null, 2, 0 == true ? 1 : 0);
        }
    }

    /* compiled from: MainScreenEvents.kt */
    @Metadata(d1 = {"\u0000\f\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\u0018\u00002\u00020\u0001B\u0005¢\u0006\u0002\u0010\u0002¨\u0006\u0003"}, d2 = {"Lcom/sputnik/common/analytics/MainScreenEvents$ClickArhiveStandart;", "Lcom/sputnik/common/analytics/MainScreenEvents;", "()V", "common_release"}, k = 1, mv = {1, 9, 0}, xi = 48)
    public static final class ClickArhiveStandart extends MainScreenEvents {
        public ClickArhiveStandart() {
            super("clickArhiveStandart", null, 2, 0 == true ? 1 : 0);
        }
    }

    /* compiled from: MainScreenEvents.kt */
    @Metadata(d1 = {"\u0000\f\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\u0018\u00002\u00020\u0001B\u0005¢\u0006\u0002\u0010\u0002¨\u0006\u0003"}, d2 = {"Lcom/sputnik/common/analytics/MainScreenEvents$ClickArhiveFamily;", "Lcom/sputnik/common/analytics/MainScreenEvents;", "()V", "common_release"}, k = 1, mv = {1, 9, 0}, xi = 48)
    public static final class ClickArhiveFamily extends MainScreenEvents {
        public ClickArhiveFamily() {
            super("clickArhiveFamily", null, 2, 0 == true ? 1 : 0);
        }
    }

    /* compiled from: MainScreenEvents.kt */
    @Metadata(d1 = {"\u0000\f\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\u0018\u00002\u00020\u0001B\u0005¢\u0006\u0002\u0010\u0002¨\u0006\u0003"}, d2 = {"Lcom/sputnik/common/analytics/MainScreenEvents$ClickCodeStandart;", "Lcom/sputnik/common/analytics/MainScreenEvents;", "()V", "common_release"}, k = 1, mv = {1, 9, 0}, xi = 48)
    public static final class ClickCodeStandart extends MainScreenEvents {
        public ClickCodeStandart() {
            super("clickCodeStandart", null, 2, 0 == true ? 1 : 0);
        }
    }

    /* compiled from: MainScreenEvents.kt */
    @Metadata(d1 = {"\u0000\f\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\u0018\u00002\u00020\u0001B\u0005¢\u0006\u0002\u0010\u0002¨\u0006\u0003"}, d2 = {"Lcom/sputnik/common/analytics/MainScreenEvents$ClickCodeFamily;", "Lcom/sputnik/common/analytics/MainScreenEvents;", "()V", "common_release"}, k = 1, mv = {1, 9, 0}, xi = 48)
    public static final class ClickCodeFamily extends MainScreenEvents {
        public ClickCodeFamily() {
            super("clickCodeFamily", null, 2, 0 == true ? 1 : 0);
        }
    }

    /* compiled from: MainScreenEvents.kt */
    @Metadata(d1 = {"\u0000\f\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\u0018\u00002\u00020\u0001B\u0005¢\u0006\u0002\u0010\u0002¨\u0006\u0003"}, d2 = {"Lcom/sputnik/common/analytics/MainScreenEvents$ClickAddressStandart;", "Lcom/sputnik/common/analytics/MainScreenEvents;", "()V", "common_release"}, k = 1, mv = {1, 9, 0}, xi = 48)
    public static final class ClickAddressStandart extends MainScreenEvents {
        public ClickAddressStandart() {
            super("clickAddressStandart", null, 2, 0 == true ? 1 : 0);
        }
    }

    /* compiled from: MainScreenEvents.kt */
    @Metadata(d1 = {"\u0000\f\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\u0018\u00002\u00020\u0001B\u0005¢\u0006\u0002\u0010\u0002¨\u0006\u0003"}, d2 = {"Lcom/sputnik/common/analytics/MainScreenEvents$ClickAddressFamily;", "Lcom/sputnik/common/analytics/MainScreenEvents;", "()V", "common_release"}, k = 1, mv = {1, 9, 0}, xi = 48)
    public static final class ClickAddressFamily extends MainScreenEvents {
        public ClickAddressFamily() {
            super("clickAddressFamily", null, 2, 0 == true ? 1 : 0);
        }
    }
}

package com.sputnik.common.analytics;

import com.google.android.gms.measurement.api.AppMeasurementSdk;
import com.sputnik.common.analytics.AnalyticsTracker;
import kotlin.Metadata;
import kotlin.jvm.internal.DefaultConstructorMarker;

/* compiled from: PopupEvents.kt */
@Metadata(d1 = {"\u0000$\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0006\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\b6\u0018\u00002\u00020\u0001:\u0004\u0006\u0007\b\tB\u001b\b\u0004\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\n\b\u0002\u0010\u0004\u001a\u0004\u0018\u00010\u0003¢\u0006\u0002\u0010\u0005\u0082\u0001\u0004\n\u000b\f\r¨\u0006\u000e"}, d2 = {"Lcom/sputnik/common/analytics/PopupEvents;", "Lcom/sputnik/common/analytics/AnalyticsTracker$Event;", AppMeasurementSdk.ConditionalUserProperty.NAME, "", AppMeasurementSdk.ConditionalUserProperty.VALUE, "(Ljava/lang/String;Ljava/lang/String;)V", "ClickScreenBtnClose", "ClickScreenBtnN", "ShowScreenOpen", "ShowScreenSeeN", "Lcom/sputnik/common/analytics/PopupEvents$ClickScreenBtnClose;", "Lcom/sputnik/common/analytics/PopupEvents$ClickScreenBtnN;", "Lcom/sputnik/common/analytics/PopupEvents$ShowScreenOpen;", "Lcom/sputnik/common/analytics/PopupEvents$ShowScreenSeeN;", "common_release"}, k = 1, mv = {1, 9, 0}, xi = 48)
/* loaded from: classes3.dex */
public abstract class PopupEvents extends AnalyticsTracker.Event {
    public /* synthetic */ PopupEvents(String str, String str2, DefaultConstructorMarker defaultConstructorMarker) {
        this(str, str2);
    }

    private PopupEvents(String str, String str2) {
        super("Promo", str, str2);
    }

    /* compiled from: PopupEvents.kt */
    @Metadata(d1 = {"\u0000\u0018\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0002\u0018\u00002\u00020\u0001B\u0017\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\b\u0010\u0004\u001a\u0004\u0018\u00010\u0005¢\u0006\u0002\u0010\u0006¨\u0006\u0007"}, d2 = {"Lcom/sputnik/common/analytics/PopupEvents$ClickScreenBtnN;", "Lcom/sputnik/common/analytics/PopupEvents;", "buttonNumber", "", "popupId", "", "(ILjava/lang/String;)V", "common_release"}, k = 1, mv = {1, 9, 0}, xi = 48)
    public static final class ClickScreenBtnN extends PopupEvents {
        public ClickScreenBtnN(int i, String str) {
            super("clickScreenBtn" + i, str, null);
        }
    }

    /* compiled from: PopupEvents.kt */
    @Metadata(d1 = {"\u0000\u0012\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0002\u0018\u00002\u00020\u0001B\u000f\u0012\b\u0010\u0002\u001a\u0004\u0018\u00010\u0003¢\u0006\u0002\u0010\u0004¨\u0006\u0005"}, d2 = {"Lcom/sputnik/common/analytics/PopupEvents$ClickScreenBtnClose;", "Lcom/sputnik/common/analytics/PopupEvents;", "popupId", "", "(Ljava/lang/String;)V", "common_release"}, k = 1, mv = {1, 9, 0}, xi = 48)
    public static final class ClickScreenBtnClose extends PopupEvents {
        public ClickScreenBtnClose(String str) {
            super("clickScreenBtnClose", str, null);
        }
    }

    /* compiled from: PopupEvents.kt */
    @Metadata(d1 = {"\u0000\u0012\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0002\u0018\u00002\u00020\u0001B\u000f\u0012\b\u0010\u0002\u001a\u0004\u0018\u00010\u0003¢\u0006\u0002\u0010\u0004¨\u0006\u0005"}, d2 = {"Lcom/sputnik/common/analytics/PopupEvents$ShowScreenOpen;", "Lcom/sputnik/common/analytics/PopupEvents;", "popupId", "", "(Ljava/lang/String;)V", "common_release"}, k = 1, mv = {1, 9, 0}, xi = 48)
    public static final class ShowScreenOpen extends PopupEvents {
        public ShowScreenOpen(String str) {
            super("showScreenOpen", str, null);
        }
    }

    /* compiled from: PopupEvents.kt */
    @Metadata(d1 = {"\u0000\u0018\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0002\u0018\u00002\u00020\u0001B\u0017\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\b\u0010\u0004\u001a\u0004\u0018\u00010\u0005¢\u0006\u0002\u0010\u0006¨\u0006\u0007"}, d2 = {"Lcom/sputnik/common/analytics/PopupEvents$ShowScreenSeeN;", "Lcom/sputnik/common/analytics/PopupEvents;", "screenPosition", "", "popupId", "", "(ILjava/lang/String;)V", "common_release"}, k = 1, mv = {1, 9, 0}, xi = 48)
    public static final class ShowScreenSeeN extends PopupEvents {
        public ShowScreenSeeN(int i, String str) {
            super("showScreenSee" + i, str, null);
        }
    }
}

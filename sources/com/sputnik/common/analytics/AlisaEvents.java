package com.sputnik.common.analytics;

import com.google.android.gms.measurement.api.AppMeasurementSdk;
import com.sputnik.common.analytics.AnalyticsTracker;
import kotlin.Metadata;
import kotlin.jvm.internal.DefaultConstructorMarker;

/* compiled from: AlisaEvents.kt */
@Metadata(d1 = {"\u0000*\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u000e\n\u0002\b\n\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\b6\u0018\u00002\u00020\u0001:\u0006\u0007\b\t\n\u000b\fB\u001d\b\u0004\u0012\u0006\u0010\u0003\u001a\u00020\u0002\u0012\n\b\u0002\u0010\u0004\u001a\u0004\u0018\u00010\u0002¢\u0006\u0004\b\u0005\u0010\u0006\u0082\u0001\u0006\r\u000e\u000f\u0010\u0011\u0012¨\u0006\u0013"}, d2 = {"Lcom/sputnik/common/analytics/AlisaEvents;", "Lcom/sputnik/common/analytics/AnalyticsTracker$Event;", "", AppMeasurementSdk.ConditionalUserProperty.NAME, AppMeasurementSdk.ConditionalUserProperty.VALUE, "<init>", "(Ljava/lang/String;Ljava/lang/String;)V", "ClickAlisaMarket", "ClickAlisaProfile", "ClickConnectAlisaBtn", "ClickConnectAlisaLink", "ShowDetAlisa", "StateSubscribeAlisaPopup", "Lcom/sputnik/common/analytics/AlisaEvents$ClickAlisaMarket;", "Lcom/sputnik/common/analytics/AlisaEvents$ClickAlisaProfile;", "Lcom/sputnik/common/analytics/AlisaEvents$ClickConnectAlisaBtn;", "Lcom/sputnik/common/analytics/AlisaEvents$ClickConnectAlisaLink;", "Lcom/sputnik/common/analytics/AlisaEvents$ShowDetAlisa;", "Lcom/sputnik/common/analytics/AlisaEvents$StateSubscribeAlisaPopup;", "common_release"}, k = 1, mv = {1, 9, 0}, xi = 48)
/* loaded from: classes3.dex */
public abstract class AlisaEvents extends AnalyticsTracker.Event {
    public /* synthetic */ AlisaEvents(String str, String str2, DefaultConstructorMarker defaultConstructorMarker) {
        this(str, str2);
    }

    public /* synthetic */ AlisaEvents(String str, String str2, int i, DefaultConstructorMarker defaultConstructorMarker) {
        this(str, (i & 2) != 0 ? null : str2, null);
    }

    /* compiled from: AlisaEvents.kt */
    @Metadata(d1 = {"\u0000\f\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\u0018\u00002\u00020\u0001B\u0005¢\u0006\u0002\u0010\u0002¨\u0006\u0003"}, d2 = {"Lcom/sputnik/common/analytics/AlisaEvents$ClickAlisaProfile;", "Lcom/sputnik/common/analytics/AlisaEvents;", "()V", "common_release"}, k = 1, mv = {1, 9, 0}, xi = 48)
    public static final class ClickAlisaProfile extends AlisaEvents {
        public ClickAlisaProfile() {
            super("clickAlisaProfile", null, 2, 0 == true ? 1 : 0);
        }
    }

    private AlisaEvents(String str, String str2) {
        super("Alisa", str, str2);
    }

    /* compiled from: AlisaEvents.kt */
    @Metadata(d1 = {"\u0000\f\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\u0018\u00002\u00020\u0001B\u0005¢\u0006\u0002\u0010\u0002¨\u0006\u0003"}, d2 = {"Lcom/sputnik/common/analytics/AlisaEvents$ShowDetAlisa;", "Lcom/sputnik/common/analytics/AlisaEvents;", "()V", "common_release"}, k = 1, mv = {1, 9, 0}, xi = 48)
    public static final class ShowDetAlisa extends AlisaEvents {
        public ShowDetAlisa() {
            super("showDetAlisa", null, 2, 0 == true ? 1 : 0);
        }
    }

    /* compiled from: AlisaEvents.kt */
    @Metadata(d1 = {"\u0000\f\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\u0018\u00002\u00020\u0001B\u0005¢\u0006\u0002\u0010\u0002¨\u0006\u0003"}, d2 = {"Lcom/sputnik/common/analytics/AlisaEvents$ClickConnectAlisaBtn;", "Lcom/sputnik/common/analytics/AlisaEvents;", "()V", "common_release"}, k = 1, mv = {1, 9, 0}, xi = 48)
    public static final class ClickConnectAlisaBtn extends AlisaEvents {
        public ClickConnectAlisaBtn() {
            super("clickConnectAlisaBtn", null, 2, 0 == true ? 1 : 0);
        }
    }

    /* compiled from: AlisaEvents.kt */
    @Metadata(d1 = {"\u0000\f\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\u0018\u00002\u00020\u0001B\u0005¢\u0006\u0002\u0010\u0002¨\u0006\u0003"}, d2 = {"Lcom/sputnik/common/analytics/AlisaEvents$ClickConnectAlisaLink;", "Lcom/sputnik/common/analytics/AlisaEvents;", "()V", "common_release"}, k = 1, mv = {1, 9, 0}, xi = 48)
    public static final class ClickConnectAlisaLink extends AlisaEvents {
        public ClickConnectAlisaLink() {
            super("clickConnectAlisaLink", null, 2, 0 == true ? 1 : 0);
        }
    }

    /* compiled from: AlisaEvents.kt */
    @Metadata(d1 = {"\u0000\f\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\u0018\u00002\u00020\u0001B\u0005¢\u0006\u0002\u0010\u0002¨\u0006\u0003"}, d2 = {"Lcom/sputnik/common/analytics/AlisaEvents$ClickAlisaMarket;", "Lcom/sputnik/common/analytics/AlisaEvents;", "()V", "common_release"}, k = 1, mv = {1, 9, 0}, xi = 48)
    public static final class ClickAlisaMarket extends AlisaEvents {
        public ClickAlisaMarket() {
            super("clickAlisaMarket", null, 2, 0 == true ? 1 : 0);
        }
    }

    /* compiled from: AlisaEvents.kt */
    @Metadata(d1 = {"\u0000\f\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\u0018\u00002\u00020\u0001B\u0005¢\u0006\u0002\u0010\u0002¨\u0006\u0003"}, d2 = {"Lcom/sputnik/common/analytics/AlisaEvents$StateSubscribeAlisaPopup;", "Lcom/sputnik/common/analytics/AlisaEvents;", "()V", "common_release"}, k = 1, mv = {1, 9, 0}, xi = 48)
    public static final class StateSubscribeAlisaPopup extends AlisaEvents {
        public StateSubscribeAlisaPopup() {
            super("stateSubscribeAlisaPopup", null, 2, 0 == true ? 1 : 0);
        }
    }
}

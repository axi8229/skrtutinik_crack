package com.sputnik.common.analytics;

import com.google.android.gms.measurement.api.AppMeasurementSdk;
import com.sputnik.common.analytics.AnalyticsTracker;
import kotlin.Metadata;
import kotlin.jvm.internal.DefaultConstructorMarker;

/* compiled from: GorservEvents.kt */
@Metadata(d1 = {"\u0000<\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0002\b\f\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\b6\u0018\u00002\u00020\u0001:\n\u0006\u0007\b\t\n\u000b\f\r\u000e\u000fB\u001b\b\u0004\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\n\b\u0002\u0010\u0004\u001a\u0004\u0018\u00010\u0003¢\u0006\u0002\u0010\u0005\u0082\u0001\n\u0010\u0011\u0012\u0013\u0014\u0015\u0016\u0017\u0018\u0019¨\u0006\u001a"}, d2 = {"Lcom/sputnik/common/analytics/GorservEvents;", "Lcom/sputnik/common/analytics/AnalyticsTracker$Event;", AppMeasurementSdk.ConditionalUserProperty.NAME, "", AppMeasurementSdk.ConditionalUserProperty.VALUE, "(Ljava/lang/String;Ljava/lang/String;)V", "ClickAboutGorserv", "ClickCreateRequest", "ClickErrorPhoneNumber", "ClickInformationVideo", "ClickNumberEditing", "ClickPhoneNumber", "ClickServicesScreen", "ShowErrorScreen", "ShowSlider", "ShowSuccessScreen", "Lcom/sputnik/common/analytics/GorservEvents$ClickAboutGorserv;", "Lcom/sputnik/common/analytics/GorservEvents$ClickCreateRequest;", "Lcom/sputnik/common/analytics/GorservEvents$ClickErrorPhoneNumber;", "Lcom/sputnik/common/analytics/GorservEvents$ClickInformationVideo;", "Lcom/sputnik/common/analytics/GorservEvents$ClickNumberEditing;", "Lcom/sputnik/common/analytics/GorservEvents$ClickPhoneNumber;", "Lcom/sputnik/common/analytics/GorservEvents$ClickServicesScreen;", "Lcom/sputnik/common/analytics/GorservEvents$ShowErrorScreen;", "Lcom/sputnik/common/analytics/GorservEvents$ShowSlider;", "Lcom/sputnik/common/analytics/GorservEvents$ShowSuccessScreen;", "common_release"}, k = 1, mv = {1, 9, 0}, xi = 48)
/* loaded from: classes3.dex */
public abstract class GorservEvents extends AnalyticsTracker.Event {
    public /* synthetic */ GorservEvents(String str, String str2, DefaultConstructorMarker defaultConstructorMarker) {
        this(str, str2);
    }

    public /* synthetic */ GorservEvents(String str, String str2, int i, DefaultConstructorMarker defaultConstructorMarker) {
        this(str, (i & 2) != 0 ? null : str2, null);
    }

    /* compiled from: GorservEvents.kt */
    @Metadata(d1 = {"\u0000\f\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\u0018\u00002\u00020\u0001B\u0005¢\u0006\u0002\u0010\u0002¨\u0006\u0003"}, d2 = {"Lcom/sputnik/common/analytics/GorservEvents$ShowSlider;", "Lcom/sputnik/common/analytics/GorservEvents;", "()V", "common_release"}, k = 1, mv = {1, 9, 0}, xi = 48)
    public static final class ShowSlider extends GorservEvents {
        public ShowSlider() {
            super("ShowSlider", null, 2, 0 == true ? 1 : 0);
        }
    }

    private GorservEvents(String str, String str2) {
        super("Gorserv", str, str2);
    }

    /* compiled from: GorservEvents.kt */
    @Metadata(d1 = {"\u0000\f\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\u0018\u00002\u00020\u0001B\u0005¢\u0006\u0002\u0010\u0002¨\u0006\u0003"}, d2 = {"Lcom/sputnik/common/analytics/GorservEvents$ClickServicesScreen;", "Lcom/sputnik/common/analytics/GorservEvents;", "()V", "common_release"}, k = 1, mv = {1, 9, 0}, xi = 48)
    public static final class ClickServicesScreen extends GorservEvents {
        public ClickServicesScreen() {
            super("ClickServicesScreen", null, 2, 0 == true ? 1 : 0);
        }
    }

    /* compiled from: GorservEvents.kt */
    @Metadata(d1 = {"\u0000\f\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\u0018\u00002\u00020\u0001B\u0005¢\u0006\u0002\u0010\u0002¨\u0006\u0003"}, d2 = {"Lcom/sputnik/common/analytics/GorservEvents$ClickInformationVideo;", "Lcom/sputnik/common/analytics/GorservEvents;", "()V", "common_release"}, k = 1, mv = {1, 9, 0}, xi = 48)
    public static final class ClickInformationVideo extends GorservEvents {
        public ClickInformationVideo() {
            super("ClickInformationVideo", null, 2, 0 == true ? 1 : 0);
        }
    }

    /* compiled from: GorservEvents.kt */
    @Metadata(d1 = {"\u0000\f\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\u0018\u00002\u00020\u0001B\u0005¢\u0006\u0002\u0010\u0002¨\u0006\u0003"}, d2 = {"Lcom/sputnik/common/analytics/GorservEvents$ClickPhoneNumber;", "Lcom/sputnik/common/analytics/GorservEvents;", "()V", "common_release"}, k = 1, mv = {1, 9, 0}, xi = 48)
    public static final class ClickPhoneNumber extends GorservEvents {
        public ClickPhoneNumber() {
            super("ClickPhoneNumber", null, 2, 0 == true ? 1 : 0);
        }
    }

    /* compiled from: GorservEvents.kt */
    @Metadata(d1 = {"\u0000\f\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\u0018\u00002\u00020\u0001B\u0005¢\u0006\u0002\u0010\u0002¨\u0006\u0003"}, d2 = {"Lcom/sputnik/common/analytics/GorservEvents$ClickCreateRequest;", "Lcom/sputnik/common/analytics/GorservEvents;", "()V", "common_release"}, k = 1, mv = {1, 9, 0}, xi = 48)
    public static final class ClickCreateRequest extends GorservEvents {
        public ClickCreateRequest() {
            super("ClickCreateRequest", null, 2, 0 == true ? 1 : 0);
        }
    }

    /* compiled from: GorservEvents.kt */
    @Metadata(d1 = {"\u0000\f\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\u0018\u00002\u00020\u0001B\u0005¢\u0006\u0002\u0010\u0002¨\u0006\u0003"}, d2 = {"Lcom/sputnik/common/analytics/GorservEvents$ClickNumberEditing;", "Lcom/sputnik/common/analytics/GorservEvents;", "()V", "common_release"}, k = 1, mv = {1, 9, 0}, xi = 48)
    public static final class ClickNumberEditing extends GorservEvents {
        public ClickNumberEditing() {
            super("ClickNumberEditing", null, 2, 0 == true ? 1 : 0);
        }
    }

    /* compiled from: GorservEvents.kt */
    @Metadata(d1 = {"\u0000\f\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\u0018\u00002\u00020\u0001B\u0005¢\u0006\u0002\u0010\u0002¨\u0006\u0003"}, d2 = {"Lcom/sputnik/common/analytics/GorservEvents$ClickAboutGorserv;", "Lcom/sputnik/common/analytics/GorservEvents;", "()V", "common_release"}, k = 1, mv = {1, 9, 0}, xi = 48)
    public static final class ClickAboutGorserv extends GorservEvents {
        public ClickAboutGorserv() {
            super("ClickAboutGorserv", null, 2, 0 == true ? 1 : 0);
        }
    }

    /* compiled from: GorservEvents.kt */
    @Metadata(d1 = {"\u0000\f\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\u0018\u00002\u00020\u0001B\u0005¢\u0006\u0002\u0010\u0002¨\u0006\u0003"}, d2 = {"Lcom/sputnik/common/analytics/GorservEvents$ShowErrorScreen;", "Lcom/sputnik/common/analytics/GorservEvents;", "()V", "common_release"}, k = 1, mv = {1, 9, 0}, xi = 48)
    public static final class ShowErrorScreen extends GorservEvents {
        public ShowErrorScreen() {
            super("ShowErrorScreen", null, 2, 0 == true ? 1 : 0);
        }
    }

    /* compiled from: GorservEvents.kt */
    @Metadata(d1 = {"\u0000\f\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\u0018\u00002\u00020\u0001B\u0005¢\u0006\u0002\u0010\u0002¨\u0006\u0003"}, d2 = {"Lcom/sputnik/common/analytics/GorservEvents$ClickErrorPhoneNumber;", "Lcom/sputnik/common/analytics/GorservEvents;", "()V", "common_release"}, k = 1, mv = {1, 9, 0}, xi = 48)
    public static final class ClickErrorPhoneNumber extends GorservEvents {
        public ClickErrorPhoneNumber() {
            super("ClickErrorPhoneNumber", null, 2, 0 == true ? 1 : 0);
        }
    }

    /* compiled from: GorservEvents.kt */
    @Metadata(d1 = {"\u0000\f\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\u0018\u00002\u00020\u0001B\u0005¢\u0006\u0002\u0010\u0002¨\u0006\u0003"}, d2 = {"Lcom/sputnik/common/analytics/GorservEvents$ShowSuccessScreen;", "Lcom/sputnik/common/analytics/GorservEvents;", "()V", "common_release"}, k = 1, mv = {1, 9, 0}, xi = 48)
    public static final class ShowSuccessScreen extends GorservEvents {
        public ShowSuccessScreen() {
            super("ShowSuccessScreen", null, 2, 0 == true ? 1 : 0);
        }
    }
}

package com.sputnik.common.analytics;

import com.google.android.gms.measurement.api.AppMeasurementSdk;
import com.sputnik.common.analytics.AnalyticsTracker;
import kotlin.Metadata;
import kotlin.jvm.internal.DefaultConstructorMarker;

/* compiled from: CamerasEvents.kt */
@Metadata(d1 = {"\u0000P\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0011\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\b6\u0018\u00002\u00020\u0001:\u000f\u0006\u0007\b\t\n\u000b\f\r\u000e\u000f\u0010\u0011\u0012\u0013\u0014B\u001b\b\u0004\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\n\b\u0002\u0010\u0004\u001a\u0004\u0018\u00010\u0003¢\u0006\u0002\u0010\u0005\u0082\u0001\u000f\u0015\u0016\u0017\u0018\u0019\u001a\u001b\u001c\u001d\u001e\u001f !\"#¨\u0006$"}, d2 = {"Lcom/sputnik/common/analytics/CamerasEvents;", "Lcom/sputnik/common/analytics/AnalyticsTracker$Event;", AppMeasurementSdk.ConditionalUserProperty.NAME, "", AppMeasurementSdk.ConditionalUserProperty.VALUE, "(Ljava/lang/String;Ljava/lang/String;)V", "ClickCamerasSettings", "ClickGridIcon", "ShowDetAllCamerasAccess", "ShowFrameBlockedCamera", "ShowFrameBlockedIntercomCamera", "ShowFrameCamera", "ShowFrameIntercomCamera", "ShowHomeBlockedCamera", "ShowHomeBlockedIntercomCamera", "ShowHomeCamera", "ShowHomeIntercomCamera", "StateAddCameraOnHomeScreen", "StateAddCameraOnWidgetScreen", "StateDelCameraFromHomeScreen", "StateDelCameraFromWidgetScreen", "Lcom/sputnik/common/analytics/CamerasEvents$ClickCamerasSettings;", "Lcom/sputnik/common/analytics/CamerasEvents$ClickGridIcon;", "Lcom/sputnik/common/analytics/CamerasEvents$ShowDetAllCamerasAccess;", "Lcom/sputnik/common/analytics/CamerasEvents$ShowFrameBlockedCamera;", "Lcom/sputnik/common/analytics/CamerasEvents$ShowFrameBlockedIntercomCamera;", "Lcom/sputnik/common/analytics/CamerasEvents$ShowFrameCamera;", "Lcom/sputnik/common/analytics/CamerasEvents$ShowFrameIntercomCamera;", "Lcom/sputnik/common/analytics/CamerasEvents$ShowHomeBlockedCamera;", "Lcom/sputnik/common/analytics/CamerasEvents$ShowHomeBlockedIntercomCamera;", "Lcom/sputnik/common/analytics/CamerasEvents$ShowHomeCamera;", "Lcom/sputnik/common/analytics/CamerasEvents$ShowHomeIntercomCamera;", "Lcom/sputnik/common/analytics/CamerasEvents$StateAddCameraOnHomeScreen;", "Lcom/sputnik/common/analytics/CamerasEvents$StateAddCameraOnWidgetScreen;", "Lcom/sputnik/common/analytics/CamerasEvents$StateDelCameraFromHomeScreen;", "Lcom/sputnik/common/analytics/CamerasEvents$StateDelCameraFromWidgetScreen;", "common_release"}, k = 1, mv = {1, 9, 0}, xi = 48)
/* loaded from: classes3.dex */
public abstract class CamerasEvents extends AnalyticsTracker.Event {
    public /* synthetic */ CamerasEvents(String str, String str2, DefaultConstructorMarker defaultConstructorMarker) {
        this(str, str2);
    }

    public /* synthetic */ CamerasEvents(String str, String str2, int i, DefaultConstructorMarker defaultConstructorMarker) {
        this(str, (i & 2) != 0 ? null : str2, null);
    }

    /* compiled from: CamerasEvents.kt */
    @Metadata(d1 = {"\u0000\f\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\u0018\u00002\u00020\u0001B\u0005¢\u0006\u0002\u0010\u0002¨\u0006\u0003"}, d2 = {"Lcom/sputnik/common/analytics/CamerasEvents$ClickGridIcon;", "Lcom/sputnik/common/analytics/CamerasEvents;", "()V", "common_release"}, k = 1, mv = {1, 9, 0}, xi = 48)
    public static final class ClickGridIcon extends CamerasEvents {
        public ClickGridIcon() {
            super("clickGridIcon", null, 2, 0 == true ? 1 : 0);
        }
    }

    private CamerasEvents(String str, String str2) {
        super("Cameras", str, str2);
    }

    /* compiled from: CamerasEvents.kt */
    @Metadata(d1 = {"\u0000\f\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\u0018\u00002\u00020\u0001B\u0005¢\u0006\u0002\u0010\u0002¨\u0006\u0003"}, d2 = {"Lcom/sputnik/common/analytics/CamerasEvents$ShowHomeIntercomCamera;", "Lcom/sputnik/common/analytics/CamerasEvents;", "()V", "common_release"}, k = 1, mv = {1, 9, 0}, xi = 48)
    public static final class ShowHomeIntercomCamera extends CamerasEvents {
        public ShowHomeIntercomCamera() {
            super("showHomeIntercomCamera", null, 2, 0 == true ? 1 : 0);
        }
    }

    /* compiled from: CamerasEvents.kt */
    @Metadata(d1 = {"\u0000\f\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\u0018\u00002\u00020\u0001B\u0005¢\u0006\u0002\u0010\u0002¨\u0006\u0003"}, d2 = {"Lcom/sputnik/common/analytics/CamerasEvents$ShowHomeCamera;", "Lcom/sputnik/common/analytics/CamerasEvents;", "()V", "common_release"}, k = 1, mv = {1, 9, 0}, xi = 48)
    public static final class ShowHomeCamera extends CamerasEvents {
        public ShowHomeCamera() {
            super("showHomeCamera", null, 2, 0 == true ? 1 : 0);
        }
    }

    /* compiled from: CamerasEvents.kt */
    @Metadata(d1 = {"\u0000\f\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\u0018\u00002\u00020\u0001B\u0005¢\u0006\u0002\u0010\u0002¨\u0006\u0003"}, d2 = {"Lcom/sputnik/common/analytics/CamerasEvents$ShowHomeBlockedIntercomCamera;", "Lcom/sputnik/common/analytics/CamerasEvents;", "()V", "common_release"}, k = 1, mv = {1, 9, 0}, xi = 48)
    public static final class ShowHomeBlockedIntercomCamera extends CamerasEvents {
        public ShowHomeBlockedIntercomCamera() {
            super("showHomeBlockedIntercomCamera", null, 2, 0 == true ? 1 : 0);
        }
    }

    /* compiled from: CamerasEvents.kt */
    @Metadata(d1 = {"\u0000\f\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\u0018\u00002\u00020\u0001B\u0005¢\u0006\u0002\u0010\u0002¨\u0006\u0003"}, d2 = {"Lcom/sputnik/common/analytics/CamerasEvents$ShowHomeBlockedCamera;", "Lcom/sputnik/common/analytics/CamerasEvents;", "()V", "common_release"}, k = 1, mv = {1, 9, 0}, xi = 48)
    public static final class ShowHomeBlockedCamera extends CamerasEvents {
        public ShowHomeBlockedCamera() {
            super("showHomeBlockedCamera", null, 2, 0 == true ? 1 : 0);
        }
    }

    /* compiled from: CamerasEvents.kt */
    @Metadata(d1 = {"\u0000\f\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\u0018\u00002\u00020\u0001B\u0005¢\u0006\u0002\u0010\u0002¨\u0006\u0003"}, d2 = {"Lcom/sputnik/common/analytics/CamerasEvents$ShowFrameIntercomCamera;", "Lcom/sputnik/common/analytics/CamerasEvents;", "()V", "common_release"}, k = 1, mv = {1, 9, 0}, xi = 48)
    public static final class ShowFrameIntercomCamera extends CamerasEvents {
        public ShowFrameIntercomCamera() {
            super("showFrameIntercomCamera", null, 2, 0 == true ? 1 : 0);
        }
    }

    /* compiled from: CamerasEvents.kt */
    @Metadata(d1 = {"\u0000\f\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\u0018\u00002\u00020\u0001B\u0005¢\u0006\u0002\u0010\u0002¨\u0006\u0003"}, d2 = {"Lcom/sputnik/common/analytics/CamerasEvents$ShowFrameCamera;", "Lcom/sputnik/common/analytics/CamerasEvents;", "()V", "common_release"}, k = 1, mv = {1, 9, 0}, xi = 48)
    public static final class ShowFrameCamera extends CamerasEvents {
        public ShowFrameCamera() {
            super("showFrameCamera", null, 2, 0 == true ? 1 : 0);
        }
    }

    /* compiled from: CamerasEvents.kt */
    @Metadata(d1 = {"\u0000\f\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\u0018\u00002\u00020\u0001B\u0005¢\u0006\u0002\u0010\u0002¨\u0006\u0003"}, d2 = {"Lcom/sputnik/common/analytics/CamerasEvents$ShowFrameBlockedIntercomCamera;", "Lcom/sputnik/common/analytics/CamerasEvents;", "()V", "common_release"}, k = 1, mv = {1, 9, 0}, xi = 48)
    public static final class ShowFrameBlockedIntercomCamera extends CamerasEvents {
        public ShowFrameBlockedIntercomCamera() {
            super("showFrameBlockedIntercomCamera", null, 2, 0 == true ? 1 : 0);
        }
    }

    /* compiled from: CamerasEvents.kt */
    @Metadata(d1 = {"\u0000\f\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\u0018\u00002\u00020\u0001B\u0005¢\u0006\u0002\u0010\u0002¨\u0006\u0003"}, d2 = {"Lcom/sputnik/common/analytics/CamerasEvents$ShowFrameBlockedCamera;", "Lcom/sputnik/common/analytics/CamerasEvents;", "()V", "common_release"}, k = 1, mv = {1, 9, 0}, xi = 48)
    public static final class ShowFrameBlockedCamera extends CamerasEvents {
        public ShowFrameBlockedCamera() {
            super("showFrameBlockedCamera", null, 2, 0 == true ? 1 : 0);
        }
    }

    /* compiled from: CamerasEvents.kt */
    @Metadata(d1 = {"\u0000\f\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\u0018\u00002\u00020\u0001B\u0005¢\u0006\u0002\u0010\u0002¨\u0006\u0003"}, d2 = {"Lcom/sputnik/common/analytics/CamerasEvents$ClickCamerasSettings;", "Lcom/sputnik/common/analytics/CamerasEvents;", "()V", "common_release"}, k = 1, mv = {1, 9, 0}, xi = 48)
    public static final class ClickCamerasSettings extends CamerasEvents {
        public ClickCamerasSettings() {
            super("clickCamerasSettings", null, 2, 0 == true ? 1 : 0);
        }
    }

    /* compiled from: CamerasEvents.kt */
    @Metadata(d1 = {"\u0000\f\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\u0018\u00002\u00020\u0001B\u0005¢\u0006\u0002\u0010\u0002¨\u0006\u0003"}, d2 = {"Lcom/sputnik/common/analytics/CamerasEvents$ShowDetAllCamerasAccess;", "Lcom/sputnik/common/analytics/CamerasEvents;", "()V", "common_release"}, k = 1, mv = {1, 9, 0}, xi = 48)
    public static final class ShowDetAllCamerasAccess extends CamerasEvents {
        public ShowDetAllCamerasAccess() {
            super("showDetAllCamerasAccess", null, 2, 0 == true ? 1 : 0);
        }
    }

    /* compiled from: CamerasEvents.kt */
    @Metadata(d1 = {"\u0000\f\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\u0018\u00002\u00020\u0001B\u0005¢\u0006\u0002\u0010\u0002¨\u0006\u0003"}, d2 = {"Lcom/sputnik/common/analytics/CamerasEvents$StateAddCameraOnHomeScreen;", "Lcom/sputnik/common/analytics/CamerasEvents;", "()V", "common_release"}, k = 1, mv = {1, 9, 0}, xi = 48)
    public static final class StateAddCameraOnHomeScreen extends CamerasEvents {
        public StateAddCameraOnHomeScreen() {
            super("stateAddCameraOnHomeScreen", null, 2, 0 == true ? 1 : 0);
        }
    }

    /* compiled from: CamerasEvents.kt */
    @Metadata(d1 = {"\u0000\f\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\u0018\u00002\u00020\u0001B\u0005¢\u0006\u0002\u0010\u0002¨\u0006\u0003"}, d2 = {"Lcom/sputnik/common/analytics/CamerasEvents$StateDelCameraFromHomeScreen;", "Lcom/sputnik/common/analytics/CamerasEvents;", "()V", "common_release"}, k = 1, mv = {1, 9, 0}, xi = 48)
    public static final class StateDelCameraFromHomeScreen extends CamerasEvents {
        public StateDelCameraFromHomeScreen() {
            super("stateDelCameraFromHomeScreen", null, 2, 0 == true ? 1 : 0);
        }
    }

    /* compiled from: CamerasEvents.kt */
    @Metadata(d1 = {"\u0000\f\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\u0018\u00002\u00020\u0001B\u0005¢\u0006\u0002\u0010\u0002¨\u0006\u0003"}, d2 = {"Lcom/sputnik/common/analytics/CamerasEvents$StateAddCameraOnWidgetScreen;", "Lcom/sputnik/common/analytics/CamerasEvents;", "()V", "common_release"}, k = 1, mv = {1, 9, 0}, xi = 48)
    public static final class StateAddCameraOnWidgetScreen extends CamerasEvents {
        public StateAddCameraOnWidgetScreen() {
            super("stateAddCameraOnWidgetScreen", null, 2, 0 == true ? 1 : 0);
        }
    }

    /* compiled from: CamerasEvents.kt */
    @Metadata(d1 = {"\u0000\f\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\u0018\u00002\u00020\u0001B\u0005¢\u0006\u0002\u0010\u0002¨\u0006\u0003"}, d2 = {"Lcom/sputnik/common/analytics/CamerasEvents$StateDelCameraFromWidgetScreen;", "Lcom/sputnik/common/analytics/CamerasEvents;", "()V", "common_release"}, k = 1, mv = {1, 9, 0}, xi = 48)
    public static final class StateDelCameraFromWidgetScreen extends CamerasEvents {
        public StateDelCameraFromWidgetScreen() {
            super("stateDelCameraFromWidgetScreen", null, 2, 0 == true ? 1 : 0);
        }
    }
}

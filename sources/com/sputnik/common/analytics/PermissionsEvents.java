package com.sputnik.common.analytics;

import com.google.android.gms.measurement.api.AppMeasurementSdk;
import com.sputnik.common.analytics.AnalyticsTracker;
import kotlin.Metadata;
import kotlin.jvm.internal.DefaultConstructorMarker;

/* compiled from: PermissionsEvents.kt */
@Metadata(d1 = {"\u0000h\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0017\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\b6\u0018\u00002\u00020\u0001:\u0015\u0006\u0007\b\t\n\u000b\f\r\u000e\u000f\u0010\u0011\u0012\u0013\u0014\u0015\u0016\u0017\u0018\u0019\u001aB\u001b\b\u0004\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\n\b\u0002\u0010\u0004\u001a\u0004\u0018\u00010\u0003¢\u0006\u0002\u0010\u0005\u0082\u0001\u0015\u001b\u001c\u001d\u001e\u001f !\"#$%&'()*+,-./¨\u00060"}, d2 = {"Lcom/sputnik/common/analytics/PermissionsEvents;", "Lcom/sputnik/common/analytics/AnalyticsTracker$Event;", AppMeasurementSdk.ConditionalUserProperty.NAME, "", AppMeasurementSdk.ConditionalUserProperty.VALUE, "(Ljava/lang/String;Ljava/lang/String;)V", "ClickPermissionBluetoothOn", "ClickPermissionDeviceSearchDetOn", "ClickPermissionDeviceSearchOn", "ClickPermissionDisplayOverOn", "ClickPermissionGPSOn", "ClickPermissionLocationDetOn", "ClickPermissionLocationOn", "ClickPermissionNotificationsDetOn", "ClickPermissionNotificationsOn", "ClickPermissionProfile", "ClickPermissionWhitelistDetOn", "ClickPermissionWhitelistOn", "ClickSetupWorkInBackground", "ClickSetupWorkInDetBackground", "StatePermissionBluetoothOn", "StatePermissionDeviceSearchOn", "StatePermissionGPSOn", "StatePermissionLocationOn", "StatePermissionNotificationsOn", "StatePermissionOverOn", "StatePermissionWhitelistOn", "Lcom/sputnik/common/analytics/PermissionsEvents$ClickPermissionBluetoothOn;", "Lcom/sputnik/common/analytics/PermissionsEvents$ClickPermissionDeviceSearchDetOn;", "Lcom/sputnik/common/analytics/PermissionsEvents$ClickPermissionDeviceSearchOn;", "Lcom/sputnik/common/analytics/PermissionsEvents$ClickPermissionDisplayOverOn;", "Lcom/sputnik/common/analytics/PermissionsEvents$ClickPermissionGPSOn;", "Lcom/sputnik/common/analytics/PermissionsEvents$ClickPermissionLocationDetOn;", "Lcom/sputnik/common/analytics/PermissionsEvents$ClickPermissionLocationOn;", "Lcom/sputnik/common/analytics/PermissionsEvents$ClickPermissionNotificationsDetOn;", "Lcom/sputnik/common/analytics/PermissionsEvents$ClickPermissionNotificationsOn;", "Lcom/sputnik/common/analytics/PermissionsEvents$ClickPermissionProfile;", "Lcom/sputnik/common/analytics/PermissionsEvents$ClickPermissionWhitelistDetOn;", "Lcom/sputnik/common/analytics/PermissionsEvents$ClickPermissionWhitelistOn;", "Lcom/sputnik/common/analytics/PermissionsEvents$ClickSetupWorkInBackground;", "Lcom/sputnik/common/analytics/PermissionsEvents$ClickSetupWorkInDetBackground;", "Lcom/sputnik/common/analytics/PermissionsEvents$StatePermissionBluetoothOn;", "Lcom/sputnik/common/analytics/PermissionsEvents$StatePermissionDeviceSearchOn;", "Lcom/sputnik/common/analytics/PermissionsEvents$StatePermissionGPSOn;", "Lcom/sputnik/common/analytics/PermissionsEvents$StatePermissionLocationOn;", "Lcom/sputnik/common/analytics/PermissionsEvents$StatePermissionNotificationsOn;", "Lcom/sputnik/common/analytics/PermissionsEvents$StatePermissionOverOn;", "Lcom/sputnik/common/analytics/PermissionsEvents$StatePermissionWhitelistOn;", "common_release"}, k = 1, mv = {1, 9, 0}, xi = 48)
/* loaded from: classes3.dex */
public abstract class PermissionsEvents extends AnalyticsTracker.Event {
    public /* synthetic */ PermissionsEvents(String str, String str2, DefaultConstructorMarker defaultConstructorMarker) {
        this(str, str2);
    }

    public /* synthetic */ PermissionsEvents(String str, String str2, int i, DefaultConstructorMarker defaultConstructorMarker) {
        this(str, (i & 2) != 0 ? null : str2, null);
    }

    private PermissionsEvents(String str, String str2) {
        super("Permissions", str, str2);
    }

    /* compiled from: PermissionsEvents.kt */
    @Metadata(d1 = {"\u0000\f\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\u0018\u00002\u00020\u0001B\u0005¢\u0006\u0002\u0010\u0002¨\u0006\u0003"}, d2 = {"Lcom/sputnik/common/analytics/PermissionsEvents$ClickPermissionProfile;", "Lcom/sputnik/common/analytics/PermissionsEvents;", "()V", "common_release"}, k = 1, mv = {1, 9, 0}, xi = 48)
    public static final class ClickPermissionProfile extends PermissionsEvents {
        public ClickPermissionProfile() {
            super("clickPermissionProfile", null, 2, 0 == true ? 1 : 0);
        }
    }

    /* compiled from: PermissionsEvents.kt */
    @Metadata(d1 = {"\u0000\f\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\u0018\u00002\u00020\u0001B\u0005¢\u0006\u0002\u0010\u0002¨\u0006\u0003"}, d2 = {"Lcom/sputnik/common/analytics/PermissionsEvents$StatePermissionBluetoothOn;", "Lcom/sputnik/common/analytics/PermissionsEvents;", "()V", "common_release"}, k = 1, mv = {1, 9, 0}, xi = 48)
    public static final class StatePermissionBluetoothOn extends PermissionsEvents {
        public StatePermissionBluetoothOn() {
            super("statePermissionBluetoothOn", null, 2, 0 == true ? 1 : 0);
        }
    }

    /* compiled from: PermissionsEvents.kt */
    @Metadata(d1 = {"\u0000\f\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\u0018\u00002\u00020\u0001B\u0005¢\u0006\u0002\u0010\u0002¨\u0006\u0003"}, d2 = {"Lcom/sputnik/common/analytics/PermissionsEvents$StatePermissionGPSOn;", "Lcom/sputnik/common/analytics/PermissionsEvents;", "()V", "common_release"}, k = 1, mv = {1, 9, 0}, xi = 48)
    public static final class StatePermissionGPSOn extends PermissionsEvents {
        public StatePermissionGPSOn() {
            super("statePermissionGPSOn", null, 2, 0 == true ? 1 : 0);
        }
    }

    /* compiled from: PermissionsEvents.kt */
    @Metadata(d1 = {"\u0000\f\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\u0018\u00002\u00020\u0001B\u0005¢\u0006\u0002\u0010\u0002¨\u0006\u0003"}, d2 = {"Lcom/sputnik/common/analytics/PermissionsEvents$StatePermissionNotificationsOn;", "Lcom/sputnik/common/analytics/PermissionsEvents;", "()V", "common_release"}, k = 1, mv = {1, 9, 0}, xi = 48)
    public static final class StatePermissionNotificationsOn extends PermissionsEvents {
        public StatePermissionNotificationsOn() {
            super("statePermissionNotificationsOn", null, 2, 0 == true ? 1 : 0);
        }
    }

    /* compiled from: PermissionsEvents.kt */
    @Metadata(d1 = {"\u0000\f\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\u0018\u00002\u00020\u0001B\u0005¢\u0006\u0002\u0010\u0002¨\u0006\u0003"}, d2 = {"Lcom/sputnik/common/analytics/PermissionsEvents$StatePermissionLocationOn;", "Lcom/sputnik/common/analytics/PermissionsEvents;", "()V", "common_release"}, k = 1, mv = {1, 9, 0}, xi = 48)
    public static final class StatePermissionLocationOn extends PermissionsEvents {
        public StatePermissionLocationOn() {
            super("statePermissionLocationOn", null, 2, 0 == true ? 1 : 0);
        }
    }

    /* compiled from: PermissionsEvents.kt */
    @Metadata(d1 = {"\u0000\f\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\u0018\u00002\u00020\u0001B\u0005¢\u0006\u0002\u0010\u0002¨\u0006\u0003"}, d2 = {"Lcom/sputnik/common/analytics/PermissionsEvents$StatePermissionDeviceSearchOn;", "Lcom/sputnik/common/analytics/PermissionsEvents;", "()V", "common_release"}, k = 1, mv = {1, 9, 0}, xi = 48)
    public static final class StatePermissionDeviceSearchOn extends PermissionsEvents {
        public StatePermissionDeviceSearchOn() {
            super("statePermissionDeviceSearchOn", null, 2, 0 == true ? 1 : 0);
        }
    }

    /* compiled from: PermissionsEvents.kt */
    @Metadata(d1 = {"\u0000\f\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\u0018\u00002\u00020\u0001B\u0005¢\u0006\u0002\u0010\u0002¨\u0006\u0003"}, d2 = {"Lcom/sputnik/common/analytics/PermissionsEvents$StatePermissionWhitelistOn;", "Lcom/sputnik/common/analytics/PermissionsEvents;", "()V", "common_release"}, k = 1, mv = {1, 9, 0}, xi = 48)
    public static final class StatePermissionWhitelistOn extends PermissionsEvents {
        public StatePermissionWhitelistOn() {
            super("statePermissionWhitelistOn", null, 2, 0 == true ? 1 : 0);
        }
    }

    /* compiled from: PermissionsEvents.kt */
    @Metadata(d1 = {"\u0000\f\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\u0018\u00002\u00020\u0001B\u0005¢\u0006\u0002\u0010\u0002¨\u0006\u0003"}, d2 = {"Lcom/sputnik/common/analytics/PermissionsEvents$StatePermissionOverOn;", "Lcom/sputnik/common/analytics/PermissionsEvents;", "()V", "common_release"}, k = 1, mv = {1, 9, 0}, xi = 48)
    public static final class StatePermissionOverOn extends PermissionsEvents {
        public StatePermissionOverOn() {
            super("statePermissionOverOn", null, 2, 0 == true ? 1 : 0);
        }
    }

    /* compiled from: PermissionsEvents.kt */
    @Metadata(d1 = {"\u0000\f\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\u0018\u00002\u00020\u0001B\u0005¢\u0006\u0002\u0010\u0002¨\u0006\u0003"}, d2 = {"Lcom/sputnik/common/analytics/PermissionsEvents$ClickSetupWorkInBackground;", "Lcom/sputnik/common/analytics/PermissionsEvents;", "()V", "common_release"}, k = 1, mv = {1, 9, 0}, xi = 48)
    public static final class ClickSetupWorkInBackground extends PermissionsEvents {
        public ClickSetupWorkInBackground() {
            super("clickSetupWorkInBackground", null, 2, 0 == true ? 1 : 0);
        }
    }

    /* compiled from: PermissionsEvents.kt */
    @Metadata(d1 = {"\u0000\f\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\u0018\u00002\u00020\u0001B\u0005¢\u0006\u0002\u0010\u0002¨\u0006\u0003"}, d2 = {"Lcom/sputnik/common/analytics/PermissionsEvents$ClickPermissionBluetoothOn;", "Lcom/sputnik/common/analytics/PermissionsEvents;", "()V", "common_release"}, k = 1, mv = {1, 9, 0}, xi = 48)
    public static final class ClickPermissionBluetoothOn extends PermissionsEvents {
        public ClickPermissionBluetoothOn() {
            super("clickPermissionBluetoothOn", null, 2, 0 == true ? 1 : 0);
        }
    }

    /* compiled from: PermissionsEvents.kt */
    @Metadata(d1 = {"\u0000\f\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\u0018\u00002\u00020\u0001B\u0005¢\u0006\u0002\u0010\u0002¨\u0006\u0003"}, d2 = {"Lcom/sputnik/common/analytics/PermissionsEvents$ClickPermissionGPSOn;", "Lcom/sputnik/common/analytics/PermissionsEvents;", "()V", "common_release"}, k = 1, mv = {1, 9, 0}, xi = 48)
    public static final class ClickPermissionGPSOn extends PermissionsEvents {
        public ClickPermissionGPSOn() {
            super("clickPermissionGPSOn", null, 2, 0 == true ? 1 : 0);
        }
    }

    /* compiled from: PermissionsEvents.kt */
    @Metadata(d1 = {"\u0000\f\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\u0018\u00002\u00020\u0001B\u0005¢\u0006\u0002\u0010\u0002¨\u0006\u0003"}, d2 = {"Lcom/sputnik/common/analytics/PermissionsEvents$ClickPermissionNotificationsOn;", "Lcom/sputnik/common/analytics/PermissionsEvents;", "()V", "common_release"}, k = 1, mv = {1, 9, 0}, xi = 48)
    public static final class ClickPermissionNotificationsOn extends PermissionsEvents {
        public ClickPermissionNotificationsOn() {
            super("clickPermissionNotificationsOn", null, 2, 0 == true ? 1 : 0);
        }
    }

    /* compiled from: PermissionsEvents.kt */
    @Metadata(d1 = {"\u0000\f\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\u0018\u00002\u00020\u0001B\u0005¢\u0006\u0002\u0010\u0002¨\u0006\u0003"}, d2 = {"Lcom/sputnik/common/analytics/PermissionsEvents$ClickPermissionLocationOn;", "Lcom/sputnik/common/analytics/PermissionsEvents;", "()V", "common_release"}, k = 1, mv = {1, 9, 0}, xi = 48)
    public static final class ClickPermissionLocationOn extends PermissionsEvents {
        public ClickPermissionLocationOn() {
            super("clickPermissionLocationOn", null, 2, 0 == true ? 1 : 0);
        }
    }

    /* compiled from: PermissionsEvents.kt */
    @Metadata(d1 = {"\u0000\f\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\u0018\u00002\u00020\u0001B\u0005¢\u0006\u0002\u0010\u0002¨\u0006\u0003"}, d2 = {"Lcom/sputnik/common/analytics/PermissionsEvents$ClickPermissionDeviceSearchOn;", "Lcom/sputnik/common/analytics/PermissionsEvents;", "()V", "common_release"}, k = 1, mv = {1, 9, 0}, xi = 48)
    public static final class ClickPermissionDeviceSearchOn extends PermissionsEvents {
        public ClickPermissionDeviceSearchOn() {
            super("clickPermissionDeviceSearchOn", null, 2, 0 == true ? 1 : 0);
        }
    }

    /* compiled from: PermissionsEvents.kt */
    @Metadata(d1 = {"\u0000\f\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\u0018\u00002\u00020\u0001B\u0005¢\u0006\u0002\u0010\u0002¨\u0006\u0003"}, d2 = {"Lcom/sputnik/common/analytics/PermissionsEvents$ClickPermissionWhitelistOn;", "Lcom/sputnik/common/analytics/PermissionsEvents;", "()V", "common_release"}, k = 1, mv = {1, 9, 0}, xi = 48)
    public static final class ClickPermissionWhitelistOn extends PermissionsEvents {
        public ClickPermissionWhitelistOn() {
            super("clickPermissionWhitelistOn", null, 2, 0 == true ? 1 : 0);
        }
    }

    /* compiled from: PermissionsEvents.kt */
    @Metadata(d1 = {"\u0000\f\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\u0018\u00002\u00020\u0001B\u0005¢\u0006\u0002\u0010\u0002¨\u0006\u0003"}, d2 = {"Lcom/sputnik/common/analytics/PermissionsEvents$ClickPermissionNotificationsDetOn;", "Lcom/sputnik/common/analytics/PermissionsEvents;", "()V", "common_release"}, k = 1, mv = {1, 9, 0}, xi = 48)
    public static final class ClickPermissionNotificationsDetOn extends PermissionsEvents {
        public ClickPermissionNotificationsDetOn() {
            super("clickPermissionNotificationsDetOn", null, 2, 0 == true ? 1 : 0);
        }
    }

    /* compiled from: PermissionsEvents.kt */
    @Metadata(d1 = {"\u0000\f\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\u0018\u00002\u00020\u0001B\u0005¢\u0006\u0002\u0010\u0002¨\u0006\u0003"}, d2 = {"Lcom/sputnik/common/analytics/PermissionsEvents$ClickPermissionLocationDetOn;", "Lcom/sputnik/common/analytics/PermissionsEvents;", "()V", "common_release"}, k = 1, mv = {1, 9, 0}, xi = 48)
    public static final class ClickPermissionLocationDetOn extends PermissionsEvents {
        public ClickPermissionLocationDetOn() {
            super("clickPermissionLocationDetOn", null, 2, 0 == true ? 1 : 0);
        }
    }

    /* compiled from: PermissionsEvents.kt */
    @Metadata(d1 = {"\u0000\f\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\u0018\u00002\u00020\u0001B\u0005¢\u0006\u0002\u0010\u0002¨\u0006\u0003"}, d2 = {"Lcom/sputnik/common/analytics/PermissionsEvents$ClickPermissionDeviceSearchDetOn;", "Lcom/sputnik/common/analytics/PermissionsEvents;", "()V", "common_release"}, k = 1, mv = {1, 9, 0}, xi = 48)
    public static final class ClickPermissionDeviceSearchDetOn extends PermissionsEvents {
        public ClickPermissionDeviceSearchDetOn() {
            super("clickPermissionDeviceSearchDetOn", null, 2, 0 == true ? 1 : 0);
        }
    }

    /* compiled from: PermissionsEvents.kt */
    @Metadata(d1 = {"\u0000\f\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\u0018\u00002\u00020\u0001B\u0005¢\u0006\u0002\u0010\u0002¨\u0006\u0003"}, d2 = {"Lcom/sputnik/common/analytics/PermissionsEvents$ClickPermissionWhitelistDetOn;", "Lcom/sputnik/common/analytics/PermissionsEvents;", "()V", "common_release"}, k = 1, mv = {1, 9, 0}, xi = 48)
    public static final class ClickPermissionWhitelistDetOn extends PermissionsEvents {
        public ClickPermissionWhitelistDetOn() {
            super("clickPermissionWhitelistDetOn", null, 2, 0 == true ? 1 : 0);
        }
    }

    /* compiled from: PermissionsEvents.kt */
    @Metadata(d1 = {"\u0000\f\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\u0018\u00002\u00020\u0001B\u0005¢\u0006\u0002\u0010\u0002¨\u0006\u0003"}, d2 = {"Lcom/sputnik/common/analytics/PermissionsEvents$ClickSetupWorkInDetBackground;", "Lcom/sputnik/common/analytics/PermissionsEvents;", "()V", "common_release"}, k = 1, mv = {1, 9, 0}, xi = 48)
    public static final class ClickSetupWorkInDetBackground extends PermissionsEvents {
        public ClickSetupWorkInDetBackground() {
            super("clickSetupWorkInDetBackground", null, 2, 0 == true ? 1 : 0);
        }
    }

    /* compiled from: PermissionsEvents.kt */
    @Metadata(d1 = {"\u0000\f\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\u0018\u00002\u00020\u0001B\u0005¢\u0006\u0002\u0010\u0002¨\u0006\u0003"}, d2 = {"Lcom/sputnik/common/analytics/PermissionsEvents$ClickPermissionDisplayOverOn;", "Lcom/sputnik/common/analytics/PermissionsEvents;", "()V", "common_release"}, k = 1, mv = {1, 9, 0}, xi = 48)
    public static final class ClickPermissionDisplayOverOn extends PermissionsEvents {
        public ClickPermissionDisplayOverOn() {
            super("clickPermissionDisplayOverOn", null, 2, 0 == true ? 1 : 0);
        }
    }
}

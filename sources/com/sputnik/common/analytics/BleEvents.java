package com.sputnik.common.analytics;

import com.google.android.gms.measurement.api.AppMeasurementSdk;
import com.sputnik.common.analytics.AnalyticsTracker;
import kotlin.Metadata;
import kotlin.jvm.internal.DefaultConstructorMarker;

/* compiled from: BleEvents.kt */
@Metadata(d1 = {"\u0000b\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u000e\n\u0002\b\u0018\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\b6\u0018\u00002\u00020\u0001:\u0014\u0007\b\t\n\u000b\f\r\u000e\u000f\u0010\u0011\u0012\u0013\u0014\u0015\u0016\u0017\u0018\u0019\u001aB\u001d\b\u0004\u0012\u0006\u0010\u0003\u001a\u00020\u0002\u0012\n\b\u0002\u0010\u0004\u001a\u0004\u0018\u00010\u0002¢\u0006\u0004\b\u0005\u0010\u0006\u0082\u0001\u0014\u001b\u001c\u001d\u001e\u001f !\"#$%&'()*+,-.¨\u0006/"}, d2 = {"Lcom/sputnik/common/analytics/BleEvents;", "Lcom/sputnik/common/analytics/AnalyticsTracker$Event;", "", AppMeasurementSdk.ConditionalUserProperty.NAME, AppMeasurementSdk.ConditionalUserProperty.VALUE, "<init>", "(Ljava/lang/String;Ljava/lang/String;)V", "ClickBleExcellent", "ClickBleOff", "ClickBleOff2", "ClickBleOn", "ClickBleOpeningDistance", "ClickBlePermission", "ClickBleSignalLevel", "ClickBleSignalLevel2", "ClickBleSubscriptionSettings", "ShowBleError", "ShowBleSuccess", "ShowPermissionModalMainScreenSkip", "ShowPermissionModalMainScreenTweak", "ShowPermissionModalOnBLESkip", "ShowPermissionModalOnBLETweak", "ShowPermissionModalRSSISkip", "ShowPermissionModalRSSITweak", "StateBleOpenDoorFailed", "StateBleOpenDoorSuccessfully", "StateBlePromoOff", "Lcom/sputnik/common/analytics/BleEvents$ClickBleExcellent;", "Lcom/sputnik/common/analytics/BleEvents$ClickBleOff;", "Lcom/sputnik/common/analytics/BleEvents$ClickBleOff2;", "Lcom/sputnik/common/analytics/BleEvents$ClickBleOn;", "Lcom/sputnik/common/analytics/BleEvents$ClickBleOpeningDistance;", "Lcom/sputnik/common/analytics/BleEvents$ClickBlePermission;", "Lcom/sputnik/common/analytics/BleEvents$ClickBleSignalLevel;", "Lcom/sputnik/common/analytics/BleEvents$ClickBleSignalLevel2;", "Lcom/sputnik/common/analytics/BleEvents$ClickBleSubscriptionSettings;", "Lcom/sputnik/common/analytics/BleEvents$ShowBleError;", "Lcom/sputnik/common/analytics/BleEvents$ShowBleSuccess;", "Lcom/sputnik/common/analytics/BleEvents$ShowPermissionModalMainScreenSkip;", "Lcom/sputnik/common/analytics/BleEvents$ShowPermissionModalMainScreenTweak;", "Lcom/sputnik/common/analytics/BleEvents$ShowPermissionModalOnBLESkip;", "Lcom/sputnik/common/analytics/BleEvents$ShowPermissionModalOnBLETweak;", "Lcom/sputnik/common/analytics/BleEvents$ShowPermissionModalRSSISkip;", "Lcom/sputnik/common/analytics/BleEvents$ShowPermissionModalRSSITweak;", "Lcom/sputnik/common/analytics/BleEvents$StateBleOpenDoorFailed;", "Lcom/sputnik/common/analytics/BleEvents$StateBleOpenDoorSuccessfully;", "Lcom/sputnik/common/analytics/BleEvents$StateBlePromoOff;", "common_release"}, k = 1, mv = {1, 9, 0}, xi = 48)
/* loaded from: classes3.dex */
public abstract class BleEvents extends AnalyticsTracker.Event {
    public /* synthetic */ BleEvents(String str, String str2, DefaultConstructorMarker defaultConstructorMarker) {
        this(str, str2);
    }

    public /* synthetic */ BleEvents(String str, String str2, int i, DefaultConstructorMarker defaultConstructorMarker) {
        this(str, (i & 2) != 0 ? null : str2, null);
    }

    private BleEvents(String str, String str2) {
        super("BLE", str, str2);
    }

    /* compiled from: BleEvents.kt */
    @Metadata(d1 = {"\u0000\f\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\u0018\u00002\u00020\u0001B\u0005¢\u0006\u0002\u0010\u0002¨\u0006\u0003"}, d2 = {"Lcom/sputnik/common/analytics/BleEvents$StateBleOpenDoorSuccessfully;", "Lcom/sputnik/common/analytics/BleEvents;", "()V", "common_release"}, k = 1, mv = {1, 9, 0}, xi = 48)
    public static final class StateBleOpenDoorSuccessfully extends BleEvents {
        public StateBleOpenDoorSuccessfully() {
            super("stateBleOpenDoorSuccessfully", null, 2, 0 == true ? 1 : 0);
        }
    }

    /* compiled from: BleEvents.kt */
    @Metadata(d1 = {"\u0000\f\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\u0018\u00002\u00020\u0001B\u0005¢\u0006\u0002\u0010\u0002¨\u0006\u0003"}, d2 = {"Lcom/sputnik/common/analytics/BleEvents$StateBleOpenDoorFailed;", "Lcom/sputnik/common/analytics/BleEvents;", "()V", "common_release"}, k = 1, mv = {1, 9, 0}, xi = 48)
    public static final class StateBleOpenDoorFailed extends BleEvents {
        public StateBleOpenDoorFailed() {
            super("stateBleOpenDoorFailed", null, 2, 0 == true ? 1 : 0);
        }
    }

    /* compiled from: BleEvents.kt */
    @Metadata(d1 = {"\u0000\f\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\u0018\u00002\u00020\u0001B\u0005¢\u0006\u0002\u0010\u0002¨\u0006\u0003"}, d2 = {"Lcom/sputnik/common/analytics/BleEvents$ClickBleOn;", "Lcom/sputnik/common/analytics/BleEvents;", "()V", "common_release"}, k = 1, mv = {1, 9, 0}, xi = 48)
    public static final class ClickBleOn extends BleEvents {
        public ClickBleOn() {
            super("clickBleOn", null, 2, 0 == true ? 1 : 0);
        }
    }

    /* compiled from: BleEvents.kt */
    @Metadata(d1 = {"\u0000\f\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\u0018\u00002\u00020\u0001B\u0005¢\u0006\u0002\u0010\u0002¨\u0006\u0003"}, d2 = {"Lcom/sputnik/common/analytics/BleEvents$ClickBleOff;", "Lcom/sputnik/common/analytics/BleEvents;", "()V", "common_release"}, k = 1, mv = {1, 9, 0}, xi = 48)
    public static final class ClickBleOff extends BleEvents {
        public ClickBleOff() {
            super("clickBleOff", null, 2, 0 == true ? 1 : 0);
        }
    }

    /* compiled from: BleEvents.kt */
    @Metadata(d1 = {"\u0000\f\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\u0018\u00002\u00020\u0001B\u0005¢\u0006\u0002\u0010\u0002¨\u0006\u0003"}, d2 = {"Lcom/sputnik/common/analytics/BleEvents$ClickBleOff2;", "Lcom/sputnik/common/analytics/BleEvents;", "()V", "common_release"}, k = 1, mv = {1, 9, 0}, xi = 48)
    public static final class ClickBleOff2 extends BleEvents {
        public ClickBleOff2() {
            super("clickBleOff2", null, 2, 0 == true ? 1 : 0);
        }
    }

    /* compiled from: BleEvents.kt */
    @Metadata(d1 = {"\u0000\f\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\u0018\u00002\u00020\u0001B\u0005¢\u0006\u0002\u0010\u0002¨\u0006\u0003"}, d2 = {"Lcom/sputnik/common/analytics/BleEvents$ClickBlePermission;", "Lcom/sputnik/common/analytics/BleEvents;", "()V", "common_release"}, k = 1, mv = {1, 9, 0}, xi = 48)
    public static final class ClickBlePermission extends BleEvents {
        public ClickBlePermission() {
            super("clickBlePermission", null, 2, 0 == true ? 1 : 0);
        }
    }

    /* compiled from: BleEvents.kt */
    @Metadata(d1 = {"\u0000\f\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\u0018\u00002\u00020\u0001B\u0005¢\u0006\u0002\u0010\u0002¨\u0006\u0003"}, d2 = {"Lcom/sputnik/common/analytics/BleEvents$ClickBleSignalLevel;", "Lcom/sputnik/common/analytics/BleEvents;", "()V", "common_release"}, k = 1, mv = {1, 9, 0}, xi = 48)
    public static final class ClickBleSignalLevel extends BleEvents {
        public ClickBleSignalLevel() {
            super("clickBleSignalLevel", null, 2, 0 == true ? 1 : 0);
        }
    }

    /* compiled from: BleEvents.kt */
    @Metadata(d1 = {"\u0000\f\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\u0018\u00002\u00020\u0001B\u0005¢\u0006\u0002\u0010\u0002¨\u0006\u0003"}, d2 = {"Lcom/sputnik/common/analytics/BleEvents$ClickBleOpeningDistance;", "Lcom/sputnik/common/analytics/BleEvents;", "()V", "common_release"}, k = 1, mv = {1, 9, 0}, xi = 48)
    public static final class ClickBleOpeningDistance extends BleEvents {
        public ClickBleOpeningDistance() {
            super("clickBleOpeningDistance", null, 2, 0 == true ? 1 : 0);
        }
    }

    /* compiled from: BleEvents.kt */
    @Metadata(d1 = {"\u0000\f\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\u0018\u00002\u00020\u0001B\u0005¢\u0006\u0002\u0010\u0002¨\u0006\u0003"}, d2 = {"Lcom/sputnik/common/analytics/BleEvents$ClickBleSubscriptionSettings;", "Lcom/sputnik/common/analytics/BleEvents;", "()V", "common_release"}, k = 1, mv = {1, 9, 0}, xi = 48)
    public static final class ClickBleSubscriptionSettings extends BleEvents {
        public ClickBleSubscriptionSettings() {
            super("clickBleSubscriptionSettings", null, 2, 0 == true ? 1 : 0);
        }
    }

    /* compiled from: BleEvents.kt */
    @Metadata(d1 = {"\u0000\f\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\u0018\u00002\u00020\u0001B\u0005¢\u0006\u0002\u0010\u0002¨\u0006\u0003"}, d2 = {"Lcom/sputnik/common/analytics/BleEvents$ClickBleSignalLevel2;", "Lcom/sputnik/common/analytics/BleEvents;", "()V", "common_release"}, k = 1, mv = {1, 9, 0}, xi = 48)
    public static final class ClickBleSignalLevel2 extends BleEvents {
        public ClickBleSignalLevel2() {
            super("clickBleSignalLevel2", null, 2, 0 == true ? 1 : 0);
        }
    }

    /* compiled from: BleEvents.kt */
    @Metadata(d1 = {"\u0000\f\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\u0018\u00002\u00020\u0001B\u0005¢\u0006\u0002\u0010\u0002¨\u0006\u0003"}, d2 = {"Lcom/sputnik/common/analytics/BleEvents$ClickBleExcellent;", "Lcom/sputnik/common/analytics/BleEvents;", "()V", "common_release"}, k = 1, mv = {1, 9, 0}, xi = 48)
    public static final class ClickBleExcellent extends BleEvents {
        public ClickBleExcellent() {
            super("clickBleExcellent", null, 2, 0 == true ? 1 : 0);
        }
    }

    /* compiled from: BleEvents.kt */
    @Metadata(d1 = {"\u0000\f\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\u0018\u00002\u00020\u0001B\u0005¢\u0006\u0002\u0010\u0002¨\u0006\u0003"}, d2 = {"Lcom/sputnik/common/analytics/BleEvents$ShowBleSuccess;", "Lcom/sputnik/common/analytics/BleEvents;", "()V", "common_release"}, k = 1, mv = {1, 9, 0}, xi = 48)
    public static final class ShowBleSuccess extends BleEvents {
        public ShowBleSuccess() {
            super("showBleSuccess", null, 2, 0 == true ? 1 : 0);
        }
    }

    /* compiled from: BleEvents.kt */
    @Metadata(d1 = {"\u0000\f\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\u0018\u00002\u00020\u0001B\u0005¢\u0006\u0002\u0010\u0002¨\u0006\u0003"}, d2 = {"Lcom/sputnik/common/analytics/BleEvents$ShowBleError;", "Lcom/sputnik/common/analytics/BleEvents;", "()V", "common_release"}, k = 1, mv = {1, 9, 0}, xi = 48)
    public static final class ShowBleError extends BleEvents {
        public ShowBleError() {
            super("showBleError", null, 2, 0 == true ? 1 : 0);
        }
    }

    /* compiled from: BleEvents.kt */
    @Metadata(d1 = {"\u0000\f\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\u0018\u00002\u00020\u0001B\u0005¢\u0006\u0002\u0010\u0002¨\u0006\u0003"}, d2 = {"Lcom/sputnik/common/analytics/BleEvents$ShowPermissionModalMainScreenTweak;", "Lcom/sputnik/common/analytics/BleEvents;", "()V", "common_release"}, k = 1, mv = {1, 9, 0}, xi = 48)
    public static final class ShowPermissionModalMainScreenTweak extends BleEvents {
        public ShowPermissionModalMainScreenTweak() {
            super("showPermissionModalMainScreenTweak", null, 2, 0 == true ? 1 : 0);
        }
    }

    /* compiled from: BleEvents.kt */
    @Metadata(d1 = {"\u0000\f\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\u0018\u00002\u00020\u0001B\u0005¢\u0006\u0002\u0010\u0002¨\u0006\u0003"}, d2 = {"Lcom/sputnik/common/analytics/BleEvents$ShowPermissionModalMainScreenSkip;", "Lcom/sputnik/common/analytics/BleEvents;", "()V", "common_release"}, k = 1, mv = {1, 9, 0}, xi = 48)
    public static final class ShowPermissionModalMainScreenSkip extends BleEvents {
        public ShowPermissionModalMainScreenSkip() {
            super("showPermissionModalMainScreenSkip", null, 2, 0 == true ? 1 : 0);
        }
    }

    /* compiled from: BleEvents.kt */
    @Metadata(d1 = {"\u0000\f\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\u0018\u00002\u00020\u0001B\u0005¢\u0006\u0002\u0010\u0002¨\u0006\u0003"}, d2 = {"Lcom/sputnik/common/analytics/BleEvents$ShowPermissionModalOnBLETweak;", "Lcom/sputnik/common/analytics/BleEvents;", "()V", "common_release"}, k = 1, mv = {1, 9, 0}, xi = 48)
    public static final class ShowPermissionModalOnBLETweak extends BleEvents {
        public ShowPermissionModalOnBLETweak() {
            super("showPermissionModalOnBLETweak", null, 2, 0 == true ? 1 : 0);
        }
    }

    /* compiled from: BleEvents.kt */
    @Metadata(d1 = {"\u0000\f\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\u0018\u00002\u00020\u0001B\u0005¢\u0006\u0002\u0010\u0002¨\u0006\u0003"}, d2 = {"Lcom/sputnik/common/analytics/BleEvents$ShowPermissionModalOnBLESkip;", "Lcom/sputnik/common/analytics/BleEvents;", "()V", "common_release"}, k = 1, mv = {1, 9, 0}, xi = 48)
    public static final class ShowPermissionModalOnBLESkip extends BleEvents {
        public ShowPermissionModalOnBLESkip() {
            super("showPermissionModalOnBLESkip", null, 2, 0 == true ? 1 : 0);
        }
    }

    /* compiled from: BleEvents.kt */
    @Metadata(d1 = {"\u0000\f\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\u0018\u00002\u00020\u0001B\u0005¢\u0006\u0002\u0010\u0002¨\u0006\u0003"}, d2 = {"Lcom/sputnik/common/analytics/BleEvents$ShowPermissionModalRSSITweak;", "Lcom/sputnik/common/analytics/BleEvents;", "()V", "common_release"}, k = 1, mv = {1, 9, 0}, xi = 48)
    public static final class ShowPermissionModalRSSITweak extends BleEvents {
        public ShowPermissionModalRSSITweak() {
            super("showPermissionModalRSSITweak", null, 2, 0 == true ? 1 : 0);
        }
    }

    /* compiled from: BleEvents.kt */
    @Metadata(d1 = {"\u0000\f\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\u0018\u00002\u00020\u0001B\u0005¢\u0006\u0002\u0010\u0002¨\u0006\u0003"}, d2 = {"Lcom/sputnik/common/analytics/BleEvents$ShowPermissionModalRSSISkip;", "Lcom/sputnik/common/analytics/BleEvents;", "()V", "common_release"}, k = 1, mv = {1, 9, 0}, xi = 48)
    public static final class ShowPermissionModalRSSISkip extends BleEvents {
        public ShowPermissionModalRSSISkip() {
            super("showPermissionModalRSSISkip", null, 2, 0 == true ? 1 : 0);
        }
    }

    /* compiled from: BleEvents.kt */
    @Metadata(d1 = {"\u0000\f\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\u0018\u00002\u00020\u0001B\u0005¢\u0006\u0002\u0010\u0002¨\u0006\u0003"}, d2 = {"Lcom/sputnik/common/analytics/BleEvents$StateBlePromoOff;", "Lcom/sputnik/common/analytics/BleEvents;", "()V", "common_release"}, k = 1, mv = {1, 9, 0}, xi = 48)
    public static final class StateBlePromoOff extends BleEvents {
        public StateBlePromoOff() {
            super("stateBlePromoOff", null, 2, 0 == true ? 1 : 0);
        }
    }
}

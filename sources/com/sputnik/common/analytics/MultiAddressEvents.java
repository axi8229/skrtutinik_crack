package com.sputnik.common.analytics;

import com.google.android.gms.measurement.api.AppMeasurementSdk;
import com.sputnik.common.analytics.AnalyticsTracker;
import kotlin.Metadata;
import kotlin.jvm.internal.DefaultConstructorMarker;

/* compiled from: MultiAddressEvents.kt */
@Metadata(d1 = {"\u00008\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u000b\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\b6\u0018\u00002\u00020\u0001:\t\u0006\u0007\b\t\n\u000b\f\r\u000eB\u001b\b\u0004\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\n\b\u0002\u0010\u0004\u001a\u0004\u0018\u00010\u0003¢\u0006\u0002\u0010\u0005\u0082\u0001\t\u000f\u0010\u0011\u0012\u0013\u0014\u0015\u0016\u0017¨\u0006\u0018"}, d2 = {"Lcom/sputnik/common/analytics/MultiAddressEvents;", "Lcom/sputnik/common/analytics/AnalyticsTracker$Event;", AppMeasurementSdk.ConditionalUserProperty.NAME, "", AppMeasurementSdk.ConditionalUserProperty.VALUE, "(Ljava/lang/String;Ljava/lang/String;)V", "ClickAddAddress", "ClickNearToIntercomBtn", "ClickProfileAddressTile", "ShowAddressInfoSheet", "ShowBlockedAddressCallSettings", "ShowBlockedAddressSelect", "StateAddressAdded", "StateAddressDeferredAddComplete", "StateAddressUnlinked", "Lcom/sputnik/common/analytics/MultiAddressEvents$ClickAddAddress;", "Lcom/sputnik/common/analytics/MultiAddressEvents$ClickNearToIntercomBtn;", "Lcom/sputnik/common/analytics/MultiAddressEvents$ClickProfileAddressTile;", "Lcom/sputnik/common/analytics/MultiAddressEvents$ShowAddressInfoSheet;", "Lcom/sputnik/common/analytics/MultiAddressEvents$ShowBlockedAddressCallSettings;", "Lcom/sputnik/common/analytics/MultiAddressEvents$ShowBlockedAddressSelect;", "Lcom/sputnik/common/analytics/MultiAddressEvents$StateAddressAdded;", "Lcom/sputnik/common/analytics/MultiAddressEvents$StateAddressDeferredAddComplete;", "Lcom/sputnik/common/analytics/MultiAddressEvents$StateAddressUnlinked;", "common_release"}, k = 1, mv = {1, 9, 0}, xi = 48)
/* loaded from: classes3.dex */
public abstract class MultiAddressEvents extends AnalyticsTracker.Event {
    public /* synthetic */ MultiAddressEvents(String str, String str2, DefaultConstructorMarker defaultConstructorMarker) {
        this(str, str2);
    }

    public /* synthetic */ MultiAddressEvents(String str, String str2, int i, DefaultConstructorMarker defaultConstructorMarker) {
        this(str, (i & 2) != 0 ? null : str2, null);
    }

    private MultiAddressEvents(String str, String str2) {
        super("Address", str, str2);
    }

    /* compiled from: MultiAddressEvents.kt */
    @Metadata(d1 = {"\u0000\u0012\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000b\n\u0002\b\u0002\u0018\u00002\u00020\u0001B\r\u0012\u0006\u0010\u0002\u001a\u00020\u0003¢\u0006\u0002\u0010\u0004¨\u0006\u0005"}, d2 = {"Lcom/sputnik/common/analytics/MultiAddressEvents$StateAddressAdded;", "Lcom/sputnik/common/analytics/MultiAddressEvents;", "isFirstAddress", "", "(Z)V", "common_release"}, k = 1, mv = {1, 9, 0}, xi = 48)
    public static final class StateAddressAdded extends MultiAddressEvents {
        public StateAddressAdded(boolean z) {
            super("stateAddressAdded", z ? "first" : "additional", null);
        }
    }

    /* compiled from: MultiAddressEvents.kt */
    @Metadata(d1 = {"\u0000\f\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\u0018\u00002\u00020\u0001B\u0005¢\u0006\u0002\u0010\u0002¨\u0006\u0003"}, d2 = {"Lcom/sputnik/common/analytics/MultiAddressEvents$ClickAddAddress;", "Lcom/sputnik/common/analytics/MultiAddressEvents;", "()V", "common_release"}, k = 1, mv = {1, 9, 0}, xi = 48)
    public static final class ClickAddAddress extends MultiAddressEvents {
        public ClickAddAddress() {
            super("clickAddAddress", null, 2, 0 == true ? 1 : 0);
        }
    }

    /* compiled from: MultiAddressEvents.kt */
    @Metadata(d1 = {"\u0000\u0012\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000b\n\u0002\b\u0002\u0018\u00002\u00020\u0001B\r\u0012\u0006\u0010\u0002\u001a\u00020\u0003¢\u0006\u0002\u0010\u0004¨\u0006\u0005"}, d2 = {"Lcom/sputnik/common/analytics/MultiAddressEvents$ClickNearToIntercomBtn;", "Lcom/sputnik/common/analytics/MultiAddressEvents;", "isFirstAddress", "", "(Z)V", "common_release"}, k = 1, mv = {1, 9, 0}, xi = 48)
    public static final class ClickNearToIntercomBtn extends MultiAddressEvents {
        public ClickNearToIntercomBtn(boolean z) {
            super("clickNearToIntercomBtn", z ? "first" : "additional", null);
        }
    }

    /* compiled from: MultiAddressEvents.kt */
    @Metadata(d1 = {"\u0000\u0012\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000b\n\u0002\b\u0002\u0018\u00002\u00020\u0001B\r\u0012\u0006\u0010\u0002\u001a\u00020\u0003¢\u0006\u0002\u0010\u0004¨\u0006\u0005"}, d2 = {"Lcom/sputnik/common/analytics/MultiAddressEvents$StateAddressUnlinked;", "Lcom/sputnik/common/analytics/MultiAddressEvents;", "isFirstAddress", "", "(Z)V", "common_release"}, k = 1, mv = {1, 9, 0}, xi = 48)
    public static final class StateAddressUnlinked extends MultiAddressEvents {
        public StateAddressUnlinked(boolean z) {
            super("stateAddressUnlinked", z ? "first" : "additional", null);
        }
    }

    /* compiled from: MultiAddressEvents.kt */
    @Metadata(d1 = {"\u0000\f\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\u0018\u00002\u00020\u0001B\u0005¢\u0006\u0002\u0010\u0002¨\u0006\u0003"}, d2 = {"Lcom/sputnik/common/analytics/MultiAddressEvents$ShowAddressInfoSheet;", "Lcom/sputnik/common/analytics/MultiAddressEvents;", "()V", "common_release"}, k = 1, mv = {1, 9, 0}, xi = 48)
    public static final class ShowAddressInfoSheet extends MultiAddressEvents {
        public ShowAddressInfoSheet() {
            super("showAddressInfoSheet", null, 2, 0 == true ? 1 : 0);
        }
    }

    /* compiled from: MultiAddressEvents.kt */
    @Metadata(d1 = {"\u0000\f\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\u0018\u00002\u00020\u0001B\u0005¢\u0006\u0002\u0010\u0002¨\u0006\u0003"}, d2 = {"Lcom/sputnik/common/analytics/MultiAddressEvents$StateAddressDeferredAddComplete;", "Lcom/sputnik/common/analytics/MultiAddressEvents;", "()V", "common_release"}, k = 1, mv = {1, 9, 0}, xi = 48)
    public static final class StateAddressDeferredAddComplete extends MultiAddressEvents {
        public StateAddressDeferredAddComplete() {
            super("stateAddressDeferredAddComplete", null, 2, 0 == true ? 1 : 0);
        }
    }

    /* compiled from: MultiAddressEvents.kt */
    @Metadata(d1 = {"\u0000\f\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\u0018\u00002\u00020\u0001B\u0005¢\u0006\u0002\u0010\u0002¨\u0006\u0003"}, d2 = {"Lcom/sputnik/common/analytics/MultiAddressEvents$ShowBlockedAddressSelect;", "Lcom/sputnik/common/analytics/MultiAddressEvents;", "()V", "common_release"}, k = 1, mv = {1, 9, 0}, xi = 48)
    public static final class ShowBlockedAddressSelect extends MultiAddressEvents {
        public ShowBlockedAddressSelect() {
            super("showBlockedAddressSelect", null, 2, 0 == true ? 1 : 0);
        }
    }

    /* compiled from: MultiAddressEvents.kt */
    @Metadata(d1 = {"\u0000\f\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\u0018\u00002\u00020\u0001B\u0005¢\u0006\u0002\u0010\u0002¨\u0006\u0003"}, d2 = {"Lcom/sputnik/common/analytics/MultiAddressEvents$ClickProfileAddressTile;", "Lcom/sputnik/common/analytics/MultiAddressEvents;", "()V", "common_release"}, k = 1, mv = {1, 9, 0}, xi = 48)
    public static final class ClickProfileAddressTile extends MultiAddressEvents {
        public ClickProfileAddressTile() {
            super("clickProfileAddressTile", null, 2, 0 == true ? 1 : 0);
        }
    }

    /* compiled from: MultiAddressEvents.kt */
    @Metadata(d1 = {"\u0000\f\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\u0018\u00002\u00020\u0001B\u0005¢\u0006\u0002\u0010\u0002¨\u0006\u0003"}, d2 = {"Lcom/sputnik/common/analytics/MultiAddressEvents$ShowBlockedAddressCallSettings;", "Lcom/sputnik/common/analytics/MultiAddressEvents;", "()V", "common_release"}, k = 1, mv = {1, 9, 0}, xi = 48)
    public static final class ShowBlockedAddressCallSettings extends MultiAddressEvents {
        public ShowBlockedAddressCallSettings() {
            super("showBlockedAddressCallSettings", null, 2, 0 == true ? 1 : 0);
        }
    }
}

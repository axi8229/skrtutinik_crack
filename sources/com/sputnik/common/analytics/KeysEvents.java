package com.sputnik.common.analytics;

import com.google.android.gms.measurement.api.AppMeasurementSdk;
import com.sputnik.common.analytics.AnalyticsTracker;
import kotlin.Metadata;
import kotlin.jvm.internal.DefaultConstructorMarker;

/* compiled from: KeysEvents.kt */
@Metadata(d1 = {"\u0000^\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u000e\n\u0002\b\u0017\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\b6\u0018\u00002\u00020\u0001:\u0013\u0007\b\t\n\u000b\f\r\u000e\u000f\u0010\u0011\u0012\u0013\u0014\u0015\u0016\u0017\u0018\u0019B\u001d\b\u0004\u0012\u0006\u0010\u0003\u001a\u00020\u0002\u0012\n\b\u0002\u0010\u0004\u001a\u0004\u0018\u00010\u0002¢\u0006\u0004\b\u0005\u0010\u0006\u0082\u0001\u0013\u001a\u001b\u001c\u001d\u001e\u001f !\"#$%&'()*+,¨\u0006-"}, d2 = {"Lcom/sputnik/common/analytics/KeysEvents;", "Lcom/sputnik/common/analytics/AnalyticsTracker$Event;", "", AppMeasurementSdk.ConditionalUserProperty.NAME, AppMeasurementSdk.ConditionalUserProperty.VALUE, "<init>", "(Ljava/lang/String;Ljava/lang/String;)V", "ClickBlockKey", "ClickDeleteKey", "ClickGoCatalog", "ClickKeyBanner", "ClickKeyMarket", "ClickKeyRegister", "ClickKeySettings", "ClickUnlockKey", "ShowDetKeys", "ShowMyKeys", "StateBlockKeySuccessfull", "StateDeleteKey", "StateKeyAlreadyRegistredPopup", "StateKeyRegisterSuccessfull", "StateNumberIncorrectPopup", "StateSaveKeyName", "StateServerProblemPopup", "StateSubscribeKeyPopup", "StateUnlockKeySuccessfull", "Lcom/sputnik/common/analytics/KeysEvents$ClickBlockKey;", "Lcom/sputnik/common/analytics/KeysEvents$ClickDeleteKey;", "Lcom/sputnik/common/analytics/KeysEvents$ClickGoCatalog;", "Lcom/sputnik/common/analytics/KeysEvents$ClickKeyBanner;", "Lcom/sputnik/common/analytics/KeysEvents$ClickKeyMarket;", "Lcom/sputnik/common/analytics/KeysEvents$ClickKeyRegister;", "Lcom/sputnik/common/analytics/KeysEvents$ClickKeySettings;", "Lcom/sputnik/common/analytics/KeysEvents$ClickUnlockKey;", "Lcom/sputnik/common/analytics/KeysEvents$ShowDetKeys;", "Lcom/sputnik/common/analytics/KeysEvents$ShowMyKeys;", "Lcom/sputnik/common/analytics/KeysEvents$StateBlockKeySuccessfull;", "Lcom/sputnik/common/analytics/KeysEvents$StateDeleteKey;", "Lcom/sputnik/common/analytics/KeysEvents$StateKeyAlreadyRegistredPopup;", "Lcom/sputnik/common/analytics/KeysEvents$StateKeyRegisterSuccessfull;", "Lcom/sputnik/common/analytics/KeysEvents$StateNumberIncorrectPopup;", "Lcom/sputnik/common/analytics/KeysEvents$StateSaveKeyName;", "Lcom/sputnik/common/analytics/KeysEvents$StateServerProblemPopup;", "Lcom/sputnik/common/analytics/KeysEvents$StateSubscribeKeyPopup;", "Lcom/sputnik/common/analytics/KeysEvents$StateUnlockKeySuccessfull;", "common_release"}, k = 1, mv = {1, 9, 0}, xi = 48)
/* loaded from: classes3.dex */
public abstract class KeysEvents extends AnalyticsTracker.Event {
    public /* synthetic */ KeysEvents(String str, String str2, DefaultConstructorMarker defaultConstructorMarker) {
        this(str, str2);
    }

    public /* synthetic */ KeysEvents(String str, String str2, int i, DefaultConstructorMarker defaultConstructorMarker) {
        this(str, (i & 2) != 0 ? null : str2, null);
    }

    private KeysEvents(String str, String str2) {
        super("Keys", str, str2);
    }

    /* compiled from: KeysEvents.kt */
    @Metadata(d1 = {"\u0000\f\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\u0018\u00002\u00020\u0001B\u0005¢\u0006\u0002\u0010\u0002¨\u0006\u0003"}, d2 = {"Lcom/sputnik/common/analytics/KeysEvents$ShowMyKeys;", "Lcom/sputnik/common/analytics/KeysEvents;", "()V", "common_release"}, k = 1, mv = {1, 9, 0}, xi = 48)
    public static final class ShowMyKeys extends KeysEvents {
        public ShowMyKeys() {
            super("showMyKeys", null, 2, 0 == true ? 1 : 0);
        }
    }

    /* compiled from: KeysEvents.kt */
    @Metadata(d1 = {"\u0000\f\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\u0018\u00002\u00020\u0001B\u0005¢\u0006\u0002\u0010\u0002¨\u0006\u0003"}, d2 = {"Lcom/sputnik/common/analytics/KeysEvents$ClickKeyRegister;", "Lcom/sputnik/common/analytics/KeysEvents;", "()V", "common_release"}, k = 1, mv = {1, 9, 0}, xi = 48)
    public static final class ClickKeyRegister extends KeysEvents {
        public ClickKeyRegister() {
            super("clickKeyRegister", null, 2, 0 == true ? 1 : 0);
        }
    }

    /* compiled from: KeysEvents.kt */
    @Metadata(d1 = {"\u0000\f\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\u0018\u00002\u00020\u0001B\u0005¢\u0006\u0002\u0010\u0002¨\u0006\u0003"}, d2 = {"Lcom/sputnik/common/analytics/KeysEvents$ClickKeyBanner;", "Lcom/sputnik/common/analytics/KeysEvents;", "()V", "common_release"}, k = 1, mv = {1, 9, 0}, xi = 48)
    public static final class ClickKeyBanner extends KeysEvents {
        public ClickKeyBanner() {
            super("clickKeyBanner", null, 2, 0 == true ? 1 : 0);
        }
    }

    /* compiled from: KeysEvents.kt */
    @Metadata(d1 = {"\u0000\f\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\u0018\u00002\u00020\u0001B\u0005¢\u0006\u0002\u0010\u0002¨\u0006\u0003"}, d2 = {"Lcom/sputnik/common/analytics/KeysEvents$StateSubscribeKeyPopup;", "Lcom/sputnik/common/analytics/KeysEvents;", "()V", "common_release"}, k = 1, mv = {1, 9, 0}, xi = 48)
    public static final class StateSubscribeKeyPopup extends KeysEvents {
        public StateSubscribeKeyPopup() {
            super("stateSubscribeKeyPopup", null, 2, 0 == true ? 1 : 0);
        }
    }

    /* compiled from: KeysEvents.kt */
    @Metadata(d1 = {"\u0000\f\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\u0018\u00002\u00020\u0001B\u0005¢\u0006\u0002\u0010\u0002¨\u0006\u0003"}, d2 = {"Lcom/sputnik/common/analytics/KeysEvents$StateKeyRegisterSuccessfull;", "Lcom/sputnik/common/analytics/KeysEvents;", "()V", "common_release"}, k = 1, mv = {1, 9, 0}, xi = 48)
    public static final class StateKeyRegisterSuccessfull extends KeysEvents {
        public StateKeyRegisterSuccessfull() {
            super("stateKeyRegisterSuccessfull", null, 2, 0 == true ? 1 : 0);
        }
    }

    /* compiled from: KeysEvents.kt */
    @Metadata(d1 = {"\u0000\f\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\u0018\u00002\u00020\u0001B\u0005¢\u0006\u0002\u0010\u0002¨\u0006\u0003"}, d2 = {"Lcom/sputnik/common/analytics/KeysEvents$StateKeyAlreadyRegistredPopup;", "Lcom/sputnik/common/analytics/KeysEvents;", "()V", "common_release"}, k = 1, mv = {1, 9, 0}, xi = 48)
    public static final class StateKeyAlreadyRegistredPopup extends KeysEvents {
        public StateKeyAlreadyRegistredPopup() {
            super("stateKeyAlreadyRegistredPopup", null, 2, 0 == true ? 1 : 0);
        }
    }

    /* compiled from: KeysEvents.kt */
    @Metadata(d1 = {"\u0000\f\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\u0018\u00002\u00020\u0001B\u0005¢\u0006\u0002\u0010\u0002¨\u0006\u0003"}, d2 = {"Lcom/sputnik/common/analytics/KeysEvents$StateNumberIncorrectPopup;", "Lcom/sputnik/common/analytics/KeysEvents;", "()V", "common_release"}, k = 1, mv = {1, 9, 0}, xi = 48)
    public static final class StateNumberIncorrectPopup extends KeysEvents {
        public StateNumberIncorrectPopup() {
            super("stateNumberIncorrectPopup", null, 2, 0 == true ? 1 : 0);
        }
    }

    /* compiled from: KeysEvents.kt */
    @Metadata(d1 = {"\u0000\f\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\u0018\u00002\u00020\u0001B\u0005¢\u0006\u0002\u0010\u0002¨\u0006\u0003"}, d2 = {"Lcom/sputnik/common/analytics/KeysEvents$StateServerProblemPopup;", "Lcom/sputnik/common/analytics/KeysEvents;", "()V", "common_release"}, k = 1, mv = {1, 9, 0}, xi = 48)
    public static final class StateServerProblemPopup extends KeysEvents {
        public StateServerProblemPopup() {
            super("stateServerProblemPopup", null, 2, 0 == true ? 1 : 0);
        }
    }

    /* compiled from: KeysEvents.kt */
    @Metadata(d1 = {"\u0000\f\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\u0018\u00002\u00020\u0001B\u0005¢\u0006\u0002\u0010\u0002¨\u0006\u0003"}, d2 = {"Lcom/sputnik/common/analytics/KeysEvents$ClickKeySettings;", "Lcom/sputnik/common/analytics/KeysEvents;", "()V", "common_release"}, k = 1, mv = {1, 9, 0}, xi = 48)
    public static final class ClickKeySettings extends KeysEvents {
        public ClickKeySettings() {
            super("clickKeySettings", null, 2, 0 == true ? 1 : 0);
        }
    }

    /* compiled from: KeysEvents.kt */
    @Metadata(d1 = {"\u0000\f\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\u0018\u00002\u00020\u0001B\u0005¢\u0006\u0002\u0010\u0002¨\u0006\u0003"}, d2 = {"Lcom/sputnik/common/analytics/KeysEvents$StateSaveKeyName;", "Lcom/sputnik/common/analytics/KeysEvents;", "()V", "common_release"}, k = 1, mv = {1, 9, 0}, xi = 48)
    public static final class StateSaveKeyName extends KeysEvents {
        public StateSaveKeyName() {
            super("stateSaveKeyName", null, 2, 0 == true ? 1 : 0);
        }
    }

    /* compiled from: KeysEvents.kt */
    @Metadata(d1 = {"\u0000\f\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\u0018\u00002\u00020\u0001B\u0005¢\u0006\u0002\u0010\u0002¨\u0006\u0003"}, d2 = {"Lcom/sputnik/common/analytics/KeysEvents$ClickDeleteKey;", "Lcom/sputnik/common/analytics/KeysEvents;", "()V", "common_release"}, k = 1, mv = {1, 9, 0}, xi = 48)
    public static final class ClickDeleteKey extends KeysEvents {
        public ClickDeleteKey() {
            super("clickDeleteKey", null, 2, 0 == true ? 1 : 0);
        }
    }

    /* compiled from: KeysEvents.kt */
    @Metadata(d1 = {"\u0000\f\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\u0018\u00002\u00020\u0001B\u0005¢\u0006\u0002\u0010\u0002¨\u0006\u0003"}, d2 = {"Lcom/sputnik/common/analytics/KeysEvents$StateDeleteKey;", "Lcom/sputnik/common/analytics/KeysEvents;", "()V", "common_release"}, k = 1, mv = {1, 9, 0}, xi = 48)
    public static final class StateDeleteKey extends KeysEvents {
        public StateDeleteKey() {
            super("stateDeleteKey", null, 2, 0 == true ? 1 : 0);
        }
    }

    /* compiled from: KeysEvents.kt */
    @Metadata(d1 = {"\u0000\f\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\u0018\u00002\u00020\u0001B\u0005¢\u0006\u0002\u0010\u0002¨\u0006\u0003"}, d2 = {"Lcom/sputnik/common/analytics/KeysEvents$ClickBlockKey;", "Lcom/sputnik/common/analytics/KeysEvents;", "()V", "common_release"}, k = 1, mv = {1, 9, 0}, xi = 48)
    public static final class ClickBlockKey extends KeysEvents {
        public ClickBlockKey() {
            super("clickBlockKey", null, 2, 0 == true ? 1 : 0);
        }
    }

    /* compiled from: KeysEvents.kt */
    @Metadata(d1 = {"\u0000\f\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\u0018\u00002\u00020\u0001B\u0005¢\u0006\u0002\u0010\u0002¨\u0006\u0003"}, d2 = {"Lcom/sputnik/common/analytics/KeysEvents$StateBlockKeySuccessfull;", "Lcom/sputnik/common/analytics/KeysEvents;", "()V", "common_release"}, k = 1, mv = {1, 9, 0}, xi = 48)
    public static final class StateBlockKeySuccessfull extends KeysEvents {
        public StateBlockKeySuccessfull() {
            super("stateBlockKeySuccessfull", null, 2, 0 == true ? 1 : 0);
        }
    }

    /* compiled from: KeysEvents.kt */
    @Metadata(d1 = {"\u0000\f\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\u0018\u00002\u00020\u0001B\u0005¢\u0006\u0002\u0010\u0002¨\u0006\u0003"}, d2 = {"Lcom/sputnik/common/analytics/KeysEvents$ClickUnlockKey;", "Lcom/sputnik/common/analytics/KeysEvents;", "()V", "common_release"}, k = 1, mv = {1, 9, 0}, xi = 48)
    public static final class ClickUnlockKey extends KeysEvents {
        public ClickUnlockKey() {
            super("clickUnlockKey", null, 2, 0 == true ? 1 : 0);
        }
    }

    /* compiled from: KeysEvents.kt */
    @Metadata(d1 = {"\u0000\f\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\u0018\u00002\u00020\u0001B\u0005¢\u0006\u0002\u0010\u0002¨\u0006\u0003"}, d2 = {"Lcom/sputnik/common/analytics/KeysEvents$StateUnlockKeySuccessfull;", "Lcom/sputnik/common/analytics/KeysEvents;", "()V", "common_release"}, k = 1, mv = {1, 9, 0}, xi = 48)
    public static final class StateUnlockKeySuccessfull extends KeysEvents {
        public StateUnlockKeySuccessfull() {
            super("stateUnlockKeySuccessfull", null, 2, 0 == true ? 1 : 0);
        }
    }

    /* compiled from: KeysEvents.kt */
    @Metadata(d1 = {"\u0000\f\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\u0018\u00002\u00020\u0001B\u0005¢\u0006\u0002\u0010\u0002¨\u0006\u0003"}, d2 = {"Lcom/sputnik/common/analytics/KeysEvents$ClickKeyMarket;", "Lcom/sputnik/common/analytics/KeysEvents;", "()V", "common_release"}, k = 1, mv = {1, 9, 0}, xi = 48)
    public static final class ClickKeyMarket extends KeysEvents {
        public ClickKeyMarket() {
            super("clickKeyMarket", null, 2, 0 == true ? 1 : 0);
        }
    }

    /* compiled from: KeysEvents.kt */
    @Metadata(d1 = {"\u0000\f\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\u0018\u00002\u00020\u0001B\u0005¢\u0006\u0002\u0010\u0002¨\u0006\u0003"}, d2 = {"Lcom/sputnik/common/analytics/KeysEvents$ClickGoCatalog;", "Lcom/sputnik/common/analytics/KeysEvents;", "()V", "common_release"}, k = 1, mv = {1, 9, 0}, xi = 48)
    public static final class ClickGoCatalog extends KeysEvents {
        public ClickGoCatalog() {
            super("clickGoToCatalogBtn", null, 2, 0 == true ? 1 : 0);
        }
    }

    /* compiled from: KeysEvents.kt */
    @Metadata(d1 = {"\u0000\f\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\u0018\u00002\u00020\u0001B\u0005¢\u0006\u0002\u0010\u0002¨\u0006\u0003"}, d2 = {"Lcom/sputnik/common/analytics/KeysEvents$ShowDetKeys;", "Lcom/sputnik/common/analytics/KeysEvents;", "()V", "common_release"}, k = 1, mv = {1, 9, 0}, xi = 48)
    public static final class ShowDetKeys extends KeysEvents {
        public ShowDetKeys() {
            super("showDetKeys", null, 2, 0 == true ? 1 : 0);
        }
    }
}

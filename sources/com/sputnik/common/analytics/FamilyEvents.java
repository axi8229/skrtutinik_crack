package com.sputnik.common.analytics;

import com.google.android.gms.measurement.api.AppMeasurementSdk;
import com.sputnik.common.analytics.AnalyticsTracker;
import kotlin.Metadata;
import kotlin.jvm.internal.DefaultConstructorMarker;

/* compiled from: FamilyEvents.kt */
@Metadata(d1 = {"\u0000\\\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0014\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\b6\u0018\u00002\u00020\u0001:\u0012\u0006\u0007\b\t\n\u000b\f\r\u000e\u000f\u0010\u0011\u0012\u0013\u0014\u0015\u0016\u0017B\u001b\b\u0004\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\n\b\u0002\u0010\u0004\u001a\u0004\u0018\u00010\u0003¢\u0006\u0002\u0010\u0005\u0082\u0001\u0012\u0018\u0019\u001a\u001b\u001c\u001d\u001e\u001f !\"#$%&'()¨\u0006*"}, d2 = {"Lcom/sputnik/common/analytics/FamilyEvents;", "Lcom/sputnik/common/analytics/AnalyticsTracker$Event;", AppMeasurementSdk.ConditionalUserProperty.NAME, "", AppMeasurementSdk.ConditionalUserProperty.VALUE, "(Ljava/lang/String;Ljava/lang/String;)V", "ClickAcceptToTheFamily", "ClickAcceptToTheFamilyPartner", "ClickFamilyCancel", "ClickFamilyMakeAnAdmin", "ClickFamilyRemoveFromTheFamily", "ClickFamilyRemoveFromTheFamilyCancel", "ClickFamilyRemoveFromTheFamilyConfirm", "ClickFamilySendAnInvitation", "ClickInviteToTheFamily", "ClickInviteToTheFamilyAgain", "ClickInviteToTheFamilyAgainCancel", "ClickInviteToTheFamilyAgainConfirm", "ClickInviteToTheFamilyDelete", "ClickRejectToTheFamily", "ClickRejectToTheFamilyPartner", "ShowInviteToTheFamilyErrorScreen", "StateAcceptFromAdminSuccess", "StateAcceptFromPartnerSuccess", "Lcom/sputnik/common/analytics/FamilyEvents$ClickAcceptToTheFamily;", "Lcom/sputnik/common/analytics/FamilyEvents$ClickAcceptToTheFamilyPartner;", "Lcom/sputnik/common/analytics/FamilyEvents$ClickFamilyCancel;", "Lcom/sputnik/common/analytics/FamilyEvents$ClickFamilyMakeAnAdmin;", "Lcom/sputnik/common/analytics/FamilyEvents$ClickFamilyRemoveFromTheFamily;", "Lcom/sputnik/common/analytics/FamilyEvents$ClickFamilyRemoveFromTheFamilyCancel;", "Lcom/sputnik/common/analytics/FamilyEvents$ClickFamilyRemoveFromTheFamilyConfirm;", "Lcom/sputnik/common/analytics/FamilyEvents$ClickFamilySendAnInvitation;", "Lcom/sputnik/common/analytics/FamilyEvents$ClickInviteToTheFamily;", "Lcom/sputnik/common/analytics/FamilyEvents$ClickInviteToTheFamilyAgain;", "Lcom/sputnik/common/analytics/FamilyEvents$ClickInviteToTheFamilyAgainCancel;", "Lcom/sputnik/common/analytics/FamilyEvents$ClickInviteToTheFamilyAgainConfirm;", "Lcom/sputnik/common/analytics/FamilyEvents$ClickInviteToTheFamilyDelete;", "Lcom/sputnik/common/analytics/FamilyEvents$ClickRejectToTheFamily;", "Lcom/sputnik/common/analytics/FamilyEvents$ClickRejectToTheFamilyPartner;", "Lcom/sputnik/common/analytics/FamilyEvents$ShowInviteToTheFamilyErrorScreen;", "Lcom/sputnik/common/analytics/FamilyEvents$StateAcceptFromAdminSuccess;", "Lcom/sputnik/common/analytics/FamilyEvents$StateAcceptFromPartnerSuccess;", "common_release"}, k = 1, mv = {1, 9, 0}, xi = 48)
/* loaded from: classes3.dex */
public abstract class FamilyEvents extends AnalyticsTracker.Event {
    public /* synthetic */ FamilyEvents(String str, String str2, DefaultConstructorMarker defaultConstructorMarker) {
        this(str, str2);
    }

    public /* synthetic */ FamilyEvents(String str, String str2, int i, DefaultConstructorMarker defaultConstructorMarker) {
        this(str, (i & 2) != 0 ? null : str2, null);
    }

    private FamilyEvents(String str, String str2) {
        super("Family", str, str2);
    }

    /* compiled from: FamilyEvents.kt */
    @Metadata(d1 = {"\u0000\f\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\u0018\u00002\u00020\u0001B\u0005¢\u0006\u0002\u0010\u0002¨\u0006\u0003"}, d2 = {"Lcom/sputnik/common/analytics/FamilyEvents$ClickInviteToTheFamily;", "Lcom/sputnik/common/analytics/FamilyEvents;", "()V", "common_release"}, k = 1, mv = {1, 9, 0}, xi = 48)
    public static final class ClickInviteToTheFamily extends FamilyEvents {
        public ClickInviteToTheFamily() {
            super("clickInviteToTheFamily", null, 2, 0 == true ? 1 : 0);
        }
    }

    /* compiled from: FamilyEvents.kt */
    @Metadata(d1 = {"\u0000\f\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\u0018\u00002\u00020\u0001B\u0005¢\u0006\u0002\u0010\u0002¨\u0006\u0003"}, d2 = {"Lcom/sputnik/common/analytics/FamilyEvents$ClickFamilySendAnInvitation;", "Lcom/sputnik/common/analytics/FamilyEvents;", "()V", "common_release"}, k = 1, mv = {1, 9, 0}, xi = 48)
    public static final class ClickFamilySendAnInvitation extends FamilyEvents {
        public ClickFamilySendAnInvitation() {
            super("clickFamilySendAnInvitation", null, 2, 0 == true ? 1 : 0);
        }
    }

    /* compiled from: FamilyEvents.kt */
    @Metadata(d1 = {"\u0000\f\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\u0018\u00002\u00020\u0001B\u0005¢\u0006\u0002\u0010\u0002¨\u0006\u0003"}, d2 = {"Lcom/sputnik/common/analytics/FamilyEvents$ClickFamilyCancel;", "Lcom/sputnik/common/analytics/FamilyEvents;", "()V", "common_release"}, k = 1, mv = {1, 9, 0}, xi = 48)
    public static final class ClickFamilyCancel extends FamilyEvents {
        public ClickFamilyCancel() {
            super("clickFamilyCancel", null, 2, 0 == true ? 1 : 0);
        }
    }

    /* compiled from: FamilyEvents.kt */
    @Metadata(d1 = {"\u0000\f\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\u0018\u00002\u00020\u0001B\u0005¢\u0006\u0002\u0010\u0002¨\u0006\u0003"}, d2 = {"Lcom/sputnik/common/analytics/FamilyEvents$ClickFamilyMakeAnAdmin;", "Lcom/sputnik/common/analytics/FamilyEvents;", "()V", "common_release"}, k = 1, mv = {1, 9, 0}, xi = 48)
    public static final class ClickFamilyMakeAnAdmin extends FamilyEvents {
        public ClickFamilyMakeAnAdmin() {
            super("clickFamilyMakeAnAdmin", null, 2, 0 == true ? 1 : 0);
        }
    }

    /* compiled from: FamilyEvents.kt */
    @Metadata(d1 = {"\u0000\f\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\u0018\u00002\u00020\u0001B\u0005¢\u0006\u0002\u0010\u0002¨\u0006\u0003"}, d2 = {"Lcom/sputnik/common/analytics/FamilyEvents$ClickFamilyRemoveFromTheFamily;", "Lcom/sputnik/common/analytics/FamilyEvents;", "()V", "common_release"}, k = 1, mv = {1, 9, 0}, xi = 48)
    public static final class ClickFamilyRemoveFromTheFamily extends FamilyEvents {
        public ClickFamilyRemoveFromTheFamily() {
            super("clickFamilyRemoveFromTheFamily", null, 2, 0 == true ? 1 : 0);
        }
    }

    /* compiled from: FamilyEvents.kt */
    @Metadata(d1 = {"\u0000\f\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\u0018\u00002\u00020\u0001B\u0005¢\u0006\u0002\u0010\u0002¨\u0006\u0003"}, d2 = {"Lcom/sputnik/common/analytics/FamilyEvents$ClickFamilyRemoveFromTheFamilyConfirm;", "Lcom/sputnik/common/analytics/FamilyEvents;", "()V", "common_release"}, k = 1, mv = {1, 9, 0}, xi = 48)
    public static final class ClickFamilyRemoveFromTheFamilyConfirm extends FamilyEvents {
        public ClickFamilyRemoveFromTheFamilyConfirm() {
            super("clickFamilyRemoveFromTheFamilyConfirm", null, 2, 0 == true ? 1 : 0);
        }
    }

    /* compiled from: FamilyEvents.kt */
    @Metadata(d1 = {"\u0000\f\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\u0018\u00002\u00020\u0001B\u0005¢\u0006\u0002\u0010\u0002¨\u0006\u0003"}, d2 = {"Lcom/sputnik/common/analytics/FamilyEvents$ClickFamilyRemoveFromTheFamilyCancel;", "Lcom/sputnik/common/analytics/FamilyEvents;", "()V", "common_release"}, k = 1, mv = {1, 9, 0}, xi = 48)
    public static final class ClickFamilyRemoveFromTheFamilyCancel extends FamilyEvents {
        public ClickFamilyRemoveFromTheFamilyCancel() {
            super("clickFamilyRemoveFromTheFamilyCancel", null, 2, 0 == true ? 1 : 0);
        }
    }

    /* compiled from: FamilyEvents.kt */
    @Metadata(d1 = {"\u0000\f\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\u0018\u00002\u00020\u0001B\u0005¢\u0006\u0002\u0010\u0002¨\u0006\u0003"}, d2 = {"Lcom/sputnik/common/analytics/FamilyEvents$ClickInviteToTheFamilyAgain;", "Lcom/sputnik/common/analytics/FamilyEvents;", "()V", "common_release"}, k = 1, mv = {1, 9, 0}, xi = 48)
    public static final class ClickInviteToTheFamilyAgain extends FamilyEvents {
        public ClickInviteToTheFamilyAgain() {
            super("clickInviteToTheFamilyAgain", null, 2, 0 == true ? 1 : 0);
        }
    }

    /* compiled from: FamilyEvents.kt */
    @Metadata(d1 = {"\u0000\f\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\u0018\u00002\u00020\u0001B\u0005¢\u0006\u0002\u0010\u0002¨\u0006\u0003"}, d2 = {"Lcom/sputnik/common/analytics/FamilyEvents$ClickInviteToTheFamilyDelete;", "Lcom/sputnik/common/analytics/FamilyEvents;", "()V", "common_release"}, k = 1, mv = {1, 9, 0}, xi = 48)
    public static final class ClickInviteToTheFamilyDelete extends FamilyEvents {
        public ClickInviteToTheFamilyDelete() {
            super("clickInviteToTheFamilyDelete", null, 2, 0 == true ? 1 : 0);
        }
    }

    /* compiled from: FamilyEvents.kt */
    @Metadata(d1 = {"\u0000\f\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\u0018\u00002\u00020\u0001B\u0005¢\u0006\u0002\u0010\u0002¨\u0006\u0003"}, d2 = {"Lcom/sputnik/common/analytics/FamilyEvents$ClickInviteToTheFamilyAgainConfirm;", "Lcom/sputnik/common/analytics/FamilyEvents;", "()V", "common_release"}, k = 1, mv = {1, 9, 0}, xi = 48)
    public static final class ClickInviteToTheFamilyAgainConfirm extends FamilyEvents {
        public ClickInviteToTheFamilyAgainConfirm() {
            super("clickInviteToTheFamilyAgainConfirm", null, 2, 0 == true ? 1 : 0);
        }
    }

    /* compiled from: FamilyEvents.kt */
    @Metadata(d1 = {"\u0000\f\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\u0018\u00002\u00020\u0001B\u0005¢\u0006\u0002\u0010\u0002¨\u0006\u0003"}, d2 = {"Lcom/sputnik/common/analytics/FamilyEvents$ClickInviteToTheFamilyAgainCancel;", "Lcom/sputnik/common/analytics/FamilyEvents;", "()V", "common_release"}, k = 1, mv = {1, 9, 0}, xi = 48)
    public static final class ClickInviteToTheFamilyAgainCancel extends FamilyEvents {
        public ClickInviteToTheFamilyAgainCancel() {
            super("clickInviteToTheFamilyAgainCancel", null, 2, 0 == true ? 1 : 0);
        }
    }

    /* compiled from: FamilyEvents.kt */
    @Metadata(d1 = {"\u0000\f\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\u0018\u00002\u00020\u0001B\u0005¢\u0006\u0002\u0010\u0002¨\u0006\u0003"}, d2 = {"Lcom/sputnik/common/analytics/FamilyEvents$ClickAcceptToTheFamily;", "Lcom/sputnik/common/analytics/FamilyEvents;", "()V", "common_release"}, k = 1, mv = {1, 9, 0}, xi = 48)
    public static final class ClickAcceptToTheFamily extends FamilyEvents {
        public ClickAcceptToTheFamily() {
            super("clickAcceptToTheFamily", null, 2, 0 == true ? 1 : 0);
        }
    }

    /* compiled from: FamilyEvents.kt */
    @Metadata(d1 = {"\u0000\f\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\u0018\u00002\u00020\u0001B\u0005¢\u0006\u0002\u0010\u0002¨\u0006\u0003"}, d2 = {"Lcom/sputnik/common/analytics/FamilyEvents$ClickRejectToTheFamily;", "Lcom/sputnik/common/analytics/FamilyEvents;", "()V", "common_release"}, k = 1, mv = {1, 9, 0}, xi = 48)
    public static final class ClickRejectToTheFamily extends FamilyEvents {
        public ClickRejectToTheFamily() {
            super("clickRejectToTheFamily", null, 2, 0 == true ? 1 : 0);
        }
    }

    /* compiled from: FamilyEvents.kt */
    @Metadata(d1 = {"\u0000\f\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\u0018\u00002\u00020\u0001B\u0005¢\u0006\u0002\u0010\u0002¨\u0006\u0003"}, d2 = {"Lcom/sputnik/common/analytics/FamilyEvents$ShowInviteToTheFamilyErrorScreen;", "Lcom/sputnik/common/analytics/FamilyEvents;", "()V", "common_release"}, k = 1, mv = {1, 9, 0}, xi = 48)
    public static final class ShowInviteToTheFamilyErrorScreen extends FamilyEvents {
        public ShowInviteToTheFamilyErrorScreen() {
            super("showInviteToTheFamilyErrorScreen", null, 2, 0 == true ? 1 : 0);
        }
    }

    /* compiled from: FamilyEvents.kt */
    @Metadata(d1 = {"\u0000\f\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\u0018\u00002\u00020\u0001B\u0005¢\u0006\u0002\u0010\u0002¨\u0006\u0003"}, d2 = {"Lcom/sputnik/common/analytics/FamilyEvents$ClickAcceptToTheFamilyPartner;", "Lcom/sputnik/common/analytics/FamilyEvents;", "()V", "common_release"}, k = 1, mv = {1, 9, 0}, xi = 48)
    public static final class ClickAcceptToTheFamilyPartner extends FamilyEvents {
        public ClickAcceptToTheFamilyPartner() {
            super("clickAcceptToTheFamilyPartner", null, 2, 0 == true ? 1 : 0);
        }
    }

    /* compiled from: FamilyEvents.kt */
    @Metadata(d1 = {"\u0000\f\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\u0018\u00002\u00020\u0001B\u0005¢\u0006\u0002\u0010\u0002¨\u0006\u0003"}, d2 = {"Lcom/sputnik/common/analytics/FamilyEvents$ClickRejectToTheFamilyPartner;", "Lcom/sputnik/common/analytics/FamilyEvents;", "()V", "common_release"}, k = 1, mv = {1, 9, 0}, xi = 48)
    public static final class ClickRejectToTheFamilyPartner extends FamilyEvents {
        public ClickRejectToTheFamilyPartner() {
            super("clickRejectToTheFamilyPartner", null, 2, 0 == true ? 1 : 0);
        }
    }

    /* compiled from: FamilyEvents.kt */
    @Metadata(d1 = {"\u0000\f\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\u0018\u00002\u00020\u0001B\u0005¢\u0006\u0002\u0010\u0002¨\u0006\u0003"}, d2 = {"Lcom/sputnik/common/analytics/FamilyEvents$StateAcceptFromAdminSuccess;", "Lcom/sputnik/common/analytics/FamilyEvents;", "()V", "common_release"}, k = 1, mv = {1, 9, 0}, xi = 48)
    public static final class StateAcceptFromAdminSuccess extends FamilyEvents {
        public StateAcceptFromAdminSuccess() {
            super("stateAcceptFromAdminSuccess", null, 2, 0 == true ? 1 : 0);
        }
    }

    /* compiled from: FamilyEvents.kt */
    @Metadata(d1 = {"\u0000\f\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\u0018\u00002\u00020\u0001B\u0005¢\u0006\u0002\u0010\u0002¨\u0006\u0003"}, d2 = {"Lcom/sputnik/common/analytics/FamilyEvents$StateAcceptFromPartnerSuccess;", "Lcom/sputnik/common/analytics/FamilyEvents;", "()V", "common_release"}, k = 1, mv = {1, 9, 0}, xi = 48)
    public static final class StateAcceptFromPartnerSuccess extends FamilyEvents {
        public StateAcceptFromPartnerSuccess() {
            super("stateAcceptFromPartnerSuccess", null, 2, 0 == true ? 1 : 0);
        }
    }
}

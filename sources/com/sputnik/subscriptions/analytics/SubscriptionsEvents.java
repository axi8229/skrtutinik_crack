package com.sputnik.subscriptions.analytics;

import com.google.android.gms.measurement.api.AppMeasurementSdk;
import com.sputnik.common.analytics.AnalyticsTracker;
import kotlin.Metadata;
import kotlin.jvm.internal.DefaultConstructorMarker;

/* compiled from: SubscriptionsEvents.kt */
@Metadata(d1 = {"\u0000Ò\u0001\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u000e\n\u0002\b4\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\b6\u0018\u00002\u00020\u0001:0\u0007\b\t\n\u000b\f\r\u000e\u000f\u0010\u0011\u0012\u0013\u0014\u0015\u0016\u0017\u0018\u0019\u001a\u001b\u001c\u001d\u001e\u001f !\"#$%&'()*+,-./0123456B\u001d\b\u0004\u0012\u0006\u0010\u0003\u001a\u00020\u0002\u0012\n\b\u0002\u0010\u0004\u001a\u0004\u0018\u00010\u0002¢\u0006\u0004\b\u0005\u0010\u0006\u0082\u00010789:;<=>?@ABCDEFGHIJKLMNOPQRSTUVWXYZ[\\]^_`abcdef¨\u0006g"}, d2 = {"Lcom/sputnik/subscriptions/analytics/SubscriptionsEvents;", "Lcom/sputnik/common/analytics/AnalyticsTracker$Event;", "", AppMeasurementSdk.ConditionalUserProperty.NAME, AppMeasurementSdk.ConditionalUserProperty.VALUE, "<init>", "(Ljava/lang/String;Ljava/lang/String;)V", "ClickArch3SubsProfile", "ClickArch7SubsProfile", "ClickBuyMarketStandardDetails", "ClickCodesSubsProfile", "ClickFacerecSubsProfile", "ClickMarket", "ClickMarketPremiumDetArch7", "ClickMarketPremiumDetArch7DescPayment", "ClickMarketPremiumDetCallLog", "ClickMarketPremiumDetCallLogDescPayment", "ClickMarketPremiumDetCodes", "ClickMarketPremiumDetCodesDescPayment", "ClickMarketPremiumDetFacerec", "ClickMarketPremiumDetFacerecDescPayment", "ClickMarketServ", "ClickMarketServPartnerOfferCustom", "ClickMarketStandardDetArch3", "ClickMarketStandardDetArch3DescPayment", "ClickMarketStandardDetBleDescPayment", "ClickMarketStandardDetCallLog", "ClickMarketStandardDetCallLogDescPayment", "ClickMarketStandardDetCodes", "ClickMarketStandardDetCodesDescPayment", "ClickMarketStandardDetFastLoadingDescPayment", "ClickMarketSubs", "ClickMarketSubsPremiumDet", "ClickMarketSubsPremiumDetPayment", "ClickMarketSubsPremiumPayment", "ClickMarketSubsStandardDet", "ClickMarketSubsStandardDetPayment", "ClickMarketSubsStandardPayment", "ClickSeeAllHistoryBtn", "ClickWantPromoInCallLog", "ClickWantPromoInProfile", "ClickWantPromoStandardPayment", "ShowDetFastLoading", "SuccessPremiumPurchase", "SuccessStandardPurchase", "ViewMarketPremiumDetArch7Desc", "ViewMarketPremiumDetCallLogDesc", "ViewMarketPremiumDetCodesDesc", "ViewMarketPremiumDetFacerecDesc", "ViewMarketStandardDetArch3Desc", "ViewMarketStandardDetBle", "ViewMarketStandardDetCallLogDesc", "ViewMarketStandardDetCodesDesc", "ViewWantPromoStandardDesc", "СlickBleSubsProfile", "Lcom/sputnik/subscriptions/analytics/SubscriptionsEvents$ClickArch3SubsProfile;", "Lcom/sputnik/subscriptions/analytics/SubscriptionsEvents$ClickArch7SubsProfile;", "Lcom/sputnik/subscriptions/analytics/SubscriptionsEvents$ClickBuyMarketStandardDetails;", "Lcom/sputnik/subscriptions/analytics/SubscriptionsEvents$ClickCodesSubsProfile;", "Lcom/sputnik/subscriptions/analytics/SubscriptionsEvents$ClickFacerecSubsProfile;", "Lcom/sputnik/subscriptions/analytics/SubscriptionsEvents$ClickMarket;", "Lcom/sputnik/subscriptions/analytics/SubscriptionsEvents$ClickMarketPremiumDetArch7;", "Lcom/sputnik/subscriptions/analytics/SubscriptionsEvents$ClickMarketPremiumDetArch7DescPayment;", "Lcom/sputnik/subscriptions/analytics/SubscriptionsEvents$ClickMarketPremiumDetCallLog;", "Lcom/sputnik/subscriptions/analytics/SubscriptionsEvents$ClickMarketPremiumDetCallLogDescPayment;", "Lcom/sputnik/subscriptions/analytics/SubscriptionsEvents$ClickMarketPremiumDetCodes;", "Lcom/sputnik/subscriptions/analytics/SubscriptionsEvents$ClickMarketPremiumDetCodesDescPayment;", "Lcom/sputnik/subscriptions/analytics/SubscriptionsEvents$ClickMarketPremiumDetFacerec;", "Lcom/sputnik/subscriptions/analytics/SubscriptionsEvents$ClickMarketPremiumDetFacerecDescPayment;", "Lcom/sputnik/subscriptions/analytics/SubscriptionsEvents$ClickMarketServ;", "Lcom/sputnik/subscriptions/analytics/SubscriptionsEvents$ClickMarketServPartnerOfferCustom;", "Lcom/sputnik/subscriptions/analytics/SubscriptionsEvents$ClickMarketStandardDetArch3;", "Lcom/sputnik/subscriptions/analytics/SubscriptionsEvents$ClickMarketStandardDetArch3DescPayment;", "Lcom/sputnik/subscriptions/analytics/SubscriptionsEvents$ClickMarketStandardDetBleDescPayment;", "Lcom/sputnik/subscriptions/analytics/SubscriptionsEvents$ClickMarketStandardDetCallLog;", "Lcom/sputnik/subscriptions/analytics/SubscriptionsEvents$ClickMarketStandardDetCallLogDescPayment;", "Lcom/sputnik/subscriptions/analytics/SubscriptionsEvents$ClickMarketStandardDetCodes;", "Lcom/sputnik/subscriptions/analytics/SubscriptionsEvents$ClickMarketStandardDetCodesDescPayment;", "Lcom/sputnik/subscriptions/analytics/SubscriptionsEvents$ClickMarketStandardDetFastLoadingDescPayment;", "Lcom/sputnik/subscriptions/analytics/SubscriptionsEvents$ClickMarketSubs;", "Lcom/sputnik/subscriptions/analytics/SubscriptionsEvents$ClickMarketSubsPremiumDet;", "Lcom/sputnik/subscriptions/analytics/SubscriptionsEvents$ClickMarketSubsPremiumDetPayment;", "Lcom/sputnik/subscriptions/analytics/SubscriptionsEvents$ClickMarketSubsPremiumPayment;", "Lcom/sputnik/subscriptions/analytics/SubscriptionsEvents$ClickMarketSubsStandardDet;", "Lcom/sputnik/subscriptions/analytics/SubscriptionsEvents$ClickMarketSubsStandardDetPayment;", "Lcom/sputnik/subscriptions/analytics/SubscriptionsEvents$ClickMarketSubsStandardPayment;", "Lcom/sputnik/subscriptions/analytics/SubscriptionsEvents$ClickSeeAllHistoryBtn;", "Lcom/sputnik/subscriptions/analytics/SubscriptionsEvents$ClickWantPromoInCallLog;", "Lcom/sputnik/subscriptions/analytics/SubscriptionsEvents$ClickWantPromoInProfile;", "Lcom/sputnik/subscriptions/analytics/SubscriptionsEvents$ClickWantPromoStandardPayment;", "Lcom/sputnik/subscriptions/analytics/SubscriptionsEvents$ShowDetFastLoading;", "Lcom/sputnik/subscriptions/analytics/SubscriptionsEvents$SuccessPremiumPurchase;", "Lcom/sputnik/subscriptions/analytics/SubscriptionsEvents$SuccessStandardPurchase;", "Lcom/sputnik/subscriptions/analytics/SubscriptionsEvents$ViewMarketPremiumDetArch7Desc;", "Lcom/sputnik/subscriptions/analytics/SubscriptionsEvents$ViewMarketPremiumDetCallLogDesc;", "Lcom/sputnik/subscriptions/analytics/SubscriptionsEvents$ViewMarketPremiumDetCodesDesc;", "Lcom/sputnik/subscriptions/analytics/SubscriptionsEvents$ViewMarketPremiumDetFacerecDesc;", "Lcom/sputnik/subscriptions/analytics/SubscriptionsEvents$ViewMarketStandardDetArch3Desc;", "Lcom/sputnik/subscriptions/analytics/SubscriptionsEvents$ViewMarketStandardDetBle;", "Lcom/sputnik/subscriptions/analytics/SubscriptionsEvents$ViewMarketStandardDetCallLogDesc;", "Lcom/sputnik/subscriptions/analytics/SubscriptionsEvents$ViewMarketStandardDetCodesDesc;", "Lcom/sputnik/subscriptions/analytics/SubscriptionsEvents$ViewWantPromoStandardDesc;", "Lcom/sputnik/subscriptions/analytics/SubscriptionsEvents$СlickBleSubsProfile;", "subscriptions_release"}, k = 1, mv = {1, 9, 0}, xi = 48)
/* loaded from: classes3.dex */
public abstract class SubscriptionsEvents extends AnalyticsTracker.Event {
    public /* synthetic */ SubscriptionsEvents(String str, String str2, DefaultConstructorMarker defaultConstructorMarker) {
        this(str, str2);
    }

    public /* synthetic */ SubscriptionsEvents(String str, String str2, int i, DefaultConstructorMarker defaultConstructorMarker) {
        this(str, (i & 2) != 0 ? null : str2, null);
    }

    private SubscriptionsEvents(String str, String str2) {
        super("Subs", str, str2);
    }

    /* compiled from: SubscriptionsEvents.kt */
    @Metadata(d1 = {"\u0000\f\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\u0018\u00002\u00020\u0001B\u0005¢\u0006\u0002\u0010\u0002¨\u0006\u0003"}, d2 = {"Lcom/sputnik/subscriptions/analytics/SubscriptionsEvents$ClickMarket;", "Lcom/sputnik/subscriptions/analytics/SubscriptionsEvents;", "()V", "subscriptions_release"}, k = 1, mv = {1, 9, 0}, xi = 48)
    public static final class ClickMarket extends SubscriptionsEvents {
        public ClickMarket() {
            super("clickMarket", null, 2, 0 == true ? 1 : 0);
        }
    }

    /* compiled from: SubscriptionsEvents.kt */
    @Metadata(d1 = {"\u0000\f\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\u0018\u00002\u00020\u0001B\u0005¢\u0006\u0002\u0010\u0002¨\u0006\u0003"}, d2 = {"Lcom/sputnik/subscriptions/analytics/SubscriptionsEvents$ClickMarketSubs;", "Lcom/sputnik/subscriptions/analytics/SubscriptionsEvents;", "()V", "subscriptions_release"}, k = 1, mv = {1, 9, 0}, xi = 48)
    public static final class ClickMarketSubs extends SubscriptionsEvents {
        public ClickMarketSubs() {
            super("clickMarketSubs", null, 2, 0 == true ? 1 : 0);
        }
    }

    /* compiled from: SubscriptionsEvents.kt */
    @Metadata(d1 = {"\u0000\f\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\u0018\u00002\u00020\u0001B\u0005¢\u0006\u0002\u0010\u0002¨\u0006\u0003"}, d2 = {"Lcom/sputnik/subscriptions/analytics/SubscriptionsEvents$ClickMarketServ;", "Lcom/sputnik/subscriptions/analytics/SubscriptionsEvents;", "()V", "subscriptions_release"}, k = 1, mv = {1, 9, 0}, xi = 48)
    public static final class ClickMarketServ extends SubscriptionsEvents {
        public ClickMarketServ() {
            super("clickMarketServ", null, 2, 0 == true ? 1 : 0);
        }
    }

    /* compiled from: SubscriptionsEvents.kt */
    @Metadata(d1 = {"\u0000\f\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\u0018\u00002\u00020\u0001B\u0005¢\u0006\u0002\u0010\u0002¨\u0006\u0003"}, d2 = {"Lcom/sputnik/subscriptions/analytics/SubscriptionsEvents$ClickMarketServPartnerOfferCustom;", "Lcom/sputnik/subscriptions/analytics/SubscriptionsEvents;", "()V", "subscriptions_release"}, k = 1, mv = {1, 9, 0}, xi = 48)
    public static final class ClickMarketServPartnerOfferCustom extends SubscriptionsEvents {
        public ClickMarketServPartnerOfferCustom() {
            super("clickMarketServPartnerOfferCustom", null, 2, 0 == true ? 1 : 0);
        }
    }

    /* compiled from: SubscriptionsEvents.kt */
    @Metadata(d1 = {"\u0000\f\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\u0018\u00002\u00020\u0001B\u0005¢\u0006\u0002\u0010\u0002¨\u0006\u0003"}, d2 = {"Lcom/sputnik/subscriptions/analytics/SubscriptionsEvents$ClickMarketSubsStandardPayment;", "Lcom/sputnik/subscriptions/analytics/SubscriptionsEvents;", "()V", "subscriptions_release"}, k = 1, mv = {1, 9, 0}, xi = 48)
    public static final class ClickMarketSubsStandardPayment extends SubscriptionsEvents {
        public ClickMarketSubsStandardPayment() {
            super("clickMarketSubsStandardPayment", null, 2, 0 == true ? 1 : 0);
        }
    }

    /* compiled from: SubscriptionsEvents.kt */
    @Metadata(d1 = {"\u0000\f\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\u0018\u00002\u00020\u0001B\u0005¢\u0006\u0002\u0010\u0002¨\u0006\u0003"}, d2 = {"Lcom/sputnik/subscriptions/analytics/SubscriptionsEvents$ClickMarketSubsStandardDet;", "Lcom/sputnik/subscriptions/analytics/SubscriptionsEvents;", "()V", "subscriptions_release"}, k = 1, mv = {1, 9, 0}, xi = 48)
    public static final class ClickMarketSubsStandardDet extends SubscriptionsEvents {
        public ClickMarketSubsStandardDet() {
            super("clickMarketSubsStandardDet", null, 2, 0 == true ? 1 : 0);
        }
    }

    /* compiled from: SubscriptionsEvents.kt */
    @Metadata(d1 = {"\u0000\f\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\u0018\u00002\u00020\u0001B\u0005¢\u0006\u0002\u0010\u0002¨\u0006\u0003"}, d2 = {"Lcom/sputnik/subscriptions/analytics/SubscriptionsEvents$ClickMarketSubsStandardDetPayment;", "Lcom/sputnik/subscriptions/analytics/SubscriptionsEvents;", "()V", "subscriptions_release"}, k = 1, mv = {1, 9, 0}, xi = 48)
    public static final class ClickMarketSubsStandardDetPayment extends SubscriptionsEvents {
        public ClickMarketSubsStandardDetPayment() {
            super("clickMarketSubsStandardDetPayment", null, 2, 0 == true ? 1 : 0);
        }
    }

    /* compiled from: SubscriptionsEvents.kt */
    @Metadata(d1 = {"\u0000\f\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\u0018\u00002\u00020\u0001B\u0005¢\u0006\u0002\u0010\u0002¨\u0006\u0003"}, d2 = {"Lcom/sputnik/subscriptions/analytics/SubscriptionsEvents$ClickMarketStandardDetCodes;", "Lcom/sputnik/subscriptions/analytics/SubscriptionsEvents;", "()V", "subscriptions_release"}, k = 1, mv = {1, 9, 0}, xi = 48)
    public static final class ClickMarketStandardDetCodes extends SubscriptionsEvents {
        public ClickMarketStandardDetCodes() {
            super("clickMarketStandardDetCodes", null, 2, 0 == true ? 1 : 0);
        }
    }

    /* compiled from: SubscriptionsEvents.kt */
    @Metadata(d1 = {"\u0000\f\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\u0018\u00002\u00020\u0001B\u0005¢\u0006\u0002\u0010\u0002¨\u0006\u0003"}, d2 = {"Lcom/sputnik/subscriptions/analytics/SubscriptionsEvents$ViewMarketStandardDetCodesDesc;", "Lcom/sputnik/subscriptions/analytics/SubscriptionsEvents;", "()V", "subscriptions_release"}, k = 1, mv = {1, 9, 0}, xi = 48)
    public static final class ViewMarketStandardDetCodesDesc extends SubscriptionsEvents {
        public ViewMarketStandardDetCodesDesc() {
            super("viewMarketStandardDetCodesDesc", null, 2, 0 == true ? 1 : 0);
        }
    }

    /* compiled from: SubscriptionsEvents.kt */
    @Metadata(d1 = {"\u0000\f\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\u0018\u00002\u00020\u0001B\u0005¢\u0006\u0002\u0010\u0002¨\u0006\u0003"}, d2 = {"Lcom/sputnik/subscriptions/analytics/SubscriptionsEvents$ClickMarketStandardDetCodesDescPayment;", "Lcom/sputnik/subscriptions/analytics/SubscriptionsEvents;", "()V", "subscriptions_release"}, k = 1, mv = {1, 9, 0}, xi = 48)
    public static final class ClickMarketStandardDetCodesDescPayment extends SubscriptionsEvents {
        public ClickMarketStandardDetCodesDescPayment() {
            super("clickMarketStandardDetCodesDescPayment", null, 2, 0 == true ? 1 : 0);
        }
    }

    /* compiled from: SubscriptionsEvents.kt */
    @Metadata(d1 = {"\u0000\f\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\u0018\u00002\u00020\u0001B\u0005¢\u0006\u0002\u0010\u0002¨\u0006\u0003"}, d2 = {"Lcom/sputnik/subscriptions/analytics/SubscriptionsEvents$ClickMarketStandardDetArch3;", "Lcom/sputnik/subscriptions/analytics/SubscriptionsEvents;", "()V", "subscriptions_release"}, k = 1, mv = {1, 9, 0}, xi = 48)
    public static final class ClickMarketStandardDetArch3 extends SubscriptionsEvents {
        public ClickMarketStandardDetArch3() {
            super("clickMarketStandardDetArch3", null, 2, 0 == true ? 1 : 0);
        }
    }

    /* compiled from: SubscriptionsEvents.kt */
    @Metadata(d1 = {"\u0000\f\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\u0018\u00002\u00020\u0001B\u0005¢\u0006\u0002\u0010\u0002¨\u0006\u0003"}, d2 = {"Lcom/sputnik/subscriptions/analytics/SubscriptionsEvents$ViewMarketStandardDetArch3Desc;", "Lcom/sputnik/subscriptions/analytics/SubscriptionsEvents;", "()V", "subscriptions_release"}, k = 1, mv = {1, 9, 0}, xi = 48)
    public static final class ViewMarketStandardDetArch3Desc extends SubscriptionsEvents {
        public ViewMarketStandardDetArch3Desc() {
            super("viewMarketStandardDetArch3Desc", null, 2, 0 == true ? 1 : 0);
        }
    }

    /* compiled from: SubscriptionsEvents.kt */
    @Metadata(d1 = {"\u0000\f\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\u0018\u00002\u00020\u0001B\u0005¢\u0006\u0002\u0010\u0002¨\u0006\u0003"}, d2 = {"Lcom/sputnik/subscriptions/analytics/SubscriptionsEvents$ClickMarketStandardDetArch3DescPayment;", "Lcom/sputnik/subscriptions/analytics/SubscriptionsEvents;", "()V", "subscriptions_release"}, k = 1, mv = {1, 9, 0}, xi = 48)
    public static final class ClickMarketStandardDetArch3DescPayment extends SubscriptionsEvents {
        public ClickMarketStandardDetArch3DescPayment() {
            super("clickMarketStandardDetArch3DescPayment", null, 2, 0 == true ? 1 : 0);
        }
    }

    /* compiled from: SubscriptionsEvents.kt */
    @Metadata(d1 = {"\u0000\f\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\u0018\u00002\u00020\u0001B\u0005¢\u0006\u0002\u0010\u0002¨\u0006\u0003"}, d2 = {"Lcom/sputnik/subscriptions/analytics/SubscriptionsEvents$ClickMarketStandardDetCallLog;", "Lcom/sputnik/subscriptions/analytics/SubscriptionsEvents;", "()V", "subscriptions_release"}, k = 1, mv = {1, 9, 0}, xi = 48)
    public static final class ClickMarketStandardDetCallLog extends SubscriptionsEvents {
        public ClickMarketStandardDetCallLog() {
            super("clickMarketStandardDetCallLog", null, 2, 0 == true ? 1 : 0);
        }
    }

    /* compiled from: SubscriptionsEvents.kt */
    @Metadata(d1 = {"\u0000\f\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\u0018\u00002\u00020\u0001B\u0005¢\u0006\u0002\u0010\u0002¨\u0006\u0003"}, d2 = {"Lcom/sputnik/subscriptions/analytics/SubscriptionsEvents$ViewMarketStandardDetCallLogDesc;", "Lcom/sputnik/subscriptions/analytics/SubscriptionsEvents;", "()V", "subscriptions_release"}, k = 1, mv = {1, 9, 0}, xi = 48)
    public static final class ViewMarketStandardDetCallLogDesc extends SubscriptionsEvents {
        public ViewMarketStandardDetCallLogDesc() {
            super("viewMarketStandardDetCallLogDesc", null, 2, 0 == true ? 1 : 0);
        }
    }

    /* compiled from: SubscriptionsEvents.kt */
    @Metadata(d1 = {"\u0000\f\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\u0018\u00002\u00020\u0001B\u0005¢\u0006\u0002\u0010\u0002¨\u0006\u0003"}, d2 = {"Lcom/sputnik/subscriptions/analytics/SubscriptionsEvents$ClickMarketStandardDetCallLogDescPayment;", "Lcom/sputnik/subscriptions/analytics/SubscriptionsEvents;", "()V", "subscriptions_release"}, k = 1, mv = {1, 9, 0}, xi = 48)
    public static final class ClickMarketStandardDetCallLogDescPayment extends SubscriptionsEvents {
        public ClickMarketStandardDetCallLogDescPayment() {
            super("clickMarketStandardDetCallLogDescPayment", null, 2, 0 == true ? 1 : 0);
        }
    }

    /* compiled from: SubscriptionsEvents.kt */
    @Metadata(d1 = {"\u0000\f\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\u0018\u00002\u00020\u0001B\u0005¢\u0006\u0002\u0010\u0002¨\u0006\u0003"}, d2 = {"Lcom/sputnik/subscriptions/analytics/SubscriptionsEvents$SuccessStandardPurchase;", "Lcom/sputnik/subscriptions/analytics/SubscriptionsEvents;", "()V", "subscriptions_release"}, k = 1, mv = {1, 9, 0}, xi = 48)
    public static final class SuccessStandardPurchase extends SubscriptionsEvents {
        public SuccessStandardPurchase() {
            super("successStandardPurchase", null, 2, 0 == true ? 1 : 0);
        }
    }

    /* compiled from: SubscriptionsEvents.kt */
    @Metadata(d1 = {"\u0000\f\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\u0018\u00002\u00020\u0001B\u0005¢\u0006\u0002\u0010\u0002¨\u0006\u0003"}, d2 = {"Lcom/sputnik/subscriptions/analytics/SubscriptionsEvents$ClickMarketSubsPremiumPayment;", "Lcom/sputnik/subscriptions/analytics/SubscriptionsEvents;", "()V", "subscriptions_release"}, k = 1, mv = {1, 9, 0}, xi = 48)
    public static final class ClickMarketSubsPremiumPayment extends SubscriptionsEvents {
        public ClickMarketSubsPremiumPayment() {
            super("clickMarketSubsPremiumPayment", null, 2, 0 == true ? 1 : 0);
        }
    }

    /* compiled from: SubscriptionsEvents.kt */
    @Metadata(d1 = {"\u0000\f\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\u0018\u00002\u00020\u0001B\u0005¢\u0006\u0002\u0010\u0002¨\u0006\u0003"}, d2 = {"Lcom/sputnik/subscriptions/analytics/SubscriptionsEvents$ClickMarketSubsPremiumDet;", "Lcom/sputnik/subscriptions/analytics/SubscriptionsEvents;", "()V", "subscriptions_release"}, k = 1, mv = {1, 9, 0}, xi = 48)
    public static final class ClickMarketSubsPremiumDet extends SubscriptionsEvents {
        public ClickMarketSubsPremiumDet() {
            super("clickMarketSubsPremiumDet", null, 2, 0 == true ? 1 : 0);
        }
    }

    /* compiled from: SubscriptionsEvents.kt */
    @Metadata(d1 = {"\u0000\f\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\u0018\u00002\u00020\u0001B\u0005¢\u0006\u0002\u0010\u0002¨\u0006\u0003"}, d2 = {"Lcom/sputnik/subscriptions/analytics/SubscriptionsEvents$ClickMarketSubsPremiumDetPayment;", "Lcom/sputnik/subscriptions/analytics/SubscriptionsEvents;", "()V", "subscriptions_release"}, k = 1, mv = {1, 9, 0}, xi = 48)
    public static final class ClickMarketSubsPremiumDetPayment extends SubscriptionsEvents {
        public ClickMarketSubsPremiumDetPayment() {
            super("clickMarketSubsPremiumDetPayment", null, 2, 0 == true ? 1 : 0);
        }
    }

    /* compiled from: SubscriptionsEvents.kt */
    @Metadata(d1 = {"\u0000\f\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\u0018\u00002\u00020\u0001B\u0005¢\u0006\u0002\u0010\u0002¨\u0006\u0003"}, d2 = {"Lcom/sputnik/subscriptions/analytics/SubscriptionsEvents$ClickMarketPremiumDetCodes;", "Lcom/sputnik/subscriptions/analytics/SubscriptionsEvents;", "()V", "subscriptions_release"}, k = 1, mv = {1, 9, 0}, xi = 48)
    public static final class ClickMarketPremiumDetCodes extends SubscriptionsEvents {
        public ClickMarketPremiumDetCodes() {
            super("clickMarketPremiumDetCodes", null, 2, 0 == true ? 1 : 0);
        }
    }

    /* compiled from: SubscriptionsEvents.kt */
    @Metadata(d1 = {"\u0000\f\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\u0018\u00002\u00020\u0001B\u0005¢\u0006\u0002\u0010\u0002¨\u0006\u0003"}, d2 = {"Lcom/sputnik/subscriptions/analytics/SubscriptionsEvents$ViewMarketPremiumDetCodesDesc;", "Lcom/sputnik/subscriptions/analytics/SubscriptionsEvents;", "()V", "subscriptions_release"}, k = 1, mv = {1, 9, 0}, xi = 48)
    public static final class ViewMarketPremiumDetCodesDesc extends SubscriptionsEvents {
        public ViewMarketPremiumDetCodesDesc() {
            super("viewMarketPremiumDetCodesDesc", null, 2, 0 == true ? 1 : 0);
        }
    }

    /* compiled from: SubscriptionsEvents.kt */
    @Metadata(d1 = {"\u0000\f\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\u0018\u00002\u00020\u0001B\u0005¢\u0006\u0002\u0010\u0002¨\u0006\u0003"}, d2 = {"Lcom/sputnik/subscriptions/analytics/SubscriptionsEvents$ClickMarketPremiumDetCodesDescPayment;", "Lcom/sputnik/subscriptions/analytics/SubscriptionsEvents;", "()V", "subscriptions_release"}, k = 1, mv = {1, 9, 0}, xi = 48)
    public static final class ClickMarketPremiumDetCodesDescPayment extends SubscriptionsEvents {
        public ClickMarketPremiumDetCodesDescPayment() {
            super("clickMarketPremiumDetCodesDescPayment", null, 2, 0 == true ? 1 : 0);
        }
    }

    /* compiled from: SubscriptionsEvents.kt */
    @Metadata(d1 = {"\u0000\f\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\u0018\u00002\u00020\u0001B\u0005¢\u0006\u0002\u0010\u0002¨\u0006\u0003"}, d2 = {"Lcom/sputnik/subscriptions/analytics/SubscriptionsEvents$ClickMarketPremiumDetArch7;", "Lcom/sputnik/subscriptions/analytics/SubscriptionsEvents;", "()V", "subscriptions_release"}, k = 1, mv = {1, 9, 0}, xi = 48)
    public static final class ClickMarketPremiumDetArch7 extends SubscriptionsEvents {
        public ClickMarketPremiumDetArch7() {
            super("clickMarketPremiumDetArch7", null, 2, 0 == true ? 1 : 0);
        }
    }

    /* compiled from: SubscriptionsEvents.kt */
    @Metadata(d1 = {"\u0000\f\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\u0018\u00002\u00020\u0001B\u0005¢\u0006\u0002\u0010\u0002¨\u0006\u0003"}, d2 = {"Lcom/sputnik/subscriptions/analytics/SubscriptionsEvents$ViewMarketPremiumDetArch7Desc;", "Lcom/sputnik/subscriptions/analytics/SubscriptionsEvents;", "()V", "subscriptions_release"}, k = 1, mv = {1, 9, 0}, xi = 48)
    public static final class ViewMarketPremiumDetArch7Desc extends SubscriptionsEvents {
        public ViewMarketPremiumDetArch7Desc() {
            super("viewMarketPremiumDetArch7Desc", null, 2, 0 == true ? 1 : 0);
        }
    }

    /* compiled from: SubscriptionsEvents.kt */
    @Metadata(d1 = {"\u0000\f\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\u0018\u00002\u00020\u0001B\u0005¢\u0006\u0002\u0010\u0002¨\u0006\u0003"}, d2 = {"Lcom/sputnik/subscriptions/analytics/SubscriptionsEvents$ClickMarketPremiumDetArch7DescPayment;", "Lcom/sputnik/subscriptions/analytics/SubscriptionsEvents;", "()V", "subscriptions_release"}, k = 1, mv = {1, 9, 0}, xi = 48)
    public static final class ClickMarketPremiumDetArch7DescPayment extends SubscriptionsEvents {
        public ClickMarketPremiumDetArch7DescPayment() {
            super("clickMarketPremiumDetArch7DescPayment", null, 2, 0 == true ? 1 : 0);
        }
    }

    /* compiled from: SubscriptionsEvents.kt */
    @Metadata(d1 = {"\u0000\f\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\u0018\u00002\u00020\u0001B\u0005¢\u0006\u0002\u0010\u0002¨\u0006\u0003"}, d2 = {"Lcom/sputnik/subscriptions/analytics/SubscriptionsEvents$ClickMarketPremiumDetCallLog;", "Lcom/sputnik/subscriptions/analytics/SubscriptionsEvents;", "()V", "subscriptions_release"}, k = 1, mv = {1, 9, 0}, xi = 48)
    public static final class ClickMarketPremiumDetCallLog extends SubscriptionsEvents {
        public ClickMarketPremiumDetCallLog() {
            super("clickMarketPremiumDetCallLog", null, 2, 0 == true ? 1 : 0);
        }
    }

    /* compiled from: SubscriptionsEvents.kt */
    @Metadata(d1 = {"\u0000\f\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\u0018\u00002\u00020\u0001B\u0005¢\u0006\u0002\u0010\u0002¨\u0006\u0003"}, d2 = {"Lcom/sputnik/subscriptions/analytics/SubscriptionsEvents$ViewMarketPremiumDetCallLogDesc;", "Lcom/sputnik/subscriptions/analytics/SubscriptionsEvents;", "()V", "subscriptions_release"}, k = 1, mv = {1, 9, 0}, xi = 48)
    public static final class ViewMarketPremiumDetCallLogDesc extends SubscriptionsEvents {
        public ViewMarketPremiumDetCallLogDesc() {
            super("viewMarketPremiumDetCallLogDesc", null, 2, 0 == true ? 1 : 0);
        }
    }

    /* compiled from: SubscriptionsEvents.kt */
    @Metadata(d1 = {"\u0000\f\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\u0018\u00002\u00020\u0001B\u0005¢\u0006\u0002\u0010\u0002¨\u0006\u0003"}, d2 = {"Lcom/sputnik/subscriptions/analytics/SubscriptionsEvents$ClickMarketPremiumDetCallLogDescPayment;", "Lcom/sputnik/subscriptions/analytics/SubscriptionsEvents;", "()V", "subscriptions_release"}, k = 1, mv = {1, 9, 0}, xi = 48)
    public static final class ClickMarketPremiumDetCallLogDescPayment extends SubscriptionsEvents {
        public ClickMarketPremiumDetCallLogDescPayment() {
            super("clickMarketPremiumDetCallLogDescPayment", null, 2, 0 == true ? 1 : 0);
        }
    }

    /* compiled from: SubscriptionsEvents.kt */
    @Metadata(d1 = {"\u0000\f\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\u0018\u00002\u00020\u0001B\u0005¢\u0006\u0002\u0010\u0002¨\u0006\u0003"}, d2 = {"Lcom/sputnik/subscriptions/analytics/SubscriptionsEvents$ClickMarketPremiumDetFacerec;", "Lcom/sputnik/subscriptions/analytics/SubscriptionsEvents;", "()V", "subscriptions_release"}, k = 1, mv = {1, 9, 0}, xi = 48)
    public static final class ClickMarketPremiumDetFacerec extends SubscriptionsEvents {
        public ClickMarketPremiumDetFacerec() {
            super("clickMarketPremiumDetFacerec", null, 2, 0 == true ? 1 : 0);
        }
    }

    /* compiled from: SubscriptionsEvents.kt */
    @Metadata(d1 = {"\u0000\f\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\u0018\u00002\u00020\u0001B\u0005¢\u0006\u0002\u0010\u0002¨\u0006\u0003"}, d2 = {"Lcom/sputnik/subscriptions/analytics/SubscriptionsEvents$ViewMarketPremiumDetFacerecDesc;", "Lcom/sputnik/subscriptions/analytics/SubscriptionsEvents;", "()V", "subscriptions_release"}, k = 1, mv = {1, 9, 0}, xi = 48)
    public static final class ViewMarketPremiumDetFacerecDesc extends SubscriptionsEvents {
        public ViewMarketPremiumDetFacerecDesc() {
            super("viewMarketPremiumDetFacerecDesc", null, 2, 0 == true ? 1 : 0);
        }
    }

    /* compiled from: SubscriptionsEvents.kt */
    @Metadata(d1 = {"\u0000\f\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\u0018\u00002\u00020\u0001B\u0005¢\u0006\u0002\u0010\u0002¨\u0006\u0003"}, d2 = {"Lcom/sputnik/subscriptions/analytics/SubscriptionsEvents$ClickMarketPremiumDetFacerecDescPayment;", "Lcom/sputnik/subscriptions/analytics/SubscriptionsEvents;", "()V", "subscriptions_release"}, k = 1, mv = {1, 9, 0}, xi = 48)
    public static final class ClickMarketPremiumDetFacerecDescPayment extends SubscriptionsEvents {
        public ClickMarketPremiumDetFacerecDescPayment() {
            super("clickMarketPremiumDetFacerecDescPayment", null, 2, 0 == true ? 1 : 0);
        }
    }

    /* compiled from: SubscriptionsEvents.kt */
    @Metadata(d1 = {"\u0000\f\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\u0018\u00002\u00020\u0001B\u0005¢\u0006\u0002\u0010\u0002¨\u0006\u0003"}, d2 = {"Lcom/sputnik/subscriptions/analytics/SubscriptionsEvents$SuccessPremiumPurchase;", "Lcom/sputnik/subscriptions/analytics/SubscriptionsEvents;", "()V", "subscriptions_release"}, k = 1, mv = {1, 9, 0}, xi = 48)
    public static final class SuccessPremiumPurchase extends SubscriptionsEvents {
        public SuccessPremiumPurchase() {
            super("successPremiumPurchase", null, 2, 0 == true ? 1 : 0);
        }
    }

    /* compiled from: SubscriptionsEvents.kt */
    @Metadata(d1 = {"\u0000\f\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\u0018\u00002\u00020\u0001B\u0005¢\u0006\u0002\u0010\u0002¨\u0006\u0003"}, d2 = {"Lcom/sputnik/subscriptions/analytics/SubscriptionsEvents$ClickWantPromoInCallLog;", "Lcom/sputnik/subscriptions/analytics/SubscriptionsEvents;", "()V", "subscriptions_release"}, k = 1, mv = {1, 9, 0}, xi = 48)
    public static final class ClickWantPromoInCallLog extends SubscriptionsEvents {
        public ClickWantPromoInCallLog() {
            super("clickWantPromoInCallLog", null, 2, 0 == true ? 1 : 0);
        }
    }

    /* compiled from: SubscriptionsEvents.kt */
    @Metadata(d1 = {"\u0000\f\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\u0018\u00002\u00020\u0001B\u0005¢\u0006\u0002\u0010\u0002¨\u0006\u0003"}, d2 = {"Lcom/sputnik/subscriptions/analytics/SubscriptionsEvents$ClickWantPromoInProfile;", "Lcom/sputnik/subscriptions/analytics/SubscriptionsEvents;", "()V", "subscriptions_release"}, k = 1, mv = {1, 9, 0}, xi = 48)
    public static final class ClickWantPromoInProfile extends SubscriptionsEvents {
        public ClickWantPromoInProfile() {
            super("clickWantPromoInProfile", null, 2, 0 == true ? 1 : 0);
        }
    }

    /* compiled from: SubscriptionsEvents.kt */
    @Metadata(d1 = {"\u0000\f\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\u0018\u00002\u00020\u0001B\u0005¢\u0006\u0002\u0010\u0002¨\u0006\u0003"}, d2 = {"Lcom/sputnik/subscriptions/analytics/SubscriptionsEvents$ViewWantPromoStandardDesc;", "Lcom/sputnik/subscriptions/analytics/SubscriptionsEvents;", "()V", "subscriptions_release"}, k = 1, mv = {1, 9, 0}, xi = 48)
    public static final class ViewWantPromoStandardDesc extends SubscriptionsEvents {
        public ViewWantPromoStandardDesc() {
            super("viewWantPromoStandardDesc", null, 2, 0 == true ? 1 : 0);
        }
    }

    /* compiled from: SubscriptionsEvents.kt */
    @Metadata(d1 = {"\u0000\f\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\u0018\u00002\u00020\u0001B\u0005¢\u0006\u0002\u0010\u0002¨\u0006\u0003"}, d2 = {"Lcom/sputnik/subscriptions/analytics/SubscriptionsEvents$ClickWantPromoStandardPayment;", "Lcom/sputnik/subscriptions/analytics/SubscriptionsEvents;", "()V", "subscriptions_release"}, k = 1, mv = {1, 9, 0}, xi = 48)
    public static final class ClickWantPromoStandardPayment extends SubscriptionsEvents {
        public ClickWantPromoStandardPayment() {
            super("clickWantPromoStandardPayment", null, 2, 0 == true ? 1 : 0);
        }
    }

    /* compiled from: SubscriptionsEvents.kt */
    @Metadata(d1 = {"\u0000\f\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\u0018\u00002\u00020\u0001B\u0005¢\u0006\u0002\u0010\u0002¨\u0006\u0003"}, d2 = {"Lcom/sputnik/subscriptions/analytics/SubscriptionsEvents$ClickCodesSubsProfile;", "Lcom/sputnik/subscriptions/analytics/SubscriptionsEvents;", "()V", "subscriptions_release"}, k = 1, mv = {1, 9, 0}, xi = 48)
    public static final class ClickCodesSubsProfile extends SubscriptionsEvents {
        public ClickCodesSubsProfile() {
            super("clickCodesSubsProfile", null, 2, 0 == true ? 1 : 0);
        }
    }

    /* compiled from: SubscriptionsEvents.kt */
    @Metadata(d1 = {"\u0000\f\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\u0018\u00002\u00020\u0001B\u0005¢\u0006\u0002\u0010\u0002¨\u0006\u0003"}, d2 = {"Lcom/sputnik/subscriptions/analytics/SubscriptionsEvents$ClickArch3SubsProfile;", "Lcom/sputnik/subscriptions/analytics/SubscriptionsEvents;", "()V", "subscriptions_release"}, k = 1, mv = {1, 9, 0}, xi = 48)
    public static final class ClickArch3SubsProfile extends SubscriptionsEvents {
        public ClickArch3SubsProfile() {
            super("clickArch3SubsProfile", null, 2, 0 == true ? 1 : 0);
        }
    }

    /* compiled from: SubscriptionsEvents.kt */
    @Metadata(d1 = {"\u0000\f\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\u0018\u00002\u00020\u0001B\u0005¢\u0006\u0002\u0010\u0002¨\u0006\u0003"}, d2 = {"Lcom/sputnik/subscriptions/analytics/SubscriptionsEvents$ClickArch7SubsProfile;", "Lcom/sputnik/subscriptions/analytics/SubscriptionsEvents;", "()V", "subscriptions_release"}, k = 1, mv = {1, 9, 0}, xi = 48)
    public static final class ClickArch7SubsProfile extends SubscriptionsEvents {
        public ClickArch7SubsProfile() {
            super("clickArch7SubsProfile", null, 2, 0 == true ? 1 : 0);
        }
    }

    /* compiled from: SubscriptionsEvents.kt */
    @Metadata(d1 = {"\u0000\f\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\u0018\u00002\u00020\u0001B\u0005¢\u0006\u0002\u0010\u0002¨\u0006\u0003"}, d2 = {"Lcom/sputnik/subscriptions/analytics/SubscriptionsEvents$ClickFacerecSubsProfile;", "Lcom/sputnik/subscriptions/analytics/SubscriptionsEvents;", "()V", "subscriptions_release"}, k = 1, mv = {1, 9, 0}, xi = 48)
    public static final class ClickFacerecSubsProfile extends SubscriptionsEvents {
        public ClickFacerecSubsProfile() {
            super("clickFacerecSubsProfile", null, 2, 0 == true ? 1 : 0);
        }
    }

    /* compiled from: SubscriptionsEvents.kt */
    @Metadata(d1 = {"\u0000\f\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\u0018\u00002\u00020\u0001B\u0005¢\u0006\u0002\u0010\u0002¨\u0006\u0003"}, d2 = {"Lcom/sputnik/subscriptions/analytics/SubscriptionsEvents$СlickBleSubsProfile;", "Lcom/sputnik/subscriptions/analytics/SubscriptionsEvents;", "()V", "subscriptions_release"}, k = 1, mv = {1, 9, 0}, xi = 48)
    /* renamed from: com.sputnik.subscriptions.analytics.SubscriptionsEvents$СlickBleSubsProfile, reason: invalid class name */
    public static final class lickBleSubsProfile extends SubscriptionsEvents {
        public lickBleSubsProfile() {
            super("clickBleSubsProfile", null, 2, 0 == true ? 1 : 0);
        }
    }

    /* compiled from: SubscriptionsEvents.kt */
    @Metadata(d1 = {"\u0000\f\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\u0018\u00002\u00020\u0001B\u0005¢\u0006\u0002\u0010\u0002¨\u0006\u0003"}, d2 = {"Lcom/sputnik/subscriptions/analytics/SubscriptionsEvents$ViewMarketStandardDetBle;", "Lcom/sputnik/subscriptions/analytics/SubscriptionsEvents;", "()V", "subscriptions_release"}, k = 1, mv = {1, 9, 0}, xi = 48)
    public static final class ViewMarketStandardDetBle extends SubscriptionsEvents {
        public ViewMarketStandardDetBle() {
            super("viewMarketStandardDetBle", null, 2, 0 == true ? 1 : 0);
        }
    }

    /* compiled from: SubscriptionsEvents.kt */
    @Metadata(d1 = {"\u0000\f\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\u0018\u00002\u00020\u0001B\u0005¢\u0006\u0002\u0010\u0002¨\u0006\u0003"}, d2 = {"Lcom/sputnik/subscriptions/analytics/SubscriptionsEvents$ClickMarketStandardDetBleDescPayment;", "Lcom/sputnik/subscriptions/analytics/SubscriptionsEvents;", "()V", "subscriptions_release"}, k = 1, mv = {1, 9, 0}, xi = 48)
    public static final class ClickMarketStandardDetBleDescPayment extends SubscriptionsEvents {
        public ClickMarketStandardDetBleDescPayment() {
            super("clickMarketStandardDetBleDescPayment", null, 2, 0 == true ? 1 : 0);
        }
    }

    /* compiled from: SubscriptionsEvents.kt */
    @Metadata(d1 = {"\u0000\f\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\u0018\u00002\u00020\u0001B\u0005¢\u0006\u0002\u0010\u0002¨\u0006\u0003"}, d2 = {"Lcom/sputnik/subscriptions/analytics/SubscriptionsEvents$ClickMarketStandardDetFastLoadingDescPayment;", "Lcom/sputnik/subscriptions/analytics/SubscriptionsEvents;", "()V", "subscriptions_release"}, k = 1, mv = {1, 9, 0}, xi = 48)
    public static final class ClickMarketStandardDetFastLoadingDescPayment extends SubscriptionsEvents {
        public ClickMarketStandardDetFastLoadingDescPayment() {
            super("clickMarketStandardDetFastLoadingDescPayment", null, 2, 0 == true ? 1 : 0);
        }
    }

    /* compiled from: SubscriptionsEvents.kt */
    @Metadata(d1 = {"\u0000\f\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\u0018\u00002\u00020\u0001B\u0005¢\u0006\u0002\u0010\u0002¨\u0006\u0003"}, d2 = {"Lcom/sputnik/subscriptions/analytics/SubscriptionsEvents$ShowDetFastLoading;", "Lcom/sputnik/subscriptions/analytics/SubscriptionsEvents;", "()V", "subscriptions_release"}, k = 1, mv = {1, 9, 0}, xi = 48)
    public static final class ShowDetFastLoading extends SubscriptionsEvents {
        public ShowDetFastLoading() {
            super("showDetFastLoading", null, 2, 0 == true ? 1 : 0);
        }
    }

    /* compiled from: SubscriptionsEvents.kt */
    @Metadata(d1 = {"\u0000\f\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\u0018\u00002\u00020\u0001B\u0005¢\u0006\u0002\u0010\u0002¨\u0006\u0003"}, d2 = {"Lcom/sputnik/subscriptions/analytics/SubscriptionsEvents$ClickBuyMarketStandardDetails;", "Lcom/sputnik/subscriptions/analytics/SubscriptionsEvents;", "()V", "subscriptions_release"}, k = 1, mv = {1, 9, 0}, xi = 48)
    public static final class ClickBuyMarketStandardDetails extends SubscriptionsEvents {
        public ClickBuyMarketStandardDetails() {
            super("clickBuyMarketStandardDetails", null, 2, 0 == true ? 1 : 0);
        }
    }

    /* compiled from: SubscriptionsEvents.kt */
    @Metadata(d1 = {"\u0000\f\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\u0018\u00002\u00020\u0001B\u0005¢\u0006\u0002\u0010\u0002¨\u0006\u0003"}, d2 = {"Lcom/sputnik/subscriptions/analytics/SubscriptionsEvents$ClickSeeAllHistoryBtn;", "Lcom/sputnik/subscriptions/analytics/SubscriptionsEvents;", "()V", "subscriptions_release"}, k = 1, mv = {1, 9, 0}, xi = 48)
    public static final class ClickSeeAllHistoryBtn extends SubscriptionsEvents {
        public ClickSeeAllHistoryBtn() {
            super("clickSeeAllHistoryBtn", null, 2, 0 == true ? 1 : 0);
        }
    }
}

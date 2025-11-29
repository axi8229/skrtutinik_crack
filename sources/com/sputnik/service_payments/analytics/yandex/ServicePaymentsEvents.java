package com.sputnik.service_payments.analytics.yandex;

import com.google.android.gms.measurement.api.AppMeasurementSdk;
import com.sputnik.common.analytics.AnalyticsTracker;
import kotlin.Metadata;
import kotlin.jvm.internal.DefaultConstructorMarker;

/* compiled from: ServicePaymentsEvents.kt */
@Metadata(d1 = {"\u0000l\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0018\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\b6\u0018\u00002\u00020\u0001:\u0016\u0006\u0007\b\t\n\u000b\f\r\u000e\u000f\u0010\u0011\u0012\u0013\u0014\u0015\u0016\u0017\u0018\u0019\u001a\u001bB\u001b\b\u0004\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\n\b\u0002\u0010\u0004\u001a\u0004\u0018\u00010\u0003¢\u0006\u0002\u0010\u0005\u0082\u0001\u0016\u001c\u001d\u001e\u001f !\"#$%&'()*+,-./01¨\u00062"}, d2 = {"Lcom/sputnik/service_payments/analytics/yandex/ServicePaymentsEvents;", "Lcom/sputnik/common/analytics/AnalyticsTracker$Event;", AppMeasurementSdk.ConditionalUserProperty.NAME, "", AppMeasurementSdk.ConditionalUserProperty.VALUE, "(Ljava/lang/String;Ljava/lang/String;)V", "ClickBackToProfileEvent", "ClickCloseBtnLimitPopupEvent", "ClickContinueButtonLimitPopupEvent", "ClickDisputeButtonEvent", "ClickHistoryDetailsEvent", "ClickHistoryPartnerInfoEvent", "ClickPaymentButtonBlockedEvent", "ClickPaymentButtonEvent", "ClickPaymentButtonLimitPopupEvent", "ClickPaymentContinueEvent", "ClickPromiseButtonBlockedEvent", "ClickServInUserProfile", "ClickSputnik1ButtonEvent", "ClickUsePromiseButtonBlocked", "FailPromiseBtnBlocked", "FailServPayment", "LoadAccrualEvent", "SuccessPromiseBtnBlocked", "SuccessServPayment", "ViewBlockedEvent", "ViewLimitedPopupEvent", "ViewPaymentsLogsEvent", "Lcom/sputnik/service_payments/analytics/yandex/ServicePaymentsEvents$ClickBackToProfileEvent;", "Lcom/sputnik/service_payments/analytics/yandex/ServicePaymentsEvents$ClickCloseBtnLimitPopupEvent;", "Lcom/sputnik/service_payments/analytics/yandex/ServicePaymentsEvents$ClickContinueButtonLimitPopupEvent;", "Lcom/sputnik/service_payments/analytics/yandex/ServicePaymentsEvents$ClickDisputeButtonEvent;", "Lcom/sputnik/service_payments/analytics/yandex/ServicePaymentsEvents$ClickHistoryDetailsEvent;", "Lcom/sputnik/service_payments/analytics/yandex/ServicePaymentsEvents$ClickHistoryPartnerInfoEvent;", "Lcom/sputnik/service_payments/analytics/yandex/ServicePaymentsEvents$ClickPaymentButtonBlockedEvent;", "Lcom/sputnik/service_payments/analytics/yandex/ServicePaymentsEvents$ClickPaymentButtonEvent;", "Lcom/sputnik/service_payments/analytics/yandex/ServicePaymentsEvents$ClickPaymentButtonLimitPopupEvent;", "Lcom/sputnik/service_payments/analytics/yandex/ServicePaymentsEvents$ClickPaymentContinueEvent;", "Lcom/sputnik/service_payments/analytics/yandex/ServicePaymentsEvents$ClickPromiseButtonBlockedEvent;", "Lcom/sputnik/service_payments/analytics/yandex/ServicePaymentsEvents$ClickServInUserProfile;", "Lcom/sputnik/service_payments/analytics/yandex/ServicePaymentsEvents$ClickSputnik1ButtonEvent;", "Lcom/sputnik/service_payments/analytics/yandex/ServicePaymentsEvents$ClickUsePromiseButtonBlocked;", "Lcom/sputnik/service_payments/analytics/yandex/ServicePaymentsEvents$FailPromiseBtnBlocked;", "Lcom/sputnik/service_payments/analytics/yandex/ServicePaymentsEvents$FailServPayment;", "Lcom/sputnik/service_payments/analytics/yandex/ServicePaymentsEvents$LoadAccrualEvent;", "Lcom/sputnik/service_payments/analytics/yandex/ServicePaymentsEvents$SuccessPromiseBtnBlocked;", "Lcom/sputnik/service_payments/analytics/yandex/ServicePaymentsEvents$SuccessServPayment;", "Lcom/sputnik/service_payments/analytics/yandex/ServicePaymentsEvents$ViewBlockedEvent;", "Lcom/sputnik/service_payments/analytics/yandex/ServicePaymentsEvents$ViewLimitedPopupEvent;", "Lcom/sputnik/service_payments/analytics/yandex/ServicePaymentsEvents$ViewPaymentsLogsEvent;", "service_payments_release"}, k = 1, mv = {1, 9, 0}, xi = 48)
/* loaded from: classes3.dex */
public abstract class ServicePaymentsEvents extends AnalyticsTracker.Event {
    public /* synthetic */ ServicePaymentsEvents(String str, String str2, DefaultConstructorMarker defaultConstructorMarker) {
        this(str, str2);
    }

    public /* synthetic */ ServicePaymentsEvents(String str, String str2, int i, DefaultConstructorMarker defaultConstructorMarker) {
        this(str, (i & 2) != 0 ? null : str2, null);
    }

    private ServicePaymentsEvents(String str, String str2) {
        super("Serv", str, str2);
    }

    /* compiled from: ServicePaymentsEvents.kt */
    @Metadata(d1 = {"\u0000\f\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\u0018\u00002\u00020\u0001B\u0005¢\u0006\u0002\u0010\u0002¨\u0006\u0003"}, d2 = {"Lcom/sputnik/service_payments/analytics/yandex/ServicePaymentsEvents$LoadAccrualEvent;", "Lcom/sputnik/service_payments/analytics/yandex/ServicePaymentsEvents;", "()V", "service_payments_release"}, k = 1, mv = {1, 9, 0}, xi = 48)
    public static final class LoadAccrualEvent extends ServicePaymentsEvents {
        public LoadAccrualEvent() {
            super("loadAccrual", null, 2, 0 == true ? 1 : 0);
        }
    }

    /* compiled from: ServicePaymentsEvents.kt */
    @Metadata(d1 = {"\u0000\f\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\u0018\u00002\u00020\u0001B\u0005¢\u0006\u0002\u0010\u0002¨\u0006\u0003"}, d2 = {"Lcom/sputnik/service_payments/analytics/yandex/ServicePaymentsEvents$ClickServInUserProfile;", "Lcom/sputnik/service_payments/analytics/yandex/ServicePaymentsEvents;", "()V", "service_payments_release"}, k = 1, mv = {1, 9, 0}, xi = 48)
    public static final class ClickServInUserProfile extends ServicePaymentsEvents {
        public ClickServInUserProfile() {
            super("clickServInUserProfile", null, 2, 0 == true ? 1 : 0);
        }
    }

    /* compiled from: ServicePaymentsEvents.kt */
    @Metadata(d1 = {"\u0000\f\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\u0018\u00002\u00020\u0001B\u0005¢\u0006\u0002\u0010\u0002¨\u0006\u0003"}, d2 = {"Lcom/sputnik/service_payments/analytics/yandex/ServicePaymentsEvents$ViewPaymentsLogsEvent;", "Lcom/sputnik/service_payments/analytics/yandex/ServicePaymentsEvents;", "()V", "service_payments_release"}, k = 1, mv = {1, 9, 0}, xi = 48)
    public static final class ViewPaymentsLogsEvent extends ServicePaymentsEvents {
        public ViewPaymentsLogsEvent() {
            super("viewPaymentsLogs", null, 2, 0 == true ? 1 : 0);
        }
    }

    /* compiled from: ServicePaymentsEvents.kt */
    @Metadata(d1 = {"\u0000\f\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\u0018\u00002\u00020\u0001B\u0005¢\u0006\u0002\u0010\u0002¨\u0006\u0003"}, d2 = {"Lcom/sputnik/service_payments/analytics/yandex/ServicePaymentsEvents$ClickPaymentButtonEvent;", "Lcom/sputnik/service_payments/analytics/yandex/ServicePaymentsEvents;", "()V", "service_payments_release"}, k = 1, mv = {1, 9, 0}, xi = 48)
    public static final class ClickPaymentButtonEvent extends ServicePaymentsEvents {
        public ClickPaymentButtonEvent() {
            super("clickPaymentBtn", null, 2, 0 == true ? 1 : 0);
        }
    }

    /* compiled from: ServicePaymentsEvents.kt */
    @Metadata(d1 = {"\u0000\f\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\u0018\u00002\u00020\u0001B\u0005¢\u0006\u0002\u0010\u0002¨\u0006\u0003"}, d2 = {"Lcom/sputnik/service_payments/analytics/yandex/ServicePaymentsEvents$ClickPaymentContinueEvent;", "Lcom/sputnik/service_payments/analytics/yandex/ServicePaymentsEvents;", "()V", "service_payments_release"}, k = 1, mv = {1, 9, 0}, xi = 48)
    public static final class ClickPaymentContinueEvent extends ServicePaymentsEvents {
        public ClickPaymentContinueEvent() {
            super("clickPaymentContinue", null, 2, 0 == true ? 1 : 0);
        }
    }

    /* compiled from: ServicePaymentsEvents.kt */
    @Metadata(d1 = {"\u0000\f\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\u0018\u00002\u00020\u0001B\u0005¢\u0006\u0002\u0010\u0002¨\u0006\u0003"}, d2 = {"Lcom/sputnik/service_payments/analytics/yandex/ServicePaymentsEvents$ClickSputnik1ButtonEvent;", "Lcom/sputnik/service_payments/analytics/yandex/ServicePaymentsEvents;", "()V", "service_payments_release"}, k = 1, mv = {1, 9, 0}, xi = 48)
    public static final class ClickSputnik1ButtonEvent extends ServicePaymentsEvents {
        public ClickSputnik1ButtonEvent() {
            super("clickSputnik1Btn", null, 2, 0 == true ? 1 : 0);
        }
    }

    /* compiled from: ServicePaymentsEvents.kt */
    @Metadata(d1 = {"\u0000\f\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\u0018\u00002\u00020\u0001B\u0005¢\u0006\u0002\u0010\u0002¨\u0006\u0003"}, d2 = {"Lcom/sputnik/service_payments/analytics/yandex/ServicePaymentsEvents$ClickBackToProfileEvent;", "Lcom/sputnik/service_payments/analytics/yandex/ServicePaymentsEvents;", "()V", "service_payments_release"}, k = 1, mv = {1, 9, 0}, xi = 48)
    public static final class ClickBackToProfileEvent extends ServicePaymentsEvents {
        public ClickBackToProfileEvent() {
            super("clickBackToProfile", null, 2, 0 == true ? 1 : 0);
        }
    }

    /* compiled from: ServicePaymentsEvents.kt */
    @Metadata(d1 = {"\u0000\f\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\u0018\u00002\u00020\u0001B\u0005¢\u0006\u0002\u0010\u0002¨\u0006\u0003"}, d2 = {"Lcom/sputnik/service_payments/analytics/yandex/ServicePaymentsEvents$ClickHistoryDetailsEvent;", "Lcom/sputnik/service_payments/analytics/yandex/ServicePaymentsEvents;", "()V", "service_payments_release"}, k = 1, mv = {1, 9, 0}, xi = 48)
    public static final class ClickHistoryDetailsEvent extends ServicePaymentsEvents {
        public ClickHistoryDetailsEvent() {
            super("clickHistoryDetails", null, 2, 0 == true ? 1 : 0);
        }
    }

    /* compiled from: ServicePaymentsEvents.kt */
    @Metadata(d1 = {"\u0000\f\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\u0018\u00002\u00020\u0001B\u0005¢\u0006\u0002\u0010\u0002¨\u0006\u0003"}, d2 = {"Lcom/sputnik/service_payments/analytics/yandex/ServicePaymentsEvents$ClickHistoryPartnerInfoEvent;", "Lcom/sputnik/service_payments/analytics/yandex/ServicePaymentsEvents;", "()V", "service_payments_release"}, k = 1, mv = {1, 9, 0}, xi = 48)
    public static final class ClickHistoryPartnerInfoEvent extends ServicePaymentsEvents {
        public ClickHistoryPartnerInfoEvent() {
            super("clickHistoryPartnerInfo", null, 2, 0 == true ? 1 : 0);
        }
    }

    /* compiled from: ServicePaymentsEvents.kt */
    @Metadata(d1 = {"\u0000\f\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\u0018\u00002\u00020\u0001B\u0005¢\u0006\u0002\u0010\u0002¨\u0006\u0003"}, d2 = {"Lcom/sputnik/service_payments/analytics/yandex/ServicePaymentsEvents$ViewLimitedPopupEvent;", "Lcom/sputnik/service_payments/analytics/yandex/ServicePaymentsEvents;", "()V", "service_payments_release"}, k = 1, mv = {1, 9, 0}, xi = 48)
    public static final class ViewLimitedPopupEvent extends ServicePaymentsEvents {
        public ViewLimitedPopupEvent() {
            super("viewLimitedPopup", null, 2, 0 == true ? 1 : 0);
        }
    }

    /* compiled from: ServicePaymentsEvents.kt */
    @Metadata(d1 = {"\u0000\f\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\u0018\u00002\u00020\u0001B\u0005¢\u0006\u0002\u0010\u0002¨\u0006\u0003"}, d2 = {"Lcom/sputnik/service_payments/analytics/yandex/ServicePaymentsEvents$ClickPaymentButtonLimitPopupEvent;", "Lcom/sputnik/service_payments/analytics/yandex/ServicePaymentsEvents;", "()V", "service_payments_release"}, k = 1, mv = {1, 9, 0}, xi = 48)
    public static final class ClickPaymentButtonLimitPopupEvent extends ServicePaymentsEvents {
        public ClickPaymentButtonLimitPopupEvent() {
            super("clickPaymentBtnLimitP", null, 2, 0 == true ? 1 : 0);
        }
    }

    /* compiled from: ServicePaymentsEvents.kt */
    @Metadata(d1 = {"\u0000\f\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\u0018\u00002\u00020\u0001B\u0005¢\u0006\u0002\u0010\u0002¨\u0006\u0003"}, d2 = {"Lcom/sputnik/service_payments/analytics/yandex/ServicePaymentsEvents$ClickCloseBtnLimitPopupEvent;", "Lcom/sputnik/service_payments/analytics/yandex/ServicePaymentsEvents;", "()V", "service_payments_release"}, k = 1, mv = {1, 9, 0}, xi = 48)
    public static final class ClickCloseBtnLimitPopupEvent extends ServicePaymentsEvents {
        public ClickCloseBtnLimitPopupEvent() {
            super("clickCloseBtnLimitP", null, 2, 0 == true ? 1 : 0);
        }
    }

    /* compiled from: ServicePaymentsEvents.kt */
    @Metadata(d1 = {"\u0000\f\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\u0018\u00002\u00020\u0001B\u0005¢\u0006\u0002\u0010\u0002¨\u0006\u0003"}, d2 = {"Lcom/sputnik/service_payments/analytics/yandex/ServicePaymentsEvents$ClickContinueButtonLimitPopupEvent;", "Lcom/sputnik/service_payments/analytics/yandex/ServicePaymentsEvents;", "()V", "service_payments_release"}, k = 1, mv = {1, 9, 0}, xi = 48)
    public static final class ClickContinueButtonLimitPopupEvent extends ServicePaymentsEvents {
        public ClickContinueButtonLimitPopupEvent() {
            super("clickContinueBtnLimitP", null, 2, 0 == true ? 1 : 0);
        }
    }

    /* compiled from: ServicePaymentsEvents.kt */
    @Metadata(d1 = {"\u0000\f\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\u0018\u00002\u00020\u0001B\u0005¢\u0006\u0002\u0010\u0002¨\u0006\u0003"}, d2 = {"Lcom/sputnik/service_payments/analytics/yandex/ServicePaymentsEvents$ViewBlockedEvent;", "Lcom/sputnik/service_payments/analytics/yandex/ServicePaymentsEvents;", "()V", "service_payments_release"}, k = 1, mv = {1, 9, 0}, xi = 48)
    public static final class ViewBlockedEvent extends ServicePaymentsEvents {
        public ViewBlockedEvent() {
            super("viewBlocked", null, 2, 0 == true ? 1 : 0);
        }
    }

    /* compiled from: ServicePaymentsEvents.kt */
    @Metadata(d1 = {"\u0000\f\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\u0018\u00002\u00020\u0001B\u0005¢\u0006\u0002\u0010\u0002¨\u0006\u0003"}, d2 = {"Lcom/sputnik/service_payments/analytics/yandex/ServicePaymentsEvents$ClickPaymentButtonBlockedEvent;", "Lcom/sputnik/service_payments/analytics/yandex/ServicePaymentsEvents;", "()V", "service_payments_release"}, k = 1, mv = {1, 9, 0}, xi = 48)
    public static final class ClickPaymentButtonBlockedEvent extends ServicePaymentsEvents {
        public ClickPaymentButtonBlockedEvent() {
            super("clickPaymentBtnBlocked", null, 2, 0 == true ? 1 : 0);
        }
    }

    /* compiled from: ServicePaymentsEvents.kt */
    @Metadata(d1 = {"\u0000\f\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\u0018\u00002\u00020\u0001B\u0005¢\u0006\u0002\u0010\u0002¨\u0006\u0003"}, d2 = {"Lcom/sputnik/service_payments/analytics/yandex/ServicePaymentsEvents$ClickPromiseButtonBlockedEvent;", "Lcom/sputnik/service_payments/analytics/yandex/ServicePaymentsEvents;", "()V", "service_payments_release"}, k = 1, mv = {1, 9, 0}, xi = 48)
    public static final class ClickPromiseButtonBlockedEvent extends ServicePaymentsEvents {
        public ClickPromiseButtonBlockedEvent() {
            super("clickPromiseBtnBlocked", null, 2, 0 == true ? 1 : 0);
        }
    }

    /* compiled from: ServicePaymentsEvents.kt */
    @Metadata(d1 = {"\u0000\f\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\u0018\u00002\u00020\u0001B\u0005¢\u0006\u0002\u0010\u0002¨\u0006\u0003"}, d2 = {"Lcom/sputnik/service_payments/analytics/yandex/ServicePaymentsEvents$ClickUsePromiseButtonBlocked;", "Lcom/sputnik/service_payments/analytics/yandex/ServicePaymentsEvents;", "()V", "service_payments_release"}, k = 1, mv = {1, 9, 0}, xi = 48)
    public static final class ClickUsePromiseButtonBlocked extends ServicePaymentsEvents {
        public ClickUsePromiseButtonBlocked() {
            super("clickUsePromiseBtnBlocked", null, 2, 0 == true ? 1 : 0);
        }
    }

    /* compiled from: ServicePaymentsEvents.kt */
    @Metadata(d1 = {"\u0000\f\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\u0018\u00002\u00020\u0001B\u0005¢\u0006\u0002\u0010\u0002¨\u0006\u0003"}, d2 = {"Lcom/sputnik/service_payments/analytics/yandex/ServicePaymentsEvents$ClickDisputeButtonEvent;", "Lcom/sputnik/service_payments/analytics/yandex/ServicePaymentsEvents;", "()V", "service_payments_release"}, k = 1, mv = {1, 9, 0}, xi = 48)
    public static final class ClickDisputeButtonEvent extends ServicePaymentsEvents {
        public ClickDisputeButtonEvent() {
            super("clickDisputeBtn", null, 2, 0 == true ? 1 : 0);
        }
    }

    /* compiled from: ServicePaymentsEvents.kt */
    @Metadata(d1 = {"\u0000\f\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\u0018\u00002\u00020\u0001B\u0005¢\u0006\u0002\u0010\u0002¨\u0006\u0003"}, d2 = {"Lcom/sputnik/service_payments/analytics/yandex/ServicePaymentsEvents$SuccessServPayment;", "Lcom/sputnik/service_payments/analytics/yandex/ServicePaymentsEvents;", "()V", "service_payments_release"}, k = 1, mv = {1, 9, 0}, xi = 48)
    public static final class SuccessServPayment extends ServicePaymentsEvents {
        public SuccessServPayment() {
            super("successServPayment", null, 2, 0 == true ? 1 : 0);
        }
    }

    /* compiled from: ServicePaymentsEvents.kt */
    @Metadata(d1 = {"\u0000\f\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\u0018\u00002\u00020\u0001B\u0005¢\u0006\u0002\u0010\u0002¨\u0006\u0003"}, d2 = {"Lcom/sputnik/service_payments/analytics/yandex/ServicePaymentsEvents$SuccessPromiseBtnBlocked;", "Lcom/sputnik/service_payments/analytics/yandex/ServicePaymentsEvents;", "()V", "service_payments_release"}, k = 1, mv = {1, 9, 0}, xi = 48)
    public static final class SuccessPromiseBtnBlocked extends ServicePaymentsEvents {
        public SuccessPromiseBtnBlocked() {
            super("successPromiseBtnBlocked", null, 2, 0 == true ? 1 : 0);
        }
    }

    /* compiled from: ServicePaymentsEvents.kt */
    @Metadata(d1 = {"\u0000\f\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\u0018\u00002\u00020\u0001B\u0005¢\u0006\u0002\u0010\u0002¨\u0006\u0003"}, d2 = {"Lcom/sputnik/service_payments/analytics/yandex/ServicePaymentsEvents$FailPromiseBtnBlocked;", "Lcom/sputnik/service_payments/analytics/yandex/ServicePaymentsEvents;", "()V", "service_payments_release"}, k = 1, mv = {1, 9, 0}, xi = 48)
    public static final class FailPromiseBtnBlocked extends ServicePaymentsEvents {
        public FailPromiseBtnBlocked() {
            super("failPromiseBtnBlocked", null, 2, 0 == true ? 1 : 0);
        }
    }

    /* compiled from: ServicePaymentsEvents.kt */
    @Metadata(d1 = {"\u0000\f\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\u0018\u00002\u00020\u0001B\u0005¢\u0006\u0002\u0010\u0002¨\u0006\u0003"}, d2 = {"Lcom/sputnik/service_payments/analytics/yandex/ServicePaymentsEvents$FailServPayment;", "Lcom/sputnik/service_payments/analytics/yandex/ServicePaymentsEvents;", "()V", "service_payments_release"}, k = 1, mv = {1, 9, 0}, xi = 48)
    public static final class FailServPayment extends ServicePaymentsEvents {
        public FailServPayment() {
            super("failServPayment", null, 2, 0 == true ? 1 : 0);
        }
    }
}

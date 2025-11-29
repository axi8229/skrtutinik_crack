package com.sputnik.service_payments.ui;

import com.sputnik.common.base.VMState;
import com.sputnik.domain.common.Event;
import com.sputnik.domain.common.Resource;
import com.sputnik.service_payments.entities.payments.PaymentHistory;
import com.sputnik.service_payments.entities.payments.PromisePayment;
import com.sputnik.service_payments.entities.payments.ServiceAccountInfo;
import java.util.List;
import kotlin.Metadata;
import kotlin.collections.CollectionsKt;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;

/* compiled from: ServicePaymentsViewModel.kt */
@Metadata(d1 = {"\u0000R\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0010\u000b\n\u0002\b\u0005\n\u0002\u0010\u000e\n\u0002\b\u0002\n\u0002\u0010\b\n\u0002\b\u0002\n\u0002\u0010\u0000\n\u0002\b\u001f\b\u0086\b\u0018\u00002\u00020\u0001:\u0001;Bw\u0012\b\b\u0002\u0010\u0003\u001a\u00020\u0002\u0012\b\b\u0002\u0010\u0004\u001a\u00020\u0002\u0012\u000e\b\u0002\u0010\u0007\u001a\b\u0012\u0004\u0012\u00020\u00060\u0005\u0012\n\b\u0002\u0010\b\u001a\u0004\u0018\u00010\u0006\u0012\n\b\u0002\u0010\t\u001a\u0004\u0018\u00010\u0006\u0012\n\b\u0002\u0010\u000b\u001a\u0004\u0018\u00010\n\u0012\n\b\u0002\u0010\r\u001a\u0004\u0018\u00010\f\u0012\n\b\u0002\u0010\u000f\u001a\u0004\u0018\u00010\u000e\u0012\u000e\b\u0002\u0010\u0012\u001a\b\u0012\u0004\u0012\u00020\u00110\u0010¢\u0006\u0004\b\u0013\u0010\u0014J\u0080\u0001\u0010\u0015\u001a\u00020\u00002\b\b\u0002\u0010\u0003\u001a\u00020\u00022\b\b\u0002\u0010\u0004\u001a\u00020\u00022\u000e\b\u0002\u0010\u0007\u001a\b\u0012\u0004\u0012\u00020\u00060\u00052\n\b\u0002\u0010\b\u001a\u0004\u0018\u00010\u00062\n\b\u0002\u0010\t\u001a\u0004\u0018\u00010\u00062\n\b\u0002\u0010\u000b\u001a\u0004\u0018\u00010\n2\n\b\u0002\u0010\r\u001a\u0004\u0018\u00010\f2\n\b\u0002\u0010\u000f\u001a\u0004\u0018\u00010\u000e2\u000e\b\u0002\u0010\u0012\u001a\b\u0012\u0004\u0012\u00020\u00110\u0010HÆ\u0001¢\u0006\u0004\b\u0015\u0010\u0016J\u0010\u0010\u0018\u001a\u00020\u0017HÖ\u0001¢\u0006\u0004\b\u0018\u0010\u0019J\u0010\u0010\u001b\u001a\u00020\u001aHÖ\u0001¢\u0006\u0004\b\u001b\u0010\u001cJ\u001a\u0010\u001f\u001a\u00020\u00112\b\u0010\u001e\u001a\u0004\u0018\u00010\u001dHÖ\u0003¢\u0006\u0004\b\u001f\u0010 R\"\u0010\u0003\u001a\u00020\u00028\u0006@\u0006X\u0086\u000e¢\u0006\u0012\n\u0004\b\u0003\u0010!\u001a\u0004\b\"\u0010#\"\u0004\b$\u0010%R\"\u0010\u0004\u001a\u00020\u00028\u0006@\u0006X\u0086\u000e¢\u0006\u0012\n\u0004\b\u0004\u0010!\u001a\u0004\b&\u0010#\"\u0004\b'\u0010%R\u001d\u0010\u0007\u001a\b\u0012\u0004\u0012\u00020\u00060\u00058\u0006¢\u0006\f\n\u0004\b\u0007\u0010(\u001a\u0004\b)\u0010*R\u0019\u0010\b\u001a\u0004\u0018\u00010\u00068\u0006¢\u0006\f\n\u0004\b\b\u0010+\u001a\u0004\b,\u0010-R\u0019\u0010\t\u001a\u0004\u0018\u00010\u00068\u0006¢\u0006\f\n\u0004\b\t\u0010+\u001a\u0004\b.\u0010-R\u0019\u0010\u000b\u001a\u0004\u0018\u00010\n8\u0006¢\u0006\f\n\u0004\b\u000b\u0010/\u001a\u0004\b0\u00101R\u0019\u0010\r\u001a\u0004\u0018\u00010\f8\u0006¢\u0006\f\n\u0004\b\r\u00102\u001a\u0004\b3\u00104R\u0019\u0010\u000f\u001a\u0004\u0018\u00010\u000e8\u0006¢\u0006\f\n\u0004\b\u000f\u00105\u001a\u0004\b6\u00107R\u001d\u0010\u0012\u001a\b\u0012\u0004\u0012\u00020\u00110\u00108\u0006¢\u0006\f\n\u0004\b\u0012\u00108\u001a\u0004\b9\u0010:¨\u0006<"}, d2 = {"Lcom/sputnik/service_payments/ui/ServicePaymentsViewState;", "Lcom/sputnik/common/base/VMState;", "Lcom/sputnik/domain/common/Resource$Status;", "serverStateAccountInfo", "serverStatePayments", "", "Lcom/sputnik/service_payments/entities/payments/PaymentHistory;", "payments", "payment", "debtPayment", "Lcom/sputnik/service_payments/entities/payments/ServiceAccountInfo;", "accountInfo", "Lcom/sputnik/service_payments/entities/payments/PromisePayment;", "promisedPaymentInfo", "Lcom/sputnik/service_payments/ui/ServicePaymentsViewState$ReceiptState;", "receiptState", "Lcom/sputnik/domain/common/Event;", "", "needToReload", "<init>", "(Lcom/sputnik/domain/common/Resource$Status;Lcom/sputnik/domain/common/Resource$Status;Ljava/util/List;Lcom/sputnik/service_payments/entities/payments/PaymentHistory;Lcom/sputnik/service_payments/entities/payments/PaymentHistory;Lcom/sputnik/service_payments/entities/payments/ServiceAccountInfo;Lcom/sputnik/service_payments/entities/payments/PromisePayment;Lcom/sputnik/service_payments/ui/ServicePaymentsViewState$ReceiptState;Lcom/sputnik/domain/common/Event;)V", "copy", "(Lcom/sputnik/domain/common/Resource$Status;Lcom/sputnik/domain/common/Resource$Status;Ljava/util/List;Lcom/sputnik/service_payments/entities/payments/PaymentHistory;Lcom/sputnik/service_payments/entities/payments/PaymentHistory;Lcom/sputnik/service_payments/entities/payments/ServiceAccountInfo;Lcom/sputnik/service_payments/entities/payments/PromisePayment;Lcom/sputnik/service_payments/ui/ServicePaymentsViewState$ReceiptState;Lcom/sputnik/domain/common/Event;)Lcom/sputnik/service_payments/ui/ServicePaymentsViewState;", "", "toString", "()Ljava/lang/String;", "", "hashCode", "()I", "", "other", "equals", "(Ljava/lang/Object;)Z", "Lcom/sputnik/domain/common/Resource$Status;", "getServerStateAccountInfo", "()Lcom/sputnik/domain/common/Resource$Status;", "setServerStateAccountInfo", "(Lcom/sputnik/domain/common/Resource$Status;)V", "getServerStatePayments", "setServerStatePayments", "Ljava/util/List;", "getPayments", "()Ljava/util/List;", "Lcom/sputnik/service_payments/entities/payments/PaymentHistory;", "getPayment", "()Lcom/sputnik/service_payments/entities/payments/PaymentHistory;", "getDebtPayment", "Lcom/sputnik/service_payments/entities/payments/ServiceAccountInfo;", "getAccountInfo", "()Lcom/sputnik/service_payments/entities/payments/ServiceAccountInfo;", "Lcom/sputnik/service_payments/entities/payments/PromisePayment;", "getPromisedPaymentInfo", "()Lcom/sputnik/service_payments/entities/payments/PromisePayment;", "Lcom/sputnik/service_payments/ui/ServicePaymentsViewState$ReceiptState;", "getReceiptState", "()Lcom/sputnik/service_payments/ui/ServicePaymentsViewState$ReceiptState;", "Lcom/sputnik/domain/common/Event;", "getNeedToReload", "()Lcom/sputnik/domain/common/Event;", "ReceiptState", "service_payments_release"}, k = 1, mv = {1, 9, 0}, xi = 48)
/* loaded from: classes3.dex */
public final /* data */ class ServicePaymentsViewState implements VMState {
    private final ServiceAccountInfo accountInfo;
    private final PaymentHistory debtPayment;
    private final Event<Boolean> needToReload;
    private final PaymentHistory payment;
    private final List<PaymentHistory> payments;
    private final PromisePayment promisedPaymentInfo;
    private final ReceiptState receiptState;
    private Resource.Status serverStateAccountInfo;
    private Resource.Status serverStatePayments;

    public ServicePaymentsViewState() {
        this(null, null, null, null, null, null, null, null, null, 511, null);
    }

    public final ServicePaymentsViewState copy(Resource.Status serverStateAccountInfo, Resource.Status serverStatePayments, List<PaymentHistory> payments, PaymentHistory payment, PaymentHistory debtPayment, ServiceAccountInfo accountInfo, PromisePayment promisedPaymentInfo, ReceiptState receiptState, Event<Boolean> needToReload) {
        Intrinsics.checkNotNullParameter(serverStateAccountInfo, "serverStateAccountInfo");
        Intrinsics.checkNotNullParameter(serverStatePayments, "serverStatePayments");
        Intrinsics.checkNotNullParameter(payments, "payments");
        Intrinsics.checkNotNullParameter(needToReload, "needToReload");
        return new ServicePaymentsViewState(serverStateAccountInfo, serverStatePayments, payments, payment, debtPayment, accountInfo, promisedPaymentInfo, receiptState, needToReload);
    }

    public boolean equals(Object other) {
        if (this == other) {
            return true;
        }
        if (!(other instanceof ServicePaymentsViewState)) {
            return false;
        }
        ServicePaymentsViewState servicePaymentsViewState = (ServicePaymentsViewState) other;
        return this.serverStateAccountInfo == servicePaymentsViewState.serverStateAccountInfo && this.serverStatePayments == servicePaymentsViewState.serverStatePayments && Intrinsics.areEqual(this.payments, servicePaymentsViewState.payments) && Intrinsics.areEqual(this.payment, servicePaymentsViewState.payment) && Intrinsics.areEqual(this.debtPayment, servicePaymentsViewState.debtPayment) && Intrinsics.areEqual(this.accountInfo, servicePaymentsViewState.accountInfo) && Intrinsics.areEqual(this.promisedPaymentInfo, servicePaymentsViewState.promisedPaymentInfo) && Intrinsics.areEqual(this.receiptState, servicePaymentsViewState.receiptState) && Intrinsics.areEqual(this.needToReload, servicePaymentsViewState.needToReload);
    }

    public int hashCode() {
        int iHashCode = ((((this.serverStateAccountInfo.hashCode() * 31) + this.serverStatePayments.hashCode()) * 31) + this.payments.hashCode()) * 31;
        PaymentHistory paymentHistory = this.payment;
        int iHashCode2 = (iHashCode + (paymentHistory == null ? 0 : paymentHistory.hashCode())) * 31;
        PaymentHistory paymentHistory2 = this.debtPayment;
        int iHashCode3 = (iHashCode2 + (paymentHistory2 == null ? 0 : paymentHistory2.hashCode())) * 31;
        ServiceAccountInfo serviceAccountInfo = this.accountInfo;
        int iHashCode4 = (iHashCode3 + (serviceAccountInfo == null ? 0 : serviceAccountInfo.hashCode())) * 31;
        PromisePayment promisePayment = this.promisedPaymentInfo;
        int iHashCode5 = (iHashCode4 + (promisePayment == null ? 0 : promisePayment.hashCode())) * 31;
        ReceiptState receiptState = this.receiptState;
        return ((iHashCode5 + (receiptState != null ? receiptState.hashCode() : 0)) * 31) + this.needToReload.hashCode();
    }

    public String toString() {
        return "ServicePaymentsViewState(serverStateAccountInfo=" + this.serverStateAccountInfo + ", serverStatePayments=" + this.serverStatePayments + ", payments=" + this.payments + ", payment=" + this.payment + ", debtPayment=" + this.debtPayment + ", accountInfo=" + this.accountInfo + ", promisedPaymentInfo=" + this.promisedPaymentInfo + ", receiptState=" + this.receiptState + ", needToReload=" + this.needToReload + ")";
    }

    public ServicePaymentsViewState(Resource.Status serverStateAccountInfo, Resource.Status serverStatePayments, List<PaymentHistory> payments, PaymentHistory paymentHistory, PaymentHistory paymentHistory2, ServiceAccountInfo serviceAccountInfo, PromisePayment promisePayment, ReceiptState receiptState, Event<Boolean> needToReload) {
        Intrinsics.checkNotNullParameter(serverStateAccountInfo, "serverStateAccountInfo");
        Intrinsics.checkNotNullParameter(serverStatePayments, "serverStatePayments");
        Intrinsics.checkNotNullParameter(payments, "payments");
        Intrinsics.checkNotNullParameter(needToReload, "needToReload");
        this.serverStateAccountInfo = serverStateAccountInfo;
        this.serverStatePayments = serverStatePayments;
        this.payments = payments;
        this.payment = paymentHistory;
        this.debtPayment = paymentHistory2;
        this.accountInfo = serviceAccountInfo;
        this.promisedPaymentInfo = promisePayment;
        this.receiptState = receiptState;
        this.needToReload = needToReload;
    }

    public /* synthetic */ ServicePaymentsViewState(Resource.Status status, Resource.Status status2, List list, PaymentHistory paymentHistory, PaymentHistory paymentHistory2, ServiceAccountInfo serviceAccountInfo, PromisePayment promisePayment, ReceiptState receiptState, Event event, int i, DefaultConstructorMarker defaultConstructorMarker) {
        this((i & 1) != 0 ? Resource.Status.NONE : status, (i & 2) != 0 ? Resource.Status.NONE : status2, (i & 4) != 0 ? CollectionsKt.emptyList() : list, (i & 8) != 0 ? null : paymentHistory, (i & 16) != 0 ? null : paymentHistory2, (i & 32) != 0 ? null : serviceAccountInfo, (i & 64) != 0 ? null : promisePayment, (i & 128) == 0 ? receiptState : null, (i & 256) != 0 ? new Event(Boolean.FALSE) : event);
    }

    public final Resource.Status getServerStateAccountInfo() {
        return this.serverStateAccountInfo;
    }

    public final Resource.Status getServerStatePayments() {
        return this.serverStatePayments;
    }

    public final List<PaymentHistory> getPayments() {
        return this.payments;
    }

    public final PaymentHistory getPayment() {
        return this.payment;
    }

    public final PaymentHistory getDebtPayment() {
        return this.debtPayment;
    }

    public final ServiceAccountInfo getAccountInfo() {
        return this.accountInfo;
    }

    public final PromisePayment getPromisedPaymentInfo() {
        return this.promisedPaymentInfo;
    }

    public final ReceiptState getReceiptState() {
        return this.receiptState;
    }

    public final Event<Boolean> getNeedToReload() {
        return this.needToReload;
    }

    /* compiled from: ServicePaymentsViewModel.kt */
    @Metadata(d1 = {"\u0000&\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0010\b\n\u0002\b\u0003\n\u0002\u0010\u000b\n\u0002\b\b\b\u0086\b\u0018\u00002\u00020\u0001B\u001d\u0012\n\b\u0002\u0010\u0003\u001a\u0004\u0018\u00010\u0002\u0012\b\b\u0002\u0010\u0005\u001a\u00020\u0004¢\u0006\u0004\b\u0006\u0010\u0007J\u0010\u0010\b\u001a\u00020\u0002HÖ\u0001¢\u0006\u0004\b\b\u0010\tJ\u0010\u0010\u000b\u001a\u00020\nHÖ\u0001¢\u0006\u0004\b\u000b\u0010\fJ\u001a\u0010\u000f\u001a\u00020\u000e2\b\u0010\r\u001a\u0004\u0018\u00010\u0001HÖ\u0003¢\u0006\u0004\b\u000f\u0010\u0010R\u0019\u0010\u0003\u001a\u0004\u0018\u00010\u00028\u0006¢\u0006\f\n\u0004\b\u0003\u0010\u0011\u001a\u0004\b\u0012\u0010\tR\u0017\u0010\u0005\u001a\u00020\u00048\u0006¢\u0006\f\n\u0004\b\u0005\u0010\u0013\u001a\u0004\b\u0014\u0010\u0015¨\u0006\u0016"}, d2 = {"Lcom/sputnik/service_payments/ui/ServicePaymentsViewState$ReceiptState;", "", "", "receiptUrl", "Lcom/sputnik/domain/common/Resource$Status;", "state", "<init>", "(Ljava/lang/String;Lcom/sputnik/domain/common/Resource$Status;)V", "toString", "()Ljava/lang/String;", "", "hashCode", "()I", "other", "", "equals", "(Ljava/lang/Object;)Z", "Ljava/lang/String;", "getReceiptUrl", "Lcom/sputnik/domain/common/Resource$Status;", "getState", "()Lcom/sputnik/domain/common/Resource$Status;", "service_payments_release"}, k = 1, mv = {1, 9, 0}, xi = 48)
    public static final /* data */ class ReceiptState {
        private final String receiptUrl;
        private final Resource.Status state;

        public ReceiptState() {
            this(null, 0 == true ? 1 : 0, 3, 0 == true ? 1 : 0);
        }

        public boolean equals(Object other) {
            if (this == other) {
                return true;
            }
            if (!(other instanceof ReceiptState)) {
                return false;
            }
            ReceiptState receiptState = (ReceiptState) other;
            return Intrinsics.areEqual(this.receiptUrl, receiptState.receiptUrl) && this.state == receiptState.state;
        }

        public int hashCode() {
            String str = this.receiptUrl;
            return ((str == null ? 0 : str.hashCode()) * 31) + this.state.hashCode();
        }

        public String toString() {
            return "ReceiptState(receiptUrl=" + this.receiptUrl + ", state=" + this.state + ")";
        }

        public ReceiptState(String str, Resource.Status state) {
            Intrinsics.checkNotNullParameter(state, "state");
            this.receiptUrl = str;
            this.state = state;
        }

        public final String getReceiptUrl() {
            return this.receiptUrl;
        }

        public /* synthetic */ ReceiptState(String str, Resource.Status status, int i, DefaultConstructorMarker defaultConstructorMarker) {
            this((i & 1) != 0 ? null : str, (i & 2) != 0 ? Resource.Status.NONE : status);
        }

        public final Resource.Status getState() {
            return this.state;
        }
    }
}

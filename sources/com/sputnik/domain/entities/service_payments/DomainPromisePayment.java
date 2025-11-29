package com.sputnik.domain.entities.service_payments;

import kotlin.Metadata;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;

/* compiled from: DomainPromisePayment.kt */
@Metadata(d1 = {"\u0000.\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u000e\n\u0002\b\u0002\n\u0002\u0010\b\n\u0002\b\u0003\n\u0002\u0010\u000b\n\u0002\b\t\b\u0086\b\u0018\u00002\u00020\u0001B\u001f\u0012\n\b\u0002\u0010\u0003\u001a\u0004\u0018\u00010\u0002\u0012\n\b\u0002\u0010\u0005\u001a\u0004\u0018\u00010\u0004¢\u0006\u0004\b\u0006\u0010\u0007J\u0010\u0010\t\u001a\u00020\bHÖ\u0001¢\u0006\u0004\b\t\u0010\nJ\u0010\u0010\f\u001a\u00020\u000bHÖ\u0001¢\u0006\u0004\b\f\u0010\rJ\u001a\u0010\u0010\u001a\u00020\u000f2\b\u0010\u000e\u001a\u0004\u0018\u00010\u0001HÖ\u0003¢\u0006\u0004\b\u0010\u0010\u0011R\u0019\u0010\u0003\u001a\u0004\u0018\u00010\u00028\u0006¢\u0006\f\n\u0004\b\u0003\u0010\u0012\u001a\u0004\b\u0013\u0010\u0014R\u0019\u0010\u0005\u001a\u0004\u0018\u00010\u00048\u0006¢\u0006\f\n\u0004\b\u0005\u0010\u0015\u001a\u0004\b\u0016\u0010\u0017¨\u0006\u0018"}, d2 = {"Lcom/sputnik/domain/entities/service_payments/DomainPromisePayment;", "", "Lcom/sputnik/domain/entities/service_payments/DomainPaymentHistory;", "accrual", "Lcom/sputnik/domain/entities/service_payments/DomainPromisedPayment;", "promisedPayment", "<init>", "(Lcom/sputnik/domain/entities/service_payments/DomainPaymentHistory;Lcom/sputnik/domain/entities/service_payments/DomainPromisedPayment;)V", "", "toString", "()Ljava/lang/String;", "", "hashCode", "()I", "other", "", "equals", "(Ljava/lang/Object;)Z", "Lcom/sputnik/domain/entities/service_payments/DomainPaymentHistory;", "getAccrual", "()Lcom/sputnik/domain/entities/service_payments/DomainPaymentHistory;", "Lcom/sputnik/domain/entities/service_payments/DomainPromisedPayment;", "getPromisedPayment", "()Lcom/sputnik/domain/entities/service_payments/DomainPromisedPayment;", "domain"}, k = 1, mv = {1, 9, 0}, xi = 48)
/* loaded from: classes3.dex */
public final /* data */ class DomainPromisePayment {
    private final DomainPaymentHistory accrual;
    private final DomainPromisedPayment promisedPayment;

    public DomainPromisePayment() {
        this(null, 0 == true ? 1 : 0, 3, 0 == true ? 1 : 0);
    }

    public boolean equals(Object other) {
        if (this == other) {
            return true;
        }
        if (!(other instanceof DomainPromisePayment)) {
            return false;
        }
        DomainPromisePayment domainPromisePayment = (DomainPromisePayment) other;
        return Intrinsics.areEqual(this.accrual, domainPromisePayment.accrual) && Intrinsics.areEqual(this.promisedPayment, domainPromisePayment.promisedPayment);
    }

    public int hashCode() {
        DomainPaymentHistory domainPaymentHistory = this.accrual;
        int iHashCode = (domainPaymentHistory == null ? 0 : domainPaymentHistory.hashCode()) * 31;
        DomainPromisedPayment domainPromisedPayment = this.promisedPayment;
        return iHashCode + (domainPromisedPayment != null ? domainPromisedPayment.hashCode() : 0);
    }

    public String toString() {
        return "DomainPromisePayment(accrual=" + this.accrual + ", promisedPayment=" + this.promisedPayment + ")";
    }

    public DomainPromisePayment(DomainPaymentHistory domainPaymentHistory, DomainPromisedPayment domainPromisedPayment) {
        this.accrual = domainPaymentHistory;
        this.promisedPayment = domainPromisedPayment;
    }

    public /* synthetic */ DomainPromisePayment(DomainPaymentHistory domainPaymentHistory, DomainPromisedPayment domainPromisedPayment, int i, DefaultConstructorMarker defaultConstructorMarker) {
        this((i & 1) != 0 ? null : domainPaymentHistory, (i & 2) != 0 ? null : domainPromisedPayment);
    }

    public final DomainPaymentHistory getAccrual() {
        return this.accrual;
    }

    public final DomainPromisedPayment getPromisedPayment() {
        return this.promisedPayment;
    }
}

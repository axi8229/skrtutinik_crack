package com.sputnik.domain.entities.service_payments;

import kotlin.Metadata;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;

/* compiled from: DomainPaymentHistory.kt */
@Metadata(d1 = {"\u0000.\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0006\n\u0002\u0010\b\n\u0002\b\u0003\n\u0002\u0010\u000b\n\u0002\b\u000e\b\u0086\b\u0018\u00002\u00020\u0001BO\u0012\n\b\u0002\u0010\u0003\u001a\u0004\u0018\u00010\u0002\u0012\n\b\u0002\u0010\u0005\u001a\u0004\u0018\u00010\u0004\u0012\n\b\u0002\u0010\u0006\u001a\u0004\u0018\u00010\u0002\u0012\n\b\u0002\u0010\u0007\u001a\u0004\u0018\u00010\u0002\u0012\n\b\u0002\u0010\t\u001a\u0004\u0018\u00010\b\u0012\n\b\u0002\u0010\n\u001a\u0004\u0018\u00010\u0002¢\u0006\u0004\b\u000b\u0010\fJ\u0010\u0010\r\u001a\u00020\u0002HÖ\u0001¢\u0006\u0004\b\r\u0010\u000eJ\u0010\u0010\u0010\u001a\u00020\u000fHÖ\u0001¢\u0006\u0004\b\u0010\u0010\u0011J\u001a\u0010\u0014\u001a\u00020\u00132\b\u0010\u0012\u001a\u0004\u0018\u00010\u0001HÖ\u0003¢\u0006\u0004\b\u0014\u0010\u0015R\u0019\u0010\u0003\u001a\u0004\u0018\u00010\u00028\u0006¢\u0006\f\n\u0004\b\u0003\u0010\u0016\u001a\u0004\b\u0017\u0010\u000eR\u0019\u0010\u0005\u001a\u0004\u0018\u00010\u00048\u0006¢\u0006\f\n\u0004\b\u0005\u0010\u0018\u001a\u0004\b\u0019\u0010\u001aR\u0019\u0010\u0006\u001a\u0004\u0018\u00010\u00028\u0006¢\u0006\f\n\u0004\b\u0006\u0010\u0016\u001a\u0004\b\u001b\u0010\u000eR\u0019\u0010\u0007\u001a\u0004\u0018\u00010\u00028\u0006¢\u0006\f\n\u0004\b\u0007\u0010\u0016\u001a\u0004\b\u001c\u0010\u000eR\u0019\u0010\t\u001a\u0004\u0018\u00010\b8\u0006¢\u0006\f\n\u0004\b\t\u0010\u001d\u001a\u0004\b\u001e\u0010\u001fR\u0019\u0010\n\u001a\u0004\u0018\u00010\u00028\u0006¢\u0006\f\n\u0004\b\n\u0010\u0016\u001a\u0004\b \u0010\u000e¨\u0006!"}, d2 = {"Lcom/sputnik/domain/entities/service_payments/DomainPaymentHistory;", "", "", "id", "Lcom/sputnik/domain/entities/service_payments/ServicePaymentType;", "type", "paymentDate", "amount", "Lcom/sputnik/domain/entities/service_payments/ServicePaymentState;", "state", "payUntil", "<init>", "(Ljava/lang/String;Lcom/sputnik/domain/entities/service_payments/ServicePaymentType;Ljava/lang/String;Ljava/lang/String;Lcom/sputnik/domain/entities/service_payments/ServicePaymentState;Ljava/lang/String;)V", "toString", "()Ljava/lang/String;", "", "hashCode", "()I", "other", "", "equals", "(Ljava/lang/Object;)Z", "Ljava/lang/String;", "getId", "Lcom/sputnik/domain/entities/service_payments/ServicePaymentType;", "getType", "()Lcom/sputnik/domain/entities/service_payments/ServicePaymentType;", "getPaymentDate", "getAmount", "Lcom/sputnik/domain/entities/service_payments/ServicePaymentState;", "getState", "()Lcom/sputnik/domain/entities/service_payments/ServicePaymentState;", "getPayUntil", "domain"}, k = 1, mv = {1, 9, 0}, xi = 48)
/* loaded from: classes3.dex */
public final /* data */ class DomainPaymentHistory {
    private final String amount;
    private final String id;
    private final String payUntil;
    private final String paymentDate;
    private final ServicePaymentState state;
    private final ServicePaymentType type;

    public DomainPaymentHistory() {
        this(null, null, null, null, null, null, 63, null);
    }

    public boolean equals(Object other) {
        if (this == other) {
            return true;
        }
        if (!(other instanceof DomainPaymentHistory)) {
            return false;
        }
        DomainPaymentHistory domainPaymentHistory = (DomainPaymentHistory) other;
        return Intrinsics.areEqual(this.id, domainPaymentHistory.id) && this.type == domainPaymentHistory.type && Intrinsics.areEqual(this.paymentDate, domainPaymentHistory.paymentDate) && Intrinsics.areEqual(this.amount, domainPaymentHistory.amount) && this.state == domainPaymentHistory.state && Intrinsics.areEqual(this.payUntil, domainPaymentHistory.payUntil);
    }

    public int hashCode() {
        String str = this.id;
        int iHashCode = (str == null ? 0 : str.hashCode()) * 31;
        ServicePaymentType servicePaymentType = this.type;
        int iHashCode2 = (iHashCode + (servicePaymentType == null ? 0 : servicePaymentType.hashCode())) * 31;
        String str2 = this.paymentDate;
        int iHashCode3 = (iHashCode2 + (str2 == null ? 0 : str2.hashCode())) * 31;
        String str3 = this.amount;
        int iHashCode4 = (iHashCode3 + (str3 == null ? 0 : str3.hashCode())) * 31;
        ServicePaymentState servicePaymentState = this.state;
        int iHashCode5 = (iHashCode4 + (servicePaymentState == null ? 0 : servicePaymentState.hashCode())) * 31;
        String str4 = this.payUntil;
        return iHashCode5 + (str4 != null ? str4.hashCode() : 0);
    }

    public String toString() {
        return "DomainPaymentHistory(id=" + this.id + ", type=" + this.type + ", paymentDate=" + this.paymentDate + ", amount=" + this.amount + ", state=" + this.state + ", payUntil=" + this.payUntil + ")";
    }

    public DomainPaymentHistory(String str, ServicePaymentType servicePaymentType, String str2, String str3, ServicePaymentState servicePaymentState, String str4) {
        this.id = str;
        this.type = servicePaymentType;
        this.paymentDate = str2;
        this.amount = str3;
        this.state = servicePaymentState;
        this.payUntil = str4;
    }

    public /* synthetic */ DomainPaymentHistory(String str, ServicePaymentType servicePaymentType, String str2, String str3, ServicePaymentState servicePaymentState, String str4, int i, DefaultConstructorMarker defaultConstructorMarker) {
        this((i & 1) != 0 ? null : str, (i & 2) != 0 ? null : servicePaymentType, (i & 4) != 0 ? null : str2, (i & 8) != 0 ? null : str3, (i & 16) != 0 ? null : servicePaymentState, (i & 32) != 0 ? null : str4);
    }

    public final String getId() {
        return this.id;
    }

    public final ServicePaymentType getType() {
        return this.type;
    }

    public final String getPaymentDate() {
        return this.paymentDate;
    }

    public final String getAmount() {
        return this.amount;
    }

    public final ServicePaymentState getState() {
        return this.state;
    }

    public final String getPayUntil() {
        return this.payUntil;
    }
}

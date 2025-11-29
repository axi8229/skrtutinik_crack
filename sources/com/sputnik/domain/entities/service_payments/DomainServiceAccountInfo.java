package com.sputnik.domain.entities.service_payments;

import kotlin.Metadata;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;

/* compiled from: DomainServiceAccountInfo.kt */
@Metadata(d1 = {"\u0000.\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0010\u000b\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0007\n\u0002\u0010\b\n\u0002\b\u0018\b\u0086\b\u0018\u00002\u00020\u0001B\u008b\u0001\u0012\n\b\u0002\u0010\u0003\u001a\u0004\u0018\u00010\u0002\u0012\n\b\u0002\u0010\u0005\u001a\u0004\u0018\u00010\u0004\u0012\n\b\u0002\u0010\u0006\u001a\u0004\u0018\u00010\u0002\u0012\n\b\u0002\u0010\u0007\u001a\u0004\u0018\u00010\u0002\u0012\n\b\u0002\u0010\b\u001a\u0004\u0018\u00010\u0002\u0012\n\b\u0002\u0010\t\u001a\u0004\u0018\u00010\u0002\u0012\n\b\u0002\u0010\u000b\u001a\u0004\u0018\u00010\n\u0012\n\b\u0002\u0010\f\u001a\u0004\u0018\u00010\u0002\u0012\n\b\u0002\u0010\u000e\u001a\u0004\u0018\u00010\r\u0012\n\b\u0002\u0010\u000f\u001a\u0004\u0018\u00010\u0002\u0012\n\b\u0002\u0010\u0010\u001a\u0004\u0018\u00010\n¢\u0006\u0004\b\u0011\u0010\u0012J\u0010\u0010\u0013\u001a\u00020\u0002HÖ\u0001¢\u0006\u0004\b\u0013\u0010\u0014J\u0010\u0010\u0016\u001a\u00020\u0015HÖ\u0001¢\u0006\u0004\b\u0016\u0010\u0017J\u001a\u0010\u0019\u001a\u00020\n2\b\u0010\u0018\u001a\u0004\u0018\u00010\u0001HÖ\u0003¢\u0006\u0004\b\u0019\u0010\u001aR\u0019\u0010\u0003\u001a\u0004\u0018\u00010\u00028\u0006¢\u0006\f\n\u0004\b\u0003\u0010\u001b\u001a\u0004\b\u001c\u0010\u0014R\u0019\u0010\u0005\u001a\u0004\u0018\u00010\u00048\u0006¢\u0006\f\n\u0004\b\u0005\u0010\u001d\u001a\u0004\b\u001e\u0010\u001fR\u0019\u0010\u0006\u001a\u0004\u0018\u00010\u00028\u0006¢\u0006\f\n\u0004\b\u0006\u0010\u001b\u001a\u0004\b \u0010\u0014R\u0019\u0010\u0007\u001a\u0004\u0018\u00010\u00028\u0006¢\u0006\f\n\u0004\b\u0007\u0010\u001b\u001a\u0004\b!\u0010\u0014R\u0019\u0010\b\u001a\u0004\u0018\u00010\u00028\u0006¢\u0006\f\n\u0004\b\b\u0010\u001b\u001a\u0004\b\"\u0010\u0014R\u0019\u0010\t\u001a\u0004\u0018\u00010\u00028\u0006¢\u0006\f\n\u0004\b\t\u0010\u001b\u001a\u0004\b#\u0010\u0014R\u0019\u0010\u000b\u001a\u0004\u0018\u00010\n8\u0006¢\u0006\f\n\u0004\b\u000b\u0010$\u001a\u0004\b%\u0010&R\u0019\u0010\f\u001a\u0004\u0018\u00010\u00028\u0006¢\u0006\f\n\u0004\b\f\u0010\u001b\u001a\u0004\b'\u0010\u0014R\u0019\u0010\u000e\u001a\u0004\u0018\u00010\r8\u0006¢\u0006\f\n\u0004\b\u000e\u0010(\u001a\u0004\b)\u0010*R\u0019\u0010\u000f\u001a\u0004\u0018\u00010\u00028\u0006¢\u0006\f\n\u0004\b\u000f\u0010\u001b\u001a\u0004\b+\u0010\u0014R\u0019\u0010\u0010\u001a\u0004\u0018\u00010\n8\u0006¢\u0006\f\n\u0004\b\u0010\u0010$\u001a\u0004\b,\u0010&¨\u0006-"}, d2 = {"Lcom/sputnik/domain/entities/service_payments/DomainServiceAccountInfo;", "", "", "id", "Lcom/sputnik/domain/entities/service_payments/ServicePaymentType;", "type", "number", "fullAddress", "currentDebt", "accrualUuid", "", "promiseAvailable", "promiseExpiresAt", "Lcom/sputnik/domain/entities/service_payments/DomainPartnerInfo;", "partner", "lastAccruedAt", "offerAccepted", "<init>", "(Ljava/lang/String;Lcom/sputnik/domain/entities/service_payments/ServicePaymentType;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/Boolean;Ljava/lang/String;Lcom/sputnik/domain/entities/service_payments/DomainPartnerInfo;Ljava/lang/String;Ljava/lang/Boolean;)V", "toString", "()Ljava/lang/String;", "", "hashCode", "()I", "other", "equals", "(Ljava/lang/Object;)Z", "Ljava/lang/String;", "getId", "Lcom/sputnik/domain/entities/service_payments/ServicePaymentType;", "getType", "()Lcom/sputnik/domain/entities/service_payments/ServicePaymentType;", "getNumber", "getFullAddress", "getCurrentDebt", "getAccrualUuid", "Ljava/lang/Boolean;", "getPromiseAvailable", "()Ljava/lang/Boolean;", "getPromiseExpiresAt", "Lcom/sputnik/domain/entities/service_payments/DomainPartnerInfo;", "getPartner", "()Lcom/sputnik/domain/entities/service_payments/DomainPartnerInfo;", "getLastAccruedAt", "getOfferAccepted", "domain"}, k = 1, mv = {1, 9, 0}, xi = 48)
/* loaded from: classes3.dex */
public final /* data */ class DomainServiceAccountInfo {
    private final String accrualUuid;
    private final String currentDebt;
    private final String fullAddress;
    private final String id;
    private final String lastAccruedAt;
    private final String number;
    private final Boolean offerAccepted;
    private final DomainPartnerInfo partner;
    private final Boolean promiseAvailable;
    private final String promiseExpiresAt;
    private final ServicePaymentType type;

    public DomainServiceAccountInfo() {
        this(null, null, null, null, null, null, null, null, null, null, null, 2047, null);
    }

    public boolean equals(Object other) {
        if (this == other) {
            return true;
        }
        if (!(other instanceof DomainServiceAccountInfo)) {
            return false;
        }
        DomainServiceAccountInfo domainServiceAccountInfo = (DomainServiceAccountInfo) other;
        return Intrinsics.areEqual(this.id, domainServiceAccountInfo.id) && this.type == domainServiceAccountInfo.type && Intrinsics.areEqual(this.number, domainServiceAccountInfo.number) && Intrinsics.areEqual(this.fullAddress, domainServiceAccountInfo.fullAddress) && Intrinsics.areEqual(this.currentDebt, domainServiceAccountInfo.currentDebt) && Intrinsics.areEqual(this.accrualUuid, domainServiceAccountInfo.accrualUuid) && Intrinsics.areEqual(this.promiseAvailable, domainServiceAccountInfo.promiseAvailable) && Intrinsics.areEqual(this.promiseExpiresAt, domainServiceAccountInfo.promiseExpiresAt) && Intrinsics.areEqual(this.partner, domainServiceAccountInfo.partner) && Intrinsics.areEqual(this.lastAccruedAt, domainServiceAccountInfo.lastAccruedAt) && Intrinsics.areEqual(this.offerAccepted, domainServiceAccountInfo.offerAccepted);
    }

    public int hashCode() {
        String str = this.id;
        int iHashCode = (str == null ? 0 : str.hashCode()) * 31;
        ServicePaymentType servicePaymentType = this.type;
        int iHashCode2 = (iHashCode + (servicePaymentType == null ? 0 : servicePaymentType.hashCode())) * 31;
        String str2 = this.number;
        int iHashCode3 = (iHashCode2 + (str2 == null ? 0 : str2.hashCode())) * 31;
        String str3 = this.fullAddress;
        int iHashCode4 = (iHashCode3 + (str3 == null ? 0 : str3.hashCode())) * 31;
        String str4 = this.currentDebt;
        int iHashCode5 = (iHashCode4 + (str4 == null ? 0 : str4.hashCode())) * 31;
        String str5 = this.accrualUuid;
        int iHashCode6 = (iHashCode5 + (str5 == null ? 0 : str5.hashCode())) * 31;
        Boolean bool = this.promiseAvailable;
        int iHashCode7 = (iHashCode6 + (bool == null ? 0 : bool.hashCode())) * 31;
        String str6 = this.promiseExpiresAt;
        int iHashCode8 = (iHashCode7 + (str6 == null ? 0 : str6.hashCode())) * 31;
        DomainPartnerInfo domainPartnerInfo = this.partner;
        int iHashCode9 = (iHashCode8 + (domainPartnerInfo == null ? 0 : domainPartnerInfo.hashCode())) * 31;
        String str7 = this.lastAccruedAt;
        int iHashCode10 = (iHashCode9 + (str7 == null ? 0 : str7.hashCode())) * 31;
        Boolean bool2 = this.offerAccepted;
        return iHashCode10 + (bool2 != null ? bool2.hashCode() : 0);
    }

    public String toString() {
        return "DomainServiceAccountInfo(id=" + this.id + ", type=" + this.type + ", number=" + this.number + ", fullAddress=" + this.fullAddress + ", currentDebt=" + this.currentDebt + ", accrualUuid=" + this.accrualUuid + ", promiseAvailable=" + this.promiseAvailable + ", promiseExpiresAt=" + this.promiseExpiresAt + ", partner=" + this.partner + ", lastAccruedAt=" + this.lastAccruedAt + ", offerAccepted=" + this.offerAccepted + ")";
    }

    public DomainServiceAccountInfo(String str, ServicePaymentType servicePaymentType, String str2, String str3, String str4, String str5, Boolean bool, String str6, DomainPartnerInfo domainPartnerInfo, String str7, Boolean bool2) {
        this.id = str;
        this.type = servicePaymentType;
        this.number = str2;
        this.fullAddress = str3;
        this.currentDebt = str4;
        this.accrualUuid = str5;
        this.promiseAvailable = bool;
        this.promiseExpiresAt = str6;
        this.partner = domainPartnerInfo;
        this.lastAccruedAt = str7;
        this.offerAccepted = bool2;
    }

    public /* synthetic */ DomainServiceAccountInfo(String str, ServicePaymentType servicePaymentType, String str2, String str3, String str4, String str5, Boolean bool, String str6, DomainPartnerInfo domainPartnerInfo, String str7, Boolean bool2, int i, DefaultConstructorMarker defaultConstructorMarker) {
        this((i & 1) != 0 ? null : str, (i & 2) != 0 ? null : servicePaymentType, (i & 4) != 0 ? null : str2, (i & 8) != 0 ? null : str3, (i & 16) != 0 ? null : str4, (i & 32) != 0 ? null : str5, (i & 64) != 0 ? null : bool, (i & 128) != 0 ? null : str6, (i & 256) != 0 ? null : domainPartnerInfo, (i & 512) != 0 ? null : str7, (i & 1024) == 0 ? bool2 : null);
    }

    public final String getId() {
        return this.id;
    }

    public final ServicePaymentType getType() {
        return this.type;
    }

    public final String getNumber() {
        return this.number;
    }

    public final String getFullAddress() {
        return this.fullAddress;
    }

    public final String getCurrentDebt() {
        return this.currentDebt;
    }

    public final String getAccrualUuid() {
        return this.accrualUuid;
    }

    public final Boolean getPromiseAvailable() {
        return this.promiseAvailable;
    }

    public final String getPromiseExpiresAt() {
        return this.promiseExpiresAt;
    }

    public final DomainPartnerInfo getPartner() {
        return this.partner;
    }

    public final String getLastAccruedAt() {
        return this.lastAccruedAt;
    }

    public final Boolean getOfferAccepted() {
        return this.offerAccepted;
    }
}

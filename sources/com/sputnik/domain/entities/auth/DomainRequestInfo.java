package com.sputnik.domain.entities.auth;

import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

/* compiled from: DomainRequestInfo.kt */
@Metadata(d1 = {"\u0000,\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0007\n\u0002\u0010\b\n\u0002\b\u0003\n\u0002\u0010\u000b\n\u0002\b\r\b\u0086\b\u0018\u00002\u00020\u0001B9\u0012\b\u0010\u0003\u001a\u0004\u0018\u00010\u0002\u0012\b\u0010\u0005\u001a\u0004\u0018\u00010\u0004\u0012\b\u0010\u0007\u001a\u0004\u0018\u00010\u0006\u0012\b\u0010\b\u001a\u0004\u0018\u00010\u0002\u0012\b\u0010\t\u001a\u0004\u0018\u00010\u0002¢\u0006\u0004\b\n\u0010\u000bJ\u0010\u0010\f\u001a\u00020\u0002HÖ\u0001¢\u0006\u0004\b\f\u0010\rJ\u0010\u0010\u000f\u001a\u00020\u000eHÖ\u0001¢\u0006\u0004\b\u000f\u0010\u0010J\u001a\u0010\u0013\u001a\u00020\u00122\b\u0010\u0011\u001a\u0004\u0018\u00010\u0001HÖ\u0003¢\u0006\u0004\b\u0013\u0010\u0014R\u0019\u0010\u0003\u001a\u0004\u0018\u00010\u00028\u0006¢\u0006\f\n\u0004\b\u0003\u0010\u0015\u001a\u0004\b\u0016\u0010\rR\u0019\u0010\u0005\u001a\u0004\u0018\u00010\u00048\u0006¢\u0006\f\n\u0004\b\u0005\u0010\u0017\u001a\u0004\b\u0018\u0010\u0019R\u0019\u0010\u0007\u001a\u0004\u0018\u00010\u00068\u0006¢\u0006\f\n\u0004\b\u0007\u0010\u001a\u001a\u0004\b\u001b\u0010\u001cR\u0019\u0010\b\u001a\u0004\u0018\u00010\u00028\u0006¢\u0006\f\n\u0004\b\b\u0010\u0015\u001a\u0004\b\u001d\u0010\rR\u0019\u0010\t\u001a\u0004\u0018\u00010\u00028\u0006¢\u0006\f\n\u0004\b\t\u0010\u0015\u001a\u0004\b\u001e\u0010\r¨\u0006\u001f"}, d2 = {"Lcom/sputnik/domain/entities/auth/DomainRequestInfo;", "", "", "phone", "Lcom/sputnik/domain/entities/auth/RegistrationWay;", "way", "Lcom/sputnik/domain/entities/auth/RegistrationState;", "state", "expiresAt", "requestId", "<init>", "(Ljava/lang/String;Lcom/sputnik/domain/entities/auth/RegistrationWay;Lcom/sputnik/domain/entities/auth/RegistrationState;Ljava/lang/String;Ljava/lang/String;)V", "toString", "()Ljava/lang/String;", "", "hashCode", "()I", "other", "", "equals", "(Ljava/lang/Object;)Z", "Ljava/lang/String;", "getPhone", "Lcom/sputnik/domain/entities/auth/RegistrationWay;", "getWay", "()Lcom/sputnik/domain/entities/auth/RegistrationWay;", "Lcom/sputnik/domain/entities/auth/RegistrationState;", "getState", "()Lcom/sputnik/domain/entities/auth/RegistrationState;", "getExpiresAt", "getRequestId", "domain"}, k = 1, mv = {1, 9, 0}, xi = 48)
/* loaded from: classes3.dex */
public final /* data */ class DomainRequestInfo {
    private final String expiresAt;
    private final String phone;
    private final String requestId;
    private final RegistrationState state;
    private final RegistrationWay way;

    public boolean equals(Object other) {
        if (this == other) {
            return true;
        }
        if (!(other instanceof DomainRequestInfo)) {
            return false;
        }
        DomainRequestInfo domainRequestInfo = (DomainRequestInfo) other;
        return Intrinsics.areEqual(this.phone, domainRequestInfo.phone) && this.way == domainRequestInfo.way && this.state == domainRequestInfo.state && Intrinsics.areEqual(this.expiresAt, domainRequestInfo.expiresAt) && Intrinsics.areEqual(this.requestId, domainRequestInfo.requestId);
    }

    public int hashCode() {
        String str = this.phone;
        int iHashCode = (str == null ? 0 : str.hashCode()) * 31;
        RegistrationWay registrationWay = this.way;
        int iHashCode2 = (iHashCode + (registrationWay == null ? 0 : registrationWay.hashCode())) * 31;
        RegistrationState registrationState = this.state;
        int iHashCode3 = (iHashCode2 + (registrationState == null ? 0 : registrationState.hashCode())) * 31;
        String str2 = this.expiresAt;
        int iHashCode4 = (iHashCode3 + (str2 == null ? 0 : str2.hashCode())) * 31;
        String str3 = this.requestId;
        return iHashCode4 + (str3 != null ? str3.hashCode() : 0);
    }

    public String toString() {
        return "DomainRequestInfo(phone=" + this.phone + ", way=" + this.way + ", state=" + this.state + ", expiresAt=" + this.expiresAt + ", requestId=" + this.requestId + ")";
    }

    public DomainRequestInfo(String str, RegistrationWay registrationWay, RegistrationState registrationState, String str2, String str3) {
        this.phone = str;
        this.way = registrationWay;
        this.state = registrationState;
        this.expiresAt = str2;
        this.requestId = str3;
    }

    public final RegistrationState getState() {
        return this.state;
    }
}

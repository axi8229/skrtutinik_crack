package com.sputnik.domain.entities.auth;

import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

/* compiled from: DomainApplyRegistration.kt */
@Metadata(d1 = {"\u0000,\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0005\n\u0002\u0010\u000b\n\u0002\b\u0005\n\u0002\u0010\b\n\u0002\b\u0015\b\u0086\b\u0018\u00002\u00020\u0001BW\u0012\b\u0010\u0003\u001a\u0004\u0018\u00010\u0002\u0012\b\u0010\u0005\u001a\u0004\u0018\u00010\u0004\u0012\b\u0010\u0007\u001a\u0004\u0018\u00010\u0006\u0012\b\u0010\b\u001a\u0004\u0018\u00010\u0006\u0012\b\u0010\t\u001a\u0004\u0018\u00010\u0006\u0012\b\u0010\n\u001a\u0004\u0018\u00010\u0006\u0012\b\u0010\u000b\u001a\u0004\u0018\u00010\u0006\u0012\b\u0010\r\u001a\u0004\u0018\u00010\f¢\u0006\u0004\b\u000e\u0010\u000fJ\u0010\u0010\u0010\u001a\u00020\u0006HÖ\u0001¢\u0006\u0004\b\u0010\u0010\u0011J\u0010\u0010\u0013\u001a\u00020\u0012HÖ\u0001¢\u0006\u0004\b\u0013\u0010\u0014J\u001a\u0010\u0016\u001a\u00020\f2\b\u0010\u0015\u001a\u0004\u0018\u00010\u0001HÖ\u0003¢\u0006\u0004\b\u0016\u0010\u0017R\u0019\u0010\u0003\u001a\u0004\u0018\u00010\u00028\u0006¢\u0006\f\n\u0004\b\u0003\u0010\u0018\u001a\u0004\b\u0019\u0010\u001aR\u0019\u0010\u0005\u001a\u0004\u0018\u00010\u00048\u0006¢\u0006\f\n\u0004\b\u0005\u0010\u001b\u001a\u0004\b\u001c\u0010\u001dR\u0019\u0010\u0007\u001a\u0004\u0018\u00010\u00068\u0006¢\u0006\f\n\u0004\b\u0007\u0010\u001e\u001a\u0004\b\u001f\u0010\u0011R\u0019\u0010\b\u001a\u0004\u0018\u00010\u00068\u0006¢\u0006\f\n\u0004\b\b\u0010\u001e\u001a\u0004\b \u0010\u0011R\u0019\u0010\t\u001a\u0004\u0018\u00010\u00068\u0006¢\u0006\f\n\u0004\b\t\u0010\u001e\u001a\u0004\b!\u0010\u0011R\u0019\u0010\n\u001a\u0004\u0018\u00010\u00068\u0006¢\u0006\f\n\u0004\b\n\u0010\u001e\u001a\u0004\b\"\u0010\u0011R\u0019\u0010\u000b\u001a\u0004\u0018\u00010\u00068\u0006¢\u0006\f\n\u0004\b\u000b\u0010\u001e\u001a\u0004\b#\u0010\u0011R\u0019\u0010\r\u001a\u0004\u0018\u00010\f8\u0006¢\u0006\f\n\u0004\b\r\u0010$\u001a\u0004\b%\u0010&¨\u0006'"}, d2 = {"Lcom/sputnik/domain/entities/auth/DomainApplyRegistration;", "", "Lcom/sputnik/domain/entities/auth/RegistrationWay;", "way", "Lcom/sputnik/domain/entities/auth/RegistrationState;", "state", "", "userSmsCode", "userSmsPhone", "limitExpiresAt", "requestId", "expiresAtUnused", "", "showHelpOnFail", "<init>", "(Lcom/sputnik/domain/entities/auth/RegistrationWay;Lcom/sputnik/domain/entities/auth/RegistrationState;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/Boolean;)V", "toString", "()Ljava/lang/String;", "", "hashCode", "()I", "other", "equals", "(Ljava/lang/Object;)Z", "Lcom/sputnik/domain/entities/auth/RegistrationWay;", "getWay", "()Lcom/sputnik/domain/entities/auth/RegistrationWay;", "Lcom/sputnik/domain/entities/auth/RegistrationState;", "getState", "()Lcom/sputnik/domain/entities/auth/RegistrationState;", "Ljava/lang/String;", "getUserSmsCode", "getUserSmsPhone", "getLimitExpiresAt", "getRequestId", "getExpiresAtUnused", "Ljava/lang/Boolean;", "getShowHelpOnFail", "()Ljava/lang/Boolean;", "domain"}, k = 1, mv = {1, 9, 0}, xi = 48)
/* loaded from: classes3.dex */
public final /* data */ class DomainApplyRegistration {
    private final String expiresAtUnused;
    private final String limitExpiresAt;
    private final String requestId;
    private final Boolean showHelpOnFail;
    private final RegistrationState state;
    private final String userSmsCode;
    private final String userSmsPhone;
    private final RegistrationWay way;

    public boolean equals(Object other) {
        if (this == other) {
            return true;
        }
        if (!(other instanceof DomainApplyRegistration)) {
            return false;
        }
        DomainApplyRegistration domainApplyRegistration = (DomainApplyRegistration) other;
        return this.way == domainApplyRegistration.way && this.state == domainApplyRegistration.state && Intrinsics.areEqual(this.userSmsCode, domainApplyRegistration.userSmsCode) && Intrinsics.areEqual(this.userSmsPhone, domainApplyRegistration.userSmsPhone) && Intrinsics.areEqual(this.limitExpiresAt, domainApplyRegistration.limitExpiresAt) && Intrinsics.areEqual(this.requestId, domainApplyRegistration.requestId) && Intrinsics.areEqual(this.expiresAtUnused, domainApplyRegistration.expiresAtUnused) && Intrinsics.areEqual(this.showHelpOnFail, domainApplyRegistration.showHelpOnFail);
    }

    public int hashCode() {
        RegistrationWay registrationWay = this.way;
        int iHashCode = (registrationWay == null ? 0 : registrationWay.hashCode()) * 31;
        RegistrationState registrationState = this.state;
        int iHashCode2 = (iHashCode + (registrationState == null ? 0 : registrationState.hashCode())) * 31;
        String str = this.userSmsCode;
        int iHashCode3 = (iHashCode2 + (str == null ? 0 : str.hashCode())) * 31;
        String str2 = this.userSmsPhone;
        int iHashCode4 = (iHashCode3 + (str2 == null ? 0 : str2.hashCode())) * 31;
        String str3 = this.limitExpiresAt;
        int iHashCode5 = (iHashCode4 + (str3 == null ? 0 : str3.hashCode())) * 31;
        String str4 = this.requestId;
        int iHashCode6 = (iHashCode5 + (str4 == null ? 0 : str4.hashCode())) * 31;
        String str5 = this.expiresAtUnused;
        int iHashCode7 = (iHashCode6 + (str5 == null ? 0 : str5.hashCode())) * 31;
        Boolean bool = this.showHelpOnFail;
        return iHashCode7 + (bool != null ? bool.hashCode() : 0);
    }

    public String toString() {
        return "DomainApplyRegistration(way=" + this.way + ", state=" + this.state + ", userSmsCode=" + this.userSmsCode + ", userSmsPhone=" + this.userSmsPhone + ", limitExpiresAt=" + this.limitExpiresAt + ", requestId=" + this.requestId + ", expiresAtUnused=" + this.expiresAtUnused + ", showHelpOnFail=" + this.showHelpOnFail + ")";
    }

    public DomainApplyRegistration(RegistrationWay registrationWay, RegistrationState registrationState, String str, String str2, String str3, String str4, String str5, Boolean bool) {
        this.way = registrationWay;
        this.state = registrationState;
        this.userSmsCode = str;
        this.userSmsPhone = str2;
        this.limitExpiresAt = str3;
        this.requestId = str4;
        this.expiresAtUnused = str5;
        this.showHelpOnFail = bool;
    }

    public final RegistrationWay getWay() {
        return this.way;
    }

    public final RegistrationState getState() {
        return this.state;
    }

    public final String getUserSmsCode() {
        return this.userSmsCode;
    }

    public final String getUserSmsPhone() {
        return this.userSmsPhone;
    }

    public final String getLimitExpiresAt() {
        return this.limitExpiresAt;
    }

    public final String getRequestId() {
        return this.requestId;
    }

    public final String getExpiresAtUnused() {
        return this.expiresAtUnused;
    }

    public final Boolean getShowHelpOnFail() {
        return this.showHelpOnFail;
    }
}

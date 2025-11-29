package com.sputnik.common.entities.sessions;

import com.google.android.gms.measurement.api.AppMeasurementSdk;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

/* compiled from: LocalSession.kt */
@Metadata(d1 = {"\u0000 \n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0010\u000e\n\u0002\b\u0004\n\u0002\u0010\u000b\n\u0002\b\u0007\n\u0002\u0010\b\n\u0002\b\u0015\b\u0086\b\u0018\u00002\u00020\u0001B?\u0012\b\u0010\u0003\u001a\u0004\u0018\u00010\u0002\u0012\u0006\u0010\u0004\u001a\u00020\u0002\u0012\u0006\u0010\u0005\u001a\u00020\u0002\u0012\b\u0010\u0006\u001a\u0004\u0018\u00010\u0002\u0012\b\u0010\b\u001a\u0004\u0018\u00010\u0007\u0012\b\u0010\t\u001a\u0004\u0018\u00010\u0002¢\u0006\u0004\b\n\u0010\u000bJ\r\u0010\f\u001a\u00020\u0002¢\u0006\u0004\b\f\u0010\rJ\u0010\u0010\u000e\u001a\u00020\u0002HÖ\u0001¢\u0006\u0004\b\u000e\u0010\rJ\u0010\u0010\u0010\u001a\u00020\u000fHÖ\u0001¢\u0006\u0004\b\u0010\u0010\u0011J\u001a\u0010\u0013\u001a\u00020\u00072\b\u0010\u0012\u001a\u0004\u0018\u00010\u0001HÖ\u0003¢\u0006\u0004\b\u0013\u0010\u0014R$\u0010\u0003\u001a\u0004\u0018\u00010\u00028\u0006@\u0006X\u0086\u000e¢\u0006\u0012\n\u0004\b\u0003\u0010\u0015\u001a\u0004\b\u0016\u0010\r\"\u0004\b\u0017\u0010\u0018R\"\u0010\u0004\u001a\u00020\u00028\u0006@\u0006X\u0086\u000e¢\u0006\u0012\n\u0004\b\u0004\u0010\u0015\u001a\u0004\b\u0019\u0010\r\"\u0004\b\u001a\u0010\u0018R\"\u0010\u0005\u001a\u00020\u00028\u0006@\u0006X\u0086\u000e¢\u0006\u0012\n\u0004\b\u0005\u0010\u0015\u001a\u0004\b\u001b\u0010\r\"\u0004\b\u001c\u0010\u0018R$\u0010\u0006\u001a\u0004\u0018\u00010\u00028\u0006@\u0006X\u0086\u000e¢\u0006\u0012\n\u0004\b\u0006\u0010\u0015\u001a\u0004\b\u001d\u0010\r\"\u0004\b\u001e\u0010\u0018R$\u0010\b\u001a\u0004\u0018\u00010\u00078\u0006@\u0006X\u0086\u000e¢\u0006\u0012\n\u0004\b\b\u0010\u001f\u001a\u0004\b\b\u0010 \"\u0004\b!\u0010\"R\u0019\u0010\t\u001a\u0004\u0018\u00010\u00028\u0006¢\u0006\f\n\u0004\b\t\u0010\u0015\u001a\u0004\b#\u0010\r¨\u0006$"}, d2 = {"Lcom/sputnik/common/entities/sessions/LocalSession;", "", "", AppMeasurementSdk.ConditionalUserProperty.NAME, "phone", "countryCode", "jwt", "", "isVisible", "image", "<init>", "(Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/Boolean;Ljava/lang/String;)V", "hash", "()Ljava/lang/String;", "toString", "", "hashCode", "()I", "other", "equals", "(Ljava/lang/Object;)Z", "Ljava/lang/String;", "getName", "setName", "(Ljava/lang/String;)V", "getPhone", "setPhone", "getCountryCode", "setCountryCode", "getJwt", "setJwt", "Ljava/lang/Boolean;", "()Ljava/lang/Boolean;", "setVisible", "(Ljava/lang/Boolean;)V", "getImage", "common_release"}, k = 1, mv = {1, 9, 0}, xi = 48)
/* loaded from: classes3.dex */
public final /* data */ class LocalSession {
    private String countryCode;
    private final String image;
    private Boolean isVisible;
    private String jwt;
    private String name;
    private String phone;

    public boolean equals(Object other) {
        if (this == other) {
            return true;
        }
        if (!(other instanceof LocalSession)) {
            return false;
        }
        LocalSession localSession = (LocalSession) other;
        return Intrinsics.areEqual(this.name, localSession.name) && Intrinsics.areEqual(this.phone, localSession.phone) && Intrinsics.areEqual(this.countryCode, localSession.countryCode) && Intrinsics.areEqual(this.jwt, localSession.jwt) && Intrinsics.areEqual(this.isVisible, localSession.isVisible) && Intrinsics.areEqual(this.image, localSession.image);
    }

    public int hashCode() {
        String str = this.name;
        int iHashCode = (((((str == null ? 0 : str.hashCode()) * 31) + this.phone.hashCode()) * 31) + this.countryCode.hashCode()) * 31;
        String str2 = this.jwt;
        int iHashCode2 = (iHashCode + (str2 == null ? 0 : str2.hashCode())) * 31;
        Boolean bool = this.isVisible;
        int iHashCode3 = (iHashCode2 + (bool == null ? 0 : bool.hashCode())) * 31;
        String str3 = this.image;
        return iHashCode3 + (str3 != null ? str3.hashCode() : 0);
    }

    public String toString() {
        return "LocalSession(name=" + this.name + ", phone=" + this.phone + ", countryCode=" + this.countryCode + ", jwt=" + this.jwt + ", isVisible=" + this.isVisible + ", image=" + this.image + ")";
    }

    public LocalSession(String str, String phone, String countryCode, String str2, Boolean bool, String str3) {
        Intrinsics.checkNotNullParameter(phone, "phone");
        Intrinsics.checkNotNullParameter(countryCode, "countryCode");
        this.name = str;
        this.phone = phone;
        this.countryCode = countryCode;
        this.jwt = str2;
        this.isVisible = bool;
        this.image = str3;
    }

    public final String getName() {
        return this.name;
    }

    public final String getPhone() {
        return this.phone;
    }

    public final String getCountryCode() {
        return this.countryCode;
    }

    public final String getJwt() {
        return this.jwt;
    }

    public final String getImage() {
        return this.image;
    }

    public final String hash() {
        return LocalSessionKt.toPhoneHash(this.countryCode + this.phone);
    }
}

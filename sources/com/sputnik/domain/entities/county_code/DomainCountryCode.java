package com.sputnik.domain.entities.county_code;

import com.google.android.gms.measurement.api.AppMeasurementSdk;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

/* compiled from: DomainCountryCode.kt */
@Metadata(d1 = {"\u0000 \n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0010\u000e\n\u0002\b\u0007\n\u0002\u0010\b\n\u0002\b\u0003\n\u0002\u0010\u000b\n\u0002\b\u0007\b\u0086\b\u0018\u00002\u00020\u0001B\u001f\u0012\u0006\u0010\u0003\u001a\u00020\u0002\u0012\u0006\u0010\u0004\u001a\u00020\u0002\u0012\u0006\u0010\u0005\u001a\u00020\u0002¢\u0006\u0004\b\u0006\u0010\u0007J\u0010\u0010\b\u001a\u00020\u0002HÖ\u0001¢\u0006\u0004\b\b\u0010\tJ\u0010\u0010\u000b\u001a\u00020\nHÖ\u0001¢\u0006\u0004\b\u000b\u0010\fJ\u001a\u0010\u000f\u001a\u00020\u000e2\b\u0010\r\u001a\u0004\u0018\u00010\u0001HÖ\u0003¢\u0006\u0004\b\u000f\u0010\u0010R\u0017\u0010\u0003\u001a\u00020\u00028\u0006¢\u0006\f\n\u0004\b\u0003\u0010\u0011\u001a\u0004\b\u0012\u0010\tR\u0017\u0010\u0004\u001a\u00020\u00028\u0006¢\u0006\f\n\u0004\b\u0004\u0010\u0011\u001a\u0004\b\u0013\u0010\tR\u0017\u0010\u0005\u001a\u00020\u00028\u0006¢\u0006\f\n\u0004\b\u0005\u0010\u0011\u001a\u0004\b\u0014\u0010\t¨\u0006\u0015"}, d2 = {"Lcom/sputnik/domain/entities/county_code/DomainCountryCode;", "", "", AppMeasurementSdk.ConditionalUserProperty.NAME, "code", "isoCode", "<init>", "(Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;)V", "toString", "()Ljava/lang/String;", "", "hashCode", "()I", "other", "", "equals", "(Ljava/lang/Object;)Z", "Ljava/lang/String;", "getName", "getCode", "getIsoCode", "domain"}, k = 1, mv = {1, 9, 0}, xi = 48)
/* loaded from: classes3.dex */
public final /* data */ class DomainCountryCode {
    private final String code;
    private final String isoCode;
    private final String name;

    public boolean equals(Object other) {
        if (this == other) {
            return true;
        }
        if (!(other instanceof DomainCountryCode)) {
            return false;
        }
        DomainCountryCode domainCountryCode = (DomainCountryCode) other;
        return Intrinsics.areEqual(this.name, domainCountryCode.name) && Intrinsics.areEqual(this.code, domainCountryCode.code) && Intrinsics.areEqual(this.isoCode, domainCountryCode.isoCode);
    }

    public int hashCode() {
        return (((this.name.hashCode() * 31) + this.code.hashCode()) * 31) + this.isoCode.hashCode();
    }

    public String toString() {
        return "DomainCountryCode(name=" + this.name + ", code=" + this.code + ", isoCode=" + this.isoCode + ")";
    }

    public DomainCountryCode(String name, String code, String isoCode) {
        Intrinsics.checkNotNullParameter(name, "name");
        Intrinsics.checkNotNullParameter(code, "code");
        Intrinsics.checkNotNullParameter(isoCode, "isoCode");
        this.name = name;
        this.code = code;
        this.isoCode = isoCode;
    }

    public final String getName() {
        return this.name;
    }

    public final String getCode() {
        return this.code;
    }

    public final String getIsoCode() {
        return this.isoCode;
    }
}

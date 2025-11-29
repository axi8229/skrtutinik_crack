package ru.yoomoney.sdk.auth.api.registrationV2.api.model;

import com.fasterxml.jackson.annotation.JsonProperty;
import com.google.android.gms.measurement.api.AppMeasurementSdk;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

@Metadata(d1 = {"\u0000(\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0018\u0002\n\u0002\b\t\n\u0002\u0010\u000b\n\u0002\b\u0002\n\u0002\u0010\b\n\u0002\b\u0002\b\u0080\b\u0018\u00002\u00020\u0001B\u0019\u0012\b\b\u0001\u0010\u0002\u001a\u00020\u0003\u0012\b\b\u0001\u0010\u0004\u001a\u00020\u0005¢\u0006\u0002\u0010\u0006J\t\u0010\u000b\u001a\u00020\u0003HÆ\u0003J\t\u0010\f\u001a\u00020\u0005HÆ\u0003J\u001d\u0010\r\u001a\u00020\u00002\b\b\u0003\u0010\u0002\u001a\u00020\u00032\b\b\u0003\u0010\u0004\u001a\u00020\u0005HÆ\u0001J\u0013\u0010\u000e\u001a\u00020\u000f2\b\u0010\u0010\u001a\u0004\u0018\u00010\u0001HÖ\u0003J\t\u0010\u0011\u001a\u00020\u0012HÖ\u0001J\t\u0010\u0013\u001a\u00020\u0003HÖ\u0001R\u0011\u0010\u0004\u001a\u00020\u0005¢\u0006\b\n\u0000\u001a\u0004\b\u0007\u0010\bR\u0011\u0010\u0002\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\t\u0010\n¨\u0006\u0014"}, d2 = {"Lru/yoomoney/sdk/auth/api/registrationV2/api/model/PrefilledPhone;", "", AppMeasurementSdk.ConditionalUserProperty.VALUE, "", "countryCallingCode", "Lru/yoomoney/sdk/auth/api/registrationV2/api/model/CountryCallingCode;", "(Ljava/lang/String;Lru/yoomoney/sdk/auth/api/registrationV2/api/model/CountryCallingCode;)V", "getCountryCallingCode", "()Lru/yoomoney/sdk/auth/api/registrationV2/api/model/CountryCallingCode;", "getValue", "()Ljava/lang/String;", "component1", "component2", "copy", "equals", "", "other", "hashCode", "", "toString", "auth_release"}, k = 1, mv = {1, 9, 0}, xi = 48)
/* loaded from: classes4.dex */
public final /* data */ class PrefilledPhone {
    private final CountryCallingCode countryCallingCode;
    private final String value;

    public PrefilledPhone(@JsonProperty(AppMeasurementSdk.ConditionalUserProperty.VALUE) String value, @JsonProperty("countryCallingCode") CountryCallingCode countryCallingCode) {
        Intrinsics.checkNotNullParameter(value, "value");
        Intrinsics.checkNotNullParameter(countryCallingCode, "countryCallingCode");
        this.value = value;
        this.countryCallingCode = countryCallingCode;
    }

    public static /* synthetic */ PrefilledPhone copy$default(PrefilledPhone prefilledPhone, String str, CountryCallingCode countryCallingCode, int i, Object obj) {
        if ((i & 1) != 0) {
            str = prefilledPhone.value;
        }
        if ((i & 2) != 0) {
            countryCallingCode = prefilledPhone.countryCallingCode;
        }
        return prefilledPhone.copy(str, countryCallingCode);
    }

    /* renamed from: component1, reason: from getter */
    public final String getValue() {
        return this.value;
    }

    /* renamed from: component2, reason: from getter */
    public final CountryCallingCode getCountryCallingCode() {
        return this.countryCallingCode;
    }

    public final PrefilledPhone copy(@JsonProperty(AppMeasurementSdk.ConditionalUserProperty.VALUE) String value, @JsonProperty("countryCallingCode") CountryCallingCode countryCallingCode) {
        Intrinsics.checkNotNullParameter(value, "value");
        Intrinsics.checkNotNullParameter(countryCallingCode, "countryCallingCode");
        return new PrefilledPhone(value, countryCallingCode);
    }

    public boolean equals(Object other) {
        if (this == other) {
            return true;
        }
        if (!(other instanceof PrefilledPhone)) {
            return false;
        }
        PrefilledPhone prefilledPhone = (PrefilledPhone) other;
        return Intrinsics.areEqual(this.value, prefilledPhone.value) && Intrinsics.areEqual(this.countryCallingCode, prefilledPhone.countryCallingCode);
    }

    public final CountryCallingCode getCountryCallingCode() {
        return this.countryCallingCode;
    }

    public final String getValue() {
        return this.value;
    }

    public int hashCode() {
        return this.countryCallingCode.hashCode() + (this.value.hashCode() * 31);
    }

    public String toString() {
        return "PrefilledPhone(value=" + this.value + ", countryCallingCode=" + this.countryCallingCode + ")";
    }
}

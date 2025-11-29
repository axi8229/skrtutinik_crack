package ru.yoomoney.sdk.auth.api.account.phoneChange.method;

import com.google.gson.annotations.SerializedName;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

@Metadata(d1 = {"\u0000\"\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\u000e\n\u0002\b\t\n\u0002\u0010\u000b\n\u0002\b\u0002\n\u0002\u0010\b\n\u0002\b\u0002\b\u0080\b\u0018\u00002\u00020\u0001B\u0015\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\u0006\u0010\u0004\u001a\u00020\u0003¢\u0006\u0002\u0010\u0005J\t\u0010\t\u001a\u00020\u0003HÆ\u0003J\t\u0010\n\u001a\u00020\u0003HÆ\u0003J\u001d\u0010\u000b\u001a\u00020\u00002\b\b\u0002\u0010\u0002\u001a\u00020\u00032\b\b\u0002\u0010\u0004\u001a\u00020\u0003HÆ\u0001J\u0013\u0010\f\u001a\u00020\r2\b\u0010\u000e\u001a\u0004\u0018\u00010\u0001HÖ\u0003J\t\u0010\u000f\u001a\u00020\u0010HÖ\u0001J\t\u0010\u0011\u001a\u00020\u0003HÖ\u0001R\u0016\u0010\u0004\u001a\u00020\u00038\u0006X\u0087\u0004¢\u0006\b\n\u0000\u001a\u0004\b\u0006\u0010\u0007R\u0016\u0010\u0002\u001a\u00020\u00038\u0006X\u0087\u0004¢\u0006\b\n\u0000\u001a\u0004\b\b\u0010\u0007¨\u0006\u0012"}, d2 = {"Lru/yoomoney/sdk/auth/api/account/phoneChange/method/PhoneChangeSetPhoneRequest;", "", "phone", "", "countryCode", "(Ljava/lang/String;Ljava/lang/String;)V", "getCountryCode", "()Ljava/lang/String;", "getPhone", "component1", "component2", "copy", "equals", "", "other", "hashCode", "", "toString", "auth_release"}, k = 1, mv = {1, 9, 0}, xi = 48)
/* loaded from: classes4.dex */
public final /* data */ class PhoneChangeSetPhoneRequest {

    @SerializedName("countryCode")
    private final String countryCode;

    @SerializedName("phone")
    private final String phone;

    public PhoneChangeSetPhoneRequest(String phone, String countryCode) {
        Intrinsics.checkNotNullParameter(phone, "phone");
        Intrinsics.checkNotNullParameter(countryCode, "countryCode");
        this.phone = phone;
        this.countryCode = countryCode;
    }

    public static /* synthetic */ PhoneChangeSetPhoneRequest copy$default(PhoneChangeSetPhoneRequest phoneChangeSetPhoneRequest, String str, String str2, int i, Object obj) {
        if ((i & 1) != 0) {
            str = phoneChangeSetPhoneRequest.phone;
        }
        if ((i & 2) != 0) {
            str2 = phoneChangeSetPhoneRequest.countryCode;
        }
        return phoneChangeSetPhoneRequest.copy(str, str2);
    }

    /* renamed from: component1, reason: from getter */
    public final String getPhone() {
        return this.phone;
    }

    /* renamed from: component2, reason: from getter */
    public final String getCountryCode() {
        return this.countryCode;
    }

    public final PhoneChangeSetPhoneRequest copy(String phone, String countryCode) {
        Intrinsics.checkNotNullParameter(phone, "phone");
        Intrinsics.checkNotNullParameter(countryCode, "countryCode");
        return new PhoneChangeSetPhoneRequest(phone, countryCode);
    }

    public boolean equals(Object other) {
        if (this == other) {
            return true;
        }
        if (!(other instanceof PhoneChangeSetPhoneRequest)) {
            return false;
        }
        PhoneChangeSetPhoneRequest phoneChangeSetPhoneRequest = (PhoneChangeSetPhoneRequest) other;
        return Intrinsics.areEqual(this.phone, phoneChangeSetPhoneRequest.phone) && Intrinsics.areEqual(this.countryCode, phoneChangeSetPhoneRequest.countryCode);
    }

    public final String getCountryCode() {
        return this.countryCode;
    }

    public final String getPhone() {
        return this.phone;
    }

    public int hashCode() {
        return this.countryCode.hashCode() + (this.phone.hashCode() * 31);
    }

    public String toString() {
        return "PhoneChangeSetPhoneRequest(phone=" + this.phone + ", countryCode=" + this.countryCode + ")";
    }
}

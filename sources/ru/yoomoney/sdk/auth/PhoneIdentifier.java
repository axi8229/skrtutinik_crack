package ru.yoomoney.sdk.auth;

import android.os.Parcel;
import android.os.Parcelable;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

@Metadata(d1 = {"\u00004\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0002\b\t\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010\u0000\n\u0002\b\u0003\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\b\u0087\b\u0018\u00002\u00020\u0001B\u0015\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\u0006\u0010\u0004\u001a\u00020\u0003¢\u0006\u0002\u0010\u0005J\t\u0010\t\u001a\u00020\u0003HÆ\u0003J\t\u0010\n\u001a\u00020\u0003HÆ\u0003J\u001d\u0010\u000b\u001a\u00020\u00002\b\b\u0002\u0010\u0002\u001a\u00020\u00032\b\b\u0002\u0010\u0004\u001a\u00020\u0003HÆ\u0001J\t\u0010\f\u001a\u00020\rHÖ\u0001J\u0013\u0010\u000e\u001a\u00020\u000f2\b\u0010\u0010\u001a\u0004\u0018\u00010\u0011HÖ\u0003J\t\u0010\u0012\u001a\u00020\rHÖ\u0001J\t\u0010\u0013\u001a\u00020\u0003HÖ\u0001J\u0019\u0010\u0014\u001a\u00020\u00152\u0006\u0010\u0016\u001a\u00020\u00172\u0006\u0010\u0018\u001a\u00020\rHÖ\u0001R\u0011\u0010\u0004\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u0006\u0010\u0007R\u0011\u0010\u0002\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\b\u0010\u0007¨\u0006\u0019"}, d2 = {"Lru/yoomoney/sdk/auth/PhoneIdentifier;", "Landroid/os/Parcelable;", "phone", "", "countryCode", "(Ljava/lang/String;Ljava/lang/String;)V", "getCountryCode", "()Ljava/lang/String;", "getPhone", "component1", "component2", "copy", "describeContents", "", "equals", "", "other", "", "hashCode", "toString", "writeToParcel", "", "parcel", "Landroid/os/Parcel;", "flags", "auth_release"}, k = 1, mv = {1, 9, 0}, xi = 48)
/* loaded from: classes4.dex */
public final /* data */ class PhoneIdentifier implements Parcelable {
    public static final Parcelable.Creator<PhoneIdentifier> CREATOR = new Creator();
    private final String countryCode;
    private final String phone;

    @Metadata(k = 3, mv = {1, 9, 0}, xi = 48)
    public static final class Creator implements Parcelable.Creator<PhoneIdentifier> {
        @Override // android.os.Parcelable.Creator
        public final PhoneIdentifier createFromParcel(Parcel parcel) {
            Intrinsics.checkNotNullParameter(parcel, "parcel");
            return new PhoneIdentifier(parcel.readString(), parcel.readString());
        }

        @Override // android.os.Parcelable.Creator
        public final PhoneIdentifier[] newArray(int i) {
            return new PhoneIdentifier[i];
        }
    }

    public PhoneIdentifier(String phone, String countryCode) {
        Intrinsics.checkNotNullParameter(phone, "phone");
        Intrinsics.checkNotNullParameter(countryCode, "countryCode");
        this.phone = phone;
        this.countryCode = countryCode;
    }

    public static /* synthetic */ PhoneIdentifier copy$default(PhoneIdentifier phoneIdentifier, String str, String str2, int i, Object obj) {
        if ((i & 1) != 0) {
            str = phoneIdentifier.phone;
        }
        if ((i & 2) != 0) {
            str2 = phoneIdentifier.countryCode;
        }
        return phoneIdentifier.copy(str, str2);
    }

    /* renamed from: component1, reason: from getter */
    public final String getPhone() {
        return this.phone;
    }

    /* renamed from: component2, reason: from getter */
    public final String getCountryCode() {
        return this.countryCode;
    }

    public final PhoneIdentifier copy(String phone, String countryCode) {
        Intrinsics.checkNotNullParameter(phone, "phone");
        Intrinsics.checkNotNullParameter(countryCode, "countryCode");
        return new PhoneIdentifier(phone, countryCode);
    }

    @Override // android.os.Parcelable
    public int describeContents() {
        return 0;
    }

    public boolean equals(Object other) {
        if (this == other) {
            return true;
        }
        if (!(other instanceof PhoneIdentifier)) {
            return false;
        }
        PhoneIdentifier phoneIdentifier = (PhoneIdentifier) other;
        return Intrinsics.areEqual(this.phone, phoneIdentifier.phone) && Intrinsics.areEqual(this.countryCode, phoneIdentifier.countryCode);
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
        return "PhoneIdentifier(phone=" + this.phone + ", countryCode=" + this.countryCode + ")";
    }

    @Override // android.os.Parcelable
    public void writeToParcel(Parcel parcel, int flags) {
        Intrinsics.checkNotNullParameter(parcel, "out");
        parcel.writeString(this.phone);
        parcel.writeString(this.countryCode);
    }
}

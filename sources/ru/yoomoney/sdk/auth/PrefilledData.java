package ru.yoomoney.sdk.auth;

import android.os.Parcel;
import android.os.Parcelable;
import com.google.android.gms.common.Scopes;
import kotlin.Metadata;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;

@Metadata(d1 = {"\u0000:\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0002\b\t\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010\u0000\n\u0002\b\u0003\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\b\u0087\b\u0018\u00002\u00020\u0001B\u001d\u0012\n\b\u0002\u0010\u0002\u001a\u0004\u0018\u00010\u0003\u0012\n\b\u0002\u0010\u0004\u001a\u0004\u0018\u00010\u0005¢\u0006\u0002\u0010\u0006J\u000b\u0010\u000b\u001a\u0004\u0018\u00010\u0003HÆ\u0003J\u000b\u0010\f\u001a\u0004\u0018\u00010\u0005HÆ\u0003J!\u0010\r\u001a\u00020\u00002\n\b\u0002\u0010\u0002\u001a\u0004\u0018\u00010\u00032\n\b\u0002\u0010\u0004\u001a\u0004\u0018\u00010\u0005HÆ\u0001J\t\u0010\u000e\u001a\u00020\u000fHÖ\u0001J\u0013\u0010\u0010\u001a\u00020\u00112\b\u0010\u0012\u001a\u0004\u0018\u00010\u0013HÖ\u0003J\t\u0010\u0014\u001a\u00020\u000fHÖ\u0001J\t\u0010\u0015\u001a\u00020\u0005HÖ\u0001J\u0019\u0010\u0016\u001a\u00020\u00172\u0006\u0010\u0018\u001a\u00020\u00192\u0006\u0010\u001a\u001a\u00020\u000fHÖ\u0001R\u0013\u0010\u0004\u001a\u0004\u0018\u00010\u0005¢\u0006\b\n\u0000\u001a\u0004\b\u0007\u0010\bR\u0013\u0010\u0002\u001a\u0004\u0018\u00010\u0003¢\u0006\b\n\u0000\u001a\u0004\b\t\u0010\n¨\u0006\u001b"}, d2 = {"Lru/yoomoney/sdk/auth/PrefilledData;", "Landroid/os/Parcelable;", "phone", "Lru/yoomoney/sdk/auth/PhoneIdentifier;", Scopes.EMAIL, "", "(Lru/yoomoney/sdk/auth/PhoneIdentifier;Ljava/lang/String;)V", "getEmail", "()Ljava/lang/String;", "getPhone", "()Lru/yoomoney/sdk/auth/PhoneIdentifier;", "component1", "component2", "copy", "describeContents", "", "equals", "", "other", "", "hashCode", "toString", "writeToParcel", "", "parcel", "Landroid/os/Parcel;", "flags", "auth_release"}, k = 1, mv = {1, 9, 0}, xi = 48)
/* loaded from: classes4.dex */
public final /* data */ class PrefilledData implements Parcelable {
    public static final Parcelable.Creator<PrefilledData> CREATOR = new Creator();
    private final String email;
    private final PhoneIdentifier phone;

    @Metadata(k = 3, mv = {1, 9, 0}, xi = 48)
    public static final class Creator implements Parcelable.Creator<PrefilledData> {
        @Override // android.os.Parcelable.Creator
        public final PrefilledData createFromParcel(Parcel parcel) {
            Intrinsics.checkNotNullParameter(parcel, "parcel");
            return new PrefilledData(parcel.readInt() == 0 ? null : PhoneIdentifier.CREATOR.createFromParcel(parcel), parcel.readString());
        }

        @Override // android.os.Parcelable.Creator
        public final PrefilledData[] newArray(int i) {
            return new PrefilledData[i];
        }
    }

    public PrefilledData() {
        this(null, 0 == true ? 1 : 0, 3, 0 == true ? 1 : 0);
    }

    public static /* synthetic */ PrefilledData copy$default(PrefilledData prefilledData, PhoneIdentifier phoneIdentifier, String str, int i, Object obj) {
        if ((i & 1) != 0) {
            phoneIdentifier = prefilledData.phone;
        }
        if ((i & 2) != 0) {
            str = prefilledData.email;
        }
        return prefilledData.copy(phoneIdentifier, str);
    }

    /* renamed from: component1, reason: from getter */
    public final PhoneIdentifier getPhone() {
        return this.phone;
    }

    /* renamed from: component2, reason: from getter */
    public final String getEmail() {
        return this.email;
    }

    public final PrefilledData copy(PhoneIdentifier phone, String email) {
        return new PrefilledData(phone, email);
    }

    @Override // android.os.Parcelable
    public int describeContents() {
        return 0;
    }

    public boolean equals(Object other) {
        if (this == other) {
            return true;
        }
        if (!(other instanceof PrefilledData)) {
            return false;
        }
        PrefilledData prefilledData = (PrefilledData) other;
        return Intrinsics.areEqual(this.phone, prefilledData.phone) && Intrinsics.areEqual(this.email, prefilledData.email);
    }

    public final String getEmail() {
        return this.email;
    }

    public final PhoneIdentifier getPhone() {
        return this.phone;
    }

    public int hashCode() {
        PhoneIdentifier phoneIdentifier = this.phone;
        int iHashCode = (phoneIdentifier == null ? 0 : phoneIdentifier.hashCode()) * 31;
        String str = this.email;
        return iHashCode + (str != null ? str.hashCode() : 0);
    }

    public String toString() {
        return "PrefilledData(phone=" + this.phone + ", email=" + this.email + ")";
    }

    @Override // android.os.Parcelable
    public void writeToParcel(Parcel parcel, int flags) {
        Intrinsics.checkNotNullParameter(parcel, "out");
        PhoneIdentifier phoneIdentifier = this.phone;
        if (phoneIdentifier == null) {
            parcel.writeInt(0);
        } else {
            parcel.writeInt(1);
            phoneIdentifier.writeToParcel(parcel, flags);
        }
        parcel.writeString(this.email);
    }

    public PrefilledData(PhoneIdentifier phoneIdentifier, String str) {
        this.phone = phoneIdentifier;
        this.email = str;
    }

    public /* synthetic */ PrefilledData(PhoneIdentifier phoneIdentifier, String str, int i, DefaultConstructorMarker defaultConstructorMarker) {
        this((i & 1) != 0 ? null : phoneIdentifier, (i & 2) != 0 ? null : str);
    }
}

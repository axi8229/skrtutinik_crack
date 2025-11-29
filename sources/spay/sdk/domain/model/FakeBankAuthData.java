package spay.sdk.domain.model;

import android.os.Parcel;
import android.os.Parcelable;
import kotlin.Metadata;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import npi.spay.Q1;

@Metadata(d1 = {"\u00006\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u001e\n\u0002\u0010\b\n\u0002\b\u0002\n\u0002\u0010\u0000\n\u0002\b\u0003\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\b\u0087\b\u0018\u00002\u00020\u0001BM\u0012\n\b\u0002\u0010\u0002\u001a\u0004\u0018\u00010\u0003\u0012\n\b\u0002\u0010\u0004\u001a\u0004\u0018\u00010\u0005\u0012\n\b\u0002\u0010\u0006\u001a\u0004\u0018\u00010\u0005\u0012\n\b\u0002\u0010\u0007\u001a\u0004\u0018\u00010\u0005\u0012\n\b\u0002\u0010\b\u001a\u0004\u0018\u00010\u0005\u0012\n\b\u0002\u0010\t\u001a\u0004\u0018\u00010\u0005¢\u0006\u0002\u0010\nJ\u0010\u0010\u001b\u001a\u0004\u0018\u00010\u0003HÆ\u0003¢\u0006\u0002\u0010\u0013J\u000b\u0010\u001c\u001a\u0004\u0018\u00010\u0005HÆ\u0003J\u000b\u0010\u001d\u001a\u0004\u0018\u00010\u0005HÆ\u0003J\u000b\u0010\u001e\u001a\u0004\u0018\u00010\u0005HÆ\u0003J\u000b\u0010\u001f\u001a\u0004\u0018\u00010\u0005HÆ\u0003J\u000b\u0010 \u001a\u0004\u0018\u00010\u0005HÆ\u0003JV\u0010!\u001a\u00020\u00002\n\b\u0002\u0010\u0002\u001a\u0004\u0018\u00010\u00032\n\b\u0002\u0010\u0004\u001a\u0004\u0018\u00010\u00052\n\b\u0002\u0010\u0006\u001a\u0004\u0018\u00010\u00052\n\b\u0002\u0010\u0007\u001a\u0004\u0018\u00010\u00052\n\b\u0002\u0010\b\u001a\u0004\u0018\u00010\u00052\n\b\u0002\u0010\t\u001a\u0004\u0018\u00010\u0005HÆ\u0001¢\u0006\u0002\u0010\"J\t\u0010#\u001a\u00020$HÖ\u0001J\u0013\u0010%\u001a\u00020\u00032\b\u0010&\u001a\u0004\u0018\u00010'HÖ\u0003J\t\u0010(\u001a\u00020$HÖ\u0001J\t\u0010)\u001a\u00020\u0005HÖ\u0001J\u0019\u0010*\u001a\u00020+2\u0006\u0010,\u001a\u00020-2\u0006\u0010.\u001a\u00020$HÖ\u0001R\u001c\u0010\u0007\u001a\u0004\u0018\u00010\u0005X\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u000b\u0010\f\"\u0004\b\r\u0010\u000eR\u001c\u0010\t\u001a\u0004\u0018\u00010\u0005X\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u000f\u0010\f\"\u0004\b\u0010\u0010\u000eR\u001c\u0010\b\u001a\u0004\u0018\u00010\u0005X\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u0011\u0010\f\"\u0004\b\u0012\u0010\u000eR\u001e\u0010\u0002\u001a\u0004\u0018\u00010\u0003X\u0086\u000e¢\u0006\u0010\n\u0002\u0010\u0016\u001a\u0004\b\u0002\u0010\u0013\"\u0004\b\u0014\u0010\u0015R\u001c\u0010\u0006\u001a\u0004\u0018\u00010\u0005X\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u0017\u0010\f\"\u0004\b\u0018\u0010\u000eR\u001c\u0010\u0004\u001a\u0004\u0018\u00010\u0005X\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u0019\u0010\f\"\u0004\b\u001a\u0010\u000e¨\u0006/"}, d2 = {"Lspay/sdk/domain/model/FakeBankAuthData;", "Landroid/os/Parcelable;", "isSuccess", "", "state", "", "nonce", "authCode", "errorDescription", "errorCode", "(Ljava/lang/Boolean;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;)V", "getAuthCode", "()Ljava/lang/String;", "setAuthCode", "(Ljava/lang/String;)V", "getErrorCode", "setErrorCode", "getErrorDescription", "setErrorDescription", "()Ljava/lang/Boolean;", "setSuccess", "(Ljava/lang/Boolean;)V", "Ljava/lang/Boolean;", "getNonce", "setNonce", "getState", "setState", "component1", "component2", "component3", "component4", "component5", "component6", "copy", "(Ljava/lang/Boolean;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;)Lspay/sdk/domain/model/FakeBankAuthData;", "describeContents", "", "equals", "other", "", "hashCode", "toString", "writeToParcel", "", "parcel", "Landroid/os/Parcel;", "flags", "SPaySDK_release"}, k = 1, mv = {1, 8, 0}, xi = 48)
/* loaded from: classes5.dex */
public final /* data */ class FakeBankAuthData implements Parcelable {
    public static final Parcelable.Creator<FakeBankAuthData> CREATOR = new Creator();
    private String authCode;
    private String errorCode;
    private String errorDescription;
    private Boolean isSuccess;
    private String nonce;
    private String state;

    @Metadata(k = 3, mv = {1, 8, 0}, xi = 48)
    public static final class Creator implements Parcelable.Creator<FakeBankAuthData> {
        @Override // android.os.Parcelable.Creator
        public final FakeBankAuthData createFromParcel(Parcel parcel) {
            Boolean boolValueOf;
            Intrinsics.checkNotNullParameter(parcel, "parcel");
            if (parcel.readInt() == 0) {
                boolValueOf = null;
            } else {
                boolValueOf = Boolean.valueOf(parcel.readInt() != 0);
            }
            return new FakeBankAuthData(boolValueOf, parcel.readString(), parcel.readString(), parcel.readString(), parcel.readString(), parcel.readString());
        }

        @Override // android.os.Parcelable.Creator
        public final FakeBankAuthData[] newArray(int i) {
            return new FakeBankAuthData[i];
        }
    }

    public FakeBankAuthData() {
        this(null, null, null, null, null, null, 63, null);
    }

    public static /* synthetic */ FakeBankAuthData copy$default(FakeBankAuthData fakeBankAuthData, Boolean bool, String str, String str2, String str3, String str4, String str5, int i, Object obj) {
        if ((i & 1) != 0) {
            bool = fakeBankAuthData.isSuccess;
        }
        if ((i & 2) != 0) {
            str = fakeBankAuthData.state;
        }
        String str6 = str;
        if ((i & 4) != 0) {
            str2 = fakeBankAuthData.nonce;
        }
        String str7 = str2;
        if ((i & 8) != 0) {
            str3 = fakeBankAuthData.authCode;
        }
        String str8 = str3;
        if ((i & 16) != 0) {
            str4 = fakeBankAuthData.errorDescription;
        }
        String str9 = str4;
        if ((i & 32) != 0) {
            str5 = fakeBankAuthData.errorCode;
        }
        return fakeBankAuthData.copy(bool, str6, str7, str8, str9, str5);
    }

    /* renamed from: component1, reason: from getter */
    public final Boolean getIsSuccess() {
        return this.isSuccess;
    }

    /* renamed from: component2, reason: from getter */
    public final String getState() {
        return this.state;
    }

    /* renamed from: component3, reason: from getter */
    public final String getNonce() {
        return this.nonce;
    }

    /* renamed from: component4, reason: from getter */
    public final String getAuthCode() {
        return this.authCode;
    }

    /* renamed from: component5, reason: from getter */
    public final String getErrorDescription() {
        return this.errorDescription;
    }

    /* renamed from: component6, reason: from getter */
    public final String getErrorCode() {
        return this.errorCode;
    }

    public final FakeBankAuthData copy(Boolean isSuccess, String state, String nonce, String authCode, String errorDescription, String errorCode) {
        return new FakeBankAuthData(isSuccess, state, nonce, authCode, errorDescription, errorCode);
    }

    @Override // android.os.Parcelable
    public int describeContents() {
        return 0;
    }

    public boolean equals(Object other) {
        if (this == other) {
            return true;
        }
        if (!(other instanceof FakeBankAuthData)) {
            return false;
        }
        FakeBankAuthData fakeBankAuthData = (FakeBankAuthData) other;
        return Intrinsics.areEqual(this.isSuccess, fakeBankAuthData.isSuccess) && Intrinsics.areEqual(this.state, fakeBankAuthData.state) && Intrinsics.areEqual(this.nonce, fakeBankAuthData.nonce) && Intrinsics.areEqual(this.authCode, fakeBankAuthData.authCode) && Intrinsics.areEqual(this.errorDescription, fakeBankAuthData.errorDescription) && Intrinsics.areEqual(this.errorCode, fakeBankAuthData.errorCode);
    }

    public final String getAuthCode() {
        return this.authCode;
    }

    public final String getErrorCode() {
        return this.errorCode;
    }

    public final String getErrorDescription() {
        return this.errorDescription;
    }

    public final String getNonce() {
        return this.nonce;
    }

    public final String getState() {
        return this.state;
    }

    public int hashCode() {
        Boolean bool = this.isSuccess;
        int iHashCode = (bool == null ? 0 : bool.hashCode()) * 31;
        String str = this.state;
        int iHashCode2 = (iHashCode + (str == null ? 0 : str.hashCode())) * 31;
        String str2 = this.nonce;
        int iHashCode3 = (iHashCode2 + (str2 == null ? 0 : str2.hashCode())) * 31;
        String str3 = this.authCode;
        int iHashCode4 = (iHashCode3 + (str3 == null ? 0 : str3.hashCode())) * 31;
        String str4 = this.errorDescription;
        int iHashCode5 = (iHashCode4 + (str4 == null ? 0 : str4.hashCode())) * 31;
        String str5 = this.errorCode;
        return iHashCode5 + (str5 != null ? str5.hashCode() : 0);
    }

    public final Boolean isSuccess() {
        return this.isSuccess;
    }

    public final void setAuthCode(String str) {
        this.authCode = str;
    }

    public final void setErrorCode(String str) {
        this.errorCode = str;
    }

    public final void setErrorDescription(String str) {
        this.errorDescription = str;
    }

    public final void setNonce(String str) {
        this.nonce = str;
    }

    public final void setState(String str) {
        this.state = str;
    }

    public final void setSuccess(Boolean bool) {
        this.isSuccess = bool;
    }

    public String toString() {
        StringBuilder sb = new StringBuilder("FakeBankAuthData(isSuccess=");
        sb.append(this.isSuccess);
        sb.append(", state=");
        sb.append(this.state);
        sb.append(", nonce=");
        sb.append(this.nonce);
        sb.append(", authCode=");
        sb.append(this.authCode);
        sb.append(", errorDescription=");
        sb.append(this.errorDescription);
        sb.append(", errorCode=");
        return Q1.a(sb, this.errorCode, ')');
    }

    /* JADX WARN: Multi-variable type inference failed */
    @Override // android.os.Parcelable
    public void writeToParcel(Parcel parcel, int flags) {
        int iBooleanValue;
        Intrinsics.checkNotNullParameter(parcel, "out");
        Boolean bool = this.isSuccess;
        if (bool == null) {
            iBooleanValue = 0;
        } else {
            parcel.writeInt(1);
            iBooleanValue = bool.booleanValue();
        }
        parcel.writeInt(iBooleanValue);
        parcel.writeString(this.state);
        parcel.writeString(this.nonce);
        parcel.writeString(this.authCode);
        parcel.writeString(this.errorDescription);
        parcel.writeString(this.errorCode);
    }

    public FakeBankAuthData(Boolean bool, String str, String str2, String str3, String str4, String str5) {
        this.isSuccess = bool;
        this.state = str;
        this.nonce = str2;
        this.authCode = str3;
        this.errorDescription = str4;
        this.errorCode = str5;
    }

    public /* synthetic */ FakeBankAuthData(Boolean bool, String str, String str2, String str3, String str4, String str5, int i, DefaultConstructorMarker defaultConstructorMarker) {
        this((i & 1) != 0 ? null : bool, (i & 2) != 0 ? null : str, (i & 4) != 0 ? null : str2, (i & 8) != 0 ? null : str3, (i & 16) != 0 ? null : str4, (i & 32) != 0 ? null : str5);
    }
}

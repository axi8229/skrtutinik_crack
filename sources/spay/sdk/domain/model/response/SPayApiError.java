package spay.sdk.domain.model.response;

import android.os.Parcel;
import android.os.Parcelable;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import npi.spay.Q1;
import spay.sdk.domain.model.response.paymentToken.errorResponse.FraudMonCheckResult;

@Metadata(d1 = {"\u0000<\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u000e\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010\u0000\n\u0002\b\u0003\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\b\u0081\b\u0018\u00002\u00020\u0001B+\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\b\u0010\u0004\u001a\u0004\u0018\u00010\u0003\u0012\b\u0010\u0005\u001a\u0004\u0018\u00010\u0006\u0012\b\u0010\u0007\u001a\u0004\u0018\u00010\u0003¢\u0006\u0002\u0010\bJ\t\u0010\u000f\u001a\u00020\u0003HÆ\u0003J\u000b\u0010\u0010\u001a\u0004\u0018\u00010\u0003HÆ\u0003J\u000b\u0010\u0011\u001a\u0004\u0018\u00010\u0006HÆ\u0003J\u000b\u0010\u0012\u001a\u0004\u0018\u00010\u0003HÆ\u0003J7\u0010\u0013\u001a\u00020\u00002\b\b\u0002\u0010\u0002\u001a\u00020\u00032\n\b\u0002\u0010\u0004\u001a\u0004\u0018\u00010\u00032\n\b\u0002\u0010\u0005\u001a\u0004\u0018\u00010\u00062\n\b\u0002\u0010\u0007\u001a\u0004\u0018\u00010\u0003HÆ\u0001J\t\u0010\u0014\u001a\u00020\u0015HÖ\u0001J\u0013\u0010\u0016\u001a\u00020\u00172\b\u0010\u0018\u001a\u0004\u0018\u00010\u0019HÖ\u0003J\t\u0010\u001a\u001a\u00020\u0015HÖ\u0001J\t\u0010\u001b\u001a\u00020\u0003HÖ\u0001J\u0019\u0010\u001c\u001a\u00020\u001d2\u0006\u0010\u001e\u001a\u00020\u001f2\u0006\u0010 \u001a\u00020\u0015HÖ\u0001R\u0013\u0010\u0004\u001a\u0004\u0018\u00010\u0003¢\u0006\b\n\u0000\u001a\u0004\b\t\u0010\nR\u0011\u0010\u0002\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u000b\u0010\nR\u0013\u0010\u0005\u001a\u0004\u0018\u00010\u0006¢\u0006\b\n\u0000\u001a\u0004\b\f\u0010\rR\u0013\u0010\u0007\u001a\u0004\u0018\u00010\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u000e\u0010\n¨\u0006!"}, d2 = {"Lspay/sdk/domain/model/response/SPayApiError;", "Landroid/os/Parcelable;", "errorCode", "", "description", "fraudMonCheckResult", "Lspay/sdk/domain/model/response/paymentToken/errorResponse/FraudMonCheckResult;", "info", "(Ljava/lang/String;Ljava/lang/String;Lspay/sdk/domain/model/response/paymentToken/errorResponse/FraudMonCheckResult;Ljava/lang/String;)V", "getDescription", "()Ljava/lang/String;", "getErrorCode", "getFraudMonCheckResult", "()Lspay/sdk/domain/model/response/paymentToken/errorResponse/FraudMonCheckResult;", "getInfo", "component1", "component2", "component3", "component4", "copy", "describeContents", "", "equals", "", "other", "", "hashCode", "toString", "writeToParcel", "", "parcel", "Landroid/os/Parcel;", "flags", "SPaySDK_release"}, k = 1, mv = {1, 8, 0}, xi = 48)
/* loaded from: classes5.dex */
public final /* data */ class SPayApiError implements Parcelable {
    public static final Parcelable.Creator<SPayApiError> CREATOR = new Creator();
    private final String description;
    private final String errorCode;
    private final FraudMonCheckResult fraudMonCheckResult;
    private final String info;

    @Metadata(k = 3, mv = {1, 8, 0}, xi = 48)
    public static final class Creator implements Parcelable.Creator<SPayApiError> {
        @Override // android.os.Parcelable.Creator
        public final SPayApiError createFromParcel(Parcel parcel) {
            Intrinsics.checkNotNullParameter(parcel, "parcel");
            return new SPayApiError(parcel.readString(), parcel.readString(), parcel.readInt() == 0 ? null : FraudMonCheckResult.CREATOR.createFromParcel(parcel), parcel.readString());
        }

        @Override // android.os.Parcelable.Creator
        public final SPayApiError[] newArray(int i) {
            return new SPayApiError[i];
        }
    }

    public SPayApiError(String errorCode, String str, FraudMonCheckResult fraudMonCheckResult, String str2) {
        Intrinsics.checkNotNullParameter(errorCode, "errorCode");
        this.errorCode = errorCode;
        this.description = str;
        this.fraudMonCheckResult = fraudMonCheckResult;
        this.info = str2;
    }

    public static /* synthetic */ SPayApiError copy$default(SPayApiError sPayApiError, String str, String str2, FraudMonCheckResult fraudMonCheckResult, String str3, int i, Object obj) {
        if ((i & 1) != 0) {
            str = sPayApiError.errorCode;
        }
        if ((i & 2) != 0) {
            str2 = sPayApiError.description;
        }
        if ((i & 4) != 0) {
            fraudMonCheckResult = sPayApiError.fraudMonCheckResult;
        }
        if ((i & 8) != 0) {
            str3 = sPayApiError.info;
        }
        return sPayApiError.copy(str, str2, fraudMonCheckResult, str3);
    }

    /* renamed from: component1, reason: from getter */
    public final String getErrorCode() {
        return this.errorCode;
    }

    /* renamed from: component2, reason: from getter */
    public final String getDescription() {
        return this.description;
    }

    /* renamed from: component3, reason: from getter */
    public final FraudMonCheckResult getFraudMonCheckResult() {
        return this.fraudMonCheckResult;
    }

    /* renamed from: component4, reason: from getter */
    public final String getInfo() {
        return this.info;
    }

    public final SPayApiError copy(String errorCode, String description, FraudMonCheckResult fraudMonCheckResult, String info) {
        Intrinsics.checkNotNullParameter(errorCode, "errorCode");
        return new SPayApiError(errorCode, description, fraudMonCheckResult, info);
    }

    @Override // android.os.Parcelable
    public int describeContents() {
        return 0;
    }

    public boolean equals(Object other) {
        if (this == other) {
            return true;
        }
        if (!(other instanceof SPayApiError)) {
            return false;
        }
        SPayApiError sPayApiError = (SPayApiError) other;
        return Intrinsics.areEqual(this.errorCode, sPayApiError.errorCode) && Intrinsics.areEqual(this.description, sPayApiError.description) && Intrinsics.areEqual(this.fraudMonCheckResult, sPayApiError.fraudMonCheckResult) && Intrinsics.areEqual(this.info, sPayApiError.info);
    }

    public final String getDescription() {
        return this.description;
    }

    public final String getErrorCode() {
        return this.errorCode;
    }

    public final FraudMonCheckResult getFraudMonCheckResult() {
        return this.fraudMonCheckResult;
    }

    public final String getInfo() {
        return this.info;
    }

    public int hashCode() {
        int iHashCode = this.errorCode.hashCode() * 31;
        String str = this.description;
        int iHashCode2 = (iHashCode + (str == null ? 0 : str.hashCode())) * 31;
        FraudMonCheckResult fraudMonCheckResult = this.fraudMonCheckResult;
        int iHashCode3 = (iHashCode2 + (fraudMonCheckResult == null ? 0 : fraudMonCheckResult.hashCode())) * 31;
        String str2 = this.info;
        return iHashCode3 + (str2 != null ? str2.hashCode() : 0);
    }

    public String toString() {
        StringBuilder sb = new StringBuilder("SPayApiError(errorCode=");
        sb.append(this.errorCode);
        sb.append(", description=");
        sb.append(this.description);
        sb.append(", fraudMonCheckResult=");
        sb.append(this.fraudMonCheckResult);
        sb.append(", info=");
        return Q1.a(sb, this.info, ')');
    }

    @Override // android.os.Parcelable
    public void writeToParcel(Parcel parcel, int flags) {
        Intrinsics.checkNotNullParameter(parcel, "out");
        parcel.writeString(this.errorCode);
        parcel.writeString(this.description);
        FraudMonCheckResult fraudMonCheckResult = this.fraudMonCheckResult;
        if (fraudMonCheckResult == null) {
            parcel.writeInt(0);
        } else {
            parcel.writeInt(1);
            fraudMonCheckResult.writeToParcel(parcel, flags);
        }
        parcel.writeString(this.info);
    }
}

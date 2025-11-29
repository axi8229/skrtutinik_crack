package spay.sdk.data.dto.response;

import android.os.Parcel;
import android.os.Parcelable;
import com.google.gson.annotations.SerializedName;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import npi.spay.Kg;
import npi.spay.Q1;
import spay.sdk.data.dto.response.paymentToken.FraudMonCheckResultResponseBodyDto;
import spay.sdk.domain.model.response.SPayApiError;

@Metadata(d1 = {"\u0000D\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0011\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010\u0000\n\u0002\b\u0004\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\b\u0081\b\u0018\u00002\b\u0012\u0004\u0012\u00020\u00020\u00012\u00020\u0003B7\u0012\b\u0010\u0004\u001a\u0004\u0018\u00010\u0005\u0012\b\u0010\u0006\u001a\u0004\u0018\u00010\u0005\u0012\b\u0010\u0007\u001a\u0004\u0018\u00010\b\u0012\b\u0010\t\u001a\u0004\u0018\u00010\b\u0012\b\u0010\n\u001a\u0004\u0018\u00010\u0005¢\u0006\u0002\u0010\u000bJ\u000b\u0010\u0013\u001a\u0004\u0018\u00010\u0005HÆ\u0003J\u000b\u0010\u0014\u001a\u0004\u0018\u00010\u0005HÆ\u0003J\u000b\u0010\u0015\u001a\u0004\u0018\u00010\bHÆ\u0003J\u000b\u0010\u0016\u001a\u0004\u0018\u00010\bHÆ\u0003J\u000b\u0010\u0017\u001a\u0004\u0018\u00010\u0005HÆ\u0003JE\u0010\u0018\u001a\u00020\u00002\n\b\u0002\u0010\u0004\u001a\u0004\u0018\u00010\u00052\n\b\u0002\u0010\u0006\u001a\u0004\u0018\u00010\u00052\n\b\u0002\u0010\u0007\u001a\u0004\u0018\u00010\b2\n\b\u0002\u0010\t\u001a\u0004\u0018\u00010\b2\n\b\u0002\u0010\n\u001a\u0004\u0018\u00010\u0005HÆ\u0001J\t\u0010\u0019\u001a\u00020\u001aHÖ\u0001J\u0013\u0010\u001b\u001a\u00020\u001c2\b\u0010\u001d\u001a\u0004\u0018\u00010\u001eHÖ\u0003J\t\u0010\u001f\u001a\u00020\u001aHÖ\u0001J\b\u0010 \u001a\u00020\u0002H\u0016J\t\u0010!\u001a\u00020\u0005HÖ\u0001J\u0019\u0010\"\u001a\u00020#2\u0006\u0010$\u001a\u00020%2\u0006\u0010&\u001a\u00020\u001aHÖ\u0001R\u0018\u0010\u0006\u001a\u0004\u0018\u00010\u00058\u0006X\u0087\u0004¢\u0006\b\n\u0000\u001a\u0004\b\f\u0010\rR\u0018\u0010\u0004\u001a\u0004\u0018\u00010\u00058\u0006X\u0087\u0004¢\u0006\b\n\u0000\u001a\u0004\b\u000e\u0010\rR\u0018\u0010\u0007\u001a\u0004\u0018\u00010\b8\u0006X\u0087\u0004¢\u0006\b\n\u0000\u001a\u0004\b\u000f\u0010\u0010R\u0018\u0010\n\u001a\u0004\u0018\u00010\u00058\u0006X\u0087\u0004¢\u0006\b\n\u0000\u001a\u0004\b\u0011\u0010\rR\u0018\u0010\t\u001a\u0004\u0018\u00010\b8\u0006X\u0087\u0004¢\u0006\b\n\u0000\u001a\u0004\b\u0012\u0010\u0010¨\u0006'"}, d2 = {"Lspay/sdk/data/dto/response/SPayErrorDto;", "Lspay/sdk/data/dto/response/DataDtoInterface;", "Lspay/sdk/domain/model/response/SPayApiError;", "Landroid/os/Parcelable;", "errorCode", "", "description", "fraudMonCheckResultResponseBodyDto", "Lspay/sdk/data/dto/response/paymentToken/FraudMonCheckResultResponseBodyDto;", "oldFraudMonCheckResultResponseBodyDto", "info", "(Ljava/lang/String;Ljava/lang/String;Lspay/sdk/data/dto/response/paymentToken/FraudMonCheckResultResponseBodyDto;Lspay/sdk/data/dto/response/paymentToken/FraudMonCheckResultResponseBodyDto;Ljava/lang/String;)V", "getDescription", "()Ljava/lang/String;", "getErrorCode", "getFraudMonCheckResultResponseBodyDto", "()Lspay/sdk/data/dto/response/paymentToken/FraudMonCheckResultResponseBodyDto;", "getInfo", "getOldFraudMonCheckResultResponseBodyDto", "component1", "component2", "component3", "component4", "component5", "copy", "describeContents", "", "equals", "", "other", "", "hashCode", "toModel", "toString", "writeToParcel", "", "parcel", "Landroid/os/Parcel;", "flags", "SPaySDK_release"}, k = 1, mv = {1, 8, 0}, xi = 48)
/* loaded from: classes5.dex */
public final /* data */ class SPayErrorDto implements DataDtoInterface<SPayApiError>, Parcelable {
    public static final Parcelable.Creator<SPayErrorDto> CREATOR = new Creator();

    @SerializedName("description")
    private final String description;

    @SerializedName("errorCode")
    private final String errorCode;

    @SerializedName("fraudMonCheckResult")
    private final FraudMonCheckResultResponseBodyDto fraudMonCheckResultResponseBodyDto;

    @SerializedName("info")
    private final String info;

    @SerializedName("fraudMonСheckResult")
    private final FraudMonCheckResultResponseBodyDto oldFraudMonCheckResultResponseBodyDto;

    @Metadata(k = 3, mv = {1, 8, 0}, xi = 48)
    public static final class Creator implements Parcelable.Creator<SPayErrorDto> {
        @Override // android.os.Parcelable.Creator
        public final SPayErrorDto createFromParcel(Parcel parcel) {
            Intrinsics.checkNotNullParameter(parcel, "parcel");
            return new SPayErrorDto(parcel.readString(), parcel.readString(), parcel.readInt() == 0 ? null : FraudMonCheckResultResponseBodyDto.CREATOR.createFromParcel(parcel), parcel.readInt() != 0 ? FraudMonCheckResultResponseBodyDto.CREATOR.createFromParcel(parcel) : null, parcel.readString());
        }

        @Override // android.os.Parcelable.Creator
        public final SPayErrorDto[] newArray(int i) {
            return new SPayErrorDto[i];
        }
    }

    public SPayErrorDto(String str, String str2, FraudMonCheckResultResponseBodyDto fraudMonCheckResultResponseBodyDto, FraudMonCheckResultResponseBodyDto fraudMonCheckResultResponseBodyDto2, String str3) {
        this.errorCode = str;
        this.description = str2;
        this.fraudMonCheckResultResponseBodyDto = fraudMonCheckResultResponseBodyDto;
        this.oldFraudMonCheckResultResponseBodyDto = fraudMonCheckResultResponseBodyDto2;
        this.info = str3;
    }

    public static /* synthetic */ SPayErrorDto copy$default(SPayErrorDto sPayErrorDto, String str, String str2, FraudMonCheckResultResponseBodyDto fraudMonCheckResultResponseBodyDto, FraudMonCheckResultResponseBodyDto fraudMonCheckResultResponseBodyDto2, String str3, int i, Object obj) {
        if ((i & 1) != 0) {
            str = sPayErrorDto.errorCode;
        }
        if ((i & 2) != 0) {
            str2 = sPayErrorDto.description;
        }
        String str4 = str2;
        if ((i & 4) != 0) {
            fraudMonCheckResultResponseBodyDto = sPayErrorDto.fraudMonCheckResultResponseBodyDto;
        }
        FraudMonCheckResultResponseBodyDto fraudMonCheckResultResponseBodyDto3 = fraudMonCheckResultResponseBodyDto;
        if ((i & 8) != 0) {
            fraudMonCheckResultResponseBodyDto2 = sPayErrorDto.oldFraudMonCheckResultResponseBodyDto;
        }
        FraudMonCheckResultResponseBodyDto fraudMonCheckResultResponseBodyDto4 = fraudMonCheckResultResponseBodyDto2;
        if ((i & 16) != 0) {
            str3 = sPayErrorDto.info;
        }
        return sPayErrorDto.copy(str, str4, fraudMonCheckResultResponseBodyDto3, fraudMonCheckResultResponseBodyDto4, str3);
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
    public final FraudMonCheckResultResponseBodyDto getFraudMonCheckResultResponseBodyDto() {
        return this.fraudMonCheckResultResponseBodyDto;
    }

    /* renamed from: component4, reason: from getter */
    public final FraudMonCheckResultResponseBodyDto getOldFraudMonCheckResultResponseBodyDto() {
        return this.oldFraudMonCheckResultResponseBodyDto;
    }

    /* renamed from: component5, reason: from getter */
    public final String getInfo() {
        return this.info;
    }

    public final SPayErrorDto copy(String errorCode, String description, FraudMonCheckResultResponseBodyDto fraudMonCheckResultResponseBodyDto, FraudMonCheckResultResponseBodyDto oldFraudMonCheckResultResponseBodyDto, String info) {
        return new SPayErrorDto(errorCode, description, fraudMonCheckResultResponseBodyDto, oldFraudMonCheckResultResponseBodyDto, info);
    }

    @Override // android.os.Parcelable
    public int describeContents() {
        return 0;
    }

    public boolean equals(Object other) {
        if (this == other) {
            return true;
        }
        if (!(other instanceof SPayErrorDto)) {
            return false;
        }
        SPayErrorDto sPayErrorDto = (SPayErrorDto) other;
        return Intrinsics.areEqual(this.errorCode, sPayErrorDto.errorCode) && Intrinsics.areEqual(this.description, sPayErrorDto.description) && Intrinsics.areEqual(this.fraudMonCheckResultResponseBodyDto, sPayErrorDto.fraudMonCheckResultResponseBodyDto) && Intrinsics.areEqual(this.oldFraudMonCheckResultResponseBodyDto, sPayErrorDto.oldFraudMonCheckResultResponseBodyDto) && Intrinsics.areEqual(this.info, sPayErrorDto.info);
    }

    public final String getDescription() {
        return this.description;
    }

    public final String getErrorCode() {
        return this.errorCode;
    }

    public final FraudMonCheckResultResponseBodyDto getFraudMonCheckResultResponseBodyDto() {
        return this.fraudMonCheckResultResponseBodyDto;
    }

    public final String getInfo() {
        return this.info;
    }

    public final FraudMonCheckResultResponseBodyDto getOldFraudMonCheckResultResponseBodyDto() {
        return this.oldFraudMonCheckResultResponseBodyDto;
    }

    public int hashCode() {
        String str = this.errorCode;
        int iHashCode = (str == null ? 0 : str.hashCode()) * 31;
        String str2 = this.description;
        int iHashCode2 = (iHashCode + (str2 == null ? 0 : str2.hashCode())) * 31;
        FraudMonCheckResultResponseBodyDto fraudMonCheckResultResponseBodyDto = this.fraudMonCheckResultResponseBodyDto;
        int iHashCode3 = (iHashCode2 + (fraudMonCheckResultResponseBodyDto == null ? 0 : fraudMonCheckResultResponseBodyDto.hashCode())) * 31;
        FraudMonCheckResultResponseBodyDto fraudMonCheckResultResponseBodyDto2 = this.oldFraudMonCheckResultResponseBodyDto;
        int iHashCode4 = (iHashCode3 + (fraudMonCheckResultResponseBodyDto2 == null ? 0 : fraudMonCheckResultResponseBodyDto2.hashCode())) * 31;
        String str3 = this.info;
        return iHashCode4 + (str3 != null ? str3.hashCode() : 0);
    }

    public String toString() {
        StringBuilder sb = new StringBuilder("SPayErrorDto(errorCode=");
        sb.append(this.errorCode);
        sb.append(", description=");
        sb.append(this.description);
        sb.append(", fraudMonCheckResultResponseBodyDto=");
        sb.append(this.fraudMonCheckResultResponseBodyDto);
        sb.append(", oldFraudMonCheckResultResponseBodyDto=");
        sb.append(this.oldFraudMonCheckResultResponseBodyDto);
        sb.append(", info=");
        return Q1.a(sb, this.info, ')');
    }

    @Override // android.os.Parcelable
    public void writeToParcel(Parcel parcel, int flags) {
        Intrinsics.checkNotNullParameter(parcel, "out");
        parcel.writeString(this.errorCode);
        parcel.writeString(this.description);
        FraudMonCheckResultResponseBodyDto fraudMonCheckResultResponseBodyDto = this.fraudMonCheckResultResponseBodyDto;
        if (fraudMonCheckResultResponseBodyDto == null) {
            parcel.writeInt(0);
        } else {
            parcel.writeInt(1);
            fraudMonCheckResultResponseBodyDto.writeToParcel(parcel, flags);
        }
        FraudMonCheckResultResponseBodyDto fraudMonCheckResultResponseBodyDto2 = this.oldFraudMonCheckResultResponseBodyDto;
        if (fraudMonCheckResultResponseBodyDto2 == null) {
            parcel.writeInt(0);
        } else {
            parcel.writeInt(1);
            fraudMonCheckResultResponseBodyDto2.writeToParcel(parcel, flags);
        }
        parcel.writeString(this.info);
    }

    @Override // spay.sdk.data.dto.response.DataDtoInterface
    public SPayApiError toModel() {
        String str = this.errorCode;
        if (str == null) {
            throw new Kg("errorCode");
        }
        String str2 = this.description;
        FraudMonCheckResultResponseBodyDto fraudMonCheckResultResponseBodyDtoFindOutCurrentVerdict = SPayErrorDtoKt.findOutCurrentVerdict(this);
        return new SPayApiError(str, str2, fraudMonCheckResultResponseBodyDtoFindOutCurrentVerdict != null ? fraudMonCheckResultResponseBodyDtoFindOutCurrentVerdict.toModel() : null, this.info);
    }
}

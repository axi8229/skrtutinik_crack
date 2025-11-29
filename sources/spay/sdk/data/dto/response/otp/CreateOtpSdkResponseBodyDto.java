package spay.sdk.data.dto.response.otp;

import com.google.gson.annotations.SerializedName;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import kotlin.text.StringsKt;
import npi.spay.Q1;
import spay.sdk.data.dto.response.DataDtoInterface;
import spay.sdk.domain.model.response.otp.CreateOtpSdkResponseBody;

@Metadata(d1 = {"\u0000*\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0002\b\f\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\b\n\u0002\b\u0003\b\u0080\b\u0018\u00002\b\u0012\u0004\u0012\u00020\u00020\u0001B#\u0012\b\u0010\u0003\u001a\u0004\u0018\u00010\u0004\u0012\b\u0010\u0005\u001a\u0004\u0018\u00010\u0004\u0012\b\u0010\u0006\u001a\u0004\u0018\u00010\u0004¢\u0006\u0002\u0010\u0007J\u000b\u0010\f\u001a\u0004\u0018\u00010\u0004HÆ\u0003J\u000b\u0010\r\u001a\u0004\u0018\u00010\u0004HÆ\u0003J\u000b\u0010\u000e\u001a\u0004\u0018\u00010\u0004HÆ\u0003J-\u0010\u000f\u001a\u00020\u00002\n\b\u0002\u0010\u0003\u001a\u0004\u0018\u00010\u00042\n\b\u0002\u0010\u0005\u001a\u0004\u0018\u00010\u00042\n\b\u0002\u0010\u0006\u001a\u0004\u0018\u00010\u0004HÆ\u0001J\u0013\u0010\u0010\u001a\u00020\u00112\b\u0010\u0012\u001a\u0004\u0018\u00010\u0013HÖ\u0003J\t\u0010\u0014\u001a\u00020\u0015HÖ\u0001J\b\u0010\u0016\u001a\u00020\u0002H\u0016J\t\u0010\u0017\u001a\u00020\u0004HÖ\u0001R\u0018\u0010\u0003\u001a\u0004\u0018\u00010\u00048\u0006X\u0087\u0004¢\u0006\b\n\u0000\u001a\u0004\b\b\u0010\tR\u0018\u0010\u0005\u001a\u0004\u0018\u00010\u00048\u0006X\u0087\u0004¢\u0006\b\n\u0000\u001a\u0004\b\n\u0010\tR\u0018\u0010\u0006\u001a\u0004\u0018\u00010\u00048\u0006X\u0087\u0004¢\u0006\b\n\u0000\u001a\u0004\b\u000b\u0010\t¨\u0006\u0018"}, d2 = {"Lspay/sdk/data/dto/response/otp/CreateOtpSdkResponseBodyDto;", "Lspay/sdk/data/dto/response/DataDtoInterface;", "Lspay/sdk/domain/model/response/otp/CreateOtpSdkResponseBody;", "errorCode", "", "errorMessage", "mobilePhone", "(Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;)V", "getErrorCode", "()Ljava/lang/String;", "getErrorMessage", "getMobilePhone", "component1", "component2", "component3", "copy", "equals", "", "other", "", "hashCode", "", "toModel", "toString", "SPaySDK_release"}, k = 1, mv = {1, 8, 0}, xi = 48)
/* loaded from: classes5.dex */
public final /* data */ class CreateOtpSdkResponseBodyDto implements DataDtoInterface<CreateOtpSdkResponseBody> {

    @SerializedName("errorCode")
    private final String errorCode;

    @SerializedName("errorMessage")
    private final String errorMessage;

    @SerializedName("mobilePhone")
    private final String mobilePhone;

    public CreateOtpSdkResponseBodyDto(String str, String str2, String str3) {
        this.errorCode = str;
        this.errorMessage = str2;
        this.mobilePhone = str3;
    }

    public static /* synthetic */ CreateOtpSdkResponseBodyDto copy$default(CreateOtpSdkResponseBodyDto createOtpSdkResponseBodyDto, String str, String str2, String str3, int i, Object obj) {
        if ((i & 1) != 0) {
            str = createOtpSdkResponseBodyDto.errorCode;
        }
        if ((i & 2) != 0) {
            str2 = createOtpSdkResponseBodyDto.errorMessage;
        }
        if ((i & 4) != 0) {
            str3 = createOtpSdkResponseBodyDto.mobilePhone;
        }
        return createOtpSdkResponseBodyDto.copy(str, str2, str3);
    }

    /* renamed from: component1, reason: from getter */
    public final String getErrorCode() {
        return this.errorCode;
    }

    /* renamed from: component2, reason: from getter */
    public final String getErrorMessage() {
        return this.errorMessage;
    }

    /* renamed from: component3, reason: from getter */
    public final String getMobilePhone() {
        return this.mobilePhone;
    }

    public final CreateOtpSdkResponseBodyDto copy(String errorCode, String errorMessage, String mobilePhone) {
        return new CreateOtpSdkResponseBodyDto(errorCode, errorMessage, mobilePhone);
    }

    public boolean equals(Object other) {
        if (this == other) {
            return true;
        }
        if (!(other instanceof CreateOtpSdkResponseBodyDto)) {
            return false;
        }
        CreateOtpSdkResponseBodyDto createOtpSdkResponseBodyDto = (CreateOtpSdkResponseBodyDto) other;
        return Intrinsics.areEqual(this.errorCode, createOtpSdkResponseBodyDto.errorCode) && Intrinsics.areEqual(this.errorMessage, createOtpSdkResponseBodyDto.errorMessage) && Intrinsics.areEqual(this.mobilePhone, createOtpSdkResponseBodyDto.mobilePhone);
    }

    public final String getErrorCode() {
        return this.errorCode;
    }

    public final String getErrorMessage() {
        return this.errorMessage;
    }

    public final String getMobilePhone() {
        return this.mobilePhone;
    }

    public int hashCode() {
        String str = this.errorCode;
        int iHashCode = (str == null ? 0 : str.hashCode()) * 31;
        String str2 = this.errorMessage;
        int iHashCode2 = (iHashCode + (str2 == null ? 0 : str2.hashCode())) * 31;
        String str3 = this.mobilePhone;
        return iHashCode2 + (str3 != null ? str3.hashCode() : 0);
    }

    public String toString() {
        StringBuilder sb = new StringBuilder("CreateOtpSdkResponseBodyDto(errorCode=");
        sb.append(this.errorCode);
        sb.append(", errorMessage=");
        sb.append(this.errorMessage);
        sb.append(", mobilePhone=");
        return Q1.a(sb, this.mobilePhone, ')');
    }

    @Override // spay.sdk.data.dto.response.DataDtoInterface
    public CreateOtpSdkResponseBody toModel() {
        Integer intOrNull;
        String str = this.errorCode;
        int iIntValue = (str == null || (intOrNull = StringsKt.toIntOrNull(str)) == null) ? 2 : intOrNull.intValue();
        String str2 = this.errorMessage;
        String str3 = this.mobilePhone;
        if (str3 == null) {
            str3 = "";
        }
        return new CreateOtpSdkResponseBody(iIntValue, str2, str3);
    }
}

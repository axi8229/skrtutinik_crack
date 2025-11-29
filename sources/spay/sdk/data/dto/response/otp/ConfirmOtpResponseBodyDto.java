package spay.sdk.data.dto.response.otp;

import com.google.gson.annotations.SerializedName;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import kotlin.text.StringsKt;
import npi.spay.Q1;
import spay.sdk.data.dto.response.DataDtoInterface;
import spay.sdk.domain.model.response.otp.ConfirmOtpResponseBody;

@Metadata(d1 = {"\u0000*\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0002\b\t\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\b\n\u0002\b\u0003\b\u0080\b\u0018\u00002\b\u0012\u0004\u0012\u00020\u00020\u0001B\u0019\u0012\b\u0010\u0003\u001a\u0004\u0018\u00010\u0004\u0012\b\u0010\u0005\u001a\u0004\u0018\u00010\u0004¢\u0006\u0002\u0010\u0006J\u000b\u0010\n\u001a\u0004\u0018\u00010\u0004HÆ\u0003J\u000b\u0010\u000b\u001a\u0004\u0018\u00010\u0004HÆ\u0003J!\u0010\f\u001a\u00020\u00002\n\b\u0002\u0010\u0003\u001a\u0004\u0018\u00010\u00042\n\b\u0002\u0010\u0005\u001a\u0004\u0018\u00010\u0004HÆ\u0001J\u0013\u0010\r\u001a\u00020\u000e2\b\u0010\u000f\u001a\u0004\u0018\u00010\u0010HÖ\u0003J\t\u0010\u0011\u001a\u00020\u0012HÖ\u0001J\b\u0010\u0013\u001a\u00020\u0002H\u0016J\t\u0010\u0014\u001a\u00020\u0004HÖ\u0001R\u0018\u0010\u0003\u001a\u0004\u0018\u00010\u00048\u0006X\u0087\u0004¢\u0006\b\n\u0000\u001a\u0004\b\u0007\u0010\bR\u0018\u0010\u0005\u001a\u0004\u0018\u00010\u00048\u0006X\u0087\u0004¢\u0006\b\n\u0000\u001a\u0004\b\t\u0010\b¨\u0006\u0015"}, d2 = {"Lspay/sdk/data/dto/response/otp/ConfirmOtpResponseBodyDto;", "Lspay/sdk/data/dto/response/DataDtoInterface;", "Lspay/sdk/domain/model/response/otp/ConfirmOtpResponseBody;", "errorCode", "", "errorMessage", "(Ljava/lang/String;Ljava/lang/String;)V", "getErrorCode", "()Ljava/lang/String;", "getErrorMessage", "component1", "component2", "copy", "equals", "", "other", "", "hashCode", "", "toModel", "toString", "SPaySDK_release"}, k = 1, mv = {1, 8, 0}, xi = 48)
/* loaded from: classes5.dex */
public final /* data */ class ConfirmOtpResponseBodyDto implements DataDtoInterface<ConfirmOtpResponseBody> {

    @SerializedName("errorCode")
    private final String errorCode;

    @SerializedName("errorMessage")
    private final String errorMessage;

    public ConfirmOtpResponseBodyDto(String str, String str2) {
        this.errorCode = str;
        this.errorMessage = str2;
    }

    public static /* synthetic */ ConfirmOtpResponseBodyDto copy$default(ConfirmOtpResponseBodyDto confirmOtpResponseBodyDto, String str, String str2, int i, Object obj) {
        if ((i & 1) != 0) {
            str = confirmOtpResponseBodyDto.errorCode;
        }
        if ((i & 2) != 0) {
            str2 = confirmOtpResponseBodyDto.errorMessage;
        }
        return confirmOtpResponseBodyDto.copy(str, str2);
    }

    /* renamed from: component1, reason: from getter */
    public final String getErrorCode() {
        return this.errorCode;
    }

    /* renamed from: component2, reason: from getter */
    public final String getErrorMessage() {
        return this.errorMessage;
    }

    public final ConfirmOtpResponseBodyDto copy(String errorCode, String errorMessage) {
        return new ConfirmOtpResponseBodyDto(errorCode, errorMessage);
    }

    public boolean equals(Object other) {
        if (this == other) {
            return true;
        }
        if (!(other instanceof ConfirmOtpResponseBodyDto)) {
            return false;
        }
        ConfirmOtpResponseBodyDto confirmOtpResponseBodyDto = (ConfirmOtpResponseBodyDto) other;
        return Intrinsics.areEqual(this.errorCode, confirmOtpResponseBodyDto.errorCode) && Intrinsics.areEqual(this.errorMessage, confirmOtpResponseBodyDto.errorMessage);
    }

    public final String getErrorCode() {
        return this.errorCode;
    }

    public final String getErrorMessage() {
        return this.errorMessage;
    }

    public int hashCode() {
        String str = this.errorCode;
        int iHashCode = (str == null ? 0 : str.hashCode()) * 31;
        String str2 = this.errorMessage;
        return iHashCode + (str2 != null ? str2.hashCode() : 0);
    }

    public String toString() {
        StringBuilder sb = new StringBuilder("ConfirmOtpResponseBodyDto(errorCode=");
        sb.append(this.errorCode);
        sb.append(", errorMessage=");
        return Q1.a(sb, this.errorMessage, ')');
    }

    @Override // spay.sdk.data.dto.response.DataDtoInterface
    public ConfirmOtpResponseBody toModel() {
        Integer intOrNull;
        String str = this.errorCode;
        return new ConfirmOtpResponseBody((str == null || (intOrNull = StringsKt.toIntOrNull(str)) == null) ? 2 : intOrNull.intValue(), this.errorMessage);
    }
}

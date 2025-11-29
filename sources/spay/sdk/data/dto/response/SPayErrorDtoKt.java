package spay.sdk.data.dto.response;

import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import spay.sdk.data.dto.response.paymentToken.FraudMonCheckResultResponseBodyDto;

@Metadata(d1 = {"\u0000\f\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\u001a\u000e\u0010\u0000\u001a\u0004\u0018\u00010\u0001*\u00020\u0002H\u0000¨\u0006\u0003"}, d2 = {"findOutCurrentVerdict", "Lspay/sdk/data/dto/response/paymentToken/FraudMonCheckResultResponseBodyDto;", "Lspay/sdk/data/dto/response/SPayErrorDto;", "SPaySDK_release"}, k = 2, mv = {1, 8, 0}, xi = 48)
/* loaded from: classes5.dex */
public final class SPayErrorDtoKt {
    public static final FraudMonCheckResultResponseBodyDto findOutCurrentVerdict(SPayErrorDto sPayErrorDto) {
        Intrinsics.checkNotNullParameter(sPayErrorDto, "<this>");
        FraudMonCheckResultResponseBodyDto fraudMonCheckResultResponseBodyDto = sPayErrorDto.getFraudMonCheckResultResponseBodyDto();
        return fraudMonCheckResultResponseBodyDto == null ? sPayErrorDto.getOldFraudMonCheckResultResponseBodyDto() : fraudMonCheckResultResponseBodyDto;
    }
}

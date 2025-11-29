package spay.sdk.data.dto.response;

import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import spay.sdk.domain.model.response.AuthResponseBody;

@Metadata(d1 = {"\u0000\f\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\u001a\f\u0010\u0000\u001a\u00020\u0001*\u00020\u0002H\u0000¨\u0006\u0003"}, d2 = {"toDto", "Lspay/sdk/data/dto/response/AuthResponseBodyDto;", "Lspay/sdk/domain/model/response/AuthResponseBody;", "SPaySDK_release"}, k = 2, mv = {1, 8, 0}, xi = 48)
/* loaded from: classes5.dex */
public final class AuthResponseBodyDtoKt {
    public static final AuthResponseBodyDto toDto(AuthResponseBody authResponseBody) {
        Intrinsics.checkNotNullParameter(authResponseBody, "<this>");
        return new AuthResponseBodyDto(authResponseBody.getSessionId(), authResponseBody.getUserInfo(), authResponseBody.getMerchantName(), authResponseBody.getLogoUrl(), authResponseBody.isOtpNeed());
    }
}

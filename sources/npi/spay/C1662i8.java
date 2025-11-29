package npi.spay;

import kotlin.jvm.internal.Intrinsics;
import spay.sdk.data.dto.response.SPayErrorDto;
import spay.sdk.data.dto.response.SPayErrorDtoKt;
import spay.sdk.data.dto.response.paymentToken.FraudMonCheckResultResponseBodyDto;
import spay.sdk.domain.model.response.ErrorEntity;

/* renamed from: npi.spay.i8, reason: case insensitive filesystem */
/* loaded from: classes4.dex */
public final class C1662i8 implements InterfaceC1788na {
    @Override // npi.spay.InterfaceC1788na
    public final /* bridge */ /* synthetic */ ErrorEntity a(Object obj) {
        return a((SPayErrorDto) obj);
    }

    public static ErrorEntity a(SPayErrorDto error) {
        String description;
        Intrinsics.checkNotNullParameter(error, "error");
        String errorCode = error.getErrorCode();
        if ((errorCode == null || errorCode.length() == 0) && ((description = error.getDescription()) == null || description.length() == 0)) {
            return ErrorEntity.Unknown.INSTANCE;
        }
        String errorCode2 = error.getErrorCode();
        if (errorCode2 != null && errorCode2.length() != 0 && SPayErrorDtoKt.findOutCurrentVerdict(error) != null) {
            String errorCode3 = error.getErrorCode();
            String description2 = error.getDescription();
            FraudMonCheckResultResponseBodyDto fraudMonCheckResultResponseBodyDtoFindOutCurrentVerdict = SPayErrorDtoKt.findOutCurrentVerdict(error);
            return new ErrorEntity.BadRequest(errorCode3, description2, fraudMonCheckResultResponseBodyDtoFindOutCurrentVerdict != null ? fraudMonCheckResultResponseBodyDtoFindOutCurrentVerdict.toModel() : null);
        }
        String errorCode4 = error.getErrorCode();
        Intrinsics.checkNotNull(errorCode4);
        String description3 = error.getDescription();
        Intrinsics.checkNotNull(description3);
        return new ErrorEntity.ApiError(errorCode4, description3);
    }
}

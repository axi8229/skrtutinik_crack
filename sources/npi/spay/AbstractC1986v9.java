package npi.spay;

import kotlin.jvm.internal.Intrinsics;
import retrofit2.HttpException;
import retrofit2.Response;
import spay.sdk.data.dto.response.DataDtoInterface;
import spay.sdk.data.dto.response.SPayErrorDto;
import spay.sdk.domain.model.response.ErrorEntity;

/* renamed from: npi.spay.v9, reason: case insensitive filesystem */
/* loaded from: classes4.dex */
public abstract class AbstractC1986v9 {
    public final J9 a;
    public final C1662i8 b;

    public AbstractC1986v9(J9 networkErrorHandlerImpl, C1662i8 apiResponseErrorHandlerImpl) {
        Intrinsics.checkNotNullParameter(networkErrorHandlerImpl, "networkErrorHandlerImpl");
        Intrinsics.checkNotNullParameter(apiResponseErrorHandlerImpl, "apiResponseErrorHandlerImpl");
        this.a = networkErrorHandlerImpl;
        this.b = apiResponseErrorHandlerImpl;
    }

    public static Object a(Response response, C1955u3 c1955u3, InterfaceC1852q successAction, InterfaceC1852q failAction, EnumC1877r0 view) {
        Object model;
        Intrinsics.checkNotNullParameter(response, "<this>");
        Intrinsics.checkNotNullParameter(successAction, "successAction");
        Intrinsics.checkNotNullParameter(failAction, "failAction");
        Intrinsics.checkNotNullParameter(view, "view");
        try {
            DataDtoInterface dataDtoInterface = (DataDtoInterface) response.body();
            if (dataDtoInterface != null && (model = dataDtoInterface.toModel()) != null) {
                if (c1955u3 != null) {
                    c1955u3.a(new C1560e6(successAction, view, C0.RS_GOOD, null, null, null, null, 120));
                }
                return model;
            }
            okhttp3.Response responseRaw = response.raw();
            Intrinsics.checkNotNullExpressionValue(responseRaw, "this.raw()");
            Intrinsics.checkNotNullParameter(responseRaw, "<this>");
            throw new C2067yf(responseRaw.request().url().pathSegments().get(responseRaw.request().url().pathSize() - 1));
        } catch (Kg e) {
            if (c1955u3 != null) {
                c1955u3.a(new C1560e6(failAction, view, C0.RS_FAIL, null, null, null, e.a, 56));
            }
            throw e;
        }
    }

    public final ErrorEntity a(Response raw, SPayErrorDto sPayErrorDto) {
        Intrinsics.checkNotNullParameter(raw, "raw");
        if (raw.body() == null && sPayErrorDto == null) {
            J9 j9 = this.a;
            HttpException httpException = new HttpException(raw);
            j9.getClass();
            return J9.a((Throwable) httpException);
        }
        if (raw.body() == null || sPayErrorDto == null) {
            if (raw.body() == null && sPayErrorDto != null) {
                this.b.getClass();
                return C1662i8.a(sPayErrorDto);
            }
            raw.body();
        }
        return ErrorEntity.Unknown.INSTANCE;
    }
}

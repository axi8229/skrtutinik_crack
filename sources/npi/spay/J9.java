package npi.spay;

import java.net.SocketTimeoutException;
import java.net.UnknownHostException;
import kotlin.jvm.internal.Intrinsics;
import retrofit2.HttpException;
import spay.sdk.domain.model.response.ErrorEntity;

/* loaded from: classes4.dex */
public final class J9 implements InterfaceC1788na {
    @Override // npi.spay.InterfaceC1788na
    public final /* bridge */ /* synthetic */ ErrorEntity a(Object obj) {
        return a((Throwable) obj);
    }

    public static ErrorEntity a(Throwable error) {
        Intrinsics.checkNotNullParameter(error, "error");
        if (error instanceof UnknownHostException) {
            return ErrorEntity.NoInternet.INSTANCE;
        }
        if (error instanceof SocketTimeoutException) {
            return ErrorEntity.TimeOut.INSTANCE;
        }
        if (error instanceof HttpException) {
            int iCode = ((HttpException) error).code();
            if (iCode == 400) {
                return new ErrorEntity.BadRequest(null, null, null, 7, null);
            }
            if (iCode == 401) {
                return ErrorEntity.Unauthorized.INSTANCE;
            }
            if (iCode != 403) {
                if (iCode == 404) {
                    return ErrorEntity.NotFound.INSTANCE;
                }
                if (iCode != 408 && iCode != 423 && iCode != 429 && iCode != 500) {
                    if (iCode == 503) {
                        return ErrorEntity.ServiceUnavailable.INSTANCE;
                    }
                }
            }
            return ErrorEntity.UnknownApiResult.INSTANCE;
        }
        return ErrorEntity.Unknown.INSTANCE;
    }
}

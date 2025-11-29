package ru.yoomoney.sdk.kassa.payments.api.failures;

import com.fasterxml.jackson.databind.ObjectMapper;
import kotlin.jvm.internal.Intrinsics;
import npi.spay.Fa;
import okhttp3.ResponseBody;
import retrofit2.HttpException;
import retrofit2.Response;
import ru.yoomoney.sdk.kassa.payments.model.M;

/* loaded from: classes5.dex */
public final class b implements a {
    public final ObjectMapper a;

    public b(ObjectMapper objectMapper) {
        Intrinsics.checkNotNullParameter(objectMapper, "objectMapper");
        this.a = objectMapper;
    }

    @Override // ru.yoomoney.sdk.kassa.payments.api.failures.a
    public final Exception a(Response response) {
        Intrinsics.checkNotNullParameter(response, "response");
        if (response.code() == 304) {
            return M.a;
        }
        if (response.errorBody() == null) {
            return new HttpException(response);
        }
        try {
            ObjectMapper objectMapper = this.a;
            ResponseBody responseBodyErrorBody = response.errorBody();
            Fa.a(objectMapper.readValue(responseBodyErrorBody != null ? responseBodyErrorBody.string() : null, ru.yoomoney.sdk.kassa.payments.api.a.class));
            Intrinsics.checkNotNull(null);
            Intrinsics.checkNotNullParameter(null, "<this>");
            throw null;
        } catch (Exception e) {
            return e;
        }
    }
}

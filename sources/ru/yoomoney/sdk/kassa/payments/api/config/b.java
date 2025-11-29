package ru.yoomoney.sdk.kassa.payments.api.config;

import com.fasterxml.jackson.databind.JsonNode;
import com.fasterxml.jackson.databind.ObjectMapper;
import kotlin.NoWhenBranchMatchedException;
import kotlin.jvm.internal.Intrinsics;
import okhttp3.ResponseBody;
import retrofit2.HttpException;
import retrofit2.Response;

/* loaded from: classes5.dex */
public final class b implements ru.yoomoney.sdk.kassa.payments.api.failures.a {
    public final ObjectMapper a;
    public final ru.yoomoney.sdk.kassa.payments.api.failures.a b;

    public b(ObjectMapper objectMapper, ru.yoomoney.sdk.kassa.payments.api.failures.a fallbackApiErrorMapper) {
        Intrinsics.checkNotNullParameter(objectMapper, "objectMapper");
        Intrinsics.checkNotNullParameter(fallbackApiErrorMapper, "fallbackApiErrorMapper");
        this.a = objectMapper;
        this.b = fallbackApiErrorMapper;
    }

    @Override // ru.yoomoney.sdk.kassa.payments.api.failures.a
    public final Exception a(Response response) {
        Intrinsics.checkNotNullParameter(response, "response");
        if (response.errorBody() == null) {
            return this.b.a(response);
        }
        try {
            ObjectMapper objectMapper = this.a;
            ResponseBody responseBodyErrorBody = response.errorBody();
            JsonNode tree = objectMapper.readTree(responseBodyErrorBody != null ? responseBodyErrorBody.string() : null);
            if (tree.get("error") == null) {
                return new HttpException(response);
            }
            Object objTreeToValue = this.a.treeToValue(tree.get("error"), (Class<Object>) a.class);
            Intrinsics.checkNotNullExpressionValue(objTreeToValue, "treeToValue(...)");
            if (objTreeToValue != null) {
                throw new ClassCastException();
            }
            Intrinsics.checkNotNullParameter(null, "<this>");
            throw new NoWhenBranchMatchedException();
        } catch (Exception e) {
            return e;
        }
    }
}

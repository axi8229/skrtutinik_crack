package ru.yoomoney.sdk.kassa.payments.api;

import java.lang.reflect.Type;
import kotlin.jvm.internal.Intrinsics;
import retrofit2.Call;
import retrofit2.CallAdapter;

/* loaded from: classes5.dex */
public final class j implements CallAdapter {
    public final CallAdapter a;
    public final ru.yoomoney.sdk.kassa.payments.api.failures.a b;

    public j(CallAdapter delegate, ru.yoomoney.sdk.kassa.payments.api.failures.a apiErrorMapper) {
        Intrinsics.checkNotNullParameter(delegate, "delegate");
        Intrinsics.checkNotNullParameter(apiErrorMapper, "apiErrorMapper");
        this.a = delegate;
        this.b = apiErrorMapper;
    }

    @Override // retrofit2.CallAdapter
    public final Object adapt(Call call) {
        Intrinsics.checkNotNullParameter(call, "call");
        return new i(call, this.b);
    }

    @Override // retrofit2.CallAdapter
    /* renamed from: responseType */
    public final Type getResponseType() {
        Type responseType = this.a.getResponseType();
        Intrinsics.checkNotNullExpressionValue(responseType, "responseType(...)");
        return responseType;
    }
}

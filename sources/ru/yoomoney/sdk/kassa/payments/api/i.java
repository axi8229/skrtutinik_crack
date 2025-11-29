package ru.yoomoney.sdk.kassa.payments.api;

import kotlin.jvm.internal.Intrinsics;
import okhttp3.Request;
import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

/* loaded from: classes5.dex */
public final class i implements Call {
    public final Call a;
    public final ru.yoomoney.sdk.kassa.payments.api.failures.a b;

    public i(Call delegate, ru.yoomoney.sdk.kassa.payments.api.failures.a apiErrorMapper) {
        Intrinsics.checkNotNullParameter(delegate, "delegate");
        Intrinsics.checkNotNullParameter(apiErrorMapper, "apiErrorMapper");
        this.a = delegate;
        this.b = apiErrorMapper;
    }

    @Override // retrofit2.Call
    public final void cancel() {
        this.a.cancel();
    }

    public final Object clone() {
        return new i(this.a, this.b);
    }

    @Override // retrofit2.Call
    public final void enqueue(Callback callback) {
        Intrinsics.checkNotNullParameter(callback, "callback");
        this.a.enqueue(new h(callback, this));
    }

    @Override // retrofit2.Call
    public final Response execute() {
        throw new UnsupportedOperationException("Suspend function should not be blocking.");
    }

    @Override // retrofit2.Call
    public final boolean isCanceled() {
        return this.a.isCanceled();
    }

    @Override // retrofit2.Call
    public final Request request() {
        Request request = this.a.request();
        Intrinsics.checkNotNullExpressionValue(request, "request(...)");
        return request;
    }

    @Override // retrofit2.Call
    /* renamed from: clone */
    public final Call mo3203clone() {
        return new i(this.a, this.b);
    }
}

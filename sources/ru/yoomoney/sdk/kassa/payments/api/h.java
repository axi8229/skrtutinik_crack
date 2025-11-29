package ru.yoomoney.sdk.kassa.payments.api;

import kotlin.Result;
import kotlin.ResultKt;
import kotlin.jvm.internal.Intrinsics;
import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

/* loaded from: classes5.dex */
public final class h implements Callback {
    public final /* synthetic */ Callback a;
    public final /* synthetic */ i b;

    public h(Callback callback, i iVar) {
        this.a = callback;
        this.b = iVar;
    }

    @Override // retrofit2.Callback
    public final void onFailure(Call call, Throwable t) {
        Intrinsics.checkNotNullParameter(call, "call");
        Intrinsics.checkNotNullParameter(t, "t");
        Callback callback = this.a;
        i iVar = this.b;
        Result.Companion companion = Result.INSTANCE;
        callback.onResponse(iVar, Response.success(Result.m2627boximpl(Result.m2628constructorimpl(ResultKt.createFailure(t)))));
    }

    @Override // retrofit2.Callback
    public final void onResponse(Call call, Response response) {
        Intrinsics.checkNotNullParameter(call, "call");
        Intrinsics.checkNotNullParameter(response, "response");
        if (response.isSuccessful()) {
            this.a.onResponse(this.b, Response.success(Result.m2627boximpl(Result.m2628constructorimpl(response.body()))));
            return;
        }
        Exception excA = this.b.b.a(response);
        Callback callback = this.a;
        i iVar = this.b;
        Result.Companion companion = Result.INSTANCE;
        callback.onResponse(iVar, Response.success(Result.m2627boximpl(Result.m2628constructorimpl(ResultKt.createFailure(excA)))));
    }
}

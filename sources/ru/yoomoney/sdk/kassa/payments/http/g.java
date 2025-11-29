package ru.yoomoney.sdk.kassa.payments.http;

import kotlin.jvm.internal.Intrinsics;
import okhttp3.Interceptor;
import okhttp3.Request;
import okhttp3.Response;

/* loaded from: classes5.dex */
public final class g implements Interceptor {
    public final /* synthetic */ ru.yoomoney.sdk.kassa.payments.secure.j a;

    public g(ru.yoomoney.sdk.kassa.payments.secure.j jVar) {
        this.a = jVar;
    }

    @Override // okhttp3.Interceptor
    public final Response intercept(Interceptor.Chain chain) {
        String strA;
        Intrinsics.checkNotNullParameter(chain, "chain");
        Request.Builder builderNewBuilder = chain.request().newBuilder();
        String strE = this.a.e();
        if (strE == null || (strA = c.a(strE)) == null) {
            strA = "";
        }
        return chain.proceed(builderNewBuilder.header("Authorization", strA).build());
    }
}

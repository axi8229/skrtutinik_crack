package ru.yoomoney.sdk.kassa.payments.http;

import kotlin.jvm.internal.Intrinsics;
import okhttp3.Credentials;
import okhttp3.Interceptor;
import okhttp3.Response;

/* loaded from: classes5.dex */
public final class d implements Interceptor {
    public final /* synthetic */ String a;

    public d(String str) {
        this.a = str;
    }

    @Override // okhttp3.Interceptor
    public final Response intercept(Interceptor.Chain chain) {
        Intrinsics.checkNotNullParameter(chain, "chain");
        return chain.proceed(chain.request().newBuilder().header("Authorization", Credentials.basic$default(this.a, "", null, 4, null)).build());
    }
}

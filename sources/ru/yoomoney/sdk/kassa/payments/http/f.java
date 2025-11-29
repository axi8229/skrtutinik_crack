package ru.yoomoney.sdk.kassa.payments.http;

import kotlin.jvm.internal.Intrinsics;
import okhttp3.Interceptor;
import okhttp3.Request;
import okhttp3.Response;

/* loaded from: classes5.dex */
public final class f implements Interceptor {
    public final /* synthetic */ ru.yoomoney.sdk.kassa.payments.secure.j a;

    public f(ru.yoomoney.sdk.kassa.payments.secure.j jVar) {
        this.a = jVar;
    }

    @Override // okhttp3.Interceptor
    public final Response intercept(Interceptor.Chain chain) {
        String strD;
        Intrinsics.checkNotNullParameter(chain, "chain");
        ru.yoomoney.sdk.kassa.payments.secure.j jVar = this.a;
        String strE = null;
        String string = jVar.a.getString("userAuthToken", null);
        String str = string != null ? (String) jVar.c.invoke(string) : null;
        if (str == null || str.length() == 0 || (strD = this.a.d()) == null || strD.length() == 0) {
            strE = this.a.e();
        } else {
            ru.yoomoney.sdk.kassa.payments.secure.j jVar2 = this.a;
            String string2 = jVar2.a.getString("userAuthToken", null);
            if (string2 != null) {
                strE = (String) jVar2.c.invoke(string2);
            }
        }
        Request request = chain.request();
        if (strE != null) {
            request = request.newBuilder().header("Passport-Authorization", strE).build();
        }
        return chain.proceed(request);
    }
}

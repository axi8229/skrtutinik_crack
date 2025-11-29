package npi.spay;

import dagger.internal.Factory;
import dagger.internal.Preconditions;
import javax.inject.Provider;
import kotlin.jvm.internal.Intrinsics;
import okhttp3.OkHttpClient;
import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;

/* renamed from: npi.spay.fj, reason: case insensitive filesystem */
/* loaded from: classes4.dex */
public final class C1598fj implements Factory {
    public final Jc a;
    public final Provider b;

    public C1598fj(Jc jc, Provider provider) {
        this.a = jc;
        this.b = provider;
    }

    @Override // javax.inject.Provider
    public final Object get() {
        Jc jc = this.a;
        OkHttpClient okHttpClient = (OkHttpClient) this.b.get();
        jc.getClass();
        Intrinsics.checkNotNullParameter(okHttpClient, "okHttpClient");
        Retrofit retrofitBuild = new Retrofit.Builder().baseUrl(Vb.a()).client(okHttpClient).addConverterFactory(GsonConverterFactory.create()).build();
        Intrinsics.checkNotNullExpressionValue(retrofitBuild, "Builder()\n            .b…e())\n            .build()");
        return (Retrofit) Preconditions.checkNotNullFromProvides(retrofitBuild);
    }
}

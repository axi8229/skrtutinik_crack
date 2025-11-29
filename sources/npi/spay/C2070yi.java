package npi.spay;

import dagger.internal.Factory;
import dagger.internal.Preconditions;
import javax.inject.Provider;
import kotlin.jvm.internal.Intrinsics;
import okhttp3.OkHttpClient;

/* renamed from: npi.spay.yi, reason: case insensitive filesystem */
/* loaded from: classes4.dex */
public final class C2070yi implements Factory {
    public final Jc a;
    public final Provider b;

    public C2070yi(Jc jc, Provider provider) {
        this.a = jc;
        this.b = provider;
    }

    @Override // javax.inject.Provider
    public final Object get() {
        Jc jc = this.a;
        OkHttpClient.Builder okHttpBuilder = (OkHttpClient.Builder) this.b.get();
        jc.getClass();
        Intrinsics.checkNotNullParameter(okHttpBuilder, "okHttpBuilder");
        return (OkHttpClient) Preconditions.checkNotNullFromProvides(okHttpBuilder.build());
    }
}

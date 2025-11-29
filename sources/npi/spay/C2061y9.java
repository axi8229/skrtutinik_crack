package npi.spay;

import android.content.Context;
import coil.ComponentRegistry;
import coil.ImageLoader;
import coil.decode.SvgDecoder;
import dagger.internal.Factory;
import dagger.internal.Preconditions;
import javax.inject.Provider;
import kotlin.jvm.internal.Intrinsics;
import okhttp3.OkHttpClient;

/* renamed from: npi.spay.y9, reason: case insensitive filesystem */
/* loaded from: classes4.dex */
public final class C2061y9 implements Factory {
    public final A8 a;
    public final Provider b;
    public final Provider c;

    public C2061y9(A8 a8, Factory factory, Provider provider) {
        this.a = a8;
        this.b = factory;
        this.c = provider;
    }

    @Override // javax.inject.Provider
    public final Object get() {
        A8 a8 = this.a;
        Context context = (Context) this.b.get();
        OkHttpClient okHttpClient = (OkHttpClient) this.c.get();
        a8.getClass();
        Intrinsics.checkNotNullParameter(context, "context");
        Intrinsics.checkNotNullParameter(okHttpClient, "okHttpClient");
        ImageLoader.Builder builderOkHttpClient = new ImageLoader.Builder(context).okHttpClient(new C1512c8(okHttpClient));
        ComponentRegistry.Builder builder = new ComponentRegistry.Builder();
        builder.add(new SvgDecoder.Factory(false, 1, null));
        return (ImageLoader) Preconditions.checkNotNullFromProvides(builderOkHttpClient.components(builder.build()).build());
    }
}

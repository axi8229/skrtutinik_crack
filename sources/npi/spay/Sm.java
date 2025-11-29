package npi.spay;

import android.content.Context;
import bz.C0555t1;
import dagger.internal.Factory;
import dagger.internal.Preconditions;
import javax.inject.Provider;
import okhttp3.OkHttpClient;

/* loaded from: classes4.dex */
public final class Sm implements Factory {
    public final Rl a;
    public final Provider b;
    public final Provider c;

    public Sm(Rl rl, Factory factory, Provider provider) {
        this.a = rl;
        this.b = factory;
        this.c = provider;
    }

    @Override // javax.inject.Provider
    public final Object get() {
        Rl rl = this.a;
        Context context = (Context) this.b.get();
        OkHttpClient okHttpClient = (OkHttpClient) this.c.get();
        rl.getClass();
        return (C0555t1) Preconditions.checkNotNullFromProvides(Rl.a(context, okHttpClient));
    }
}

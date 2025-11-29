package npi.spay;

import dagger.internal.Factory;
import dagger.internal.Preconditions;
import okhttp3.logging.HttpLoggingInterceptor;

/* loaded from: classes4.dex */
public final class Jg implements Factory {
    public final Jc a;

    public Jg(Jc jc) {
        this.a = jc;
    }

    @Override // javax.inject.Provider
    public final Object get() {
        this.a.getClass();
        return (HttpLoggingInterceptor) Preconditions.checkNotNullFromProvides(new HttpLoggingInterceptor(new S0()).setLevel(HttpLoggingInterceptor.Level.BODY));
    }
}

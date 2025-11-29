package npi.spay;

import android.content.Context;
import dagger.internal.Factory;
import dagger.internal.Preconditions;
import javax.inject.Provider;
import kotlin.jvm.internal.Intrinsics;

/* loaded from: classes4.dex */
public final class Yd implements Factory {
    public final Vl a;
    public final Factory b;
    public final Provider c;
    public final Ji d;

    public Yd(Vl vl, Factory factory, Provider provider, Ji ji) {
        this.a = vl;
        this.b = factory;
        this.c = provider;
        this.d = ji;
    }

    /* JADX WARN: Multi-variable type inference failed */
    @Override // javax.inject.Provider
    public final Object get() {
        Vl vl = this.a;
        Context context = (Context) this.b.get();
        C1951u lazyNetworkModule = (C1951u) this.c.get();
        C1898rl hashUtility = (C1898rl) this.d.get();
        vl.getClass();
        Intrinsics.checkNotNullParameter(context, "context");
        Intrinsics.checkNotNullParameter(lazyNetworkModule, "lazyNetworkModule");
        Intrinsics.checkNotNullParameter(hashUtility, "hashUtility");
        return (InterfaceC1797nj) Preconditions.checkNotNullFromProvides(C1815oc.b == 5 ? new C1972uk(context, hashUtility) : new Xk(lazyNetworkModule));
    }
}

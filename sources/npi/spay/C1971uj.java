package npi.spay;

import android.content.Context;
import dagger.internal.Factory;
import dagger.internal.Preconditions;
import kotlin.jvm.internal.Intrinsics;

/* renamed from: npi.spay.uj, reason: case insensitive filesystem */
/* loaded from: classes4.dex */
public final class C1971uj implements Factory {
    public final C1620gg a;
    public final Factory b;

    public C1971uj(C1620gg c1620gg, Factory factory) {
        this.a = c1620gg;
        this.b = factory;
    }

    /* JADX WARN: Multi-variable type inference failed */
    @Override // javax.inject.Provider
    public final Object get() {
        C1620gg c1620gg = this.a;
        Context context = (Context) this.b.get();
        c1620gg.getClass();
        Intrinsics.checkNotNullParameter(context, "context");
        return (C1876qn) Preconditions.checkNotNullFromProvides(new C1876qn(context));
    }
}

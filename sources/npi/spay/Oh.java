package npi.spay;

import android.content.Context;
import dagger.internal.Factory;
import dagger.internal.Preconditions;
import kotlin.jvm.internal.Intrinsics;

/* loaded from: classes4.dex */
public final class Oh implements Factory {
    public final C1620gg a;
    public final Factory b;

    public Oh(C1620gg c1620gg, Factory factory) {
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
        return (F9) Preconditions.checkNotNullFromProvides(new F9(context));
    }
}

package npi.spay;

import android.content.Context;
import dagger.internal.Factory;
import dagger.internal.Preconditions;
import javax.inject.Provider;
import kotlin.jvm.internal.Intrinsics;

/* loaded from: classes4.dex */
public final class Ii implements Factory {
    public final Wg a;
    public final Provider b;

    public Ii(Wg wg, Factory factory) {
        this.a = wg;
        this.b = factory;
    }

    @Override // javax.inject.Provider
    public final Object get() {
        Wg wg = this.a;
        Context context = (Context) this.b.get();
        wg.getClass();
        Intrinsics.checkNotNullParameter(context, "context");
        return (InterfaceC1943tg) Preconditions.checkNotNullFromProvides(new Fi(context));
    }
}

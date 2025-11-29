package npi.spay;

import dagger.internal.Factory;
import dagger.internal.Preconditions;

/* renamed from: npi.spay.i, reason: case insensitive filesystem */
/* loaded from: classes4.dex */
public final class C1653i implements Factory {
    public final Vl a;

    public C1653i(Vl vl) {
        this.a = vl;
    }

    @Override // javax.inject.Provider
    public final Object get() {
        this.a.getClass();
        return (C1612g8) Preconditions.checkNotNullFromProvides(new C1612g8());
    }
}

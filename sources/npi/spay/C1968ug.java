package npi.spay;

import dagger.internal.Factory;
import dagger.internal.Preconditions;

/* renamed from: npi.spay.ug, reason: case insensitive filesystem */
/* loaded from: classes4.dex */
public final class C1968ug implements Factory {
    public final Vl a;

    public C1968ug(Vl vl) {
        this.a = vl;
    }

    @Override // javax.inject.Provider
    public final Object get() {
        this.a.getClass();
        return (Ei) Preconditions.checkNotNullFromProvides(new C1822oj());
    }
}

package npi.spay;

import dagger.internal.Factory;
import dagger.internal.Preconditions;
import javax.inject.Provider;
import kotlin.jvm.internal.Intrinsics;
import kotlinx.coroutines.CoroutineScope;

/* loaded from: classes4.dex */
public final class P4 implements Factory {
    public final C1482b3 a;
    public final Provider b;

    public P4(C1482b3 c1482b3, Provider provider) {
        this.a = c1482b3;
        this.b = provider;
    }

    @Override // javax.inject.Provider
    public final Object get() {
        C1482b3 c1482b3 = this.a;
        CoroutineScope scope = (CoroutineScope) this.b.get();
        c1482b3.getClass();
        Intrinsics.checkNotNullParameter(scope, "scope");
        return (Ih) Preconditions.checkNotNullFromProvides(new Di(scope));
    }
}

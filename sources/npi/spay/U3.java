package npi.spay;

import dagger.internal.Factory;
import dagger.internal.Preconditions;
import kotlinx.coroutines.CoroutineScope;
import kotlinx.coroutines.CoroutineScopeKt;
import kotlinx.coroutines.Dispatchers;

/* loaded from: classes4.dex */
public final class U3 implements Factory {
    public final C1482b3 a;

    public U3(C1482b3 c1482b3) {
        this.a = c1482b3;
    }

    @Override // javax.inject.Provider
    public final Object get() {
        this.a.getClass();
        return (CoroutineScope) Preconditions.checkNotNullFromProvides(CoroutineScopeKt.CoroutineScope(Dispatchers.getDefault()));
    }
}

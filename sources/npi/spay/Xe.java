package npi.spay;

import dagger.internal.Factory;
import dagger.internal.Preconditions;
import sberid.sdk.auth.login.SberIDLoginManager;

/* loaded from: classes4.dex */
public final class Xe implements Factory {
    public final C1518ce a;

    public Xe(C1518ce c1518ce) {
        this.a = c1518ce;
    }

    @Override // javax.inject.Provider
    public final Object get() {
        this.a.getClass();
        return (SberIDLoginManager) Preconditions.checkNotNullFromProvides(new SberIDLoginManager(null, 1, null));
    }
}

package ru.yoomoney.sdk.kassa.payments.userAuth.di;

import dagger.internal.Factory;
import dagger.internal.Preconditions;
import javax.inject.Provider;
import kotlin.jvm.internal.Intrinsics;
import ru.yoomoney.sdk.auth.transferData.TransferDataRepository;
import ru.yoomoney.sdk.kassa.payments.userAuth.C2539b;
import ru.yoomoney.sdk.kassa.payments.userAuth.InterfaceC2538a;

/* loaded from: classes5.dex */
public final class g implements Factory {
    public final d a;
    public final Provider b;

    public g(d dVar, dagger.internal.Provider provider) {
        this.a = dVar;
        this.b = provider;
    }

    @Override // javax.inject.Provider
    public final Object get() {
        d dVar = this.a;
        TransferDataRepository transferDataRepository = (TransferDataRepository) this.b.get();
        dVar.getClass();
        Intrinsics.checkNotNullParameter(transferDataRepository, "transferDataRepository");
        return (InterfaceC2538a) Preconditions.checkNotNullFromProvides(new C2539b(transferDataRepository));
    }
}

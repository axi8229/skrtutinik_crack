package npi.spay;

import dagger.internal.Factory;
import dagger.internal.Preconditions;
import javax.inject.Provider;
import kotlin.jvm.internal.Intrinsics;

/* loaded from: classes4.dex */
public final class Oa implements Factory {
    public final C1936t9 a;
    public final Provider b;

    public Oa(C1936t9 c1936t9, Provider provider) {
        this.a = c1936t9;
        this.b = provider;
    }

    @Override // javax.inject.Provider
    public final Object get() {
        C1936t9 c1936t9 = this.a;
        InterfaceC1728l0 sPaySdkConfigRepository = (InterfaceC1728l0) this.b.get();
        c1936t9.getClass();
        Intrinsics.checkNotNullParameter(sPaySdkConfigRepository, "sPaySdkConfigRepository");
        return (InterfaceC1997vk) Preconditions.checkNotNullFromProvides(new C1871qi(sPaySdkConfigRepository));
    }
}

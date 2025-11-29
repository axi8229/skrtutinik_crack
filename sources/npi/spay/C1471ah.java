package npi.spay;

import dagger.internal.Factory;
import dagger.internal.Preconditions;
import javax.inject.Provider;
import kotlin.jvm.internal.Intrinsics;

/* renamed from: npi.spay.ah, reason: case insensitive filesystem */
/* loaded from: classes4.dex */
public final class C1471ah implements Factory {
    public final Le a;
    public final Provider b;
    public final Provider c;

    public C1471ah(Le le, Provider provider, Provider provider2) {
        this.a = le;
        this.b = provider;
        this.c = provider2;
    }

    @Override // javax.inject.Provider
    public final Object get() {
        Le le = this.a;
        InterfaceC1846pi configService = (InterfaceC1846pi) this.b.get();
        InterfaceC1943tg defaultSharedPreferences = (InterfaceC1943tg) this.c.get();
        le.getClass();
        Intrinsics.checkNotNullParameter(configService, "configService");
        Intrinsics.checkNotNullParameter(defaultSharedPreferences, "defaultSharedPreferences");
        return (InterfaceC1728l0) Preconditions.checkNotNullFromProvides(new O0(configService, defaultSharedPreferences));
    }
}

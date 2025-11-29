package bz;

import dagger.internal.DoubleCheck;
import dagger.internal.Factory;
import dagger.internal.InstanceFactory;
import dagger.internal.MapFactory;
import javax.inject.Provider;

/* renamed from: bz.k0, reason: case insensitive filesystem */
/* loaded from: classes.dex */
public final class C0527k0 implements InterfaceC0523j {
    public Factory a;
    public Provider b;
    public Provider c;
    public Provider d;
    public Provider e;

    public C0527k0(C0505d c0505d) {
        a(c0505d);
    }

    public final void a(C0505d c0505d) {
        Factory factoryCreate = InstanceFactory.create(c0505d);
        this.a = factoryCreate;
        this.b = DoubleCheck.provider(factoryCreate);
        Provider provider = DoubleCheck.provider(this.a);
        this.c = provider;
        this.d = DoubleCheck.provider(new C0546q0(this.b, provider));
        this.e = DoubleCheck.provider(new C0558u1(MapFactory.builder(1).put((MapFactory.Builder) Object.class, this.d).build()));
    }
}

package npi.spay;

import android.content.Context;
import coil.ImageLoader;
import dagger.internal.DoubleCheck;
import dagger.internal.Factory;
import dagger.internal.InstanceFactory;
import dagger.internal.Preconditions;
import javax.inject.Provider;
import kotlin.jvm.internal.Intrinsics;

/* loaded from: classes4.dex */
public final class Ik implements Im {
    public final Context a;
    public final C1832p4 b;
    public final Ik c = this;
    public Factory d;
    public C1703k0 e;
    public S4 f;
    public Provider g;
    public Provider h;
    public Provider i;
    public C1534d5 j;
    public Provider k;
    public C2042xf l;
    public Jg m;
    public Provider n;
    public Provider o;
    public O5 p;
    public C1899rm q;
    public Provider r;
    public Provider s;
    public Provider t;
    public C1478b u;
    public Provider v;

    public Ik(C1910s8 c1910s8, C1985v8 c1985v8, C1482b3 c1482b3, C1557e3 c1557e3, Wg wg, C2048xl c2048xl, Rl rl, L5 l5, Jc jc, A8 a8, Le le, C1832p4 c1832p4, Context context) {
        this.a = context;
        this.b = c1832p4;
        a(c1910s8, c1985v8, c1482b3, c1557e3, wg, c2048xl, rl, l5, jc, a8, le, c1832p4, context);
    }

    public final C1884r7 a() {
        return new C1884r7(this.a, (ImageLoader) this.t.get());
    }

    public final C1955u3 b() {
        C1832p4 c1832p4 = this.b;
        Context context = this.a;
        C1993vg featuresHandler = (C1993vg) this.i.get();
        Ih sPayDataContract = (Ih) this.g.get();
        F9 appNameUtil = new F9(this.a);
        c1832p4.getClass();
        Intrinsics.checkNotNullParameter(context, "context");
        Intrinsics.checkNotNullParameter(featuresHandler, "featuresHandler");
        Intrinsics.checkNotNullParameter(sPayDataContract, "sPayDataContract");
        Intrinsics.checkNotNullParameter(appNameUtil, "appNameUtil");
        return (C1955u3) Preconditions.checkNotNullFromProvides(new C1955u3(context, featuresHandler, sPayDataContract, appNameUtil));
    }

    public final void a(C1910s8 c1910s8, C1985v8 c1985v8, C1482b3 c1482b3, C1557e3 c1557e3, Wg wg, C2048xl c2048xl, Rl rl, L5 l5, Jc jc, A8 a8, Le le, C1832p4 c1832p4, Context context) {
        Factory factoryCreate = InstanceFactory.create(context);
        this.d = factoryCreate;
        this.e = new C1703k0(factoryCreate);
        this.f = new S4(c1557e3);
        this.g = DoubleCheck.provider(new P4(c1482b3, DoubleCheck.provider(new U3(c1482b3))));
        this.h = DoubleCheck.provider(new Ii(wg, this.d));
        Provider provider = DoubleCheck.provider(new R9(c1910s8));
        this.i = provider;
        Factory factory = this.d;
        C1534d5 c1534d5 = new C1534d5(c1832p4, factory, provider, this.g, new C1962ua(factory));
        this.j = c1534d5;
        Provider provider2 = DoubleCheck.provider(new C1909s7(l5, this.h, c1534d5));
        this.k = provider2;
        this.l = new C2042xf(jc, this.f, this.g, DoubleCheck.provider(new B6(l5, provider2)));
        this.m = new Jg(jc);
        Provider provider3 = DoubleCheck.provider(new Ah(jc, this.l, this.m, DoubleCheck.provider(new U9(c1985v8))));
        this.n = provider3;
        Provider provider4 = DoubleCheck.provider(new C2070yi(jc, provider3));
        this.o = provider4;
        C1474ak c1474ak = new C1474ak(jc, new C1598fj(jc, provider4));
        O5 o5 = new O5(c1557e3);
        this.p = o5;
        C1899rm c1899rm = new C1899rm(c2048xl, c1474ak, o5, new X3(c1557e3), this.g, this.j);
        this.q = c1899rm;
        this.r = DoubleCheck.provider(new C1893rg(le, this.e, c1899rm));
        this.s = DoubleCheck.provider(new C1471ah(le, this.r, DoubleCheck.provider(new Nh(wg, this.d))));
        this.t = DoubleCheck.provider(new C2061y9(a8, this.d, this.o));
        Factory factory2 = this.d;
        this.u = new C1478b(rl, new Sm(rl, factory2, this.o), new C1927t0(rl));
        this.v = DoubleCheck.provider(new C1862q9(c1910s8, factory2, this.i));
    }
}

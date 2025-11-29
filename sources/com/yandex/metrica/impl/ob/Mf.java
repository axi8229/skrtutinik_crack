package com.yandex.metrica.impl.ob;

import com.yandex.metrica.core.api.executors.ICommonExecutor;
import java.util.Map;
import kotlin.jvm.internal.Intrinsics;

/* loaded from: classes3.dex */
public final class Mf {
    private final ICommonExecutor a;
    private final Sf b;
    private final Kf c;
    private final Kn<String> d;
    private final Kn<String> e;

    public static final class a extends AbstractRunnableC0908em {
        final /* synthetic */ int b;
        final /* synthetic */ String c;
        final /* synthetic */ String d;
        final /* synthetic */ Map e;
        final /* synthetic */ Map f;

        a(int i, String str, String str2, Map map, Map map2) {
            this.b = i;
            this.c = str;
            this.d = str2;
            this.e = map;
            this.f = map2;
        }

        @Override // com.yandex.metrica.impl.ob.AbstractRunnableC0908em
        public void a() {
            Mf.a(Mf.this).a(this.b, this.c, this.d, this.e, this.f);
        }
    }

    public static final class b extends AbstractRunnableC0908em {
        final /* synthetic */ String b;
        final /* synthetic */ byte[] c;

        b(String str, byte[] bArr) {
            this.b = str;
            this.c = bArr;
        }

        @Override // com.yandex.metrica.impl.ob.AbstractRunnableC0908em
        public void a() {
            Mf.a(Mf.this).a(this.b, this.c);
        }
    }

    public Mf(ICommonExecutor iCommonExecutor, Sf sf, Kf kf, Kn<String> kn, Kn<String> kn2) {
        this.a = iCommonExecutor;
        this.b = sf;
        this.c = kf;
        this.d = kn;
        this.e = kn2;
    }

    public final void a(int i, String str, String str2, Map<String, String> map, Map<String, byte[]> map2) {
        this.c.a(null);
        this.d.a(str);
        this.a.execute(new a(i, str, str2, map, map2));
    }

    public Mf(ICommonExecutor iCommonExecutor) {
        this(iCommonExecutor, new Sf());
    }

    private Mf(ICommonExecutor iCommonExecutor, Sf sf) {
        this(iCommonExecutor, sf, new Kf(sf), new Hn(new Gn("Event name")), new Hn(new Gn("Session extra key")));
    }

    public final void a(String str, byte[] bArr) {
        this.e.a(str);
        this.a.execute(new b(str, bArr));
    }

    public final boolean a() {
        this.b.getClass();
        return R2.h();
    }

    public static final K0 a(Mf mf) {
        mf.b.getClass();
        R2 r2K = R2.k();
        Intrinsics.checkNotNull(r2K);
        Intrinsics.checkNotNullExpressionValue(r2K, "provider.peekInitializedImpl()!!");
        C1036k1 c1036k1D = r2K.d();
        Intrinsics.checkNotNull(c1036k1D);
        Intrinsics.checkNotNullExpressionValue(c1036k1D, "provider.peekInitialized…rterApiConsumerProvider!!");
        K0 k0B = c1036k1D.b();
        Intrinsics.checkNotNullExpressionValue(k0B, "provider.peekInitialized…erProvider!!.mainReporter");
        return k0B;
    }
}

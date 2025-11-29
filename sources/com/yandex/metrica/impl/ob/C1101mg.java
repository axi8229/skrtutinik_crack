package com.yandex.metrica.impl.ob;

import java.util.ArrayList;
import java.util.List;
import kotlin.Lazy;
import kotlin.LazyKt;
import kotlin.collections.CollectionsKt;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.internal.Lambda;

/* renamed from: com.yandex.metrica.impl.ob.mg, reason: case insensitive filesystem */
/* loaded from: classes3.dex */
public final class C1101mg {
    private final Lazy a = LazyKt.lazy(new c());
    private final Lazy b = LazyKt.lazy(new b());
    private final Lazy c = LazyKt.lazy(new d());
    private final List<C0877dg> d = new ArrayList();
    private final C1247sg e;
    private final C1343wg f;
    private final C0952gg g;
    private final C1367xg h;

    /* JADX INFO: Access modifiers changed from: private */
    /* renamed from: com.yandex.metrica.impl.ob.mg$a */
    interface a {
        void a();
    }

    /* renamed from: com.yandex.metrica.impl.ob.mg$b */
    static final class b extends Lambda implements Function0<C1126ng> {
        b() {
            super(0);
        }

        @Override // kotlin.jvm.functions.Function0
        public C1126ng invoke() {
            return new C1126ng(this);
        }
    }

    /* renamed from: com.yandex.metrica.impl.ob.mg$c */
    static final class c extends Lambda implements Function0<C1151og> {
        c() {
            super(0);
        }

        @Override // kotlin.jvm.functions.Function0
        public C1151og invoke() {
            return new C1151og(this);
        }
    }

    /* renamed from: com.yandex.metrica.impl.ob.mg$d */
    static final class d extends Lambda implements Function0<C1176pg> {
        d() {
            super(0);
        }

        @Override // kotlin.jvm.functions.Function0
        public C1176pg invoke() {
            return new C1176pg(this);
        }
    }

    public C1101mg(C1247sg c1247sg, C1343wg c1343wg, C0952gg c0952gg, C1367xg c1367xg) {
        this.e = c1247sg;
        this.f = c1343wg;
        this.g = c0952gg;
        this.h = c1367xg;
    }

    public static final a b(C1101mg c1101mg) {
        return (a) c1101mg.b.getValue();
    }

    public static final a c(C1101mg c1101mg) {
        return (a) c1101mg.a.getValue();
    }

    public static final void a(C1101mg c1101mg, C0877dg c0877dg, a aVar) {
        c1101mg.d.add(c0877dg);
        if (c1101mg.h.a(c0877dg)) {
            c1101mg.e.a(c0877dg);
        } else {
            aVar.a();
        }
    }

    public final void b() {
        this.f.a((InterfaceC1319vg) this.c.getValue());
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final void a() {
        List<C0877dg> list = this.d;
        ArrayList arrayList = new ArrayList();
        for (Object obj : list) {
            if (this.h.b((C0877dg) obj)) {
                arrayList.add(obj);
            }
        }
        this.e.a(this.h.a(CollectionsKt.filterNotNull(arrayList)));
    }
}

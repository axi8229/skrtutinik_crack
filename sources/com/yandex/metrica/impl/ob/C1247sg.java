package com.yandex.metrica.impl.ob;

import android.content.Context;
import java.util.HashSet;
import java.util.Iterator;
import java.util.Set;
import kotlin.jvm.internal.Intrinsics;

/* renamed from: com.yandex.metrica.impl.ob.sg, reason: case insensitive filesystem */
/* loaded from: classes3.dex */
public class C1247sg {
    private final Set<C1271tg> a;
    private C0877dg b;
    private boolean c;
    private final C0794a8 d;
    private final Context e;

    /* renamed from: com.yandex.metrica.impl.ob.sg$a */
    public interface a {
        void a(C0877dg c0877dg);
    }

    public C1247sg(Context context) {
        this(context, F0.g().w().a());
    }

    public synchronized void a(C0877dg c0877dg) {
        this.b = c0877dg;
        this.c = true;
        this.d.a(c0877dg);
        this.d.a(true);
        C0877dg c0877dg2 = this.b;
        synchronized (this) {
            Iterator<C1271tg> it = this.a.iterator();
            while (it.hasNext()) {
                it.next().a(c0877dg2);
            }
        }
    }

    public void b() {
        if (this.c) {
            return;
        }
        Context context = this.e;
        F0 f0G = F0.g();
        Intrinsics.checkNotNullExpressionValue(f0G, "GlobalServiceLocator.getInstance()");
        Pm pmQ = f0G.q();
        Intrinsics.checkNotNullExpressionValue(pmQ, "GlobalServiceLocator.get…).serviceExecutorProvider");
        new C1101mg(this, new C1343wg(context, pmQ.a()), new C0952gg(context), new C1367xg(context, null, 0 == true ? 1 : 0, 6)).b();
    }

    C1247sg(Context context, C0794a8 c0794a8) {
        this.a = new HashSet();
        this.e = context;
        this.d = c0794a8;
        this.b = c0794a8.g();
        this.c = c0794a8.h();
    }

    public C0877dg a() {
        return this.b;
    }

    public synchronized void a(C1271tg c1271tg) {
        this.a.add(c1271tg);
        if (this.c) {
            c1271tg.a(this.b);
        }
    }
}

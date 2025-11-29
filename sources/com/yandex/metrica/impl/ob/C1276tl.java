package com.yandex.metrica.impl.ob;

import android.R;
import android.app.Activity;
import android.view.ViewGroup;
import java.util.Arrays;
import java.util.Collections;
import java.util.Iterator;

/* renamed from: com.yandex.metrica.impl.ob.tl, reason: case insensitive filesystem */
/* loaded from: classes3.dex */
public class C1276tl {
    private final b a;
    private final a b;

    /* renamed from: com.yandex.metrica.impl.ob.tl$a */
    static class a {
        a() {
        }
    }

    /* renamed from: com.yandex.metrica.impl.ob.tl$b */
    static class b {
        b() {
        }
    }

    public C1276tl() {
        this(new b(), new a());
    }

    public C0882dl a(Activity activity, Hk hk, C1348wl c1348wl, Ak ak, C1396yl c1396yl, C1252sl c1252sl) {
        ViewGroup viewGroup;
        C0882dl c0882dl = new C0882dl();
        try {
            viewGroup = (ViewGroup) activity.findViewById(R.id.content);
        } catch (Throwable th) {
            c1396yl.a("ui_parsing_root", th);
            viewGroup = null;
        }
        if (viewGroup != null) {
            this.a.getClass();
            Rk rk = new Rk(c1348wl, new Fl(c1396yl), new C1251sk(c1348wl.c), ak, Collections.singletonList(new Mk()), Arrays.asList(new C0807al(c1348wl.b)), c1396yl, c1252sl, new Hl());
            c0882dl.a(rk, viewGroup, hk);
            if (c1348wl.e) {
                this.b.getClass();
                C1227rk c1227rk = new C1227rk(rk.a());
                Iterator<C0832bl> it = rk.b().iterator();
                while (it.hasNext()) {
                    c1227rk.a(it.next());
                }
            }
        }
        return c0882dl;
    }

    C1276tl(b bVar, a aVar) {
        this.a = bVar;
        this.b = aVar;
    }
}

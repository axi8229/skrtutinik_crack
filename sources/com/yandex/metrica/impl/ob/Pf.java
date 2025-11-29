package com.yandex.metrica.impl.ob;

import android.content.Context;
import com.yandex.metrica.core.api.executors.ICommonExecutor;
import java.util.HashMap;
import java.util.Map;

/* loaded from: classes3.dex */
public class Pf {
    private final Map<String, Of> a = new HashMap();
    private final Sf b;
    private final ICommonExecutor c;

    class a implements Runnable {
        final /* synthetic */ Context a;

        a(Context context) {
            this.a = context;
        }

        @Override // java.lang.Runnable
        public void run() {
            Sf sf = Pf.this.b;
            Context context = this.a;
            sf.getClass();
            R2.a(context);
        }
    }

    private static class b {
        private static final Pf a = new Pf(P.g().c(), new Sf());
    }

    Pf(ICommonExecutor iCommonExecutor, Sf sf) {
        this.c = iCommonExecutor;
        this.b = sf;
    }

    private Of b(Context context, String str) {
        this.b.getClass();
        if (R2.k() == null) {
            this.c.execute(new a(context));
        }
        Of of = new Of(this.c, context, str);
        this.a.put(str, of);
        return of;
    }

    public static Pf a() {
        return b.a;
    }

    public Of a(Context context, String str) {
        Of of = this.a.get(str);
        if (of == null) {
            synchronized (this.a) {
                try {
                    of = this.a.get(str);
                    if (of == null) {
                        Of ofB = b(context, str);
                        ofB.d(str);
                        of = ofB;
                    }
                } finally {
                }
            }
        }
        return of;
    }

    public Of a(Context context, com.yandex.metrica.e eVar) {
        Of of = this.a.get(eVar.apiKey);
        if (of == null) {
            synchronized (this.a) {
                try {
                    of = this.a.get(eVar.apiKey);
                    if (of == null) {
                        Of ofB = b(context, eVar.apiKey);
                        ofB.a(eVar);
                        of = ofB;
                    }
                } finally {
                }
            }
        }
        return of;
    }
}

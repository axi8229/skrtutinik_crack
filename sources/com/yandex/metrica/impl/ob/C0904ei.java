package com.yandex.metrica.impl.ob;

import android.content.Context;
import com.yandex.metrica.impl.ob.Mg;
import java.util.HashMap;

/* renamed from: com.yandex.metrica.impl.ob.ei, reason: case insensitive filesystem */
/* loaded from: classes3.dex */
public class C0904ei {
    private final C1229rm<String, InterfaceC1053ki> a = new C1229rm<>();
    private final HashMap<String, C1225ri> b = new HashMap<>();
    private C1178pi c = null;
    private final InterfaceC1153oi d = new a();

    /* renamed from: com.yandex.metrica.impl.ob.ei$a */
    class a implements InterfaceC1153oi {
        a() {
        }
    }

    /* renamed from: com.yandex.metrica.impl.ob.ei$b */
    private static final class b {
        static final C0904ei a = new C0904ei();
    }

    public static final C0904ei a() {
        return b.a;
    }

    public C1225ri a(Context context, I3 i3, Mg.b bVar) {
        C1225ri c1225ri = this.b.get(i3.b());
        boolean z = true;
        if (c1225ri == null) {
            synchronized (this.b) {
                try {
                    c1225ri = this.b.get(i3.b());
                    if (c1225ri == null) {
                        c1225ri = new C1225ri(context, i3.b(), bVar, this.d);
                        this.b.put(i3.b(), c1225ri);
                        z = false;
                    }
                } finally {
                }
            }
        }
        if (z) {
            c1225ri.a(bVar);
        }
        return c1225ri;
    }

    public void a(I3 i3, InterfaceC1053ki interfaceC1053ki) {
        synchronized (this.b) {
            try {
                this.a.a(i3.b(), interfaceC1053ki);
                C1178pi c1178pi = this.c;
                if (c1178pi != null) {
                    interfaceC1053ki.a(c1178pi);
                }
            } catch (Throwable th) {
                throw th;
            }
        }
    }
}

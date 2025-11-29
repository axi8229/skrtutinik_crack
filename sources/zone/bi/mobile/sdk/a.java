package zone.bi.mobile.sdk;

import android.content.Context;
import bz.B;
import bz.C0527k0;
import bz.InterfaceC0523j;
import bz.L;
import bz.L1;
import java.util.Collections;
import npi.spay.X0;

/* loaded from: classes5.dex */
public final class a {
    public final Context a;
    public final c b;
    public final b c;
    public X0 d;

    public a(Context context, c cVar, b bVar) {
        this.a = context;
        this.b = cVar;
        this.c = bVar;
    }

    public final e a() {
        e eVar = new e(this.a, this.b, this.c);
        eVar.b = this.d;
        B b = (B) ((C0527k0) ((InterfaceC0523j) eVar.a.b.a(InterfaceC0523j.class))).e.get();
        b.a.putAll(Collections.singletonMap(L.class, (L1) eVar.e.get()));
        eVar.b = null;
        return eVar;
    }

    public final a a(X0 x0) {
        this.d = x0;
        return this;
    }
}

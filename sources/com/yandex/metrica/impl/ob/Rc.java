package com.yandex.metrica.impl.ob;

import android.location.Location;
import android.text.TextUtils;
import com.yandex.metrica.coreutils.services.SystemTimeProvider;
import com.yandex.metrica.impl.ob.C1147oc;

/* loaded from: classes3.dex */
class Rc extends V {
    private U7 b;
    private Vb c;
    private SystemTimeProvider d;
    private final E e;
    private final C1326w f;

    Rc(V v, U7 u7, Vb vb, SystemTimeProvider systemTimeProvider, E e, C1326w c1326w) {
        super(v);
        this.b = u7;
        this.c = vb;
        this.d = systemTimeProvider;
        this.e = e;
        this.f = c1326w;
    }

    @Override // com.yandex.metrica.impl.ob.V
    public void b(Object obj) {
        Location location = (Location) obj;
        if (location != null) {
            Hc hc = new Hc(C1147oc.a.a(this.f.c()), this.d.currentTimeMillis(), this.d.elapsedRealtime(), location, this.e.b(), null);
            String strA = this.c.a(hc);
            if (TextUtils.isEmpty(strA)) {
                return;
            }
            this.b.a(hc.e(), strA);
        }
    }
}

package com.yandex.metrica.impl.ob;

import android.content.Context;
import android.os.Bundle;
import com.yandex.metrica.identifiers.AdsIdentifiersProvider;
import com.yandex.metrica.impl.ob.C1266tb;
import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;

/* loaded from: classes3.dex */
public class Kb implements InterfaceC1314vb {
    private final String a;
    private final Jb b;

    public Kb(String str) {
        this(str, new Jb());
    }

    private C1290ub b(Context context) throws Throwable {
        int i = AdsIdentifiersProvider.$r8$clinit;
        Method method = AdsIdentifiersProvider.class.getMethod("requestIdentifiers", Context.class, Bundle.class);
        Bundle bundle = new Bundle();
        bundle.putString("com.yandex.metrica.identifiers.extra.PROVIDER", this.a);
        Jb jb = this.b;
        Object[] objArr = {context, bundle};
        C1266tb c1266tb = null;
        Bundle bundle2 = (Bundle) method.invoke(null, objArr);
        jb.getClass();
        if (bundle2 == null) {
            return null;
        }
        Bundle bundle3 = bundle2.getBundle("com.yandex.metrica.identifiers.extra.TRACKING_INFO");
        if (bundle3 != null) {
            C1266tb.a aVar = Ib.a.get(bundle3.getString("com.yandex.metrica.identifiers.extra.PROVIDER"));
            if (aVar == null) {
                throw new IllegalArgumentException(("Provider " + bundle3.getString("com.yandex.metrica.identifiers.extra.PROVIDER") + " is invalid").toString());
            }
            c1266tb = new C1266tb(aVar, bundle3.getString("com.yandex.metrica.identifiers.extra.ID"), bundle3.containsKey("com.yandex.metrica.identifiers.extra.LIMITED") ? Boolean.valueOf(bundle3.getBoolean("com.yandex.metrica.identifiers.extra.LIMITED")) : null);
        }
        return new C1290ub(c1266tb, U0.a(bundle2.getString("com.yandex.metrica.identifiers.extra.STATUS")), bundle2.getString("com.yandex.metrica.identifiers.extra.ERROR_MESSAGE"));
    }

    @Override // com.yandex.metrica.impl.ob.InterfaceC1314vb
    public C1290ub a(Context context) {
        return a(context, new Fb());
    }

    Kb(String str, Jb jb) {
        this.a = str;
        this.b = jb;
    }

    @Override // com.yandex.metrica.impl.ob.InterfaceC1314vb
    public C1290ub a(Context context, Gb gb) throws InterruptedException {
        C1290ub c1290ub;
        gb.c();
        C1290ub c1290ub2 = null;
        while (gb.b()) {
            try {
                return b(context);
            } catch (InvocationTargetException e) {
                String message = e.getTargetException() != null ? e.getTargetException().getMessage() : null;
                c1290ub = new C1290ub(null, U0.UNKNOWN, "exception while fetching " + this.a + " adv_id: " + message);
                c1290ub2 = c1290ub;
                try {
                    Thread.sleep(gb.a());
                } catch (InterruptedException unused) {
                }
            } catch (Throwable th) {
                c1290ub = new C1290ub(null, U0.UNKNOWN, "exception while fetching " + this.a + " adv_id: " + th.getMessage());
                c1290ub2 = c1290ub;
                Thread.sleep(gb.a());
            }
        }
        return c1290ub2 == null ? new C1290ub() : c1290ub2;
    }
}

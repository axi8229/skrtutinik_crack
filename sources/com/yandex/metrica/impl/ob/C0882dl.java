package com.yandex.metrica.impl.ob;

import android.view.View;
import java.util.ArrayList;
import java.util.Iterator;
import org.json.JSONObject;

/* renamed from: com.yandex.metrica.impl.ob.dl, reason: case insensitive filesystem */
/* loaded from: classes3.dex */
class C0882dl {
    private Pk a;

    C0882dl() {
    }

    void a(Rk rk, View view, Hk hk) {
        Pk pkB = rk.b(null, view, 0);
        this.a = pkB;
        if (pkB != null) {
            a(rk, pkB, view, 1, hk);
        }
    }

    JSONObject a(C0982hl c0982hl, Ak ak, int i) {
        Pk pk = this.a;
        JSONObject jSONObject = pk != null ? pk.a(c0982hl, ak, i, 0).c : null;
        return jSONObject == null ? new JSONObject() : jSONObject;
    }

    private void a(Rk rk, Pk pk, View view, int i, Hk hk) {
        ArrayList arrayList = (ArrayList) rk.a(view, i);
        if (arrayList.size() == 0) {
            hk.a(pk.a());
            return;
        }
        Iterator it = arrayList.iterator();
        while (it.hasNext()) {
            View view2 = (View) it.next();
            Pk pkB = rk.b(pk.a(), view2, i);
            if (pkB != null) {
                pk.a(pkB);
                a(rk, pkB, view2, i + 1, hk);
            }
        }
    }
}

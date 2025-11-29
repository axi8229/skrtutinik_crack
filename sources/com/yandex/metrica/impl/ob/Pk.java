package com.yandex.metrica.impl.ob;

import com.yandex.metrica.impl.ob.C1228rl;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import org.json.JSONArray;
import org.json.JSONObject;

/* loaded from: classes3.dex */
public class Pk {
    private final List<Pk> a = new ArrayList();
    private final C1228rl b;

    static class a {
        final int a;
        final int b;
        final JSONObject c;

        a(int i, int i2, JSONObject jSONObject) {
            this.a = i;
            this.b = i2;
            this.c = jSONObject;
        }
    }

    public Pk(C1228rl c1228rl) {
        this.b = c1228rl;
    }

    public void a(Pk pk) {
        this.a.add(pk);
    }

    public C1228rl a() {
        return this.b;
    }

    public a a(C0982hl c0982hl, Ak ak, int i, int i2) {
        int length;
        JSONArray jSONArray;
        JSONObject jSONObject = new JSONObject();
        int i3 = i2 + 1;
        try {
            C1228rl.b bVarA = this.b.a(ak);
            boolean z = true;
            boolean z2 = c0982hl.f || this.b.a();
            if (bVarA != null && c0982hl.i) {
                z = false;
            }
            if (z2 && z) {
                jSONObject = this.b.a(c0982hl, bVarA);
            }
            length = jSONObject.toString().getBytes().length + i;
            try {
                jSONArray = new JSONArray();
                jSONObject.put("ch", jSONArray);
                length += 8;
            } catch (Throwable unused) {
            }
        } catch (Throwable unused2) {
            length = i;
        }
        if (length <= c0982hl.n && i3 <= c0982hl.m) {
            Iterator<Pk> it = this.a.iterator();
            while (it.hasNext()) {
                a aVarA = it.next().a(c0982hl, ak, length + 1, i3);
                JSONObject jSONObject2 = aVarA.c;
                if (jSONObject2 != null) {
                    jSONArray.put(jSONObject2);
                }
                int i4 = aVarA.a;
                if (i4 == 0) {
                    break;
                }
                i3 += aVarA.b;
                length += i4;
            }
            return new a(length - i, i3 - i2, jSONObject);
        }
        return new a(0, 0, null);
    }
}

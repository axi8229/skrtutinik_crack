package com.yandex.metrica.impl.ob;

import java.util.Collection;
import java.util.LinkedList;
import java.util.List;
import org.json.JSONArray;
import org.json.JSONObject;

/* renamed from: com.yandex.metrica.impl.ob.kk, reason: case insensitive filesystem */
/* loaded from: classes3.dex */
public class C1055kk {
    private final LinkedList<JSONObject> a;
    private final C0820b9 b;
    private final LinkedList<String> c;
    private final Gk d;
    private int e;

    C1055kk(int i, C0820b9 c0820b9) {
        this(i, c0820b9, new C0931fk());
    }

    void a(JSONObject jSONObject) {
        if (this.a.size() == this.e) {
            this.a.removeLast();
            this.c.removeLast();
        }
        String string = jSONObject.toString();
        this.a.addFirst(jSONObject);
        this.c.addFirst(string);
        if (this.c.isEmpty()) {
            return;
        }
        this.b.a(this.c);
    }

    public List<JSONObject> b() {
        return this.a;
    }

    C1055kk(int i, C0820b9 c0820b9, Gk gk) {
        this.a = new LinkedList<>();
        this.c = new LinkedList<>();
        this.e = i;
        this.b = c0820b9;
        this.d = gk;
        a(c0820b9);
    }

    private void a(C0820b9 c0820b9) {
        List<String> listH = c0820b9.h();
        for (int iMax = Math.max(0, listH.size() - this.e); iMax < listH.size(); iMax++) {
            String str = listH.get(iMax);
            try {
                this.a.addLast(new JSONObject(str));
                this.c.addLast(str);
            } catch (Throwable unused) {
            }
        }
    }

    public JSONObject a() {
        return this.d.a(new JSONArray((Collection) this.a));
    }
}

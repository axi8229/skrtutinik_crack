package com.yandex.metrica.impl.ob;

import android.text.TextUtils;
import java.util.ArrayList;
import java.util.Iterator;
import org.json.JSONObject;

/* renamed from: com.yandex.metrica.impl.ob.xh, reason: case insensitive filesystem */
/* loaded from: classes3.dex */
public class C1368xh {
    private final C1353x2 a;
    private final C1344wh b;

    public C1368xh(C1344wh c1344wh) {
        this(c1344wh, new C1353x2());
    }

    public long a(int i) {
        return a().optLong(String.valueOf(i));
    }

    C1368xh(C1344wh c1344wh, C1353x2 c1353x2) {
        this.b = c1344wh;
        this.a = c1353x2;
    }

    public void a(int i, long j) {
        JSONObject jSONObjectA = a();
        try {
            jSONObjectA.put(String.valueOf(i), j);
        } catch (Throwable unused) {
        }
        this.b.a(jSONObjectA.toString());
    }

    public void a(long j) {
        ArrayList arrayList = new ArrayList();
        JSONObject jSONObjectA = a();
        Iterator<String> itKeys = jSONObjectA.keys();
        while (itKeys.hasNext()) {
            String next = itKeys.next();
            long jOptLong = jSONObjectA.optLong(next);
            if (this.a.b(jOptLong, j, "last socket open on " + next)) {
                arrayList.add(next);
            }
        }
        if (arrayList.isEmpty()) {
            return;
        }
        Iterator it = arrayList.iterator();
        while (it.hasNext()) {
            jSONObjectA.remove((String) it.next());
        }
        this.b.a(jSONObjectA.toString());
    }

    private JSONObject a() {
        JSONObject jSONObject = new JSONObject();
        String strA = this.b.a();
        if (TextUtils.isEmpty(strA)) {
            return jSONObject;
        }
        try {
            return new JSONObject(strA);
        } catch (Throwable unused) {
            return jSONObject;
        }
    }
}

package com.yandex.metrica.impl.ob;

import com.yandex.metrica.core.api.ProtobufStateStorage;
import java.util.ArrayList;
import java.util.Collection;
import java.util.Iterator;
import java.util.List;
import org.json.JSONArray;
import org.json.JSONObject;

/* renamed from: com.yandex.metrica.impl.ob.gh, reason: case insensitive filesystem */
/* loaded from: classes3.dex */
public class C0953gh {
    private final ProtobufStateStorage a;
    private final C0928fh b;
    private final M0 c;

    public C0953gh(ProtobufStateStorage protobufStateStorage) {
        this(protobufStateStorage, new C0928fh(), C1152oh.a());
    }

    public void a() {
        M0 m0 = this.c;
        C0928fh c0928fh = this.b;
        List<C0978hh> list = ((C0903eh) this.a.read()).a;
        c0928fh.getClass();
        ArrayList arrayList = new ArrayList();
        for (C0978hh c0978hh : list) {
            ArrayList arrayList2 = new ArrayList(c0978hh.b.size());
            for (String str : c0978hh.b) {
                if (C0963h2.a(str)) {
                    arrayList2.add(str);
                }
            }
            if (!arrayList2.isEmpty()) {
                arrayList.add(new C0978hh(c0978hh.a, arrayList2));
            }
        }
        JSONObject jSONObject = new JSONObject();
        Iterator it = arrayList.iterator();
        while (it.hasNext()) {
            C0978hh c0978hh2 = (C0978hh) it.next();
            try {
                jSONObject.put(c0978hh2.a, new JSONObject().put("classes", new JSONArray((Collection) c0978hh2.b)));
            } catch (Throwable unused) {
            }
        }
        m0.reportEvent("sdk_list", jSONObject.toString());
    }

    public C0953gh(ProtobufStateStorage protobufStateStorage, C0928fh c0928fh, M0 m0) {
        this.a = protobufStateStorage;
        this.b = c0928fh;
        this.c = m0;
    }
}

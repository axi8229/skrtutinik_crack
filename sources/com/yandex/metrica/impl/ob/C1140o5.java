package com.yandex.metrica.impl.ob;

import kotlin.jvm.internal.Intrinsics;
import org.json.JSONObject;

/* renamed from: com.yandex.metrica.impl.ob.o5, reason: case insensitive filesystem */
/* loaded from: classes3.dex */
public class C1140o5 extends X4 {
    private final I1 b;

    public C1140o5(L3 l3) {
        this(l3, F0.g().k());
    }

    @Override // com.yandex.metrica.impl.ob.S4
    public boolean a(C0836c0 c0836c0) {
        JSONObject jSONObjectOptJSONObject;
        JSONObject jSONObject;
        EnumC1279u0 enumC1279u0 = null;
        try {
            jSONObjectOptJSONObject = new JSONObject(c0836c0.q()).optJSONObject("preloadInfo");
        } catch (Throwable unused) {
            jSONObjectOptJSONObject = null;
        }
        I1 i1 = this.b;
        String strB = Tl.b(jSONObjectOptJSONObject, "trackingId");
        JSONObject jSONObject2 = new JSONObject();
        if (jSONObjectOptJSONObject == null || !jSONObjectOptJSONObject.has("additionalParams")) {
            jSONObject = null;
        } else {
            try {
                jSONObject = jSONObjectOptJSONObject.getJSONObject("additionalParams");
            } catch (Throwable unused2) {
            }
        }
        if (jSONObject == null) {
            jSONObject = jSONObject2;
        }
        boolean zA = Tl.a(jSONObjectOptJSONObject, "wasSet", false);
        boolean zA2 = Tl.a(jSONObjectOptJSONObject, "autoTracking", false);
        String strB2 = Tl.b(jSONObjectOptJSONObject, "source");
        EnumC1279u0[] enumC1279u0ArrValues = EnumC1279u0.values();
        int i = 0;
        while (true) {
            if (i >= 4) {
                break;
            }
            EnumC1279u0 enumC1279u02 = enumC1279u0ArrValues[i];
            if (Intrinsics.areEqual(enumC1279u02.a(), strB2)) {
                enumC1279u0 = enumC1279u02;
                break;
            }
            i++;
        }
        i1.b(new C0900ee(strB, jSONObject, zA, zA2, enumC1279u0 != null ? enumC1279u0 : EnumC1279u0.UNDEFINED));
        return false;
    }

    C1140o5(L3 l3, I1 i1) {
        super(l3);
        this.b = i1;
    }
}

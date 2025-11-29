package com.yandex.metrica.impl.ob;

import android.text.TextUtils;
import com.yandex.metrica.impl.ob.C1199qf;
import org.json.JSONArray;
import org.json.JSONObject;

/* renamed from: com.yandex.metrica.impl.ob.ve, reason: case insensitive filesystem */
/* loaded from: classes3.dex */
public class C1317ve implements InterfaceC1413ze {
    @Override // com.yandex.metrica.impl.ob.InterfaceC1413ze
    public C1199qf.d.a.c a(Integer num, String str, String str2, String str3) {
        C1150of[] c1150ofArr;
        C1199qf.d.a.c cVar = new C1199qf.d.a.c();
        if (num != null) {
            cVar.c = num.intValue();
        }
        if (str != null) {
            cVar.d = str;
        }
        try {
            try {
            } catch (Throwable unused) {
                c1150ofArr = new C1150of[]{J1.b(new JSONObject(str3))};
            }
        } catch (Throwable unused2) {
        }
        C1150of[] c1150ofArrB = !TextUtils.isEmpty(str3) ? J1.b(new JSONArray(str3)) : null;
        c1150ofArr = c1150ofArrB;
        if (c1150ofArr != null) {
            cVar.a = c1150ofArr;
        }
        if (!TextUtils.isEmpty(str2)) {
            C1222rf[] c1222rfArrA = new C1222rf[0];
            try {
                c1222rfArrA = J1.a(new JSONArray(str2));
            } catch (Throwable unused3) {
            }
            cVar.b = c1222rfArrA;
        }
        return cVar;
    }
}

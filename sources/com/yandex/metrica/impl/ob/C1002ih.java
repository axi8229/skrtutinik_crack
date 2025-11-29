package com.yandex.metrica.impl.ob;

import android.text.TextUtils;
import com.google.android.gms.measurement.api.AppMeasurementSdk;
import com.yandex.metrica.impl.ob.Tl;
import java.util.ArrayList;
import java.util.List;
import org.json.JSONArray;
import org.json.JSONObject;

/* renamed from: com.yandex.metrica.impl.ob.ih, reason: case insensitive filesystem */
/* loaded from: classes3.dex */
public class C1002ih {
    public List<C0978hh> a(String str) {
        ArrayList arrayList = new ArrayList();
        try {
            JSONArray jSONArrayOptJSONArray = new Tl.a(str).optJSONArray("sdk_list");
            if (jSONArrayOptJSONArray != null) {
                for (int i = 0; i < jSONArrayOptJSONArray.length(); i++) {
                    JSONObject jSONObject = jSONArrayOptJSONArray.getJSONObject(i);
                    String strOptString = jSONObject.optString(AppMeasurementSdk.ConditionalUserProperty.NAME);
                    if (!TextUtils.isEmpty(strOptString)) {
                        JSONArray jSONArrayOptJSONArray2 = jSONObject.optJSONArray("classes");
                        ArrayList arrayList2 = new ArrayList();
                        if (jSONArrayOptJSONArray2 != null) {
                            for (int i2 = 0; i2 < jSONArrayOptJSONArray2.length(); i2++) {
                                try {
                                    String strOptString2 = jSONArrayOptJSONArray2.getJSONObject(i2).optString(AppMeasurementSdk.ConditionalUserProperty.NAME);
                                    if (!TextUtils.isEmpty(strOptString2)) {
                                        arrayList2.add(strOptString2);
                                    }
                                } catch (Throwable unused) {
                                }
                            }
                        }
                        if (!A2.b(arrayList2)) {
                            arrayList.add(new C0978hh(strOptString, arrayList2));
                        }
                    }
                }
            }
        } catch (Throwable unused2) {
        }
        return arrayList;
    }
}

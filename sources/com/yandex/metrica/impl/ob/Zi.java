package com.yandex.metrica.impl.ob;

import com.google.android.gms.measurement.api.AppMeasurementSdk;
import com.yandex.metrica.impl.ob.If;
import java.util.ArrayList;
import org.json.JSONArray;
import org.json.JSONObject;

/* loaded from: classes3.dex */
class Zi {
    Zi() {
    }

    If.y[] a(JSONArray jSONArray) {
        int i;
        if (jSONArray == null) {
            return new If.y[0];
        }
        ArrayList arrayList = new ArrayList();
        for (int i2 = 0; i2 < jSONArray.length(); i2++) {
            try {
                JSONObject jSONObject = jSONArray.getJSONObject(i2);
                Integer num = null;
                Integer numA = Tl.a(jSONObject, "type", (Integer) null);
                if (numA != null) {
                    int iIntValue = numA.intValue();
                    if (iIntValue == 0) {
                        i = 0;
                    } else if (iIntValue == 1) {
                        i = 1;
                    } else if (iIntValue == 2) {
                        i = 2;
                    } else if (iIntValue == 3) {
                        i = 3;
                    }
                    num = i;
                }
                String strB = Tl.b(jSONObject, AppMeasurementSdk.ConditionalUserProperty.VALUE);
                if (num != null && strB != null) {
                    If.y yVar = new If.y();
                    yVar.a = num.intValue();
                    yVar.b = strB;
                    arrayList.add(yVar);
                }
            } catch (Throwable unused) {
            }
        }
        return (If.y[]) arrayList.toArray(new If.y[0]);
    }
}

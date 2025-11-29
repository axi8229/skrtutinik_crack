package com.yandex.metrica.impl.interact;

import android.content.Context;
import android.text.TextUtils;
import com.huawei.hms.framework.common.ContainerUtils;
import com.yandex.metrica.impl.ob.C1298uj;
import com.yandex.metrica.impl.ob.InterfaceC0806ak;
import com.yandex.metrica.impl.ob.P;
import com.yandex.metrica.impl.ob.Xj;
import com.yandex.metrica.impl.ob.Zj;
import java.util.HashMap;
import java.util.Map;

/* loaded from: classes3.dex */
public class CellularNetworkInfo {
    private String a = "";

    class a implements InterfaceC0806ak {
        a() {
        }

        @Override // com.yandex.metrica.impl.ob.InterfaceC0806ak
        public void a(Zj zj) {
            C1298uj c1298ujB = zj.b();
            if (c1298ujB != null) {
                String strM = c1298ujB.m();
                String strN = c1298ujB.n();
                Integer numL = c1298ujB.l();
                Integer numK = c1298ujB.k();
                Integer numB = c1298ujB.b();
                Integer numE = c1298ujB.e();
                Integer numP = c1298ujB.p();
                HashMap map = new HashMap();
                map.put("network_type", strM);
                map.put("operator_name", strN);
                map.put("country_code", numK != null ? String.valueOf(numK) : null);
                map.put("operator_id", numL != null ? String.valueOf(numL) : null);
                map.put("cell_id", numB != null ? String.valueOf(numB) : null);
                map.put("lac", numE != null ? String.valueOf(numE) : null);
                map.put("signal_strength", numP != null ? String.valueOf(numP) : null);
                StringBuilder sb = new StringBuilder();
                String str = "";
                for (Map.Entry entry : map.entrySet()) {
                    String str2 = (String) entry.getValue();
                    if (!TextUtils.isEmpty(str2)) {
                        sb.append(str);
                        sb.append((String) entry.getKey());
                        sb.append(ContainerUtils.KEY_VALUE_DELIMITER);
                        sb.append(str2);
                        str = ContainerUtils.FIELD_DELIMITER;
                    }
                }
                CellularNetworkInfo.this.a = sb.toString();
            }
        }
    }

    public CellularNetworkInfo(Context context) {
        new Xj(context, P.g().d().b()).a(new a());
    }

    public String getCelluralInfo() {
        return this.a;
    }
}

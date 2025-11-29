package com.yandex.metrica.impl.ob;

import android.net.Uri;
import android.text.TextUtils;
import android.util.Pair;
import com.huawei.hms.framework.common.ContainerUtils;
import com.yandex.metrica.impl.ob.Oh;
import org.json.JSONObject;

/* loaded from: classes3.dex */
public class W4 extends X4 {
    public W4(L3 l3) {
        super(l3);
    }

    @Override // com.yandex.metrica.impl.ob.S4
    public boolean a(C0836c0 c0836c0) {
        String strQ = c0836c0.q();
        if (TextUtils.isEmpty(strQ)) {
            return false;
        }
        try {
            JSONObject jSONObject = new JSONObject(strQ);
            if (!"open".equals(jSONObject.optString("type"))) {
                return false;
            }
            a().x().j();
            if (!a(jSONObject.optString("link"))) {
                return false;
            }
            c0836c0.a(Boolean.TRUE);
            a().x().i();
            a().D();
            a().j().a();
            return false;
        } catch (Throwable unused) {
            return false;
        }
    }

    private boolean a(String str) {
        Object obj;
        if (!TextUtils.isEmpty(str)) {
            try {
                String queryParameter = Uri.parse(str).getQueryParameter("referrer");
                if (!TextUtils.isEmpty(queryParameter)) {
                    Oh ohB = a().w().b();
                    for (String str2 : queryParameter.split(ContainerUtils.FIELD_DELIMITER)) {
                        int iIndexOf = str2.indexOf(ContainerUtils.KEY_VALUE_DELIMITER);
                        if (iIndexOf >= 0) {
                            String strDecode = Uri.decode(str2.substring(0, iIndexOf));
                            String strDecode2 = Uri.decode(str2.substring(iIndexOf + 1));
                            if ("reattribution".equals(strDecode) && "1".equals(strDecode2)) {
                                return true;
                            }
                            if (ohB != null) {
                                for (Pair<String, Oh.a> pair : ohB.a) {
                                    if (A2.a(pair.first, strDecode) && ((obj = pair.second) == null || ((Oh.a) obj).a.equals(strDecode2))) {
                                        return true;
                                    }
                                }
                            } else {
                                continue;
                            }
                        }
                    }
                }
            } catch (Throwable unused) {
            }
        }
        return false;
    }
}

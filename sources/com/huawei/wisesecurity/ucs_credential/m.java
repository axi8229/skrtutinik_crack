package com.huawei.wisesecurity.ucs_credential;

import android.os.Build;
import android.text.TextUtils;
import com.huawei.hms.framework.common.ContainerUtils;
import com.huawei.wisesecurity.ucs.common.exception.UcsException;
import java.util.HashMap;
import java.util.Map;
import org.json.JSONException;
import org.json.JSONObject;

/* loaded from: classes3.dex */
public class m {
    public static String a(String str) throws JSONException, UcsException {
        try {
            JSONObject jSONObject = new JSONObject();
            jSONObject.put("request", str);
            return jSONObject.toString();
        } catch (JSONException e) {
            StringBuilder sbA = f.a("getReqBody error : ");
            sbA.append(e.getMessage());
            throw new UcsException(1002L, sbA.toString());
        }
    }

    public static Map<String, String> a(String str, String str2, String str3) {
        String string;
        HashMap map = new HashMap();
        map.put("Content-Type", "application/json");
        if (!TextUtils.isEmpty(str)) {
            map.put("X-App-ID", str);
        }
        map.put("X-Client-Version", "1.0.4.312");
        String str4 = Build.MODEL;
        map.put("terminalType", str4);
        map.put("X-Request-ID", str3);
        map.put("X-Credential-Terminal", "aucs");
        HashMap map2 = new HashMap();
        map2.put("terminalType", str4);
        map2.put("appPkgName", str2);
        map2.put("callTime", String.valueOf(System.currentTimeMillis()));
        if (map2.size() == 0) {
            string = "";
        } else {
            StringBuilder sb = new StringBuilder();
            for (Map.Entry entry : map2.entrySet()) {
                sb.append((String) entry.getKey());
                sb.append(ContainerUtils.KEY_VALUE_DELIMITER);
                sb.append((String) entry.getValue());
                sb.append(",");
            }
            sb.deleteCharAt(sb.lastIndexOf(","));
            string = sb.toString();
        }
        map.put("X-RequestContext", string);
        return map;
    }
}

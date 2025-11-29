package com.huawei.wisesecurity.ucs_credential;

import android.text.TextUtils;
import com.huawei.wisesecurity.ucs.common.exception.UcsException;
import com.huawei.wisesecurity.ucs.common.utils.StringUtil;
import java.nio.charset.StandardCharsets;
import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

/* loaded from: classes3.dex */
public class v {
    public a a;
    public b b;
    public byte[] c;
    public String d;

    public static class a {
        public String a;
        public String[] b;
    }

    public static class b {
        public int a;
        public String b;
    }

    public v(String str) throws UcsException {
        a(str);
        String[] strArrSplit = str.split("\\.");
        a(strArrSplit);
        b(strArrSplit);
        a(str, strArrSplit);
    }

    public final void a(String str) throws UcsException {
        if (TextUtils.isEmpty(str)) {
            throw new UcsException(1012L, "ComponentJws is empty.");
        }
    }

    public void a(String str, String[] strArr) throws UcsException {
        try {
            this.c = StringUtil.base64Decode(strArr[2], 8);
            this.d = str.substring(0, str.lastIndexOf("."));
        } catch (UcsException e) {
            StringBuilder sbA = f.a("Fail to convert jws string to Content, ");
            sbA.append(e.getMessage());
            throw new UcsException(1012L, sbA.toString());
        }
    }

    public void a(String[] strArr) throws UcsException {
        try {
            JSONObject jSONObject = new JSONObject(new String(StringUtil.base64Decode(strArr[0], 8), StandardCharsets.UTF_8));
            JSONArray jSONArrayOptJSONArray = jSONObject.optJSONArray("x5c");
            String[] strArr2 = {jSONArrayOptJSONArray.optString(0), jSONArrayOptJSONArray.optString(1)};
            a aVar = new a();
            this.a = aVar;
            aVar.a = jSONObject.getString("alg");
            this.a.b = strArr2;
        } catch (RuntimeException | JSONException e) {
            throw new UcsException(1012L, e.a(e, f.a("Fail to convert jws string to header, ")));
        }
    }

    public void b(String[] strArr) throws UcsException {
        try {
            JSONObject jSONObject = new JSONObject(new String(StringUtil.base64Decode(strArr[1], 8), StandardCharsets.UTF_8));
            b bVar = new b();
            this.b = bVar;
            bVar.b = jSONObject.getString("component");
            this.b.a = jSONObject.getInt("version");
        } catch (RuntimeException | JSONException e) {
            throw new UcsException(1012L, e.a(e, f.a("Fail to convert jws string to payload, ")));
        }
    }
}

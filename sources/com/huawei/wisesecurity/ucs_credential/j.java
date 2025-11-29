package com.huawei.wisesecurity.ucs_credential;

import com.huawei.wisesecurity.ucs.common.exception.UcsException;
import com.huawei.wisesecurity.ucs.common.log.LogUcs;
import com.huawei.wisesecurity.ucs.common.utils.StringUtil;
import java.nio.charset.Charset;
import java.nio.charset.StandardCharsets;
import java.security.cert.Certificate;
import java.security.cert.CertificateEncodingException;
import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

/* loaded from: classes3.dex */
public class j {
    public Certificate[] a;

    public j(String str, Certificate[] certificateArr, String str2) {
        this.a = certificateArr;
    }

    public String toString() throws JSONException {
        try {
            JSONObject jSONObject = new JSONObject();
            JSONArray jSONArray = new JSONArray();
            jSONObject.put("alg", "PS256");
            jSONObject.put("cty", "AndroidKS");
            Certificate[] certificateArr = this.a;
            int length = 3;
            if (certificateArr.length <= 3) {
                length = certificateArr.length;
            }
            for (int i = 0; i < length; i++) {
                jSONArray.put(StringUtil.base64EncodeToString(this.a[i].getEncoded(), 2));
            }
            jSONObject.put("x5c", jSONArray);
            JSONObject jSONObject2 = new JSONObject();
            jSONObject2.put("len", 32);
            String string = jSONObject2.toString();
            Charset charset = StandardCharsets.UTF_8;
            jSONObject.put("kid", StringUtil.base64EncodeToString(string.getBytes(charset), 10));
            return StringUtil.base64EncodeToString(jSONObject.toString().getBytes(charset), 10);
        } catch (UcsException e) {
            e = e;
            LogUcs.e("CredentialJws", "generate TAHeader exception: {0}", e.getMessage());
            return "";
        } catch (CertificateEncodingException e2) {
            e = e2;
            LogUcs.e("CredentialJws", "generate TAHeader exception: {0}", e.getMessage());
            return "";
        } catch (JSONException e3) {
            e = e3;
            LogUcs.e("CredentialJws", "generate TAHeader exception: {0}", e.getMessage());
            return "";
        }
    }
}

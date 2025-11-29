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
public class t extends s {
    public String i;
    public o0 j;
    public String k;
    public String l;
    public Certificate[] m;
    public int n = 5;
    public String o;

    public String a() throws JSONException, UcsException {
        try {
            this.b.put("alg", this.n);
            this.b.put("pbk", this.o);
            this.a.put("alg", this.k);
            this.a.put("cty", this.l);
            int iMin = Math.min(this.m.length, 3);
            JSONArray jSONArray = new JSONArray();
            for (int i = 0; i < iMin; i++) {
                jSONArray.put(StringUtil.base64EncodeToString(this.m[i].getEncoded(), 2));
            }
            this.a.put("x5c", jSONArray);
            JSONObject jSONObject = new JSONObject();
            jSONObject.put("len", 32);
            JSONObject jSONObject2 = this.a;
            String string = jSONObject.toString();
            Charset charset = StandardCharsets.UTF_8;
            jSONObject2.put("kid", StringUtil.base64EncodeToString(string.getBytes(charset), 10));
            try {
                this.b.put("kekAlg", this.c);
                this.b.put("packageName", this.d);
                this.b.put("appId", this.e);
                this.b.put("akskVersion", this.f);
                this.b.put("appPkgName", this.g);
                this.b.put("appCertFP", this.h);
                String str = StringUtil.base64EncodeToString(this.a.toString().getBytes(charset), 10) + "." + StringUtil.base64EncodeToString(this.b.toString().getBytes(charset), 10);
                o0 o0Var = this.j;
                if (o0Var == null) {
                    throw new UcsException(1022L, "UcsKeyStore must no null");
                }
                return str + "." + StringUtil.base64EncodeToString(o0Var.a(this.i, str), 10);
            } catch (JSONException e) {
                LogUcs.e("JwsKeystoreCredentialReqGenerator", "generate payload exception: {0}", e.getMessage());
                StringBuilder sbA = f.a("build payload json error: ");
                sbA.append(e.getMessage());
                throw new UcsException(1002L, sbA.toString());
            }
        } catch (CertificateEncodingException e2) {
            e = e2;
            LogUcs.e("JwsKeystoreECCredentialReqGenerator", e.a(e, f.a("put json error: ")), new Object[0]);
            throw new UcsException(1002L, e.a(e, f.a("put json error: ")));
        } catch (JSONException e3) {
            e = e3;
            LogUcs.e("JwsKeystoreECCredentialReqGenerator", e.a(e, f.a("put json error: ")), new Object[0]);
            throw new UcsException(1002L, e.a(e, f.a("put json error: ")));
        }
    }
}

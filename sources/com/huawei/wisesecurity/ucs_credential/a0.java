package com.huawei.wisesecurity.ucs_credential;

import android.annotation.SuppressLint;
import android.content.Context;
import android.text.TextUtils;
import com.huawei.wisesecurity.ucs.common.exception.UcsException;
import com.huawei.wisesecurity.ucs.common.log.LogUcs;
import com.huawei.wisesecurity.ucs.common.utils.SpUtil;
import com.huawei.wisesecurity.ucs.common.utils.StringUtil;
import com.huawei.wisesecurity.ucs.credential.Credential;
import com.huawei.wisesecurity.ucs.credential.CredentialClient;
import com.huawei.wisesecurity.ucs.credential.entity.ErrorBody;
import com.huawei.wisesecurity.ucs.credential.entity.UcsKeyStoreProvider;
import com.huawei.wisesecurity.ucs.credential.nativelib.UcsLib;
import com.huawei.wisesecurity.ucs.credential.outer.NetworkCapability;
import com.huawei.wisesecurity.ucs.credential.outer.NetworkResponse;
import java.nio.charset.StandardCharsets;
import java.security.cert.Certificate;
import java.util.List;
import okhttp3.internal.ws.RealWebSocket;
import org.json.JSONException;
import org.json.JSONObject;

/* loaded from: classes3.dex */
public class a0 extends b {
    public a0(CredentialClient credentialClient, Context context, NetworkCapability networkCapability) throws UcsException {
        super(credentialClient, context, networkCapability);
    }

    @Override // com.huawei.wisesecurity.ucs_credential.b
    public Credential a(String str) throws UcsException {
        try {
            if (Integer.parseInt(new JSONObject(str).getString("expire")) == 0) {
                return this.g.genCredentialFromString(str);
            }
            throw new UcsException(1017L, "unenable expire.");
        } catch (NumberFormatException e) {
            StringBuilder sbA = f.a("parse TSMS resp expire error : ");
            sbA.append(e.getMessage());
            throw new UcsException(2001L, sbA.toString());
        } catch (JSONException e2) {
            StringBuilder sbA2 = f.a("parse TSMS resp get json error : ");
            sbA2.append(e2.getMessage());
            throw new UcsException(1002L, sbA2.toString());
        }
    }

    @Override // com.huawei.wisesecurity.ucs_credential.b
    public Credential a(String str, String str2, String str3, String str4, d dVar) throws UcsException {
        try {
            LogUcs.i("KeyStoreHandler", "applyCredential use KeyStoreHandler.", new Object[0]);
            return a(str, str2, str3, str4);
        } catch (Throwable th) {
            StringBuilder sbA = f.a("applyCredential use KeyStoreHandler get exception: ");
            sbA.append(th.getMessage());
            LogUcs.e("KeyStoreHandler", sbA.toString(), new Object[0]);
            return dVar.a(0, str, str2, str3, str4, dVar);
        }
    }

    @Override // com.huawei.wisesecurity.ucs_credential.b
    public String a(NetworkResponse networkResponse) throws UcsException {
        boolean zIsSuccessful = networkResponse.isSuccessful();
        String body = networkResponse.getBody();
        if (zIsSuccessful) {
            return body;
        }
        ErrorBody errorBodyFromString = ErrorBody.fromString(body);
        StringBuilder sbA = f.a("tsms service error, ");
        sbA.append(errorBodyFromString.getErrorMessage());
        String string = sbA.toString();
        LogUcs.e("KeyStoreHandler", string, new Object[0]);
        if (b.b(errorBodyFromString.getErrorCode())) {
            d0.b(this.b);
            LogUcs.i("KeyStoreHandler", "turn off android keystore CertificateChain", new Object[0]);
        }
        throw new UcsException(RealWebSocket.DEFAULT_MINIMUM_DEFLATE_SIZE, string);
    }

    @Override // com.huawei.wisesecurity.ucs_credential.b
    public void a() throws UcsException {
        Context context = this.b;
        if (!d0.a() || SpUtil.getInt("ucs_keystore_sp_key_t", -1, context) == 0) {
            throw h.a("KeyStoreHandler", "keyStoreCertificateChain is off. not support keyStore RSA.", new Object[0], 1022L, "keyStoreCertificateChain is off. not support keyStore RSA.");
        }
    }

    @Override // com.huawei.wisesecurity.ucs_credential.b
    @SuppressLint({"NewApi"})
    public String b() throws JSONException, UcsException {
        String strBase64EncodeToString;
        if (p0.a == null) {
            p0.b.a((UcsKeyStoreProvider) null);
        }
        p0 p0Var = p0.b;
        p0Var.a("ucs_alias_rootKey");
        Certificate[] certificateArrB = p0Var.b("ucs_alias_rootKey");
        if (c0.a(certificateArrB)) {
            d0.b(this.b);
            throw new UcsException(2001L, "android keystore RSA no support software attestation root.");
        }
        String string = new j("PS256", certificateArrB, "AndroidKS").toString();
        List<String> pkgNameCertFP = UcsLib.getPkgNameCertFP(this.b);
        String str = this.e;
        String str2 = this.d;
        String str3 = pkgNameCertFP.get(0);
        String str4 = pkgNameCertFP.get(1);
        try {
            JSONObject jSONObject = new JSONObject();
            jSONObject.put("alg", 2);
            jSONObject.put("kekAlg", 1);
            jSONObject.put("packageName", str);
            jSONObject.put("appId", str2);
            jSONObject.put("akskVersion", 1);
            jSONObject.put("appPkgName", str3);
            jSONObject.put("appCertFP", str4);
            strBase64EncodeToString = StringUtil.base64EncodeToString(jSONObject.toString().getBytes(StandardCharsets.UTF_8), 10);
        } catch (UcsException | JSONException e) {
            LogUcs.e("CredentialJws", "generate payload exception: {0}", e.getMessage());
            strBase64EncodeToString = "";
        }
        if (TextUtils.isEmpty(string) || TextUtils.isEmpty(strBase64EncodeToString)) {
            throw new UcsException(1006L, "Get signStr error");
        }
        String strBase64EncodeToString2 = StringUtil.base64EncodeToString(p0Var.a("ucs_alias_rootKey", string + "." + strBase64EncodeToString), 10);
        if (TextUtils.isEmpty(string) || TextUtils.isEmpty(strBase64EncodeToString) || TextUtils.isEmpty(strBase64EncodeToString2)) {
            throw new UcsException(1006L, "get credential JWS is empty...");
        }
        StringBuilder sb = new StringBuilder();
        if (TextUtils.isEmpty(string) || TextUtils.isEmpty(strBase64EncodeToString)) {
            throw new UcsException(1006L, "Get signStr error");
        }
        sb.append(string + "." + strBase64EncodeToString);
        sb.append(".");
        sb.append(strBase64EncodeToString2);
        return sb.toString();
    }
}

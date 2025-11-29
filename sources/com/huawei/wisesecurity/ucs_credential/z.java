package com.huawei.wisesecurity.ucs_credential;

import android.content.Context;
import com.huawei.wisesecurity.ucs.common.exception.UcsException;
import com.huawei.wisesecurity.ucs.common.log.LogUcs;
import com.huawei.wisesecurity.ucs.common.utils.SpUtil;
import com.huawei.wisesecurity.ucs.common.utils.StringUtil;
import com.huawei.wisesecurity.ucs.credential.Credential;
import com.huawei.wisesecurity.ucs.credential.CredentialClient;
import com.huawei.wisesecurity.ucs.credential.entity.EcKeyPair;
import com.huawei.wisesecurity.ucs.credential.entity.ErrorBody;
import com.huawei.wisesecurity.ucs.credential.entity.UcsKeyStoreProvider;
import com.huawei.wisesecurity.ucs.credential.nativelib.UcsLib;
import com.huawei.wisesecurity.ucs.credential.outer.NetworkCapability;
import com.huawei.wisesecurity.ucs.credential.outer.NetworkResponse;
import java.security.KeyStoreException;
import java.security.cert.Certificate;
import java.util.List;
import okhttp3.internal.ws.RealWebSocket;
import org.json.JSONException;
import org.json.JSONObject;

/* loaded from: classes3.dex */
public class z extends b {
    public z(CredentialClient credentialClient, Context context, NetworkCapability networkCapability) throws UcsException {
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
            LogUcs.i("UcsECKeyStoreHandler", "applyCredential use KeyStoreEcHandler.", new Object[0]);
            return a(str, str2, str3, str4);
        } catch (Throwable th) {
            StringBuilder sbA = f.a("applyCredential use KeyStoreEcHandler get exception: ");
            sbA.append(th.getMessage());
            LogUcs.e("UcsECKeyStoreHandler", sbA.toString(), new Object[0]);
            return dVar.a(3, str, str2, str3, str4, dVar);
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
        sbA.append("; error code : ");
        sbA.append(errorBodyFromString.getErrorCode());
        String string = sbA.toString();
        LogUcs.e("UcsECKeyStoreHandler", string, new Object[0]);
        if (b.b(errorBodyFromString.getErrorCode())) {
            d0.a(this.b);
            LogUcs.i("UcsECKeyStoreHandler", "turn off android keystore EC CertificateChain", new Object[0]);
        }
        throw new UcsException(RealWebSocket.DEFAULT_MINIMUM_DEFLATE_SIZE, string);
    }

    @Override // com.huawei.wisesecurity.ucs_credential.b
    public void a() throws UcsException {
        Context context = this.b;
        if (!d0.a() || SpUtil.getInt("ucs_ec_keystore_sp_key_t", -1, context) == 0) {
            throw h.a("UcsECKeyStoreHandler", "keyStoreCertificateChain is off. not support android keyStore EC.", new Object[0], 1022L, "keyStoreCertificateChain is off. not support android keyStore EC.");
        }
    }

    @Override // com.huawei.wisesecurity.ucs_credential.b
    public String b() throws UcsException, KeyStoreException {
        n0.a(UcsKeyStoreProvider.ANDROID_KEYSTORE);
        o0 o0Var = n0.b;
        n0 n0Var = (n0) o0Var;
        n0Var.a("ucs_ec_alias_rootKey");
        Certificate[] certificateArrB = n0Var.b("ucs_ec_alias_rootKey");
        if (c0.a(certificateArrB)) {
            d0.a(this.b);
            throw new UcsException(2001L, "android keystore EC no support software attestation root.");
        }
        t tVar = new t();
        tVar.i = "ucs_ec_alias_rootKey";
        tVar.k = "ED256";
        tVar.j = o0Var;
        tVar.m = certificateArrB;
        tVar.l = "AndroidKS";
        List<String> pkgNameCertFP = UcsLib.getPkgNameCertFP(this.b);
        tVar.c = 1;
        tVar.d = this.e;
        tVar.e = this.d;
        tVar.f = 1;
        tVar.g = pkgNameCertFP.get(0);
        tVar.h = pkgNameCertFP.get(1);
        EcKeyPair ecKeyPairA = n.a(this.b);
        tVar.o = StringUtil.base64EncodeToString(ecKeyPairA.getPublicKey(), 2);
        n.a(ecKeyPairA);
        return tVar.a();
    }
}

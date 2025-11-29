package com.huawei.wisesecurity.ucs_credential;

import android.content.Context;
import com.huawei.wisesecurity.ucs.common.exception.UcsException;
import com.huawei.wisesecurity.ucs.common.log.LogUcs;
import com.huawei.wisesecurity.ucs.common.utils.SpUtil;
import com.huawei.wisesecurity.ucs.credential.Credential;
import com.huawei.wisesecurity.ucs.credential.CredentialClient;
import com.huawei.wisesecurity.ucs.credential.entity.ErrorBody;
import com.huawei.wisesecurity.ucs.credential.outer.NetworkCapability;
import com.huawei.wisesecurity.ucs.credential.outer.NetworkResponse;
import okhttp3.internal.ws.RealWebSocket;
import org.json.JSONException;
import org.json.JSONObject;

/* loaded from: classes3.dex */
public class q extends b {
    public q(CredentialClient credentialClient, Context context, NetworkCapability networkCapability) throws UcsException {
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
            LogUcs.i("HuksHandler", "applyCredential use HuksHandler.", new Object[0]);
            return a(str, str2, str3, str4);
        } catch (Throwable th) {
            StringBuilder sbA = f.a("applyCredential use HuksHandler get exception: ");
            sbA.append(th.getMessage());
            LogUcs.e("HuksHandler", sbA.toString(), new Object[0]);
            return dVar.a(0, str, str2, str3, str4, dVar);
        }
    }

    @Override // com.huawei.wisesecurity.ucs_credential.b
    public void a() throws UcsException {
        Context context = this.b;
        if (!d0.a() || SpUtil.getInt("ucs_ec_huks_sp_key_t", -1, context) == 0) {
            throw h.a("HuksHandler", "keyStoreCertificateChain is off. not support huks EC.", new Object[0], 1026L, "keyStoreCertificateChain is off. not support huks EC.");
        }
    }

    /* JADX WARN: Removed duplicated region for block: B:12:0x004e  */
    @Override // com.huawei.wisesecurity.ucs_credential.b
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    public java.lang.String b() throws com.huawei.wisesecurity.ucs.common.exception.UcsException, java.security.KeyStoreException {
        /*
            r8 = this;
            com.huawei.wisesecurity.ucs.credential.entity.UcsKeyStoreProvider r0 = com.huawei.wisesecurity.ucs.credential.entity.UcsKeyStoreProvider.HUAWEI_KEYSTORE
            com.huawei.wisesecurity.ucs_credential.n0.a(r0)
            com.huawei.wisesecurity.ucs_credential.o0 r0 = com.huawei.wisesecurity.ucs_credential.n0.b
            r1 = r0
            com.huawei.wisesecurity.ucs_credential.n0 r1 = (com.huawei.wisesecurity.ucs_credential.n0) r1
            java.lang.String r2 = "ucs_ec_alias_rootKey"
            r1.a(r2)
            java.security.cert.Certificate[] r1 = r1.b(r2)
            int r3 = r1.length
            r4 = 0
            r5 = 1
            r6 = 2
            if (r3 <= r6) goto L24
            java.security.cert.Certificate[] r3 = new java.security.cert.Certificate[r6]
            r7 = r1[r4]
            r3[r4] = r7
            r1 = r1[r5]
            r3[r5] = r1
            r1 = r3
        L24:
            com.huawei.wisesecurity.ucs_credential.t r3 = new com.huawei.wisesecurity.ucs_credential.t
            r3.<init>()
            r3.i = r2
            java.lang.String r2 = android.os.Build.MANUFACTURER
            java.lang.String r7 = "HONOR"
            boolean r2 = r2.equals(r7)
            if (r2 != 0) goto L36
            goto L4e
        L36:
            java.lang.String r2 = "com.huawei.android.os.BuildEx$VERSION"
            java.lang.Class r2 = java.lang.Class.forName(r2)     // Catch: java.lang.Throwable -> L4e
            java.lang.String r7 = "EMUI_SDK_INT"
            java.lang.reflect.Field r2 = r2.getField(r7)     // Catch: java.lang.Throwable -> L4e
            r7 = 0
            int r2 = r2.getInt(r7)     // Catch: java.lang.Throwable -> L4e
            r7 = 31
            if (r2 < r7) goto L4e
            java.lang.String r2 = "ED256"
            goto L50
        L4e:
            java.lang.String r2 = "ED256HUKS"
        L50:
            r3.k = r2
            r3.j = r0
            r3.m = r1
            android.content.Context r0 = r8.b
            java.util.List r0 = com.huawei.wisesecurity.ucs.credential.nativelib.UcsLib.getPkgNameCertFP(r0)
            java.lang.String r1 = "huks"
            r3.l = r1
            r3.c = r5
            java.lang.String r1 = r8.e
            r3.d = r1
            java.lang.String r1 = r8.d
            r3.e = r1
            r3.f = r5
            java.lang.Object r1 = r0.get(r4)
            java.lang.String r1 = (java.lang.String) r1
            r3.g = r1
            java.lang.Object r0 = r0.get(r5)
            java.lang.String r0 = (java.lang.String) r0
            r3.h = r0
            android.content.Context r0 = r8.b
            com.huawei.wisesecurity.ucs.credential.entity.EcKeyPair r0 = com.huawei.wisesecurity.ucs_credential.n.a(r0)
            byte[] r1 = r0.getPublicKey()
            java.lang.String r1 = com.huawei.wisesecurity.ucs.common.utils.StringUtil.base64EncodeToString(r1, r6)
            r3.o = r1
            com.huawei.wisesecurity.ucs_credential.n.a(r0)
            java.lang.String r0 = r3.a()
            return r0
        */
        throw new UnsupportedOperationException("Method not decompiled: com.huawei.wisesecurity.ucs_credential.q.b():java.lang.String");
    }

    @Override // com.huawei.wisesecurity.ucs_credential.b
    public String a(NetworkResponse networkResponse) throws UcsException {
        if (networkResponse.isSuccessful()) {
            return networkResponse.getBody();
        }
        ErrorBody errorBodyFromString = ErrorBody.fromString(networkResponse.getBody());
        StringBuilder sbA = f.a("tsms service error, ");
        sbA.append(errorBodyFromString.getErrorMessage());
        sbA.append("; error code : ");
        sbA.append(errorBodyFromString.getErrorCode());
        String string = sbA.toString();
        LogUcs.e("HuksHandler", string, new Object[0]);
        if (b.b(errorBodyFromString.getErrorCode())) {
            SpUtil.putInt("ucs_ec_huks_sp_key_t", 0, this.b);
            LogUcs.i("HuksHandler", "turn off huks EC CertificateChain", new Object[0]);
        }
        throw new UcsException(RealWebSocket.DEFAULT_MINIMUM_DEFLATE_SIZE, string);
    }
}

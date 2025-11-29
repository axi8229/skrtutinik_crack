package com.huawei.wisesecurity.ucs.credential;

import android.content.Context;
import android.text.TextUtils;
import com.huawei.wisesecurity.kfs.crypto.signer.SignAlg;
import com.huawei.wisesecurity.kfs.crypto.signer.hmac.HmacSigner;
import com.huawei.wisesecurity.kfs.exception.KfsValidationException;
import com.huawei.wisesecurity.kfs.validation.KfsValidator;
import com.huawei.wisesecurity.kfs.validation.constrains.KfsNotNull;
import com.huawei.wisesecurity.ucs.common.exception.UcsCryptoException;
import com.huawei.wisesecurity.ucs.common.exception.UcsException;
import com.huawei.wisesecurity.ucs.common.exception.UcsParamException;
import com.huawei.wisesecurity.ucs.common.log.LogUcs;
import com.huawei.wisesecurity.ucs.common.utils.StringUtil;
import com.huawei.wisesecurity.ucs.credential.crypto.signer.CredentialSignAlg;
import com.huawei.wisesecurity.ucs.credential.entity.SkDkEntity;
import com.huawei.wisesecurity.ucs.credential.nativelib.UcsLib;
import com.huawei.wisesecurity.ucs_credential.e;
import com.huawei.wisesecurity.ucs_credential.f;
import com.huawei.wisesecurity.ucs_credential.l;
import java.nio.charset.StandardCharsets;
import java.util.List;
import org.json.JSONException;
import org.json.JSONObject;

@Deprecated
/* loaded from: classes3.dex */
public class AppAuthticationClient {
    private CredentialSignAlg alg;
    private Context context;
    private Credential credential;
    private String extra;

    @Deprecated
    public static class Builder {

        @KfsNotNull
        private CredentialSignAlg alg = CredentialSignAlg.HMAC_SHA256;

        @KfsNotNull
        private Context context;

        @KfsNotNull
        private Credential credential;
        private String extra;

        public Builder alg(CredentialSignAlg credentialSignAlg) {
            this.alg = credentialSignAlg;
            return this;
        }

        public AppAuthticationClient build() throws UcsException {
            try {
                KfsValidator.validate(this);
                return new AppAuthticationClient(this.context, this.credential, this.extra, this.alg);
            } catch (KfsValidationException e) {
                StringBuilder sbA = f.a("AppAuthticationClient check param error : ");
                sbA.append(e.getMessage());
                throw new UcsParamException(sbA.toString());
            }
        }

        public Builder context(Context context) {
            this.context = context;
            return this;
        }

        public Builder credential(Credential credential) {
            this.credential = credential;
            return this;
        }

        public Builder extra(String str) {
            this.extra = str;
            return this;
        }
    }

    private AppAuthticationClient(Context context, Credential credential, String str, CredentialSignAlg credentialSignAlg) {
        this.context = context;
        this.credential = credential;
        this.extra = str;
        this.alg = credentialSignAlg;
    }

    @Deprecated
    public String getAppAuthtication() throws JSONException, UcsException {
        String strBase64EncodeToString;
        String str;
        String str2;
        String strBase64EncodeToString2 = "";
        try {
            com.huawei.wisesecurity.ucs_credential.a aVar = new com.huawei.wisesecurity.ucs_credential.a();
            try {
                JSONObject jSONObject = new JSONObject();
                jSONObject.put("alg", "HS256");
                strBase64EncodeToString = StringUtil.base64EncodeToString(jSONObject.toString().getBytes(StandardCharsets.UTF_8), 10);
            } catch (UcsException | JSONException e) {
                LogUcs.e("AppAuthticationJws", "generate Header exception: {0}", e.getMessage());
                strBase64EncodeToString = "";
            }
            aVar.a = strBase64EncodeToString;
            if (this.credential.getAkskVersion() < 1) {
                List<String> pkgNameCertFP = UcsLib.getPkgNameCertFP(this.context);
                str2 = pkgNameCertFP.get(0);
                str = pkgNameCertFP.get(1);
            } else {
                str = "";
                str2 = str;
            }
            String str3 = this.extra;
            try {
                JSONObject jSONObject2 = new JSONObject();
                jSONObject2.put("pkgName", str2);
                jSONObject2.put("certSig", str);
                if (!TextUtils.isEmpty(str3)) {
                    jSONObject2.put("extra", str3);
                }
                strBase64EncodeToString2 = StringUtil.base64EncodeToString(jSONObject2.toString().getBytes(StandardCharsets.UTF_8), 10);
            } catch (UcsException e2) {
                e = e2;
                LogUcs.e("AppAuthticationJws", "generate PayLoad exception: {0}", e.getMessage());
                aVar.b = strBase64EncodeToString2;
                aVar.c = StringUtil.base64EncodeToString(new HmacSigner.Builder().withKey(SkDkEntity.from(this.credential.getSecretKeyBytes()).decryptSkDk(l.a(this.credential))).withAlg(SignAlg.HMAC_SHA256).build().getSignHandler().from(aVar.b()).sign(), 10);
                return aVar.a();
            } catch (JSONException e3) {
                e = e3;
                LogUcs.e("AppAuthticationJws", "generate PayLoad exception: {0}", e.getMessage());
                aVar.b = strBase64EncodeToString2;
                aVar.c = StringUtil.base64EncodeToString(new HmacSigner.Builder().withKey(SkDkEntity.from(this.credential.getSecretKeyBytes()).decryptSkDk(l.a(this.credential))).withAlg(SignAlg.HMAC_SHA256).build().getSignHandler().from(aVar.b()).sign(), 10);
                return aVar.a();
            }
            aVar.b = strBase64EncodeToString2;
            aVar.c = StringUtil.base64EncodeToString(new HmacSigner.Builder().withKey(SkDkEntity.from(this.credential.getSecretKeyBytes()).decryptSkDk(l.a(this.credential))).withAlg(SignAlg.HMAC_SHA256).build().getSignHandler().from(aVar.b()).sign(), 10);
            return aVar.a();
        } catch (UcsCryptoException e4) {
            throw new UcsException(1022L, e4.getMessage());
        } catch (UnsupportedOperationException unused) {
            throw new UcsException(2001L, "new String UnsupportedOperationException..");
        } catch (Exception e5) {
            throw new UcsException(2001L, e.a(e5, f.a("app info auth Exception : ")));
        }
    }
}

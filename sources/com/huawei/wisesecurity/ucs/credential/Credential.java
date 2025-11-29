package com.huawei.wisesecurity.ucs.credential;

import android.content.Context;
import com.fasterxml.jackson.module.kotlin.KotlinModule;
import com.huawei.wisesecurity.kfs.crypto.codec.Decoder;
import com.huawei.wisesecurity.kfs.exception.CodecException;
import com.huawei.wisesecurity.kfs.exception.KfsValidationException;
import com.huawei.wisesecurity.kfs.validation.KfsValidator;
import com.huawei.wisesecurity.kfs.validation.constrains.KfsLongRange;
import com.huawei.wisesecurity.kfs.validation.constrains.KfsStringNotEmpty;
import com.huawei.wisesecurity.ucs.common.exception.UcsException;
import com.huawei.wisesecurity.ucs.common.exception.UcsParamException;
import com.huawei.wisesecurity.ucs.common.log.LogUcs;
import com.huawei.wisesecurity.ucs.credential.entity.AccessKey;
import com.huawei.wisesecurity.ucs.credential.entity.KeyEncryptKey;
import com.huawei.wisesecurity.ucs.credential.nativelib.UcsLib;
import com.huawei.wisesecurity.ucs_credential.e;
import com.huawei.wisesecurity.ucs_credential.f;
import com.huawei.wisesecurity.ucs_credential.h;
import com.huawei.wisesecurity.ucs_credential.i;
import com.huawei.wisesecurity.ucs_credential.l;
import org.json.JSONException;
import org.json.JSONObject;

/* loaded from: classes3.dex */
public class Credential {
    private static final String AK = "accessKey";
    private static final String DK = "dataKey";
    private static final byte[] EMPTY_BYTES = new byte[0];
    private static final String EXPIRE_TIME = "expireTime";
    private static final String KEK = "kek";
    private static final String SK = "secretKey";
    private static final String TAG = "Credential";

    @KfsStringNotEmpty
    private String accessKey;
    private AccessKey ak;

    @KfsStringNotEmpty
    private String dataKey;

    @KfsLongRange(max = Long.MAX_VALUE, min = KotlinModule.serialVersionUID)
    private long expireTime;
    private KeyEncryptKey kek;

    @KfsStringNotEmpty
    private String rawKek;

    @KfsStringNotEmpty
    private String secretKey;

    private Credential() {
    }

    private byte[] base64DecodeForNative(String str) {
        try {
            return Decoder.BASE64.decode(str);
        } catch (CodecException unused) {
            return EMPTY_BYTES;
        }
    }

    public static Credential fromString(Context context, String str, i iVar) throws UcsException {
        try {
            Credential credential = new Credential();
            JSONObject jSONObject = new JSONObject(str);
            credential.secretKey = jSONObject.optString(SK);
            credential.dataKey = jSONObject.optString(DK);
            credential.accessKey = jSONObject.optString(AK);
            credential.rawKek = jSONObject.optString(KEK);
            credential.expireTime = jSONObject.optLong(EXPIRE_TIME);
            credential.kek = KeyEncryptKey.fromString(context, credential.rawKek);
            credential.checkParam();
            credential.ak = AccessKey.fromString(credential.accessKey);
            iVar.linkedHashMap.put("credentialAppName", credential.getAppPkgName());
            iVar.linkedHashMap.put("akSkVersion", String.valueOf(credential.getAkskVersion()));
            iVar.linkedHashMap.put("cty", getCty(credential.getKekVersion()));
            if (credential.ak.hasAkskVersion()) {
                UcsLib.checkNativeLibrary();
                StringBuilder sb = new StringBuilder();
                if (!UcsLib.checkPkgNameCertFP(context, credential.ak.getAppPkgName(), credential.ak.getAppCertFP(), sb)) {
                    String str2 = "check AppPkgName appCertFP fail " + sb.toString();
                    LogUcs.e(TAG, str2, new Object[0]);
                    throw new UcsException(1023L, str2);
                }
            }
            l.b(credential).b(credential, context);
            return credential;
        } catch (UcsException e) {
            LogUcs.e(TAG, "parse credentialStr get UCS exception : errorCode : {0} errorMsg : {1}", Long.valueOf(e.getErrorCode()), e.getMessage());
            throw e;
        } catch (JSONException e2) {
            LogUcs.e(TAG, "parse credentialStr get json exception : {0}", e2.getMessage());
            StringBuilder sbA = f.a("parse credentialStr get json exception : ");
            sbA.append(e2.getMessage());
            throw new UcsException(1002L, sbA.toString());
        } catch (Exception e3) {
            String strA = e.a(e3, f.a("parse credentialStr get exception : "));
            throw h.a(TAG, strA, new Object[0], 2001L, strA);
        }
    }

    private static String getCty(int i) {
        return i != 0 ? i != 3 ? i != 6 ? i != 7 ? "" : "Huks_EC" : "AndroidKS_EC" : "AndroidKS" : "Kid";
    }

    public void checkParam() throws UcsException {
        try {
            KfsValidator.validate(this);
        } catch (KfsValidationException e) {
            StringBuilder sbA = f.a("credential get param exception : ");
            sbA.append(e.getMessage());
            throw new UcsParamException(sbA.toString());
        }
    }

    public String getAccessKey() {
        return this.accessKey;
    }

    public int getAkskVersion() {
        return this.ak.getAkskVersion();
    }

    public int getAlg() {
        return this.kek.getAlg();
    }

    public String getAppCertFP() {
        return this.ak.getAppCertFP();
    }

    public String getAppPkgName() {
        return this.ak.getAppPkgName();
    }

    public String getDataKey() {
        return this.dataKey;
    }

    public byte[] getDataKeyBytes() {
        return base64DecodeForNative(this.dataKey);
    }

    public long getExpireTime() {
        return this.expireTime;
    }

    public int getKekAlg() {
        return this.kek.getKekAlg();
    }

    public byte[] getKekBytes() {
        return base64DecodeForNative(this.kek.getKey());
    }

    public String getKekString() {
        return this.kek.getKey();
    }

    public int getKekVersion() {
        return this.kek.getVersion();
    }

    public String getRawKek() {
        return this.rawKek;
    }

    public String getSecretKey() {
        return this.secretKey;
    }

    public byte[] getSecretKeyBytes() {
        return base64DecodeForNative(this.secretKey);
    }

    public String toString() throws JSONException {
        JSONObject jSONObject = new JSONObject();
        try {
            jSONObject.put(SK, this.secretKey);
            jSONObject.put(AK, this.accessKey);
            jSONObject.put(DK, this.dataKey);
            jSONObject.put(KEK, this.rawKek);
            jSONObject.put(EXPIRE_TIME, this.expireTime);
            return jSONObject.toString();
        } catch (JSONException e) {
            LogUcs.e(TAG, "Credential toString exception : {0}", e.getMessage());
            return "";
        }
    }
}

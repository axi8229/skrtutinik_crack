package com.huawei.wisesecurity.ucs.credential.entity;

import com.huawei.wisesecurity.kfs.exception.KfsValidationException;
import com.huawei.wisesecurity.kfs.validation.KfsValidator;
import com.huawei.wisesecurity.kfs.validation.constrains.KfsStringNotEmpty;
import com.huawei.wisesecurity.ucs.common.exception.UcsException;
import com.huawei.wisesecurity.ucs.common.utils.StringUtil;
import com.huawei.wisesecurity.ucs_credential.f;
import org.json.JSONException;
import org.json.JSONObject;

/* loaded from: classes3.dex */
public class AccessKey {
    private static final String AKSK_VERSION = "akskVersion";
    private static final String APP_CERT_FP = "appCertFP";
    private static final String APP_PKG_NAME = "appPkgName";
    private int akskVersion;

    @KfsStringNotEmpty
    private String appCertFP;

    @KfsStringNotEmpty
    private String appPkgName;

    public static AccessKey fromString(String str) throws UcsException {
        try {
            AccessKey accessKey = new AccessKey();
            JSONObject jSONObject = new JSONObject(StringUtil.base64DecodeToString(str, 0));
            accessKey.akskVersion = jSONObject.optInt(AKSK_VERSION);
            accessKey.appPkgName = jSONObject.optString(APP_PKG_NAME);
            accessKey.appCertFP = jSONObject.optString(APP_CERT_FP);
            if (accessKey.hasAkskVersion()) {
                KfsValidator.validate(accessKey);
            }
            return accessKey;
        } catch (KfsValidationException e) {
            StringBuilder sbA = f.a("accessKey param invalid : ");
            sbA.append(e.getMessage());
            throw new UcsException(1001L, sbA.toString());
        } catch (JSONException e2) {
            StringBuilder sbA2 = f.a("accessKey param is not a valid json string : ");
            sbA2.append(e2.getMessage());
            throw new UcsException(1001L, sbA2.toString());
        }
    }

    public int getAkskVersion() {
        return this.akskVersion;
    }

    public String getAppCertFP() {
        return this.appCertFP;
    }

    public String getAppPkgName() {
        return this.appPkgName;
    }

    public boolean hasAkskVersion() {
        return this.akskVersion >= 1;
    }
}

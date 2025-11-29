package com.huawei.wisesecurity.ucs.credential.entity;

import android.content.Context;
import com.huawei.wisesecurity.kfs.exception.KfsValidationException;
import com.huawei.wisesecurity.kfs.validation.KfsValidator;
import com.huawei.wisesecurity.kfs.validation.constrains.KfsIntegerRange;
import com.huawei.wisesecurity.kfs.validation.constrains.KfsStringNotEmpty;
import com.huawei.wisesecurity.ucs.common.exception.UcsException;
import com.huawei.wisesecurity.ucs.common.utils.SpUtil;
import com.huawei.wisesecurity.ucs.common.utils.StringUtil;
import com.huawei.wisesecurity.ucs.credential.nativelib.UcsLib;
import com.huawei.wisesecurity.ucs_credential.f;
import com.huawei.wisesecurity.ucs_credential.g0;
import com.huawei.wisesecurity.ucs_credential.w;
import org.json.JSONException;
import org.json.JSONObject;

/* loaded from: classes3.dex */
public class KeyEncryptKey {
    private static final int KEK_ALG_GCM = 1;
    private static final String TAG = "KeyEncryptKey";

    @KfsIntegerRange(max = 5, min = 0)
    private int alg;

    @KfsIntegerRange(max = 1, min = 0)
    private int kekAlg;

    @KfsStringNotEmpty
    private String key;
    private int v1;
    private int v2;
    private int version;

    private void checkC1Version(Context context) throws UcsException {
        if (this.v2 != SpUtil.getInt("Local-C1-Version", -1, context)) {
            throw new UcsException(1020L, "kek V2 with C1 version check fail,  please reapply the credential.");
        }
    }

    private void checkSoVersion() throws UcsException {
        if (this.v1 != ((int) UcsLib.ucsGetSoVersion())) {
            throw new UcsException(1020L, "kek V1 with so version check fail,  please reapply the credential.");
        }
    }

    private void checkVersion(Context context, int i) throws UcsException {
        UcsLib.checkNativeLibrary();
        if (i == 3 || i == 6 || i == 7) {
            return;
        }
        checkSoVersion();
        checkC1Version(context);
        updateRootKey(context);
    }

    public static KeyEncryptKey fromString(Context context, String str) throws UcsException {
        try {
            KeyEncryptKey keyEncryptKey = new KeyEncryptKey();
            JSONObject jSONObject = new JSONObject(StringUtil.base64DecodeToString(str, 0));
            keyEncryptKey.version = jSONObject.getInt("version");
            keyEncryptKey.alg = jSONObject.getInt("alg");
            keyEncryptKey.kekAlg = jSONObject.getInt("kekAlg");
            keyEncryptKey.key = jSONObject.getString("key");
            keyEncryptKey.v1 = jSONObject.optInt("v1");
            keyEncryptKey.v2 = jSONObject.optInt("v2");
            KfsValidator.validate(keyEncryptKey);
            keyEncryptKey.checkVersion(context, keyEncryptKey.version);
            if (keyEncryptKey.kekAlg == 1) {
                return keyEncryptKey;
            }
            throw new UcsException(1020L, "unsupported kek alg");
        } catch (KfsValidationException e) {
            StringBuilder sbA = f.a("kek param invalid : ");
            sbA.append(e.getMessage());
            throw new UcsException(1001L, sbA.toString());
        } catch (JSONException e2) {
            StringBuilder sbA2 = f.a("kek param is not a valid json string : ");
            sbA2.append(e2.getMessage());
            throw new UcsException(1001L, sbA2.toString());
        }
    }

    private void updateRootKey(Context context) throws UcsException {
        if (UcsLib.isRootKeyUpdated()) {
            return;
        }
        w.a(context, new g0());
    }

    public int getAlg() {
        return this.alg;
    }

    public int getKekAlg() {
        return this.kekAlg;
    }

    public String getKey() {
        return this.key;
    }

    public int getV1() {
        return this.v1;
    }

    public int getV2() {
        return this.v2;
    }

    public int getVersion() {
        return this.version;
    }
}

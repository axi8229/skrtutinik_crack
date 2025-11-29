package com.huawei.location.lite.common.security;

import android.text.TextUtils;
import com.huawei.location.lite.common.log.LogLocation;
import com.huawei.secure.android.common.encrypt.keystore.aes.AesGcmKS;

/* loaded from: classes3.dex */
class yn implements Vw {
    yn() {
    }

    @Override // com.huawei.location.lite.common.security.Vw
    public String decrypt(String str, String str2) {
        if (TextUtils.isEmpty(str2) || TextUtils.isEmpty(str)) {
            LogLocation.e("AesSecurityCipher", "decrypt alias or content is null");
            return "";
        }
        try {
            return AesGcmKS.decrypt(str2, str);
        } catch (Exception unused) {
            LogLocation.e("AesSecurityCipher", "AesGcmKS decrypt failed", true);
            return "";
        }
    }

    @Override // com.huawei.location.lite.common.security.Vw
    public String encrypt(String str, String str2) {
        if (TextUtils.isEmpty(str2) || TextUtils.isEmpty(str)) {
            LogLocation.e("AesSecurityCipher", "encrypt alias or content is null");
            return "";
        }
        try {
            return AesGcmKS.encrypt(str2, str);
        } catch (Exception unused) {
            LogLocation.e("AesSecurityCipher", "AesGcmKS encrypt failed", true);
            return "";
        }
    }
}

package com.huawei.location.lite.common.security;

import com.huawei.location.lite.common.log.LogLocation;
import com.huawei.secure.android.common.encrypt.aes.AesCbc;

/* loaded from: classes3.dex */
public class dC implements Vw {
    private FB yn = new FB();

    dC() {
    }

    @Override // com.huawei.location.lite.common.security.Vw
    public String decrypt(String str, String str2) {
        String str3;
        if (this.yn == null) {
            str3 = "rootKey is null";
        } else {
            if (str.isEmpty()) {
                return "";
            }
            try {
                return AesCbc.decrypt(str, this.yn.yn());
            } catch (Exception unused) {
                str3 = "AesCbc decrypt failed";
            }
        }
        LogLocation.e("ACECipher", str3);
        return "";
    }

    @Override // com.huawei.location.lite.common.security.Vw
    public String encrypt(String str, String str2) {
        String str3;
        if (this.yn == null) {
            str3 = "rootKey is null";
        } else {
            if (str.isEmpty()) {
                return "";
            }
            try {
                return AesCbc.encrypt(str, this.yn.yn());
            } catch (Exception unused) {
                str3 = "AesCbc encrypt failed";
            }
        }
        LogLocation.e("ACECipher", str3);
        return "";
    }
}

package com.huawei.location.lite.common.security;

import com.huawei.location.lite.common.log.LogLocation;

/* loaded from: classes3.dex */
public class LocationSecurityManager implements Vw {
    private final int securityType;

    public LocationSecurityManager(int i) {
        this.securityType = i;
    }

    private Vw getSecurity() {
        int i = this.securityType;
        if (i == 1) {
            return new LW();
        }
        if (i == 2) {
            return new OpensslSm4Security();
        }
        if (i == 3) {
            return new yn();
        }
        if (i != 4) {
            return null;
        }
        return new dC();
    }

    @Override // com.huawei.location.lite.common.security.Vw
    public String decrypt(String str, String str2) {
        Vw security = getSecurity();
        if (security != null) {
            return security.decrypt(str, str2);
        }
        LogLocation.e("LocationSecurityManager", "locationCipher is null");
        return str;
    }

    @Override // com.huawei.location.lite.common.security.Vw
    public String encrypt(String str, String str2) {
        Vw security = getSecurity();
        if (security != null) {
            return security.encrypt(str, str2);
        }
        LogLocation.e("LocationSecurityManager", "locationCipher is null");
        return str;
    }
}

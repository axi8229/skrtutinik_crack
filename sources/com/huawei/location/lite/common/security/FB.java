package com.huawei.location.lite.common.security;

import com.huawei.location.lite.common.log.LogLocation;
import com.huawei.location.lite.common.util.PreferencesHelper;
import com.huawei.secure.android.common.encrypt.utils.EncryptUtil;
import com.huawei.secure.android.common.encrypt.utils.HexUtil;
import com.huawei.secure.android.common.encrypt.utils.RootKeyUtil;
import com.huawei.secure.android.common.encrypt.utils.WorkKeyCryptUtil;

/* loaded from: classes3.dex */
public class FB {
    private PreferencesHelper FB;
    private PreferencesHelper LW;
    private PreferencesHelper Vw;
    private RootKeyUtil dC;
    private PreferencesHelper yn;

    public FB() {
        Vw();
    }

    private void Vw() {
        this.yn = new PreferencesHelper("LocationCaptainA");
        this.Vw = new PreferencesHelper("LocationIronMan");
        this.FB = new PreferencesHelper("LocationCaptainM");
        this.LW = new PreferencesHelper("LocationJarvis");
        if (this.yn.getString("LocationCaptainA").isEmpty() || this.Vw.getString("LocationIronMan").isEmpty() || this.FB.getString("LocationCaptainM").isEmpty() || this.LW.getString("LocationSpiderMan").isEmpty()) {
            LogLocation.i("RootKey", "generate new root and work key");
            this.yn.saveString("LocationCaptainA", HexUtil.byteArray2HexStr(EncryptUtil.generateSecureRandom(32)));
            this.Vw.saveString("LocationIronMan", HexUtil.byteArray2HexStr(EncryptUtil.generateSecureRandom(32)));
            this.FB.saveString("LocationCaptainM", HexUtil.byteArray2HexStr(EncryptUtil.generateSecureRandom(32)));
            this.LW.saveString("LocationSpiderMan", HexUtil.byteArray2HexStr(EncryptUtil.generateSecureRandom(32)));
        }
        this.dC = RootKeyUtil.newInstance(this.yn.getString("LocationCaptainA"), this.Vw.getString("LocationIronMan"), this.FB.getString("LocationCaptainM"), this.LW.getString("LocationSpiderMan"));
        if (this.LW.getString("LocationJarvis").isEmpty()) {
            this.LW.saveString("LocationJarvis", WorkKeyCryptUtil.encryptWorkKey(EncryptUtil.generateSecureRandomStr(32), this.dC));
        }
    }

    String yn() {
        String str;
        if (this.dC == null) {
            str = "rootKeyUtil is null";
        } else {
            if (!this.LW.getString("LocationJarvis").isEmpty()) {
                return WorkKeyCryptUtil.decryptWorkKey(this.LW.getString("LocationJarvis"), this.dC);
            }
            str = "workKey is null";
        }
        LogLocation.e("RootKey", str);
        return "";
    }
}

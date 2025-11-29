package com.huawei.hms.framework.common;

import android.annotation.SuppressLint;
import com.huawei.secure.android.common.encrypt.utils.EncryptUtil;

/* loaded from: classes3.dex */
public class SecurityRandomHelper {

    @SuppressLint({"StaticFieldLeak"})
    public static volatile SecurityRandomHelper instance;

    public static SecurityRandomHelper getInstance() {
        if (instance == null) {
            synchronized (SecurityRandomHelper.class) {
                try {
                    if (instance == null) {
                        EncryptUtil.setBouncycastleFlag(true);
                        instance = new SecurityRandomHelper();
                    }
                } finally {
                }
            }
        }
        return instance;
    }

    private SecurityRandomHelper() {
    }

    public byte[] generateSecureRandom(int i) {
        return EncryptUtil.generateSecureRandom(i);
    }

    public String generateSecureRandomStr(int i) {
        return EncryptUtil.generateSecureRandomStr(i);
    }
}

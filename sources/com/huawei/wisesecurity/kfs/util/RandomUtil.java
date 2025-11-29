package com.huawei.wisesecurity.kfs.util;

import com.huawei.secure.android.common.encrypt.utils.EncryptUtil;

/* loaded from: classes3.dex */
public final class RandomUtil {
    public static byte[] generateRandomBytes(int i) {
        EncryptUtil.setBouncycastleFlag(true);
        return EncryptUtil.generateSecureRandom(i);
    }
}

package com.huawei.wisesecurity.ucs.credential.util;

import com.huawei.wisesecurity.kfs.util.RandomUtil;

/* loaded from: classes3.dex */
public class SecureRandomUtil {
    private static final String TAG = "SecureRandomUtil";

    public static byte[] generateRandomBytes(int i) {
        return RandomUtil.generateRandomBytes(i);
    }
}

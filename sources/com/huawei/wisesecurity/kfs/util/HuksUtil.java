package com.huawei.wisesecurity.kfs.util;

import com.huawei.wisesecurity.kfs.exception.KfsException;
import com.huawei.wisesecurity.ucs_credential.f;
import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;

/* loaded from: classes3.dex */
public class HuksUtil {
    private static volatile HuksUtil instance;

    private HuksUtil() throws IllegalAccessException, NoSuchMethodException, KfsException, SecurityException, IllegalArgumentException, InvocationTargetException {
        installHwKeyStoreProvider();
    }

    public static HuksUtil getInstance() throws KfsException {
        if (instance == null) {
            synchronized (HuksUtil.class) {
                try {
                    if (instance == null) {
                        instance = new HuksUtil();
                    }
                } finally {
                }
            }
        }
        return instance;
    }

    private void installHwKeyStoreProvider() throws IllegalAccessException, NoSuchMethodException, KfsException, SecurityException, IllegalArgumentException, InvocationTargetException {
        try {
            Method method = Class.forName("com.huawei.security.keystore.HwUniversalKeyStoreProvider").getMethod("install", null);
            method.setAccessible(true);
            method.invoke(null, null);
        } catch (ClassNotFoundException | IllegalAccessException | NoSuchMethodException | InvocationTargetException e) {
            StringBuilder sbA = f.a("install HwKeyStore fail:");
            sbA.append(e.getMessage());
            throw new KfsException(sbA.toString());
        }
    }
}

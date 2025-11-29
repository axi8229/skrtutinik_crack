package com.huawei.location.lite.common.util;

import android.text.TextUtils;
import com.huawei.location.lite.common.log.LogLocation;
import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;

/* loaded from: classes3.dex */
public class ReflectionUtils {
    private static final String TAG = "ReflectionUtils";

    private ReflectionUtils() {
    }

    public static boolean checkCompatible(String str) {
        try {
            tryLoadClass(str);
            return true;
        } catch (Exception unused) {
            LogLocation.w(TAG, str + "ClassNotFoundException");
            return false;
        }
    }

    public static Class<?> getClass(String str) {
        try {
            return Class.forName(str);
        } catch (ClassNotFoundException | NoClassDefFoundError unused) {
            LogLocation.e(TAG, "className not found:" + str);
            return null;
        }
    }

    public static Method getMethod(Class<?> cls, String str, Class<?>... clsArr) {
        if (cls != null && !TextUtils.isEmpty(str)) {
            try {
                return cls.getMethod(str, clsArr);
            } catch (NoSuchMethodException unused) {
                LogLocation.e(TAG, "getMethod NoSuchMethodException");
            }
        }
        return null;
    }

    public static Object invoke(Object obj, Method method, Object... objArr) {
        if (method == null) {
            throw new UnsupportedOperationException();
        }
        try {
            return method.invoke(obj, objArr);
        } catch (IllegalAccessException | IllegalArgumentException | InvocationTargetException unused) {
            LogLocation.e(TAG, "invoke Exception");
            throw new UnsupportedOperationException();
        }
    }

    public static boolean isSupportClass(String str) {
        return getClass(str) != null;
    }

    private static void tryLoadClass(String str) throws ClassNotFoundException {
        ClassLoader classLoader = ReflectionUtils.class.getClassLoader();
        if (classLoader == null) {
            throw new ClassNotFoundException("not found classloader");
        }
        classLoader.loadClass(str);
    }
}

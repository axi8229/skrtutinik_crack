package com.huawei.updatesdk.b.a.b;

import android.util.ArrayMap;
import android.util.ArraySet;
import java.io.File;
import java.lang.reflect.InvocationTargetException;
import java.security.PublicKey;

/* loaded from: classes3.dex */
class c {

    static class a {
        ArrayMap<String, ArraySet<PublicKey>> a = null;
        ArraySet<String> b = null;

        a() {
        }
    }

    static a a(File file) throws ClassNotFoundException {
        a aVar = new a();
        Object objB = b(file);
        if (objB != null) {
            Object objA = a(objB, "mKeySetMapping");
            if (objA instanceof ArrayMap) {
                aVar.a = (ArrayMap) objA;
            }
            Object objA2 = a(objB, "mUpgradeKeySets");
            if (objA2 instanceof ArraySet) {
                aVar.b = (ArraySet) objA2;
            }
        }
        return aVar;
    }

    private static Object a(Object obj, String str) {
        String str2;
        try {
            return Class.forName("android.content.pm.PackageParser$Package").getDeclaredField(str).get(obj);
        } catch (ClassNotFoundException unused) {
            str2 = "can not find class,ClassNotFoundException";
            com.huawei.updatesdk.a.a.c.a.a.a.c("KeySetsUtils", str2);
            return null;
        } catch (IllegalAccessException unused2) {
            str2 = "can not find field,IllegalAccessException";
            com.huawei.updatesdk.a.a.c.a.a.a.c("KeySetsUtils", str2);
            return null;
        } catch (NoSuchFieldError unused3) {
            str2 = "can not find field,NoSuchFieldError";
            com.huawei.updatesdk.a.a.c.a.a.a.c("KeySetsUtils", str2);
            return null;
        } catch (NoSuchFieldException unused4) {
            str2 = "can not find field,NoSuchFieldException";
            com.huawei.updatesdk.a.a.c.a.a.a.c("KeySetsUtils", str2);
            return null;
        }
    }

    private static Object b(File file) throws ClassNotFoundException {
        String str;
        try {
            Class<?> cls = Class.forName("android.content.pm.PackageParser");
            return cls.getDeclaredMethod("parsePackage", File.class, Integer.TYPE).invoke(cls.newInstance(), file, 0);
        } catch (ClassNotFoundException unused) {
            str = "can not get PackageParser,ClassNotFoundException";
            com.huawei.updatesdk.a.a.c.a.a.a.c("KeySetsUtils", str);
            return null;
        } catch (IllegalAccessException unused2) {
            str = "can not get PackageParser,IllegalAccessException";
            com.huawei.updatesdk.a.a.c.a.a.a.c("KeySetsUtils", str);
            return null;
        } catch (InstantiationException unused3) {
            str = "can not get PackageParser,InstantiationException";
            com.huawei.updatesdk.a.a.c.a.a.a.c("KeySetsUtils", str);
            return null;
        } catch (NoSuchMethodException unused4) {
            str = "can not get PackageParser,NoSuchMethodException";
            com.huawei.updatesdk.a.a.c.a.a.a.c("KeySetsUtils", str);
            return null;
        } catch (InvocationTargetException unused5) {
            str = "can not get PackageParser,InvocationTargetException";
            com.huawei.updatesdk.a.a.c.a.a.a.c("KeySetsUtils", str);
            return null;
        } catch (Exception e) {
            str = "can not get PackageParser," + e.getMessage();
            com.huawei.updatesdk.a.a.c.a.a.a.c("KeySetsUtils", str);
            return null;
        }
    }
}

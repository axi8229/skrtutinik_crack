package com.huawei.hms.push;

import android.content.Context;
import android.text.TextUtils;
import com.huawei.agconnect.config.AGConnectServicesConfig;
import com.huawei.hms.android.HwBuildEx;
import com.huawei.hms.support.log.HMSLog;
import java.io.File;
import java.lang.reflect.InvocationTargetException;
import org.json.JSONObject;

/* compiled from: CommFun.java */
/* loaded from: classes3.dex */
public abstract class c {
    private static final Object a = new Object();
    private static int b = -1;

    private static boolean a(Context context) {
        HMSLog.d("CommFun", "existFrameworkPush:" + b);
        try {
            File file = new File("/system/framework/hwpush.jar");
            if (!a() && !file.isFile()) {
                return false;
            }
            HMSLog.d("CommFun", "push jarFile is exist");
            return true;
        } catch (Exception e) {
            HMSLog.e("CommFun", "get Apk version faild ,Exception e= " + e.toString());
            return false;
        }
    }

    public static long b(Context context) {
        try {
            return context.getPackageManager().getPackageInfo("com.huawei.android.pushagent", 16384).versionCode;
        } catch (Exception unused) {
            HMSLog.e("CommFun", "get nc versionCode error");
            return -1L;
        }
    }

    public static boolean c() {
        return HwBuildEx.VERSION.EMUI_SDK_INT < 19;
    }

    public static boolean d(Context context) {
        HMSLog.d("CommFun", "existFrameworkPush:" + b);
        synchronized (a) {
            try {
                int i = b;
                if (-1 != i) {
                    return 1 == i;
                }
                if (a(context)) {
                    b = 1;
                } else {
                    b = 0;
                }
                return 1 == b;
            } catch (Throwable th) {
                throw th;
            }
        }
    }

    public static String c(Context context) {
        return AGConnectServicesConfig.fromContext(context).getString("client/project_id");
    }

    public static boolean b() {
        return HwBuildEx.VERSION.EMUI_SDK_INT >= 21;
    }

    private static boolean a() throws ClassNotFoundException {
        try {
            Class<?> cls = Class.forName("huawei.cust.HwCfgFilePolicy");
            Integer num = (Integer) cls.getDeclaredField("CUST_TYPE_CONFIG").get(cls);
            num.intValue();
            File file = (File) cls.getDeclaredMethod("getCfgFile", String.class, Integer.TYPE).invoke(cls, "jars/hwpush.jar", num);
            if (file == null || !file.exists()) {
                return false;
            }
            HMSLog.d("CommFun", "get push cust File path success.");
            return true;
        } catch (ClassNotFoundException unused) {
            HMSLog.e("CommFun", "HwCfgFilePolicy ClassNotFoundException");
            return false;
        } catch (IllegalAccessException unused2) {
            HMSLog.e("CommFun", "check cust exist push IllegalAccessException.");
            return false;
        } catch (IllegalArgumentException unused3) {
            HMSLog.e("CommFun", "check cust exist push IllegalArgumentException.");
            return false;
        } catch (NoSuchFieldException unused4) {
            HMSLog.e("CommFun", "check cust exist push NoSuchFieldException.");
            return false;
        } catch (NoSuchMethodException unused5) {
            HMSLog.e("CommFun", "check cust exist push NoSuchMethodException.");
            return false;
        } catch (SecurityException unused6) {
            HMSLog.e("CommFun", "check cust exist push SecurityException.");
            return false;
        } catch (InvocationTargetException unused7) {
            HMSLog.e("CommFun", "check cust exist push InvocationTargetException.");
            return false;
        }
    }

    public static boolean a(JSONObject jSONObject, JSONObject jSONObject2, String str) {
        return jSONObject == null || (TextUtils.isEmpty(str) && jSONObject2 == null);
    }
}

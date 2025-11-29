package com.huawei.hms.jos.util;

import android.R;
import android.app.Activity;
import android.app.ActivityManager;
import android.content.Context;
import android.content.pm.PackageInfo;
import android.content.pm.PackageManager;
import android.os.Build;
import android.os.Bundle;
import android.text.TextUtils;
import android.util.DisplayMetrics;
import android.view.View;
import android.view.WindowManager;
import com.huawei.hms.jos.manager.InnerActivityManager;
import com.huawei.hms.support.log.HMSLog;
import com.huawei.hms.utils.HMSPackageManager;
import java.util.List;

/* loaded from: classes3.dex */
public class Utils {
    private static int a;
    private static int b;

    public static int dp2Px(Context context, float f) {
        return (int) ((f * context.getResources().getDisplayMetrics().density) + 0.5f);
    }

    public static int getActivityWidth(Activity activity) {
        if (activity == null || activity.isFinishing()) {
            HMSLog.e("Utils", "activity is invalid");
            return 0;
        }
        View viewFindViewById = activity.findViewById(R.id.content);
        if (viewFindViewById != null) {
            return viewFindViewById.getMeasuredWidth();
        }
        int screenW = getScreenW(activity);
        HMSLog.e("Utils", "getActivityWidth error:android.R.id.content is null,return getScreenW");
        return screenW;
    }

    public static String getBuildVersion() {
        return String.valueOf(Build.DISPLAY);
    }

    public static String getDeviceModel() {
        return Build.MODEL;
    }

    public static String getHMSPackageName(Context context) {
        if (context != null) {
            return HMSPackageManager.getInstance(context).getHMSPackageName();
        }
        HMSLog.w("Utils", "getHMSPackageName fail, context is null.");
        return "";
    }

    public static int getPackageVersionCode(String str) throws PackageManager.NameNotFoundException {
        PackageManager packageManager;
        if (TextUtils.isEmpty(str)) {
            HMSLog.w("Utils", "getPackageVersionCode fail, packageName is " + str);
            return 0;
        }
        try {
            Activity currentActivity = InnerActivityManager.get().getCurrentActivity();
            packageManager = currentActivity == null ? null : currentActivity.getPackageManager();
        } catch (PackageManager.NameNotFoundException unused) {
        }
        if (packageManager == null) {
            HMSLog.e("Utils", "getPackageVersionCode error, getCurrentActivity is null");
            return 0;
        }
        PackageInfo packageInfo = packageManager.getPackageInfo(str, 16);
        if (packageInfo != null) {
            return packageInfo.versionCode;
        }
        return 0;
    }

    public static int getSDKVersionCode(Context context) {
        if (context == null) {
            HMSLog.e("Utils", "context is null, get getSDKVersionCode failed");
            return 0;
        }
        int i = a;
        if (i > 0) {
            return i;
        }
        try {
            Bundle bundle = context.getPackageManager().getApplicationInfo(context.getPackageName(), 128).metaData;
            if (bundle != null) {
                a = bundle.getInt("com.huawei.hms.jos.versioncode");
                HMSLog.i("Utils", "Jos Service Kit version:" + a);
                return a;
            }
        } catch (Exception unused) {
            HMSLog.e("Utils", "get getSDKVersionCode ");
        }
        return 0;
    }

    public static int getScreenW(Context context) {
        DisplayMetrics displayMetrics = new DisplayMetrics();
        ((WindowManager) context.getSystemService("window")).getDefaultDisplay().getMetrics(displayMetrics);
        int i = displayMetrics.widthPixels;
        b = i;
        return i;
    }

    public static boolean isAppVisible() {
        List<ActivityManager.RunningAppProcessInfo> runningAppProcesses;
        try {
            Activity currentActivity = InnerActivityManager.get().getCurrentActivity();
            if (currentActivity == null) {
                HMSLog.e("Utils", "get current activity failed");
                return false;
            }
            Object systemService = currentActivity.getSystemService("activity");
            if (!(systemService instanceof ActivityManager) || (runningAppProcesses = ((ActivityManager) systemService).getRunningAppProcesses()) == null) {
                return true;
            }
            for (ActivityManager.RunningAppProcessInfo runningAppProcessInfo : runningAppProcesses) {
                if (runningAppProcessInfo.pkgList[0].equals(currentActivity.getPackageName()) && runningAppProcessInfo.importance < 200) {
                    return true;
                }
            }
            return false;
        } catch (Exception unused) {
            HMSLog.e("Utils", "check the app isBackground meet exception");
            return true;
        }
    }
}

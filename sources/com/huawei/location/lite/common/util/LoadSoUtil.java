package com.huawei.location.lite.common.util;

import android.content.Context;
import android.os.Process;
import android.text.TextUtils;
import com.huawei.location.lite.common.android.context.ContextUtil;
import com.huawei.location.lite.common.log.LogLocation;
import com.huawei.secure.android.common.encrypt.hash.FileSHA256;
import java.io.File;
import java.io.IOException;

/* loaded from: classes3.dex */
public class LoadSoUtil {
    private static boolean isLoadSuccess = false;

    public static String getCurrentCpuAbi(Context context) {
        return Process.is64Bit() ? "arm64-v8a" : "armeabi-v7a";
    }

    public static String getFilePath(Context context) {
        try {
            return context.createDeviceProtectedStorageContext().getFilesDir().getCanonicalPath();
        } catch (IOException unused) {
            LogLocation.e("LoadSoUtil", "getCanonicalPath is IOException");
            return null;
        }
    }

    private static String getSoDirSavePath() {
        StringBuilder sb = new StringBuilder();
        sb.append(getFilePath(SDKComponentType.getComponentType() == 200 ? ContextUtil.getHMSContext() : ContextUtil.getContext()));
        String str = File.separator;
        sb.append(str);
        sb.append("kits");
        sb.append(str);
        sb.append(ContextUtil.getContext().getPackageName());
        sb.append(str);
        sb.append(APKUtil.getAppVersionCode(ContextUtil.getContext()));
        sb.append(str);
        sb.append("lib");
        return sb.toString();
    }

    private static String getSoFileSavePath(String str) {
        if (TextUtils.isEmpty(str) || !str.contains(".so")) {
            LogLocation.e("LoadSoUtil", "so name not valid");
            return "";
        }
        String currentCpuAbi = getCurrentCpuAbi(ContextUtil.getContext());
        StringBuilder sb = new StringBuilder();
        sb.append(getSoDirSavePath());
        String str2 = File.separator;
        sb.append(str2);
        sb.append(currentCpuAbi);
        sb.append(str2);
        sb.append(str);
        return sb.toString();
    }

    public static synchronized boolean loadLocalSo(String str) {
        return loadLocalSo(str, "", false);
    }

    public static synchronized boolean loadLocalSo(String str, String str2, boolean z) {
        if (!isLoadSuccess) {
            LogLocation.e("LoadSoUtil", "init load so fail");
            return false;
        }
        String soFileSavePath = getSoFileSavePath(str);
        if (TextUtils.isEmpty(soFileSavePath)) {
            return false;
        }
        File file = new File(soFileSavePath);
        if (!file.exists()) {
            LogLocation.e("LoadSoUtil", "load Local so error because of so file not exist");
            return false;
        }
        if (z && !FileSHA256.validateFileSHA256(file, str2)) {
            return false;
        }
        System.load(soFileSavePath);
        return true;
    }

    public static boolean loadSo(String str, String str2) {
        if (TextUtils.isEmpty(str)) {
            return false;
        }
        try {
            File file = new File(str2 + File.separator + str);
            if (file.exists() && file.length() > 0) {
                System.load(file.getCanonicalPath());
                return true;
            }
            return false;
        } catch (IOException unused) {
            LogLocation.d("LoadSoUtil", "loadSo exception:Invalid file path");
            return false;
        }
    }
}

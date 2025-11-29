package com.huawei.hms.locationSdk;

import android.content.Context;
import android.location.Location;
import android.os.Bundle;
import android.text.TextUtils;
import com.huawei.hms.common.ApiException;
import com.huawei.hms.location.LocationResult;
import com.huawei.hms.location.LogConfig;
import com.huawei.hms.support.api.client.Status;
import com.huawei.hms.support.api.location.common.HMSLocationLog;
import com.huawei.hms.support.api.location.common.exception.LocationStatusCode;
import com.huawei.location.lite.common.android.context.ContextUtil;
import com.huawei.location.lite.common.log.logwrite.DateUtil;
import com.huawei.location.lite.common.log.logwrite.LogWriteParam;
import com.huawei.location.lite.common.util.APKUtil;
import com.huawei.location.lite.common.util.PermissionUtil;
import com.huawei.secure.android.common.intent.SafeBundle;
import java.io.File;
import java.util.Calendar;
import java.util.regex.Pattern;
import java.util.regex.PatternSyntaxException;

/* loaded from: classes3.dex */
public class l0 {
    public static LogWriteParam a(LogConfig logConfig) {
        LogWriteParam logWriteParam = new LogWriteParam();
        logWriteParam.setFileExpiredTime(logConfig.getFileExpiredTime());
        logWriteParam.setFileNum(logConfig.getFileNum());
        logWriteParam.setFileSize(logConfig.getFileSize());
        logWriteParam.setLogPath(logConfig.getLogPath());
        return logWriteParam;
    }

    private static String a() {
        return DateUtil.formate(Calendar.getInstance().getTime(), "yy-MM-dd HH:mm:ss.SSS");
    }

    public static String a(Context context) {
        StringBuilder sb = new StringBuilder();
        String packageName = context.getPackageName();
        String strValueOf = String.valueOf(APKUtil.getThirdAppVersionCode(context.getPackageName()));
        String strValueOf2 = String.valueOf(61200300);
        String strValueOf3 = String.valueOf(APKUtil.getThirdAppVersionCode("com.huawei.hwid"));
        sb.append(packageName);
        sb.append(":");
        sb.append(strValueOf);
        sb.append(",");
        sb.append("locationSdkVersion");
        sb.append(":");
        sb.append(strValueOf2);
        sb.append(",");
        sb.append("com.huawei.hwid");
        sb.append(":");
        sb.append(strValueOf3);
        return sb.toString();
    }

    public static String a(String str, LocationResult locationResult) {
        StringBuilder sb = new StringBuilder();
        sb.append("\t");
        sb.append(a());
        sb.append(",");
        sb.append(str);
        sb.append(",");
        Location location = locationResult.getLocations().get(0);
        if (location != null) {
            sb.append(location.getProvider());
            sb.append(",");
            sb.append("\t");
            sb.append(location.getLatitude());
            sb.append(",");
            sb.append("\t");
            sb.append(location.getLongitude());
            sb.append(",");
            sb.append(location.getAccuracy());
            sb.append(",");
            sb.append("\t");
            sb.append(location.getTime());
            sb.append(",");
            sb.append(location.getSpeed());
            sb.append(",");
            Bundle extras = location.getExtras();
            SafeBundle safeBundle = new SafeBundle(extras);
            if (extras != null) {
                sb.append(safeBundle.getString("session_id"));
                sb.append(",");
                int i = safeBundle.getInt("SourceType", Integer.MIN_VALUE);
                if (i == Integer.MIN_VALUE) {
                    sb.append("null");
                } else {
                    sb.append(i);
                }
                sb.append(",");
                sb.append(safeBundle.getString("locateType"));
                sb.append(",");
                sb.append(safeBundle.getInt("vendorType"));
                sb.append(",");
                sb.append(safeBundle.getString("src"));
                sb.append(",");
                sb.append(safeBundle.getInt("switchHd"));
                sb.append(",");
                sb.append(safeBundle.getInt("floor"));
                sb.append(",");
                sb.append(safeBundle.getInt("floorAcc"));
                sb.append(",");
                sb.append(safeBundle.getString("buildingId"));
            }
        }
        return sb.toString();
    }

    public static void a(Context context, String str, String str2) throws ApiException {
        String str3;
        if (TextUtils.isEmpty(str)) {
            throw new ApiException(new Status(LocationStatusCode.ARGUMENTS_EMPTY, LocationStatusCode.getStatusCodeString(LocationStatusCode.ARGUMENTS_EMPTY)));
        }
        if (str.startsWith("/data/user/") || str.startsWith("/data/data/") || str.startsWith("data/data/") || str.startsWith("data/user/")) {
            str3 = "setLogConfig internal storage - read and write permissions not need to be verified";
        } else {
            HMSLocationLog.i("WriteLocationResultUtil", str2, "setLogConfig Non-internal storage - read and write permissions need to be verified");
            ContextUtil.setContext(context);
            if (!PermissionUtil.checkSelfPermission(context, "android.permission.READ_EXTERNAL_STORAGE")) {
                throw new ApiException(new Status(10803, LocationStatusCode.getStatusCodeString(10803)));
            }
            if (!PermissionUtil.checkSelfPermission(context, "android.permission.WRITE_EXTERNAL_STORAGE")) {
                throw new ApiException(new Status(10803, LocationStatusCode.getStatusCodeString(10803)));
            }
            str3 = "setLogConfig Permission check pass";
        }
        HMSLocationLog.i("WriteLocationResultUtil", str2, str3);
    }

    public static void a(String str, String str2) throws ApiException {
        if (TextUtils.isEmpty(str)) {
            throw new ApiException(new Status(LocationStatusCode.ARGUMENTS_EMPTY, LocationStatusCode.getStatusCodeString(LocationStatusCode.ARGUMENTS_EMPTY)));
        }
        if (!str.startsWith("data/data/") && !str.startsWith("/data/data/") && !str.startsWith("/data/user/") && !str.startsWith("data/user/") && !str.startsWith("/storage/emulated") && !str.startsWith("storage/emulated") && !str.startsWith("/storage/B3E4-1711") && !str.startsWith("storage/B3E4-1711") && !str.startsWith("/storage/sdcard") && !str.startsWith("storage/sdcard") && !str.startsWith("/mnt/sdcard/") && !str.startsWith("mnt/sdcard/")) {
            throw new ApiException(new Status(10101, LocationStatusCode.getStatusCodeString(10101)));
        }
        if (a(str)) {
            throw new ApiException(new Status(10101, LocationStatusCode.getStatusCodeString(10101)));
        }
        File file = new File(str);
        try {
            if (file.exists()) {
                return;
            }
            if (file.mkdirs()) {
                HMSLocationLog.i("WriteLocationResultUtil", str2, "createFolder success");
            } else {
                HMSLocationLog.e("WriteLocationResultUtil", str2, "createFolder fail");
                throw new ApiException(new Status(10101, LocationStatusCode.getStatusCodeString(10101)));
            }
        } catch (SecurityException e) {
            HMSLocationLog.e("WriteLocationResultUtil", str2, "createFolder SecurityException:" + e.getMessage());
        }
    }

    public static boolean a(String str) throws PatternSyntaxException {
        return !Pattern.compile("^[-a-zA-Z0-9_/.]+$").matcher(str).find();
    }

    public static boolean b() {
        return false;
    }
}

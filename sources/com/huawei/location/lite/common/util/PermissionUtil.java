package com.huawei.location.lite.common.util;

import android.app.ActivityManager;
import android.content.Context;
import android.content.pm.PackageManager;
import android.text.TextUtils;
import androidx.core.content.PermissionChecker;
import com.huawei.location.base.activity.constant.ActivityErrorCode;
import com.huawei.location.lite.common.android.context.ContextUtil;
import com.huawei.location.lite.common.exception.LocationServiceException;
import com.huawei.location.lite.common.exception.LocationStatusCode;
import com.huawei.location.lite.common.log.LogLocation;
import java.util.List;

/* loaded from: classes3.dex */
public class PermissionUtil {
    private static int errorCode;

    static {
        errorCode = SDKComponentType.getComponentType() == 200 ? ActivityErrorCode.PERMISSION_DENIED : 10803;
    }

    public static int checkPermission(Context context, String str, int i, int i2, String str2) {
        try {
            PackageManager packageManager = context.getPackageManager();
            if (str2 == null) {
                String[] packagesForUid = packageManager.getPackagesForUid(i2);
                if (packagesForUid != null && packagesForUid.length > 0) {
                    str2 = packagesForUid[0];
                }
                LogLocation.i("PermissionUtil", "checkPermission get packageName fail ");
                return -1;
            }
            return APKUtil.getTargetSdkVersion(str2) >= 23 ? packageManager.checkPermission(str, str2) : PermissionChecker.checkPermission(context, str, i, i2, str2);
        } catch (Exception unused) {
            LogLocation.e("PermissionUtil", "checkPermission LocationServiceException");
            throw new LocationServiceException(10000, LocationStatusCode.getStatusCodeString(10000));
        }
    }

    public static boolean checkSelfPermission(Context context, String str) {
        String str2;
        if (context == null || TextUtils.isEmpty(str)) {
            str2 = "hasSelfPermission failed because of context or permission is null";
        } else {
            if (context.checkSelfPermission(str) == 0) {
                return true;
            }
            str2 = "do not hasSelfPermission " + str;
        }
        LogLocation.e("PermissionUtil", str2);
        return false;
    }

    public static boolean hasPermission(Context context, String str, int i, int i2) {
        String str2;
        if (context == null) {
            str2 = "hasPermission Context is null";
        } else {
            int iCheckPermission = checkPermission(context, str, i, i2, null);
            if (iCheckPermission == 0) {
                return true;
            }
            if (-1 != iCheckPermission) {
                LogLocation.e("PermissionUtil", "hasPermission, result is " + iCheckPermission);
                int i3 = errorCode;
                throw new LocationServiceException(i3, LocationStatusCode.getStatusCodeString(i3));
            }
            str2 = "hasPermission, result is " + iCheckPermission;
        }
        LogLocation.e("PermissionUtil", str2);
        return false;
    }

    public static boolean isAppIsInBackground(String str) {
        String str2;
        Object systemService = ContextUtil.getHMSContext().getSystemService("activity");
        if (systemService instanceof ActivityManager) {
            List<ActivityManager.RunningAppProcessInfo> runningAppProcesses = ((ActivityManager) systemService).getRunningAppProcesses();
            if (runningAppProcesses != null) {
                boolean z = true;
                for (ActivityManager.RunningAppProcessInfo runningAppProcessInfo : runningAppProcesses) {
                    if (isImportanceForeground(runningAppProcessInfo.importance)) {
                        String[] strArr = runningAppProcessInfo.pkgList;
                        int length = strArr.length;
                        int i = 0;
                        while (true) {
                            if (i >= length) {
                                break;
                            }
                            if (strArr[i].equals(str)) {
                                z = false;
                                break;
                            }
                            i++;
                        }
                    }
                }
                return z;
            }
            str2 = "runningProcesses is null";
        } else {
            str2 = "managerResult is not a instance of ActivityManager";
        }
        LogLocation.e("PermissionUtil", str2);
        return false;
    }

    private static boolean isImportanceForeground(int i) {
        return i <= 125;
    }
}

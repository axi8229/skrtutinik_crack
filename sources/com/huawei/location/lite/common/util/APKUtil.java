package com.huawei.location.lite.common.util;

import android.content.Context;
import android.content.pm.ApplicationInfo;
import android.content.pm.PackageInfo;
import android.content.pm.PackageManager;
import android.content.pm.Signature;
import android.os.Build;
import android.text.TextUtils;
import android.util.LruCache;
import com.huawei.location.lite.common.android.context.ContextUtil;
import com.huawei.location.lite.common.android.receiver.PackageOperateCallback;
import com.huawei.location.lite.common.android.receiver.PackageReceiver;
import com.huawei.location.lite.common.log.LogLocation;
import com.huawei.secure.android.common.util.SafeString;
import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;
import java.util.Locale;

/* loaded from: classes3.dex */
public class APKUtil {
    private static LruCache<String, ApkInfo> apkInfoLruCache;

    public static class ApkInfo {
        public int applicationFlag;
        public int applicationLabelRes;
        public String defSecretSignature;
        public Signature signature;
        public int targetSdkVersion;
        public int uid;
        public long versionCode = -1;
        public String versionName;
    }

    static {
        PackageReceiver.getInstance().registerCallback(new PackageOperateCallback() { // from class: com.huawei.location.lite.common.util.APKUtil.1
            @Override // com.huawei.location.lite.common.android.receiver.PackageOperateCallback
            public void onAdded(String str) {
            }

            @Override // com.huawei.location.lite.common.android.receiver.PackageOperateCallback
            public void onRemoved(String str) {
                APKUtil.updateLruCache(str);
            }

            @Override // com.huawei.location.lite.common.android.receiver.PackageOperateCallback
            public void onReplaced(String str) {
                APKUtil.updateLruCache(str);
            }
        });
    }

    public static synchronized ApkInfo getApkInfo(String str, int i) {
        if (TextUtils.isEmpty(str)) {
            LogLocation.d("APKUtil", "package name is empty");
            return new ApkInfo();
        }
        if (apkInfoLruCache == null) {
            apkInfoLruCache = new LruCache<>(4);
        }
        ApkInfo packageInfo = apkInfoLruCache.get(str);
        if (packageInfo != null) {
            LogLocation.d("APKUtil", "getPackageInfo From Cache");
            if (i == 1) {
                if (packageInfo.uid <= 0) {
                    packageInfo = getPackageInfo(packageInfo, str, i);
                }
                return packageInfo;
            }
            if (i == 64) {
                if (TextUtils.isEmpty(packageInfo.defSecretSignature)) {
                    packageInfo = getPackageInfo(packageInfo, str, i);
                }
                return packageInfo;
            }
            if (i == 16384) {
                if (packageInfo.versionCode <= 0) {
                    packageInfo = getPackageInfo(packageInfo, str, i);
                }
                return packageInfo;
            }
        }
        return getPackageInfo(packageInfo, str, i);
    }

    public static long getAppVersionCode(Context context) {
        if (context == null) {
            return -1L;
        }
        return getVersionCode(context.getPackageName());
    }

    public static long getLBSVersionCode() {
        return getThirdAppVersionCode("com.huawei.lbs");
    }

    private static ApkInfo getPackageInfo(ApkInfo apkInfo, String str, int i) throws PackageManager.NameNotFoundException {
        String str2;
        PackageInfo packageInfo;
        PackageManager packageManager = ContextUtil.getContext().getPackageManager();
        if (apkInfo == null) {
            apkInfo = new ApkInfo();
        }
        try {
            LogLocation.d("APKUtil", "getPackageInfo From PackageManager");
            packageInfo = packageManager.getPackageInfo(str, i);
        } catch (PackageManager.NameNotFoundException unused) {
            str2 = "NameNotFoundException!";
            LogLocation.d("APKUtil", str2);
            return apkInfo;
        } catch (Exception unused2) {
            str2 = "Package  manager  has  died Exception";
            LogLocation.d("APKUtil", str2);
            return apkInfo;
        }
        if (packageInfo == null) {
            return apkInfo;
        }
        if (i == 1) {
            apkInfo.uid = packageInfo.applicationInfo.uid;
        } else if (i == 64) {
            apkInfo.signature = !CollectionsUtils.isEmpty(packageInfo.signatures) ? packageInfo.signatures[0] : null;
            apkInfo.defSecretSignature = getSignature(packageInfo.signatures);
        } else if (i == 16384) {
            apkInfo.versionName = packageInfo.versionName;
            apkInfo.versionCode = Build.VERSION.SDK_INT >= 28 ? packageInfo.getLongVersionCode() : packageInfo.versionCode;
            ApplicationInfo applicationInfo = packageInfo.applicationInfo;
            apkInfo.targetSdkVersion = applicationInfo.targetSdkVersion;
            apkInfo.applicationLabelRes = applicationInfo.labelRes;
            apkInfo.applicationFlag = applicationInfo.flags;
        }
        if (i != 64) {
            apkInfoLruCache.put(str, apkInfo);
        }
        return apkInfo;
    }

    public static String getPackageVersionName(String str) {
        return getVersionName(str);
    }

    private static String getSignature(Signature[] signatureArr) {
        String str;
        if (CollectionsUtils.isEmpty(signatureArr)) {
            str = "signatures is empty!";
        } else {
            try {
                return getSignatureString(signatureArr[0]);
            } catch (NoSuchAlgorithmException unused) {
                str = "NoSuchAlgorithmException!";
            }
        }
        LogLocation.d("APKUtil", str);
        return null;
    }

    public static String getSignatureForPkgName(String str) {
        return getApkInfo(str, 64).defSecretSignature;
    }

    private static String getSignatureString(Signature signature) throws NoSuchAlgorithmException {
        byte[] bArrDigest = MessageDigest.getInstance("SHA256").digest(signature.toByteArray());
        StringBuilder sb = new StringBuilder();
        for (byte b : bArrDigest) {
            sb.append(SafeString.substring(Integer.toHexString((b & 255) | 256), 1, 3).toUpperCase(Locale.ROOT));
        }
        return sb.toString();
    }

    public static int getTargetSdkVersion(String str) {
        return getApkInfo(str, 16384).targetSdkVersion;
    }

    public static long getThirdAppVersionCode(String str) {
        return getVersionCode(str);
    }

    public static int getUidByPackageName(String str) {
        if (str != null && !str.isEmpty()) {
            return getApkInfo(str, 1).uid;
        }
        LogLocation.d("APKUtil", "packageName is empty, return -1");
        return -1;
    }

    private static long getVersionCode(String str) {
        return getApkInfo(str, 16384).versionCode;
    }

    public static String getVersionName() {
        return getVersionName(ContextUtil.getContext().getPackageName());
    }

    private static String getVersionName(String str) {
        return getApkInfo(str, 16384).versionName;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static void updateLruCache(String str) {
        if (apkInfoLruCache.get(str) != null) {
            apkInfoLruCache.remove(str);
        }
    }
}

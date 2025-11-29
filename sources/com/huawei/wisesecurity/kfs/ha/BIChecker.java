package com.huawei.wisesecurity.kfs.ha;

import android.content.Context;
import android.os.Build;
import android.provider.Settings;
import android.text.TextUtils;
import com.huawei.hms.android.SystemUtils;
import com.huawei.wisesecurity.kfs.log.ILogKfs;
import com.huawei.wisesecurity.kfs.util.PropertyUtil;
import java.util.Locale;

/* loaded from: classes3.dex */
class BIChecker {
    private static int isOobe = -1;
    private boolean isOobeCheck = true;
    private final ILogKfs kfsLog;

    public BIChecker(ILogKfs iLogKfs) {
        this.kfsLog = iLogKfs;
    }

    private String getLocalCountry() {
        return Locale.getDefault().getCountry();
    }

    private String getProductLocal() {
        return PropertyUtil.getSystemProperties("ro.product.locale", "");
    }

    private String getProductRegion() {
        return PropertyUtil.getSystemProperties("ro.product.locale.region", "");
    }

    private boolean isChinaROM() {
        String productRegion = getProductRegion();
        if (!TextUtils.isEmpty(productRegion)) {
            return "cn".equalsIgnoreCase(productRegion);
        }
        String productLocal = getProductLocal();
        if (!TextUtils.isEmpty(productLocal)) {
            return productLocal.toLowerCase(Locale.US).contains("cn");
        }
        String localCountry = getLocalCountry();
        if (TextUtils.isEmpty(localCountry)) {
            return false;
        }
        return "cn".equalsIgnoreCase(localCountry);
    }

    private boolean isHuawei() {
        return SystemUtils.PRODUCT_HUAWEI.equalsIgnoreCase(Build.MANUFACTURER);
    }

    private static void setIsOobe(int i) {
        isOobe = i;
    }

    public boolean hasError(Context context) {
        ILogKfs iLogKfs;
        String str;
        if (!this.isOobeCheck) {
            iLogKfs = this.kfsLog;
            str = "oobe check is off, report is on";
        } else {
            if (isHuawei()) {
                if (context == null) {
                    return true;
                }
                if (isChinaROM()) {
                    return isOobe == 0;
                }
                this.kfsLog.i("BIChecker", "not ChinaROM");
                try {
                    setIsOobe(Settings.Secure.getInt(context.getContentResolver(), "hw_app_analytics_state"));
                    this.kfsLog.i("BIChecker", "hw_app_analytics_state value is " + isOobe);
                    return isOobe != 1;
                } catch (Settings.SettingNotFoundException unused) {
                    this.kfsLog.i("BIChecker", "Get OOBE failed");
                    return true;
                }
            }
            iLogKfs = this.kfsLog;
            str = "not huawei device, report is on";
        }
        iLogKfs.i("BIChecker", str);
        return false;
    }

    public void setOobeCheckOff() {
        this.isOobeCheck = false;
    }
}

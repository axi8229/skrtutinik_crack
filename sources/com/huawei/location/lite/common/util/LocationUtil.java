package com.huawei.location.lite.common.util;

import android.content.Context;
import android.content.IntentFilter;
import android.provider.Settings;
import com.huawei.location.lite.common.android.context.ContextUtil;
import com.huawei.location.lite.common.android.receiver.ScreenStatusBroadcastReceiver;
import com.huawei.location.lite.common.log.LogLocation;
import java.io.IOException;
import java.util.concurrent.atomic.AtomicBoolean;

/* loaded from: classes3.dex */
public class LocationUtil {
    private static AtomicBoolean isRegister = new AtomicBoolean(false);
    private static volatile int locatorSDKVersion = 0;

    public static String getFilePath(Context context) {
        try {
            return context.createDeviceProtectedStorageContext().getFilesDir().getCanonicalPath();
        } catch (IOException unused) {
            LogLocation.e("LocationUtil", "getCanonicalPath is IOException");
            return null;
        }
    }

    public static boolean isBlePresent(Context context) {
        if (context == null) {
            LogLocation.e("LocationUtil", "isBlePresent Context is null");
            return false;
        }
        boolean zHasSystemFeature = context.getPackageManager().hasSystemFeature("android.hardware.bluetooth_le");
        LogLocation.i("LocationUtil", "isBlePresent isBlePresent is " + zHasSystemFeature);
        return zHasSystemFeature;
    }

    public static boolean isBlueBoothEnabled(Context context) {
        if (context == null) {
            LogLocation.e("LocationUtil", "isBlueBoothEnabled Context is null");
            return false;
        }
        int i = Settings.Global.getInt(context.getContentResolver(), "bluetooth_on", -1);
        boolean z = i == 1;
        LogLocation.i("LocationUtil", "isBlueBoothEnabled locationMode is " + i);
        return z;
    }

    public static boolean isLocationEnabled(Context context) {
        return isLocationEnabled(context, true);
    }

    public static boolean isLocationEnabled(Context context, boolean z) throws Settings.SettingNotFoundException {
        String str;
        if (context == null) {
            str = "isLocationEnabled Context is null";
        } else {
            try {
                int i = Settings.Secure.getInt(context.getContentResolver(), "location_mode");
                LogLocation.i("LocationUtil", "isLocationEnabled locationMode is " + i);
                if (!z) {
                    return i == 3;
                }
                if (i != 3) {
                    return false;
                }
                int i2 = Settings.Secure.getInt(context.getContentResolver(), "first_open_location_switch", 1);
                LogLocation.i("LocationUtil", "isLocationEnabled agreed is " + i2);
                return i2 == 1;
            } catch (Settings.SettingNotFoundException unused) {
                str = "isLocationEnabled SettingNotFoundException";
            }
        }
        LogLocation.e("LocationUtil", str);
        return false;
    }

    public static boolean isScanBleEnabled(Context context) throws Settings.SettingNotFoundException {
        if (context == null) {
            LogLocation.e("LocationUtil", "isScanBleEnabled Context is null");
            return false;
        }
        try {
            int i = Settings.Global.getInt(context.getContentResolver(), "ble_scan_always_enabled");
            z = i == 1;
            LogLocation.i("LocationUtil", "isScanBleEnabled locationMode is " + i);
        } catch (Settings.SettingNotFoundException unused) {
            LogLocation.e("LocationUtil", "isScanBleEnabled SettingNotFoundException");
        }
        return z;
    }

    public static synchronized void registerScreenStatusBroadcast() {
        if (isRegister.get()) {
            LogLocation.i("LocationUtil", "registerScreenStatusBroadcast is Register");
            return;
        }
        IntentFilter intentFilter = new IntentFilter();
        intentFilter.addAction("android.intent.action.SCREEN_OFF");
        intentFilter.addAction("android.intent.action.SCREEN_ON");
        ContextUtil.getContext().registerReceiver(new ScreenStatusBroadcastReceiver(), intentFilter);
        isRegister.set(true);
    }
}

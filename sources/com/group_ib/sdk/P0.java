package com.group_ib.sdk;

import android.app.admin.DevicePolicyManager;
import android.content.pm.PackageManager;
import android.graphics.Point;
import android.os.Build;
import android.provider.Settings;
import android.util.DisplayMetrics;
import android.view.Display;
import android.view.WindowManager;
import java.io.File;
import java.util.HashMap;
import org.json.JSONArray;
import org.json.JSONObject;

/* loaded from: classes3.dex */
public final class P0 extends B0 {
    public static final String[] e = {"/mnt/windows/BstSharedFolder"};

    public P0(MobileSdkService mobileSdkService) {
        super(mobileSdkService, 1, 0L);
    }

    @Override // com.group_ib.sdk.B0
    public final void a(b1 b1Var) {
        JSONArray jSONArray;
        Display defaultDisplay;
        String str;
        int storageEncryptionStatus;
        try {
            b1Var.put("AndroidSDK", String.valueOf(Build.VERSION.SDK_INT));
            b1Var.put("AndroidRelease", Build.VERSION.RELEASE);
            String str2 = Build.SERIAL;
            if (str2 != null) {
                b1Var.put("Serial", str2);
            }
            String string = Settings.Secure.getString(this.a.getContentResolver(), "android_id");
            if (string != null) {
                b1Var.put("AndroidID", new a1(string));
            }
        } catch (Exception e2) {
            c1.b("ParamsOnce", "get android profile failed", e2);
        }
        try {
            b1Var.put("PhoneBoard", Build.BOARD);
            b1Var.put("PhoneBootloader", Build.BOOTLOADER);
            b1Var.put("PhoneBrand", Build.BRAND);
            b1Var.put("PhoneDevice", Build.DEVICE);
            b1Var.put("PhoneDisplay", Build.DISPLAY);
            b1Var.put("PhoneFingerprint", Build.FINGERPRINT);
            b1Var.put("PhoneHardware", Build.HARDWARE);
            b1Var.put("PhoneHost", Build.HOST);
            b1Var.put("PhoneID", Build.ID);
            b1Var.put("PhoneManufacturerModel", Build.MANUFACTURER + " " + Build.MODEL);
            b1Var.put("PhoneProduct", Build.PRODUCT);
            b1Var.put("PhoneRadio", Build.getRadioVersion());
            if (Build.VERSION.SDK_INT >= 26 && AbstractC0604j0.a(this.a, "android.permission.READ_PHONE_STATE")) {
                try {
                    b1Var.put("PhoneSerial", Build.getSerial());
                } catch (SecurityException unused) {
                    c1.a(4, 4, "ParamsOnce", "get serial number is not permitted");
                }
            }
            DevicePolicyManager devicePolicyManager = (DevicePolicyManager) this.a.getSystemService("device_policy");
            b1Var.put("DeviceEncrypted", (devicePolicyManager == null || !((storageEncryptionStatus = devicePolicyManager.getStorageEncryptionStatus()) == 3 || storageEncryptionStatus == 5)) ? "false" : "true");
        } catch (Exception e3) {
            c1.b("ParamsOnce", "get phone params failed", e3);
        }
        try {
            synchronized (T.class) {
                str = T.g;
            }
            if (str != null) {
                b1Var.put("AppVersion", this.a.getPackageManager().getPackageInfo(T.e(), 0).versionName);
            } else {
                b1Var.put("AppVersion", "N/A");
            }
        } catch (PackageManager.NameNotFoundException e4) {
            c1.b("ParamsOnce", "get app version failed", e4);
        }
        b(b1Var);
        WindowManager windowManager = (WindowManager) this.a.getSystemService("window");
        if (windowManager != null && (defaultDisplay = windowManager.getDefaultDisplay()) != null) {
            Point point = new Point();
            defaultDisplay.getRealSize(point);
            DisplayMetrics displayMetrics = this.a.getResources().getDisplayMetrics();
            if (displayMetrics != null) {
                b1Var.put("DisplayHeight", Integer.valueOf(point.y));
                b1Var.put("DisplayWidth", Integer.valueOf(point.x));
                b1Var.put("DisplayDensity", Float.valueOf(displayMetrics.density));
                b1Var.put("DisplayDensityDpi", Integer.valueOf(displayMetrics.densityDpi));
                b1Var.put("DisplayXDPI", Float.valueOf(displayMetrics.xdpi));
                b1Var.put("DisplayYDPI", Float.valueOf(displayMetrics.ydpi));
            }
        }
        String str3 = e[0];
        char[] cArr = AbstractC0604j0.a;
        if (str3 != null && new File(str3).exists()) {
            jSONArray = new JSONArray();
            jSONArray.put(str3);
        } else {
            jSONArray = null;
        }
        if (jSONArray != null) {
            b1Var.put("FilesExists", jSONArray);
        }
    }

    public final void b(b1 b1Var) {
        String str;
        String str2;
        try {
            PackageManager packageManager = this.a.getPackageManager();
            synchronized (T.class) {
                str2 = T.g;
            }
            str = packageManager.getPackageInfo(str2, 0).versionName;
        } catch (PackageManager.NameNotFoundException e2) {
            e2.printStackTrace();
            str = null;
        }
        HashMap map = new HashMap();
        map.put("as", "2.0.b302271022");
        map.put("p", str);
        b1Var.put("SDKVersion", new JSONObject(map).toString());
    }
}

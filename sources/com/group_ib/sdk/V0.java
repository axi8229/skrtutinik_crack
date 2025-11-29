package com.group_ib.sdk;

import android.app.KeyguardManager;
import android.provider.Settings;
import android.provider.Telephony;

/* loaded from: classes3.dex */
public final class V0 extends B0 {
    public V0(MobileSdkService mobileSdkService) {
        super(mobileSdkService, Integer.MAX_VALUE, 60000L);
    }

    @Override // com.group_ib.sdk.B0
    public final void a(b1 b1Var) {
        String str = "false";
        try {
            String defaultSmsPackage = Telephony.Sms.getDefaultSmsPackage(this.a);
            if (defaultSmsPackage != null) {
                b1Var.put("DefaultSMSApp", defaultSmsPackage);
            }
        } catch (Exception e) {
            c1.b("ParamsRegular", "get default sms app failed", e);
        }
        try {
            try {
            } catch (Exception e2) {
                c1.b("ParamsRegular", "detection of non market apps enabled is failed", e2);
            }
            String str2 = Settings.Secure.getInt(this.a.getContentResolver(), "install_non_market_apps", 0) != 0 ? "true" : "false";
            b1Var.put("NonMarketAppsEnabled", str2);
            try {
            } catch (Exception e3) {
                c1.b("ParamsRegular", "detection of development mode enabled is failed", e3);
            }
            String str3 = Settings.Secure.getInt(this.a.getContentResolver(), "development_settings_enabled", 0) != 0 ? "true" : "false";
            b1Var.put("DeveloperModeEnabled", str3);
            KeyguardManager keyguardManager = (KeyguardManager) this.a.getSystemService("keyguard");
            if (keyguardManager != null && keyguardManager.isDeviceSecure()) {
                str = "true";
            }
            b1Var.put("IsDeviceSecured", str);
        } catch (Exception e4) {
            c1.b("ParamsRegular", "get phone params failed", e4);
        }
    }
}

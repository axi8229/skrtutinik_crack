package com.huawei.location.nlp.scan.wifi;

import android.content.Context;
import android.content.Intent;
import android.content.IntentFilter;
import android.net.wifi.ScanResult;
import android.net.wifi.WifiManager;
import android.text.TextUtils;
import com.huawei.location.lite.common.android.context.ContextUtil;
import com.huawei.location.lite.common.log.LogLocation;
import com.huawei.location.lite.common.util.PermissionUtil;
import com.huawei.secure.android.common.intent.SafeBroadcastReceiver;
import java.util.List;

/* loaded from: classes3.dex */
public class FB {
    private yn FB;
    private SafeBroadcastReceiver LW;
    private Context Vw;
    private boolean dC = true;
    private WifiManager yn;

    public interface yn {
        void onFail(int i, String str);

        void yn(List<ScanResult> list);
    }

    public FB() {
        Context context = ContextUtil.getContext();
        this.Vw = context;
        Object systemService = context.getApplicationContext().getSystemService("wifi");
        if (systemService instanceof WifiManager) {
            this.yn = (WifiManager) systemService;
            LogLocation.i("WifiScanManager", "WifiScanManager init");
        }
    }

    static void yn(FB fb, Intent intent) {
        String str;
        String str2;
        if (fb.FB == null) {
            str = "onReceiveWifi, wifiScanLister is null";
        } else {
            String action = intent.getAction();
            if (!TextUtils.isEmpty(action) && "android.net.wifi.SCAN_RESULTS".equals(action)) {
                fb.dC = true;
                WifiManager wifiManager = fb.yn;
                if (wifiManager == null) {
                    str2 = "onReceiveWifi, WiFiManager is null";
                } else {
                    try {
                        List<ScanResult> scanResults = wifiManager.getScanResults();
                        if (!scanResults.isEmpty()) {
                            fb.FB.yn(scanResults);
                            return;
                        }
                        str2 = "onReceiveWifi, wifi scan result is null";
                    } catch (Exception unused) {
                        str2 = "onReceiveWifi, remoteException";
                    }
                }
                LogLocation.e("WifiScanManager", str2);
                fb.FB.onFail(10000, com.huawei.location.nlp.constant.yn.yn(10000));
                return;
            }
            str = "onReceiveWifi, action is invalid";
        }
        LogLocation.e("WifiScanManager", str);
    }

    public void yn() {
        SafeBroadcastReceiver safeBroadcastReceiver;
        Context context = this.Vw;
        if (context == null || (safeBroadcastReceiver = this.LW) == null) {
            return;
        }
        try {
            context.unregisterReceiver(safeBroadcastReceiver);
        } catch (Exception unused) {
            LogLocation.e("WifiScanManager", "unregisterReceiver error");
        }
        this.LW = null;
    }

    public void yn(yn ynVar) {
        if (!PermissionUtil.checkSelfPermission(this.Vw, "android.permission.ACCESS_WIFI_STATE") || !PermissionUtil.checkSelfPermission(this.Vw, "android.permission.CHANGE_WIFI_STATE")) {
            ynVar.onFail(10000, com.huawei.location.nlp.constant.yn.yn(10000));
            return;
        }
        this.FB = ynVar;
        if (this.LW == null) {
            LogLocation.i("WifiScanManager", "registeredWifiBroadcast");
            this.LW = new Vw(this);
            IntentFilter intentFilter = new IntentFilter();
            intentFilter.addAction("android.net.wifi.SCAN_RESULTS");
            this.Vw.registerReceiver(this.LW, intentFilter);
        }
        WifiManager wifiManager = this.yn;
        if (wifiManager == null) {
            LogLocation.e("WifiScanManager", "WifiScanManager is null");
            ynVar.onFail(10000, com.huawei.location.nlp.constant.yn.yn(10000));
            return;
        }
        try {
            wifiManager.startScan();
            this.dC = false;
        } catch (Exception unused) {
            LogLocation.e("WifiScanManager", "WifiScanManager throw Exception");
            ynVar.onFail(10000, com.huawei.location.nlp.constant.yn.yn(10000));
        }
    }
}

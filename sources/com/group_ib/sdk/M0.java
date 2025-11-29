package com.group_ib.sdk;

import android.net.ConnectivityManager;
import android.net.NetworkInfo;
import android.net.wifi.ScanResult;
import android.net.wifi.WifiInfo;
import android.net.wifi.WifiManager;
import java.util.List;
import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

/* loaded from: classes3.dex */
public final class M0 extends B0 {
    public M0(MobileSdkService mobileSdkService) {
        super(mobileSdkService, 29, 0L);
    }

    @Override // com.group_ib.sdk.B0
    public final void a(b1 b1Var) throws JSONException {
        WifiManager wifiManager;
        boolean zContains;
        try {
            ConnectivityManager connectivityManager = (ConnectivityManager) this.a.getSystemService("connectivity");
            if (connectivityManager == null) {
                return;
            }
            NetworkInfo activeNetworkInfo = connectivityManager.getActiveNetworkInfo();
            if (activeNetworkInfo == null || !activeNetworkInfo.isConnected()) {
                b1Var.remove("WifiSsid");
                b1Var.remove("WifiMacAddress");
                return;
            }
            if (activeNetworkInfo.getType() != 1 || (wifiManager = (WifiManager) this.a.getApplicationContext().getSystemService("wifi")) == null) {
                return;
            }
            if (!AbstractC0604j0.a(this.a, "android.permission.ACCESS_COARSE_LOCATION") && !AbstractC0604j0.a(this.a, "android.permission.ACCESS_FINE_LOCATION")) {
                return;
            }
            if (AbstractC0604j0.a(this.a, "android.permission.ACCESS_WIFI_STATE")) {
                WifiInfo connectionInfo = wifiManager.getConnectionInfo();
                b1Var.put("WifiBssid", connectionInfo.getBSSID());
                String macAddress = connectionInfo.getMacAddress();
                if (macAddress != null && !macAddress.equals("02:00:00:00:00:00")) {
                    b1Var.put("WifiMacAddress", macAddress);
                }
                EnumC0589c enumC0589c = EnumC0589c.AccessPointsCollectionCapability;
                synchronized (T.class) {
                    zContains = T.s.contains(enumC0589c);
                }
                if (zContains) {
                    List<ScanResult> scanResults = wifiManager.getScanResults();
                    String ssid = null;
                    if (scanResults != null && !scanResults.isEmpty()) {
                        JSONArray jSONArray = new JSONArray();
                        for (ScanResult scanResult : scanResults) {
                            JSONObject jSONObjectPut = new JSONObject().put("ssid", scanResult.SSID).put("bssid", scanResult.BSSID).put("rssi", scanResult.level);
                            if (scanResult.BSSID.equals(connectionInfo.getBSSID())) {
                                ssid = scanResult.SSID;
                                b1Var.put("WifiCapabilities", scanResult.capabilities);
                            }
                            jSONArray.put(jSONObjectPut);
                        }
                        if (c1.b(5)) {
                            c1.a(4, 4, "ParamsNetwork", "AccessPoints changed: " + jSONArray.toString());
                        }
                        this.a.a(jSONArray);
                    }
                    if (ssid == null) {
                        ssid = connectionInfo.getSSID();
                    }
                    b1Var.put("WifiSsid", ssid);
                }
            }
        } catch (Exception e) {
            c1.b("ParamsNetwork", "failed to get network params", e);
        }
    }
}

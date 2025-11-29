package com.huawei.location.crowdsourcing.record;

import android.content.Context;
import android.location.Location;
import android.net.wifi.ScanResult;
import android.net.wifi.WifiInfo;
import android.net.wifi.WifiManager;
import android.os.SystemClock;
import android.text.TextUtils;
import com.google.gson.annotations.SerializedName;
import com.huawei.location.lite.common.log.LogLocation;
import com.huawei.secure.android.common.intent.SafeBundle;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.Iterator;
import java.util.List;
import java.util.Locale;

/* loaded from: classes3.dex */
public class yn {

    @SerializedName("ACC")
    private int E5;

    @SerializedName("SRCTYPE")
    private int EF;

    @SerializedName("LAT")
    private String FB;

    @SerializedName("BOOTTIME")
    private long G3;

    @SerializedName("LON")
    private String LW;

    @SerializedName("ARSTATUS")
    private int OB;

    @SerializedName("DIFF_TIME")
    private long Ot = 2147483647L;

    @SerializedName("HappenTime")
    private String Vw;

    @SerializedName("AVGPRESSURE")
    private float Wf;

    @SerializedName("CURRENTCELL")
    private List<Vw> Yx;

    @SerializedName("BEARING")
    private int d2;

    @SerializedName("ALT")
    private String dC;

    @SerializedName("WIFIAPINFO")
    private List<FB> dW;

    @SerializedName("NEIGHBORCELL")
    private List<Vw> h1;

    @SerializedName("TYPE")
    private int oc;

    @SerializedName("FIX_TIME")
    private long ut;
    private transient long yn;

    @SerializedName("SPEED")
    private int zp;

    public String toString() {
        return "CommonParam{happenTime='" + this.Vw + "', latitude=" + this.FB + ", longitude=" + this.LW + ", altitude=" + this.dC + ", accuracy=" + this.E5 + ", bearing=" + this.d2 + ", speed=" + this.zp + ", locationTime=" + this.ut + ", type=" + this.oc + ", diffTime=" + this.Ot + ", bootTime=" + this.G3 + ", currentCells=" + this.Yx + ", neighborCells=" + this.h1 + ", wifiInfos=" + this.dW + ", avgPressure=" + this.Wf + ", sourceType=" + this.EF + ", arStatus=" + this.OB + ", locationBootTime=" + this.yn + '}';
    }

    public void yn(Location location) {
        this.Vw = new SimpleDateFormat("yyyyMMddHHmmss", Locale.US).format(new Date());
        if (location != null) {
            this.FB = location.getLatitude() + "";
            this.LW = location.getLongitude() + "";
            this.dC = location.getAltitude() + "";
            this.E5 = (int) location.getAccuracy();
            this.d2 = (int) location.getBearing();
            this.zp = (int) location.getSpeed();
            this.ut = location.getTime();
            this.yn = (location.getElapsedRealtimeNanos() / 1000) / 1000;
            String provider = location.getProvider();
            this.oc = (!TextUtils.isEmpty(provider) && provider.equals("gps")) ? 0 : 1;
            this.EF = new SafeBundle(location.getExtras()).getInt("SourceType", -1);
        }
        this.G3 = SystemClock.elapsedRealtime();
        this.Wf = 0.0f;
    }

    public void yn(List<com.huawei.location.crowdsourcing.common.entity.yn> list) {
        ArrayList arrayList = new ArrayList();
        ArrayList arrayList2 = new ArrayList();
        for (com.huawei.location.crowdsourcing.common.entity.yn ynVar : list) {
            if (ynVar.Vw().isRegistered()) {
                Vw vw = new Vw();
                vw.yn(ynVar);
                arrayList.add(vw);
            } else {
                Vw vw2 = new Vw();
                vw2.Vw(ynVar);
                arrayList2.add(vw2);
            }
        }
        if (arrayList2.size() != 0) {
            if (arrayList.size() == 1) {
                if (Vw.yn((Vw) arrayList.get(0), arrayList2)) {
                    Vw.Vw((Vw) arrayList.get(0), arrayList2);
                }
            } else if (arrayList.size() == 2) {
                Vw vw3 = (Vw) arrayList.get(0);
                Vw vw4 = (Vw) arrayList.get(1);
                if ((vw3 == null || vw4 == null) ? false : vw3.yn(vw4)) {
                    boolean zYn = Vw.yn(vw3, arrayList2);
                    boolean zYn2 = Vw.yn(vw4, arrayList2);
                    if (zYn) {
                        Vw.Vw(vw3, arrayList2);
                    }
                    if (zYn2) {
                        Vw.Vw(vw4, arrayList2);
                    }
                } else {
                    Vw vw5 = (Vw) arrayList.get(0);
                    Vw vw6 = (Vw) arrayList.get(1);
                    ArrayList arrayList3 = new ArrayList(arrayList2.size());
                    ArrayList arrayList4 = new ArrayList(arrayList2.size());
                    Iterator it = arrayList2.iterator();
                    while (it.hasNext()) {
                        Vw vw7 = (Vw) it.next();
                        if (vw5.yn(vw7)) {
                            arrayList3.add(vw7);
                        } else if (vw6.yn(vw7)) {
                            arrayList4.add(vw7);
                        } else {
                            LogLocation.d("LocCellInfo", "neighborCellBy5GRules: not fit");
                        }
                    }
                    if (Vw.yn(vw3, arrayList3)) {
                        Vw.Vw(vw3, arrayList3);
                    }
                    if (Vw.yn(vw4, arrayList4)) {
                        Vw.Vw(vw4, arrayList4);
                    }
                }
            } else {
                LogLocation.d("LocCellInfo", "neighborCellBy5GRules: Not supported Three SIM Card");
            }
        }
        this.Yx = arrayList;
        this.h1 = arrayList2;
    }

    public void yn(List<ScanResult> list, Context context) {
        if (list.isEmpty()) {
            return;
        }
        ArrayList arrayList = new ArrayList();
        Object systemService = context.getApplicationContext().getSystemService("wifi");
        String bssid = "";
        if (systemService instanceof WifiManager) {
            WifiInfo connectionInfo = ((WifiManager) systemService).getConnectionInfo();
            if (connectionInfo != null) {
                bssid = connectionInfo.getBSSID();
            }
        } else {
            LogLocation.d("LocWifiInfo", "not get WIFI_SERVICE");
        }
        for (ScanResult scanResult : list) {
            FB fb = new FB();
            fb.yn(scanResult, bssid);
            this.Ot = Math.min(this.Ot, (int) Math.abs(this.yn - fb.yn()));
            arrayList.add(fb);
        }
        this.dW = arrayList;
    }
}

package com.huawei.location.nlp.network.request;

import com.huawei.location.lite.common.util.NetworkUtil;
import com.huawei.location.nlp.network.request.cell.CellSourceInfo;
import com.huawei.location.nlp.network.request.wifi.WifiInfo;
import java.util.List;

/* loaded from: classes3.dex */
public class OnlineLocationRequest {
    private long boottime;
    private List<CellSourceInfo> cellInfos;
    private RequestExtraInfo extraInfo;
    private GPSLocationOnline gpsLastLocation;
    private int indoorMode = 0;
    private int networkType = NetworkUtil.getNetworkType();
    private List<WifiInfo> wifiScanResult;

    public long getBoottime() {
        return this.boottime;
    }

    public List<CellSourceInfo> getCellInfos() {
        return this.cellInfos;
    }

    public RequestExtraInfo getExtraInfo() {
        return this.extraInfo;
    }

    public GPSLocationOnline getGpsLastLocation() {
        return this.gpsLastLocation;
    }

    public int getIndoorMode() {
        return this.indoorMode;
    }

    public int getNetworkType() {
        return this.networkType;
    }

    public List<WifiInfo> getWifiScanResult() {
        return this.wifiScanResult;
    }

    public void setBoottime(long j) {
        this.boottime = j;
    }

    public void setCellInfos(List<CellSourceInfo> list) {
        this.cellInfos = list;
    }

    public void setExtraInfo(RequestExtraInfo requestExtraInfo) {
        this.extraInfo = requestExtraInfo;
    }

    public void setGpsLastLocation(GPSLocationOnline gPSLocationOnline) {
        this.gpsLastLocation = gPSLocationOnline;
    }

    public void setIndoorMode(int i) {
        this.indoorMode = i;
    }

    public void setNetworkType(int i) {
        this.networkType = i;
    }

    public void setWifiScanResult(List<WifiInfo> list) {
        this.wifiScanResult = list;
    }

    public String toString() {
        StringBuilder sb = new StringBuilder("OnlineLocationRequest {indoorMode=" + this.indoorMode + ", bootTime=" + this.boottime + ", networkType=" + this.networkType);
        if (this.wifiScanResult != null) {
            sb.append(", wifiScanResult size is ");
            sb.append(this.wifiScanResult.size());
        }
        if (this.cellInfos != null) {
            sb.append(", cellInfo size is ");
            sb.append(this.cellInfos.size());
        }
        sb.append('}');
        return sb.toString();
    }
}

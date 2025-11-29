package com.huawei.location.resp;

/* loaded from: classes3.dex */
public class LocationAvailabilityInfo {
    private int cellStatus;
    private long elapsedRealtimeNs;
    private int locationStatus;
    private int wifiStatus;

    public int getCellStatus() {
        return this.cellStatus;
    }

    public long getElapsedRealtimeNs() {
        return this.elapsedRealtimeNs;
    }

    public int getLocationStatus() {
        return this.locationStatus;
    }

    public int getWifiStatus() {
        return this.wifiStatus;
    }

    public void setCellStatus(int i) {
        this.cellStatus = i;
    }

    public void setElapsedRealtimeNs(long j) {
        this.elapsedRealtimeNs = j;
    }

    public void setLocationStatus(int i) {
        this.locationStatus = i;
    }

    public void setWifiStatus(int i) {
        this.wifiStatus = i;
    }
}

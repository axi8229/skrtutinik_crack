package com.huawei.location.nlp.network.request.wifi;

/* loaded from: classes3.dex */
public class WifiInfo {
    private static final int FLAG_SAME_CODE = 16;
    private int frequency;
    private long mac;
    private int rssi;
    private long time;

    public WifiInfo(long j, int i, long j2, int i2) {
        this.mac = j;
        this.rssi = i;
        this.time = j2;
        this.frequency = i2;
    }

    public int getFrequency() {
        return this.frequency;
    }

    public long getMac() {
        return this.mac;
    }

    public int getRssi() {
        return this.rssi;
    }

    public long getSameCode() {
        return this.mac / 16;
    }

    public long getTime() {
        return this.time;
    }

    public void setFrequency(int i) {
        this.frequency = i;
    }

    public void setMac(long j) {
        this.mac = j;
    }

    public void setRssi(short s) {
        this.rssi = s;
    }

    public void setTime(long j) {
        this.time = j;
    }
}

package com.huawei.hms.support.api.entity.location.offlinelocation;

/* loaded from: classes3.dex */
public class HwCellInfo {
    private long cellId;
    private int channelNumber;
    private boolean isRegistered;
    private int lacOrTac;
    private int mcc;
    private int mnc;
    private int physicalIdentity;
    private int rat;
    private int rssi;
    private long timeStamp;

    public long getCellId() {
        return this.cellId;
    }

    public int getChannelNumber() {
        return this.channelNumber;
    }

    public int getLacOrTac() {
        return this.lacOrTac;
    }

    public int getMcc() {
        return this.mcc;
    }

    public int getMnc() {
        return this.mnc;
    }

    public int getPhysicalIdentity() {
        return this.physicalIdentity;
    }

    public int getRat() {
        return this.rat;
    }

    public int getRssi() {
        return this.rssi;
    }

    public long getTimeStamp() {
        return this.timeStamp;
    }

    public boolean isRegistered() {
        return this.isRegistered;
    }

    public void setCellId(long j) {
        this.cellId = j;
    }

    public void setChannelNumber(int i) {
        this.channelNumber = i;
    }

    public void setLacOrTac(int i) {
        this.lacOrTac = i;
    }

    public void setMcc(int i) {
        this.mcc = i;
    }

    public void setMnc(int i) {
        this.mnc = i;
    }

    public void setPhysicalIdentity(int i) {
        this.physicalIdentity = i;
    }

    public void setRat(int i) {
        this.rat = i;
    }

    public void setRegistered(boolean z) {
        this.isRegistered = z;
    }

    public void setRssi(int i) {
        this.rssi = i;
    }

    public void setTimeStamp(long j) {
        this.timeStamp = j;
    }
}

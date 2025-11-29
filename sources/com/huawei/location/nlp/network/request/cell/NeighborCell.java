package com.huawei.location.nlp.network.request.cell;

/* loaded from: classes3.dex */
public class NeighborCell {
    private int cNum;
    private int pId;
    private short rssi;

    public NeighborCell(int i, int i2, short s) {
        this.cNum = i;
        this.pId = i2;
        this.rssi = s;
    }

    public short getRssi() {
        return this.rssi;
    }

    public int getcNum() {
        return this.cNum;
    }

    public int getpId() {
        return this.pId;
    }

    public void setRssi(short s) {
        this.rssi = s;
    }

    public void setcNum(int i) {
        this.cNum = i;
    }

    public void setpId(int i) {
        this.pId = i;
    }

    public String toString() {
        return "NeighborCell{cNum=" + this.cNum + ", pId=" + this.pId + ", rssi=" + ((int) this.rssi) + '}';
    }
}

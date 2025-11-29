package com.huawei.location.nlp.network.request.cell;

/* loaded from: classes3.dex */
public class CurrentCell {
    private long boottime;
    private long cellId;
    private int lac;
    private int mcc;
    private int mnc;
    private int rat;
    private short rssi;

    public long getBoottime() {
        return this.boottime;
    }

    public long getCellId() {
        return this.cellId;
    }

    public int getLac() {
        return this.lac;
    }

    public int getMcc() {
        return this.mcc;
    }

    public int getMnc() {
        return this.mnc;
    }

    public int getRat() {
        return this.rat;
    }

    public short getRssi() {
        return this.rssi;
    }

    public void setBoottime(long j) {
        this.boottime = j;
    }

    public void setCellId(long j) {
        this.cellId = j;
    }

    public void setLac(int i) {
        this.lac = i;
    }

    public void setMcc(int i) {
        this.mcc = i;
    }

    public void setMnc(int i) {
        this.mnc = i;
    }

    public void setRat(int i) {
        this.rat = i;
    }

    public void setRssi(short s) {
        this.rssi = s;
    }

    public String toString() {
        return "CurrentCell{boottime=" + this.boottime + ", mcc=" + this.mcc + ", mnc=" + this.mnc + ", lac=" + this.lac + ", cellId=" + this.cellId + ", rat=" + this.rat + ", rssi=" + ((int) this.rssi) + '}';
    }
}

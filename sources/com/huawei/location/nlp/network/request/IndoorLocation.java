package com.huawei.location.nlp.network.request;

/* loaded from: classes3.dex */
public class IndoorLocation {
    private float acc;
    private String buildingId;
    private int flags;
    private int floor;
    private float floorAcc;
    private double lat;
    private double lon;
    private long time;

    public float getAcc() {
        return this.acc;
    }

    public String getBuildingId() {
        return this.buildingId;
    }

    public int getFlags() {
        return this.flags;
    }

    public int getFloor() {
        return this.floor;
    }

    public float getFloorAcc() {
        return this.floorAcc;
    }

    public double getLat() {
        return this.lat;
    }

    public double getLon() {
        return this.lon;
    }

    public long getTime() {
        return this.time;
    }

    public void setAcc(float f) {
        this.acc = f;
    }

    public void setBuildingId(String str) {
        this.buildingId = str;
    }

    public void setFlags(int i) {
        this.flags = i;
    }

    public void setFloor(int i) {
        this.floor = i;
    }

    public void setFloorAcc(float f) {
        this.floorAcc = f;
    }

    public void setLat(double d) {
        this.lat = d;
    }

    public void setLon(double d) {
        this.lon = d;
    }

    public void setTime(long j) {
        this.time = j;
    }

    public String toString() {
        return "IndoorLocation{lat=" + this.lat + ", lon=" + this.lon + ", acc=" + this.acc + ", buildingId='" + this.buildingId + "', floor=" + this.floor + ", floorAcc=" + this.floorAcc + ", time=" + this.time + ", flags=" + this.flags + '}';
    }
}

package com.huawei.location.nlp.network.response;

/* loaded from: classes3.dex */
public class Location {
    private float acc;
    private float bearing;
    private String buildingId;
    private String extraInfo;
    private short flags;
    private int floor;
    private int floorAcc;
    private double lat;
    private double lon;
    private float speed;
    private long time;

    public float getAccuracy() {
        return this.acc;
    }

    public float getBearing() {
        return this.bearing;
    }

    public String getBuildingId() {
        return this.buildingId;
    }

    public String getExtraInfo() {
        return this.extraInfo;
    }

    public short getFlags() {
        return this.flags;
    }

    public int getFloor() {
        return this.floor;
    }

    public int getFloorAcc() {
        return this.floorAcc;
    }

    public double getLatitude() {
        return this.lat;
    }

    public double getLongitude() {
        return this.lon;
    }

    public float getSpeed() {
        return this.speed;
    }

    public long getTime() {
        return this.time;
    }

    public void setAccuracy(float f) {
        this.acc = f;
    }

    public void setBearing(float f) {
        this.bearing = f;
    }

    public void setBuildingId(String str) {
        this.buildingId = str;
    }

    public void setExtraInfo(String str) {
        this.extraInfo = str;
    }

    public void setFlags(short s) {
        this.flags = s;
    }

    public void setFloor(int i) {
        this.floor = i;
    }

    public void setFloorAcc(int i) {
        this.floorAcc = i;
    }

    public void setLatitude(double d) {
        this.lat = d;
    }

    public void setLongitude(double d) {
        this.lon = d;
    }

    public void setSpeed(float f) {
        this.speed = f;
    }

    public void setTime(long j) {
        this.time = j;
    }

    public String toString() {
        return "Location{lat=" + this.lat + ", lon=" + this.lon + ", acc=" + this.acc + ", speed=" + this.speed + ", bearing=" + this.bearing + ", flags=" + ((int) this.flags) + ", time=" + this.time + ", buildingId='" + this.buildingId + "', floor=" + this.floor + ", floorAcc=" + this.floorAcc + ", extraInfo='" + this.extraInfo + "'}";
    }
}

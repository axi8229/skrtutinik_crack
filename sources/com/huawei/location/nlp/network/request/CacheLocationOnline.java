package com.huawei.location.nlp.network.request;

import com.huawei.location.nlp.network.response.Location;

/* loaded from: classes3.dex */
public class CacheLocationOnline extends Location {
    private float accFilter;
    private short flagsFilter;
    private double latFilter;
    private double lonFilter;

    public float getAccFilter() {
        return this.accFilter;
    }

    public short getFlagsFilter() {
        return this.flagsFilter;
    }

    public double getLatFilter() {
        return this.latFilter;
    }

    public double getLonFilter() {
        return this.lonFilter;
    }

    public void setAccFilter(float f) {
        this.accFilter = f;
    }

    public void setFlagsFilter(short s) {
        this.flagsFilter = s;
    }

    public void setLatFilter(double d) {
        this.latFilter = d;
    }

    public void setLonFilter(double d) {
        this.lonFilter = d;
    }

    @Override // com.huawei.location.nlp.network.response.Location
    public String toString() {
        return "CacheLocationOnline{" + super.toString() + "latFilter=" + this.latFilter + ", lonFilter=" + this.lonFilter + ", accFilter=" + this.accFilter + ", flagsFilter=" + ((int) this.flagsFilter) + '}';
    }
}

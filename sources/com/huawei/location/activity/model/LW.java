package com.huawei.location.activity.model;

import com.huawei.location.lite.common.log.LogLocation;

/* loaded from: classes3.dex */
public class LW implements Cloneable {
    private float FB;
    private float LW;
    private float Vw;
    private long yn;

    public LW() {
        this(0.0f, 0.0f, 0.0f);
    }

    public LW(float f, float f2, float f3) {
        this.Vw = f;
        this.FB = f2;
        this.LW = f3;
    }

    public float FB() {
        return this.FB;
    }

    public void FB(float f) {
        this.LW = f;
    }

    public float LW() {
        return this.LW;
    }

    public float Vw() {
        return this.Vw;
    }

    public void Vw(float f) {
        this.FB = f;
    }

    public Object clone() throws CloneNotSupportedException {
        LW lw = new LW(0.0f, 0.0f, 0.0f);
        try {
            return super.clone() instanceof LW ? (LW) super.clone() : lw;
        } catch (CloneNotSupportedException unused) {
            LogLocation.e("SensorRecord", "Clone Not Supported Exception");
            return lw;
        }
    }

    public String toString() {
        return "time: " + this.yn + " x:" + this.Vw + " y:" + this.FB + " z:" + this.LW;
    }

    public long yn() {
        return this.yn;
    }

    public void yn(float f) {
        this.Vw = f;
    }

    public void yn(long j) {
        this.yn = j;
    }
}

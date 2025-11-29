package com.group_ib.sdk;

import android.hardware.SensorEvent;

/* loaded from: classes3.dex */
public abstract class B extends k1 {
    public static final double h = Math.pow(10.0d, 4.0d);
    public final long c;
    public final int f;
    public final A[] g;
    public int a = 3;
    public int b = 0;
    public long d = 0;
    public float e = 0.0f;

    public B(int i, long j, A[] aArr) {
        this.f = i;
        this.c = j;
        this.g = aArr;
    }

    public static double a(double d) {
        return ((int) (d * r0)) / h;
    }

    public final String toString() {
        StringBuilder sb = new StringBuilder("type:");
        sb.append(this.f);
        sb.append(",num:");
        sb.append(this.b);
        sb.append(",mean_delay:");
        sb.append(this.e);
        sb.append(",data:[");
        for (A a : this.g) {
            sb.append('{');
            sb.append(a);
            sb.append("}");
        }
        sb.append("]");
        return sb.toString();
    }

    @Override // com.group_ib.sdk.k1
    public final int a() {
        return this.a;
    }

    @Override // com.group_ib.sdk.k1
    public void a(long j, float[] fArr) {
        if (fArr == null || j < this.c) {
            return;
        }
        for (int i = 0; i < fArr.length; i++) {
            this.g[i].a(fArr[i]);
        }
        int i2 = this.b;
        int i3 = i2 + 1;
        this.b = i3;
        if (i3 > 1) {
            this.e = ((this.e * (i2 - 1)) + (j - this.d)) / i2;
        }
        this.d = j;
        if (this.a == 1) {
            this.a = 2;
        }
    }

    @Override // com.group_ib.sdk.k1
    public final void a(SensorEvent sensorEvent) {
        float[] fArr;
        if (sensorEvent.sensor == null || (fArr = sensorEvent.values) == null) {
            return;
        }
        a(sensorEvent.timestamp, fArr);
    }
}

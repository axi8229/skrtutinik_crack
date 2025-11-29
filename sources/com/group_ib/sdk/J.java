package com.group_ib.sdk;

import android.hardware.SensorEvent;

/* loaded from: classes3.dex */
public final class J extends k1 {
    public H[] a = new H[(((int) 500) / 9) + 2];
    public final long c = 500000000;
    public int b = 0;

    @Override // com.group_ib.sdk.k1
    public final int a() {
        return 2;
    }

    @Override // com.group_ib.sdk.k1
    public final void a(long j, k1 k1Var) {
        int i = this.b;
        while (true) {
            int i2 = this.b;
            H[] hArr = this.a;
            if (i >= i2 + hArr.length) {
                return;
            }
            H h = hArr[i % hArr.length];
            if (h != null) {
                long j2 = h.a;
                if (j - j2 <= this.c) {
                    k1Var.a(j2, h.b);
                }
            }
            i++;
        }
    }

    @Override // com.group_ib.sdk.k1
    public final void a(long j, float[] fArr) {
        int i = this.b;
        H[] hArr = this.a;
        int length = i % hArr.length;
        H h = hArr[length];
        if (h != null && j - h.a < this.c) {
            H[] hArr2 = new H[hArr.length << 1];
            if (i != hArr.length) {
                System.arraycopy(hArr, i, hArr2, 0, hArr.length - i);
            }
            H[] hArr3 = this.a;
            int length2 = hArr3.length;
            int i2 = this.b;
            System.arraycopy(hArr3, 0, hArr2, length2 - i2, i2);
            int length3 = this.a.length;
            this.a = hArr2;
            length = length3;
        }
        this.b = length;
        H[] hArr4 = this.a;
        if (hArr4[length] == null) {
            hArr4[length] = new H();
        }
        this.b = length + 1;
        H h2 = hArr4[length];
        h2.a = j;
        float[] fArr2 = h2.b;
        if (fArr2 == null || fArr2.length != fArr.length) {
            h2.b = new float[fArr.length];
        }
        System.arraycopy(fArr, 0, h2.b, 0, fArr.length);
    }

    @Override // com.group_ib.sdk.k1
    public final void a(SensorEvent sensorEvent) {
        a(sensorEvent.timestamp, sensorEvent.values);
    }
}

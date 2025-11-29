package com.group_ib.sdk;

/* loaded from: classes3.dex */
public final class r extends B {
    public r(int i, long j) {
        super(i, j, new A[]{new A(), new A(), new A(), new A()});
    }

    @Override // com.group_ib.sdk.B, com.group_ib.sdk.k1
    public final void a(long j, float[] fArr) {
        if (j < this.c || fArr.length != 3) {
            return;
        }
        super.a(j, fArr);
        A a = this.g[3];
        float f = fArr[0];
        float f2 = fArr[1];
        float f3 = (f2 * f2) + (f * f);
        float f4 = fArr[2];
        a.a(Math.sqrt((f4 * f4) + f3));
    }
}

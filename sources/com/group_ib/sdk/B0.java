package com.group_ib.sdk;

/* loaded from: classes3.dex */
public abstract class B0 {
    public final MobileSdkService a;
    public final int b;
    public final long c;
    public long d;

    public B0(MobileSdkService mobileSdkService, int i, long j) {
        this.a = mobileSdkService;
        this.b = i;
        this.c = j;
        this.d = -j;
    }

    public abstract void a(b1 b1Var);

    public boolean a(int i) {
        return (i & this.b) != 0 && System.currentTimeMillis() > this.d + this.c;
    }
}

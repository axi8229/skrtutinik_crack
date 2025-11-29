package com.group_ib.sdk;

import android.os.SystemClock;

/* loaded from: classes3.dex */
public final class K0 extends B0 {
    public K0(MobileSdkService mobileSdkService) {
        super(mobileSdkService, 17, 0L);
    }

    @Override // com.group_ib.sdk.B0
    public final void a(b1 b1Var) {
        long jElapsedRealtimeNanos = SystemClock.elapsedRealtimeNanos();
        long jUptimeMillis = SystemClock.uptimeMillis();
        long jCurrentTimeMillis = System.currentTimeMillis();
        b1Var.put("UptimeMillis", new a1(String.valueOf(jUptimeMillis)));
        b1Var.put("RealtimeElapsedNanos", new a1(String.valueOf(jElapsedRealtimeNanos)));
        b1Var.put("TimestampMillis", new a1(String.valueOf(jCurrentTimeMillis)));
    }
}

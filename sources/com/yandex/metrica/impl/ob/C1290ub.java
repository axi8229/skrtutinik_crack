package com.yandex.metrica.impl.ob;

import android.text.TextUtils;

/* renamed from: com.yandex.metrica.impl.ob.ub, reason: case insensitive filesystem */
/* loaded from: classes3.dex */
public class C1290ub {
    public final C1266tb a;
    public final U0 b;
    public final String c;

    public C1290ub() {
        this(null, U0.UNKNOWN, "identifier info has never been updated");
    }

    public boolean a() {
        C1266tb c1266tb = this.a;
        return (c1266tb == null || TextUtils.isEmpty(c1266tb.b)) ? false : true;
    }

    public String toString() {
        return "AdTrackingInfoResult{mAdTrackingInfo=" + this.a + ", mStatus=" + this.b + ", mErrorExplanation='" + this.c + "'}";
    }

    public C1290ub(C1266tb c1266tb, U0 u0, String str) {
        this.a = c1266tb;
        this.b = u0;
        this.c = str;
    }
}

package com.yandex.metrica.impl.ob;

import java.util.List;

/* renamed from: com.yandex.metrica.impl.ob.eh, reason: case insensitive filesystem */
/* loaded from: classes3.dex */
public class C0903eh {
    public final List<C0978hh> a;
    public final String b;
    public final long c;
    public final boolean d;
    public final boolean e;

    public C0903eh(List<C0978hh> list, String str, long j, boolean z, boolean z2) {
        this.a = A2.c(list);
        this.b = str;
        this.c = j;
        this.d = z;
        this.e = z2;
    }

    public String toString() {
        return "SdkFingerprintingState{sdkItemList=" + this.a + ", etag='" + this.b + "', lastAttemptTime=" + this.c + ", hasFirstCollectionOccurred=" + this.d + ", shouldRetry=" + this.e + '}';
    }
}

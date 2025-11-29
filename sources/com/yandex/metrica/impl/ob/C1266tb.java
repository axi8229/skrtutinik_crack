package com.yandex.metrica.impl.ob;

/* renamed from: com.yandex.metrica.impl.ob.tb, reason: case insensitive filesystem */
/* loaded from: classes3.dex */
public class C1266tb {
    public final a a;
    public final String b;
    public final Boolean c;

    /* renamed from: com.yandex.metrica.impl.ob.tb$a */
    public enum a {
        GOOGLE,
        HMS,
        YANDEX
    }

    public C1266tb(a aVar, String str, Boolean bool) {
        this.a = aVar;
        this.b = str;
        this.c = bool;
    }

    public String toString() {
        return "AdTrackingInfo{provider=" + this.a + ", advId='" + this.b + "', limitedAdTracking=" + this.c + '}';
    }
}

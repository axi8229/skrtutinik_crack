package com.yandex.metrica.impl.ob;

import java.util.Map;

/* renamed from: com.yandex.metrica.impl.ob.n0, reason: case insensitive filesystem */
/* loaded from: classes3.dex */
public class C1110n0 {
    public final Map<String, String> a;
    public final String b;
    public final String c;

    public C1110n0(String str, Map<String, String> map, String str2) {
        this.b = str;
        this.a = map;
        this.c = str2;
    }

    public String toString() {
        return "DeferredDeeplinkState{mParameters=" + this.a + ", mDeeplink='" + this.b + "', mUnparsedReferrer='" + this.c + "'}";
    }
}

package com.yandex.metrica.impl.ob;

import java.util.Map;

@Deprecated
/* loaded from: classes3.dex */
public class Z1 {
    public final Map<String, String> a;
    public final boolean b;

    public Z1(Map<String, String> map, boolean z) {
        this.a = map;
        this.b = z;
    }

    public String toString() {
        return "SatelliteClidsInfo{clids=" + this.a + ", checked=" + this.b + '}';
    }
}

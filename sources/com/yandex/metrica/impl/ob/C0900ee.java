package com.yandex.metrica.impl.ob;

import org.json.JSONObject;

/* renamed from: com.yandex.metrica.impl.ob.ee, reason: case insensitive filesystem */
/* loaded from: classes3.dex */
public class C0900ee implements InterfaceC1303v0 {
    public final String a;
    public final JSONObject b;
    public final boolean c;
    public final boolean d;
    public final EnumC1279u0 e;

    public C0900ee(String str, JSONObject jSONObject, boolean z, boolean z2, EnumC1279u0 enumC1279u0) {
        this.a = str;
        this.b = jSONObject;
        this.c = z;
        this.d = z2;
        this.e = enumC1279u0;
    }

    @Override // com.yandex.metrica.impl.ob.InterfaceC1303v0
    public EnumC1279u0 a() {
        return this.e;
    }

    public String toString() {
        return "PreloadInfoState{trackingId='" + this.a + "', additionalParameters=" + this.b + ", wasSet=" + this.c + ", autoTrackingEnabled=" + this.d + ", source=" + this.e + '}';
    }
}

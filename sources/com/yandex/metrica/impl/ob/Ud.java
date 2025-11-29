package com.yandex.metrica.impl.ob;

import java.util.List;
import org.json.JSONObject;

/* loaded from: classes3.dex */
public class Ud implements InterfaceC1231s0<a, C0900ee> {
    public final C0900ee a;
    public final List<a> b;

    public static class a {
        public final String a;
        public final JSONObject b;
        public final EnumC1279u0 c;

        public a(String str, JSONObject jSONObject, EnumC1279u0 enumC1279u0) {
            this.a = str;
            this.b = jSONObject;
            this.c = enumC1279u0;
        }

        public String toString() {
            return "Candidate{trackingId='" + this.a + "', additionalParams=" + this.b + ", source=" + this.c + '}';
        }
    }

    public Ud(C0900ee c0900ee, List<a> list) {
        this.a = c0900ee;
        this.b = list;
    }

    @Override // com.yandex.metrica.impl.ob.InterfaceC1231s0
    public List<a> a() {
        return this.b;
    }

    @Override // com.yandex.metrica.impl.ob.InterfaceC1231s0
    public C0900ee b() {
        return this.a;
    }

    public String toString() {
        return "PreloadInfoData{chosenPreloadInfo=" + this.a + ", candidates=" + this.b + '}';
    }
}

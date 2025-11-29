package com.yandex.metrica.impl.ob;

import java.util.List;
import java.util.Map;
import kotlin.jvm.internal.Intrinsics;

/* renamed from: com.yandex.metrica.impl.ob.v3, reason: case insensitive filesystem */
/* loaded from: classes3.dex */
public final class C1306v3 implements InterfaceC1231s0<a, a> {
    private final a a;
    private final List<a> b;

    /* renamed from: com.yandex.metrica.impl.ob.v3$a */
    public static final class a implements InterfaceC1303v0 {
        private final Map<String, String> a;
        private final EnumC1279u0 b;

        public a(Map<String, String> map, EnumC1279u0 enumC1279u0) {
            this.a = map;
            this.b = enumC1279u0;
        }

        @Override // com.yandex.metrica.impl.ob.InterfaceC1303v0
        public EnumC1279u0 a() {
            return this.b;
        }

        public final Map<String, String> b() {
            return this.a;
        }

        public boolean equals(Object obj) {
            if (this == obj) {
                return true;
            }
            if (!(obj instanceof a)) {
                return false;
            }
            a aVar = (a) obj;
            return Intrinsics.areEqual(this.a, aVar.a) && Intrinsics.areEqual(this.b, aVar.b);
        }

        public int hashCode() {
            Map<String, String> map = this.a;
            int iHashCode = (map != null ? map.hashCode() : 0) * 31;
            EnumC1279u0 enumC1279u0 = this.b;
            return iHashCode + (enumC1279u0 != null ? enumC1279u0.hashCode() : 0);
        }

        public String toString() {
            return "Candidate(clids=" + this.a + ", source=" + this.b + ")";
        }
    }

    public C1306v3(a aVar, List<a> list) {
        this.a = aVar;
        this.b = list;
    }

    @Override // com.yandex.metrica.impl.ob.InterfaceC1231s0
    public List<a> a() {
        return this.b;
    }

    @Override // com.yandex.metrica.impl.ob.InterfaceC1231s0
    public a b() {
        return this.a;
    }

    public a c() {
        return this.a;
    }

    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (!(obj instanceof C1306v3)) {
            return false;
        }
        C1306v3 c1306v3 = (C1306v3) obj;
        return Intrinsics.areEqual(this.a, c1306v3.a) && Intrinsics.areEqual(this.b, c1306v3.b);
    }

    public int hashCode() {
        a aVar = this.a;
        int iHashCode = (aVar != null ? aVar.hashCode() : 0) * 31;
        List<a> list = this.b;
        return iHashCode + (list != null ? list.hashCode() : 0);
    }

    public String toString() {
        return "ClidsInfo(chosen=" + this.a + ", candidates=" + this.b + ")";
    }
}

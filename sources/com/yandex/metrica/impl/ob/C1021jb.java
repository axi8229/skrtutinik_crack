package com.yandex.metrica.impl.ob;

import com.huawei.updatesdk.service.otaupdate.UpdateKey;
import java.util.Map;
import kotlin.TuplesKt;
import kotlin.collections.MapsKt;
import kotlin.jvm.internal.Intrinsics;

/* renamed from: com.yandex.metrica.impl.ob.jb, reason: case insensitive filesystem */
/* loaded from: classes3.dex */
public final class C1021jb {
    private final M0 a;

    /* renamed from: com.yandex.metrica.impl.ob.jb$a */
    public static final class a {
        private final boolean a;
        private final int b;
        private final int c;
        private final String d;

        public a() {
            this(false, 0, 0, null, 15);
        }

        public a(boolean z, int i, int i2, String str) {
            this.a = z;
            this.b = i;
            this.c = i2;
            this.d = str;
        }

        public final String a() {
            return this.d;
        }

        public final int b() {
            return this.b;
        }

        public final int c() {
            return this.c;
        }

        public final boolean d() {
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
            return this.a == aVar.a && this.b == aVar.b && this.c == aVar.c && Intrinsics.areEqual(this.d, aVar.d);
        }

        /* JADX WARN: Multi-variable type inference failed */
        /* JADX WARN: Type inference failed for: r0v1, types: [int] */
        /* JADX WARN: Type inference failed for: r0v8 */
        /* JADX WARN: Type inference failed for: r0v9 */
        public int hashCode() {
            boolean z = this.a;
            ?? r0 = z;
            if (z) {
                r0 = 1;
            }
            int i = ((((r0 * 31) + this.b) * 31) + this.c) * 31;
            String str = this.d;
            return i + (str != null ? str.hashCode() : 0);
        }

        public String toString() {
            return "RequestReport(success=" + this.a + ", httpStatus=" + this.b + ", size=" + this.c + ", failureReason=" + this.d + ")";
        }

        public /* synthetic */ a(boolean z, int i, int i2, String str, int i3) {
            this((i3 & 1) != 0 ? false : z, (i3 & 2) != 0 ? 0 : i, (i3 & 4) != 0 ? 0 : i2, null);
        }
    }

    public C1021jb(Uh uh, M0 m0) {
        this.a = uh.e() ? m0 : null;
    }

    public final void a(a aVar) {
        M0 m0 = this.a;
        if (m0 != null) {
            Map mapMutableMapOf = MapsKt.mutableMapOf(TuplesKt.to(UpdateKey.STATUS, aVar.d() ? "OK" : "FAILED"), TuplesKt.to("http_status", Integer.valueOf(aVar.b())), TuplesKt.to("size", Integer.valueOf(aVar.c())));
            String strA = aVar.a();
            if (strA != null) {
                mapMutableMapOf.put("reason", strA);
            }
            m0.reportEvent("egress_status", MapsKt.toMap(mapMutableMapOf));
        }
    }
}

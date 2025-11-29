package com.yandex.metrica.impl.ob;

import android.annotation.SuppressLint;
import android.content.Context;
import android.util.SparseArray;

@SuppressLint({"NewApi"})
/* renamed from: com.yandex.metrica.impl.ob.wj, reason: case insensitive filesystem */
/* loaded from: classes3.dex */
public class C1346wj implements Yj<C1298uj> {

    @SuppressLint({"InlineApi"})
    private static final SparseArray<String> d = new a();
    private final Ij a;
    private final InterfaceC1412zd b;
    private final InterfaceC1412zd c;

    /* renamed from: com.yandex.metrica.impl.ob.wj$a */
    class a extends SparseArray<String> {
        a() {
            put(0, null);
            put(7, "1xRTT");
            put(4, "CDMA");
            put(2, "EDGE");
            put(14, "eHRPD");
            put(5, "EVDO rev.0");
            put(6, "EVDO rev.A");
            put(12, "EVDO rev.B");
            put(1, "GPRS");
            put(8, "HSDPA");
            put(10, "HSPA");
            put(15, "HSPA+");
            put(9, "HSUPA");
            put(11, "iDen");
            put(3, "UMTS");
            put(12, "EVDO rev.B");
            put(14, "eHRPD");
            put(13, "LTE");
            put(15, "HSPA+");
        }
    }

    /* renamed from: com.yandex.metrica.impl.ob.wj$b */
    class b implements InterfaceC1412zd {
        final /* synthetic */ C1388yd a;

        b(C1346wj c1346wj, C1388yd c1388yd) {
            this.a = c1388yd;
        }

        @Override // com.yandex.metrica.impl.ob.InterfaceC1412zd
        public boolean a(Context context) {
            this.a.getClass();
            return false;
        }
    }

    /* renamed from: com.yandex.metrica.impl.ob.wj$c */
    class c implements InterfaceC1412zd {
        final /* synthetic */ C1388yd a;

        c(C1346wj c1346wj, C1388yd c1388yd) {
            this.a = c1388yd;
        }

        @Override // com.yandex.metrica.impl.ob.InterfaceC1412zd
        public boolean a(Context context) {
            return this.a.b(context);
        }
    }

    /* renamed from: com.yandex.metrica.impl.ob.wj$d */
    class d implements InterfaceC1412zd {
        final /* synthetic */ C1388yd a;

        d(C1346wj c1346wj, C1388yd c1388yd) {
            this.a = c1388yd;
        }

        @Override // com.yandex.metrica.impl.ob.InterfaceC1412zd
        public boolean a(Context context) {
            return this.a.a(context);
        }
    }

    /* renamed from: com.yandex.metrica.impl.ob.wj$e */
    class e implements InterfaceC1412zd {
        e(C1346wj c1346wj) {
        }

        @Override // com.yandex.metrica.impl.ob.InterfaceC1412zd
        public boolean a(Context context) {
            return true;
        }
    }

    public C1346wj(Ij ij, C1388yd c1388yd) {
        this.a = ij;
        if (A2.a(29)) {
            this.b = new b(this, c1388yd);
            this.c = new c(this, c1388yd);
        } else {
            this.b = new d(this, c1388yd);
            this.c = new e(this);
        }
    }

    /* JADX WARN: Removed duplicated region for block: B:15:0x003d  */
    /* JADX WARN: Removed duplicated region for block: B:26:0x006b  */
    /* JADX WARN: Removed duplicated region for block: B:37:0x0097  */
    /* JADX WARN: Removed duplicated region for block: B:49:0x00cb  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    public java.lang.Object b() {
        /*
            Method dump skipped, instructions count: 289
            To view this dump change 'Code comments level' option to 'DEBUG'
        */
        throw new UnsupportedOperationException("Method not decompiled: com.yandex.metrica.impl.ob.C1346wj.b():java.lang.Object");
    }
}

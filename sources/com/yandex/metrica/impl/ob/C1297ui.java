package com.yandex.metrica.impl.ob;

/* renamed from: com.yandex.metrica.impl.ob.ui, reason: case insensitive filesystem */
/* loaded from: classes3.dex */
public class C1297ui {
    public final a a;
    public final a b;

    /* renamed from: com.yandex.metrica.impl.ob.ui$a */
    public static class a {
        public final int a;
        public final long b;

        public a(int i, long j) {
            this.a = i;
            this.b = j;
        }

        public String toString() {
            return "Item{refreshEventCount=" + this.a + ", refreshPeriodSeconds=" + this.b + '}';
        }
    }

    /* renamed from: com.yandex.metrica.impl.ob.ui$b */
    public enum b {
        WIFI,
        CELL
    }

    public C1297ui(a aVar, a aVar2) {
        this.a = aVar;
        this.b = aVar2;
    }

    public String toString() {
        return "ThrottlingConfig{cell=" + this.a + ", wifi=" + this.b + '}';
    }
}

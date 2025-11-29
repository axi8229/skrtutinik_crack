package com.yandex.metrica.impl.ob;

/* renamed from: com.yandex.metrica.impl.ob.ud, reason: case insensitive filesystem */
/* loaded from: classes3.dex */
public class C1292ud implements InterfaceC1340wd {
    private final InterfaceC1340wd a;
    private final InterfaceC1340wd b;

    /* renamed from: com.yandex.metrica.impl.ob.ud$a */
    public static class a {
        private InterfaceC1340wd a;
        private InterfaceC1340wd b;

        public a(InterfaceC1340wd interfaceC1340wd, InterfaceC1340wd interfaceC1340wd2) {
            this.a = interfaceC1340wd;
            this.b = interfaceC1340wd2;
        }

        public a a(C1178pi c1178pi) {
            this.b = new Fd(c1178pi.E());
            return this;
        }

        public a a(boolean z) {
            this.a = new C1364xd(z);
            return this;
        }

        public C1292ud a() {
            return new C1292ud(this.a, this.b);
        }
    }

    C1292ud(InterfaceC1340wd interfaceC1340wd, InterfaceC1340wd interfaceC1340wd2) {
        this.a = interfaceC1340wd;
        this.b = interfaceC1340wd2;
    }

    public static a b() {
        return new a(new C1364xd(false), new Fd(null));
    }

    @Override // com.yandex.metrica.impl.ob.InterfaceC1340wd
    public boolean a(String str) {
        return this.b.a(str) && this.a.a(str);
    }

    public String toString() {
        return "AskForPermissionsStrategy{mLocationFlagStrategy=" + this.a + ", mStartupStateStrategy=" + this.b + '}';
    }

    public a a() {
        return new a(this.a, this.b);
    }
}

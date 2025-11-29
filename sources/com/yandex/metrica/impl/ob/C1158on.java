package com.yandex.metrica.impl.ob;

/* renamed from: com.yandex.metrica.impl.ob.on, reason: case insensitive filesystem */
/* loaded from: classes3.dex */
public class C1158on extends tn<C1298uj> {

    /* renamed from: com.yandex.metrica.impl.ob.on$a */
    public static class a implements un<C1298uj> {
        @Override // com.yandex.metrica.impl.ob.un
        public tn a(C1298uj c1298uj) {
            return new C1158on(c1298uj);
        }
    }

    public C1158on(C1298uj c1298uj) {
        super(c1298uj);
    }

    /* JADX WARN: Multi-variable type inference failed */
    @Override // com.yandex.metrica.impl.ob.tn
    public boolean a(tn<C1298uj> tnVar) {
        C1298uj c1298uj = tnVar.a;
        T t = this.a;
        if (t == c1298uj) {
            return true;
        }
        if (((C1298uj) t).c() != c1298uj.c()) {
            return false;
        }
        if (((C1298uj) this.a).k() == null ? c1298uj.k() != null : !((C1298uj) this.a).k().equals(c1298uj.k())) {
            return false;
        }
        if (((C1298uj) this.a).l() == null ? c1298uj.l() != null : !((C1298uj) this.a).l().equals(c1298uj.l())) {
            return false;
        }
        if (((C1298uj) this.a).e() == null ? c1298uj.e() != null : !((C1298uj) this.a).e().equals(c1298uj.e())) {
            return false;
        }
        if (((C1298uj) this.a).b() == null ? c1298uj.b() != null : !((C1298uj) this.a).b().equals(c1298uj.b())) {
            return false;
        }
        if (((C1298uj) this.a).m() == null ? c1298uj.m() == null : ((C1298uj) this.a).m().equals(c1298uj.m())) {
            return ((C1298uj) this.a).o() != null ? ((C1298uj) this.a).o().equals(c1298uj.o()) : c1298uj.o() == null;
        }
        return false;
    }

    /* JADX WARN: Multi-variable type inference failed */
    public int hashCode() {
        return ((((((((((((((C1298uj) this.a).k() != null ? ((C1298uj) this.a).k().hashCode() : 0) * 31) + (((C1298uj) this.a).l() != null ? ((C1298uj) this.a).l().hashCode() : 0)) * 31) + (((C1298uj) this.a).e() != null ? ((C1298uj) this.a).e().hashCode() : 0)) * 31) + (((C1298uj) this.a).b() != null ? ((C1298uj) this.a).b().hashCode() : 0)) * 31) + (((C1298uj) this.a).m() != null ? ((C1298uj) this.a).m().hashCode() : 0)) * 31) + ((C1298uj) this.a).c()) * 31) + (((C1298uj) this.a).o() != null ? ((C1298uj) this.a).o().hashCode() : 0);
    }
}

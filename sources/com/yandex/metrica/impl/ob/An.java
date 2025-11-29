package com.yandex.metrica.impl.ob;

/* loaded from: classes3.dex */
class An extends tn<F2> {
    An(Bn bn, F2 f2) {
        super(f2);
    }

    /* JADX WARN: Multi-variable type inference failed */
    @Override // com.yandex.metrica.impl.ob.tn
    protected boolean a(tn<F2> tnVar) {
        String str = ((F2) this.a).a;
        if (str == null ? tnVar.a.a != null : !str.equals(tnVar.a.a)) {
            return false;
        }
        String str2 = ((F2) this.a).b;
        return str2 != null ? str2.equals(tnVar.a.b) : tnVar.a.b == null;
    }

    /* JADX WARN: Multi-variable type inference failed */
    public int hashCode() {
        String str = ((F2) this.a).a;
        int iHashCode = (str != null ? str.hashCode() : 0) * 31;
        String str2 = ((F2) this.a).b;
        return iHashCode + (str2 != null ? str2.hashCode() : 0);
    }
}

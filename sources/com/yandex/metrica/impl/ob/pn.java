package com.yandex.metrica.impl.ob;

import java.util.Comparator;

/* loaded from: classes3.dex */
public class pn implements Comparator<C1298uj> {
    @Override // java.util.Comparator
    public int compare(C1298uj c1298uj, C1298uj c1298uj2) {
        C1298uj c1298uj3 = c1298uj;
        C1298uj c1298uj4 = c1298uj2;
        if (c1298uj3 == c1298uj4) {
            return 0;
        }
        if (!((c1298uj4 == null) ^ (c1298uj3 == null)) && c1298uj3.q() == c1298uj4.q() && c1298uj3.c() == c1298uj4.c() && (c1298uj3.k() == null ? c1298uj4.k() == null : c1298uj3.k().equals(c1298uj4.k())) && (c1298uj3.l() == null ? c1298uj4.l() == null : c1298uj3.l().equals(c1298uj4.l())) && (c1298uj3.e() == null ? c1298uj4.e() == null : c1298uj3.e().equals(c1298uj4.e())) && (c1298uj3.b() == null ? c1298uj4.b() == null : c1298uj3.b().equals(c1298uj4.b())) && (c1298uj3.n() == null ? c1298uj4.n() == null : c1298uj3.n().equals(c1298uj4.n())) && (c1298uj3.m() == null ? c1298uj4.m() == null : c1298uj3.m().equals(c1298uj4.m()))) {
            if (c1298uj3.o() != null) {
                if (c1298uj3.o().equals(c1298uj4.o())) {
                    return 0;
                }
            } else if (c1298uj4.o() == null) {
                return 0;
            }
        }
        return 10;
    }
}

package com.yandex.metrica.impl.ob;

import com.google.protobuf.nano.ym.MessageNano;
import com.yandex.metrica.impl.ob.C1294uf;
import java.util.Currency;
import java.util.concurrent.TimeUnit;

/* renamed from: com.yandex.metrica.impl.ob.h3, reason: case insensitive filesystem */
/* loaded from: classes3.dex */
public class C0964h3 {
    private final com.yandex.metrica.billing_interface.d a;

    public C0964h3(com.yandex.metrica.billing_interface.d dVar) {
        this.a = dVar;
    }

    public byte[] a() {
        String currencyCode;
        com.yandex.metrica.billing_interface.d dVar = this.a;
        C1294uf c1294uf = new C1294uf();
        c1294uf.a = dVar.c;
        c1294uf.g = dVar.d;
        try {
            currencyCode = Currency.getInstance(dVar.e).getCurrencyCode();
        } catch (Throwable unused) {
            currencyCode = "";
        }
        c1294uf.c = currencyCode.getBytes();
        c1294uf.d = dVar.b.getBytes();
        C1294uf.a aVar = new C1294uf.a();
        aVar.a = dVar.n.getBytes();
        aVar.b = dVar.j.getBytes();
        c1294uf.f = aVar;
        c1294uf.h = true;
        c1294uf.i = 1;
        c1294uf.j = dVar.a.ordinal() == 1 ? 2 : 1;
        C1294uf.c cVar = new C1294uf.c();
        cVar.a = dVar.k.getBytes();
        cVar.b = TimeUnit.MILLISECONDS.toSeconds(dVar.l);
        c1294uf.k = cVar;
        if (dVar.a == com.yandex.metrica.billing_interface.e.SUBS) {
            C1294uf.b bVar = new C1294uf.b();
            bVar.a = dVar.m;
            com.yandex.metrica.billing_interface.c cVar2 = dVar.i;
            if (cVar2 != null) {
                bVar.b = a(cVar2);
            }
            C1294uf.b.a aVar2 = new C1294uf.b.a();
            aVar2.a = dVar.f;
            com.yandex.metrica.billing_interface.c cVar3 = dVar.g;
            if (cVar3 != null) {
                aVar2.b = a(cVar3);
            }
            aVar2.c = dVar.h;
            bVar.c = aVar2;
            c1294uf.l = bVar;
        }
        return MessageNano.toByteArray(c1294uf);
    }

    private C1294uf.b.C0295b a(com.yandex.metrica.billing_interface.c cVar) {
        C1294uf.b.C0295b c0295b = new C1294uf.b.C0295b();
        c0295b.a = cVar.a;
        int iOrdinal = cVar.b.ordinal();
        int i = 1;
        if (iOrdinal != 1) {
            i = 2;
            if (iOrdinal != 2) {
                i = 3;
                if (iOrdinal != 3) {
                    i = 4;
                    if (iOrdinal != 4) {
                        i = 0;
                    }
                }
            }
        }
        c0295b.b = i;
        return c0295b;
    }
}

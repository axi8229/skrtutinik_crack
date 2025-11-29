package com.yandex.metrica.impl.ob;

import android.util.Pair;
import com.google.protobuf.nano.ym.MessageNano;
import com.yandex.metrica.Revenue;
import com.yandex.metrica.impl.ob.C1294uf;

/* loaded from: classes3.dex */
class W1 {
    private final Revenue a;
    private final InterfaceC0934fn<String> b;
    private final InterfaceC0934fn<String> c;
    private final InterfaceC0934fn<String> d;
    private final C0858cm e;

    W1(Revenue revenue, C0858cm c0858cm) {
        this.e = c0858cm;
        this.a = revenue;
        this.b = new C0859cn(30720, "revenue payload", c0858cm);
        this.c = new C0909en(new C0859cn(184320, "receipt data", c0858cm), "<truncated data was not sent, see METRIKALIB-4568>");
        this.d = new C0909en(new C0884dn(1000, "receipt signature", c0858cm), "<truncated data was not sent, see METRIKALIB-4568>");
    }

    Pair<byte[], Integer> a() {
        C1294uf c1294uf = new C1294uf();
        c1294uf.c = this.a.currency.getCurrencyCode().getBytes();
        if (A2.a(this.a.price)) {
            c1294uf.b = this.a.price.doubleValue();
        }
        if (A2.a(this.a.priceMicros)) {
            c1294uf.g = this.a.priceMicros.longValue();
        }
        c1294uf.d = C0810b.e(new C0884dn(200, "revenue productID", this.e).a(this.a.productID));
        Integer num = this.a.quantity;
        if (num == null) {
            num = 1;
        }
        c1294uf.a = num.intValue();
        c1294uf.e = C0810b.e(this.b.a(this.a.payload));
        if (A2.a(this.a.receipt)) {
            C1294uf.a aVar = new C1294uf.a();
            String strA = this.c.a(this.a.receipt.data);
            length = C0810b.b(this.a.receipt.data, strA) ? this.a.receipt.data.length() : 0;
            String strA2 = this.d.a(this.a.receipt.signature);
            aVar.a = C0810b.e(strA);
            aVar.b = C0810b.e(strA2);
            c1294uf.f = aVar;
        }
        return new Pair<>(MessageNano.toByteArray(c1294uf), Integer.valueOf(length));
    }
}

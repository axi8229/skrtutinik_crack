package com.yandex.metrica.impl.ob;

import com.yandex.metrica.Revenue;
import java.util.Arrays;
import java.util.List;

/* loaded from: classes3.dex */
public class On implements Kn<Revenue> {
    private final Kn<List<In>> a = new Jn();

    @Override // com.yandex.metrica.impl.ob.Kn
    public In a(Revenue revenue) {
        return this.a.a(Arrays.asList(new Nn().a(revenue.quantity)));
    }
}

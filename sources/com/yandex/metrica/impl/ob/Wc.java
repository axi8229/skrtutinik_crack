package com.yandex.metrica.impl.ob;

import java.util.List;

/* loaded from: classes3.dex */
public class Wc extends V {
    private final I2 b;

    public Wc(V v, I2 i2) {
        super(null);
        this.b = i2;
    }

    @Override // com.yandex.metrica.impl.ob.V
    public void b(Object obj) {
        List list = (List) obj;
        if (list != null) {
            this.b.b((I2) list);
        }
    }
}

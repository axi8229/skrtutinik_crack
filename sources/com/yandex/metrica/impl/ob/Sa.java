package com.yandex.metrica.impl.ob;

import com.yandex.metrica.ecommerce.ECommerceAmount;
import java.math.BigDecimal;

/* loaded from: classes3.dex */
public class Sa {
    public final BigDecimal a;
    public final String b;

    public Sa(ECommerceAmount eCommerceAmount) {
        this(eCommerceAmount.getAmount(), eCommerceAmount.getUnit());
    }

    public String toString() {
        return "AmountWrapper{amount=" + this.a + ", unit='" + this.b + "'}";
    }

    public Sa(BigDecimal bigDecimal, String str) {
        this.a = bigDecimal;
        this.b = str;
    }
}

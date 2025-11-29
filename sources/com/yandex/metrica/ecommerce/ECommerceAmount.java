package com.yandex.metrica.ecommerce;

import com.yandex.metrica.impl.ob.A2;
import com.yandex.varioqub.config.model.ConfigValue;
import java.math.BigDecimal;

/* loaded from: classes3.dex */
public class ECommerceAmount {
    private final BigDecimal a;
    private final String b;

    public ECommerceAmount(long j, String str) {
        this(A2.a(j), str);
    }

    public BigDecimal getAmount() {
        return this.a;
    }

    public String getUnit() {
        return this.b;
    }

    public String toString() {
        return "ECommerceAmount{amount=" + this.a + ", unit='" + this.b + "'}";
    }

    public ECommerceAmount(double d, String str) {
        this(new BigDecimal(A2.a(d, ConfigValue.DOUBLE_DEFAULT_VALUE)), str);
    }

    public ECommerceAmount(BigDecimal bigDecimal, String str) {
        this.a = bigDecimal;
        this.b = str;
    }
}

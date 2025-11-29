package com.yandex.metrica;

import com.yandex.metrica.impl.ob.A2;
import com.yandex.varioqub.config.model.ConfigValue;
import java.math.BigDecimal;
import java.util.Currency;
import java.util.HashMap;
import java.util.Map;

/* loaded from: classes3.dex */
public class AdRevenue {
    public final String adNetwork;
    public final String adPlacementId;
    public final String adPlacementName;
    public final BigDecimal adRevenue;
    public final AdType adType;
    public final String adUnitId;
    public final String adUnitName;
    public final Currency currency;
    public final Map<String, String> payload;
    public final String precision;

    public static class Builder {
        private final BigDecimal a;
        private final Currency b;
        private AdType c;
        private String d;
        private String e;
        private String f;
        private String g;
        private String h;
        private String i;
        private Map<String, String> j;

        public AdRevenue build() {
            return new AdRevenue(this.a, this.b, this.c, this.d, this.e, this.f, this.g, this.h, this.i, this.j);
        }

        public Builder withAdNetwork(String str) {
            this.d = str;
            return this;
        }

        public Builder withAdPlacementId(String str) {
            this.g = str;
            return this;
        }

        public Builder withAdPlacementName(String str) {
            this.h = str;
            return this;
        }

        public Builder withAdType(AdType adType) {
            this.c = adType;
            return this;
        }

        public Builder withAdUnitId(String str) {
            this.e = str;
            return this;
        }

        public Builder withAdUnitName(String str) {
            this.f = str;
            return this;
        }

        public Builder withPayload(Map<String, String> map) {
            this.j = (map == null || A2.b(map)) ? null : new HashMap(map);
            return this;
        }

        public Builder withPrecision(String str) {
            this.i = str;
            return this;
        }

        private Builder(BigDecimal bigDecimal, Currency currency) {
            this.a = bigDecimal;
            this.b = currency;
        }
    }

    public static Builder newBuilder(BigDecimal bigDecimal, Currency currency) {
        return new Builder(bigDecimal, currency);
    }

    private AdRevenue(BigDecimal bigDecimal, Currency currency, AdType adType, String str, String str2, String str3, String str4, String str5, String str6, Map<String, String> map) {
        this.adRevenue = bigDecimal;
        this.currency = currency;
        this.adType = adType;
        this.adNetwork = str;
        this.adUnitId = str2;
        this.adUnitName = str3;
        this.adPlacementId = str4;
        this.adPlacementName = str5;
        this.precision = str6;
        this.payload = map == null ? null : A2.d(map);
    }

    public static Builder newBuilder(long j, Currency currency) {
        return new Builder(A2.a(j), currency);
    }

    public static Builder newBuilder(double d, Currency currency) {
        return new Builder(new BigDecimal(A2.a(d, ConfigValue.DOUBLE_DEFAULT_VALUE)), currency);
    }
}

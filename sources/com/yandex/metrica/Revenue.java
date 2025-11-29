package com.yandex.metrica;

import com.yandex.metrica.impl.ob.Gn;
import com.yandex.metrica.impl.ob.Hn;
import com.yandex.metrica.impl.ob.Kn;
import java.util.Currency;

/* loaded from: classes3.dex */
public class Revenue {
    public final Currency currency;
    public final String payload;

    @Deprecated
    public final Double price;
    public final Long priceMicros;
    public final String productID;
    public final Integer quantity;
    public final Receipt receipt;

    public static class Receipt {
        public final String data;
        public final String signature;

        public static class Builder {
            private String a;
            private String b;

            Builder() {
            }

            public Receipt build() {
                return new Receipt(this);
            }

            public Builder withData(String str) {
                this.a = str;
                return this;
            }

            public Builder withSignature(String str) {
                this.b = str;
                return this;
            }
        }

        public static Builder newBuilder() {
            return new Builder();
        }

        private Receipt(Builder builder) {
            this.data = builder.a;
            this.signature = builder.b;
        }
    }

    @Deprecated
    public static Builder newBuilder(double d, Currency currency) {
        return new Builder(d, currency);
    }

    public static Builder newBuilderWithMicros(long j, Currency currency) {
        return new Builder(j, currency);
    }

    private Revenue(Builder builder) {
        this.price = builder.a;
        this.priceMicros = builder.b;
        this.currency = builder.c;
        this.quantity = builder.d;
        this.productID = builder.e;
        this.payload = builder.f;
        this.receipt = builder.g;
    }

    public static class Builder {
        private static final Kn<Currency> h = new Hn(new Gn("revenue currency"));
        Double a;
        Long b;
        Currency c;
        Integer d;
        String e;
        String f;
        Receipt g;

        Builder(double d, Currency currency) {
            ((Hn) h).a(currency);
            this.a = Double.valueOf(d);
            this.c = currency;
        }

        public Revenue build() {
            return new Revenue(this);
        }

        public Builder withPayload(String str) {
            this.f = str;
            return this;
        }

        public Builder withProductID(String str) {
            this.e = str;
            return this;
        }

        public Builder withQuantity(Integer num) {
            this.d = num;
            return this;
        }

        public Builder withReceipt(Receipt receipt) {
            this.g = receipt;
            return this;
        }

        Builder(long j, Currency currency) {
            ((Hn) h).a(currency);
            this.b = Long.valueOf(j);
            this.c = currency;
        }
    }
}

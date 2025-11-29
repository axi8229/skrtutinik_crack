package ru.yoomoney.sdk.kassa.payments.api.model.packageoptions;

import androidx.annotation.Keep;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.google.android.gms.measurement.api.AppMeasurementSdk;
import java.util.Currency;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

@Metadata(d1 = {"\u0000(\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0018\u0002\n\u0002\b\t\n\u0002\u0010\u000b\n\u0002\b\u0002\n\u0002\u0010\b\n\u0002\b\u0002\b\u0080\b\u0018\u00002\u00020\u0001B\u0019\u0012\b\b\u0001\u0010\u0002\u001a\u00020\u0003\u0012\b\b\u0001\u0010\u0004\u001a\u00020\u0005¢\u0006\u0002\u0010\u0006J\t\u0010\u000b\u001a\u00020\u0003HÆ\u0003J\t\u0010\f\u001a\u00020\u0005HÆ\u0003J\u001d\u0010\r\u001a\u00020\u00002\b\b\u0003\u0010\u0002\u001a\u00020\u00032\b\b\u0003\u0010\u0004\u001a\u00020\u0005HÆ\u0001J\u0013\u0010\u000e\u001a\u00020\u000f2\b\u0010\u0010\u001a\u0004\u0018\u00010\u0001HÖ\u0003J\t\u0010\u0011\u001a\u00020\u0012HÖ\u0001J\t\u0010\u0013\u001a\u00020\u0003HÖ\u0001R\u0013\u0010\u0004\u001a\u00020\u00058\u0007¢\u0006\b\n\u0000\u001a\u0004\b\u0007\u0010\bR\u0013\u0010\u0002\u001a\u00020\u00038\u0007¢\u0006\b\n\u0000\u001a\u0004\b\t\u0010\n¨\u0006\u0014"}, d2 = {"Lru/yoomoney/sdk/kassa/payments/api/model/packageoptions/Amount;", "", AppMeasurementSdk.ConditionalUserProperty.VALUE, "", "currency", "Ljava/util/Currency;", "(Ljava/lang/String;Ljava/util/Currency;)V", "getCurrency", "()Ljava/util/Currency;", "getValue", "()Ljava/lang/String;", "component1", "component2", "copy", "equals", "", "other", "hashCode", "", "toString", "library_metricaRealRelease"}, k = 1, mv = {1, 9, 0}, xi = 48)
/* loaded from: classes5.dex */
public final /* data */ class Amount {
    public static final int $stable = 8;
    private final Currency currency;
    private final String value;

    public Amount(@JsonProperty(AppMeasurementSdk.ConditionalUserProperty.VALUE) String value, @JsonProperty("currency") Currency currency) {
        Intrinsics.checkNotNullParameter(value, "value");
        Intrinsics.checkNotNullParameter(currency, "currency");
        this.value = value;
        this.currency = currency;
    }

    public static /* synthetic */ Amount copy$default(Amount amount, String str, Currency currency, int i, Object obj) {
        if ((i & 1) != 0) {
            str = amount.value;
        }
        if ((i & 2) != 0) {
            currency = amount.currency;
        }
        return amount.copy(str, currency);
    }

    /* renamed from: component1, reason: from getter */
    public final String getValue() {
        return this.value;
    }

    /* renamed from: component2, reason: from getter */
    public final Currency getCurrency() {
        return this.currency;
    }

    public final Amount copy(@JsonProperty(AppMeasurementSdk.ConditionalUserProperty.VALUE) String value, @JsonProperty("currency") Currency currency) {
        Intrinsics.checkNotNullParameter(value, "value");
        Intrinsics.checkNotNullParameter(currency, "currency");
        return new Amount(value, currency);
    }

    public boolean equals(Object other) {
        if (this == other) {
            return true;
        }
        if (!(other instanceof Amount)) {
            return false;
        }
        Amount amount = (Amount) other;
        return Intrinsics.areEqual(this.value, amount.value) && Intrinsics.areEqual(this.currency, amount.currency);
    }

    @Keep
    public final Currency getCurrency() {
        return this.currency;
    }

    @Keep
    public final String getValue() {
        return this.value;
    }

    public int hashCode() {
        return this.currency.hashCode() + (this.value.hashCode() * 31);
    }

    public String toString() {
        return "Amount(value=" + this.value + ", currency=" + this.currency + ")";
    }
}

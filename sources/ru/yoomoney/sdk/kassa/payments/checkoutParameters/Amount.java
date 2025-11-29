package ru.yoomoney.sdk.kassa.payments.checkoutParameters;

import android.annotation.SuppressLint;
import android.os.Parcel;
import android.os.Parcelable;
import androidx.annotation.Keep;
import com.google.android.gms.measurement.api.AppMeasurementSdk;
import java.math.BigDecimal;
import java.util.Currency;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

@Keep
@Metadata(d1 = {"\u0000@\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\t\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\b\u0087\b\u0018\u00002\u00020\u0001B\u0017\b\u0007\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\u0006\u0010\u0004\u001a\u00020\u0005¢\u0006\u0002\u0010\u0006J\t\u0010\u000b\u001a\u00020\u0003HÆ\u0003J\t\u0010\f\u001a\u00020\u0005HÆ\u0003J\u001d\u0010\r\u001a\u00020\u00002\b\b\u0002\u0010\u0002\u001a\u00020\u00032\b\b\u0002\u0010\u0004\u001a\u00020\u0005HÆ\u0001J\t\u0010\u000e\u001a\u00020\u000fHÖ\u0001J\u0013\u0010\u0010\u001a\u00020\u00112\b\u0010\u0012\u001a\u0004\u0018\u00010\u0013HÖ\u0003J\t\u0010\u0014\u001a\u00020\u000fHÖ\u0001J\t\u0010\u0015\u001a\u00020\u0016HÖ\u0001J\u0019\u0010\u0017\u001a\u00020\u00182\u0006\u0010\u0019\u001a\u00020\u001a2\u0006\u0010\u001b\u001a\u00020\u000fHÖ\u0001R\u0013\u0010\u0004\u001a\u00020\u00058\u0007¢\u0006\b\n\u0000\u001a\u0004\b\u0007\u0010\bR\u0013\u0010\u0002\u001a\u00020\u00038\u0007¢\u0006\b\n\u0000\u001a\u0004\b\t\u0010\n¨\u0006\u001c"}, d2 = {"Lru/yoomoney/sdk/kassa/payments/checkoutParameters/Amount;", "Landroid/os/Parcelable;", AppMeasurementSdk.ConditionalUserProperty.VALUE, "Ljava/math/BigDecimal;", "currency", "Ljava/util/Currency;", "(Ljava/math/BigDecimal;Ljava/util/Currency;)V", "getCurrency", "()Ljava/util/Currency;", "getValue", "()Ljava/math/BigDecimal;", "component1", "component2", "copy", "describeContents", "", "equals", "", "other", "", "hashCode", "toString", "", "writeToParcel", "", "parcel", "Landroid/os/Parcel;", "flags", "library_metricaRealRelease"}, k = 1, mv = {1, 9, 0}, xi = 48)
@SuppressLint({"ParcelCreator"})
/* loaded from: classes5.dex */
public final /* data */ class Amount implements Parcelable {
    public static final int $stable = 8;
    public static final Parcelable.Creator<Amount> CREATOR = new a();
    private final Currency currency;
    private final BigDecimal value;

    @Keep
    public Amount(BigDecimal value, Currency currency) {
        Intrinsics.checkNotNullParameter(value, "value");
        Intrinsics.checkNotNullParameter(currency, "currency");
        this.value = value;
        this.currency = currency;
    }

    public static /* synthetic */ Amount copy$default(Amount amount, BigDecimal bigDecimal, Currency currency, int i, Object obj) {
        if ((i & 1) != 0) {
            bigDecimal = amount.value;
        }
        if ((i & 2) != 0) {
            currency = amount.currency;
        }
        return amount.copy(bigDecimal, currency);
    }

    /* renamed from: component1, reason: from getter */
    public final BigDecimal getValue() {
        return this.value;
    }

    /* renamed from: component2, reason: from getter */
    public final Currency getCurrency() {
        return this.currency;
    }

    public final Amount copy(BigDecimal value, Currency currency) {
        Intrinsics.checkNotNullParameter(value, "value");
        Intrinsics.checkNotNullParameter(currency, "currency");
        return new Amount(value, currency);
    }

    @Override // android.os.Parcelable
    public int describeContents() {
        return 0;
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
    public final BigDecimal getValue() {
        return this.value;
    }

    public int hashCode() {
        return this.currency.hashCode() + (this.value.hashCode() * 31);
    }

    public String toString() {
        return "Amount(value=" + this.value + ", currency=" + this.currency + ")";
    }

    @Override // android.os.Parcelable
    public void writeToParcel(Parcel parcel, int flags) {
        Intrinsics.checkNotNullParameter(parcel, "out");
        parcel.writeSerializable(this.value);
        parcel.writeSerializable(this.currency);
    }
}

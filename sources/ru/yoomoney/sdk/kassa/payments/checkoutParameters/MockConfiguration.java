package ru.yoomoney.sdk.kassa.payments.checkoutParameters;

import android.annotation.SuppressLint;
import android.os.Parcel;
import android.os.Parcelable;
import androidx.annotation.Keep;
import kotlin.Metadata;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;

@Keep
@Metadata(d1 = {"\u0000<\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000b\n\u0002\b\u0002\n\u0002\u0010\b\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0010\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\b\u0087\b\u0018\u00002\u00020\u0001B1\b\u0007\u0012\b\b\u0002\u0010\u0002\u001a\u00020\u0003\u0012\b\b\u0002\u0010\u0004\u001a\u00020\u0003\u0012\b\b\u0002\u0010\u0005\u001a\u00020\u0006\u0012\n\b\u0002\u0010\u0007\u001a\u0004\u0018\u00010\b¢\u0006\u0002\u0010\tJ\t\u0010\u0011\u001a\u00020\u0003HÆ\u0003J\t\u0010\u0012\u001a\u00020\u0003HÆ\u0003J\t\u0010\u0013\u001a\u00020\u0006HÆ\u0003J\u000b\u0010\u0014\u001a\u0004\u0018\u00010\bHÆ\u0003J3\u0010\u0015\u001a\u00020\u00002\b\b\u0002\u0010\u0002\u001a\u00020\u00032\b\b\u0002\u0010\u0004\u001a\u00020\u00032\b\b\u0002\u0010\u0005\u001a\u00020\u00062\n\b\u0002\u0010\u0007\u001a\u0004\u0018\u00010\bHÆ\u0001J\t\u0010\u0016\u001a\u00020\u0006HÖ\u0001J\u0013\u0010\u0017\u001a\u00020\u00032\b\u0010\u0018\u001a\u0004\u0018\u00010\u0019HÖ\u0003J\t\u0010\u001a\u001a\u00020\u0006HÖ\u0001J\t\u0010\u001b\u001a\u00020\u001cHÖ\u0001J\u0019\u0010\u001d\u001a\u00020\u001e2\u0006\u0010\u001f\u001a\u00020 2\u0006\u0010!\u001a\u00020\u0006HÖ\u0001R\u0013\u0010\u0002\u001a\u00020\u00038\u0007¢\u0006\b\n\u0000\u001a\u0004\b\n\u0010\u000bR\u0013\u0010\u0005\u001a\u00020\u00068\u0007¢\u0006\b\n\u0000\u001a\u0004\b\f\u0010\rR\u0013\u0010\u0004\u001a\u00020\u00038\u0007¢\u0006\b\n\u0000\u001a\u0004\b\u000e\u0010\u000bR\u0015\u0010\u0007\u001a\u0004\u0018\u00010\b8\u0007¢\u0006\b\n\u0000\u001a\u0004\b\u000f\u0010\u0010¨\u0006\""}, d2 = {"Lru/yoomoney/sdk/kassa/payments/checkoutParameters/MockConfiguration;", "Landroid/os/Parcelable;", "completeWithError", "", "paymentAuthPassed", "linkedCardsCount", "", "serviceFee", "Lru/yoomoney/sdk/kassa/payments/checkoutParameters/Amount;", "(ZZILru/yoomoney/sdk/kassa/payments/checkoutParameters/Amount;)V", "getCompleteWithError", "()Z", "getLinkedCardsCount", "()I", "getPaymentAuthPassed", "getServiceFee", "()Lru/yoomoney/sdk/kassa/payments/checkoutParameters/Amount;", "component1", "component2", "component3", "component4", "copy", "describeContents", "equals", "other", "", "hashCode", "toString", "", "writeToParcel", "", "parcel", "Landroid/os/Parcel;", "flags", "library_metricaRealRelease"}, k = 1, mv = {1, 9, 0}, xi = 48)
@SuppressLint({"ParcelCreator"})
/* loaded from: classes5.dex */
public final /* data */ class MockConfiguration implements Parcelable {
    public static final int $stable = 8;
    public static final Parcelable.Creator<MockConfiguration> CREATOR = new d();
    private final boolean completeWithError;
    private final int linkedCardsCount;
    private final boolean paymentAuthPassed;
    private final Amount serviceFee;

    @Keep
    public MockConfiguration() {
        this(false, false, 0, null, 15, null);
    }

    public static /* synthetic */ MockConfiguration copy$default(MockConfiguration mockConfiguration, boolean z, boolean z2, int i, Amount amount, int i2, Object obj) {
        if ((i2 & 1) != 0) {
            z = mockConfiguration.completeWithError;
        }
        if ((i2 & 2) != 0) {
            z2 = mockConfiguration.paymentAuthPassed;
        }
        if ((i2 & 4) != 0) {
            i = mockConfiguration.linkedCardsCount;
        }
        if ((i2 & 8) != 0) {
            amount = mockConfiguration.serviceFee;
        }
        return mockConfiguration.copy(z, z2, i, amount);
    }

    /* renamed from: component1, reason: from getter */
    public final boolean getCompleteWithError() {
        return this.completeWithError;
    }

    /* renamed from: component2, reason: from getter */
    public final boolean getPaymentAuthPassed() {
        return this.paymentAuthPassed;
    }

    /* renamed from: component3, reason: from getter */
    public final int getLinkedCardsCount() {
        return this.linkedCardsCount;
    }

    /* renamed from: component4, reason: from getter */
    public final Amount getServiceFee() {
        return this.serviceFee;
    }

    public final MockConfiguration copy(boolean completeWithError, boolean paymentAuthPassed, int linkedCardsCount, Amount serviceFee) {
        return new MockConfiguration(completeWithError, paymentAuthPassed, linkedCardsCount, serviceFee);
    }

    @Override // android.os.Parcelable
    public int describeContents() {
        return 0;
    }

    public boolean equals(Object other) {
        if (this == other) {
            return true;
        }
        if (!(other instanceof MockConfiguration)) {
            return false;
        }
        MockConfiguration mockConfiguration = (MockConfiguration) other;
        return this.completeWithError == mockConfiguration.completeWithError && this.paymentAuthPassed == mockConfiguration.paymentAuthPassed && this.linkedCardsCount == mockConfiguration.linkedCardsCount && Intrinsics.areEqual(this.serviceFee, mockConfiguration.serviceFee);
    }

    @Keep
    public final boolean getCompleteWithError() {
        return this.completeWithError;
    }

    @Keep
    public final int getLinkedCardsCount() {
        return this.linkedCardsCount;
    }

    @Keep
    public final boolean getPaymentAuthPassed() {
        return this.paymentAuthPassed;
    }

    @Keep
    public final Amount getServiceFee() {
        return this.serviceFee;
    }

    public int hashCode() {
        int iHashCode = (Integer.hashCode(this.linkedCardsCount) + ru.yoomoney.sdk.kassa.payments.api.model.packageoptions.a.a(this.paymentAuthPassed, Boolean.hashCode(this.completeWithError) * 31, 31)) * 31;
        Amount amount = this.serviceFee;
        return iHashCode + (amount == null ? 0 : amount.hashCode());
    }

    public String toString() {
        return "MockConfiguration(completeWithError=" + this.completeWithError + ", paymentAuthPassed=" + this.paymentAuthPassed + ", linkedCardsCount=" + this.linkedCardsCount + ", serviceFee=" + this.serviceFee + ")";
    }

    @Override // android.os.Parcelable
    public void writeToParcel(Parcel parcel, int flags) {
        Intrinsics.checkNotNullParameter(parcel, "out");
        parcel.writeInt(this.completeWithError ? 1 : 0);
        parcel.writeInt(this.paymentAuthPassed ? 1 : 0);
        parcel.writeInt(this.linkedCardsCount);
        Amount amount = this.serviceFee;
        if (amount == null) {
            parcel.writeInt(0);
        } else {
            parcel.writeInt(1);
            amount.writeToParcel(parcel, flags);
        }
    }

    @Keep
    public MockConfiguration(boolean z) {
        this(z, false, 0, null, 14, null);
    }

    @Keep
    public MockConfiguration(boolean z, boolean z2) {
        this(z, z2, 0, null, 12, null);
    }

    @Keep
    public MockConfiguration(boolean z, boolean z2, int i) {
        this(z, z2, i, null, 8, null);
    }

    @Keep
    public MockConfiguration(boolean z, boolean z2, int i, Amount amount) {
        this.completeWithError = z;
        this.paymentAuthPassed = z2;
        this.linkedCardsCount = i;
        this.serviceFee = amount;
    }

    public /* synthetic */ MockConfiguration(boolean z, boolean z2, int i, Amount amount, int i2, DefaultConstructorMarker defaultConstructorMarker) {
        this((i2 & 1) != 0 ? false : z, (i2 & 2) != 0 ? false : z2, (i2 & 4) != 0 ? 1 : i, (i2 & 8) != 0 ? null : amount);
    }
}

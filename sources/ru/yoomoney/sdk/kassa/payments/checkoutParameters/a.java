package ru.yoomoney.sdk.kassa.payments.checkoutParameters;

import android.os.Parcel;
import android.os.Parcelable;
import java.math.BigDecimal;
import java.util.Currency;
import kotlin.jvm.internal.Intrinsics;

/* loaded from: classes5.dex */
public final class a implements Parcelable.Creator {
    @Override // android.os.Parcelable.Creator
    public final Object createFromParcel(Parcel parcel) {
        Intrinsics.checkNotNullParameter(parcel, "parcel");
        return new Amount((BigDecimal) parcel.readSerializable(), (Currency) parcel.readSerializable());
    }

    @Override // android.os.Parcelable.Creator
    public final Object[] newArray(int i) {
        return new Amount[i];
    }
}

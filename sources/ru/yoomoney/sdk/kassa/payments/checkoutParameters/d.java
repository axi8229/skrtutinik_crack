package ru.yoomoney.sdk.kassa.payments.checkoutParameters;

import android.os.Parcel;
import android.os.Parcelable;
import kotlin.jvm.internal.Intrinsics;

/* loaded from: classes5.dex */
public final class d implements Parcelable.Creator {
    @Override // android.os.Parcelable.Creator
    public final Object createFromParcel(Parcel parcel) {
        Intrinsics.checkNotNullParameter(parcel, "parcel");
        return new MockConfiguration(parcel.readInt() != 0, parcel.readInt() != 0, parcel.readInt(), parcel.readInt() == 0 ? null : Amount.CREATOR.createFromParcel(parcel));
    }

    @Override // android.os.Parcelable.Creator
    public final Object[] newArray(int i) {
        return new MockConfiguration[i];
    }
}

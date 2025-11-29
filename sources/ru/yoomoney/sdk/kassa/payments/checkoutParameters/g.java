package ru.yoomoney.sdk.kassa.payments.checkoutParameters;

import android.os.Parcel;
import android.os.Parcelable;
import kotlin.jvm.internal.Intrinsics;

/* loaded from: classes5.dex */
public final class g implements Parcelable.Creator {
    @Override // android.os.Parcelable.Creator
    public final Object createFromParcel(Parcel parcel) {
        Intrinsics.checkNotNullParameter(parcel, "parcel");
        return new TestParameters(parcel.readInt() != 0, parcel.readInt() != 0, parcel.readInt() == 0 ? null : MockConfiguration.CREATOR.createFromParcel(parcel), HostParameters.CREATOR.createFromParcel(parcel), parcel.readString());
    }

    @Override // android.os.Parcelable.Creator
    public final Object[] newArray(int i) {
        return new TestParameters[i];
    }
}

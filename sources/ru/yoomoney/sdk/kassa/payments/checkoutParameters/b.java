package ru.yoomoney.sdk.kassa.payments.checkoutParameters;

import android.os.Parcel;
import android.os.Parcelable;
import java.util.LinkedHashSet;
import kotlin.jvm.internal.Intrinsics;

/* loaded from: classes5.dex */
public final class b implements Parcelable.Creator {
    @Override // android.os.Parcelable.Creator
    public final Object createFromParcel(Parcel parcel) {
        Intrinsics.checkNotNullParameter(parcel, "parcel");
        int i = parcel.readInt();
        LinkedHashSet linkedHashSet = new LinkedHashSet(i);
        for (int i2 = 0; i2 != i; i2++) {
            linkedHashSet.add(GooglePayCardNetwork.valueOf(parcel.readString()));
        }
        return new GooglePayParameters(linkedHashSet);
    }

    @Override // android.os.Parcelable.Creator
    public final Object[] newArray(int i) {
        return new GooglePayParameters[i];
    }
}

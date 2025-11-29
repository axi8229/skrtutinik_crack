package ru.yoomoney.sdk.kassa.payments.checkoutParameters;

import android.os.Parcel;
import android.os.Parcelable;
import java.util.LinkedHashSet;
import kotlin.jvm.internal.Intrinsics;

/* loaded from: classes5.dex */
public final class e implements Parcelable.Creator {
    @Override // android.os.Parcelable.Creator
    public final Object createFromParcel(Parcel parcel) {
        Intrinsics.checkNotNullParameter(parcel, "parcel");
        Amount amountCreateFromParcel = Amount.CREATOR.createFromParcel(parcel);
        String string = parcel.readString();
        String string2 = parcel.readString();
        String string3 = parcel.readString();
        String string4 = parcel.readString();
        SavePaymentMethod savePaymentMethodValueOf = SavePaymentMethod.valueOf(parcel.readString());
        int i = parcel.readInt();
        LinkedHashSet linkedHashSet = new LinkedHashSet(i);
        int i2 = 0;
        while (true) {
            String string5 = parcel.readString();
            if (i2 == i) {
                return new PaymentParameters(amountCreateFromParcel, string, string2, string3, string4, savePaymentMethodValueOf, linkedHashSet, string5, parcel.readString(), parcel.readString(), GooglePayParameters.CREATOR.createFromParcel(parcel), parcel.readString(), parcel.readString());
            }
            linkedHashSet.add(PaymentMethodType.valueOf(string5));
            i2++;
        }
    }

    @Override // android.os.Parcelable.Creator
    public final Object[] newArray(int i) {
        return new PaymentParameters[i];
    }
}

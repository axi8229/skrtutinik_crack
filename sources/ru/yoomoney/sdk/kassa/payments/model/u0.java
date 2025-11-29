package ru.yoomoney.sdk.kassa.payments.model;

import android.os.Parcel;
import android.os.Parcelable;
import java.util.ArrayList;
import kotlin.jvm.internal.Intrinsics;
import ru.yoomoney.sdk.kassa.payments.checkoutParameters.Amount;

/* loaded from: classes5.dex */
public final class u0 implements Parcelable.Creator {
    @Override // android.os.Parcelable.Creator
    public final Object createFromParcel(Parcel parcel) {
        Intrinsics.checkNotNullParameter(parcel, "parcel");
        int i = parcel.readInt();
        Parcelable.Creator<Amount> creator = Amount.CREATOR;
        Amount amountCreateFromParcel = creator.createFromParcel(parcel);
        A aCreateFromParcel = parcel.readInt() == 0 ? null : A.CREATOR.createFromParcel(parcel);
        String string = parcel.readString();
        Amount amountCreateFromParcel2 = parcel.readInt() != 0 ? creator.createFromParcel(parcel) : null;
        String string2 = parcel.readString();
        String string3 = parcel.readString();
        boolean z = parcel.readInt() != 0;
        int i2 = parcel.readInt();
        ArrayList arrayList = new ArrayList(i2);
        for (int i3 = 0; i3 != i2; i3++) {
            arrayList.add(ConfirmationType.valueOf(parcel.readString()));
        }
        return new Wallet(i, amountCreateFromParcel, aCreateFromParcel, string, amountCreateFromParcel2, string2, string3, z, arrayList, parcel.readInt() != 0);
    }

    @Override // android.os.Parcelable.Creator
    public final Object[] newArray(int i) {
        return new Wallet[i];
    }
}

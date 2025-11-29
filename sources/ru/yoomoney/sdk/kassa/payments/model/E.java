package ru.yoomoney.sdk.kassa.payments.model;

import android.os.Parcel;
import android.os.Parcelable;
import java.util.ArrayList;
import kotlin.jvm.internal.Intrinsics;
import ru.yoomoney.sdk.kassa.payments.checkoutParameters.Amount;

/* loaded from: classes5.dex */
public final class E implements Parcelable.Creator {
    @Override // android.os.Parcelable.Creator
    public final Object createFromParcel(Parcel parcel) {
        Intrinsics.checkNotNullParameter(parcel, "parcel");
        int i = parcel.readInt();
        Amount amountCreateFromParcel = Amount.CREATOR.createFromParcel(parcel);
        A aCreateFromParcel = parcel.readInt() == 0 ? null : A.CREATOR.createFromParcel(parcel);
        String string = parcel.readString();
        String string2 = parcel.readString();
        String string3 = parcel.readString();
        EnumC2333q enumC2333qValueOf = EnumC2333q.valueOf(parcel.readString());
        String string4 = parcel.readString();
        String string5 = parcel.readString();
        boolean z = parcel.readInt() != 0;
        boolean z2 = parcel.readInt() != 0;
        int i2 = parcel.readInt();
        ArrayList arrayList = new ArrayList(i2);
        for (int i3 = 0; i3 != i2; i3++) {
            arrayList.add(ConfirmationType.valueOf(parcel.readString()));
        }
        return new LinkedCard(i, amountCreateFromParcel, aCreateFromParcel, string, string2, string3, enumC2333qValueOf, string4, string5, z, z2, arrayList, parcel.readInt() != 0);
    }

    @Override // android.os.Parcelable.Creator
    public final Object[] newArray(int i) {
        return new LinkedCard[i];
    }
}

package ru.yoomoney.sdk.kassa.payments.model;

import android.os.Parcel;
import android.os.Parcelable;
import java.util.ArrayList;
import kotlin.jvm.internal.Intrinsics;
import ru.yoomoney.sdk.kassa.payments.checkoutParameters.Amount;

/* renamed from: ru.yoomoney.sdk.kassa.payments.model.p, reason: case insensitive filesystem */
/* loaded from: classes5.dex */
public final class C2332p implements Parcelable.Creator {
    @Override // android.os.Parcelable.Creator
    public final Object createFromParcel(Parcel parcel) {
        Intrinsics.checkNotNullParameter(parcel, "parcel");
        int i = parcel.readInt();
        Amount amountCreateFromParcel = Amount.CREATOR.createFromParcel(parcel);
        A aCreateFromParcel = parcel.readInt() == 0 ? null : A.CREATOR.createFromParcel(parcel);
        String string = parcel.readString();
        String string2 = parcel.readString();
        boolean z = parcel.readInt() != 0;
        int i2 = parcel.readInt();
        ArrayList arrayList = new ArrayList(i2);
        for (int i3 = 0; i3 != i2; i3++) {
            arrayList.add(ConfirmationType.valueOf(parcel.readString()));
        }
        int i4 = parcel.readInt();
        ArrayList arrayList2 = new ArrayList(i4);
        for (int i5 = 0; i5 != i4; i5++) {
            arrayList2.add(Q.CREATOR.createFromParcel(parcel));
        }
        return new BankCardPaymentOption(i, amountCreateFromParcel, aCreateFromParcel, string, string2, z, arrayList, arrayList2, parcel.readInt() != 0);
    }

    @Override // android.os.Parcelable.Creator
    public final Object[] newArray(int i) {
        return new BankCardPaymentOption[i];
    }
}

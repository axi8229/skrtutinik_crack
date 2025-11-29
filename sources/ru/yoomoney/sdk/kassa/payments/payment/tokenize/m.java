package ru.yoomoney.sdk.kassa.payments.payment.tokenize;

import android.os.Parcel;
import android.os.Parcelable;
import kotlin.jvm.internal.Intrinsics;
import ru.yoomoney.sdk.kassa.payments.model.AbstractC2335t;
import ru.yoomoney.sdk.kassa.payments.model.Q;
import ru.yoomoney.sdk.kassa.payments.model.U;

/* loaded from: classes5.dex */
public final class m implements Parcelable.Creator {
    @Override // android.os.Parcelable.Creator
    public final Object createFromParcel(Parcel parcel) {
        Intrinsics.checkNotNullParameter(parcel, "parcel");
        return new n(parcel.readInt(), parcel.readInt() != 0, parcel.readInt() != 0, (AbstractC2335t) parcel.readParcelable(n.class.getClassLoader()), (U) parcel.readParcelable(n.class.getClassLoader()), parcel.readInt() != 0, parcel.readInt() == 0 ? null : Q.CREATOR.createFromParcel(parcel), parcel.readString());
    }

    @Override // android.os.Parcelable.Creator
    public final Object[] newArray(int i) {
        return new n[i];
    }
}

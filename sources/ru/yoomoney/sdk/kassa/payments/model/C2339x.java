package ru.yoomoney.sdk.kassa.payments.model;

import android.os.Parcel;
import android.os.Parcelable;
import kotlin.jvm.internal.Intrinsics;

/* renamed from: ru.yoomoney.sdk.kassa.payments.model.x, reason: case insensitive filesystem */
/* loaded from: classes5.dex */
public final class C2339x implements Parcelable.Creator {
    @Override // android.os.Parcelable.Creator
    public final Object createFromParcel(Parcel parcel) {
        Intrinsics.checkNotNullParameter(parcel, "parcel");
        parcel.readInt();
        return C2340y.a;
    }

    @Override // android.os.Parcelable.Creator
    public final Object[] newArray(int i) {
        return new C2340y[i];
    }
}

package ru.yoomoney.sdk.kassa.payments.checkoutParameters;

import android.os.Parcel;
import android.os.Parcelable;
import kotlin.jvm.internal.Intrinsics;
import ru.yoomoney.sdk.kassa.payments.ui.color.ColorScheme;

/* loaded from: classes5.dex */
public final class h implements Parcelable.Creator {
    @Override // android.os.Parcelable.Creator
    public final Object createFromParcel(Parcel parcel) {
        Intrinsics.checkNotNullParameter(parcel, "parcel");
        return new UiParameters(parcel.readInt() != 0, (ColorScheme) parcel.readParcelable(UiParameters.class.getClassLoader()));
    }

    @Override // android.os.Parcelable.Creator
    public final Object[] newArray(int i) {
        return new UiParameters[i];
    }
}

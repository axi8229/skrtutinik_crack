package ru.yoomoney.sdk.kassa.payments.model;

import android.os.Parcel;
import android.os.Parcelable;
import kotlin.jvm.internal.Intrinsics;

/* renamed from: ru.yoomoney.sdk.kassa.payments.model.y, reason: case insensitive filesystem */
/* loaded from: classes5.dex */
public final class C2340y extends AbstractC2335t {
    public static final C2340y a = new C2340y();
    public static final Parcelable.Creator<C2340y> CREATOR = new C2339x();

    public C2340y() {
        super(0);
    }

    @Override // android.os.Parcelable
    public final int describeContents() {
        return 0;
    }

    @Override // android.os.Parcelable
    public final void writeToParcel(Parcel out, int i) {
        Intrinsics.checkNotNullParameter(out, "out");
        out.writeInt(1);
    }
}

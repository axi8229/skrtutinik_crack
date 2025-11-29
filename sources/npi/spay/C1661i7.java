package npi.spay;

import android.os.Parcel;
import android.os.Parcelable;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.Intrinsics;

/* renamed from: npi.spay.i7, reason: case insensitive filesystem */
/* loaded from: classes4.dex */
public final class C1661i7 implements Parcelable {
    public static final Parcelable.Creator<C1661i7> CREATOR = new C1636h7();
    public final Function1 a;

    public C1661i7(Function1 function1) {
        this.a = function1;
    }

    @Override // android.os.Parcelable
    public final int describeContents() {
        return 0;
    }

    @Override // android.os.Parcelable
    public final void writeToParcel(Parcel out, int i) {
        Intrinsics.checkNotNullParameter(out, "out");
    }
}

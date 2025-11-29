package ru.yoomoney.sdk.two_fa.exception;

import android.os.Parcel;
import android.os.Parcelable;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

/* compiled from: Failure.kt */
@Metadata(d1 = {"\u0000 \n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\bÇ\u0002\u0018\u00002\u00020\u0001B\u0007\b\u0002¢\u0006\u0002\u0010\u0002J\t\u0010\u0003\u001a\u00020\u0004HÖ\u0001J\u0019\u0010\u0005\u001a\u00020\u00062\u0006\u0010\u0007\u001a\u00020\b2\u0006\u0010\t\u001a\u00020\u0004HÖ\u0001¨\u0006\n"}, d2 = {"Lru/yoomoney/sdk/two_fa/exception/InvalidTokenFailure;", "Lru/yoomoney/sdk/two_fa/exception/Failure;", "()V", "describeContents", "", "writeToParcel", "", "parcel", "Landroid/os/Parcel;", "flags", "two-fa_release"}, k = 1, mv = {1, 9, 0}, xi = 48)
/* loaded from: classes5.dex */
public final class InvalidTokenFailure extends Failure {
    public static final int $stable = 0;
    public static final InvalidTokenFailure INSTANCE = new InvalidTokenFailure();
    public static final Parcelable.Creator<InvalidTokenFailure> CREATOR = new Creator();

    /* compiled from: Failure.kt */
    @Metadata(k = 3, mv = {1, 9, 0}, xi = 48)
    public static final class Creator implements Parcelable.Creator<InvalidTokenFailure> {
        @Override // android.os.Parcelable.Creator
        public final InvalidTokenFailure createFromParcel(Parcel parcel) {
            Intrinsics.checkNotNullParameter(parcel, "parcel");
            parcel.readInt();
            return InvalidTokenFailure.INSTANCE;
        }

        @Override // android.os.Parcelable.Creator
        public final InvalidTokenFailure[] newArray(int i) {
            return new InvalidTokenFailure[i];
        }
    }

    @Override // android.os.Parcelable
    public int describeContents() {
        return 0;
    }

    @Override // android.os.Parcelable
    public void writeToParcel(Parcel parcel, int flags) {
        Intrinsics.checkNotNullParameter(parcel, "out");
        parcel.writeInt(1);
    }

    private InvalidTokenFailure() {
        super(null);
    }
}

package ru.yoomoney.sdk.auth.api.model;

import android.os.Parcel;
import android.os.Parcelable;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

@Metadata(d1 = {"\u0000 \n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\bÁ\u0002\u0018\u00002\u00020\u0001B\u0007\b\u0002¢\u0006\u0002\u0010\u0002J\t\u0010\u0003\u001a\u00020\u0004HÖ\u0001J\u0019\u0010\u0005\u001a\u00020\u00062\u0006\u0010\u0007\u001a\u00020\b2\u0006\u0010\t\u001a\u00020\u0004HÖ\u0001¨\u0006\n"}, d2 = {"Lru/yoomoney/sdk/auth/api/model/ErrorSocialAccountAlreadyBound;", "Lru/yoomoney/sdk/auth/api/model/ProcessError;", "()V", "describeContents", "", "writeToParcel", "", "parcel", "Landroid/os/Parcel;", "flags", "auth_release"}, k = 1, mv = {1, 9, 0}, xi = 48)
/* loaded from: classes4.dex */
public final class ErrorSocialAccountAlreadyBound extends ProcessError {
    public static final ErrorSocialAccountAlreadyBound INSTANCE = new ErrorSocialAccountAlreadyBound();
    public static final Parcelable.Creator<ErrorSocialAccountAlreadyBound> CREATOR = new Creator();

    @Metadata(k = 3, mv = {1, 9, 0}, xi = 48)
    public static final class Creator implements Parcelable.Creator<ErrorSocialAccountAlreadyBound> {
        @Override // android.os.Parcelable.Creator
        public final ErrorSocialAccountAlreadyBound createFromParcel(Parcel parcel) {
            Intrinsics.checkNotNullParameter(parcel, "parcel");
            parcel.readInt();
            return ErrorSocialAccountAlreadyBound.INSTANCE;
        }

        @Override // android.os.Parcelable.Creator
        public final ErrorSocialAccountAlreadyBound[] newArray(int i) {
            return new ErrorSocialAccountAlreadyBound[i];
        }
    }

    private ErrorSocialAccountAlreadyBound() {
        super(null);
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
}

package ru.yoomoney.sdk.auth.api.model;

import android.os.Parcel;
import android.os.Parcelable;
import kotlin.Metadata;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;

@Metadata(d1 = {"\u00004\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0006\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010\u0000\n\u0002\b\u0003\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\b\u0087\b\u0018\u00002\u00020\u0001B\u0011\u0012\n\b\u0002\u0010\u0002\u001a\u0004\u0018\u00010\u0003¢\u0006\u0002\u0010\u0004J\u000b\u0010\u0007\u001a\u0004\u0018\u00010\u0003HÆ\u0003J\u0015\u0010\b\u001a\u00020\u00002\n\b\u0002\u0010\u0002\u001a\u0004\u0018\u00010\u0003HÆ\u0001J\t\u0010\t\u001a\u00020\nHÖ\u0001J\u0013\u0010\u000b\u001a\u00020\f2\b\u0010\r\u001a\u0004\u0018\u00010\u000eHÖ\u0003J\t\u0010\u000f\u001a\u00020\nHÖ\u0001J\t\u0010\u0010\u001a\u00020\u0003HÖ\u0001J\u0019\u0010\u0011\u001a\u00020\u00122\u0006\u0010\u0013\u001a\u00020\u00142\u0006\u0010\u0015\u001a\u00020\nHÖ\u0001R\u0013\u0010\u0002\u001a\u0004\u0018\u00010\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u0005\u0010\u0006¨\u0006\u0016"}, d2 = {"Lru/yoomoney/sdk/auth/api/model/RequestParametersFailure;", "Lru/yoomoney/sdk/auth/api/model/Failure;", "rawErrorBody", "", "(Ljava/lang/String;)V", "getRawErrorBody", "()Ljava/lang/String;", "component1", "copy", "describeContents", "", "equals", "", "other", "", "hashCode", "toString", "writeToParcel", "", "parcel", "Landroid/os/Parcel;", "flags", "auth_release"}, k = 1, mv = {1, 9, 0}, xi = 48)
/* loaded from: classes4.dex */
public final /* data */ class RequestParametersFailure extends Failure {
    public static final Parcelable.Creator<RequestParametersFailure> CREATOR = new Creator();
    private final String rawErrorBody;

    @Metadata(k = 3, mv = {1, 9, 0}, xi = 48)
    public static final class Creator implements Parcelable.Creator<RequestParametersFailure> {
        @Override // android.os.Parcelable.Creator
        public final RequestParametersFailure createFromParcel(Parcel parcel) {
            Intrinsics.checkNotNullParameter(parcel, "parcel");
            return new RequestParametersFailure(parcel.readString());
        }

        @Override // android.os.Parcelable.Creator
        public final RequestParametersFailure[] newArray(int i) {
            return new RequestParametersFailure[i];
        }
    }

    public RequestParametersFailure() {
        this(null, 1, 0 == true ? 1 : 0);
    }

    public static /* synthetic */ RequestParametersFailure copy$default(RequestParametersFailure requestParametersFailure, String str, int i, Object obj) {
        if ((i & 1) != 0) {
            str = requestParametersFailure.rawErrorBody;
        }
        return requestParametersFailure.copy(str);
    }

    /* renamed from: component1, reason: from getter */
    public final String getRawErrorBody() {
        return this.rawErrorBody;
    }

    public final RequestParametersFailure copy(String rawErrorBody) {
        return new RequestParametersFailure(rawErrorBody);
    }

    @Override // android.os.Parcelable
    public int describeContents() {
        return 0;
    }

    public boolean equals(Object other) {
        if (this == other) {
            return true;
        }
        return (other instanceof RequestParametersFailure) && Intrinsics.areEqual(this.rawErrorBody, ((RequestParametersFailure) other).rawErrorBody);
    }

    public final String getRawErrorBody() {
        return this.rawErrorBody;
    }

    public int hashCode() {
        String str = this.rawErrorBody;
        if (str == null) {
            return 0;
        }
        return str.hashCode();
    }

    @Override // java.lang.Throwable
    public String toString() {
        return "RequestParametersFailure(rawErrorBody=" + this.rawErrorBody + ")";
    }

    @Override // android.os.Parcelable
    public void writeToParcel(Parcel parcel, int flags) {
        Intrinsics.checkNotNullParameter(parcel, "out");
        parcel.writeString(this.rawErrorBody);
    }

    public RequestParametersFailure(String str) {
        super(null);
        this.rawErrorBody = str;
    }

    public /* synthetic */ RequestParametersFailure(String str, int i, DefaultConstructorMarker defaultConstructorMarker) {
        this((i & 1) != 0 ? null : str);
    }
}

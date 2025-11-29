package ru.yoomoney.sdk.auth;

import android.os.Parcel;
import android.os.Parcelable;
import kotlin.Metadata;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;

@Metadata(d1 = {"\u0000:\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0018\u0002\n\u0002\b\t\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010\u0000\n\u0002\b\u0003\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\b\u0087\b\u0018\u00002\u00020\u0001B\u0019\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\n\b\u0002\u0010\u0004\u001a\u0004\u0018\u00010\u0005¢\u0006\u0002\u0010\u0006J\t\u0010\u000b\u001a\u00020\u0003HÆ\u0003J\u000b\u0010\f\u001a\u0004\u0018\u00010\u0005HÆ\u0003J\u001f\u0010\r\u001a\u00020\u00002\b\b\u0002\u0010\u0002\u001a\u00020\u00032\n\b\u0002\u0010\u0004\u001a\u0004\u0018\u00010\u0005HÆ\u0001J\t\u0010\u000e\u001a\u00020\u000fHÖ\u0001J\u0013\u0010\u0010\u001a\u00020\u00112\b\u0010\u0012\u001a\u0004\u0018\u00010\u0013HÖ\u0003J\t\u0010\u0014\u001a\u00020\u000fHÖ\u0001J\t\u0010\u0015\u001a\u00020\u0003HÖ\u0001J\u0019\u0010\u0016\u001a\u00020\u00172\u0006\u0010\u0018\u001a\u00020\u00192\u0006\u0010\u001a\u001a\u00020\u000fHÖ\u0001R\u0013\u0010\u0004\u001a\u0004\u0018\u00010\u0005¢\u0006\b\n\u0000\u001a\u0004\b\u0007\u0010\bR\u0011\u0010\u0002\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\t\u0010\n¨\u0006\u001b"}, d2 = {"Lru/yoomoney/sdk/auth/OauthParams;", "Landroid/os/Parcelable;", "packageName", "", "oauthOrigin", "Lru/yoomoney/sdk/auth/OauthOrigin;", "(Ljava/lang/String;Lru/yoomoney/sdk/auth/OauthOrigin;)V", "getOauthOrigin", "()Lru/yoomoney/sdk/auth/OauthOrigin;", "getPackageName", "()Ljava/lang/String;", "component1", "component2", "copy", "describeContents", "", "equals", "", "other", "", "hashCode", "toString", "writeToParcel", "", "parcel", "Landroid/os/Parcel;", "flags", "auth_release"}, k = 1, mv = {1, 9, 0}, xi = 48)
/* loaded from: classes4.dex */
public final /* data */ class OauthParams implements Parcelable {
    public static final Parcelable.Creator<OauthParams> CREATOR = new Creator();
    private final OauthOrigin oauthOrigin;
    private final String packageName;

    @Metadata(k = 3, mv = {1, 9, 0}, xi = 48)
    public static final class Creator implements Parcelable.Creator<OauthParams> {
        @Override // android.os.Parcelable.Creator
        public final OauthParams createFromParcel(Parcel parcel) {
            Intrinsics.checkNotNullParameter(parcel, "parcel");
            return new OauthParams(parcel.readString(), parcel.readInt() == 0 ? null : OauthOrigin.valueOf(parcel.readString()));
        }

        @Override // android.os.Parcelable.Creator
        public final OauthParams[] newArray(int i) {
            return new OauthParams[i];
        }
    }

    public OauthParams(String packageName, OauthOrigin oauthOrigin) {
        Intrinsics.checkNotNullParameter(packageName, "packageName");
        this.packageName = packageName;
        this.oauthOrigin = oauthOrigin;
    }

    public static /* synthetic */ OauthParams copy$default(OauthParams oauthParams, String str, OauthOrigin oauthOrigin, int i, Object obj) {
        if ((i & 1) != 0) {
            str = oauthParams.packageName;
        }
        if ((i & 2) != 0) {
            oauthOrigin = oauthParams.oauthOrigin;
        }
        return oauthParams.copy(str, oauthOrigin);
    }

    /* renamed from: component1, reason: from getter */
    public final String getPackageName() {
        return this.packageName;
    }

    /* renamed from: component2, reason: from getter */
    public final OauthOrigin getOauthOrigin() {
        return this.oauthOrigin;
    }

    public final OauthParams copy(String packageName, OauthOrigin oauthOrigin) {
        Intrinsics.checkNotNullParameter(packageName, "packageName");
        return new OauthParams(packageName, oauthOrigin);
    }

    @Override // android.os.Parcelable
    public int describeContents() {
        return 0;
    }

    public boolean equals(Object other) {
        if (this == other) {
            return true;
        }
        if (!(other instanceof OauthParams)) {
            return false;
        }
        OauthParams oauthParams = (OauthParams) other;
        return Intrinsics.areEqual(this.packageName, oauthParams.packageName) && this.oauthOrigin == oauthParams.oauthOrigin;
    }

    public final OauthOrigin getOauthOrigin() {
        return this.oauthOrigin;
    }

    public final String getPackageName() {
        return this.packageName;
    }

    public int hashCode() {
        int iHashCode = this.packageName.hashCode() * 31;
        OauthOrigin oauthOrigin = this.oauthOrigin;
        return iHashCode + (oauthOrigin == null ? 0 : oauthOrigin.hashCode());
    }

    public String toString() {
        return "OauthParams(packageName=" + this.packageName + ", oauthOrigin=" + this.oauthOrigin + ")";
    }

    @Override // android.os.Parcelable
    public void writeToParcel(Parcel parcel, int flags) {
        Intrinsics.checkNotNullParameter(parcel, "out");
        parcel.writeString(this.packageName);
        OauthOrigin oauthOrigin = this.oauthOrigin;
        if (oauthOrigin == null) {
            parcel.writeInt(0);
        } else {
            parcel.writeInt(1);
            parcel.writeString(oauthOrigin.name());
        }
    }

    public /* synthetic */ OauthParams(String str, OauthOrigin oauthOrigin, int i, DefaultConstructorMarker defaultConstructorMarker) {
        this(str, (i & 2) != 0 ? null : oauthOrigin);
    }
}

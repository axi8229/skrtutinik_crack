package ru.yoomoney.sdk.auth.api.model;

import android.os.Parcel;
import android.os.Parcelable;
import com.google.android.gms.common.Scopes;
import com.google.gson.annotations.SerializedName;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import ru.yoomoney.sdk.auth.api.account.socialAccount.model.OauthServiceProvider;

@Metadata(d1 = {"\u0000:\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0002\b\f\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010\u0000\n\u0002\b\u0003\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\b\u0081\b\u0018\u00002\u00020\u0001B!\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\b\u0010\u0004\u001a\u0004\u0018\u00010\u0005\u0012\b\u0010\u0006\u001a\u0004\u0018\u00010\u0005¢\u0006\u0002\u0010\u0007J\t\u0010\r\u001a\u00020\u0003HÆ\u0003J\u000b\u0010\u000e\u001a\u0004\u0018\u00010\u0005HÆ\u0003J\u000b\u0010\u000f\u001a\u0004\u0018\u00010\u0005HÆ\u0003J+\u0010\u0010\u001a\u00020\u00002\b\b\u0002\u0010\u0002\u001a\u00020\u00032\n\b\u0002\u0010\u0004\u001a\u0004\u0018\u00010\u00052\n\b\u0002\u0010\u0006\u001a\u0004\u0018\u00010\u0005HÆ\u0001J\t\u0010\u0011\u001a\u00020\u0012HÖ\u0001J\u0013\u0010\u0013\u001a\u00020\u00142\b\u0010\u0015\u001a\u0004\u0018\u00010\u0016HÖ\u0003J\t\u0010\u0017\u001a\u00020\u0012HÖ\u0001J\t\u0010\u0018\u001a\u00020\u0005HÖ\u0001J\u0019\u0010\u0019\u001a\u00020\u001a2\u0006\u0010\u001b\u001a\u00020\u001c2\u0006\u0010\u001d\u001a\u00020\u0012HÖ\u0001R\u0018\u0010\u0006\u001a\u0004\u0018\u00010\u00058\u0006X\u0087\u0004¢\u0006\b\n\u0000\u001a\u0004\b\b\u0010\tR\u0018\u0010\u0004\u001a\u0004\u0018\u00010\u00058\u0006X\u0087\u0004¢\u0006\b\n\u0000\u001a\u0004\b\n\u0010\tR\u0016\u0010\u0002\u001a\u00020\u00038\u0006X\u0087\u0004¢\u0006\b\n\u0000\u001a\u0004\b\u000b\u0010\f¨\u0006\u001e"}, d2 = {"Lru/yoomoney/sdk/auth/api/model/ErrorOauthAccountNotConnected;", "Lru/yoomoney/sdk/auth/api/model/ProcessError;", "service", "Lru/yoomoney/sdk/auth/api/account/socialAccount/model/OauthServiceProvider;", "phone", "", Scopes.EMAIL, "(Lru/yoomoney/sdk/auth/api/account/socialAccount/model/OauthServiceProvider;Ljava/lang/String;Ljava/lang/String;)V", "getEmail", "()Ljava/lang/String;", "getPhone", "getService", "()Lru/yoomoney/sdk/auth/api/account/socialAccount/model/OauthServiceProvider;", "component1", "component2", "component3", "copy", "describeContents", "", "equals", "", "other", "", "hashCode", "toString", "writeToParcel", "", "parcel", "Landroid/os/Parcel;", "flags", "auth_release"}, k = 1, mv = {1, 9, 0}, xi = 48)
/* loaded from: classes4.dex */
public final /* data */ class ErrorOauthAccountNotConnected extends ProcessError {
    public static final Parcelable.Creator<ErrorOauthAccountNotConnected> CREATOR = new Creator();

    @SerializedName(Scopes.EMAIL)
    private final String email;

    @SerializedName("phone")
    private final String phone;

    @SerializedName("service")
    private final OauthServiceProvider service;

    @Metadata(k = 3, mv = {1, 9, 0}, xi = 48)
    public static final class Creator implements Parcelable.Creator<ErrorOauthAccountNotConnected> {
        @Override // android.os.Parcelable.Creator
        public final ErrorOauthAccountNotConnected createFromParcel(Parcel parcel) {
            Intrinsics.checkNotNullParameter(parcel, "parcel");
            return new ErrorOauthAccountNotConnected(OauthServiceProvider.valueOf(parcel.readString()), parcel.readString(), parcel.readString());
        }

        @Override // android.os.Parcelable.Creator
        public final ErrorOauthAccountNotConnected[] newArray(int i) {
            return new ErrorOauthAccountNotConnected[i];
        }
    }

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public ErrorOauthAccountNotConnected(OauthServiceProvider service, String str, String str2) {
        super(null);
        Intrinsics.checkNotNullParameter(service, "service");
        this.service = service;
        this.phone = str;
        this.email = str2;
    }

    public static /* synthetic */ ErrorOauthAccountNotConnected copy$default(ErrorOauthAccountNotConnected errorOauthAccountNotConnected, OauthServiceProvider oauthServiceProvider, String str, String str2, int i, Object obj) {
        if ((i & 1) != 0) {
            oauthServiceProvider = errorOauthAccountNotConnected.service;
        }
        if ((i & 2) != 0) {
            str = errorOauthAccountNotConnected.phone;
        }
        if ((i & 4) != 0) {
            str2 = errorOauthAccountNotConnected.email;
        }
        return errorOauthAccountNotConnected.copy(oauthServiceProvider, str, str2);
    }

    /* renamed from: component1, reason: from getter */
    public final OauthServiceProvider getService() {
        return this.service;
    }

    /* renamed from: component2, reason: from getter */
    public final String getPhone() {
        return this.phone;
    }

    /* renamed from: component3, reason: from getter */
    public final String getEmail() {
        return this.email;
    }

    public final ErrorOauthAccountNotConnected copy(OauthServiceProvider service, String phone, String email) {
        Intrinsics.checkNotNullParameter(service, "service");
        return new ErrorOauthAccountNotConnected(service, phone, email);
    }

    @Override // android.os.Parcelable
    public int describeContents() {
        return 0;
    }

    public boolean equals(Object other) {
        if (this == other) {
            return true;
        }
        if (!(other instanceof ErrorOauthAccountNotConnected)) {
            return false;
        }
        ErrorOauthAccountNotConnected errorOauthAccountNotConnected = (ErrorOauthAccountNotConnected) other;
        return this.service == errorOauthAccountNotConnected.service && Intrinsics.areEqual(this.phone, errorOauthAccountNotConnected.phone) && Intrinsics.areEqual(this.email, errorOauthAccountNotConnected.email);
    }

    public final String getEmail() {
        return this.email;
    }

    public final String getPhone() {
        return this.phone;
    }

    public final OauthServiceProvider getService() {
        return this.service;
    }

    public int hashCode() {
        int iHashCode = this.service.hashCode() * 31;
        String str = this.phone;
        int iHashCode2 = (iHashCode + (str == null ? 0 : str.hashCode())) * 31;
        String str2 = this.email;
        return iHashCode2 + (str2 != null ? str2.hashCode() : 0);
    }

    public String toString() {
        return "ErrorOauthAccountNotConnected(service=" + this.service + ", phone=" + this.phone + ", email=" + this.email + ")";
    }

    @Override // android.os.Parcelable
    public void writeToParcel(Parcel parcel, int flags) {
        Intrinsics.checkNotNullParameter(parcel, "out");
        parcel.writeString(this.service.name());
        parcel.writeString(this.phone);
        parcel.writeString(this.email);
    }
}

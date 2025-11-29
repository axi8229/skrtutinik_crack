package ru.yoomoney.sdk.auth.api.account.socialAccount.model;

import android.os.Parcel;
import android.os.Parcelable;
import com.google.gson.annotations.SerializedName;
import com.huawei.updatesdk.service.otaupdate.UpdateKey;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import ru.yoomoney.sdk.auth.api.account.model.SocialAccount;
import ru.yoomoney.sdk.auth.api.account.socialAccount.model.BindSocialAccountResult;

@Metadata(d1 = {"\u0000F\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\f\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\b\u0081\b\u0018\u00002\u00020\u0001B\u001f\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\b\u0010\u0004\u001a\u0004\u0018\u00010\u0005\u0012\u0006\u0010\u0006\u001a\u00020\u0007¢\u0006\u0002\u0010\bJ\t\u0010\u000f\u001a\u00020\u0003HÆ\u0003J\u000b\u0010\u0010\u001a\u0004\u0018\u00010\u0005HÆ\u0003J\t\u0010\u0011\u001a\u00020\u0007HÆ\u0003J)\u0010\u0012\u001a\u00020\u00002\b\b\u0002\u0010\u0002\u001a\u00020\u00032\n\b\u0002\u0010\u0004\u001a\u0004\u0018\u00010\u00052\b\b\u0002\u0010\u0006\u001a\u00020\u0007HÆ\u0001J\t\u0010\u0013\u001a\u00020\u0014HÖ\u0001J\u0013\u0010\u0015\u001a\u00020\u00162\b\u0010\u0017\u001a\u0004\u0018\u00010\u0018HÖ\u0003J\t\u0010\u0019\u001a\u00020\u0014HÖ\u0001J\t\u0010\u001a\u001a\u00020\u001bHÖ\u0001J\u0019\u0010\u001c\u001a\u00020\u001d2\u0006\u0010\u001e\u001a\u00020\u001f2\u0006\u0010 \u001a\u00020\u0014HÖ\u0001R\u0018\u0010\u0004\u001a\u0004\u0018\u00010\u00058\u0016X\u0097\u0004¢\u0006\b\n\u0000\u001a\u0004\b\t\u0010\nR\u0016\u0010\u0006\u001a\u00020\u00078\u0006X\u0087\u0004¢\u0006\b\n\u0000\u001a\u0004\b\u000b\u0010\fR\u0016\u0010\u0002\u001a\u00020\u00038\u0016X\u0097\u0004¢\u0006\b\n\u0000\u001a\u0004\b\r\u0010\u000e¨\u0006!"}, d2 = {"Lru/yoomoney/sdk/auth/api/account/socialAccount/model/BindSocialAccountSuccessResult;", "Lru/yoomoney/sdk/auth/api/account/socialAccount/model/BindSocialAccountResult;", UpdateKey.STATUS, "Lru/yoomoney/sdk/auth/api/account/socialAccount/model/BindSocialAccountResult$Status;", "service", "Lru/yoomoney/sdk/auth/api/account/socialAccount/model/OauthServiceProvider;", "socialAccount", "Lru/yoomoney/sdk/auth/api/account/model/SocialAccount;", "(Lru/yoomoney/sdk/auth/api/account/socialAccount/model/BindSocialAccountResult$Status;Lru/yoomoney/sdk/auth/api/account/socialAccount/model/OauthServiceProvider;Lru/yoomoney/sdk/auth/api/account/model/SocialAccount;)V", "getService", "()Lru/yoomoney/sdk/auth/api/account/socialAccount/model/OauthServiceProvider;", "getSocialAccount", "()Lru/yoomoney/sdk/auth/api/account/model/SocialAccount;", "getStatus", "()Lru/yoomoney/sdk/auth/api/account/socialAccount/model/BindSocialAccountResult$Status;", "component1", "component2", "component3", "copy", "describeContents", "", "equals", "", "other", "", "hashCode", "toString", "", "writeToParcel", "", "parcel", "Landroid/os/Parcel;", "flags", "auth_release"}, k = 1, mv = {1, 9, 0}, xi = 48)
/* loaded from: classes4.dex */
public final /* data */ class BindSocialAccountSuccessResult extends BindSocialAccountResult {
    public static final Parcelable.Creator<BindSocialAccountSuccessResult> CREATOR = new Creator();

    @SerializedName("service")
    private final OauthServiceProvider service;

    @SerializedName("socialAccount")
    private final SocialAccount socialAccount;

    @SerializedName(UpdateKey.STATUS)
    private final BindSocialAccountResult.Status status;

    @Metadata(k = 3, mv = {1, 9, 0}, xi = 48)
    public static final class Creator implements Parcelable.Creator<BindSocialAccountSuccessResult> {
        @Override // android.os.Parcelable.Creator
        public final BindSocialAccountSuccessResult createFromParcel(Parcel parcel) {
            Intrinsics.checkNotNullParameter(parcel, "parcel");
            return new BindSocialAccountSuccessResult(BindSocialAccountResult.Status.valueOf(parcel.readString()), parcel.readInt() == 0 ? null : OauthServiceProvider.valueOf(parcel.readString()), SocialAccount.CREATOR.createFromParcel(parcel));
        }

        @Override // android.os.Parcelable.Creator
        public final BindSocialAccountSuccessResult[] newArray(int i) {
            return new BindSocialAccountSuccessResult[i];
        }
    }

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public BindSocialAccountSuccessResult(BindSocialAccountResult.Status status, OauthServiceProvider oauthServiceProvider, SocialAccount socialAccount) {
        super(null);
        Intrinsics.checkNotNullParameter(status, "status");
        Intrinsics.checkNotNullParameter(socialAccount, "socialAccount");
        this.status = status;
        this.service = oauthServiceProvider;
        this.socialAccount = socialAccount;
    }

    public static /* synthetic */ BindSocialAccountSuccessResult copy$default(BindSocialAccountSuccessResult bindSocialAccountSuccessResult, BindSocialAccountResult.Status status, OauthServiceProvider oauthServiceProvider, SocialAccount socialAccount, int i, Object obj) {
        if ((i & 1) != 0) {
            status = bindSocialAccountSuccessResult.status;
        }
        if ((i & 2) != 0) {
            oauthServiceProvider = bindSocialAccountSuccessResult.service;
        }
        if ((i & 4) != 0) {
            socialAccount = bindSocialAccountSuccessResult.socialAccount;
        }
        return bindSocialAccountSuccessResult.copy(status, oauthServiceProvider, socialAccount);
    }

    /* renamed from: component1, reason: from getter */
    public final BindSocialAccountResult.Status getStatus() {
        return this.status;
    }

    /* renamed from: component2, reason: from getter */
    public final OauthServiceProvider getService() {
        return this.service;
    }

    /* renamed from: component3, reason: from getter */
    public final SocialAccount getSocialAccount() {
        return this.socialAccount;
    }

    public final BindSocialAccountSuccessResult copy(BindSocialAccountResult.Status status, OauthServiceProvider service, SocialAccount socialAccount) {
        Intrinsics.checkNotNullParameter(status, "status");
        Intrinsics.checkNotNullParameter(socialAccount, "socialAccount");
        return new BindSocialAccountSuccessResult(status, service, socialAccount);
    }

    @Override // android.os.Parcelable
    public int describeContents() {
        return 0;
    }

    public boolean equals(Object other) {
        if (this == other) {
            return true;
        }
        if (!(other instanceof BindSocialAccountSuccessResult)) {
            return false;
        }
        BindSocialAccountSuccessResult bindSocialAccountSuccessResult = (BindSocialAccountSuccessResult) other;
        return this.status == bindSocialAccountSuccessResult.status && this.service == bindSocialAccountSuccessResult.service && Intrinsics.areEqual(this.socialAccount, bindSocialAccountSuccessResult.socialAccount);
    }

    @Override // ru.yoomoney.sdk.auth.api.account.socialAccount.model.BindSocialAccountResult
    public OauthServiceProvider getService() {
        return this.service;
    }

    public final SocialAccount getSocialAccount() {
        return this.socialAccount;
    }

    @Override // ru.yoomoney.sdk.auth.api.account.socialAccount.model.BindSocialAccountResult
    public BindSocialAccountResult.Status getStatus() {
        return this.status;
    }

    public int hashCode() {
        int iHashCode = this.status.hashCode() * 31;
        OauthServiceProvider oauthServiceProvider = this.service;
        return this.socialAccount.hashCode() + ((iHashCode + (oauthServiceProvider == null ? 0 : oauthServiceProvider.hashCode())) * 31);
    }

    public String toString() {
        return "BindSocialAccountSuccessResult(status=" + this.status + ", service=" + this.service + ", socialAccount=" + this.socialAccount + ")";
    }

    @Override // android.os.Parcelable
    public void writeToParcel(Parcel parcel, int flags) {
        Intrinsics.checkNotNullParameter(parcel, "out");
        parcel.writeString(this.status.name());
        OauthServiceProvider oauthServiceProvider = this.service;
        if (oauthServiceProvider == null) {
            parcel.writeInt(0);
        } else {
            parcel.writeInt(1);
            parcel.writeString(oauthServiceProvider.name());
        }
        this.socialAccount.writeToParcel(parcel, flags);
    }
}

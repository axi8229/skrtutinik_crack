package ru.yoomoney.sdk.auth.api.account.model;

import android.os.Parcel;
import android.os.Parcelable;
import com.google.gson.annotations.SerializedName;
import flussonic.media.FFmpegMediaMetadataRetriever;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import ru.yoomoney.sdk.auth.api.account.socialAccount.model.OauthServiceProvider;

@Metadata(d1 = {"\u0000:\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0018\u0002\n\u0002\b\t\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010\u0000\n\u0002\b\u0003\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\b\u0087\b\u0018\u00002\u00020\u0001B\u0019\u0012\b\u0010\u0002\u001a\u0004\u0018\u00010\u0003\u0012\b\u0010\u0004\u001a\u0004\u0018\u00010\u0005¢\u0006\u0002\u0010\u0006J\u000b\u0010\u000b\u001a\u0004\u0018\u00010\u0003HÆ\u0003J\u000b\u0010\f\u001a\u0004\u0018\u00010\u0005HÆ\u0003J!\u0010\r\u001a\u00020\u00002\n\b\u0002\u0010\u0002\u001a\u0004\u0018\u00010\u00032\n\b\u0002\u0010\u0004\u001a\u0004\u0018\u00010\u0005HÆ\u0001J\t\u0010\u000e\u001a\u00020\u000fHÖ\u0001J\u0013\u0010\u0010\u001a\u00020\u00112\b\u0010\u0012\u001a\u0004\u0018\u00010\u0013HÖ\u0003J\t\u0010\u0014\u001a\u00020\u000fHÖ\u0001J\t\u0010\u0015\u001a\u00020\u0003HÖ\u0001J\u0019\u0010\u0016\u001a\u00020\u00172\u0006\u0010\u0018\u001a\u00020\u00192\u0006\u0010\u001a\u001a\u00020\u000fHÖ\u0001R\u0018\u0010\u0004\u001a\u0004\u0018\u00010\u00058\u0006X\u0087\u0004¢\u0006\b\n\u0000\u001a\u0004\b\u0007\u0010\bR\u0018\u0010\u0002\u001a\u0004\u0018\u00010\u00038\u0006X\u0087\u0004¢\u0006\b\n\u0000\u001a\u0004\b\t\u0010\n¨\u0006\u001b"}, d2 = {"Lru/yoomoney/sdk/auth/api/account/model/SocialAccount;", "Landroid/os/Parcelable;", FFmpegMediaMetadataRetriever.METADATA_KEY_TITLE, "", "service", "Lru/yoomoney/sdk/auth/api/account/socialAccount/model/OauthServiceProvider;", "(Ljava/lang/String;Lru/yoomoney/sdk/auth/api/account/socialAccount/model/OauthServiceProvider;)V", "getService", "()Lru/yoomoney/sdk/auth/api/account/socialAccount/model/OauthServiceProvider;", "getTitle", "()Ljava/lang/String;", "component1", "component2", "copy", "describeContents", "", "equals", "", "other", "", "hashCode", "toString", "writeToParcel", "", "parcel", "Landroid/os/Parcel;", "flags", "auth_release"}, k = 1, mv = {1, 9, 0}, xi = 48)
/* loaded from: classes4.dex */
public final /* data */ class SocialAccount implements Parcelable {
    public static final Parcelable.Creator<SocialAccount> CREATOR = new Creator();

    @SerializedName("service")
    private final OauthServiceProvider service;

    @SerializedName(FFmpegMediaMetadataRetriever.METADATA_KEY_TITLE)
    private final String title;

    @Metadata(k = 3, mv = {1, 9, 0}, xi = 48)
    public static final class Creator implements Parcelable.Creator<SocialAccount> {
        @Override // android.os.Parcelable.Creator
        public final SocialAccount createFromParcel(Parcel parcel) {
            Intrinsics.checkNotNullParameter(parcel, "parcel");
            return new SocialAccount(parcel.readString(), parcel.readInt() == 0 ? null : OauthServiceProvider.valueOf(parcel.readString()));
        }

        @Override // android.os.Parcelable.Creator
        public final SocialAccount[] newArray(int i) {
            return new SocialAccount[i];
        }
    }

    public SocialAccount(String str, OauthServiceProvider oauthServiceProvider) {
        this.title = str;
        this.service = oauthServiceProvider;
    }

    public static /* synthetic */ SocialAccount copy$default(SocialAccount socialAccount, String str, OauthServiceProvider oauthServiceProvider, int i, Object obj) {
        if ((i & 1) != 0) {
            str = socialAccount.title;
        }
        if ((i & 2) != 0) {
            oauthServiceProvider = socialAccount.service;
        }
        return socialAccount.copy(str, oauthServiceProvider);
    }

    /* renamed from: component1, reason: from getter */
    public final String getTitle() {
        return this.title;
    }

    /* renamed from: component2, reason: from getter */
    public final OauthServiceProvider getService() {
        return this.service;
    }

    public final SocialAccount copy(String title, OauthServiceProvider service) {
        return new SocialAccount(title, service);
    }

    @Override // android.os.Parcelable
    public int describeContents() {
        return 0;
    }

    public boolean equals(Object other) {
        if (this == other) {
            return true;
        }
        if (!(other instanceof SocialAccount)) {
            return false;
        }
        SocialAccount socialAccount = (SocialAccount) other;
        return Intrinsics.areEqual(this.title, socialAccount.title) && this.service == socialAccount.service;
    }

    public final OauthServiceProvider getService() {
        return this.service;
    }

    public final String getTitle() {
        return this.title;
    }

    public int hashCode() {
        String str = this.title;
        int iHashCode = (str == null ? 0 : str.hashCode()) * 31;
        OauthServiceProvider oauthServiceProvider = this.service;
        return iHashCode + (oauthServiceProvider != null ? oauthServiceProvider.hashCode() : 0);
    }

    public String toString() {
        return "SocialAccount(title=" + this.title + ", service=" + this.service + ")";
    }

    @Override // android.os.Parcelable
    public void writeToParcel(Parcel parcel, int flags) {
        Intrinsics.checkNotNullParameter(parcel, "out");
        parcel.writeString(this.title);
        OauthServiceProvider oauthServiceProvider = this.service;
        if (oauthServiceProvider == null) {
            parcel.writeInt(0);
        } else {
            parcel.writeInt(1);
            parcel.writeString(oauthServiceProvider.name());
        }
    }
}

package ru.yoomoney.sdk.auth;

import android.os.Parcel;
import android.os.Parcelable;
import kotlin.Metadata;
import kotlin.enums.EnumEntries;
import kotlin.enums.EnumEntriesKt;
import kotlin.jvm.internal.Intrinsics;
import ru.yoomoney.sdk.auth.api.account.socialAccount.model.OauthServiceProvider;

@Metadata(d1 = {"\u0000@\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\t\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\b\u0087\b\u0018\u00002\u00020\u0001:\u0001\u001cB\u0015\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\u0006\u0010\u0004\u001a\u00020\u0005¢\u0006\u0002\u0010\u0006J\t\u0010\u000b\u001a\u00020\u0003HÆ\u0003J\t\u0010\f\u001a\u00020\u0005HÆ\u0003J\u001d\u0010\r\u001a\u00020\u00002\b\b\u0002\u0010\u0002\u001a\u00020\u00032\b\b\u0002\u0010\u0004\u001a\u00020\u0005HÆ\u0001J\t\u0010\u000e\u001a\u00020\u000fHÖ\u0001J\u0013\u0010\u0010\u001a\u00020\u00112\b\u0010\u0012\u001a\u0004\u0018\u00010\u0013HÖ\u0003J\t\u0010\u0014\u001a\u00020\u000fHÖ\u0001J\t\u0010\u0015\u001a\u00020\u0016HÖ\u0001J\u0019\u0010\u0017\u001a\u00020\u00182\u0006\u0010\u0019\u001a\u00020\u001a2\u0006\u0010\u001b\u001a\u00020\u000fHÖ\u0001R\u0011\u0010\u0004\u001a\u00020\u0005¢\u0006\b\n\u0000\u001a\u0004\b\u0007\u0010\bR\u0011\u0010\u0002\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\t\u0010\n¨\u0006\u001d"}, d2 = {"Lru/yoomoney/sdk/auth/OauthResult;", "Landroid/os/Parcelable;", "provider", "Lru/yoomoney/sdk/auth/api/account/socialAccount/model/OauthServiceProvider;", "linkStatus", "Lru/yoomoney/sdk/auth/OauthResult$OauthLinkStatus;", "(Lru/yoomoney/sdk/auth/api/account/socialAccount/model/OauthServiceProvider;Lru/yoomoney/sdk/auth/OauthResult$OauthLinkStatus;)V", "getLinkStatus", "()Lru/yoomoney/sdk/auth/OauthResult$OauthLinkStatus;", "getProvider", "()Lru/yoomoney/sdk/auth/api/account/socialAccount/model/OauthServiceProvider;", "component1", "component2", "copy", "describeContents", "", "equals", "", "other", "", "hashCode", "toString", "", "writeToParcel", "", "parcel", "Landroid/os/Parcel;", "flags", "OauthLinkStatus", "auth_release"}, k = 1, mv = {1, 9, 0}, xi = 48)
/* loaded from: classes4.dex */
public final /* data */ class OauthResult implements Parcelable {
    public static final Parcelable.Creator<OauthResult> CREATOR = new Creator();
    private final OauthLinkStatus linkStatus;
    private final OauthServiceProvider provider;

    @Metadata(k = 3, mv = {1, 9, 0}, xi = 48)
    public static final class Creator implements Parcelable.Creator<OauthResult> {
        @Override // android.os.Parcelable.Creator
        public final OauthResult createFromParcel(Parcel parcel) {
            Intrinsics.checkNotNullParameter(parcel, "parcel");
            return new OauthResult(OauthServiceProvider.valueOf(parcel.readString()), OauthLinkStatus.valueOf(parcel.readString()));
        }

        @Override // android.os.Parcelable.Creator
        public final OauthResult[] newArray(int i) {
            return new OauthResult[i];
        }
    }

    /* JADX WARN: Failed to restore enum class, 'enum' modifier and super class removed */
    /* JADX WARN: Unknown enum class pattern. Please report as an issue! */
    @Metadata(d1 = {"\u0000\f\n\u0002\u0018\u0002\n\u0002\u0010\u0010\n\u0002\b\u0004\b\u0086\u0081\u0002\u0018\u00002\b\u0012\u0004\u0012\u00020\u00000\u0001B\u0007\b\u0002¢\u0006\u0002\u0010\u0002j\u0002\b\u0003j\u0002\b\u0004¨\u0006\u0005"}, d2 = {"Lru/yoomoney/sdk/auth/OauthResult$OauthLinkStatus;", "", "(Ljava/lang/String;I)V", "ACCOUNT_CREATED", "ACCOUNT_LINKED", "auth_release"}, k = 1, mv = {1, 9, 0}, xi = 48)
    public static final class OauthLinkStatus {
        private static final /* synthetic */ EnumEntries $ENTRIES;
        private static final /* synthetic */ OauthLinkStatus[] $VALUES;
        public static final OauthLinkStatus ACCOUNT_CREATED = new OauthLinkStatus("ACCOUNT_CREATED", 0);
        public static final OauthLinkStatus ACCOUNT_LINKED = new OauthLinkStatus("ACCOUNT_LINKED", 1);

        private static final /* synthetic */ OauthLinkStatus[] $values() {
            return new OauthLinkStatus[]{ACCOUNT_CREATED, ACCOUNT_LINKED};
        }

        static {
            OauthLinkStatus[] oauthLinkStatusArr$values = $values();
            $VALUES = oauthLinkStatusArr$values;
            $ENTRIES = EnumEntriesKt.enumEntries(oauthLinkStatusArr$values);
        }

        private OauthLinkStatus(String str, int i) {
        }

        public static EnumEntries<OauthLinkStatus> getEntries() {
            return $ENTRIES;
        }

        public static OauthLinkStatus valueOf(String str) {
            return (OauthLinkStatus) Enum.valueOf(OauthLinkStatus.class, str);
        }

        public static OauthLinkStatus[] values() {
            return (OauthLinkStatus[]) $VALUES.clone();
        }
    }

    public OauthResult(OauthServiceProvider provider, OauthLinkStatus linkStatus) {
        Intrinsics.checkNotNullParameter(provider, "provider");
        Intrinsics.checkNotNullParameter(linkStatus, "linkStatus");
        this.provider = provider;
        this.linkStatus = linkStatus;
    }

    public static /* synthetic */ OauthResult copy$default(OauthResult oauthResult, OauthServiceProvider oauthServiceProvider, OauthLinkStatus oauthLinkStatus, int i, Object obj) {
        if ((i & 1) != 0) {
            oauthServiceProvider = oauthResult.provider;
        }
        if ((i & 2) != 0) {
            oauthLinkStatus = oauthResult.linkStatus;
        }
        return oauthResult.copy(oauthServiceProvider, oauthLinkStatus);
    }

    /* renamed from: component1, reason: from getter */
    public final OauthServiceProvider getProvider() {
        return this.provider;
    }

    /* renamed from: component2, reason: from getter */
    public final OauthLinkStatus getLinkStatus() {
        return this.linkStatus;
    }

    public final OauthResult copy(OauthServiceProvider provider, OauthLinkStatus linkStatus) {
        Intrinsics.checkNotNullParameter(provider, "provider");
        Intrinsics.checkNotNullParameter(linkStatus, "linkStatus");
        return new OauthResult(provider, linkStatus);
    }

    @Override // android.os.Parcelable
    public int describeContents() {
        return 0;
    }

    public boolean equals(Object other) {
        if (this == other) {
            return true;
        }
        if (!(other instanceof OauthResult)) {
            return false;
        }
        OauthResult oauthResult = (OauthResult) other;
        return this.provider == oauthResult.provider && this.linkStatus == oauthResult.linkStatus;
    }

    public final OauthLinkStatus getLinkStatus() {
        return this.linkStatus;
    }

    public final OauthServiceProvider getProvider() {
        return this.provider;
    }

    public int hashCode() {
        return this.linkStatus.hashCode() + (this.provider.hashCode() * 31);
    }

    public String toString() {
        return "OauthResult(provider=" + this.provider + ", linkStatus=" + this.linkStatus + ")";
    }

    @Override // android.os.Parcelable
    public void writeToParcel(Parcel parcel, int flags) {
        Intrinsics.checkNotNullParameter(parcel, "out");
        parcel.writeString(this.provider.name());
        parcel.writeString(this.linkStatus.name());
    }
}

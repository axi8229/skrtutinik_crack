package ru.yoomoney.sdk.auth.api.account.socialAccount.model;

import android.os.Parcel;
import android.os.Parcelable;
import com.google.gson.annotations.SerializedName;
import com.huawei.updatesdk.service.otaupdate.UpdateKey;
import kotlin.Metadata;
import kotlin.enums.EnumEntries;
import kotlin.enums.EnumEntriesKt;
import kotlin.jvm.internal.Intrinsics;
import ru.yoomoney.sdk.auth.api.account.socialAccount.model.BindSocialAccountResult;

@Metadata(d1 = {"\u0000F\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\f\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\b\u0081\b\u0018\u00002\u00020\u0001:\u0001!B\u001f\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\b\u0010\u0004\u001a\u0004\u0018\u00010\u0005\u0012\u0006\u0010\u0006\u001a\u00020\u0007¢\u0006\u0002\u0010\bJ\t\u0010\u000f\u001a\u00020\u0003HÆ\u0003J\u000b\u0010\u0010\u001a\u0004\u0018\u00010\u0005HÆ\u0003J\t\u0010\u0011\u001a\u00020\u0007HÆ\u0003J)\u0010\u0012\u001a\u00020\u00002\b\b\u0002\u0010\u0002\u001a\u00020\u00032\n\b\u0002\u0010\u0004\u001a\u0004\u0018\u00010\u00052\b\b\u0002\u0010\u0006\u001a\u00020\u0007HÆ\u0001J\t\u0010\u0013\u001a\u00020\u0014HÖ\u0001J\u0013\u0010\u0015\u001a\u00020\u00162\b\u0010\u0017\u001a\u0004\u0018\u00010\u0018HÖ\u0003J\t\u0010\u0019\u001a\u00020\u0014HÖ\u0001J\t\u0010\u001a\u001a\u00020\u001bHÖ\u0001J\u0019\u0010\u001c\u001a\u00020\u001d2\u0006\u0010\u001e\u001a\u00020\u001f2\u0006\u0010 \u001a\u00020\u0014HÖ\u0001R\u0016\u0010\u0006\u001a\u00020\u00078\u0006X\u0087\u0004¢\u0006\b\n\u0000\u001a\u0004\b\t\u0010\nR\u0018\u0010\u0004\u001a\u0004\u0018\u00010\u00058\u0016X\u0097\u0004¢\u0006\b\n\u0000\u001a\u0004\b\u000b\u0010\fR\u0016\u0010\u0002\u001a\u00020\u00038\u0016X\u0097\u0004¢\u0006\b\n\u0000\u001a\u0004\b\r\u0010\u000e¨\u0006\""}, d2 = {"Lru/yoomoney/sdk/auth/api/account/socialAccount/model/BindSocialAccountFailResult;", "Lru/yoomoney/sdk/auth/api/account/socialAccount/model/BindSocialAccountResult;", UpdateKey.STATUS, "Lru/yoomoney/sdk/auth/api/account/socialAccount/model/BindSocialAccountResult$Status;", "service", "Lru/yoomoney/sdk/auth/api/account/socialAccount/model/OauthServiceProvider;", "reason", "Lru/yoomoney/sdk/auth/api/account/socialAccount/model/BindSocialAccountFailResult$Reason;", "(Lru/yoomoney/sdk/auth/api/account/socialAccount/model/BindSocialAccountResult$Status;Lru/yoomoney/sdk/auth/api/account/socialAccount/model/OauthServiceProvider;Lru/yoomoney/sdk/auth/api/account/socialAccount/model/BindSocialAccountFailResult$Reason;)V", "getReason", "()Lru/yoomoney/sdk/auth/api/account/socialAccount/model/BindSocialAccountFailResult$Reason;", "getService", "()Lru/yoomoney/sdk/auth/api/account/socialAccount/model/OauthServiceProvider;", "getStatus", "()Lru/yoomoney/sdk/auth/api/account/socialAccount/model/BindSocialAccountResult$Status;", "component1", "component2", "component3", "copy", "describeContents", "", "equals", "", "other", "", "hashCode", "toString", "", "writeToParcel", "", "parcel", "Landroid/os/Parcel;", "flags", "Reason", "auth_release"}, k = 1, mv = {1, 9, 0}, xi = 48)
/* loaded from: classes4.dex */
public final /* data */ class BindSocialAccountFailResult extends BindSocialAccountResult {
    public static final Parcelable.Creator<BindSocialAccountFailResult> CREATOR = new Creator();

    @SerializedName("reason")
    private final Reason reason;

    @SerializedName("service")
    private final OauthServiceProvider service;

    @SerializedName(UpdateKey.STATUS)
    private final BindSocialAccountResult.Status status;

    @Metadata(k = 3, mv = {1, 9, 0}, xi = 48)
    public static final class Creator implements Parcelable.Creator<BindSocialAccountFailResult> {
        @Override // android.os.Parcelable.Creator
        public final BindSocialAccountFailResult createFromParcel(Parcel parcel) {
            Intrinsics.checkNotNullParameter(parcel, "parcel");
            return new BindSocialAccountFailResult(BindSocialAccountResult.Status.valueOf(parcel.readString()), parcel.readInt() == 0 ? null : OauthServiceProvider.valueOf(parcel.readString()), Reason.valueOf(parcel.readString()));
        }

        @Override // android.os.Parcelable.Creator
        public final BindSocialAccountFailResult[] newArray(int i) {
            return new BindSocialAccountFailResult[i];
        }
    }

    /* JADX WARN: Failed to restore enum class, 'enum' modifier and super class removed */
    /* JADX WARN: Unknown enum class pattern. Please report as an issue! */
    @Metadata(d1 = {"\u0000\f\n\u0002\u0018\u0002\n\u0002\u0010\u0010\n\u0002\b\u0004\b\u0086\u0081\u0002\u0018\u00002\b\u0012\u0004\u0012\u00020\u00000\u0001B\u0007\b\u0002¢\u0006\u0002\u0010\u0002j\u0002\b\u0003j\u0002\b\u0004¨\u0006\u0005"}, d2 = {"Lru/yoomoney/sdk/auth/api/account/socialAccount/model/BindSocialAccountFailResult$Reason;", "", "(Ljava/lang/String;I)V", "SOCIAL_ACCOUNT_ALREADY_BOUND", "TECHNICAL_ERROR", "auth_release"}, k = 1, mv = {1, 9, 0}, xi = 48)
    public static final class Reason {
        private static final /* synthetic */ EnumEntries $ENTRIES;
        private static final /* synthetic */ Reason[] $VALUES;

        @SerializedName("SocialAccountAlreadyBound")
        public static final Reason SOCIAL_ACCOUNT_ALREADY_BOUND = new Reason("SOCIAL_ACCOUNT_ALREADY_BOUND", 0);

        @SerializedName("TechnicalError")
        public static final Reason TECHNICAL_ERROR = new Reason("TECHNICAL_ERROR", 1);

        private static final /* synthetic */ Reason[] $values() {
            return new Reason[]{SOCIAL_ACCOUNT_ALREADY_BOUND, TECHNICAL_ERROR};
        }

        static {
            Reason[] reasonArr$values = $values();
            $VALUES = reasonArr$values;
            $ENTRIES = EnumEntriesKt.enumEntries(reasonArr$values);
        }

        private Reason(String str, int i) {
        }

        public static EnumEntries<Reason> getEntries() {
            return $ENTRIES;
        }

        public static Reason valueOf(String str) {
            return (Reason) Enum.valueOf(Reason.class, str);
        }

        public static Reason[] values() {
            return (Reason[]) $VALUES.clone();
        }
    }

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public BindSocialAccountFailResult(BindSocialAccountResult.Status status, OauthServiceProvider oauthServiceProvider, Reason reason) {
        super(null);
        Intrinsics.checkNotNullParameter(status, "status");
        Intrinsics.checkNotNullParameter(reason, "reason");
        this.status = status;
        this.service = oauthServiceProvider;
        this.reason = reason;
    }

    public static /* synthetic */ BindSocialAccountFailResult copy$default(BindSocialAccountFailResult bindSocialAccountFailResult, BindSocialAccountResult.Status status, OauthServiceProvider oauthServiceProvider, Reason reason, int i, Object obj) {
        if ((i & 1) != 0) {
            status = bindSocialAccountFailResult.status;
        }
        if ((i & 2) != 0) {
            oauthServiceProvider = bindSocialAccountFailResult.service;
        }
        if ((i & 4) != 0) {
            reason = bindSocialAccountFailResult.reason;
        }
        return bindSocialAccountFailResult.copy(status, oauthServiceProvider, reason);
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
    public final Reason getReason() {
        return this.reason;
    }

    public final BindSocialAccountFailResult copy(BindSocialAccountResult.Status status, OauthServiceProvider service, Reason reason) {
        Intrinsics.checkNotNullParameter(status, "status");
        Intrinsics.checkNotNullParameter(reason, "reason");
        return new BindSocialAccountFailResult(status, service, reason);
    }

    @Override // android.os.Parcelable
    public int describeContents() {
        return 0;
    }

    public boolean equals(Object other) {
        if (this == other) {
            return true;
        }
        if (!(other instanceof BindSocialAccountFailResult)) {
            return false;
        }
        BindSocialAccountFailResult bindSocialAccountFailResult = (BindSocialAccountFailResult) other;
        return this.status == bindSocialAccountFailResult.status && this.service == bindSocialAccountFailResult.service && this.reason == bindSocialAccountFailResult.reason;
    }

    public final Reason getReason() {
        return this.reason;
    }

    @Override // ru.yoomoney.sdk.auth.api.account.socialAccount.model.BindSocialAccountResult
    public OauthServiceProvider getService() {
        return this.service;
    }

    @Override // ru.yoomoney.sdk.auth.api.account.socialAccount.model.BindSocialAccountResult
    public BindSocialAccountResult.Status getStatus() {
        return this.status;
    }

    public int hashCode() {
        int iHashCode = this.status.hashCode() * 31;
        OauthServiceProvider oauthServiceProvider = this.service;
        return this.reason.hashCode() + ((iHashCode + (oauthServiceProvider == null ? 0 : oauthServiceProvider.hashCode())) * 31);
    }

    public String toString() {
        return "BindSocialAccountFailResult(status=" + this.status + ", service=" + this.service + ", reason=" + this.reason + ")";
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
        parcel.writeString(this.reason.name());
    }
}

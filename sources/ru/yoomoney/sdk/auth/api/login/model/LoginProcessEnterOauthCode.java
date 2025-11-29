package ru.yoomoney.sdk.auth.api.login.model;

import android.os.Parcel;
import android.os.Parcelable;
import com.google.gson.annotations.SerializedName;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import org.threeten.bp.OffsetDateTime;
import ru.yoomoney.sdk.auth.api.account.socialAccount.model.OauthCodeParameters;
import ru.yoomoney.sdk.auth.api.account.socialAccount.model.OauthServiceProvider;
import ru.yoomoney.sdk.auth.b;

@Metadata(d1 = {"\u0000L\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000b\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0012\n\u0002\u0010\b\n\u0002\b\u0002\n\u0002\u0010\u0000\n\u0002\b\u0003\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\b\u0081\b\u0018\u00002\u00020\u00012\u00020\u0002B-\u0012\u0006\u0010\u0003\u001a\u00020\u0004\u0012\u0006\u0010\u0005\u001a\u00020\u0006\u0012\u0006\u0010\u0007\u001a\u00020\b\u0012\u0006\u0010\t\u001a\u00020\n\u0012\u0006\u0010\u000b\u001a\u00020\f¢\u0006\u0002\u0010\rJ\t\u0010\u0018\u001a\u00020\u0004HÆ\u0003J\t\u0010\u0019\u001a\u00020\u0006HÆ\u0003J\t\u0010\u001a\u001a\u00020\bHÆ\u0003J\t\u0010\u001b\u001a\u00020\nHÆ\u0003J\t\u0010\u001c\u001a\u00020\fHÆ\u0003J;\u0010\u001d\u001a\u00020\u00002\b\b\u0002\u0010\u0003\u001a\u00020\u00042\b\b\u0002\u0010\u0005\u001a\u00020\u00062\b\b\u0002\u0010\u0007\u001a\u00020\b2\b\b\u0002\u0010\t\u001a\u00020\n2\b\b\u0002\u0010\u000b\u001a\u00020\fHÆ\u0001J\t\u0010\u001e\u001a\u00020\u001fHÖ\u0001J\u0013\u0010 \u001a\u00020\b2\b\u0010!\u001a\u0004\u0018\u00010\"HÖ\u0003J\t\u0010#\u001a\u00020\u001fHÖ\u0001J\t\u0010$\u001a\u00020\u0004HÖ\u0001J\u0019\u0010%\u001a\u00020&2\u0006\u0010'\u001a\u00020(2\u0006\u0010)\u001a\u00020\u001fHÖ\u0001R\u0016\u0010\u0007\u001a\u00020\b8\u0016X\u0097\u0004¢\u0006\b\n\u0000\u001a\u0004\b\u000e\u0010\u000fR\u0016\u0010\u0005\u001a\u00020\u00068\u0016X\u0097\u0004¢\u0006\b\n\u0000\u001a\u0004\b\u0010\u0010\u0011R\u0016\u0010\u0003\u001a\u00020\u00048\u0016X\u0097\u0004¢\u0006\b\n\u0000\u001a\u0004\b\u0012\u0010\u0013R\u0016\u0010\u000b\u001a\u00020\f8\u0006X\u0087\u0004¢\u0006\b\n\u0000\u001a\u0004\b\u0014\u0010\u0015R\u0016\u0010\t\u001a\u00020\n8\u0006X\u0087\u0004¢\u0006\b\n\u0000\u001a\u0004\b\u0016\u0010\u0017¨\u0006*"}, d2 = {"Lru/yoomoney/sdk/auth/api/login/model/LoginProcessEnterOauthCode;", "Lru/yoomoney/sdk/auth/api/login/model/LoginProcess;", "Landroid/os/Parcelable;", "id", "", "expireAt", "Lorg/threeten/bp/OffsetDateTime;", "addToBackStack", "", "oauthService", "Lru/yoomoney/sdk/auth/api/account/socialAccount/model/OauthServiceProvider;", "oauthCodeParameters", "Lru/yoomoney/sdk/auth/api/account/socialAccount/model/OauthCodeParameters;", "(Ljava/lang/String;Lorg/threeten/bp/OffsetDateTime;ZLru/yoomoney/sdk/auth/api/account/socialAccount/model/OauthServiceProvider;Lru/yoomoney/sdk/auth/api/account/socialAccount/model/OauthCodeParameters;)V", "getAddToBackStack", "()Z", "getExpireAt", "()Lorg/threeten/bp/OffsetDateTime;", "getId", "()Ljava/lang/String;", "getOauthCodeParameters", "()Lru/yoomoney/sdk/auth/api/account/socialAccount/model/OauthCodeParameters;", "getOauthService", "()Lru/yoomoney/sdk/auth/api/account/socialAccount/model/OauthServiceProvider;", "component1", "component2", "component3", "component4", "component5", "copy", "describeContents", "", "equals", "other", "", "hashCode", "toString", "writeToParcel", "", "parcel", "Landroid/os/Parcel;", "flags", "auth_release"}, k = 1, mv = {1, 9, 0}, xi = 48)
/* loaded from: classes4.dex */
public final /* data */ class LoginProcessEnterOauthCode extends LoginProcess implements Parcelable {
    public static final Parcelable.Creator<LoginProcessEnterOauthCode> CREATOR = new Creator();

    @SerializedName("addToBackStack")
    private final boolean addToBackStack;

    @SerializedName("expireAt")
    private final OffsetDateTime expireAt;

    @SerializedName("id")
    private final String id;

    @SerializedName("oauthCodeParameters")
    private final OauthCodeParameters oauthCodeParameters;

    @SerializedName("oauthService")
    private final OauthServiceProvider oauthService;

    @Metadata(k = 3, mv = {1, 9, 0}, xi = 48)
    public static final class Creator implements Parcelable.Creator<LoginProcessEnterOauthCode> {
        @Override // android.os.Parcelable.Creator
        public final LoginProcessEnterOauthCode createFromParcel(Parcel parcel) {
            Intrinsics.checkNotNullParameter(parcel, "parcel");
            return new LoginProcessEnterOauthCode(parcel.readString(), (OffsetDateTime) parcel.readSerializable(), parcel.readInt() != 0, OauthServiceProvider.valueOf(parcel.readString()), (OauthCodeParameters) parcel.readParcelable(LoginProcessEnterOauthCode.class.getClassLoader()));
        }

        @Override // android.os.Parcelable.Creator
        public final LoginProcessEnterOauthCode[] newArray(int i) {
            return new LoginProcessEnterOauthCode[i];
        }
    }

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public LoginProcessEnterOauthCode(String id, OffsetDateTime expireAt, boolean z, OauthServiceProvider oauthService, OauthCodeParameters oauthCodeParameters) {
        super(null);
        Intrinsics.checkNotNullParameter(id, "id");
        Intrinsics.checkNotNullParameter(expireAt, "expireAt");
        Intrinsics.checkNotNullParameter(oauthService, "oauthService");
        Intrinsics.checkNotNullParameter(oauthCodeParameters, "oauthCodeParameters");
        this.id = id;
        this.expireAt = expireAt;
        this.addToBackStack = z;
        this.oauthService = oauthService;
        this.oauthCodeParameters = oauthCodeParameters;
    }

    public static /* synthetic */ LoginProcessEnterOauthCode copy$default(LoginProcessEnterOauthCode loginProcessEnterOauthCode, String str, OffsetDateTime offsetDateTime, boolean z, OauthServiceProvider oauthServiceProvider, OauthCodeParameters oauthCodeParameters, int i, Object obj) {
        if ((i & 1) != 0) {
            str = loginProcessEnterOauthCode.id;
        }
        if ((i & 2) != 0) {
            offsetDateTime = loginProcessEnterOauthCode.expireAt;
        }
        OffsetDateTime offsetDateTime2 = offsetDateTime;
        if ((i & 4) != 0) {
            z = loginProcessEnterOauthCode.addToBackStack;
        }
        boolean z2 = z;
        if ((i & 8) != 0) {
            oauthServiceProvider = loginProcessEnterOauthCode.oauthService;
        }
        OauthServiceProvider oauthServiceProvider2 = oauthServiceProvider;
        if ((i & 16) != 0) {
            oauthCodeParameters = loginProcessEnterOauthCode.oauthCodeParameters;
        }
        return loginProcessEnterOauthCode.copy(str, offsetDateTime2, z2, oauthServiceProvider2, oauthCodeParameters);
    }

    /* renamed from: component1, reason: from getter */
    public final String getId() {
        return this.id;
    }

    /* renamed from: component2, reason: from getter */
    public final OffsetDateTime getExpireAt() {
        return this.expireAt;
    }

    /* renamed from: component3, reason: from getter */
    public final boolean getAddToBackStack() {
        return this.addToBackStack;
    }

    /* renamed from: component4, reason: from getter */
    public final OauthServiceProvider getOauthService() {
        return this.oauthService;
    }

    /* renamed from: component5, reason: from getter */
    public final OauthCodeParameters getOauthCodeParameters() {
        return this.oauthCodeParameters;
    }

    public final LoginProcessEnterOauthCode copy(String id, OffsetDateTime expireAt, boolean addToBackStack, OauthServiceProvider oauthService, OauthCodeParameters oauthCodeParameters) {
        Intrinsics.checkNotNullParameter(id, "id");
        Intrinsics.checkNotNullParameter(expireAt, "expireAt");
        Intrinsics.checkNotNullParameter(oauthService, "oauthService");
        Intrinsics.checkNotNullParameter(oauthCodeParameters, "oauthCodeParameters");
        return new LoginProcessEnterOauthCode(id, expireAt, addToBackStack, oauthService, oauthCodeParameters);
    }

    @Override // android.os.Parcelable
    public int describeContents() {
        return 0;
    }

    public boolean equals(Object other) {
        if (this == other) {
            return true;
        }
        if (!(other instanceof LoginProcessEnterOauthCode)) {
            return false;
        }
        LoginProcessEnterOauthCode loginProcessEnterOauthCode = (LoginProcessEnterOauthCode) other;
        return Intrinsics.areEqual(this.id, loginProcessEnterOauthCode.id) && Intrinsics.areEqual(this.expireAt, loginProcessEnterOauthCode.expireAt) && this.addToBackStack == loginProcessEnterOauthCode.addToBackStack && this.oauthService == loginProcessEnterOauthCode.oauthService && Intrinsics.areEqual(this.oauthCodeParameters, loginProcessEnterOauthCode.oauthCodeParameters);
    }

    @Override // ru.yoomoney.sdk.auth.api.Process
    public boolean getAddToBackStack() {
        return this.addToBackStack;
    }

    @Override // ru.yoomoney.sdk.auth.api.Process
    public OffsetDateTime getExpireAt() {
        return this.expireAt;
    }

    @Override // ru.yoomoney.sdk.auth.api.Process
    public String getId() {
        return this.id;
    }

    public final OauthCodeParameters getOauthCodeParameters() {
        return this.oauthCodeParameters;
    }

    public final OauthServiceProvider getOauthService() {
        return this.oauthService;
    }

    public int hashCode() {
        return this.oauthCodeParameters.hashCode() + ((this.oauthService.hashCode() + b.a(this.addToBackStack, ru.yoomoney.sdk.auth.api.account.model.b.a(this.expireAt, this.id.hashCode() * 31, 31), 31)) * 31);
    }

    public String toString() {
        return "LoginProcessEnterOauthCode(id=" + this.id + ", expireAt=" + this.expireAt + ", addToBackStack=" + this.addToBackStack + ", oauthService=" + this.oauthService + ", oauthCodeParameters=" + this.oauthCodeParameters + ")";
    }

    @Override // android.os.Parcelable
    public void writeToParcel(Parcel parcel, int flags) {
        Intrinsics.checkNotNullParameter(parcel, "out");
        parcel.writeString(this.id);
        parcel.writeSerializable(this.expireAt);
        parcel.writeInt(this.addToBackStack ? 1 : 0);
        parcel.writeString(this.oauthService.name());
        parcel.writeParcelable(this.oauthCodeParameters, flags);
    }
}

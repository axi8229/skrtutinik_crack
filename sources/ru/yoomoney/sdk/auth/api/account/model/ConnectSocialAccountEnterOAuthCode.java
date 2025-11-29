package ru.yoomoney.sdk.auth.api.account.model;

import com.google.gson.annotations.SerializedName;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import org.threeten.bp.OffsetDateTime;
import ru.yoomoney.sdk.auth.api.account.socialAccount.model.OauthCodeParameters;
import ru.yoomoney.sdk.auth.api.account.socialAccount.model.OauthServiceProvider;

@Metadata(d1 = {"\u00008\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000b\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0013\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\b\n\u0002\b\u0002\b\u0080\b\u0018\u00002\u00020\u0001B-\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\u0006\u0010\u0004\u001a\u00020\u0005\u0012\u0006\u0010\u0006\u001a\u00020\u0007\u0012\u0006\u0010\b\u001a\u00020\t\u0012\u0006\u0010\n\u001a\u00020\u000b¢\u0006\u0002\u0010\fJ\t\u0010\u0017\u001a\u00020\u0003HÆ\u0003J\t\u0010\u0018\u001a\u00020\u0005HÆ\u0003J\t\u0010\u0019\u001a\u00020\u0007HÆ\u0003J\t\u0010\u001a\u001a\u00020\tHÆ\u0003J\t\u0010\u001b\u001a\u00020\u000bHÆ\u0003J;\u0010\u001c\u001a\u00020\u00002\b\b\u0002\u0010\u0002\u001a\u00020\u00032\b\b\u0002\u0010\u0004\u001a\u00020\u00052\b\b\u0002\u0010\u0006\u001a\u00020\u00072\b\b\u0002\u0010\b\u001a\u00020\t2\b\b\u0002\u0010\n\u001a\u00020\u000bHÆ\u0001J\u0013\u0010\u001d\u001a\u00020\u00072\b\u0010\u001e\u001a\u0004\u0018\u00010\u001fHÖ\u0003J\t\u0010 \u001a\u00020!HÖ\u0001J\t\u0010\"\u001a\u00020\u0003HÖ\u0001R\u0016\u0010\u0006\u001a\u00020\u00078\u0016X\u0097\u0004¢\u0006\b\n\u0000\u001a\u0004\b\r\u0010\u000eR\u0016\u0010\u0004\u001a\u00020\u00058\u0016X\u0097\u0004¢\u0006\b\n\u0000\u001a\u0004\b\u000f\u0010\u0010R\u0016\u0010\u0002\u001a\u00020\u00038\u0016X\u0097\u0004¢\u0006\b\n\u0000\u001a\u0004\b\u0011\u0010\u0012R\u0016\u0010\n\u001a\u00020\u000b8\u0006X\u0087\u0004¢\u0006\b\n\u0000\u001a\u0004\b\u0013\u0010\u0014R\u0016\u0010\b\u001a\u00020\t8\u0006X\u0087\u0004¢\u0006\b\n\u0000\u001a\u0004\b\u0015\u0010\u0016¨\u0006#"}, d2 = {"Lru/yoomoney/sdk/auth/api/account/model/ConnectSocialAccountEnterOAuthCode;", "Lru/yoomoney/sdk/auth/api/account/model/ConnectSocialAccountProcess;", "id", "", "expireAt", "Lorg/threeten/bp/OffsetDateTime;", "addToBackStack", "", "oauthService", "Lru/yoomoney/sdk/auth/api/account/socialAccount/model/OauthServiceProvider;", "oauthCodeParameters", "Lru/yoomoney/sdk/auth/api/account/socialAccount/model/OauthCodeParameters;", "(Ljava/lang/String;Lorg/threeten/bp/OffsetDateTime;ZLru/yoomoney/sdk/auth/api/account/socialAccount/model/OauthServiceProvider;Lru/yoomoney/sdk/auth/api/account/socialAccount/model/OauthCodeParameters;)V", "getAddToBackStack", "()Z", "getExpireAt", "()Lorg/threeten/bp/OffsetDateTime;", "getId", "()Ljava/lang/String;", "getOauthCodeParameters", "()Lru/yoomoney/sdk/auth/api/account/socialAccount/model/OauthCodeParameters;", "getOauthService", "()Lru/yoomoney/sdk/auth/api/account/socialAccount/model/OauthServiceProvider;", "component1", "component2", "component3", "component4", "component5", "copy", "equals", "other", "", "hashCode", "", "toString", "auth_release"}, k = 1, mv = {1, 9, 0}, xi = 48)
/* loaded from: classes4.dex */
public final /* data */ class ConnectSocialAccountEnterOAuthCode extends ConnectSocialAccountProcess {

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

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public ConnectSocialAccountEnterOAuthCode(String id, OffsetDateTime expireAt, boolean z, OauthServiceProvider oauthService, OauthCodeParameters oauthCodeParameters) {
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

    public static /* synthetic */ ConnectSocialAccountEnterOAuthCode copy$default(ConnectSocialAccountEnterOAuthCode connectSocialAccountEnterOAuthCode, String str, OffsetDateTime offsetDateTime, boolean z, OauthServiceProvider oauthServiceProvider, OauthCodeParameters oauthCodeParameters, int i, Object obj) {
        if ((i & 1) != 0) {
            str = connectSocialAccountEnterOAuthCode.id;
        }
        if ((i & 2) != 0) {
            offsetDateTime = connectSocialAccountEnterOAuthCode.expireAt;
        }
        OffsetDateTime offsetDateTime2 = offsetDateTime;
        if ((i & 4) != 0) {
            z = connectSocialAccountEnterOAuthCode.addToBackStack;
        }
        boolean z2 = z;
        if ((i & 8) != 0) {
            oauthServiceProvider = connectSocialAccountEnterOAuthCode.oauthService;
        }
        OauthServiceProvider oauthServiceProvider2 = oauthServiceProvider;
        if ((i & 16) != 0) {
            oauthCodeParameters = connectSocialAccountEnterOAuthCode.oauthCodeParameters;
        }
        return connectSocialAccountEnterOAuthCode.copy(str, offsetDateTime2, z2, oauthServiceProvider2, oauthCodeParameters);
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

    public final ConnectSocialAccountEnterOAuthCode copy(String id, OffsetDateTime expireAt, boolean addToBackStack, OauthServiceProvider oauthService, OauthCodeParameters oauthCodeParameters) {
        Intrinsics.checkNotNullParameter(id, "id");
        Intrinsics.checkNotNullParameter(expireAt, "expireAt");
        Intrinsics.checkNotNullParameter(oauthService, "oauthService");
        Intrinsics.checkNotNullParameter(oauthCodeParameters, "oauthCodeParameters");
        return new ConnectSocialAccountEnterOAuthCode(id, expireAt, addToBackStack, oauthService, oauthCodeParameters);
    }

    public boolean equals(Object other) {
        if (this == other) {
            return true;
        }
        if (!(other instanceof ConnectSocialAccountEnterOAuthCode)) {
            return false;
        }
        ConnectSocialAccountEnterOAuthCode connectSocialAccountEnterOAuthCode = (ConnectSocialAccountEnterOAuthCode) other;
        return Intrinsics.areEqual(this.id, connectSocialAccountEnterOAuthCode.id) && Intrinsics.areEqual(this.expireAt, connectSocialAccountEnterOAuthCode.expireAt) && this.addToBackStack == connectSocialAccountEnterOAuthCode.addToBackStack && this.oauthService == connectSocialAccountEnterOAuthCode.oauthService && Intrinsics.areEqual(this.oauthCodeParameters, connectSocialAccountEnterOAuthCode.oauthCodeParameters);
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
        return this.oauthCodeParameters.hashCode() + ((this.oauthService.hashCode() + ru.yoomoney.sdk.auth.b.a(this.addToBackStack, b.a(this.expireAt, this.id.hashCode() * 31, 31), 31)) * 31);
    }

    public String toString() {
        return "ConnectSocialAccountEnterOAuthCode(id=" + this.id + ", expireAt=" + this.expireAt + ", addToBackStack=" + this.addToBackStack + ", oauthService=" + this.oauthService + ", oauthCodeParameters=" + this.oauthCodeParameters + ")";
    }
}

package ru.yoomoney.sdk.auth.api.registrationV2.api.model;

import com.fasterxml.jackson.annotation.JsonProperty;
import com.huawei.updatesdk.service.otaupdate.UpdateKey;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import ru.yoomoney.sdk.auth.api.registrationV2.api.model.BindSocialAccountResultBase;

@Metadata(d1 = {"\u00006\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\f\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u000e\n\u0000\b\u0080\b\u0018\u00002\u00020\u0001B#\u0012\b\b\u0001\u0010\u0002\u001a\u00020\u0003\u0012\b\b\u0001\u0010\u0004\u001a\u00020\u0005\u0012\b\b\u0001\u0010\u0006\u001a\u00020\u0007¢\u0006\u0002\u0010\bJ\t\u0010\u000f\u001a\u00020\u0003HÆ\u0003J\t\u0010\u0010\u001a\u00020\u0005HÆ\u0003J\t\u0010\u0011\u001a\u00020\u0007HÆ\u0003J'\u0010\u0012\u001a\u00020\u00002\b\b\u0003\u0010\u0002\u001a\u00020\u00032\b\b\u0003\u0010\u0004\u001a\u00020\u00052\b\b\u0003\u0010\u0006\u001a\u00020\u0007HÆ\u0001J\u0013\u0010\u0013\u001a\u00020\u00142\b\u0010\u0015\u001a\u0004\u0018\u00010\u0016HÖ\u0003J\t\u0010\u0017\u001a\u00020\u0018HÖ\u0001J\t\u0010\u0019\u001a\u00020\u001aHÖ\u0001R\u0014\u0010\u0004\u001a\u00020\u0005X\u0096\u0004¢\u0006\b\n\u0000\u001a\u0004\b\t\u0010\nR\u0011\u0010\u0006\u001a\u00020\u0007¢\u0006\b\n\u0000\u001a\u0004\b\u000b\u0010\fR\u0014\u0010\u0002\u001a\u00020\u0003X\u0096\u0004¢\u0006\b\n\u0000\u001a\u0004\b\r\u0010\u000e¨\u0006\u001b"}, d2 = {"Lru/yoomoney/sdk/auth/api/registrationV2/api/model/BindSocialAccountSuccessResult;", "Lru/yoomoney/sdk/auth/api/registrationV2/api/model/BindSocialAccountResultBase;", UpdateKey.STATUS, "Lru/yoomoney/sdk/auth/api/registrationV2/api/model/BindSocialAccountResultBase$Status;", "service", "Lru/yoomoney/sdk/auth/api/registrationV2/api/model/OauthServiceProvider;", "socialAccount", "Lru/yoomoney/sdk/auth/api/registrationV2/api/model/SocialAccount;", "(Lru/yoomoney/sdk/auth/api/registrationV2/api/model/BindSocialAccountResultBase$Status;Lru/yoomoney/sdk/auth/api/registrationV2/api/model/OauthServiceProvider;Lru/yoomoney/sdk/auth/api/registrationV2/api/model/SocialAccount;)V", "getService", "()Lru/yoomoney/sdk/auth/api/registrationV2/api/model/OauthServiceProvider;", "getSocialAccount", "()Lru/yoomoney/sdk/auth/api/registrationV2/api/model/SocialAccount;", "getStatus", "()Lru/yoomoney/sdk/auth/api/registrationV2/api/model/BindSocialAccountResultBase$Status;", "component1", "component2", "component3", "copy", "equals", "", "other", "", "hashCode", "", "toString", "", "auth_release"}, k = 1, mv = {1, 9, 0}, xi = 48)
/* loaded from: classes4.dex */
public final /* data */ class BindSocialAccountSuccessResult extends BindSocialAccountResultBase {
    private final OauthServiceProvider service;
    private final SocialAccount socialAccount;
    private final BindSocialAccountResultBase.Status status;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public BindSocialAccountSuccessResult(@JsonProperty(UpdateKey.STATUS) BindSocialAccountResultBase.Status status, @JsonProperty("service") OauthServiceProvider service, @JsonProperty("socialAccount") SocialAccount socialAccount) {
        super(null);
        Intrinsics.checkNotNullParameter(status, "status");
        Intrinsics.checkNotNullParameter(service, "service");
        Intrinsics.checkNotNullParameter(socialAccount, "socialAccount");
        this.status = status;
        this.service = service;
        this.socialAccount = socialAccount;
    }

    public static /* synthetic */ BindSocialAccountSuccessResult copy$default(BindSocialAccountSuccessResult bindSocialAccountSuccessResult, BindSocialAccountResultBase.Status status, OauthServiceProvider oauthServiceProvider, SocialAccount socialAccount, int i, Object obj) {
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
    public final BindSocialAccountResultBase.Status getStatus() {
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

    public final BindSocialAccountSuccessResult copy(@JsonProperty(UpdateKey.STATUS) BindSocialAccountResultBase.Status status, @JsonProperty("service") OauthServiceProvider service, @JsonProperty("socialAccount") SocialAccount socialAccount) {
        Intrinsics.checkNotNullParameter(status, "status");
        Intrinsics.checkNotNullParameter(service, "service");
        Intrinsics.checkNotNullParameter(socialAccount, "socialAccount");
        return new BindSocialAccountSuccessResult(status, service, socialAccount);
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

    @Override // ru.yoomoney.sdk.auth.api.registrationV2.api.model.BindSocialAccountResultBase
    public OauthServiceProvider getService() {
        return this.service;
    }

    public final SocialAccount getSocialAccount() {
        return this.socialAccount;
    }

    @Override // ru.yoomoney.sdk.auth.api.registrationV2.api.model.BindSocialAccountResultBase
    public BindSocialAccountResultBase.Status getStatus() {
        return this.status;
    }

    public int hashCode() {
        return this.socialAccount.hashCode() + ((this.service.hashCode() + (this.status.hashCode() * 31)) * 31);
    }

    public String toString() {
        return "BindSocialAccountSuccessResult(status=" + this.status + ", service=" + this.service + ", socialAccount=" + this.socialAccount + ")";
    }
}

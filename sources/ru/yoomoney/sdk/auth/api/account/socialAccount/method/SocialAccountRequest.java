package ru.yoomoney.sdk.auth.api.account.socialAccount.method;

import com.google.gson.annotations.SerializedName;
import kotlin.Metadata;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import ru.yoomoney.sdk.auth.a;
import ru.yoomoney.sdk.auth.api.account.socialAccount.model.OauthServiceProvider;

@Metadata(d1 = {"\u0000(\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u000f\n\u0002\u0010\u000b\n\u0002\b\u0002\n\u0002\u0010\b\n\u0002\b\u0002\b\u0080\b\u0018\u00002\u00020\u0001B)\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\u0006\u0010\u0004\u001a\u00020\u0005\u0012\u0006\u0010\u0006\u001a\u00020\u0005\u0012\n\b\u0002\u0010\u0007\u001a\u0004\u0018\u00010\u0005¢\u0006\u0002\u0010\bJ\t\u0010\u000f\u001a\u00020\u0003HÆ\u0003J\t\u0010\u0010\u001a\u00020\u0005HÆ\u0003J\t\u0010\u0011\u001a\u00020\u0005HÆ\u0003J\u000b\u0010\u0012\u001a\u0004\u0018\u00010\u0005HÆ\u0003J3\u0010\u0013\u001a\u00020\u00002\b\b\u0002\u0010\u0002\u001a\u00020\u00032\b\b\u0002\u0010\u0004\u001a\u00020\u00052\b\b\u0002\u0010\u0006\u001a\u00020\u00052\n\b\u0002\u0010\u0007\u001a\u0004\u0018\u00010\u0005HÆ\u0001J\u0013\u0010\u0014\u001a\u00020\u00152\b\u0010\u0016\u001a\u0004\u0018\u00010\u0001HÖ\u0003J\t\u0010\u0017\u001a\u00020\u0018HÖ\u0001J\t\u0010\u0019\u001a\u00020\u0005HÖ\u0001R\u0016\u0010\u0004\u001a\u00020\u00058\u0006X\u0087\u0004¢\u0006\b\n\u0000\u001a\u0004\b\t\u0010\nR\u0016\u0010\u0006\u001a\u00020\u00058\u0006X\u0087\u0004¢\u0006\b\n\u0000\u001a\u0004\b\u000b\u0010\nR\u0016\u0010\u0002\u001a\u00020\u00038\u0006X\u0087\u0004¢\u0006\b\n\u0000\u001a\u0004\b\f\u0010\rR\u0018\u0010\u0007\u001a\u0004\u0018\u00010\u00058\u0006X\u0087\u0004¢\u0006\b\n\u0000\u001a\u0004\b\u000e\u0010\n¨\u0006\u001a"}, d2 = {"Lru/yoomoney/sdk/auth/api/account/socialAccount/method/SocialAccountRequest;", "", "oauthService", "Lru/yoomoney/sdk/auth/api/account/socialAccount/model/OauthServiceProvider;", "applicationId", "", "clientId", "redirectUrl", "(Lru/yoomoney/sdk/auth/api/account/socialAccount/model/OauthServiceProvider;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;)V", "getApplicationId", "()Ljava/lang/String;", "getClientId", "getOauthService", "()Lru/yoomoney/sdk/auth/api/account/socialAccount/model/OauthServiceProvider;", "getRedirectUrl", "component1", "component2", "component3", "component4", "copy", "equals", "", "other", "hashCode", "", "toString", "auth_release"}, k = 1, mv = {1, 9, 0}, xi = 48)
/* loaded from: classes4.dex */
public final /* data */ class SocialAccountRequest {

    @SerializedName("applicationId")
    private final String applicationId;

    @SerializedName("clientId")
    private final String clientId;

    @SerializedName("oauthService")
    private final OauthServiceProvider oauthService;

    @SerializedName("redirectUrl")
    private final String redirectUrl;

    public SocialAccountRequest(OauthServiceProvider oauthService, String applicationId, String clientId, String str) {
        Intrinsics.checkNotNullParameter(oauthService, "oauthService");
        Intrinsics.checkNotNullParameter(applicationId, "applicationId");
        Intrinsics.checkNotNullParameter(clientId, "clientId");
        this.oauthService = oauthService;
        this.applicationId = applicationId;
        this.clientId = clientId;
        this.redirectUrl = str;
    }

    public static /* synthetic */ SocialAccountRequest copy$default(SocialAccountRequest socialAccountRequest, OauthServiceProvider oauthServiceProvider, String str, String str2, String str3, int i, Object obj) {
        if ((i & 1) != 0) {
            oauthServiceProvider = socialAccountRequest.oauthService;
        }
        if ((i & 2) != 0) {
            str = socialAccountRequest.applicationId;
        }
        if ((i & 4) != 0) {
            str2 = socialAccountRequest.clientId;
        }
        if ((i & 8) != 0) {
            str3 = socialAccountRequest.redirectUrl;
        }
        return socialAccountRequest.copy(oauthServiceProvider, str, str2, str3);
    }

    /* renamed from: component1, reason: from getter */
    public final OauthServiceProvider getOauthService() {
        return this.oauthService;
    }

    /* renamed from: component2, reason: from getter */
    public final String getApplicationId() {
        return this.applicationId;
    }

    /* renamed from: component3, reason: from getter */
    public final String getClientId() {
        return this.clientId;
    }

    /* renamed from: component4, reason: from getter */
    public final String getRedirectUrl() {
        return this.redirectUrl;
    }

    public final SocialAccountRequest copy(OauthServiceProvider oauthService, String applicationId, String clientId, String redirectUrl) {
        Intrinsics.checkNotNullParameter(oauthService, "oauthService");
        Intrinsics.checkNotNullParameter(applicationId, "applicationId");
        Intrinsics.checkNotNullParameter(clientId, "clientId");
        return new SocialAccountRequest(oauthService, applicationId, clientId, redirectUrl);
    }

    public boolean equals(Object other) {
        if (this == other) {
            return true;
        }
        if (!(other instanceof SocialAccountRequest)) {
            return false;
        }
        SocialAccountRequest socialAccountRequest = (SocialAccountRequest) other;
        return this.oauthService == socialAccountRequest.oauthService && Intrinsics.areEqual(this.applicationId, socialAccountRequest.applicationId) && Intrinsics.areEqual(this.clientId, socialAccountRequest.clientId) && Intrinsics.areEqual(this.redirectUrl, socialAccountRequest.redirectUrl);
    }

    public final String getApplicationId() {
        return this.applicationId;
    }

    public final String getClientId() {
        return this.clientId;
    }

    public final OauthServiceProvider getOauthService() {
        return this.oauthService;
    }

    public final String getRedirectUrl() {
        return this.redirectUrl;
    }

    public int hashCode() {
        int iA = a.a(this.clientId, a.a(this.applicationId, this.oauthService.hashCode() * 31, 31), 31);
        String str = this.redirectUrl;
        return iA + (str == null ? 0 : str.hashCode());
    }

    public String toString() {
        return "SocialAccountRequest(oauthService=" + this.oauthService + ", applicationId=" + this.applicationId + ", clientId=" + this.clientId + ", redirectUrl=" + this.redirectUrl + ")";
    }

    public /* synthetic */ SocialAccountRequest(OauthServiceProvider oauthServiceProvider, String str, String str2, String str3, int i, DefaultConstructorMarker defaultConstructorMarker) {
        this(oauthServiceProvider, str, str2, (i & 8) != 0 ? null : str3);
    }
}

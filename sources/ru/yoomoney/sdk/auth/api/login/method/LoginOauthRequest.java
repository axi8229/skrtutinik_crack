package ru.yoomoney.sdk.auth.api.login.method;

import com.google.android.gms.measurement.api.AppMeasurementSdk;
import com.google.gson.annotations.SerializedName;
import kotlin.Metadata;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import ru.yoomoney.sdk.auth.a;
import ru.yoomoney.sdk.auth.api.Origin;
import ru.yoomoney.sdk.auth.api.account.socialAccount.model.OauthServiceProvider;
import ru.yoomoney.sdk.auth.api.login.method.LoginRequest;

@Metadata(d1 = {"\u00002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u000f\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\b\n\u0002\b\u0002\b\u0080\b\u0018\u00002\u00020\u0001B)\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\u0006\u0010\u0004\u001a\u00020\u0005\u0012\u0006\u0010\u0006\u001a\u00020\u0007\u0012\n\b\u0002\u0010\b\u001a\u0004\u0018\u00010\u0007¢\u0006\u0002\u0010\tJ\t\u0010\u0011\u001a\u00020\u0003HÆ\u0003J\t\u0010\u0012\u001a\u00020\u0005HÆ\u0003J\t\u0010\u0013\u001a\u00020\u0007HÆ\u0003J\u000b\u0010\u0014\u001a\u0004\u0018\u00010\u0007HÆ\u0003J3\u0010\u0015\u001a\u00020\u00002\b\b\u0002\u0010\u0002\u001a\u00020\u00032\b\b\u0002\u0010\u0004\u001a\u00020\u00052\b\b\u0002\u0010\u0006\u001a\u00020\u00072\n\b\u0002\u0010\b\u001a\u0004\u0018\u00010\u0007HÆ\u0001J\u0013\u0010\u0016\u001a\u00020\u00172\b\u0010\u0018\u001a\u0004\u0018\u00010\u0019HÖ\u0003J\t\u0010\u001a\u001a\u00020\u001bHÖ\u0001J\t\u0010\u001c\u001a\u00020\u0007HÖ\u0001R\u0016\u0010\u0006\u001a\u00020\u00078\u0006X\u0087\u0004¢\u0006\b\n\u0000\u001a\u0004\b\n\u0010\u000bR\u0016\u0010\u0004\u001a\u00020\u00058\u0006X\u0087\u0004¢\u0006\b\n\u0000\u001a\u0004\b\f\u0010\rR\u0016\u0010\u0002\u001a\u00020\u00038\u0006X\u0087\u0004¢\u0006\b\n\u0000\u001a\u0004\b\u000e\u0010\u000fR\u0018\u0010\b\u001a\u0004\u0018\u00010\u00078\u0006X\u0087\u0004¢\u0006\b\n\u0000\u001a\u0004\b\u0010\u0010\u000b¨\u0006\u001d"}, d2 = {"Lru/yoomoney/sdk/auth/api/login/method/LoginOauthRequest;", "Lru/yoomoney/sdk/auth/api/login/method/LoginRequest;", AppMeasurementSdk.ConditionalUserProperty.ORIGIN, "Lru/yoomoney/sdk/auth/api/Origin;", "oauthService", "Lru/yoomoney/sdk/auth/api/account/socialAccount/model/OauthServiceProvider;", "applicationId", "", "redirectUrl", "(Lru/yoomoney/sdk/auth/api/Origin;Lru/yoomoney/sdk/auth/api/account/socialAccount/model/OauthServiceProvider;Ljava/lang/String;Ljava/lang/String;)V", "getApplicationId", "()Ljava/lang/String;", "getOauthService", "()Lru/yoomoney/sdk/auth/api/account/socialAccount/model/OauthServiceProvider;", "getOrigin", "()Lru/yoomoney/sdk/auth/api/Origin;", "getRedirectUrl", "component1", "component2", "component3", "component4", "copy", "equals", "", "other", "", "hashCode", "", "toString", "auth_release"}, k = 1, mv = {1, 9, 0}, xi = 48)
/* loaded from: classes4.dex */
public final /* data */ class LoginOauthRequest extends LoginRequest {

    @SerializedName("applicationId")
    private final String applicationId;

    @SerializedName("oauthService")
    private final OauthServiceProvider oauthService;

    @SerializedName(AppMeasurementSdk.ConditionalUserProperty.ORIGIN)
    private final Origin origin;

    @SerializedName("redirectUrl")
    private final String redirectUrl;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public LoginOauthRequest(Origin origin, OauthServiceProvider oauthService, String applicationId, String str) {
        super(LoginRequest.Type.OAUTH, null);
        Intrinsics.checkNotNullParameter(origin, "origin");
        Intrinsics.checkNotNullParameter(oauthService, "oauthService");
        Intrinsics.checkNotNullParameter(applicationId, "applicationId");
        this.origin = origin;
        this.oauthService = oauthService;
        this.applicationId = applicationId;
        this.redirectUrl = str;
    }

    public static /* synthetic */ LoginOauthRequest copy$default(LoginOauthRequest loginOauthRequest, Origin origin, OauthServiceProvider oauthServiceProvider, String str, String str2, int i, Object obj) {
        if ((i & 1) != 0) {
            origin = loginOauthRequest.origin;
        }
        if ((i & 2) != 0) {
            oauthServiceProvider = loginOauthRequest.oauthService;
        }
        if ((i & 4) != 0) {
            str = loginOauthRequest.applicationId;
        }
        if ((i & 8) != 0) {
            str2 = loginOauthRequest.redirectUrl;
        }
        return loginOauthRequest.copy(origin, oauthServiceProvider, str, str2);
    }

    /* renamed from: component1, reason: from getter */
    public final Origin getOrigin() {
        return this.origin;
    }

    /* renamed from: component2, reason: from getter */
    public final OauthServiceProvider getOauthService() {
        return this.oauthService;
    }

    /* renamed from: component3, reason: from getter */
    public final String getApplicationId() {
        return this.applicationId;
    }

    /* renamed from: component4, reason: from getter */
    public final String getRedirectUrl() {
        return this.redirectUrl;
    }

    public final LoginOauthRequest copy(Origin origin, OauthServiceProvider oauthService, String applicationId, String redirectUrl) {
        Intrinsics.checkNotNullParameter(origin, "origin");
        Intrinsics.checkNotNullParameter(oauthService, "oauthService");
        Intrinsics.checkNotNullParameter(applicationId, "applicationId");
        return new LoginOauthRequest(origin, oauthService, applicationId, redirectUrl);
    }

    public boolean equals(Object other) {
        if (this == other) {
            return true;
        }
        if (!(other instanceof LoginOauthRequest)) {
            return false;
        }
        LoginOauthRequest loginOauthRequest = (LoginOauthRequest) other;
        return this.origin == loginOauthRequest.origin && this.oauthService == loginOauthRequest.oauthService && Intrinsics.areEqual(this.applicationId, loginOauthRequest.applicationId) && Intrinsics.areEqual(this.redirectUrl, loginOauthRequest.redirectUrl);
    }

    public final String getApplicationId() {
        return this.applicationId;
    }

    public final OauthServiceProvider getOauthService() {
        return this.oauthService;
    }

    public final Origin getOrigin() {
        return this.origin;
    }

    public final String getRedirectUrl() {
        return this.redirectUrl;
    }

    public int hashCode() {
        int iA = a.a(this.applicationId, (this.oauthService.hashCode() + (this.origin.hashCode() * 31)) * 31, 31);
        String str = this.redirectUrl;
        return iA + (str == null ? 0 : str.hashCode());
    }

    public String toString() {
        return "LoginOauthRequest(origin=" + this.origin + ", oauthService=" + this.oauthService + ", applicationId=" + this.applicationId + ", redirectUrl=" + this.redirectUrl + ")";
    }

    public /* synthetic */ LoginOauthRequest(Origin origin, OauthServiceProvider oauthServiceProvider, String str, String str2, int i, DefaultConstructorMarker defaultConstructorMarker) {
        this(origin, oauthServiceProvider, str, (i & 8) != 0 ? null : str2);
    }
}

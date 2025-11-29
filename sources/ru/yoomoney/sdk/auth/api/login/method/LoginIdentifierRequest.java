package ru.yoomoney.sdk.auth.api.login.method;

import com.google.android.gms.measurement.api.AppMeasurementSdk;
import com.google.gson.annotations.SerializedName;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import ru.yoomoney.sdk.auth.api.Origin;
import ru.yoomoney.sdk.auth.api.login.method.LoginRequest;

@Metadata(d1 = {"\u0000,\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0002\b\t\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\b\n\u0002\b\u0002\b\u0080\b\u0018\u00002\u00020\u0001B\u0017\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\b\u0010\u0004\u001a\u0004\u0018\u00010\u0005¢\u0006\u0002\u0010\u0006J\t\u0010\u000b\u001a\u00020\u0003HÆ\u0003J\u000b\u0010\f\u001a\u0004\u0018\u00010\u0005HÆ\u0003J\u001f\u0010\r\u001a\u00020\u00002\b\b\u0002\u0010\u0002\u001a\u00020\u00032\n\b\u0002\u0010\u0004\u001a\u0004\u0018\u00010\u0005HÆ\u0001J\u0013\u0010\u000e\u001a\u00020\u000f2\b\u0010\u0010\u001a\u0004\u0018\u00010\u0011HÖ\u0003J\t\u0010\u0012\u001a\u00020\u0013HÖ\u0001J\t\u0010\u0014\u001a\u00020\u0005HÖ\u0001R\u0018\u0010\u0004\u001a\u0004\u0018\u00010\u00058\u0006X\u0087\u0004¢\u0006\b\n\u0000\u001a\u0004\b\u0007\u0010\bR\u0016\u0010\u0002\u001a\u00020\u00038\u0006X\u0087\u0004¢\u0006\b\n\u0000\u001a\u0004\b\t\u0010\n¨\u0006\u0015"}, d2 = {"Lru/yoomoney/sdk/auth/api/login/method/LoginIdentifierRequest;", "Lru/yoomoney/sdk/auth/api/login/method/LoginRequest;", AppMeasurementSdk.ConditionalUserProperty.ORIGIN, "Lru/yoomoney/sdk/auth/api/Origin;", "loginOauthProcessId", "", "(Lru/yoomoney/sdk/auth/api/Origin;Ljava/lang/String;)V", "getLoginOauthProcessId", "()Ljava/lang/String;", "getOrigin", "()Lru/yoomoney/sdk/auth/api/Origin;", "component1", "component2", "copy", "equals", "", "other", "", "hashCode", "", "toString", "auth_release"}, k = 1, mv = {1, 9, 0}, xi = 48)
/* loaded from: classes4.dex */
public final /* data */ class LoginIdentifierRequest extends LoginRequest {

    @SerializedName("loginOauthProcessId")
    private final String loginOauthProcessId;

    @SerializedName(AppMeasurementSdk.ConditionalUserProperty.ORIGIN)
    private final Origin origin;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public LoginIdentifierRequest(Origin origin, String str) {
        super(LoginRequest.Type.IDENTIFIER, null);
        Intrinsics.checkNotNullParameter(origin, "origin");
        this.origin = origin;
        this.loginOauthProcessId = str;
    }

    public static /* synthetic */ LoginIdentifierRequest copy$default(LoginIdentifierRequest loginIdentifierRequest, Origin origin, String str, int i, Object obj) {
        if ((i & 1) != 0) {
            origin = loginIdentifierRequest.origin;
        }
        if ((i & 2) != 0) {
            str = loginIdentifierRequest.loginOauthProcessId;
        }
        return loginIdentifierRequest.copy(origin, str);
    }

    /* renamed from: component1, reason: from getter */
    public final Origin getOrigin() {
        return this.origin;
    }

    /* renamed from: component2, reason: from getter */
    public final String getLoginOauthProcessId() {
        return this.loginOauthProcessId;
    }

    public final LoginIdentifierRequest copy(Origin origin, String loginOauthProcessId) {
        Intrinsics.checkNotNullParameter(origin, "origin");
        return new LoginIdentifierRequest(origin, loginOauthProcessId);
    }

    public boolean equals(Object other) {
        if (this == other) {
            return true;
        }
        if (!(other instanceof LoginIdentifierRequest)) {
            return false;
        }
        LoginIdentifierRequest loginIdentifierRequest = (LoginIdentifierRequest) other;
        return this.origin == loginIdentifierRequest.origin && Intrinsics.areEqual(this.loginOauthProcessId, loginIdentifierRequest.loginOauthProcessId);
    }

    public final String getLoginOauthProcessId() {
        return this.loginOauthProcessId;
    }

    public final Origin getOrigin() {
        return this.origin;
    }

    public int hashCode() {
        int iHashCode = this.origin.hashCode() * 31;
        String str = this.loginOauthProcessId;
        return iHashCode + (str == null ? 0 : str.hashCode());
    }

    public String toString() {
        return "LoginIdentifierRequest(origin=" + this.origin + ", loginOauthProcessId=" + this.loginOauthProcessId + ")";
    }
}

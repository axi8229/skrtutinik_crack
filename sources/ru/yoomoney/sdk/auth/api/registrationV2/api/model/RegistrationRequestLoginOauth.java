package ru.yoomoney.sdk.auth.api.registrationV2.api.model;

import com.fasterxml.jackson.annotation.JsonProperty;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import ru.yoomoney.sdk.auth.api.registrationV2.api.model.RegistrationRequestBase;

@Metadata(d1 = {"\u0000,\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0002\b\t\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\b\n\u0002\b\u0002\b\u0080\b\u0018\u00002\u00020\u0001B\u0019\u0012\b\b\u0001\u0010\u0002\u001a\u00020\u0003\u0012\b\b\u0001\u0010\u0004\u001a\u00020\u0005¢\u0006\u0002\u0010\u0006J\t\u0010\u000b\u001a\u00020\u0003HÆ\u0003J\t\u0010\f\u001a\u00020\u0005HÆ\u0003J\u001d\u0010\r\u001a\u00020\u00002\b\b\u0003\u0010\u0002\u001a\u00020\u00032\b\b\u0003\u0010\u0004\u001a\u00020\u0005HÆ\u0001J\u0013\u0010\u000e\u001a\u00020\u000f2\b\u0010\u0010\u001a\u0004\u0018\u00010\u0011HÖ\u0003J\t\u0010\u0012\u001a\u00020\u0013HÖ\u0001J\t\u0010\u0014\u001a\u00020\u0005HÖ\u0001R\u0011\u0010\u0004\u001a\u00020\u0005¢\u0006\b\n\u0000\u001a\u0004\b\u0007\u0010\bR\u0014\u0010\u0002\u001a\u00020\u0003X\u0096\u0004¢\u0006\b\n\u0000\u001a\u0004\b\t\u0010\n¨\u0006\u0015"}, d2 = {"Lru/yoomoney/sdk/auth/api/registrationV2/api/model/RegistrationRequestLoginOauth;", "Lru/yoomoney/sdk/auth/api/registrationV2/api/model/RegistrationRequestBase;", "type", "Lru/yoomoney/sdk/auth/api/registrationV2/api/model/RegistrationRequestBase$Type;", "loginOauthProcessId", "", "(Lru/yoomoney/sdk/auth/api/registrationV2/api/model/RegistrationRequestBase$Type;Ljava/lang/String;)V", "getLoginOauthProcessId", "()Ljava/lang/String;", "getType", "()Lru/yoomoney/sdk/auth/api/registrationV2/api/model/RegistrationRequestBase$Type;", "component1", "component2", "copy", "equals", "", "other", "", "hashCode", "", "toString", "auth_release"}, k = 1, mv = {1, 9, 0}, xi = 48)
/* loaded from: classes4.dex */
public final /* data */ class RegistrationRequestLoginOauth extends RegistrationRequestBase {
    private final String loginOauthProcessId;
    private final RegistrationRequestBase.Type type;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public RegistrationRequestLoginOauth(@JsonProperty("type") RegistrationRequestBase.Type type, @JsonProperty("loginOauthProcessId") String loginOauthProcessId) {
        super(null);
        Intrinsics.checkNotNullParameter(type, "type");
        Intrinsics.checkNotNullParameter(loginOauthProcessId, "loginOauthProcessId");
        this.type = type;
        this.loginOauthProcessId = loginOauthProcessId;
    }

    public static /* synthetic */ RegistrationRequestLoginOauth copy$default(RegistrationRequestLoginOauth registrationRequestLoginOauth, RegistrationRequestBase.Type type, String str, int i, Object obj) {
        if ((i & 1) != 0) {
            type = registrationRequestLoginOauth.type;
        }
        if ((i & 2) != 0) {
            str = registrationRequestLoginOauth.loginOauthProcessId;
        }
        return registrationRequestLoginOauth.copy(type, str);
    }

    /* renamed from: component1, reason: from getter */
    public final RegistrationRequestBase.Type getType() {
        return this.type;
    }

    /* renamed from: component2, reason: from getter */
    public final String getLoginOauthProcessId() {
        return this.loginOauthProcessId;
    }

    public final RegistrationRequestLoginOauth copy(@JsonProperty("type") RegistrationRequestBase.Type type, @JsonProperty("loginOauthProcessId") String loginOauthProcessId) {
        Intrinsics.checkNotNullParameter(type, "type");
        Intrinsics.checkNotNullParameter(loginOauthProcessId, "loginOauthProcessId");
        return new RegistrationRequestLoginOauth(type, loginOauthProcessId);
    }

    public boolean equals(Object other) {
        if (this == other) {
            return true;
        }
        if (!(other instanceof RegistrationRequestLoginOauth)) {
            return false;
        }
        RegistrationRequestLoginOauth registrationRequestLoginOauth = (RegistrationRequestLoginOauth) other;
        return this.type == registrationRequestLoginOauth.type && Intrinsics.areEqual(this.loginOauthProcessId, registrationRequestLoginOauth.loginOauthProcessId);
    }

    public final String getLoginOauthProcessId() {
        return this.loginOauthProcessId;
    }

    @Override // ru.yoomoney.sdk.auth.api.registrationV2.api.model.RegistrationRequestBase
    public RegistrationRequestBase.Type getType() {
        return this.type;
    }

    public int hashCode() {
        return this.loginOauthProcessId.hashCode() + (this.type.hashCode() * 31);
    }

    public String toString() {
        return "RegistrationRequestLoginOauth(type=" + this.type + ", loginOauthProcessId=" + this.loginOauthProcessId + ")";
    }
}

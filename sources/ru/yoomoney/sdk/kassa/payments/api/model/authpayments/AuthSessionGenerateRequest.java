package ru.yoomoney.sdk.kassa.payments.api.model.authpayments;

import com.fasterxml.jackson.annotation.JsonProperty;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

@Metadata(d1 = {"\u0000(\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0018\u0002\n\u0002\b\t\n\u0002\u0010\u000b\n\u0002\b\u0002\n\u0002\u0010\b\n\u0002\b\u0002\b\u0080\b\u0018\u00002\u00020\u0001B\u0019\u0012\b\b\u0001\u0010\u0002\u001a\u00020\u0003\u0012\b\b\u0001\u0010\u0004\u001a\u00020\u0005¢\u0006\u0002\u0010\u0006J\t\u0010\u000b\u001a\u00020\u0003HÆ\u0003J\t\u0010\f\u001a\u00020\u0005HÆ\u0003J\u001d\u0010\r\u001a\u00020\u00002\b\b\u0003\u0010\u0002\u001a\u00020\u00032\b\b\u0003\u0010\u0004\u001a\u00020\u0005HÆ\u0001J\u0013\u0010\u000e\u001a\u00020\u000f2\b\u0010\u0010\u001a\u0004\u0018\u00010\u0001HÖ\u0003J\t\u0010\u0011\u001a\u00020\u0012HÖ\u0001J\t\u0010\u0013\u001a\u00020\u0003HÖ\u0001R\u0011\u0010\u0002\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u0007\u0010\bR\u0011\u0010\u0004\u001a\u00020\u0005¢\u0006\b\n\u0000\u001a\u0004\b\t\u0010\n¨\u0006\u0014"}, d2 = {"Lru/yoomoney/sdk/kassa/payments/api/model/authpayments/AuthSessionGenerateRequest;", "", "authContextId", "", "authType", "Lru/yoomoney/sdk/kassa/payments/api/model/authpayments/AuthTypes;", "(Ljava/lang/String;Lru/yoomoney/sdk/kassa/payments/api/model/authpayments/AuthTypes;)V", "getAuthContextId", "()Ljava/lang/String;", "getAuthType", "()Lru/yoomoney/sdk/kassa/payments/api/model/authpayments/AuthTypes;", "component1", "component2", "copy", "equals", "", "other", "hashCode", "", "toString", "library_metricaRealRelease"}, k = 1, mv = {1, 9, 0}, xi = 48)
/* loaded from: classes5.dex */
public final /* data */ class AuthSessionGenerateRequest {
    public static final int $stable = 0;
    private final String authContextId;
    private final AuthTypes authType;

    public AuthSessionGenerateRequest(@JsonProperty("authContextId") String authContextId, @JsonProperty("authType") AuthTypes authType) {
        Intrinsics.checkNotNullParameter(authContextId, "authContextId");
        Intrinsics.checkNotNullParameter(authType, "authType");
        this.authContextId = authContextId;
        this.authType = authType;
    }

    public static /* synthetic */ AuthSessionGenerateRequest copy$default(AuthSessionGenerateRequest authSessionGenerateRequest, String str, AuthTypes authTypes, int i, Object obj) {
        if ((i & 1) != 0) {
            str = authSessionGenerateRequest.authContextId;
        }
        if ((i & 2) != 0) {
            authTypes = authSessionGenerateRequest.authType;
        }
        return authSessionGenerateRequest.copy(str, authTypes);
    }

    /* renamed from: component1, reason: from getter */
    public final String getAuthContextId() {
        return this.authContextId;
    }

    /* renamed from: component2, reason: from getter */
    public final AuthTypes getAuthType() {
        return this.authType;
    }

    public final AuthSessionGenerateRequest copy(@JsonProperty("authContextId") String authContextId, @JsonProperty("authType") AuthTypes authType) {
        Intrinsics.checkNotNullParameter(authContextId, "authContextId");
        Intrinsics.checkNotNullParameter(authType, "authType");
        return new AuthSessionGenerateRequest(authContextId, authType);
    }

    public boolean equals(Object other) {
        if (this == other) {
            return true;
        }
        if (!(other instanceof AuthSessionGenerateRequest)) {
            return false;
        }
        AuthSessionGenerateRequest authSessionGenerateRequest = (AuthSessionGenerateRequest) other;
        return Intrinsics.areEqual(this.authContextId, authSessionGenerateRequest.authContextId) && this.authType == authSessionGenerateRequest.authType;
    }

    public final String getAuthContextId() {
        return this.authContextId;
    }

    public final AuthTypes getAuthType() {
        return this.authType;
    }

    public int hashCode() {
        return this.authType.hashCode() + (this.authContextId.hashCode() * 31);
    }

    public String toString() {
        return "AuthSessionGenerateRequest(authContextId=" + this.authContextId + ", authType=" + this.authType + ")";
    }
}

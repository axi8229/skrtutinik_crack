package ru.yoomoney.sdk.kassa.payments.api.model.authpayments;

import com.fasterxml.jackson.annotation.JsonProperty;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

@Metadata(d1 = {"\u0000(\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0018\u0002\n\u0002\b\f\n\u0002\u0010\u000b\n\u0002\b\u0002\n\u0002\u0010\b\n\u0002\b\u0002\b\u0080\b\u0018\u00002\u00020\u0001B#\u0012\b\b\u0001\u0010\u0002\u001a\u00020\u0003\u0012\b\b\u0001\u0010\u0004\u001a\u00020\u0005\u0012\b\b\u0001\u0010\u0006\u001a\u00020\u0003¢\u0006\u0002\u0010\u0007J\t\u0010\r\u001a\u00020\u0003HÆ\u0003J\t\u0010\u000e\u001a\u00020\u0005HÆ\u0003J\t\u0010\u000f\u001a\u00020\u0003HÆ\u0003J'\u0010\u0010\u001a\u00020\u00002\b\b\u0003\u0010\u0002\u001a\u00020\u00032\b\b\u0003\u0010\u0004\u001a\u00020\u00052\b\b\u0003\u0010\u0006\u001a\u00020\u0003HÆ\u0001J\u0013\u0010\u0011\u001a\u00020\u00122\b\u0010\u0013\u001a\u0004\u0018\u00010\u0001HÖ\u0003J\t\u0010\u0014\u001a\u00020\u0015HÖ\u0001J\t\u0010\u0016\u001a\u00020\u0003HÖ\u0001R\u0011\u0010\u0006\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\b\u0010\tR\u0011\u0010\u0002\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\n\u0010\tR\u0011\u0010\u0004\u001a\u00020\u0005¢\u0006\b\n\u0000\u001a\u0004\b\u000b\u0010\f¨\u0006\u0017"}, d2 = {"Lru/yoomoney/sdk/kassa/payments/api/model/authpayments/AuthCheckRequest;", "", "authContextId", "", "authType", "Lru/yoomoney/sdk/kassa/payments/api/model/authpayments/AuthTypes;", "answer", "(Ljava/lang/String;Lru/yoomoney/sdk/kassa/payments/api/model/authpayments/AuthTypes;Ljava/lang/String;)V", "getAnswer", "()Ljava/lang/String;", "getAuthContextId", "getAuthType", "()Lru/yoomoney/sdk/kassa/payments/api/model/authpayments/AuthTypes;", "component1", "component2", "component3", "copy", "equals", "", "other", "hashCode", "", "toString", "library_metricaRealRelease"}, k = 1, mv = {1, 9, 0}, xi = 48)
/* loaded from: classes5.dex */
public final /* data */ class AuthCheckRequest {
    public static final int $stable = 0;
    private final String answer;
    private final String authContextId;
    private final AuthTypes authType;

    public AuthCheckRequest(@JsonProperty("authContextId") String authContextId, @JsonProperty("authType") AuthTypes authType, @JsonProperty("answer") String answer) {
        Intrinsics.checkNotNullParameter(authContextId, "authContextId");
        Intrinsics.checkNotNullParameter(authType, "authType");
        Intrinsics.checkNotNullParameter(answer, "answer");
        this.authContextId = authContextId;
        this.authType = authType;
        this.answer = answer;
    }

    public static /* synthetic */ AuthCheckRequest copy$default(AuthCheckRequest authCheckRequest, String str, AuthTypes authTypes, String str2, int i, Object obj) {
        if ((i & 1) != 0) {
            str = authCheckRequest.authContextId;
        }
        if ((i & 2) != 0) {
            authTypes = authCheckRequest.authType;
        }
        if ((i & 4) != 0) {
            str2 = authCheckRequest.answer;
        }
        return authCheckRequest.copy(str, authTypes, str2);
    }

    /* renamed from: component1, reason: from getter */
    public final String getAuthContextId() {
        return this.authContextId;
    }

    /* renamed from: component2, reason: from getter */
    public final AuthTypes getAuthType() {
        return this.authType;
    }

    /* renamed from: component3, reason: from getter */
    public final String getAnswer() {
        return this.answer;
    }

    public final AuthCheckRequest copy(@JsonProperty("authContextId") String authContextId, @JsonProperty("authType") AuthTypes authType, @JsonProperty("answer") String answer) {
        Intrinsics.checkNotNullParameter(authContextId, "authContextId");
        Intrinsics.checkNotNullParameter(authType, "authType");
        Intrinsics.checkNotNullParameter(answer, "answer");
        return new AuthCheckRequest(authContextId, authType, answer);
    }

    public boolean equals(Object other) {
        if (this == other) {
            return true;
        }
        if (!(other instanceof AuthCheckRequest)) {
            return false;
        }
        AuthCheckRequest authCheckRequest = (AuthCheckRequest) other;
        return Intrinsics.areEqual(this.authContextId, authCheckRequest.authContextId) && this.authType == authCheckRequest.authType && Intrinsics.areEqual(this.answer, authCheckRequest.answer);
    }

    public final String getAnswer() {
        return this.answer;
    }

    public final String getAuthContextId() {
        return this.authContextId;
    }

    public final AuthTypes getAuthType() {
        return this.authType;
    }

    public int hashCode() {
        return this.answer.hashCode() + ((this.authType.hashCode() + (this.authContextId.hashCode() * 31)) * 31);
    }

    public String toString() {
        return "AuthCheckRequest(authContextId=" + this.authContextId + ", authType=" + this.authType + ", answer=" + this.answer + ")";
    }
}

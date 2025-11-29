package ru.yoomoney.sdk.kassa.payments.api.model.authpayments;

import com.fasterxml.jackson.annotation.JsonProperty;
import java.util.List;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

@Metadata(d1 = {"\u00000\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0002\b\t\n\u0002\u0010\u000b\n\u0002\b\u0002\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u000e\n\u0000\b\u0080\b\u0018\u00002\u00020\u0001B\u001f\u0012\b\b\u0001\u0010\u0002\u001a\u00020\u0003\u0012\u000e\b\u0001\u0010\u0004\u001a\b\u0012\u0004\u0012\u00020\u00060\u0005¢\u0006\u0002\u0010\u0007J\t\u0010\f\u001a\u00020\u0003HÆ\u0003J\u000f\u0010\r\u001a\b\u0012\u0004\u0012\u00020\u00060\u0005HÆ\u0003J#\u0010\u000e\u001a\u00020\u00002\b\b\u0003\u0010\u0002\u001a\u00020\u00032\u000e\b\u0003\u0010\u0004\u001a\b\u0012\u0004\u0012\u00020\u00060\u0005HÆ\u0001J\u0013\u0010\u000f\u001a\u00020\u00102\b\u0010\u0011\u001a\u0004\u0018\u00010\u0001HÖ\u0003J\t\u0010\u0012\u001a\u00020\u0013HÖ\u0001J\t\u0010\u0014\u001a\u00020\u0015HÖ\u0001R\u0017\u0010\u0004\u001a\b\u0012\u0004\u0012\u00020\u00060\u0005¢\u0006\b\n\u0000\u001a\u0004\b\b\u0010\tR\u0011\u0010\u0002\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\n\u0010\u000b¨\u0006\u0016"}, d2 = {"Lru/yoomoney/sdk/kassa/payments/api/model/authpayments/AuthContextTypesResult;", "", "defaultAuthType", "Lru/yoomoney/sdk/kassa/payments/api/model/authpayments/AuthTypes;", "authTypes", "", "Lru/yoomoney/sdk/kassa/payments/api/model/authpayments/AuthTypeStateResponse;", "(Lru/yoomoney/sdk/kassa/payments/api/model/authpayments/AuthTypes;Ljava/util/List;)V", "getAuthTypes", "()Ljava/util/List;", "getDefaultAuthType", "()Lru/yoomoney/sdk/kassa/payments/api/model/authpayments/AuthTypes;", "component1", "component2", "copy", "equals", "", "other", "hashCode", "", "toString", "", "library_metricaRealRelease"}, k = 1, mv = {1, 9, 0}, xi = 48)
/* loaded from: classes5.dex */
public final /* data */ class AuthContextTypesResult {
    public static final int $stable = 8;
    private final List<AuthTypeStateResponse> authTypes;
    private final AuthTypes defaultAuthType;

    public AuthContextTypesResult(@JsonProperty("defaultAuthType") AuthTypes defaultAuthType, @JsonProperty("authTypes") List<AuthTypeStateResponse> authTypes) {
        Intrinsics.checkNotNullParameter(defaultAuthType, "defaultAuthType");
        Intrinsics.checkNotNullParameter(authTypes, "authTypes");
        this.defaultAuthType = defaultAuthType;
        this.authTypes = authTypes;
    }

    /* JADX WARN: Multi-variable type inference failed */
    public static /* synthetic */ AuthContextTypesResult copy$default(AuthContextTypesResult authContextTypesResult, AuthTypes authTypes, List list, int i, Object obj) {
        if ((i & 1) != 0) {
            authTypes = authContextTypesResult.defaultAuthType;
        }
        if ((i & 2) != 0) {
            list = authContextTypesResult.authTypes;
        }
        return authContextTypesResult.copy(authTypes, list);
    }

    /* renamed from: component1, reason: from getter */
    public final AuthTypes getDefaultAuthType() {
        return this.defaultAuthType;
    }

    public final List<AuthTypeStateResponse> component2() {
        return this.authTypes;
    }

    public final AuthContextTypesResult copy(@JsonProperty("defaultAuthType") AuthTypes defaultAuthType, @JsonProperty("authTypes") List<AuthTypeStateResponse> authTypes) {
        Intrinsics.checkNotNullParameter(defaultAuthType, "defaultAuthType");
        Intrinsics.checkNotNullParameter(authTypes, "authTypes");
        return new AuthContextTypesResult(defaultAuthType, authTypes);
    }

    public boolean equals(Object other) {
        if (this == other) {
            return true;
        }
        if (!(other instanceof AuthContextTypesResult)) {
            return false;
        }
        AuthContextTypesResult authContextTypesResult = (AuthContextTypesResult) other;
        return this.defaultAuthType == authContextTypesResult.defaultAuthType && Intrinsics.areEqual(this.authTypes, authContextTypesResult.authTypes);
    }

    public final List<AuthTypeStateResponse> getAuthTypes() {
        return this.authTypes;
    }

    public final AuthTypes getDefaultAuthType() {
        return this.defaultAuthType;
    }

    public int hashCode() {
        return this.authTypes.hashCode() + (this.defaultAuthType.hashCode() * 31);
    }

    public String toString() {
        return "AuthContextTypesResult(defaultAuthType=" + this.defaultAuthType + ", authTypes=" + this.authTypes + ")";
    }
}

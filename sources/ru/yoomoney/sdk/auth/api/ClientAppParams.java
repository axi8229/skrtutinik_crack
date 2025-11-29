package ru.yoomoney.sdk.auth.api;

import kotlin.Metadata;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;

@Metadata(d1 = {"\u0000\"\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\u000e\n\u0002\b\t\n\u0002\u0010\u000b\n\u0002\b\u0002\n\u0002\u0010\b\n\u0002\b\u0002\b\u0086\b\u0018\u00002\u00020\u0001B\u0019\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\n\b\u0002\u0010\u0004\u001a\u0004\u0018\u00010\u0003¢\u0006\u0002\u0010\u0005J\t\u0010\t\u001a\u00020\u0003HÆ\u0003J\u000b\u0010\n\u001a\u0004\u0018\u00010\u0003HÆ\u0003J\u001f\u0010\u000b\u001a\u00020\u00002\b\b\u0002\u0010\u0002\u001a\u00020\u00032\n\b\u0002\u0010\u0004\u001a\u0004\u0018\u00010\u0003HÆ\u0001J\u0013\u0010\f\u001a\u00020\r2\b\u0010\u000e\u001a\u0004\u0018\u00010\u0001HÖ\u0003J\t\u0010\u000f\u001a\u00020\u0010HÖ\u0001J\t\u0010\u0011\u001a\u00020\u0003HÖ\u0001R\u0011\u0010\u0002\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u0006\u0010\u0007R\u0013\u0010\u0004\u001a\u0004\u0018\u00010\u0003¢\u0006\b\n\u0000\u001a\u0004\b\b\u0010\u0007¨\u0006\u0012"}, d2 = {"Lru/yoomoney/sdk/auth/api/ClientAppParams;", "", "clientId", "", "clientSecret", "(Ljava/lang/String;Ljava/lang/String;)V", "getClientId", "()Ljava/lang/String;", "getClientSecret", "component1", "component2", "copy", "equals", "", "other", "hashCode", "", "toString", "auth_release"}, k = 1, mv = {1, 9, 0}, xi = 48)
/* loaded from: classes4.dex */
public final /* data */ class ClientAppParams {
    private final String clientId;
    private final String clientSecret;

    public ClientAppParams(String clientId, String str) {
        Intrinsics.checkNotNullParameter(clientId, "clientId");
        this.clientId = clientId;
        this.clientSecret = str;
    }

    public static /* synthetic */ ClientAppParams copy$default(ClientAppParams clientAppParams, String str, String str2, int i, Object obj) {
        if ((i & 1) != 0) {
            str = clientAppParams.clientId;
        }
        if ((i & 2) != 0) {
            str2 = clientAppParams.clientSecret;
        }
        return clientAppParams.copy(str, str2);
    }

    /* renamed from: component1, reason: from getter */
    public final String getClientId() {
        return this.clientId;
    }

    /* renamed from: component2, reason: from getter */
    public final String getClientSecret() {
        return this.clientSecret;
    }

    public final ClientAppParams copy(String clientId, String clientSecret) {
        Intrinsics.checkNotNullParameter(clientId, "clientId");
        return new ClientAppParams(clientId, clientSecret);
    }

    public boolean equals(Object other) {
        if (this == other) {
            return true;
        }
        if (!(other instanceof ClientAppParams)) {
            return false;
        }
        ClientAppParams clientAppParams = (ClientAppParams) other;
        return Intrinsics.areEqual(this.clientId, clientAppParams.clientId) && Intrinsics.areEqual(this.clientSecret, clientAppParams.clientSecret);
    }

    public final String getClientId() {
        return this.clientId;
    }

    public final String getClientSecret() {
        return this.clientSecret;
    }

    public int hashCode() {
        int iHashCode = this.clientId.hashCode() * 31;
        String str = this.clientSecret;
        return iHashCode + (str == null ? 0 : str.hashCode());
    }

    public String toString() {
        return "ClientAppParams(clientId=" + this.clientId + ", clientSecret=" + this.clientSecret + ")";
    }

    public /* synthetic */ ClientAppParams(String str, String str2, int i, DefaultConstructorMarker defaultConstructorMarker) {
        this(str, (i & 2) != 0 ? null : str2);
    }
}

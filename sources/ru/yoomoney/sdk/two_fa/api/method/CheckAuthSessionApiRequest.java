package ru.yoomoney.sdk.two_fa.api.method;

import com.fasterxml.jackson.annotation.JsonProperty;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

/* compiled from: CheckAuthSessionApiRequest.kt */
@Metadata(d1 = {"\u0000\"\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\u000e\n\u0002\b\t\n\u0002\u0010\u000b\n\u0002\b\u0002\n\u0002\u0010\b\n\u0002\b\u0002\b\u0080\b\u0018\u00002\u00020\u0001B\u0019\u0012\b\b\u0001\u0010\u0002\u001a\u00020\u0003\u0012\b\b\u0001\u0010\u0004\u001a\u00020\u0003¢\u0006\u0002\u0010\u0005J\t\u0010\t\u001a\u00020\u0003HÆ\u0003J\t\u0010\n\u001a\u00020\u0003HÆ\u0003J\u001d\u0010\u000b\u001a\u00020\u00002\b\b\u0003\u0010\u0002\u001a\u00020\u00032\b\b\u0003\u0010\u0004\u001a\u00020\u0003HÆ\u0001J\u0013\u0010\f\u001a\u00020\r2\b\u0010\u000e\u001a\u0004\u0018\u00010\u0001HÖ\u0003J\t\u0010\u000f\u001a\u00020\u0010HÖ\u0001J\t\u0010\u0011\u001a\u00020\u0003HÖ\u0001R\u0011\u0010\u0002\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u0006\u0010\u0007R\u0011\u0010\u0004\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\b\u0010\u0007¨\u0006\u0012"}, d2 = {"Lru/yoomoney/sdk/two_fa/api/method/CheckAuthSessionApiRequest;", "", "authProcessId", "", "secret", "(Ljava/lang/String;Ljava/lang/String;)V", "getAuthProcessId", "()Ljava/lang/String;", "getSecret", "component1", "component2", "copy", "equals", "", "other", "hashCode", "", "toString", "two-fa_release"}, k = 1, mv = {1, 9, 0}, xi = 48)
/* loaded from: classes5.dex */
public final /* data */ class CheckAuthSessionApiRequest {
    public static final int $stable = 0;
    private final String authProcessId;
    private final String secret;

    public static /* synthetic */ CheckAuthSessionApiRequest copy$default(CheckAuthSessionApiRequest checkAuthSessionApiRequest, String str, String str2, int i, Object obj) {
        if ((i & 1) != 0) {
            str = checkAuthSessionApiRequest.authProcessId;
        }
        if ((i & 2) != 0) {
            str2 = checkAuthSessionApiRequest.secret;
        }
        return checkAuthSessionApiRequest.copy(str, str2);
    }

    /* renamed from: component1, reason: from getter */
    public final String getAuthProcessId() {
        return this.authProcessId;
    }

    /* renamed from: component2, reason: from getter */
    public final String getSecret() {
        return this.secret;
    }

    public final CheckAuthSessionApiRequest copy(@JsonProperty("authProcessId") String authProcessId, @JsonProperty("secret") String secret) {
        Intrinsics.checkNotNullParameter(authProcessId, "authProcessId");
        Intrinsics.checkNotNullParameter(secret, "secret");
        return new CheckAuthSessionApiRequest(authProcessId, secret);
    }

    public boolean equals(Object other) {
        if (this == other) {
            return true;
        }
        if (!(other instanceof CheckAuthSessionApiRequest)) {
            return false;
        }
        CheckAuthSessionApiRequest checkAuthSessionApiRequest = (CheckAuthSessionApiRequest) other;
        return Intrinsics.areEqual(this.authProcessId, checkAuthSessionApiRequest.authProcessId) && Intrinsics.areEqual(this.secret, checkAuthSessionApiRequest.secret);
    }

    public int hashCode() {
        return (this.authProcessId.hashCode() * 31) + this.secret.hashCode();
    }

    public String toString() {
        return "CheckAuthSessionApiRequest(authProcessId=" + this.authProcessId + ", secret=" + this.secret + ")";
    }

    public CheckAuthSessionApiRequest(@JsonProperty("authProcessId") String authProcessId, @JsonProperty("secret") String secret) {
        Intrinsics.checkNotNullParameter(authProcessId, "authProcessId");
        Intrinsics.checkNotNullParameter(secret, "secret");
        this.authProcessId = authProcessId;
        this.secret = secret;
    }

    public final String getAuthProcessId() {
        return this.authProcessId;
    }

    public final String getSecret() {
        return this.secret;
    }
}

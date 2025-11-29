package ru.yoomoney.sdk.two_fa.api.method;

import com.fasterxml.jackson.annotation.JsonProperty;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

/* compiled from: CheckAuthSessionApiResponse.kt */
@Metadata(d1 = {"\u0000\"\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0006\n\u0002\u0010\u000b\n\u0002\b\u0002\n\u0002\u0010\b\n\u0002\b\u0002\b\u0080\b\u0018\u00002\u00020\u0001B\u000f\u0012\b\b\u0001\u0010\u0002\u001a\u00020\u0003¢\u0006\u0002\u0010\u0004J\t\u0010\u0007\u001a\u00020\u0003HÆ\u0003J\u0013\u0010\b\u001a\u00020\u00002\b\b\u0003\u0010\u0002\u001a\u00020\u0003HÆ\u0001J\u0013\u0010\t\u001a\u00020\n2\b\u0010\u000b\u001a\u0004\u0018\u00010\u0001HÖ\u0003J\t\u0010\f\u001a\u00020\rHÖ\u0001J\t\u0010\u000e\u001a\u00020\u0003HÖ\u0001R\u0011\u0010\u0002\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u0005\u0010\u0006¨\u0006\u000f"}, d2 = {"Lru/yoomoney/sdk/two_fa/api/method/CheckAuthSessionApiResponse;", "", "authProcessId", "", "(Ljava/lang/String;)V", "getAuthProcessId", "()Ljava/lang/String;", "component1", "copy", "equals", "", "other", "hashCode", "", "toString", "two-fa_release"}, k = 1, mv = {1, 9, 0}, xi = 48)
/* loaded from: classes5.dex */
public final /* data */ class CheckAuthSessionApiResponse {
    public static final int $stable = 0;
    private final String authProcessId;

    public static /* synthetic */ CheckAuthSessionApiResponse copy$default(CheckAuthSessionApiResponse checkAuthSessionApiResponse, String str, int i, Object obj) {
        if ((i & 1) != 0) {
            str = checkAuthSessionApiResponse.authProcessId;
        }
        return checkAuthSessionApiResponse.copy(str);
    }

    /* renamed from: component1, reason: from getter */
    public final String getAuthProcessId() {
        return this.authProcessId;
    }

    public final CheckAuthSessionApiResponse copy(@JsonProperty("authProcessId") String authProcessId) {
        Intrinsics.checkNotNullParameter(authProcessId, "authProcessId");
        return new CheckAuthSessionApiResponse(authProcessId);
    }

    public boolean equals(Object other) {
        if (this == other) {
            return true;
        }
        return (other instanceof CheckAuthSessionApiResponse) && Intrinsics.areEqual(this.authProcessId, ((CheckAuthSessionApiResponse) other).authProcessId);
    }

    public int hashCode() {
        return this.authProcessId.hashCode();
    }

    public String toString() {
        return "CheckAuthSessionApiResponse(authProcessId=" + this.authProcessId + ")";
    }

    public CheckAuthSessionApiResponse(@JsonProperty("authProcessId") String authProcessId) {
        Intrinsics.checkNotNullParameter(authProcessId, "authProcessId");
        this.authProcessId = authProcessId;
    }

    public final String getAuthProcessId() {
        return this.authProcessId;
    }
}

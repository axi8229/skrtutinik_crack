package ru.yoomoney.sdk.two_fa.api.method;

import com.fasterxml.jackson.annotation.JsonProperty;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import ru.yoomoney.sdk.two_fa.api.model.ApiSessionType;

/* compiled from: StartAuthSessionApiRequest.kt */
@Metadata(d1 = {"\u0000(\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0018\u0002\n\u0002\b\t\n\u0002\u0010\u000b\n\u0002\b\u0002\n\u0002\u0010\b\n\u0002\b\u0002\b\u0080\b\u0018\u00002\u00020\u0001B\u0019\u0012\b\b\u0001\u0010\u0002\u001a\u00020\u0003\u0012\b\b\u0001\u0010\u0004\u001a\u00020\u0005¢\u0006\u0002\u0010\u0006J\t\u0010\u000b\u001a\u00020\u0003HÆ\u0003J\t\u0010\f\u001a\u00020\u0005HÆ\u0003J\u001d\u0010\r\u001a\u00020\u00002\b\b\u0003\u0010\u0002\u001a\u00020\u00032\b\b\u0003\u0010\u0004\u001a\u00020\u0005HÆ\u0001J\u0013\u0010\u000e\u001a\u00020\u000f2\b\u0010\u0010\u001a\u0004\u0018\u00010\u0001HÖ\u0003J\t\u0010\u0011\u001a\u00020\u0012HÖ\u0001J\t\u0010\u0013\u001a\u00020\u0003HÖ\u0001R\u0011\u0010\u0002\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u0007\u0010\bR\u0011\u0010\u0004\u001a\u00020\u0005¢\u0006\b\n\u0000\u001a\u0004\b\t\u0010\n¨\u0006\u0014"}, d2 = {"Lru/yoomoney/sdk/two_fa/api/method/StartAuthSessionApiRequest;", "", "authProcessId", "", "type", "Lru/yoomoney/sdk/two_fa/api/model/ApiSessionType;", "(Ljava/lang/String;Lru/yoomoney/sdk/two_fa/api/model/ApiSessionType;)V", "getAuthProcessId", "()Ljava/lang/String;", "getType", "()Lru/yoomoney/sdk/two_fa/api/model/ApiSessionType;", "component1", "component2", "copy", "equals", "", "other", "hashCode", "", "toString", "two-fa_release"}, k = 1, mv = {1, 9, 0}, xi = 48)
/* loaded from: classes5.dex */
public final /* data */ class StartAuthSessionApiRequest {
    public static final int $stable = 0;
    private final String authProcessId;
    private final ApiSessionType type;

    public static /* synthetic */ StartAuthSessionApiRequest copy$default(StartAuthSessionApiRequest startAuthSessionApiRequest, String str, ApiSessionType apiSessionType, int i, Object obj) {
        if ((i & 1) != 0) {
            str = startAuthSessionApiRequest.authProcessId;
        }
        if ((i & 2) != 0) {
            apiSessionType = startAuthSessionApiRequest.type;
        }
        return startAuthSessionApiRequest.copy(str, apiSessionType);
    }

    /* renamed from: component1, reason: from getter */
    public final String getAuthProcessId() {
        return this.authProcessId;
    }

    /* renamed from: component2, reason: from getter */
    public final ApiSessionType getType() {
        return this.type;
    }

    public final StartAuthSessionApiRequest copy(@JsonProperty("authProcessId") String authProcessId, @JsonProperty("type") ApiSessionType type) {
        Intrinsics.checkNotNullParameter(authProcessId, "authProcessId");
        Intrinsics.checkNotNullParameter(type, "type");
        return new StartAuthSessionApiRequest(authProcessId, type);
    }

    public boolean equals(Object other) {
        if (this == other) {
            return true;
        }
        if (!(other instanceof StartAuthSessionApiRequest)) {
            return false;
        }
        StartAuthSessionApiRequest startAuthSessionApiRequest = (StartAuthSessionApiRequest) other;
        return Intrinsics.areEqual(this.authProcessId, startAuthSessionApiRequest.authProcessId) && this.type == startAuthSessionApiRequest.type;
    }

    public int hashCode() {
        return (this.authProcessId.hashCode() * 31) + this.type.hashCode();
    }

    public String toString() {
        return "StartAuthSessionApiRequest(authProcessId=" + this.authProcessId + ", type=" + this.type + ")";
    }

    public StartAuthSessionApiRequest(@JsonProperty("authProcessId") String authProcessId, @JsonProperty("type") ApiSessionType type) {
        Intrinsics.checkNotNullParameter(authProcessId, "authProcessId");
        Intrinsics.checkNotNullParameter(type, "type");
        this.authProcessId = authProcessId;
        this.type = type;
    }

    public final String getAuthProcessId() {
        return this.authProcessId;
    }

    public final ApiSessionType getType() {
        return this.type;
    }
}

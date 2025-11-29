package ru.yoomoney.sdk.two_fa.api.method;

import com.fasterxml.jackson.annotation.JsonProperty;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import ru.yoomoney.sdk.two_fa.api.model.SessionApi;

/* compiled from: StartAuthSessionApiResponse.kt */
@Metadata(d1 = {"\u0000(\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0018\u0002\n\u0002\b\t\n\u0002\u0010\u000b\n\u0002\b\u0002\n\u0002\u0010\b\n\u0002\b\u0002\b\u0080\b\u0018\u00002\u00020\u0001B\u0019\u0012\b\b\u0001\u0010\u0002\u001a\u00020\u0003\u0012\b\b\u0001\u0010\u0004\u001a\u00020\u0005¢\u0006\u0002\u0010\u0006J\t\u0010\u000b\u001a\u00020\u0003HÆ\u0003J\t\u0010\f\u001a\u00020\u0005HÆ\u0003J\u001d\u0010\r\u001a\u00020\u00002\b\b\u0003\u0010\u0002\u001a\u00020\u00032\b\b\u0003\u0010\u0004\u001a\u00020\u0005HÆ\u0001J\u0013\u0010\u000e\u001a\u00020\u000f2\b\u0010\u0010\u001a\u0004\u0018\u00010\u0001HÖ\u0003J\t\u0010\u0011\u001a\u00020\u0012HÖ\u0001J\t\u0010\u0013\u001a\u00020\u0003HÖ\u0001R\u0011\u0010\u0002\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u0007\u0010\bR\u0011\u0010\u0004\u001a\u00020\u0005¢\u0006\b\n\u0000\u001a\u0004\b\t\u0010\n¨\u0006\u0014"}, d2 = {"Lru/yoomoney/sdk/two_fa/api/method/StartAuthSessionApiResponse;", "", "authProcessId", "", "session", "Lru/yoomoney/sdk/two_fa/api/model/SessionApi;", "(Ljava/lang/String;Lru/yoomoney/sdk/two_fa/api/model/SessionApi;)V", "getAuthProcessId", "()Ljava/lang/String;", "getSession", "()Lru/yoomoney/sdk/two_fa/api/model/SessionApi;", "component1", "component2", "copy", "equals", "", "other", "hashCode", "", "toString", "two-fa_release"}, k = 1, mv = {1, 9, 0}, xi = 48)
/* loaded from: classes5.dex */
public final /* data */ class StartAuthSessionApiResponse {
    public static final int $stable = 0;
    private final String authProcessId;
    private final SessionApi session;

    public static /* synthetic */ StartAuthSessionApiResponse copy$default(StartAuthSessionApiResponse startAuthSessionApiResponse, String str, SessionApi sessionApi, int i, Object obj) {
        if ((i & 1) != 0) {
            str = startAuthSessionApiResponse.authProcessId;
        }
        if ((i & 2) != 0) {
            sessionApi = startAuthSessionApiResponse.session;
        }
        return startAuthSessionApiResponse.copy(str, sessionApi);
    }

    /* renamed from: component1, reason: from getter */
    public final String getAuthProcessId() {
        return this.authProcessId;
    }

    /* renamed from: component2, reason: from getter */
    public final SessionApi getSession() {
        return this.session;
    }

    public final StartAuthSessionApiResponse copy(@JsonProperty("authProcessId") String authProcessId, @JsonProperty("session") SessionApi session) {
        Intrinsics.checkNotNullParameter(authProcessId, "authProcessId");
        Intrinsics.checkNotNullParameter(session, "session");
        return new StartAuthSessionApiResponse(authProcessId, session);
    }

    public boolean equals(Object other) {
        if (this == other) {
            return true;
        }
        if (!(other instanceof StartAuthSessionApiResponse)) {
            return false;
        }
        StartAuthSessionApiResponse startAuthSessionApiResponse = (StartAuthSessionApiResponse) other;
        return Intrinsics.areEqual(this.authProcessId, startAuthSessionApiResponse.authProcessId) && Intrinsics.areEqual(this.session, startAuthSessionApiResponse.session);
    }

    public int hashCode() {
        return (this.authProcessId.hashCode() * 31) + this.session.hashCode();
    }

    public String toString() {
        return "StartAuthSessionApiResponse(authProcessId=" + this.authProcessId + ", session=" + this.session + ")";
    }

    public StartAuthSessionApiResponse(@JsonProperty("authProcessId") String authProcessId, @JsonProperty("session") SessionApi session) {
        Intrinsics.checkNotNullParameter(authProcessId, "authProcessId");
        Intrinsics.checkNotNullParameter(session, "session");
        this.authProcessId = authProcessId;
        this.session = session;
    }

    public final String getAuthProcessId() {
        return this.authProcessId;
    }

    public final SessionApi getSession() {
        return this.session;
    }
}

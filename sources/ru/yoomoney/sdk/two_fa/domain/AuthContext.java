package ru.yoomoney.sdk.two_fa.domain;

import java.util.List;
import kotlin.Metadata;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;

/* compiled from: Domain.kt */
@Metadata(d1 = {"\u00006\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\f\n\u0002\u0010\u000b\n\u0002\b\u0002\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u000e\n\u0000\b\u0080\b\u0018\u00002\u00020\u0001B'\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\f\u0010\u0004\u001a\b\u0012\u0004\u0012\u00020\u00060\u0005\u0012\n\b\u0002\u0010\u0007\u001a\u0004\u0018\u00010\b¢\u0006\u0002\u0010\tJ\t\u0010\u0010\u001a\u00020\u0003HÆ\u0003J\u000f\u0010\u0011\u001a\b\u0012\u0004\u0012\u00020\u00060\u0005HÆ\u0003J\u000b\u0010\u0012\u001a\u0004\u0018\u00010\bHÆ\u0003J/\u0010\u0013\u001a\u00020\u00002\b\b\u0002\u0010\u0002\u001a\u00020\u00032\u000e\b\u0002\u0010\u0004\u001a\b\u0012\u0004\u0012\u00020\u00060\u00052\n\b\u0002\u0010\u0007\u001a\u0004\u0018\u00010\bHÆ\u0001J\u0013\u0010\u0014\u001a\u00020\u00152\b\u0010\u0016\u001a\u0004\u0018\u00010\u0001HÖ\u0003J\t\u0010\u0017\u001a\u00020\u0018HÖ\u0001J\t\u0010\u0019\u001a\u00020\u001aHÖ\u0001R\u0013\u0010\u0007\u001a\u0004\u0018\u00010\b¢\u0006\b\n\u0000\u001a\u0004\b\n\u0010\u000bR\u0011\u0010\u0002\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\f\u0010\rR\u0017\u0010\u0004\u001a\b\u0012\u0004\u0012\u00020\u00060\u0005¢\u0006\b\n\u0000\u001a\u0004\b\u000e\u0010\u000f¨\u0006\u001b"}, d2 = {"Lru/yoomoney/sdk/two_fa/domain/AuthContext;", "", "authStatus", "Lru/yoomoney/sdk/two_fa/domain/AuthStatus;", "availableSessionOptions", "", "Lru/yoomoney/sdk/two_fa/domain/SessionType;", "activeSession", "Lru/yoomoney/sdk/two_fa/domain/Session;", "(Lru/yoomoney/sdk/two_fa/domain/AuthStatus;Ljava/util/List;Lru/yoomoney/sdk/two_fa/domain/Session;)V", "getActiveSession", "()Lru/yoomoney/sdk/two_fa/domain/Session;", "getAuthStatus", "()Lru/yoomoney/sdk/two_fa/domain/AuthStatus;", "getAvailableSessionOptions", "()Ljava/util/List;", "component1", "component2", "component3", "copy", "equals", "", "other", "hashCode", "", "toString", "", "two-fa_release"}, k = 1, mv = {1, 9, 0}, xi = 48)
/* loaded from: classes5.dex */
public final /* data */ class AuthContext {
    public static final int $stable = 8;
    private final Session activeSession;
    private final AuthStatus authStatus;
    private final List<SessionType> availableSessionOptions;

    /* JADX WARN: Multi-variable type inference failed */
    public static /* synthetic */ AuthContext copy$default(AuthContext authContext, AuthStatus authStatus, List list, Session session, int i, Object obj) {
        if ((i & 1) != 0) {
            authStatus = authContext.authStatus;
        }
        if ((i & 2) != 0) {
            list = authContext.availableSessionOptions;
        }
        if ((i & 4) != 0) {
            session = authContext.activeSession;
        }
        return authContext.copy(authStatus, list, session);
    }

    /* renamed from: component1, reason: from getter */
    public final AuthStatus getAuthStatus() {
        return this.authStatus;
    }

    public final List<SessionType> component2() {
        return this.availableSessionOptions;
    }

    /* renamed from: component3, reason: from getter */
    public final Session getActiveSession() {
        return this.activeSession;
    }

    public final AuthContext copy(AuthStatus authStatus, List<? extends SessionType> availableSessionOptions, Session activeSession) {
        Intrinsics.checkNotNullParameter(authStatus, "authStatus");
        Intrinsics.checkNotNullParameter(availableSessionOptions, "availableSessionOptions");
        return new AuthContext(authStatus, availableSessionOptions, activeSession);
    }

    public boolean equals(Object other) {
        if (this == other) {
            return true;
        }
        if (!(other instanceof AuthContext)) {
            return false;
        }
        AuthContext authContext = (AuthContext) other;
        return this.authStatus == authContext.authStatus && Intrinsics.areEqual(this.availableSessionOptions, authContext.availableSessionOptions) && Intrinsics.areEqual(this.activeSession, authContext.activeSession);
    }

    public int hashCode() {
        int iHashCode = ((this.authStatus.hashCode() * 31) + this.availableSessionOptions.hashCode()) * 31;
        Session session = this.activeSession;
        return iHashCode + (session == null ? 0 : session.hashCode());
    }

    public String toString() {
        return "AuthContext(authStatus=" + this.authStatus + ", availableSessionOptions=" + this.availableSessionOptions + ", activeSession=" + this.activeSession + ")";
    }

    /* JADX WARN: Multi-variable type inference failed */
    public AuthContext(AuthStatus authStatus, List<? extends SessionType> availableSessionOptions, Session session) {
        Intrinsics.checkNotNullParameter(authStatus, "authStatus");
        Intrinsics.checkNotNullParameter(availableSessionOptions, "availableSessionOptions");
        this.authStatus = authStatus;
        this.availableSessionOptions = availableSessionOptions;
        this.activeSession = session;
    }

    public /* synthetic */ AuthContext(AuthStatus authStatus, List list, Session session, int i, DefaultConstructorMarker defaultConstructorMarker) {
        this(authStatus, list, (i & 4) != 0 ? null : session);
    }

    public final AuthStatus getAuthStatus() {
        return this.authStatus;
    }

    public final List<SessionType> getAvailableSessionOptions() {
        return this.availableSessionOptions;
    }

    public final Session getActiveSession() {
        return this.activeSession;
    }
}

package ru.yoomoney.sdk.two_fa.domain;

import kotlin.Metadata;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;

/* compiled from: Domain.kt */
@Metadata(d1 = {"\u00002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0018\u0002\n\u0002\b\f\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\b\n\u0002\b\u0002\b\u0080\b\u0018\u00002\u00020\u0001B!\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\u0006\u0010\u0004\u001a\u00020\u0005\u0012\n\b\u0002\u0010\u0006\u001a\u0004\u0018\u00010\u0007¢\u0006\u0002\u0010\bJ\t\u0010\u000f\u001a\u00020\u0003HÆ\u0003J\t\u0010\u0010\u001a\u00020\u0005HÆ\u0003J\u000b\u0010\u0011\u001a\u0004\u0018\u00010\u0007HÆ\u0003J)\u0010\u0012\u001a\u00020\u00002\b\b\u0002\u0010\u0002\u001a\u00020\u00032\b\b\u0002\u0010\u0004\u001a\u00020\u00052\n\b\u0002\u0010\u0006\u001a\u0004\u0018\u00010\u0007HÆ\u0001J\u0013\u0010\u0013\u001a\u00020\u00142\b\u0010\u0015\u001a\u0004\u0018\u00010\u0016HÖ\u0003J\t\u0010\u0017\u001a\u00020\u0018HÖ\u0001J\t\u0010\u0019\u001a\u00020\u0005HÖ\u0001R\u0014\u0010\u0004\u001a\u00020\u0005X\u0096\u0004¢\u0006\b\n\u0000\u001a\u0004\b\t\u0010\nR\u0013\u0010\u0006\u001a\u0004\u0018\u00010\u0007¢\u0006\b\n\u0000\u001a\u0004\b\u000b\u0010\fR\u0014\u0010\u0002\u001a\u00020\u0003X\u0096\u0004¢\u0006\b\n\u0000\u001a\u0004\b\r\u0010\u000e¨\u0006\u001a"}, d2 = {"Lru/yoomoney/sdk/two_fa/domain/ActiveSessionPushApp;", "Lru/yoomoney/sdk/two_fa/domain/ActiveSession;", "type", "Lru/yoomoney/sdk/two_fa/domain/ActiveSessionType;", "authProcessId", "", "operationInfo", "Lru/yoomoney/sdk/two_fa/domain/ActiveSessionOperationInfo;", "(Lru/yoomoney/sdk/two_fa/domain/ActiveSessionType;Ljava/lang/String;Lru/yoomoney/sdk/two_fa/domain/ActiveSessionOperationInfo;)V", "getAuthProcessId", "()Ljava/lang/String;", "getOperationInfo", "()Lru/yoomoney/sdk/two_fa/domain/ActiveSessionOperationInfo;", "getType", "()Lru/yoomoney/sdk/two_fa/domain/ActiveSessionType;", "component1", "component2", "component3", "copy", "equals", "", "other", "", "hashCode", "", "toString", "two-fa_release"}, k = 1, mv = {1, 9, 0}, xi = 48)
/* loaded from: classes5.dex */
public final /* data */ class ActiveSessionPushApp extends ActiveSession {
    public static final int $stable = 8;
    private final String authProcessId;
    private final ActiveSessionOperationInfo operationInfo;
    private final ActiveSessionType type;

    public static /* synthetic */ ActiveSessionPushApp copy$default(ActiveSessionPushApp activeSessionPushApp, ActiveSessionType activeSessionType, String str, ActiveSessionOperationInfo activeSessionOperationInfo, int i, Object obj) {
        if ((i & 1) != 0) {
            activeSessionType = activeSessionPushApp.type;
        }
        if ((i & 2) != 0) {
            str = activeSessionPushApp.authProcessId;
        }
        if ((i & 4) != 0) {
            activeSessionOperationInfo = activeSessionPushApp.operationInfo;
        }
        return activeSessionPushApp.copy(activeSessionType, str, activeSessionOperationInfo);
    }

    /* renamed from: component1, reason: from getter */
    public final ActiveSessionType getType() {
        return this.type;
    }

    /* renamed from: component2, reason: from getter */
    public final String getAuthProcessId() {
        return this.authProcessId;
    }

    /* renamed from: component3, reason: from getter */
    public final ActiveSessionOperationInfo getOperationInfo() {
        return this.operationInfo;
    }

    public final ActiveSessionPushApp copy(ActiveSessionType type, String authProcessId, ActiveSessionOperationInfo operationInfo) {
        Intrinsics.checkNotNullParameter(type, "type");
        Intrinsics.checkNotNullParameter(authProcessId, "authProcessId");
        return new ActiveSessionPushApp(type, authProcessId, operationInfo);
    }

    public boolean equals(Object other) {
        if (this == other) {
            return true;
        }
        if (!(other instanceof ActiveSessionPushApp)) {
            return false;
        }
        ActiveSessionPushApp activeSessionPushApp = (ActiveSessionPushApp) other;
        return this.type == activeSessionPushApp.type && Intrinsics.areEqual(this.authProcessId, activeSessionPushApp.authProcessId) && Intrinsics.areEqual(this.operationInfo, activeSessionPushApp.operationInfo);
    }

    public int hashCode() {
        int iHashCode = ((this.type.hashCode() * 31) + this.authProcessId.hashCode()) * 31;
        ActiveSessionOperationInfo activeSessionOperationInfo = this.operationInfo;
        return iHashCode + (activeSessionOperationInfo == null ? 0 : activeSessionOperationInfo.hashCode());
    }

    public String toString() {
        return "ActiveSessionPushApp(type=" + this.type + ", authProcessId=" + this.authProcessId + ", operationInfo=" + this.operationInfo + ")";
    }

    public /* synthetic */ ActiveSessionPushApp(ActiveSessionType activeSessionType, String str, ActiveSessionOperationInfo activeSessionOperationInfo, int i, DefaultConstructorMarker defaultConstructorMarker) {
        this(activeSessionType, str, (i & 4) != 0 ? null : activeSessionOperationInfo);
    }

    @Override // ru.yoomoney.sdk.two_fa.domain.ActiveSession
    public ActiveSessionType getType() {
        return this.type;
    }

    @Override // ru.yoomoney.sdk.two_fa.domain.ActiveSession
    public String getAuthProcessId() {
        return this.authProcessId;
    }

    public final ActiveSessionOperationInfo getOperationInfo() {
        return this.operationInfo;
    }

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public ActiveSessionPushApp(ActiveSessionType type, String authProcessId, ActiveSessionOperationInfo activeSessionOperationInfo) {
        super(null);
        Intrinsics.checkNotNullParameter(type, "type");
        Intrinsics.checkNotNullParameter(authProcessId, "authProcessId");
        this.type = type;
        this.authProcessId = authProcessId;
        this.operationInfo = activeSessionOperationInfo;
    }
}

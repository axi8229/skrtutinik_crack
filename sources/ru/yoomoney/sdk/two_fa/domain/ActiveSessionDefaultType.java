package ru.yoomoney.sdk.two_fa.domain;

import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

/* compiled from: Domain.kt */
@Metadata(d1 = {"\u0000,\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0002\b\t\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\b\n\u0002\b\u0002\b\u0080\b\u0018\u00002\u00020\u0001B\u0015\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\u0006\u0010\u0004\u001a\u00020\u0005¢\u0006\u0002\u0010\u0006J\t\u0010\u000b\u001a\u00020\u0003HÆ\u0003J\t\u0010\f\u001a\u00020\u0005HÆ\u0003J\u001d\u0010\r\u001a\u00020\u00002\b\b\u0002\u0010\u0002\u001a\u00020\u00032\b\b\u0002\u0010\u0004\u001a\u00020\u0005HÆ\u0001J\u0013\u0010\u000e\u001a\u00020\u000f2\b\u0010\u0010\u001a\u0004\u0018\u00010\u0011HÖ\u0003J\t\u0010\u0012\u001a\u00020\u0013HÖ\u0001J\t\u0010\u0014\u001a\u00020\u0005HÖ\u0001R\u0014\u0010\u0004\u001a\u00020\u0005X\u0096\u0004¢\u0006\b\n\u0000\u001a\u0004\b\u0007\u0010\bR\u0014\u0010\u0002\u001a\u00020\u0003X\u0096\u0004¢\u0006\b\n\u0000\u001a\u0004\b\t\u0010\n¨\u0006\u0015"}, d2 = {"Lru/yoomoney/sdk/two_fa/domain/ActiveSessionDefaultType;", "Lru/yoomoney/sdk/two_fa/domain/ActiveSession;", "type", "Lru/yoomoney/sdk/two_fa/domain/ActiveSessionType;", "authProcessId", "", "(Lru/yoomoney/sdk/two_fa/domain/ActiveSessionType;Ljava/lang/String;)V", "getAuthProcessId", "()Ljava/lang/String;", "getType", "()Lru/yoomoney/sdk/two_fa/domain/ActiveSessionType;", "component1", "component2", "copy", "equals", "", "other", "", "hashCode", "", "toString", "two-fa_release"}, k = 1, mv = {1, 9, 0}, xi = 48)
/* loaded from: classes5.dex */
public final /* data */ class ActiveSessionDefaultType extends ActiveSession {
    public static final int $stable = 0;
    private final String authProcessId;
    private final ActiveSessionType type;

    public static /* synthetic */ ActiveSessionDefaultType copy$default(ActiveSessionDefaultType activeSessionDefaultType, ActiveSessionType activeSessionType, String str, int i, Object obj) {
        if ((i & 1) != 0) {
            activeSessionType = activeSessionDefaultType.type;
        }
        if ((i & 2) != 0) {
            str = activeSessionDefaultType.authProcessId;
        }
        return activeSessionDefaultType.copy(activeSessionType, str);
    }

    /* renamed from: component1, reason: from getter */
    public final ActiveSessionType getType() {
        return this.type;
    }

    /* renamed from: component2, reason: from getter */
    public final String getAuthProcessId() {
        return this.authProcessId;
    }

    public final ActiveSessionDefaultType copy(ActiveSessionType type, String authProcessId) {
        Intrinsics.checkNotNullParameter(type, "type");
        Intrinsics.checkNotNullParameter(authProcessId, "authProcessId");
        return new ActiveSessionDefaultType(type, authProcessId);
    }

    public boolean equals(Object other) {
        if (this == other) {
            return true;
        }
        if (!(other instanceof ActiveSessionDefaultType)) {
            return false;
        }
        ActiveSessionDefaultType activeSessionDefaultType = (ActiveSessionDefaultType) other;
        return this.type == activeSessionDefaultType.type && Intrinsics.areEqual(this.authProcessId, activeSessionDefaultType.authProcessId);
    }

    public int hashCode() {
        return (this.type.hashCode() * 31) + this.authProcessId.hashCode();
    }

    public String toString() {
        return "ActiveSessionDefaultType(type=" + this.type + ", authProcessId=" + this.authProcessId + ")";
    }

    @Override // ru.yoomoney.sdk.two_fa.domain.ActiveSession
    public ActiveSessionType getType() {
        return this.type;
    }

    @Override // ru.yoomoney.sdk.two_fa.domain.ActiveSession
    public String getAuthProcessId() {
        return this.authProcessId;
    }

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public ActiveSessionDefaultType(ActiveSessionType type, String authProcessId) {
        super(null);
        Intrinsics.checkNotNullParameter(type, "type");
        Intrinsics.checkNotNullParameter(authProcessId, "authProcessId");
        this.type = type;
        this.authProcessId = authProcessId;
    }
}

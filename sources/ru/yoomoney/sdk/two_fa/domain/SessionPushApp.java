package ru.yoomoney.sdk.two_fa.domain;

import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import org.threeten.bp.LocalDateTime;

/* compiled from: Domain.kt */
@Metadata(d1 = {"\u00000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\f\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u000e\n\u0000\b\u0080\b\u0018\u00002\u00020\u0001B\u001d\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\u0006\u0010\u0004\u001a\u00020\u0005\u0012\u0006\u0010\u0006\u001a\u00020\u0005¢\u0006\u0002\u0010\u0007J\t\u0010\r\u001a\u00020\u0003HÆ\u0003J\t\u0010\u000e\u001a\u00020\u0005HÆ\u0003J\t\u0010\u000f\u001a\u00020\u0005HÆ\u0003J'\u0010\u0010\u001a\u00020\u00002\b\b\u0002\u0010\u0002\u001a\u00020\u00032\b\b\u0002\u0010\u0004\u001a\u00020\u00052\b\b\u0002\u0010\u0006\u001a\u00020\u0005HÆ\u0001J\u0013\u0010\u0011\u001a\u00020\u00122\b\u0010\u0013\u001a\u0004\u0018\u00010\u0014HÖ\u0003J\t\u0010\u0015\u001a\u00020\u0016HÖ\u0001J\t\u0010\u0017\u001a\u00020\u0018HÖ\u0001R\u0014\u0010\u0006\u001a\u00020\u0005X\u0096\u0004¢\u0006\b\n\u0000\u001a\u0004\b\b\u0010\tR\u0014\u0010\u0002\u001a\u00020\u0003X\u0096\u0004¢\u0006\b\n\u0000\u001a\u0004\b\n\u0010\u000bR\u0014\u0010\u0004\u001a\u00020\u0005X\u0096\u0004¢\u0006\b\n\u0000\u001a\u0004\b\f\u0010\t¨\u0006\u0019"}, d2 = {"Lru/yoomoney/sdk/two_fa/domain/SessionPushApp;", "Lru/yoomoney/sdk/two_fa/domain/Session;", "type", "Lru/yoomoney/sdk/two_fa/domain/SessionType;", "validUntil", "Lorg/threeten/bp/LocalDateTime;", "nextAvailableFrom", "(Lru/yoomoney/sdk/two_fa/domain/SessionType;Lorg/threeten/bp/LocalDateTime;Lorg/threeten/bp/LocalDateTime;)V", "getNextAvailableFrom", "()Lorg/threeten/bp/LocalDateTime;", "getType", "()Lru/yoomoney/sdk/two_fa/domain/SessionType;", "getValidUntil", "component1", "component2", "component3", "copy", "equals", "", "other", "", "hashCode", "", "toString", "", "two-fa_release"}, k = 1, mv = {1, 9, 0}, xi = 48)
/* loaded from: classes5.dex */
public final /* data */ class SessionPushApp extends Session {
    public static final int $stable = 8;
    private final LocalDateTime nextAvailableFrom;
    private final SessionType type;
    private final LocalDateTime validUntil;

    public static /* synthetic */ SessionPushApp copy$default(SessionPushApp sessionPushApp, SessionType sessionType, LocalDateTime localDateTime, LocalDateTime localDateTime2, int i, Object obj) {
        if ((i & 1) != 0) {
            sessionType = sessionPushApp.type;
        }
        if ((i & 2) != 0) {
            localDateTime = sessionPushApp.validUntil;
        }
        if ((i & 4) != 0) {
            localDateTime2 = sessionPushApp.nextAvailableFrom;
        }
        return sessionPushApp.copy(sessionType, localDateTime, localDateTime2);
    }

    /* renamed from: component1, reason: from getter */
    public final SessionType getType() {
        return this.type;
    }

    /* renamed from: component2, reason: from getter */
    public final LocalDateTime getValidUntil() {
        return this.validUntil;
    }

    /* renamed from: component3, reason: from getter */
    public final LocalDateTime getNextAvailableFrom() {
        return this.nextAvailableFrom;
    }

    public final SessionPushApp copy(SessionType type, LocalDateTime validUntil, LocalDateTime nextAvailableFrom) {
        Intrinsics.checkNotNullParameter(type, "type");
        Intrinsics.checkNotNullParameter(validUntil, "validUntil");
        Intrinsics.checkNotNullParameter(nextAvailableFrom, "nextAvailableFrom");
        return new SessionPushApp(type, validUntil, nextAvailableFrom);
    }

    public boolean equals(Object other) {
        if (this == other) {
            return true;
        }
        if (!(other instanceof SessionPushApp)) {
            return false;
        }
        SessionPushApp sessionPushApp = (SessionPushApp) other;
        return this.type == sessionPushApp.type && Intrinsics.areEqual(this.validUntil, sessionPushApp.validUntil) && Intrinsics.areEqual(this.nextAvailableFrom, sessionPushApp.nextAvailableFrom);
    }

    public int hashCode() {
        return (((this.type.hashCode() * 31) + this.validUntil.hashCode()) * 31) + this.nextAvailableFrom.hashCode();
    }

    public String toString() {
        return "SessionPushApp(type=" + this.type + ", validUntil=" + this.validUntil + ", nextAvailableFrom=" + this.nextAvailableFrom + ")";
    }

    @Override // ru.yoomoney.sdk.two_fa.domain.Session
    public SessionType getType() {
        return this.type;
    }

    @Override // ru.yoomoney.sdk.two_fa.domain.Session
    public LocalDateTime getValidUntil() {
        return this.validUntil;
    }

    @Override // ru.yoomoney.sdk.two_fa.domain.Session
    public LocalDateTime getNextAvailableFrom() {
        return this.nextAvailableFrom;
    }

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public SessionPushApp(SessionType type, LocalDateTime validUntil, LocalDateTime nextAvailableFrom) {
        super(null);
        Intrinsics.checkNotNullParameter(type, "type");
        Intrinsics.checkNotNullParameter(validUntil, "validUntil");
        Intrinsics.checkNotNullParameter(nextAvailableFrom, "nextAvailableFrom");
        this.type = type;
        this.validUntil = validUntil;
        this.nextAvailableFrom = nextAvailableFrom;
    }
}

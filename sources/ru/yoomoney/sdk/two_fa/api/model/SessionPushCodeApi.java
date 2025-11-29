package ru.yoomoney.sdk.two_fa.api.model;

import com.fasterxml.jackson.annotation.JsonProperty;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import org.threeten.bp.LocalDateTime;

/* compiled from: SessionPushCodeApi.kt */
@Metadata(d1 = {"\u00004\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\b\n\u0002\b\u0011\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0000\b\u0080\b\u0018\u00002\u00020\u0001B7\u0012\b\b\u0001\u0010\u0002\u001a\u00020\u0003\u0012\b\b\u0001\u0010\u0004\u001a\u00020\u0005\u0012\b\b\u0001\u0010\u0006\u001a\u00020\u0005\u0012\b\b\u0001\u0010\u0007\u001a\u00020\b\u0012\b\b\u0001\u0010\t\u001a\u00020\b¢\u0006\u0002\u0010\nJ\t\u0010\u0013\u001a\u00020\u0003HÆ\u0003J\t\u0010\u0014\u001a\u00020\u0005HÆ\u0003J\t\u0010\u0015\u001a\u00020\u0005HÆ\u0003J\t\u0010\u0016\u001a\u00020\bHÆ\u0003J\t\u0010\u0017\u001a\u00020\bHÆ\u0003J;\u0010\u0018\u001a\u00020\u00002\b\b\u0003\u0010\u0002\u001a\u00020\u00032\b\b\u0003\u0010\u0004\u001a\u00020\u00052\b\b\u0003\u0010\u0006\u001a\u00020\u00052\b\b\u0003\u0010\u0007\u001a\u00020\b2\b\b\u0003\u0010\t\u001a\u00020\bHÆ\u0001J\u0013\u0010\u0019\u001a\u00020\u001a2\b\u0010\u001b\u001a\u0004\u0018\u00010\u001cHÖ\u0003J\t\u0010\u001d\u001a\u00020\bHÖ\u0001J\t\u0010\u001e\u001a\u00020\u001fHÖ\u0001R\u0011\u0010\t\u001a\u00020\b¢\u0006\b\n\u0000\u001a\u0004\b\u000b\u0010\fR\u0011\u0010\u0007\u001a\u00020\b¢\u0006\b\n\u0000\u001a\u0004\b\r\u0010\fR\u0014\u0010\u0006\u001a\u00020\u0005X\u0096\u0004¢\u0006\b\n\u0000\u001a\u0004\b\u000e\u0010\u000fR\u0014\u0010\u0002\u001a\u00020\u0003X\u0096\u0004¢\u0006\b\n\u0000\u001a\u0004\b\u0010\u0010\u0011R\u0014\u0010\u0004\u001a\u00020\u0005X\u0096\u0004¢\u0006\b\n\u0000\u001a\u0004\b\u0012\u0010\u000f¨\u0006 "}, d2 = {"Lru/yoomoney/sdk/two_fa/api/model/SessionPushCodeApi;", "Lru/yoomoney/sdk/two_fa/api/model/SessionApi;", "type", "Lru/yoomoney/sdk/two_fa/api/model/ApiSessionType;", "validUntil", "Lorg/threeten/bp/LocalDateTime;", "nextAvailableFrom", "codeLength", "", "attemptsLeft", "(Lru/yoomoney/sdk/two_fa/api/model/ApiSessionType;Lorg/threeten/bp/LocalDateTime;Lorg/threeten/bp/LocalDateTime;II)V", "getAttemptsLeft", "()I", "getCodeLength", "getNextAvailableFrom", "()Lorg/threeten/bp/LocalDateTime;", "getType", "()Lru/yoomoney/sdk/two_fa/api/model/ApiSessionType;", "getValidUntil", "component1", "component2", "component3", "component4", "component5", "copy", "equals", "", "other", "", "hashCode", "toString", "", "two-fa_release"}, k = 1, mv = {1, 9, 0}, xi = 48)
/* loaded from: classes5.dex */
public final /* data */ class SessionPushCodeApi extends SessionApi {
    public static final int $stable = 8;
    private final int attemptsLeft;
    private final int codeLength;
    private final LocalDateTime nextAvailableFrom;
    private final ApiSessionType type;
    private final LocalDateTime validUntil;

    public static /* synthetic */ SessionPushCodeApi copy$default(SessionPushCodeApi sessionPushCodeApi, ApiSessionType apiSessionType, LocalDateTime localDateTime, LocalDateTime localDateTime2, int i, int i2, int i3, Object obj) {
        if ((i3 & 1) != 0) {
            apiSessionType = sessionPushCodeApi.type;
        }
        if ((i3 & 2) != 0) {
            localDateTime = sessionPushCodeApi.validUntil;
        }
        LocalDateTime localDateTime3 = localDateTime;
        if ((i3 & 4) != 0) {
            localDateTime2 = sessionPushCodeApi.nextAvailableFrom;
        }
        LocalDateTime localDateTime4 = localDateTime2;
        if ((i3 & 8) != 0) {
            i = sessionPushCodeApi.codeLength;
        }
        int i4 = i;
        if ((i3 & 16) != 0) {
            i2 = sessionPushCodeApi.attemptsLeft;
        }
        return sessionPushCodeApi.copy(apiSessionType, localDateTime3, localDateTime4, i4, i2);
    }

    /* renamed from: component1, reason: from getter */
    public final ApiSessionType getType() {
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

    /* renamed from: component4, reason: from getter */
    public final int getCodeLength() {
        return this.codeLength;
    }

    /* renamed from: component5, reason: from getter */
    public final int getAttemptsLeft() {
        return this.attemptsLeft;
    }

    public final SessionPushCodeApi copy(@JsonProperty("type") ApiSessionType type, @JsonProperty("validUntil") LocalDateTime validUntil, @JsonProperty("nextAvailableFrom") LocalDateTime nextAvailableFrom, @JsonProperty("codeLength") int codeLength, @JsonProperty("attemptsLeft") int attemptsLeft) {
        Intrinsics.checkNotNullParameter(type, "type");
        Intrinsics.checkNotNullParameter(validUntil, "validUntil");
        Intrinsics.checkNotNullParameter(nextAvailableFrom, "nextAvailableFrom");
        return new SessionPushCodeApi(type, validUntil, nextAvailableFrom, codeLength, attemptsLeft);
    }

    public boolean equals(Object other) {
        if (this == other) {
            return true;
        }
        if (!(other instanceof SessionPushCodeApi)) {
            return false;
        }
        SessionPushCodeApi sessionPushCodeApi = (SessionPushCodeApi) other;
        return this.type == sessionPushCodeApi.type && Intrinsics.areEqual(this.validUntil, sessionPushCodeApi.validUntil) && Intrinsics.areEqual(this.nextAvailableFrom, sessionPushCodeApi.nextAvailableFrom) && this.codeLength == sessionPushCodeApi.codeLength && this.attemptsLeft == sessionPushCodeApi.attemptsLeft;
    }

    public int hashCode() {
        return (((((((this.type.hashCode() * 31) + this.validUntil.hashCode()) * 31) + this.nextAvailableFrom.hashCode()) * 31) + Integer.hashCode(this.codeLength)) * 31) + Integer.hashCode(this.attemptsLeft);
    }

    public String toString() {
        return "SessionPushCodeApi(type=" + this.type + ", validUntil=" + this.validUntil + ", nextAvailableFrom=" + this.nextAvailableFrom + ", codeLength=" + this.codeLength + ", attemptsLeft=" + this.attemptsLeft + ")";
    }

    @Override // ru.yoomoney.sdk.two_fa.api.model.SessionApi
    public ApiSessionType getType() {
        return this.type;
    }

    @Override // ru.yoomoney.sdk.two_fa.api.model.SessionApi
    public LocalDateTime getValidUntil() {
        return this.validUntil;
    }

    @Override // ru.yoomoney.sdk.two_fa.api.model.SessionApi
    public LocalDateTime getNextAvailableFrom() {
        return this.nextAvailableFrom;
    }

    public final int getCodeLength() {
        return this.codeLength;
    }

    public final int getAttemptsLeft() {
        return this.attemptsLeft;
    }

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public SessionPushCodeApi(@JsonProperty("type") ApiSessionType type, @JsonProperty("validUntil") LocalDateTime validUntil, @JsonProperty("nextAvailableFrom") LocalDateTime nextAvailableFrom, @JsonProperty("codeLength") int i, @JsonProperty("attemptsLeft") int i2) {
        super(null);
        Intrinsics.checkNotNullParameter(type, "type");
        Intrinsics.checkNotNullParameter(validUntil, "validUntil");
        Intrinsics.checkNotNullParameter(nextAvailableFrom, "nextAvailableFrom");
        this.type = type;
        this.validUntil = validUntil;
        this.nextAvailableFrom = nextAvailableFrom;
        this.codeLength = i;
        this.attemptsLeft = i2;
    }
}

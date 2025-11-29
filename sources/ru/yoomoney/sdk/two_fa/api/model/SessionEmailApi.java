package ru.yoomoney.sdk.two_fa.api.model;

import com.fasterxml.jackson.annotation.JsonProperty;
import com.google.android.gms.common.Scopes;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import org.threeten.bp.LocalDateTime;

/* compiled from: SessionEmailApi.kt */
@Metadata(d1 = {"\u00004\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010\b\n\u0002\b\u0014\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010\u0000\n\u0002\b\u0003\b\u0080\b\u0018\u00002\u00020\u0001BA\u0012\b\b\u0001\u0010\u0002\u001a\u00020\u0003\u0012\b\b\u0001\u0010\u0004\u001a\u00020\u0005\u0012\b\b\u0001\u0010\u0006\u001a\u00020\u0005\u0012\b\b\u0001\u0010\u0007\u001a\u00020\b\u0012\b\b\u0001\u0010\t\u001a\u00020\n\u0012\b\b\u0001\u0010\u000b\u001a\u00020\n¢\u0006\u0002\u0010\fJ\t\u0010\u0017\u001a\u00020\u0003HÆ\u0003J\t\u0010\u0018\u001a\u00020\u0005HÆ\u0003J\t\u0010\u0019\u001a\u00020\u0005HÆ\u0003J\t\u0010\u001a\u001a\u00020\bHÆ\u0003J\t\u0010\u001b\u001a\u00020\nHÆ\u0003J\t\u0010\u001c\u001a\u00020\nHÆ\u0003JE\u0010\u001d\u001a\u00020\u00002\b\b\u0003\u0010\u0002\u001a\u00020\u00032\b\b\u0003\u0010\u0004\u001a\u00020\u00052\b\b\u0003\u0010\u0006\u001a\u00020\u00052\b\b\u0003\u0010\u0007\u001a\u00020\b2\b\b\u0003\u0010\t\u001a\u00020\n2\b\b\u0003\u0010\u000b\u001a\u00020\nHÆ\u0001J\u0013\u0010\u001e\u001a\u00020\u001f2\b\u0010 \u001a\u0004\u0018\u00010!HÖ\u0003J\t\u0010\"\u001a\u00020\nHÖ\u0001J\t\u0010#\u001a\u00020\bHÖ\u0001R\u0011\u0010\u000b\u001a\u00020\n¢\u0006\b\n\u0000\u001a\u0004\b\r\u0010\u000eR\u0011\u0010\t\u001a\u00020\n¢\u0006\b\n\u0000\u001a\u0004\b\u000f\u0010\u000eR\u0011\u0010\u0007\u001a\u00020\b¢\u0006\b\n\u0000\u001a\u0004\b\u0010\u0010\u0011R\u0014\u0010\u0006\u001a\u00020\u0005X\u0096\u0004¢\u0006\b\n\u0000\u001a\u0004\b\u0012\u0010\u0013R\u0014\u0010\u0002\u001a\u00020\u0003X\u0096\u0004¢\u0006\b\n\u0000\u001a\u0004\b\u0014\u0010\u0015R\u0014\u0010\u0004\u001a\u00020\u0005X\u0096\u0004¢\u0006\b\n\u0000\u001a\u0004\b\u0016\u0010\u0013¨\u0006$"}, d2 = {"Lru/yoomoney/sdk/two_fa/api/model/SessionEmailApi;", "Lru/yoomoney/sdk/two_fa/api/model/SessionApi;", "type", "Lru/yoomoney/sdk/two_fa/api/model/ApiSessionType;", "validUntil", "Lorg/threeten/bp/LocalDateTime;", "nextAvailableFrom", Scopes.EMAIL, "", "codeLength", "", "attemptsLeft", "(Lru/yoomoney/sdk/two_fa/api/model/ApiSessionType;Lorg/threeten/bp/LocalDateTime;Lorg/threeten/bp/LocalDateTime;Ljava/lang/String;II)V", "getAttemptsLeft", "()I", "getCodeLength", "getEmail", "()Ljava/lang/String;", "getNextAvailableFrom", "()Lorg/threeten/bp/LocalDateTime;", "getType", "()Lru/yoomoney/sdk/two_fa/api/model/ApiSessionType;", "getValidUntil", "component1", "component2", "component3", "component4", "component5", "component6", "copy", "equals", "", "other", "", "hashCode", "toString", "two-fa_release"}, k = 1, mv = {1, 9, 0}, xi = 48)
/* loaded from: classes5.dex */
public final /* data */ class SessionEmailApi extends SessionApi {
    public static final int $stable = 8;
    private final int attemptsLeft;
    private final int codeLength;
    private final String email;
    private final LocalDateTime nextAvailableFrom;
    private final ApiSessionType type;
    private final LocalDateTime validUntil;

    public static /* synthetic */ SessionEmailApi copy$default(SessionEmailApi sessionEmailApi, ApiSessionType apiSessionType, LocalDateTime localDateTime, LocalDateTime localDateTime2, String str, int i, int i2, int i3, Object obj) {
        if ((i3 & 1) != 0) {
            apiSessionType = sessionEmailApi.type;
        }
        if ((i3 & 2) != 0) {
            localDateTime = sessionEmailApi.validUntil;
        }
        LocalDateTime localDateTime3 = localDateTime;
        if ((i3 & 4) != 0) {
            localDateTime2 = sessionEmailApi.nextAvailableFrom;
        }
        LocalDateTime localDateTime4 = localDateTime2;
        if ((i3 & 8) != 0) {
            str = sessionEmailApi.email;
        }
        String str2 = str;
        if ((i3 & 16) != 0) {
            i = sessionEmailApi.codeLength;
        }
        int i4 = i;
        if ((i3 & 32) != 0) {
            i2 = sessionEmailApi.attemptsLeft;
        }
        return sessionEmailApi.copy(apiSessionType, localDateTime3, localDateTime4, str2, i4, i2);
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
    public final String getEmail() {
        return this.email;
    }

    /* renamed from: component5, reason: from getter */
    public final int getCodeLength() {
        return this.codeLength;
    }

    /* renamed from: component6, reason: from getter */
    public final int getAttemptsLeft() {
        return this.attemptsLeft;
    }

    public final SessionEmailApi copy(@JsonProperty("type") ApiSessionType type, @JsonProperty("validUntil") LocalDateTime validUntil, @JsonProperty("nextAvailableFrom") LocalDateTime nextAvailableFrom, @JsonProperty(Scopes.EMAIL) String email, @JsonProperty("codeLength") int codeLength, @JsonProperty("attemptsLeft") int attemptsLeft) {
        Intrinsics.checkNotNullParameter(type, "type");
        Intrinsics.checkNotNullParameter(validUntil, "validUntil");
        Intrinsics.checkNotNullParameter(nextAvailableFrom, "nextAvailableFrom");
        Intrinsics.checkNotNullParameter(email, "email");
        return new SessionEmailApi(type, validUntil, nextAvailableFrom, email, codeLength, attemptsLeft);
    }

    public boolean equals(Object other) {
        if (this == other) {
            return true;
        }
        if (!(other instanceof SessionEmailApi)) {
            return false;
        }
        SessionEmailApi sessionEmailApi = (SessionEmailApi) other;
        return this.type == sessionEmailApi.type && Intrinsics.areEqual(this.validUntil, sessionEmailApi.validUntil) && Intrinsics.areEqual(this.nextAvailableFrom, sessionEmailApi.nextAvailableFrom) && Intrinsics.areEqual(this.email, sessionEmailApi.email) && this.codeLength == sessionEmailApi.codeLength && this.attemptsLeft == sessionEmailApi.attemptsLeft;
    }

    public int hashCode() {
        return (((((((((this.type.hashCode() * 31) + this.validUntil.hashCode()) * 31) + this.nextAvailableFrom.hashCode()) * 31) + this.email.hashCode()) * 31) + Integer.hashCode(this.codeLength)) * 31) + Integer.hashCode(this.attemptsLeft);
    }

    public String toString() {
        return "SessionEmailApi(type=" + this.type + ", validUntil=" + this.validUntil + ", nextAvailableFrom=" + this.nextAvailableFrom + ", email=" + this.email + ", codeLength=" + this.codeLength + ", attemptsLeft=" + this.attemptsLeft + ")";
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

    public final String getEmail() {
        return this.email;
    }

    public final int getCodeLength() {
        return this.codeLength;
    }

    public final int getAttemptsLeft() {
        return this.attemptsLeft;
    }

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public SessionEmailApi(@JsonProperty("type") ApiSessionType type, @JsonProperty("validUntil") LocalDateTime validUntil, @JsonProperty("nextAvailableFrom") LocalDateTime nextAvailableFrom, @JsonProperty(Scopes.EMAIL) String email, @JsonProperty("codeLength") int i, @JsonProperty("attemptsLeft") int i2) {
        super(null);
        Intrinsics.checkNotNullParameter(type, "type");
        Intrinsics.checkNotNullParameter(validUntil, "validUntil");
        Intrinsics.checkNotNullParameter(nextAvailableFrom, "nextAvailableFrom");
        Intrinsics.checkNotNullParameter(email, "email");
        this.type = type;
        this.validUntil = validUntil;
        this.nextAvailableFrom = nextAvailableFrom;
        this.email = email;
        this.codeLength = i;
        this.attemptsLeft = i2;
    }
}

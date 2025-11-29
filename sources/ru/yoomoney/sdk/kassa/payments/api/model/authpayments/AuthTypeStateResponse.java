package ru.yoomoney.sdk.kassa.payments.api.model.authpayments;

import com.fasterxml.jackson.annotation.JsonProperty;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

@Metadata(d1 = {"\u0000$\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010\b\n\u0002\b\u001c\n\u0002\u0010\u000e\n\u0000\b\u0080\b\u0018\u00002\u00020\u0001BG\u0012\b\b\u0001\u0010\u0002\u001a\u00020\u0003\u0012\n\b\u0001\u0010\u0004\u001a\u0004\u0018\u00010\u0005\u0012\b\b\u0001\u0010\u0006\u001a\u00020\u0007\u0012\b\b\u0001\u0010\b\u001a\u00020\u0007\u0012\n\b\u0001\u0010\t\u001a\u0004\u0018\u00010\u0007\u0012\n\b\u0001\u0010\n\u001a\u0004\u0018\u00010\u0007¢\u0006\u0002\u0010\u000bJ\t\u0010\u0018\u001a\u00020\u0003HÆ\u0003J\u0010\u0010\u0019\u001a\u0004\u0018\u00010\u0005HÆ\u0003¢\u0006\u0002\u0010\u0013J\t\u0010\u001a\u001a\u00020\u0007HÆ\u0003J\t\u0010\u001b\u001a\u00020\u0007HÆ\u0003J\u0010\u0010\u001c\u001a\u0004\u0018\u00010\u0007HÆ\u0003¢\u0006\u0002\u0010\rJ\u0010\u0010\u001d\u001a\u0004\u0018\u00010\u0007HÆ\u0003¢\u0006\u0002\u0010\rJP\u0010\u001e\u001a\u00020\u00002\b\b\u0003\u0010\u0002\u001a\u00020\u00032\n\b\u0003\u0010\u0004\u001a\u0004\u0018\u00010\u00052\b\b\u0003\u0010\u0006\u001a\u00020\u00072\b\b\u0003\u0010\b\u001a\u00020\u00072\n\b\u0003\u0010\t\u001a\u0004\u0018\u00010\u00072\n\b\u0003\u0010\n\u001a\u0004\u0018\u00010\u0007HÆ\u0001¢\u0006\u0002\u0010\u001fJ\u0013\u0010 \u001a\u00020\u00052\b\u0010!\u001a\u0004\u0018\u00010\u0001HÖ\u0003J\t\u0010\"\u001a\u00020\u0007HÖ\u0001J\t\u0010#\u001a\u00020$HÖ\u0001R\u0015\u0010\t\u001a\u0004\u0018\u00010\u0007¢\u0006\n\n\u0002\u0010\u000e\u001a\u0004\b\f\u0010\rR\u0015\u0010\n\u001a\u0004\u0018\u00010\u0007¢\u0006\n\n\u0002\u0010\u000e\u001a\u0004\b\u000f\u0010\rR\u0011\u0010\b\u001a\u00020\u0007¢\u0006\b\n\u0000\u001a\u0004\b\u0010\u0010\u0011R\u0015\u0010\u0004\u001a\u0004\u0018\u00010\u0005¢\u0006\n\n\u0002\u0010\u0014\u001a\u0004\b\u0012\u0010\u0013R\u0011\u0010\u0006\u001a\u00020\u0007¢\u0006\b\n\u0000\u001a\u0004\b\u0015\u0010\u0011R\u0011\u0010\u0002\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u0016\u0010\u0017¨\u0006%"}, d2 = {"Lru/yoomoney/sdk/kassa/payments/api/model/authpayments/AuthTypeStateResponse;", "", "type", "Lru/yoomoney/sdk/kassa/payments/api/model/authpayments/AuthTypes;", "enabled", "", "nextSessionTimeLeft", "", "codeLength", "attemptsCount", "attemptsLeft", "(Lru/yoomoney/sdk/kassa/payments/api/model/authpayments/AuthTypes;Ljava/lang/Boolean;IILjava/lang/Integer;Ljava/lang/Integer;)V", "getAttemptsCount", "()Ljava/lang/Integer;", "Ljava/lang/Integer;", "getAttemptsLeft", "getCodeLength", "()I", "getEnabled", "()Ljava/lang/Boolean;", "Ljava/lang/Boolean;", "getNextSessionTimeLeft", "getType", "()Lru/yoomoney/sdk/kassa/payments/api/model/authpayments/AuthTypes;", "component1", "component2", "component3", "component4", "component5", "component6", "copy", "(Lru/yoomoney/sdk/kassa/payments/api/model/authpayments/AuthTypes;Ljava/lang/Boolean;IILjava/lang/Integer;Ljava/lang/Integer;)Lru/yoomoney/sdk/kassa/payments/api/model/authpayments/AuthTypeStateResponse;", "equals", "other", "hashCode", "toString", "", "library_metricaRealRelease"}, k = 1, mv = {1, 9, 0}, xi = 48)
/* loaded from: classes5.dex */
public final /* data */ class AuthTypeStateResponse {
    public static final int $stable = 0;
    private final Integer attemptsCount;
    private final Integer attemptsLeft;
    private final int codeLength;
    private final Boolean enabled;
    private final int nextSessionTimeLeft;
    private final AuthTypes type;

    public AuthTypeStateResponse(@JsonProperty("type") AuthTypes type, @JsonProperty("enabled") Boolean bool, @JsonProperty("nextSessionTimeLeft") int i, @JsonProperty("codeLength") int i2, @JsonProperty("attemptsCount") Integer num, @JsonProperty("attemptsLeft") Integer num2) {
        Intrinsics.checkNotNullParameter(type, "type");
        this.type = type;
        this.enabled = bool;
        this.nextSessionTimeLeft = i;
        this.codeLength = i2;
        this.attemptsCount = num;
        this.attemptsLeft = num2;
    }

    public static /* synthetic */ AuthTypeStateResponse copy$default(AuthTypeStateResponse authTypeStateResponse, AuthTypes authTypes, Boolean bool, int i, int i2, Integer num, Integer num2, int i3, Object obj) {
        if ((i3 & 1) != 0) {
            authTypes = authTypeStateResponse.type;
        }
        if ((i3 & 2) != 0) {
            bool = authTypeStateResponse.enabled;
        }
        Boolean bool2 = bool;
        if ((i3 & 4) != 0) {
            i = authTypeStateResponse.nextSessionTimeLeft;
        }
        int i4 = i;
        if ((i3 & 8) != 0) {
            i2 = authTypeStateResponse.codeLength;
        }
        int i5 = i2;
        if ((i3 & 16) != 0) {
            num = authTypeStateResponse.attemptsCount;
        }
        Integer num3 = num;
        if ((i3 & 32) != 0) {
            num2 = authTypeStateResponse.attemptsLeft;
        }
        return authTypeStateResponse.copy(authTypes, bool2, i4, i5, num3, num2);
    }

    /* renamed from: component1, reason: from getter */
    public final AuthTypes getType() {
        return this.type;
    }

    /* renamed from: component2, reason: from getter */
    public final Boolean getEnabled() {
        return this.enabled;
    }

    /* renamed from: component3, reason: from getter */
    public final int getNextSessionTimeLeft() {
        return this.nextSessionTimeLeft;
    }

    /* renamed from: component4, reason: from getter */
    public final int getCodeLength() {
        return this.codeLength;
    }

    /* renamed from: component5, reason: from getter */
    public final Integer getAttemptsCount() {
        return this.attemptsCount;
    }

    /* renamed from: component6, reason: from getter */
    public final Integer getAttemptsLeft() {
        return this.attemptsLeft;
    }

    public final AuthTypeStateResponse copy(@JsonProperty("type") AuthTypes type, @JsonProperty("enabled") Boolean enabled, @JsonProperty("nextSessionTimeLeft") int nextSessionTimeLeft, @JsonProperty("codeLength") int codeLength, @JsonProperty("attemptsCount") Integer attemptsCount, @JsonProperty("attemptsLeft") Integer attemptsLeft) {
        Intrinsics.checkNotNullParameter(type, "type");
        return new AuthTypeStateResponse(type, enabled, nextSessionTimeLeft, codeLength, attemptsCount, attemptsLeft);
    }

    public boolean equals(Object other) {
        if (this == other) {
            return true;
        }
        if (!(other instanceof AuthTypeStateResponse)) {
            return false;
        }
        AuthTypeStateResponse authTypeStateResponse = (AuthTypeStateResponse) other;
        return this.type == authTypeStateResponse.type && Intrinsics.areEqual(this.enabled, authTypeStateResponse.enabled) && this.nextSessionTimeLeft == authTypeStateResponse.nextSessionTimeLeft && this.codeLength == authTypeStateResponse.codeLength && Intrinsics.areEqual(this.attemptsCount, authTypeStateResponse.attemptsCount) && Intrinsics.areEqual(this.attemptsLeft, authTypeStateResponse.attemptsLeft);
    }

    public final Integer getAttemptsCount() {
        return this.attemptsCount;
    }

    public final Integer getAttemptsLeft() {
        return this.attemptsLeft;
    }

    public final int getCodeLength() {
        return this.codeLength;
    }

    public final Boolean getEnabled() {
        return this.enabled;
    }

    public final int getNextSessionTimeLeft() {
        return this.nextSessionTimeLeft;
    }

    public final AuthTypes getType() {
        return this.type;
    }

    public int hashCode() {
        int iHashCode = this.type.hashCode() * 31;
        Boolean bool = this.enabled;
        int iHashCode2 = (Integer.hashCode(this.codeLength) + ((Integer.hashCode(this.nextSessionTimeLeft) + ((iHashCode + (bool == null ? 0 : bool.hashCode())) * 31)) * 31)) * 31;
        Integer num = this.attemptsCount;
        int iHashCode3 = (iHashCode2 + (num == null ? 0 : num.hashCode())) * 31;
        Integer num2 = this.attemptsLeft;
        return iHashCode3 + (num2 != null ? num2.hashCode() : 0);
    }

    public String toString() {
        return "AuthTypeStateResponse(type=" + this.type + ", enabled=" + this.enabled + ", nextSessionTimeLeft=" + this.nextSessionTimeLeft + ", codeLength=" + this.codeLength + ", attemptsCount=" + this.attemptsCount + ", attemptsLeft=" + this.attemptsLeft + ")";
    }
}

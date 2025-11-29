package ru.yoomoney.sdk.auth.api.oauth.domain;

import com.fasterxml.jackson.annotation.JsonProperty;
import com.huawei.updatesdk.service.otaupdate.UpdateKey;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import org.threeten.bp.LocalDateTime;

@Metadata(d1 = {"\u0000.\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0018\u0002\n\u0002\b\f\n\u0002\u0010\u000b\n\u0002\b\u0002\n\u0002\u0010\b\n\u0002\b\u0002\b\u0086\b\u0018\u00002\u00020\u0001B'\u0012\b\b\u0001\u0010\u0002\u001a\u00020\u0003\u0012\n\b\u0001\u0010\u0004\u001a\u0004\u0018\u00010\u0005\u0012\n\b\u0001\u0010\u0006\u001a\u0004\u0018\u00010\u0007¢\u0006\u0002\u0010\bJ\t\u0010\u000f\u001a\u00020\u0003HÆ\u0003J\u000b\u0010\u0010\u001a\u0004\u0018\u00010\u0005HÆ\u0003J\u000b\u0010\u0011\u001a\u0004\u0018\u00010\u0007HÆ\u0003J+\u0010\u0012\u001a\u00020\u00002\b\b\u0003\u0010\u0002\u001a\u00020\u00032\n\b\u0003\u0010\u0004\u001a\u0004\u0018\u00010\u00052\n\b\u0003\u0010\u0006\u001a\u0004\u0018\u00010\u0007HÆ\u0001J\u0013\u0010\u0013\u001a\u00020\u00142\b\u0010\u0015\u001a\u0004\u0018\u00010\u0001HÖ\u0003J\t\u0010\u0016\u001a\u00020\u0017HÖ\u0001J\t\u0010\u0018\u001a\u00020\u0005HÖ\u0001R\u0013\u0010\u0004\u001a\u0004\u0018\u00010\u0005¢\u0006\b\n\u0000\u001a\u0004\b\t\u0010\nR\u0011\u0010\u0002\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u000b\u0010\fR\u0013\u0010\u0006\u001a\u0004\u0018\u00010\u0007¢\u0006\b\n\u0000\u001a\u0004\b\r\u0010\u000e¨\u0006\u0019"}, d2 = {"Lru/yoomoney/sdk/auth/api/oauth/domain/CreateAuthorizationCodeResponse;", "", UpdateKey.STATUS, "Lru/yoomoney/sdk/auth/api/oauth/domain/Status;", "code", "", "validUntil", "Lorg/threeten/bp/LocalDateTime;", "(Lru/yoomoney/sdk/auth/api/oauth/domain/Status;Ljava/lang/String;Lorg/threeten/bp/LocalDateTime;)V", "getCode", "()Ljava/lang/String;", "getStatus", "()Lru/yoomoney/sdk/auth/api/oauth/domain/Status;", "getValidUntil", "()Lorg/threeten/bp/LocalDateTime;", "component1", "component2", "component3", "copy", "equals", "", "other", "hashCode", "", "toString", "auth_release"}, k = 1, mv = {1, 9, 0}, xi = 48)
/* loaded from: classes4.dex */
public final /* data */ class CreateAuthorizationCodeResponse {
    private final String code;
    private final Status status;
    private final LocalDateTime validUntil;

    public CreateAuthorizationCodeResponse(@JsonProperty(UpdateKey.STATUS) Status status, @JsonProperty("code") String str, @JsonProperty("validUntil") LocalDateTime localDateTime) {
        Intrinsics.checkNotNullParameter(status, "status");
        this.status = status;
        this.code = str;
        this.validUntil = localDateTime;
    }

    public static /* synthetic */ CreateAuthorizationCodeResponse copy$default(CreateAuthorizationCodeResponse createAuthorizationCodeResponse, Status status, String str, LocalDateTime localDateTime, int i, Object obj) {
        if ((i & 1) != 0) {
            status = createAuthorizationCodeResponse.status;
        }
        if ((i & 2) != 0) {
            str = createAuthorizationCodeResponse.code;
        }
        if ((i & 4) != 0) {
            localDateTime = createAuthorizationCodeResponse.validUntil;
        }
        return createAuthorizationCodeResponse.copy(status, str, localDateTime);
    }

    /* renamed from: component1, reason: from getter */
    public final Status getStatus() {
        return this.status;
    }

    /* renamed from: component2, reason: from getter */
    public final String getCode() {
        return this.code;
    }

    /* renamed from: component3, reason: from getter */
    public final LocalDateTime getValidUntil() {
        return this.validUntil;
    }

    public final CreateAuthorizationCodeResponse copy(@JsonProperty(UpdateKey.STATUS) Status status, @JsonProperty("code") String code, @JsonProperty("validUntil") LocalDateTime validUntil) {
        Intrinsics.checkNotNullParameter(status, "status");
        return new CreateAuthorizationCodeResponse(status, code, validUntil);
    }

    public boolean equals(Object other) {
        if (this == other) {
            return true;
        }
        if (!(other instanceof CreateAuthorizationCodeResponse)) {
            return false;
        }
        CreateAuthorizationCodeResponse createAuthorizationCodeResponse = (CreateAuthorizationCodeResponse) other;
        return this.status == createAuthorizationCodeResponse.status && Intrinsics.areEqual(this.code, createAuthorizationCodeResponse.code) && Intrinsics.areEqual(this.validUntil, createAuthorizationCodeResponse.validUntil);
    }

    public final String getCode() {
        return this.code;
    }

    public final Status getStatus() {
        return this.status;
    }

    public final LocalDateTime getValidUntil() {
        return this.validUntil;
    }

    public int hashCode() {
        int iHashCode = this.status.hashCode() * 31;
        String str = this.code;
        int iHashCode2 = (iHashCode + (str == null ? 0 : str.hashCode())) * 31;
        LocalDateTime localDateTime = this.validUntil;
        return iHashCode2 + (localDateTime != null ? localDateTime.hashCode() : 0);
    }

    public String toString() {
        return "CreateAuthorizationCodeResponse(status=" + this.status + ", code=" + this.code + ", validUntil=" + this.validUntil + ")";
    }
}

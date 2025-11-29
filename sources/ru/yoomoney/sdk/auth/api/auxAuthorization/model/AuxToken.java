package ru.yoomoney.sdk.auth.api.auxAuthorization.model;

import com.google.gson.annotations.SerializedName;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import org.threeten.bp.OffsetDateTime;
import ru.yoomoney.sdk.auth.YooMoneyAuth;

@Metadata(d1 = {"\u0000(\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0018\u0002\n\u0002\b\t\n\u0002\u0010\u000b\n\u0002\b\u0002\n\u0002\u0010\b\n\u0002\b\u0002\b\u0086\b\u0018\u00002\u00020\u0001B\u0015\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\u0006\u0010\u0004\u001a\u00020\u0005¢\u0006\u0002\u0010\u0006J\t\u0010\u000b\u001a\u00020\u0003HÆ\u0003J\t\u0010\f\u001a\u00020\u0005HÆ\u0003J\u001d\u0010\r\u001a\u00020\u00002\b\b\u0002\u0010\u0002\u001a\u00020\u00032\b\b\u0002\u0010\u0004\u001a\u00020\u0005HÆ\u0001J\u0013\u0010\u000e\u001a\u00020\u000f2\b\u0010\u0010\u001a\u0004\u0018\u00010\u0001HÖ\u0003J\t\u0010\u0011\u001a\u00020\u0012HÖ\u0001J\t\u0010\u0013\u001a\u00020\u0003HÖ\u0001R\u0016\u0010\u0002\u001a\u00020\u00038\u0006X\u0087\u0004¢\u0006\b\n\u0000\u001a\u0004\b\u0007\u0010\bR\u0016\u0010\u0004\u001a\u00020\u00058\u0006X\u0087\u0004¢\u0006\b\n\u0000\u001a\u0004\b\t\u0010\n¨\u0006\u0014"}, d2 = {"Lru/yoomoney/sdk/auth/api/auxAuthorization/model/AuxToken;", "", YooMoneyAuth.KEY_ACCESS_TOKEN, "", "expireAt", "Lorg/threeten/bp/OffsetDateTime;", "(Ljava/lang/String;Lorg/threeten/bp/OffsetDateTime;)V", "getAccessToken", "()Ljava/lang/String;", "getExpireAt", "()Lorg/threeten/bp/OffsetDateTime;", "component1", "component2", "copy", "equals", "", "other", "hashCode", "", "toString", "auth_release"}, k = 1, mv = {1, 9, 0}, xi = 48)
/* loaded from: classes4.dex */
public final /* data */ class AuxToken {

    @SerializedName(YooMoneyAuth.KEY_ACCESS_TOKEN)
    private final String accessToken;

    @SerializedName("expireAt")
    private final OffsetDateTime expireAt;

    public AuxToken(String accessToken, OffsetDateTime expireAt) {
        Intrinsics.checkNotNullParameter(accessToken, "accessToken");
        Intrinsics.checkNotNullParameter(expireAt, "expireAt");
        this.accessToken = accessToken;
        this.expireAt = expireAt;
    }

    public static /* synthetic */ AuxToken copy$default(AuxToken auxToken, String str, OffsetDateTime offsetDateTime, int i, Object obj) {
        if ((i & 1) != 0) {
            str = auxToken.accessToken;
        }
        if ((i & 2) != 0) {
            offsetDateTime = auxToken.expireAt;
        }
        return auxToken.copy(str, offsetDateTime);
    }

    /* renamed from: component1, reason: from getter */
    public final String getAccessToken() {
        return this.accessToken;
    }

    /* renamed from: component2, reason: from getter */
    public final OffsetDateTime getExpireAt() {
        return this.expireAt;
    }

    public final AuxToken copy(String accessToken, OffsetDateTime expireAt) {
        Intrinsics.checkNotNullParameter(accessToken, "accessToken");
        Intrinsics.checkNotNullParameter(expireAt, "expireAt");
        return new AuxToken(accessToken, expireAt);
    }

    public boolean equals(Object other) {
        if (this == other) {
            return true;
        }
        if (!(other instanceof AuxToken)) {
            return false;
        }
        AuxToken auxToken = (AuxToken) other;
        return Intrinsics.areEqual(this.accessToken, auxToken.accessToken) && Intrinsics.areEqual(this.expireAt, auxToken.expireAt);
    }

    public final String getAccessToken() {
        return this.accessToken;
    }

    public final OffsetDateTime getExpireAt() {
        return this.expireAt;
    }

    public int hashCode() {
        return this.expireAt.hashCode() + (this.accessToken.hashCode() * 31);
    }

    public String toString() {
        return "AuxToken(accessToken=" + this.accessToken + ", expireAt=" + this.expireAt + ")";
    }
}

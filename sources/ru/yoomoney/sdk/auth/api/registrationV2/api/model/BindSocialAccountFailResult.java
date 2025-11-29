package ru.yoomoney.sdk.auth.api.registrationV2.api.model;

import com.fasterxml.jackson.annotation.JsonEnumDefaultValue;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.huawei.updatesdk.service.otaupdate.UpdateKey;
import kotlin.Metadata;
import kotlin.enums.EnumEntries;
import kotlin.enums.EnumEntriesKt;
import kotlin.jvm.internal.Intrinsics;
import ru.yoomoney.sdk.auth.api.registrationV2.api.model.BindSocialAccountResultBase;

@Metadata(d1 = {"\u00008\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\f\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0002\b\u0080\b\u0018\u00002\u00020\u0001:\u0001\u001bB#\u0012\b\b\u0001\u0010\u0002\u001a\u00020\u0003\u0012\b\b\u0001\u0010\u0004\u001a\u00020\u0005\u0012\b\b\u0001\u0010\u0006\u001a\u00020\u0007¢\u0006\u0002\u0010\bJ\t\u0010\u000f\u001a\u00020\u0003HÆ\u0003J\t\u0010\u0010\u001a\u00020\u0005HÆ\u0003J\t\u0010\u0011\u001a\u00020\u0007HÆ\u0003J'\u0010\u0012\u001a\u00020\u00002\b\b\u0003\u0010\u0002\u001a\u00020\u00032\b\b\u0003\u0010\u0004\u001a\u00020\u00052\b\b\u0003\u0010\u0006\u001a\u00020\u0007HÆ\u0001J\u0013\u0010\u0013\u001a\u00020\u00142\b\u0010\u0015\u001a\u0004\u0018\u00010\u0016HÖ\u0003J\t\u0010\u0017\u001a\u00020\u0018HÖ\u0001J\t\u0010\u0019\u001a\u00020\u001aHÖ\u0001R\u0011\u0010\u0006\u001a\u00020\u0007¢\u0006\b\n\u0000\u001a\u0004\b\t\u0010\nR\u0014\u0010\u0004\u001a\u00020\u0005X\u0096\u0004¢\u0006\b\n\u0000\u001a\u0004\b\u000b\u0010\fR\u0014\u0010\u0002\u001a\u00020\u0003X\u0096\u0004¢\u0006\b\n\u0000\u001a\u0004\b\r\u0010\u000e¨\u0006\u001c"}, d2 = {"Lru/yoomoney/sdk/auth/api/registrationV2/api/model/BindSocialAccountFailResult;", "Lru/yoomoney/sdk/auth/api/registrationV2/api/model/BindSocialAccountResultBase;", UpdateKey.STATUS, "Lru/yoomoney/sdk/auth/api/registrationV2/api/model/BindSocialAccountResultBase$Status;", "service", "Lru/yoomoney/sdk/auth/api/registrationV2/api/model/OauthServiceProvider;", "reason", "Lru/yoomoney/sdk/auth/api/registrationV2/api/model/BindSocialAccountFailResult$Reason;", "(Lru/yoomoney/sdk/auth/api/registrationV2/api/model/BindSocialAccountResultBase$Status;Lru/yoomoney/sdk/auth/api/registrationV2/api/model/OauthServiceProvider;Lru/yoomoney/sdk/auth/api/registrationV2/api/model/BindSocialAccountFailResult$Reason;)V", "getReason", "()Lru/yoomoney/sdk/auth/api/registrationV2/api/model/BindSocialAccountFailResult$Reason;", "getService", "()Lru/yoomoney/sdk/auth/api/registrationV2/api/model/OauthServiceProvider;", "getStatus", "()Lru/yoomoney/sdk/auth/api/registrationV2/api/model/BindSocialAccountResultBase$Status;", "component1", "component2", "component3", "copy", "equals", "", "other", "", "hashCode", "", "toString", "", "Reason", "auth_release"}, k = 1, mv = {1, 9, 0}, xi = 48)
/* loaded from: classes4.dex */
public final /* data */ class BindSocialAccountFailResult extends BindSocialAccountResultBase {
    private final Reason reason;
    private final OauthServiceProvider service;
    private final BindSocialAccountResultBase.Status status;

    /* JADX WARN: Failed to restore enum class, 'enum' modifier and super class removed */
    /* JADX WARN: Unknown enum class pattern. Please report as an issue! */
    @Metadata(d1 = {"\u0000\f\n\u0002\u0018\u0002\n\u0002\u0010\u0010\n\u0002\b\u0005\b\u0086\u0081\u0002\u0018\u00002\b\u0012\u0004\u0012\u00020\u00000\u0001B\u0007\b\u0002¢\u0006\u0002\u0010\u0002j\u0002\b\u0003j\u0002\b\u0004j\u0002\b\u0005¨\u0006\u0006"}, d2 = {"Lru/yoomoney/sdk/auth/api/registrationV2/api/model/BindSocialAccountFailResult$Reason;", "", "(Ljava/lang/String;I)V", "SOCIAL_ACCOUNT_ALREADY_BOUND", "TECHNICAL_ERROR", "UNKNOWN_ENUM", "auth_release"}, k = 1, mv = {1, 9, 0}, xi = 48)
    public static final class Reason {
        private static final /* synthetic */ EnumEntries $ENTRIES;
        private static final /* synthetic */ Reason[] $VALUES;

        @JsonProperty("SocialAccountAlreadyBound")
        public static final Reason SOCIAL_ACCOUNT_ALREADY_BOUND = new Reason("SOCIAL_ACCOUNT_ALREADY_BOUND", 0);

        @JsonProperty("TechnicalError")
        public static final Reason TECHNICAL_ERROR = new Reason("TECHNICAL_ERROR", 1);

        @JsonEnumDefaultValue
        public static final Reason UNKNOWN_ENUM = new Reason("UNKNOWN_ENUM", 2);

        private static final /* synthetic */ Reason[] $values() {
            return new Reason[]{SOCIAL_ACCOUNT_ALREADY_BOUND, TECHNICAL_ERROR, UNKNOWN_ENUM};
        }

        static {
            Reason[] reasonArr$values = $values();
            $VALUES = reasonArr$values;
            $ENTRIES = EnumEntriesKt.enumEntries(reasonArr$values);
        }

        private Reason(String str, int i) {
        }

        public static EnumEntries<Reason> getEntries() {
            return $ENTRIES;
        }

        public static Reason valueOf(String str) {
            return (Reason) Enum.valueOf(Reason.class, str);
        }

        public static Reason[] values() {
            return (Reason[]) $VALUES.clone();
        }
    }

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public BindSocialAccountFailResult(@JsonProperty(UpdateKey.STATUS) BindSocialAccountResultBase.Status status, @JsonProperty("service") OauthServiceProvider service, @JsonProperty("reason") Reason reason) {
        super(null);
        Intrinsics.checkNotNullParameter(status, "status");
        Intrinsics.checkNotNullParameter(service, "service");
        Intrinsics.checkNotNullParameter(reason, "reason");
        this.status = status;
        this.service = service;
        this.reason = reason;
    }

    public static /* synthetic */ BindSocialAccountFailResult copy$default(BindSocialAccountFailResult bindSocialAccountFailResult, BindSocialAccountResultBase.Status status, OauthServiceProvider oauthServiceProvider, Reason reason, int i, Object obj) {
        if ((i & 1) != 0) {
            status = bindSocialAccountFailResult.status;
        }
        if ((i & 2) != 0) {
            oauthServiceProvider = bindSocialAccountFailResult.service;
        }
        if ((i & 4) != 0) {
            reason = bindSocialAccountFailResult.reason;
        }
        return bindSocialAccountFailResult.copy(status, oauthServiceProvider, reason);
    }

    /* renamed from: component1, reason: from getter */
    public final BindSocialAccountResultBase.Status getStatus() {
        return this.status;
    }

    /* renamed from: component2, reason: from getter */
    public final OauthServiceProvider getService() {
        return this.service;
    }

    /* renamed from: component3, reason: from getter */
    public final Reason getReason() {
        return this.reason;
    }

    public final BindSocialAccountFailResult copy(@JsonProperty(UpdateKey.STATUS) BindSocialAccountResultBase.Status status, @JsonProperty("service") OauthServiceProvider service, @JsonProperty("reason") Reason reason) {
        Intrinsics.checkNotNullParameter(status, "status");
        Intrinsics.checkNotNullParameter(service, "service");
        Intrinsics.checkNotNullParameter(reason, "reason");
        return new BindSocialAccountFailResult(status, service, reason);
    }

    public boolean equals(Object other) {
        if (this == other) {
            return true;
        }
        if (!(other instanceof BindSocialAccountFailResult)) {
            return false;
        }
        BindSocialAccountFailResult bindSocialAccountFailResult = (BindSocialAccountFailResult) other;
        return this.status == bindSocialAccountFailResult.status && this.service == bindSocialAccountFailResult.service && this.reason == bindSocialAccountFailResult.reason;
    }

    public final Reason getReason() {
        return this.reason;
    }

    @Override // ru.yoomoney.sdk.auth.api.registrationV2.api.model.BindSocialAccountResultBase
    public OauthServiceProvider getService() {
        return this.service;
    }

    @Override // ru.yoomoney.sdk.auth.api.registrationV2.api.model.BindSocialAccountResultBase
    public BindSocialAccountResultBase.Status getStatus() {
        return this.status;
    }

    public int hashCode() {
        return this.reason.hashCode() + ((this.service.hashCode() + (this.status.hashCode() * 31)) * 31);
    }

    public String toString() {
        return "BindSocialAccountFailResult(status=" + this.status + ", service=" + this.service + ", reason=" + this.reason + ")";
    }
}

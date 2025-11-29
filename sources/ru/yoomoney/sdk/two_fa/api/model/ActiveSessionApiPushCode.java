package ru.yoomoney.sdk.two_fa.api.model;

import com.fasterxml.jackson.annotation.JsonProperty;
import kotlin.Metadata;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;

/* compiled from: ActiveSessionApiPushCode.kt */
@Metadata(d1 = {"\u00004\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u000e\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\b\n\u0002\b\u0002\b\u0080\b\u0018\u00002\u00020\u0001B/\u0012\b\b\u0001\u0010\u0002\u001a\u00020\u0003\u0012\b\b\u0001\u0010\u0004\u001a\u00020\u0005\u0012\b\b\u0001\u0010\u0006\u001a\u00020\u0005\u0012\n\b\u0003\u0010\u0007\u001a\u0004\u0018\u00010\b¢\u0006\u0002\u0010\tJ\t\u0010\u0011\u001a\u00020\u0003HÆ\u0003J\t\u0010\u0012\u001a\u00020\u0005HÆ\u0003J\t\u0010\u0013\u001a\u00020\u0005HÆ\u0003J\u000b\u0010\u0014\u001a\u0004\u0018\u00010\bHÆ\u0003J3\u0010\u0015\u001a\u00020\u00002\b\b\u0003\u0010\u0002\u001a\u00020\u00032\b\b\u0003\u0010\u0004\u001a\u00020\u00052\b\b\u0003\u0010\u0006\u001a\u00020\u00052\n\b\u0003\u0010\u0007\u001a\u0004\u0018\u00010\bHÆ\u0001J\u0013\u0010\u0016\u001a\u00020\u00172\b\u0010\u0018\u001a\u0004\u0018\u00010\u0019HÖ\u0003J\t\u0010\u001a\u001a\u00020\u001bHÖ\u0001J\t\u0010\u001c\u001a\u00020\u0005HÖ\u0001R\u0014\u0010\u0004\u001a\u00020\u0005X\u0096\u0004¢\u0006\b\n\u0000\u001a\u0004\b\n\u0010\u000bR\u0011\u0010\u0006\u001a\u00020\u0005¢\u0006\b\n\u0000\u001a\u0004\b\f\u0010\u000bR\u0013\u0010\u0007\u001a\u0004\u0018\u00010\b¢\u0006\b\n\u0000\u001a\u0004\b\r\u0010\u000eR\u0014\u0010\u0002\u001a\u00020\u0003X\u0096\u0004¢\u0006\b\n\u0000\u001a\u0004\b\u000f\u0010\u0010¨\u0006\u001d"}, d2 = {"Lru/yoomoney/sdk/two_fa/api/model/ActiveSessionApiPushCode;", "Lru/yoomoney/sdk/two_fa/api/model/ActiveSessionApi;", "type", "Lru/yoomoney/sdk/two_fa/api/model/ActiveSessionApiType;", "authProcessId", "", "confirmationCode", "operationInfo", "Lru/yoomoney/sdk/two_fa/api/model/ActiveSessionOperationInfo;", "(Lru/yoomoney/sdk/two_fa/api/model/ActiveSessionApiType;Ljava/lang/String;Ljava/lang/String;Lru/yoomoney/sdk/two_fa/api/model/ActiveSessionOperationInfo;)V", "getAuthProcessId", "()Ljava/lang/String;", "getConfirmationCode", "getOperationInfo", "()Lru/yoomoney/sdk/two_fa/api/model/ActiveSessionOperationInfo;", "getType", "()Lru/yoomoney/sdk/two_fa/api/model/ActiveSessionApiType;", "component1", "component2", "component3", "component4", "copy", "equals", "", "other", "", "hashCode", "", "toString", "two-fa_release"}, k = 1, mv = {1, 9, 0}, xi = 48)
/* loaded from: classes5.dex */
public final /* data */ class ActiveSessionApiPushCode extends ActiveSessionApi {
    public static final int $stable = 0;
    private final String authProcessId;
    private final String confirmationCode;
    private final ActiveSessionOperationInfo operationInfo;
    private final ActiveSessionApiType type;

    public static /* synthetic */ ActiveSessionApiPushCode copy$default(ActiveSessionApiPushCode activeSessionApiPushCode, ActiveSessionApiType activeSessionApiType, String str, String str2, ActiveSessionOperationInfo activeSessionOperationInfo, int i, Object obj) {
        if ((i & 1) != 0) {
            activeSessionApiType = activeSessionApiPushCode.type;
        }
        if ((i & 2) != 0) {
            str = activeSessionApiPushCode.authProcessId;
        }
        if ((i & 4) != 0) {
            str2 = activeSessionApiPushCode.confirmationCode;
        }
        if ((i & 8) != 0) {
            activeSessionOperationInfo = activeSessionApiPushCode.operationInfo;
        }
        return activeSessionApiPushCode.copy(activeSessionApiType, str, str2, activeSessionOperationInfo);
    }

    /* renamed from: component1, reason: from getter */
    public final ActiveSessionApiType getType() {
        return this.type;
    }

    /* renamed from: component2, reason: from getter */
    public final String getAuthProcessId() {
        return this.authProcessId;
    }

    /* renamed from: component3, reason: from getter */
    public final String getConfirmationCode() {
        return this.confirmationCode;
    }

    /* renamed from: component4, reason: from getter */
    public final ActiveSessionOperationInfo getOperationInfo() {
        return this.operationInfo;
    }

    public final ActiveSessionApiPushCode copy(@JsonProperty("type") ActiveSessionApiType type, @JsonProperty("authProcessId") String authProcessId, @JsonProperty("confirmationCode") String confirmationCode, @JsonProperty("operationInfo") ActiveSessionOperationInfo operationInfo) {
        Intrinsics.checkNotNullParameter(type, "type");
        Intrinsics.checkNotNullParameter(authProcessId, "authProcessId");
        Intrinsics.checkNotNullParameter(confirmationCode, "confirmationCode");
        return new ActiveSessionApiPushCode(type, authProcessId, confirmationCode, operationInfo);
    }

    public boolean equals(Object other) {
        if (this == other) {
            return true;
        }
        if (!(other instanceof ActiveSessionApiPushCode)) {
            return false;
        }
        ActiveSessionApiPushCode activeSessionApiPushCode = (ActiveSessionApiPushCode) other;
        return this.type == activeSessionApiPushCode.type && Intrinsics.areEqual(this.authProcessId, activeSessionApiPushCode.authProcessId) && Intrinsics.areEqual(this.confirmationCode, activeSessionApiPushCode.confirmationCode) && Intrinsics.areEqual(this.operationInfo, activeSessionApiPushCode.operationInfo);
    }

    public int hashCode() {
        int iHashCode = ((((this.type.hashCode() * 31) + this.authProcessId.hashCode()) * 31) + this.confirmationCode.hashCode()) * 31;
        ActiveSessionOperationInfo activeSessionOperationInfo = this.operationInfo;
        return iHashCode + (activeSessionOperationInfo == null ? 0 : activeSessionOperationInfo.hashCode());
    }

    public String toString() {
        return "ActiveSessionApiPushCode(type=" + this.type + ", authProcessId=" + this.authProcessId + ", confirmationCode=" + this.confirmationCode + ", operationInfo=" + this.operationInfo + ")";
    }

    public /* synthetic */ ActiveSessionApiPushCode(ActiveSessionApiType activeSessionApiType, String str, String str2, ActiveSessionOperationInfo activeSessionOperationInfo, int i, DefaultConstructorMarker defaultConstructorMarker) {
        this(activeSessionApiType, str, str2, (i & 8) != 0 ? null : activeSessionOperationInfo);
    }

    @Override // ru.yoomoney.sdk.two_fa.api.model.ActiveSessionApi
    public ActiveSessionApiType getType() {
        return this.type;
    }

    @Override // ru.yoomoney.sdk.two_fa.api.model.ActiveSessionApi
    public String getAuthProcessId() {
        return this.authProcessId;
    }

    public final String getConfirmationCode() {
        return this.confirmationCode;
    }

    public final ActiveSessionOperationInfo getOperationInfo() {
        return this.operationInfo;
    }

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public ActiveSessionApiPushCode(@JsonProperty("type") ActiveSessionApiType type, @JsonProperty("authProcessId") String authProcessId, @JsonProperty("confirmationCode") String confirmationCode, @JsonProperty("operationInfo") ActiveSessionOperationInfo activeSessionOperationInfo) {
        super(null);
        Intrinsics.checkNotNullParameter(type, "type");
        Intrinsics.checkNotNullParameter(authProcessId, "authProcessId");
        Intrinsics.checkNotNullParameter(confirmationCode, "confirmationCode");
        this.type = type;
        this.authProcessId = authProcessId;
        this.confirmationCode = confirmationCode;
        this.operationInfo = activeSessionOperationInfo;
    }
}

package ru.yoomoney.sdk.two_fa.api.model;

import com.fasterxml.jackson.annotation.JsonProperty;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

/* compiled from: ActiveSessionApiDefaultType.kt */
@Metadata(d1 = {"\u0000,\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0002\b\t\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\b\n\u0002\b\u0002\b\u0080\b\u0018\u00002\u00020\u0001B\u0019\u0012\b\b\u0001\u0010\u0002\u001a\u00020\u0003\u0012\b\b\u0001\u0010\u0004\u001a\u00020\u0005¢\u0006\u0002\u0010\u0006J\t\u0010\u000b\u001a\u00020\u0003HÆ\u0003J\t\u0010\f\u001a\u00020\u0005HÆ\u0003J\u001d\u0010\r\u001a\u00020\u00002\b\b\u0003\u0010\u0002\u001a\u00020\u00032\b\b\u0003\u0010\u0004\u001a\u00020\u0005HÆ\u0001J\u0013\u0010\u000e\u001a\u00020\u000f2\b\u0010\u0010\u001a\u0004\u0018\u00010\u0011HÖ\u0003J\t\u0010\u0012\u001a\u00020\u0013HÖ\u0001J\t\u0010\u0014\u001a\u00020\u0005HÖ\u0001R\u0014\u0010\u0004\u001a\u00020\u0005X\u0096\u0004¢\u0006\b\n\u0000\u001a\u0004\b\u0007\u0010\bR\u0014\u0010\u0002\u001a\u00020\u0003X\u0096\u0004¢\u0006\b\n\u0000\u001a\u0004\b\t\u0010\n¨\u0006\u0015"}, d2 = {"Lru/yoomoney/sdk/two_fa/api/model/ActiveSessionApiDefaultType;", "Lru/yoomoney/sdk/two_fa/api/model/ActiveSessionApi;", "type", "Lru/yoomoney/sdk/two_fa/api/model/ActiveSessionApiType;", "authProcessId", "", "(Lru/yoomoney/sdk/two_fa/api/model/ActiveSessionApiType;Ljava/lang/String;)V", "getAuthProcessId", "()Ljava/lang/String;", "getType", "()Lru/yoomoney/sdk/two_fa/api/model/ActiveSessionApiType;", "component1", "component2", "copy", "equals", "", "other", "", "hashCode", "", "toString", "two-fa_release"}, k = 1, mv = {1, 9, 0}, xi = 48)
/* loaded from: classes5.dex */
public final /* data */ class ActiveSessionApiDefaultType extends ActiveSessionApi {
    public static final int $stable = 0;
    private final String authProcessId;
    private final ActiveSessionApiType type;

    public static /* synthetic */ ActiveSessionApiDefaultType copy$default(ActiveSessionApiDefaultType activeSessionApiDefaultType, ActiveSessionApiType activeSessionApiType, String str, int i, Object obj) {
        if ((i & 1) != 0) {
            activeSessionApiType = activeSessionApiDefaultType.type;
        }
        if ((i & 2) != 0) {
            str = activeSessionApiDefaultType.authProcessId;
        }
        return activeSessionApiDefaultType.copy(activeSessionApiType, str);
    }

    /* renamed from: component1, reason: from getter */
    public final ActiveSessionApiType getType() {
        return this.type;
    }

    /* renamed from: component2, reason: from getter */
    public final String getAuthProcessId() {
        return this.authProcessId;
    }

    public final ActiveSessionApiDefaultType copy(@JsonProperty("type") ActiveSessionApiType type, @JsonProperty("authProcessId") String authProcessId) {
        Intrinsics.checkNotNullParameter(type, "type");
        Intrinsics.checkNotNullParameter(authProcessId, "authProcessId");
        return new ActiveSessionApiDefaultType(type, authProcessId);
    }

    public boolean equals(Object other) {
        if (this == other) {
            return true;
        }
        if (!(other instanceof ActiveSessionApiDefaultType)) {
            return false;
        }
        ActiveSessionApiDefaultType activeSessionApiDefaultType = (ActiveSessionApiDefaultType) other;
        return this.type == activeSessionApiDefaultType.type && Intrinsics.areEqual(this.authProcessId, activeSessionApiDefaultType.authProcessId);
    }

    public int hashCode() {
        return (this.type.hashCode() * 31) + this.authProcessId.hashCode();
    }

    public String toString() {
        return "ActiveSessionApiDefaultType(type=" + this.type + ", authProcessId=" + this.authProcessId + ")";
    }

    @Override // ru.yoomoney.sdk.two_fa.api.model.ActiveSessionApi
    public ActiveSessionApiType getType() {
        return this.type;
    }

    @Override // ru.yoomoney.sdk.two_fa.api.model.ActiveSessionApi
    public String getAuthProcessId() {
        return this.authProcessId;
    }

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public ActiveSessionApiDefaultType(@JsonProperty("type") ActiveSessionApiType type, @JsonProperty("authProcessId") String authProcessId) {
        super(null);
        Intrinsics.checkNotNullParameter(type, "type");
        Intrinsics.checkNotNullParameter(authProcessId, "authProcessId");
        this.type = type;
        this.authProcessId = authProcessId;
    }
}

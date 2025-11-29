package ru.yoomoney.sdk.two_fa.api.model;

import com.fasterxml.jackson.annotation.JsonProperty;
import kotlin.Metadata;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;

/* compiled from: ActiveSessionOperationInfo.kt */
@Metadata(d1 = {"\u0000*\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u000b\n\u0002\u0010\u000b\n\u0002\b\u0002\n\u0002\u0010\b\n\u0002\b\u0002\b\u0080\b\u0018\u00002\u00020\u0001B)\u0012\n\b\u0003\u0010\u0002\u001a\u0004\u0018\u00010\u0003\u0012\n\b\u0003\u0010\u0004\u001a\u0004\u0018\u00010\u0003\u0012\n\b\u0003\u0010\u0005\u001a\u0004\u0018\u00010\u0006¢\u0006\u0002\u0010\u0007J\u000b\u0010\r\u001a\u0004\u0018\u00010\u0003HÆ\u0003J\u000b\u0010\u000e\u001a\u0004\u0018\u00010\u0003HÆ\u0003J\u000b\u0010\u000f\u001a\u0004\u0018\u00010\u0006HÆ\u0003J-\u0010\u0010\u001a\u00020\u00002\n\b\u0003\u0010\u0002\u001a\u0004\u0018\u00010\u00032\n\b\u0003\u0010\u0004\u001a\u0004\u0018\u00010\u00032\n\b\u0003\u0010\u0005\u001a\u0004\u0018\u00010\u0006HÆ\u0001J\u0013\u0010\u0011\u001a\u00020\u00122\b\u0010\u0013\u001a\u0004\u0018\u00010\u0001HÖ\u0003J\t\u0010\u0014\u001a\u00020\u0015HÖ\u0001J\t\u0010\u0016\u001a\u00020\u0003HÖ\u0001R\u0013\u0010\u0005\u001a\u0004\u0018\u00010\u0006¢\u0006\b\n\u0000\u001a\u0004\b\b\u0010\tR\u0013\u0010\u0004\u001a\u0004\u0018\u00010\u0003¢\u0006\b\n\u0000\u001a\u0004\b\n\u0010\u000bR\u0013\u0010\u0002\u001a\u0004\u0018\u00010\u0003¢\u0006\b\n\u0000\u001a\u0004\b\f\u0010\u000b¨\u0006\u0017"}, d2 = {"Lru/yoomoney/sdk/two_fa/api/model/ActiveSessionOperationInfo;", "", "operationName", "", "operationKey", "amount", "Lru/yoomoney/sdk/two_fa/api/model/MonetaryAmount;", "(Ljava/lang/String;Ljava/lang/String;Lru/yoomoney/sdk/two_fa/api/model/MonetaryAmount;)V", "getAmount", "()Lru/yoomoney/sdk/two_fa/api/model/MonetaryAmount;", "getOperationKey", "()Ljava/lang/String;", "getOperationName", "component1", "component2", "component3", "copy", "equals", "", "other", "hashCode", "", "toString", "two-fa_release"}, k = 1, mv = {1, 9, 0}, xi = 48)
/* loaded from: classes5.dex */
public final /* data */ class ActiveSessionOperationInfo {
    public static final int $stable = 0;
    private final MonetaryAmount amount;
    private final String operationKey;
    private final String operationName;

    public ActiveSessionOperationInfo() {
        this(null, null, null, 7, null);
    }

    public static /* synthetic */ ActiveSessionOperationInfo copy$default(ActiveSessionOperationInfo activeSessionOperationInfo, String str, String str2, MonetaryAmount monetaryAmount, int i, Object obj) {
        if ((i & 1) != 0) {
            str = activeSessionOperationInfo.operationName;
        }
        if ((i & 2) != 0) {
            str2 = activeSessionOperationInfo.operationKey;
        }
        if ((i & 4) != 0) {
            monetaryAmount = activeSessionOperationInfo.amount;
        }
        return activeSessionOperationInfo.copy(str, str2, monetaryAmount);
    }

    /* renamed from: component1, reason: from getter */
    public final String getOperationName() {
        return this.operationName;
    }

    /* renamed from: component2, reason: from getter */
    public final String getOperationKey() {
        return this.operationKey;
    }

    /* renamed from: component3, reason: from getter */
    public final MonetaryAmount getAmount() {
        return this.amount;
    }

    public final ActiveSessionOperationInfo copy(@JsonProperty("operationName") String operationName, @JsonProperty("operationKey") String operationKey, @JsonProperty("amount") MonetaryAmount amount) {
        return new ActiveSessionOperationInfo(operationName, operationKey, amount);
    }

    public boolean equals(Object other) {
        if (this == other) {
            return true;
        }
        if (!(other instanceof ActiveSessionOperationInfo)) {
            return false;
        }
        ActiveSessionOperationInfo activeSessionOperationInfo = (ActiveSessionOperationInfo) other;
        return Intrinsics.areEqual(this.operationName, activeSessionOperationInfo.operationName) && Intrinsics.areEqual(this.operationKey, activeSessionOperationInfo.operationKey) && Intrinsics.areEqual(this.amount, activeSessionOperationInfo.amount);
    }

    public int hashCode() {
        String str = this.operationName;
        int iHashCode = (str == null ? 0 : str.hashCode()) * 31;
        String str2 = this.operationKey;
        int iHashCode2 = (iHashCode + (str2 == null ? 0 : str2.hashCode())) * 31;
        MonetaryAmount monetaryAmount = this.amount;
        return iHashCode2 + (monetaryAmount != null ? monetaryAmount.hashCode() : 0);
    }

    public String toString() {
        return "ActiveSessionOperationInfo(operationName=" + this.operationName + ", operationKey=" + this.operationKey + ", amount=" + this.amount + ")";
    }

    public ActiveSessionOperationInfo(@JsonProperty("operationName") String str, @JsonProperty("operationKey") String str2, @JsonProperty("amount") MonetaryAmount monetaryAmount) {
        this.operationName = str;
        this.operationKey = str2;
        this.amount = monetaryAmount;
    }

    public /* synthetic */ ActiveSessionOperationInfo(String str, String str2, MonetaryAmount monetaryAmount, int i, DefaultConstructorMarker defaultConstructorMarker) {
        this((i & 1) != 0 ? null : str, (i & 2) != 0 ? null : str2, (i & 4) != 0 ? null : monetaryAmount);
    }

    public final String getOperationName() {
        return this.operationName;
    }

    public final String getOperationKey() {
        return this.operationKey;
    }

    public final MonetaryAmount getAmount() {
        return this.amount;
    }
}

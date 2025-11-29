package ru.yoomoney.sdk.kassa.payments.api.model.packageoptions;

import com.fasterxml.jackson.annotation.JsonProperty;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

@Metadata(d1 = {"\u0000&\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0018\u0002\n\u0002\b\t\n\u0002\u0010\u000b\n\u0002\b\u0002\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u000e\n\u0000\b\u0080\b\u0018\u00002\u00020\u0001B\u001d\u0012\n\b\u0001\u0010\u0002\u001a\u0004\u0018\u00010\u0003\u0012\n\b\u0001\u0010\u0004\u001a\u0004\u0018\u00010\u0003¢\u0006\u0002\u0010\u0005J\u000b\u0010\t\u001a\u0004\u0018\u00010\u0003HÆ\u0003J\u000b\u0010\n\u001a\u0004\u0018\u00010\u0003HÆ\u0003J!\u0010\u000b\u001a\u00020\u00002\n\b\u0003\u0010\u0002\u001a\u0004\u0018\u00010\u00032\n\b\u0003\u0010\u0004\u001a\u0004\u0018\u00010\u0003HÆ\u0001J\u0013\u0010\f\u001a\u00020\r2\b\u0010\u000e\u001a\u0004\u0018\u00010\u0001HÖ\u0003J\t\u0010\u000f\u001a\u00020\u0010HÖ\u0001J\t\u0010\u0011\u001a\u00020\u0012HÖ\u0001R\u0013\u0010\u0004\u001a\u0004\u0018\u00010\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u0006\u0010\u0007R\u0013\u0010\u0002\u001a\u0004\u0018\u00010\u0003¢\u0006\b\n\u0000\u001a\u0004\b\b\u0010\u0007¨\u0006\u0013"}, d2 = {"Lru/yoomoney/sdk/kassa/payments/api/model/packageoptions/Fee;", "", "service", "Lru/yoomoney/sdk/kassa/payments/api/model/packageoptions/Amount;", "counterparty", "(Lru/yoomoney/sdk/kassa/payments/api/model/packageoptions/Amount;Lru/yoomoney/sdk/kassa/payments/api/model/packageoptions/Amount;)V", "getCounterparty", "()Lru/yoomoney/sdk/kassa/payments/api/model/packageoptions/Amount;", "getService", "component1", "component2", "copy", "equals", "", "other", "hashCode", "", "toString", "", "library_metricaRealRelease"}, k = 1, mv = {1, 9, 0}, xi = 48)
/* loaded from: classes5.dex */
public final /* data */ class Fee {
    public static final int $stable = 8;
    private final Amount counterparty;
    private final Amount service;

    public Fee(@JsonProperty("service") Amount amount, @JsonProperty("counterparty") Amount amount2) {
        this.service = amount;
        this.counterparty = amount2;
    }

    public static /* synthetic */ Fee copy$default(Fee fee, Amount amount, Amount amount2, int i, Object obj) {
        if ((i & 1) != 0) {
            amount = fee.service;
        }
        if ((i & 2) != 0) {
            amount2 = fee.counterparty;
        }
        return fee.copy(amount, amount2);
    }

    /* renamed from: component1, reason: from getter */
    public final Amount getService() {
        return this.service;
    }

    /* renamed from: component2, reason: from getter */
    public final Amount getCounterparty() {
        return this.counterparty;
    }

    public final Fee copy(@JsonProperty("service") Amount service, @JsonProperty("counterparty") Amount counterparty) {
        return new Fee(service, counterparty);
    }

    public boolean equals(Object other) {
        if (this == other) {
            return true;
        }
        if (!(other instanceof Fee)) {
            return false;
        }
        Fee fee = (Fee) other;
        return Intrinsics.areEqual(this.service, fee.service) && Intrinsics.areEqual(this.counterparty, fee.counterparty);
    }

    public final Amount getCounterparty() {
        return this.counterparty;
    }

    public final Amount getService() {
        return this.service;
    }

    public int hashCode() {
        Amount amount = this.service;
        int iHashCode = (amount == null ? 0 : amount.hashCode()) * 31;
        Amount amount2 = this.counterparty;
        return iHashCode + (amount2 != null ? amount2.hashCode() : 0);
    }

    public String toString() {
        return "Fee(service=" + this.service + ", counterparty=" + this.counterparty + ")";
    }
}

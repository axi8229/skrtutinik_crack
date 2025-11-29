package ru.yoomoney.sdk.kassa.payments.payment.sbp.bankList.model;

import androidx.annotation.Keep;
import com.fasterxml.jackson.annotation.JsonProperty;
import java.util.List;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

@Keep
@Metadata(d1 = {"\u0000*\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0002\b\u0006\n\u0002\u0010\u000b\n\u0002\b\u0002\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u000e\n\u0000\b\u0081\b\u0018\u00002\u00020\u0001B\u0015\u0012\u000e\b\u0001\u0010\u0002\u001a\b\u0012\u0004\u0012\u00020\u00040\u0003¢\u0006\u0002\u0010\u0005J\u000f\u0010\b\u001a\b\u0012\u0004\u0012\u00020\u00040\u0003HÆ\u0003J\u0019\u0010\t\u001a\u00020\u00002\u000e\b\u0003\u0010\u0002\u001a\b\u0012\u0004\u0012\u00020\u00040\u0003HÆ\u0001J\u0013\u0010\n\u001a\u00020\u000b2\b\u0010\f\u001a\u0004\u0018\u00010\u0001HÖ\u0003J\t\u0010\r\u001a\u00020\u000eHÖ\u0001J\t\u0010\u000f\u001a\u00020\u0010HÖ\u0001R\u001c\u0010\u0002\u001a\b\u0012\u0004\u0012\u00020\u00040\u00038\u0006X\u0087\u0004¢\u0006\b\n\u0000\u001a\u0004\b\u0006\u0010\u0007¨\u0006\u0011"}, d2 = {"Lru/yoomoney/sdk/kassa/payments/payment/sbp/bankList/model/PrioritySbpBanksConfig;", "", "banks", "", "Lru/yoomoney/sdk/kassa/payments/payment/sbp/bankList/model/PrioritySbpBank;", "(Ljava/util/List;)V", "getBanks", "()Ljava/util/List;", "component1", "copy", "equals", "", "other", "hashCode", "", "toString", "", "library_metricaRealRelease"}, k = 1, mv = {1, 9, 0}, xi = 48)
/* loaded from: classes5.dex */
public final /* data */ class PrioritySbpBanksConfig {
    public static final int $stable = 8;

    @Keep
    private final List<PrioritySbpBank> banks;

    public PrioritySbpBanksConfig(@JsonProperty("banks") List<PrioritySbpBank> banks) {
        Intrinsics.checkNotNullParameter(banks, "banks");
        this.banks = banks;
    }

    /* JADX WARN: Multi-variable type inference failed */
    public static /* synthetic */ PrioritySbpBanksConfig copy$default(PrioritySbpBanksConfig prioritySbpBanksConfig, List list, int i, Object obj) {
        if ((i & 1) != 0) {
            list = prioritySbpBanksConfig.banks;
        }
        return prioritySbpBanksConfig.copy(list);
    }

    public final List<PrioritySbpBank> component1() {
        return this.banks;
    }

    public final PrioritySbpBanksConfig copy(@JsonProperty("banks") List<PrioritySbpBank> banks) {
        Intrinsics.checkNotNullParameter(banks, "banks");
        return new PrioritySbpBanksConfig(banks);
    }

    public boolean equals(Object other) {
        if (this == other) {
            return true;
        }
        return (other instanceof PrioritySbpBanksConfig) && Intrinsics.areEqual(this.banks, ((PrioritySbpBanksConfig) other).banks);
    }

    public final List<PrioritySbpBank> getBanks() {
        return this.banks;
    }

    public int hashCode() {
        return this.banks.hashCode();
    }

    public String toString() {
        return "PrioritySbpBanksConfig(banks=" + this.banks + ")";
    }
}

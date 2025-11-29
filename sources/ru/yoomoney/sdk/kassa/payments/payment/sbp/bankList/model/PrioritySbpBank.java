package ru.yoomoney.sdk.kassa.payments.payment.sbp.bankList.model;

import androidx.annotation.Keep;
import com.fasterxml.jackson.annotation.JsonProperty;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

@Keep
@Metadata(d1 = {"\u0000\"\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\u000e\n\u0002\b\t\n\u0002\u0010\u000b\n\u0002\b\u0002\n\u0002\u0010\b\n\u0002\b\u0002\b\u0081\b\u0018\u00002\u00020\u0001B\u0019\u0012\b\b\u0001\u0010\u0002\u001a\u00020\u0003\u0012\b\b\u0001\u0010\u0004\u001a\u00020\u0003¢\u0006\u0002\u0010\u0005J\t\u0010\t\u001a\u00020\u0003HÆ\u0003J\t\u0010\n\u001a\u00020\u0003HÆ\u0003J\u001d\u0010\u000b\u001a\u00020\u00002\b\b\u0003\u0010\u0002\u001a\u00020\u00032\b\b\u0003\u0010\u0004\u001a\u00020\u0003HÆ\u0001J\u0013\u0010\f\u001a\u00020\r2\b\u0010\u000e\u001a\u0004\u0018\u00010\u0001HÖ\u0003J\t\u0010\u000f\u001a\u00020\u0010HÖ\u0001J\t\u0010\u0011\u001a\u00020\u0003HÖ\u0001R\u0016\u0010\u0002\u001a\u00020\u00038\u0006X\u0087\u0004¢\u0006\b\n\u0000\u001a\u0004\b\u0006\u0010\u0007R\u0016\u0010\u0004\u001a\u00020\u00038\u0006X\u0087\u0004¢\u0006\b\n\u0000\u001a\u0004\b\b\u0010\u0007¨\u0006\u0012"}, d2 = {"Lru/yoomoney/sdk/kassa/payments/payment/sbp/bankList/model/PrioritySbpBank;", "", "memberId", "", "packageName", "(Ljava/lang/String;Ljava/lang/String;)V", "getMemberId", "()Ljava/lang/String;", "getPackageName", "component1", "component2", "copy", "equals", "", "other", "hashCode", "", "toString", "library_metricaRealRelease"}, k = 1, mv = {1, 9, 0}, xi = 48)
/* loaded from: classes5.dex */
public final /* data */ class PrioritySbpBank {
    public static final int $stable = 0;

    @Keep
    private final String memberId;

    @Keep
    private final String packageName;

    public PrioritySbpBank(@JsonProperty("member_id") String memberId, @JsonProperty("package_name") String packageName) {
        Intrinsics.checkNotNullParameter(memberId, "memberId");
        Intrinsics.checkNotNullParameter(packageName, "packageName");
        this.memberId = memberId;
        this.packageName = packageName;
    }

    public static /* synthetic */ PrioritySbpBank copy$default(PrioritySbpBank prioritySbpBank, String str, String str2, int i, Object obj) {
        if ((i & 1) != 0) {
            str = prioritySbpBank.memberId;
        }
        if ((i & 2) != 0) {
            str2 = prioritySbpBank.packageName;
        }
        return prioritySbpBank.copy(str, str2);
    }

    /* renamed from: component1, reason: from getter */
    public final String getMemberId() {
        return this.memberId;
    }

    /* renamed from: component2, reason: from getter */
    public final String getPackageName() {
        return this.packageName;
    }

    public final PrioritySbpBank copy(@JsonProperty("member_id") String memberId, @JsonProperty("package_name") String packageName) {
        Intrinsics.checkNotNullParameter(memberId, "memberId");
        Intrinsics.checkNotNullParameter(packageName, "packageName");
        return new PrioritySbpBank(memberId, packageName);
    }

    public boolean equals(Object other) {
        if (this == other) {
            return true;
        }
        if (!(other instanceof PrioritySbpBank)) {
            return false;
        }
        PrioritySbpBank prioritySbpBank = (PrioritySbpBank) other;
        return Intrinsics.areEqual(this.memberId, prioritySbpBank.memberId) && Intrinsics.areEqual(this.packageName, prioritySbpBank.packageName);
    }

    public final String getMemberId() {
        return this.memberId;
    }

    public final String getPackageName() {
        return this.packageName;
    }

    public int hashCode() {
        return this.packageName.hashCode() + (this.memberId.hashCode() * 31);
    }

    public String toString() {
        return "PrioritySbpBank(memberId=" + this.memberId + ", packageName=" + this.packageName + ")";
    }
}

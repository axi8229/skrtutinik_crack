package ru.yoomoney.sdk.kassa.payments.api.model.sbp;

import com.fasterxml.jackson.annotation.JsonProperty;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import npi.spay.AbstractC1553e;

@Metadata(d1 = {"\u0000\"\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u000f\n\u0002\u0010\u000b\n\u0002\b\u0002\n\u0002\u0010\b\n\u0002\b\u0002\b\u0080\b\u0018\u00002\u00020\u0001B-\u0012\b\b\u0001\u0010\u0002\u001a\u00020\u0003\u0012\b\b\u0001\u0010\u0004\u001a\u00020\u0003\u0012\b\b\u0001\u0010\u0005\u001a\u00020\u0003\u0012\b\b\u0001\u0010\u0006\u001a\u00020\u0003¢\u0006\u0002\u0010\u0007J\t\u0010\r\u001a\u00020\u0003HÆ\u0003J\t\u0010\u000e\u001a\u00020\u0003HÆ\u0003J\t\u0010\u000f\u001a\u00020\u0003HÆ\u0003J\t\u0010\u0010\u001a\u00020\u0003HÆ\u0003J1\u0010\u0011\u001a\u00020\u00002\b\b\u0003\u0010\u0002\u001a\u00020\u00032\b\b\u0003\u0010\u0004\u001a\u00020\u00032\b\b\u0003\u0010\u0005\u001a\u00020\u00032\b\b\u0003\u0010\u0006\u001a\u00020\u0003HÆ\u0001J\u0013\u0010\u0012\u001a\u00020\u00132\b\u0010\u0014\u001a\u0004\u0018\u00010\u0001HÖ\u0003J\t\u0010\u0015\u001a\u00020\u0016HÖ\u0001J\t\u0010\u0017\u001a\u00020\u0003HÖ\u0001R\u0011\u0010\u0006\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\b\u0010\tR\u0011\u0010\u0002\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\n\u0010\tR\u0011\u0010\u0005\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u000b\u0010\tR\u0011\u0010\u0004\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\f\u0010\t¨\u0006\u0018"}, d2 = {"Lru/yoomoney/sdk/kassa/payments/api/model/sbp/SbpBankInfo;", "", "memberId", "", "nameRus", "nameEng", "deeplink", "(Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;)V", "getDeeplink", "()Ljava/lang/String;", "getMemberId", "getNameEng", "getNameRus", "component1", "component2", "component3", "component4", "copy", "equals", "", "other", "hashCode", "", "toString", "library_metricaRealRelease"}, k = 1, mv = {1, 9, 0}, xi = 48)
/* loaded from: classes5.dex */
public final /* data */ class SbpBankInfo {
    public static final int $stable = 0;
    private final String deeplink;
    private final String memberId;
    private final String nameEng;
    private final String nameRus;

    public SbpBankInfo(@JsonProperty("member_id") String memberId, @JsonProperty("name_rus") String nameRus, @JsonProperty("name_eng") String nameEng, @JsonProperty("deeplink") String deeplink) {
        Intrinsics.checkNotNullParameter(memberId, "memberId");
        Intrinsics.checkNotNullParameter(nameRus, "nameRus");
        Intrinsics.checkNotNullParameter(nameEng, "nameEng");
        Intrinsics.checkNotNullParameter(deeplink, "deeplink");
        this.memberId = memberId;
        this.nameRus = nameRus;
        this.nameEng = nameEng;
        this.deeplink = deeplink;
    }

    public static /* synthetic */ SbpBankInfo copy$default(SbpBankInfo sbpBankInfo, String str, String str2, String str3, String str4, int i, Object obj) {
        if ((i & 1) != 0) {
            str = sbpBankInfo.memberId;
        }
        if ((i & 2) != 0) {
            str2 = sbpBankInfo.nameRus;
        }
        if ((i & 4) != 0) {
            str3 = sbpBankInfo.nameEng;
        }
        if ((i & 8) != 0) {
            str4 = sbpBankInfo.deeplink;
        }
        return sbpBankInfo.copy(str, str2, str3, str4);
    }

    /* renamed from: component1, reason: from getter */
    public final String getMemberId() {
        return this.memberId;
    }

    /* renamed from: component2, reason: from getter */
    public final String getNameRus() {
        return this.nameRus;
    }

    /* renamed from: component3, reason: from getter */
    public final String getNameEng() {
        return this.nameEng;
    }

    /* renamed from: component4, reason: from getter */
    public final String getDeeplink() {
        return this.deeplink;
    }

    public final SbpBankInfo copy(@JsonProperty("member_id") String memberId, @JsonProperty("name_rus") String nameRus, @JsonProperty("name_eng") String nameEng, @JsonProperty("deeplink") String deeplink) {
        Intrinsics.checkNotNullParameter(memberId, "memberId");
        Intrinsics.checkNotNullParameter(nameRus, "nameRus");
        Intrinsics.checkNotNullParameter(nameEng, "nameEng");
        Intrinsics.checkNotNullParameter(deeplink, "deeplink");
        return new SbpBankInfo(memberId, nameRus, nameEng, deeplink);
    }

    public boolean equals(Object other) {
        if (this == other) {
            return true;
        }
        if (!(other instanceof SbpBankInfo)) {
            return false;
        }
        SbpBankInfo sbpBankInfo = (SbpBankInfo) other;
        return Intrinsics.areEqual(this.memberId, sbpBankInfo.memberId) && Intrinsics.areEqual(this.nameRus, sbpBankInfo.nameRus) && Intrinsics.areEqual(this.nameEng, sbpBankInfo.nameEng) && Intrinsics.areEqual(this.deeplink, sbpBankInfo.deeplink);
    }

    public final String getDeeplink() {
        return this.deeplink;
    }

    public final String getMemberId() {
        return this.memberId;
    }

    public final String getNameEng() {
        return this.nameEng;
    }

    public final String getNameRus() {
        return this.nameRus;
    }

    public int hashCode() {
        return this.deeplink.hashCode() + AbstractC1553e.a(this.nameEng, AbstractC1553e.a(this.nameRus, this.memberId.hashCode() * 31, 31), 31);
    }

    public String toString() {
        return "SbpBankInfo(memberId=" + this.memberId + ", nameRus=" + this.nameRus + ", nameEng=" + this.nameEng + ", deeplink=" + this.deeplink + ")";
    }
}

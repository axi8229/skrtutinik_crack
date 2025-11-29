package ru.yoomoney.sdk.yoopinning;

import java.util.List;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

/* compiled from: CertificatesLists.kt */
@Metadata(d1 = {"\u0000&\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010 \n\u0002\u0010\u000e\n\u0002\b\t\n\u0002\u0010\u000b\n\u0002\b\u0002\n\u0002\u0010\b\n\u0002\b\u0002\b\u0086\b\u0018\u00002\u00020\u0001B!\u0012\f\u0010\u0002\u001a\b\u0012\u0004\u0012\u00020\u00040\u0003\u0012\f\u0010\u0005\u001a\b\u0012\u0004\u0012\u00020\u00040\u0003¢\u0006\u0002\u0010\u0006J\u000f\u0010\n\u001a\b\u0012\u0004\u0012\u00020\u00040\u0003HÆ\u0003J\u000f\u0010\u000b\u001a\b\u0012\u0004\u0012\u00020\u00040\u0003HÆ\u0003J)\u0010\f\u001a\u00020\u00002\u000e\b\u0002\u0010\u0002\u001a\b\u0012\u0004\u0012\u00020\u00040\u00032\u000e\b\u0002\u0010\u0005\u001a\b\u0012\u0004\u0012\u00020\u00040\u0003HÆ\u0001J\u0013\u0010\r\u001a\u00020\u000e2\b\u0010\u000f\u001a\u0004\u0018\u00010\u0001HÖ\u0003J\t\u0010\u0010\u001a\u00020\u0011HÖ\u0001J\t\u0010\u0012\u001a\u00020\u0004HÖ\u0001R\u0017\u0010\u0005\u001a\b\u0012\u0004\u0012\u00020\u00040\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u0007\u0010\bR\u0017\u0010\u0002\u001a\b\u0012\u0004\u0012\u00020\u00040\u0003¢\u0006\b\n\u0000\u001a\u0004\b\t\u0010\b¨\u0006\u0013"}, d2 = {"Lru/yoomoney/sdk/yoopinning/CertificatesLists;", "", "whiteList", "", "", "blackList", "(Ljava/util/List;Ljava/util/List;)V", "getBlackList", "()Ljava/util/List;", "getWhiteList", "component1", "component2", "copy", "equals", "", "other", "hashCode", "", "toString", "yoopinning_release"}, k = 1, mv = {1, 9, 0}, xi = 48)
/* loaded from: classes5.dex */
public final /* data */ class CertificatesLists {
    private final List<String> blackList;
    private final List<String> whiteList;

    /* JADX WARN: Multi-variable type inference failed */
    public static /* synthetic */ CertificatesLists copy$default(CertificatesLists certificatesLists, List list, List list2, int i, Object obj) {
        if ((i & 1) != 0) {
            list = certificatesLists.whiteList;
        }
        if ((i & 2) != 0) {
            list2 = certificatesLists.blackList;
        }
        return certificatesLists.copy(list, list2);
    }

    public final List<String> component1() {
        return this.whiteList;
    }

    public final List<String> component2() {
        return this.blackList;
    }

    public final CertificatesLists copy(List<String> whiteList, List<String> blackList) {
        Intrinsics.checkNotNullParameter(whiteList, "whiteList");
        Intrinsics.checkNotNullParameter(blackList, "blackList");
        return new CertificatesLists(whiteList, blackList);
    }

    public boolean equals(Object other) {
        if (this == other) {
            return true;
        }
        if (!(other instanceof CertificatesLists)) {
            return false;
        }
        CertificatesLists certificatesLists = (CertificatesLists) other;
        return Intrinsics.areEqual(this.whiteList, certificatesLists.whiteList) && Intrinsics.areEqual(this.blackList, certificatesLists.blackList);
    }

    public int hashCode() {
        return (this.whiteList.hashCode() * 31) + this.blackList.hashCode();
    }

    public String toString() {
        return "CertificatesLists(whiteList=" + this.whiteList + ", blackList=" + this.blackList + ")";
    }

    public CertificatesLists(List<String> whiteList, List<String> blackList) {
        Intrinsics.checkNotNullParameter(whiteList, "whiteList");
        Intrinsics.checkNotNullParameter(blackList, "blackList");
        this.whiteList = whiteList;
        this.blackList = blackList;
    }

    public final List<String> getWhiteList() {
        return this.whiteList;
    }

    public final List<String> getBlackList() {
        return this.blackList;
    }
}

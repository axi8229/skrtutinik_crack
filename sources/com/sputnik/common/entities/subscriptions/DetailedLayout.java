package com.sputnik.common.entities.subscriptions;

import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

/* compiled from: DetailedLayout.kt */
@Metadata(d1 = {"\u0000:\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u000e\n\u0002\b\u0002\n\u0002\u0010\b\n\u0002\b\u0003\n\u0002\u0010\u000b\n\u0002\b\u000f\b\u0086\b\u0018\u00002\u00020\u0001B/\u0012\b\u0010\u0003\u001a\u0004\u0018\u00010\u0002\u0012\b\u0010\u0005\u001a\u0004\u0018\u00010\u0004\u0012\b\u0010\u0007\u001a\u0004\u0018\u00010\u0006\u0012\b\u0010\t\u001a\u0004\u0018\u00010\b¢\u0006\u0004\b\n\u0010\u000bJ\u0010\u0010\r\u001a\u00020\fHÖ\u0001¢\u0006\u0004\b\r\u0010\u000eJ\u0010\u0010\u0010\u001a\u00020\u000fHÖ\u0001¢\u0006\u0004\b\u0010\u0010\u0011J\u001a\u0010\u0014\u001a\u00020\u00132\b\u0010\u0012\u001a\u0004\u0018\u00010\u0001HÖ\u0003¢\u0006\u0004\b\u0014\u0010\u0015R\u0019\u0010\u0003\u001a\u0004\u0018\u00010\u00028\u0006¢\u0006\f\n\u0004\b\u0003\u0010\u0016\u001a\u0004\b\u0017\u0010\u0018R\u0019\u0010\u0005\u001a\u0004\u0018\u00010\u00048\u0006¢\u0006\f\n\u0004\b\u0005\u0010\u0019\u001a\u0004\b\u001a\u0010\u001bR\u0019\u0010\u0007\u001a\u0004\u0018\u00010\u00068\u0006¢\u0006\f\n\u0004\b\u0007\u0010\u001c\u001a\u0004\b\u001d\u0010\u001eR\u0019\u0010\t\u001a\u0004\u0018\u00010\b8\u0006¢\u0006\f\n\u0004\b\t\u0010\u001f\u001a\u0004\b \u0010!¨\u0006\""}, d2 = {"Lcom/sputnik/common/entities/subscriptions/DetailedLayout;", "", "Lcom/sputnik/common/entities/subscriptions/Features;", "features", "Lcom/sputnik/common/entities/subscriptions/Header;", "header", "Lcom/sputnik/common/entities/subscriptions/IncludedServices;", "includedServices", "Lcom/sputnik/common/entities/subscriptions/NoticeBody;", "notice", "<init>", "(Lcom/sputnik/common/entities/subscriptions/Features;Lcom/sputnik/common/entities/subscriptions/Header;Lcom/sputnik/common/entities/subscriptions/IncludedServices;Lcom/sputnik/common/entities/subscriptions/NoticeBody;)V", "", "toString", "()Ljava/lang/String;", "", "hashCode", "()I", "other", "", "equals", "(Ljava/lang/Object;)Z", "Lcom/sputnik/common/entities/subscriptions/Features;", "getFeatures", "()Lcom/sputnik/common/entities/subscriptions/Features;", "Lcom/sputnik/common/entities/subscriptions/Header;", "getHeader", "()Lcom/sputnik/common/entities/subscriptions/Header;", "Lcom/sputnik/common/entities/subscriptions/IncludedServices;", "getIncludedServices", "()Lcom/sputnik/common/entities/subscriptions/IncludedServices;", "Lcom/sputnik/common/entities/subscriptions/NoticeBody;", "getNotice", "()Lcom/sputnik/common/entities/subscriptions/NoticeBody;", "common_release"}, k = 1, mv = {1, 9, 0}, xi = 48)
/* loaded from: classes3.dex */
public final /* data */ class DetailedLayout {
    private final Features features;
    private final Header header;
    private final IncludedServices includedServices;
    private final NoticeBody notice;

    public boolean equals(Object other) {
        if (this == other) {
            return true;
        }
        if (!(other instanceof DetailedLayout)) {
            return false;
        }
        DetailedLayout detailedLayout = (DetailedLayout) other;
        return Intrinsics.areEqual(this.features, detailedLayout.features) && Intrinsics.areEqual(this.header, detailedLayout.header) && Intrinsics.areEqual(this.includedServices, detailedLayout.includedServices) && Intrinsics.areEqual(this.notice, detailedLayout.notice);
    }

    public int hashCode() {
        Features features = this.features;
        int iHashCode = (features == null ? 0 : features.hashCode()) * 31;
        Header header = this.header;
        int iHashCode2 = (iHashCode + (header == null ? 0 : header.hashCode())) * 31;
        IncludedServices includedServices = this.includedServices;
        int iHashCode3 = (iHashCode2 + (includedServices == null ? 0 : includedServices.hashCode())) * 31;
        NoticeBody noticeBody = this.notice;
        return iHashCode3 + (noticeBody != null ? noticeBody.hashCode() : 0);
    }

    public String toString() {
        return "DetailedLayout(features=" + this.features + ", header=" + this.header + ", includedServices=" + this.includedServices + ", notice=" + this.notice + ")";
    }

    public DetailedLayout(Features features, Header header, IncludedServices includedServices, NoticeBody noticeBody) {
        this.features = features;
        this.header = header;
        this.includedServices = includedServices;
        this.notice = noticeBody;
    }

    public final Features getFeatures() {
        return this.features;
    }

    public final Header getHeader() {
        return this.header;
    }

    public final IncludedServices getIncludedServices() {
        return this.includedServices;
    }

    public final NoticeBody getNotice() {
        return this.notice;
    }
}

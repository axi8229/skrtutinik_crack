package com.sputnik.domain.entities.archive;

import com.huawei.hms.framework.common.hianalytics.CrashHianalyticsData;
import com.huawei.hms.push.constant.RemoteMessageConst;
import java.util.List;
import kotlin.Metadata;
import kotlin.collections.CollectionsKt;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;

/* compiled from: DomainArchiveUrls.kt */
@Metadata(d1 = {"\u0000*\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0002\b\u0006\n\u0002\u0010\b\n\u0002\b\u0003\n\u0002\u0010\u000b\n\u0002\b\t\b\u0086\b\u0018\u00002\u00020\u0001B/\u0012\n\b\u0002\u0010\u0003\u001a\u0004\u0018\u00010\u0002\u0012\u000e\b\u0002\u0010\u0006\u001a\b\u0012\u0004\u0012\u00020\u00050\u0004\u0012\n\b\u0002\u0010\u0007\u001a\u0004\u0018\u00010\u0002¢\u0006\u0004\b\b\u0010\tJ\u0010\u0010\n\u001a\u00020\u0002HÖ\u0001¢\u0006\u0004\b\n\u0010\u000bJ\u0010\u0010\r\u001a\u00020\fHÖ\u0001¢\u0006\u0004\b\r\u0010\u000eJ\u001a\u0010\u0011\u001a\u00020\u00102\b\u0010\u000f\u001a\u0004\u0018\u00010\u0001HÖ\u0003¢\u0006\u0004\b\u0011\u0010\u0012R\u0019\u0010\u0003\u001a\u0004\u0018\u00010\u00028\u0006¢\u0006\f\n\u0004\b\u0003\u0010\u0013\u001a\u0004\b\u0014\u0010\u000bR\u001d\u0010\u0006\u001a\b\u0012\u0004\u0012\u00020\u00050\u00048\u0006¢\u0006\f\n\u0004\b\u0006\u0010\u0015\u001a\u0004\b\u0016\u0010\u0017R\u0019\u0010\u0007\u001a\u0004\u0018\u00010\u00028\u0006¢\u0006\f\n\u0004\b\u0007\u0010\u0013\u001a\u0004\b\u0018\u0010\u000b¨\u0006\u0019"}, d2 = {"Lcom/sputnik/domain/entities/archive/DomainArchiveUrls;", "", "", "way", "", "Lcom/sputnik/domain/entities/archive/DomainArchiveItem;", RemoteMessageConst.DATA, CrashHianalyticsData.MESSAGE, "<init>", "(Ljava/lang/String;Ljava/util/List;Ljava/lang/String;)V", "toString", "()Ljava/lang/String;", "", "hashCode", "()I", "other", "", "equals", "(Ljava/lang/Object;)Z", "Ljava/lang/String;", "getWay", "Ljava/util/List;", "getData", "()Ljava/util/List;", "getMessage", "domain"}, k = 1, mv = {1, 9, 0}, xi = 48)
/* loaded from: classes3.dex */
public final /* data */ class DomainArchiveUrls {
    private final List<DomainArchiveItem> data;
    private final String message;
    private final String way;

    public DomainArchiveUrls() {
        this(null, null, null, 7, null);
    }

    public boolean equals(Object other) {
        if (this == other) {
            return true;
        }
        if (!(other instanceof DomainArchiveUrls)) {
            return false;
        }
        DomainArchiveUrls domainArchiveUrls = (DomainArchiveUrls) other;
        return Intrinsics.areEqual(this.way, domainArchiveUrls.way) && Intrinsics.areEqual(this.data, domainArchiveUrls.data) && Intrinsics.areEqual(this.message, domainArchiveUrls.message);
    }

    public int hashCode() {
        String str = this.way;
        int iHashCode = (((str == null ? 0 : str.hashCode()) * 31) + this.data.hashCode()) * 31;
        String str2 = this.message;
        return iHashCode + (str2 != null ? str2.hashCode() : 0);
    }

    public String toString() {
        return "DomainArchiveUrls(way=" + this.way + ", data=" + this.data + ", message=" + this.message + ")";
    }

    public DomainArchiveUrls(String str, List<DomainArchiveItem> data, String str2) {
        Intrinsics.checkNotNullParameter(data, "data");
        this.way = str;
        this.data = data;
        this.message = str2;
    }

    public final String getWay() {
        return this.way;
    }

    public /* synthetic */ DomainArchiveUrls(String str, List list, String str2, int i, DefaultConstructorMarker defaultConstructorMarker) {
        this((i & 1) != 0 ? null : str, (i & 2) != 0 ? CollectionsKt.emptyList() : list, (i & 4) != 0 ? null : str2);
    }

    public final List<DomainArchiveItem> getData() {
        return this.data;
    }
}

package com.sputnik.domain.entities.localization;

import com.google.android.gms.measurement.api.AppMeasurementSdk;
import com.huawei.hms.push.constant.RemoteMessageConst;
import kotlin.Metadata;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;

/* compiled from: DomainLocalization.kt */
@Metadata(d1 = {"\u0000(\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0010\u000e\n\u0002\b\u0002\n\u0002\u0010\t\n\u0002\b\u0004\n\u0002\u0010\u000b\n\u0002\b\u0005\n\u0002\u0010\b\n\u0002\b\u0012\b\u0086\b\u0018\u00002\u00020\u0001BY\u0012\n\b\u0002\u0010\u0003\u001a\u0004\u0018\u00010\u0002\u0012\n\b\u0002\u0010\u0004\u001a\u0004\u0018\u00010\u0002\u0012\n\b\u0002\u0010\u0006\u001a\u0004\u0018\u00010\u0005\u0012\n\b\u0002\u0010\u0007\u001a\u0004\u0018\u00010\u0002\u0012\n\b\u0002\u0010\b\u001a\u0004\u0018\u00010\u0002\u0012\n\b\u0002\u0010\t\u001a\u0004\u0018\u00010\u0002\u0012\b\b\u0002\u0010\u000b\u001a\u00020\n¢\u0006\u0004\b\f\u0010\rJ\u0010\u0010\u000e\u001a\u00020\u0002HÖ\u0001¢\u0006\u0004\b\u000e\u0010\u000fJ\u0010\u0010\u0011\u001a\u00020\u0010HÖ\u0001¢\u0006\u0004\b\u0011\u0010\u0012J\u001a\u0010\u0014\u001a\u00020\n2\b\u0010\u0013\u001a\u0004\u0018\u00010\u0001HÖ\u0003¢\u0006\u0004\b\u0014\u0010\u0015R\u0019\u0010\u0003\u001a\u0004\u0018\u00010\u00028\u0006¢\u0006\f\n\u0004\b\u0003\u0010\u0016\u001a\u0004\b\u0017\u0010\u000fR\u0019\u0010\u0004\u001a\u0004\u0018\u00010\u00028\u0006¢\u0006\f\n\u0004\b\u0004\u0010\u0016\u001a\u0004\b\u0018\u0010\u000fR\u0019\u0010\u0006\u001a\u0004\u0018\u00010\u00058\u0006¢\u0006\f\n\u0004\b\u0006\u0010\u0019\u001a\u0004\b\u001a\u0010\u001bR\u0019\u0010\u0007\u001a\u0004\u0018\u00010\u00028\u0006¢\u0006\f\n\u0004\b\u0007\u0010\u0016\u001a\u0004\b\u001c\u0010\u000fR\u0019\u0010\b\u001a\u0004\u0018\u00010\u00028\u0006¢\u0006\f\n\u0004\b\b\u0010\u0016\u001a\u0004\b\u001d\u0010\u000fR\u0019\u0010\t\u001a\u0004\u0018\u00010\u00028\u0006¢\u0006\f\n\u0004\b\t\u0010\u0016\u001a\u0004\b\u001e\u0010\u000fR\u0017\u0010\u000b\u001a\u00020\n8\u0006¢\u0006\f\n\u0004\b\u000b\u0010\u001f\u001a\u0004\b \u0010!¨\u0006\""}, d2 = {"Lcom/sputnik/domain/entities/localization/DomainLocalization;", "", "", "id", RemoteMessageConst.Notification.TAG, "", "createdAt", AppMeasurementSdk.ConditionalUserProperty.NAME, "platform", "file", "", "current", "<init>", "(Ljava/lang/String;Ljava/lang/String;Ljava/lang/Long;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Z)V", "toString", "()Ljava/lang/String;", "", "hashCode", "()I", "other", "equals", "(Ljava/lang/Object;)Z", "Ljava/lang/String;", "getId", "getTag", "Ljava/lang/Long;", "getCreatedAt", "()Ljava/lang/Long;", "getName", "getPlatform", "getFile", "Z", "getCurrent", "()Z", "domain"}, k = 1, mv = {1, 9, 0}, xi = 48)
/* loaded from: classes3.dex */
public final /* data */ class DomainLocalization {
    private final Long createdAt;
    private final boolean current;
    private final String file;
    private final String id;
    private final String name;
    private final String platform;
    private final String tag;

    public DomainLocalization() {
        this(null, null, null, null, null, null, false, 127, null);
    }

    public boolean equals(Object other) {
        if (this == other) {
            return true;
        }
        if (!(other instanceof DomainLocalization)) {
            return false;
        }
        DomainLocalization domainLocalization = (DomainLocalization) other;
        return Intrinsics.areEqual(this.id, domainLocalization.id) && Intrinsics.areEqual(this.tag, domainLocalization.tag) && Intrinsics.areEqual(this.createdAt, domainLocalization.createdAt) && Intrinsics.areEqual(this.name, domainLocalization.name) && Intrinsics.areEqual(this.platform, domainLocalization.platform) && Intrinsics.areEqual(this.file, domainLocalization.file) && this.current == domainLocalization.current;
    }

    /* JADX WARN: Multi-variable type inference failed */
    public int hashCode() {
        String str = this.id;
        int iHashCode = (str == null ? 0 : str.hashCode()) * 31;
        String str2 = this.tag;
        int iHashCode2 = (iHashCode + (str2 == null ? 0 : str2.hashCode())) * 31;
        Long l = this.createdAt;
        int iHashCode3 = (iHashCode2 + (l == null ? 0 : l.hashCode())) * 31;
        String str3 = this.name;
        int iHashCode4 = (iHashCode3 + (str3 == null ? 0 : str3.hashCode())) * 31;
        String str4 = this.platform;
        int iHashCode5 = (iHashCode4 + (str4 == null ? 0 : str4.hashCode())) * 31;
        String str5 = this.file;
        int iHashCode6 = (iHashCode5 + (str5 != null ? str5.hashCode() : 0)) * 31;
        boolean z = this.current;
        int i = z;
        if (z != 0) {
            i = 1;
        }
        return iHashCode6 + i;
    }

    public String toString() {
        return "DomainLocalization(id=" + this.id + ", tag=" + this.tag + ", createdAt=" + this.createdAt + ", name=" + this.name + ", platform=" + this.platform + ", file=" + this.file + ", current=" + this.current + ")";
    }

    public DomainLocalization(String str, String str2, Long l, String str3, String str4, String str5, boolean z) {
        this.id = str;
        this.tag = str2;
        this.createdAt = l;
        this.name = str3;
        this.platform = str4;
        this.file = str5;
        this.current = z;
    }

    public /* synthetic */ DomainLocalization(String str, String str2, Long l, String str3, String str4, String str5, boolean z, int i, DefaultConstructorMarker defaultConstructorMarker) {
        this((i & 1) != 0 ? null : str, (i & 2) != 0 ? null : str2, (i & 4) != 0 ? null : l, (i & 8) != 0 ? null : str3, (i & 16) != 0 ? null : str4, (i & 32) == 0 ? str5 : null, (i & 64) != 0 ? false : z);
    }

    public final String getId() {
        return this.id;
    }

    public final String getTag() {
        return this.tag;
    }

    public final Long getCreatedAt() {
        return this.createdAt;
    }

    public final String getName() {
        return this.name;
    }

    public final String getPlatform() {
        return this.platform;
    }

    public final String getFile() {
        return this.file;
    }

    public final boolean getCurrent() {
        return this.current;
    }
}

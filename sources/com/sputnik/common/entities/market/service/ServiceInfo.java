package com.sputnik.common.entities.market.service;

import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

/* compiled from: ServiceInfo.kt */
@Metadata(d1 = {"\u0000\u001e\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010\u000b\n\u0002\b\u0005\n\u0002\u0010\b\n\u0002\b\n\b\u0086\b\u0018\u00002\u00020\u0001B\u0017\u0012\u0006\u0010\u0003\u001a\u00020\u0002\u0012\u0006\u0010\u0005\u001a\u00020\u0004¢\u0006\u0004\b\u0006\u0010\u0007J\u0010\u0010\b\u001a\u00020\u0002HÖ\u0001¢\u0006\u0004\b\b\u0010\tJ\u0010\u0010\u000b\u001a\u00020\nHÖ\u0001¢\u0006\u0004\b\u000b\u0010\fJ\u001a\u0010\u000e\u001a\u00020\u00042\b\u0010\r\u001a\u0004\u0018\u00010\u0001HÖ\u0003¢\u0006\u0004\b\u000e\u0010\u000fR\u0017\u0010\u0003\u001a\u00020\u00028\u0006¢\u0006\f\n\u0004\b\u0003\u0010\u0010\u001a\u0004\b\u0011\u0010\tR\u0017\u0010\u0005\u001a\u00020\u00048\u0006¢\u0006\f\n\u0004\b\u0005\u0010\u0012\u001a\u0004\b\u0005\u0010\u0013¨\u0006\u0014"}, d2 = {"Lcom/sputnik/common/entities/market/service/ServiceInfo;", "", "", "id", "", "isSubscribed", "<init>", "(Ljava/lang/String;Z)V", "toString", "()Ljava/lang/String;", "", "hashCode", "()I", "other", "equals", "(Ljava/lang/Object;)Z", "Ljava/lang/String;", "getId", "Z", "()Z", "common_release"}, k = 1, mv = {1, 9, 0}, xi = 48)
/* loaded from: classes3.dex */
public final /* data */ class ServiceInfo {
    private final String id;
    private final boolean isSubscribed;

    public boolean equals(Object other) {
        if (this == other) {
            return true;
        }
        if (!(other instanceof ServiceInfo)) {
            return false;
        }
        ServiceInfo serviceInfo = (ServiceInfo) other;
        return Intrinsics.areEqual(this.id, serviceInfo.id) && this.isSubscribed == serviceInfo.isSubscribed;
    }

    /* JADX WARN: Multi-variable type inference failed */
    public int hashCode() {
        int iHashCode = this.id.hashCode() * 31;
        boolean z = this.isSubscribed;
        int i = z;
        if (z != 0) {
            i = 1;
        }
        return iHashCode + i;
    }

    public String toString() {
        return "ServiceInfo(id=" + this.id + ", isSubscribed=" + this.isSubscribed + ")";
    }

    public ServiceInfo(String id, boolean z) {
        Intrinsics.checkNotNullParameter(id, "id");
        this.id = id;
        this.isSubscribed = z;
    }

    public final String getId() {
        return this.id;
    }

    /* renamed from: isSubscribed, reason: from getter */
    public final boolean getIsSubscribed() {
        return this.isSubscribed;
    }
}

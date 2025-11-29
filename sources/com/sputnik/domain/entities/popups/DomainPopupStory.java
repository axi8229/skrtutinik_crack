package com.sputnik.domain.entities.popups;

import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

/* compiled from: DomainPopupStory.kt */
@Metadata(d1 = {"\u00000\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0010\t\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u000e\n\u0002\b\u0002\n\u0002\u0010\b\n\u0002\b\u0003\n\u0002\u0010\u000b\n\u0002\b\n\b\u0086\b\u0018\u00002\u00020\u0001B\u001f\u0012\u0006\u0010\u0003\u001a\u00020\u0002\u0012\u0006\u0010\u0004\u001a\u00020\u0002\u0012\u0006\u0010\u0006\u001a\u00020\u0005¢\u0006\u0004\b\u0007\u0010\bJ\u0010\u0010\n\u001a\u00020\tHÖ\u0001¢\u0006\u0004\b\n\u0010\u000bJ\u0010\u0010\r\u001a\u00020\fHÖ\u0001¢\u0006\u0004\b\r\u0010\u000eJ\u001a\u0010\u0011\u001a\u00020\u00102\b\u0010\u000f\u001a\u0004\u0018\u00010\u0001HÖ\u0003¢\u0006\u0004\b\u0011\u0010\u0012R\u0017\u0010\u0003\u001a\u00020\u00028\u0006¢\u0006\f\n\u0004\b\u0003\u0010\u0013\u001a\u0004\b\u0014\u0010\u0015R\u0017\u0010\u0004\u001a\u00020\u00028\u0006¢\u0006\f\n\u0004\b\u0004\u0010\u0013\u001a\u0004\b\u0016\u0010\u0015R\u0017\u0010\u0006\u001a\u00020\u00058\u0006¢\u0006\f\n\u0004\b\u0006\u0010\u0017\u001a\u0004\b\u0018\u0010\u0019¨\u0006\u001a"}, d2 = {"Lcom/sputnik/domain/entities/popups/DomainPopupStory;", "", "", "id", "order", "Lcom/sputnik/domain/entities/popups/DomainAppearance;", "appearance", "<init>", "(JJLcom/sputnik/domain/entities/popups/DomainAppearance;)V", "", "toString", "()Ljava/lang/String;", "", "hashCode", "()I", "other", "", "equals", "(Ljava/lang/Object;)Z", "J", "getId", "()J", "getOrder", "Lcom/sputnik/domain/entities/popups/DomainAppearance;", "getAppearance", "()Lcom/sputnik/domain/entities/popups/DomainAppearance;", "domain"}, k = 1, mv = {1, 9, 0}, xi = 48)
/* loaded from: classes3.dex */
public final /* data */ class DomainPopupStory {
    private final DomainAppearance appearance;
    private final long id;
    private final long order;

    public boolean equals(Object other) {
        if (this == other) {
            return true;
        }
        if (!(other instanceof DomainPopupStory)) {
            return false;
        }
        DomainPopupStory domainPopupStory = (DomainPopupStory) other;
        return this.id == domainPopupStory.id && this.order == domainPopupStory.order && Intrinsics.areEqual(this.appearance, domainPopupStory.appearance);
    }

    public int hashCode() {
        return (((Long.hashCode(this.id) * 31) + Long.hashCode(this.order)) * 31) + this.appearance.hashCode();
    }

    public String toString() {
        return "DomainPopupStory(id=" + this.id + ", order=" + this.order + ", appearance=" + this.appearance + ")";
    }

    public DomainPopupStory(long j, long j2, DomainAppearance appearance) {
        Intrinsics.checkNotNullParameter(appearance, "appearance");
        this.id = j;
        this.order = j2;
        this.appearance = appearance;
    }

    public final long getId() {
        return this.id;
    }

    public final long getOrder() {
        return this.order;
    }

    public final DomainAppearance getAppearance() {
        return this.appearance;
    }
}

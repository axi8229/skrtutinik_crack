package com.sputnik.domain.entities.entry;

import kotlin.Metadata;

/* compiled from: DomainEntry.kt */
@Metadata(d1 = {"\u0000 \n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0010\b\n\u0002\b\u0004\n\u0002\u0010\u000e\n\u0002\b\u0005\n\u0002\u0010\u000b\n\u0002\b\u0006\b\u0086\b\u0018\u00002\u00020\u0001B\u0017\u0012\u0006\u0010\u0003\u001a\u00020\u0002\u0012\u0006\u0010\u0004\u001a\u00020\u0002¢\u0006\u0004\b\u0005\u0010\u0006J\u0010\u0010\b\u001a\u00020\u0007HÖ\u0001¢\u0006\u0004\b\b\u0010\tJ\u0010\u0010\n\u001a\u00020\u0002HÖ\u0001¢\u0006\u0004\b\n\u0010\u000bJ\u001a\u0010\u000e\u001a\u00020\r2\b\u0010\f\u001a\u0004\u0018\u00010\u0001HÖ\u0003¢\u0006\u0004\b\u000e\u0010\u000fR\u0017\u0010\u0003\u001a\u00020\u00028\u0006¢\u0006\f\n\u0004\b\u0003\u0010\u0010\u001a\u0004\b\u0011\u0010\u000bR\u0017\u0010\u0004\u001a\u00020\u00028\u0006¢\u0006\f\n\u0004\b\u0004\u0010\u0010\u001a\u0004\b\u0012\u0010\u000b¨\u0006\u0013"}, d2 = {"Lcom/sputnik/domain/entities/entry/DomainEntry;", "", "", "firstFlat", "lastFlat", "<init>", "(II)V", "", "toString", "()Ljava/lang/String;", "hashCode", "()I", "other", "", "equals", "(Ljava/lang/Object;)Z", "I", "getFirstFlat", "getLastFlat", "domain"}, k = 1, mv = {1, 9, 0}, xi = 48)
/* loaded from: classes3.dex */
public final /* data */ class DomainEntry {
    private final int firstFlat;
    private final int lastFlat;

    public boolean equals(Object other) {
        if (this == other) {
            return true;
        }
        if (!(other instanceof DomainEntry)) {
            return false;
        }
        DomainEntry domainEntry = (DomainEntry) other;
        return this.firstFlat == domainEntry.firstFlat && this.lastFlat == domainEntry.lastFlat;
    }

    public int hashCode() {
        return (Integer.hashCode(this.firstFlat) * 31) + Integer.hashCode(this.lastFlat);
    }

    public String toString() {
        return "DomainEntry(firstFlat=" + this.firstFlat + ", lastFlat=" + this.lastFlat + ")";
    }

    public DomainEntry(int i, int i2) {
        this.firstFlat = i;
        this.lastFlat = i2;
    }

    public final int getFirstFlat() {
        return this.firstFlat;
    }

    public final int getLastFlat() {
        return this.lastFlat;
    }
}

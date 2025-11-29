package com.sputnik.domain.entities.invites;

import java.util.List;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

/* compiled from: DomainFamilyInvites.kt */
@Metadata(d1 = {"\u00002\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u000e\n\u0002\b\u0002\n\u0002\u0010\b\n\u0002\b\u0003\n\u0002\u0010\u000b\n\u0002\b\u000b\b\u0086\b\u0018\u00002\u00020\u0001:\u0002\u0019\u001aB\u001f\u0012\f\u0010\u0004\u001a\b\u0012\u0004\u0012\u00020\u00030\u0002\u0012\b\u0010\u0006\u001a\u0004\u0018\u00010\u0005¢\u0006\u0004\b\u0007\u0010\bJ\u0010\u0010\n\u001a\u00020\tHÖ\u0001¢\u0006\u0004\b\n\u0010\u000bJ\u0010\u0010\r\u001a\u00020\fHÖ\u0001¢\u0006\u0004\b\r\u0010\u000eJ\u001a\u0010\u0011\u001a\u00020\u00102\b\u0010\u000f\u001a\u0004\u0018\u00010\u0001HÖ\u0003¢\u0006\u0004\b\u0011\u0010\u0012R\u001d\u0010\u0004\u001a\b\u0012\u0004\u0012\u00020\u00030\u00028\u0006¢\u0006\f\n\u0004\b\u0004\u0010\u0013\u001a\u0004\b\u0014\u0010\u0015R\u0019\u0010\u0006\u001a\u0004\u0018\u00010\u00058\u0006¢\u0006\f\n\u0004\b\u0006\u0010\u0016\u001a\u0004\b\u0017\u0010\u0018¨\u0006\u001b"}, d2 = {"Lcom/sputnik/domain/entities/invites/DomainFamilyInvites;", "", "", "Lcom/sputnik/domain/entities/invites/DomainFamilyInvite;", "invites", "Lcom/sputnik/domain/entities/invites/DomainFamilyInvites$DomainMeta;", "meta", "<init>", "(Ljava/util/List;Lcom/sputnik/domain/entities/invites/DomainFamilyInvites$DomainMeta;)V", "", "toString", "()Ljava/lang/String;", "", "hashCode", "()I", "other", "", "equals", "(Ljava/lang/Object;)Z", "Ljava/util/List;", "getInvites", "()Ljava/util/List;", "Lcom/sputnik/domain/entities/invites/DomainFamilyInvites$DomainMeta;", "getMeta", "()Lcom/sputnik/domain/entities/invites/DomainFamilyInvites$DomainMeta;", "DomainInviteLimits", "DomainMeta", "domain"}, k = 1, mv = {1, 9, 0}, xi = 48)
/* loaded from: classes3.dex */
public final /* data */ class DomainFamilyInvites {
    private final List<DomainFamilyInvite> invites;
    private final DomainMeta meta;

    public boolean equals(Object other) {
        if (this == other) {
            return true;
        }
        if (!(other instanceof DomainFamilyInvites)) {
            return false;
        }
        DomainFamilyInvites domainFamilyInvites = (DomainFamilyInvites) other;
        return Intrinsics.areEqual(this.invites, domainFamilyInvites.invites) && Intrinsics.areEqual(this.meta, domainFamilyInvites.meta);
    }

    public int hashCode() {
        int iHashCode = this.invites.hashCode() * 31;
        DomainMeta domainMeta = this.meta;
        return iHashCode + (domainMeta == null ? 0 : domainMeta.hashCode());
    }

    public String toString() {
        return "DomainFamilyInvites(invites=" + this.invites + ", meta=" + this.meta + ")";
    }

    public DomainFamilyInvites(List<DomainFamilyInvite> invites, DomainMeta domainMeta) {
        Intrinsics.checkNotNullParameter(invites, "invites");
        this.invites = invites;
        this.meta = domainMeta;
    }

    public final List<DomainFamilyInvite> getInvites() {
        return this.invites;
    }

    public final DomainMeta getMeta() {
        return this.meta;
    }

    /* compiled from: DomainFamilyInvites.kt */
    @Metadata(d1 = {"\u0000(\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u000e\n\u0002\b\u0002\n\u0002\u0010\b\n\u0002\b\u0003\n\u0002\u0010\u000b\n\u0002\b\u0006\b\u0086\b\u0018\u00002\u00020\u0001B\u0011\u0012\b\u0010\u0003\u001a\u0004\u0018\u00010\u0002¢\u0006\u0004\b\u0004\u0010\u0005J\u0010\u0010\u0007\u001a\u00020\u0006HÖ\u0001¢\u0006\u0004\b\u0007\u0010\bJ\u0010\u0010\n\u001a\u00020\tHÖ\u0001¢\u0006\u0004\b\n\u0010\u000bJ\u001a\u0010\u000e\u001a\u00020\r2\b\u0010\f\u001a\u0004\u0018\u00010\u0001HÖ\u0003¢\u0006\u0004\b\u000e\u0010\u000fR\u0019\u0010\u0003\u001a\u0004\u0018\u00010\u00028\u0006¢\u0006\f\n\u0004\b\u0003\u0010\u0010\u001a\u0004\b\u0011\u0010\u0012¨\u0006\u0013"}, d2 = {"Lcom/sputnik/domain/entities/invites/DomainFamilyInvites$DomainMeta;", "", "Lcom/sputnik/domain/entities/invites/DomainFamilyInvites$DomainInviteLimits;", "inviteLimits", "<init>", "(Lcom/sputnik/domain/entities/invites/DomainFamilyInvites$DomainInviteLimits;)V", "", "toString", "()Ljava/lang/String;", "", "hashCode", "()I", "other", "", "equals", "(Ljava/lang/Object;)Z", "Lcom/sputnik/domain/entities/invites/DomainFamilyInvites$DomainInviteLimits;", "getInviteLimits", "()Lcom/sputnik/domain/entities/invites/DomainFamilyInvites$DomainInviteLimits;", "domain"}, k = 1, mv = {1, 9, 0}, xi = 48)
    public static final /* data */ class DomainMeta {
        private final DomainInviteLimits inviteLimits;

        public boolean equals(Object other) {
            if (this == other) {
                return true;
            }
            return (other instanceof DomainMeta) && Intrinsics.areEqual(this.inviteLimits, ((DomainMeta) other).inviteLimits);
        }

        public int hashCode() {
            DomainInviteLimits domainInviteLimits = this.inviteLimits;
            if (domainInviteLimits == null) {
                return 0;
            }
            return domainInviteLimits.hashCode();
        }

        public String toString() {
            return "DomainMeta(inviteLimits=" + this.inviteLimits + ")";
        }

        public DomainMeta(DomainInviteLimits domainInviteLimits) {
            this.inviteLimits = domainInviteLimits;
        }

        public final DomainInviteLimits getInviteLimits() {
            return this.inviteLimits;
        }
    }

    /* compiled from: DomainFamilyInvites.kt */
    @Metadata(d1 = {"\u0000 \n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0010\b\n\u0002\b\u0004\n\u0002\u0010\u000e\n\u0002\b\u0005\n\u0002\u0010\u000b\n\u0002\b\u0007\b\u0086\b\u0018\u00002\u00020\u0001B\u001b\u0012\b\u0010\u0003\u001a\u0004\u0018\u00010\u0002\u0012\b\u0010\u0004\u001a\u0004\u0018\u00010\u0002¢\u0006\u0004\b\u0005\u0010\u0006J\u0010\u0010\b\u001a\u00020\u0007HÖ\u0001¢\u0006\u0004\b\b\u0010\tJ\u0010\u0010\n\u001a\u00020\u0002HÖ\u0001¢\u0006\u0004\b\n\u0010\u000bJ\u001a\u0010\u000e\u001a\u00020\r2\b\u0010\f\u001a\u0004\u0018\u00010\u0001HÖ\u0003¢\u0006\u0004\b\u000e\u0010\u000fR\u0019\u0010\u0003\u001a\u0004\u0018\u00010\u00028\u0006¢\u0006\f\n\u0004\b\u0003\u0010\u0010\u001a\u0004\b\u0011\u0010\u0012R\u0019\u0010\u0004\u001a\u0004\u0018\u00010\u00028\u0006¢\u0006\f\n\u0004\b\u0004\u0010\u0010\u001a\u0004\b\u0013\u0010\u0012¨\u0006\u0014"}, d2 = {"Lcom/sputnik/domain/entities/invites/DomainFamilyInvites$DomainInviteLimits;", "", "", "total", "used", "<init>", "(Ljava/lang/Integer;Ljava/lang/Integer;)V", "", "toString", "()Ljava/lang/String;", "hashCode", "()I", "other", "", "equals", "(Ljava/lang/Object;)Z", "Ljava/lang/Integer;", "getTotal", "()Ljava/lang/Integer;", "getUsed", "domain"}, k = 1, mv = {1, 9, 0}, xi = 48)
    public static final /* data */ class DomainInviteLimits {
        private final Integer total;
        private final Integer used;

        public boolean equals(Object other) {
            if (this == other) {
                return true;
            }
            if (!(other instanceof DomainInviteLimits)) {
                return false;
            }
            DomainInviteLimits domainInviteLimits = (DomainInviteLimits) other;
            return Intrinsics.areEqual(this.total, domainInviteLimits.total) && Intrinsics.areEqual(this.used, domainInviteLimits.used);
        }

        public int hashCode() {
            Integer num = this.total;
            int iHashCode = (num == null ? 0 : num.hashCode()) * 31;
            Integer num2 = this.used;
            return iHashCode + (num2 != null ? num2.hashCode() : 0);
        }

        public String toString() {
            return "DomainInviteLimits(total=" + this.total + ", used=" + this.used + ")";
        }

        public DomainInviteLimits(Integer num, Integer num2) {
            this.total = num;
            this.used = num2;
        }

        public final Integer getTotal() {
            return this.total;
        }

        public final Integer getUsed() {
            return this.used;
        }
    }
}

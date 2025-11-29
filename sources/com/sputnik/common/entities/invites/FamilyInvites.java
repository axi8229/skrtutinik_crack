package com.sputnik.common.entities.invites;

import java.util.List;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

/* compiled from: FamilyInvites.kt */
@Metadata(d1 = {"\u00002\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u000e\n\u0002\b\u0002\n\u0002\u0010\b\n\u0002\b\u0003\n\u0002\u0010\u000b\n\u0002\b\u000b\b\u0086\b\u0018\u00002\u00020\u0001:\u0002\u0019\u001aB\u001f\u0012\f\u0010\u0004\u001a\b\u0012\u0004\u0012\u00020\u00030\u0002\u0012\b\u0010\u0006\u001a\u0004\u0018\u00010\u0005¢\u0006\u0004\b\u0007\u0010\bJ\u0010\u0010\n\u001a\u00020\tHÖ\u0001¢\u0006\u0004\b\n\u0010\u000bJ\u0010\u0010\r\u001a\u00020\fHÖ\u0001¢\u0006\u0004\b\r\u0010\u000eJ\u001a\u0010\u0011\u001a\u00020\u00102\b\u0010\u000f\u001a\u0004\u0018\u00010\u0001HÖ\u0003¢\u0006\u0004\b\u0011\u0010\u0012R\u001d\u0010\u0004\u001a\b\u0012\u0004\u0012\u00020\u00030\u00028\u0006¢\u0006\f\n\u0004\b\u0004\u0010\u0013\u001a\u0004\b\u0014\u0010\u0015R\u0019\u0010\u0006\u001a\u0004\u0018\u00010\u00058\u0006¢\u0006\f\n\u0004\b\u0006\u0010\u0016\u001a\u0004\b\u0017\u0010\u0018¨\u0006\u001b"}, d2 = {"Lcom/sputnik/common/entities/invites/FamilyInvites;", "", "", "Lcom/sputnik/common/entities/invites/FamilyInvite;", "invites", "Lcom/sputnik/common/entities/invites/FamilyInvites$Meta;", "meta", "<init>", "(Ljava/util/List;Lcom/sputnik/common/entities/invites/FamilyInvites$Meta;)V", "", "toString", "()Ljava/lang/String;", "", "hashCode", "()I", "other", "", "equals", "(Ljava/lang/Object;)Z", "Ljava/util/List;", "getInvites", "()Ljava/util/List;", "Lcom/sputnik/common/entities/invites/FamilyInvites$Meta;", "getMeta", "()Lcom/sputnik/common/entities/invites/FamilyInvites$Meta;", "InviteLimits", "Meta", "common_release"}, k = 1, mv = {1, 9, 0}, xi = 48)
/* loaded from: classes3.dex */
public final /* data */ class FamilyInvites {
    private final List<FamilyInvite> invites;
    private final Meta meta;

    public boolean equals(Object other) {
        if (this == other) {
            return true;
        }
        if (!(other instanceof FamilyInvites)) {
            return false;
        }
        FamilyInvites familyInvites = (FamilyInvites) other;
        return Intrinsics.areEqual(this.invites, familyInvites.invites) && Intrinsics.areEqual(this.meta, familyInvites.meta);
    }

    public int hashCode() {
        int iHashCode = this.invites.hashCode() * 31;
        Meta meta = this.meta;
        return iHashCode + (meta == null ? 0 : meta.hashCode());
    }

    public String toString() {
        return "FamilyInvites(invites=" + this.invites + ", meta=" + this.meta + ")";
    }

    public FamilyInvites(List<FamilyInvite> invites, Meta meta) {
        Intrinsics.checkNotNullParameter(invites, "invites");
        this.invites = invites;
        this.meta = meta;
    }

    public final List<FamilyInvite> getInvites() {
        return this.invites;
    }

    public final Meta getMeta() {
        return this.meta;
    }

    /* compiled from: FamilyInvites.kt */
    @Metadata(d1 = {"\u0000(\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u000e\n\u0002\b\u0002\n\u0002\u0010\b\n\u0002\b\u0003\n\u0002\u0010\u000b\n\u0002\b\u0006\b\u0086\b\u0018\u00002\u00020\u0001B\u0011\u0012\b\u0010\u0003\u001a\u0004\u0018\u00010\u0002¢\u0006\u0004\b\u0004\u0010\u0005J\u0010\u0010\u0007\u001a\u00020\u0006HÖ\u0001¢\u0006\u0004\b\u0007\u0010\bJ\u0010\u0010\n\u001a\u00020\tHÖ\u0001¢\u0006\u0004\b\n\u0010\u000bJ\u001a\u0010\u000e\u001a\u00020\r2\b\u0010\f\u001a\u0004\u0018\u00010\u0001HÖ\u0003¢\u0006\u0004\b\u000e\u0010\u000fR\u0019\u0010\u0003\u001a\u0004\u0018\u00010\u00028\u0006¢\u0006\f\n\u0004\b\u0003\u0010\u0010\u001a\u0004\b\u0011\u0010\u0012¨\u0006\u0013"}, d2 = {"Lcom/sputnik/common/entities/invites/FamilyInvites$Meta;", "", "Lcom/sputnik/common/entities/invites/FamilyInvites$InviteLimits;", "inviteLimits", "<init>", "(Lcom/sputnik/common/entities/invites/FamilyInvites$InviteLimits;)V", "", "toString", "()Ljava/lang/String;", "", "hashCode", "()I", "other", "", "equals", "(Ljava/lang/Object;)Z", "Lcom/sputnik/common/entities/invites/FamilyInvites$InviteLimits;", "getInviteLimits", "()Lcom/sputnik/common/entities/invites/FamilyInvites$InviteLimits;", "common_release"}, k = 1, mv = {1, 9, 0}, xi = 48)
    public static final /* data */ class Meta {
        private final InviteLimits inviteLimits;

        public boolean equals(Object other) {
            if (this == other) {
                return true;
            }
            return (other instanceof Meta) && Intrinsics.areEqual(this.inviteLimits, ((Meta) other).inviteLimits);
        }

        public int hashCode() {
            InviteLimits inviteLimits = this.inviteLimits;
            if (inviteLimits == null) {
                return 0;
            }
            return inviteLimits.hashCode();
        }

        public String toString() {
            return "Meta(inviteLimits=" + this.inviteLimits + ")";
        }

        public Meta(InviteLimits inviteLimits) {
            this.inviteLimits = inviteLimits;
        }

        public final InviteLimits getInviteLimits() {
            return this.inviteLimits;
        }
    }

    /* compiled from: FamilyInvites.kt */
    @Metadata(d1 = {"\u0000 \n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0010\b\n\u0002\b\u0004\n\u0002\u0010\u000e\n\u0002\b\u0005\n\u0002\u0010\u000b\n\u0002\b\u0006\b\u0086\b\u0018\u00002\u00020\u0001B\u0017\u0012\u0006\u0010\u0003\u001a\u00020\u0002\u0012\u0006\u0010\u0004\u001a\u00020\u0002¢\u0006\u0004\b\u0005\u0010\u0006J\u0010\u0010\b\u001a\u00020\u0007HÖ\u0001¢\u0006\u0004\b\b\u0010\tJ\u0010\u0010\n\u001a\u00020\u0002HÖ\u0001¢\u0006\u0004\b\n\u0010\u000bJ\u001a\u0010\u000e\u001a\u00020\r2\b\u0010\f\u001a\u0004\u0018\u00010\u0001HÖ\u0003¢\u0006\u0004\b\u000e\u0010\u000fR\u0017\u0010\u0003\u001a\u00020\u00028\u0006¢\u0006\f\n\u0004\b\u0003\u0010\u0010\u001a\u0004\b\u0011\u0010\u000bR\u0017\u0010\u0004\u001a\u00020\u00028\u0006¢\u0006\f\n\u0004\b\u0004\u0010\u0010\u001a\u0004\b\u0012\u0010\u000b¨\u0006\u0013"}, d2 = {"Lcom/sputnik/common/entities/invites/FamilyInvites$InviteLimits;", "", "", "total", "used", "<init>", "(II)V", "", "toString", "()Ljava/lang/String;", "hashCode", "()I", "other", "", "equals", "(Ljava/lang/Object;)Z", "I", "getTotal", "getUsed", "common_release"}, k = 1, mv = {1, 9, 0}, xi = 48)
    public static final /* data */ class InviteLimits {
        private final int total;
        private final int used;

        public boolean equals(Object other) {
            if (this == other) {
                return true;
            }
            if (!(other instanceof InviteLimits)) {
                return false;
            }
            InviteLimits inviteLimits = (InviteLimits) other;
            return this.total == inviteLimits.total && this.used == inviteLimits.used;
        }

        public int hashCode() {
            return (Integer.hashCode(this.total) * 31) + Integer.hashCode(this.used);
        }

        public String toString() {
            return "InviteLimits(total=" + this.total + ", used=" + this.used + ")";
        }

        public InviteLimits(int i, int i2) {
            this.total = i;
            this.used = i2;
        }

        public final int getTotal() {
            return this.total;
        }

        public final int getUsed() {
            return this.used;
        }
    }
}

package com.sputnik.common.entities.invites;

import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

/* compiled from: Invite.kt */
@Metadata(d1 = {"\u00000\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0010\u000e\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0010\b\n\u0002\b\u0003\n\u0002\u0010\u000b\n\u0002\b\u000f\b\u0086\b\u0018\u00002\u00020\u0001BM\u0012\b\u0010\u0003\u001a\u0004\u0018\u00010\u0002\u0012\b\u0010\u0004\u001a\u0004\u0018\u00010\u0002\u0012\b\u0010\u0006\u001a\u0004\u0018\u00010\u0005\u0012\b\u0010\u0007\u001a\u0004\u0018\u00010\u0002\u0012\b\u0010\b\u001a\u0004\u0018\u00010\u0002\u0012\b\u0010\t\u001a\u0004\u0018\u00010\u0002\u0012\b\u0010\u000b\u001a\u0004\u0018\u00010\n¢\u0006\u0004\b\f\u0010\rJ\u0010\u0010\u000e\u001a\u00020\u0002HÖ\u0001¢\u0006\u0004\b\u000e\u0010\u000fJ\u0010\u0010\u0011\u001a\u00020\u0010HÖ\u0001¢\u0006\u0004\b\u0011\u0010\u0012J\u001a\u0010\u0015\u001a\u00020\u00142\b\u0010\u0013\u001a\u0004\u0018\u00010\u0001HÖ\u0003¢\u0006\u0004\b\u0015\u0010\u0016R\u0019\u0010\u0003\u001a\u0004\u0018\u00010\u00028\u0006¢\u0006\f\n\u0004\b\u0003\u0010\u0017\u001a\u0004\b\u0018\u0010\u000fR\u0019\u0010\u0004\u001a\u0004\u0018\u00010\u00028\u0006¢\u0006\f\n\u0004\b\u0004\u0010\u0017\u001a\u0004\b\u0019\u0010\u000fR\u0019\u0010\u0006\u001a\u0004\u0018\u00010\u00058\u0006¢\u0006\f\n\u0004\b\u0006\u0010\u001a\u001a\u0004\b\u001b\u0010\u001cR\u0019\u0010\u0007\u001a\u0004\u0018\u00010\u00028\u0006¢\u0006\f\n\u0004\b\u0007\u0010\u0017\u001a\u0004\b\u001d\u0010\u000fR\u0019\u0010\b\u001a\u0004\u0018\u00010\u00028\u0006¢\u0006\f\n\u0004\b\b\u0010\u0017\u001a\u0004\b\u001e\u0010\u000fR\u0019\u0010\t\u001a\u0004\u0018\u00010\u00028\u0006¢\u0006\f\n\u0004\b\t\u0010\u0017\u001a\u0004\b\u001f\u0010\u000fR\u0019\u0010\u000b\u001a\u0004\u0018\u00010\n8\u0006¢\u0006\f\n\u0004\b\u000b\u0010 \u001a\u0004\b!\u0010\"¨\u0006#"}, d2 = {"Lcom/sputnik/common/entities/invites/Invite;", "", "", "id", "phone", "Lcom/sputnik/common/entities/invites/InviteStatus;", "state", "flatUuid", "flatNumber", "fullAddress", "Lcom/sputnik/common/entities/invites/InviteSources;", "source", "<init>", "(Ljava/lang/String;Ljava/lang/String;Lcom/sputnik/common/entities/invites/InviteStatus;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Lcom/sputnik/common/entities/invites/InviteSources;)V", "toString", "()Ljava/lang/String;", "", "hashCode", "()I", "other", "", "equals", "(Ljava/lang/Object;)Z", "Ljava/lang/String;", "getId", "getPhone", "Lcom/sputnik/common/entities/invites/InviteStatus;", "getState", "()Lcom/sputnik/common/entities/invites/InviteStatus;", "getFlatUuid", "getFlatNumber", "getFullAddress", "Lcom/sputnik/common/entities/invites/InviteSources;", "getSource", "()Lcom/sputnik/common/entities/invites/InviteSources;", "common_release"}, k = 1, mv = {1, 9, 0}, xi = 48)
/* loaded from: classes3.dex */
public final /* data */ class Invite {
    private final String flatNumber;
    private final String flatUuid;
    private final String fullAddress;
    private final String id;
    private final String phone;
    private final InviteSources source;
    private final InviteStatus state;

    public boolean equals(Object other) {
        if (this == other) {
            return true;
        }
        if (!(other instanceof Invite)) {
            return false;
        }
        Invite invite = (Invite) other;
        return Intrinsics.areEqual(this.id, invite.id) && Intrinsics.areEqual(this.phone, invite.phone) && this.state == invite.state && Intrinsics.areEqual(this.flatUuid, invite.flatUuid) && Intrinsics.areEqual(this.flatNumber, invite.flatNumber) && Intrinsics.areEqual(this.fullAddress, invite.fullAddress) && this.source == invite.source;
    }

    public int hashCode() {
        String str = this.id;
        int iHashCode = (str == null ? 0 : str.hashCode()) * 31;
        String str2 = this.phone;
        int iHashCode2 = (iHashCode + (str2 == null ? 0 : str2.hashCode())) * 31;
        InviteStatus inviteStatus = this.state;
        int iHashCode3 = (iHashCode2 + (inviteStatus == null ? 0 : inviteStatus.hashCode())) * 31;
        String str3 = this.flatUuid;
        int iHashCode4 = (iHashCode3 + (str3 == null ? 0 : str3.hashCode())) * 31;
        String str4 = this.flatNumber;
        int iHashCode5 = (iHashCode4 + (str4 == null ? 0 : str4.hashCode())) * 31;
        String str5 = this.fullAddress;
        int iHashCode6 = (iHashCode5 + (str5 == null ? 0 : str5.hashCode())) * 31;
        InviteSources inviteSources = this.source;
        return iHashCode6 + (inviteSources != null ? inviteSources.hashCode() : 0);
    }

    public String toString() {
        return "Invite(id=" + this.id + ", phone=" + this.phone + ", state=" + this.state + ", flatUuid=" + this.flatUuid + ", flatNumber=" + this.flatNumber + ", fullAddress=" + this.fullAddress + ", source=" + this.source + ")";
    }

    public Invite(String str, String str2, InviteStatus inviteStatus, String str3, String str4, String str5, InviteSources inviteSources) {
        this.id = str;
        this.phone = str2;
        this.state = inviteStatus;
        this.flatUuid = str3;
        this.flatNumber = str4;
        this.fullAddress = str5;
        this.source = inviteSources;
    }

    public final String getId() {
        return this.id;
    }

    public final String getFlatNumber() {
        return this.flatNumber;
    }

    public final String getFullAddress() {
        return this.fullAddress;
    }

    public final InviteSources getSource() {
        return this.source;
    }
}

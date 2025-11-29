package com.sputnik.common.viewmodels;

import com.sputnik.common.base.VMState;
import com.sputnik.common.entities.invites.FamilyInvites;
import com.sputnik.common.entities.invites.Invite;
import com.sputnik.common.entities.invites.InviteStatus;
import com.sputnik.domain.common.Event;
import com.sputnik.domain.common.Resource;
import java.util.List;
import kotlin.Metadata;
import kotlin.collections.CollectionsKt;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;

/* compiled from: InvitesViewModel.kt */
@Metadata(d1 = {"\u0000H\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\b\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010\u000b\n\u0002\b\u0007\n\u0002\u0010\b\n\u0002\b\u0002\n\u0002\u0010\u0000\n\u0002\b\u001c\b\u0086\b\u0018\u00002\u00020\u0001B\u009b\u0001\u0012\b\b\u0002\u0010\u0003\u001a\u00020\u0002\u0012\b\b\u0002\u0010\u0004\u001a\u00020\u0002\u0012\b\b\u0002\u0010\u0005\u001a\u00020\u0002\u0012\b\b\u0002\u0010\u0006\u001a\u00020\u0002\u0012\b\b\u0002\u0010\u0007\u001a\u00020\u0002\u0012\b\b\u0002\u0010\b\u001a\u00020\u0002\u0012\b\b\u0002\u0010\t\u001a\u00020\u0002\u0012\b\b\u0002\u0010\n\u001a\u00020\u0002\u0012\n\b\u0002\u0010\f\u001a\u0004\u0018\u00010\u000b\u0012\u0014\b\u0002\u0010\u0010\u001a\u000e\u0012\n\u0012\b\u0012\u0004\u0012\u00020\u000f0\u000e0\r\u0012\n\b\u0002\u0010\u0012\u001a\u0004\u0018\u00010\u0011\u0012\n\b\u0002\u0010\u0014\u001a\u0004\u0018\u00010\u0013\u0012\b\b\u0002\u0010\u0016\u001a\u00020\u0015¢\u0006\u0004\b\u0017\u0010\u0018J¤\u0001\u0010\u0019\u001a\u00020\u00002\b\b\u0002\u0010\u0003\u001a\u00020\u00022\b\b\u0002\u0010\u0004\u001a\u00020\u00022\b\b\u0002\u0010\u0005\u001a\u00020\u00022\b\b\u0002\u0010\u0006\u001a\u00020\u00022\b\b\u0002\u0010\u0007\u001a\u00020\u00022\b\b\u0002\u0010\b\u001a\u00020\u00022\b\b\u0002\u0010\t\u001a\u00020\u00022\b\b\u0002\u0010\n\u001a\u00020\u00022\n\b\u0002\u0010\f\u001a\u0004\u0018\u00010\u000b2\u0014\b\u0002\u0010\u0010\u001a\u000e\u0012\n\u0012\b\u0012\u0004\u0012\u00020\u000f0\u000e0\r2\n\b\u0002\u0010\u0012\u001a\u0004\u0018\u00010\u00112\n\b\u0002\u0010\u0014\u001a\u0004\u0018\u00010\u00132\b\b\u0002\u0010\u0016\u001a\u00020\u0015HÆ\u0001¢\u0006\u0004\b\u0019\u0010\u001aJ\u0010\u0010\u001b\u001a\u00020\u0013HÖ\u0001¢\u0006\u0004\b\u001b\u0010\u001cJ\u0010\u0010\u001e\u001a\u00020\u001dHÖ\u0001¢\u0006\u0004\b\u001e\u0010\u001fJ\u001a\u0010\"\u001a\u00020\u00152\b\u0010!\u001a\u0004\u0018\u00010 HÖ\u0003¢\u0006\u0004\b\"\u0010#R\u0017\u0010\u0003\u001a\u00020\u00028\u0006¢\u0006\f\n\u0004\b\u0003\u0010$\u001a\u0004\b%\u0010&R\u0017\u0010\u0004\u001a\u00020\u00028\u0006¢\u0006\f\n\u0004\b\u0004\u0010$\u001a\u0004\b'\u0010&R\u0017\u0010\u0005\u001a\u00020\u00028\u0006¢\u0006\f\n\u0004\b\u0005\u0010$\u001a\u0004\b(\u0010&R\u0017\u0010\u0006\u001a\u00020\u00028\u0006¢\u0006\f\n\u0004\b\u0006\u0010$\u001a\u0004\b)\u0010&R\u0017\u0010\u0007\u001a\u00020\u00028\u0006¢\u0006\f\n\u0004\b\u0007\u0010$\u001a\u0004\b*\u0010&R\u0017\u0010\b\u001a\u00020\u00028\u0006¢\u0006\f\n\u0004\b\b\u0010$\u001a\u0004\b+\u0010&R\u0017\u0010\t\u001a\u00020\u00028\u0006¢\u0006\f\n\u0004\b\t\u0010$\u001a\u0004\b,\u0010&R\u0017\u0010\n\u001a\u00020\u00028\u0006¢\u0006\f\n\u0004\b\n\u0010$\u001a\u0004\b-\u0010&R\u0019\u0010\f\u001a\u0004\u0018\u00010\u000b8\u0006¢\u0006\f\n\u0004\b\f\u0010.\u001a\u0004\b/\u00100R#\u0010\u0010\u001a\u000e\u0012\n\u0012\b\u0012\u0004\u0012\u00020\u000f0\u000e0\r8\u0006¢\u0006\f\n\u0004\b\u0010\u00101\u001a\u0004\b2\u00103R\u0019\u0010\u0012\u001a\u0004\u0018\u00010\u00118\u0006¢\u0006\f\n\u0004\b\u0012\u00104\u001a\u0004\b5\u00106R\u0019\u0010\u0014\u001a\u0004\u0018\u00010\u00138\u0006¢\u0006\f\n\u0004\b\u0014\u00107\u001a\u0004\b8\u0010\u001cR\u0017\u0010\u0016\u001a\u00020\u00158\u0006¢\u0006\f\n\u0004\b\u0016\u00109\u001a\u0004\b:\u0010;¨\u0006<"}, d2 = {"Lcom/sputnik/common/viewmodels/InvitesViewState;", "Lcom/sputnik/common/base/VMState;", "Lcom/sputnik/domain/common/Resource$Status;", "serverState", "familyInvitesServerState", "sendFamilyInviteServerState", "resendFamilyInviteServerState", "deleteFamilyInviteServerState", "familyInvitesOperationServerState", "acceptInviteServerState", "declineInviteServerState", "Lcom/sputnik/common/entities/invites/InviteStatus;", "manageInviteStatus", "Lcom/sputnik/domain/common/Event;", "", "Lcom/sputnik/common/entities/invites/Invite;", "invites", "Lcom/sputnik/common/entities/invites/FamilyInvites;", "familyInvites", "", "sendFamilyInviteErrorMessage", "", "manageInvitesAvailable", "<init>", "(Lcom/sputnik/domain/common/Resource$Status;Lcom/sputnik/domain/common/Resource$Status;Lcom/sputnik/domain/common/Resource$Status;Lcom/sputnik/domain/common/Resource$Status;Lcom/sputnik/domain/common/Resource$Status;Lcom/sputnik/domain/common/Resource$Status;Lcom/sputnik/domain/common/Resource$Status;Lcom/sputnik/domain/common/Resource$Status;Lcom/sputnik/common/entities/invites/InviteStatus;Lcom/sputnik/domain/common/Event;Lcom/sputnik/common/entities/invites/FamilyInvites;Ljava/lang/String;Z)V", "copy", "(Lcom/sputnik/domain/common/Resource$Status;Lcom/sputnik/domain/common/Resource$Status;Lcom/sputnik/domain/common/Resource$Status;Lcom/sputnik/domain/common/Resource$Status;Lcom/sputnik/domain/common/Resource$Status;Lcom/sputnik/domain/common/Resource$Status;Lcom/sputnik/domain/common/Resource$Status;Lcom/sputnik/domain/common/Resource$Status;Lcom/sputnik/common/entities/invites/InviteStatus;Lcom/sputnik/domain/common/Event;Lcom/sputnik/common/entities/invites/FamilyInvites;Ljava/lang/String;Z)Lcom/sputnik/common/viewmodels/InvitesViewState;", "toString", "()Ljava/lang/String;", "", "hashCode", "()I", "", "other", "equals", "(Ljava/lang/Object;)Z", "Lcom/sputnik/domain/common/Resource$Status;", "getServerState", "()Lcom/sputnik/domain/common/Resource$Status;", "getFamilyInvitesServerState", "getSendFamilyInviteServerState", "getResendFamilyInviteServerState", "getDeleteFamilyInviteServerState", "getFamilyInvitesOperationServerState", "getAcceptInviteServerState", "getDeclineInviteServerState", "Lcom/sputnik/common/entities/invites/InviteStatus;", "getManageInviteStatus", "()Lcom/sputnik/common/entities/invites/InviteStatus;", "Lcom/sputnik/domain/common/Event;", "getInvites", "()Lcom/sputnik/domain/common/Event;", "Lcom/sputnik/common/entities/invites/FamilyInvites;", "getFamilyInvites", "()Lcom/sputnik/common/entities/invites/FamilyInvites;", "Ljava/lang/String;", "getSendFamilyInviteErrorMessage", "Z", "getManageInvitesAvailable", "()Z", "common_release"}, k = 1, mv = {1, 9, 0}, xi = 48)
/* loaded from: classes3.dex */
public final /* data */ class InvitesViewState implements VMState {
    private final Resource.Status acceptInviteServerState;
    private final Resource.Status declineInviteServerState;
    private final Resource.Status deleteFamilyInviteServerState;
    private final FamilyInvites familyInvites;
    private final Resource.Status familyInvitesOperationServerState;
    private final Resource.Status familyInvitesServerState;
    private final Event<List<Invite>> invites;
    private final InviteStatus manageInviteStatus;
    private final boolean manageInvitesAvailable;
    private final Resource.Status resendFamilyInviteServerState;
    private final String sendFamilyInviteErrorMessage;
    private final Resource.Status sendFamilyInviteServerState;
    private final Resource.Status serverState;

    public InvitesViewState() {
        this(null, null, null, null, null, null, null, null, null, null, null, null, false, 8191, null);
    }

    public final InvitesViewState copy(Resource.Status serverState, Resource.Status familyInvitesServerState, Resource.Status sendFamilyInviteServerState, Resource.Status resendFamilyInviteServerState, Resource.Status deleteFamilyInviteServerState, Resource.Status familyInvitesOperationServerState, Resource.Status acceptInviteServerState, Resource.Status declineInviteServerState, InviteStatus manageInviteStatus, Event<? extends List<Invite>> invites, FamilyInvites familyInvites, String sendFamilyInviteErrorMessage, boolean manageInvitesAvailable) {
        Intrinsics.checkNotNullParameter(serverState, "serverState");
        Intrinsics.checkNotNullParameter(familyInvitesServerState, "familyInvitesServerState");
        Intrinsics.checkNotNullParameter(sendFamilyInviteServerState, "sendFamilyInviteServerState");
        Intrinsics.checkNotNullParameter(resendFamilyInviteServerState, "resendFamilyInviteServerState");
        Intrinsics.checkNotNullParameter(deleteFamilyInviteServerState, "deleteFamilyInviteServerState");
        Intrinsics.checkNotNullParameter(familyInvitesOperationServerState, "familyInvitesOperationServerState");
        Intrinsics.checkNotNullParameter(acceptInviteServerState, "acceptInviteServerState");
        Intrinsics.checkNotNullParameter(declineInviteServerState, "declineInviteServerState");
        Intrinsics.checkNotNullParameter(invites, "invites");
        return new InvitesViewState(serverState, familyInvitesServerState, sendFamilyInviteServerState, resendFamilyInviteServerState, deleteFamilyInviteServerState, familyInvitesOperationServerState, acceptInviteServerState, declineInviteServerState, manageInviteStatus, invites, familyInvites, sendFamilyInviteErrorMessage, manageInvitesAvailable);
    }

    public boolean equals(Object other) {
        if (this == other) {
            return true;
        }
        if (!(other instanceof InvitesViewState)) {
            return false;
        }
        InvitesViewState invitesViewState = (InvitesViewState) other;
        return this.serverState == invitesViewState.serverState && this.familyInvitesServerState == invitesViewState.familyInvitesServerState && this.sendFamilyInviteServerState == invitesViewState.sendFamilyInviteServerState && this.resendFamilyInviteServerState == invitesViewState.resendFamilyInviteServerState && this.deleteFamilyInviteServerState == invitesViewState.deleteFamilyInviteServerState && this.familyInvitesOperationServerState == invitesViewState.familyInvitesOperationServerState && this.acceptInviteServerState == invitesViewState.acceptInviteServerState && this.declineInviteServerState == invitesViewState.declineInviteServerState && this.manageInviteStatus == invitesViewState.manageInviteStatus && Intrinsics.areEqual(this.invites, invitesViewState.invites) && Intrinsics.areEqual(this.familyInvites, invitesViewState.familyInvites) && Intrinsics.areEqual(this.sendFamilyInviteErrorMessage, invitesViewState.sendFamilyInviteErrorMessage) && this.manageInvitesAvailable == invitesViewState.manageInvitesAvailable;
    }

    /* JADX WARN: Multi-variable type inference failed */
    public int hashCode() {
        int iHashCode = ((((((((((((((this.serverState.hashCode() * 31) + this.familyInvitesServerState.hashCode()) * 31) + this.sendFamilyInviteServerState.hashCode()) * 31) + this.resendFamilyInviteServerState.hashCode()) * 31) + this.deleteFamilyInviteServerState.hashCode()) * 31) + this.familyInvitesOperationServerState.hashCode()) * 31) + this.acceptInviteServerState.hashCode()) * 31) + this.declineInviteServerState.hashCode()) * 31;
        InviteStatus inviteStatus = this.manageInviteStatus;
        int iHashCode2 = (((iHashCode + (inviteStatus == null ? 0 : inviteStatus.hashCode())) * 31) + this.invites.hashCode()) * 31;
        FamilyInvites familyInvites = this.familyInvites;
        int iHashCode3 = (iHashCode2 + (familyInvites == null ? 0 : familyInvites.hashCode())) * 31;
        String str = this.sendFamilyInviteErrorMessage;
        int iHashCode4 = (iHashCode3 + (str != null ? str.hashCode() : 0)) * 31;
        boolean z = this.manageInvitesAvailable;
        int i = z;
        if (z != 0) {
            i = 1;
        }
        return iHashCode4 + i;
    }

    public String toString() {
        return "InvitesViewState(serverState=" + this.serverState + ", familyInvitesServerState=" + this.familyInvitesServerState + ", sendFamilyInviteServerState=" + this.sendFamilyInviteServerState + ", resendFamilyInviteServerState=" + this.resendFamilyInviteServerState + ", deleteFamilyInviteServerState=" + this.deleteFamilyInviteServerState + ", familyInvitesOperationServerState=" + this.familyInvitesOperationServerState + ", acceptInviteServerState=" + this.acceptInviteServerState + ", declineInviteServerState=" + this.declineInviteServerState + ", manageInviteStatus=" + this.manageInviteStatus + ", invites=" + this.invites + ", familyInvites=" + this.familyInvites + ", sendFamilyInviteErrorMessage=" + this.sendFamilyInviteErrorMessage + ", manageInvitesAvailable=" + this.manageInvitesAvailable + ")";
    }

    /* JADX WARN: Multi-variable type inference failed */
    public InvitesViewState(Resource.Status serverState, Resource.Status familyInvitesServerState, Resource.Status sendFamilyInviteServerState, Resource.Status resendFamilyInviteServerState, Resource.Status deleteFamilyInviteServerState, Resource.Status familyInvitesOperationServerState, Resource.Status acceptInviteServerState, Resource.Status declineInviteServerState, InviteStatus inviteStatus, Event<? extends List<Invite>> invites, FamilyInvites familyInvites, String str, boolean z) {
        Intrinsics.checkNotNullParameter(serverState, "serverState");
        Intrinsics.checkNotNullParameter(familyInvitesServerState, "familyInvitesServerState");
        Intrinsics.checkNotNullParameter(sendFamilyInviteServerState, "sendFamilyInviteServerState");
        Intrinsics.checkNotNullParameter(resendFamilyInviteServerState, "resendFamilyInviteServerState");
        Intrinsics.checkNotNullParameter(deleteFamilyInviteServerState, "deleteFamilyInviteServerState");
        Intrinsics.checkNotNullParameter(familyInvitesOperationServerState, "familyInvitesOperationServerState");
        Intrinsics.checkNotNullParameter(acceptInviteServerState, "acceptInviteServerState");
        Intrinsics.checkNotNullParameter(declineInviteServerState, "declineInviteServerState");
        Intrinsics.checkNotNullParameter(invites, "invites");
        this.serverState = serverState;
        this.familyInvitesServerState = familyInvitesServerState;
        this.sendFamilyInviteServerState = sendFamilyInviteServerState;
        this.resendFamilyInviteServerState = resendFamilyInviteServerState;
        this.deleteFamilyInviteServerState = deleteFamilyInviteServerState;
        this.familyInvitesOperationServerState = familyInvitesOperationServerState;
        this.acceptInviteServerState = acceptInviteServerState;
        this.declineInviteServerState = declineInviteServerState;
        this.manageInviteStatus = inviteStatus;
        this.invites = invites;
        this.familyInvites = familyInvites;
        this.sendFamilyInviteErrorMessage = str;
        this.manageInvitesAvailable = z;
    }

    public /* synthetic */ InvitesViewState(Resource.Status status, Resource.Status status2, Resource.Status status3, Resource.Status status4, Resource.Status status5, Resource.Status status6, Resource.Status status7, Resource.Status status8, InviteStatus inviteStatus, Event event, FamilyInvites familyInvites, String str, boolean z, int i, DefaultConstructorMarker defaultConstructorMarker) {
        this((i & 1) != 0 ? Resource.Status.NONE : status, (i & 2) != 0 ? Resource.Status.NONE : status2, (i & 4) != 0 ? Resource.Status.NONE : status3, (i & 8) != 0 ? Resource.Status.NONE : status4, (i & 16) != 0 ? Resource.Status.NONE : status5, (i & 32) != 0 ? Resource.Status.NONE : status6, (i & 64) != 0 ? Resource.Status.NONE : status7, (i & 128) != 0 ? Resource.Status.NONE : status8, (i & 256) != 0 ? null : inviteStatus, (i & 512) != 0 ? new Event(CollectionsKt.emptyList()) : event, (i & 1024) != 0 ? null : familyInvites, (i & 2048) == 0 ? str : null, (i & 4096) != 0 ? false : z);
    }

    public final Resource.Status getServerState() {
        return this.serverState;
    }

    public final Resource.Status getFamilyInvitesServerState() {
        return this.familyInvitesServerState;
    }

    public final Resource.Status getSendFamilyInviteServerState() {
        return this.sendFamilyInviteServerState;
    }

    public final Resource.Status getResendFamilyInviteServerState() {
        return this.resendFamilyInviteServerState;
    }

    public final Resource.Status getDeleteFamilyInviteServerState() {
        return this.deleteFamilyInviteServerState;
    }

    public final Resource.Status getAcceptInviteServerState() {
        return this.acceptInviteServerState;
    }

    public final Resource.Status getDeclineInviteServerState() {
        return this.declineInviteServerState;
    }

    public final InviteStatus getManageInviteStatus() {
        return this.manageInviteStatus;
    }

    public final Event<List<Invite>> getInvites() {
        return this.invites;
    }

    public final FamilyInvites getFamilyInvites() {
        return this.familyInvites;
    }

    public final String getSendFamilyInviteErrorMessage() {
        return this.sendFamilyInviteErrorMessage;
    }

    public final boolean getManageInvitesAvailable() {
        return this.manageInvitesAvailable;
    }
}

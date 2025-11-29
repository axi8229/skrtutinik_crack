package com.sputnik.oboarding.ui.registration.viewmodel;

import com.sputnik.common.base.VMState;
import com.sputnik.domain.common.Resource;
import com.sputnik.oboarding.entities.connect_intercom.ActivationCode;
import com.sputnik.oboarding.entities.entry.Entry;
import kotlin.Metadata;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;

/* compiled from: ConnectIntercomViewModel.kt */
@Metadata(d1 = {"\u00008\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0002\b\u0005\n\u0002\u0010\u000e\n\u0002\b\u0004\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\u000b\n\u0002\b\u000e\b\u0086\b\u0018\u00002\u00020\u0001B3\u0012\b\b\u0002\u0010\u0003\u001a\u00020\u0002\u0012\n\b\u0002\u0010\u0005\u001a\u0004\u0018\u00010\u0004\u0012\n\b\u0002\u0010\u0007\u001a\u0004\u0018\u00010\u0006\u0012\b\b\u0002\u0010\t\u001a\u00020\b¢\u0006\u0004\b\n\u0010\u000bJ<\u0010\f\u001a\u00020\u00002\b\b\u0002\u0010\u0003\u001a\u00020\u00022\n\b\u0002\u0010\u0005\u001a\u0004\u0018\u00010\u00042\n\b\u0002\u0010\u0007\u001a\u0004\u0018\u00010\u00062\b\b\u0002\u0010\t\u001a\u00020\bHÆ\u0001¢\u0006\u0004\b\f\u0010\rJ\u0010\u0010\u000f\u001a\u00020\u000eHÖ\u0001¢\u0006\u0004\b\u000f\u0010\u0010J\u0010\u0010\u0011\u001a\u00020\bHÖ\u0001¢\u0006\u0004\b\u0011\u0010\u0012J\u001a\u0010\u0016\u001a\u00020\u00152\b\u0010\u0014\u001a\u0004\u0018\u00010\u0013HÖ\u0003¢\u0006\u0004\b\u0016\u0010\u0017R\u0017\u0010\u0003\u001a\u00020\u00028\u0006¢\u0006\f\n\u0004\b\u0003\u0010\u0018\u001a\u0004\b\u0019\u0010\u001aR\u0019\u0010\u0005\u001a\u0004\u0018\u00010\u00048\u0006¢\u0006\f\n\u0004\b\u0005\u0010\u001b\u001a\u0004\b\u001c\u0010\u001dR\u0019\u0010\u0007\u001a\u0004\u0018\u00010\u00068\u0006¢\u0006\f\n\u0004\b\u0007\u0010\u001e\u001a\u0004\b\u001f\u0010 R\u0017\u0010\t\u001a\u00020\b8\u0006¢\u0006\f\n\u0004\b\t\u0010!\u001a\u0004\b\"\u0010\u0012¨\u0006#"}, d2 = {"Lcom/sputnik/oboarding/ui/registration/viewmodel/ConnectIntercomViewState;", "Lcom/sputnik/common/base/VMState;", "Lcom/sputnik/domain/common/Resource$Status;", "serverState", "Lcom/sputnik/oboarding/entities/connect_intercom/ActivationCode;", "codeResponse", "Lcom/sputnik/oboarding/entities/entry/Entry;", "entry", "", "count", "<init>", "(Lcom/sputnik/domain/common/Resource$Status;Lcom/sputnik/oboarding/entities/connect_intercom/ActivationCode;Lcom/sputnik/oboarding/entities/entry/Entry;I)V", "copy", "(Lcom/sputnik/domain/common/Resource$Status;Lcom/sputnik/oboarding/entities/connect_intercom/ActivationCode;Lcom/sputnik/oboarding/entities/entry/Entry;I)Lcom/sputnik/oboarding/ui/registration/viewmodel/ConnectIntercomViewState;", "", "toString", "()Ljava/lang/String;", "hashCode", "()I", "", "other", "", "equals", "(Ljava/lang/Object;)Z", "Lcom/sputnik/domain/common/Resource$Status;", "getServerState", "()Lcom/sputnik/domain/common/Resource$Status;", "Lcom/sputnik/oboarding/entities/connect_intercom/ActivationCode;", "getCodeResponse", "()Lcom/sputnik/oboarding/entities/connect_intercom/ActivationCode;", "Lcom/sputnik/oboarding/entities/entry/Entry;", "getEntry", "()Lcom/sputnik/oboarding/entities/entry/Entry;", "I", "getCount", "onboarding_release"}, k = 1, mv = {1, 9, 0}, xi = 48)
/* loaded from: classes3.dex */
public final /* data */ class ConnectIntercomViewState implements VMState {
    private final ActivationCode codeResponse;
    private final int count;
    private final Entry entry;
    private final Resource.Status serverState;

    public ConnectIntercomViewState() {
        this(null, null, null, 0, 15, null);
    }

    public static /* synthetic */ ConnectIntercomViewState copy$default(ConnectIntercomViewState connectIntercomViewState, Resource.Status status, ActivationCode activationCode, Entry entry, int i, int i2, Object obj) {
        if ((i2 & 1) != 0) {
            status = connectIntercomViewState.serverState;
        }
        if ((i2 & 2) != 0) {
            activationCode = connectIntercomViewState.codeResponse;
        }
        if ((i2 & 4) != 0) {
            entry = connectIntercomViewState.entry;
        }
        if ((i2 & 8) != 0) {
            i = connectIntercomViewState.count;
        }
        return connectIntercomViewState.copy(status, activationCode, entry, i);
    }

    public final ConnectIntercomViewState copy(Resource.Status serverState, ActivationCode codeResponse, Entry entry, int count) {
        Intrinsics.checkNotNullParameter(serverState, "serverState");
        return new ConnectIntercomViewState(serverState, codeResponse, entry, count);
    }

    public boolean equals(Object other) {
        if (this == other) {
            return true;
        }
        if (!(other instanceof ConnectIntercomViewState)) {
            return false;
        }
        ConnectIntercomViewState connectIntercomViewState = (ConnectIntercomViewState) other;
        return this.serverState == connectIntercomViewState.serverState && Intrinsics.areEqual(this.codeResponse, connectIntercomViewState.codeResponse) && Intrinsics.areEqual(this.entry, connectIntercomViewState.entry) && this.count == connectIntercomViewState.count;
    }

    public int hashCode() {
        int iHashCode = this.serverState.hashCode() * 31;
        ActivationCode activationCode = this.codeResponse;
        int iHashCode2 = (iHashCode + (activationCode == null ? 0 : activationCode.hashCode())) * 31;
        Entry entry = this.entry;
        return ((iHashCode2 + (entry != null ? entry.hashCode() : 0)) * 31) + Integer.hashCode(this.count);
    }

    public String toString() {
        return "ConnectIntercomViewState(serverState=" + this.serverState + ", codeResponse=" + this.codeResponse + ", entry=" + this.entry + ", count=" + this.count + ")";
    }

    public ConnectIntercomViewState(Resource.Status serverState, ActivationCode activationCode, Entry entry, int i) {
        Intrinsics.checkNotNullParameter(serverState, "serverState");
        this.serverState = serverState;
        this.codeResponse = activationCode;
        this.entry = entry;
        this.count = i;
    }

    public /* synthetic */ ConnectIntercomViewState(Resource.Status status, ActivationCode activationCode, Entry entry, int i, int i2, DefaultConstructorMarker defaultConstructorMarker) {
        this((i2 & 1) != 0 ? Resource.Status.NONE : status, (i2 & 2) != 0 ? null : activationCode, (i2 & 4) != 0 ? null : entry, (i2 & 8) != 0 ? 0 : i);
    }

    public final Resource.Status getServerState() {
        return this.serverState;
    }

    public final ActivationCode getCodeResponse() {
        return this.codeResponse;
    }

    public final int getCount() {
        return this.count;
    }
}

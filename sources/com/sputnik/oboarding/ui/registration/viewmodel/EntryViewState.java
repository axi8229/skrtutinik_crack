package com.sputnik.oboarding.ui.registration.viewmodel;

import com.sputnik.common.base.VMState;
import com.sputnik.domain.common.Resource;
import com.sputnik.oboarding.entities.entry.Entry;
import kotlin.Metadata;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;

/* compiled from: EntryViewModel.kt */
@Metadata(d1 = {"\u00004\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0010\u000e\n\u0002\b\u0002\n\u0002\u0010\b\n\u0002\b\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\u000b\n\u0002\b\t\b\u0086\b\u0018\u00002\u00020\u0001B\u001d\u0012\b\b\u0002\u0010\u0003\u001a\u00020\u0002\u0012\n\b\u0002\u0010\u0005\u001a\u0004\u0018\u00010\u0004¢\u0006\u0004\b\u0006\u0010\u0007J&\u0010\b\u001a\u00020\u00002\b\b\u0002\u0010\u0003\u001a\u00020\u00022\n\b\u0002\u0010\u0005\u001a\u0004\u0018\u00010\u0004HÆ\u0001¢\u0006\u0004\b\b\u0010\tJ\u0010\u0010\u000b\u001a\u00020\nHÖ\u0001¢\u0006\u0004\b\u000b\u0010\fJ\u0010\u0010\u000e\u001a\u00020\rHÖ\u0001¢\u0006\u0004\b\u000e\u0010\u000fJ\u001a\u0010\u0013\u001a\u00020\u00122\b\u0010\u0011\u001a\u0004\u0018\u00010\u0010HÖ\u0003¢\u0006\u0004\b\u0013\u0010\u0014R\u0017\u0010\u0003\u001a\u00020\u00028\u0006¢\u0006\f\n\u0004\b\u0003\u0010\u0015\u001a\u0004\b\u0016\u0010\u0017R\u0019\u0010\u0005\u001a\u0004\u0018\u00010\u00048\u0006¢\u0006\f\n\u0004\b\u0005\u0010\u0018\u001a\u0004\b\u0019\u0010\u001a¨\u0006\u001b"}, d2 = {"Lcom/sputnik/oboarding/ui/registration/viewmodel/EntryViewState;", "Lcom/sputnik/common/base/VMState;", "Lcom/sputnik/domain/common/Resource$Status;", "serverState", "Lcom/sputnik/oboarding/entities/entry/Entry;", "entry", "<init>", "(Lcom/sputnik/domain/common/Resource$Status;Lcom/sputnik/oboarding/entities/entry/Entry;)V", "copy", "(Lcom/sputnik/domain/common/Resource$Status;Lcom/sputnik/oboarding/entities/entry/Entry;)Lcom/sputnik/oboarding/ui/registration/viewmodel/EntryViewState;", "", "toString", "()Ljava/lang/String;", "", "hashCode", "()I", "", "other", "", "equals", "(Ljava/lang/Object;)Z", "Lcom/sputnik/domain/common/Resource$Status;", "getServerState", "()Lcom/sputnik/domain/common/Resource$Status;", "Lcom/sputnik/oboarding/entities/entry/Entry;", "getEntry", "()Lcom/sputnik/oboarding/entities/entry/Entry;", "onboarding_release"}, k = 1, mv = {1, 9, 0}, xi = 48)
/* loaded from: classes3.dex */
public final /* data */ class EntryViewState implements VMState {
    private final Entry entry;
    private final Resource.Status serverState;

    public EntryViewState() {
        this(null, 0 == true ? 1 : 0, 3, 0 == true ? 1 : 0);
    }

    public final EntryViewState copy(Resource.Status serverState, Entry entry) {
        Intrinsics.checkNotNullParameter(serverState, "serverState");
        return new EntryViewState(serverState, entry);
    }

    public boolean equals(Object other) {
        if (this == other) {
            return true;
        }
        if (!(other instanceof EntryViewState)) {
            return false;
        }
        EntryViewState entryViewState = (EntryViewState) other;
        return this.serverState == entryViewState.serverState && Intrinsics.areEqual(this.entry, entryViewState.entry);
    }

    public int hashCode() {
        int iHashCode = this.serverState.hashCode() * 31;
        Entry entry = this.entry;
        return iHashCode + (entry == null ? 0 : entry.hashCode());
    }

    public String toString() {
        return "EntryViewState(serverState=" + this.serverState + ", entry=" + this.entry + ")";
    }

    public EntryViewState(Resource.Status serverState, Entry entry) {
        Intrinsics.checkNotNullParameter(serverState, "serverState");
        this.serverState = serverState;
        this.entry = entry;
    }

    public /* synthetic */ EntryViewState(Resource.Status status, Entry entry, int i, DefaultConstructorMarker defaultConstructorMarker) {
        this((i & 1) != 0 ? Resource.Status.NONE : status, (i & 2) != 0 ? null : entry);
    }

    public final Resource.Status getServerState() {
        return this.serverState;
    }

    public final Entry getEntry() {
        return this.entry;
    }
}

package com.sputnik.common.viewmodels;

import com.sputnik.common.base.VMState;
import com.sputnik.common.entities.keys.PhysicalKey;
import com.sputnik.domain.common.Event;
import com.sputnik.domain.common.Resource;
import java.util.List;
import kotlin.Metadata;
import kotlin.collections.CollectionsKt;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;

/* compiled from: KeysViewModel.kt */
@Metadata(d1 = {"\u0000<\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0010\u000e\n\u0000\n\u0002\u0018\u0002\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0002\b\u0007\n\u0002\u0010\b\n\u0002\b\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\u000b\n\u0002\b\u000f\b\u0086\b\u0018\u00002\u00020\u0001BY\u0012\b\b\u0002\u0010\u0003\u001a\u00020\u0002\u0012\b\b\u0002\u0010\u0004\u001a\u00020\u0002\u0012\b\b\u0002\u0010\u0005\u001a\u00020\u0002\u0012\b\b\u0002\u0010\u0006\u001a\u00020\u0002\u0012\b\b\u0002\u0010\u0007\u001a\u00020\u0002\u0012\b\b\u0002\u0010\t\u001a\u00020\b\u0012\u0014\b\u0002\u0010\r\u001a\u000e\u0012\n\u0012\b\u0012\u0004\u0012\u00020\f0\u000b0\n¢\u0006\u0004\b\u000e\u0010\u000fJb\u0010\u0010\u001a\u00020\u00002\b\b\u0002\u0010\u0003\u001a\u00020\u00022\b\b\u0002\u0010\u0004\u001a\u00020\u00022\b\b\u0002\u0010\u0005\u001a\u00020\u00022\b\b\u0002\u0010\u0006\u001a\u00020\u00022\b\b\u0002\u0010\u0007\u001a\u00020\u00022\b\b\u0002\u0010\t\u001a\u00020\b2\u0014\b\u0002\u0010\r\u001a\u000e\u0012\n\u0012\b\u0012\u0004\u0012\u00020\f0\u000b0\nHÆ\u0001¢\u0006\u0004\b\u0010\u0010\u0011J\u0010\u0010\u0012\u001a\u00020\bHÖ\u0001¢\u0006\u0004\b\u0012\u0010\u0013J\u0010\u0010\u0015\u001a\u00020\u0014HÖ\u0001¢\u0006\u0004\b\u0015\u0010\u0016J\u001a\u0010\u001a\u001a\u00020\u00192\b\u0010\u0018\u001a\u0004\u0018\u00010\u0017HÖ\u0003¢\u0006\u0004\b\u001a\u0010\u001bR\u0017\u0010\u0003\u001a\u00020\u00028\u0006¢\u0006\f\n\u0004\b\u0003\u0010\u001c\u001a\u0004\b\u001d\u0010\u001eR\u0017\u0010\u0004\u001a\u00020\u00028\u0006¢\u0006\f\n\u0004\b\u0004\u0010\u001c\u001a\u0004\b\u001f\u0010\u001eR\u0017\u0010\u0005\u001a\u00020\u00028\u0006¢\u0006\f\n\u0004\b\u0005\u0010\u001c\u001a\u0004\b \u0010\u001eR\u0017\u0010\u0006\u001a\u00020\u00028\u0006¢\u0006\f\n\u0004\b\u0006\u0010\u001c\u001a\u0004\b!\u0010\u001eR\u0017\u0010\u0007\u001a\u00020\u00028\u0006¢\u0006\f\n\u0004\b\u0007\u0010\u001c\u001a\u0004\b\"\u0010\u001eR\u0017\u0010\t\u001a\u00020\b8\u0006¢\u0006\f\n\u0004\b\t\u0010#\u001a\u0004\b$\u0010\u0013R#\u0010\r\u001a\u000e\u0012\n\u0012\b\u0012\u0004\u0012\u00020\f0\u000b0\n8\u0006¢\u0006\f\n\u0004\b\r\u0010%\u001a\u0004\b&\u0010'¨\u0006("}, d2 = {"Lcom/sputnik/common/viewmodels/KeysViewState;", "Lcom/sputnik/common/base/VMState;", "Lcom/sputnik/domain/common/Resource$Status;", "serverState", "updateKeyCommentServerState", "lockUnlockKeyServerState", "deleteKeyServerState", "createKeyServerState", "", "createKeyServerResponse", "Lcom/sputnik/domain/common/Event;", "", "Lcom/sputnik/common/entities/keys/PhysicalKey;", "keys", "<init>", "(Lcom/sputnik/domain/common/Resource$Status;Lcom/sputnik/domain/common/Resource$Status;Lcom/sputnik/domain/common/Resource$Status;Lcom/sputnik/domain/common/Resource$Status;Lcom/sputnik/domain/common/Resource$Status;Ljava/lang/String;Lcom/sputnik/domain/common/Event;)V", "copy", "(Lcom/sputnik/domain/common/Resource$Status;Lcom/sputnik/domain/common/Resource$Status;Lcom/sputnik/domain/common/Resource$Status;Lcom/sputnik/domain/common/Resource$Status;Lcom/sputnik/domain/common/Resource$Status;Ljava/lang/String;Lcom/sputnik/domain/common/Event;)Lcom/sputnik/common/viewmodels/KeysViewState;", "toString", "()Ljava/lang/String;", "", "hashCode", "()I", "", "other", "", "equals", "(Ljava/lang/Object;)Z", "Lcom/sputnik/domain/common/Resource$Status;", "getServerState", "()Lcom/sputnik/domain/common/Resource$Status;", "getUpdateKeyCommentServerState", "getLockUnlockKeyServerState", "getDeleteKeyServerState", "getCreateKeyServerState", "Ljava/lang/String;", "getCreateKeyServerResponse", "Lcom/sputnik/domain/common/Event;", "getKeys", "()Lcom/sputnik/domain/common/Event;", "common_release"}, k = 1, mv = {1, 9, 0}, xi = 48)
/* loaded from: classes3.dex */
public final /* data */ class KeysViewState implements VMState {
    private final String createKeyServerResponse;
    private final Resource.Status createKeyServerState;
    private final Resource.Status deleteKeyServerState;
    private final Event<List<PhysicalKey>> keys;
    private final Resource.Status lockUnlockKeyServerState;
    private final Resource.Status serverState;
    private final Resource.Status updateKeyCommentServerState;

    public KeysViewState() {
        this(null, null, null, null, null, null, null, 127, null);
    }

    public static /* synthetic */ KeysViewState copy$default(KeysViewState keysViewState, Resource.Status status, Resource.Status status2, Resource.Status status3, Resource.Status status4, Resource.Status status5, String str, Event event, int i, Object obj) {
        if ((i & 1) != 0) {
            status = keysViewState.serverState;
        }
        if ((i & 2) != 0) {
            status2 = keysViewState.updateKeyCommentServerState;
        }
        Resource.Status status6 = status2;
        if ((i & 4) != 0) {
            status3 = keysViewState.lockUnlockKeyServerState;
        }
        Resource.Status status7 = status3;
        if ((i & 8) != 0) {
            status4 = keysViewState.deleteKeyServerState;
        }
        Resource.Status status8 = status4;
        if ((i & 16) != 0) {
            status5 = keysViewState.createKeyServerState;
        }
        Resource.Status status9 = status5;
        if ((i & 32) != 0) {
            str = keysViewState.createKeyServerResponse;
        }
        String str2 = str;
        if ((i & 64) != 0) {
            event = keysViewState.keys;
        }
        return keysViewState.copy(status, status6, status7, status8, status9, str2, event);
    }

    public final KeysViewState copy(Resource.Status serverState, Resource.Status updateKeyCommentServerState, Resource.Status lockUnlockKeyServerState, Resource.Status deleteKeyServerState, Resource.Status createKeyServerState, String createKeyServerResponse, Event<? extends List<PhysicalKey>> keys) {
        Intrinsics.checkNotNullParameter(serverState, "serverState");
        Intrinsics.checkNotNullParameter(updateKeyCommentServerState, "updateKeyCommentServerState");
        Intrinsics.checkNotNullParameter(lockUnlockKeyServerState, "lockUnlockKeyServerState");
        Intrinsics.checkNotNullParameter(deleteKeyServerState, "deleteKeyServerState");
        Intrinsics.checkNotNullParameter(createKeyServerState, "createKeyServerState");
        Intrinsics.checkNotNullParameter(createKeyServerResponse, "createKeyServerResponse");
        Intrinsics.checkNotNullParameter(keys, "keys");
        return new KeysViewState(serverState, updateKeyCommentServerState, lockUnlockKeyServerState, deleteKeyServerState, createKeyServerState, createKeyServerResponse, keys);
    }

    public boolean equals(Object other) {
        if (this == other) {
            return true;
        }
        if (!(other instanceof KeysViewState)) {
            return false;
        }
        KeysViewState keysViewState = (KeysViewState) other;
        return this.serverState == keysViewState.serverState && this.updateKeyCommentServerState == keysViewState.updateKeyCommentServerState && this.lockUnlockKeyServerState == keysViewState.lockUnlockKeyServerState && this.deleteKeyServerState == keysViewState.deleteKeyServerState && this.createKeyServerState == keysViewState.createKeyServerState && Intrinsics.areEqual(this.createKeyServerResponse, keysViewState.createKeyServerResponse) && Intrinsics.areEqual(this.keys, keysViewState.keys);
    }

    public int hashCode() {
        return (((((((((((this.serverState.hashCode() * 31) + this.updateKeyCommentServerState.hashCode()) * 31) + this.lockUnlockKeyServerState.hashCode()) * 31) + this.deleteKeyServerState.hashCode()) * 31) + this.createKeyServerState.hashCode()) * 31) + this.createKeyServerResponse.hashCode()) * 31) + this.keys.hashCode();
    }

    public String toString() {
        return "KeysViewState(serverState=" + this.serverState + ", updateKeyCommentServerState=" + this.updateKeyCommentServerState + ", lockUnlockKeyServerState=" + this.lockUnlockKeyServerState + ", deleteKeyServerState=" + this.deleteKeyServerState + ", createKeyServerState=" + this.createKeyServerState + ", createKeyServerResponse=" + this.createKeyServerResponse + ", keys=" + this.keys + ")";
    }

    /* JADX WARN: Multi-variable type inference failed */
    public KeysViewState(Resource.Status serverState, Resource.Status updateKeyCommentServerState, Resource.Status lockUnlockKeyServerState, Resource.Status deleteKeyServerState, Resource.Status createKeyServerState, String createKeyServerResponse, Event<? extends List<PhysicalKey>> keys) {
        Intrinsics.checkNotNullParameter(serverState, "serverState");
        Intrinsics.checkNotNullParameter(updateKeyCommentServerState, "updateKeyCommentServerState");
        Intrinsics.checkNotNullParameter(lockUnlockKeyServerState, "lockUnlockKeyServerState");
        Intrinsics.checkNotNullParameter(deleteKeyServerState, "deleteKeyServerState");
        Intrinsics.checkNotNullParameter(createKeyServerState, "createKeyServerState");
        Intrinsics.checkNotNullParameter(createKeyServerResponse, "createKeyServerResponse");
        Intrinsics.checkNotNullParameter(keys, "keys");
        this.serverState = serverState;
        this.updateKeyCommentServerState = updateKeyCommentServerState;
        this.lockUnlockKeyServerState = lockUnlockKeyServerState;
        this.deleteKeyServerState = deleteKeyServerState;
        this.createKeyServerState = createKeyServerState;
        this.createKeyServerResponse = createKeyServerResponse;
        this.keys = keys;
    }

    public /* synthetic */ KeysViewState(Resource.Status status, Resource.Status status2, Resource.Status status3, Resource.Status status4, Resource.Status status5, String str, Event event, int i, DefaultConstructorMarker defaultConstructorMarker) {
        this((i & 1) != 0 ? Resource.Status.NONE : status, (i & 2) != 0 ? Resource.Status.NONE : status2, (i & 4) != 0 ? Resource.Status.NONE : status3, (i & 8) != 0 ? Resource.Status.NONE : status4, (i & 16) != 0 ? Resource.Status.NONE : status5, (i & 32) != 0 ? "" : str, (i & 64) != 0 ? new Event(CollectionsKt.emptyList()) : event);
    }

    public final Resource.Status getServerState() {
        return this.serverState;
    }

    public final Resource.Status getUpdateKeyCommentServerState() {
        return this.updateKeyCommentServerState;
    }

    public final Resource.Status getLockUnlockKeyServerState() {
        return this.lockUnlockKeyServerState;
    }

    public final Resource.Status getDeleteKeyServerState() {
        return this.deleteKeyServerState;
    }

    public final Resource.Status getCreateKeyServerState() {
        return this.createKeyServerState;
    }

    public final String getCreateKeyServerResponse() {
        return this.createKeyServerResponse;
    }

    public final Event<List<PhysicalKey>> getKeys() {
        return this.keys;
    }
}

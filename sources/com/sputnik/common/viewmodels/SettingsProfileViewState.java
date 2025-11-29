package com.sputnik.common.viewmodels;

import com.google.android.gms.measurement.api.AppMeasurementSdk;
import com.sputnik.common.base.VMState;
import com.sputnik.domain.common.Event;
import com.sputnik.domain.common.Resource;
import kotlin.Metadata;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;

/* compiled from: SettingsProfileViewModel.kt */
@Metadata(d1 = {"\u00008\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0010\u000b\n\u0002\b\u0007\n\u0002\u0010\b\n\u0002\b\u0002\n\u0002\u0010\u0000\n\u0002\b\u000f\b\u0086\b\u0018\u00002\u00020\u0001BC\u0012\b\b\u0002\u0010\u0003\u001a\u00020\u0002\u0012\n\b\u0002\u0010\u0005\u001a\u0004\u0018\u00010\u0004\u0012\n\b\u0002\u0010\u0006\u001a\u0004\u0018\u00010\u0004\u0012\b\b\u0002\u0010\b\u001a\u00020\u0007\u0012\u000e\b\u0002\u0010\u000b\u001a\b\u0012\u0004\u0012\u00020\n0\t¢\u0006\u0004\b\f\u0010\rJL\u0010\u000e\u001a\u00020\u00002\b\b\u0002\u0010\u0003\u001a\u00020\u00022\n\b\u0002\u0010\u0005\u001a\u0004\u0018\u00010\u00042\n\b\u0002\u0010\u0006\u001a\u0004\u0018\u00010\u00042\b\b\u0002\u0010\b\u001a\u00020\u00072\u000e\b\u0002\u0010\u000b\u001a\b\u0012\u0004\u0012\u00020\n0\tHÆ\u0001¢\u0006\u0004\b\u000e\u0010\u000fJ\u0010\u0010\u0010\u001a\u00020\u0004HÖ\u0001¢\u0006\u0004\b\u0010\u0010\u0011J\u0010\u0010\u0013\u001a\u00020\u0012HÖ\u0001¢\u0006\u0004\b\u0013\u0010\u0014J\u001a\u0010\u0017\u001a\u00020\n2\b\u0010\u0016\u001a\u0004\u0018\u00010\u0015HÖ\u0003¢\u0006\u0004\b\u0017\u0010\u0018R\u0017\u0010\u0003\u001a\u00020\u00028\u0006¢\u0006\f\n\u0004\b\u0003\u0010\u0019\u001a\u0004\b\u001a\u0010\u001bR\u0019\u0010\u0005\u001a\u0004\u0018\u00010\u00048\u0006¢\u0006\f\n\u0004\b\u0005\u0010\u001c\u001a\u0004\b\u001d\u0010\u0011R\u0019\u0010\u0006\u001a\u0004\u0018\u00010\u00048\u0006¢\u0006\f\n\u0004\b\u0006\u0010\u001c\u001a\u0004\b\u001e\u0010\u0011R\u0017\u0010\b\u001a\u00020\u00078\u0006¢\u0006\f\n\u0004\b\b\u0010\u001f\u001a\u0004\b \u0010!R\u001d\u0010\u000b\u001a\b\u0012\u0004\u0012\u00020\n0\t8\u0006¢\u0006\f\n\u0004\b\u000b\u0010\"\u001a\u0004\b\u000b\u0010#¨\u0006$"}, d2 = {"Lcom/sputnik/common/viewmodels/SettingsProfileViewState;", "Lcom/sputnik/common/base/VMState;", "Lcom/sputnik/domain/common/Resource$Status;", "serverState", "", AppMeasurementSdk.ConditionalUserProperty.NAME, "avatar", "Lcom/sputnik/common/viewmodels/EditModeData;", "editMode", "Lcom/sputnik/domain/common/Event;", "", "isSavedData", "<init>", "(Lcom/sputnik/domain/common/Resource$Status;Ljava/lang/String;Ljava/lang/String;Lcom/sputnik/common/viewmodels/EditModeData;Lcom/sputnik/domain/common/Event;)V", "copy", "(Lcom/sputnik/domain/common/Resource$Status;Ljava/lang/String;Ljava/lang/String;Lcom/sputnik/common/viewmodels/EditModeData;Lcom/sputnik/domain/common/Event;)Lcom/sputnik/common/viewmodels/SettingsProfileViewState;", "toString", "()Ljava/lang/String;", "", "hashCode", "()I", "", "other", "equals", "(Ljava/lang/Object;)Z", "Lcom/sputnik/domain/common/Resource$Status;", "getServerState", "()Lcom/sputnik/domain/common/Resource$Status;", "Ljava/lang/String;", "getName", "getAvatar", "Lcom/sputnik/common/viewmodels/EditModeData;", "getEditMode", "()Lcom/sputnik/common/viewmodels/EditModeData;", "Lcom/sputnik/domain/common/Event;", "()Lcom/sputnik/domain/common/Event;", "common_release"}, k = 1, mv = {1, 9, 0}, xi = 48)
/* loaded from: classes3.dex */
public final /* data */ class SettingsProfileViewState implements VMState {
    private final String avatar;
    private final EditModeData editMode;
    private final Event<Boolean> isSavedData;
    private final String name;
    private final Resource.Status serverState;

    public SettingsProfileViewState() {
        this(null, null, null, null, null, 31, null);
    }

    public static /* synthetic */ SettingsProfileViewState copy$default(SettingsProfileViewState settingsProfileViewState, Resource.Status status, String str, String str2, EditModeData editModeData, Event event, int i, Object obj) {
        if ((i & 1) != 0) {
            status = settingsProfileViewState.serverState;
        }
        if ((i & 2) != 0) {
            str = settingsProfileViewState.name;
        }
        String str3 = str;
        if ((i & 4) != 0) {
            str2 = settingsProfileViewState.avatar;
        }
        String str4 = str2;
        if ((i & 8) != 0) {
            editModeData = settingsProfileViewState.editMode;
        }
        EditModeData editModeData2 = editModeData;
        if ((i & 16) != 0) {
            event = settingsProfileViewState.isSavedData;
        }
        return settingsProfileViewState.copy(status, str3, str4, editModeData2, event);
    }

    public final SettingsProfileViewState copy(Resource.Status serverState, String name, String avatar, EditModeData editMode, Event<Boolean> isSavedData) {
        Intrinsics.checkNotNullParameter(serverState, "serverState");
        Intrinsics.checkNotNullParameter(editMode, "editMode");
        Intrinsics.checkNotNullParameter(isSavedData, "isSavedData");
        return new SettingsProfileViewState(serverState, name, avatar, editMode, isSavedData);
    }

    public boolean equals(Object other) {
        if (this == other) {
            return true;
        }
        if (!(other instanceof SettingsProfileViewState)) {
            return false;
        }
        SettingsProfileViewState settingsProfileViewState = (SettingsProfileViewState) other;
        return this.serverState == settingsProfileViewState.serverState && Intrinsics.areEqual(this.name, settingsProfileViewState.name) && Intrinsics.areEqual(this.avatar, settingsProfileViewState.avatar) && Intrinsics.areEqual(this.editMode, settingsProfileViewState.editMode) && Intrinsics.areEqual(this.isSavedData, settingsProfileViewState.isSavedData);
    }

    public int hashCode() {
        int iHashCode = this.serverState.hashCode() * 31;
        String str = this.name;
        int iHashCode2 = (iHashCode + (str == null ? 0 : str.hashCode())) * 31;
        String str2 = this.avatar;
        return ((((iHashCode2 + (str2 != null ? str2.hashCode() : 0)) * 31) + this.editMode.hashCode()) * 31) + this.isSavedData.hashCode();
    }

    public String toString() {
        return "SettingsProfileViewState(serverState=" + this.serverState + ", name=" + this.name + ", avatar=" + this.avatar + ", editMode=" + this.editMode + ", isSavedData=" + this.isSavedData + ")";
    }

    public SettingsProfileViewState(Resource.Status serverState, String str, String str2, EditModeData editMode, Event<Boolean> isSavedData) {
        Intrinsics.checkNotNullParameter(serverState, "serverState");
        Intrinsics.checkNotNullParameter(editMode, "editMode");
        Intrinsics.checkNotNullParameter(isSavedData, "isSavedData");
        this.serverState = serverState;
        this.name = str;
        this.avatar = str2;
        this.editMode = editMode;
        this.isSavedData = isSavedData;
    }

    public /* synthetic */ SettingsProfileViewState(Resource.Status status, String str, String str2, EditModeData editModeData, Event event, int i, DefaultConstructorMarker defaultConstructorMarker) {
        this((i & 1) != 0 ? Resource.Status.NONE : status, (i & 2) != 0 ? null : str, (i & 4) != 0 ? null : str2, (i & 8) != 0 ? new EditModeData(false, false, 3, null) : editModeData, (i & 16) != 0 ? new Event(Boolean.FALSE) : event);
    }

    public final String getName() {
        return this.name;
    }

    public final String getAvatar() {
        return this.avatar;
    }

    public final EditModeData getEditMode() {
        return this.editMode;
    }

    public final Event<Boolean> isSavedData() {
        return this.isSavedData;
    }
}

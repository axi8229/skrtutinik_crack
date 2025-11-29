package com.sputnik.common.viewmodels;

import kotlin.Metadata;
import kotlin.jvm.internal.DefaultConstructorMarker;

/* compiled from: ProfileViewModel.kt */
@Metadata(d1 = {"\u0000 \n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0010\u000b\n\u0002\b\u0006\n\u0002\u0010\u000e\n\u0002\b\u0002\n\u0002\u0010\b\n\u0002\b\u000b\b\u0086\b\u0018\u00002\u00020\u0001B\u001b\u0012\b\b\u0002\u0010\u0003\u001a\u00020\u0002\u0012\b\b\u0002\u0010\u0004\u001a\u00020\u0002¢\u0006\u0004\b\u0005\u0010\u0006J$\u0010\u0007\u001a\u00020\u00002\b\b\u0002\u0010\u0003\u001a\u00020\u00022\b\b\u0002\u0010\u0004\u001a\u00020\u0002HÆ\u0001¢\u0006\u0004\b\u0007\u0010\bJ\u0010\u0010\n\u001a\u00020\tHÖ\u0001¢\u0006\u0004\b\n\u0010\u000bJ\u0010\u0010\r\u001a\u00020\fHÖ\u0001¢\u0006\u0004\b\r\u0010\u000eJ\u001a\u0010\u0010\u001a\u00020\u00022\b\u0010\u000f\u001a\u0004\u0018\u00010\u0001HÖ\u0003¢\u0006\u0004\b\u0010\u0010\u0011R\u0017\u0010\u0003\u001a\u00020\u00028\u0006¢\u0006\f\n\u0004\b\u0003\u0010\u0012\u001a\u0004\b\u0013\u0010\u0014R\u0017\u0010\u0004\u001a\u00020\u00028\u0006¢\u0006\f\n\u0004\b\u0004\u0010\u0012\u001a\u0004\b\u0015\u0010\u0014R\u0011\u0010\u0016\u001a\u00020\u00028F¢\u0006\u0006\u001a\u0004\b\u0016\u0010\u0014¨\u0006\u0017"}, d2 = {"Lcom/sputnik/common/viewmodels/EditModeData;", "", "", "editName", "editSurname", "<init>", "(ZZ)V", "copy", "(ZZ)Lcom/sputnik/common/viewmodels/EditModeData;", "", "toString", "()Ljava/lang/String;", "", "hashCode", "()I", "other", "equals", "(Ljava/lang/Object;)Z", "Z", "getEditName", "()Z", "getEditSurname", "isEditMode", "common_release"}, k = 1, mv = {1, 9, 0}, xi = 48)
/* loaded from: classes3.dex */
public final /* data */ class EditModeData {
    private final boolean editName;
    private final boolean editSurname;

    /* JADX WARN: Illegal instructions before constructor call */
    public EditModeData() {
        boolean z = false;
        this(z, z, 3, null);
    }

    public static /* synthetic */ EditModeData copy$default(EditModeData editModeData, boolean z, boolean z2, int i, Object obj) {
        if ((i & 1) != 0) {
            z = editModeData.editName;
        }
        if ((i & 2) != 0) {
            z2 = editModeData.editSurname;
        }
        return editModeData.copy(z, z2);
    }

    public final EditModeData copy(boolean editName, boolean editSurname) {
        return new EditModeData(editName, editSurname);
    }

    public boolean equals(Object other) {
        if (this == other) {
            return true;
        }
        if (!(other instanceof EditModeData)) {
            return false;
        }
        EditModeData editModeData = (EditModeData) other;
        return this.editName == editModeData.editName && this.editSurname == editModeData.editSurname;
    }

    /* JADX WARN: Multi-variable type inference failed */
    /* JADX WARN: Type inference failed for: r0v1, types: [int] */
    /* JADX WARN: Type inference failed for: r0v4 */
    /* JADX WARN: Type inference failed for: r0v5 */
    public int hashCode() {
        boolean z = this.editName;
        ?? r0 = z;
        if (z) {
            r0 = 1;
        }
        int i = r0 * 31;
        boolean z2 = this.editSurname;
        return i + (z2 ? 1 : z2 ? 1 : 0);
    }

    public String toString() {
        return "EditModeData(editName=" + this.editName + ", editSurname=" + this.editSurname + ")";
    }

    public EditModeData(boolean z, boolean z2) {
        this.editName = z;
        this.editSurname = z2;
    }

    public /* synthetic */ EditModeData(boolean z, boolean z2, int i, DefaultConstructorMarker defaultConstructorMarker) {
        this((i & 1) != 0 ? false : z, (i & 2) != 0 ? false : z2);
    }

    public final boolean isEditMode() {
        return this.editName || this.editSurname;
    }
}

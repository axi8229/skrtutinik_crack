package com.sputnik.common.entities.popup;

import android.os.Parcel;
import android.os.Parcelable;
import kotlin.Metadata;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;

/* compiled from: PopupStory.kt */
@Metadata(d1 = {"\u0000F\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\t\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000b\n\u0002\b\u0003\n\u0002\u0010\u000e\n\u0002\b\u0002\n\u0002\u0010\b\n\u0002\b\u0002\n\u0002\u0010\u0000\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u0002\n\u0002\b\u000f\b\u0087\b\u0018\u00002\u00020\u0001B)\u0012\u0006\u0010\u0003\u001a\u00020\u0002\u0012\u0006\u0010\u0004\u001a\u00020\u0002\u0012\u0006\u0010\u0006\u001a\u00020\u0005\u0012\b\b\u0002\u0010\b\u001a\u00020\u0007¢\u0006\u0004\b\t\u0010\nJ\u0010\u0010\f\u001a\u00020\u000bHÖ\u0001¢\u0006\u0004\b\f\u0010\rJ\u0010\u0010\u000f\u001a\u00020\u000eHÖ\u0001¢\u0006\u0004\b\u000f\u0010\u0010J\u001a\u0010\u0013\u001a\u00020\u00072\b\u0010\u0012\u001a\u0004\u0018\u00010\u0011HÖ\u0003¢\u0006\u0004\b\u0013\u0010\u0014J\u0010\u0010\u0015\u001a\u00020\u000eHÖ\u0001¢\u0006\u0004\b\u0015\u0010\u0010J \u0010\u001a\u001a\u00020\u00192\u0006\u0010\u0017\u001a\u00020\u00162\u0006\u0010\u0018\u001a\u00020\u000eHÖ\u0001¢\u0006\u0004\b\u001a\u0010\u001bR\u0017\u0010\u0003\u001a\u00020\u00028\u0006¢\u0006\f\n\u0004\b\u0003\u0010\u001c\u001a\u0004\b\u001d\u0010\u001eR\u0017\u0010\u0004\u001a\u00020\u00028\u0006¢\u0006\f\n\u0004\b\u0004\u0010\u001c\u001a\u0004\b\u001f\u0010\u001eR\u0017\u0010\u0006\u001a\u00020\u00058\u0006¢\u0006\f\n\u0004\b\u0006\u0010 \u001a\u0004\b!\u0010\"R\"\u0010\b\u001a\u00020\u00078\u0006@\u0006X\u0086\u000e¢\u0006\u0012\n\u0004\b\b\u0010#\u001a\u0004\b$\u0010%\"\u0004\b&\u0010'¨\u0006("}, d2 = {"Lcom/sputnik/common/entities/popup/PopupStory;", "Landroid/os/Parcelable;", "", "id", "order", "Lcom/sputnik/common/entities/popup/Appearance;", "appearance", "", "showed", "<init>", "(JJLcom/sputnik/common/entities/popup/Appearance;Z)V", "", "toString", "()Ljava/lang/String;", "", "hashCode", "()I", "", "other", "equals", "(Ljava/lang/Object;)Z", "describeContents", "Landroid/os/Parcel;", "parcel", "flags", "", "writeToParcel", "(Landroid/os/Parcel;I)V", "J", "getId", "()J", "getOrder", "Lcom/sputnik/common/entities/popup/Appearance;", "getAppearance", "()Lcom/sputnik/common/entities/popup/Appearance;", "Z", "getShowed", "()Z", "setShowed", "(Z)V", "common_release"}, k = 1, mv = {1, 9, 0}, xi = 48)
/* loaded from: classes3.dex */
public final /* data */ class PopupStory implements Parcelable {
    public static final Parcelable.Creator<PopupStory> CREATOR = new Creator();
    private final Appearance appearance;
    private final long id;
    private final long order;
    private boolean showed;

    /* compiled from: PopupStory.kt */
    @Metadata(k = 3, mv = {1, 9, 0}, xi = 48)
    public static final class Creator implements Parcelable.Creator<PopupStory> {
        /* JADX WARN: Can't rename method to resolve collision */
        @Override // android.os.Parcelable.Creator
        public final PopupStory createFromParcel(Parcel parcel) {
            Intrinsics.checkNotNullParameter(parcel, "parcel");
            return new PopupStory(parcel.readLong(), parcel.readLong(), Appearance.CREATOR.createFromParcel(parcel), parcel.readInt() != 0);
        }

        /* JADX WARN: Can't rename method to resolve collision */
        @Override // android.os.Parcelable.Creator
        public final PopupStory[] newArray(int i) {
            return new PopupStory[i];
        }
    }

    @Override // android.os.Parcelable
    public int describeContents() {
        return 0;
    }

    public boolean equals(Object other) {
        if (this == other) {
            return true;
        }
        if (!(other instanceof PopupStory)) {
            return false;
        }
        PopupStory popupStory = (PopupStory) other;
        return this.id == popupStory.id && this.order == popupStory.order && Intrinsics.areEqual(this.appearance, popupStory.appearance) && this.showed == popupStory.showed;
    }

    /* JADX WARN: Multi-variable type inference failed */
    public int hashCode() {
        int iHashCode = ((((Long.hashCode(this.id) * 31) + Long.hashCode(this.order)) * 31) + this.appearance.hashCode()) * 31;
        boolean z = this.showed;
        int i = z;
        if (z != 0) {
            i = 1;
        }
        return iHashCode + i;
    }

    public String toString() {
        return "PopupStory(id=" + this.id + ", order=" + this.order + ", appearance=" + this.appearance + ", showed=" + this.showed + ")";
    }

    @Override // android.os.Parcelable
    public void writeToParcel(Parcel parcel, int flags) {
        Intrinsics.checkNotNullParameter(parcel, "out");
        parcel.writeLong(this.id);
        parcel.writeLong(this.order);
        this.appearance.writeToParcel(parcel, flags);
        parcel.writeInt(this.showed ? 1 : 0);
    }

    public PopupStory(long j, long j2, Appearance appearance, boolean z) {
        Intrinsics.checkNotNullParameter(appearance, "appearance");
        this.id = j;
        this.order = j2;
        this.appearance = appearance;
        this.showed = z;
    }

    public /* synthetic */ PopupStory(long j, long j2, Appearance appearance, boolean z, int i, DefaultConstructorMarker defaultConstructorMarker) {
        this(j, j2, appearance, (i & 8) != 0 ? false : z);
    }

    public final long getId() {
        return this.id;
    }

    public final Appearance getAppearance() {
        return this.appearance;
    }

    public final boolean getShowed() {
        return this.showed;
    }

    public final void setShowed(boolean z) {
        this.showed = z;
    }
}

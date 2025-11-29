package com.sputnik.data.entities.popups;

import android.os.Parcel;
import android.os.Parcelable;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

/* compiled from: DataPopupStory.kt */
@Metadata(d1 = {"\u0000F\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\t\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u000e\n\u0002\b\u0002\n\u0002\u0010\b\n\u0002\b\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\u000b\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u0002\n\u0002\b\n\b\u0087\b\u0018\u00002\u00020\u0001B\u001f\u0012\u0006\u0010\u0003\u001a\u00020\u0002\u0012\u0006\u0010\u0004\u001a\u00020\u0002\u0012\u0006\u0010\u0006\u001a\u00020\u0005¢\u0006\u0004\b\u0007\u0010\bJ\u0010\u0010\n\u001a\u00020\tHÖ\u0001¢\u0006\u0004\b\n\u0010\u000bJ\u0010\u0010\r\u001a\u00020\fHÖ\u0001¢\u0006\u0004\b\r\u0010\u000eJ\u001a\u0010\u0012\u001a\u00020\u00112\b\u0010\u0010\u001a\u0004\u0018\u00010\u000fHÖ\u0003¢\u0006\u0004\b\u0012\u0010\u0013J\u0010\u0010\u0014\u001a\u00020\fHÖ\u0001¢\u0006\u0004\b\u0014\u0010\u000eJ \u0010\u0019\u001a\u00020\u00182\u0006\u0010\u0016\u001a\u00020\u00152\u0006\u0010\u0017\u001a\u00020\fHÖ\u0001¢\u0006\u0004\b\u0019\u0010\u001aR\u0017\u0010\u0003\u001a\u00020\u00028\u0006¢\u0006\f\n\u0004\b\u0003\u0010\u001b\u001a\u0004\b\u001c\u0010\u001dR\u0017\u0010\u0004\u001a\u00020\u00028\u0006¢\u0006\f\n\u0004\b\u0004\u0010\u001b\u001a\u0004\b\u001e\u0010\u001dR\u0017\u0010\u0006\u001a\u00020\u00058\u0006¢\u0006\f\n\u0004\b\u0006\u0010\u001f\u001a\u0004\b \u0010!¨\u0006\""}, d2 = {"Lcom/sputnik/data/entities/popups/DataPopupStory;", "Landroid/os/Parcelable;", "", "id", "order", "Lcom/sputnik/data/entities/popups/DataAppearance;", "appearance", "<init>", "(JJLcom/sputnik/data/entities/popups/DataAppearance;)V", "", "toString", "()Ljava/lang/String;", "", "hashCode", "()I", "", "other", "", "equals", "(Ljava/lang/Object;)Z", "describeContents", "Landroid/os/Parcel;", "parcel", "flags", "", "writeToParcel", "(Landroid/os/Parcel;I)V", "J", "getId", "()J", "getOrder", "Lcom/sputnik/data/entities/popups/DataAppearance;", "getAppearance", "()Lcom/sputnik/data/entities/popups/DataAppearance;", "data_release"}, k = 1, mv = {1, 9, 0}, xi = 48)
/* loaded from: classes3.dex */
public final /* data */ class DataPopupStory implements Parcelable {
    public static final Parcelable.Creator<DataPopupStory> CREATOR = new Creator();
    private final DataAppearance appearance;
    private final long id;
    private final long order;

    /* compiled from: DataPopupStory.kt */
    @Metadata(k = 3, mv = {1, 9, 0}, xi = 48)
    public static final class Creator implements Parcelable.Creator<DataPopupStory> {
        /* JADX WARN: Can't rename method to resolve collision */
        @Override // android.os.Parcelable.Creator
        public final DataPopupStory createFromParcel(Parcel parcel) {
            Intrinsics.checkNotNullParameter(parcel, "parcel");
            return new DataPopupStory(parcel.readLong(), parcel.readLong(), DataAppearance.CREATOR.createFromParcel(parcel));
        }

        /* JADX WARN: Can't rename method to resolve collision */
        @Override // android.os.Parcelable.Creator
        public final DataPopupStory[] newArray(int i) {
            return new DataPopupStory[i];
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
        if (!(other instanceof DataPopupStory)) {
            return false;
        }
        DataPopupStory dataPopupStory = (DataPopupStory) other;
        return this.id == dataPopupStory.id && this.order == dataPopupStory.order && Intrinsics.areEqual(this.appearance, dataPopupStory.appearance);
    }

    public int hashCode() {
        return (((Long.hashCode(this.id) * 31) + Long.hashCode(this.order)) * 31) + this.appearance.hashCode();
    }

    public String toString() {
        return "DataPopupStory(id=" + this.id + ", order=" + this.order + ", appearance=" + this.appearance + ")";
    }

    @Override // android.os.Parcelable
    public void writeToParcel(Parcel parcel, int flags) {
        Intrinsics.checkNotNullParameter(parcel, "out");
        parcel.writeLong(this.id);
        parcel.writeLong(this.order);
        this.appearance.writeToParcel(parcel, flags);
    }

    public DataPopupStory(long j, long j2, DataAppearance appearance) {
        Intrinsics.checkNotNullParameter(appearance, "appearance");
        this.id = j;
        this.order = j2;
        this.appearance = appearance;
    }

    public final long getId() {
        return this.id;
    }

    public final long getOrder() {
        return this.order;
    }

    public final DataAppearance getAppearance() {
        return this.appearance;
    }
}

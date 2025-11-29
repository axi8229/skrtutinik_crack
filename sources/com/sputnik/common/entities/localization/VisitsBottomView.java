package com.sputnik.common.entities.localization;

import android.os.Parcel;
import android.os.Parcelable;
import com.google.gson.annotations.SerializedName;
import kotlin.Metadata;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;

/* compiled from: LocalizationModel.kt */
@Metadata(d1 = {"\u0000D\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u000e\n\u0002\b\u0002\n\u0002\u0010\b\n\u0002\b\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\u000b\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u0002\n\u0002\b\t\b\u0087\b\u0018\u00002\u00020\u0001B\u001f\u0012\n\b\u0002\u0010\u0003\u001a\u0004\u0018\u00010\u0002\u0012\n\b\u0002\u0010\u0005\u001a\u0004\u0018\u00010\u0004¢\u0006\u0004\b\u0006\u0010\u0007J\u0010\u0010\t\u001a\u00020\bHÖ\u0001¢\u0006\u0004\b\t\u0010\nJ\u0010\u0010\f\u001a\u00020\u000bHÖ\u0001¢\u0006\u0004\b\f\u0010\rJ\u001a\u0010\u0011\u001a\u00020\u00102\b\u0010\u000f\u001a\u0004\u0018\u00010\u000eHÖ\u0003¢\u0006\u0004\b\u0011\u0010\u0012J\u0010\u0010\u0013\u001a\u00020\u000bHÖ\u0001¢\u0006\u0004\b\u0013\u0010\rJ \u0010\u0018\u001a\u00020\u00172\u0006\u0010\u0015\u001a\u00020\u00142\u0006\u0010\u0016\u001a\u00020\u000bHÖ\u0001¢\u0006\u0004\b\u0018\u0010\u0019R\u001c\u0010\u0003\u001a\u0004\u0018\u00010\u00028\u0006X\u0087\u0004¢\u0006\f\n\u0004\b\u0003\u0010\u001a\u001a\u0004\b\u001b\u0010\u001cR\u001c\u0010\u0005\u001a\u0004\u0018\u00010\u00048\u0006X\u0087\u0004¢\u0006\f\n\u0004\b\u0005\u0010\u001d\u001a\u0004\b\u001e\u0010\u001f¨\u0006 "}, d2 = {"Lcom/sputnik/common/entities/localization/VisitsBottomView;", "Landroid/os/Parcelable;", "Lcom/sputnik/common/entities/localization/VisitsArcAvailable;", "archiveAvailable", "Lcom/sputnik/common/entities/localization/VisitsArcUnavailable;", "archiveUnavailable", "<init>", "(Lcom/sputnik/common/entities/localization/VisitsArcAvailable;Lcom/sputnik/common/entities/localization/VisitsArcUnavailable;)V", "", "toString", "()Ljava/lang/String;", "", "hashCode", "()I", "", "other", "", "equals", "(Ljava/lang/Object;)Z", "describeContents", "Landroid/os/Parcel;", "parcel", "flags", "", "writeToParcel", "(Landroid/os/Parcel;I)V", "Lcom/sputnik/common/entities/localization/VisitsArcAvailable;", "getArchiveAvailable", "()Lcom/sputnik/common/entities/localization/VisitsArcAvailable;", "Lcom/sputnik/common/entities/localization/VisitsArcUnavailable;", "getArchiveUnavailable", "()Lcom/sputnik/common/entities/localization/VisitsArcUnavailable;", "common_release"}, k = 1, mv = {1, 9, 0}, xi = 48)
/* loaded from: classes3.dex */
public final /* data */ class VisitsBottomView implements Parcelable {
    public static final Parcelable.Creator<VisitsBottomView> CREATOR = new Creator();

    @SerializedName("arhive_available")
    private final VisitsArcAvailable archiveAvailable;

    @SerializedName("arhive_unavailable")
    private final VisitsArcUnavailable archiveUnavailable;

    /* compiled from: LocalizationModel.kt */
    @Metadata(k = 3, mv = {1, 9, 0}, xi = 48)
    public static final class Creator implements Parcelable.Creator<VisitsBottomView> {
        /* JADX WARN: Can't rename method to resolve collision */
        @Override // android.os.Parcelable.Creator
        public final VisitsBottomView createFromParcel(Parcel parcel) {
            Intrinsics.checkNotNullParameter(parcel, "parcel");
            return new VisitsBottomView(parcel.readInt() == 0 ? null : VisitsArcAvailable.CREATOR.createFromParcel(parcel), parcel.readInt() != 0 ? VisitsArcUnavailable.CREATOR.createFromParcel(parcel) : null);
        }

        /* JADX WARN: Can't rename method to resolve collision */
        @Override // android.os.Parcelable.Creator
        public final VisitsBottomView[] newArray(int i) {
            return new VisitsBottomView[i];
        }
    }

    public VisitsBottomView() {
        this(null, 0 == true ? 1 : 0, 3, 0 == true ? 1 : 0);
    }

    @Override // android.os.Parcelable
    public int describeContents() {
        return 0;
    }

    public boolean equals(Object other) {
        if (this == other) {
            return true;
        }
        if (!(other instanceof VisitsBottomView)) {
            return false;
        }
        VisitsBottomView visitsBottomView = (VisitsBottomView) other;
        return Intrinsics.areEqual(this.archiveAvailable, visitsBottomView.archiveAvailable) && Intrinsics.areEqual(this.archiveUnavailable, visitsBottomView.archiveUnavailable);
    }

    public int hashCode() {
        VisitsArcAvailable visitsArcAvailable = this.archiveAvailable;
        int iHashCode = (visitsArcAvailable == null ? 0 : visitsArcAvailable.hashCode()) * 31;
        VisitsArcUnavailable visitsArcUnavailable = this.archiveUnavailable;
        return iHashCode + (visitsArcUnavailable != null ? visitsArcUnavailable.hashCode() : 0);
    }

    public String toString() {
        return "VisitsBottomView(archiveAvailable=" + this.archiveAvailable + ", archiveUnavailable=" + this.archiveUnavailable + ")";
    }

    @Override // android.os.Parcelable
    public void writeToParcel(Parcel parcel, int flags) {
        Intrinsics.checkNotNullParameter(parcel, "out");
        VisitsArcAvailable visitsArcAvailable = this.archiveAvailable;
        if (visitsArcAvailable == null) {
            parcel.writeInt(0);
        } else {
            parcel.writeInt(1);
            visitsArcAvailable.writeToParcel(parcel, flags);
        }
        VisitsArcUnavailable visitsArcUnavailable = this.archiveUnavailable;
        if (visitsArcUnavailable == null) {
            parcel.writeInt(0);
        } else {
            parcel.writeInt(1);
            visitsArcUnavailable.writeToParcel(parcel, flags);
        }
    }

    public VisitsBottomView(VisitsArcAvailable visitsArcAvailable, VisitsArcUnavailable visitsArcUnavailable) {
        this.archiveAvailable = visitsArcAvailable;
        this.archiveUnavailable = visitsArcUnavailable;
    }

    public /* synthetic */ VisitsBottomView(VisitsArcAvailable visitsArcAvailable, VisitsArcUnavailable visitsArcUnavailable, int i, DefaultConstructorMarker defaultConstructorMarker) {
        this((i & 1) != 0 ? null : visitsArcAvailable, (i & 2) != 0 ? null : visitsArcUnavailable);
    }

    public final VisitsArcAvailable getArchiveAvailable() {
        return this.archiveAvailable;
    }

    public final VisitsArcUnavailable getArchiveUnavailable() {
        return this.archiveUnavailable;
    }
}

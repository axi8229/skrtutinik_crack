package com.sputnik.data.entities.market;

import android.os.Parcel;
import android.os.Parcelable;
import com.sputnik.domain.entities.market.PlansDuration;
import flussonic.media.FFmpegMediaMetadataRetriever;
import kotlin.Metadata;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;

/* compiled from: DataPlans.kt */
@Metadata(d1 = {"\u0000@\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0007\n\u0002\u0010\u0000\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u0002\n\u0002\b\u0011\b\u0087\b\u0018\u00002\u00020\u0001BC\u0012\n\b\u0002\u0010\u0003\u001a\u0004\u0018\u00010\u0002\u0012\n\b\u0002\u0010\u0005\u001a\u0004\u0018\u00010\u0004\u0012\n\b\u0002\u0010\u0007\u001a\u0004\u0018\u00010\u0006\u0012\n\b\u0002\u0010\t\u001a\u0004\u0018\u00010\b\u0012\n\b\u0002\u0010\u000b\u001a\u0004\u0018\u00010\n¢\u0006\u0004\b\f\u0010\rJ\u0010\u0010\u000e\u001a\u00020\u0004HÖ\u0001¢\u0006\u0004\b\u000e\u0010\u000fJ\u0010\u0010\u0010\u001a\u00020\bHÖ\u0001¢\u0006\u0004\b\u0010\u0010\u0011J\u001a\u0010\u0014\u001a\u00020\u00022\b\u0010\u0013\u001a\u0004\u0018\u00010\u0012HÖ\u0003¢\u0006\u0004\b\u0014\u0010\u0015J\u0010\u0010\u0016\u001a\u00020\bHÖ\u0001¢\u0006\u0004\b\u0016\u0010\u0011J \u0010\u001b\u001a\u00020\u001a2\u0006\u0010\u0018\u001a\u00020\u00172\u0006\u0010\u0019\u001a\u00020\bHÖ\u0001¢\u0006\u0004\b\u001b\u0010\u001cR\u0019\u0010\u0003\u001a\u0004\u0018\u00010\u00028\u0006¢\u0006\f\n\u0004\b\u0003\u0010\u001d\u001a\u0004\b\u001e\u0010\u001fR\u0019\u0010\u0005\u001a\u0004\u0018\u00010\u00048\u0006¢\u0006\f\n\u0004\b\u0005\u0010 \u001a\u0004\b!\u0010\u000fR\u0019\u0010\u0007\u001a\u0004\u0018\u00010\u00068\u0006¢\u0006\f\n\u0004\b\u0007\u0010\"\u001a\u0004\b#\u0010$R\u0019\u0010\t\u001a\u0004\u0018\u00010\b8\u0006¢\u0006\f\n\u0004\b\t\u0010%\u001a\u0004\b&\u0010'R\u0019\u0010\u000b\u001a\u0004\u0018\u00010\n8\u0006¢\u0006\f\n\u0004\b\u000b\u0010(\u001a\u0004\b)\u0010*¨\u0006+"}, d2 = {"Lcom/sputnik/data/entities/market/DataPlans;", "Landroid/os/Parcelable;", "", "outdated", "", "identifier", "Lcom/sputnik/domain/entities/market/PlansDuration;", FFmpegMediaMetadataRetriever.METADATA_KEY_DURATION, "", "price", "Lcom/sputnik/data/entities/market/DataPlanAppearance;", "appearance", "<init>", "(Ljava/lang/Boolean;Ljava/lang/String;Lcom/sputnik/domain/entities/market/PlansDuration;Ljava/lang/Integer;Lcom/sputnik/data/entities/market/DataPlanAppearance;)V", "toString", "()Ljava/lang/String;", "hashCode", "()I", "", "other", "equals", "(Ljava/lang/Object;)Z", "describeContents", "Landroid/os/Parcel;", "parcel", "flags", "", "writeToParcel", "(Landroid/os/Parcel;I)V", "Ljava/lang/Boolean;", "getOutdated", "()Ljava/lang/Boolean;", "Ljava/lang/String;", "getIdentifier", "Lcom/sputnik/domain/entities/market/PlansDuration;", "getDuration", "()Lcom/sputnik/domain/entities/market/PlansDuration;", "Ljava/lang/Integer;", "getPrice", "()Ljava/lang/Integer;", "Lcom/sputnik/data/entities/market/DataPlanAppearance;", "getAppearance", "()Lcom/sputnik/data/entities/market/DataPlanAppearance;", "data_release"}, k = 1, mv = {1, 9, 0}, xi = 48)
/* loaded from: classes3.dex */
public final /* data */ class DataPlans implements Parcelable {
    public static final Parcelable.Creator<DataPlans> CREATOR = new Creator();
    private final DataPlanAppearance appearance;
    private final PlansDuration duration;
    private final String identifier;
    private final Boolean outdated;
    private final Integer price;

    /* compiled from: DataPlans.kt */
    @Metadata(k = 3, mv = {1, 9, 0}, xi = 48)
    public static final class Creator implements Parcelable.Creator<DataPlans> {
        /* JADX WARN: Can't rename method to resolve collision */
        @Override // android.os.Parcelable.Creator
        public final DataPlans createFromParcel(Parcel parcel) {
            Boolean boolValueOf;
            Intrinsics.checkNotNullParameter(parcel, "parcel");
            if (parcel.readInt() == 0) {
                boolValueOf = null;
            } else {
                boolValueOf = Boolean.valueOf(parcel.readInt() != 0);
            }
            return new DataPlans(boolValueOf, parcel.readString(), parcel.readInt() == 0 ? null : PlansDuration.valueOf(parcel.readString()), parcel.readInt() == 0 ? null : Integer.valueOf(parcel.readInt()), parcel.readInt() != 0 ? DataPlanAppearance.CREATOR.createFromParcel(parcel) : null);
        }

        /* JADX WARN: Can't rename method to resolve collision */
        @Override // android.os.Parcelable.Creator
        public final DataPlans[] newArray(int i) {
            return new DataPlans[i];
        }
    }

    public DataPlans() {
        this(null, null, null, null, null, 31, null);
    }

    @Override // android.os.Parcelable
    public int describeContents() {
        return 0;
    }

    public boolean equals(Object other) {
        if (this == other) {
            return true;
        }
        if (!(other instanceof DataPlans)) {
            return false;
        }
        DataPlans dataPlans = (DataPlans) other;
        return Intrinsics.areEqual(this.outdated, dataPlans.outdated) && Intrinsics.areEqual(this.identifier, dataPlans.identifier) && this.duration == dataPlans.duration && Intrinsics.areEqual(this.price, dataPlans.price) && Intrinsics.areEqual(this.appearance, dataPlans.appearance);
    }

    public int hashCode() {
        Boolean bool = this.outdated;
        int iHashCode = (bool == null ? 0 : bool.hashCode()) * 31;
        String str = this.identifier;
        int iHashCode2 = (iHashCode + (str == null ? 0 : str.hashCode())) * 31;
        PlansDuration plansDuration = this.duration;
        int iHashCode3 = (iHashCode2 + (plansDuration == null ? 0 : plansDuration.hashCode())) * 31;
        Integer num = this.price;
        int iHashCode4 = (iHashCode3 + (num == null ? 0 : num.hashCode())) * 31;
        DataPlanAppearance dataPlanAppearance = this.appearance;
        return iHashCode4 + (dataPlanAppearance != null ? dataPlanAppearance.hashCode() : 0);
    }

    public String toString() {
        return "DataPlans(outdated=" + this.outdated + ", identifier=" + this.identifier + ", duration=" + this.duration + ", price=" + this.price + ", appearance=" + this.appearance + ")";
    }

    @Override // android.os.Parcelable
    public void writeToParcel(Parcel parcel, int flags) {
        Intrinsics.checkNotNullParameter(parcel, "out");
        Boolean bool = this.outdated;
        if (bool == null) {
            parcel.writeInt(0);
        } else {
            parcel.writeInt(1);
            parcel.writeInt(bool.booleanValue() ? 1 : 0);
        }
        parcel.writeString(this.identifier);
        PlansDuration plansDuration = this.duration;
        if (plansDuration == null) {
            parcel.writeInt(0);
        } else {
            parcel.writeInt(1);
            parcel.writeString(plansDuration.name());
        }
        Integer num = this.price;
        if (num == null) {
            parcel.writeInt(0);
        } else {
            parcel.writeInt(1);
            parcel.writeInt(num.intValue());
        }
        DataPlanAppearance dataPlanAppearance = this.appearance;
        if (dataPlanAppearance == null) {
            parcel.writeInt(0);
        } else {
            parcel.writeInt(1);
            dataPlanAppearance.writeToParcel(parcel, flags);
        }
    }

    public DataPlans(Boolean bool, String str, PlansDuration plansDuration, Integer num, DataPlanAppearance dataPlanAppearance) {
        this.outdated = bool;
        this.identifier = str;
        this.duration = plansDuration;
        this.price = num;
        this.appearance = dataPlanAppearance;
    }

    public /* synthetic */ DataPlans(Boolean bool, String str, PlansDuration plansDuration, Integer num, DataPlanAppearance dataPlanAppearance, int i, DefaultConstructorMarker defaultConstructorMarker) {
        this((i & 1) != 0 ? null : bool, (i & 2) != 0 ? null : str, (i & 4) != 0 ? null : plansDuration, (i & 8) != 0 ? null : num, (i & 16) != 0 ? null : dataPlanAppearance);
    }

    public final Boolean getOutdated() {
        return this.outdated;
    }

    public final String getIdentifier() {
        return this.identifier;
    }

    public final PlansDuration getDuration() {
        return this.duration;
    }

    public final Integer getPrice() {
        return this.price;
    }

    public final DataPlanAppearance getAppearance() {
        return this.appearance;
    }
}

package com.sputnik.data.entities.market;

import android.os.Parcel;
import android.os.Parcelable;
import com.google.gson.annotations.SerializedName;
import com.sputnik.domain.entities.market.PlansDuration;
import flussonic.media.FFmpegMediaMetadataRetriever;
import kotlin.KotlinVersion;
import kotlin.Metadata;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;

/* compiled from: DataSubsPlans.kt */
@Metadata(d1 = {"\u0000<\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u000e\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0002\b\u0002\n\u0002\u0010\u000b\n\u0002\b\n\n\u0002\u0010\u0000\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u0002\n\u0002\b\u0012\b\u0087\b\u0018\u00002\u00020\u0001Bg\u0012\n\b\u0002\u0010\u0003\u001a\u0004\u0018\u00010\u0002\u0012\n\b\u0002\u0010\u0005\u001a\u0004\u0018\u00010\u0004\u0012\n\b\u0002\u0010\u0007\u001a\u0004\u0018\u00010\u0006\u0012\n\b\u0002\u0010\b\u001a\u0004\u0018\u00010\u0002\u0012\n\b\u0002\u0010\n\u001a\u0004\u0018\u00010\t\u0012\n\b\u0002\u0010\u000b\u001a\u0004\u0018\u00010\u0002\u0012\n\b\u0002\u0010\f\u001a\u0004\u0018\u00010\u0002\u0012\n\b\u0002\u0010\r\u001a\u0004\u0018\u00010\u0002¢\u0006\u0004\b\u000e\u0010\u000fJ\u0010\u0010\u0010\u001a\u00020\u0002HÖ\u0001¢\u0006\u0004\b\u0010\u0010\u0011J\u0010\u0010\u0012\u001a\u00020\u0006HÖ\u0001¢\u0006\u0004\b\u0012\u0010\u0013J\u001a\u0010\u0016\u001a\u00020\t2\b\u0010\u0015\u001a\u0004\u0018\u00010\u0014HÖ\u0003¢\u0006\u0004\b\u0016\u0010\u0017J\u0010\u0010\u0018\u001a\u00020\u0006HÖ\u0001¢\u0006\u0004\b\u0018\u0010\u0013J \u0010\u001d\u001a\u00020\u001c2\u0006\u0010\u001a\u001a\u00020\u00192\u0006\u0010\u001b\u001a\u00020\u0006HÖ\u0001¢\u0006\u0004\b\u001d\u0010\u001eR\u0019\u0010\u0003\u001a\u0004\u0018\u00010\u00028\u0006¢\u0006\f\n\u0004\b\u0003\u0010\u001f\u001a\u0004\b \u0010\u0011R\u0019\u0010\u0005\u001a\u0004\u0018\u00010\u00048\u0006¢\u0006\f\n\u0004\b\u0005\u0010!\u001a\u0004\b\"\u0010#R\u0019\u0010\u0007\u001a\u0004\u0018\u00010\u00068\u0006¢\u0006\f\n\u0004\b\u0007\u0010$\u001a\u0004\b%\u0010&R\u0019\u0010\b\u001a\u0004\u0018\u00010\u00028\u0006¢\u0006\f\n\u0004\b\b\u0010\u001f\u001a\u0004\b'\u0010\u0011R\u0019\u0010\n\u001a\u0004\u0018\u00010\t8\u0006¢\u0006\f\n\u0004\b\n\u0010(\u001a\u0004\b)\u0010*R\u001c\u0010\u000b\u001a\u0004\u0018\u00010\u00028\u0006X\u0087\u0004¢\u0006\f\n\u0004\b\u000b\u0010\u001f\u001a\u0004\b+\u0010\u0011R\u001c\u0010\f\u001a\u0004\u0018\u00010\u00028\u0006X\u0087\u0004¢\u0006\f\n\u0004\b\f\u0010\u001f\u001a\u0004\b,\u0010\u0011R\u001c\u0010\r\u001a\u0004\u0018\u00010\u00028\u0006X\u0087\u0004¢\u0006\f\n\u0004\b\r\u0010\u001f\u001a\u0004\b-\u0010\u0011¨\u0006."}, d2 = {"Lcom/sputnik/data/entities/market/DataSubsPlans;", "Landroid/os/Parcelable;", "", "identifier", "Lcom/sputnik/domain/entities/market/PlansDuration;", FFmpegMediaMetadataRetriever.METADATA_KEY_DURATION, "", "price", FFmpegMediaMetadataRetriever.METADATA_KEY_TITLE, "", "special", "specialDescription", "specialBadgeTitle", "priceVerbose", "<init>", "(Ljava/lang/String;Lcom/sputnik/domain/entities/market/PlansDuration;Ljava/lang/Integer;Ljava/lang/String;Ljava/lang/Boolean;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;)V", "toString", "()Ljava/lang/String;", "hashCode", "()I", "", "other", "equals", "(Ljava/lang/Object;)Z", "describeContents", "Landroid/os/Parcel;", "parcel", "flags", "", "writeToParcel", "(Landroid/os/Parcel;I)V", "Ljava/lang/String;", "getIdentifier", "Lcom/sputnik/domain/entities/market/PlansDuration;", "getDuration", "()Lcom/sputnik/domain/entities/market/PlansDuration;", "Ljava/lang/Integer;", "getPrice", "()Ljava/lang/Integer;", "getTitle", "Ljava/lang/Boolean;", "getSpecial", "()Ljava/lang/Boolean;", "getSpecialDescription", "getSpecialBadgeTitle", "getPriceVerbose", "data_release"}, k = 1, mv = {1, 9, 0}, xi = 48)
/* loaded from: classes3.dex */
public final /* data */ class DataSubsPlans implements Parcelable {
    public static final Parcelable.Creator<DataSubsPlans> CREATOR = new Creator();
    private final PlansDuration duration;
    private final String identifier;
    private final Integer price;

    @SerializedName("price_verbose")
    private final String priceVerbose;
    private final Boolean special;

    @SerializedName("special_badge_title")
    private final String specialBadgeTitle;

    @SerializedName("special_description")
    private final String specialDescription;
    private final String title;

    /* compiled from: DataSubsPlans.kt */
    @Metadata(k = 3, mv = {1, 9, 0}, xi = 48)
    public static final class Creator implements Parcelable.Creator<DataSubsPlans> {
        /* JADX WARN: Can't rename method to resolve collision */
        @Override // android.os.Parcelable.Creator
        public final DataSubsPlans createFromParcel(Parcel parcel) {
            Boolean boolValueOf;
            Intrinsics.checkNotNullParameter(parcel, "parcel");
            String string = parcel.readString();
            PlansDuration plansDurationValueOf = parcel.readInt() == 0 ? null : PlansDuration.valueOf(parcel.readString());
            Integer numValueOf = parcel.readInt() == 0 ? null : Integer.valueOf(parcel.readInt());
            String string2 = parcel.readString();
            if (parcel.readInt() == 0) {
                boolValueOf = null;
            } else {
                boolValueOf = Boolean.valueOf(parcel.readInt() != 0);
            }
            return new DataSubsPlans(string, plansDurationValueOf, numValueOf, string2, boolValueOf, parcel.readString(), parcel.readString(), parcel.readString());
        }

        /* JADX WARN: Can't rename method to resolve collision */
        @Override // android.os.Parcelable.Creator
        public final DataSubsPlans[] newArray(int i) {
            return new DataSubsPlans[i];
        }
    }

    public DataSubsPlans() {
        this(null, null, null, null, null, null, null, null, KotlinVersion.MAX_COMPONENT_VALUE, null);
    }

    @Override // android.os.Parcelable
    public int describeContents() {
        return 0;
    }

    public boolean equals(Object other) {
        if (this == other) {
            return true;
        }
        if (!(other instanceof DataSubsPlans)) {
            return false;
        }
        DataSubsPlans dataSubsPlans = (DataSubsPlans) other;
        return Intrinsics.areEqual(this.identifier, dataSubsPlans.identifier) && this.duration == dataSubsPlans.duration && Intrinsics.areEqual(this.price, dataSubsPlans.price) && Intrinsics.areEqual(this.title, dataSubsPlans.title) && Intrinsics.areEqual(this.special, dataSubsPlans.special) && Intrinsics.areEqual(this.specialDescription, dataSubsPlans.specialDescription) && Intrinsics.areEqual(this.specialBadgeTitle, dataSubsPlans.specialBadgeTitle) && Intrinsics.areEqual(this.priceVerbose, dataSubsPlans.priceVerbose);
    }

    public int hashCode() {
        String str = this.identifier;
        int iHashCode = (str == null ? 0 : str.hashCode()) * 31;
        PlansDuration plansDuration = this.duration;
        int iHashCode2 = (iHashCode + (plansDuration == null ? 0 : plansDuration.hashCode())) * 31;
        Integer num = this.price;
        int iHashCode3 = (iHashCode2 + (num == null ? 0 : num.hashCode())) * 31;
        String str2 = this.title;
        int iHashCode4 = (iHashCode3 + (str2 == null ? 0 : str2.hashCode())) * 31;
        Boolean bool = this.special;
        int iHashCode5 = (iHashCode4 + (bool == null ? 0 : bool.hashCode())) * 31;
        String str3 = this.specialDescription;
        int iHashCode6 = (iHashCode5 + (str3 == null ? 0 : str3.hashCode())) * 31;
        String str4 = this.specialBadgeTitle;
        int iHashCode7 = (iHashCode6 + (str4 == null ? 0 : str4.hashCode())) * 31;
        String str5 = this.priceVerbose;
        return iHashCode7 + (str5 != null ? str5.hashCode() : 0);
    }

    public String toString() {
        return "DataSubsPlans(identifier=" + this.identifier + ", duration=" + this.duration + ", price=" + this.price + ", title=" + this.title + ", special=" + this.special + ", specialDescription=" + this.specialDescription + ", specialBadgeTitle=" + this.specialBadgeTitle + ", priceVerbose=" + this.priceVerbose + ")";
    }

    @Override // android.os.Parcelable
    public void writeToParcel(Parcel parcel, int flags) {
        Intrinsics.checkNotNullParameter(parcel, "out");
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
        parcel.writeString(this.title);
        Boolean bool = this.special;
        if (bool == null) {
            parcel.writeInt(0);
        } else {
            parcel.writeInt(1);
            parcel.writeInt(bool.booleanValue() ? 1 : 0);
        }
        parcel.writeString(this.specialDescription);
        parcel.writeString(this.specialBadgeTitle);
        parcel.writeString(this.priceVerbose);
    }

    public DataSubsPlans(String str, PlansDuration plansDuration, Integer num, String str2, Boolean bool, String str3, String str4, String str5) {
        this.identifier = str;
        this.duration = plansDuration;
        this.price = num;
        this.title = str2;
        this.special = bool;
        this.specialDescription = str3;
        this.specialBadgeTitle = str4;
        this.priceVerbose = str5;
    }

    public /* synthetic */ DataSubsPlans(String str, PlansDuration plansDuration, Integer num, String str2, Boolean bool, String str3, String str4, String str5, int i, DefaultConstructorMarker defaultConstructorMarker) {
        this((i & 1) != 0 ? null : str, (i & 2) != 0 ? null : plansDuration, (i & 4) != 0 ? null : num, (i & 8) != 0 ? null : str2, (i & 16) != 0 ? null : bool, (i & 32) != 0 ? null : str3, (i & 64) != 0 ? null : str4, (i & 128) == 0 ? str5 : null);
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

    public final String getTitle() {
        return this.title;
    }

    public final Boolean getSpecial() {
        return this.special;
    }

    public final String getSpecialDescription() {
        return this.specialDescription;
    }

    public final String getSpecialBadgeTitle() {
        return this.specialBadgeTitle;
    }

    public final String getPriceVerbose() {
        return this.priceVerbose;
    }
}

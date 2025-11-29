package com.sputnik.common.entities.localization;

import android.os.Parcel;
import android.os.Parcelable;
import com.google.gson.annotations.SerializedName;
import java.util.List;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

/* compiled from: LocalizationModel.kt */
@Metadata(d1 = {"\u0000B\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010 \n\u0002\u0010\u000e\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0010\b\n\u0002\b\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\u000b\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u0002\n\u0002\b\n\b\u0087\b\u0018\u00002\u00020\u0001B3\u0012\u000e\u0010\u0004\u001a\n\u0012\u0004\u0012\u00020\u0003\u0018\u00010\u0002\u0012\u000e\u0010\u0005\u001a\n\u0012\u0004\u0012\u00020\u0003\u0018\u00010\u0002\u0012\n\b\u0002\u0010\u0007\u001a\u0004\u0018\u00010\u0006¢\u0006\u0004\b\b\u0010\tJ\u0010\u0010\n\u001a\u00020\u0003HÖ\u0001¢\u0006\u0004\b\n\u0010\u000bJ\u0010\u0010\r\u001a\u00020\fHÖ\u0001¢\u0006\u0004\b\r\u0010\u000eJ\u001a\u0010\u0012\u001a\u00020\u00112\b\u0010\u0010\u001a\u0004\u0018\u00010\u000fHÖ\u0003¢\u0006\u0004\b\u0012\u0010\u0013J\u0010\u0010\u0014\u001a\u00020\fHÖ\u0001¢\u0006\u0004\b\u0014\u0010\u000eJ \u0010\u0019\u001a\u00020\u00182\u0006\u0010\u0016\u001a\u00020\u00152\u0006\u0010\u0017\u001a\u00020\fHÖ\u0001¢\u0006\u0004\b\u0019\u0010\u001aR\"\u0010\u0004\u001a\n\u0012\u0004\u0012\u00020\u0003\u0018\u00010\u00028\u0006X\u0087\u0004¢\u0006\f\n\u0004\b\u0004\u0010\u001b\u001a\u0004\b\u001c\u0010\u001dR\"\u0010\u0005\u001a\n\u0012\u0004\u0012\u00020\u0003\u0018\u00010\u00028\u0006X\u0087\u0004¢\u0006\f\n\u0004\b\u0005\u0010\u001b\u001a\u0004\b\u001e\u0010\u001dR\u001c\u0010\u0007\u001a\u0004\u0018\u00010\u00068\u0006X\u0087\u0004¢\u0006\f\n\u0004\b\u0007\u0010\u001f\u001a\u0004\b \u0010!¨\u0006\""}, d2 = {"Lcom/sputnik/common/entities/localization/MarketBody;", "Landroid/os/Parcelable;", "", "", "sectionTitles", "sectionNewTitles", "Lcom/sputnik/common/entities/localization/ItemSubscription;", "itemSubscription", "<init>", "(Ljava/util/List;Ljava/util/List;Lcom/sputnik/common/entities/localization/ItemSubscription;)V", "toString", "()Ljava/lang/String;", "", "hashCode", "()I", "", "other", "", "equals", "(Ljava/lang/Object;)Z", "describeContents", "Landroid/os/Parcel;", "parcel", "flags", "", "writeToParcel", "(Landroid/os/Parcel;I)V", "Ljava/util/List;", "getSectionTitles", "()Ljava/util/List;", "getSectionNewTitles", "Lcom/sputnik/common/entities/localization/ItemSubscription;", "getItemSubscription", "()Lcom/sputnik/common/entities/localization/ItemSubscription;", "common_release"}, k = 1, mv = {1, 9, 0}, xi = 48)
/* loaded from: classes3.dex */
public final /* data */ class MarketBody implements Parcelable {
    public static final Parcelable.Creator<MarketBody> CREATOR = new Creator();

    @SerializedName("item_subscription")
    private final ItemSubscription itemSubscription;

    @SerializedName("section_new_titles")
    private final List<String> sectionNewTitles;

    @SerializedName("section_titles")
    private final List<String> sectionTitles;

    /* compiled from: LocalizationModel.kt */
    @Metadata(k = 3, mv = {1, 9, 0}, xi = 48)
    public static final class Creator implements Parcelable.Creator<MarketBody> {
        /* JADX WARN: Can't rename method to resolve collision */
        @Override // android.os.Parcelable.Creator
        public final MarketBody createFromParcel(Parcel parcel) {
            Intrinsics.checkNotNullParameter(parcel, "parcel");
            return new MarketBody(parcel.createStringArrayList(), parcel.createStringArrayList(), parcel.readInt() == 0 ? null : ItemSubscription.CREATOR.createFromParcel(parcel));
        }

        /* JADX WARN: Can't rename method to resolve collision */
        @Override // android.os.Parcelable.Creator
        public final MarketBody[] newArray(int i) {
            return new MarketBody[i];
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
        if (!(other instanceof MarketBody)) {
            return false;
        }
        MarketBody marketBody = (MarketBody) other;
        return Intrinsics.areEqual(this.sectionTitles, marketBody.sectionTitles) && Intrinsics.areEqual(this.sectionNewTitles, marketBody.sectionNewTitles) && Intrinsics.areEqual(this.itemSubscription, marketBody.itemSubscription);
    }

    public int hashCode() {
        List<String> list = this.sectionTitles;
        int iHashCode = (list == null ? 0 : list.hashCode()) * 31;
        List<String> list2 = this.sectionNewTitles;
        int iHashCode2 = (iHashCode + (list2 == null ? 0 : list2.hashCode())) * 31;
        ItemSubscription itemSubscription = this.itemSubscription;
        return iHashCode2 + (itemSubscription != null ? itemSubscription.hashCode() : 0);
    }

    public String toString() {
        return "MarketBody(sectionTitles=" + this.sectionTitles + ", sectionNewTitles=" + this.sectionNewTitles + ", itemSubscription=" + this.itemSubscription + ")";
    }

    @Override // android.os.Parcelable
    public void writeToParcel(Parcel parcel, int flags) {
        Intrinsics.checkNotNullParameter(parcel, "out");
        parcel.writeStringList(this.sectionTitles);
        parcel.writeStringList(this.sectionNewTitles);
        ItemSubscription itemSubscription = this.itemSubscription;
        if (itemSubscription == null) {
            parcel.writeInt(0);
        } else {
            parcel.writeInt(1);
            itemSubscription.writeToParcel(parcel, flags);
        }
    }

    public MarketBody(List<String> list, List<String> list2, ItemSubscription itemSubscription) {
        this.sectionTitles = list;
        this.sectionNewTitles = list2;
        this.itemSubscription = itemSubscription;
    }

    public final List<String> getSectionNewTitles() {
        return this.sectionNewTitles;
    }

    public final ItemSubscription getItemSubscription() {
        return this.itemSubscription;
    }
}

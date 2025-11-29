package com.sputnik.data.entities.market.subscription;

import android.os.Parcel;
import android.os.Parcelable;
import com.google.gson.annotations.SerializedName;
import com.sputnik.data.entities.market.DataBadgeStyle;
import com.sputnik.data.entities.market.DataDetailedLayout;
import flussonic.media.FFmpegMediaMetadataRetriever;
import java.util.List;
import kotlin.Metadata;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;

/* compiled from: DataSubscriptionAppearance.kt */
@Metadata(d1 = {"\u0000L\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u000e\n\u0002\b\u0003\n\u0002\u0010\u000b\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010 \n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0010\b\n\u0002\b\u0002\n\u0002\u0010\u0000\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u0002\n\u0002\b\u0016\b\u0087\b\u0018\u00002\u00020\u0001B\u0085\u0001\u0012\n\b\u0002\u0010\u0003\u001a\u0004\u0018\u00010\u0002\u0012\n\b\u0002\u0010\u0004\u001a\u0004\u0018\u00010\u0002\u0012\n\b\u0002\u0010\u0005\u001a\u0004\u0018\u00010\u0002\u0012\n\b\u0002\u0010\u0007\u001a\u0004\u0018\u00010\u0006\u0012\n\b\u0002\u0010\t\u001a\u0004\u0018\u00010\b\u0012\u0010\b\u0002\u0010\u000b\u001a\n\u0012\u0004\u0012\u00020\u0002\u0018\u00010\n\u0012\n\b\u0002\u0010\f\u001a\u0004\u0018\u00010\u0002\u0012\n\b\u0002\u0010\r\u001a\u0004\u0018\u00010\u0002\u0012\n\b\u0002\u0010\u000e\u001a\u0004\u0018\u00010\u0002\u0012\n\b\u0002\u0010\u0010\u001a\u0004\u0018\u00010\u000f¢\u0006\u0004\b\u0011\u0010\u0012J\u0010\u0010\u0013\u001a\u00020\u0002HÖ\u0001¢\u0006\u0004\b\u0013\u0010\u0014J\u0010\u0010\u0016\u001a\u00020\u0015HÖ\u0001¢\u0006\u0004\b\u0016\u0010\u0017J\u001a\u0010\u001a\u001a\u00020\u00062\b\u0010\u0019\u001a\u0004\u0018\u00010\u0018HÖ\u0003¢\u0006\u0004\b\u001a\u0010\u001bJ\u0010\u0010\u001c\u001a\u00020\u0015HÖ\u0001¢\u0006\u0004\b\u001c\u0010\u0017J \u0010!\u001a\u00020 2\u0006\u0010\u001e\u001a\u00020\u001d2\u0006\u0010\u001f\u001a\u00020\u0015HÖ\u0001¢\u0006\u0004\b!\u0010\"R\u0019\u0010\u0003\u001a\u0004\u0018\u00010\u00028\u0006¢\u0006\f\n\u0004\b\u0003\u0010#\u001a\u0004\b$\u0010\u0014R\u0019\u0010\u0004\u001a\u0004\u0018\u00010\u00028\u0006¢\u0006\f\n\u0004\b\u0004\u0010#\u001a\u0004\b%\u0010\u0014R\u001c\u0010\u0005\u001a\u0004\u0018\u00010\u00028\u0006X\u0087\u0004¢\u0006\f\n\u0004\b\u0005\u0010#\u001a\u0004\b&\u0010\u0014R\u0019\u0010\u0007\u001a\u0004\u0018\u00010\u00068\u0006¢\u0006\f\n\u0004\b\u0007\u0010'\u001a\u0004\b(\u0010)R\u0019\u0010\t\u001a\u0004\u0018\u00010\b8\u0006¢\u0006\f\n\u0004\b\t\u0010*\u001a\u0004\b+\u0010,R\u001f\u0010\u000b\u001a\n\u0012\u0004\u0012\u00020\u0002\u0018\u00010\n8\u0006¢\u0006\f\n\u0004\b\u000b\u0010-\u001a\u0004\b.\u0010/R\u0019\u0010\f\u001a\u0004\u0018\u00010\u00028\u0006¢\u0006\f\n\u0004\b\f\u0010#\u001a\u0004\b0\u0010\u0014R\u0019\u0010\r\u001a\u0004\u0018\u00010\u00028\u0006¢\u0006\f\n\u0004\b\r\u0010#\u001a\u0004\b1\u0010\u0014R\u001c\u0010\u000e\u001a\u0004\u0018\u00010\u00028\u0006X\u0087\u0004¢\u0006\f\n\u0004\b\u000e\u0010#\u001a\u0004\b2\u0010\u0014R\u001c\u0010\u0010\u001a\u0004\u0018\u00010\u000f8\u0006X\u0087\u0004¢\u0006\f\n\u0004\b\u0010\u00103\u001a\u0004\b4\u00105¨\u00066"}, d2 = {"Lcom/sputnik/data/entities/market/subscription/DataSubscriptionAppearance;", "Landroid/os/Parcelable;", "", FFmpegMediaMetadataRetriever.METADATA_KEY_TITLE, "description", "specialDescription", "", "special", "Lcom/sputnik/data/entities/market/DataBadgeStyle;", "badge", "", "list", "finale", "link", "priceVerbose", "Lcom/sputnik/data/entities/market/DataDetailedLayout;", "detailedLayout", "<init>", "(Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/Boolean;Lcom/sputnik/data/entities/market/DataBadgeStyle;Ljava/util/List;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Lcom/sputnik/data/entities/market/DataDetailedLayout;)V", "toString", "()Ljava/lang/String;", "", "hashCode", "()I", "", "other", "equals", "(Ljava/lang/Object;)Z", "describeContents", "Landroid/os/Parcel;", "parcel", "flags", "", "writeToParcel", "(Landroid/os/Parcel;I)V", "Ljava/lang/String;", "getTitle", "getDescription", "getSpecialDescription", "Ljava/lang/Boolean;", "getSpecial", "()Ljava/lang/Boolean;", "Lcom/sputnik/data/entities/market/DataBadgeStyle;", "getBadge", "()Lcom/sputnik/data/entities/market/DataBadgeStyle;", "Ljava/util/List;", "getList", "()Ljava/util/List;", "getFinale", "getLink", "getPriceVerbose", "Lcom/sputnik/data/entities/market/DataDetailedLayout;", "getDetailedLayout", "()Lcom/sputnik/data/entities/market/DataDetailedLayout;", "data_release"}, k = 1, mv = {1, 9, 0}, xi = 48)
/* loaded from: classes3.dex */
public final /* data */ class DataSubscriptionAppearance implements Parcelable {
    public static final Parcelable.Creator<DataSubscriptionAppearance> CREATOR = new Creator();
    private final DataBadgeStyle badge;
    private final String description;

    @SerializedName("detailed_layout")
    private final DataDetailedLayout detailedLayout;
    private final String finale;
    private final String link;
    private final List<String> list;

    @SerializedName("price_verbose")
    private final String priceVerbose;
    private final Boolean special;

    @SerializedName("special_description")
    private final String specialDescription;
    private final String title;

    /* compiled from: DataSubscriptionAppearance.kt */
    @Metadata(k = 3, mv = {1, 9, 0}, xi = 48)
    public static final class Creator implements Parcelable.Creator<DataSubscriptionAppearance> {
        /* JADX WARN: Can't rename method to resolve collision */
        @Override // android.os.Parcelable.Creator
        public final DataSubscriptionAppearance createFromParcel(Parcel parcel) {
            Boolean boolValueOf;
            Intrinsics.checkNotNullParameter(parcel, "parcel");
            String string = parcel.readString();
            String string2 = parcel.readString();
            String string3 = parcel.readString();
            if (parcel.readInt() == 0) {
                boolValueOf = null;
            } else {
                boolValueOf = Boolean.valueOf(parcel.readInt() != 0);
            }
            return new DataSubscriptionAppearance(string, string2, string3, boolValueOf, parcel.readInt() == 0 ? null : DataBadgeStyle.CREATOR.createFromParcel(parcel), parcel.createStringArrayList(), parcel.readString(), parcel.readString(), parcel.readString(), parcel.readInt() != 0 ? DataDetailedLayout.CREATOR.createFromParcel(parcel) : null);
        }

        /* JADX WARN: Can't rename method to resolve collision */
        @Override // android.os.Parcelable.Creator
        public final DataSubscriptionAppearance[] newArray(int i) {
            return new DataSubscriptionAppearance[i];
        }
    }

    public DataSubscriptionAppearance() {
        this(null, null, null, null, null, null, null, null, null, null, 1023, null);
    }

    @Override // android.os.Parcelable
    public int describeContents() {
        return 0;
    }

    public boolean equals(Object other) {
        if (this == other) {
            return true;
        }
        if (!(other instanceof DataSubscriptionAppearance)) {
            return false;
        }
        DataSubscriptionAppearance dataSubscriptionAppearance = (DataSubscriptionAppearance) other;
        return Intrinsics.areEqual(this.title, dataSubscriptionAppearance.title) && Intrinsics.areEqual(this.description, dataSubscriptionAppearance.description) && Intrinsics.areEqual(this.specialDescription, dataSubscriptionAppearance.specialDescription) && Intrinsics.areEqual(this.special, dataSubscriptionAppearance.special) && Intrinsics.areEqual(this.badge, dataSubscriptionAppearance.badge) && Intrinsics.areEqual(this.list, dataSubscriptionAppearance.list) && Intrinsics.areEqual(this.finale, dataSubscriptionAppearance.finale) && Intrinsics.areEqual(this.link, dataSubscriptionAppearance.link) && Intrinsics.areEqual(this.priceVerbose, dataSubscriptionAppearance.priceVerbose) && Intrinsics.areEqual(this.detailedLayout, dataSubscriptionAppearance.detailedLayout);
    }

    public int hashCode() {
        String str = this.title;
        int iHashCode = (str == null ? 0 : str.hashCode()) * 31;
        String str2 = this.description;
        int iHashCode2 = (iHashCode + (str2 == null ? 0 : str2.hashCode())) * 31;
        String str3 = this.specialDescription;
        int iHashCode3 = (iHashCode2 + (str3 == null ? 0 : str3.hashCode())) * 31;
        Boolean bool = this.special;
        int iHashCode4 = (iHashCode3 + (bool == null ? 0 : bool.hashCode())) * 31;
        DataBadgeStyle dataBadgeStyle = this.badge;
        int iHashCode5 = (iHashCode4 + (dataBadgeStyle == null ? 0 : dataBadgeStyle.hashCode())) * 31;
        List<String> list = this.list;
        int iHashCode6 = (iHashCode5 + (list == null ? 0 : list.hashCode())) * 31;
        String str4 = this.finale;
        int iHashCode7 = (iHashCode6 + (str4 == null ? 0 : str4.hashCode())) * 31;
        String str5 = this.link;
        int iHashCode8 = (iHashCode7 + (str5 == null ? 0 : str5.hashCode())) * 31;
        String str6 = this.priceVerbose;
        int iHashCode9 = (iHashCode8 + (str6 == null ? 0 : str6.hashCode())) * 31;
        DataDetailedLayout dataDetailedLayout = this.detailedLayout;
        return iHashCode9 + (dataDetailedLayout != null ? dataDetailedLayout.hashCode() : 0);
    }

    public String toString() {
        return "DataSubscriptionAppearance(title=" + this.title + ", description=" + this.description + ", specialDescription=" + this.specialDescription + ", special=" + this.special + ", badge=" + this.badge + ", list=" + this.list + ", finale=" + this.finale + ", link=" + this.link + ", priceVerbose=" + this.priceVerbose + ", detailedLayout=" + this.detailedLayout + ")";
    }

    @Override // android.os.Parcelable
    public void writeToParcel(Parcel parcel, int flags) {
        Intrinsics.checkNotNullParameter(parcel, "out");
        parcel.writeString(this.title);
        parcel.writeString(this.description);
        parcel.writeString(this.specialDescription);
        Boolean bool = this.special;
        if (bool == null) {
            parcel.writeInt(0);
        } else {
            parcel.writeInt(1);
            parcel.writeInt(bool.booleanValue() ? 1 : 0);
        }
        DataBadgeStyle dataBadgeStyle = this.badge;
        if (dataBadgeStyle == null) {
            parcel.writeInt(0);
        } else {
            parcel.writeInt(1);
            dataBadgeStyle.writeToParcel(parcel, flags);
        }
        parcel.writeStringList(this.list);
        parcel.writeString(this.finale);
        parcel.writeString(this.link);
        parcel.writeString(this.priceVerbose);
        DataDetailedLayout dataDetailedLayout = this.detailedLayout;
        if (dataDetailedLayout == null) {
            parcel.writeInt(0);
        } else {
            parcel.writeInt(1);
            dataDetailedLayout.writeToParcel(parcel, flags);
        }
    }

    public DataSubscriptionAppearance(String str, String str2, String str3, Boolean bool, DataBadgeStyle dataBadgeStyle, List<String> list, String str4, String str5, String str6, DataDetailedLayout dataDetailedLayout) {
        this.title = str;
        this.description = str2;
        this.specialDescription = str3;
        this.special = bool;
        this.badge = dataBadgeStyle;
        this.list = list;
        this.finale = str4;
        this.link = str5;
        this.priceVerbose = str6;
        this.detailedLayout = dataDetailedLayout;
    }

    public /* synthetic */ DataSubscriptionAppearance(String str, String str2, String str3, Boolean bool, DataBadgeStyle dataBadgeStyle, List list, String str4, String str5, String str6, DataDetailedLayout dataDetailedLayout, int i, DefaultConstructorMarker defaultConstructorMarker) {
        this((i & 1) != 0 ? null : str, (i & 2) != 0 ? null : str2, (i & 4) != 0 ? null : str3, (i & 8) != 0 ? null : bool, (i & 16) != 0 ? null : dataBadgeStyle, (i & 32) != 0 ? null : list, (i & 64) != 0 ? null : str4, (i & 128) != 0 ? null : str5, (i & 256) != 0 ? null : str6, (i & 512) == 0 ? dataDetailedLayout : null);
    }

    public final String getTitle() {
        return this.title;
    }

    public final String getDescription() {
        return this.description;
    }

    public final String getSpecialDescription() {
        return this.specialDescription;
    }

    public final Boolean getSpecial() {
        return this.special;
    }

    public final DataBadgeStyle getBadge() {
        return this.badge;
    }

    public final List<String> getList() {
        return this.list;
    }

    public final String getFinale() {
        return this.finale;
    }

    public final String getLink() {
        return this.link;
    }

    public final String getPriceVerbose() {
        return this.priceVerbose;
    }

    public final DataDetailedLayout getDetailedLayout() {
        return this.detailedLayout;
    }
}

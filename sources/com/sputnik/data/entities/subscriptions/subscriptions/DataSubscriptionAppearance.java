package com.sputnik.data.entities.subscriptions.subscriptions;

import com.google.gson.annotations.SerializedName;
import flussonic.media.FFmpegMediaMetadataRetriever;
import java.util.List;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

/* compiled from: DataSubscriptionAppearance.kt */
@Metadata(d1 = {"\u0000@\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0010\u000e\n\u0002\b\u0002\n\u0002\u0010\b\n\u0002\b\u0003\n\u0002\u0010\u000b\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0007\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0010 \n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0012\b\u0086\b\u0018\u00002\u00020\u0001:\u0001/J\u0010\u0010\u0003\u001a\u00020\u0002HÖ\u0001¢\u0006\u0004\b\u0003\u0010\u0004J\u0010\u0010\u0006\u001a\u00020\u0005HÖ\u0001¢\u0006\u0004\b\u0006\u0010\u0007J\u001a\u0010\n\u001a\u00020\t2\b\u0010\b\u001a\u0004\u0018\u00010\u0001HÖ\u0003¢\u0006\u0004\b\n\u0010\u000bR\u001c\u0010\r\u001a\u0004\u0018\u00010\f8\u0006X\u0087\u0004¢\u0006\f\n\u0004\b\r\u0010\u000e\u001a\u0004\b\u000f\u0010\u0010R\u001c\u0010\u0011\u001a\u0004\u0018\u00010\u00028\u0006X\u0087\u0004¢\u0006\f\n\u0004\b\u0011\u0010\u0012\u001a\u0004\b\u0013\u0010\u0004R\u001c\u0010\u0015\u001a\u0004\u0018\u00010\u00148\u0006X\u0087\u0004¢\u0006\f\n\u0004\b\u0015\u0010\u0016\u001a\u0004\b\u0017\u0010\u0018R\"\u0010\u001a\u001a\n\u0012\u0004\u0012\u00020\u0002\u0018\u00010\u00198\u0006X\u0087\u0004¢\u0006\f\n\u0004\b\u001a\u0010\u001b\u001a\u0004\b\u001c\u0010\u001dR\"\u0010\u001f\u001a\n\u0012\u0004\u0012\u00020\u001e\u0018\u00010\u00198\u0006X\u0087\u0004¢\u0006\f\n\u0004\b\u001f\u0010\u001b\u001a\u0004\b \u0010\u001dR\u001c\u0010!\u001a\u0004\u0018\u00010\u00028\u0006X\u0087\u0004¢\u0006\f\n\u0004\b!\u0010\u0012\u001a\u0004\b\"\u0010\u0004R\u001c\u0010#\u001a\u0004\u0018\u00010\u00028\u0006X\u0087\u0004¢\u0006\f\n\u0004\b#\u0010\u0012\u001a\u0004\b$\u0010\u0004R\u001c\u0010%\u001a\u0004\u0018\u00010\u00028\u0006X\u0087\u0004¢\u0006\f\n\u0004\b%\u0010\u0012\u001a\u0004\b&\u0010\u0004R\u001c\u0010'\u001a\u0004\u0018\u00010\t8\u0006X\u0087\u0004¢\u0006\f\n\u0004\b'\u0010(\u001a\u0004\b)\u0010*R\u001c\u0010+\u001a\u0004\u0018\u00010\u00028\u0006X\u0087\u0004¢\u0006\f\n\u0004\b+\u0010\u0012\u001a\u0004\b,\u0010\u0004R\u001c\u0010-\u001a\u0004\u0018\u00010\u00028\u0006X\u0087\u0004¢\u0006\f\n\u0004\b-\u0010\u0012\u001a\u0004\b.\u0010\u0004¨\u00060"}, d2 = {"Lcom/sputnik/data/entities/subscriptions/subscriptions/DataSubscriptionAppearance;", "", "", "toString", "()Ljava/lang/String;", "", "hashCode", "()I", "other", "", "equals", "(Ljava/lang/Object;)Z", "Lcom/sputnik/data/entities/subscriptions/subscriptions/DataBadge;", "badge", "Lcom/sputnik/data/entities/subscriptions/subscriptions/DataBadge;", "getBadge", "()Lcom/sputnik/data/entities/subscriptions/subscriptions/DataBadge;", "description", "Ljava/lang/String;", "getDescription", "Lcom/sputnik/data/entities/subscriptions/subscriptions/DataDetailedLayout;", "detailedLayout", "Lcom/sputnik/data/entities/subscriptions/subscriptions/DataDetailedLayout;", "getDetailedLayout", "()Lcom/sputnik/data/entities/subscriptions/subscriptions/DataDetailedLayout;", "", "featuresList", "Ljava/util/List;", "getFeaturesList", "()Ljava/util/List;", "Lcom/sputnik/data/entities/subscriptions/subscriptions/DataSubscriptionAppearance$DataFeaturePoint;", "featuresPoints", "getFeaturesPoints", "finale", "getFinale", "priceVerbose", "getPriceVerbose", "priceText", "getPriceText", "special", "Ljava/lang/Boolean;", "getSpecial", "()Ljava/lang/Boolean;", "specialDescription", "getSpecialDescription", FFmpegMediaMetadataRetriever.METADATA_KEY_TITLE, "getTitle", "DataFeaturePoint", "data_release"}, k = 1, mv = {1, 9, 0}, xi = 48)
/* loaded from: classes3.dex */
public final /* data */ class DataSubscriptionAppearance {

    @SerializedName("badge")
    private final DataBadge badge;

    @SerializedName("description")
    private final String description;

    @SerializedName("detailed_layout")
    private final DataDetailedLayout detailedLayout;

    @SerializedName("features_list")
    private final List<String> featuresList;

    @SerializedName("features_points")
    private final List<DataFeaturePoint> featuresPoints;

    @SerializedName("finale")
    private final String finale;

    @SerializedName("price_text")
    private final String priceText;

    @SerializedName("price_verbose")
    private final String priceVerbose;

    @SerializedName("special")
    private final Boolean special;

    @SerializedName("special_description")
    private final String specialDescription;

    @SerializedName(FFmpegMediaMetadataRetriever.METADATA_KEY_TITLE)
    private final String title;

    public boolean equals(Object other) {
        if (this == other) {
            return true;
        }
        if (!(other instanceof DataSubscriptionAppearance)) {
            return false;
        }
        DataSubscriptionAppearance dataSubscriptionAppearance = (DataSubscriptionAppearance) other;
        return Intrinsics.areEqual(this.badge, dataSubscriptionAppearance.badge) && Intrinsics.areEqual(this.description, dataSubscriptionAppearance.description) && Intrinsics.areEqual(this.detailedLayout, dataSubscriptionAppearance.detailedLayout) && Intrinsics.areEqual(this.featuresList, dataSubscriptionAppearance.featuresList) && Intrinsics.areEqual(this.featuresPoints, dataSubscriptionAppearance.featuresPoints) && Intrinsics.areEqual(this.finale, dataSubscriptionAppearance.finale) && Intrinsics.areEqual(this.priceVerbose, dataSubscriptionAppearance.priceVerbose) && Intrinsics.areEqual(this.priceText, dataSubscriptionAppearance.priceText) && Intrinsics.areEqual(this.special, dataSubscriptionAppearance.special) && Intrinsics.areEqual(this.specialDescription, dataSubscriptionAppearance.specialDescription) && Intrinsics.areEqual(this.title, dataSubscriptionAppearance.title);
    }

    public int hashCode() {
        DataBadge dataBadge = this.badge;
        int iHashCode = (dataBadge == null ? 0 : dataBadge.hashCode()) * 31;
        String str = this.description;
        int iHashCode2 = (iHashCode + (str == null ? 0 : str.hashCode())) * 31;
        DataDetailedLayout dataDetailedLayout = this.detailedLayout;
        int iHashCode3 = (iHashCode2 + (dataDetailedLayout == null ? 0 : dataDetailedLayout.hashCode())) * 31;
        List<String> list = this.featuresList;
        int iHashCode4 = (iHashCode3 + (list == null ? 0 : list.hashCode())) * 31;
        List<DataFeaturePoint> list2 = this.featuresPoints;
        int iHashCode5 = (iHashCode4 + (list2 == null ? 0 : list2.hashCode())) * 31;
        String str2 = this.finale;
        int iHashCode6 = (iHashCode5 + (str2 == null ? 0 : str2.hashCode())) * 31;
        String str3 = this.priceVerbose;
        int iHashCode7 = (iHashCode6 + (str3 == null ? 0 : str3.hashCode())) * 31;
        String str4 = this.priceText;
        int iHashCode8 = (iHashCode7 + (str4 == null ? 0 : str4.hashCode())) * 31;
        Boolean bool = this.special;
        int iHashCode9 = (iHashCode8 + (bool == null ? 0 : bool.hashCode())) * 31;
        String str5 = this.specialDescription;
        int iHashCode10 = (iHashCode9 + (str5 == null ? 0 : str5.hashCode())) * 31;
        String str6 = this.title;
        return iHashCode10 + (str6 != null ? str6.hashCode() : 0);
    }

    public String toString() {
        return "DataSubscriptionAppearance(badge=" + this.badge + ", description=" + this.description + ", detailedLayout=" + this.detailedLayout + ", featuresList=" + this.featuresList + ", featuresPoints=" + this.featuresPoints + ", finale=" + this.finale + ", priceVerbose=" + this.priceVerbose + ", priceText=" + this.priceText + ", special=" + this.special + ", specialDescription=" + this.specialDescription + ", title=" + this.title + ")";
    }

    public final DataBadge getBadge() {
        return this.badge;
    }

    public final String getDescription() {
        return this.description;
    }

    public final DataDetailedLayout getDetailedLayout() {
        return this.detailedLayout;
    }

    public final List<String> getFeaturesList() {
        return this.featuresList;
    }

    public final List<DataFeaturePoint> getFeaturesPoints() {
        return this.featuresPoints;
    }

    public final String getFinale() {
        return this.finale;
    }

    public final String getPriceVerbose() {
        return this.priceVerbose;
    }

    public final String getPriceText() {
        return this.priceText;
    }

    public final Boolean getSpecial() {
        return this.special;
    }

    public final String getSpecialDescription() {
        return this.specialDescription;
    }

    public final String getTitle() {
        return this.title;
    }

    /* compiled from: DataSubscriptionAppearance.kt */
    @Metadata(d1 = {"\u0000 \n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0010\u000e\n\u0002\b\u0002\n\u0002\u0010\b\n\u0002\b\u0003\n\u0002\u0010\u000b\n\u0002\b\b\b\u0086\b\u0018\u00002\u00020\u0001J\u0010\u0010\u0003\u001a\u00020\u0002HÖ\u0001¢\u0006\u0004\b\u0003\u0010\u0004J\u0010\u0010\u0006\u001a\u00020\u0005HÖ\u0001¢\u0006\u0004\b\u0006\u0010\u0007J\u001a\u0010\n\u001a\u00020\t2\b\u0010\b\u001a\u0004\u0018\u00010\u0001HÖ\u0003¢\u0006\u0004\b\n\u0010\u000bR\u0019\u0010\f\u001a\u0004\u0018\u00010\u00028\u0006¢\u0006\f\n\u0004\b\f\u0010\r\u001a\u0004\b\u000e\u0010\u0004R\u0019\u0010\u000f\u001a\u0004\u0018\u00010\u00028\u0006¢\u0006\f\n\u0004\b\u000f\u0010\r\u001a\u0004\b\u0010\u0010\u0004¨\u0006\u0011"}, d2 = {"Lcom/sputnik/data/entities/subscriptions/subscriptions/DataSubscriptionAppearance$DataFeaturePoint;", "", "", "toString", "()Ljava/lang/String;", "", "hashCode", "()I", "other", "", "equals", "(Ljava/lang/Object;)Z", FFmpegMediaMetadataRetriever.METADATA_KEY_TITLE, "Ljava/lang/String;", "getTitle", "badge", "getBadge", "data_release"}, k = 1, mv = {1, 9, 0}, xi = 48)
    public static final /* data */ class DataFeaturePoint {
        private final String badge;
        private final String title;

        public boolean equals(Object other) {
            if (this == other) {
                return true;
            }
            if (!(other instanceof DataFeaturePoint)) {
                return false;
            }
            DataFeaturePoint dataFeaturePoint = (DataFeaturePoint) other;
            return Intrinsics.areEqual(this.title, dataFeaturePoint.title) && Intrinsics.areEqual(this.badge, dataFeaturePoint.badge);
        }

        public int hashCode() {
            String str = this.title;
            int iHashCode = (str == null ? 0 : str.hashCode()) * 31;
            String str2 = this.badge;
            return iHashCode + (str2 != null ? str2.hashCode() : 0);
        }

        public String toString() {
            return "DataFeaturePoint(title=" + this.title + ", badge=" + this.badge + ")";
        }

        public final String getTitle() {
            return this.title;
        }

        public final String getBadge() {
            return this.badge;
        }
    }
}

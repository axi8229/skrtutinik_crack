package com.sputnik.common.entities.subscriptions;

import android.os.Parcel;
import android.os.Parcelable;
import flussonic.media.FFmpegMediaMetadataRetriever;
import java.util.List;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

/* compiled from: SubscriptionAppearance.kt */
@Metadata(d1 = {"\u0000:\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010 \n\u0002\b\u0004\n\u0002\u0010\u000b\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0010\b\n\u0002\b\u001d\b\u0086\b\u0018\u00002\u00020\u0001:\u00013B\u0081\u0001\u0012\b\u0010\u0003\u001a\u0004\u0018\u00010\u0002\u0012\b\u0010\u0005\u001a\u0004\u0018\u00010\u0004\u0012\b\u0010\u0007\u001a\u0004\u0018\u00010\u0006\u0012\u000e\u0010\t\u001a\n\u0012\u0004\u0012\u00020\u0004\u0018\u00010\b\u0012\b\u0010\n\u001a\u0004\u0018\u00010\u0001\u0012\b\u0010\u000b\u001a\u0004\u0018\u00010\u0004\u0012\b\u0010\f\u001a\u0004\u0018\u00010\u0004\u0012\b\u0010\u000e\u001a\u0004\u0018\u00010\r\u0012\b\u0010\u000f\u001a\u0004\u0018\u00010\u0004\u0012\b\u0010\u0010\u001a\u0004\u0018\u00010\u0004\u0012\u000e\u0010\u0012\u001a\n\u0012\u0004\u0012\u00020\u0011\u0018\u00010\b¢\u0006\u0004\b\u0013\u0010\u0014J\u0010\u0010\u0015\u001a\u00020\u0004HÖ\u0001¢\u0006\u0004\b\u0015\u0010\u0016J\u0010\u0010\u0018\u001a\u00020\u0017HÖ\u0001¢\u0006\u0004\b\u0018\u0010\u0019J\u001a\u0010\u001b\u001a\u00020\r2\b\u0010\u001a\u001a\u0004\u0018\u00010\u0001HÖ\u0003¢\u0006\u0004\b\u001b\u0010\u001cR\u0019\u0010\u0003\u001a\u0004\u0018\u00010\u00028\u0006¢\u0006\f\n\u0004\b\u0003\u0010\u001d\u001a\u0004\b\u001e\u0010\u001fR\u0019\u0010\u0005\u001a\u0004\u0018\u00010\u00048\u0006¢\u0006\f\n\u0004\b\u0005\u0010 \u001a\u0004\b!\u0010\u0016R\u0019\u0010\u0007\u001a\u0004\u0018\u00010\u00068\u0006¢\u0006\f\n\u0004\b\u0007\u0010\"\u001a\u0004\b#\u0010$R\u001f\u0010\t\u001a\n\u0012\u0004\u0012\u00020\u0004\u0018\u00010\b8\u0006¢\u0006\f\n\u0004\b\t\u0010%\u001a\u0004\b&\u0010'R\u0019\u0010\n\u001a\u0004\u0018\u00010\u00018\u0006¢\u0006\f\n\u0004\b\n\u0010(\u001a\u0004\b)\u0010*R\u0019\u0010\u000b\u001a\u0004\u0018\u00010\u00048\u0006¢\u0006\f\n\u0004\b\u000b\u0010 \u001a\u0004\b+\u0010\u0016R\u0019\u0010\f\u001a\u0004\u0018\u00010\u00048\u0006¢\u0006\f\n\u0004\b\f\u0010 \u001a\u0004\b,\u0010\u0016R\u0019\u0010\u000e\u001a\u0004\u0018\u00010\r8\u0006¢\u0006\f\n\u0004\b\u000e\u0010-\u001a\u0004\b.\u0010/R\u0019\u0010\u000f\u001a\u0004\u0018\u00010\u00048\u0006¢\u0006\f\n\u0004\b\u000f\u0010 \u001a\u0004\b0\u0010\u0016R\u0019\u0010\u0010\u001a\u0004\u0018\u00010\u00048\u0006¢\u0006\f\n\u0004\b\u0010\u0010 \u001a\u0004\b1\u0010\u0016R\u001f\u0010\u0012\u001a\n\u0012\u0004\u0012\u00020\u0011\u0018\u00010\b8\u0006¢\u0006\f\n\u0004\b\u0012\u0010%\u001a\u0004\b2\u0010'¨\u00064"}, d2 = {"Lcom/sputnik/common/entities/subscriptions/SubscriptionAppearance;", "", "Lcom/sputnik/common/entities/subscriptions/Badge;", "badge", "", "description", "Lcom/sputnik/common/entities/subscriptions/DetailedLayout;", "detailedLayout", "", "featuresList", "finale", "priceVerbose", "priceText", "", "special", "specialDescription", FFmpegMediaMetadataRetriever.METADATA_KEY_TITLE, "Lcom/sputnik/common/entities/subscriptions/SubscriptionAppearance$FeaturePoint;", "featuresPoints", "<init>", "(Lcom/sputnik/common/entities/subscriptions/Badge;Ljava/lang/String;Lcom/sputnik/common/entities/subscriptions/DetailedLayout;Ljava/util/List;Ljava/lang/Object;Ljava/lang/String;Ljava/lang/String;Ljava/lang/Boolean;Ljava/lang/String;Ljava/lang/String;Ljava/util/List;)V", "toString", "()Ljava/lang/String;", "", "hashCode", "()I", "other", "equals", "(Ljava/lang/Object;)Z", "Lcom/sputnik/common/entities/subscriptions/Badge;", "getBadge", "()Lcom/sputnik/common/entities/subscriptions/Badge;", "Ljava/lang/String;", "getDescription", "Lcom/sputnik/common/entities/subscriptions/DetailedLayout;", "getDetailedLayout", "()Lcom/sputnik/common/entities/subscriptions/DetailedLayout;", "Ljava/util/List;", "getFeaturesList", "()Ljava/util/List;", "Ljava/lang/Object;", "getFinale", "()Ljava/lang/Object;", "getPriceVerbose", "getPriceText", "Ljava/lang/Boolean;", "getSpecial", "()Ljava/lang/Boolean;", "getSpecialDescription", "getTitle", "getFeaturesPoints", "FeaturePoint", "common_release"}, k = 1, mv = {1, 9, 0}, xi = 48)
/* loaded from: classes3.dex */
public final /* data */ class SubscriptionAppearance {
    private final Badge badge;
    private final String description;
    private final DetailedLayout detailedLayout;
    private final List<String> featuresList;
    private final List<FeaturePoint> featuresPoints;
    private final Object finale;
    private final String priceText;
    private final String priceVerbose;
    private final Boolean special;
    private final String specialDescription;
    private final String title;

    public boolean equals(Object other) {
        if (this == other) {
            return true;
        }
        if (!(other instanceof SubscriptionAppearance)) {
            return false;
        }
        SubscriptionAppearance subscriptionAppearance = (SubscriptionAppearance) other;
        return Intrinsics.areEqual(this.badge, subscriptionAppearance.badge) && Intrinsics.areEqual(this.description, subscriptionAppearance.description) && Intrinsics.areEqual(this.detailedLayout, subscriptionAppearance.detailedLayout) && Intrinsics.areEqual(this.featuresList, subscriptionAppearance.featuresList) && Intrinsics.areEqual(this.finale, subscriptionAppearance.finale) && Intrinsics.areEqual(this.priceVerbose, subscriptionAppearance.priceVerbose) && Intrinsics.areEqual(this.priceText, subscriptionAppearance.priceText) && Intrinsics.areEqual(this.special, subscriptionAppearance.special) && Intrinsics.areEqual(this.specialDescription, subscriptionAppearance.specialDescription) && Intrinsics.areEqual(this.title, subscriptionAppearance.title) && Intrinsics.areEqual(this.featuresPoints, subscriptionAppearance.featuresPoints);
    }

    public int hashCode() {
        Badge badge = this.badge;
        int iHashCode = (badge == null ? 0 : badge.hashCode()) * 31;
        String str = this.description;
        int iHashCode2 = (iHashCode + (str == null ? 0 : str.hashCode())) * 31;
        DetailedLayout detailedLayout = this.detailedLayout;
        int iHashCode3 = (iHashCode2 + (detailedLayout == null ? 0 : detailedLayout.hashCode())) * 31;
        List<String> list = this.featuresList;
        int iHashCode4 = (iHashCode3 + (list == null ? 0 : list.hashCode())) * 31;
        Object obj = this.finale;
        int iHashCode5 = (iHashCode4 + (obj == null ? 0 : obj.hashCode())) * 31;
        String str2 = this.priceVerbose;
        int iHashCode6 = (iHashCode5 + (str2 == null ? 0 : str2.hashCode())) * 31;
        String str3 = this.priceText;
        int iHashCode7 = (iHashCode6 + (str3 == null ? 0 : str3.hashCode())) * 31;
        Boolean bool = this.special;
        int iHashCode8 = (iHashCode7 + (bool == null ? 0 : bool.hashCode())) * 31;
        String str4 = this.specialDescription;
        int iHashCode9 = (iHashCode8 + (str4 == null ? 0 : str4.hashCode())) * 31;
        String str5 = this.title;
        int iHashCode10 = (iHashCode9 + (str5 == null ? 0 : str5.hashCode())) * 31;
        List<FeaturePoint> list2 = this.featuresPoints;
        return iHashCode10 + (list2 != null ? list2.hashCode() : 0);
    }

    public String toString() {
        return "SubscriptionAppearance(badge=" + this.badge + ", description=" + this.description + ", detailedLayout=" + this.detailedLayout + ", featuresList=" + this.featuresList + ", finale=" + this.finale + ", priceVerbose=" + this.priceVerbose + ", priceText=" + this.priceText + ", special=" + this.special + ", specialDescription=" + this.specialDescription + ", title=" + this.title + ", featuresPoints=" + this.featuresPoints + ")";
    }

    public SubscriptionAppearance(Badge badge, String str, DetailedLayout detailedLayout, List<String> list, Object obj, String str2, String str3, Boolean bool, String str4, String str5, List<FeaturePoint> list2) {
        this.badge = badge;
        this.description = str;
        this.detailedLayout = detailedLayout;
        this.featuresList = list;
        this.finale = obj;
        this.priceVerbose = str2;
        this.priceText = str3;
        this.special = bool;
        this.specialDescription = str4;
        this.title = str5;
        this.featuresPoints = list2;
    }

    public final Badge getBadge() {
        return this.badge;
    }

    public final String getDescription() {
        return this.description;
    }

    public final DetailedLayout getDetailedLayout() {
        return this.detailedLayout;
    }

    public final String getPriceVerbose() {
        return this.priceVerbose;
    }

    public final String getPriceText() {
        return this.priceText;
    }

    public final String getTitle() {
        return this.title;
    }

    public final List<FeaturePoint> getFeaturesPoints() {
        return this.featuresPoints;
    }

    /* compiled from: SubscriptionAppearance.kt */
    @Metadata(d1 = {"\u00006\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u000e\n\u0002\b\u0006\n\u0002\u0010\b\n\u0002\b\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\u000b\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u0002\n\u0002\b\u0006\b\u0087\b\u0018\u00002\u00020\u0001B\u001b\u0012\b\u0010\u0003\u001a\u0004\u0018\u00010\u0002\u0012\b\u0010\u0004\u001a\u0004\u0018\u00010\u0002¢\u0006\u0004\b\u0005\u0010\u0006J\u0010\u0010\u0007\u001a\u00020\u0002HÖ\u0001¢\u0006\u0004\b\u0007\u0010\bJ\u0010\u0010\n\u001a\u00020\tHÖ\u0001¢\u0006\u0004\b\n\u0010\u000bJ\u001a\u0010\u000f\u001a\u00020\u000e2\b\u0010\r\u001a\u0004\u0018\u00010\fHÖ\u0003¢\u0006\u0004\b\u000f\u0010\u0010J\u0010\u0010\u0011\u001a\u00020\tHÖ\u0001¢\u0006\u0004\b\u0011\u0010\u000bJ \u0010\u0016\u001a\u00020\u00152\u0006\u0010\u0013\u001a\u00020\u00122\u0006\u0010\u0014\u001a\u00020\tHÖ\u0001¢\u0006\u0004\b\u0016\u0010\u0017R\u0019\u0010\u0003\u001a\u0004\u0018\u00010\u00028\u0006¢\u0006\f\n\u0004\b\u0003\u0010\u0018\u001a\u0004\b\u0019\u0010\bR\u0019\u0010\u0004\u001a\u0004\u0018\u00010\u00028\u0006¢\u0006\f\n\u0004\b\u0004\u0010\u0018\u001a\u0004\b\u001a\u0010\b¨\u0006\u001b"}, d2 = {"Lcom/sputnik/common/entities/subscriptions/SubscriptionAppearance$FeaturePoint;", "Landroid/os/Parcelable;", "", FFmpegMediaMetadataRetriever.METADATA_KEY_TITLE, "badge", "<init>", "(Ljava/lang/String;Ljava/lang/String;)V", "toString", "()Ljava/lang/String;", "", "hashCode", "()I", "", "other", "", "equals", "(Ljava/lang/Object;)Z", "describeContents", "Landroid/os/Parcel;", "parcel", "flags", "", "writeToParcel", "(Landroid/os/Parcel;I)V", "Ljava/lang/String;", "getTitle", "getBadge", "common_release"}, k = 1, mv = {1, 9, 0}, xi = 48)
    public static final /* data */ class FeaturePoint implements Parcelable {
        public static final Parcelable.Creator<FeaturePoint> CREATOR = new Creator();
        private final String badge;
        private final String title;

        /* compiled from: SubscriptionAppearance.kt */
        @Metadata(k = 3, mv = {1, 9, 0}, xi = 48)
        public static final class Creator implements Parcelable.Creator<FeaturePoint> {
            /* JADX WARN: Can't rename method to resolve collision */
            @Override // android.os.Parcelable.Creator
            public final FeaturePoint createFromParcel(Parcel parcel) {
                Intrinsics.checkNotNullParameter(parcel, "parcel");
                return new FeaturePoint(parcel.readString(), parcel.readString());
            }

            /* JADX WARN: Can't rename method to resolve collision */
            @Override // android.os.Parcelable.Creator
            public final FeaturePoint[] newArray(int i) {
                return new FeaturePoint[i];
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
            if (!(other instanceof FeaturePoint)) {
                return false;
            }
            FeaturePoint featurePoint = (FeaturePoint) other;
            return Intrinsics.areEqual(this.title, featurePoint.title) && Intrinsics.areEqual(this.badge, featurePoint.badge);
        }

        public int hashCode() {
            String str = this.title;
            int iHashCode = (str == null ? 0 : str.hashCode()) * 31;
            String str2 = this.badge;
            return iHashCode + (str2 != null ? str2.hashCode() : 0);
        }

        public String toString() {
            return "FeaturePoint(title=" + this.title + ", badge=" + this.badge + ")";
        }

        @Override // android.os.Parcelable
        public void writeToParcel(Parcel parcel, int flags) {
            Intrinsics.checkNotNullParameter(parcel, "out");
            parcel.writeString(this.title);
            parcel.writeString(this.badge);
        }

        public FeaturePoint(String str, String str2) {
            this.title = str;
            this.badge = str2;
        }

        public final String getTitle() {
            return this.title;
        }

        public final String getBadge() {
            return this.badge;
        }
    }
}

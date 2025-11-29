package com.sputnik.data.entities.subscriptions.subscriptions;

import com.google.gson.annotations.SerializedName;
import flussonic.media.FFmpegMediaMetadataRetriever;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

/* compiled from: DataPlan.kt */
@Metadata(d1 = {"\u0000(\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0010\u000e\n\u0002\b\u0002\n\u0002\u0010\b\n\u0002\b\u0003\n\u0002\u0010\u000b\n\u0002\b\r\n\u0002\u0018\u0002\n\u0002\b\u0006\b\u0086\b\u0018\u00002\u00020\u0001:\u0001\u001cJ\u0010\u0010\u0003\u001a\u00020\u0002HÖ\u0001¢\u0006\u0004\b\u0003\u0010\u0004J\u0010\u0010\u0006\u001a\u00020\u0005HÖ\u0001¢\u0006\u0004\b\u0006\u0010\u0007J\u001a\u0010\n\u001a\u00020\t2\b\u0010\b\u001a\u0004\u0018\u00010\u0001HÖ\u0003¢\u0006\u0004\b\n\u0010\u000bR\u001c\u0010\f\u001a\u0004\u0018\u00010\u00028\u0006X\u0087\u0004¢\u0006\f\n\u0004\b\f\u0010\r\u001a\u0004\b\u000e\u0010\u0004R\u001c\u0010\u000f\u001a\u0004\u0018\u00010\u00028\u0006X\u0087\u0004¢\u0006\f\n\u0004\b\u000f\u0010\r\u001a\u0004\b\u0010\u0010\u0004R\u001c\u0010\u0011\u001a\u0004\u0018\u00010\u00028\u0006X\u0087\u0004¢\u0006\f\n\u0004\b\u0011\u0010\r\u001a\u0004\b\u0012\u0010\u0004R\u001c\u0010\u0013\u001a\u0004\u0018\u00010\u00058\u0006X\u0087\u0004¢\u0006\f\n\u0004\b\u0013\u0010\u0014\u001a\u0004\b\u0015\u0010\u0016R\u0019\u0010\u0018\u001a\u0004\u0018\u00010\u00178\u0006¢\u0006\f\n\u0004\b\u0018\u0010\u0019\u001a\u0004\b\u001a\u0010\u001b¨\u0006\u001d"}, d2 = {"Lcom/sputnik/data/entities/subscriptions/subscriptions/DataPlan;", "", "", "toString", "()Ljava/lang/String;", "", "hashCode", "()I", "other", "", "equals", "(Ljava/lang/Object;)Z", "appstoreProductId", "Ljava/lang/String;", "getAppstoreProductId", FFmpegMediaMetadataRetriever.METADATA_KEY_DURATION, "getDuration", "identifier", "getIdentifier", "price", "Ljava/lang/Integer;", "getPrice", "()Ljava/lang/Integer;", "Lcom/sputnik/data/entities/subscriptions/subscriptions/DataPlan$DataPromo;", "promo", "Lcom/sputnik/data/entities/subscriptions/subscriptions/DataPlan$DataPromo;", "getPromo", "()Lcom/sputnik/data/entities/subscriptions/subscriptions/DataPlan$DataPromo;", "DataPromo", "data_release"}, k = 1, mv = {1, 9, 0}, xi = 48)
/* loaded from: classes3.dex */
public final /* data */ class DataPlan {

    @SerializedName("appstore_product_id")
    private final String appstoreProductId;

    @SerializedName(FFmpegMediaMetadataRetriever.METADATA_KEY_DURATION)
    private final String duration;

    @SerializedName("identifier")
    private final String identifier;

    @SerializedName("price")
    private final Integer price;
    private final DataPromo promo;

    public boolean equals(Object other) {
        if (this == other) {
            return true;
        }
        if (!(other instanceof DataPlan)) {
            return false;
        }
        DataPlan dataPlan = (DataPlan) other;
        return Intrinsics.areEqual(this.appstoreProductId, dataPlan.appstoreProductId) && Intrinsics.areEqual(this.duration, dataPlan.duration) && Intrinsics.areEqual(this.identifier, dataPlan.identifier) && Intrinsics.areEqual(this.price, dataPlan.price) && Intrinsics.areEqual(this.promo, dataPlan.promo);
    }

    public int hashCode() {
        String str = this.appstoreProductId;
        int iHashCode = (str == null ? 0 : str.hashCode()) * 31;
        String str2 = this.duration;
        int iHashCode2 = (iHashCode + (str2 == null ? 0 : str2.hashCode())) * 31;
        String str3 = this.identifier;
        int iHashCode3 = (iHashCode2 + (str3 == null ? 0 : str3.hashCode())) * 31;
        Integer num = this.price;
        int iHashCode4 = (iHashCode3 + (num == null ? 0 : num.hashCode())) * 31;
        DataPromo dataPromo = this.promo;
        return iHashCode4 + (dataPromo != null ? dataPromo.hashCode() : 0);
    }

    public String toString() {
        return "DataPlan(appstoreProductId=" + this.appstoreProductId + ", duration=" + this.duration + ", identifier=" + this.identifier + ", price=" + this.price + ", promo=" + this.promo + ")";
    }

    public final String getAppstoreProductId() {
        return this.appstoreProductId;
    }

    public final String getDuration() {
        return this.duration;
    }

    public final String getIdentifier() {
        return this.identifier;
    }

    public final Integer getPrice() {
        return this.price;
    }

    public final DataPromo getPromo() {
        return this.promo;
    }

    /* compiled from: DataPlan.kt */
    @Metadata(d1 = {"\u0000 \n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0010\u000e\n\u0002\b\u0002\n\u0002\u0010\b\n\u0002\b\u0003\n\u0002\u0010\u000b\n\u0002\b\u000e\b\u0086\b\u0018\u00002\u00020\u0001J\u0010\u0010\u0003\u001a\u00020\u0002HÖ\u0001¢\u0006\u0004\b\u0003\u0010\u0004J\u0010\u0010\u0006\u001a\u00020\u0005HÖ\u0001¢\u0006\u0004\b\u0006\u0010\u0007J\u001a\u0010\n\u001a\u00020\t2\b\u0010\b\u001a\u0004\u0018\u00010\u0001HÖ\u0003¢\u0006\u0004\b\n\u0010\u000bR\u001c\u0010\f\u001a\u0004\u0018\u00010\u00058\u0006X\u0087\u0004¢\u0006\f\n\u0004\b\f\u0010\r\u001a\u0004\b\u000e\u0010\u000fR\u0019\u0010\u0010\u001a\u0004\u0018\u00010\u00028\u0006¢\u0006\f\n\u0004\b\u0010\u0010\u0011\u001a\u0004\b\u0012\u0010\u0004R\u0019\u0010\u0013\u001a\u0004\u0018\u00010\u00028\u0006¢\u0006\f\n\u0004\b\u0013\u0010\u0011\u001a\u0004\b\u0014\u0010\u0004R\u001c\u0010\u0015\u001a\u0004\u0018\u00010\u00028\u0006X\u0087\u0004¢\u0006\f\n\u0004\b\u0015\u0010\u0011\u001a\u0004\b\u0016\u0010\u0004¨\u0006\u0017"}, d2 = {"Lcom/sputnik/data/entities/subscriptions/subscriptions/DataPlan$DataPromo;", "", "", "toString", "()Ljava/lang/String;", "", "hashCode", "()I", "other", "", "equals", "(Ljava/lang/Object;)Z", "discountPrice", "Ljava/lang/Integer;", "getDiscountPrice", "()Ljava/lang/Integer;", "description", "Ljava/lang/String;", "getDescription", "link", "getLink", "linkText", "getLinkText", "data_release"}, k = 1, mv = {1, 9, 0}, xi = 48)
    public static final /* data */ class DataPromo {
        private final String description;

        @SerializedName("discount_price")
        private final Integer discountPrice;
        private final String link;

        @SerializedName("link_text")
        private final String linkText;

        public boolean equals(Object other) {
            if (this == other) {
                return true;
            }
            if (!(other instanceof DataPromo)) {
                return false;
            }
            DataPromo dataPromo = (DataPromo) other;
            return Intrinsics.areEqual(this.discountPrice, dataPromo.discountPrice) && Intrinsics.areEqual(this.description, dataPromo.description) && Intrinsics.areEqual(this.link, dataPromo.link) && Intrinsics.areEqual(this.linkText, dataPromo.linkText);
        }

        public int hashCode() {
            Integer num = this.discountPrice;
            int iHashCode = (num == null ? 0 : num.hashCode()) * 31;
            String str = this.description;
            int iHashCode2 = (iHashCode + (str == null ? 0 : str.hashCode())) * 31;
            String str2 = this.link;
            int iHashCode3 = (iHashCode2 + (str2 == null ? 0 : str2.hashCode())) * 31;
            String str3 = this.linkText;
            return iHashCode3 + (str3 != null ? str3.hashCode() : 0);
        }

        public String toString() {
            return "DataPromo(discountPrice=" + this.discountPrice + ", description=" + this.description + ", link=" + this.link + ", linkText=" + this.linkText + ")";
        }

        public final Integer getDiscountPrice() {
            return this.discountPrice;
        }

        public final String getDescription() {
            return this.description;
        }

        public final String getLink() {
            return this.link;
        }

        public final String getLinkText() {
            return this.linkText;
        }
    }
}

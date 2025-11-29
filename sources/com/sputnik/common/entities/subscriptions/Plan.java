package com.sputnik.common.entities.subscriptions;

import com.google.gson.annotations.SerializedName;
import flussonic.media.FFmpegMediaMetadataRetriever;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

/* compiled from: Plan.kt */
@Metadata(d1 = {"\u0000&\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0010\u000e\n\u0002\b\u0003\n\u0002\u0010\b\n\u0000\n\u0002\u0018\u0002\n\u0002\b\b\n\u0002\u0010\u000b\n\u0002\b\u000e\b\u0086\b\u0018\u00002\u00020\u0001:\u0001\u001eB9\u0012\b\u0010\u0003\u001a\u0004\u0018\u00010\u0002\u0012\b\u0010\u0004\u001a\u0004\u0018\u00010\u0002\u0012\b\u0010\u0005\u001a\u0004\u0018\u00010\u0002\u0012\b\u0010\u0007\u001a\u0004\u0018\u00010\u0006\u0012\b\u0010\t\u001a\u0004\u0018\u00010\b¢\u0006\u0004\b\n\u0010\u000bJ\u0010\u0010\f\u001a\u00020\u0002HÖ\u0001¢\u0006\u0004\b\f\u0010\rJ\u0010\u0010\u000e\u001a\u00020\u0006HÖ\u0001¢\u0006\u0004\b\u000e\u0010\u000fJ\u001a\u0010\u0012\u001a\u00020\u00112\b\u0010\u0010\u001a\u0004\u0018\u00010\u0001HÖ\u0003¢\u0006\u0004\b\u0012\u0010\u0013R\u0019\u0010\u0003\u001a\u0004\u0018\u00010\u00028\u0006¢\u0006\f\n\u0004\b\u0003\u0010\u0014\u001a\u0004\b\u0015\u0010\rR\u0019\u0010\u0004\u001a\u0004\u0018\u00010\u00028\u0006¢\u0006\f\n\u0004\b\u0004\u0010\u0014\u001a\u0004\b\u0016\u0010\rR\u0019\u0010\u0005\u001a\u0004\u0018\u00010\u00028\u0006¢\u0006\f\n\u0004\b\u0005\u0010\u0014\u001a\u0004\b\u0017\u0010\rR\u0019\u0010\u0007\u001a\u0004\u0018\u00010\u00068\u0006¢\u0006\f\n\u0004\b\u0007\u0010\u0018\u001a\u0004\b\u0019\u0010\u001aR\u0019\u0010\t\u001a\u0004\u0018\u00010\b8\u0006¢\u0006\f\n\u0004\b\t\u0010\u001b\u001a\u0004\b\u001c\u0010\u001d¨\u0006\u001f"}, d2 = {"Lcom/sputnik/common/entities/subscriptions/Plan;", "", "", "appstoreProductId", FFmpegMediaMetadataRetriever.METADATA_KEY_DURATION, "identifier", "", "price", "Lcom/sputnik/common/entities/subscriptions/Plan$Promo;", "promo", "<init>", "(Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/Integer;Lcom/sputnik/common/entities/subscriptions/Plan$Promo;)V", "toString", "()Ljava/lang/String;", "hashCode", "()I", "other", "", "equals", "(Ljava/lang/Object;)Z", "Ljava/lang/String;", "getAppstoreProductId", "getDuration", "getIdentifier", "Ljava/lang/Integer;", "getPrice", "()Ljava/lang/Integer;", "Lcom/sputnik/common/entities/subscriptions/Plan$Promo;", "getPromo", "()Lcom/sputnik/common/entities/subscriptions/Plan$Promo;", "Promo", "common_release"}, k = 1, mv = {1, 9, 0}, xi = 48)
/* loaded from: classes3.dex */
public final /* data */ class Plan {
    private final String appstoreProductId;
    private final String duration;
    private final String identifier;
    private final Integer price;
    private final Promo promo;

    public boolean equals(Object other) {
        if (this == other) {
            return true;
        }
        if (!(other instanceof Plan)) {
            return false;
        }
        Plan plan = (Plan) other;
        return Intrinsics.areEqual(this.appstoreProductId, plan.appstoreProductId) && Intrinsics.areEqual(this.duration, plan.duration) && Intrinsics.areEqual(this.identifier, plan.identifier) && Intrinsics.areEqual(this.price, plan.price) && Intrinsics.areEqual(this.promo, plan.promo);
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
        Promo promo = this.promo;
        return iHashCode4 + (promo != null ? promo.hashCode() : 0);
    }

    public String toString() {
        return "Plan(appstoreProductId=" + this.appstoreProductId + ", duration=" + this.duration + ", identifier=" + this.identifier + ", price=" + this.price + ", promo=" + this.promo + ")";
    }

    public Plan(String str, String str2, String str3, Integer num, Promo promo) {
        this.appstoreProductId = str;
        this.duration = str2;
        this.identifier = str3;
        this.price = num;
        this.promo = promo;
    }

    public final String getIdentifier() {
        return this.identifier;
    }

    public final Integer getPrice() {
        return this.price;
    }

    public final Promo getPromo() {
        return this.promo;
    }

    /* compiled from: Plan.kt */
    @Metadata(d1 = {"\u0000\u001e\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u000e\n\u0002\b\n\n\u0002\u0010\u000b\n\u0002\b\n\b\u0086\b\u0018\u00002\u00020\u0001B/\u0012\b\u0010\u0003\u001a\u0004\u0018\u00010\u0002\u0012\b\u0010\u0005\u001a\u0004\u0018\u00010\u0004\u0012\b\u0010\u0006\u001a\u0004\u0018\u00010\u0004\u0012\b\u0010\u0007\u001a\u0004\u0018\u00010\u0004¢\u0006\u0004\b\b\u0010\tJ\u0010\u0010\n\u001a\u00020\u0004HÖ\u0001¢\u0006\u0004\b\n\u0010\u000bJ\u0010\u0010\f\u001a\u00020\u0002HÖ\u0001¢\u0006\u0004\b\f\u0010\rJ\u001a\u0010\u0010\u001a\u00020\u000f2\b\u0010\u000e\u001a\u0004\u0018\u00010\u0001HÖ\u0003¢\u0006\u0004\b\u0010\u0010\u0011R\u001c\u0010\u0003\u001a\u0004\u0018\u00010\u00028\u0006X\u0087\u0004¢\u0006\f\n\u0004\b\u0003\u0010\u0012\u001a\u0004\b\u0013\u0010\u0014R\u0019\u0010\u0005\u001a\u0004\u0018\u00010\u00048\u0006¢\u0006\f\n\u0004\b\u0005\u0010\u0015\u001a\u0004\b\u0016\u0010\u000bR\u0019\u0010\u0006\u001a\u0004\u0018\u00010\u00048\u0006¢\u0006\f\n\u0004\b\u0006\u0010\u0015\u001a\u0004\b\u0017\u0010\u000bR\u001c\u0010\u0007\u001a\u0004\u0018\u00010\u00048\u0006X\u0087\u0004¢\u0006\f\n\u0004\b\u0007\u0010\u0015\u001a\u0004\b\u0018\u0010\u000b¨\u0006\u0019"}, d2 = {"Lcom/sputnik/common/entities/subscriptions/Plan$Promo;", "", "", "discountPrice", "", "description", "link", "linkText", "<init>", "(Ljava/lang/Integer;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;)V", "toString", "()Ljava/lang/String;", "hashCode", "()I", "other", "", "equals", "(Ljava/lang/Object;)Z", "Ljava/lang/Integer;", "getDiscountPrice", "()Ljava/lang/Integer;", "Ljava/lang/String;", "getDescription", "getLink", "getLinkText", "common_release"}, k = 1, mv = {1, 9, 0}, xi = 48)
    public static final /* data */ class Promo {
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
            if (!(other instanceof Promo)) {
                return false;
            }
            Promo promo = (Promo) other;
            return Intrinsics.areEqual(this.discountPrice, promo.discountPrice) && Intrinsics.areEqual(this.description, promo.description) && Intrinsics.areEqual(this.link, promo.link) && Intrinsics.areEqual(this.linkText, promo.linkText);
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
            return "Promo(discountPrice=" + this.discountPrice + ", description=" + this.description + ", link=" + this.link + ", linkText=" + this.linkText + ")";
        }

        public Promo(Integer num, String str, String str2, String str3) {
            this.discountPrice = num;
            this.description = str;
            this.link = str2;
            this.linkText = str3;
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

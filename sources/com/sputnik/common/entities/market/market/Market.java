package com.sputnik.common.entities.market.market;

import android.os.Parcel;
import android.os.Parcelable;
import com.sputnik.common.entities.subscriptions.SubscriptionAppearance;
import com.sputnik.domain.entities.market.MarketTypes;
import flussonic.media.FFmpegMediaMetadataRetriever;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import kotlin.Metadata;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import org.pjsip.pjsua2.pj_ssl_sock_proto;
import org.pjsip.pjsua2.pjmedia_tp_proto;

/* compiled from: Market.kt */
@Metadata(d1 = {"\u0000d\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010 \n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u000b\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0006\n\u0002\u0010\b\n\u0002\b\u0002\n\u0002\u0010\u0000\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u0002\n\u0002\b\u001d\b\u0087\b\u0018\u00002\u00020\u0001Bý\u0001\u0012\n\b\u0002\u0010\u0003\u001a\u0004\u0018\u00010\u0002\u0012\u0010\b\u0002\u0010\u0005\u001a\n\u0012\u0004\u0012\u00020\u0002\u0018\u00010\u0004\u0012\n\b\u0002\u0010\u0006\u001a\u0004\u0018\u00010\u0002\u0012\n\b\u0002\u0010\u0007\u001a\u0004\u0018\u00010\u0002\u0012\n\b\u0002\u0010\b\u001a\u0004\u0018\u00010\u0002\u0012\n\b\u0002\u0010\n\u001a\u0004\u0018\u00010\t\u0012\n\b\u0002\u0010\u000b\u001a\u0004\u0018\u00010\u0002\u0012\n\b\u0002\u0010\r\u001a\u0004\u0018\u00010\f\u0012\n\b\u0002\u0010\u000e\u001a\u0004\u0018\u00010\u0002\u0012\n\b\u0002\u0010\u0010\u001a\u0004\u0018\u00010\u000f\u0012\n\b\u0002\u0010\u0011\u001a\u0004\u0018\u00010\u0002\u0012\n\b\u0002\u0010\u0012\u001a\u0004\u0018\u00010\u0002\u0012\u0010\b\u0002\u0010\u0013\u001a\n\u0012\u0004\u0012\u00020\u0002\u0018\u00010\u0004\u0012\u0010\b\u0002\u0010\u0015\u001a\n\u0012\u0004\u0012\u00020\u0014\u0018\u00010\u0004\u0012\u0010\b\u0002\u0010\u0017\u001a\n\u0012\u0004\u0012\u00020\u0016\u0018\u00010\u0004\u0012\n\b\u0002\u0010\u0018\u001a\u0004\u0018\u00010\u0002\u0012\u0010\b\u0002\u0010\u001a\u001a\n\u0012\u0004\u0012\u00020\u0019\u0018\u00010\u0004\u0012\n\b\u0002\u0010\u001b\u001a\u0004\u0018\u00010\u0002¢\u0006\u0004\b\u001c\u0010\u001dJ\u0010\u0010\u001e\u001a\u00020\u0002HÖ\u0001¢\u0006\u0004\b\u001e\u0010\u001fJ\u0010\u0010!\u001a\u00020 HÖ\u0001¢\u0006\u0004\b!\u0010\"J\u001a\u0010%\u001a\u00020\f2\b\u0010$\u001a\u0004\u0018\u00010#HÖ\u0003¢\u0006\u0004\b%\u0010&J\u0010\u0010'\u001a\u00020 HÖ\u0001¢\u0006\u0004\b'\u0010\"J \u0010,\u001a\u00020+2\u0006\u0010)\u001a\u00020(2\u0006\u0010*\u001a\u00020 HÖ\u0001¢\u0006\u0004\b,\u0010-R\u0019\u0010\u0003\u001a\u0004\u0018\u00010\u00028\u0006¢\u0006\f\n\u0004\b\u0003\u0010.\u001a\u0004\b/\u0010\u001fR\u001f\u0010\u0005\u001a\n\u0012\u0004\u0012\u00020\u0002\u0018\u00010\u00048\u0006¢\u0006\f\n\u0004\b\u0005\u00100\u001a\u0004\b1\u00102R\u0019\u0010\u0006\u001a\u0004\u0018\u00010\u00028\u0006¢\u0006\f\n\u0004\b\u0006\u0010.\u001a\u0004\b3\u0010\u001fR\u0019\u0010\u0007\u001a\u0004\u0018\u00010\u00028\u0006¢\u0006\f\n\u0004\b\u0007\u0010.\u001a\u0004\b4\u0010\u001fR\u0019\u0010\b\u001a\u0004\u0018\u00010\u00028\u0006¢\u0006\f\n\u0004\b\b\u0010.\u001a\u0004\b5\u0010\u001fR\u0019\u0010\n\u001a\u0004\u0018\u00010\t8\u0006¢\u0006\f\n\u0004\b\n\u00106\u001a\u0004\b7\u00108R\u0019\u0010\u000b\u001a\u0004\u0018\u00010\u00028\u0006¢\u0006\f\n\u0004\b\u000b\u0010.\u001a\u0004\b9\u0010\u001fR\u0019\u0010\r\u001a\u0004\u0018\u00010\f8\u0006¢\u0006\f\n\u0004\b\r\u0010:\u001a\u0004\b\r\u0010;R\u0019\u0010\u000e\u001a\u0004\u0018\u00010\u00028\u0006¢\u0006\f\n\u0004\b\u000e\u0010.\u001a\u0004\b<\u0010\u001fR\u0019\u0010\u0010\u001a\u0004\u0018\u00010\u000f8\u0006¢\u0006\f\n\u0004\b\u0010\u0010=\u001a\u0004\b>\u0010?R\u0019\u0010\u0011\u001a\u0004\u0018\u00010\u00028\u0006¢\u0006\f\n\u0004\b\u0011\u0010.\u001a\u0004\b@\u0010\u001fR\u0019\u0010\u0012\u001a\u0004\u0018\u00010\u00028\u0006¢\u0006\f\n\u0004\b\u0012\u0010.\u001a\u0004\bA\u0010\u001fR\u001f\u0010\u0013\u001a\n\u0012\u0004\u0012\u00020\u0002\u0018\u00010\u00048\u0006¢\u0006\f\n\u0004\b\u0013\u00100\u001a\u0004\bB\u00102R\u001f\u0010\u0015\u001a\n\u0012\u0004\u0012\u00020\u0014\u0018\u00010\u00048\u0006¢\u0006\f\n\u0004\b\u0015\u00100\u001a\u0004\bC\u00102R\u001f\u0010\u0017\u001a\n\u0012\u0004\u0012\u00020\u0016\u0018\u00010\u00048\u0006¢\u0006\f\n\u0004\b\u0017\u00100\u001a\u0004\bD\u00102R\u0019\u0010\u0018\u001a\u0004\u0018\u00010\u00028\u0006¢\u0006\f\n\u0004\b\u0018\u0010.\u001a\u0004\bE\u0010\u001fR\u001f\u0010\u001a\u001a\n\u0012\u0004\u0012\u00020\u0019\u0018\u00010\u00048\u0006¢\u0006\f\n\u0004\b\u001a\u00100\u001a\u0004\bF\u00102R\u0019\u0010\u001b\u001a\u0004\u0018\u00010\u00028\u0006¢\u0006\f\n\u0004\b\u001b\u0010.\u001a\u0004\bG\u0010\u001f¨\u0006H"}, d2 = {"Lcom/sputnik/common/entities/market/market/Market;", "Landroid/os/Parcelable;", "", FFmpegMediaMetadataRetriever.METADATA_KEY_TITLE, "", "titleHeader", "description", "finale", "link", "Lcom/sputnik/domain/entities/market/MarketTypes;", "type", "identifier", "", "isSpecial", "specialDescription", "Lcom/sputnik/common/entities/market/market/Badge;", "badge", "priceVerbose", "subscriptionProductId", "featuresList", "Lcom/sputnik/common/entities/subscriptions/SubscriptionAppearance$FeaturePoint;", "featuresPoints", "Lcom/sputnik/common/entities/market/market/SubsPlans;", "plans", "plansTitle", "Lcom/sputnik/common/entities/market/market/SmallServices;", "includedServices", "includedServiceTitle", "<init>", "(Ljava/lang/String;Ljava/util/List;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Lcom/sputnik/domain/entities/market/MarketTypes;Ljava/lang/String;Ljava/lang/Boolean;Ljava/lang/String;Lcom/sputnik/common/entities/market/market/Badge;Ljava/lang/String;Ljava/lang/String;Ljava/util/List;Ljava/util/List;Ljava/util/List;Ljava/lang/String;Ljava/util/List;Ljava/lang/String;)V", "toString", "()Ljava/lang/String;", "", "hashCode", "()I", "", "other", "equals", "(Ljava/lang/Object;)Z", "describeContents", "Landroid/os/Parcel;", "parcel", "flags", "", "writeToParcel", "(Landroid/os/Parcel;I)V", "Ljava/lang/String;", "getTitle", "Ljava/util/List;", "getTitleHeader", "()Ljava/util/List;", "getDescription", "getFinale", "getLink", "Lcom/sputnik/domain/entities/market/MarketTypes;", "getType", "()Lcom/sputnik/domain/entities/market/MarketTypes;", "getIdentifier", "Ljava/lang/Boolean;", "()Ljava/lang/Boolean;", "getSpecialDescription", "Lcom/sputnik/common/entities/market/market/Badge;", "getBadge", "()Lcom/sputnik/common/entities/market/market/Badge;", "getPriceVerbose", "getSubscriptionProductId", "getFeaturesList", "getFeaturesPoints", "getPlans", "getPlansTitle", "getIncludedServices", "getIncludedServiceTitle", "common_release"}, k = 1, mv = {1, 9, 0}, xi = 48)
/* loaded from: classes3.dex */
public final /* data */ class Market implements Parcelable {
    public static final Parcelable.Creator<Market> CREATOR = new Creator();
    private final Badge badge;
    private final String description;
    private final List<String> featuresList;
    private final List<SubscriptionAppearance.FeaturePoint> featuresPoints;
    private final String finale;
    private final String identifier;
    private final String includedServiceTitle;
    private final List<SmallServices> includedServices;
    private final Boolean isSpecial;
    private final String link;
    private final List<SubsPlans> plans;
    private final String plansTitle;
    private final String priceVerbose;
    private final String specialDescription;
    private final String subscriptionProductId;
    private final String title;
    private final List<String> titleHeader;
    private final MarketTypes type;

    /* compiled from: Market.kt */
    @Metadata(k = 3, mv = {1, 9, 0}, xi = 48)
    public static final class Creator implements Parcelable.Creator<Market> {
        /* JADX WARN: Can't rename method to resolve collision */
        @Override // android.os.Parcelable.Creator
        public final Market createFromParcel(Parcel parcel) {
            Boolean boolValueOf;
            ArrayList<String> arrayList;
            ArrayList arrayList2;
            ArrayList arrayList3;
            ArrayList arrayList4;
            Intrinsics.checkNotNullParameter(parcel, "parcel");
            String string = parcel.readString();
            ArrayList<String> arrayListCreateStringArrayList = parcel.createStringArrayList();
            String string2 = parcel.readString();
            String string3 = parcel.readString();
            String string4 = parcel.readString();
            MarketTypes marketTypesValueOf = parcel.readInt() == 0 ? null : MarketTypes.valueOf(parcel.readString());
            String string5 = parcel.readString();
            if (parcel.readInt() == 0) {
                boolValueOf = null;
            } else {
                boolValueOf = Boolean.valueOf(parcel.readInt() != 0);
            }
            String string6 = parcel.readString();
            Badge badgeCreateFromParcel = parcel.readInt() == 0 ? null : Badge.CREATOR.createFromParcel(parcel);
            String string7 = parcel.readString();
            String string8 = parcel.readString();
            ArrayList<String> arrayListCreateStringArrayList2 = parcel.createStringArrayList();
            if (parcel.readInt() == 0) {
                arrayList = arrayListCreateStringArrayList2;
                arrayList2 = null;
            } else {
                int i = parcel.readInt();
                ArrayList arrayList5 = new ArrayList(i);
                arrayList = arrayListCreateStringArrayList2;
                int i2 = 0;
                while (i2 != i) {
                    arrayList5.add(SubscriptionAppearance.FeaturePoint.CREATOR.createFromParcel(parcel));
                    i2++;
                    i = i;
                }
                arrayList2 = arrayList5;
            }
            if (parcel.readInt() == 0) {
                arrayList3 = null;
            } else {
                int i3 = parcel.readInt();
                ArrayList arrayList6 = new ArrayList(i3);
                int i4 = 0;
                while (i4 != i3) {
                    arrayList6.add(SubsPlans.CREATOR.createFromParcel(parcel));
                    i4++;
                    i3 = i3;
                }
                arrayList3 = arrayList6;
            }
            String string9 = parcel.readString();
            if (parcel.readInt() == 0) {
                arrayList4 = null;
            } else {
                int i5 = parcel.readInt();
                ArrayList arrayList7 = new ArrayList(i5);
                int i6 = 0;
                while (i6 != i5) {
                    arrayList7.add(SmallServices.CREATOR.createFromParcel(parcel));
                    i6++;
                    i5 = i5;
                }
                arrayList4 = arrayList7;
            }
            return new Market(string, arrayListCreateStringArrayList, string2, string3, string4, marketTypesValueOf, string5, boolValueOf, string6, badgeCreateFromParcel, string7, string8, arrayList, arrayList2, arrayList3, string9, arrayList4, parcel.readString());
        }

        /* JADX WARN: Can't rename method to resolve collision */
        @Override // android.os.Parcelable.Creator
        public final Market[] newArray(int i) {
            return new Market[i];
        }
    }

    public Market() {
        this(null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, 262143, null);
    }

    @Override // android.os.Parcelable
    public int describeContents() {
        return 0;
    }

    public boolean equals(Object other) {
        if (this == other) {
            return true;
        }
        if (!(other instanceof Market)) {
            return false;
        }
        Market market = (Market) other;
        return Intrinsics.areEqual(this.title, market.title) && Intrinsics.areEqual(this.titleHeader, market.titleHeader) && Intrinsics.areEqual(this.description, market.description) && Intrinsics.areEqual(this.finale, market.finale) && Intrinsics.areEqual(this.link, market.link) && this.type == market.type && Intrinsics.areEqual(this.identifier, market.identifier) && Intrinsics.areEqual(this.isSpecial, market.isSpecial) && Intrinsics.areEqual(this.specialDescription, market.specialDescription) && Intrinsics.areEqual(this.badge, market.badge) && Intrinsics.areEqual(this.priceVerbose, market.priceVerbose) && Intrinsics.areEqual(this.subscriptionProductId, market.subscriptionProductId) && Intrinsics.areEqual(this.featuresList, market.featuresList) && Intrinsics.areEqual(this.featuresPoints, market.featuresPoints) && Intrinsics.areEqual(this.plans, market.plans) && Intrinsics.areEqual(this.plansTitle, market.plansTitle) && Intrinsics.areEqual(this.includedServices, market.includedServices) && Intrinsics.areEqual(this.includedServiceTitle, market.includedServiceTitle);
    }

    public int hashCode() {
        String str = this.title;
        int iHashCode = (str == null ? 0 : str.hashCode()) * 31;
        List<String> list = this.titleHeader;
        int iHashCode2 = (iHashCode + (list == null ? 0 : list.hashCode())) * 31;
        String str2 = this.description;
        int iHashCode3 = (iHashCode2 + (str2 == null ? 0 : str2.hashCode())) * 31;
        String str3 = this.finale;
        int iHashCode4 = (iHashCode3 + (str3 == null ? 0 : str3.hashCode())) * 31;
        String str4 = this.link;
        int iHashCode5 = (iHashCode4 + (str4 == null ? 0 : str4.hashCode())) * 31;
        MarketTypes marketTypes = this.type;
        int iHashCode6 = (iHashCode5 + (marketTypes == null ? 0 : marketTypes.hashCode())) * 31;
        String str5 = this.identifier;
        int iHashCode7 = (iHashCode6 + (str5 == null ? 0 : str5.hashCode())) * 31;
        Boolean bool = this.isSpecial;
        int iHashCode8 = (iHashCode7 + (bool == null ? 0 : bool.hashCode())) * 31;
        String str6 = this.specialDescription;
        int iHashCode9 = (iHashCode8 + (str6 == null ? 0 : str6.hashCode())) * 31;
        Badge badge = this.badge;
        int iHashCode10 = (iHashCode9 + (badge == null ? 0 : badge.hashCode())) * 31;
        String str7 = this.priceVerbose;
        int iHashCode11 = (iHashCode10 + (str7 == null ? 0 : str7.hashCode())) * 31;
        String str8 = this.subscriptionProductId;
        int iHashCode12 = (iHashCode11 + (str8 == null ? 0 : str8.hashCode())) * 31;
        List<String> list2 = this.featuresList;
        int iHashCode13 = (iHashCode12 + (list2 == null ? 0 : list2.hashCode())) * 31;
        List<SubscriptionAppearance.FeaturePoint> list3 = this.featuresPoints;
        int iHashCode14 = (iHashCode13 + (list3 == null ? 0 : list3.hashCode())) * 31;
        List<SubsPlans> list4 = this.plans;
        int iHashCode15 = (iHashCode14 + (list4 == null ? 0 : list4.hashCode())) * 31;
        String str9 = this.plansTitle;
        int iHashCode16 = (iHashCode15 + (str9 == null ? 0 : str9.hashCode())) * 31;
        List<SmallServices> list5 = this.includedServices;
        int iHashCode17 = (iHashCode16 + (list5 == null ? 0 : list5.hashCode())) * 31;
        String str10 = this.includedServiceTitle;
        return iHashCode17 + (str10 != null ? str10.hashCode() : 0);
    }

    public String toString() {
        return "Market(title=" + this.title + ", titleHeader=" + this.titleHeader + ", description=" + this.description + ", finale=" + this.finale + ", link=" + this.link + ", type=" + this.type + ", identifier=" + this.identifier + ", isSpecial=" + this.isSpecial + ", specialDescription=" + this.specialDescription + ", badge=" + this.badge + ", priceVerbose=" + this.priceVerbose + ", subscriptionProductId=" + this.subscriptionProductId + ", featuresList=" + this.featuresList + ", featuresPoints=" + this.featuresPoints + ", plans=" + this.plans + ", plansTitle=" + this.plansTitle + ", includedServices=" + this.includedServices + ", includedServiceTitle=" + this.includedServiceTitle + ")";
    }

    @Override // android.os.Parcelable
    public void writeToParcel(Parcel parcel, int flags) {
        Intrinsics.checkNotNullParameter(parcel, "out");
        parcel.writeString(this.title);
        parcel.writeStringList(this.titleHeader);
        parcel.writeString(this.description);
        parcel.writeString(this.finale);
        parcel.writeString(this.link);
        MarketTypes marketTypes = this.type;
        if (marketTypes == null) {
            parcel.writeInt(0);
        } else {
            parcel.writeInt(1);
            parcel.writeString(marketTypes.name());
        }
        parcel.writeString(this.identifier);
        Boolean bool = this.isSpecial;
        if (bool == null) {
            parcel.writeInt(0);
        } else {
            parcel.writeInt(1);
            parcel.writeInt(bool.booleanValue() ? 1 : 0);
        }
        parcel.writeString(this.specialDescription);
        Badge badge = this.badge;
        if (badge == null) {
            parcel.writeInt(0);
        } else {
            parcel.writeInt(1);
            badge.writeToParcel(parcel, flags);
        }
        parcel.writeString(this.priceVerbose);
        parcel.writeString(this.subscriptionProductId);
        parcel.writeStringList(this.featuresList);
        List<SubscriptionAppearance.FeaturePoint> list = this.featuresPoints;
        if (list == null) {
            parcel.writeInt(0);
        } else {
            parcel.writeInt(1);
            parcel.writeInt(list.size());
            Iterator<SubscriptionAppearance.FeaturePoint> it = list.iterator();
            while (it.hasNext()) {
                it.next().writeToParcel(parcel, flags);
            }
        }
        List<SubsPlans> list2 = this.plans;
        if (list2 == null) {
            parcel.writeInt(0);
        } else {
            parcel.writeInt(1);
            parcel.writeInt(list2.size());
            Iterator<SubsPlans> it2 = list2.iterator();
            while (it2.hasNext()) {
                it2.next().writeToParcel(parcel, flags);
            }
        }
        parcel.writeString(this.plansTitle);
        List<SmallServices> list3 = this.includedServices;
        if (list3 == null) {
            parcel.writeInt(0);
        } else {
            parcel.writeInt(1);
            parcel.writeInt(list3.size());
            Iterator<SmallServices> it3 = list3.iterator();
            while (it3.hasNext()) {
                it3.next().writeToParcel(parcel, flags);
            }
        }
        parcel.writeString(this.includedServiceTitle);
    }

    public Market(String str, List<String> list, String str2, String str3, String str4, MarketTypes marketTypes, String str5, Boolean bool, String str6, Badge badge, String str7, String str8, List<String> list2, List<SubscriptionAppearance.FeaturePoint> list3, List<SubsPlans> list4, String str9, List<SmallServices> list5, String str10) {
        this.title = str;
        this.titleHeader = list;
        this.description = str2;
        this.finale = str3;
        this.link = str4;
        this.type = marketTypes;
        this.identifier = str5;
        this.isSpecial = bool;
        this.specialDescription = str6;
        this.badge = badge;
        this.priceVerbose = str7;
        this.subscriptionProductId = str8;
        this.featuresList = list2;
        this.featuresPoints = list3;
        this.plans = list4;
        this.plansTitle = str9;
        this.includedServices = list5;
        this.includedServiceTitle = str10;
    }

    public /* synthetic */ Market(String str, List list, String str2, String str3, String str4, MarketTypes marketTypes, String str5, Boolean bool, String str6, Badge badge, String str7, String str8, List list2, List list3, List list4, String str9, List list5, String str10, int i, DefaultConstructorMarker defaultConstructorMarker) {
        this((i & 1) != 0 ? null : str, (i & 2) != 0 ? null : list, (i & 4) != 0 ? null : str2, (i & 8) != 0 ? null : str3, (i & 16) != 0 ? null : str4, (i & 32) != 0 ? null : marketTypes, (i & 64) != 0 ? null : str5, (i & 128) != 0 ? null : bool, (i & 256) != 0 ? null : str6, (i & 512) != 0 ? null : badge, (i & 1024) != 0 ? null : str7, (i & 2048) != 0 ? null : str8, (i & 4096) != 0 ? null : list2, (i & 8192) != 0 ? null : list3, (i & 16384) != 0 ? null : list4, (i & pjmedia_tp_proto.PJMEDIA_TP_PROFILE_AVP) != 0 ? null : str9, (i & pj_ssl_sock_proto.PJ_SSL_SOCK_PROTO_DTLS1) != 0 ? null : list5, (i & 131072) != 0 ? null : str10);
    }

    public final List<String> getTitleHeader() {
        return this.titleHeader;
    }

    public final MarketTypes getType() {
        return this.type;
    }

    public final Badge getBadge() {
        return this.badge;
    }

    public final String getSubscriptionProductId() {
        return this.subscriptionProductId;
    }

    public final List<String> getFeaturesList() {
        return this.featuresList;
    }

    public final List<SubsPlans> getPlans() {
        return this.plans;
    }

    public final String getPlansTitle() {
        return this.plansTitle;
    }

    public final List<SmallServices> getIncludedServices() {
        return this.includedServices;
    }

    public final String getIncludedServiceTitle() {
        return this.includedServiceTitle;
    }
}

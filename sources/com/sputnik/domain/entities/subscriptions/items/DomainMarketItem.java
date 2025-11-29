package com.sputnik.domain.entities.subscriptions.items;

import com.huawei.hms.push.constant.RemoteMessageConst;
import com.sputnik.domain.entities.market.ItemTypes;
import flussonic.media.FFmpegMediaMetadataRetriever;
import java.util.List;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

/* compiled from: DomainMarketItem.kt */
@Metadata(d1 = {"\u0000*\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0018\u0002\n\u0002\b\b\n\u0002\u0010\u000b\n\u0002\b\u0010\b\u0086\b\u0018\u00002\u00020\u0001:\u0002\u001f B/\u0012\b\u0010\u0003\u001a\u0004\u0018\u00010\u0002\u0012\b\u0010\u0005\u001a\u0004\u0018\u00010\u0004\u0012\b\u0010\u0007\u001a\u0004\u0018\u00010\u0006\u0012\b\u0010\t\u001a\u0004\u0018\u00010\b¢\u0006\u0004\b\n\u0010\u000bJ\u0010\u0010\f\u001a\u00020\u0002HÖ\u0001¢\u0006\u0004\b\f\u0010\rJ\u0010\u0010\u000e\u001a\u00020\u0006HÖ\u0001¢\u0006\u0004\b\u000e\u0010\u000fJ\u001a\u0010\u0012\u001a\u00020\u00112\b\u0010\u0010\u001a\u0004\u0018\u00010\u0001HÖ\u0003¢\u0006\u0004\b\u0012\u0010\u0013R\u0019\u0010\u0003\u001a\u0004\u0018\u00010\u00028\u0006¢\u0006\f\n\u0004\b\u0003\u0010\u0014\u001a\u0004\b\u0015\u0010\rR\u0019\u0010\u0005\u001a\u0004\u0018\u00010\u00048\u0006¢\u0006\f\n\u0004\b\u0005\u0010\u0016\u001a\u0004\b\u0017\u0010\u0018R\u0019\u0010\u0007\u001a\u0004\u0018\u00010\u00068\u0006¢\u0006\f\n\u0004\b\u0007\u0010\u0019\u001a\u0004\b\u001a\u0010\u001bR\u0019\u0010\t\u001a\u0004\u0018\u00010\b8\u0006¢\u0006\f\n\u0004\b\t\u0010\u001c\u001a\u0004\b\u001d\u0010\u001e¨\u0006!"}, d2 = {"Lcom/sputnik/domain/entities/subscriptions/items/DomainMarketItem;", "", "", "identifier", "Lcom/sputnik/domain/entities/market/ItemTypes;", "type", "", "order", "Lcom/sputnik/domain/entities/subscriptions/items/DomainMarketItem$DomainMarketItemAppearance;", "appearance", "<init>", "(Ljava/lang/String;Lcom/sputnik/domain/entities/market/ItemTypes;Ljava/lang/Integer;Lcom/sputnik/domain/entities/subscriptions/items/DomainMarketItem$DomainMarketItemAppearance;)V", "toString", "()Ljava/lang/String;", "hashCode", "()I", "other", "", "equals", "(Ljava/lang/Object;)Z", "Ljava/lang/String;", "getIdentifier", "Lcom/sputnik/domain/entities/market/ItemTypes;", "getType", "()Lcom/sputnik/domain/entities/market/ItemTypes;", "Ljava/lang/Integer;", "getOrder", "()Ljava/lang/Integer;", "Lcom/sputnik/domain/entities/subscriptions/items/DomainMarketItem$DomainMarketItemAppearance;", "getAppearance", "()Lcom/sputnik/domain/entities/subscriptions/items/DomainMarketItem$DomainMarketItemAppearance;", "DetailedLayout", "DomainMarketItemAppearance", "domain"}, k = 1, mv = {1, 9, 0}, xi = 48)
/* loaded from: classes3.dex */
public final /* data */ class DomainMarketItem {
    private final DomainMarketItemAppearance appearance;
    private final String identifier;
    private final Integer order;
    private final ItemTypes type;

    public boolean equals(Object other) {
        if (this == other) {
            return true;
        }
        if (!(other instanceof DomainMarketItem)) {
            return false;
        }
        DomainMarketItem domainMarketItem = (DomainMarketItem) other;
        return Intrinsics.areEqual(this.identifier, domainMarketItem.identifier) && this.type == domainMarketItem.type && Intrinsics.areEqual(this.order, domainMarketItem.order) && Intrinsics.areEqual(this.appearance, domainMarketItem.appearance);
    }

    public int hashCode() {
        String str = this.identifier;
        int iHashCode = (str == null ? 0 : str.hashCode()) * 31;
        ItemTypes itemTypes = this.type;
        int iHashCode2 = (iHashCode + (itemTypes == null ? 0 : itemTypes.hashCode())) * 31;
        Integer num = this.order;
        int iHashCode3 = (iHashCode2 + (num == null ? 0 : num.hashCode())) * 31;
        DomainMarketItemAppearance domainMarketItemAppearance = this.appearance;
        return iHashCode3 + (domainMarketItemAppearance != null ? domainMarketItemAppearance.hashCode() : 0);
    }

    public String toString() {
        return "DomainMarketItem(identifier=" + this.identifier + ", type=" + this.type + ", order=" + this.order + ", appearance=" + this.appearance + ")";
    }

    public DomainMarketItem(String str, ItemTypes itemTypes, Integer num, DomainMarketItemAppearance domainMarketItemAppearance) {
        this.identifier = str;
        this.type = itemTypes;
        this.order = num;
        this.appearance = domainMarketItemAppearance;
    }

    public final String getIdentifier() {
        return this.identifier;
    }

    public final ItemTypes getType() {
        return this.type;
    }

    public final Integer getOrder() {
        return this.order;
    }

    public final DomainMarketItemAppearance getAppearance() {
        return this.appearance;
    }

    /* compiled from: DomainMarketItem.kt */
    @Metadata(d1 = {"\u0000:\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010 \n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0010\b\n\u0002\b\u0003\n\u0002\u0010\u000b\n\u0002\b\u0014\b\u0086\b\u0018\u00002\u00020\u0001:\u0002'(BI\u0012\b\u0010\u0003\u001a\u0004\u0018\u00010\u0002\u0012\u000e\b\u0002\u0010\u0005\u001a\b\u0012\u0004\u0012\u00020\u00020\u0004\u0012\b\u0010\u0006\u001a\u0004\u0018\u00010\u0002\u0012\b\u0010\b\u001a\u0004\u0018\u00010\u0007\u0012\b\u0010\n\u001a\u0004\u0018\u00010\t\u0012\b\u0010\f\u001a\u0004\u0018\u00010\u000b¢\u0006\u0004\b\r\u0010\u000eJ\u0010\u0010\u000f\u001a\u00020\u0002HÖ\u0001¢\u0006\u0004\b\u000f\u0010\u0010J\u0010\u0010\u0012\u001a\u00020\u0011HÖ\u0001¢\u0006\u0004\b\u0012\u0010\u0013J\u001a\u0010\u0016\u001a\u00020\u00152\b\u0010\u0014\u001a\u0004\u0018\u00010\u0001HÖ\u0003¢\u0006\u0004\b\u0016\u0010\u0017R\u0019\u0010\u0003\u001a\u0004\u0018\u00010\u00028\u0006¢\u0006\f\n\u0004\b\u0003\u0010\u0018\u001a\u0004\b\u0019\u0010\u0010R\u001d\u0010\u0005\u001a\b\u0012\u0004\u0012\u00020\u00020\u00048\u0006¢\u0006\f\n\u0004\b\u0005\u0010\u001a\u001a\u0004\b\u001b\u0010\u001cR\u0019\u0010\u0006\u001a\u0004\u0018\u00010\u00028\u0006¢\u0006\f\n\u0004\b\u0006\u0010\u0018\u001a\u0004\b\u001d\u0010\u0010R\u0019\u0010\b\u001a\u0004\u0018\u00010\u00078\u0006¢\u0006\f\n\u0004\b\b\u0010\u001e\u001a\u0004\b\u001f\u0010 R\u0019\u0010\n\u001a\u0004\u0018\u00010\t8\u0006¢\u0006\f\n\u0004\b\n\u0010!\u001a\u0004\b\"\u0010#R\u0019\u0010\f\u001a\u0004\u0018\u00010\u000b8\u0006¢\u0006\f\n\u0004\b\f\u0010$\u001a\u0004\b%\u0010&¨\u0006)"}, d2 = {"Lcom/sputnik/domain/entities/subscriptions/items/DomainMarketItem$DomainMarketItemAppearance;", "", "", FFmpegMediaMetadataRetriever.METADATA_KEY_TITLE, "", "featuresList", "imageLink", "Lcom/sputnik/domain/entities/subscriptions/items/DomainMarketItem$DomainMarketItemAppearance$TextTitle;", "finale", "Lcom/sputnik/domain/entities/subscriptions/items/DomainMarketItem$DomainMarketItemAppearance$Deeplink;", "onTap", "Lcom/sputnik/domain/entities/subscriptions/items/DomainMarketItem$DetailedLayout;", "detailedLayout", "<init>", "(Ljava/lang/String;Ljava/util/List;Ljava/lang/String;Lcom/sputnik/domain/entities/subscriptions/items/DomainMarketItem$DomainMarketItemAppearance$TextTitle;Lcom/sputnik/domain/entities/subscriptions/items/DomainMarketItem$DomainMarketItemAppearance$Deeplink;Lcom/sputnik/domain/entities/subscriptions/items/DomainMarketItem$DetailedLayout;)V", "toString", "()Ljava/lang/String;", "", "hashCode", "()I", "other", "", "equals", "(Ljava/lang/Object;)Z", "Ljava/lang/String;", "getTitle", "Ljava/util/List;", "getFeaturesList", "()Ljava/util/List;", "getImageLink", "Lcom/sputnik/domain/entities/subscriptions/items/DomainMarketItem$DomainMarketItemAppearance$TextTitle;", "getFinale", "()Lcom/sputnik/domain/entities/subscriptions/items/DomainMarketItem$DomainMarketItemAppearance$TextTitle;", "Lcom/sputnik/domain/entities/subscriptions/items/DomainMarketItem$DomainMarketItemAppearance$Deeplink;", "getOnTap", "()Lcom/sputnik/domain/entities/subscriptions/items/DomainMarketItem$DomainMarketItemAppearance$Deeplink;", "Lcom/sputnik/domain/entities/subscriptions/items/DomainMarketItem$DetailedLayout;", "getDetailedLayout", "()Lcom/sputnik/domain/entities/subscriptions/items/DomainMarketItem$DetailedLayout;", "Deeplink", "TextTitle", "domain"}, k = 1, mv = {1, 9, 0}, xi = 48)
    public static final /* data */ class DomainMarketItemAppearance {
        private final DetailedLayout detailedLayout;
        private final List<String> featuresList;
        private final TextTitle finale;
        private final String imageLink;
        private final Deeplink onTap;
        private final String title;

        public boolean equals(Object other) {
            if (this == other) {
                return true;
            }
            if (!(other instanceof DomainMarketItemAppearance)) {
                return false;
            }
            DomainMarketItemAppearance domainMarketItemAppearance = (DomainMarketItemAppearance) other;
            return Intrinsics.areEqual(this.title, domainMarketItemAppearance.title) && Intrinsics.areEqual(this.featuresList, domainMarketItemAppearance.featuresList) && Intrinsics.areEqual(this.imageLink, domainMarketItemAppearance.imageLink) && Intrinsics.areEqual(this.finale, domainMarketItemAppearance.finale) && Intrinsics.areEqual(this.onTap, domainMarketItemAppearance.onTap) && Intrinsics.areEqual(this.detailedLayout, domainMarketItemAppearance.detailedLayout);
        }

        public int hashCode() {
            String str = this.title;
            int iHashCode = (((str == null ? 0 : str.hashCode()) * 31) + this.featuresList.hashCode()) * 31;
            String str2 = this.imageLink;
            int iHashCode2 = (iHashCode + (str2 == null ? 0 : str2.hashCode())) * 31;
            TextTitle textTitle = this.finale;
            int iHashCode3 = (iHashCode2 + (textTitle == null ? 0 : textTitle.hashCode())) * 31;
            Deeplink deeplink = this.onTap;
            int iHashCode4 = (iHashCode3 + (deeplink == null ? 0 : deeplink.hashCode())) * 31;
            DetailedLayout detailedLayout = this.detailedLayout;
            return iHashCode4 + (detailedLayout != null ? detailedLayout.hashCode() : 0);
        }

        public String toString() {
            return "DomainMarketItemAppearance(title=" + this.title + ", featuresList=" + this.featuresList + ", imageLink=" + this.imageLink + ", finale=" + this.finale + ", onTap=" + this.onTap + ", detailedLayout=" + this.detailedLayout + ")";
        }

        public DomainMarketItemAppearance(String str, List<String> featuresList, String str2, TextTitle textTitle, Deeplink deeplink, DetailedLayout detailedLayout) {
            Intrinsics.checkNotNullParameter(featuresList, "featuresList");
            this.title = str;
            this.featuresList = featuresList;
            this.imageLink = str2;
            this.finale = textTitle;
            this.onTap = deeplink;
            this.detailedLayout = detailedLayout;
        }

        public final String getTitle() {
            return this.title;
        }

        public final List<String> getFeaturesList() {
            return this.featuresList;
        }

        public final String getImageLink() {
            return this.imageLink;
        }

        public final TextTitle getFinale() {
            return this.finale;
        }

        public final Deeplink getOnTap() {
            return this.onTap;
        }

        public final DetailedLayout getDetailedLayout() {
            return this.detailedLayout;
        }

        /* compiled from: DomainMarketItem.kt */
        @Metadata(d1 = {"\u0000 \n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0010\u000e\n\u0002\b\u0006\n\u0002\u0010\b\n\u0002\b\u0003\n\u0002\u0010\u000b\n\u0002\b\u0006\b\u0086\b\u0018\u00002\u00020\u0001B\u001b\u0012\b\u0010\u0003\u001a\u0004\u0018\u00010\u0002\u0012\b\u0010\u0004\u001a\u0004\u0018\u00010\u0002¢\u0006\u0004\b\u0005\u0010\u0006J\u0010\u0010\u0007\u001a\u00020\u0002HÖ\u0001¢\u0006\u0004\b\u0007\u0010\bJ\u0010\u0010\n\u001a\u00020\tHÖ\u0001¢\u0006\u0004\b\n\u0010\u000bJ\u001a\u0010\u000e\u001a\u00020\r2\b\u0010\f\u001a\u0004\u0018\u00010\u0001HÖ\u0003¢\u0006\u0004\b\u000e\u0010\u000fR\u0019\u0010\u0003\u001a\u0004\u0018\u00010\u00028\u0006¢\u0006\f\n\u0004\b\u0003\u0010\u0010\u001a\u0004\b\u0011\u0010\bR\u0019\u0010\u0004\u001a\u0004\u0018\u00010\u00028\u0006¢\u0006\f\n\u0004\b\u0004\u0010\u0010\u001a\u0004\b\u0012\u0010\b¨\u0006\u0013"}, d2 = {"Lcom/sputnik/domain/entities/subscriptions/items/DomainMarketItem$DomainMarketItemAppearance$TextTitle;", "", "", FFmpegMediaMetadataRetriever.METADATA_KEY_TITLE, "link", "<init>", "(Ljava/lang/String;Ljava/lang/String;)V", "toString", "()Ljava/lang/String;", "", "hashCode", "()I", "other", "", "equals", "(Ljava/lang/Object;)Z", "Ljava/lang/String;", "getTitle", "getLink", "domain"}, k = 1, mv = {1, 9, 0}, xi = 48)
        public static final /* data */ class TextTitle {
            private final String link;
            private final String title;

            public boolean equals(Object other) {
                if (this == other) {
                    return true;
                }
                if (!(other instanceof TextTitle)) {
                    return false;
                }
                TextTitle textTitle = (TextTitle) other;
                return Intrinsics.areEqual(this.title, textTitle.title) && Intrinsics.areEqual(this.link, textTitle.link);
            }

            public int hashCode() {
                String str = this.title;
                int iHashCode = (str == null ? 0 : str.hashCode()) * 31;
                String str2 = this.link;
                return iHashCode + (str2 != null ? str2.hashCode() : 0);
            }

            public String toString() {
                return "TextTitle(title=" + this.title + ", link=" + this.link + ")";
            }

            public TextTitle(String str, String str2) {
                this.title = str;
                this.link = str2;
            }

            public final String getTitle() {
                return this.title;
            }

            public final String getLink() {
                return this.link;
            }
        }

        /* compiled from: DomainMarketItem.kt */
        @Metadata(d1 = {"\u0000 \n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0010\u000e\n\u0002\b\u0005\n\u0002\u0010\b\n\u0002\b\u0003\n\u0002\u0010\u000b\n\u0002\b\u0005\b\u0086\b\u0018\u00002\u00020\u0001B\u0011\u0012\b\u0010\u0003\u001a\u0004\u0018\u00010\u0002¢\u0006\u0004\b\u0004\u0010\u0005J\u0010\u0010\u0006\u001a\u00020\u0002HÖ\u0001¢\u0006\u0004\b\u0006\u0010\u0007J\u0010\u0010\t\u001a\u00020\bHÖ\u0001¢\u0006\u0004\b\t\u0010\nJ\u001a\u0010\r\u001a\u00020\f2\b\u0010\u000b\u001a\u0004\u0018\u00010\u0001HÖ\u0003¢\u0006\u0004\b\r\u0010\u000eR\u0019\u0010\u0003\u001a\u0004\u0018\u00010\u00028\u0006¢\u0006\f\n\u0004\b\u0003\u0010\u000f\u001a\u0004\b\u0010\u0010\u0007¨\u0006\u0011"}, d2 = {"Lcom/sputnik/domain/entities/subscriptions/items/DomainMarketItem$DomainMarketItemAppearance$Deeplink;", "", "", "deeplink", "<init>", "(Ljava/lang/String;)V", "toString", "()Ljava/lang/String;", "", "hashCode", "()I", "other", "", "equals", "(Ljava/lang/Object;)Z", "Ljava/lang/String;", "getDeeplink", "domain"}, k = 1, mv = {1, 9, 0}, xi = 48)
        public static final /* data */ class Deeplink {
            private final String deeplink;

            public boolean equals(Object other) {
                if (this == other) {
                    return true;
                }
                return (other instanceof Deeplink) && Intrinsics.areEqual(this.deeplink, ((Deeplink) other).deeplink);
            }

            public int hashCode() {
                String str = this.deeplink;
                if (str == null) {
                    return 0;
                }
                return str.hashCode();
            }

            public String toString() {
                return "Deeplink(deeplink=" + this.deeplink + ")";
            }

            public Deeplink(String str) {
                this.deeplink = str;
            }

            public final String getDeeplink() {
                return this.deeplink;
            }
        }
    }

    /* compiled from: DomainMarketItem.kt */
    @Metadata(d1 = {"\u0000D\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u000e\n\u0002\b\u0002\n\u0002\u0010\b\n\u0002\b\u0003\n\u0002\u0010\u000b\n\u0002\b\u0018\b\u0086\b\u0018\u00002\u00020\u0001:\u0006()*+,-B?\u0012\b\u0010\u0003\u001a\u0004\u0018\u00010\u0002\u0012\u000e\b\u0002\u0010\u0006\u001a\b\u0012\u0004\u0012\u00020\u00050\u0004\u0012\b\u0010\b\u001a\u0004\u0018\u00010\u0007\u0012\b\u0010\n\u001a\u0004\u0018\u00010\t\u0012\b\u0010\f\u001a\u0004\u0018\u00010\u000b¢\u0006\u0004\b\r\u0010\u000eJ\u0010\u0010\u0010\u001a\u00020\u000fHÖ\u0001¢\u0006\u0004\b\u0010\u0010\u0011J\u0010\u0010\u0013\u001a\u00020\u0012HÖ\u0001¢\u0006\u0004\b\u0013\u0010\u0014J\u001a\u0010\u0017\u001a\u00020\u00162\b\u0010\u0015\u001a\u0004\u0018\u00010\u0001HÖ\u0003¢\u0006\u0004\b\u0017\u0010\u0018R\u0019\u0010\u0003\u001a\u0004\u0018\u00010\u00028\u0006¢\u0006\f\n\u0004\b\u0003\u0010\u0019\u001a\u0004\b\u001a\u0010\u001bR\u001d\u0010\u0006\u001a\b\u0012\u0004\u0012\u00020\u00050\u00048\u0006¢\u0006\f\n\u0004\b\u0006\u0010\u001c\u001a\u0004\b\u001d\u0010\u001eR\u0019\u0010\b\u001a\u0004\u0018\u00010\u00078\u0006¢\u0006\f\n\u0004\b\b\u0010\u001f\u001a\u0004\b \u0010!R\u0019\u0010\n\u001a\u0004\u0018\u00010\t8\u0006¢\u0006\f\n\u0004\b\n\u0010\"\u001a\u0004\b#\u0010$R\u0019\u0010\f\u001a\u0004\u0018\u00010\u000b8\u0006¢\u0006\f\n\u0004\b\f\u0010%\u001a\u0004\b&\u0010'¨\u0006."}, d2 = {"Lcom/sputnik/domain/entities/subscriptions/items/DomainMarketItem$DetailedLayout;", "", "Lcom/sputnik/domain/entities/subscriptions/items/DomainMarketItem$DetailedLayout$Header;", "header", "", "Lcom/sputnik/domain/entities/subscriptions/items/DomainMarketItem$DetailedLayout$FeatureObject;", "features", "Lcom/sputnik/domain/entities/subscriptions/items/DomainMarketItem$DetailedLayout$UpcomingFeatures;", "upcomingFeatures", "Lcom/sputnik/domain/entities/subscriptions/items/DomainMarketItem$DetailedLayout$Notice;", "notice", "Lcom/sputnik/domain/entities/subscriptions/items/DomainMarketItem$DetailedLayout$Button;", "button", "<init>", "(Lcom/sputnik/domain/entities/subscriptions/items/DomainMarketItem$DetailedLayout$Header;Ljava/util/List;Lcom/sputnik/domain/entities/subscriptions/items/DomainMarketItem$DetailedLayout$UpcomingFeatures;Lcom/sputnik/domain/entities/subscriptions/items/DomainMarketItem$DetailedLayout$Notice;Lcom/sputnik/domain/entities/subscriptions/items/DomainMarketItem$DetailedLayout$Button;)V", "", "toString", "()Ljava/lang/String;", "", "hashCode", "()I", "other", "", "equals", "(Ljava/lang/Object;)Z", "Lcom/sputnik/domain/entities/subscriptions/items/DomainMarketItem$DetailedLayout$Header;", "getHeader", "()Lcom/sputnik/domain/entities/subscriptions/items/DomainMarketItem$DetailedLayout$Header;", "Ljava/util/List;", "getFeatures", "()Ljava/util/List;", "Lcom/sputnik/domain/entities/subscriptions/items/DomainMarketItem$DetailedLayout$UpcomingFeatures;", "getUpcomingFeatures", "()Lcom/sputnik/domain/entities/subscriptions/items/DomainMarketItem$DetailedLayout$UpcomingFeatures;", "Lcom/sputnik/domain/entities/subscriptions/items/DomainMarketItem$DetailedLayout$Notice;", "getNotice", "()Lcom/sputnik/domain/entities/subscriptions/items/DomainMarketItem$DetailedLayout$Notice;", "Lcom/sputnik/domain/entities/subscriptions/items/DomainMarketItem$DetailedLayout$Button;", "getButton", "()Lcom/sputnik/domain/entities/subscriptions/items/DomainMarketItem$DetailedLayout$Button;", "Button", "Feature", "FeatureObject", "Header", "Notice", "UpcomingFeatures", "domain"}, k = 1, mv = {1, 9, 0}, xi = 48)
    public static final /* data */ class DetailedLayout {
        private final Button button;
        private final List<FeatureObject> features;
        private final Header header;
        private final Notice notice;
        private final UpcomingFeatures upcomingFeatures;

        public boolean equals(Object other) {
            if (this == other) {
                return true;
            }
            if (!(other instanceof DetailedLayout)) {
                return false;
            }
            DetailedLayout detailedLayout = (DetailedLayout) other;
            return Intrinsics.areEqual(this.header, detailedLayout.header) && Intrinsics.areEqual(this.features, detailedLayout.features) && Intrinsics.areEqual(this.upcomingFeatures, detailedLayout.upcomingFeatures) && Intrinsics.areEqual(this.notice, detailedLayout.notice) && Intrinsics.areEqual(this.button, detailedLayout.button);
        }

        public int hashCode() {
            Header header = this.header;
            int iHashCode = (((header == null ? 0 : header.hashCode()) * 31) + this.features.hashCode()) * 31;
            UpcomingFeatures upcomingFeatures = this.upcomingFeatures;
            int iHashCode2 = (iHashCode + (upcomingFeatures == null ? 0 : upcomingFeatures.hashCode())) * 31;
            Notice notice = this.notice;
            int iHashCode3 = (iHashCode2 + (notice == null ? 0 : notice.hashCode())) * 31;
            Button button = this.button;
            return iHashCode3 + (button != null ? button.hashCode() : 0);
        }

        public String toString() {
            return "DetailedLayout(header=" + this.header + ", features=" + this.features + ", upcomingFeatures=" + this.upcomingFeatures + ", notice=" + this.notice + ", button=" + this.button + ")";
        }

        public DetailedLayout(Header header, List<FeatureObject> features, UpcomingFeatures upcomingFeatures, Notice notice, Button button) {
            Intrinsics.checkNotNullParameter(features, "features");
            this.header = header;
            this.features = features;
            this.upcomingFeatures = upcomingFeatures;
            this.notice = notice;
            this.button = button;
        }

        public final Header getHeader() {
            return this.header;
        }

        public final List<FeatureObject> getFeatures() {
            return this.features;
        }

        public final UpcomingFeatures getUpcomingFeatures() {
            return this.upcomingFeatures;
        }

        public final Notice getNotice() {
            return this.notice;
        }

        public final Button getButton() {
            return this.button;
        }

        /* compiled from: DomainMarketItem.kt */
        @Metadata(d1 = {"\u0000 \n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0010\u000e\n\u0002\b\u0006\n\u0002\u0010\b\n\u0002\b\u0003\n\u0002\u0010\u000b\n\u0002\b\u0006\b\u0086\b\u0018\u00002\u00020\u0001B\u001b\u0012\b\u0010\u0003\u001a\u0004\u0018\u00010\u0002\u0012\b\u0010\u0004\u001a\u0004\u0018\u00010\u0002¢\u0006\u0004\b\u0005\u0010\u0006J\u0010\u0010\u0007\u001a\u00020\u0002HÖ\u0001¢\u0006\u0004\b\u0007\u0010\bJ\u0010\u0010\n\u001a\u00020\tHÖ\u0001¢\u0006\u0004\b\n\u0010\u000bJ\u001a\u0010\u000e\u001a\u00020\r2\b\u0010\f\u001a\u0004\u0018\u00010\u0001HÖ\u0003¢\u0006\u0004\b\u000e\u0010\u000fR\u0019\u0010\u0003\u001a\u0004\u0018\u00010\u00028\u0006¢\u0006\f\n\u0004\b\u0003\u0010\u0010\u001a\u0004\b\u0011\u0010\bR\u0019\u0010\u0004\u001a\u0004\u0018\u00010\u00028\u0006¢\u0006\f\n\u0004\b\u0004\u0010\u0010\u001a\u0004\b\u0012\u0010\b¨\u0006\u0013"}, d2 = {"Lcom/sputnik/domain/entities/subscriptions/items/DomainMarketItem$DetailedLayout$Header;", "", "", FFmpegMediaMetadataRetriever.METADATA_KEY_TITLE, "imageLink", "<init>", "(Ljava/lang/String;Ljava/lang/String;)V", "toString", "()Ljava/lang/String;", "", "hashCode", "()I", "other", "", "equals", "(Ljava/lang/Object;)Z", "Ljava/lang/String;", "getTitle", "getImageLink", "domain"}, k = 1, mv = {1, 9, 0}, xi = 48)
        public static final /* data */ class Header {
            private final String imageLink;
            private final String title;

            public boolean equals(Object other) {
                if (this == other) {
                    return true;
                }
                if (!(other instanceof Header)) {
                    return false;
                }
                Header header = (Header) other;
                return Intrinsics.areEqual(this.title, header.title) && Intrinsics.areEqual(this.imageLink, header.imageLink);
            }

            public int hashCode() {
                String str = this.title;
                int iHashCode = (str == null ? 0 : str.hashCode()) * 31;
                String str2 = this.imageLink;
                return iHashCode + (str2 != null ? str2.hashCode() : 0);
            }

            public String toString() {
                return "Header(title=" + this.title + ", imageLink=" + this.imageLink + ")";
            }

            public Header(String str, String str2) {
                this.title = str;
                this.imageLink = str2;
            }

            public final String getTitle() {
                return this.title;
            }

            public final String getImageLink() {
                return this.imageLink;
            }
        }

        /* compiled from: DomainMarketItem.kt */
        @Metadata(d1 = {"\u0000(\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u000e\n\u0002\b\u0002\n\u0002\u0010\b\n\u0002\b\u0003\n\u0002\u0010\u000b\n\u0002\b\u0006\b\u0086\b\u0018\u00002\u00020\u0001B\u0011\u0012\b\u0010\u0003\u001a\u0004\u0018\u00010\u0002¢\u0006\u0004\b\u0004\u0010\u0005J\u0010\u0010\u0007\u001a\u00020\u0006HÖ\u0001¢\u0006\u0004\b\u0007\u0010\bJ\u0010\u0010\n\u001a\u00020\tHÖ\u0001¢\u0006\u0004\b\n\u0010\u000bJ\u001a\u0010\u000e\u001a\u00020\r2\b\u0010\f\u001a\u0004\u0018\u00010\u0001HÖ\u0003¢\u0006\u0004\b\u000e\u0010\u000fR\u0019\u0010\u0003\u001a\u0004\u0018\u00010\u00028\u0006¢\u0006\f\n\u0004\b\u0003\u0010\u0010\u001a\u0004\b\u0011\u0010\u0012¨\u0006\u0013"}, d2 = {"Lcom/sputnik/domain/entities/subscriptions/items/DomainMarketItem$DetailedLayout$FeatureObject;", "", "Lcom/sputnik/domain/entities/subscriptions/items/DomainMarketItem$DetailedLayout$Feature;", "feature", "<init>", "(Lcom/sputnik/domain/entities/subscriptions/items/DomainMarketItem$DetailedLayout$Feature;)V", "", "toString", "()Ljava/lang/String;", "", "hashCode", "()I", "other", "", "equals", "(Ljava/lang/Object;)Z", "Lcom/sputnik/domain/entities/subscriptions/items/DomainMarketItem$DetailedLayout$Feature;", "getFeature", "()Lcom/sputnik/domain/entities/subscriptions/items/DomainMarketItem$DetailedLayout$Feature;", "domain"}, k = 1, mv = {1, 9, 0}, xi = 48)
        public static final /* data */ class FeatureObject {
            private final Feature feature;

            public boolean equals(Object other) {
                if (this == other) {
                    return true;
                }
                return (other instanceof FeatureObject) && Intrinsics.areEqual(this.feature, ((FeatureObject) other).feature);
            }

            public int hashCode() {
                Feature feature = this.feature;
                if (feature == null) {
                    return 0;
                }
                return feature.hashCode();
            }

            public String toString() {
                return "FeatureObject(feature=" + this.feature + ")";
            }

            public FeatureObject(Feature feature) {
                this.feature = feature;
            }

            public final Feature getFeature() {
                return this.feature;
            }
        }

        /* compiled from: DomainMarketItem.kt */
        @Metadata(d1 = {"\u0000 \n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0010\u000e\n\u0002\b\u0006\n\u0002\u0010\b\n\u0002\b\u0003\n\u0002\u0010\u000b\n\u0002\b\u0006\b\u0086\b\u0018\u00002\u00020\u0001B\u001b\u0012\b\u0010\u0003\u001a\u0004\u0018\u00010\u0002\u0012\b\u0010\u0004\u001a\u0004\u0018\u00010\u0002¢\u0006\u0004\b\u0005\u0010\u0006J\u0010\u0010\u0007\u001a\u00020\u0002HÖ\u0001¢\u0006\u0004\b\u0007\u0010\bJ\u0010\u0010\n\u001a\u00020\tHÖ\u0001¢\u0006\u0004\b\n\u0010\u000bJ\u001a\u0010\u000e\u001a\u00020\r2\b\u0010\f\u001a\u0004\u0018\u00010\u0001HÖ\u0003¢\u0006\u0004\b\u000e\u0010\u000fR\u0019\u0010\u0003\u001a\u0004\u0018\u00010\u00028\u0006¢\u0006\f\n\u0004\b\u0003\u0010\u0010\u001a\u0004\b\u0011\u0010\bR\u0019\u0010\u0004\u001a\u0004\u0018\u00010\u00028\u0006¢\u0006\f\n\u0004\b\u0004\u0010\u0010\u001a\u0004\b\u0012\u0010\b¨\u0006\u0013"}, d2 = {"Lcom/sputnik/domain/entities/subscriptions/items/DomainMarketItem$DetailedLayout$Feature;", "", "", "description", "imageLink", "<init>", "(Ljava/lang/String;Ljava/lang/String;)V", "toString", "()Ljava/lang/String;", "", "hashCode", "()I", "other", "", "equals", "(Ljava/lang/Object;)Z", "Ljava/lang/String;", "getDescription", "getImageLink", "domain"}, k = 1, mv = {1, 9, 0}, xi = 48)
        public static final /* data */ class Feature {
            private final String description;
            private final String imageLink;

            public boolean equals(Object other) {
                if (this == other) {
                    return true;
                }
                if (!(other instanceof Feature)) {
                    return false;
                }
                Feature feature = (Feature) other;
                return Intrinsics.areEqual(this.description, feature.description) && Intrinsics.areEqual(this.imageLink, feature.imageLink);
            }

            public int hashCode() {
                String str = this.description;
                int iHashCode = (str == null ? 0 : str.hashCode()) * 31;
                String str2 = this.imageLink;
                return iHashCode + (str2 != null ? str2.hashCode() : 0);
            }

            public String toString() {
                return "Feature(description=" + this.description + ", imageLink=" + this.imageLink + ")";
            }

            public Feature(String str, String str2) {
                this.description = str;
                this.imageLink = str2;
            }

            public final String getDescription() {
                return this.description;
            }

            public final String getImageLink() {
                return this.imageLink;
            }
        }

        /* compiled from: DomainMarketItem.kt */
        @Metadata(d1 = {"\u0000*\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0010\b\n\u0002\b\u0003\n\u0002\u0010\u000b\n\u0002\b\b\b\u0086\b\u0018\u00002\u00020\u0001B#\u0012\b\u0010\u0003\u001a\u0004\u0018\u00010\u0002\u0012\u0010\u0010\u0006\u001a\f\u0012\u0006\u0012\u0004\u0018\u00010\u0005\u0018\u00010\u0004¢\u0006\u0004\b\u0007\u0010\bJ\u0010\u0010\t\u001a\u00020\u0002HÖ\u0001¢\u0006\u0004\b\t\u0010\nJ\u0010\u0010\f\u001a\u00020\u000bHÖ\u0001¢\u0006\u0004\b\f\u0010\rJ\u001a\u0010\u0010\u001a\u00020\u000f2\b\u0010\u000e\u001a\u0004\u0018\u00010\u0001HÖ\u0003¢\u0006\u0004\b\u0010\u0010\u0011R\u0019\u0010\u0003\u001a\u0004\u0018\u00010\u00028\u0006¢\u0006\f\n\u0004\b\u0003\u0010\u0012\u001a\u0004\b\u0013\u0010\nR!\u0010\u0006\u001a\f\u0012\u0006\u0012\u0004\u0018\u00010\u0005\u0018\u00010\u00048\u0006¢\u0006\f\n\u0004\b\u0006\u0010\u0014\u001a\u0004\b\u0015\u0010\u0016¨\u0006\u0017"}, d2 = {"Lcom/sputnik/domain/entities/subscriptions/items/DomainMarketItem$DetailedLayout$UpcomingFeatures;", "", "", FFmpegMediaMetadataRetriever.METADATA_KEY_TITLE, "", "Lcom/sputnik/domain/entities/subscriptions/items/DomainMarketItem$DetailedLayout$Feature;", "features", "<init>", "(Ljava/lang/String;Ljava/util/List;)V", "toString", "()Ljava/lang/String;", "", "hashCode", "()I", "other", "", "equals", "(Ljava/lang/Object;)Z", "Ljava/lang/String;", "getTitle", "Ljava/util/List;", "getFeatures", "()Ljava/util/List;", "domain"}, k = 1, mv = {1, 9, 0}, xi = 48)
        public static final /* data */ class UpcomingFeatures {
            private final List<Feature> features;
            private final String title;

            public boolean equals(Object other) {
                if (this == other) {
                    return true;
                }
                if (!(other instanceof UpcomingFeatures)) {
                    return false;
                }
                UpcomingFeatures upcomingFeatures = (UpcomingFeatures) other;
                return Intrinsics.areEqual(this.title, upcomingFeatures.title) && Intrinsics.areEqual(this.features, upcomingFeatures.features);
            }

            public int hashCode() {
                String str = this.title;
                int iHashCode = (str == null ? 0 : str.hashCode()) * 31;
                List<Feature> list = this.features;
                return iHashCode + (list != null ? list.hashCode() : 0);
            }

            public String toString() {
                return "UpcomingFeatures(title=" + this.title + ", features=" + this.features + ")";
            }

            public UpcomingFeatures(String str, List<Feature> list) {
                this.title = str;
                this.features = list;
            }

            public final String getTitle() {
                return this.title;
            }

            public final List<Feature> getFeatures() {
                return this.features;
            }
        }

        /* compiled from: DomainMarketItem.kt */
        @Metadata(d1 = {"\u0000 \n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0010\u000e\n\u0002\b\u0005\n\u0002\u0010\b\n\u0002\b\u0003\n\u0002\u0010\u000b\n\u0002\b\u0005\b\u0086\b\u0018\u00002\u00020\u0001B\u0011\u0012\b\u0010\u0003\u001a\u0004\u0018\u00010\u0002¢\u0006\u0004\b\u0004\u0010\u0005J\u0010\u0010\u0006\u001a\u00020\u0002HÖ\u0001¢\u0006\u0004\b\u0006\u0010\u0007J\u0010\u0010\t\u001a\u00020\bHÖ\u0001¢\u0006\u0004\b\t\u0010\nJ\u001a\u0010\r\u001a\u00020\f2\b\u0010\u000b\u001a\u0004\u0018\u00010\u0001HÖ\u0003¢\u0006\u0004\b\r\u0010\u000eR\u0019\u0010\u0003\u001a\u0004\u0018\u00010\u00028\u0006¢\u0006\f\n\u0004\b\u0003\u0010\u000f\u001a\u0004\b\u0010\u0010\u0007¨\u0006\u0011"}, d2 = {"Lcom/sputnik/domain/entities/subscriptions/items/DomainMarketItem$DetailedLayout$Notice;", "", "", "body", "<init>", "(Ljava/lang/String;)V", "toString", "()Ljava/lang/String;", "", "hashCode", "()I", "other", "", "equals", "(Ljava/lang/Object;)Z", "Ljava/lang/String;", "getBody", "domain"}, k = 1, mv = {1, 9, 0}, xi = 48)
        public static final /* data */ class Notice {
            private final String body;

            public boolean equals(Object other) {
                if (this == other) {
                    return true;
                }
                return (other instanceof Notice) && Intrinsics.areEqual(this.body, ((Notice) other).body);
            }

            public int hashCode() {
                String str = this.body;
                if (str == null) {
                    return 0;
                }
                return str.hashCode();
            }

            public String toString() {
                return "Notice(body=" + this.body + ")";
            }

            public Notice(String str) {
                this.body = str;
            }

            public final String getBody() {
                return this.body;
            }
        }

        /* compiled from: DomainMarketItem.kt */
        @Metadata(d1 = {"\u0000 \n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0010\u000e\n\u0002\b\b\n\u0002\u0010\b\n\u0002\b\u0003\n\u0002\u0010\u000b\n\u0002\b\b\b\u0086\b\u0018\u00002\u00020\u0001B/\u0012\b\u0010\u0003\u001a\u0004\u0018\u00010\u0002\u0012\b\u0010\u0004\u001a\u0004\u0018\u00010\u0002\u0012\b\u0010\u0005\u001a\u0004\u0018\u00010\u0002\u0012\b\u0010\u0006\u001a\u0004\u0018\u00010\u0002¢\u0006\u0004\b\u0007\u0010\bJ\u0010\u0010\t\u001a\u00020\u0002HÖ\u0001¢\u0006\u0004\b\t\u0010\nJ\u0010\u0010\f\u001a\u00020\u000bHÖ\u0001¢\u0006\u0004\b\f\u0010\rJ\u001a\u0010\u0010\u001a\u00020\u000f2\b\u0010\u000e\u001a\u0004\u0018\u00010\u0001HÖ\u0003¢\u0006\u0004\b\u0010\u0010\u0011R\u0019\u0010\u0003\u001a\u0004\u0018\u00010\u00028\u0006¢\u0006\f\n\u0004\b\u0003\u0010\u0012\u001a\u0004\b\u0013\u0010\nR\u0019\u0010\u0004\u001a\u0004\u0018\u00010\u00028\u0006¢\u0006\f\n\u0004\b\u0004\u0010\u0012\u001a\u0004\b\u0014\u0010\nR\u0019\u0010\u0005\u001a\u0004\u0018\u00010\u00028\u0006¢\u0006\f\n\u0004\b\u0005\u0010\u0012\u001a\u0004\b\u0015\u0010\nR\u0019\u0010\u0006\u001a\u0004\u0018\u00010\u00028\u0006¢\u0006\f\n\u0004\b\u0006\u0010\u0012\u001a\u0004\b\u0016\u0010\n¨\u0006\u0017"}, d2 = {"Lcom/sputnik/domain/entities/subscriptions/items/DomainMarketItem$DetailedLayout$Button;", "", "", "type", RemoteMessageConst.Notification.COLOR, FFmpegMediaMetadataRetriever.METADATA_KEY_TITLE, "link", "<init>", "(Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;)V", "toString", "()Ljava/lang/String;", "", "hashCode", "()I", "other", "", "equals", "(Ljava/lang/Object;)Z", "Ljava/lang/String;", "getType", "getColor", "getTitle", "getLink", "domain"}, k = 1, mv = {1, 9, 0}, xi = 48)
        public static final /* data */ class Button {
            private final String color;
            private final String link;
            private final String title;
            private final String type;

            public boolean equals(Object other) {
                if (this == other) {
                    return true;
                }
                if (!(other instanceof Button)) {
                    return false;
                }
                Button button = (Button) other;
                return Intrinsics.areEqual(this.type, button.type) && Intrinsics.areEqual(this.color, button.color) && Intrinsics.areEqual(this.title, button.title) && Intrinsics.areEqual(this.link, button.link);
            }

            public int hashCode() {
                String str = this.type;
                int iHashCode = (str == null ? 0 : str.hashCode()) * 31;
                String str2 = this.color;
                int iHashCode2 = (iHashCode + (str2 == null ? 0 : str2.hashCode())) * 31;
                String str3 = this.title;
                int iHashCode3 = (iHashCode2 + (str3 == null ? 0 : str3.hashCode())) * 31;
                String str4 = this.link;
                return iHashCode3 + (str4 != null ? str4.hashCode() : 0);
            }

            public String toString() {
                return "Button(type=" + this.type + ", color=" + this.color + ", title=" + this.title + ", link=" + this.link + ")";
            }

            public Button(String str, String str2, String str3, String str4) {
                this.type = str;
                this.color = str2;
                this.title = str3;
                this.link = str4;
            }

            public final String getType() {
                return this.type;
            }

            public final String getColor() {
                return this.color;
            }

            public final String getTitle() {
                return this.title;
            }

            public final String getLink() {
                return this.link;
            }
        }
    }
}

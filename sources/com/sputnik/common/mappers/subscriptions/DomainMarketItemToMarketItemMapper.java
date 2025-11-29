package com.sputnik.common.mappers.subscriptions;

import com.sputnik.common.entities.market.items.MarketItem;
import com.sputnik.domain.common.Mapper;
import com.sputnik.domain.entities.market.ItemTypes;
import com.sputnik.domain.entities.subscriptions.items.DomainMarketItem;
import java.util.ArrayList;
import java.util.List;
import kotlin.Metadata;
import kotlin.collections.CollectionsKt;
import kotlin.jvm.internal.Intrinsics;

/* compiled from: DomainMarketItemToMarketItemMapper.kt */
@Metadata(d1 = {"\u0000\u0014\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0004\u0018\u00002\u000e\u0012\u0004\u0012\u00020\u0002\u0012\u0004\u0012\u00020\u00030\u0001B\u0007\b\u0007¢\u0006\u0002\u0010\u0004J\u0010\u0010\u0005\u001a\u00020\u00032\u0006\u0010\u0006\u001a\u00020\u0002H\u0016¨\u0006\u0007"}, d2 = {"Lcom/sputnik/common/mappers/subscriptions/DomainMarketItemToMarketItemMapper;", "Lcom/sputnik/domain/common/Mapper;", "Lcom/sputnik/domain/entities/subscriptions/items/DomainMarketItem;", "Lcom/sputnik/common/entities/market/items/MarketItem;", "()V", "map", "input", "common_release"}, k = 1, mv = {1, 9, 0}, xi = 48)
/* loaded from: classes3.dex */
public final class DomainMarketItemToMarketItemMapper implements Mapper<DomainMarketItem, MarketItem> {
    @Override // com.sputnik.domain.common.Mapper
    public MarketItem map(DomainMarketItem input) {
        List<String> listEmptyList;
        List listEmptyList2;
        List listEmptyList3;
        String str;
        String link;
        DomainMarketItem.DetailedLayout detailedLayout;
        DomainMarketItem.DetailedLayout.Button button;
        DomainMarketItem.DetailedLayout detailedLayout2;
        DomainMarketItem.DetailedLayout.Button button2;
        DomainMarketItem.DetailedLayout detailedLayout3;
        DomainMarketItem.DetailedLayout.Button button3;
        DomainMarketItem.DetailedLayout detailedLayout4;
        DomainMarketItem.DetailedLayout.Button button4;
        DomainMarketItem.DetailedLayout detailedLayout5;
        DomainMarketItem.DetailedLayout.Notice notice;
        DomainMarketItem.DetailedLayout detailedLayout6;
        DomainMarketItem.DetailedLayout.UpcomingFeatures upcomingFeatures;
        List<DomainMarketItem.DetailedLayout.Feature> features;
        DomainMarketItem.DetailedLayout detailedLayout7;
        DomainMarketItem.DetailedLayout.UpcomingFeatures upcomingFeatures2;
        DomainMarketItem.DetailedLayout detailedLayout8;
        List<DomainMarketItem.DetailedLayout.FeatureObject> features2;
        DomainMarketItem.DetailedLayout.Feature feature;
        DomainMarketItem.DetailedLayout.Feature feature2;
        DomainMarketItem.DetailedLayout detailedLayout9;
        DomainMarketItem.DetailedLayout.Header header;
        DomainMarketItem.DetailedLayout detailedLayout10;
        DomainMarketItem.DetailedLayout.Header header2;
        DomainMarketItem.DomainMarketItemAppearance.Deeplink onTap;
        DomainMarketItem.DomainMarketItemAppearance.TextTitle finale;
        DomainMarketItem.DomainMarketItemAppearance.TextTitle finale2;
        Intrinsics.checkNotNullParameter(input, "input");
        String identifier = input.getIdentifier();
        ItemTypes type = input.getType();
        Integer order = input.getOrder();
        DomainMarketItem.DomainMarketItemAppearance appearance = input.getAppearance();
        String title = appearance != null ? appearance.getTitle() : null;
        DomainMarketItem.DomainMarketItemAppearance appearance2 = input.getAppearance();
        if (appearance2 == null || (listEmptyList = appearance2.getFeaturesList()) == null) {
            listEmptyList = CollectionsKt.emptyList();
        }
        List<String> list = listEmptyList;
        DomainMarketItem.DomainMarketItemAppearance appearance3 = input.getAppearance();
        String imageLink = appearance3 != null ? appearance3.getImageLink() : null;
        DomainMarketItem.DomainMarketItemAppearance appearance4 = input.getAppearance();
        String title2 = (appearance4 == null || (finale2 = appearance4.getFinale()) == null) ? null : finale2.getTitle();
        DomainMarketItem.DomainMarketItemAppearance appearance5 = input.getAppearance();
        MarketItem.MarketItemAppearance.TextTitle textTitle = new MarketItem.MarketItemAppearance.TextTitle(title2, (appearance5 == null || (finale = appearance5.getFinale()) == null) ? null : finale.getLink());
        DomainMarketItem.DomainMarketItemAppearance appearance6 = input.getAppearance();
        MarketItem.MarketItemAppearance.Deeplink deeplink = new MarketItem.MarketItemAppearance.Deeplink((appearance6 == null || (onTap = appearance6.getOnTap()) == null) ? null : onTap.getDeeplink());
        DomainMarketItem.DomainMarketItemAppearance appearance7 = input.getAppearance();
        String title3 = (appearance7 == null || (detailedLayout10 = appearance7.getDetailedLayout()) == null || (header2 = detailedLayout10.getHeader()) == null) ? null : header2.getTitle();
        DomainMarketItem.DomainMarketItemAppearance appearance8 = input.getAppearance();
        MarketItem.DetailedLayout.Header header3 = new MarketItem.DetailedLayout.Header(title3, (appearance8 == null || (detailedLayout9 = appearance8.getDetailedLayout()) == null || (header = detailedLayout9.getHeader()) == null) ? null : header.getImageLink());
        DomainMarketItem.DomainMarketItemAppearance appearance9 = input.getAppearance();
        if (appearance9 == null || (detailedLayout8 = appearance9.getDetailedLayout()) == null || (features2 = detailedLayout8.getFeatures()) == null) {
            listEmptyList2 = CollectionsKt.emptyList();
        } else {
            ArrayList arrayList = new ArrayList();
            for (DomainMarketItem.DetailedLayout.FeatureObject featureObject : features2) {
                arrayList.add(new MarketItem.DetailedLayout.FeatureObject(new MarketItem.DetailedLayout.Feature((featureObject == null || (feature2 = featureObject.getFeature()) == null) ? null : feature2.getDescription(), (featureObject == null || (feature = featureObject.getFeature()) == null) ? null : feature.getImageLink())));
            }
            listEmptyList2 = arrayList;
        }
        DomainMarketItem.DomainMarketItemAppearance appearance10 = input.getAppearance();
        String title4 = (appearance10 == null || (detailedLayout7 = appearance10.getDetailedLayout()) == null || (upcomingFeatures2 = detailedLayout7.getUpcomingFeatures()) == null) ? null : upcomingFeatures2.getTitle();
        DomainMarketItem.DomainMarketItemAppearance appearance11 = input.getAppearance();
        if (appearance11 == null || (detailedLayout6 = appearance11.getDetailedLayout()) == null || (upcomingFeatures = detailedLayout6.getUpcomingFeatures()) == null || (features = upcomingFeatures.getFeatures()) == null) {
            listEmptyList3 = CollectionsKt.emptyList();
        } else {
            listEmptyList3 = new ArrayList();
            for (DomainMarketItem.DetailedLayout.Feature feature3 : features) {
                listEmptyList3.add(new MarketItem.DetailedLayout.Feature(feature3 != null ? feature3.getDescription() : null, feature3 != null ? feature3.getImageLink() : null));
            }
        }
        MarketItem.DetailedLayout.UpcomingFeatures upcomingFeatures3 = new MarketItem.DetailedLayout.UpcomingFeatures(title4, listEmptyList3);
        DomainMarketItem.DomainMarketItemAppearance appearance12 = input.getAppearance();
        MarketItem.DetailedLayout.Notice notice2 = new MarketItem.DetailedLayout.Notice((appearance12 == null || (detailedLayout5 = appearance12.getDetailedLayout()) == null || (notice = detailedLayout5.getNotice()) == null) ? null : notice.getBody());
        DomainMarketItem.DomainMarketItemAppearance appearance13 = input.getAppearance();
        String type2 = (appearance13 == null || (detailedLayout4 = appearance13.getDetailedLayout()) == null || (button4 = detailedLayout4.getButton()) == null) ? null : button4.getType();
        DomainMarketItem.DomainMarketItemAppearance appearance14 = input.getAppearance();
        String color = (appearance14 == null || (detailedLayout3 = appearance14.getDetailedLayout()) == null || (button3 = detailedLayout3.getButton()) == null) ? null : button3.getColor();
        DomainMarketItem.DomainMarketItemAppearance appearance15 = input.getAppearance();
        String title5 = (appearance15 == null || (detailedLayout2 = appearance15.getDetailedLayout()) == null || (button2 = detailedLayout2.getButton()) == null) ? null : button2.getTitle();
        DomainMarketItem.DomainMarketItemAppearance appearance16 = input.getAppearance();
        if (appearance16 == null || (detailedLayout = appearance16.getDetailedLayout()) == null || (button = detailedLayout.getButton()) == null) {
            str = identifier;
            link = null;
        } else {
            str = identifier;
            link = button.getLink();
        }
        return new MarketItem(str, type, order, new MarketItem.MarketItemAppearance(title, list, imageLink, textTitle, deeplink, new MarketItem.DetailedLayout(header3, listEmptyList2, upcomingFeatures3, notice2, new MarketItem.DetailedLayout.Button(type2, color, title5, link))));
    }
}

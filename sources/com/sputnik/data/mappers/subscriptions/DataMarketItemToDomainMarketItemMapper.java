package com.sputnik.data.mappers.subscriptions;

import com.sputnik.data.entities.subscriptions.items.DataMarketItem;
import com.sputnik.domain.common.Mapper;
import com.sputnik.domain.entities.market.ItemTypes;
import com.sputnik.domain.entities.subscriptions.items.DomainMarketItem;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import kotlin.Metadata;
import kotlin.collections.CollectionsKt;
import kotlin.jvm.internal.Intrinsics;

/* compiled from: DataMarketItemToDomainMarketItemMapper.kt */
@Metadata(d1 = {"\u0000\u0014\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0004\u0018\u00002\u000e\u0012\u0004\u0012\u00020\u0002\u0012\u0004\u0012\u00020\u00030\u0001B\u0007\b\u0007¢\u0006\u0002\u0010\u0004J\u0010\u0010\u0005\u001a\u00020\u00032\u0006\u0010\u0006\u001a\u00020\u0002H\u0016¨\u0006\u0007"}, d2 = {"Lcom/sputnik/data/mappers/subscriptions/DataMarketItemToDomainMarketItemMapper;", "Lcom/sputnik/domain/common/Mapper;", "Lcom/sputnik/data/entities/subscriptions/items/DataMarketItem;", "Lcom/sputnik/domain/entities/subscriptions/items/DomainMarketItem;", "()V", "map", "input", "data_release"}, k = 1, mv = {1, 9, 0}, xi = 48)
/* loaded from: classes3.dex */
public final class DataMarketItemToDomainMarketItemMapper implements Mapper<DataMarketItem, DomainMarketItem> {
    @Override // com.sputnik.domain.common.Mapper
    public DomainMarketItem map(DataMarketItem input) {
        List<String> listEmptyList;
        List listEmptyList2;
        String str;
        List listEmptyList3;
        DataMarketItem.DetailedLayout detailedLayout;
        List<DataMarketItem.DetailedLayout.FeatureObject> features;
        String str2;
        String description;
        DataMarketItem.DetailedLayout.Feature feature;
        DataMarketItem.DetailedLayout.Feature feature2;
        DataMarketItem.DetailedLayout detailedLayout2;
        DataMarketItem.DetailedLayout.Button button;
        DataMarketItem.DetailedLayout detailedLayout3;
        DataMarketItem.DetailedLayout.Button button2;
        DataMarketItem.DetailedLayout detailedLayout4;
        DataMarketItem.DetailedLayout.Button button3;
        DataMarketItem.DetailedLayout detailedLayout5;
        DataMarketItem.DetailedLayout.Button button4;
        DataMarketItem.DetailedLayout detailedLayout6;
        DataMarketItem.DetailedLayout.Notice notice;
        DataMarketItem.DetailedLayout detailedLayout7;
        DataMarketItem.DetailedLayout.UpcomingFeatures upcomingFeatures;
        List<DataMarketItem.DetailedLayout.FeatureObject> features2;
        DataMarketItem.DetailedLayout.Feature feature3;
        DataMarketItem.DetailedLayout.Feature feature4;
        DataMarketItem.DetailedLayout detailedLayout8;
        DataMarketItem.DetailedLayout.UpcomingFeatures upcomingFeatures2;
        DataMarketItem.DetailedLayout detailedLayout9;
        DataMarketItem.DetailedLayout.Header header;
        DataMarketItem.DetailedLayout detailedLayout10;
        DataMarketItem.DetailedLayout.Header header2;
        DataMarketItem.DataMarketItemAppearance.Deeplink onTap;
        DataMarketItem.DataMarketItemAppearance.TextTitle finale;
        DataMarketItem.DataMarketItemAppearance.TextTitle finale2;
        Intrinsics.checkNotNullParameter(input, "input");
        String identifier = input.getIdentifier();
        ItemTypes type = input.getType();
        Integer order = input.getOrder();
        DataMarketItem.DataMarketItemAppearance appearance = input.getAppearance();
        String title = appearance != null ? appearance.getTitle() : null;
        DataMarketItem.DataMarketItemAppearance appearance2 = input.getAppearance();
        if (appearance2 == null || (listEmptyList = appearance2.getFeaturesList()) == null) {
            listEmptyList = CollectionsKt.emptyList();
        }
        List<String> list = listEmptyList;
        DataMarketItem.DataMarketItemAppearance appearance3 = input.getAppearance();
        String imageLink = appearance3 != null ? appearance3.getImageLink() : null;
        DataMarketItem.DataMarketItemAppearance appearance4 = input.getAppearance();
        String title2 = (appearance4 == null || (finale2 = appearance4.getFinale()) == null) ? null : finale2.getTitle();
        DataMarketItem.DataMarketItemAppearance appearance5 = input.getAppearance();
        DomainMarketItem.DomainMarketItemAppearance.TextTitle textTitle = new DomainMarketItem.DomainMarketItemAppearance.TextTitle(title2, (appearance5 == null || (finale = appearance5.getFinale()) == null) ? null : finale.getLink());
        DataMarketItem.DataMarketItemAppearance appearance6 = input.getAppearance();
        DomainMarketItem.DomainMarketItemAppearance.Deeplink deeplink = new DomainMarketItem.DomainMarketItemAppearance.Deeplink((appearance6 == null || (onTap = appearance6.getOnTap()) == null) ? null : onTap.getDeeplink());
        DataMarketItem.DataMarketItemAppearance appearance7 = input.getAppearance();
        String title3 = (appearance7 == null || (detailedLayout10 = appearance7.getDetailedLayout()) == null || (header2 = detailedLayout10.getHeader()) == null) ? null : header2.getTitle();
        DataMarketItem.DataMarketItemAppearance appearance8 = input.getAppearance();
        DomainMarketItem.DetailedLayout.Header header3 = new DomainMarketItem.DetailedLayout.Header(title3, (appearance8 == null || (detailedLayout9 = appearance8.getDetailedLayout()) == null || (header = detailedLayout9.getHeader()) == null) ? null : header.getImageLink());
        DataMarketItem.DataMarketItemAppearance appearance9 = input.getAppearance();
        String title4 = (appearance9 == null || (detailedLayout8 = appearance9.getDetailedLayout()) == null || (upcomingFeatures2 = detailedLayout8.getUpcomingFeatures()) == null) ? null : upcomingFeatures2.getTitle();
        DataMarketItem.DataMarketItemAppearance appearance10 = input.getAppearance();
        if (appearance10 == null || (detailedLayout7 = appearance10.getDetailedLayout()) == null || (upcomingFeatures = detailedLayout7.getUpcomingFeatures()) == null || (features2 = upcomingFeatures.getFeatures()) == null) {
            listEmptyList2 = CollectionsKt.emptyList();
        } else {
            listEmptyList2 = new ArrayList();
            for (DataMarketItem.DetailedLayout.FeatureObject featureObject : features2) {
                listEmptyList2.add(new DomainMarketItem.DetailedLayout.Feature((featureObject == null || (feature4 = featureObject.getFeature()) == null) ? null : feature4.getDescription(), (featureObject == null || (feature3 = featureObject.getFeature()) == null) ? null : feature3.getImageLink()));
            }
        }
        DomainMarketItem.DetailedLayout.UpcomingFeatures upcomingFeatures3 = new DomainMarketItem.DetailedLayout.UpcomingFeatures(title4, listEmptyList2);
        DataMarketItem.DataMarketItemAppearance appearance11 = input.getAppearance();
        DomainMarketItem.DetailedLayout.Notice notice2 = new DomainMarketItem.DetailedLayout.Notice((appearance11 == null || (detailedLayout6 = appearance11.getDetailedLayout()) == null || (notice = detailedLayout6.getNotice()) == null) ? null : notice.getBody());
        DataMarketItem.DataMarketItemAppearance appearance12 = input.getAppearance();
        String type2 = (appearance12 == null || (detailedLayout5 = appearance12.getDetailedLayout()) == null || (button4 = detailedLayout5.getButton()) == null) ? null : button4.getType();
        DataMarketItem.DataMarketItemAppearance appearance13 = input.getAppearance();
        String color = (appearance13 == null || (detailedLayout4 = appearance13.getDetailedLayout()) == null || (button3 = detailedLayout4.getButton()) == null) ? null : button3.getColor();
        DataMarketItem.DataMarketItemAppearance appearance14 = input.getAppearance();
        String title5 = (appearance14 == null || (detailedLayout3 = appearance14.getDetailedLayout()) == null || (button2 = detailedLayout3.getButton()) == null) ? null : button2.getTitle();
        DataMarketItem.DataMarketItemAppearance appearance15 = input.getAppearance();
        DomainMarketItem.DetailedLayout.Button button5 = new DomainMarketItem.DetailedLayout.Button(type2, color, title5, (appearance15 == null || (detailedLayout2 = appearance15.getDetailedLayout()) == null || (button = detailedLayout2.getButton()) == null) ? null : button.getLink());
        DataMarketItem.DataMarketItemAppearance appearance16 = input.getAppearance();
        if (appearance16 == null || (detailedLayout = appearance16.getDetailedLayout()) == null || (features = detailedLayout.getFeatures()) == null) {
            str = identifier;
            listEmptyList3 = CollectionsKt.emptyList();
        } else {
            ArrayList arrayList = new ArrayList();
            Iterator it = features.iterator();
            while (it.hasNext()) {
                DataMarketItem.DetailedLayout.FeatureObject featureObject2 = (DataMarketItem.DetailedLayout.FeatureObject) it.next();
                Iterator it2 = it;
                if (featureObject2 == null || (feature2 = featureObject2.getFeature()) == null) {
                    str2 = identifier;
                    description = null;
                } else {
                    str2 = identifier;
                    description = feature2.getDescription();
                }
                arrayList.add(new DomainMarketItem.DetailedLayout.FeatureObject(new DomainMarketItem.DetailedLayout.Feature(description, (featureObject2 == null || (feature = featureObject2.getFeature()) == null) ? null : feature.getImageLink())));
                it = it2;
                identifier = str2;
            }
            str = identifier;
            listEmptyList3 = arrayList;
        }
        return new DomainMarketItem(str, type, order, new DomainMarketItem.DomainMarketItemAppearance(title, list, imageLink, textTitle, deeplink, new DomainMarketItem.DetailedLayout(header3, listEmptyList3, upcomingFeatures3, notice2, button5)));
    }
}

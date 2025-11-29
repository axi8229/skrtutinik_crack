package com.sputnik.data.mappers.subscriptions;

import com.sputnik.data.entities.subscriptions.subscriptions.DataBadge;
import com.sputnik.data.entities.subscriptions.subscriptions.DataDetailedLayout;
import com.sputnik.data.entities.subscriptions.subscriptions.DataFeatures;
import com.sputnik.data.entities.subscriptions.subscriptions.DataHeader;
import com.sputnik.data.entities.subscriptions.subscriptions.DataIncludedServices;
import com.sputnik.data.entities.subscriptions.subscriptions.DataNoticeBody;
import com.sputnik.data.entities.subscriptions.subscriptions.DataService;
import com.sputnik.data.entities.subscriptions.subscriptions.DataServiceAppearance;
import com.sputnik.data.entities.subscriptions.subscriptions.DataSubscriptionAppearance;
import com.sputnik.domain.common.Mapper;
import com.sputnik.domain.entities.subscriptions.subscriptions.DomainBadge;
import com.sputnik.domain.entities.subscriptions.subscriptions.DomainDetailedLayout;
import com.sputnik.domain.entities.subscriptions.subscriptions.DomainFeatures;
import com.sputnik.domain.entities.subscriptions.subscriptions.DomainHeader;
import com.sputnik.domain.entities.subscriptions.subscriptions.DomainIncludedService;
import com.sputnik.domain.entities.subscriptions.subscriptions.DomainIncludedServiceAppearance;
import com.sputnik.domain.entities.subscriptions.subscriptions.DomainIncludedServices;
import com.sputnik.domain.entities.subscriptions.subscriptions.DomainNoticeBody;
import com.sputnik.domain.entities.subscriptions.subscriptions.DomainSubscriptionAppearance;
import java.util.ArrayList;
import java.util.List;
import kotlin.Metadata;
import kotlin.collections.CollectionsKt;
import kotlin.jvm.internal.Intrinsics;

/* compiled from: DataBaseAppearanceToDomainAppearanceMapper.kt */
@Metadata(d1 = {"\u0000\u0014\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0004\u0018\u00002\u000e\u0012\u0004\u0012\u00020\u0002\u0012\u0004\u0012\u00020\u00030\u0001B\u0007\b\u0007¢\u0006\u0002\u0010\u0004J\u0010\u0010\u0005\u001a\u00020\u00032\u0006\u0010\u0006\u001a\u00020\u0002H\u0016¨\u0006\u0007"}, d2 = {"Lcom/sputnik/data/mappers/subscriptions/DataBaseAppearanceToDomainAppearanceMapper;", "Lcom/sputnik/domain/common/Mapper;", "Lcom/sputnik/data/entities/subscriptions/subscriptions/DataSubscriptionAppearance;", "Lcom/sputnik/domain/entities/subscriptions/subscriptions/DomainSubscriptionAppearance;", "()V", "map", "input", "data_release"}, k = 1, mv = {1, 9, 0}, xi = 48)
/* loaded from: classes3.dex */
public final class DataBaseAppearanceToDomainAppearanceMapper implements Mapper<DataSubscriptionAppearance, DomainSubscriptionAppearance> {
    @Override // com.sputnik.domain.common.Mapper
    public DomainSubscriptionAppearance map(DataSubscriptionAppearance input) {
        ArrayList arrayList;
        ArrayList arrayList2;
        DataNoticeBody notice;
        DataIncludedServices includedServices;
        List<DataService> services;
        DataHeader header;
        DataFeatures features;
        DataFeatures features2;
        Intrinsics.checkNotNullParameter(input, "input");
        String finale = input.getFinale();
        String priceVerbose = input.getPriceVerbose();
        Boolean special = input.getSpecial();
        String specialDescription = input.getSpecialDescription();
        String title = input.getTitle();
        String description = input.getDescription();
        DataBadge badge = input.getBadge();
        String color = badge != null ? badge.getColor() : null;
        DataBadge badge2 = input.getBadge();
        DomainBadge domainBadge = new DomainBadge(color, badge2 != null ? badge2.getTitle() : null);
        DataDetailedLayout detailedLayout = input.getDetailedLayout();
        List<String> list = (detailedLayout == null || (features2 = detailedLayout.getFeatures()) == null) ? null : features2.getList();
        DataDetailedLayout detailedLayout2 = input.getDetailedLayout();
        DomainFeatures domainFeatures = new DomainFeatures(list, (detailedLayout2 == null || (features = detailedLayout2.getFeatures()) == null) ? null : features.getTitle());
        DataDetailedLayout detailedLayout3 = input.getDetailedLayout();
        DomainHeader domainHeader = new DomainHeader((detailedLayout3 == null || (header = detailedLayout3.getHeader()) == null) ? null : header.getTitle());
        DataDetailedLayout detailedLayout4 = input.getDetailedLayout();
        if (detailedLayout4 == null || (includedServices = detailedLayout4.getIncludedServices()) == null || (services = includedServices.getServices()) == null) {
            arrayList = null;
        } else {
            List<DataService> list2 = services;
            arrayList = new ArrayList(CollectionsKt.collectionSizeOrDefault(list2, 10));
            for (DataService dataService : list2) {
                DataServiceAppearance appearance = dataService.getAppearance();
                String description2 = appearance != null ? appearance.getDescription() : null;
                DataServiceAppearance appearance2 = dataService.getAppearance();
                String fullDescription = appearance2 != null ? appearance2.getFullDescription() : null;
                DataServiceAppearance appearance3 = dataService.getAppearance();
                String introduction = appearance3 != null ? appearance3.getIntroduction() : null;
                DataServiceAppearance appearance4 = dataService.getAppearance();
                String resume = appearance4 != null ? appearance4.getResume() : null;
                DataServiceAppearance appearance5 = dataService.getAppearance();
                String title2 = appearance5 != null ? appearance5.getTitle() : null;
                DataServiceAppearance appearance6 = dataService.getAppearance();
                arrayList.add(new DomainIncludedService(new DomainIncludedServiceAppearance(description2, fullDescription, introduction, resume, title2, appearance6 != null ? appearance6.getBadge() : null), dataService.getServiceConfigIdentifier()));
            }
        }
        DomainIncludedServices domainIncludedServices = new DomainIncludedServices(arrayList);
        DataDetailedLayout detailedLayout5 = input.getDetailedLayout();
        DomainDetailedLayout domainDetailedLayout = new DomainDetailedLayout(domainFeatures, domainHeader, domainIncludedServices, new DomainNoticeBody((detailedLayout5 == null || (notice = detailedLayout5.getNotice()) == null) ? null : notice.getBody()));
        List<String> featuresList = input.getFeaturesList();
        String priceText = input.getPriceText();
        List<DataSubscriptionAppearance.DataFeaturePoint> featuresPoints = input.getFeaturesPoints();
        if (featuresPoints != null) {
            List<DataSubscriptionAppearance.DataFeaturePoint> list3 = featuresPoints;
            ArrayList arrayList3 = new ArrayList(CollectionsKt.collectionSizeOrDefault(list3, 10));
            for (DataSubscriptionAppearance.DataFeaturePoint dataFeaturePoint : list3) {
                arrayList3.add(new DomainSubscriptionAppearance.DomainFeaturePoint(dataFeaturePoint.getTitle(), dataFeaturePoint.getBadge()));
            }
            arrayList2 = arrayList3;
        } else {
            arrayList2 = null;
        }
        return new DomainSubscriptionAppearance(finale, priceVerbose, priceText, special, specialDescription, title, description, domainBadge, domainDetailedLayout, featuresList, arrayList2);
    }
}

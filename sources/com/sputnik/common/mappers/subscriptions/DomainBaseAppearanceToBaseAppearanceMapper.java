package com.sputnik.common.mappers.subscriptions;

import com.sputnik.common.entities.subscriptions.Badge;
import com.sputnik.common.entities.subscriptions.DetailedLayout;
import com.sputnik.common.entities.subscriptions.Features;
import com.sputnik.common.entities.subscriptions.Header;
import com.sputnik.common.entities.subscriptions.IncludedServices;
import com.sputnik.common.entities.subscriptions.NoticeBody;
import com.sputnik.common.entities.subscriptions.Service;
import com.sputnik.common.entities.subscriptions.ServiceAppearance;
import com.sputnik.common.entities.subscriptions.SubscriptionAppearance;
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

/* compiled from: DomainBaseAppearanceToBaseAppearanceMapper.kt */
@Metadata(d1 = {"\u0000\u0014\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0004\u0018\u00002\u000e\u0012\u0004\u0012\u00020\u0002\u0012\u0004\u0012\u00020\u00030\u0001B\u0007\b\u0007¢\u0006\u0002\u0010\u0004J\u0010\u0010\u0005\u001a\u00020\u00032\u0006\u0010\u0006\u001a\u00020\u0002H\u0016¨\u0006\u0007"}, d2 = {"Lcom/sputnik/common/mappers/subscriptions/DomainBaseAppearanceToBaseAppearanceMapper;", "Lcom/sputnik/domain/common/Mapper;", "Lcom/sputnik/domain/entities/subscriptions/subscriptions/DomainSubscriptionAppearance;", "Lcom/sputnik/common/entities/subscriptions/SubscriptionAppearance;", "()V", "map", "input", "common_release"}, k = 1, mv = {1, 9, 0}, xi = 48)
/* loaded from: classes3.dex */
public final class DomainBaseAppearanceToBaseAppearanceMapper implements Mapper<DomainSubscriptionAppearance, SubscriptionAppearance> {
    @Override // com.sputnik.domain.common.Mapper
    public SubscriptionAppearance map(DomainSubscriptionAppearance input) {
        ArrayList arrayList;
        ArrayList arrayList2;
        DomainNoticeBody notice;
        DomainIncludedServices includedServices;
        List<DomainIncludedService> services;
        Enum enumValueOf;
        ServiceAppearance.ServiceBadges serviceBadges;
        DomainHeader header;
        DomainFeatures features;
        DomainFeatures features2;
        Intrinsics.checkNotNullParameter(input, "input");
        String finale = input.getFinale();
        String priceVerbose = input.getPriceVerbose();
        String priceText = input.getPriceText();
        Boolean special = input.getSpecial();
        String specialDescription = input.getSpecialDescription();
        String title = input.getTitle();
        String description = input.getDescription();
        DomainBadge badge = input.getBadge();
        String color = badge != null ? badge.getColor() : null;
        DomainBadge badge2 = input.getBadge();
        Badge badge3 = new Badge(color, badge2 != null ? badge2.getTitle() : null);
        DomainDetailedLayout detailedLayout = input.getDetailedLayout();
        List<String> list = (detailedLayout == null || (features2 = detailedLayout.getFeatures()) == null) ? null : features2.getList();
        DomainDetailedLayout detailedLayout2 = input.getDetailedLayout();
        Features features3 = new Features(list, (detailedLayout2 == null || (features = detailedLayout2.getFeatures()) == null) ? null : features.getTitle());
        DomainDetailedLayout detailedLayout3 = input.getDetailedLayout();
        Header header2 = new Header((detailedLayout3 == null || (header = detailedLayout3.getHeader()) == null) ? null : header.getTitle());
        DomainDetailedLayout detailedLayout4 = input.getDetailedLayout();
        if (detailedLayout4 == null || (includedServices = detailedLayout4.getIncludedServices()) == null || (services = includedServices.getServices()) == null) {
            arrayList = null;
        } else {
            List<DomainIncludedService> list2 = services;
            arrayList = new ArrayList(CollectionsKt.collectionSizeOrDefault(list2, 10));
            for (DomainIncludedService domainIncludedService : list2) {
                DomainIncludedServiceAppearance appearance = domainIncludedService.getAppearance();
                String description2 = appearance != null ? appearance.getDescription() : null;
                DomainIncludedServiceAppearance appearance2 = domainIncludedService.getAppearance();
                String fullDescription = appearance2 != null ? appearance2.getFullDescription() : null;
                DomainIncludedServiceAppearance appearance3 = domainIncludedService.getAppearance();
                String introduction = appearance3 != null ? appearance3.getIntroduction() : null;
                DomainIncludedServiceAppearance appearance4 = domainIncludedService.getAppearance();
                String resume = appearance4 != null ? appearance4.getResume() : null;
                DomainIncludedServiceAppearance appearance5 = domainIncludedService.getAppearance();
                String title2 = appearance5 != null ? appearance5.getTitle() : null;
                DomainIncludedServiceAppearance appearance6 = domainIncludedService.getAppearance();
                if ((appearance6 != null ? appearance6.getBadge() : null) == null) {
                    serviceBadges = null;
                } else {
                    DomainIncludedServiceAppearance appearance7 = domainIncludedService.getAppearance();
                    String badge4 = appearance7 != null ? appearance7.getBadge() : null;
                    if (badge4 == null) {
                        enumValueOf = null;
                        serviceBadges = (ServiceAppearance.ServiceBadges) enumValueOf;
                    } else {
                        try {
                            enumValueOf = Enum.valueOf(ServiceAppearance.ServiceBadges.class, badge4);
                        } catch (IllegalArgumentException unused) {
                        }
                        serviceBadges = (ServiceAppearance.ServiceBadges) enumValueOf;
                    }
                }
                arrayList.add(new Service(new ServiceAppearance(description2, fullDescription, introduction, resume, title2, serviceBadges), domainIncludedService.getServiceConfigIdentifier()));
            }
        }
        IncludedServices includedServices2 = new IncludedServices(arrayList);
        DomainDetailedLayout detailedLayout5 = input.getDetailedLayout();
        DetailedLayout detailedLayout6 = new DetailedLayout(features3, header2, includedServices2, new NoticeBody((detailedLayout5 == null || (notice = detailedLayout5.getNotice()) == null) ? null : notice.getBody()));
        List<String> featuresList = input.getFeaturesList();
        List<DomainSubscriptionAppearance.DomainFeaturePoint> featuresPoints = input.getFeaturesPoints();
        if (featuresPoints != null) {
            List<DomainSubscriptionAppearance.DomainFeaturePoint> list3 = featuresPoints;
            ArrayList arrayList3 = new ArrayList(CollectionsKt.collectionSizeOrDefault(list3, 10));
            for (DomainSubscriptionAppearance.DomainFeaturePoint domainFeaturePoint : list3) {
                arrayList3.add(new SubscriptionAppearance.FeaturePoint(domainFeaturePoint.getTitle(), domainFeaturePoint.getBadge()));
            }
            arrayList2 = arrayList3;
        } else {
            arrayList2 = null;
        }
        return new SubscriptionAppearance(badge3, description, detailedLayout6, featuresList, finale, priceVerbose, priceText, special, specialDescription, title, arrayList2);
    }
}

package sputnik.axmor.com.sputnik.mappers.market.market;

import com.sputnik.common.entities.market.market.Badge;
import com.sputnik.common.entities.market.market.Market;
import com.sputnik.common.entities.market.market.SmallServices;
import com.sputnik.common.entities.market.market.SubsPlans;
import com.sputnik.domain.common.Mapper;
import com.sputnik.domain.common.NullableInputListMapper;
import com.sputnik.domain.entities.market.DomainMarket;
import com.sputnik.domain.entities.market.DomainSubsPlans;
import com.sputnik.domain.entities.market.MarketTypes;
import com.sputnik.domain.entities.market.PlansDuration;
import com.sputnik.domain.entities.market.appearance.DomainAppearancePlans;
import com.sputnik.domain.entities.market.appearance.DomainBadgeStyle;
import com.sputnik.domain.entities.market.appearance.DomainDetailedLayout;
import com.sputnik.domain.entities.market.appearance.DomainFeatures;
import com.sputnik.domain.entities.market.appearance.DomainHeader;
import com.sputnik.domain.entities.market.appearance.DomainIncludedServices;
import com.sputnik.domain.entities.market.services.DomainSmallServices;
import com.sputnik.domain.entities.market.subscription.DomainSubscriptionAppearance;
import com.sputnik.domain.entities.market.subscription.DomainSubscriptionDetail;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import kotlin.Metadata;
import kotlin.collections.CollectionsKt;
import kotlin.jvm.internal.Intrinsics;

/* compiled from: DomainMarketToMarketMapper.kt */
@Metadata(d1 = {"\u00004\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010 \n\u0002\b\u0005\u0018\u00002\u000e\u0012\u0004\u0012\u00020\u0002\u0012\u0004\u0012\u00020\u00030\u0001B/\b\u0007\u0012\u0012\u0010\u0004\u001a\u000e\u0012\u0004\u0012\u00020\u0006\u0012\u0004\u0012\u00020\u00070\u0005\u0012\u0012\u0010\b\u001a\u000e\u0012\u0004\u0012\u00020\t\u0012\u0004\u0012\u00020\n0\u0005¢\u0006\u0002\u0010\u000bJ0\u0010\f\u001a\n\u0012\u0004\u0012\u00020\u0006\u0018\u00010\r2\u000e\u0010\u000e\u001a\n\u0012\u0004\u0012\u00020\u0006\u0018\u00010\r2\u000e\u0010\u000f\u001a\n\u0012\u0004\u0012\u00020\u0006\u0018\u00010\rH\u0002J\u0010\u0010\u0010\u001a\u00020\u00032\u0006\u0010\u0011\u001a\u00020\u0002H\u0016R\u001a\u0010\b\u001a\u000e\u0012\u0004\u0012\u00020\t\u0012\u0004\u0012\u00020\n0\u0005X\u0082\u0004¢\u0006\u0002\n\u0000R\u001a\u0010\u0004\u001a\u000e\u0012\u0004\u0012\u00020\u0006\u0012\u0004\u0012\u00020\u00070\u0005X\u0082\u0004¢\u0006\u0002\n\u0000¨\u0006\u0012"}, d2 = {"Lsputnik/axmor/com/sputnik/mappers/market/market/DomainMarketToMarketMapper;", "Lcom/sputnik/domain/common/Mapper;", "Lcom/sputnik/domain/entities/market/DomainMarket;", "Lcom/sputnik/common/entities/market/market/Market;", "domainSubsPlansToSubsPlansMapper", "Lcom/sputnik/domain/common/NullableInputListMapper;", "Lcom/sputnik/domain/entities/market/DomainSubsPlans;", "Lcom/sputnik/common/entities/market/market/SubsPlans;", "domainSmallServicesToSmallServicesMapper", "Lcom/sputnik/domain/entities/market/services/DomainSmallServices;", "Lcom/sputnik/common/entities/market/market/SmallServices;", "(Lcom/sputnik/domain/common/NullableInputListMapper;Lcom/sputnik/domain/common/NullableInputListMapper;)V", "joinTwoSubsPlans", "", "subPlansWithIds", "list2", "map", "input", "app_huaweiRelease"}, k = 1, mv = {1, 9, 0}, xi = 48)
/* loaded from: classes5.dex */
public final class DomainMarketToMarketMapper implements Mapper<DomainMarket, Market> {
    private final NullableInputListMapper<DomainSmallServices, SmallServices> domainSmallServicesToSmallServicesMapper;
    private final NullableInputListMapper<DomainSubsPlans, SubsPlans> domainSubsPlansToSubsPlansMapper;

    public DomainMarketToMarketMapper(NullableInputListMapper<DomainSubsPlans, SubsPlans> domainSubsPlansToSubsPlansMapper, NullableInputListMapper<DomainSmallServices, SmallServices> domainSmallServicesToSmallServicesMapper) {
        Intrinsics.checkNotNullParameter(domainSubsPlansToSubsPlansMapper, "domainSubsPlansToSubsPlansMapper");
        Intrinsics.checkNotNullParameter(domainSmallServicesToSmallServicesMapper, "domainSmallServicesToSmallServicesMapper");
        this.domainSubsPlansToSubsPlansMapper = domainSubsPlansToSubsPlansMapper;
        this.domainSmallServicesToSmallServicesMapper = domainSmallServicesToSmallServicesMapper;
    }

    @Override // com.sputnik.domain.common.Mapper
    public Market map(DomainMarket input) {
        Badge badge;
        DomainBadgeStyle badge2;
        DomainBadgeStyle badge3;
        String str;
        List<DomainSubsPlans> list;
        DomainDetailedLayout detailedLayout;
        DomainIncludedServices includedServices;
        DomainDetailedLayout detailedLayout2;
        DomainIncludedServices includedServices2;
        DomainDetailedLayout detailedLayout3;
        DomainAppearancePlans plans;
        DomainDetailedLayout detailedLayout4;
        DomainAppearancePlans plans2;
        DomainDetailedLayout detailedLayout5;
        DomainFeatures features;
        DomainBadgeStyle badge4;
        DomainDetailedLayout detailedLayout6;
        DomainHeader header;
        Intrinsics.checkNotNullParameter(input, "input");
        DomainSubscriptionAppearance appearance = input.getAppearance();
        String title = appearance != null ? appearance.getTitle() : null;
        DomainSubscriptionAppearance appearance2 = input.getAppearance();
        List<String> title2 = (appearance2 == null || (detailedLayout6 = appearance2.getDetailedLayout()) == null || (header = detailedLayout6.getHeader()) == null) ? null : header.getTitle();
        DomainSubscriptionAppearance appearance3 = input.getAppearance();
        String description = appearance3 != null ? appearance3.getDescription() : null;
        DomainSubscriptionAppearance appearance4 = input.getAppearance();
        String finale = appearance4 != null ? appearance4.getFinale() : null;
        DomainSubscriptionAppearance appearance5 = input.getAppearance();
        String link = appearance5 != null ? appearance5.getLink() : null;
        MarketTypes type = input.getType();
        String identifier = input.getIdentifier();
        DomainSubscriptionAppearance appearance6 = input.getAppearance();
        Boolean special = appearance6 != null ? appearance6.getSpecial() : null;
        DomainSubscriptionAppearance appearance7 = input.getAppearance();
        String specialDescription = appearance7 != null ? appearance7.getSpecialDescription() : null;
        DomainSubscriptionAppearance appearance8 = input.getAppearance();
        if (((appearance8 == null || (badge4 = appearance8.getBadge()) == null) ? null : badge4.getTitle()) == null) {
            badge = null;
        } else {
            DomainSubscriptionAppearance appearance9 = input.getAppearance();
            String title3 = (appearance9 == null || (badge3 = appearance9.getBadge()) == null) ? null : badge3.getTitle();
            DomainSubscriptionAppearance appearance10 = input.getAppearance();
            badge = new Badge(title3, (appearance10 == null || (badge2 = appearance10.getBadge()) == null) ? null : badge2.getColor());
        }
        DomainSubscriptionAppearance appearance11 = input.getAppearance();
        String priceVerbose = appearance11 != null ? appearance11.getPriceVerbose() : null;
        DomainSubscriptionDetail subscriptionDetails = input.getSubscriptionDetails();
        String productId = subscriptionDetails != null ? subscriptionDetails.getProductId() : null;
        DomainSubscriptionAppearance appearance12 = input.getAppearance();
        List<String> list2 = (appearance12 == null || (detailedLayout5 = appearance12.getDetailedLayout()) == null || (features = detailedLayout5.getFeatures()) == null) ? null : features.getList();
        NullableInputListMapper<DomainSubsPlans, SubsPlans> nullableInputListMapper = this.domainSubsPlansToSubsPlansMapper;
        DomainSubscriptionDetail subscriptionDetails2 = input.getSubscriptionDetails();
        List<DomainSubsPlans> plans3 = subscriptionDetails2 != null ? subscriptionDetails2.getPlans() : null;
        DomainSubscriptionAppearance appearance13 = input.getAppearance();
        if (appearance13 == null || (detailedLayout4 = appearance13.getDetailedLayout()) == null || (plans2 = detailedLayout4.getPlans()) == null) {
            str = productId;
            list = null;
        } else {
            List<DomainSubsPlans> plans4 = plans2.getPlans();
            str = productId;
            list = plans4;
        }
        List list3 = (List) nullableInputListMapper.map(joinTwoSubsPlans(plans3, list));
        DomainSubscriptionAppearance appearance14 = input.getAppearance();
        String title4 = (appearance14 == null || (detailedLayout3 = appearance14.getDetailedLayout()) == null || (plans = detailedLayout3.getPlans()) == null) ? null : plans.getTitle();
        NullableInputListMapper<DomainSmallServices, SmallServices> nullableInputListMapper2 = this.domainSmallServicesToSmallServicesMapper;
        DomainSubscriptionAppearance appearance15 = input.getAppearance();
        List list4 = (List) nullableInputListMapper2.map((appearance15 == null || (detailedLayout2 = appearance15.getDetailedLayout()) == null || (includedServices2 = detailedLayout2.getIncludedServices()) == null) ? null : includedServices2.getServices());
        DomainSubscriptionAppearance appearance16 = input.getAppearance();
        return new Market(title, title2, description, finale, link, type, identifier, special, specialDescription, badge, priceVerbose, str, list2, null, list3, title4, list4, (appearance16 == null || (detailedLayout = appearance16.getDetailedLayout()) == null || (includedServices = detailedLayout.getIncludedServices()) == null) ? null : includedServices.getTitle(), 8192, null);
    }

    private final List<DomainSubsPlans> joinTwoSubsPlans(List<DomainSubsPlans> subPlansWithIds, List<DomainSubsPlans> list2) {
        DomainSubsPlans domainSubsPlans;
        String str;
        Object next;
        if (subPlansWithIds == null) {
            return null;
        }
        List<DomainSubsPlans> list = subPlansWithIds;
        ArrayList arrayList = new ArrayList(CollectionsKt.collectionSizeOrDefault(list, 10));
        for (DomainSubsPlans domainSubsPlans2 : list) {
            if (list2 != null) {
                Iterator<T> it = list2.iterator();
                while (true) {
                    if (!it.hasNext()) {
                        next = null;
                        break;
                    }
                    next = it.next();
                    DomainSubsPlans domainSubsPlans3 = (DomainSubsPlans) next;
                    if (domainSubsPlans3.getDuration() == domainSubsPlans2.getDuration() && Intrinsics.areEqual(domainSubsPlans3.getPrice(), domainSubsPlans2.getPrice())) {
                        break;
                    }
                }
                domainSubsPlans = (DomainSubsPlans) next;
            } else {
                domainSubsPlans = null;
            }
            String title = domainSubsPlans2.getTitle();
            if (title != null) {
                str = title;
            } else if (domainSubsPlans != null) {
                title = domainSubsPlans.getTitle();
                str = title;
            } else {
                str = null;
            }
            String identifier = domainSubsPlans2.getIdentifier();
            if (identifier == null) {
                identifier = domainSubsPlans != null ? domainSubsPlans.getIdentifier() : null;
            }
            PlansDuration duration = domainSubsPlans2.getDuration();
            if (duration == null) {
                duration = domainSubsPlans != null ? domainSubsPlans.getDuration() : null;
            }
            Integer price = domainSubsPlans2.getPrice();
            if (price == null) {
                price = domainSubsPlans != null ? domainSubsPlans.getPrice() : null;
            }
            Boolean special = domainSubsPlans2.getSpecial();
            if (special == null) {
                special = domainSubsPlans != null ? domainSubsPlans.getSpecial() : null;
            }
            String specialDescription = domainSubsPlans2.getSpecialDescription();
            if (specialDescription == null) {
                specialDescription = domainSubsPlans != null ? domainSubsPlans.getSpecialDescription() : null;
            }
            String specialBadgeTitle = domainSubsPlans2.getSpecialBadgeTitle();
            if (specialBadgeTitle == null) {
                specialBadgeTitle = domainSubsPlans != null ? domainSubsPlans.getSpecialBadgeTitle() : null;
            }
            String priceVerbose = domainSubsPlans2.getPriceVerbose();
            if (priceVerbose == null) {
                priceVerbose = domainSubsPlans != null ? domainSubsPlans.getPriceVerbose() : null;
            }
            arrayList.add(domainSubsPlans2.copy(identifier, duration, price, str, special, specialDescription, specialBadgeTitle, priceVerbose));
        }
        return arrayList;
    }
}

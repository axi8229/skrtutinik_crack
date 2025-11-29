package com.sputnik.data.mappers.subscriptions;

import com.sputnik.data.entities.subscriptions.subscriptions.DataBaseSubscription;
import com.sputnik.data.entities.subscriptions.subscriptions.DataPlan;
import com.sputnik.data.entities.subscriptions.subscriptions.DataSubscriptionAppearance;
import com.sputnik.data.entities.subscriptions.subscriptions.DataSubscriptionDetails;
import com.sputnik.domain.common.Mapper;
import com.sputnik.domain.entities.subscriptions.subscriptions.DomainBaseSubscription;
import com.sputnik.domain.entities.subscriptions.subscriptions.DomainPlan;
import com.sputnik.domain.entities.subscriptions.subscriptions.DomainSubscriptionAppearance;
import com.sputnik.domain.entities.subscriptions.subscriptions.DomainSubscriptionDetails;
import com.sputnik.domain.entities.subscriptions.subscriptions.SubscriptionStates;
import com.sputnik.domain.entities.subscriptions.subscriptions.SubscriptionTypes;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import kotlin.Metadata;
import kotlin.collections.CollectionsKt;
import kotlin.jvm.internal.Intrinsics;

/* compiled from: DataBaseSubscriptionToDomainBaseSubscriptionMapper.kt */
@Metadata(d1 = {"\u0000\u001a\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0004\u0018\u00002\u000e\u0012\u0004\u0012\u00020\u0002\u0012\u0004\u0012\u00020\u00030\u0001B\u000f\b\u0007\u0012\u0006\u0010\u0004\u001a\u00020\u0005¢\u0006\u0002\u0010\u0006J\u0010\u0010\u0007\u001a\u00020\u00032\u0006\u0010\b\u001a\u00020\u0002H\u0016R\u000e\u0010\u0004\u001a\u00020\u0005X\u0082\u0004¢\u0006\u0002\n\u0000¨\u0006\t"}, d2 = {"Lcom/sputnik/data/mappers/subscriptions/DataBaseSubscriptionToDomainBaseSubscriptionMapper;", "Lcom/sputnik/domain/common/Mapper;", "Lcom/sputnik/data/entities/subscriptions/subscriptions/DataBaseSubscription;", "Lcom/sputnik/domain/entities/subscriptions/subscriptions/DomainBaseSubscription;", "dataBaseAppearanceToDomainAppearanceMapper", "Lcom/sputnik/data/mappers/subscriptions/DataBaseAppearanceToDomainAppearanceMapper;", "(Lcom/sputnik/data/mappers/subscriptions/DataBaseAppearanceToDomainAppearanceMapper;)V", "map", "input", "data_release"}, k = 1, mv = {1, 9, 0}, xi = 48)
/* loaded from: classes3.dex */
public final class DataBaseSubscriptionToDomainBaseSubscriptionMapper implements Mapper<DataBaseSubscription, DomainBaseSubscription> {
    private final DataBaseAppearanceToDomainAppearanceMapper dataBaseAppearanceToDomainAppearanceMapper;

    public DataBaseSubscriptionToDomainBaseSubscriptionMapper(DataBaseAppearanceToDomainAppearanceMapper dataBaseAppearanceToDomainAppearanceMapper) {
        Intrinsics.checkNotNullParameter(dataBaseAppearanceToDomainAppearanceMapper, "dataBaseAppearanceToDomainAppearanceMapper");
        this.dataBaseAppearanceToDomainAppearanceMapper = dataBaseAppearanceToDomainAppearanceMapper;
    }

    @Override // com.sputnik.domain.common.Mapper
    public DomainBaseSubscription map(DataBaseSubscription input) {
        DomainSubscriptionAppearance domainSubscriptionAppearance;
        ArrayList arrayList;
        List<DataPlan> plans;
        Iterator it;
        Integer discountPrice;
        DomainSubscriptionAppearance domainSubscriptionAppearance2;
        String link;
        DomainPlan.DomainPromo domainPromo;
        Intrinsics.checkNotNullParameter(input, "input");
        String identifier = input.getIdentifier();
        Integer order = input.getOrder();
        Integer version = input.getVersion();
        String duration = input.getDuration();
        String expires = input.getExpires();
        String plan = input.getPlan();
        String productId = input.getProductId();
        SubscriptionStates state = input.getState();
        SubscriptionTypes type = input.getType();
        DataSubscriptionAppearance appearance = input.getAppearance();
        DomainSubscriptionAppearance map = appearance != null ? this.dataBaseAppearanceToDomainAppearanceMapper.map(appearance) : null;
        DataSubscriptionDetails subscriptionDetails = input.getSubscriptionDetails();
        if (subscriptionDetails == null || (plans = subscriptionDetails.getPlans()) == null) {
            domainSubscriptionAppearance = map;
            arrayList = null;
        } else {
            List<DataPlan> list = plans;
            arrayList = new ArrayList(CollectionsKt.collectionSizeOrDefault(list, 10));
            Iterator it2 = list.iterator();
            while (it2.hasNext()) {
                DataPlan dataPlan = (DataPlan) it2.next();
                String appstoreProductId = dataPlan.getAppstoreProductId();
                String duration2 = dataPlan.getDuration();
                String identifier2 = dataPlan.getIdentifier();
                Integer price = dataPlan.getPrice();
                if (dataPlan.getPromo() == null) {
                    domainSubscriptionAppearance2 = map;
                    it = it2;
                    domainPromo = null;
                } else {
                    DataPlan.DataPromo promo = dataPlan.getPromo();
                    if (promo != null) {
                        it = it2;
                        discountPrice = promo.getDiscountPrice();
                    } else {
                        it = it2;
                        discountPrice = null;
                    }
                    DataPlan.DataPromo promo2 = dataPlan.getPromo();
                    String description = promo2 != null ? promo2.getDescription() : null;
                    DataPlan.DataPromo promo3 = dataPlan.getPromo();
                    if (promo3 != null) {
                        domainSubscriptionAppearance2 = map;
                        link = promo3.getLink();
                    } else {
                        domainSubscriptionAppearance2 = map;
                        link = null;
                    }
                    DataPlan.DataPromo promo4 = dataPlan.getPromo();
                    domainPromo = new DomainPlan.DomainPromo(discountPrice, description, link, promo4 != null ? promo4.getLinkText() : null);
                }
                arrayList.add(new DomainPlan(appstoreProductId, duration2, identifier2, price, domainPromo));
                it2 = it;
                map = domainSubscriptionAppearance2;
            }
            domainSubscriptionAppearance = map;
        }
        DataSubscriptionDetails subscriptionDetails2 = input.getSubscriptionDetails();
        return new DomainBaseSubscription(identifier, order, version, duration, expires, plan, productId, state, type, domainSubscriptionAppearance, new DomainSubscriptionDetails(arrayList, subscriptionDetails2 != null ? subscriptionDetails2.getProductId() : null));
    }
}

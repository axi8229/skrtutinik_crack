package com.sputnik.data.mappers.market.subscription;

import com.sputnik.data.entities.market.DataPlans;
import com.sputnik.data.entities.market.DataSmallService;
import com.sputnik.data.entities.market.subscription.DataSubscription;
import com.sputnik.data.entities.market.subscription.DataSubscriptionAppearance;
import com.sputnik.data.mappers.market.DataPlansToDomainPlansMapper;
import com.sputnik.domain.common.Mapper;
import com.sputnik.domain.common.NullableInputListMapper;
import com.sputnik.domain.entities.market.PlansDuration;
import com.sputnik.domain.entities.market.services.DomainSmallServices;
import com.sputnik.domain.entities.market.services.ServiceState;
import com.sputnik.domain.entities.market.subscription.DomainPlans;
import com.sputnik.domain.entities.market.subscription.DomainSubscription;
import java.util.List;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

/* compiled from: DataSubscriptionToDomainSubscriptionMapper.kt */
@Metadata(d1 = {"\u0000.\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0004\u0018\u00002\u000e\u0012\u0004\u0012\u00020\u0002\u0012\u0004\u0012\u00020\u00030\u0001B+\b\u0007\u0012\u0006\u0010\u0004\u001a\u00020\u0005\u0012\u0012\u0010\u0006\u001a\u000e\u0012\u0004\u0012\u00020\b\u0012\u0004\u0012\u00020\t0\u0007\u0012\u0006\u0010\n\u001a\u00020\u000b¢\u0006\u0002\u0010\fJ\u0010\u0010\r\u001a\u00020\u00032\u0006\u0010\u000e\u001a\u00020\u0002H\u0016R\u000e\u0010\n\u001a\u00020\u000bX\u0082\u0004¢\u0006\u0002\n\u0000R\u001a\u0010\u0006\u001a\u000e\u0012\u0004\u0012\u00020\b\u0012\u0004\u0012\u00020\t0\u0007X\u0082\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\u0004\u001a\u00020\u0005X\u0082\u0004¢\u0006\u0002\n\u0000¨\u0006\u000f"}, d2 = {"Lcom/sputnik/data/mappers/market/subscription/DataSubscriptionToDomainSubscriptionMapper;", "Lcom/sputnik/domain/common/Mapper;", "Lcom/sputnik/data/entities/market/subscription/DataSubscription;", "Lcom/sputnik/domain/entities/market/subscription/DomainSubscription;", "dataSubscriptionAppearanceToDomainSubscriptionAppearanceMapper", "Lcom/sputnik/data/mappers/market/subscription/DataSubscriptionAppearanceToDomainSubscriptionAppearanceMapper;", "dataSmallServiceToDomainSmallServiceMapper", "Lcom/sputnik/domain/common/NullableInputListMapper;", "Lcom/sputnik/data/entities/market/DataSmallService;", "Lcom/sputnik/domain/entities/market/services/DomainSmallServices;", "dataPlansToDomainPlansMapper", "Lcom/sputnik/data/mappers/market/DataPlansToDomainPlansMapper;", "(Lcom/sputnik/data/mappers/market/subscription/DataSubscriptionAppearanceToDomainSubscriptionAppearanceMapper;Lcom/sputnik/domain/common/NullableInputListMapper;Lcom/sputnik/data/mappers/market/DataPlansToDomainPlansMapper;)V", "map", "input", "data_release"}, k = 1, mv = {1, 9, 0}, xi = 48)
/* loaded from: classes3.dex */
public final class DataSubscriptionToDomainSubscriptionMapper implements Mapper<DataSubscription, DomainSubscription> {
    private final DataPlansToDomainPlansMapper dataPlansToDomainPlansMapper;
    private final NullableInputListMapper<DataSmallService, DomainSmallServices> dataSmallServiceToDomainSmallServiceMapper;
    private final DataSubscriptionAppearanceToDomainSubscriptionAppearanceMapper dataSubscriptionAppearanceToDomainSubscriptionAppearanceMapper;

    public DataSubscriptionToDomainSubscriptionMapper(DataSubscriptionAppearanceToDomainSubscriptionAppearanceMapper dataSubscriptionAppearanceToDomainSubscriptionAppearanceMapper, NullableInputListMapper<DataSmallService, DomainSmallServices> dataSmallServiceToDomainSmallServiceMapper, DataPlansToDomainPlansMapper dataPlansToDomainPlansMapper) {
        Intrinsics.checkNotNullParameter(dataSubscriptionAppearanceToDomainSubscriptionAppearanceMapper, "dataSubscriptionAppearanceToDomainSubscriptionAppearanceMapper");
        Intrinsics.checkNotNullParameter(dataSmallServiceToDomainSmallServiceMapper, "dataSmallServiceToDomainSmallServiceMapper");
        Intrinsics.checkNotNullParameter(dataPlansToDomainPlansMapper, "dataPlansToDomainPlansMapper");
        this.dataSubscriptionAppearanceToDomainSubscriptionAppearanceMapper = dataSubscriptionAppearanceToDomainSubscriptionAppearanceMapper;
        this.dataSmallServiceToDomainSmallServiceMapper = dataSmallServiceToDomainSmallServiceMapper;
        this.dataPlansToDomainPlansMapper = dataPlansToDomainPlansMapper;
    }

    @Override // com.sputnik.domain.common.Mapper
    public DomainSubscription map(DataSubscription input) {
        Intrinsics.checkNotNullParameter(input, "input");
        String productId = input.getProductId();
        ServiceState state = input.getState();
        Boolean autoRenewStatus = input.getAutoRenewStatus();
        String subscribedFrom = input.getSubscribedFrom();
        Boolean trial = input.getTrial();
        Boolean canManage = input.getCanManage();
        String expansion = input.getExpansion();
        Boolean primeSubscription = input.getPrimeSubscription();
        List list = (List) this.dataSmallServiceToDomainSmallServiceMapper.map(input.getServices());
        PlansDuration duration = input.getDuration();
        DataPlans activePlan = input.getActivePlan();
        DomainPlans map = activePlan != null ? this.dataPlansToDomainPlansMapper.map(activePlan) : null;
        String plan = input.getPlan();
        Integer price = input.getPrice();
        Double refund = input.getRefund();
        DataSubscriptionAppearance appearance = input.getAppearance();
        return new DomainSubscription(productId, state, autoRenewStatus, subscribedFrom, trial, canManage, expansion, primeSubscription, list, duration, map, plan, price, refund, appearance != null ? this.dataSubscriptionAppearanceToDomainSubscriptionAppearanceMapper.map(appearance) : null, input.getFullExpiresDate());
    }
}

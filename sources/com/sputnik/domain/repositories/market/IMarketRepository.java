package com.sputnik.domain.repositories.market;

import com.sputnik.domain.common.Resource;
import com.sputnik.domain.entities.market.DomainMarket;
import com.sputnik.domain.entities.market.services.DomainService;
import com.sputnik.domain.entities.market.subscription.DomainSubscription;
import com.sputnik.domain.entities.subscriptions.DomainMarketV2;
import java.util.List;
import kotlin.Metadata;
import kotlinx.coroutines.flow.Flow;

/* compiled from: IMarketRepository.kt */
@Metadata(d1 = {"\u00004\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0018\u0002\n\u0000\bf\u0018\u00002\u00020\u0001J\u001a\u0010\u0002\u001a\u0014\u0012\u0010\u0012\u000e\u0012\n\u0012\b\u0012\u0004\u0012\u00020\u00060\u00050\u00040\u0003H&J\u0014\u0010\u0007\u001a\u000e\u0012\n\u0012\b\u0012\u0004\u0012\u00020\b0\u00040\u0003H&J\"\u0010\t\u001a\u0014\u0012\u0010\u0012\u000e\u0012\n\u0012\b\u0012\u0004\u0012\u00020\n0\u00050\u00040\u00032\u0006\u0010\u000b\u001a\u00020\fH&J\u001a\u0010\r\u001a\u0014\u0012\u0010\u0012\u000e\u0012\n\u0012\b\u0012\u0004\u0012\u00020\u000e0\u00050\u00040\u0003H&¨\u0006\u000f"}, d2 = {"Lcom/sputnik/domain/repositories/market/IMarketRepository;", "", "getMarket", "Lkotlinx/coroutines/flow/Flow;", "Lcom/sputnik/domain/common/Resource;", "", "Lcom/sputnik/domain/entities/market/DomainMarket;", "getMarketV2", "Lcom/sputnik/domain/entities/subscriptions/DomainMarketV2;", "getServices", "Lcom/sputnik/domain/entities/market/services/DomainService;", "addressId", "", "getSubscriptions", "Lcom/sputnik/domain/entities/market/subscription/DomainSubscription;", "domain"}, k = 1, mv = {1, 9, 0}, xi = 48)
/* loaded from: classes3.dex */
public interface IMarketRepository {
    Flow<Resource<List<DomainMarket>>> getMarket();

    Flow<Resource<DomainMarketV2>> getMarketV2();

    Flow<Resource<List<DomainService>>> getServices(int addressId);

    Flow<Resource<List<DomainSubscription>>> getSubscriptions();
}

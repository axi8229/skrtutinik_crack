package com.sputnik.domain.repositories.subscription;

import com.sputnik.domain.common.Resource;
import com.sputnik.domain.entities.card.DomainPaymentState;
import com.sputnik.domain.entities.market.subscription.DomainSubscriptionStart;
import kotlin.Metadata;
import kotlin.Unit;
import kotlinx.coroutines.flow.Flow;

/* compiled from: ISubscriptionRepository.kt */
@Metadata(d1 = {"\u0000,\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0010\u0002\n\u0000\bf\u0018\u00002\u00020\u0001J\u001c\u0010\u0002\u001a\u000e\u0012\n\u0012\b\u0012\u0004\u0012\u00020\u00050\u00040\u00032\u0006\u0010\u0006\u001a\u00020\u0007H&J8\u0010\b\u001a\u000e\u0012\n\u0012\b\u0012\u0004\u0012\u00020\t0\u00040\u00032\u0006\u0010\u0006\u001a\u00020\u00072\u0006\u0010\n\u001a\u00020\u00072\b\u0010\u000b\u001a\u0004\u0018\u00010\u00072\b\u0010\f\u001a\u0004\u0018\u00010\u0007H&J\u001c\u0010\r\u001a\u000e\u0012\n\u0012\b\u0012\u0004\u0012\u00020\u000e0\u00040\u00032\u0006\u0010\u0006\u001a\u00020\u0007H&¨\u0006\u000f"}, d2 = {"Lcom/sputnik/domain/repositories/subscription/ISubscriptionRepository;", "", "getLastCardPayment", "Lkotlinx/coroutines/flow/Flow;", "Lcom/sputnik/domain/common/Resource;", "Lcom/sputnik/domain/entities/card/DomainPaymentState;", "id", "", "startSubscription", "Lcom/sputnik/domain/entities/market/subscription/DomainSubscriptionStart;", "plan", "paymentToken", "paymentMethod", "stopSubscription", "", "domain"}, k = 1, mv = {1, 9, 0}, xi = 48)
/* loaded from: classes3.dex */
public interface ISubscriptionRepository {
    Flow<Resource<DomainPaymentState>> getLastCardPayment(String id);

    Flow<Resource<DomainSubscriptionStart>> startSubscription(String id, String plan, String paymentToken, String paymentMethod);

    Flow<Resource<Unit>> stopSubscription(String id);
}

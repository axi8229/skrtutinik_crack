package com.sputnik.domain.repositories.card;

import com.sputnik.domain.common.Resource;
import com.sputnik.domain.entities.card.DomainConfirmation;
import com.sputnik.domain.entities.card.DomainPaymentState;
import kotlin.Metadata;
import kotlin.Unit;
import kotlinx.coroutines.flow.Flow;

/* compiled from: ICardRepository.kt */
@Metadata(d1 = {"\u0000,\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0000\bf\u0018\u00002\u00020\u0001J$\u0010\u0002\u001a\u000e\u0012\n\u0012\b\u0012\u0004\u0012\u00020\u00050\u00040\u00032\u0006\u0010\u0006\u001a\u00020\u00072\u0006\u0010\b\u001a\u00020\u0007H&J\u0014\u0010\t\u001a\u000e\u0012\n\u0012\b\u0012\u0004\u0012\u00020\n0\u00040\u0003H&J\u0014\u0010\u000b\u001a\u000e\u0012\n\u0012\b\u0012\u0004\u0012\u00020\f0\u00040\u0003H&¨\u0006\r"}, d2 = {"Lcom/sputnik/domain/repositories/card/ICardRepository;", "", "addNewCard", "Lkotlinx/coroutines/flow/Flow;", "Lcom/sputnik/domain/common/Resource;", "Lcom/sputnik/domain/entities/card/DomainConfirmation;", "paymentToken", "", "paymentMethodType", "getLastCardPayment", "Lcom/sputnik/domain/entities/card/DomainPaymentState;", "removeCard", "", "domain"}, k = 1, mv = {1, 9, 0}, xi = 48)
/* loaded from: classes3.dex */
public interface ICardRepository {
    Flow<Resource<DomainConfirmation>> addNewCard(String paymentToken, String paymentMethodType);

    Flow<Resource<DomainPaymentState>> getLastCardPayment();

    Flow<Resource<Unit>> removeCard();
}

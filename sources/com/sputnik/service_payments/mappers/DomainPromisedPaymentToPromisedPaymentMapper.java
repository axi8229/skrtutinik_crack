package com.sputnik.service_payments.mappers;

import com.sputnik.domain.common.Mapper;
import com.sputnik.domain.entities.service_payments.DomainPaymentHistory;
import com.sputnik.domain.entities.service_payments.DomainPromisePayment;
import com.sputnik.domain.entities.service_payments.DomainPromisedPayment;
import com.sputnik.domain.entities.service_payments.ServicePaymentState;
import com.sputnik.domain.entities.service_payments.ServicePaymentType;
import com.sputnik.domain.usecases.service_payments.PromisePaymentStates;
import com.sputnik.service_payments.entities.payments.PaymentHistory;
import com.sputnik.service_payments.entities.payments.PromisePayment;
import com.sputnik.service_payments.entities.payments.PromisedPayment;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

/* compiled from: DomainPromisedPaymentToPromisedPaymentMapper.kt */
@Metadata(d1 = {"\u0000\u0014\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0004\u0018\u00002\u000e\u0012\u0004\u0012\u00020\u0002\u0012\u0004\u0012\u00020\u00030\u0001B\u0007\b\u0007¢\u0006\u0002\u0010\u0004J\u0010\u0010\u0005\u001a\u00020\u00032\u0006\u0010\u0006\u001a\u00020\u0002H\u0016¨\u0006\u0007"}, d2 = {"Lcom/sputnik/service_payments/mappers/DomainPromisedPaymentToPromisedPaymentMapper;", "Lcom/sputnik/domain/common/Mapper;", "Lcom/sputnik/domain/entities/service_payments/DomainPromisePayment;", "Lcom/sputnik/service_payments/entities/payments/PromisePayment;", "()V", "map", "input", "service_payments_release"}, k = 1, mv = {1, 9, 0}, xi = 48)
/* loaded from: classes3.dex */
public final class DomainPromisedPaymentToPromisedPaymentMapper implements Mapper<DomainPromisePayment, PromisePayment> {
    @Override // com.sputnik.domain.common.Mapper
    public PromisePayment map(DomainPromisePayment input) {
        Intrinsics.checkNotNullParameter(input, "input");
        DomainPaymentHistory accrual = input.getAccrual();
        String id = accrual != null ? accrual.getId() : null;
        DomainPaymentHistory accrual2 = input.getAccrual();
        ServicePaymentType type = accrual2 != null ? accrual2.getType() : null;
        DomainPaymentHistory accrual3 = input.getAccrual();
        String amount = accrual3 != null ? accrual3.getAmount() : null;
        DomainPaymentHistory accrual4 = input.getAccrual();
        ServicePaymentState state = accrual4 != null ? accrual4.getState() : null;
        DomainPaymentHistory accrual5 = input.getAccrual();
        PaymentHistory paymentHistory = new PaymentHistory(id, type, amount, state, accrual5 != null ? accrual5.getPaymentDate() : null, null, 0L, 96, null);
        DomainPromisedPayment promisedPayment = input.getPromisedPayment();
        String accrualUuid = promisedPayment != null ? promisedPayment.getAccrualUuid() : null;
        DomainPromisedPayment promisedPayment2 = input.getPromisedPayment();
        String activatedAt = promisedPayment2 != null ? promisedPayment2.getActivatedAt() : null;
        DomainPromisedPayment promisedPayment3 = input.getPromisedPayment();
        String expiresAt = promisedPayment3 != null ? promisedPayment3.getExpiresAt() : null;
        DomainPromisedPayment promisedPayment4 = input.getPromisedPayment();
        PromisePaymentStates state2 = promisedPayment4 != null ? promisedPayment4.getState() : null;
        DomainPromisedPayment promisedPayment5 = input.getPromisedPayment();
        String type2 = promisedPayment5 != null ? promisedPayment5.getType() : null;
        DomainPromisedPayment promisedPayment6 = input.getPromisedPayment();
        return new PromisePayment(paymentHistory, new PromisedPayment(accrualUuid, activatedAt, expiresAt, state2, type2, promisedPayment6 != null ? promisedPayment6.getUuid() : null));
    }
}

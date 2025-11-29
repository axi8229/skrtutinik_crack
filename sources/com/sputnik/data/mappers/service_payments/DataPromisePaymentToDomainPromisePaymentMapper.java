package com.sputnik.data.mappers.service_payments;

import com.sputnik.data.entities.service_payments.DataPaymentHistory;
import com.sputnik.data.entities.service_payments.DataPromisePayment;
import com.sputnik.data.entities.service_payments.DataPromisedPayment;
import com.sputnik.domain.common.Mapper;
import com.sputnik.domain.entities.service_payments.DomainPaymentHistory;
import com.sputnik.domain.entities.service_payments.DomainPromisePayment;
import com.sputnik.domain.entities.service_payments.DomainPromisedPayment;
import com.sputnik.domain.entities.service_payments.ServicePaymentType;
import com.sputnik.domain.usecases.service_payments.PromisePaymentStates;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

/* compiled from: DataPromisePaymentToDomainPromisePaymentMapper.kt */
@Metadata(d1 = {"\u0000\u0014\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0004\u0018\u00002\u000e\u0012\u0004\u0012\u00020\u0002\u0012\u0004\u0012\u00020\u00030\u0001B\u0007\b\u0007¢\u0006\u0002\u0010\u0004J\u0010\u0010\u0005\u001a\u00020\u00032\u0006\u0010\u0006\u001a\u00020\u0002H\u0016¨\u0006\u0007"}, d2 = {"Lcom/sputnik/data/mappers/service_payments/DataPromisePaymentToDomainPromisePaymentMapper;", "Lcom/sputnik/domain/common/Mapper;", "Lcom/sputnik/data/entities/service_payments/DataPromisePayment;", "Lcom/sputnik/domain/entities/service_payments/DomainPromisePayment;", "()V", "map", "input", "data_release"}, k = 1, mv = {1, 9, 0}, xi = 48)
/* loaded from: classes3.dex */
public final class DataPromisePaymentToDomainPromisePaymentMapper implements Mapper<DataPromisePayment, DomainPromisePayment> {
    @Override // com.sputnik.domain.common.Mapper
    public DomainPromisePayment map(DataPromisePayment input) {
        Intrinsics.checkNotNullParameter(input, "input");
        DataPaymentHistory accrual = input.getAccrual();
        String id = accrual != null ? accrual.getId() : null;
        DataPaymentHistory accrual2 = input.getAccrual();
        ServicePaymentType type = accrual2 != null ? accrual2.getType() : null;
        DataPaymentHistory accrual3 = input.getAccrual();
        String amount = accrual3 != null ? accrual3.getAmount() : null;
        DataPaymentHistory accrual4 = input.getAccrual();
        String paymentDate = accrual4 != null ? accrual4.getPaymentDate() : null;
        DataPaymentHistory accrual5 = input.getAccrual();
        DomainPaymentHistory domainPaymentHistory = new DomainPaymentHistory(id, type, paymentDate, amount, accrual5 != null ? accrual5.getState() : null, null, 32, null);
        DataPromisedPayment promisedPayment = input.getPromisedPayment();
        String accrualUuid = promisedPayment != null ? promisedPayment.getAccrualUuid() : null;
        DataPromisedPayment promisedPayment2 = input.getPromisedPayment();
        String activatedAt = promisedPayment2 != null ? promisedPayment2.getActivatedAt() : null;
        DataPromisedPayment promisedPayment3 = input.getPromisedPayment();
        String expiresAt = promisedPayment3 != null ? promisedPayment3.getExpiresAt() : null;
        DataPromisedPayment promisedPayment4 = input.getPromisedPayment();
        PromisePaymentStates state = promisedPayment4 != null ? promisedPayment4.getState() : null;
        DataPromisedPayment promisedPayment5 = input.getPromisedPayment();
        String type2 = promisedPayment5 != null ? promisedPayment5.getType() : null;
        DataPromisedPayment promisedPayment6 = input.getPromisedPayment();
        return new DomainPromisePayment(domainPaymentHistory, new DomainPromisedPayment(accrualUuid, activatedAt, expiresAt, state, type2, promisedPayment6 != null ? promisedPayment6.getUuid() : null));
    }
}

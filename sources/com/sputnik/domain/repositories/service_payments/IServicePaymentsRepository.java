package com.sputnik.domain.repositories.service_payments;

import com.sputnik.domain.common.Resource;
import com.sputnik.domain.entities.service_payments.DomainIntercomPaymentInfo;
import com.sputnik.domain.entities.service_payments.DomainPaymentHistory;
import com.sputnik.domain.entities.service_payments.DomainPaymentItem;
import com.sputnik.domain.entities.service_payments.DomainPaymentReceipt;
import com.sputnik.domain.entities.service_payments.DomainPromisePayment;
import com.sputnik.domain.entities.service_payments.DomainServiceAccountInfo;
import java.util.List;
import kotlin.Metadata;
import kotlinx.coroutines.flow.Flow;

/* compiled from: IServicePaymentsRepository.kt */
@Metadata(d1 = {"\u0000B\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\bf\u0018\u00002\u00020\u0001J\u0014\u0010\u0002\u001a\u000e\u0012\n\u0012\b\u0012\u0004\u0012\u00020\u00050\u00040\u0003H&J\u001c\u0010\u0006\u001a\u000e\u0012\n\u0012\b\u0012\u0004\u0012\u00020\u00070\u00040\u00032\u0006\u0010\b\u001a\u00020\tH&J\u001c\u0010\n\u001a\u000e\u0012\n\u0012\b\u0012\u0004\u0012\u00020\u000b0\u00040\u00032\u0006\u0010\b\u001a\u00020\tH&J\u001a\u0010\f\u001a\u0014\u0012\u0010\u0012\u000e\u0012\n\u0012\b\u0012\u0004\u0012\u00020\u000e0\r0\u00040\u0003H&J&\u0010\u000f\u001a\u000e\u0012\n\u0012\b\u0012\u0004\u0012\u00020\u00100\u00040\u00032\u0006\u0010\b\u001a\u00020\t2\b\u0010\u0011\u001a\u0004\u0018\u00010\tH&J\u001c\u0010\u0012\u001a\u000e\u0012\n\u0012\b\u0012\u0004\u0012\u00020\u00130\u00040\u00032\u0006\u0010\b\u001a\u00020\tH&¨\u0006\u0014"}, d2 = {"Lcom/sputnik/domain/repositories/service_payments/IServicePaymentsRepository;", "", "getAccountInfo", "Lkotlinx/coroutines/flow/Flow;", "Lcom/sputnik/domain/common/Resource;", "Lcom/sputnik/domain/entities/service_payments/DomainServiceAccountInfo;", "getLastPaymentOfAccrual", "Lcom/sputnik/domain/entities/service_payments/DomainPaymentReceipt;", "uuid", "", "getPayment", "Lcom/sputnik/domain/entities/service_payments/DomainPaymentItem;", "getServicePayments", "", "Lcom/sputnik/domain/entities/service_payments/DomainPaymentHistory;", "payIntercom", "Lcom/sputnik/domain/entities/service_payments/DomainIntercomPaymentInfo;", "paymentToken", "promisePayment", "Lcom/sputnik/domain/entities/service_payments/DomainPromisePayment;", "domain"}, k = 1, mv = {1, 9, 0}, xi = 48)
/* loaded from: classes3.dex */
public interface IServicePaymentsRepository {
    Flow<Resource<DomainServiceAccountInfo>> getAccountInfo();

    Flow<Resource<DomainPaymentReceipt>> getLastPaymentOfAccrual(String uuid);

    Flow<Resource<DomainPaymentItem>> getPayment(String uuid);

    Flow<Resource<List<DomainPaymentHistory>>> getServicePayments();

    Flow<Resource<DomainIntercomPaymentInfo>> payIntercom(String uuid, String paymentToken);

    Flow<Resource<DomainPromisePayment>> promisePayment(String uuid);
}

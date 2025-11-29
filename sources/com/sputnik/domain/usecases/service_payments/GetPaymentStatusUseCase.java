package com.sputnik.domain.usecases.service_payments;

import com.sputnik.domain.common.Resource;
import com.sputnik.domain.entities.service_payments.DomainPaymentItem;
import com.sputnik.domain.repositories.service_payments.IServicePaymentsRepository;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import kotlinx.coroutines.flow.Flow;

/* compiled from: GetPaymentStatusUseCase.kt */
@Metadata(d1 = {"\u0000&\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0000\u0018\u00002\u00020\u0001B\r\u0012\u0006\u0010\u0002\u001a\u00020\u0003¢\u0006\u0002\u0010\u0004J\u001d\u0010\u0005\u001a\u000e\u0012\n\u0012\b\u0012\u0004\u0012\u00020\b0\u00070\u00062\u0006\u0010\t\u001a\u00020\nH\u0086\u0002R\u000e\u0010\u0002\u001a\u00020\u0003X\u0082\u0004¢\u0006\u0002\n\u0000¨\u0006\u000b"}, d2 = {"Lcom/sputnik/domain/usecases/service_payments/GetPaymentStatusUseCase;", "", "repository", "Lcom/sputnik/domain/repositories/service_payments/IServicePaymentsRepository;", "(Lcom/sputnik/domain/repositories/service_payments/IServicePaymentsRepository;)V", "invoke", "Lkotlinx/coroutines/flow/Flow;", "Lcom/sputnik/domain/common/Resource;", "Lcom/sputnik/domain/entities/service_payments/DomainPaymentItem;", "uuid", "", "domain"}, k = 1, mv = {1, 9, 0}, xi = 48)
/* loaded from: classes3.dex */
public final class GetPaymentStatusUseCase {
    private final IServicePaymentsRepository repository;

    public GetPaymentStatusUseCase(IServicePaymentsRepository repository) {
        Intrinsics.checkNotNullParameter(repository, "repository");
        this.repository = repository;
    }

    public final Flow<Resource<DomainPaymentItem>> invoke(String uuid) {
        Intrinsics.checkNotNullParameter(uuid, "uuid");
        return this.repository.getPayment(uuid);
    }
}

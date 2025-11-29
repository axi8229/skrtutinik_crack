package com.sputnik.data.repositories.service_payments;

import com.sputnik.data.entities.service_payments.DataPromisePayment;
import com.sputnik.data.mappers.service_payments.DataPromisePaymentToDomainPromisePaymentMapper;
import com.sputnik.domain.entities.service_payments.DomainPromisePayment;
import kotlin.Metadata;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.FunctionReferenceImpl;
import kotlin.jvm.internal.Intrinsics;

/* compiled from: ServicePaymentsRepository.kt */
@Metadata(k = 3, mv = {1, 9, 0}, xi = 48)
/* loaded from: classes3.dex */
/* synthetic */ class ServicePaymentsRepository$promisePayment$2$1 extends FunctionReferenceImpl implements Function1<DataPromisePayment, DomainPromisePayment> {
    ServicePaymentsRepository$promisePayment$2$1(Object obj) {
        super(1, obj, DataPromisePaymentToDomainPromisePaymentMapper.class, "map", "map(Lcom/sputnik/data/entities/service_payments/DataPromisePayment;)Lcom/sputnik/domain/entities/service_payments/DomainPromisePayment;", 0);
    }

    @Override // kotlin.jvm.functions.Function1
    public final DomainPromisePayment invoke(DataPromisePayment p0) {
        Intrinsics.checkNotNullParameter(p0, "p0");
        return ((DataPromisePaymentToDomainPromisePaymentMapper) this.receiver).map(p0);
    }
}

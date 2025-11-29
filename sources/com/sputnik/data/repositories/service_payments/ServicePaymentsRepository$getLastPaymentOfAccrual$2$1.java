package com.sputnik.data.repositories.service_payments;

import com.sputnik.data.entities.payments.DataPaymentReceipt;
import com.sputnik.data.mappers.service_payments.DataPaymentReceiptToDomainPaymentReceiptMapper;
import com.sputnik.domain.entities.service_payments.DomainPaymentReceipt;
import kotlin.Metadata;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.FunctionReferenceImpl;
import kotlin.jvm.internal.Intrinsics;

/* compiled from: ServicePaymentsRepository.kt */
@Metadata(k = 3, mv = {1, 9, 0}, xi = 48)
/* loaded from: classes3.dex */
/* synthetic */ class ServicePaymentsRepository$getLastPaymentOfAccrual$2$1 extends FunctionReferenceImpl implements Function1<DataPaymentReceipt, DomainPaymentReceipt> {
    ServicePaymentsRepository$getLastPaymentOfAccrual$2$1(Object obj) {
        super(1, obj, DataPaymentReceiptToDomainPaymentReceiptMapper.class, "map", "map(Lcom/sputnik/data/entities/payments/DataPaymentReceipt;)Lcom/sputnik/domain/entities/service_payments/DomainPaymentReceipt;", 0);
    }

    @Override // kotlin.jvm.functions.Function1
    public final DomainPaymentReceipt invoke(DataPaymentReceipt p0) {
        Intrinsics.checkNotNullParameter(p0, "p0");
        return ((DataPaymentReceiptToDomainPaymentReceiptMapper) this.receiver).map(p0);
    }
}

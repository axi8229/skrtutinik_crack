package com.sputnik.data.repositories.service_payments;

import com.sputnik.data.entities.service_payments.DataPaymentItem;
import com.sputnik.data.mappers.service_payments.DataPaymentItemToDomainPaymentItemMapper;
import com.sputnik.domain.entities.service_payments.DomainPaymentItem;
import kotlin.Metadata;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.FunctionReferenceImpl;
import kotlin.jvm.internal.Intrinsics;

/* compiled from: ServicePaymentsRepository.kt */
@Metadata(k = 3, mv = {1, 9, 0}, xi = 48)
/* loaded from: classes3.dex */
/* synthetic */ class ServicePaymentsRepository$getPayment$2$1 extends FunctionReferenceImpl implements Function1<DataPaymentItem, DomainPaymentItem> {
    ServicePaymentsRepository$getPayment$2$1(Object obj) {
        super(1, obj, DataPaymentItemToDomainPaymentItemMapper.class, "map", "map(Lcom/sputnik/data/entities/service_payments/DataPaymentItem;)Lcom/sputnik/domain/entities/service_payments/DomainPaymentItem;", 0);
    }

    @Override // kotlin.jvm.functions.Function1
    public final DomainPaymentItem invoke(DataPaymentItem p0) {
        Intrinsics.checkNotNullParameter(p0, "p0");
        return ((DataPaymentItemToDomainPaymentItemMapper) this.receiver).map(p0);
    }
}

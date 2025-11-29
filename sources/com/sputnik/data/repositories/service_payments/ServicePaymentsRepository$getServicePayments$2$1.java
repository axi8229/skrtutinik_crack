package com.sputnik.data.repositories.service_payments;

import com.sputnik.data.entities.service_payments.DataPaymentHistory;
import com.sputnik.domain.common.ListMapper;
import com.sputnik.domain.entities.service_payments.DomainPaymentHistory;
import java.util.List;
import kotlin.Metadata;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.FunctionReferenceImpl;
import kotlin.jvm.internal.Intrinsics;

/* compiled from: ServicePaymentsRepository.kt */
@Metadata(k = 3, mv = {1, 9, 0}, xi = 48)
/* loaded from: classes3.dex */
/* synthetic */ class ServicePaymentsRepository$getServicePayments$2$1 extends FunctionReferenceImpl implements Function1<List<? extends DataPaymentHistory>, List<? extends DomainPaymentHistory>> {
    ServicePaymentsRepository$getServicePayments$2$1(Object obj) {
        super(1, obj, ListMapper.class, "map", "map(Ljava/lang/Object;)Ljava/lang/Object;", 0);
    }

    @Override // kotlin.jvm.functions.Function1
    public /* bridge */ /* synthetic */ List<? extends DomainPaymentHistory> invoke(List<? extends DataPaymentHistory> list) {
        return invoke2((List<DataPaymentHistory>) list);
    }

    /* renamed from: invoke, reason: avoid collision after fix types in other method */
    public final List<DomainPaymentHistory> invoke2(List<DataPaymentHistory> p0) {
        Intrinsics.checkNotNullParameter(p0, "p0");
        return (List) ((ListMapper) this.receiver).map(p0);
    }
}

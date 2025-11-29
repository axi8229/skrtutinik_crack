package com.sputnik.data.repositories.service_payments;

import com.sputnik.data.entities.service_payments.DataIntercomPaymentInfo;
import com.sputnik.data.mappers.service_payments.DataIntercomPaymentInfoToDomainIntercomPaymentInfoMapper;
import com.sputnik.domain.entities.service_payments.DomainIntercomPaymentInfo;
import kotlin.Metadata;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.FunctionReferenceImpl;
import kotlin.jvm.internal.Intrinsics;

/* compiled from: ServicePaymentsRepository.kt */
@Metadata(k = 3, mv = {1, 9, 0}, xi = 48)
/* loaded from: classes3.dex */
/* synthetic */ class ServicePaymentsRepository$payIntercom$2$1 extends FunctionReferenceImpl implements Function1<DataIntercomPaymentInfo, DomainIntercomPaymentInfo> {
    ServicePaymentsRepository$payIntercom$2$1(Object obj) {
        super(1, obj, DataIntercomPaymentInfoToDomainIntercomPaymentInfoMapper.class, "map", "map(Lcom/sputnik/data/entities/service_payments/DataIntercomPaymentInfo;)Lcom/sputnik/domain/entities/service_payments/DomainIntercomPaymentInfo;", 0);
    }

    @Override // kotlin.jvm.functions.Function1
    public final DomainIntercomPaymentInfo invoke(DataIntercomPaymentInfo p0) {
        Intrinsics.checkNotNullParameter(p0, "p0");
        return ((DataIntercomPaymentInfoToDomainIntercomPaymentInfoMapper) this.receiver).map(p0);
    }
}

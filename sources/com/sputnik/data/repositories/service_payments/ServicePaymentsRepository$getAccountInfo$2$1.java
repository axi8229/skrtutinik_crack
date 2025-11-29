package com.sputnik.data.repositories.service_payments;

import com.sputnik.data.entities.service_payments.DataServiceAccountInfo;
import com.sputnik.data.mappers.service_payments.DataServiceAccountInfoToDomainServiceAccountInfoMapper;
import com.sputnik.domain.entities.service_payments.DomainServiceAccountInfo;
import kotlin.Metadata;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.FunctionReferenceImpl;
import kotlin.jvm.internal.Intrinsics;

/* compiled from: ServicePaymentsRepository.kt */
@Metadata(k = 3, mv = {1, 9, 0}, xi = 48)
/* loaded from: classes3.dex */
/* synthetic */ class ServicePaymentsRepository$getAccountInfo$2$1 extends FunctionReferenceImpl implements Function1<DataServiceAccountInfo, DomainServiceAccountInfo> {
    ServicePaymentsRepository$getAccountInfo$2$1(Object obj) {
        super(1, obj, DataServiceAccountInfoToDomainServiceAccountInfoMapper.class, "map", "map(Lcom/sputnik/data/entities/service_payments/DataServiceAccountInfo;)Lcom/sputnik/domain/entities/service_payments/DomainServiceAccountInfo;", 0);
    }

    @Override // kotlin.jvm.functions.Function1
    public final DomainServiceAccountInfo invoke(DataServiceAccountInfo p0) {
        Intrinsics.checkNotNullParameter(p0, "p0");
        return ((DataServiceAccountInfoToDomainServiceAccountInfoMapper) this.receiver).map(p0);
    }
}

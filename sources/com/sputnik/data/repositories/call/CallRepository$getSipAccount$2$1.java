package com.sputnik.data.repositories.call;

import com.sputnik.data.entities.call.DataSipAccount;
import com.sputnik.data.mappers.call.DataSipCallToDomainSipCallMapper;
import com.sputnik.domain.entities.call.DomainSipAccount;
import kotlin.Metadata;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.FunctionReferenceImpl;
import kotlin.jvm.internal.Intrinsics;

/* compiled from: CallRepository.kt */
@Metadata(k = 3, mv = {1, 9, 0}, xi = 48)
/* loaded from: classes3.dex */
/* synthetic */ class CallRepository$getSipAccount$2$1 extends FunctionReferenceImpl implements Function1<DataSipAccount, DomainSipAccount> {
    CallRepository$getSipAccount$2$1(Object obj) {
        super(1, obj, DataSipCallToDomainSipCallMapper.class, "map", "map(Lcom/sputnik/data/entities/call/DataSipAccount;)Lcom/sputnik/domain/entities/call/DomainSipAccount;", 0);
    }

    @Override // kotlin.jvm.functions.Function1
    public final DomainSipAccount invoke(DataSipAccount p0) {
        Intrinsics.checkNotNullParameter(p0, "p0");
        return ((DataSipCallToDomainSipCallMapper) this.receiver).map(p0);
    }
}

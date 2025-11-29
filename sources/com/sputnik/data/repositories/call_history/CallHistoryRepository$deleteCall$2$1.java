package com.sputnik.data.repositories.call_history;

import com.sputnik.data.entities.call.DataCall;
import com.sputnik.data.mappers.call.DataCallToDomainCallMapper;
import com.sputnik.domain.entities.call.DomainCall;
import kotlin.Metadata;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.FunctionReferenceImpl;
import kotlin.jvm.internal.Intrinsics;

/* compiled from: CallHistoryRepository.kt */
@Metadata(k = 3, mv = {1, 9, 0}, xi = 48)
/* loaded from: classes3.dex */
/* synthetic */ class CallHistoryRepository$deleteCall$2$1 extends FunctionReferenceImpl implements Function1<DataCall, DomainCall> {
    CallHistoryRepository$deleteCall$2$1(Object obj) {
        super(1, obj, DataCallToDomainCallMapper.class, "map", "map(Lcom/sputnik/data/entities/call/DataCall;)Lcom/sputnik/domain/entities/call/DomainCall;", 0);
    }

    @Override // kotlin.jvm.functions.Function1
    public final DomainCall invoke(DataCall p0) {
        Intrinsics.checkNotNullParameter(p0, "p0");
        return ((DataCallToDomainCallMapper) this.receiver).map(p0);
    }
}

package com.sputnik.data.repositories.call_history;

import com.sputnik.data.entities.call_history.DataCallHistory;
import com.sputnik.data.mappers.call_history.DataCallHistoryToDomainCallHistoryMapper;
import com.sputnik.domain.entities.call_history.DomainCallHistory;
import kotlin.Metadata;
import kotlin.coroutines.Continuation;
import kotlin.jvm.functions.Function2;
import kotlin.jvm.internal.AdaptedFunctionReference;

/* compiled from: CallHistoryRepository.kt */
@Metadata(k = 3, mv = {1, 9, 0}, xi = 48)
/* loaded from: classes3.dex */
/* synthetic */ class CallHistoryRepository$loadCallHistory$2$1 extends AdaptedFunctionReference implements Function2<DataCallHistory, Continuation<? super DomainCallHistory>, Object> {
    CallHistoryRepository$loadCallHistory$2$1(Object obj) {
        super(2, obj, DataCallHistoryToDomainCallHistoryMapper.class, "map", "map(Lcom/sputnik/data/entities/call_history/DataCallHistory;)Lcom/sputnik/domain/entities/call_history/DomainCallHistory;", 4);
    }

    @Override // kotlin.jvm.functions.Function2
    public final Object invoke(DataCallHistory dataCallHistory, Continuation<? super DomainCallHistory> continuation) {
        return CallHistoryRepository.loadCallHistory$lambda$0$map((DataCallHistoryToDomainCallHistoryMapper) this.receiver, dataCallHistory, continuation);
    }
}

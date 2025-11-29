package sputnik.axmor.com.sputnik.ui.main.cameras.history.viewmodel;

import com.sputnik.domain.entities.call_history.DomainCallHistory;
import kotlin.Metadata;
import kotlin.coroutines.Continuation;
import kotlin.jvm.functions.Function2;
import kotlin.jvm.internal.AdaptedFunctionReference;
import sputnik.axmor.com.sputnik.entities.call_history.CallHistory;
import sputnik.axmor.com.sputnik.mappers.call_history.DomainCallHistoryToCallHistoryMapper;

/* compiled from: CallHistoryViewModel.kt */
@Metadata(k = 3, mv = {1, 9, 0}, xi = 48)
/* loaded from: classes5.dex */
/* synthetic */ class CallHistoryViewModel$callHistory$1$1 extends AdaptedFunctionReference implements Function2<DomainCallHistory, Continuation<? super CallHistory>, Object> {
    CallHistoryViewModel$callHistory$1$1(Object obj) {
        super(2, obj, DomainCallHistoryToCallHistoryMapper.class, "map", "map(Lcom/sputnik/domain/entities/call_history/DomainCallHistory;)Lsputnik/axmor/com/sputnik/entities/call_history/CallHistory;", 4);
    }

    @Override // kotlin.jvm.functions.Function2
    public final Object invoke(DomainCallHistory domainCallHistory, Continuation<? super CallHistory> continuation) {
        return CallHistoryViewModel.callHistory$lambda$0$map((DomainCallHistoryToCallHistoryMapper) this.receiver, domainCallHistory, continuation);
    }
}

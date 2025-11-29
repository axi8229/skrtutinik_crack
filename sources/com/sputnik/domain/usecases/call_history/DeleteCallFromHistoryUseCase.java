package com.sputnik.domain.usecases.call_history;

import com.huawei.hms.api.FailedBinderCallBack;
import com.sputnik.domain.common.Resource;
import com.sputnik.domain.entities.call.DomainCall;
import com.sputnik.domain.repositories.call_history.ICallHistoryRepository;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import kotlinx.coroutines.flow.Flow;

/* compiled from: DeleteCallFromHistoryUseCase.kt */
@Metadata(d1 = {"\u0000(\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0000\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0000\u0018\u0000*\u0004\b\u0000\u0010\u00012\u00020\u0002B\u0013\u0012\f\u0010\u0003\u001a\b\u0012\u0004\u0012\u00028\u00000\u0004¢\u0006\u0002\u0010\u0005J\u001d\u0010\u0006\u001a\u000e\u0012\n\u0012\b\u0012\u0004\u0012\u00020\t0\b0\u00072\u0006\u0010\n\u001a\u00020\u000bH\u0086\u0002R\u0014\u0010\u0003\u001a\b\u0012\u0004\u0012\u00028\u00000\u0004X\u0082\u0004¢\u0006\u0002\n\u0000¨\u0006\f"}, d2 = {"Lcom/sputnik/domain/usecases/call_history/DeleteCallFromHistoryUseCase;", "T", "", "repository", "Lcom/sputnik/domain/repositories/call_history/ICallHistoryRepository;", "(Lcom/sputnik/domain/repositories/call_history/ICallHistoryRepository;)V", "invoke", "Lkotlinx/coroutines/flow/Flow;", "Lcom/sputnik/domain/common/Resource;", "Lcom/sputnik/domain/entities/call/DomainCall;", FailedBinderCallBack.CALLER_ID, "", "domain"}, k = 1, mv = {1, 9, 0}, xi = 48)
/* loaded from: classes3.dex */
public final class DeleteCallFromHistoryUseCase<T> {
    private final ICallHistoryRepository<T> repository;

    public DeleteCallFromHistoryUseCase(ICallHistoryRepository<T> repository) {
        Intrinsics.checkNotNullParameter(repository, "repository");
        this.repository = repository;
    }

    public final Flow<Resource<DomainCall>> invoke(String callId) {
        Intrinsics.checkNotNullParameter(callId, "callId");
        return this.repository.deleteCall(callId);
    }
}

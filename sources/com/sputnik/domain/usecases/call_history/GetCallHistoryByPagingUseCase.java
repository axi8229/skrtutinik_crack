package com.sputnik.domain.usecases.call_history;

import com.sputnik.domain.repositories.call_history.ICallHistoryRepository;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import kotlinx.coroutines.flow.Flow;

/* compiled from: GetCallHistoryByPagingUseCase.kt */
@Metadata(d1 = {"\u0000\u001a\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0000\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\u0018\u0000*\u0004\b\u0000\u0010\u00012\u00020\u0002B\u0013\u0012\f\u0010\u0003\u001a\b\u0012\u0004\u0012\u00028\u00000\u0004¢\u0006\u0002\u0010\u0005J\u000f\u0010\u0006\u001a\b\u0012\u0004\u0012\u00028\u00000\u0007H\u0086\u0002R\u0014\u0010\u0003\u001a\b\u0012\u0004\u0012\u00028\u00000\u0004X\u0082\u0004¢\u0006\u0002\n\u0000¨\u0006\b"}, d2 = {"Lcom/sputnik/domain/usecases/call_history/GetCallHistoryByPagingUseCase;", "T", "", "repository", "Lcom/sputnik/domain/repositories/call_history/ICallHistoryRepository;", "(Lcom/sputnik/domain/repositories/call_history/ICallHistoryRepository;)V", "invoke", "Lkotlinx/coroutines/flow/Flow;", "domain"}, k = 1, mv = {1, 9, 0}, xi = 48)
/* loaded from: classes3.dex */
public final class GetCallHistoryByPagingUseCase<T> {
    private final ICallHistoryRepository<T> repository;

    public GetCallHistoryByPagingUseCase(ICallHistoryRepository<T> repository) {
        Intrinsics.checkNotNullParameter(repository, "repository");
        this.repository = repository;
    }

    public final Flow<T> invoke() {
        return this.repository.loadCallHistory();
    }
}

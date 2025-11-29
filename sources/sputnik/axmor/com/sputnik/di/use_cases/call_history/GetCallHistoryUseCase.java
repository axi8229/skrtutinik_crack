package sputnik.axmor.com.sputnik.di.use_cases.call_history;

import androidx.paging.PagingData;
import com.sputnik.domain.entities.call_history.DomainCallHistory;
import com.sputnik.domain.repositories.call_history.ICallHistoryRepository;
import com.sputnik.domain.usecases.call_history.GetCallHistoryByPagingUseCase;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import kotlinx.coroutines.flow.Flow;

/* compiled from: GetCallHistoryUseCase.kt */
@Metadata(d1 = {"\u0000&\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\u0018\u00002\u00020\u0001B\u0019\u0012\u0012\u0010\u0002\u001a\u000e\u0012\n\u0012\b\u0012\u0004\u0012\u00020\u00050\u00040\u0003¢\u0006\u0002\u0010\u0006J\u0015\u0010\t\u001a\u000e\u0012\n\u0012\b\u0012\u0004\u0012\u00020\u00050\u00040\nH\u0086\u0002R\u001a\u0010\u0007\u001a\u000e\u0012\n\u0012\b\u0012\u0004\u0012\u00020\u00050\u00040\bX\u0082\u0004¢\u0006\u0002\n\u0000¨\u0006\u000b"}, d2 = {"Lsputnik/axmor/com/sputnik/di/use_cases/call_history/GetCallHistoryUseCase;", "", "repository", "Lcom/sputnik/domain/repositories/call_history/ICallHistoryRepository;", "Landroidx/paging/PagingData;", "Lcom/sputnik/domain/entities/call_history/DomainCallHistory;", "(Lcom/sputnik/domain/repositories/call_history/ICallHistoryRepository;)V", "useCase", "Lcom/sputnik/domain/usecases/call_history/GetCallHistoryByPagingUseCase;", "invoke", "Lkotlinx/coroutines/flow/Flow;", "app_huaweiRelease"}, k = 1, mv = {1, 9, 0}, xi = 48)
/* loaded from: classes5.dex */
public final class GetCallHistoryUseCase {
    private final GetCallHistoryByPagingUseCase<PagingData<DomainCallHistory>> useCase;

    public GetCallHistoryUseCase(ICallHistoryRepository<PagingData<DomainCallHistory>> repository) {
        Intrinsics.checkNotNullParameter(repository, "repository");
        this.useCase = new GetCallHistoryByPagingUseCase<>(repository);
    }

    public final Flow<PagingData<DomainCallHistory>> invoke() {
        return this.useCase.invoke();
    }
}

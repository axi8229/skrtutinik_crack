package sputnik.axmor.com.sputnik.di.use_cases.call_history;

import androidx.paging.PagingData;
import com.sputnik.domain.entities.call_history.DomainCallHistory;
import com.sputnik.domain.repositories.call_history.ICallHistoryRepository;
import dagger.internal.Factory;
import dagger.internal.Preconditions;

/* loaded from: classes5.dex */
public final class CallHistoryUseCaseModule_ProvideGetCallHistoryByPagingUseCaseFactory implements Factory<GetCallHistoryUseCase> {
    public static GetCallHistoryUseCase provideGetCallHistoryByPagingUseCase(CallHistoryUseCaseModule callHistoryUseCaseModule, ICallHistoryRepository<PagingData<DomainCallHistory>> iCallHistoryRepository) {
        return (GetCallHistoryUseCase) Preconditions.checkNotNullFromProvides(callHistoryUseCaseModule.provideGetCallHistoryByPagingUseCase(iCallHistoryRepository));
    }
}

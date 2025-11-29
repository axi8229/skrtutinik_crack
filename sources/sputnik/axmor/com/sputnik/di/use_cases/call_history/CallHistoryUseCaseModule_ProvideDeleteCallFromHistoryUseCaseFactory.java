package sputnik.axmor.com.sputnik.di.use_cases.call_history;

import androidx.paging.PagingData;
import com.sputnik.domain.entities.call_history.DomainCallHistory;
import com.sputnik.domain.repositories.call_history.ICallHistoryRepository;
import dagger.internal.Factory;
import dagger.internal.Preconditions;

/* loaded from: classes5.dex */
public final class CallHistoryUseCaseModule_ProvideDeleteCallFromHistoryUseCaseFactory implements Factory<DeleteCallHistoryUseCase> {
    public static DeleteCallHistoryUseCase provideDeleteCallFromHistoryUseCase(CallHistoryUseCaseModule callHistoryUseCaseModule, ICallHistoryRepository<PagingData<DomainCallHistory>> iCallHistoryRepository) {
        return (DeleteCallHistoryUseCase) Preconditions.checkNotNullFromProvides(callHistoryUseCaseModule.provideDeleteCallFromHistoryUseCase(iCallHistoryRepository));
    }
}

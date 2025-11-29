package sputnik.axmor.com.sputnik.di.use_cases.call_history;

import androidx.paging.PagingData;
import com.sputnik.domain.entities.call_history.DomainCallHistory;
import com.sputnik.domain.repositories.call_history.ICallHistoryRepository;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

/* compiled from: CallHistoryUseCaseModule.kt */
@Metadata(d1 = {"\u0000&\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\b\u0007\u0018\u00002\u00020\u0001B\u0005¢\u0006\u0002\u0010\u0002J\u001c\u0010\u0003\u001a\u00020\u00042\u0012\u0010\u0005\u001a\u000e\u0012\n\u0012\b\u0012\u0004\u0012\u00020\b0\u00070\u0006H\u0007J\u001c\u0010\t\u001a\u00020\n2\u0012\u0010\u0005\u001a\u000e\u0012\n\u0012\b\u0012\u0004\u0012\u00020\b0\u00070\u0006H\u0007¨\u0006\u000b"}, d2 = {"Lsputnik/axmor/com/sputnik/di/use_cases/call_history/CallHistoryUseCaseModule;", "", "()V", "provideDeleteCallFromHistoryUseCase", "Lsputnik/axmor/com/sputnik/di/use_cases/call_history/DeleteCallHistoryUseCase;", "repository", "Lcom/sputnik/domain/repositories/call_history/ICallHistoryRepository;", "Landroidx/paging/PagingData;", "Lcom/sputnik/domain/entities/call_history/DomainCallHistory;", "provideGetCallHistoryByPagingUseCase", "Lsputnik/axmor/com/sputnik/di/use_cases/call_history/GetCallHistoryUseCase;", "app_huaweiRelease"}, k = 1, mv = {1, 9, 0}, xi = 48)
/* loaded from: classes5.dex */
public final class CallHistoryUseCaseModule {
    public final DeleteCallHistoryUseCase provideDeleteCallFromHistoryUseCase(ICallHistoryRepository<PagingData<DomainCallHistory>> repository) {
        Intrinsics.checkNotNullParameter(repository, "repository");
        return new DeleteCallHistoryUseCase(repository);
    }

    public final GetCallHistoryUseCase provideGetCallHistoryByPagingUseCase(ICallHistoryRepository<PagingData<DomainCallHistory>> repository) {
        Intrinsics.checkNotNullParameter(repository, "repository");
        return new GetCallHistoryUseCase(repository);
    }
}

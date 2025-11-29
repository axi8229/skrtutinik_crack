package sputnik.axmor.com.sputnik.di.use_cases.event;

import com.sputnik.domain.repositories.event.IEventRepository;
import com.sputnik.domain.usecases.issues.ReportIssueUseCase;
import dagger.internal.Factory;
import dagger.internal.Preconditions;

/* loaded from: classes5.dex */
public final class EventUseCaseModule_ProvideCreateIssueUseCaseFactory implements Factory<ReportIssueUseCase> {
    public static ReportIssueUseCase provideCreateIssueUseCase(EventUseCaseModule eventUseCaseModule, IEventRepository iEventRepository) {
        return (ReportIssueUseCase) Preconditions.checkNotNullFromProvides(eventUseCaseModule.provideCreateIssueUseCase(iEventRepository));
    }
}

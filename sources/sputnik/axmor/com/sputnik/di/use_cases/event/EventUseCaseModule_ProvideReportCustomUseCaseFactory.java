package sputnik.axmor.com.sputnik.di.use_cases.event;

import com.sputnik.domain.repositories.event.IEventRepository;
import com.sputnik.domain.usecases.event.ReportCustomUseCase;
import dagger.internal.Factory;
import dagger.internal.Preconditions;

/* loaded from: classes5.dex */
public final class EventUseCaseModule_ProvideReportCustomUseCaseFactory implements Factory<ReportCustomUseCase> {
    public static ReportCustomUseCase provideReportCustomUseCase(EventUseCaseModule eventUseCaseModule, IEventRepository iEventRepository) {
        return (ReportCustomUseCase) Preconditions.checkNotNullFromProvides(eventUseCaseModule.provideReportCustomUseCase(iEventRepository));
    }
}

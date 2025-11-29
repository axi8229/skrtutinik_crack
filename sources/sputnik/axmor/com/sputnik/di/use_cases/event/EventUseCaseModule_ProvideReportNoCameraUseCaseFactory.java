package sputnik.axmor.com.sputnik.di.use_cases.event;

import com.sputnik.domain.repositories.event.IEventRepository;
import com.sputnik.domain.usecases.event.ReportNoCameraUseCase;
import dagger.internal.Factory;
import dagger.internal.Preconditions;

/* loaded from: classes5.dex */
public final class EventUseCaseModule_ProvideReportNoCameraUseCaseFactory implements Factory<ReportNoCameraUseCase> {
    public static ReportNoCameraUseCase provideReportNoCameraUseCase(EventUseCaseModule eventUseCaseModule, IEventRepository iEventRepository) {
        return (ReportNoCameraUseCase) Preconditions.checkNotNullFromProvides(eventUseCaseModule.provideReportNoCameraUseCase(iEventRepository));
    }
}

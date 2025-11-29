package sputnik.axmor.com.sputnik.di.use_cases.event;

import com.sputnik.domain.repositories.event.IEventRepository;
import com.sputnik.domain.usecases.event.ReportFlatInsuranceUseCase;
import dagger.internal.Factory;
import dagger.internal.Preconditions;

/* loaded from: classes5.dex */
public final class EventUseCaseModule_ProvideReportFlatInsuranceUseCaseFactory implements Factory<ReportFlatInsuranceUseCase> {
    public static ReportFlatInsuranceUseCase provideReportFlatInsuranceUseCase(EventUseCaseModule eventUseCaseModule, IEventRepository iEventRepository) {
        return (ReportFlatInsuranceUseCase) Preconditions.checkNotNullFromProvides(eventUseCaseModule.provideReportFlatInsuranceUseCase(iEventRepository));
    }
}

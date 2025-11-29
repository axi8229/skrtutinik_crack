package sputnik.axmor.com.sputnik.di.use_cases.event;

import com.sputnik.domain.repositories.event.IEventRepository;
import com.sputnik.domain.usecases.event.ReportCustomUseCase;
import com.sputnik.domain.usecases.event.ReportFlatInsuranceUseCase;
import com.sputnik.domain.usecases.event.ReportNoCameraUseCase;
import com.sputnik.domain.usecases.issues.ReportIssueUseCase;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

/* compiled from: EventUseCaseModule.kt */
@Metadata(d1 = {"\u0000*\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\b\u0007\u0018\u00002\u00020\u0001B\u0005¢\u0006\u0002\u0010\u0002J\u0010\u0010\u0003\u001a\u00020\u00042\u0006\u0010\u0005\u001a\u00020\u0006H\u0007J\u0010\u0010\u0007\u001a\u00020\b2\u0006\u0010\u0005\u001a\u00020\u0006H\u0007J\u0010\u0010\t\u001a\u00020\n2\u0006\u0010\u0005\u001a\u00020\u0006H\u0007J\u0010\u0010\u000b\u001a\u00020\f2\u0006\u0010\u0005\u001a\u00020\u0006H\u0007¨\u0006\r"}, d2 = {"Lsputnik/axmor/com/sputnik/di/use_cases/event/EventUseCaseModule;", "", "()V", "provideCreateIssueUseCase", "Lcom/sputnik/domain/usecases/issues/ReportIssueUseCase;", "repository", "Lcom/sputnik/domain/repositories/event/IEventRepository;", "provideReportCustomUseCase", "Lcom/sputnik/domain/usecases/event/ReportCustomUseCase;", "provideReportFlatInsuranceUseCase", "Lcom/sputnik/domain/usecases/event/ReportFlatInsuranceUseCase;", "provideReportNoCameraUseCase", "Lcom/sputnik/domain/usecases/event/ReportNoCameraUseCase;", "app_huaweiRelease"}, k = 1, mv = {1, 9, 0}, xi = 48)
/* loaded from: classes5.dex */
public final class EventUseCaseModule {
    public final ReportCustomUseCase provideReportCustomUseCase(IEventRepository repository) {
        Intrinsics.checkNotNullParameter(repository, "repository");
        return new ReportCustomUseCase(repository);
    }

    public final ReportFlatInsuranceUseCase provideReportFlatInsuranceUseCase(IEventRepository repository) {
        Intrinsics.checkNotNullParameter(repository, "repository");
        return new ReportFlatInsuranceUseCase(repository);
    }

    public final ReportNoCameraUseCase provideReportNoCameraUseCase(IEventRepository repository) {
        Intrinsics.checkNotNullParameter(repository, "repository");
        return new ReportNoCameraUseCase(repository);
    }

    public final ReportIssueUseCase provideCreateIssueUseCase(IEventRepository repository) {
        Intrinsics.checkNotNullParameter(repository, "repository");
        return new ReportIssueUseCase(repository);
    }
}

package sputnik.axmor.com.sputnik.di.use_cases.single_use_cases;

import com.sputnik.domain.repositories.archive.IArchiveRepository;
import com.sputnik.domain.usecases.archive.GetArchiveSdkUrlUseCase;
import dagger.internal.Factory;
import dagger.internal.Preconditions;

/* loaded from: classes5.dex */
public final class SingleUseCaseModule_ProvideGetArchiveSdkUrlUseCaseFactory implements Factory<GetArchiveSdkUrlUseCase> {
    public static GetArchiveSdkUrlUseCase provideGetArchiveSdkUrlUseCase(SingleUseCaseModule singleUseCaseModule, IArchiveRepository iArchiveRepository) {
        return (GetArchiveSdkUrlUseCase) Preconditions.checkNotNullFromProvides(singleUseCaseModule.provideGetArchiveSdkUrlUseCase(iArchiveRepository));
    }
}

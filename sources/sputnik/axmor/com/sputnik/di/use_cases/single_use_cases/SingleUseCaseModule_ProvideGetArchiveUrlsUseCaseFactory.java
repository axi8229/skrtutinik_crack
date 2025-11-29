package sputnik.axmor.com.sputnik.di.use_cases.single_use_cases;

import com.sputnik.domain.repositories.archive.IArchiveRepository;
import com.sputnik.domain.usecases.archive.GetArchiveUrlsUseCase;
import dagger.internal.Factory;
import dagger.internal.Preconditions;

/* loaded from: classes5.dex */
public final class SingleUseCaseModule_ProvideGetArchiveUrlsUseCaseFactory implements Factory<GetArchiveUrlsUseCase> {
    public static GetArchiveUrlsUseCase provideGetArchiveUrlsUseCase(SingleUseCaseModule singleUseCaseModule, IArchiveRepository iArchiveRepository) {
        return (GetArchiveUrlsUseCase) Preconditions.checkNotNullFromProvides(singleUseCaseModule.provideGetArchiveUrlsUseCase(iArchiveRepository));
    }
}

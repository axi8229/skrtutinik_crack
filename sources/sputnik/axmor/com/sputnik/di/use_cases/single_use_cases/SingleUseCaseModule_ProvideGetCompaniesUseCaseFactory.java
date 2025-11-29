package sputnik.axmor.com.sputnik.di.use_cases.single_use_cases;

import com.sputnik.domain.repositories.help.IHelpRepository;
import com.sputnik.domain.usecases.help.GetCompaniesUseCase;
import dagger.internal.Factory;
import dagger.internal.Preconditions;

/* loaded from: classes5.dex */
public final class SingleUseCaseModule_ProvideGetCompaniesUseCaseFactory implements Factory<GetCompaniesUseCase> {
    public static GetCompaniesUseCase provideGetCompaniesUseCase(SingleUseCaseModule singleUseCaseModule, IHelpRepository iHelpRepository) {
        return (GetCompaniesUseCase) Preconditions.checkNotNullFromProvides(singleUseCaseModule.provideGetCompaniesUseCase(iHelpRepository));
    }
}

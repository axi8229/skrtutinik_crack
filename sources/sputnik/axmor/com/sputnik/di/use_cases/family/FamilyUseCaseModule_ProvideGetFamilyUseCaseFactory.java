package sputnik.axmor.com.sputnik.di.use_cases.family;

import com.sputnik.domain.repositories.family.IFamilyRepository;
import com.sputnik.domain.usecases.family.GetFamilyUseCase;
import dagger.internal.Factory;
import dagger.internal.Preconditions;

/* loaded from: classes5.dex */
public final class FamilyUseCaseModule_ProvideGetFamilyUseCaseFactory implements Factory<GetFamilyUseCase> {
    public static GetFamilyUseCase provideGetFamilyUseCase(FamilyUseCaseModule familyUseCaseModule, IFamilyRepository iFamilyRepository) {
        return (GetFamilyUseCase) Preconditions.checkNotNullFromProvides(familyUseCaseModule.provideGetFamilyUseCase(iFamilyRepository));
    }
}

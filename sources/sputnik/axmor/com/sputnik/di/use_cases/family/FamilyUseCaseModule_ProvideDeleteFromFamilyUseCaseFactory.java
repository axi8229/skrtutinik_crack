package sputnik.axmor.com.sputnik.di.use_cases.family;

import com.sputnik.domain.repositories.family.IFamilyRepository;
import com.sputnik.domain.usecases.family.DeleteFromFamilyUseCase;
import dagger.internal.Factory;
import dagger.internal.Preconditions;

/* loaded from: classes5.dex */
public final class FamilyUseCaseModule_ProvideDeleteFromFamilyUseCaseFactory implements Factory<DeleteFromFamilyUseCase> {
    public static DeleteFromFamilyUseCase provideDeleteFromFamilyUseCase(FamilyUseCaseModule familyUseCaseModule, IFamilyRepository iFamilyRepository) {
        return (DeleteFromFamilyUseCase) Preconditions.checkNotNullFromProvides(familyUseCaseModule.provideDeleteFromFamilyUseCase(iFamilyRepository));
    }
}

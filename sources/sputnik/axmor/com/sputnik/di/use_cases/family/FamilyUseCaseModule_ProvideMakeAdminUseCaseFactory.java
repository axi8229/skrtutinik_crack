package sputnik.axmor.com.sputnik.di.use_cases.family;

import com.sputnik.domain.repositories.family.IFamilyRepository;
import com.sputnik.domain.usecases.family.MakeAdminUseCase;
import dagger.internal.Factory;
import dagger.internal.Preconditions;

/* loaded from: classes5.dex */
public final class FamilyUseCaseModule_ProvideMakeAdminUseCaseFactory implements Factory<MakeAdminUseCase> {
    public static MakeAdminUseCase provideMakeAdminUseCase(FamilyUseCaseModule familyUseCaseModule, IFamilyRepository iFamilyRepository) {
        return (MakeAdminUseCase) Preconditions.checkNotNullFromProvides(familyUseCaseModule.provideMakeAdminUseCase(iFamilyRepository));
    }
}

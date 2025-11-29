package com.sputnik.common.di.use_cases.profile;

import com.sputnik.domain.repositories.profile.IProfileRepository;
import com.sputnik.domain.usecases.profile.ResetAddressUseCase;
import dagger.internal.Factory;
import dagger.internal.Preconditions;

/* loaded from: classes3.dex */
public final class ProfileUseCaseModule_ProvideResetAddressUseCaseFactory implements Factory<ResetAddressUseCase> {
    public static ResetAddressUseCase provideResetAddressUseCase(ProfileUseCaseModule profileUseCaseModule, IProfileRepository iProfileRepository) {
        return (ResetAddressUseCase) Preconditions.checkNotNullFromProvides(profileUseCaseModule.provideResetAddressUseCase(iProfileRepository));
    }
}

package com.sputnik.common.di.use_cases.support;

import com.sputnik.domain.repositories.support.ISupportRepository;
import com.sputnik.domain.usecases.support.GetAnnounceUseCase;
import dagger.internal.Factory;
import dagger.internal.Preconditions;

/* loaded from: classes3.dex */
public final class SupportUseCaseModule_ProvideGetAnnounceUseCaseFactory implements Factory<GetAnnounceUseCase> {
    public static GetAnnounceUseCase provideGetAnnounceUseCase(SupportUseCaseModule supportUseCaseModule, ISupportRepository iSupportRepository) {
        return (GetAnnounceUseCase) Preconditions.checkNotNullFromProvides(supportUseCaseModule.provideGetAnnounceUseCase(iSupportRepository));
    }
}

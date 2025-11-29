package com.sputnik.common.di.use_cases.support;

import com.sputnik.domain.repositories.support.ISupportRepository;
import com.sputnik.domain.usecases.support.GetFaqUseCase;
import dagger.internal.Factory;
import dagger.internal.Preconditions;

/* loaded from: classes3.dex */
public final class SupportUseCaseModule_ProvideGetFaqUseCaseFactory implements Factory<GetFaqUseCase> {
    public static GetFaqUseCase provideGetFaqUseCase(SupportUseCaseModule supportUseCaseModule, ISupportRepository iSupportRepository) {
        return (GetFaqUseCase) Preconditions.checkNotNullFromProvides(supportUseCaseModule.provideGetFaqUseCase(iSupportRepository));
    }
}

package com.sputnik.common.di.use_cases.support;

import com.sputnik.domain.repositories.support.ISupportRepository;
import com.sputnik.domain.usecases.support.GetFaq2UseCase;
import dagger.internal.Factory;
import dagger.internal.Preconditions;

/* loaded from: classes3.dex */
public final class SupportUseCaseModule_ProvideGetFaq2UseCaseFactory implements Factory<GetFaq2UseCase> {
    public static GetFaq2UseCase provideGetFaq2UseCase(SupportUseCaseModule supportUseCaseModule, ISupportRepository iSupportRepository) {
        return (GetFaq2UseCase) Preconditions.checkNotNullFromProvides(supportUseCaseModule.provideGetFaq2UseCase(iSupportRepository));
    }
}

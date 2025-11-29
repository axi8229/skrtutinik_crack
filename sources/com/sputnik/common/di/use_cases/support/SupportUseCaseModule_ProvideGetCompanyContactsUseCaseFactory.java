package com.sputnik.common.di.use_cases.support;

import com.sputnik.domain.repositories.support.ISupportRepository;
import com.sputnik.domain.usecases.support.GetCompanyContactsUseCase;
import dagger.internal.Factory;
import dagger.internal.Preconditions;

/* loaded from: classes3.dex */
public final class SupportUseCaseModule_ProvideGetCompanyContactsUseCaseFactory implements Factory<GetCompanyContactsUseCase> {
    public static GetCompanyContactsUseCase provideGetCompanyContactsUseCase(SupportUseCaseModule supportUseCaseModule, ISupportRepository iSupportRepository) {
        return (GetCompanyContactsUseCase) Preconditions.checkNotNullFromProvides(supportUseCaseModule.provideGetCompanyContactsUseCase(iSupportRepository));
    }
}

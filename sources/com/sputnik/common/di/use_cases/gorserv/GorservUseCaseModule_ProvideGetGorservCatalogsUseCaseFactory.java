package com.sputnik.common.di.use_cases.gorserv;

import com.sputnik.domain.repositories.gorserv.IGorservRepository;
import com.sputnik.domain.usecases.gorserv.GetGorservCatalogsUseCase;
import dagger.internal.Factory;
import dagger.internal.Preconditions;

/* loaded from: classes3.dex */
public final class GorservUseCaseModule_ProvideGetGorservCatalogsUseCaseFactory implements Factory<GetGorservCatalogsUseCase> {
    public static GetGorservCatalogsUseCase provideGetGorservCatalogsUseCase(GorservUseCaseModule gorservUseCaseModule, IGorservRepository iGorservRepository) {
        return (GetGorservCatalogsUseCase) Preconditions.checkNotNullFromProvides(gorservUseCaseModule.provideGetGorservCatalogsUseCase(iGorservRepository));
    }
}

package com.sputnik.common.di.use_cases.cameras;

import com.sputnik.domain.repositories.cameras.ICamerasRepository;
import com.sputnik.domain.usecases.cameras.GetAllCamerasUseCase;
import dagger.internal.Factory;
import dagger.internal.Preconditions;
import javax.inject.Provider;

/* loaded from: classes3.dex */
public final class CamerasUseCaseModule_ProvideGetAllCamerasUseCaseFactory implements Factory<GetAllCamerasUseCase> {
    private final CamerasUseCaseModule module;
    private final Provider<ICamerasRepository> repositoryProvider;

    public CamerasUseCaseModule_ProvideGetAllCamerasUseCaseFactory(CamerasUseCaseModule camerasUseCaseModule, Provider<ICamerasRepository> provider) {
        this.module = camerasUseCaseModule;
        this.repositoryProvider = provider;
    }

    @Override // javax.inject.Provider
    public GetAllCamerasUseCase get() {
        return provideGetAllCamerasUseCase(this.module, this.repositoryProvider.get());
    }

    public static CamerasUseCaseModule_ProvideGetAllCamerasUseCaseFactory create(CamerasUseCaseModule camerasUseCaseModule, Provider<ICamerasRepository> provider) {
        return new CamerasUseCaseModule_ProvideGetAllCamerasUseCaseFactory(camerasUseCaseModule, provider);
    }

    public static GetAllCamerasUseCase provideGetAllCamerasUseCase(CamerasUseCaseModule camerasUseCaseModule, ICamerasRepository iCamerasRepository) {
        return (GetAllCamerasUseCase) Preconditions.checkNotNullFromProvides(camerasUseCaseModule.provideGetAllCamerasUseCase(iCamerasRepository));
    }
}

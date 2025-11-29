package com.sputnik.common.di.use_cases.cameras;

import com.sputnik.domain.repositories.cameras.ICamerasRepository;
import com.sputnik.domain.usecases.cameras.GetCamerasDemoUseCase;
import dagger.internal.Factory;
import dagger.internal.Preconditions;
import javax.inject.Provider;

/* loaded from: classes3.dex */
public final class CamerasUseCaseModule_ProvideGetCamerasDemoUseCaseFactory implements Factory<GetCamerasDemoUseCase> {
    private final CamerasUseCaseModule module;
    private final Provider<ICamerasRepository> repositoryProvider;

    public CamerasUseCaseModule_ProvideGetCamerasDemoUseCaseFactory(CamerasUseCaseModule camerasUseCaseModule, Provider<ICamerasRepository> provider) {
        this.module = camerasUseCaseModule;
        this.repositoryProvider = provider;
    }

    @Override // javax.inject.Provider
    public GetCamerasDemoUseCase get() {
        return provideGetCamerasDemoUseCase(this.module, this.repositoryProvider.get());
    }

    public static CamerasUseCaseModule_ProvideGetCamerasDemoUseCaseFactory create(CamerasUseCaseModule camerasUseCaseModule, Provider<ICamerasRepository> provider) {
        return new CamerasUseCaseModule_ProvideGetCamerasDemoUseCaseFactory(camerasUseCaseModule, provider);
    }

    public static GetCamerasDemoUseCase provideGetCamerasDemoUseCase(CamerasUseCaseModule camerasUseCaseModule, ICamerasRepository iCamerasRepository) {
        return (GetCamerasDemoUseCase) Preconditions.checkNotNullFromProvides(camerasUseCaseModule.provideGetCamerasDemoUseCase(iCamerasRepository));
    }
}

package com.sputnik.common.di.use_cases.cameras;

import com.sputnik.domain.repositories.cameras.ICamerasRepository;
import com.sputnik.domain.usecases.cameras.OpenDoorUseCase;
import dagger.internal.Factory;
import dagger.internal.Preconditions;
import javax.inject.Provider;

/* loaded from: classes3.dex */
public final class CamerasUseCaseModule_ProvideOpenDoorUseCaseFactory implements Factory<OpenDoorUseCase> {
    private final CamerasUseCaseModule module;
    private final Provider<ICamerasRepository> repositoryProvider;

    public CamerasUseCaseModule_ProvideOpenDoorUseCaseFactory(CamerasUseCaseModule camerasUseCaseModule, Provider<ICamerasRepository> provider) {
        this.module = camerasUseCaseModule;
        this.repositoryProvider = provider;
    }

    @Override // javax.inject.Provider
    public OpenDoorUseCase get() {
        return provideOpenDoorUseCase(this.module, this.repositoryProvider.get());
    }

    public static CamerasUseCaseModule_ProvideOpenDoorUseCaseFactory create(CamerasUseCaseModule camerasUseCaseModule, Provider<ICamerasRepository> provider) {
        return new CamerasUseCaseModule_ProvideOpenDoorUseCaseFactory(camerasUseCaseModule, provider);
    }

    public static OpenDoorUseCase provideOpenDoorUseCase(CamerasUseCaseModule camerasUseCaseModule, ICamerasRepository iCamerasRepository) {
        return (OpenDoorUseCase) Preconditions.checkNotNullFromProvides(camerasUseCaseModule.provideOpenDoorUseCase(iCamerasRepository));
    }
}

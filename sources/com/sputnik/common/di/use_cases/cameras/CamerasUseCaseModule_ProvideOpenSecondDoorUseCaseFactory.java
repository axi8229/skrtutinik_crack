package com.sputnik.common.di.use_cases.cameras;

import com.sputnik.domain.repositories.cameras.ICamerasRepository;
import com.sputnik.domain.usecases.cameras.OpenSecondDoorUseCase;
import dagger.internal.Factory;
import dagger.internal.Preconditions;
import javax.inject.Provider;

/* loaded from: classes3.dex */
public final class CamerasUseCaseModule_ProvideOpenSecondDoorUseCaseFactory implements Factory<OpenSecondDoorUseCase> {
    private final CamerasUseCaseModule module;
    private final Provider<ICamerasRepository> repositoryProvider;

    public CamerasUseCaseModule_ProvideOpenSecondDoorUseCaseFactory(CamerasUseCaseModule camerasUseCaseModule, Provider<ICamerasRepository> provider) {
        this.module = camerasUseCaseModule;
        this.repositoryProvider = provider;
    }

    @Override // javax.inject.Provider
    public OpenSecondDoorUseCase get() {
        return provideOpenSecondDoorUseCase(this.module, this.repositoryProvider.get());
    }

    public static CamerasUseCaseModule_ProvideOpenSecondDoorUseCaseFactory create(CamerasUseCaseModule camerasUseCaseModule, Provider<ICamerasRepository> provider) {
        return new CamerasUseCaseModule_ProvideOpenSecondDoorUseCaseFactory(camerasUseCaseModule, provider);
    }

    public static OpenSecondDoorUseCase provideOpenSecondDoorUseCase(CamerasUseCaseModule camerasUseCaseModule, ICamerasRepository iCamerasRepository) {
        return (OpenSecondDoorUseCase) Preconditions.checkNotNullFromProvides(camerasUseCaseModule.provideOpenSecondDoorUseCase(iCamerasRepository));
    }
}

package com.sputnik.common.di.use_cases.keys;

import com.sputnik.domain.repositories.keys.IPhysicalKeysRepository;
import dagger.internal.Factory;
import dagger.internal.Preconditions;
import javax.inject.Provider;

/* loaded from: classes3.dex */
public final class PhysicalKeysUseCaseModule_ProvideCreatePhysicalKeyUseCaseFactory implements Factory<CreatePhysicalKeyUseCase> {
    private final PhysicalKeysUseCaseModule module;
    private final Provider<IPhysicalKeysRepository> repositoryProvider;

    public PhysicalKeysUseCaseModule_ProvideCreatePhysicalKeyUseCaseFactory(PhysicalKeysUseCaseModule physicalKeysUseCaseModule, Provider<IPhysicalKeysRepository> provider) {
        this.module = physicalKeysUseCaseModule;
        this.repositoryProvider = provider;
    }

    @Override // javax.inject.Provider
    public CreatePhysicalKeyUseCase get() {
        return provideCreatePhysicalKeyUseCase(this.module, this.repositoryProvider.get());
    }

    public static PhysicalKeysUseCaseModule_ProvideCreatePhysicalKeyUseCaseFactory create(PhysicalKeysUseCaseModule physicalKeysUseCaseModule, Provider<IPhysicalKeysRepository> provider) {
        return new PhysicalKeysUseCaseModule_ProvideCreatePhysicalKeyUseCaseFactory(physicalKeysUseCaseModule, provider);
    }

    public static CreatePhysicalKeyUseCase provideCreatePhysicalKeyUseCase(PhysicalKeysUseCaseModule physicalKeysUseCaseModule, IPhysicalKeysRepository iPhysicalKeysRepository) {
        return (CreatePhysicalKeyUseCase) Preconditions.checkNotNullFromProvides(physicalKeysUseCaseModule.provideCreatePhysicalKeyUseCase(iPhysicalKeysRepository));
    }
}

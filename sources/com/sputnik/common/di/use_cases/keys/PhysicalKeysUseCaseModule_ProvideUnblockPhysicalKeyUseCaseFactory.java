package com.sputnik.common.di.use_cases.keys;

import com.sputnik.domain.repositories.keys.IPhysicalKeysRepository;
import dagger.internal.Factory;
import dagger.internal.Preconditions;
import javax.inject.Provider;

/* loaded from: classes3.dex */
public final class PhysicalKeysUseCaseModule_ProvideUnblockPhysicalKeyUseCaseFactory implements Factory<UnblockPhysicalKeyUseCase> {
    private final PhysicalKeysUseCaseModule module;
    private final Provider<IPhysicalKeysRepository> repositoryProvider;

    public PhysicalKeysUseCaseModule_ProvideUnblockPhysicalKeyUseCaseFactory(PhysicalKeysUseCaseModule physicalKeysUseCaseModule, Provider<IPhysicalKeysRepository> provider) {
        this.module = physicalKeysUseCaseModule;
        this.repositoryProvider = provider;
    }

    @Override // javax.inject.Provider
    public UnblockPhysicalKeyUseCase get() {
        return provideUnblockPhysicalKeyUseCase(this.module, this.repositoryProvider.get());
    }

    public static PhysicalKeysUseCaseModule_ProvideUnblockPhysicalKeyUseCaseFactory create(PhysicalKeysUseCaseModule physicalKeysUseCaseModule, Provider<IPhysicalKeysRepository> provider) {
        return new PhysicalKeysUseCaseModule_ProvideUnblockPhysicalKeyUseCaseFactory(physicalKeysUseCaseModule, provider);
    }

    public static UnblockPhysicalKeyUseCase provideUnblockPhysicalKeyUseCase(PhysicalKeysUseCaseModule physicalKeysUseCaseModule, IPhysicalKeysRepository iPhysicalKeysRepository) {
        return (UnblockPhysicalKeyUseCase) Preconditions.checkNotNullFromProvides(physicalKeysUseCaseModule.provideUnblockPhysicalKeyUseCase(iPhysicalKeysRepository));
    }
}

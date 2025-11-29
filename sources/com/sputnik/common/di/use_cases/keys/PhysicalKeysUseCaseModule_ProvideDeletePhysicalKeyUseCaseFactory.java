package com.sputnik.common.di.use_cases.keys;

import com.sputnik.domain.repositories.keys.IPhysicalKeysRepository;
import dagger.internal.Factory;
import dagger.internal.Preconditions;
import javax.inject.Provider;

/* loaded from: classes3.dex */
public final class PhysicalKeysUseCaseModule_ProvideDeletePhysicalKeyUseCaseFactory implements Factory<DeletePhysicalKeyUseCase> {
    private final PhysicalKeysUseCaseModule module;
    private final Provider<IPhysicalKeysRepository> repositoryProvider;

    public PhysicalKeysUseCaseModule_ProvideDeletePhysicalKeyUseCaseFactory(PhysicalKeysUseCaseModule physicalKeysUseCaseModule, Provider<IPhysicalKeysRepository> provider) {
        this.module = physicalKeysUseCaseModule;
        this.repositoryProvider = provider;
    }

    @Override // javax.inject.Provider
    public DeletePhysicalKeyUseCase get() {
        return provideDeletePhysicalKeyUseCase(this.module, this.repositoryProvider.get());
    }

    public static PhysicalKeysUseCaseModule_ProvideDeletePhysicalKeyUseCaseFactory create(PhysicalKeysUseCaseModule physicalKeysUseCaseModule, Provider<IPhysicalKeysRepository> provider) {
        return new PhysicalKeysUseCaseModule_ProvideDeletePhysicalKeyUseCaseFactory(physicalKeysUseCaseModule, provider);
    }

    public static DeletePhysicalKeyUseCase provideDeletePhysicalKeyUseCase(PhysicalKeysUseCaseModule physicalKeysUseCaseModule, IPhysicalKeysRepository iPhysicalKeysRepository) {
        return (DeletePhysicalKeyUseCase) Preconditions.checkNotNullFromProvides(physicalKeysUseCaseModule.provideDeletePhysicalKeyUseCase(iPhysicalKeysRepository));
    }
}

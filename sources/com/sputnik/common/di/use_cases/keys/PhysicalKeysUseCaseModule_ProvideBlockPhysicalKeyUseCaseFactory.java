package com.sputnik.common.di.use_cases.keys;

import com.sputnik.domain.repositories.keys.IPhysicalKeysRepository;
import dagger.internal.Factory;
import dagger.internal.Preconditions;
import javax.inject.Provider;

/* loaded from: classes3.dex */
public final class PhysicalKeysUseCaseModule_ProvideBlockPhysicalKeyUseCaseFactory implements Factory<BlockPhysicalKeyUseCase> {
    private final PhysicalKeysUseCaseModule module;
    private final Provider<IPhysicalKeysRepository> repositoryProvider;

    public PhysicalKeysUseCaseModule_ProvideBlockPhysicalKeyUseCaseFactory(PhysicalKeysUseCaseModule physicalKeysUseCaseModule, Provider<IPhysicalKeysRepository> provider) {
        this.module = physicalKeysUseCaseModule;
        this.repositoryProvider = provider;
    }

    @Override // javax.inject.Provider
    public BlockPhysicalKeyUseCase get() {
        return provideBlockPhysicalKeyUseCase(this.module, this.repositoryProvider.get());
    }

    public static PhysicalKeysUseCaseModule_ProvideBlockPhysicalKeyUseCaseFactory create(PhysicalKeysUseCaseModule physicalKeysUseCaseModule, Provider<IPhysicalKeysRepository> provider) {
        return new PhysicalKeysUseCaseModule_ProvideBlockPhysicalKeyUseCaseFactory(physicalKeysUseCaseModule, provider);
    }

    public static BlockPhysicalKeyUseCase provideBlockPhysicalKeyUseCase(PhysicalKeysUseCaseModule physicalKeysUseCaseModule, IPhysicalKeysRepository iPhysicalKeysRepository) {
        return (BlockPhysicalKeyUseCase) Preconditions.checkNotNullFromProvides(physicalKeysUseCaseModule.provideBlockPhysicalKeyUseCase(iPhysicalKeysRepository));
    }
}

package com.sputnik.common.di.use_cases.keys;

import com.sputnik.domain.repositories.keys.IPhysicalKeysRepository;
import dagger.internal.Factory;
import dagger.internal.Preconditions;
import javax.inject.Provider;

/* loaded from: classes3.dex */
public final class PhysicalKeysUseCaseModule_ProvideGetPhysicalKeysUseCaseFactory implements Factory<GetPhysicalKeysUseCase> {
    private final PhysicalKeysUseCaseModule module;
    private final Provider<IPhysicalKeysRepository> repositoryProvider;

    public PhysicalKeysUseCaseModule_ProvideGetPhysicalKeysUseCaseFactory(PhysicalKeysUseCaseModule physicalKeysUseCaseModule, Provider<IPhysicalKeysRepository> provider) {
        this.module = physicalKeysUseCaseModule;
        this.repositoryProvider = provider;
    }

    @Override // javax.inject.Provider
    public GetPhysicalKeysUseCase get() {
        return provideGetPhysicalKeysUseCase(this.module, this.repositoryProvider.get());
    }

    public static PhysicalKeysUseCaseModule_ProvideGetPhysicalKeysUseCaseFactory create(PhysicalKeysUseCaseModule physicalKeysUseCaseModule, Provider<IPhysicalKeysRepository> provider) {
        return new PhysicalKeysUseCaseModule_ProvideGetPhysicalKeysUseCaseFactory(physicalKeysUseCaseModule, provider);
    }

    public static GetPhysicalKeysUseCase provideGetPhysicalKeysUseCase(PhysicalKeysUseCaseModule physicalKeysUseCaseModule, IPhysicalKeysRepository iPhysicalKeysRepository) {
        return (GetPhysicalKeysUseCase) Preconditions.checkNotNullFromProvides(physicalKeysUseCaseModule.provideGetPhysicalKeysUseCase(iPhysicalKeysRepository));
    }
}

package com.sputnik.common.di.use_cases.keys;

import com.sputnik.domain.repositories.keys.IPhysicalKeysRepository;
import dagger.internal.Factory;
import dagger.internal.Preconditions;
import javax.inject.Provider;

/* loaded from: classes3.dex */
public final class PhysicalKeysUseCaseModule_ProvideUpdatePhysicalKeyCommentUseCaseFactory implements Factory<UpdatePhysicalKeyCommentUseCase> {
    private final PhysicalKeysUseCaseModule module;
    private final Provider<IPhysicalKeysRepository> repositoryProvider;

    public PhysicalKeysUseCaseModule_ProvideUpdatePhysicalKeyCommentUseCaseFactory(PhysicalKeysUseCaseModule physicalKeysUseCaseModule, Provider<IPhysicalKeysRepository> provider) {
        this.module = physicalKeysUseCaseModule;
        this.repositoryProvider = provider;
    }

    @Override // javax.inject.Provider
    public UpdatePhysicalKeyCommentUseCase get() {
        return provideUpdatePhysicalKeyCommentUseCase(this.module, this.repositoryProvider.get());
    }

    public static PhysicalKeysUseCaseModule_ProvideUpdatePhysicalKeyCommentUseCaseFactory create(PhysicalKeysUseCaseModule physicalKeysUseCaseModule, Provider<IPhysicalKeysRepository> provider) {
        return new PhysicalKeysUseCaseModule_ProvideUpdatePhysicalKeyCommentUseCaseFactory(physicalKeysUseCaseModule, provider);
    }

    public static UpdatePhysicalKeyCommentUseCase provideUpdatePhysicalKeyCommentUseCase(PhysicalKeysUseCaseModule physicalKeysUseCaseModule, IPhysicalKeysRepository iPhysicalKeysRepository) {
        return (UpdatePhysicalKeyCommentUseCase) Preconditions.checkNotNullFromProvides(physicalKeysUseCaseModule.provideUpdatePhysicalKeyCommentUseCase(iPhysicalKeysRepository));
    }
}

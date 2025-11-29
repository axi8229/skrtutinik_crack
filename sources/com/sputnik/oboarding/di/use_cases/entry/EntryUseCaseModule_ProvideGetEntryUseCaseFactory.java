package com.sputnik.oboarding.di.use_cases.entry;

import com.sputnik.domain.repositories.registration.IConnectIntercomRepository;
import com.sputnik.domain.usecases.entry.GetEntryUseCase;
import dagger.internal.Factory;
import dagger.internal.Preconditions;
import javax.inject.Provider;

/* loaded from: classes3.dex */
public final class EntryUseCaseModule_ProvideGetEntryUseCaseFactory implements Factory<GetEntryUseCase> {
    private final EntryUseCaseModule module;
    private final Provider<IConnectIntercomRepository> repositoryProvider;

    public EntryUseCaseModule_ProvideGetEntryUseCaseFactory(EntryUseCaseModule entryUseCaseModule, Provider<IConnectIntercomRepository> provider) {
        this.module = entryUseCaseModule;
        this.repositoryProvider = provider;
    }

    @Override // javax.inject.Provider
    public GetEntryUseCase get() {
        return provideGetEntryUseCase(this.module, this.repositoryProvider.get());
    }

    public static EntryUseCaseModule_ProvideGetEntryUseCaseFactory create(EntryUseCaseModule entryUseCaseModule, Provider<IConnectIntercomRepository> provider) {
        return new EntryUseCaseModule_ProvideGetEntryUseCaseFactory(entryUseCaseModule, provider);
    }

    public static GetEntryUseCase provideGetEntryUseCase(EntryUseCaseModule entryUseCaseModule, IConnectIntercomRepository iConnectIntercomRepository) {
        return (GetEntryUseCase) Preconditions.checkNotNullFromProvides(entryUseCaseModule.provideGetEntryUseCase(iConnectIntercomRepository));
    }
}

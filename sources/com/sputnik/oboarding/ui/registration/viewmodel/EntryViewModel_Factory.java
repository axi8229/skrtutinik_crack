package com.sputnik.oboarding.ui.registration.viewmodel;

import com.sputnik.domain.usecases.entry.GetEntryUseCase;
import com.sputnik.oboarding.mappers.entry.DomainEntryToEntryMapper;
import dagger.internal.Factory;
import javax.inject.Provider;

/* loaded from: classes3.dex */
public final class EntryViewModel_Factory implements Factory<EntryViewModel> {
    private final Provider<DomainEntryToEntryMapper> domainEntryToEntryMapperProvider;
    private final Provider<GetEntryUseCase> getEntryUseCaseProvider;

    public EntryViewModel_Factory(Provider<GetEntryUseCase> provider, Provider<DomainEntryToEntryMapper> provider2) {
        this.getEntryUseCaseProvider = provider;
        this.domainEntryToEntryMapperProvider = provider2;
    }

    @Override // javax.inject.Provider
    public EntryViewModel get() {
        return newInstance(this.getEntryUseCaseProvider.get(), this.domainEntryToEntryMapperProvider.get());
    }

    public static EntryViewModel_Factory create(Provider<GetEntryUseCase> provider, Provider<DomainEntryToEntryMapper> provider2) {
        return new EntryViewModel_Factory(provider, provider2);
    }

    public static EntryViewModel newInstance(GetEntryUseCase getEntryUseCase, DomainEntryToEntryMapper domainEntryToEntryMapper) {
        return new EntryViewModel(getEntryUseCase, domainEntryToEntryMapper);
    }
}

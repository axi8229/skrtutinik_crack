package com.sputnik.common.di.use_cases.subscriptions;

import com.sputnik.domain.repositories.market.IMarketRepository;
import com.sputnik.domain.usecases.market.GetMarketV2UseCase;
import dagger.internal.Factory;
import dagger.internal.Preconditions;
import javax.inject.Provider;

/* loaded from: classes3.dex */
public final class SubscriptionsUseCaseModule_ProvideGetMarketV2UseCaseFactory implements Factory<GetMarketV2UseCase> {
    private final SubscriptionsUseCaseModule module;
    private final Provider<IMarketRepository> repositoryProvider;

    public SubscriptionsUseCaseModule_ProvideGetMarketV2UseCaseFactory(SubscriptionsUseCaseModule subscriptionsUseCaseModule, Provider<IMarketRepository> provider) {
        this.module = subscriptionsUseCaseModule;
        this.repositoryProvider = provider;
    }

    @Override // javax.inject.Provider
    public GetMarketV2UseCase get() {
        return provideGetMarketV2UseCase(this.module, this.repositoryProvider.get());
    }

    public static SubscriptionsUseCaseModule_ProvideGetMarketV2UseCaseFactory create(SubscriptionsUseCaseModule subscriptionsUseCaseModule, Provider<IMarketRepository> provider) {
        return new SubscriptionsUseCaseModule_ProvideGetMarketV2UseCaseFactory(subscriptionsUseCaseModule, provider);
    }

    public static GetMarketV2UseCase provideGetMarketV2UseCase(SubscriptionsUseCaseModule subscriptionsUseCaseModule, IMarketRepository iMarketRepository) {
        return (GetMarketV2UseCase) Preconditions.checkNotNullFromProvides(subscriptionsUseCaseModule.provideGetMarketV2UseCase(iMarketRepository));
    }
}

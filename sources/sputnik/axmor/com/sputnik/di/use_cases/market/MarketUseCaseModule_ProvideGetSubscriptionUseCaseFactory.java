package sputnik.axmor.com.sputnik.di.use_cases.market;

import com.sputnik.domain.repositories.market.IMarketRepository;
import com.sputnik.domain.usecases.market.GetSubscriptionUseCase;
import dagger.internal.Factory;
import dagger.internal.Preconditions;

/* loaded from: classes5.dex */
public final class MarketUseCaseModule_ProvideGetSubscriptionUseCaseFactory implements Factory<GetSubscriptionUseCase> {
    public static GetSubscriptionUseCase provideGetSubscriptionUseCase(MarketUseCaseModule marketUseCaseModule, IMarketRepository iMarketRepository) {
        return (GetSubscriptionUseCase) Preconditions.checkNotNullFromProvides(marketUseCaseModule.provideGetSubscriptionUseCase(iMarketRepository));
    }
}

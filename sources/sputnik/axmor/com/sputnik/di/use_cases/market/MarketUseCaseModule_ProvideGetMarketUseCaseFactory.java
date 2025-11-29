package sputnik.axmor.com.sputnik.di.use_cases.market;

import com.sputnik.domain.repositories.market.IMarketRepository;
import com.sputnik.domain.usecases.market.GetMarketUseCase;
import dagger.internal.Factory;
import dagger.internal.Preconditions;

/* loaded from: classes5.dex */
public final class MarketUseCaseModule_ProvideGetMarketUseCaseFactory implements Factory<GetMarketUseCase> {
    public static GetMarketUseCase provideGetMarketUseCase(MarketUseCaseModule marketUseCaseModule, IMarketRepository iMarketRepository) {
        return (GetMarketUseCase) Preconditions.checkNotNullFromProvides(marketUseCaseModule.provideGetMarketUseCase(iMarketRepository));
    }
}

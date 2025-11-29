package sputnik.axmor.com.sputnik.di.use_cases.market;

import com.sputnik.domain.repositories.market.IMarketRepository;
import com.sputnik.domain.usecases.market.GetServicesUseCase;
import dagger.internal.Factory;
import dagger.internal.Preconditions;

/* loaded from: classes5.dex */
public final class MarketUseCaseModule_ProvideGetServicesUseCaseFactory implements Factory<GetServicesUseCase> {
    public static GetServicesUseCase provideGetServicesUseCase(MarketUseCaseModule marketUseCaseModule, IMarketRepository iMarketRepository) {
        return (GetServicesUseCase) Preconditions.checkNotNullFromProvides(marketUseCaseModule.provideGetServicesUseCase(iMarketRepository));
    }
}

package sputnik.axmor.com.sputnik.di.use_cases.market;

import com.sputnik.domain.repositories.market.IMarketRepository;
import com.sputnik.domain.usecases.market.GetMarketUseCase;
import com.sputnik.domain.usecases.market.GetServicesUseCase;
import com.sputnik.domain.usecases.market.GetSubscriptionUseCase;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

/* compiled from: MarketUseCaseModule.kt */
@Metadata(d1 = {"\u0000$\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\b\u0007\u0018\u00002\u00020\u0001B\u0005¢\u0006\u0002\u0010\u0002J\u0010\u0010\u0003\u001a\u00020\u00042\u0006\u0010\u0005\u001a\u00020\u0006H\u0007J\u0010\u0010\u0007\u001a\u00020\b2\u0006\u0010\u0005\u001a\u00020\u0006H\u0007J\u0010\u0010\t\u001a\u00020\n2\u0006\u0010\u0005\u001a\u00020\u0006H\u0007¨\u0006\u000b"}, d2 = {"Lsputnik/axmor/com/sputnik/di/use_cases/market/MarketUseCaseModule;", "", "()V", "provideGetMarketUseCase", "Lcom/sputnik/domain/usecases/market/GetMarketUseCase;", "repository", "Lcom/sputnik/domain/repositories/market/IMarketRepository;", "provideGetServicesUseCase", "Lcom/sputnik/domain/usecases/market/GetServicesUseCase;", "provideGetSubscriptionUseCase", "Lcom/sputnik/domain/usecases/market/GetSubscriptionUseCase;", "app_huaweiRelease"}, k = 1, mv = {1, 9, 0}, xi = 48)
/* loaded from: classes5.dex */
public final class MarketUseCaseModule {
    public final GetMarketUseCase provideGetMarketUseCase(IMarketRepository repository) {
        Intrinsics.checkNotNullParameter(repository, "repository");
        return new GetMarketUseCase(repository);
    }

    public final GetServicesUseCase provideGetServicesUseCase(IMarketRepository repository) {
        Intrinsics.checkNotNullParameter(repository, "repository");
        return new GetServicesUseCase(repository);
    }

    public final GetSubscriptionUseCase provideGetSubscriptionUseCase(IMarketRepository repository) {
        Intrinsics.checkNotNullParameter(repository, "repository");
        return new GetSubscriptionUseCase(repository);
    }
}

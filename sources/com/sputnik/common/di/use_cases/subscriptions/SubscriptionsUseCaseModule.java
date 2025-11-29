package com.sputnik.common.di.use_cases.subscriptions;

import com.sputnik.domain.repositories.market.IMarketRepository;
import com.sputnik.domain.usecases.market.GetMarketV2UseCase;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

/* compiled from: SubscriptionsUseCaseModule.kt */
@Metadata(d1 = {"\u0000\u0018\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\b\u0007\u0018\u00002\u00020\u0001B\u0005¢\u0006\u0002\u0010\u0002J\u0010\u0010\u0003\u001a\u00020\u00042\u0006\u0010\u0005\u001a\u00020\u0006H\u0007¨\u0006\u0007"}, d2 = {"Lcom/sputnik/common/di/use_cases/subscriptions/SubscriptionsUseCaseModule;", "", "()V", "provideGetMarketV2UseCase", "Lcom/sputnik/domain/usecases/market/GetMarketV2UseCase;", "repository", "Lcom/sputnik/domain/repositories/market/IMarketRepository;", "common_release"}, k = 1, mv = {1, 9, 0}, xi = 48)
/* loaded from: classes3.dex */
public final class SubscriptionsUseCaseModule {
    public final GetMarketV2UseCase provideGetMarketV2UseCase(IMarketRepository repository) {
        Intrinsics.checkNotNullParameter(repository, "repository");
        return new GetMarketV2UseCase(repository);
    }
}

package sputnik.axmor.com.sputnik.di.use_cases.subscription;

import com.sputnik.domain.repositories.subscription.ISubscriptionRepository;
import com.sputnik.domain.usecases.subscription.StartSubscriptionUseCase;
import dagger.internal.Factory;
import dagger.internal.Preconditions;

/* loaded from: classes5.dex */
public final class SubscriptionUseCaseModule_ProvideStartSubscriptionUseCaseFactory implements Factory<StartSubscriptionUseCase> {
    public static StartSubscriptionUseCase provideStartSubscriptionUseCase(SubscriptionUseCaseModule subscriptionUseCaseModule, ISubscriptionRepository iSubscriptionRepository) {
        return (StartSubscriptionUseCase) Preconditions.checkNotNullFromProvides(subscriptionUseCaseModule.provideStartSubscriptionUseCase(iSubscriptionRepository));
    }
}

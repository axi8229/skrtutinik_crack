package sputnik.axmor.com.sputnik.di.use_cases.subscription;

import com.sputnik.domain.repositories.subscription.ISubscriptionRepository;
import com.sputnik.domain.usecases.subscription.StopSubscriptionUseCase;
import dagger.internal.Factory;
import dagger.internal.Preconditions;

/* loaded from: classes5.dex */
public final class SubscriptionUseCaseModule_ProvideStopSubscriptionUseCaseFactory implements Factory<StopSubscriptionUseCase> {
    public static StopSubscriptionUseCase provideStopSubscriptionUseCase(SubscriptionUseCaseModule subscriptionUseCaseModule, ISubscriptionRepository iSubscriptionRepository) {
        return (StopSubscriptionUseCase) Preconditions.checkNotNullFromProvides(subscriptionUseCaseModule.provideStopSubscriptionUseCase(iSubscriptionRepository));
    }
}

package sputnik.axmor.com.sputnik.di.use_cases.subscription;

import com.sputnik.domain.repositories.subscription.ISubscriptionRepository;
import com.sputnik.domain.usecases.subscription.GetLastCardPaymentUseCase;
import dagger.internal.Factory;
import dagger.internal.Preconditions;

/* loaded from: classes5.dex */
public final class SubscriptionUseCaseModule_ProvideGetLastCardPaymentUseCaseFactory implements Factory<GetLastCardPaymentUseCase> {
    public static GetLastCardPaymentUseCase provideGetLastCardPaymentUseCase(SubscriptionUseCaseModule subscriptionUseCaseModule, ISubscriptionRepository iSubscriptionRepository) {
        return (GetLastCardPaymentUseCase) Preconditions.checkNotNullFromProvides(subscriptionUseCaseModule.provideGetLastCardPaymentUseCase(iSubscriptionRepository));
    }
}

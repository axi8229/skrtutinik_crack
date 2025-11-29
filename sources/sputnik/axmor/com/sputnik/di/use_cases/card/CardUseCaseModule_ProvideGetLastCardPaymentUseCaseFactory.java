package sputnik.axmor.com.sputnik.di.use_cases.card;

import com.sputnik.domain.repositories.card.ICardRepository;
import com.sputnik.domain.usecases.card.GetLastCardPaymentUseCase;
import dagger.internal.Factory;
import dagger.internal.Preconditions;

/* loaded from: classes5.dex */
public final class CardUseCaseModule_ProvideGetLastCardPaymentUseCaseFactory implements Factory<GetLastCardPaymentUseCase> {
    public static GetLastCardPaymentUseCase provideGetLastCardPaymentUseCase(CardUseCaseModule cardUseCaseModule, ICardRepository iCardRepository) {
        return (GetLastCardPaymentUseCase) Preconditions.checkNotNullFromProvides(cardUseCaseModule.provideGetLastCardPaymentUseCase(iCardRepository));
    }
}

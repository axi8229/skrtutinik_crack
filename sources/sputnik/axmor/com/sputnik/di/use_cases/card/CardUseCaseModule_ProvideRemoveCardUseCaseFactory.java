package sputnik.axmor.com.sputnik.di.use_cases.card;

import com.sputnik.domain.repositories.card.ICardRepository;
import com.sputnik.domain.usecases.card.RemoveCardUseCase;
import dagger.internal.Factory;
import dagger.internal.Preconditions;

/* loaded from: classes5.dex */
public final class CardUseCaseModule_ProvideRemoveCardUseCaseFactory implements Factory<RemoveCardUseCase> {
    public static RemoveCardUseCase provideRemoveCardUseCase(CardUseCaseModule cardUseCaseModule, ICardRepository iCardRepository) {
        return (RemoveCardUseCase) Preconditions.checkNotNullFromProvides(cardUseCaseModule.provideRemoveCardUseCase(iCardRepository));
    }
}

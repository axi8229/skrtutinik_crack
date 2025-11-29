package sputnik.axmor.com.sputnik.di.use_cases.card;

import com.sputnik.domain.repositories.card.ICardRepository;
import com.sputnik.domain.usecases.card.AddNewCardUseCase;
import dagger.internal.Factory;
import dagger.internal.Preconditions;

/* loaded from: classes5.dex */
public final class CardUseCaseModule_ProvideAddNewCardUseCaseFactory implements Factory<AddNewCardUseCase> {
    public static AddNewCardUseCase provideAddNewCardUseCase(CardUseCaseModule cardUseCaseModule, ICardRepository iCardRepository) {
        return (AddNewCardUseCase) Preconditions.checkNotNullFromProvides(cardUseCaseModule.provideAddNewCardUseCase(iCardRepository));
    }
}

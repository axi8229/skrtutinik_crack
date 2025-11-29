package sputnik.axmor.com.sputnik.di.use_cases.card;

import com.sputnik.domain.repositories.card.ICardRepository;
import com.sputnik.domain.usecases.card.AddNewCardUseCase;
import com.sputnik.domain.usecases.card.GetLastCardPaymentUseCase;
import com.sputnik.domain.usecases.card.RemoveCardUseCase;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

/* compiled from: CardUseCaseModule.kt */
@Metadata(d1 = {"\u0000$\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\b\u0007\u0018\u00002\u00020\u0001B\u0005¢\u0006\u0002\u0010\u0002J\u0010\u0010\u0003\u001a\u00020\u00042\u0006\u0010\u0005\u001a\u00020\u0006H\u0007J\u0010\u0010\u0007\u001a\u00020\b2\u0006\u0010\u0005\u001a\u00020\u0006H\u0007J\u0010\u0010\t\u001a\u00020\n2\u0006\u0010\u0005\u001a\u00020\u0006H\u0007¨\u0006\u000b"}, d2 = {"Lsputnik/axmor/com/sputnik/di/use_cases/card/CardUseCaseModule;", "", "()V", "provideAddNewCardUseCase", "Lcom/sputnik/domain/usecases/card/AddNewCardUseCase;", "repository", "Lcom/sputnik/domain/repositories/card/ICardRepository;", "provideGetLastCardPaymentUseCase", "Lcom/sputnik/domain/usecases/card/GetLastCardPaymentUseCase;", "provideRemoveCardUseCase", "Lcom/sputnik/domain/usecases/card/RemoveCardUseCase;", "app_huaweiRelease"}, k = 1, mv = {1, 9, 0}, xi = 48)
/* loaded from: classes5.dex */
public final class CardUseCaseModule {
    public final AddNewCardUseCase provideAddNewCardUseCase(ICardRepository repository) {
        Intrinsics.checkNotNullParameter(repository, "repository");
        return new AddNewCardUseCase(repository);
    }

    public final GetLastCardPaymentUseCase provideGetLastCardPaymentUseCase(ICardRepository repository) {
        Intrinsics.checkNotNullParameter(repository, "repository");
        return new GetLastCardPaymentUseCase(repository);
    }

    public final RemoveCardUseCase provideRemoveCardUseCase(ICardRepository repository) {
        Intrinsics.checkNotNullParameter(repository, "repository");
        return new RemoveCardUseCase(repository);
    }
}

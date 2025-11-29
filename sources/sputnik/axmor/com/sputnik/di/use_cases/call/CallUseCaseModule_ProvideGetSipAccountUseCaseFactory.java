package sputnik.axmor.com.sputnik.di.use_cases.call;

import com.sputnik.domain.repositories.call.ICallRepository;
import com.sputnik.domain.usecases.call.GetSipAccountUseCase;
import dagger.internal.Factory;
import dagger.internal.Preconditions;

/* loaded from: classes5.dex */
public final class CallUseCaseModule_ProvideGetSipAccountUseCaseFactory implements Factory<GetSipAccountUseCase> {
    public static GetSipAccountUseCase provideGetSipAccountUseCase(CallUseCaseModule callUseCaseModule, ICallRepository iCallRepository) {
        return (GetSipAccountUseCase) Preconditions.checkNotNullFromProvides(callUseCaseModule.provideGetSipAccountUseCase(iCallRepository));
    }
}

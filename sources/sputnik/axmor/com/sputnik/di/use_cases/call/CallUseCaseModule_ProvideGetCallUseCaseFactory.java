package sputnik.axmor.com.sputnik.di.use_cases.call;

import com.sputnik.domain.repositories.call.ICallRepository;
import com.sputnik.domain.usecases.call.GetCallUseCase;
import dagger.internal.Factory;
import dagger.internal.Preconditions;

/* loaded from: classes5.dex */
public final class CallUseCaseModule_ProvideGetCallUseCaseFactory implements Factory<GetCallUseCase> {
    public static GetCallUseCase provideGetCallUseCase(CallUseCaseModule callUseCaseModule, ICallRepository iCallRepository) {
        return (GetCallUseCase) Preconditions.checkNotNullFromProvides(callUseCaseModule.provideGetCallUseCase(iCallRepository));
    }
}

package sputnik.axmor.com.sputnik.di.use_cases.call;

import com.sputnik.domain.repositories.call.ICallRepository;
import com.sputnik.domain.usecases.call.AcceptCallUseCase;
import dagger.internal.Factory;
import dagger.internal.Preconditions;

/* loaded from: classes5.dex */
public final class CallUseCaseModule_ProvideAcceptCallUseCaseFactory implements Factory<AcceptCallUseCase> {
    public static AcceptCallUseCase provideAcceptCallUseCase(CallUseCaseModule callUseCaseModule, ICallRepository iCallRepository) {
        return (AcceptCallUseCase) Preconditions.checkNotNullFromProvides(callUseCaseModule.provideAcceptCallUseCase(iCallRepository));
    }
}

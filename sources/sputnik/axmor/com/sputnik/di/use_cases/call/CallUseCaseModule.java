package sputnik.axmor.com.sputnik.di.use_cases.call;

import com.sputnik.domain.repositories.call.ICallRepository;
import com.sputnik.domain.usecases.call.AcceptCallUseCase;
import com.sputnik.domain.usecases.call.GetCallUseCase;
import com.sputnik.domain.usecases.call.GetSipAccountUseCase;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

/* compiled from: CallUseCaseModule.kt */
@Metadata(d1 = {"\u0000$\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\b\u0007\u0018\u00002\u00020\u0001B\u0005¢\u0006\u0002\u0010\u0002J\u0010\u0010\u0003\u001a\u00020\u00042\u0006\u0010\u0005\u001a\u00020\u0006H\u0007J\u0010\u0010\u0007\u001a\u00020\b2\u0006\u0010\u0005\u001a\u00020\u0006H\u0007J\u0010\u0010\t\u001a\u00020\n2\u0006\u0010\u0005\u001a\u00020\u0006H\u0007¨\u0006\u000b"}, d2 = {"Lsputnik/axmor/com/sputnik/di/use_cases/call/CallUseCaseModule;", "", "()V", "provideAcceptCallUseCase", "Lcom/sputnik/domain/usecases/call/AcceptCallUseCase;", "repository", "Lcom/sputnik/domain/repositories/call/ICallRepository;", "provideGetCallUseCase", "Lcom/sputnik/domain/usecases/call/GetCallUseCase;", "provideGetSipAccountUseCase", "Lcom/sputnik/domain/usecases/call/GetSipAccountUseCase;", "app_huaweiRelease"}, k = 1, mv = {1, 9, 0}, xi = 48)
/* loaded from: classes5.dex */
public final class CallUseCaseModule {
    public final AcceptCallUseCase provideAcceptCallUseCase(ICallRepository repository) {
        Intrinsics.checkNotNullParameter(repository, "repository");
        return new AcceptCallUseCase(repository);
    }

    public final GetCallUseCase provideGetCallUseCase(ICallRepository repository) {
        Intrinsics.checkNotNullParameter(repository, "repository");
        return new GetCallUseCase(repository);
    }

    public final GetSipAccountUseCase provideGetSipAccountUseCase(ICallRepository repository) {
        Intrinsics.checkNotNullParameter(repository, "repository");
        return new GetSipAccountUseCase(repository);
    }
}

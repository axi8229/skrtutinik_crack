package com.sputnik.oboarding.di.use_cases.auth;

import com.sputnik.domain.repositories.auth.IAuthRepository;
import com.sputnik.domain.usecases.auth.ApplyRegistrationUseCase;
import com.sputnik.domain.usecases.auth.ConfirmCodeUseCase;
import com.sputnik.domain.usecases.auth.ConfirmRegistrationUseCase;
import com.sputnik.domain.usecases.auth.GetRequestUseCase;
import com.sputnik.domain.usecases.auth.RegisterUserByPhoneUseCase;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

/* compiled from: AuthUseCaseModule.kt */
@Metadata(d1 = {"\u00000\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\b\u0007\u0018\u00002\u00020\u0001B\u0005¢\u0006\u0002\u0010\u0002J\u0010\u0010\u0003\u001a\u00020\u00042\u0006\u0010\u0005\u001a\u00020\u0006H\u0007J\u0010\u0010\u0007\u001a\u00020\b2\u0006\u0010\u0005\u001a\u00020\u0006H\u0007J\u0010\u0010\t\u001a\u00020\n2\u0006\u0010\u0005\u001a\u00020\u0006H\u0007J\u0010\u0010\u000b\u001a\u00020\f2\u0006\u0010\u0005\u001a\u00020\u0006H\u0007J\u0010\u0010\r\u001a\u00020\u000e2\u0006\u0010\u0005\u001a\u00020\u0006H\u0007¨\u0006\u000f"}, d2 = {"Lcom/sputnik/oboarding/di/use_cases/auth/AuthUseCaseModule;", "", "()V", "provideApplyRegistrationUseCase", "Lcom/sputnik/domain/usecases/auth/ApplyRegistrationUseCase;", "repository", "Lcom/sputnik/domain/repositories/auth/IAuthRepository;", "provideConfirmCodeUseCase", "Lcom/sputnik/domain/usecases/auth/ConfirmCodeUseCase;", "provideConfirmRegistrationUseCase", "Lcom/sputnik/domain/usecases/auth/ConfirmRegistrationUseCase;", "provideGetRequestUseCase", "Lcom/sputnik/domain/usecases/auth/GetRequestUseCase;", "provideRegisterUserByPhoneUseCase", "Lcom/sputnik/domain/usecases/auth/RegisterUserByPhoneUseCase;", "onboarding_release"}, k = 1, mv = {1, 9, 0}, xi = 48)
/* loaded from: classes3.dex */
public final class AuthUseCaseModule {
    public final ConfirmCodeUseCase provideConfirmCodeUseCase(IAuthRepository repository) {
        Intrinsics.checkNotNullParameter(repository, "repository");
        return new ConfirmCodeUseCase(repository);
    }

    public final RegisterUserByPhoneUseCase provideRegisterUserByPhoneUseCase(IAuthRepository repository) {
        Intrinsics.checkNotNullParameter(repository, "repository");
        return new RegisterUserByPhoneUseCase(repository);
    }

    public final ApplyRegistrationUseCase provideApplyRegistrationUseCase(IAuthRepository repository) {
        Intrinsics.checkNotNullParameter(repository, "repository");
        return new ApplyRegistrationUseCase(repository);
    }

    public final ConfirmRegistrationUseCase provideConfirmRegistrationUseCase(IAuthRepository repository) {
        Intrinsics.checkNotNullParameter(repository, "repository");
        return new ConfirmRegistrationUseCase(repository);
    }

    public final GetRequestUseCase provideGetRequestUseCase(IAuthRepository repository) {
        Intrinsics.checkNotNullParameter(repository, "repository");
        return new GetRequestUseCase(repository);
    }
}

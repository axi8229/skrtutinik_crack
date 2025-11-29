package com.sputnik.common.di.use_cases.support;

import com.sputnik.domain.repositories.support.ISupportRepository;
import com.sputnik.domain.usecases.support.GetAnnounceUseCase;
import com.sputnik.domain.usecases.support.GetCompanyContactsUseCase;
import com.sputnik.domain.usecases.support.GetFaq2UseCase;
import com.sputnik.domain.usecases.support.GetFaqUseCase;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

/* compiled from: SupportUseCaseModule.kt */
@Metadata(d1 = {"\u0000*\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\b\u0007\u0018\u00002\u00020\u0001B\u0005¢\u0006\u0002\u0010\u0002J\u0010\u0010\u0003\u001a\u00020\u00042\u0006\u0010\u0005\u001a\u00020\u0006H\u0007J\u0010\u0010\u0007\u001a\u00020\b2\u0006\u0010\u0005\u001a\u00020\u0006H\u0007J\u0010\u0010\t\u001a\u00020\n2\u0006\u0010\u0005\u001a\u00020\u0006H\u0007J\u0010\u0010\u000b\u001a\u00020\f2\u0006\u0010\u0005\u001a\u00020\u0006H\u0007¨\u0006\r"}, d2 = {"Lcom/sputnik/common/di/use_cases/support/SupportUseCaseModule;", "", "()V", "provideGetAnnounceUseCase", "Lcom/sputnik/domain/usecases/support/GetAnnounceUseCase;", "repository", "Lcom/sputnik/domain/repositories/support/ISupportRepository;", "provideGetCompanyContactsUseCase", "Lcom/sputnik/domain/usecases/support/GetCompanyContactsUseCase;", "provideGetFaq2UseCase", "Lcom/sputnik/domain/usecases/support/GetFaq2UseCase;", "provideGetFaqUseCase", "Lcom/sputnik/domain/usecases/support/GetFaqUseCase;", "common_release"}, k = 1, mv = {1, 9, 0}, xi = 48)
/* loaded from: classes3.dex */
public final class SupportUseCaseModule {
    public final GetFaq2UseCase provideGetFaq2UseCase(ISupportRepository repository) {
        Intrinsics.checkNotNullParameter(repository, "repository");
        return new GetFaq2UseCase(repository);
    }

    public final GetFaqUseCase provideGetFaqUseCase(ISupportRepository repository) {
        Intrinsics.checkNotNullParameter(repository, "repository");
        return new GetFaqUseCase(repository);
    }

    public final GetCompanyContactsUseCase provideGetCompanyContactsUseCase(ISupportRepository repository) {
        Intrinsics.checkNotNullParameter(repository, "repository");
        return new GetCompanyContactsUseCase(repository);
    }

    public final GetAnnounceUseCase provideGetAnnounceUseCase(ISupportRepository repository) {
        Intrinsics.checkNotNullParameter(repository, "repository");
        return new GetAnnounceUseCase(repository);
    }
}

package com.sputnik.oboarding.di.use_cases.entry;

import com.sputnik.domain.repositories.registration.IConnectIntercomRepository;
import com.sputnik.domain.usecases.entry.GetEntryUseCase;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

/* compiled from: EntryUseCaseModule.kt */
@Metadata(d1 = {"\u0000\u0018\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\b\u0007\u0018\u00002\u00020\u0001B\u0005¢\u0006\u0002\u0010\u0002J\u0010\u0010\u0003\u001a\u00020\u00042\u0006\u0010\u0005\u001a\u00020\u0006H\u0007¨\u0006\u0007"}, d2 = {"Lcom/sputnik/oboarding/di/use_cases/entry/EntryUseCaseModule;", "", "()V", "provideGetEntryUseCase", "Lcom/sputnik/domain/usecases/entry/GetEntryUseCase;", "repository", "Lcom/sputnik/domain/repositories/registration/IConnectIntercomRepository;", "onboarding_release"}, k = 1, mv = {1, 9, 0}, xi = 48)
/* loaded from: classes3.dex */
public final class EntryUseCaseModule {
    public final GetEntryUseCase provideGetEntryUseCase(IConnectIntercomRepository repository) {
        Intrinsics.checkNotNullParameter(repository, "repository");
        return new GetEntryUseCase(repository);
    }
}

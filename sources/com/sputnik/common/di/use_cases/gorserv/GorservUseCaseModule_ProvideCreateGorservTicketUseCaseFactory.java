package com.sputnik.common.di.use_cases.gorserv;

import com.sputnik.domain.repositories.gorserv.IGorservRepository;
import com.sputnik.domain.usecases.gorserv.CreateGorservTicketUseCase;
import dagger.internal.Factory;
import dagger.internal.Preconditions;

/* loaded from: classes3.dex */
public final class GorservUseCaseModule_ProvideCreateGorservTicketUseCaseFactory implements Factory<CreateGorservTicketUseCase> {
    public static CreateGorservTicketUseCase provideCreateGorservTicketUseCase(GorservUseCaseModule gorservUseCaseModule, IGorservRepository iGorservRepository) {
        return (CreateGorservTicketUseCase) Preconditions.checkNotNullFromProvides(gorservUseCaseModule.provideCreateGorservTicketUseCase(iGorservRepository));
    }
}

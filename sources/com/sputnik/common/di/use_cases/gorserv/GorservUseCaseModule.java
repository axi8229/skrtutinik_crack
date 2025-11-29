package com.sputnik.common.di.use_cases.gorserv;

import com.sputnik.domain.repositories.gorserv.IGorservRepository;
import com.sputnik.domain.usecases.gorserv.CreateGorservTicketUseCase;
import com.sputnik.domain.usecases.gorserv.GetGorservCatalogsUseCase;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

/* compiled from: GorservUseCaseModule.kt */
@Metadata(d1 = {"\u0000\u001e\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\b\u0007\u0018\u00002\u00020\u0001B\u0005¢\u0006\u0002\u0010\u0002J\u0010\u0010\u0003\u001a\u00020\u00042\u0006\u0010\u0005\u001a\u00020\u0006H\u0007J\u0010\u0010\u0007\u001a\u00020\b2\u0006\u0010\u0005\u001a\u00020\u0006H\u0007¨\u0006\t"}, d2 = {"Lcom/sputnik/common/di/use_cases/gorserv/GorservUseCaseModule;", "", "()V", "provideCreateGorservTicketUseCase", "Lcom/sputnik/domain/usecases/gorserv/CreateGorservTicketUseCase;", "repository", "Lcom/sputnik/domain/repositories/gorserv/IGorservRepository;", "provideGetGorservCatalogsUseCase", "Lcom/sputnik/domain/usecases/gorserv/GetGorservCatalogsUseCase;", "common_release"}, k = 1, mv = {1, 9, 0}, xi = 48)
/* loaded from: classes3.dex */
public final class GorservUseCaseModule {
    public final GetGorservCatalogsUseCase provideGetGorservCatalogsUseCase(IGorservRepository repository) {
        Intrinsics.checkNotNullParameter(repository, "repository");
        return new GetGorservCatalogsUseCase(repository);
    }

    public final CreateGorservTicketUseCase provideCreateGorservTicketUseCase(IGorservRepository repository) {
        Intrinsics.checkNotNullParameter(repository, "repository");
        return new CreateGorservTicketUseCase(repository);
    }
}

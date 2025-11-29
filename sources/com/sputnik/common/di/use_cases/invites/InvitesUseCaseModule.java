package com.sputnik.common.di.use_cases.invites;

import com.sputnik.domain.repositories.invites.IInvitesRepository;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

/* compiled from: InvitesUseCaseModule.kt */
@Metadata(d1 = {"\u0000<\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\b\u0007\u0018\u00002\u00020\u0001B\u0005¢\u0006\u0002\u0010\u0002J\u0010\u0010\u0003\u001a\u00020\u00042\u0006\u0010\u0005\u001a\u00020\u0006H\u0007J\u0010\u0010\u0007\u001a\u00020\b2\u0006\u0010\u0005\u001a\u00020\u0006H\u0007J\u0010\u0010\t\u001a\u00020\n2\u0006\u0010\u0005\u001a\u00020\u0006H\u0007J\u0010\u0010\u000b\u001a\u00020\f2\u0006\u0010\u0005\u001a\u00020\u0006H\u0007J\u0010\u0010\r\u001a\u00020\u000e2\u0006\u0010\u0005\u001a\u00020\u0006H\u0007J\u0010\u0010\u000f\u001a\u00020\u00102\u0006\u0010\u0005\u001a\u00020\u0006H\u0007J\u0010\u0010\u0011\u001a\u00020\u00122\u0006\u0010\u0005\u001a\u00020\u0006H\u0007¨\u0006\u0013"}, d2 = {"Lcom/sputnik/common/di/use_cases/invites/InvitesUseCaseModule;", "", "()V", "provideAcceptInviteUseCase", "Lcom/sputnik/common/di/use_cases/invites/AcceptInviteUseCase;", "repository", "Lcom/sputnik/domain/repositories/invites/IInvitesRepository;", "provideDeclineInviteUseCase", "Lcom/sputnik/common/di/use_cases/invites/DeclineInviteUseCase;", "provideDeleteFamilyInviteUseCase", "Lcom/sputnik/common/di/use_cases/invites/DeleteFamilyInviteUseCase;", "provideGetFamilyInvitesUseCase", "Lcom/sputnik/common/di/use_cases/invites/GetFamilyInvitesUseCase;", "provideGetInvitesUseCase", "Lcom/sputnik/common/di/use_cases/invites/GetInvitesUseCase;", "provideResendFamilyInviteUseCase", "Lcom/sputnik/common/di/use_cases/invites/ResendFamilyInviteUseCase;", "provideSendFamilyInviteUseCase", "Lcom/sputnik/common/di/use_cases/invites/SendFamilyInviteUseCase;", "common_release"}, k = 1, mv = {1, 9, 0}, xi = 48)
/* loaded from: classes3.dex */
public final class InvitesUseCaseModule {
    public final GetInvitesUseCase provideGetInvitesUseCase(IInvitesRepository repository) {
        Intrinsics.checkNotNullParameter(repository, "repository");
        return new GetInvitesUseCase(repository);
    }

    public final AcceptInviteUseCase provideAcceptInviteUseCase(IInvitesRepository repository) {
        Intrinsics.checkNotNullParameter(repository, "repository");
        return new AcceptInviteUseCase(repository);
    }

    public final DeclineInviteUseCase provideDeclineInviteUseCase(IInvitesRepository repository) {
        Intrinsics.checkNotNullParameter(repository, "repository");
        return new DeclineInviteUseCase(repository);
    }

    public final GetFamilyInvitesUseCase provideGetFamilyInvitesUseCase(IInvitesRepository repository) {
        Intrinsics.checkNotNullParameter(repository, "repository");
        return new GetFamilyInvitesUseCase(repository);
    }

    public final SendFamilyInviteUseCase provideSendFamilyInviteUseCase(IInvitesRepository repository) {
        Intrinsics.checkNotNullParameter(repository, "repository");
        return new SendFamilyInviteUseCase(repository);
    }

    public final ResendFamilyInviteUseCase provideResendFamilyInviteUseCase(IInvitesRepository repository) {
        Intrinsics.checkNotNullParameter(repository, "repository");
        return new ResendFamilyInviteUseCase(repository);
    }

    public final DeleteFamilyInviteUseCase provideDeleteFamilyInviteUseCase(IInvitesRepository repository) {
        Intrinsics.checkNotNullParameter(repository, "repository");
        return new DeleteFamilyInviteUseCase(repository);
    }
}

package com.sputnik.common.di.use_cases.invites;

import com.sputnik.domain.common.Resource;
import com.sputnik.domain.entities.invites.DomainFamilyInvite;
import com.sputnik.domain.repositories.invites.IInvitesRepository;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import kotlinx.coroutines.flow.Flow;

/* compiled from: SendFamilyInviteUseCase.kt */
@Metadata(d1 = {"\u0000,\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u000e\n\u0000\u0018\u00002\u00020\u0001B\r\u0012\u0006\u0010\u0002\u001a\u00020\u0003¢\u0006\u0002\u0010\u0004J%\u0010\u0005\u001a\u000e\u0012\n\u0012\b\u0012\u0004\u0012\u00020\b0\u00070\u00062\u0006\u0010\t\u001a\u00020\n2\u0006\u0010\u000b\u001a\u00020\fH\u0086\u0002R\u000e\u0010\u0002\u001a\u00020\u0003X\u0082\u0004¢\u0006\u0002\n\u0000¨\u0006\r"}, d2 = {"Lcom/sputnik/common/di/use_cases/invites/SendFamilyInviteUseCase;", "", "repository", "Lcom/sputnik/domain/repositories/invites/IInvitesRepository;", "(Lcom/sputnik/domain/repositories/invites/IInvitesRepository;)V", "invoke", "Lkotlinx/coroutines/flow/Flow;", "Lcom/sputnik/domain/common/Resource;", "Lcom/sputnik/domain/entities/invites/DomainFamilyInvite;", "addressId", "", "phone", "", "common_release"}, k = 1, mv = {1, 9, 0}, xi = 48)
/* loaded from: classes3.dex */
public final class SendFamilyInviteUseCase {
    private final IInvitesRepository repository;

    public SendFamilyInviteUseCase(IInvitesRepository repository) {
        Intrinsics.checkNotNullParameter(repository, "repository");
        this.repository = repository;
    }

    public final Flow<Resource<DomainFamilyInvite>> invoke(int addressId, String phone) {
        Intrinsics.checkNotNullParameter(phone, "phone");
        return this.repository.sendFamilyInvite(addressId, phone);
    }
}

package com.sputnik.domain.repositories.invites;

import com.sputnik.domain.common.Resource;
import com.sputnik.domain.entities.invites.DomainFamilyInvite;
import com.sputnik.domain.entities.invites.DomainFamilyInvites;
import com.sputnik.domain.entities.invites.DomainInvite;
import java.util.List;
import kotlin.Metadata;
import kotlinx.coroutines.flow.Flow;

/* compiled from: IInvitesRepository.kt */
@Metadata(d1 = {"\u0000:\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010 \n\u0002\b\b\bf\u0018\u00002\u00020\u0001J$\u0010\u0002\u001a\u000e\u0012\n\u0012\b\u0012\u0004\u0012\u00020\u00050\u00040\u00032\u0006\u0010\u0006\u001a\u00020\u00072\u0006\u0010\b\u001a\u00020\u0007H&J$\u0010\t\u001a\u000e\u0012\n\u0012\b\u0012\u0004\u0012\u00020\u00050\u00040\u00032\u0006\u0010\u0006\u001a\u00020\u00072\u0006\u0010\b\u001a\u00020\u0007H&J$\u0010\n\u001a\u000e\u0012\n\u0012\b\u0012\u0004\u0012\u00020\u000b0\u00040\u00032\u0006\u0010\f\u001a\u00020\r2\u0006\u0010\u0006\u001a\u00020\u0007H&J\u001c\u0010\u000e\u001a\u000e\u0012\n\u0012\b\u0012\u0004\u0012\u00020\u000f0\u00040\u00032\u0006\u0010\f\u001a\u00020\rH&J:\u0010\u0010\u001a\u0014\u0012\u0010\u0012\u000e\u0012\n\u0012\b\u0012\u0004\u0012\u00020\u00050\u00110\u00040\u00032\u0006\u0010\u0012\u001a\u00020\r2\u0006\u0010\u0013\u001a\u00020\u00072\u0006\u0010\u0014\u001a\u00020\u00072\u0006\u0010\u0015\u001a\u00020\u0007H&J$\u0010\u0016\u001a\u000e\u0012\n\u0012\b\u0012\u0004\u0012\u00020\u000b0\u00040\u00032\u0006\u0010\f\u001a\u00020\r2\u0006\u0010\u0006\u001a\u00020\u0007H&J$\u0010\u0017\u001a\u000e\u0012\n\u0012\b\u0012\u0004\u0012\u00020\u000b0\u00040\u00032\u0006\u0010\f\u001a\u00020\r2\u0006\u0010\u0018\u001a\u00020\u0007H&¨\u0006\u0019"}, d2 = {"Lcom/sputnik/domain/repositories/invites/IInvitesRepository;", "", "acceptInvite", "Lkotlinx/coroutines/flow/Flow;", "Lcom/sputnik/domain/common/Resource;", "Lcom/sputnik/domain/entities/invites/DomainInvite;", "id", "", "source", "declineInvite", "deleteFamilyInvite", "Lcom/sputnik/domain/entities/invites/DomainFamilyInvite;", "addressId", "", "getFamilyInvites", "Lcom/sputnik/domain/entities/invites/DomainFamilyInvites;", "getInvites", "", "version", "platform", "app", "locale", "resendFamilyInvite", "sendFamilyInvite", "phone", "domain"}, k = 1, mv = {1, 9, 0}, xi = 48)
/* loaded from: classes3.dex */
public interface IInvitesRepository {
    Flow<Resource<DomainInvite>> acceptInvite(String id, String source);

    Flow<Resource<DomainInvite>> declineInvite(String id, String source);

    Flow<Resource<DomainFamilyInvite>> deleteFamilyInvite(int addressId, String id);

    Flow<Resource<DomainFamilyInvites>> getFamilyInvites(int addressId);

    Flow<Resource<List<DomainInvite>>> getInvites(int version, String platform, String app, String locale);

    Flow<Resource<DomainFamilyInvite>> resendFamilyInvite(int addressId, String id);

    Flow<Resource<DomainFamilyInvite>> sendFamilyInvite(int addressId, String phone);
}

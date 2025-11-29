package com.sputnik.data.mappers.invites;

import com.sputnik.data.entities.invites.DataFamilyInvite;
import com.sputnik.data.entities.invites.DataFamilyInvites;
import com.sputnik.domain.common.Mapper;
import com.sputnik.domain.entities.invites.DomainFamilyInvite;
import com.sputnik.domain.entities.invites.DomainFamilyInvites;
import java.util.ArrayList;
import java.util.List;
import kotlin.Metadata;
import kotlin.collections.CollectionsKt;
import kotlin.jvm.internal.Intrinsics;

/* compiled from: DataFamilyInvitesToDomainFamilyInvitesMapper.kt */
@Metadata(d1 = {"\u0000\u0014\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0004\u0018\u00002\u000e\u0012\u0004\u0012\u00020\u0002\u0012\u0004\u0012\u00020\u00030\u0001B\u0007\b\u0007¢\u0006\u0002\u0010\u0004J\u0010\u0010\u0005\u001a\u00020\u00032\u0006\u0010\u0006\u001a\u00020\u0002H\u0016¨\u0006\u0007"}, d2 = {"Lcom/sputnik/data/mappers/invites/DataFamilyInvitesToDomainFamilyInvitesMapper;", "Lcom/sputnik/domain/common/Mapper;", "Lcom/sputnik/data/entities/invites/DataFamilyInvites;", "Lcom/sputnik/domain/entities/invites/DomainFamilyInvites;", "()V", "map", "input", "data_release"}, k = 1, mv = {1, 9, 0}, xi = 48)
/* loaded from: classes3.dex */
public final class DataFamilyInvitesToDomainFamilyInvitesMapper implements Mapper<DataFamilyInvites, DomainFamilyInvites> {
    @Override // com.sputnik.domain.common.Mapper
    public DomainFamilyInvites map(DataFamilyInvites input) {
        List listEmptyList;
        DataFamilyInvites.DataInviteLimits inviteLimits;
        DataFamilyInvites.DataInviteLimits inviteLimits2;
        Intrinsics.checkNotNullParameter(input, "input");
        List<DataFamilyInvite> invites = input.getInvites();
        if (invites == null) {
            listEmptyList = CollectionsKt.emptyList();
        } else {
            listEmptyList = new ArrayList();
            for (DataFamilyInvite dataFamilyInvite : invites) {
                listEmptyList.add(new DomainFamilyInvite(dataFamilyInvite.getId(), dataFamilyInvite.getPhone(), dataFamilyInvite.getState(), dataFamilyInvite.getFlatUuid(), dataFamilyInvite.getFlatNumber(), dataFamilyInvite.getFullAddress(), dataFamilyInvite.getCreatedAt(), dataFamilyInvite.getUpdatedAt()));
            }
        }
        DataFamilyInvites.DataMeta meta = input.getMeta();
        Integer used = null;
        Integer total = (meta == null || (inviteLimits2 = meta.getInviteLimits()) == null) ? null : inviteLimits2.getTotal();
        DataFamilyInvites.DataMeta meta2 = input.getMeta();
        if (meta2 != null && (inviteLimits = meta2.getInviteLimits()) != null) {
            used = inviteLimits.getUsed();
        }
        return new DomainFamilyInvites(listEmptyList, new DomainFamilyInvites.DomainMeta(new DomainFamilyInvites.DomainInviteLimits(total, used)));
    }
}

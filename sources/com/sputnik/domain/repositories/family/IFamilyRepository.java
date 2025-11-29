package com.sputnik.domain.repositories.family;

import com.sputnik.domain.common.Resource;
import com.sputnik.domain.entities.family.DomainFamily;
import java.util.List;
import kotlin.Metadata;
import kotlin.Unit;
import kotlinx.coroutines.flow.Flow;

/* compiled from: IFamilyRepository.kt */
@Metadata(d1 = {"\u0000,\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u0002\n\u0000\n\u0002\u0010\b\n\u0002\b\u0002\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0002\b\u0002\bf\u0018\u00002\u00020\u0001J$\u0010\u0002\u001a\u000e\u0012\n\u0012\b\u0012\u0004\u0012\u00020\u00050\u00040\u00032\u0006\u0010\u0006\u001a\u00020\u00072\u0006\u0010\b\u001a\u00020\u0007H&J\"\u0010\t\u001a\u0014\u0012\u0010\u0012\u000e\u0012\n\u0012\b\u0012\u0004\u0012\u00020\u000b0\n0\u00040\u00032\u0006\u0010\u0006\u001a\u00020\u0007H&J$\u0010\f\u001a\u000e\u0012\n\u0012\b\u0012\u0004\u0012\u00020\u00050\u00040\u00032\u0006\u0010\u0006\u001a\u00020\u00072\u0006\u0010\b\u001a\u00020\u0007H&¨\u0006\r"}, d2 = {"Lcom/sputnik/domain/repositories/family/IFamilyRepository;", "", "deleteFromFamily", "Lkotlinx/coroutines/flow/Flow;", "Lcom/sputnik/domain/common/Resource;", "", "addressId", "", "id", "getFamily", "", "Lcom/sputnik/domain/entities/family/DomainFamily;", "makeAdmin", "domain"}, k = 1, mv = {1, 9, 0}, xi = 48)
/* loaded from: classes3.dex */
public interface IFamilyRepository {
    Flow<Resource<Unit>> deleteFromFamily(int addressId, int id);

    Flow<Resource<List<DomainFamily>>> getFamily(int addressId);

    Flow<Resource<Unit>> makeAdmin(int addressId, int id);
}

package com.sputnik.domain.repositories.digital_keys;

import com.sputnik.domain.common.Resource;
import com.sputnik.domain.entities.digital_keys.DomainDigitalKey;
import com.sputnik.domain.entities.digital_keys.TypeDigitalKey;
import java.util.List;
import kotlin.Metadata;
import kotlinx.coroutines.flow.Flow;

/* compiled from: IDigitalKeysRepository.kt */
@Metadata(d1 = {"\u00002\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u000e\n\u0002\b\u0004\bf\u0018\u00002\u00020\u0001J)\u0010\b\u001a\u0014\u0012\u0010\u0012\u000e\u0012\n\u0012\b\u0012\u0004\u0012\u00020\u00070\u00060\u00050\u00042\u0006\u0010\u0003\u001a\u00020\u0002H&¢\u0006\u0004\b\b\u0010\tJ+\u0010\f\u001a\u000e\u0012\n\u0012\b\u0012\u0004\u0012\u00020\u00070\u00050\u00042\u0006\u0010\u0003\u001a\u00020\u00022\u0006\u0010\u000b\u001a\u00020\nH&¢\u0006\u0004\b\f\u0010\rJ+\u0010\u0010\u001a\u000e\u0012\n\u0012\b\u0012\u0004\u0012\u00020\u00070\u00050\u00042\u0006\u0010\u0003\u001a\u00020\u00022\u0006\u0010\u000f\u001a\u00020\u000eH&¢\u0006\u0004\b\u0010\u0010\u0011¨\u0006\u0012"}, d2 = {"Lcom/sputnik/domain/repositories/digital_keys/IDigitalKeysRepository;", "", "", "addressId", "Lkotlinx/coroutines/flow/Flow;", "Lcom/sputnik/domain/common/Resource;", "", "Lcom/sputnik/domain/entities/digital_keys/DomainDigitalKey;", "getDigitalKeys", "(I)Lkotlinx/coroutines/flow/Flow;", "Lcom/sputnik/domain/entities/digital_keys/TypeDigitalKey;", "type", "setDigitalKey", "(ILcom/sputnik/domain/entities/digital_keys/TypeDigitalKey;)Lkotlinx/coroutines/flow/Flow;", "", "uuid", "deleteDigitalKey", "(ILjava/lang/String;)Lkotlinx/coroutines/flow/Flow;", "domain"}, k = 1, mv = {1, 9, 0}, xi = 48)
/* loaded from: classes3.dex */
public interface IDigitalKeysRepository {
    Flow<Resource<DomainDigitalKey>> deleteDigitalKey(int addressId, String uuid);

    Flow<Resource<List<DomainDigitalKey>>> getDigitalKeys(int addressId);

    Flow<Resource<DomainDigitalKey>> setDigitalKey(int addressId, TypeDigitalKey type);
}

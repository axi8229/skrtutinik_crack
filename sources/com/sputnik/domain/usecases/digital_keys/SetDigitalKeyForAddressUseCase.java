package com.sputnik.domain.usecases.digital_keys;

import com.sputnik.domain.common.Resource;
import com.sputnik.domain.entities.digital_keys.DomainDigitalKey;
import com.sputnik.domain.entities.digital_keys.TypeDigitalKey;
import com.sputnik.domain.repositories.digital_keys.IDigitalKeysRepository;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import kotlinx.coroutines.flow.Flow;

/* compiled from: SetDigitalKeyForAddressUseCase.kt */
@Metadata(d1 = {"\u0000,\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0018\u0002\n\u0000\u0018\u00002\u00020\u0001B\r\u0012\u0006\u0010\u0002\u001a\u00020\u0003¢\u0006\u0002\u0010\u0004J%\u0010\u0005\u001a\u000e\u0012\n\u0012\b\u0012\u0004\u0012\u00020\b0\u00070\u00062\u0006\u0010\t\u001a\u00020\n2\u0006\u0010\u000b\u001a\u00020\fH\u0086\u0002R\u000e\u0010\u0002\u001a\u00020\u0003X\u0082\u0004¢\u0006\u0002\n\u0000¨\u0006\r"}, d2 = {"Lcom/sputnik/domain/usecases/digital_keys/SetDigitalKeyForAddressUseCase;", "", "repository", "Lcom/sputnik/domain/repositories/digital_keys/IDigitalKeysRepository;", "(Lcom/sputnik/domain/repositories/digital_keys/IDigitalKeysRepository;)V", "invoke", "Lkotlinx/coroutines/flow/Flow;", "Lcom/sputnik/domain/common/Resource;", "Lcom/sputnik/domain/entities/digital_keys/DomainDigitalKey;", "addressId", "", "type", "Lcom/sputnik/domain/entities/digital_keys/TypeDigitalKey;", "domain"}, k = 1, mv = {1, 9, 0}, xi = 48)
/* loaded from: classes3.dex */
public final class SetDigitalKeyForAddressUseCase {
    private final IDigitalKeysRepository repository;

    public SetDigitalKeyForAddressUseCase(IDigitalKeysRepository repository) {
        Intrinsics.checkNotNullParameter(repository, "repository");
        this.repository = repository;
    }

    public final Flow<Resource<DomainDigitalKey>> invoke(int addressId, TypeDigitalKey type) {
        Intrinsics.checkNotNullParameter(type, "type");
        return this.repository.setDigitalKey(addressId, type);
    }
}

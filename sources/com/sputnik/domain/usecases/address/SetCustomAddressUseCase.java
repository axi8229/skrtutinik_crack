package com.sputnik.domain.usecases.address;

import com.sputnik.domain.common.Resource;
import com.sputnik.domain.entities.address.DomainCustomAddress;
import com.sputnik.domain.repositories.address.IAddressRepository;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import kotlinx.coroutines.flow.Flow;

/* compiled from: SetCustomAddressUseCase.kt */
@Metadata(d1 = {"\u0000(\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0004\u0018\u00002\u00020\u0001B\r\u0012\u0006\u0010\u0002\u001a\u00020\u0003¢\u0006\u0002\u0010\u0004J=\u0010\u0005\u001a\u000e\u0012\n\u0012\b\u0012\u0004\u0012\u00020\b0\u00070\u00062\b\u0010\t\u001a\u0004\u0018\u00010\n2\b\u0010\u000b\u001a\u0004\u0018\u00010\n2\b\u0010\f\u001a\u0004\u0018\u00010\n2\b\u0010\r\u001a\u0004\u0018\u00010\nH\u0086\u0002R\u000e\u0010\u0002\u001a\u00020\u0003X\u0082\u0004¢\u0006\u0002\n\u0000¨\u0006\u000e"}, d2 = {"Lcom/sputnik/domain/usecases/address/SetCustomAddressUseCase;", "", "repository", "Lcom/sputnik/domain/repositories/address/IAddressRepository;", "(Lcom/sputnik/domain/repositories/address/IAddressRepository;)V", "invoke", "Lkotlinx/coroutines/flow/Flow;", "Lcom/sputnik/domain/common/Resource;", "Lcom/sputnik/domain/entities/address/DomainCustomAddress;", "city", "", "street", "house", "flat", "domain"}, k = 1, mv = {1, 9, 0}, xi = 48)
/* loaded from: classes3.dex */
public final class SetCustomAddressUseCase {
    private final IAddressRepository repository;

    public SetCustomAddressUseCase(IAddressRepository repository) {
        Intrinsics.checkNotNullParameter(repository, "repository");
        this.repository = repository;
    }

    public final Flow<Resource<DomainCustomAddress>> invoke(String city, String street, String house, String flat) {
        return this.repository.setCustomAddress(city, street, house, flat);
    }
}

package com.sputnik.data.repositories.address;

import com.sputnik.data.entities.address.DataCustomAddress;
import com.sputnik.data.mappers.address.DataCustomAddressToDomainCustomAddressMapper;
import com.sputnik.domain.entities.address.DomainCustomAddress;
import kotlin.Metadata;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.FunctionReferenceImpl;
import kotlin.jvm.internal.Intrinsics;

/* compiled from: AddressRepository.kt */
@Metadata(k = 3, mv = {1, 9, 0}, xi = 48)
/* loaded from: classes3.dex */
/* synthetic */ class AddressRepository$updateCustomAddress$2$1 extends FunctionReferenceImpl implements Function1<DataCustomAddress, DomainCustomAddress> {
    AddressRepository$updateCustomAddress$2$1(Object obj) {
        super(1, obj, DataCustomAddressToDomainCustomAddressMapper.class, "map", "map(Lcom/sputnik/data/entities/address/DataCustomAddress;)Lcom/sputnik/domain/entities/address/DomainCustomAddress;", 0);
    }

    @Override // kotlin.jvm.functions.Function1
    public final DomainCustomAddress invoke(DataCustomAddress p0) {
        Intrinsics.checkNotNullParameter(p0, "p0");
        return ((DataCustomAddressToDomainCustomAddressMapper) this.receiver).map(p0);
    }
}

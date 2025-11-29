package com.sputnik.data.repositories.keys;

import com.sputnik.data.entities.keys.DataPhysicalKey;
import com.sputnik.data.mappers.keys.DataPhysicalKeyToDomainPhysicalKeyMapper;
import com.sputnik.domain.entities.keys.DomainPhysicalKey;
import kotlin.Metadata;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.FunctionReferenceImpl;
import kotlin.jvm.internal.Intrinsics;

/* compiled from: PhysicalKeysRepository.kt */
@Metadata(k = 3, mv = {1, 9, 0}, xi = 48)
/* loaded from: classes3.dex */
/* synthetic */ class PhysicalKeysRepository$updateComment$2$1 extends FunctionReferenceImpl implements Function1<DataPhysicalKey, DomainPhysicalKey> {
    PhysicalKeysRepository$updateComment$2$1(Object obj) {
        super(1, obj, DataPhysicalKeyToDomainPhysicalKeyMapper.class, "map", "map(Lcom/sputnik/data/entities/keys/DataPhysicalKey;)Lcom/sputnik/domain/entities/keys/DomainPhysicalKey;", 0);
    }

    @Override // kotlin.jvm.functions.Function1
    public final DomainPhysicalKey invoke(DataPhysicalKey p0) {
        Intrinsics.checkNotNullParameter(p0, "p0");
        return ((DataPhysicalKeyToDomainPhysicalKeyMapper) this.receiver).map(p0);
    }
}

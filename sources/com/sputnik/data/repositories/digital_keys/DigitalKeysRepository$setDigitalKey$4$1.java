package com.sputnik.data.repositories.digital_keys;

import com.sputnik.data.entities.digital_keys.DataDigitalKey;
import com.sputnik.data.mappers.digital_keys.DataDigitalKeyToDomainDigitalKeyMapper;
import com.sputnik.domain.entities.digital_keys.DomainDigitalKey;
import kotlin.Metadata;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.FunctionReferenceImpl;
import kotlin.jvm.internal.Intrinsics;

/* compiled from: DigitalKeysRepository.kt */
@Metadata(k = 3, mv = {1, 9, 0}, xi = 48)
/* loaded from: classes3.dex */
/* synthetic */ class DigitalKeysRepository$setDigitalKey$4$1 extends FunctionReferenceImpl implements Function1<DataDigitalKey, DomainDigitalKey> {
    DigitalKeysRepository$setDigitalKey$4$1(Object obj) {
        super(1, obj, DataDigitalKeyToDomainDigitalKeyMapper.class, "map", "map(Lcom/sputnik/data/entities/digital_keys/DataDigitalKey;)Lcom/sputnik/domain/entities/digital_keys/DomainDigitalKey;", 0);
    }

    @Override // kotlin.jvm.functions.Function1
    public final DomainDigitalKey invoke(DataDigitalKey p0) {
        Intrinsics.checkNotNullParameter(p0, "p0");
        return ((DataDigitalKeyToDomainDigitalKeyMapper) this.receiver).map(p0);
    }
}

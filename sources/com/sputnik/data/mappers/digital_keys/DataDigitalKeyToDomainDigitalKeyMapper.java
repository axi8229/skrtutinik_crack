package com.sputnik.data.mappers.digital_keys;

import com.sputnik.data.entities.digital_keys.DataDigitalKey;
import com.sputnik.domain.common.Mapper;
import com.sputnik.domain.entities.digital_keys.DomainDigitalKey;
import com.sputnik.domain.utils.DateUtilsKt;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

/* compiled from: DataDigitalKeyToDomainDigitalKeyMapper.kt */
@Metadata(d1 = {"\u0000\u0014\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0004\u0018\u00002\u000e\u0012\u0004\u0012\u00020\u0002\u0012\u0004\u0012\u00020\u00030\u0001B\u0007\b\u0007¢\u0006\u0002\u0010\u0004J\u0010\u0010\u0005\u001a\u00020\u00032\u0006\u0010\u0006\u001a\u00020\u0002H\u0016¨\u0006\u0007"}, d2 = {"Lcom/sputnik/data/mappers/digital_keys/DataDigitalKeyToDomainDigitalKeyMapper;", "Lcom/sputnik/domain/common/Mapper;", "Lcom/sputnik/data/entities/digital_keys/DataDigitalKey;", "Lcom/sputnik/domain/entities/digital_keys/DomainDigitalKey;", "()V", "map", "input", "data_release"}, k = 1, mv = {1, 9, 0}, xi = 48)
/* loaded from: classes3.dex */
public final class DataDigitalKeyToDomainDigitalKeyMapper implements Mapper<DataDigitalKey, DomainDigitalKey> {
    @Override // com.sputnik.domain.common.Mapper
    public DomainDigitalKey map(DataDigitalKey input) {
        Intrinsics.checkNotNullParameter(input, "input");
        String uuid = input.getUuid();
        String value = input.getValue();
        String expTime = input.getExpTime();
        return new DomainDigitalKey(uuid, value, expTime != null ? Long.valueOf(DateUtilsKt.toNanoFormat(expTime)) : null, input.getType());
    }
}

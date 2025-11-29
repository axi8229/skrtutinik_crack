package com.sputnik.data.repositories.registration;

import com.sputnik.data.entities.entry.DataEntry;
import com.sputnik.data.mappers.entry.DataEntryToDomainEntryMapper;
import com.sputnik.domain.entities.entry.DomainEntry;
import kotlin.Metadata;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.FunctionReferenceImpl;
import kotlin.jvm.internal.Intrinsics;

/* compiled from: ConnectIntercomRepository.kt */
@Metadata(k = 3, mv = {1, 9, 0}, xi = 48)
/* loaded from: classes3.dex */
/* synthetic */ class ConnectIntercomRepository$loadEntry$2$1 extends FunctionReferenceImpl implements Function1<DataEntry, DomainEntry> {
    ConnectIntercomRepository$loadEntry$2$1(Object obj) {
        super(1, obj, DataEntryToDomainEntryMapper.class, "map", "map(Lcom/sputnik/data/entities/entry/DataEntry;)Lcom/sputnik/domain/entities/entry/DomainEntry;", 0);
    }

    @Override // kotlin.jvm.functions.Function1
    public final DomainEntry invoke(DataEntry p0) {
        Intrinsics.checkNotNullParameter(p0, "p0");
        return ((DataEntryToDomainEntryMapper) this.receiver).map(p0);
    }
}

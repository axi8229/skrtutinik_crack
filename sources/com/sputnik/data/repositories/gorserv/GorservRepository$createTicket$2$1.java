package com.sputnik.data.repositories.gorserv;

import com.sputnik.data.entities.gorserv.DataCreateTicketResponse;
import com.sputnik.data.mappers.gorserv.DataGorservCreateTicketToDomainGorservCreateTicketMapper;
import com.sputnik.domain.entities.gorserv.DomainGorservTicket;
import kotlin.Metadata;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.FunctionReferenceImpl;
import kotlin.jvm.internal.Intrinsics;

/* compiled from: GorservRepository.kt */
@Metadata(k = 3, mv = {1, 9, 0}, xi = 48)
/* loaded from: classes3.dex */
/* synthetic */ class GorservRepository$createTicket$2$1 extends FunctionReferenceImpl implements Function1<DataCreateTicketResponse, DomainGorservTicket> {
    GorservRepository$createTicket$2$1(Object obj) {
        super(1, obj, DataGorservCreateTicketToDomainGorservCreateTicketMapper.class, "map", "map(Lcom/sputnik/data/entities/gorserv/DataCreateTicketResponse;)Lcom/sputnik/domain/entities/gorserv/DomainGorservTicket;", 0);
    }

    @Override // kotlin.jvm.functions.Function1
    public final DomainGorservTicket invoke(DataCreateTicketResponse p0) {
        Intrinsics.checkNotNullParameter(p0, "p0");
        return ((DataGorservCreateTicketToDomainGorservCreateTicketMapper) this.receiver).map(p0);
    }
}

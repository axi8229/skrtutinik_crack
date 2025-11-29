package com.sputnik.data.repositories.card;

import com.sputnik.data.entities.card.DataPaymentState;
import com.sputnik.data.mappers.card.DataPaymentStateToDomainPaymentStateMapper;
import com.sputnik.domain.entities.card.DomainPaymentState;
import kotlin.Metadata;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.FunctionReferenceImpl;
import kotlin.jvm.internal.Intrinsics;

/* compiled from: CardRepository.kt */
@Metadata(k = 3, mv = {1, 9, 0}, xi = 48)
/* loaded from: classes3.dex */
/* synthetic */ class CardRepository$getLastCardPayment$2$1 extends FunctionReferenceImpl implements Function1<DataPaymentState, DomainPaymentState> {
    CardRepository$getLastCardPayment$2$1(Object obj) {
        super(1, obj, DataPaymentStateToDomainPaymentStateMapper.class, "map", "map(Lcom/sputnik/data/entities/card/DataPaymentState;)Lcom/sputnik/domain/entities/card/DomainPaymentState;", 0);
    }

    @Override // kotlin.jvm.functions.Function1
    public final DomainPaymentState invoke(DataPaymentState p0) {
        Intrinsics.checkNotNullParameter(p0, "p0");
        return ((DataPaymentStateToDomainPaymentStateMapper) this.receiver).map(p0);
    }
}

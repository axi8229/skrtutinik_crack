package com.sputnik.data.repositories.card;

import com.sputnik.data.entities.card.DataConfirmation;
import com.sputnik.data.mappers.card.DataConfirmationToDomainConfirmationMapper;
import com.sputnik.domain.entities.card.DomainConfirmation;
import kotlin.Metadata;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.FunctionReferenceImpl;
import kotlin.jvm.internal.Intrinsics;

/* compiled from: CardRepository.kt */
@Metadata(k = 3, mv = {1, 9, 0}, xi = 48)
/* loaded from: classes3.dex */
/* synthetic */ class CardRepository$addNewCard$2$1 extends FunctionReferenceImpl implements Function1<DataConfirmation, DomainConfirmation> {
    CardRepository$addNewCard$2$1(Object obj) {
        super(1, obj, DataConfirmationToDomainConfirmationMapper.class, "map", "map(Lcom/sputnik/data/entities/card/DataConfirmation;)Lcom/sputnik/domain/entities/card/DomainConfirmation;", 0);
    }

    @Override // kotlin.jvm.functions.Function1
    public final DomainConfirmation invoke(DataConfirmation p0) {
        Intrinsics.checkNotNullParameter(p0, "p0");
        return ((DataConfirmationToDomainConfirmationMapper) this.receiver).map(p0);
    }
}

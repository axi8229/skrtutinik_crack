package com.sputnik.data.repositories.subscription;

import com.sputnik.data.entities.market.subscription.DataSubscriptionStart;
import com.sputnik.data.mappers.market.subscription.DataSubscriptionStartToDomainSubscriptionStartMapper;
import com.sputnik.domain.entities.market.subscription.DomainSubscriptionStart;
import kotlin.Metadata;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.FunctionReferenceImpl;
import kotlin.jvm.internal.Intrinsics;

/* compiled from: SubscriptionRepository.kt */
@Metadata(k = 3, mv = {1, 9, 0}, xi = 48)
/* loaded from: classes3.dex */
/* synthetic */ class SubscriptionRepository$startSubscription$2$1 extends FunctionReferenceImpl implements Function1<DataSubscriptionStart, DomainSubscriptionStart> {
    SubscriptionRepository$startSubscription$2$1(Object obj) {
        super(1, obj, DataSubscriptionStartToDomainSubscriptionStartMapper.class, "map", "map(Lcom/sputnik/data/entities/market/subscription/DataSubscriptionStart;)Lcom/sputnik/domain/entities/market/subscription/DomainSubscriptionStart;", 0);
    }

    @Override // kotlin.jvm.functions.Function1
    public final DomainSubscriptionStart invoke(DataSubscriptionStart p0) {
        Intrinsics.checkNotNullParameter(p0, "p0");
        return ((DataSubscriptionStartToDomainSubscriptionStartMapper) this.receiver).map(p0);
    }
}

package com.sputnik.data.repositories.market;

import com.sputnik.data.entities.market.DataMarket;
import com.sputnik.domain.common.ListMapper;
import com.sputnik.domain.entities.market.DomainMarket;
import java.util.List;
import kotlin.Metadata;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.FunctionReferenceImpl;
import kotlin.jvm.internal.Intrinsics;

/* compiled from: MarketRepository.kt */
@Metadata(k = 3, mv = {1, 9, 0}, xi = 48)
/* loaded from: classes3.dex */
/* synthetic */ class MarketRepository$getMarket$2$1 extends FunctionReferenceImpl implements Function1<List<? extends DataMarket>, List<? extends DomainMarket>> {
    MarketRepository$getMarket$2$1(Object obj) {
        super(1, obj, ListMapper.class, "map", "map(Ljava/lang/Object;)Ljava/lang/Object;", 0);
    }

    @Override // kotlin.jvm.functions.Function1
    public /* bridge */ /* synthetic */ List<? extends DomainMarket> invoke(List<? extends DataMarket> list) {
        return invoke2((List<DataMarket>) list);
    }

    /* renamed from: invoke, reason: avoid collision after fix types in other method */
    public final List<DomainMarket> invoke2(List<DataMarket> p0) {
        Intrinsics.checkNotNullParameter(p0, "p0");
        return (List) ((ListMapper) this.receiver).map(p0);
    }
}

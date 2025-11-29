package com.sputnik.data.repositories.address;

import com.sputnik.data.entities.address.DataCustomAddress;
import com.sputnik.domain.common.ListMapper;
import com.sputnik.domain.entities.address.DomainCustomAddress;
import java.util.List;
import kotlin.Metadata;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.FunctionReferenceImpl;
import kotlin.jvm.internal.Intrinsics;

/* compiled from: AddressRepository.kt */
@Metadata(k = 3, mv = {1, 9, 0}, xi = 48)
/* loaded from: classes3.dex */
/* synthetic */ class AddressRepository$getCustomAddress$2$1 extends FunctionReferenceImpl implements Function1<List<? extends DataCustomAddress>, List<? extends DomainCustomAddress>> {
    AddressRepository$getCustomAddress$2$1(Object obj) {
        super(1, obj, ListMapper.class, "map", "map(Ljava/lang/Object;)Ljava/lang/Object;", 0);
    }

    @Override // kotlin.jvm.functions.Function1
    public /* bridge */ /* synthetic */ List<? extends DomainCustomAddress> invoke(List<? extends DataCustomAddress> list) {
        return invoke2((List<DataCustomAddress>) list);
    }

    /* renamed from: invoke, reason: avoid collision after fix types in other method */
    public final List<DomainCustomAddress> invoke2(List<DataCustomAddress> p0) {
        Intrinsics.checkNotNullParameter(p0, "p0");
        return (List) ((ListMapper) this.receiver).map(p0);
    }
}

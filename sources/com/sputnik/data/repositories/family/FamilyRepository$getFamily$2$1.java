package com.sputnik.data.repositories.family;

import com.sputnik.data.entities.family.DataFamily;
import com.sputnik.domain.common.ListMapper;
import com.sputnik.domain.entities.family.DomainFamily;
import java.util.List;
import kotlin.Metadata;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.FunctionReferenceImpl;
import kotlin.jvm.internal.Intrinsics;

/* compiled from: FamilyRepository.kt */
@Metadata(k = 3, mv = {1, 9, 0}, xi = 48)
/* loaded from: classes3.dex */
/* synthetic */ class FamilyRepository$getFamily$2$1 extends FunctionReferenceImpl implements Function1<List<? extends DataFamily>, List<? extends DomainFamily>> {
    FamilyRepository$getFamily$2$1(Object obj) {
        super(1, obj, ListMapper.class, "map", "map(Ljava/lang/Object;)Ljava/lang/Object;", 0);
    }

    @Override // kotlin.jvm.functions.Function1
    public /* bridge */ /* synthetic */ List<? extends DomainFamily> invoke(List<? extends DataFamily> list) {
        return invoke2((List<DataFamily>) list);
    }

    /* renamed from: invoke, reason: avoid collision after fix types in other method */
    public final List<DomainFamily> invoke2(List<DataFamily> p0) {
        Intrinsics.checkNotNullParameter(p0, "p0");
        return (List) ((ListMapper) this.receiver).map(p0);
    }
}

package com.sputnik.data.repositories.cameras;

import com.sputnik.data.entities.cameras.DataCamera;
import com.sputnik.domain.common.NullableInputListMapper;
import com.sputnik.domain.entities.cameras.DomainCamera;
import java.util.List;
import kotlin.Metadata;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.FunctionReferenceImpl;

/* compiled from: CamerasRepository.kt */
@Metadata(k = 3, mv = {1, 9, 0}, xi = 48)
/* loaded from: classes3.dex */
/* synthetic */ class CamerasRepository$getCamerasDemo$2$1 extends FunctionReferenceImpl implements Function1<List<? extends DataCamera>, List<? extends DomainCamera>> {
    CamerasRepository$getCamerasDemo$2$1(Object obj) {
        super(1, obj, NullableInputListMapper.class, "map", "map(Ljava/lang/Object;)Ljava/lang/Object;", 0);
    }

    @Override // kotlin.jvm.functions.Function1
    public /* bridge */ /* synthetic */ List<? extends DomainCamera> invoke(List<? extends DataCamera> list) {
        return invoke2((List<DataCamera>) list);
    }

    /* renamed from: invoke, reason: avoid collision after fix types in other method */
    public final List<DomainCamera> invoke2(List<DataCamera> list) {
        return (List) ((NullableInputListMapper) this.receiver).map(list);
    }
}

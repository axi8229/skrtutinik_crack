package com.sputnik.data.repositories.manage_cameras;

import com.sputnik.data.entities.cameras.DataCamerasOrder;
import com.sputnik.domain.common.NullableInputListMapper;
import com.sputnik.domain.entities.cameras.DomainCamerasOrder;
import java.util.List;
import kotlin.Metadata;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.FunctionReferenceImpl;

/* compiled from: ManageCamerasRepository.kt */
@Metadata(k = 3, mv = {1, 9, 0}, xi = 48)
/* loaded from: classes3.dex */
/* synthetic */ class ManageCamerasRepository$getCamerasPreferences$2$1 extends FunctionReferenceImpl implements Function1<List<? extends DataCamerasOrder>, List<? extends DomainCamerasOrder>> {
    ManageCamerasRepository$getCamerasPreferences$2$1(Object obj) {
        super(1, obj, NullableInputListMapper.class, "map", "map(Ljava/lang/Object;)Ljava/lang/Object;", 0);
    }

    @Override // kotlin.jvm.functions.Function1
    public /* bridge */ /* synthetic */ List<? extends DomainCamerasOrder> invoke(List<? extends DataCamerasOrder> list) {
        return invoke2((List<DataCamerasOrder>) list);
    }

    /* renamed from: invoke, reason: avoid collision after fix types in other method */
    public final List<DomainCamerasOrder> invoke2(List<DataCamerasOrder> list) {
        return (List) ((NullableInputListMapper) this.receiver).map(list);
    }
}

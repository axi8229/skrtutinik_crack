package com.sputnik.data.repositories.manage_cameras;

import com.sputnik.data.entities.cameras.DataCamerasOrder;
import com.sputnik.data.mappers.cameras.DataCamerasOrderToDomainCamerasOrderMapper;
import com.sputnik.domain.entities.cameras.DomainCamerasOrder;
import kotlin.Metadata;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.FunctionReferenceImpl;
import kotlin.jvm.internal.Intrinsics;

/* compiled from: ManageCamerasRepository.kt */
@Metadata(k = 3, mv = {1, 9, 0}, xi = 48)
/* loaded from: classes3.dex */
/* synthetic */ class ManageCamerasRepository$setCamerasOrder$2$1 extends FunctionReferenceImpl implements Function1<DataCamerasOrder, DomainCamerasOrder> {
    ManageCamerasRepository$setCamerasOrder$2$1(Object obj) {
        super(1, obj, DataCamerasOrderToDomainCamerasOrderMapper.class, "map", "map(Lcom/sputnik/data/entities/cameras/DataCamerasOrder;)Lcom/sputnik/domain/entities/cameras/DomainCamerasOrder;", 0);
    }

    @Override // kotlin.jvm.functions.Function1
    public final DomainCamerasOrder invoke(DataCamerasOrder p0) {
        Intrinsics.checkNotNullParameter(p0, "p0");
        return ((DataCamerasOrderToDomainCamerasOrderMapper) this.receiver).map(p0);
    }
}

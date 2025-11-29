package com.sputnik.data.repositories.cameras;

import com.sputnik.data.entities.cameras.DataCamera;
import com.sputnik.data.mappers.cameras.DataCameraToDomainCameraMapper;
import com.sputnik.domain.entities.cameras.DomainCamera;
import kotlin.Metadata;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.FunctionReferenceImpl;
import kotlin.jvm.internal.Intrinsics;

/* compiled from: CamerasRepository.kt */
@Metadata(k = 3, mv = {1, 9, 0}, xi = 48)
/* loaded from: classes3.dex */
/* synthetic */ class CamerasRepository$getCameraByIntercomUUID$2$1 extends FunctionReferenceImpl implements Function1<DataCamera, DomainCamera> {
    CamerasRepository$getCameraByIntercomUUID$2$1(Object obj) {
        super(1, obj, DataCameraToDomainCameraMapper.class, "map", "map(Lcom/sputnik/data/entities/cameras/DataCamera;)Lcom/sputnik/domain/entities/cameras/DomainCamera;", 0);
    }

    @Override // kotlin.jvm.functions.Function1
    public final DomainCamera invoke(DataCamera p0) {
        Intrinsics.checkNotNullParameter(p0, "p0");
        return ((DataCameraToDomainCameraMapper) this.receiver).map(p0);
    }
}

package com.sputnik.data.repositories.manage_cameras;

import com.sputnik.data.entities.cameras.DataCameraObject;
import com.sputnik.data.mappers.cameras.DataCameraObjectToDomainCameraObjectMapper;
import com.sputnik.domain.entities.cameras.DomainCameraObject;
import kotlin.Metadata;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.FunctionReferenceImpl;
import kotlin.jvm.internal.Intrinsics;

/* compiled from: ManageCamerasRepository.kt */
@Metadata(k = 3, mv = {1, 9, 0}, xi = 48)
/* loaded from: classes3.dex */
/* synthetic */ class ManageCamerasRepository$setCameraParams$2$1 extends FunctionReferenceImpl implements Function1<DataCameraObject, DomainCameraObject> {
    ManageCamerasRepository$setCameraParams$2$1(Object obj) {
        super(1, obj, DataCameraObjectToDomainCameraObjectMapper.class, "map", "map(Lcom/sputnik/data/entities/cameras/DataCameraObject;)Lcom/sputnik/domain/entities/cameras/DomainCameraObject;", 0);
    }

    @Override // kotlin.jvm.functions.Function1
    public final DomainCameraObject invoke(DataCameraObject p0) {
        Intrinsics.checkNotNullParameter(p0, "p0");
        return ((DataCameraObjectToDomainCameraObjectMapper) this.receiver).map(p0);
    }
}

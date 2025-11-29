package com.sputnik.data.mappers.cameras;

import com.sputnik.data.entities.cameras.DataCameraObject;
import com.sputnik.data.entities.cameras.DataCamerasOrder;
import com.sputnik.domain.common.Mapper;
import com.sputnik.domain.entities.cameras.DomainCameraObject;
import com.sputnik.domain.entities.cameras.DomainCamerasOrder;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import kotlin.Metadata;
import kotlin.collections.CollectionsKt;
import kotlin.jvm.internal.Intrinsics;

/* compiled from: DataCamerasOrderToDomainCamerasOrderMapper.kt */
@Metadata(d1 = {"\u0000\u001a\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0004\u0018\u00002\u000e\u0012\u0004\u0012\u00020\u0002\u0012\u0004\u0012\u00020\u00030\u0001B\u000f\b\u0007\u0012\u0006\u0010\u0004\u001a\u00020\u0005¢\u0006\u0002\u0010\u0006J\u0010\u0010\u0007\u001a\u00020\u00032\u0006\u0010\b\u001a\u00020\u0002H\u0016R\u000e\u0010\u0004\u001a\u00020\u0005X\u0082\u0004¢\u0006\u0002\n\u0000¨\u0006\t"}, d2 = {"Lcom/sputnik/data/mappers/cameras/DataCamerasOrderToDomainCamerasOrderMapper;", "Lcom/sputnik/domain/common/Mapper;", "Lcom/sputnik/data/entities/cameras/DataCamerasOrder;", "Lcom/sputnik/domain/entities/cameras/DomainCamerasOrder;", "additionalMapper", "Lcom/sputnik/data/mappers/cameras/DataCameraObjectToDomainCameraObjectMapper;", "(Lcom/sputnik/data/mappers/cameras/DataCameraObjectToDomainCameraObjectMapper;)V", "map", "input", "data_release"}, k = 1, mv = {1, 9, 0}, xi = 48)
/* loaded from: classes3.dex */
public final class DataCamerasOrderToDomainCamerasOrderMapper implements Mapper<DataCamerasOrder, DomainCamerasOrder> {
    private final DataCameraObjectToDomainCameraObjectMapper additionalMapper;

    public DataCamerasOrderToDomainCamerasOrderMapper(DataCameraObjectToDomainCameraObjectMapper additionalMapper) {
        Intrinsics.checkNotNullParameter(additionalMapper, "additionalMapper");
        this.additionalMapper = additionalMapper;
    }

    @Override // com.sputnik.domain.common.Mapper
    public DomainCamerasOrder map(DataCamerasOrder input) {
        List listEmptyList;
        Intrinsics.checkNotNullParameter(input, "input");
        Integer addressId = input.getAddressId();
        Map<String, DataCameraObject> cameras = input.getCameras();
        if (cameras == null) {
            listEmptyList = CollectionsKt.emptyList();
        } else {
            listEmptyList = new ArrayList(cameras.size());
            for (Map.Entry<String, DataCameraObject> entry : cameras.entrySet()) {
                listEmptyList.add(DomainCameraObject.copy$default(this.additionalMapper.map(entry.getValue()), entry.getKey(), null, null, null, null, null, 62, null));
            }
        }
        return new DomainCamerasOrder(addressId, listEmptyList, input.getCallEnabled());
    }
}

package com.sputnik.data.mappers.cameras;

import com.sputnik.data.entities.cameras.DataCamerasOrder;
import com.sputnik.domain.common.Mapper;
import com.sputnik.domain.entities.cameras.DomainCameraObject;
import com.sputnik.domain.entities.cameras.DomainCamerasOrder;
import java.util.LinkedHashMap;
import java.util.List;
import kotlin.Metadata;
import kotlin.collections.CollectionsKt;
import kotlin.collections.MapsKt;
import kotlin.jvm.internal.Intrinsics;
import kotlin.ranges.RangesKt;

/* compiled from: DomainCamerasOrderToDataCamerasOrderMapper.kt */
@Metadata(d1 = {"\u0000\u001a\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0004\u0018\u00002\u000e\u0012\u0004\u0012\u00020\u0002\u0012\u0004\u0012\u00020\u00030\u0001B\u000f\b\u0007\u0012\u0006\u0010\u0004\u001a\u00020\u0005¢\u0006\u0002\u0010\u0006J\u0010\u0010\u0007\u001a\u00020\u00032\u0006\u0010\b\u001a\u00020\u0002H\u0016R\u000e\u0010\u0004\u001a\u00020\u0005X\u0082\u0004¢\u0006\u0002\n\u0000¨\u0006\t"}, d2 = {"Lcom/sputnik/data/mappers/cameras/DomainCamerasOrderToDataCamerasOrderMapper;", "Lcom/sputnik/domain/common/Mapper;", "Lcom/sputnik/domain/entities/cameras/DomainCamerasOrder;", "Lcom/sputnik/data/entities/cameras/DataCamerasOrder;", "additionalMapper", "Lcom/sputnik/data/mappers/cameras/DomainCameraObjectToDataCameraObjectMapper;", "(Lcom/sputnik/data/mappers/cameras/DomainCameraObjectToDataCameraObjectMapper;)V", "map", "input", "data_release"}, k = 1, mv = {1, 9, 0}, xi = 48)
/* loaded from: classes3.dex */
public final class DomainCamerasOrderToDataCamerasOrderMapper implements Mapper<DomainCamerasOrder, DataCamerasOrder> {
    private final DomainCameraObjectToDataCameraObjectMapper additionalMapper;

    public DomainCamerasOrderToDataCamerasOrderMapper(DomainCameraObjectToDataCameraObjectMapper additionalMapper) {
        Intrinsics.checkNotNullParameter(additionalMapper, "additionalMapper");
        this.additionalMapper = additionalMapper;
    }

    @Override // com.sputnik.domain.common.Mapper
    public DataCamerasOrder map(DomainCamerasOrder input) {
        LinkedHashMap linkedHashMap;
        Intrinsics.checkNotNullParameter(input, "input");
        Integer addressId = input.getAddressId();
        List<DomainCameraObject> cameras = input.getCameras();
        if (cameras != null) {
            List<DomainCameraObject> list = cameras;
            linkedHashMap = new LinkedHashMap(RangesKt.coerceAtLeast(MapsKt.mapCapacity(CollectionsKt.collectionSizeOrDefault(list, 10)), 16));
            for (DomainCameraObject domainCameraObject : list) {
                String uuid = domainCameraObject.getUuid();
                Intrinsics.checkNotNull(uuid);
                linkedHashMap.put(uuid, this.additionalMapper.map(domainCameraObject).getCamera());
            }
        } else {
            linkedHashMap = null;
        }
        return new DataCamerasOrder(addressId, input.getCallEnabled(), linkedHashMap);
    }
}

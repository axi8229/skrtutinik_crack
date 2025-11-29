package sputnik.axmor.com.sputnik.mappers.cameras;

import com.sputnik.common.entities.camera.CameraObject;
import com.sputnik.domain.common.Mapper;
import com.sputnik.domain.entities.cameras.DomainCamerasOrder;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import kotlin.Metadata;
import kotlin.collections.CollectionsKt;
import kotlin.jvm.internal.Intrinsics;
import sputnik.axmor.com.sputnik.entities.cameras.CamerasOrder;

/* compiled from: CamerasOrderToDomainCamerasOrderMapper.kt */
@Metadata(d1 = {"\u0000\u001a\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0004\u0018\u00002\u000e\u0012\u0004\u0012\u00020\u0002\u0012\u0004\u0012\u00020\u00030\u0001B\u000f\b\u0007\u0012\u0006\u0010\u0004\u001a\u00020\u0005¢\u0006\u0002\u0010\u0006J\u0010\u0010\u0007\u001a\u00020\u00032\u0006\u0010\b\u001a\u00020\u0002H\u0016R\u000e\u0010\u0004\u001a\u00020\u0005X\u0082\u0004¢\u0006\u0002\n\u0000¨\u0006\t"}, d2 = {"Lsputnik/axmor/com/sputnik/mappers/cameras/CamerasOrderToDomainCamerasOrderMapper;", "Lcom/sputnik/domain/common/Mapper;", "Lsputnik/axmor/com/sputnik/entities/cameras/CamerasOrder;", "Lcom/sputnik/domain/entities/cameras/DomainCamerasOrder;", "mapper", "Lsputnik/axmor/com/sputnik/mappers/cameras/CameraObjectToDomainCameraObjectMapper;", "(Lsputnik/axmor/com/sputnik/mappers/cameras/CameraObjectToDomainCameraObjectMapper;)V", "map", "input", "app_huaweiRelease"}, k = 1, mv = {1, 9, 0}, xi = 48)
/* loaded from: classes5.dex */
public final class CamerasOrderToDomainCamerasOrderMapper implements Mapper<CamerasOrder, DomainCamerasOrder> {
    private final CameraObjectToDomainCameraObjectMapper mapper;

    public CamerasOrderToDomainCamerasOrderMapper(CameraObjectToDomainCameraObjectMapper mapper) {
        Intrinsics.checkNotNullParameter(mapper, "mapper");
        this.mapper = mapper;
    }

    @Override // com.sputnik.domain.common.Mapper
    public DomainCamerasOrder map(CamerasOrder input) {
        List listEmptyList;
        Intrinsics.checkNotNullParameter(input, "input");
        List<CameraObject> cameras = input.getCameras();
        if (cameras == null) {
            listEmptyList = CollectionsKt.emptyList();
        } else {
            List<CameraObject> list = cameras;
            CameraObjectToDomainCameraObjectMapper cameraObjectToDomainCameraObjectMapper = this.mapper;
            listEmptyList = new ArrayList(CollectionsKt.collectionSizeOrDefault(list, 10));
            Iterator<T> it = list.iterator();
            while (it.hasNext()) {
                listEmptyList.add(cameraObjectToDomainCameraObjectMapper.map((CameraObject) it.next()));
            }
        }
        return new DomainCamerasOrder(input.getAddressId(), listEmptyList, input.getCallEnabled());
    }
}

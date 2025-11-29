package com.sputnik.domain.repositories.cameras;

import com.sputnik.domain.common.Resource;
import com.sputnik.domain.entities.cameras.DomainCamera;
import com.sputnik.domain.entities.door.OpenDoorProducers;
import java.util.List;
import kotlin.Metadata;
import kotlin.Unit;
import kotlinx.coroutines.flow.Flow;

/* compiled from: ICamerasRepository.kt */
@Metadata(d1 = {"\u0000D\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0002\n\u0002\u0010 \n\u0000\n\u0002\u0010\b\n\u0002\b\u0004\n\u0002\u0010\u0002\n\u0002\b\u0002\n\u0002\u0010\u000b\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\bf\u0018\u00002\u00020\u0001J$\u0010\u0002\u001a\u000e\u0012\n\u0012\b\u0012\u0004\u0012\u00020\u00050\u00040\u00032\u0006\u0010\u0006\u001a\u00020\u00072\u0006\u0010\b\u001a\u00020\u0007H&J6\u0010\t\u001a\u0014\u0012\u0010\u0012\u000e\u0012\n\u0012\b\u0012\u0004\u0012\u00020\u00050\n0\u00040\u00032\u0006\u0010\u000b\u001a\u00020\f2\b\u0010\r\u001a\u0004\u0018\u00010\u00072\b\u0010\u000e\u001a\u0004\u0018\u00010\u0007H&J\u001a\u0010\u000f\u001a\u0014\u0012\u0010\u0012\u000e\u0012\n\u0012\b\u0012\u0004\u0012\u00020\u00050\n0\u00040\u0003H&J:\u0010\u0010\u001a\u000e\u0012\n\u0012\b\u0012\u0004\u0012\u00020\u00110\u00040\u00032\u0006\u0010\u0012\u001a\u00020\u00072\b\b\u0002\u0010\u0013\u001a\u00020\u00142\u0006\u0010\u0015\u001a\u00020\u00162\n\b\u0002\u0010\u000b\u001a\u0004\u0018\u00010\u0007H&J&\u0010\u0017\u001a\u000e\u0012\n\u0012\b\u0012\u0004\u0012\u00020\u00110\u00040\u00032\u0006\u0010\u0012\u001a\u00020\u00072\b\b\u0002\u0010\u0013\u001a\u00020\u0014H&¨\u0006\u0018"}, d2 = {"Lcom/sputnik/domain/repositories/cameras/ICamerasRepository;", "", "getCameraByIntercomUUID", "Lkotlinx/coroutines/flow/Flow;", "Lcom/sputnik/domain/common/Resource;", "Lcom/sputnik/domain/entities/cameras/DomainCamera;", "intercomUUID", "", "flatUUID", "getCameras", "", "addressId", "", "list", "order", "getCamerasDemo", "openDoor", "", "uuid", "isWidget", "", "producer", "Lcom/sputnik/domain/entities/door/OpenDoorProducers;", "openSecondDoor", "domain"}, k = 1, mv = {1, 9, 0}, xi = 48)
/* loaded from: classes3.dex */
public interface ICamerasRepository {
    Flow<Resource<DomainCamera>> getCameraByIntercomUUID(String intercomUUID, String flatUUID);

    Flow<Resource<List<DomainCamera>>> getCameras(int addressId, String list, String order);

    Flow<Resource<List<DomainCamera>>> getCamerasDemo();

    Flow<Resource<Unit>> openDoor(String uuid, boolean isWidget, OpenDoorProducers producer, String addressId);

    Flow<Resource<Unit>> openSecondDoor(String uuid, boolean isWidget);

    /* compiled from: ICamerasRepository.kt */
    @Metadata(k = 3, mv = {1, 9, 0}, xi = 48)
    public static final class DefaultImpls {
        public static /* synthetic */ Flow openDoor$default(ICamerasRepository iCamerasRepository, String str, boolean z, OpenDoorProducers openDoorProducers, String str2, int i, Object obj) {
            if (obj != null) {
                throw new UnsupportedOperationException("Super calls with default arguments not supported in this target, function: openDoor");
            }
            if ((i & 2) != 0) {
                z = false;
            }
            if ((i & 8) != 0) {
                str2 = null;
            }
            return iCamerasRepository.openDoor(str, z, openDoorProducers, str2);
        }
    }
}

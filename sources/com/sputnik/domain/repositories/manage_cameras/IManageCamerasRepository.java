package com.sputnik.domain.repositories.manage_cameras;

import com.sputnik.domain.common.Resource;
import com.sputnik.domain.entities.cameras.DomainCameraObject;
import com.sputnik.domain.entities.cameras.DomainCamerasOrder;
import java.util.List;
import kotlin.Metadata;
import kotlin.Unit;
import kotlinx.coroutines.flow.Flow;

/* compiled from: IManageCamerasRepository.kt */
@Metadata(d1 = {"\u0000:\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\b\n\u0002\b\u0004\n\u0002\u0010\u000e\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u0002\n\u0002\b\u0003\bf\u0018\u00002\u00020\u0001J!\u0010\u0006\u001a\u0014\u0012\u0010\u0012\u000e\u0012\n\u0012\b\u0012\u0004\u0012\u00020\u00050\u00040\u00030\u0002H&¢\u0006\u0004\b\u0006\u0010\u0007J+\u0010\u000b\u001a\u000e\u0012\n\u0012\b\u0012\u0004\u0012\u00020\u00050\u00030\u00022\u0006\u0010\t\u001a\u00020\b2\u0006\u0010\n\u001a\u00020\u0005H&¢\u0006\u0004\b\u000b\u0010\fJ3\u0010\u0011\u001a\u000e\u0012\n\u0012\b\u0012\u0004\u0012\u00020\u000f0\u00030\u00022\u0006\u0010\t\u001a\u00020\b2\u0006\u0010\u000e\u001a\u00020\r2\u0006\u0010\u0010\u001a\u00020\u000fH&¢\u0006\u0004\b\u0011\u0010\u0012J#\u0010\u0014\u001a\u000e\u0012\n\u0012\b\u0012\u0004\u0012\u00020\u00130\u00030\u00022\u0006\u0010\t\u001a\u00020\bH&¢\u0006\u0004\b\u0014\u0010\u0015¨\u0006\u0016"}, d2 = {"Lcom/sputnik/domain/repositories/manage_cameras/IManageCamerasRepository;", "", "Lkotlinx/coroutines/flow/Flow;", "Lcom/sputnik/domain/common/Resource;", "", "Lcom/sputnik/domain/entities/cameras/DomainCamerasOrder;", "getCamerasPreferences", "()Lkotlinx/coroutines/flow/Flow;", "", "addressId", "camerasOrder", "setCamerasOrder", "(ILcom/sputnik/domain/entities/cameras/DomainCamerasOrder;)Lkotlinx/coroutines/flow/Flow;", "", "cameraUuid", "Lcom/sputnik/domain/entities/cameras/DomainCameraObject;", "camera", "setCameraParams", "(ILjava/lang/String;Lcom/sputnik/domain/entities/cameras/DomainCameraObject;)Lkotlinx/coroutines/flow/Flow;", "", "clearCamerasPreferences", "(I)Lkotlinx/coroutines/flow/Flow;", "domain"}, k = 1, mv = {1, 9, 0}, xi = 48)
/* loaded from: classes3.dex */
public interface IManageCamerasRepository {
    Flow<Resource<Unit>> clearCamerasPreferences(int addressId);

    Flow<Resource<List<DomainCamerasOrder>>> getCamerasPreferences();

    Flow<Resource<DomainCameraObject>> setCameraParams(int addressId, String cameraUuid, DomainCameraObject camera);

    Flow<Resource<DomainCamerasOrder>> setCamerasOrder(int addressId, DomainCamerasOrder camerasOrder);
}

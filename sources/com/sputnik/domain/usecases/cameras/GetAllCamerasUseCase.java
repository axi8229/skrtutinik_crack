package com.sputnik.domain.usecases.cameras;

import com.sputnik.domain.common.Resource;
import com.sputnik.domain.entities.cameras.DomainCamera;
import com.sputnik.domain.repositories.cameras.ICamerasRepository;
import java.util.List;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import kotlinx.coroutines.flow.Flow;

/* compiled from: GetAllCamerasUseCase.kt */
@Metadata(d1 = {"\u00002\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0002\u0018\u00002\u00020\u0001B\r\u0012\u0006\u0010\u0002\u001a\u00020\u0003¢\u0006\u0002\u0010\u0004J;\u0010\u0005\u001a\u0014\u0012\u0010\u0012\u000e\u0012\n\u0012\b\u0012\u0004\u0012\u00020\t0\b0\u00070\u00062\u0006\u0010\n\u001a\u00020\u000b2\n\b\u0002\u0010\f\u001a\u0004\u0018\u00010\r2\n\b\u0002\u0010\u000e\u001a\u0004\u0018\u00010\rH\u0086\u0002R\u000e\u0010\u0002\u001a\u00020\u0003X\u0082\u0004¢\u0006\u0002\n\u0000¨\u0006\u000f"}, d2 = {"Lcom/sputnik/domain/usecases/cameras/GetAllCamerasUseCase;", "", "repository", "Lcom/sputnik/domain/repositories/cameras/ICamerasRepository;", "(Lcom/sputnik/domain/repositories/cameras/ICamerasRepository;)V", "invoke", "Lkotlinx/coroutines/flow/Flow;", "Lcom/sputnik/domain/common/Resource;", "", "Lcom/sputnik/domain/entities/cameras/DomainCamera;", "addressId", "", "listType", "", "orderType", "domain"}, k = 1, mv = {1, 9, 0}, xi = 48)
/* loaded from: classes3.dex */
public final class GetAllCamerasUseCase {
    private final ICamerasRepository repository;

    public GetAllCamerasUseCase(ICamerasRepository repository) {
        Intrinsics.checkNotNullParameter(repository, "repository");
        this.repository = repository;
    }

    public final Flow<Resource<List<DomainCamera>>> invoke(int addressId, String listType, String orderType) {
        return this.repository.getCameras(addressId, listType, orderType);
    }
}

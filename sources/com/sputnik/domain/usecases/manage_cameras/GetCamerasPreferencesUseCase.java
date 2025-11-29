package com.sputnik.domain.usecases.manage_cameras;

import com.sputnik.domain.common.Resource;
import com.sputnik.domain.entities.cameras.DomainCamerasOrder;
import com.sputnik.domain.repositories.manage_cameras.IManageCamerasRepository;
import java.util.List;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import kotlinx.coroutines.flow.Flow;

/* compiled from: GetCamerasPreferencesUseCase.kt */
@Metadata(d1 = {"\u0000$\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0000\u0018\u00002\u00020\u0001B\r\u0012\u0006\u0010\u0002\u001a\u00020\u0003¢\u0006\u0002\u0010\u0004J\u001b\u0010\u0005\u001a\u0014\u0012\u0010\u0012\u000e\u0012\n\u0012\b\u0012\u0004\u0012\u00020\t0\b0\u00070\u0006H\u0086\u0002R\u000e\u0010\u0002\u001a\u00020\u0003X\u0082\u0004¢\u0006\u0002\n\u0000¨\u0006\n"}, d2 = {"Lcom/sputnik/domain/usecases/manage_cameras/GetCamerasPreferencesUseCase;", "", "repository", "Lcom/sputnik/domain/repositories/manage_cameras/IManageCamerasRepository;", "(Lcom/sputnik/domain/repositories/manage_cameras/IManageCamerasRepository;)V", "invoke", "Lkotlinx/coroutines/flow/Flow;", "Lcom/sputnik/domain/common/Resource;", "", "Lcom/sputnik/domain/entities/cameras/DomainCamerasOrder;", "domain"}, k = 1, mv = {1, 9, 0}, xi = 48)
/* loaded from: classes3.dex */
public final class GetCamerasPreferencesUseCase {
    private final IManageCamerasRepository repository;

    public GetCamerasPreferencesUseCase(IManageCamerasRepository repository) {
        Intrinsics.checkNotNullParameter(repository, "repository");
        this.repository = repository;
    }

    public final Flow<Resource<List<DomainCamerasOrder>>> invoke() {
        return this.repository.getCamerasPreferences();
    }
}

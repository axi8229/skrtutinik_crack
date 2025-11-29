package com.sputnik.common.di.use_cases.cameras;

import com.sputnik.domain.repositories.cameras.ICamerasRepository;
import com.sputnik.domain.usecases.cameras.GetCameraByIntercomUUIDUseCase;
import dagger.internal.Factory;
import dagger.internal.Preconditions;

/* loaded from: classes3.dex */
public final class CamerasUseCaseModule_ProvideGetCameraByIntercomUUIDUseCaseFactory implements Factory<GetCameraByIntercomUUIDUseCase> {
    public static GetCameraByIntercomUUIDUseCase provideGetCameraByIntercomUUIDUseCase(CamerasUseCaseModule camerasUseCaseModule, ICamerasRepository iCamerasRepository) {
        return (GetCameraByIntercomUUIDUseCase) Preconditions.checkNotNullFromProvides(camerasUseCaseModule.provideGetCameraByIntercomUUIDUseCase(iCamerasRepository));
    }
}

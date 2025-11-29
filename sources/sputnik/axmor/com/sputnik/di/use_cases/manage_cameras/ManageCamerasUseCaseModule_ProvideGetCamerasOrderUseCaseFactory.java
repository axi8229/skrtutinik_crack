package sputnik.axmor.com.sputnik.di.use_cases.manage_cameras;

import com.sputnik.domain.repositories.manage_cameras.IManageCamerasRepository;
import com.sputnik.domain.usecases.manage_cameras.GetCamerasOrderUseCase;
import dagger.internal.Factory;
import dagger.internal.Preconditions;

/* loaded from: classes5.dex */
public final class ManageCamerasUseCaseModule_ProvideGetCamerasOrderUseCaseFactory implements Factory<GetCamerasOrderUseCase> {
    public static GetCamerasOrderUseCase provideGetCamerasOrderUseCase(ManageCamerasUseCaseModule manageCamerasUseCaseModule, IManageCamerasRepository iManageCamerasRepository) {
        return (GetCamerasOrderUseCase) Preconditions.checkNotNullFromProvides(manageCamerasUseCaseModule.provideGetCamerasOrderUseCase(iManageCamerasRepository));
    }
}

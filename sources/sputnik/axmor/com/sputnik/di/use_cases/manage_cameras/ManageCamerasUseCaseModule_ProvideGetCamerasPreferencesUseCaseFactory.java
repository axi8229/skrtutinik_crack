package sputnik.axmor.com.sputnik.di.use_cases.manage_cameras;

import com.sputnik.domain.repositories.manage_cameras.IManageCamerasRepository;
import com.sputnik.domain.usecases.manage_cameras.GetCamerasPreferencesUseCase;
import dagger.internal.Factory;
import dagger.internal.Preconditions;

/* loaded from: classes5.dex */
public final class ManageCamerasUseCaseModule_ProvideGetCamerasPreferencesUseCaseFactory implements Factory<GetCamerasPreferencesUseCase> {
    public static GetCamerasPreferencesUseCase provideGetCamerasPreferencesUseCase(ManageCamerasUseCaseModule manageCamerasUseCaseModule, IManageCamerasRepository iManageCamerasRepository) {
        return (GetCamerasPreferencesUseCase) Preconditions.checkNotNullFromProvides(manageCamerasUseCaseModule.provideGetCamerasPreferencesUseCase(iManageCamerasRepository));
    }
}

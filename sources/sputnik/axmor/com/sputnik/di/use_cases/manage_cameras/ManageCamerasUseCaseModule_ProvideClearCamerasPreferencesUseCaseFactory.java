package sputnik.axmor.com.sputnik.di.use_cases.manage_cameras;

import com.sputnik.domain.repositories.manage_cameras.IManageCamerasRepository;
import com.sputnik.domain.usecases.manage_cameras.ClearCamerasPreferencesUseCase;
import dagger.internal.Factory;
import dagger.internal.Preconditions;

/* loaded from: classes5.dex */
public final class ManageCamerasUseCaseModule_ProvideClearCamerasPreferencesUseCaseFactory implements Factory<ClearCamerasPreferencesUseCase> {
    public static ClearCamerasPreferencesUseCase provideClearCamerasPreferencesUseCase(ManageCamerasUseCaseModule manageCamerasUseCaseModule, IManageCamerasRepository iManageCamerasRepository) {
        return (ClearCamerasPreferencesUseCase) Preconditions.checkNotNullFromProvides(manageCamerasUseCaseModule.provideClearCamerasPreferencesUseCase(iManageCamerasRepository));
    }
}

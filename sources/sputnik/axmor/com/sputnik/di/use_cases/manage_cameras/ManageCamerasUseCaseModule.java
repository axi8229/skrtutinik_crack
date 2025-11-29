package sputnik.axmor.com.sputnik.di.use_cases.manage_cameras;

import com.sputnik.domain.repositories.manage_cameras.IManageCamerasRepository;
import com.sputnik.domain.usecases.manage_cameras.ClearCamerasPreferencesUseCase;
import com.sputnik.domain.usecases.manage_cameras.GetCamerasOrderUseCase;
import com.sputnik.domain.usecases.manage_cameras.GetCamerasPreferencesUseCase;
import com.sputnik.domain.usecases.manage_cameras.SetCameraParamsUseCase;
import com.sputnik.domain.usecases.manage_cameras.SetCamerasOrderUseCase;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

/* compiled from: ManageCamerasUseCaseModule.kt */
@Metadata(d1 = {"\u00000\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\b\u0007\u0018\u00002\u00020\u0001B\u0005¢\u0006\u0002\u0010\u0002J\u0010\u0010\u0003\u001a\u00020\u00042\u0006\u0010\u0005\u001a\u00020\u0006H\u0007J\u0010\u0010\u0007\u001a\u00020\b2\u0006\u0010\u0005\u001a\u00020\u0006H\u0007J\u0010\u0010\t\u001a\u00020\n2\u0006\u0010\u0005\u001a\u00020\u0006H\u0007J\u0010\u0010\u000b\u001a\u00020\f2\u0006\u0010\u0005\u001a\u00020\u0006H\u0007J\u0010\u0010\r\u001a\u00020\u000e2\u0006\u0010\u0005\u001a\u00020\u0006H\u0007¨\u0006\u000f"}, d2 = {"Lsputnik/axmor/com/sputnik/di/use_cases/manage_cameras/ManageCamerasUseCaseModule;", "", "()V", "provideClearCamerasPreferencesUseCase", "Lcom/sputnik/domain/usecases/manage_cameras/ClearCamerasPreferencesUseCase;", "repository", "Lcom/sputnik/domain/repositories/manage_cameras/IManageCamerasRepository;", "provideGetCamerasOrderUseCase", "Lcom/sputnik/domain/usecases/manage_cameras/GetCamerasOrderUseCase;", "provideGetCamerasPreferencesUseCase", "Lcom/sputnik/domain/usecases/manage_cameras/GetCamerasPreferencesUseCase;", "provideSetCameraParamsUseCase", "Lcom/sputnik/domain/usecases/manage_cameras/SetCameraParamsUseCase;", "provideSetCamerasOrderUseCase", "Lcom/sputnik/domain/usecases/manage_cameras/SetCamerasOrderUseCase;", "app_huaweiRelease"}, k = 1, mv = {1, 9, 0}, xi = 48)
/* loaded from: classes5.dex */
public final class ManageCamerasUseCaseModule {
    public final GetCamerasOrderUseCase provideGetCamerasOrderUseCase(IManageCamerasRepository repository) {
        Intrinsics.checkNotNullParameter(repository, "repository");
        return new GetCamerasOrderUseCase(repository);
    }

    public final SetCameraParamsUseCase provideSetCameraParamsUseCase(IManageCamerasRepository repository) {
        Intrinsics.checkNotNullParameter(repository, "repository");
        return new SetCameraParamsUseCase(repository);
    }

    public final SetCamerasOrderUseCase provideSetCamerasOrderUseCase(IManageCamerasRepository repository) {
        Intrinsics.checkNotNullParameter(repository, "repository");
        return new SetCamerasOrderUseCase(repository);
    }

    public final ClearCamerasPreferencesUseCase provideClearCamerasPreferencesUseCase(IManageCamerasRepository repository) {
        Intrinsics.checkNotNullParameter(repository, "repository");
        return new ClearCamerasPreferencesUseCase(repository);
    }

    public final GetCamerasPreferencesUseCase provideGetCamerasPreferencesUseCase(IManageCamerasRepository repository) {
        Intrinsics.checkNotNullParameter(repository, "repository");
        return new GetCamerasPreferencesUseCase(repository);
    }
}

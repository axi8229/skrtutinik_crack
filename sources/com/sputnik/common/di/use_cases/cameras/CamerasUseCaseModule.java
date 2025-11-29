package com.sputnik.common.di.use_cases.cameras;

import com.sputnik.domain.repositories.cameras.ICamerasRepository;
import com.sputnik.domain.usecases.cameras.GetAllCamerasUseCase;
import com.sputnik.domain.usecases.cameras.GetCameraByIntercomUUIDUseCase;
import com.sputnik.domain.usecases.cameras.GetCamerasDemoUseCase;
import com.sputnik.domain.usecases.cameras.OpenDoorUseCase;
import com.sputnik.domain.usecases.cameras.OpenSecondDoorUseCase;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

/* compiled from: CamerasUseCaseModule.kt */
@Metadata(d1 = {"\u00000\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\b\u0007\u0018\u00002\u00020\u0001B\u0005¢\u0006\u0002\u0010\u0002J\u0010\u0010\u0003\u001a\u00020\u00042\u0006\u0010\u0005\u001a\u00020\u0006H\u0007J\u0010\u0010\u0007\u001a\u00020\b2\u0006\u0010\u0005\u001a\u00020\u0006H\u0007J\u0010\u0010\t\u001a\u00020\n2\u0006\u0010\u0005\u001a\u00020\u0006H\u0007J\u0010\u0010\u000b\u001a\u00020\f2\u0006\u0010\u0005\u001a\u00020\u0006H\u0007J\u0010\u0010\r\u001a\u00020\u000e2\u0006\u0010\u0005\u001a\u00020\u0006H\u0007¨\u0006\u000f"}, d2 = {"Lcom/sputnik/common/di/use_cases/cameras/CamerasUseCaseModule;", "", "()V", "provideGetAllCamerasUseCase", "Lcom/sputnik/domain/usecases/cameras/GetAllCamerasUseCase;", "repository", "Lcom/sputnik/domain/repositories/cameras/ICamerasRepository;", "provideGetCameraByIntercomUUIDUseCase", "Lcom/sputnik/domain/usecases/cameras/GetCameraByIntercomUUIDUseCase;", "provideGetCamerasDemoUseCase", "Lcom/sputnik/domain/usecases/cameras/GetCamerasDemoUseCase;", "provideOpenDoorUseCase", "Lcom/sputnik/domain/usecases/cameras/OpenDoorUseCase;", "provideOpenSecondDoorUseCase", "Lcom/sputnik/domain/usecases/cameras/OpenSecondDoorUseCase;", "common_release"}, k = 1, mv = {1, 9, 0}, xi = 48)
/* loaded from: classes3.dex */
public final class CamerasUseCaseModule {
    public final GetAllCamerasUseCase provideGetAllCamerasUseCase(ICamerasRepository repository) {
        Intrinsics.checkNotNullParameter(repository, "repository");
        return new GetAllCamerasUseCase(repository);
    }

    public final GetCameraByIntercomUUIDUseCase provideGetCameraByIntercomUUIDUseCase(ICamerasRepository repository) {
        Intrinsics.checkNotNullParameter(repository, "repository");
        return new GetCameraByIntercomUUIDUseCase(repository);
    }

    public final GetCamerasDemoUseCase provideGetCamerasDemoUseCase(ICamerasRepository repository) {
        Intrinsics.checkNotNullParameter(repository, "repository");
        return new GetCamerasDemoUseCase(repository);
    }

    public final OpenDoorUseCase provideOpenDoorUseCase(ICamerasRepository repository) {
        Intrinsics.checkNotNullParameter(repository, "repository");
        return new OpenDoorUseCase(repository);
    }

    public final OpenSecondDoorUseCase provideOpenSecondDoorUseCase(ICamerasRepository repository) {
        Intrinsics.checkNotNullParameter(repository, "repository");
        return new OpenSecondDoorUseCase(repository);
    }
}

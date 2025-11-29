package com.sputnik.common.di.use_cases.alerts;

import com.sputnik.domain.repositories.alerts.IAlertsRepository;
import com.sputnik.domain.usecases.alerts.GetAlertsUseCase;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

/* compiled from: AlertsUseCaseModule.kt */
@Metadata(d1 = {"\u0000\u0018\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\b\u0007\u0018\u00002\u00020\u0001B\u0005¢\u0006\u0002\u0010\u0002J\u0010\u0010\u0003\u001a\u00020\u00042\u0006\u0010\u0005\u001a\u00020\u0006H\u0007¨\u0006\u0007"}, d2 = {"Lcom/sputnik/common/di/use_cases/alerts/AlertsUseCaseModule;", "", "()V", "provideGetCamerasOrderUseCase", "Lcom/sputnik/domain/usecases/alerts/GetAlertsUseCase;", "repository", "Lcom/sputnik/domain/repositories/alerts/IAlertsRepository;", "common_release"}, k = 1, mv = {1, 9, 0}, xi = 48)
/* loaded from: classes3.dex */
public final class AlertsUseCaseModule {
    public final GetAlertsUseCase provideGetCamerasOrderUseCase(IAlertsRepository repository) {
        Intrinsics.checkNotNullParameter(repository, "repository");
        return new GetAlertsUseCase(repository);
    }
}

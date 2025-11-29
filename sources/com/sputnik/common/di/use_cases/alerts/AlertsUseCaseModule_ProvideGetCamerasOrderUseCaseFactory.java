package com.sputnik.common.di.use_cases.alerts;

import com.sputnik.domain.repositories.alerts.IAlertsRepository;
import com.sputnik.domain.usecases.alerts.GetAlertsUseCase;
import dagger.internal.Factory;
import dagger.internal.Preconditions;
import javax.inject.Provider;

/* loaded from: classes3.dex */
public final class AlertsUseCaseModule_ProvideGetCamerasOrderUseCaseFactory implements Factory<GetAlertsUseCase> {
    private final AlertsUseCaseModule module;
    private final Provider<IAlertsRepository> repositoryProvider;

    public AlertsUseCaseModule_ProvideGetCamerasOrderUseCaseFactory(AlertsUseCaseModule alertsUseCaseModule, Provider<IAlertsRepository> provider) {
        this.module = alertsUseCaseModule;
        this.repositoryProvider = provider;
    }

    @Override // javax.inject.Provider
    public GetAlertsUseCase get() {
        return provideGetCamerasOrderUseCase(this.module, this.repositoryProvider.get());
    }

    public static AlertsUseCaseModule_ProvideGetCamerasOrderUseCaseFactory create(AlertsUseCaseModule alertsUseCaseModule, Provider<IAlertsRepository> provider) {
        return new AlertsUseCaseModule_ProvideGetCamerasOrderUseCaseFactory(alertsUseCaseModule, provider);
    }

    public static GetAlertsUseCase provideGetCamerasOrderUseCase(AlertsUseCaseModule alertsUseCaseModule, IAlertsRepository iAlertsRepository) {
        return (GetAlertsUseCase) Preconditions.checkNotNullFromProvides(alertsUseCaseModule.provideGetCamerasOrderUseCase(iAlertsRepository));
    }
}

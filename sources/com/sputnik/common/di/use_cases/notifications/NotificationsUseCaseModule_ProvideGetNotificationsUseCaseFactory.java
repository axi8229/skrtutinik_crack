package com.sputnik.common.di.use_cases.notifications;

import com.sputnik.domain.repositories.notifications.INotificationsRepository;
import com.sputnik.domain.usecases.notifications.GetNotificationsUseCase;
import dagger.internal.Factory;
import dagger.internal.Preconditions;

/* loaded from: classes3.dex */
public final class NotificationsUseCaseModule_ProvideGetNotificationsUseCaseFactory implements Factory<GetNotificationsUseCase> {
    public static GetNotificationsUseCase provideGetNotificationsUseCase(NotificationsUseCaseModule notificationsUseCaseModule, INotificationsRepository iNotificationsRepository) {
        return (GetNotificationsUseCase) Preconditions.checkNotNullFromProvides(notificationsUseCaseModule.provideGetNotificationsUseCase(iNotificationsRepository));
    }
}

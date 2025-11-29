package com.sputnik.common.di.use_cases.notifications;

import com.sputnik.domain.repositories.notifications.INotificationsRepository;
import com.sputnik.domain.usecases.notifications.GetNotificationUseCase;
import dagger.internal.Factory;
import dagger.internal.Preconditions;

/* loaded from: classes3.dex */
public final class NotificationsUseCaseModule_ProvideGetNotificationUseCaseFactory implements Factory<GetNotificationUseCase> {
    public static GetNotificationUseCase provideGetNotificationUseCase(NotificationsUseCaseModule notificationsUseCaseModule, INotificationsRepository iNotificationsRepository) {
        return (GetNotificationUseCase) Preconditions.checkNotNullFromProvides(notificationsUseCaseModule.provideGetNotificationUseCase(iNotificationsRepository));
    }
}

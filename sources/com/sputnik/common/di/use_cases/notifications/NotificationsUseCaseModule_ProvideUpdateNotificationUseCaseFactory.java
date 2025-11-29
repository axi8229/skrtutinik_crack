package com.sputnik.common.di.use_cases.notifications;

import com.sputnik.domain.repositories.notifications.INotificationsRepository;
import com.sputnik.domain.usecases.notifications.UpdateNotificationUseCase;
import dagger.internal.Factory;
import dagger.internal.Preconditions;

/* loaded from: classes3.dex */
public final class NotificationsUseCaseModule_ProvideUpdateNotificationUseCaseFactory implements Factory<UpdateNotificationUseCase> {
    public static UpdateNotificationUseCase provideUpdateNotificationUseCase(NotificationsUseCaseModule notificationsUseCaseModule, INotificationsRepository iNotificationsRepository) {
        return (UpdateNotificationUseCase) Preconditions.checkNotNullFromProvides(notificationsUseCaseModule.provideUpdateNotificationUseCase(iNotificationsRepository));
    }
}

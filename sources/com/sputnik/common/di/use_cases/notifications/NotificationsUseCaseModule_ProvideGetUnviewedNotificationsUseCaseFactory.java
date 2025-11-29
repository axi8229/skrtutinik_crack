package com.sputnik.common.di.use_cases.notifications;

import com.sputnik.domain.repositories.notifications.INotificationsRepository;
import com.sputnik.domain.usecases.notifications.GetUnviewedNotificationsUseCase;
import dagger.internal.Factory;
import dagger.internal.Preconditions;

/* loaded from: classes3.dex */
public final class NotificationsUseCaseModule_ProvideGetUnviewedNotificationsUseCaseFactory implements Factory<GetUnviewedNotificationsUseCase> {
    public static GetUnviewedNotificationsUseCase provideGetUnviewedNotificationsUseCase(NotificationsUseCaseModule notificationsUseCaseModule, INotificationsRepository iNotificationsRepository) {
        return (GetUnviewedNotificationsUseCase) Preconditions.checkNotNullFromProvides(notificationsUseCaseModule.provideGetUnviewedNotificationsUseCase(iNotificationsRepository));
    }
}

package com.sputnik.common.di.use_cases.notifications;

import com.sputnik.domain.repositories.notifications.INotificationsRepository;
import com.sputnik.domain.usecases.notifications.GetNotificationUseCase;
import com.sputnik.domain.usecases.notifications.GetNotificationsUseCase;
import com.sputnik.domain.usecases.notifications.GetUnviewedNotificationsUseCase;
import com.sputnik.domain.usecases.notifications.UpdateNotificationUseCase;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

/* compiled from: NotificationsUseCaseModule.kt */
@Metadata(d1 = {"\u0000*\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\b\u0007\u0018\u00002\u00020\u0001B\u0005¢\u0006\u0002\u0010\u0002J\u0010\u0010\u0003\u001a\u00020\u00042\u0006\u0010\u0005\u001a\u00020\u0006H\u0007J\u0010\u0010\u0007\u001a\u00020\b2\u0006\u0010\u0005\u001a\u00020\u0006H\u0007J\u0010\u0010\t\u001a\u00020\n2\u0006\u0010\u0005\u001a\u00020\u0006H\u0007J\u0010\u0010\u000b\u001a\u00020\f2\u0006\u0010\u0005\u001a\u00020\u0006H\u0007¨\u0006\r"}, d2 = {"Lcom/sputnik/common/di/use_cases/notifications/NotificationsUseCaseModule;", "", "()V", "provideGetNotificationUseCase", "Lcom/sputnik/domain/usecases/notifications/GetNotificationUseCase;", "repository", "Lcom/sputnik/domain/repositories/notifications/INotificationsRepository;", "provideGetNotificationsUseCase", "Lcom/sputnik/domain/usecases/notifications/GetNotificationsUseCase;", "provideGetUnviewedNotificationsUseCase", "Lcom/sputnik/domain/usecases/notifications/GetUnviewedNotificationsUseCase;", "provideUpdateNotificationUseCase", "Lcom/sputnik/domain/usecases/notifications/UpdateNotificationUseCase;", "common_release"}, k = 1, mv = {1, 9, 0}, xi = 48)
/* loaded from: classes3.dex */
public final class NotificationsUseCaseModule {
    public final GetNotificationsUseCase provideGetNotificationsUseCase(INotificationsRepository repository) {
        Intrinsics.checkNotNullParameter(repository, "repository");
        return new GetNotificationsUseCase(repository);
    }

    public final GetUnviewedNotificationsUseCase provideGetUnviewedNotificationsUseCase(INotificationsRepository repository) {
        Intrinsics.checkNotNullParameter(repository, "repository");
        return new GetUnviewedNotificationsUseCase(repository);
    }

    public final GetNotificationUseCase provideGetNotificationUseCase(INotificationsRepository repository) {
        Intrinsics.checkNotNullParameter(repository, "repository");
        return new GetNotificationUseCase(repository);
    }

    public final UpdateNotificationUseCase provideUpdateNotificationUseCase(INotificationsRepository repository) {
        Intrinsics.checkNotNullParameter(repository, "repository");
        return new UpdateNotificationUseCase(repository);
    }
}

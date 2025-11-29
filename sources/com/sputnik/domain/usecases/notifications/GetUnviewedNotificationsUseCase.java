package com.sputnik.domain.usecases.notifications;

import com.sputnik.domain.common.Resource;
import com.sputnik.domain.entities.notifications.DomainNotification;
import com.sputnik.domain.repositories.notifications.INotificationsRepository;
import java.util.List;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import kotlinx.coroutines.flow.Flow;

/* compiled from: GetUnviewedNotificationsUseCase.kt */
@Metadata(d1 = {"\u0000$\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0000\u0018\u00002\u00020\u0001B\r\u0012\u0006\u0010\u0002\u001a\u00020\u0003¢\u0006\u0002\u0010\u0004J\u001b\u0010\u0005\u001a\u0014\u0012\u0010\u0012\u000e\u0012\n\u0012\b\u0012\u0004\u0012\u00020\t0\b0\u00070\u0006H\u0086\u0002R\u000e\u0010\u0002\u001a\u00020\u0003X\u0082\u0004¢\u0006\u0002\n\u0000¨\u0006\n"}, d2 = {"Lcom/sputnik/domain/usecases/notifications/GetUnviewedNotificationsUseCase;", "", "repository", "Lcom/sputnik/domain/repositories/notifications/INotificationsRepository;", "(Lcom/sputnik/domain/repositories/notifications/INotificationsRepository;)V", "invoke", "Lkotlinx/coroutines/flow/Flow;", "Lcom/sputnik/domain/common/Resource;", "", "Lcom/sputnik/domain/entities/notifications/DomainNotification;", "domain"}, k = 1, mv = {1, 9, 0}, xi = 48)
/* loaded from: classes3.dex */
public final class GetUnviewedNotificationsUseCase {
    private final INotificationsRepository repository;

    public GetUnviewedNotificationsUseCase(INotificationsRepository repository) {
        Intrinsics.checkNotNullParameter(repository, "repository");
        this.repository = repository;
    }

    public final Flow<Resource<List<DomainNotification>>> invoke() {
        return this.repository.getUnviewedNotifications();
    }
}

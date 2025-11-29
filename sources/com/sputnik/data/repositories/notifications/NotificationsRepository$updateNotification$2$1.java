package com.sputnik.data.repositories.notifications;

import com.sputnik.data.entities.notifications.DataNotification;
import com.sputnik.data.mappers.notifications.DataNotificationtToDomainNotificationMapper;
import com.sputnik.domain.entities.notifications.DomainNotification;
import kotlin.Metadata;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.FunctionReferenceImpl;
import kotlin.jvm.internal.Intrinsics;

/* compiled from: NotificationsRepository.kt */
@Metadata(k = 3, mv = {1, 9, 0}, xi = 48)
/* loaded from: classes3.dex */
/* synthetic */ class NotificationsRepository$updateNotification$2$1 extends FunctionReferenceImpl implements Function1<DataNotification, DomainNotification> {
    NotificationsRepository$updateNotification$2$1(Object obj) {
        super(1, obj, DataNotificationtToDomainNotificationMapper.class, "map", "map(Lcom/sputnik/data/entities/notifications/DataNotification;)Lcom/sputnik/domain/entities/notifications/DomainNotification;", 0);
    }

    @Override // kotlin.jvm.functions.Function1
    public final DomainNotification invoke(DataNotification p0) {
        Intrinsics.checkNotNullParameter(p0, "p0");
        return ((DataNotificationtToDomainNotificationMapper) this.receiver).map(p0);
    }
}

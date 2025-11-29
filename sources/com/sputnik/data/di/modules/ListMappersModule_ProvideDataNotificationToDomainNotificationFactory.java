package com.sputnik.data.di.modules;

import com.sputnik.data.entities.notifications.DataNotification;
import com.sputnik.data.mappers.notifications.DataNotificationtToDomainNotificationMapper;
import com.sputnik.domain.common.ListMapper;
import com.sputnik.domain.entities.notifications.DomainNotification;
import dagger.internal.Factory;
import dagger.internal.Preconditions;

/* loaded from: classes3.dex */
public final class ListMappersModule_ProvideDataNotificationToDomainNotificationFactory implements Factory<ListMapper<DataNotification, DomainNotification>> {
    public static ListMapper<DataNotification, DomainNotification> provideDataNotificationToDomainNotification(ListMappersModule listMappersModule, DataNotificationtToDomainNotificationMapper dataNotificationtToDomainNotificationMapper) {
        return (ListMapper) Preconditions.checkNotNullFromProvides(listMappersModule.provideDataNotificationToDomainNotification(dataNotificationtToDomainNotificationMapper));
    }
}

package com.sputnik.domain.repositories.notifications;

import com.huawei.hms.push.constant.RemoteMessageConst;
import com.sputnik.domain.common.Resource;
import com.sputnik.domain.entities.notifications.DomainNotification;
import java.util.List;
import kotlin.Metadata;
import kotlinx.coroutines.flow.Flow;

/* compiled from: INotificationsRepository.kt */
@Metadata(d1 = {"\u0000\u001c\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0002\b\u0007\bf\u0018\u00002\u00020\u0001J!\u0010\u0006\u001a\u0014\u0012\u0010\u0012\u000e\u0012\n\u0012\b\u0012\u0004\u0012\u00020\u00050\u00040\u00030\u0002H&¢\u0006\u0004\b\u0006\u0010\u0007J!\u0010\b\u001a\u0014\u0012\u0010\u0012\u000e\u0012\n\u0012\b\u0012\u0004\u0012\u00020\u00050\u00040\u00030\u0002H&¢\u0006\u0004\b\b\u0010\u0007J#\u0010\n\u001a\u000e\u0012\n\u0012\b\u0012\u0004\u0012\u00020\u00050\u00030\u00022\u0006\u0010\t\u001a\u00020\u0005H&¢\u0006\u0004\b\n\u0010\u000b¨\u0006\f"}, d2 = {"Lcom/sputnik/domain/repositories/notifications/INotificationsRepository;", "", "Lkotlinx/coroutines/flow/Flow;", "Lcom/sputnik/domain/common/Resource;", "", "Lcom/sputnik/domain/entities/notifications/DomainNotification;", "getNotifications", "()Lkotlinx/coroutines/flow/Flow;", "getUnviewedNotifications", RemoteMessageConst.NOTIFICATION, "updateNotification", "(Lcom/sputnik/domain/entities/notifications/DomainNotification;)Lkotlinx/coroutines/flow/Flow;", "domain"}, k = 1, mv = {1, 9, 0}, xi = 48)
/* loaded from: classes3.dex */
public interface INotificationsRepository {
    Flow<Resource<List<DomainNotification>>> getNotifications();

    Flow<Resource<List<DomainNotification>>> getUnviewedNotifications();

    Flow<Resource<DomainNotification>> updateNotification(DomainNotification notification);
}

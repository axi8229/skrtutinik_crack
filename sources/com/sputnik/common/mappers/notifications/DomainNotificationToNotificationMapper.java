package com.sputnik.common.mappers.notifications;

import com.sputnik.common.entities.notifications.Notification;
import com.sputnik.domain.common.Mapper;
import com.sputnik.domain.entities.notifications.DomainNotification;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import kotlin.Metadata;
import kotlin.collections.CollectionsKt;
import kotlin.jvm.internal.Intrinsics;

/* compiled from: DomainNotificationToNotificationMapper.kt */
@Metadata(d1 = {"\u0000\u0014\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0004\u0018\u00002\u000e\u0012\u0004\u0012\u00020\u0002\u0012\u0004\u0012\u00020\u00030\u0001B\u0007\b\u0007¢\u0006\u0002\u0010\u0004J\u0010\u0010\u0005\u001a\u00020\u00032\u0006\u0010\u0006\u001a\u00020\u0002H\u0016¨\u0006\u0007"}, d2 = {"Lcom/sputnik/common/mappers/notifications/DomainNotificationToNotificationMapper;", "Lcom/sputnik/domain/common/Mapper;", "Lcom/sputnik/domain/entities/notifications/DomainNotification;", "Lcom/sputnik/common/entities/notifications/Notification;", "()V", "map", "input", "common_release"}, k = 1, mv = {1, 9, 0}, xi = 48)
/* loaded from: classes3.dex */
public final class DomainNotificationToNotificationMapper implements Mapper<DomainNotification, Notification> {
    @Override // com.sputnik.domain.common.Mapper
    public Notification map(DomainNotification input) {
        List<DomainNotification.DomainButton> buttons;
        Intrinsics.checkNotNullParameter(input, "input");
        Integer id = input.getId();
        String identifier = input.getIdentifier();
        String identifierHuman = input.getIdentifierHuman();
        String title = input.getTitle();
        String deeplink = input.getDeeplink();
        String message = input.getMessage();
        Boolean viewed = input.getViewed();
        String createdAt = input.getCreatedAt();
        ArrayList arrayList = null;
        if (input.getButtons() != null && (buttons = input.getButtons()) != null) {
            List<DomainNotification.DomainButton> list = buttons;
            ArrayList arrayList2 = new ArrayList(CollectionsKt.collectionSizeOrDefault(list, 10));
            for (Iterator it = list.iterator(); it.hasNext(); it = it) {
                DomainNotification.DomainButton domainButton = (DomainNotification.DomainButton) it.next();
                arrayList2.add(new Notification.Button(domainButton.getType(), domainButton.getColor(), domainButton.getDeeplink(), domainButton.getTitle(), domainButton.getLink()));
            }
            arrayList = arrayList2;
        }
        return new Notification(id, identifier, identifierHuman, title, deeplink, message, viewed, createdAt, arrayList);
    }
}

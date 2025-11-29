package com.sputnik.data.mappers.notifications;

import com.sputnik.data.entities.notifications.DataNotification;
import com.sputnik.domain.common.Mapper;
import com.sputnik.domain.entities.notifications.DomainNotification;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import kotlin.Metadata;
import kotlin.collections.CollectionsKt;
import kotlin.jvm.internal.Intrinsics;

/* compiled from: DataNotificationtToDomainNotificationMapper.kt */
@Metadata(d1 = {"\u0000\u0014\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0004\u0018\u00002\u000e\u0012\u0004\u0012\u00020\u0002\u0012\u0004\u0012\u00020\u00030\u0001B\u0007\b\u0007¢\u0006\u0002\u0010\u0004J\u0010\u0010\u0005\u001a\u00020\u00032\u0006\u0010\u0006\u001a\u00020\u0002H\u0016¨\u0006\u0007"}, d2 = {"Lcom/sputnik/data/mappers/notifications/DataNotificationtToDomainNotificationMapper;", "Lcom/sputnik/domain/common/Mapper;", "Lcom/sputnik/data/entities/notifications/DataNotification;", "Lcom/sputnik/domain/entities/notifications/DomainNotification;", "()V", "map", "input", "data_release"}, k = 1, mv = {1, 9, 0}, xi = 48)
/* loaded from: classes3.dex */
public final class DataNotificationtToDomainNotificationMapper implements Mapper<DataNotification, DomainNotification> {
    @Override // com.sputnik.domain.common.Mapper
    public DomainNotification map(DataNotification input) {
        ArrayList arrayList;
        Intrinsics.checkNotNullParameter(input, "input");
        Integer id = input.getId();
        String identifier = input.getIdentifier();
        String identifierHuman = input.getIdentifierHuman();
        String title = input.getTitle();
        String deeplink = input.getDeeplink();
        String message = input.getMessage();
        Boolean viewed = input.getViewed();
        String createdAt = input.getCreatedAt();
        if (input.getButtons() != null) {
            List<DataNotification.DataButton> buttons = input.getButtons();
            ArrayList arrayList2 = new ArrayList(CollectionsKt.collectionSizeOrDefault(buttons, 10));
            for (Iterator it = buttons.iterator(); it.hasNext(); it = it) {
                DataNotification.DataButton dataButton = (DataNotification.DataButton) it.next();
                arrayList2.add(new DomainNotification.DomainButton(dataButton.getType(), dataButton.getColor(), dataButton.getDeeplink(), dataButton.getTitle(), dataButton.getLink()));
            }
            arrayList = arrayList2;
        } else {
            arrayList = null;
        }
        return new DomainNotification(id, identifier, identifierHuman, title, deeplink, message, viewed, createdAt, arrayList);
    }
}

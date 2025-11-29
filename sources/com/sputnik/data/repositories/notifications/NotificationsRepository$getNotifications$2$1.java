package com.sputnik.data.repositories.notifications;

import com.sputnik.data.entities.notifications.DataNotification;
import com.sputnik.domain.common.ListMapper;
import com.sputnik.domain.entities.notifications.DomainNotification;
import java.util.List;
import kotlin.Metadata;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.FunctionReferenceImpl;
import kotlin.jvm.internal.Intrinsics;

/* compiled from: NotificationsRepository.kt */
@Metadata(k = 3, mv = {1, 9, 0}, xi = 48)
/* loaded from: classes3.dex */
/* synthetic */ class NotificationsRepository$getNotifications$2$1 extends FunctionReferenceImpl implements Function1<List<? extends DataNotification>, List<? extends DomainNotification>> {
    NotificationsRepository$getNotifications$2$1(Object obj) {
        super(1, obj, ListMapper.class, "map", "map(Ljava/lang/Object;)Ljava/lang/Object;", 0);
    }

    @Override // kotlin.jvm.functions.Function1
    public /* bridge */ /* synthetic */ List<? extends DomainNotification> invoke(List<? extends DataNotification> list) {
        return invoke2((List<DataNotification>) list);
    }

    /* renamed from: invoke, reason: avoid collision after fix types in other method */
    public final List<DomainNotification> invoke2(List<DataNotification> p0) {
        Intrinsics.checkNotNullParameter(p0, "p0");
        return (List) ((ListMapper) this.receiver).map(p0);
    }
}

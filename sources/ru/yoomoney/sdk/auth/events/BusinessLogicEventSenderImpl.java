package ru.yoomoney.sdk.auth.events;

import java.util.Iterator;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

@Metadata(d1 = {"\u0000\u001e\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\b\u0000\u0018\u00002\u00020\u0001B\r\u0012\u0006\u0010\u0002\u001a\u00020\u0003¢\u0006\u0002\u0010\u0004J\u0010\u0010\u0005\u001a\u00020\u00062\u0006\u0010\u0007\u001a\u00020\bH\u0016R\u000e\u0010\u0002\u001a\u00020\u0003X\u0082\u0004¢\u0006\u0002\n\u0000¨\u0006\t"}, d2 = {"Lru/yoomoney/sdk/auth/events/BusinessLogicEventSenderImpl;", "Lru/yoomoney/sdk/auth/events/BusinessLogicEventSender;", "eventSubscriber", "Lru/yoomoney/sdk/auth/events/BusinessLogicEventSubscriber;", "(Lru/yoomoney/sdk/auth/events/BusinessLogicEventSubscriber;)V", "send", "", "event", "Lru/yoomoney/sdk/auth/events/BusinessLogicEvent;", "auth_release"}, k = 1, mv = {1, 9, 0}, xi = 48)
/* loaded from: classes4.dex */
public final class BusinessLogicEventSenderImpl implements BusinessLogicEventSender {
    private final BusinessLogicEventSubscriber eventSubscriber;

    public BusinessLogicEventSenderImpl(BusinessLogicEventSubscriber eventSubscriber) {
        Intrinsics.checkNotNullParameter(eventSubscriber, "eventSubscriber");
        this.eventSubscriber = eventSubscriber;
    }

    @Override // ru.yoomoney.sdk.auth.events.BusinessLogicEventSender
    public void send(BusinessLogicEvent event) {
        Intrinsics.checkNotNullParameter(event, "event");
        Iterator<T> it = this.eventSubscriber.getSubscribers().iterator();
        while (it.hasNext()) {
            ((BusinessLogicEventListener) it.next()).onNewEvent(event);
        }
    }
}

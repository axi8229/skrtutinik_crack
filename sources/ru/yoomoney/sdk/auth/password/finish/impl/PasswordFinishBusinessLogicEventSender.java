package ru.yoomoney.sdk.auth.password.finish.impl;

import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import ru.yoomoney.sdk.auth.events.BusinessLogicEvent;
import ru.yoomoney.sdk.auth.events.BusinessLogicEventSender;
import ru.yoomoney.sdk.auth.password.finish.PasswordFinish;

@Metadata(d1 = {"\u0000\u0018\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u0002\n\u0000\b\u0000\u0018\u00002\u00020\u0001B\r\u0012\u0006\u0010\u0002\u001a\u00020\u0003¢\u0006\u0002\u0010\u0004J\b\u0010\u0005\u001a\u00020\u0006H\u0016R\u000e\u0010\u0002\u001a\u00020\u0003X\u0082\u0004¢\u0006\u0002\n\u0000¨\u0006\u0007"}, d2 = {"Lru/yoomoney/sdk/auth/password/finish/impl/PasswordFinishBusinessLogicEventSender;", "Lru/yoomoney/sdk/auth/password/finish/PasswordFinish$BusinessLogicEventsSender;", "eventsSender", "Lru/yoomoney/sdk/auth/events/BusinessLogicEventSender;", "(Lru/yoomoney/sdk/auth/events/BusinessLogicEventSender;)V", "send", "", "auth_release"}, k = 1, mv = {1, 9, 0}, xi = 48)
/* loaded from: classes4.dex */
public final class PasswordFinishBusinessLogicEventSender implements PasswordFinish.BusinessLogicEventsSender {
    private final BusinessLogicEventSender eventsSender;

    public PasswordFinishBusinessLogicEventSender(BusinessLogicEventSender eventsSender) {
        Intrinsics.checkNotNullParameter(eventsSender, "eventsSender");
        this.eventsSender = eventsSender;
    }

    @Override // ru.yoomoney.sdk.auth.password.finish.PasswordFinish.BusinessLogicEventsSender
    public void send() {
        this.eventsSender.send(BusinessLogicEvent.PasswordChangeSuccess.INSTANCE);
    }
}

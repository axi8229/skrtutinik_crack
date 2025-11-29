package ru.yoomoney.sdk.auth.events;

import kotlin.Metadata;
import kotlin.jvm.internal.DefaultConstructorMarker;

@Metadata(d1 = {"\u0000\u0012\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\b6\u0018\u00002\u00020\u0001:\u0001\u0003B\u0007\b\u0004¢\u0006\u0002\u0010\u0002\u0082\u0001\u0001\u0004¨\u0006\u0005"}, d2 = {"Lru/yoomoney/sdk/auth/events/BusinessLogicEvent;", "", "()V", "PasswordChangeSuccess", "Lru/yoomoney/sdk/auth/events/BusinessLogicEvent$PasswordChangeSuccess;", "auth_release"}, k = 1, mv = {1, 9, 0}, xi = 48)
/* loaded from: classes4.dex */
public abstract class BusinessLogicEvent {

    @Metadata(d1 = {"\u0000\u0012\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0000\bÆ\u0002\u0018\u00002\u00020\u0001B\u0007\b\u0002¢\u0006\u0002\u0010\u0002J\b\u0010\u0003\u001a\u00020\u0004H\u0016¨\u0006\u0005"}, d2 = {"Lru/yoomoney/sdk/auth/events/BusinessLogicEvent$PasswordChangeSuccess;", "Lru/yoomoney/sdk/auth/events/BusinessLogicEvent;", "()V", "toString", "", "auth_release"}, k = 1, mv = {1, 9, 0}, xi = 48)
    public static final class PasswordChangeSuccess extends BusinessLogicEvent {
        public static final PasswordChangeSuccess INSTANCE = new PasswordChangeSuccess();

        private PasswordChangeSuccess() {
            super(null);
        }

        public String toString() {
            return "PasswordChangeSuccess";
        }
    }

    private BusinessLogicEvent() {
    }

    public /* synthetic */ BusinessLogicEvent(DefaultConstructorMarker defaultConstructorMarker) {
        this();
    }
}

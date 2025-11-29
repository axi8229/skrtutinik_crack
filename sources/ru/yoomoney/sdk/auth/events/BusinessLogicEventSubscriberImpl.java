package ru.yoomoney.sdk.auth.events;

import com.google.android.gms.common.internal.ServiceSpecificExtraArgs;
import java.util.ArrayList;
import java.util.List;
import kotlin.Metadata;
import kotlin.collections.CollectionsKt;
import kotlin.jvm.internal.Intrinsics;

@Metadata(d1 = {"\u0000$\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010!\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010 \n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0003\b\u0000\u0018\u00002\u00020\u0001B\u0005¢\u0006\u0002\u0010\u0002J\u000e\u0010\u0006\u001a\b\u0012\u0004\u0012\u00020\u00050\u0007H\u0016J\u0010\u0010\b\u001a\u00020\t2\u0006\u0010\n\u001a\u00020\u0005H\u0016J\u0010\u0010\u000b\u001a\u00020\t2\u0006\u0010\n\u001a\u00020\u0005H\u0016R\u0014\u0010\u0003\u001a\b\u0012\u0004\u0012\u00020\u00050\u0004X\u0082\u0004¢\u0006\u0002\n\u0000¨\u0006\f"}, d2 = {"Lru/yoomoney/sdk/auth/events/BusinessLogicEventSubscriberImpl;", "Lru/yoomoney/sdk/auth/events/BusinessLogicEventSubscriber;", "()V", "subscribers", "", "Lru/yoomoney/sdk/auth/events/BusinessLogicEventListener;", "getSubscribers", "", "subscribe", "", ServiceSpecificExtraArgs.CastExtraArgs.LISTENER, "unsubscribe", "auth_release"}, k = 1, mv = {1, 9, 0}, xi = 48)
/* loaded from: classes4.dex */
public final class BusinessLogicEventSubscriberImpl implements BusinessLogicEventSubscriber {
    private final List<BusinessLogicEventListener> subscribers = new ArrayList();

    @Override // ru.yoomoney.sdk.auth.events.BusinessLogicEventSubscriber
    public List<BusinessLogicEventListener> getSubscribers() {
        return CollectionsKt.toList(this.subscribers);
    }

    @Override // ru.yoomoney.sdk.auth.events.BusinessLogicEventSubscriber
    public void subscribe(BusinessLogicEventListener listener) {
        Intrinsics.checkNotNullParameter(listener, "listener");
        if (this.subscribers.contains(listener)) {
            return;
        }
        this.subscribers.add(listener);
    }

    @Override // ru.yoomoney.sdk.auth.events.BusinessLogicEventSubscriber
    public void unsubscribe(BusinessLogicEventListener listener) {
        Intrinsics.checkNotNullParameter(listener, "listener");
        this.subscribers.remove(listener);
    }
}

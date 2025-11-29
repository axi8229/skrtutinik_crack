package ru.yoomoney.sdk.auth.events;

import com.google.android.gms.common.internal.ServiceSpecificExtraArgs;
import java.util.List;
import kotlin.Metadata;

@Metadata(d1 = {"\u0000\u001c\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0003\bf\u0018\u00002\u00020\u0001J\u000e\u0010\u0002\u001a\b\u0012\u0004\u0012\u00020\u00040\u0003H&J\u0010\u0010\u0005\u001a\u00020\u00062\u0006\u0010\u0007\u001a\u00020\u0004H&J\u0010\u0010\b\u001a\u00020\u00062\u0006\u0010\u0007\u001a\u00020\u0004H&¨\u0006\t"}, d2 = {"Lru/yoomoney/sdk/auth/events/BusinessLogicEventSubscriber;", "", "getSubscribers", "", "Lru/yoomoney/sdk/auth/events/BusinessLogicEventListener;", "subscribe", "", ServiceSpecificExtraArgs.CastExtraArgs.LISTENER, "unsubscribe", "auth_release"}, k = 1, mv = {1, 9, 0}, xi = 48)
/* loaded from: classes4.dex */
public interface BusinessLogicEventSubscriber {
    List<BusinessLogicEventListener> getSubscribers();

    void subscribe(BusinessLogicEventListener listener);

    void unsubscribe(BusinessLogicEventListener listener);
}

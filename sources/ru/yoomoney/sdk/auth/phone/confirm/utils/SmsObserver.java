package ru.yoomoney.sdk.auth.phone.confirm.utils;

import com.google.android.gms.common.internal.ServiceSpecificExtraArgs;
import kotlin.Metadata;

@Metadata(d1 = {"\u0000 \n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0004\b`\u0018\u00002\u00020\u0001:\u0001\u000eJ\u0010\u0010\b\u001a\u00020\t2\u0006\u0010\n\u001a\u00020\u000bH&J\b\u0010\f\u001a\u00020\tH&J\b\u0010\r\u001a\u00020\tH&R\u001a\u0010\u0002\u001a\u0004\u0018\u00010\u0003X¦\u000e¢\u0006\f\u001a\u0004\b\u0004\u0010\u0005\"\u0004\b\u0006\u0010\u0007¨\u0006\u000f"}, d2 = {"Lru/yoomoney/sdk/auth/phone/confirm/utils/SmsObserver;", "", ServiceSpecificExtraArgs.CastExtraArgs.LISTENER, "Lru/yoomoney/sdk/auth/phone/confirm/utils/SmsObserver$Listener;", "getListener", "()Lru/yoomoney/sdk/auth/phone/confirm/utils/SmsObserver$Listener;", "setListener", "(Lru/yoomoney/sdk/auth/phone/confirm/utils/SmsObserver$Listener;)V", "init", "", "parser", "Lru/yoomoney/sdk/auth/phone/confirm/utils/SmsParser;", "startObserver", "stopObserver", "Listener", "auth_release"}, k = 1, mv = {1, 9, 0}, xi = 48)
/* loaded from: classes4.dex */
public interface SmsObserver {

    @Metadata(d1 = {"\u0000\u0016\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0010\u000e\n\u0000\bf\u0018\u00002\u00020\u0001J\u0010\u0010\u0002\u001a\u00020\u00032\u0006\u0010\u0004\u001a\u00020\u0005H&¨\u0006\u0006"}, d2 = {"Lru/yoomoney/sdk/auth/phone/confirm/utils/SmsObserver$Listener;", "", "onSmsAnswer", "", "answer", "", "auth_release"}, k = 1, mv = {1, 9, 0}, xi = 48)
    public interface Listener {
        void onSmsAnswer(String answer);
    }

    Listener getListener();

    void init(SmsParser parser);

    void setListener(Listener listener);

    void startObserver();

    void stopObserver();
}

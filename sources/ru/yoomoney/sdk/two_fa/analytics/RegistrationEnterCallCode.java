package ru.yoomoney.sdk.two_fa.analytics;

import kotlin.Metadata;

/* compiled from: AnalyticsEvent.kt */
@Metadata(d1 = {"\u0000\f\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\bÇ\u0002\u0018\u00002\u00020\u0001B\u0007\b\u0002¢\u0006\u0002\u0010\u0002¨\u0006\u0003"}, d2 = {"Lru/yoomoney/sdk/two_fa/analytics/RegistrationEnterCallCode;", "Lru/yoomoney/sdk/two_fa/analytics/AnalyticsEvent;", "()V", "two-fa_release"}, k = 1, mv = {1, 9, 0}, xi = 48)
/* loaded from: classes5.dex */
public final class RegistrationEnterCallCode extends AnalyticsEvent {
    public static final int $stable = 0;
    public static final RegistrationEnterCallCode INSTANCE = new RegistrationEnterCallCode();

    private RegistrationEnterCallCode() {
        super("registration.EnterCallCode", null, 2, null);
    }
}

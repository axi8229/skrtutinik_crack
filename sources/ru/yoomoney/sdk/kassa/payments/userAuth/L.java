package ru.yoomoney.sdk.kassa.payments.userAuth;

import java.util.List;
import kotlin.jvm.internal.Intrinsics;
import ru.yoomoney.sdk.auth.analytics.AnalyticsEvent;
import ru.yoomoney.sdk.auth.analytics.AnalyticsLogger;

/* loaded from: classes5.dex */
public final class L implements AnalyticsLogger {
    public final /* synthetic */ T a;

    public L(T t) {
        this.a = t;
    }

    @Override // ru.yoomoney.sdk.auth.analytics.AnalyticsLogger
    public final void onNewEvent(AnalyticsEvent event) {
        Intrinsics.checkNotNullParameter(event, "event");
        ru.yoomoney.sdk.kassa.payments.metrics.F f = this.a.b;
        if (f == null) {
            Intrinsics.throwUninitializedPropertyAccessException("reporter");
            f = null;
        }
        f.a(event.toString(), (List) null);
    }
}

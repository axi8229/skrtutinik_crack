package ru.yoomoney.sdk.two_fa;

import android.content.Context;
import android.content.Intent;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import ru.yoomoney.sdk.two_fa.analytics.AnalyticsLogger;

/* compiled from: YooMoneyTwoFa.kt */
@Metadata(d1 = {"\u0000.\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0002\bÇ\u0002\u0018\u00002\u00020\u0001B\u0007\b\u0002¢\u0006\u0002\u0010\u0002J\u0016\u0010\b\u001a\u00020\t2\u0006\u0010\n\u001a\u00020\u000b2\u0006\u0010\f\u001a\u00020\rJ\u000e\u0010\u000e\u001a\u00020\u000f2\u0006\u0010\u0010\u001a\u00020\u0004R\"\u0010\u0005\u001a\u0004\u0018\u00010\u00042\b\u0010\u0003\u001a\u0004\u0018\u00010\u0004@BX\u0080\u000e¢\u0006\b\n\u0000\u001a\u0004\b\u0006\u0010\u0007¨\u0006\u0011"}, d2 = {"Lru/yoomoney/sdk/two_fa/YooMoneyTwoFa;", "", "()V", "<set-?>", "Lru/yoomoney/sdk/two_fa/analytics/AnalyticsLogger;", "twoFaAnalyticsLogger", "getTwoFaAnalyticsLogger$two_fa_release", "()Lru/yoomoney/sdk/two_fa/analytics/AnalyticsLogger;", "confirm", "Landroid/content/Intent;", "context", "Landroid/content/Context;", "config", "Lru/yoomoney/sdk/two_fa/Config;", "initTwoFaAnalyticsLogger", "", "eventListener", "two-fa_release"}, k = 1, mv = {1, 9, 0}, xi = 48)
/* loaded from: classes5.dex */
public final class YooMoneyTwoFa {
    private static AnalyticsLogger twoFaAnalyticsLogger;
    public static final YooMoneyTwoFa INSTANCE = new YooMoneyTwoFa();
    public static final int $stable = 8;

    private YooMoneyTwoFa() {
    }

    public final AnalyticsLogger getTwoFaAnalyticsLogger$two_fa_release() {
        return twoFaAnalyticsLogger;
    }

    public final void initTwoFaAnalyticsLogger(AnalyticsLogger eventListener) {
        Intrinsics.checkNotNullParameter(eventListener, "eventListener");
        twoFaAnalyticsLogger = eventListener;
    }

    public final Intent confirm(Context context, Config config) {
        Intrinsics.checkNotNullParameter(context, "context");
        Intrinsics.checkNotNullParameter(config, "config");
        return EntryPointActivity.INSTANCE.createIntent(context, config);
    }
}

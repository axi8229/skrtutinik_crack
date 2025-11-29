package ru.yoomoney.sdk.kassa.payments.config;

import android.content.SharedPreferences;
import kotlin.jvm.internal.Intrinsics;
import ru.yoomoney.sdk.kassa.payments.checkoutParameters.HostParameters;
import ru.yoomoney.sdk.kassa.payments.metrics.InterfaceC2308q;
import ru.yoomoney.sdk.kassa.payments.metrics.h0;
import ru.yoomoney.sdk.kassa.payments.model.AbstractC2334s;
import ru.yoomoney.sdk.kassa.payments.model.Config;
import ru.yoomoney.sdk.kassa.payments.model.o0;

/* loaded from: classes5.dex */
public final class b implements f {
    public final HostParameters a;
    public final Config b;
    public final ru.yoomoney.sdk.kassa.payments.api.config.c c;
    public final SharedPreferences d;
    public final InterfaceC2308q e;

    public b(HostParameters hostParameters, Config getDefaultConfig, ru.yoomoney.sdk.kassa.payments.api.config.c configRequestApi, SharedPreferences sp, InterfaceC2308q errorReporter) {
        Intrinsics.checkNotNullParameter(hostParameters, "hostParameters");
        Intrinsics.checkNotNullParameter(getDefaultConfig, "getDefaultConfig");
        Intrinsics.checkNotNullParameter(configRequestApi, "configRequestApi");
        Intrinsics.checkNotNullParameter(sp, "sp");
        Intrinsics.checkNotNullParameter(errorReporter, "errorReporter");
        this.a = hostParameters;
        this.b = getDefaultConfig;
        this.c = configRequestApi;
        this.d = sp;
        this.e = errorReporter;
    }

    @Override // ru.yoomoney.sdk.kassa.payments.config.f
    public final Config a() {
        return b();
    }

    public final Config b() {
        Config configA;
        String string = this.d.getString("config_" + ru.yoomoney.sdk.kassa.payments.utils.f.a(), null);
        if (string != null) {
            try {
                configA = AbstractC2334s.a(string, this.a);
            } catch (Throwable th) {
                ((h0) this.e).a(new o0(th));
                configA = this.b;
            }
            if (configA != null) {
                return configA;
            }
        }
        return this.b;
    }

    /* JADX WARN: Removed duplicated region for block: B:7:0x0017  */
    @Override // ru.yoomoney.sdk.kassa.payments.config.f
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    public final java.lang.Object a(kotlin.coroutines.Continuation r35) {
        /*
            Method dump skipped, instructions count: 353
            To view this dump change 'Code comments level' option to 'DEBUG'
        */
        throw new UnsupportedOperationException("Method not decompiled: ru.yoomoney.sdk.kassa.payments.config.b.a(kotlin.coroutines.Continuation):java.lang.Object");
    }

    public final void a(Config config) {
        this.d.edit().putString("config_" + ru.yoomoney.sdk.kassa.payments.utils.f.a(), AbstractC2334s.a(config)).apply();
    }
}

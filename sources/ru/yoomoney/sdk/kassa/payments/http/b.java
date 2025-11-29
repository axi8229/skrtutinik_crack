package ru.yoomoney.sdk.kassa.payments.http;

import kotlin.jvm.internal.Intrinsics;
import ru.yoomoney.sdk.kassa.payments.checkoutParameters.HostParameters;

/* loaded from: classes5.dex */
public final class b implements a {
    public final ru.yoomoney.sdk.kassa.payments.config.f a;
    public final HostParameters b;
    public final boolean c;

    public b(ru.yoomoney.sdk.kassa.payments.config.f configRepository, HostParameters hostParameters) {
        Intrinsics.checkNotNullParameter(configRepository, "configRepository");
        Intrinsics.checkNotNullParameter(hostParameters, "hostParameters");
        this.a = configRepository;
        this.b = hostParameters;
        this.c = hostParameters.getIsDevHost();
    }

    public final String a() {
        return this.c ? this.b.getAuthHost() : this.a.a().getYooMoneyAuthApiEndpoint();
    }

    public final String b() {
        return this.c ? this.b.getHost() : this.a.a().getYooMoneyApiEndpoint();
    }

    public final String c() {
        return this.c ? this.b.getPaymentAuthorizationHost() : this.a.a().getYooMoneyPaymentAuthorizationApiEndpoint();
    }
}

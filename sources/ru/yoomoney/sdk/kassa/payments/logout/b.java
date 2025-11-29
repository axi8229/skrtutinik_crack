package ru.yoomoney.sdk.kassa.payments.logout;

import kotlin.jvm.functions.Function0;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.Intrinsics;
import ru.yoomoney.sdk.kassa.payments.paymentAuth.r1;
import ru.yoomoney.sdk.kassa.payments.secure.j;
import ru.yoomoney.sdk.kassa.payments.userAuth.U;

/* loaded from: classes5.dex */
public final class b implements a {
    public final ru.yoomoney.sdk.kassa.payments.payment.b a;
    public final U b;
    public final r1 c;
    public final ru.yoomoney.sdk.kassa.payments.payment.c d;
    public final ru.yoomoney.sdk.kassa.payments.tmx.a e;
    public final Function0 f;
    public final Function1 g;

    public b(ru.yoomoney.sdk.kassa.payments.payment.b currentUserRepository, j userAuthInfoRepository, r1 paymentAuthTokenRepository, ru.yoomoney.sdk.kassa.payments.payment.c loadedPaymentOptionListRepository, ru.yoomoney.sdk.kassa.payments.tmx.a profilingSessionIdStorage, ru.yoomoney.sdk.kassa.payments.contract.di.a removeKeys, ru.yoomoney.sdk.kassa.payments.contract.di.b revokeUserAuthToken) {
        Intrinsics.checkNotNullParameter(currentUserRepository, "currentUserRepository");
        Intrinsics.checkNotNullParameter(userAuthInfoRepository, "userAuthInfoRepository");
        Intrinsics.checkNotNullParameter(paymentAuthTokenRepository, "paymentAuthTokenRepository");
        Intrinsics.checkNotNullParameter(loadedPaymentOptionListRepository, "loadedPaymentOptionListRepository");
        Intrinsics.checkNotNullParameter(profilingSessionIdStorage, "profilingSessionIdStorage");
        Intrinsics.checkNotNullParameter(removeKeys, "removeKeys");
        Intrinsics.checkNotNullParameter(revokeUserAuthToken, "revokeUserAuthToken");
        this.a = currentUserRepository;
        this.b = userAuthInfoRepository;
        this.c = paymentAuthTokenRepository;
        this.d = loadedPaymentOptionListRepository;
        this.e = profilingSessionIdStorage;
        this.f = removeKeys;
        this.g = revokeUserAuthToken;
    }
}

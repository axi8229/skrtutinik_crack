package ru.yoomoney.sdk.kassa.payments.userAuth.di;

import android.content.Context;
import dagger.internal.Factory;
import dagger.internal.Preconditions;
import javax.inject.Provider;
import kotlin.jvm.internal.Intrinsics;
import ru.yoomoney.sdk.auth.YooMoneyAuth;
import ru.yoomoney.sdk.auth.transferData.TransferDataRepository;
import ru.yoomoney.sdk.kassa.payments.checkoutParameters.PaymentParameters;

/* loaded from: classes5.dex */
public final class i implements Factory {
    public final d a;
    public final Provider b;
    public final Provider c;
    public final Provider d;

    public i(d dVar, Factory factory, dagger.internal.Provider provider, dagger.internal.Provider provider2) {
        this.a = dVar;
        this.b = factory;
        this.c = provider;
        this.d = provider2;
    }

    @Override // javax.inject.Provider
    public final Object get() {
        d dVar = this.a;
        Context context = (Context) this.b.get();
        PaymentParameters paymentParameters = (PaymentParameters) this.c.get();
        ru.yoomoney.sdk.kassa.payments.http.a hostProvider = (ru.yoomoney.sdk.kassa.payments.http.a) this.d.get();
        dVar.getClass();
        Intrinsics.checkNotNullParameter(context, "context");
        Intrinsics.checkNotNullParameter(paymentParameters, "paymentParameters");
        Intrinsics.checkNotNullParameter(hostProvider, "hostProvider");
        YooMoneyAuth yooMoneyAuth = YooMoneyAuth.INSTANCE;
        String authCenterClientId = paymentParameters.getAuthCenterClientId();
        if (authCenterClientId == null) {
            throw new IllegalArgumentException("Required value was null.");
        }
        ru.yoomoney.sdk.kassa.payments.http.b bVar = (ru.yoomoney.sdk.kassa.payments.http.b) hostProvider;
        String strA = bVar.a();
        if (strA == null || strA.length() == 0) {
            strA = "https://yoomoney.ru";
        }
        String str = strA;
        String strA2 = bVar.a();
        return (TransferDataRepository) Preconditions.checkNotNullFromProvides(YooMoneyAuth.provideTransferDataRepository$default(yooMoneyAuth, context, authCenterClientId, str, !(strA2 == null || strA2.length() == 0), null, 16, null));
    }
}

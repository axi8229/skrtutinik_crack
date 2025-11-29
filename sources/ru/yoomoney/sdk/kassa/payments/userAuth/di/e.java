package ru.yoomoney.sdk.kassa.payments.userAuth.di;

import android.content.Context;
import dagger.internal.Factory;
import dagger.internal.Preconditions;
import javax.inject.Provider;
import kotlin.jvm.internal.Intrinsics;
import ru.yoomoney.sdk.auth.YooMoneyAuth;
import ru.yoomoney.sdk.auth.api.account.AccountRepository;

/* loaded from: classes5.dex */
public final class e implements Factory {
    public final d a;
    public final Provider b;
    public final Provider c;

    public e(d dVar, Factory factory, dagger.internal.Provider provider) {
        this.a = dVar;
        this.b = factory;
        this.c = provider;
    }

    @Override // javax.inject.Provider
    public final Object get() {
        d dVar = this.a;
        Context context = (Context) this.b.get();
        ru.yoomoney.sdk.kassa.payments.http.a hostProvider = (ru.yoomoney.sdk.kassa.payments.http.a) this.c.get();
        dVar.getClass();
        Intrinsics.checkNotNullParameter(context, "context");
        Intrinsics.checkNotNullParameter(hostProvider, "hostProvider");
        YooMoneyAuth yooMoneyAuth = YooMoneyAuth.INSTANCE;
        ru.yoomoney.sdk.kassa.payments.http.b bVar = (ru.yoomoney.sdk.kassa.payments.http.b) hostProvider;
        String strA = bVar.a();
        if (strA == null || strA.length() == 0) {
            strA = "https://yoomoney.ru";
        }
        String str = strA;
        String strA2 = bVar.a();
        return (AccountRepository) Preconditions.checkNotNullFromProvides(YooMoneyAuth.provideAccountRepository$default(yooMoneyAuth, context, str, !(strA2 == null || strA2.length() == 0), null, 8, null));
    }
}

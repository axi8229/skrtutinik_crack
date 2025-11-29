package ru.yoomoney.sdk.kassa.payments.di.module;

import android.content.Context;
import android.content.SharedPreferences;
import dagger.internal.Factory;
import dagger.internal.Preconditions;
import javax.inject.Provider;
import kotlin.jvm.internal.Intrinsics;
import ru.yoomoney.sdk.kassa.payments.checkoutParameters.TestParameters;

/* loaded from: classes5.dex */
public final class Z implements Factory {
    public final Y a;
    public final Provider b;
    public final Provider c;

    public Z(Y y, dagger.internal.Provider provider, dagger.internal.Provider provider2) {
        this.a = y;
        this.b = provider;
        this.c = provider2;
    }

    @Override // javax.inject.Provider
    public final Object get() {
        Y y = this.a;
        Context context = (Context) this.b.get();
        TestParameters testParameters = (TestParameters) this.c.get();
        y.getClass();
        Intrinsics.checkNotNullParameter(context, "context");
        Intrinsics.checkNotNullParameter(testParameters, "testParameters");
        SharedPreferences sharedPreferences = context.getApplicationContext().getSharedPreferences(testParameters.getMockConfiguration() == null ? "userStorageRealMode" : "userStorageTestMode", 0);
        Intrinsics.checkNotNullExpressionValue(sharedPreferences, "getSharedPreferences(...)");
        return (SharedPreferences) Preconditions.checkNotNullFromProvides(sharedPreferences);
    }
}

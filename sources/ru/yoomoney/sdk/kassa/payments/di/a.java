package ru.yoomoney.sdk.kassa.payments.di;

import android.content.Context;
import dagger.internal.Preconditions;
import kotlin.jvm.internal.Intrinsics;
import ru.yoomoney.sdk.kassa.payments.checkoutParameters.PaymentParameters;
import ru.yoomoney.sdk.kassa.payments.checkoutParameters.TestParameters;
import ru.yoomoney.sdk.kassa.payments.checkoutParameters.UiParameters;
import ru.yoomoney.sdk.kassa.payments.di.module.A;
import ru.yoomoney.sdk.kassa.payments.di.module.C2267a;
import ru.yoomoney.sdk.kassa.payments.di.module.C2275i;
import ru.yoomoney.sdk.kassa.payments.di.module.C2277k;
import ru.yoomoney.sdk.kassa.payments.di.module.C2280n;
import ru.yoomoney.sdk.kassa.payments.di.module.C2282p;
import ru.yoomoney.sdk.kassa.payments.di.module.C2288w;
import ru.yoomoney.sdk.kassa.payments.di.module.F;
import ru.yoomoney.sdk.kassa.payments.di.module.H;
import ru.yoomoney.sdk.kassa.payments.di.module.J;
import ru.yoomoney.sdk.kassa.payments.di.module.N;
import ru.yoomoney.sdk.kassa.payments.di.module.U;
import ru.yoomoney.sdk.kassa.payments.di.module.Y;
import ru.yoomoney.sdk.kassa.payments.di.module.e0;
import ru.yoomoney.sdk.kassa.payments.di.module.j0;
import ru.yoomoney.sdk.kassa.payments.di.module.l0;
import ru.yoomoney.sdk.kassa.payments.di.module.m0;
import ru.yoomoney.sdk.kassa.payments.di.module.r;
import ru.yoomoney.sdk.kassa.payments.ui.color.InMemoryColorSchemeRepository;
import ru.yoomoney.sdk.kassa.payments.ui.view.BankCardView;

/* loaded from: classes5.dex */
public final class a {
    public static ru.yoomoney.sdk.kassa.payments.di.component.c a;
    public static ru.yoomoney.sdk.kassa.payments.di.component.a b;
    public static ru.yoomoney.sdk.kassa.payments.di.component.b c;

    public static void a(BankCardView bankCardView) {
        Intrinsics.checkNotNullParameter(bankCardView, "bankCardView");
        ru.yoomoney.sdk.kassa.payments.di.component.a aVar = b;
        if (aVar == null) {
            Intrinsics.throwUninitializedPropertyAccessException("checkoutComponent");
            aVar = null;
        }
        aVar.getClass();
    }

    public static void a(boolean z, Context context, String str, TestParameters testParameters, UiParameters uiParameters, PaymentParameters paymentParameters, int i) {
        boolean z2;
        j0 j0Var;
        H h;
        C2288w c2288w;
        PaymentParameters paymentParametersCopy;
        String customReturnUrl;
        String clientApplicationKey = (i & 4) != 0 ? null : str;
        PaymentParameters paymentParameters2 = (i & 32) != 0 ? null : paymentParameters;
        C2288w okHttpModule = new C2288w();
        H paymentOptionsListModule = new H();
        j0 tokensStorageModule = new j0(false);
        Intrinsics.checkNotNullParameter(context, "context");
        Intrinsics.checkNotNullParameter(testParameters, "testParameters");
        Intrinsics.checkNotNullParameter(uiParameters, "uiParameters");
        Intrinsics.checkNotNullParameter(okHttpModule, "okHttpModule");
        Intrinsics.checkNotNullParameter(paymentOptionsListModule, "paymentOptionsListModule");
        Intrinsics.checkNotNullParameter(tokensStorageModule, "tokensStorageModule");
        if (paymentParameters2 != null && paymentParameters2.getPaymentMethodTypes().isEmpty() && (clientApplicationKey == null || clientApplicationKey.length() == 0)) {
            PaymentParameters paymentParameters3 = paymentParameters2;
            z2 = false;
            j0Var = tokensStorageModule;
            h = paymentOptionsListModule;
            c2288w = okHttpModule;
            paymentParametersCopy = paymentParameters3.copy((8127 & 1) != 0 ? paymentParameters3.amount : null, (8127 & 2) != 0 ? paymentParameters3.title : null, (8127 & 4) != 0 ? paymentParameters3.subtitle : null, (8127 & 8) != 0 ? paymentParameters3.clientApplicationKey : null, (8127 & 16) != 0 ? paymentParameters3.shopId : null, (8127 & 32) != 0 ? paymentParameters3.savePaymentMethod : null, (8127 & 64) != 0 ? paymentParameters3.paymentMethodTypes : ru.yoomoney.sdk.kassa.payments.utils.h.a(), (8127 & 128) != 0 ? paymentParameters3.gatewayId : null, (8127 & 256) != 0 ? paymentParameters3.customReturnUrl : null, (8127 & 512) != 0 ? paymentParameters3.userPhoneNumber : null, (8127 & 1024) != 0 ? paymentParameters3.googlePayParameters : null, (8127 & 2048) != 0 ? paymentParameters3.authCenterClientId : null, (8127 & 4096) != 0 ? paymentParameters3.customerId : null);
        } else {
            z2 = false;
            j0Var = tokensStorageModule;
            h = paymentOptionsListModule;
            c2288w = okHttpModule;
            paymentParametersCopy = (paymentParameters2 == null || !(clientApplicationKey == null || clientApplicationKey.length() == 0)) ? null : paymentParameters2;
        }
        if (paymentParametersCopy != null && (customReturnUrl = paymentParametersCopy.getCustomReturnUrl()) != null) {
            ru.yoomoney.sdk.kassa.payments.utils.c.a(customReturnUrl);
        }
        InMemoryColorSchemeRepository.INSTANCE.setColorScheme(uiParameters.getColorScheme());
        ru.yoomoney.sdk.kassa.payments.extensions.b.a(context);
        Context applicationContext = context.getApplicationContext();
        Intrinsics.checkNotNullExpressionValue(applicationContext, "getApplicationContext(...)");
        Context context2 = (Context) Preconditions.checkNotNull(applicationContext);
        C2288w c2288w2 = (C2288w) Preconditions.checkNotNull(c2288w);
        j0 j0Var2 = (j0) Preconditions.checkNotNull(j0Var);
        TestParameters testParameters2 = (TestParameters) Preconditions.checkNotNull(testParameters);
        if (clientApplicationKey == null) {
            clientApplicationKey = paymentParameters2 != null ? paymentParameters2.getClientApplicationKey() : null;
            if (clientApplicationKey == null) {
                clientApplicationKey = "";
            }
        }
        String str2 = (String) Preconditions.checkNotNull(clientApplicationKey);
        Preconditions.checkBuilderRequirement(context2, Context.class);
        Preconditions.checkBuilderRequirement(testParameters2, TestParameters.class);
        Preconditions.checkBuilderRequirement(str2, String.class);
        if (c2288w2 == null) {
            c2288w2 = new C2288w();
        }
        ru.yoomoney.sdk.kassa.payments.di.component.c cVar = new ru.yoomoney.sdk.kassa.payments.di.component.c(new l0(), new Y(), new r(), new N(), c2288w2, new C2282p(), new C2267a(), new ru.yoomoney.sdk.kassa.payments.config.d(), new e0(), j0Var2 == null ? new j0(z2) : j0Var2, new m0(), new C2275i(), context2, testParameters2, str2);
        a = cVar;
        if (z) {
            c = new ru.yoomoney.sdk.kassa.payments.di.component.b(cVar, new U(), new A());
            return;
        }
        Intrinsics.checkNotNull(paymentParameters2);
        PaymentParameters paymentParameters4 = (PaymentParameters) Preconditions.checkNotNull(paymentParameters2);
        H h2 = (H) Preconditions.checkNotNull(h);
        UiParameters uiParameters2 = (UiParameters) Preconditions.checkNotNull(uiParameters);
        Preconditions.checkBuilderRequirement(paymentParameters4, PaymentParameters.class);
        Preconditions.checkBuilderRequirement(uiParameters2, UiParameters.class);
        if (h2 == null) {
            h2 = new H();
        }
        b = new ru.yoomoney.sdk.kassa.payments.di.component.a(cVar, new ru.yoomoney.sdk.kassa.payments.tokenize.di.e(), new C2280n(), new ru.yoomoney.sdk.kassa.payments.contract.di.c(), new F(), new J(), h2, new ru.yoomoney.sdk.kassa.payments.userAuth.di.d(), new ru.yoomoney.sdk.kassa.payments.paymentAuth.di.f(), new ru.yoomoney.sdk.kassa.payments.unbind.di.c(), new C2277k(), paymentParameters4, uiParameters2);
    }
}

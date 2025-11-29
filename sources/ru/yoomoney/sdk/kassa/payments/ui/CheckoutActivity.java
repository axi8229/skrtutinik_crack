package ru.yoomoney.sdk.kassa.payments.ui;

import android.app.Application;
import android.app.Dialog;
import android.os.Bundle;
import android.os.Parcelable;
import androidx.appcompat.app.AppCompatActivity;
import androidx.fragment.app.FragmentManager;
import kotlin.Lazy;
import kotlin.LazyKt;
import kotlin.Metadata;
import kotlin.NoWhenBranchMatchedException;
import kotlin.Unit;
import kotlin.collections.CollectionsKt;
import kotlin.collections.SetsKt;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.internal.Intrinsics;
import ru.yoomoney.sdk.kassa.payments.checkoutParameters.Amount;
import ru.yoomoney.sdk.kassa.payments.checkoutParameters.PaymentMethodType;
import ru.yoomoney.sdk.kassa.payments.checkoutParameters.PaymentParameters;
import ru.yoomoney.sdk.kassa.payments.checkoutParameters.SavedBankCardPaymentParameters;
import ru.yoomoney.sdk.kassa.payments.checkoutParameters.TestParameters;
import ru.yoomoney.sdk.kassa.payments.checkoutParameters.UiParameters;
import ru.yoomoney.sdk.kassa.payments.confirmation.sberpay.a0;
import ru.yoomoney.sdk.kassa.payments.di.a;
import ru.yoomoney.sdk.kassa.payments.errorFormatter.b;
import ru.yoomoney.sdk.kassa.payments.metrics.C2298g;
import ru.yoomoney.sdk.kassa.payments.metrics.C2303l;
import ru.yoomoney.sdk.kassa.payments.metrics.C2304m;
import ru.yoomoney.sdk.kassa.payments.metrics.C2305n;
import ru.yoomoney.sdk.kassa.payments.metrics.C2307p;
import ru.yoomoney.sdk.kassa.payments.metrics.C2312v;
import ru.yoomoney.sdk.kassa.payments.metrics.D;
import ru.yoomoney.sdk.kassa.payments.metrics.E;
import ru.yoomoney.sdk.kassa.payments.metrics.F;
import ru.yoomoney.sdk.kassa.payments.metrics.G;
import ru.yoomoney.sdk.kassa.payments.metrics.H;
import ru.yoomoney.sdk.kassa.payments.metrics.InterfaceC2311u;
import ru.yoomoney.sdk.kassa.payments.metrics.J;
import ru.yoomoney.sdk.kassa.payments.metrics.K;
import ru.yoomoney.sdk.kassa.payments.metrics.O;
import ru.yoomoney.sdk.kassa.payments.metrics.b0;
import ru.yoomoney.sdk.kassa.payments.metrics.c0;
import ru.yoomoney.sdk.kassa.payments.metrics.e0;
import ru.yoomoney.sdk.kassa.payments.metrics.g0;
import ru.yoomoney.sdk.kassa.payments.metrics.k0;
import ru.yoomoney.sdk.kassa.payments.model.C2318b;
import ru.yoomoney.sdk.kassa.payments.model.s0;
import ru.yoomoney.sdk.kassa.payments.secure.j;
import ru.yoomoney.sdk.kassa.payments.ui.color.ColorScheme;
import ru.yoomoney.sdk.kassa.payments.ui.model.StartScreenData;
import spay.sdk.SPaySdkApp;
import spay.sdk.SPaySdkInitConfig;
import spay.sdk.api.SPayStage;

@Metadata(d1 = {"\u0000f\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\n\n\u0002\u0018\u0002\n\u0002\b\u0006\n\u0002\u0018\u0002\n\u0002\b\u0006\n\u0002\u0018\u0002\n\u0002\b\u0006\n\u0002\u0010\u000b\n\u0002\b\n\b\u0000\u0018\u00002\u00020\u0001B\u0007¢\u0006\u0004\bG\u0010\u0004J\u000f\u0010\u0003\u001a\u00020\u0002H\u0002¢\u0006\u0004\b\u0003\u0010\u0004J\u000f\u0010\u0005\u001a\u00020\u0002H\u0002¢\u0006\u0004\b\u0005\u0010\u0004J\u0019\u0010\t\u001a\u0004\u0018\u00010\b2\u0006\u0010\u0007\u001a\u00020\u0006H\u0002¢\u0006\u0004\b\t\u0010\nJ\u000f\u0010\u000b\u001a\u00020\u0002H\u0002¢\u0006\u0004\b\u000b\u0010\u0004J\u0019\u0010\u000e\u001a\u00020\u00022\b\u0010\r\u001a\u0004\u0018\u00010\fH\u0002¢\u0006\u0004\b\u000e\u0010\u000fJ\u0017\u0010\u0012\u001a\u00020\u00022\u0006\u0010\u0011\u001a\u00020\u0010H\u0002¢\u0006\u0004\b\u0012\u0010\u0013J\u001f\u0010\u0017\u001a\u00020\u00022\u0006\u0010\u0014\u001a\u00020\f2\u0006\u0010\u0016\u001a\u00020\u0015H\u0002¢\u0006\u0004\b\u0017\u0010\u0018J\u0019\u0010\u001b\u001a\u00020\u00022\b\u0010\u001a\u001a\u0004\u0018\u00010\u0019H\u0014¢\u0006\u0004\b\u001b\u0010\u001cJ\u000f\u0010\u001d\u001a\u00020\u0002H\u0014¢\u0006\u0004\b\u001d\u0010\u0004R\"\u0010\u001f\u001a\u00020\u001e8\u0006@\u0006X\u0087.¢\u0006\u0012\n\u0004\b\u001f\u0010 \u001a\u0004\b!\u0010\"\"\u0004\b#\u0010$R\"\u0010\u0011\u001a\u00020\u00108\u0006@\u0006X\u0087.¢\u0006\u0012\n\u0004\b\u0011\u0010%\u001a\u0004\b&\u0010'\"\u0004\b(\u0010\u0013R\"\u0010*\u001a\u00020)8\u0006@\u0006X\u0087.¢\u0006\u0012\n\u0004\b*\u0010+\u001a\u0004\b,\u0010-\"\u0004\b.\u0010/R\"\u00101\u001a\u0002008\u0006@\u0006X\u0087.¢\u0006\u0012\n\u0004\b1\u00102\u001a\u0004\b3\u00104\"\u0004\b5\u00106R\"\u00108\u001a\u0002078\u0006@\u0006X\u0087.¢\u0006\u0012\n\u0004\b8\u00109\u001a\u0004\b:\u0010;\"\u0004\b<\u0010=R\u001b\u0010C\u001a\u00020>8BX\u0082\u0084\u0002¢\u0006\f\n\u0004\b?\u0010@\u001a\u0004\bA\u0010BR\u001b\u0010\u0014\u001a\u00020\f8BX\u0082\u0084\u0002¢\u0006\f\n\u0004\bD\u0010@\u001a\u0004\bE\u0010F¨\u0006H"}, d2 = {"Lru/yoomoney/sdk/kassa/payments/ui/CheckoutActivity;", "Landroidx/appcompat/app/AppCompatActivity;", "", "detachMainDialogFragment", "()V", "showDialog", "Landroidx/fragment/app/FragmentManager;", "supportFragmentManager", "Lru/yoomoney/sdk/kassa/payments/ui/MainDialogFragment;", "findDialog", "(Landroidx/fragment/app/FragmentManager;)Lru/yoomoney/sdk/kassa/payments/ui/MainDialogFragment;", "checkStartedWithCreateTokenizeIntent", "Lru/yoomoney/sdk/kassa/payments/checkoutParameters/PaymentParameters;", "shopParameters", "checkParams", "(Lru/yoomoney/sdk/kassa/payments/checkoutParameters/PaymentParameters;)V", "Lru/yoomoney/sdk/kassa/payments/metrics/u;", "exceptionReporter", "throwException", "(Lru/yoomoney/sdk/kassa/payments/metrics/u;)V", "paymentParameters", "Lru/yoomoney/sdk/kassa/payments/checkoutParameters/UiParameters;", "uiParameters", "sendInitializeAction", "(Lru/yoomoney/sdk/kassa/payments/checkoutParameters/PaymentParameters;Lru/yoomoney/sdk/kassa/payments/checkoutParameters/UiParameters;)V", "Landroid/os/Bundle;", "savedInstanceState", "onCreate", "(Landroid/os/Bundle;)V", "onDestroy", "Lru/yoomoney/sdk/kassa/payments/errorFormatter/b;", "errorFormatter", "Lru/yoomoney/sdk/kassa/payments/errorFormatter/b;", "getErrorFormatter", "()Lru/yoomoney/sdk/kassa/payments/errorFormatter/b;", "setErrorFormatter", "(Lru/yoomoney/sdk/kassa/payments/errorFormatter/b;)V", "Lru/yoomoney/sdk/kassa/payments/metrics/u;", "getExceptionReporter", "()Lru/yoomoney/sdk/kassa/payments/metrics/u;", "setExceptionReporter", "Lru/yoomoney/sdk/kassa/payments/metrics/F;", "reporter", "Lru/yoomoney/sdk/kassa/payments/metrics/F;", "getReporter", "()Lru/yoomoney/sdk/kassa/payments/metrics/F;", "setReporter", "(Lru/yoomoney/sdk/kassa/payments/metrics/F;)V", "Lru/yoomoney/sdk/kassa/payments/metrics/e0;", "userAuthParamProvider", "Lru/yoomoney/sdk/kassa/payments/metrics/e0;", "getUserAuthParamProvider", "()Lru/yoomoney/sdk/kassa/payments/metrics/e0;", "setUserAuthParamProvider", "(Lru/yoomoney/sdk/kassa/payments/metrics/e0;)V", "Lru/yoomoney/sdk/kassa/payments/secure/j;", "tokensStorage", "Lru/yoomoney/sdk/kassa/payments/secure/j;", "getTokensStorage", "()Lru/yoomoney/sdk/kassa/payments/secure/j;", "setTokensStorage", "(Lru/yoomoney/sdk/kassa/payments/secure/j;)V", "", "payWithoutSaving$delegate", "Lkotlin/Lazy;", "getPayWithoutSaving", "()Z", "payWithoutSaving", "paymentParameters$delegate", "getPaymentParameters", "()Lru/yoomoney/sdk/kassa/payments/checkoutParameters/PaymentParameters;", "<init>", "library_metricaRealRelease"}, k = 1, mv = {1, 9, 0})
/* loaded from: classes5.dex */
public final class CheckoutActivity extends AppCompatActivity {
    public static final int $stable = 8;
    public b errorFormatter;
    public InterfaceC2311u exceptionReporter;

    /* renamed from: payWithoutSaving$delegate, reason: from kotlin metadata */
    private final Lazy payWithoutSaving = LazyKt.lazy(new Function0<Boolean>() { // from class: ru.yoomoney.sdk.kassa.payments.ui.CheckoutActivity$payWithoutSaving$2
        {
            super(0);
        }

        /* JADX WARN: Can't rename method to resolve collision */
        @Override // kotlin.jvm.functions.Function0
        public final Boolean invoke() {
            return Boolean.valueOf(this.this$0.getIntent().hasExtra(CheckoutActivityKt.EXTRA_PAYMENT_PARAMETERS));
        }
    });

    /* renamed from: paymentParameters$delegate, reason: from kotlin metadata */
    private final Lazy paymentParameters = LazyKt.lazy(new Function0<PaymentParameters>() { // from class: ru.yoomoney.sdk.kassa.payments.ui.CheckoutActivity$paymentParameters$2
        {
            super(0);
        }

        @Override // kotlin.jvm.functions.Function0
        public final PaymentParameters invoke() {
            if (this.this$0.getPayWithoutSaving()) {
                Parcelable parcelableExtra = this.this$0.getIntent().getParcelableExtra(CheckoutActivityKt.EXTRA_PAYMENT_PARAMETERS);
                if (parcelableExtra != null) {
                    return (PaymentParameters) parcelableExtra;
                }
                throw new IllegalArgumentException("Required value was null.");
            }
            Parcelable parcelableExtra2 = this.this$0.getIntent().getParcelableExtra(CheckoutActivityKt.EXTRA_CSC_PARAMETERS);
            if (parcelableExtra2 == null) {
                throw new IllegalArgumentException("Required value was null.");
            }
            Intrinsics.checkNotNullExpressionValue(parcelableExtra2, "requireNotNull(...)");
            SavedBankCardPaymentParameters savedBankCardPaymentParameters = (SavedBankCardPaymentParameters) parcelableExtra2;
            Amount amount = savedBankCardPaymentParameters.getAmount();
            String title = savedBankCardPaymentParameters.getTitle();
            String subtitle = savedBankCardPaymentParameters.getSubtitle();
            String clientApplicationKey = savedBankCardPaymentParameters.getClientApplicationKey();
            String shopId = savedBankCardPaymentParameters.getShopId();
            String gatewayId = savedBankCardPaymentParameters.getGatewayId();
            return new PaymentParameters(amount, title, subtitle, clientApplicationKey, shopId, savedBankCardPaymentParameters.getSavePaymentMethod(), SetsKt.setOf(PaymentMethodType.BANK_CARD), gatewayId, null, null, null, null, null, 7936, null);
        }
    });
    public F reporter;
    public j tokensStorage;
    public e0 userAuthParamProvider;

    private final void checkParams(PaymentParameters shopParameters) {
        if (shopParameters == null || !shopParameters.getPaymentMethodTypes().contains(PaymentMethodType.YOO_MONEY)) {
            return;
        }
        String authCenterClientId = shopParameters.getAuthCenterClientId();
        if (authCenterClientId == null || authCenterClientId.length() == 0) {
            throwException(getExceptionReporter());
        }
    }

    private final void checkStartedWithCreateTokenizeIntent() {
        if (!getIntent().hasExtra(CheckoutActivityKt.EXTRA_CREATED_WITH_CHECKOUT_METHOD)) {
            throw new IllegalArgumentException("Intent for CheckoutActivity should be created only with Checkout.createTokenizeIntent().");
        }
    }

    private final void detachMainDialogFragment() {
        Dialog dialog;
        FragmentManager supportFragmentManager = getSupportFragmentManager();
        Intrinsics.checkNotNullExpressionValue(supportFragmentManager, "getSupportFragmentManager(...)");
        MainDialogFragment mainDialogFragmentFindDialog = findDialog(supportFragmentManager);
        if (mainDialogFragmentFindDialog == null || (dialog = mainDialogFragmentFindDialog.getDialog()) == null) {
            return;
        }
        dialog.setOnCancelListener(null);
        dialog.setOnDismissListener(null);
    }

    private final MainDialogFragment findDialog(FragmentManager supportFragmentManager) {
        return (MainDialogFragment) supportFragmentManager.findFragmentByTag(CheckoutActivityKt.getTAG_BOTTOM_SHEET());
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final boolean getPayWithoutSaving() {
        return ((Boolean) this.payWithoutSaving.getValue()).booleanValue();
    }

    private final PaymentParameters getPaymentParameters() {
        return (PaymentParameters) this.paymentParameters.getValue();
    }

    private final void sendInitializeAction(PaymentParameters paymentParameters, UiParameters uiParameters) {
        E g;
        F reporter = getReporter();
        e0 userAuthParamProvider = getUserAuthParamProvider();
        E c2304m = Intrinsics.areEqual(userAuthParamProvider.a.a(), C2318b.a) ? new C2304m() : (userAuthParamProvider.b.b() && userAuthParamProvider.b.c()) ? new C2305n() : new C2303l();
        Intrinsics.checkNotNullParameter(paymentParameters, "parameters");
        int i = J.a[paymentParameters.getSavePaymentMethod().ordinal()];
        if (i == 1) {
            g = new G();
        } else if (i == 2) {
            g = new H();
        } else {
            if (i != 3) {
                throw new NoWhenBranchMatchedException();
            }
            g = new K();
        }
        Intrinsics.checkNotNullParameter(uiParameters, "uiParameters");
        E o = uiParameters.getShowLogo() ? new O() : new C2312v();
        Intrinsics.checkNotNullParameter(uiParameters, "uiParameters");
        E c0Var = uiParameters.getColorScheme().getPrimaryColor() == ColorScheme.INSTANCE.getDefaultPrimaryColor() ? new c0() : new b0();
        j userAuthInfoRepository = getTokensStorage();
        Intrinsics.checkNotNullParameter(userAuthInfoRepository, "userAuthInfoRepository");
        Intrinsics.checkNotNullParameter(paymentParameters, "paymentParameters");
        reporter.a("actionSDKInitialised", CollectionsKt.listOf((Object[]) new E[]{c2304m, g, o, c0Var, (paymentParameters.getCustomerId() == null || userAuthInfoRepository.e() == null) ? paymentParameters.getCustomerId() != null ? new C2307p() : userAuthInfoRepository.e() != null ? new k0() : new D() : new C2298g()}));
    }

    private final void showDialog() {
        String paymentMethodId;
        if (getPayWithoutSaving()) {
            paymentMethodId = null;
        } else {
            Parcelable parcelableExtra = getIntent().getParcelableExtra(CheckoutActivityKt.EXTRA_CSC_PARAMETERS);
            if (parcelableExtra == null) {
                throw new IllegalArgumentException("Required value was null.");
            }
            paymentMethodId = ((SavedBankCardPaymentParameters) parcelableExtra).getPaymentMethodId();
        }
        FragmentManager supportFragmentManager = getSupportFragmentManager();
        Intrinsics.checkNotNullExpressionValue(supportFragmentManager, "getSupportFragmentManager(...)");
        if (findDialog(supportFragmentManager) == null) {
            MainDialogFragment.INSTANCE.createFragment(new StartScreenData.BaseScreenData(getPaymentParameters().getPaymentMethodTypes(), paymentMethodId)).show(getSupportFragmentManager(), CheckoutActivityKt.getTAG_BOTTOM_SHEET());
            Unit unit = Unit.INSTANCE;
        }
    }

    private final void throwException(InterfaceC2311u exceptionReporter) {
        IllegalStateException illegalStateException = new IllegalStateException("You should pass authCenterClientId to PaymentParameters if you want to allow PaymentMethodType.YOO_MONEY. If you don't want to use PaymentMethodType.YOO_MONEY, specify your payment methods explicitly in PaymentParameters.paymentMethodTypes \nVisit https://git.yoomoney.ru/projects/SDK/repos/yookassa-android-sdk for more information.");
        s0 e = new s0(illegalStateException);
        g0 g0Var = (g0) exceptionReporter;
        g0Var.getClass();
        Intrinsics.checkNotNullParameter(e, "e");
        g0Var.a.reportUnhandledException(e);
        throw illegalStateException;
    }

    public final b getErrorFormatter() {
        b bVar = this.errorFormatter;
        if (bVar != null) {
            return bVar;
        }
        Intrinsics.throwUninitializedPropertyAccessException("errorFormatter");
        return null;
    }

    public final InterfaceC2311u getExceptionReporter() {
        InterfaceC2311u interfaceC2311u = this.exceptionReporter;
        if (interfaceC2311u != null) {
            return interfaceC2311u;
        }
        Intrinsics.throwUninitializedPropertyAccessException("exceptionReporter");
        return null;
    }

    public final F getReporter() {
        F f = this.reporter;
        if (f != null) {
            return f;
        }
        Intrinsics.throwUninitializedPropertyAccessException("reporter");
        return null;
    }

    public final j getTokensStorage() {
        j jVar = this.tokensStorage;
        if (jVar != null) {
            return jVar;
        }
        Intrinsics.throwUninitializedPropertyAccessException("tokensStorage");
        return null;
    }

    public final e0 getUserAuthParamProvider() {
        e0 e0Var = this.userAuthParamProvider;
        if (e0Var != null) {
            return e0Var;
        }
        Intrinsics.throwUninitializedPropertyAccessException("userAuthParamProvider");
        return null;
    }

    /* JADX WARN: Multi-variable type inference failed */
    @Override // androidx.fragment.app.FragmentActivity, androidx.view.ComponentActivity, androidx.core.app.ComponentActivity, android.app.Activity
    public void onCreate(Bundle savedInstanceState) {
        checkStartedWithCreateTokenizeIntent();
        Application app = getApplication();
        Intrinsics.checkNotNullExpressionValue(app, "getApplication(...)");
        Intrinsics.checkNotNullParameter(app, "app");
        if (!ru.yoomoney.sdk.kassa.payments.confirmation.sberpay.b0.a) {
            SPaySdkApp.INSTANCE.getInstance().initialize(new SPaySdkInitConfig(app, false, SPayStage.Prod, null, true, true, a0.a, 8, null));
            ru.yoomoney.sdk.kassa.payments.confirmation.sberpay.b0.a = true;
        }
        Parcelable parcelableExtra = getIntent().getParcelableExtra(CheckoutActivityKt.EXTRA_UI_PARAMETERS);
        if (parcelableExtra == null) {
            throw new IllegalArgumentException("Required value was null.");
        }
        UiParameters uiParameters = (UiParameters) parcelableExtra;
        PaymentParameters paymentParameters = getPaymentParameters();
        TestParameters testParameters = (TestParameters) getIntent().getParcelableExtra(CheckoutActivityKt.EXTRA_TEST_PARAMETERS);
        if (testParameters == null) {
            testParameters = new TestParameters(false, false, null, null, null, 31, null);
        }
        a.a(false, this, null, testParameters, uiParameters, paymentParameters, 452);
        Intrinsics.checkNotNullParameter(this, "activity");
        ru.yoomoney.sdk.kassa.payments.di.component.a aVar = a.b;
        if (aVar == null) {
            Intrinsics.throwUninitializedPropertyAccessException("checkoutComponent");
            aVar = null;
        }
        CheckoutActivity_MembersInjector.injectErrorFormatter(this, (b) aVar.d.k.get());
        CheckoutActivity_MembersInjector.injectExceptionReporter(this, (InterfaceC2311u) aVar.d.l.get());
        CheckoutActivity_MembersInjector.injectReporter(this, (F) aVar.d.m.get());
        CheckoutActivity_MembersInjector.injectUserAuthParamProvider(this, (e0) aVar.f.get());
        CheckoutActivity_MembersInjector.injectTokensStorage(this, (j) aVar.d.t.get());
        sendInitializeAction(getPaymentParameters(), uiParameters);
        super.onCreate(savedInstanceState);
        checkParams(getPaymentParameters());
        if (savedInstanceState == null) {
            showDialog();
        } else {
            getReporter().a("recreatedBySystem", "checkoutActivity");
        }
    }

    @Override // androidx.appcompat.app.AppCompatActivity, androidx.fragment.app.FragmentActivity, android.app.Activity
    public void onDestroy() {
        detachMainDialogFragment();
        super.onDestroy();
    }

    public final void setErrorFormatter(b bVar) {
        Intrinsics.checkNotNullParameter(bVar, "<set-?>");
        this.errorFormatter = bVar;
    }

    public final void setExceptionReporter(InterfaceC2311u interfaceC2311u) {
        Intrinsics.checkNotNullParameter(interfaceC2311u, "<set-?>");
        this.exceptionReporter = interfaceC2311u;
    }

    public final void setReporter(F f) {
        Intrinsics.checkNotNullParameter(f, "<set-?>");
        this.reporter = f;
    }

    public final void setTokensStorage(j jVar) {
        Intrinsics.checkNotNullParameter(jVar, "<set-?>");
        this.tokensStorage = jVar;
    }

    public final void setUserAuthParamProvider(e0 e0Var) {
        Intrinsics.checkNotNullParameter(e0Var, "<set-?>");
        this.userAuthParamProvider = e0Var;
    }
}

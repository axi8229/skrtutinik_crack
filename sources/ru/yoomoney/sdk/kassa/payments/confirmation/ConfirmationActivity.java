package ru.yoomoney.sdk.kassa.payments.confirmation;

import android.app.Application;
import android.app.Dialog;
import android.os.Bundle;
import androidx.appcompat.app.AppCompatActivity;
import androidx.fragment.app.FragmentManager;
import kotlin.Lazy;
import kotlin.LazyKt;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.internal.Intrinsics;
import org.pjsip.pjsua2.pjsip_status_code;
import ru.yoomoney.sdk.kassa.payments.checkoutParameters.PaymentMethodType;
import ru.yoomoney.sdk.kassa.payments.checkoutParameters.TestParameters;
import ru.yoomoney.sdk.kassa.payments.checkoutParameters.UiParameters;
import ru.yoomoney.sdk.kassa.payments.confirmation.sberpay.a0;
import ru.yoomoney.sdk.kassa.payments.confirmation.sberpay.b0;
import ru.yoomoney.sdk.kassa.payments.metrics.F;
import ru.yoomoney.sdk.kassa.payments.ui.CheckoutActivityKt;
import ru.yoomoney.sdk.kassa.payments.ui.MainDialogFragment;
import ru.yoomoney.sdk.kassa.payments.ui.color.ColorScheme;
import ru.yoomoney.sdk.kassa.payments.ui.model.StartScreenData;
import spay.sdk.SPaySdkApp;
import spay.sdk.SPaySdkInitConfig;
import spay.sdk.api.SPayStage;

@Metadata(d1 = {"\u0000\f\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\b\u0000\u0018\u00002\u00020\u0001B\u0007¢\u0006\u0004\b\u0002\u0010\u0003¨\u0006\u0004"}, d2 = {"Lru/yoomoney/sdk/kassa/payments/confirmation/ConfirmationActivity;", "Landroidx/appcompat/app/AppCompatActivity;", "<init>", "()V", "library_metricaRealRelease"}, k = 1, mv = {1, 9, 0})
/* loaded from: classes5.dex */
public final class ConfirmationActivity extends AppCompatActivity {
    public static final /* synthetic */ int $r8$clinit = 0;
    public final Lazy a = LazyKt.lazy(new e(this));
    public final Lazy b = LazyKt.lazy(new d(this));
    public final Lazy c = LazyKt.lazy(new b(this));
    public final Lazy d = LazyKt.lazy(new f(this));
    public final Lazy e = LazyKt.lazy(new g(this));
    public final Lazy f = LazyKt.lazy(new c(this));
    public boolean g;
    public F h;

    @Override // androidx.fragment.app.FragmentActivity, androidx.view.ComponentActivity, androidx.core.app.ComponentActivity, android.app.Activity
    public final void onCreate(Bundle bundle) {
        StartScreenData sberPayConfirmationData;
        if (((String) this.c.getValue()) == null || ((ColorScheme) this.f.getValue()) == null) {
            super.onCreate(bundle);
            setResult(1);
            finish();
            return;
        }
        Application app = getApplication();
        Intrinsics.checkNotNullExpressionValue(app, "getApplication(...)");
        Intrinsics.checkNotNullParameter(app, "app");
        if (!b0.a) {
            SPaySdkApp.INSTANCE.getInstance().initialize(new SPaySdkInitConfig(app, false, SPayStage.Prod, null, true, true, a0.a, 8, null));
            b0.a = true;
        }
        String str = (String) this.c.getValue();
        TestParameters testParameters = (TestParameters) this.e.getValue();
        ColorScheme colorScheme = (ColorScheme) this.f.getValue();
        if (colorScheme == null) {
            throw new IllegalArgumentException("Required value was null.");
        }
        F f = null;
        ru.yoomoney.sdk.kassa.payments.di.a.a(true, this, str, testParameters, new UiParameters(false, colorScheme, 1, null), null, pjsip_status_code.PJSIP_SC_TEMPORARILY_UNAVAILABLE);
        Intrinsics.checkNotNullParameter(this, "activity");
        ru.yoomoney.sdk.kassa.payments.di.component.b bVar = ru.yoomoney.sdk.kassa.payments.di.a.c;
        if (bVar == null) {
            Intrinsics.throwUninitializedPropertyAccessException("confirmationSubcomponent");
            bVar = null;
        }
        this.h = (F) bVar.a.m.get();
        super.onCreate(bundle);
        if (bundle != null) {
            F f2 = this.h;
            if (f2 != null) {
                f = f2;
            } else {
                Intrinsics.throwUninitializedPropertyAccessException("reporter");
            }
            f.a("recreatedBySystem", "confirmationActivity");
            return;
        }
        PaymentMethodType paymentMethodType = (PaymentMethodType) this.a.getValue();
        if (((String) this.b.getValue()) == null || ((String) this.d.getValue()) == null) {
            setResult(1);
            finish();
        }
        int i = paymentMethodType == null ? -1 : a.a[paymentMethodType.ordinal()];
        if (i == 1) {
            String str2 = (String) this.b.getValue();
            if (str2 == null) {
                throw new IllegalArgumentException("Required value was null.");
            }
            String str3 = (String) this.d.getValue();
            if (str3 == null) {
                throw new IllegalArgumentException("Required value was null.");
            }
            sberPayConfirmationData = new StartScreenData.SberPayConfirmationData(str2, str3);
            FragmentManager supportFragmentManager = getSupportFragmentManager();
            Intrinsics.checkNotNullExpressionValue(supportFragmentManager, "getSupportFragmentManager(...)");
            if (((MainDialogFragment) supportFragmentManager.findFragmentByTag(CheckoutActivityKt.getTAG_BOTTOM_SHEET())) != null) {
                return;
            }
        } else {
            if (i != 2) {
                setResult(0);
                finish();
                return;
            }
            String str4 = (String) this.b.getValue();
            if (str4 == null) {
                throw new IllegalArgumentException("Required value was null.");
            }
            sberPayConfirmationData = new StartScreenData.SBPConfirmationData(str4);
            FragmentManager supportFragmentManager2 = getSupportFragmentManager();
            Intrinsics.checkNotNullExpressionValue(supportFragmentManager2, "getSupportFragmentManager(...)");
            if (((MainDialogFragment) supportFragmentManager2.findFragmentByTag(CheckoutActivityKt.getTAG_BOTTOM_SHEET())) != null) {
                return;
            }
        }
        MainDialogFragment.INSTANCE.createFragment(sberPayConfirmationData).show(getSupportFragmentManager(), CheckoutActivityKt.getTAG_BOTTOM_SHEET());
        Unit unit = Unit.INSTANCE;
    }

    @Override // androidx.appcompat.app.AppCompatActivity, androidx.fragment.app.FragmentActivity, android.app.Activity
    public final void onDestroy() {
        Dialog dialog;
        FragmentManager supportFragmentManager = getSupportFragmentManager();
        Intrinsics.checkNotNullExpressionValue(supportFragmentManager, "getSupportFragmentManager(...)");
        MainDialogFragment mainDialogFragment = (MainDialogFragment) supportFragmentManager.findFragmentByTag(CheckoutActivityKt.getTAG_BOTTOM_SHEET());
        if (mainDialogFragment != null && (dialog = mainDialogFragment.getDialog()) != null) {
            dialog.setOnCancelListener(null);
            dialog.setOnDismissListener(null);
        }
        super.onDestroy();
    }

    /* JADX WARN: Removed duplicated region for block: B:15:0x0035  */
    @Override // androidx.view.ComponentActivity, android.app.Activity
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    public final void onNewIntent(android.content.Intent r6) {
        /*
            r5 = this;
            java.lang.String r0 = "intent"
            kotlin.jvm.internal.Intrinsics.checkNotNullParameter(r6, r0)
            super.onNewIntent(r6)
            android.net.Uri r0 = r6.getData()
            r1 = 0
            if (r0 == 0) goto L14
            java.lang.String r0 = r0.getAuthority()
            goto L15
        L14:
            r0 = r1
        L15:
            java.lang.String r2 = "invoicing"
            boolean r0 = kotlin.jvm.internal.Intrinsics.areEqual(r0, r2)
            r2 = 0
            if (r0 == 0) goto L35
            android.net.Uri r0 = r6.getData()
            if (r0 == 0) goto L35
            java.lang.String r0 = r0.getPath()
            if (r0 == 0) goto L35
            java.lang.String r3 = "sberpay"
            r4 = 2
            boolean r0 = kotlin.text.StringsKt.contains$default(r0, r3, r2, r4, r1)
            r3 = 1
            if (r0 != r3) goto L35
            goto L36
        L35:
            r3 = r2
        L36:
            android.net.Uri r6 = r6.getData()
            if (r6 == 0) goto L41
            java.lang.String r6 = r6.getAuthority()
            goto L42
        L41:
            r6 = r1
        L42:
            java.lang.String r0 = "sbp-invoicing"
            boolean r6 = kotlin.jvm.internal.Intrinsics.areEqual(r6, r0)
            java.lang.String r0 = "reporter"
            r4 = -1
            if (r3 == 0) goto L6a
            r5.g = r2
            r5.setResult(r4)
            ru.yoomoney.sdk.kassa.payments.metrics.F r6 = r5.h
            if (r6 == 0) goto L58
            r1 = r6
            goto L5b
        L58:
            kotlin.jvm.internal.Intrinsics.throwUninitializedPropertyAccessException(r0)
        L5b:
            ru.yoomoney.sdk.kassa.payments.metrics.M r6 = new ru.yoomoney.sdk.kassa.payments.metrics.M
            r6.<init>()
            java.util.List r6 = kotlin.collections.CollectionsKt.listOf(r6)
            java.lang.String r0 = "actionSberPayConfirmation"
            r1.a(r0, r6)
            goto L81
        L6a:
            if (r6 == 0) goto L7e
            r5.setResult(r4)
            ru.yoomoney.sdk.kassa.payments.metrics.F r6 = r5.h
            if (r6 == 0) goto L74
            goto L78
        L74:
            kotlin.jvm.internal.Intrinsics.throwUninitializedPropertyAccessException(r0)
            r6 = r1
        L78:
            java.lang.String r0 = "actionSBPConfirmation"
            r6.a(r0, r1)
            goto L81
        L7e:
            r5.setResult(r2)
        L81:
            r5.finish()
            return
        */
        throw new UnsupportedOperationException("Method not decompiled: ru.yoomoney.sdk.kassa.payments.confirmation.ConfirmationActivity.onNewIntent(android.content.Intent):void");
    }

    @Override // androidx.fragment.app.FragmentActivity, android.app.Activity
    public final void onResume() {
        super.onResume();
        if (((PaymentMethodType) this.a.getValue()) == PaymentMethodType.SBERBANK) {
            if (!this.g) {
                this.g = true;
                return;
            }
            this.g = false;
            setResult(0);
            finish();
        }
    }
}

package ru.yoomoney.sdk.kassa.payments.paymentOptionList;

import android.view.View;
import kotlin.Unit;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.FunctionReferenceImpl;
import kotlin.jvm.internal.Intrinsics;
import ru.yoomoney.sdk.kassa.payments.checkoutParameters.UiParameters;
import ru.yoomoney.sdk.kassa.payments.ui.DialogTopBar;
import ru.yoomoney.sdk.kassa.payments.ui.view.LoadingView;

/* loaded from: classes5.dex */
public final /* synthetic */ class Y extends FunctionReferenceImpl implements Function1 {
    public Y(Object obj) {
        super(1, obj, C2487j0.class, "showEffect", "showEffect(Lru/yoomoney/sdk/kassa/payments/paymentOptionList/PaymentOptionList$Effect;)V", 0);
    }

    @Override // kotlin.jvm.functions.Function1
    public final Object invoke(Object obj) {
        ru.yoomoney.sdk.kassa.payments.navigation.c cVarB;
        ru.yoomoney.sdk.kassa.payments.navigation.v vVar;
        L p0 = (L) obj;
        Intrinsics.checkNotNullParameter(p0, "p0");
        C2487j0 c2487j0 = (C2487j0) this.receiver;
        int i = C2487j0.$r8$clinit;
        c2487j0.getClass();
        if (p0 instanceof F) {
            F f = (F) p0;
            ((ru.yoomoney.sdk.kassa.payments.navigation.a) c2487j0.b()).a(new ru.yoomoney.sdk.kassa.payments.navigation.e(f.a, f.b));
        } else if (p0 instanceof G) {
            ((ru.yoomoney.sdk.kassa.payments.navigation.a) c2487j0.b()).a(new ru.yoomoney.sdk.kassa.payments.navigation.o(((G) p0).a));
        } else {
            if (Intrinsics.areEqual(p0, E.a)) {
                DialogTopBar dialogTopBar = c2487j0.a().c;
                UiParameters uiParameters = c2487j0.a;
                LoadingView loadingView = null;
                if (uiParameters == null) {
                    Intrinsics.throwUninitializedPropertyAccessException("uiParameters");
                    uiParameters = null;
                }
                dialogTopBar.setLogoVisible(uiParameters.getShowLogo());
                LoadingView loadingView2 = c2487j0.h;
                if (loadingView2 == null) {
                    Intrinsics.throwUninitializedPropertyAccessException("loadingView");
                } else {
                    loadingView = loadingView2;
                }
                View childAt = c2487j0.a().b.getChildAt(0);
                if (childAt == null) {
                    c2487j0.a().b.addView(loadingView);
                    cVarB = c2487j0.b();
                    vVar = ru.yoomoney.sdk.kassa.payments.navigation.g.a;
                } else {
                    if (childAt != loadingView) {
                        c2487j0.a().b.removeView(childAt);
                        c2487j0.a().b.addView(loadingView);
                    }
                    cVarB = c2487j0.b();
                    vVar = ru.yoomoney.sdk.kassa.payments.navigation.g.a;
                }
            } else if (p0 instanceof D) {
                cVarB = c2487j0.b();
                vVar = ru.yoomoney.sdk.kassa.payments.navigation.p.a;
            } else if (p0 instanceof J) {
                ((ru.yoomoney.sdk.kassa.payments.navigation.a) c2487j0.b()).a(new ru.yoomoney.sdk.kassa.payments.navigation.u(((J) p0).a));
            } else if (p0 instanceof I) {
                ((ru.yoomoney.sdk.kassa.payments.navigation.a) c2487j0.b()).a(new ru.yoomoney.sdk.kassa.payments.navigation.t(((I) p0).a));
            } else if (p0 instanceof H) {
                c2487j0.a(((H) p0).a, false);
            } else if (p0 instanceof K) {
                c2487j0.a(((K) p0).a, true);
            }
            ((ru.yoomoney.sdk.kassa.payments.navigation.a) cVarB).a(vVar);
        }
        return Unit.INSTANCE;
    }
}

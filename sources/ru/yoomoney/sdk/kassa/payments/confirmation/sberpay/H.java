package ru.yoomoney.sdk.kassa.payments.confirmation.sberpay;

import android.app.Application;
import android.content.Context;
import android.content.res.Resources;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.FrameLayout;
import android.widget.LinearLayout;
import androidx.compose.runtime.internal.ComposableLambdaKt;
import androidx.compose.ui.platform.ComposeView;
import androidx.compose.ui.platform.ViewCompositionStrategy;
import androidx.fragment.app.Fragment;
import androidx.lifecycle.LifecycleOwner;
import androidx.viewbinding.ViewBindings;
import java.util.Locale;
import kotlin.Lazy;
import kotlin.LazyKt;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import ru.yoomoney.sdk.kassa.payments.R$bool;
import ru.yoomoney.sdk.kassa.payments.R$dimen;
import ru.yoomoney.sdk.kassa.payments.R$id;
import ru.yoomoney.sdk.kassa.payments.R$layout;
import ru.yoomoney.sdk.kassa.payments.R$string;
import ru.yoomoney.sdk.kassa.payments.checkoutParameters.TestParameters;
import ru.yoomoney.sdk.kassa.payments.ui.ViewExtensionsKt;
import ru.yoomoney.sdk.kassa.payments.ui.view.LoadingView;
import ru.yoomoney.sdk.march.CodeKt;
import ru.yoomoney.sdk.march.RuntimeViewModel;
import spay.sdk.SPaySdkApp;
import spay.sdk.SPaySdkInitConfig;
import spay.sdk.api.PaymentResult;
import spay.sdk.api.SPayStage;

@Metadata(d1 = {"\u0000\f\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\b\u0000\u0018\u00002\u00020\u0001B\u0007¢\u0006\u0004\b\u0002\u0010\u0003¨\u0006\u0004"}, d2 = {"Lru/yoomoney/sdk/kassa/payments/confirmation/sberpay/H;", "Landroidx/fragment/app/Fragment;", "<init>", "()V", "library_metricaRealRelease"}, k = 1, mv = {1, 9, 0})
/* loaded from: classes5.dex */
public final class H extends Fragment {
    public static final /* synthetic */ int $r8$clinit = 0;
    public Y a;
    public ru.yoomoney.sdk.kassa.payments.errorFormatter.b b;
    public ru.yoomoney.sdk.kassa.payments.navigation.c c;
    public final Lazy d = LazyKt.lazy(new F(this, new G(this)));
    public final Lazy e = LazyKt.lazy(new C2211v(this));
    public final Lazy f = LazyKt.lazy(new A(this));
    public ru.yoomoney.sdk.kassa.payments.databinding.l g;
    public ComposeView h;
    public LoadingView i;

    public static final void a(H h, Throwable th) {
        ComposeView composeView = h.h;
        LoadingView loadingView = null;
        if (composeView == null) {
            Intrinsics.throwUninitializedPropertyAccessException("errorComposeView");
            composeView = null;
        }
        View childAt = h.a().b.getChildAt(0);
        if (childAt == null) {
            h.a().b.addView(composeView);
        } else if (childAt != composeView) {
            h.a().b.removeView(childAt);
            h.a().b.addView(composeView);
        }
        ComposeView composeView2 = h.h;
        if (composeView2 == null) {
            Intrinsics.throwUninitializedPropertyAccessException("errorComposeView");
            composeView2 = null;
        }
        composeView2.setViewCompositionStrategy(ViewCompositionStrategy.DisposeOnViewTreeLifecycleDestroyed.INSTANCE);
        composeView2.setContent(ComposableLambdaKt.composableLambdaInstance(-1390268664, true, new D(h, th)));
        LoadingView loadingView2 = h.i;
        if (loadingView2 == null) {
            Intrinsics.throwUninitializedPropertyAccessException("loadingView");
        } else {
            loadingView = loadingView2;
        }
        ViewGroup.LayoutParams layoutParams = loadingView.getLayoutParams();
        if (layoutParams == null) {
            throw new NullPointerException("null cannot be cast to non-null type android.view.ViewGroup.LayoutParams");
        }
        FrameLayout rootContainer = h.a().b;
        Intrinsics.checkNotNullExpressionValue(rootContainer, "rootContainer");
        layoutParams.height = ViewExtensionsKt.getViewHeight(rootContainer);
        loadingView.setLayoutParams(layoutParams);
    }

    /* JADX WARN: Multi-variable type inference failed */
    @Override // androidx.fragment.app.Fragment
    public final void onCreate(Bundle bundle) {
        super.onCreate(bundle);
        Context applicationContext = requireContext().getApplicationContext();
        Intrinsics.checkNotNull(applicationContext, "null cannot be cast to non-null type android.app.Application");
        Application app = (Application) applicationContext;
        Intrinsics.checkNotNullParameter(app, "app");
        if (!b0.a) {
            SPaySdkApp.INSTANCE.getInstance().initialize(new SPaySdkInitConfig(app, false, SPayStage.Prod, null, true, true, a0.a, 8, null));
            b0.a = true;
        }
        Intrinsics.checkNotNullParameter(this, "fragment");
        ru.yoomoney.sdk.kassa.payments.di.component.b bVar = ru.yoomoney.sdk.kassa.payments.di.a.c;
        if (bVar == null) {
            Intrinsics.throwUninitializedPropertyAccessException("confirmationSubcomponent");
            bVar = null;
        }
        this.a = (Y) bVar.c.get();
        this.b = (ru.yoomoney.sdk.kassa.payments.errorFormatter.b) bVar.a.k.get();
        this.c = (ru.yoomoney.sdk.kassa.payments.navigation.c) bVar.a.h.get();
        TestParameters testParameters = bVar.a.b;
    }

    @Override // androidx.fragment.app.Fragment
    public final View onCreateView(LayoutInflater inflater, ViewGroup viewGroup, Bundle bundle) {
        Intrinsics.checkNotNullParameter(inflater, "inflater");
        View viewInflate = inflater.inflate(R$layout.ym_sberpay_confirmation_fragment, viewGroup, false);
        int i = R$id.rootContainer;
        FrameLayout frameLayout = (FrameLayout) ViewBindings.findChildViewById(viewInflate, i);
        if (frameLayout == null) {
            throw new NullPointerException("Missing required view with ID: ".concat(viewInflate.getResources().getResourceName(i)));
        }
        this.g = new ru.yoomoney.sdk.kassa.payments.databinding.l((LinearLayout) viewInflate, frameLayout);
        LinearLayout linearLayout = a().a;
        Intrinsics.checkNotNullExpressionValue(linearLayout, "getRoot(...)");
        return linearLayout;
    }

    @Override // androidx.fragment.app.Fragment
    public final void onDestroyView() {
        super.onDestroyView();
        a().b.removeAllViews();
        this.g = null;
    }

    @Override // androidx.fragment.app.Fragment
    public final void onViewCreated(View view, Bundle bundle) throws Resources.NotFoundException {
        Intrinsics.checkNotNullParameter(view, "view");
        super.onViewCreated(view, bundle);
        Resources resources = view.getResources();
        boolean z = resources.getBoolean(R$bool.ym_isTablet);
        Integer numValueOf = Integer.valueOf(resources.getDimensionPixelSize(R$dimen.ym_viewAnimator_maxHeight));
        if (z) {
            numValueOf = null;
        }
        Context context = view.getContext();
        Intrinsics.checkNotNullExpressionValue(context, "getContext(...)");
        LoadingView loadingView = new LoadingView(context);
        loadingView.setLayoutParams(new FrameLayout.LayoutParams(-1, numValueOf != null ? numValueOf.intValue() : -1, 17));
        this.i = loadingView;
        Context context2 = view.getContext();
        Intrinsics.checkNotNullExpressionValue(context2, "getContext(...)");
        ComposeView composeView = new ComposeView(context2, null, 0, 6, null);
        composeView.setLayoutParams(new FrameLayout.LayoutParams(-1, numValueOf != null ? numValueOf.intValue() : -1, 17));
        this.h = composeView;
        RuntimeViewModel runtimeViewModel = (RuntimeViewModel) this.d.getValue();
        LifecycleOwner viewLifecycleOwner = getViewLifecycleOwner();
        Intrinsics.checkNotNullExpressionValue(viewLifecycleOwner, "getViewLifecycleOwner(...)");
        CodeKt.observe(runtimeViewModel, viewLifecycleOwner, new C2213x(this), new C2214y(this), new C2215z(this));
    }

    public final ru.yoomoney.sdk.kassa.payments.databinding.l a() {
        ru.yoomoney.sdk.kassa.payments.databinding.l lVar = this.g;
        if (lVar != null) {
            return lVar;
        }
        throw new IllegalArgumentException("Required value was null.");
    }

    public final void a(PaymentResult paymentResult) {
        ru.yoomoney.sdk.kassa.payments.utils.h.a(paymentResult.toString());
        ru.yoomoney.sdk.kassa.payments.navigation.c cVar = null;
        if (paymentResult instanceof PaymentResult.Success) {
            ru.yoomoney.sdk.kassa.payments.navigation.c cVar2 = this.c;
            if (cVar2 != null) {
                cVar = cVar2;
            } else {
                Intrinsics.throwUninitializedPropertyAccessException("router");
            }
            ((ru.yoomoney.sdk.kassa.payments.navigation.a) cVar).a(ru.yoomoney.sdk.kassa.payments.navigation.m.a);
            return;
        }
        if (!(paymentResult instanceof PaymentResult.Error)) {
            if (paymentResult instanceof PaymentResult.Cancel) {
                ((RuntimeViewModel) this.d.getValue()).handleAction(C2201k.a);
                return;
            } else {
                boolean z = paymentResult instanceof PaymentResult.Processing;
                return;
            }
        }
        String str = getString(R$string.ym_sber_sdk_error_prefix) + ((PaymentResult.Error) paymentResult).getMerchantError();
        ru.yoomoney.sdk.kassa.payments.navigation.c cVar3 = this.c;
        if (cVar3 != null) {
            cVar = cVar3;
        } else {
            Intrinsics.throwUninitializedPropertyAccessException("router");
        }
        ((ru.yoomoney.sdk.kassa.payments.navigation.a) cVar).a(new ru.yoomoney.sdk.kassa.payments.navigation.l(str));
    }

    public final void a(String str, String str2, String str3, String str4) {
        Context applicationContext = requireContext().getApplicationContext();
        Intrinsics.checkNotNullExpressionValue(applicationContext, "getApplicationContext(...)");
        boolean zA = b0.a(applicationContext);
        ru.yoomoney.sdk.kassa.payments.utils.h.a("is ready: " + zA);
        if (zA) {
            SPaySdkApp companion = SPaySdkApp.INSTANCE.getInstance();
            Context contextRequireContext = requireContext();
            Intrinsics.checkNotNullExpressionValue(contextRequireContext, "requireContext(...)");
            String packageName = requireContext().getPackageName();
            Intrinsics.checkNotNullExpressionValue(packageName, "getPackageName(...)");
            companion.payWithBankInvoiceId(contextRequireContext, str, str2, str3, str4, packageName, Locale.getDefault().getLanguage(), new E(this));
            return;
        }
        ru.yoomoney.sdk.kassa.payments.navigation.c cVar = this.c;
        if (cVar == null) {
            Intrinsics.throwUninitializedPropertyAccessException("router");
            cVar = null;
        }
        String string = getString(R$string.ym_sber_sdk_not_ready);
        Intrinsics.checkNotNullExpressionValue(string, "getString(...)");
        ((ru.yoomoney.sdk.kassa.payments.navigation.a) cVar).a(new ru.yoomoney.sdk.kassa.payments.navigation.l(string));
    }
}

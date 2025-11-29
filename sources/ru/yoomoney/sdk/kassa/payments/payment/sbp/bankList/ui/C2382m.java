package ru.yoomoney.sdk.kassa.payments.payment.sbp.bankList.ui;

import android.content.Context;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ViewAnimator;
import androidx.compose.runtime.internal.ComposableLambdaKt;
import androidx.compose.ui.platform.ComposeView;
import androidx.compose.ui.platform.ViewCompositionStrategy;
import androidx.fragment.app.Fragment;
import androidx.viewbinding.ViewBindings;
import kotlin.Lazy;
import kotlin.LazyKt;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import ru.yoomoney.sdk.kassa.payments.R$id;
import ru.yoomoney.sdk.kassa.payments.R$layout;
import ru.yoomoney.sdk.kassa.payments.payment.sbp.bankList.impl.x0;

@Metadata(d1 = {"\u0000\f\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\b\u0000\u0018\u00002\u00020\u0001B\u0007¢\u0006\u0004\b\u0002\u0010\u0003¨\u0006\u0004"}, d2 = {"Lru/yoomoney/sdk/kassa/payments/payment/sbp/bankList/ui/m;", "Landroidx/fragment/app/Fragment;", "<init>", "()V", "library_metricaRealRelease"}, k = 1, mv = {1, 9, 0})
/* renamed from: ru.yoomoney.sdk.kassa.payments.payment.sbp.bankList.ui.m, reason: case insensitive filesystem */
/* loaded from: classes5.dex */
public final class C2382m extends Fragment {
    public static final /* synthetic */ int $r8$clinit = 0;
    public ru.yoomoney.sdk.kassa.payments.errorFormatter.b a;
    public x0 b;
    public ru.yoomoney.sdk.kassa.payments.navigation.c c;
    public ru.yoomoney.sdk.kassa.payments.payment.sbp.bankList.impl.d0 d;
    public ru.yoomoney.sdk.kassa.payments.databinding.f e;
    public final Lazy f = LazyKt.lazy(new C2376g(this));
    public final Lazy g = LazyKt.lazy(new C2381l(this));
    public final Lazy h = LazyKt.lazy(new C2375f(this));

    /* JADX WARN: Multi-variable type inference failed */
    @Override // androidx.fragment.app.Fragment
    public final void onAttach(Context context) {
        Intrinsics.checkNotNullParameter(context, "context");
        Intrinsics.checkNotNullParameter(this, "fragment");
        ru.yoomoney.sdk.kassa.payments.di.component.b bVar = ru.yoomoney.sdk.kassa.payments.di.a.c;
        if (bVar == null) {
            Intrinsics.throwUninitializedPropertyAccessException("confirmationSubcomponent");
            bVar = null;
        }
        this.a = (ru.yoomoney.sdk.kassa.payments.errorFormatter.b) bVar.a.k.get();
        this.b = (x0) bVar.e.get();
        this.c = (ru.yoomoney.sdk.kassa.payments.navigation.c) bVar.a.h.get();
        this.d = (ru.yoomoney.sdk.kassa.payments.payment.sbp.bankList.impl.d0) bVar.d.get();
        super.onAttach(context);
    }

    @Override // androidx.fragment.app.Fragment
    public final View onCreateView(LayoutInflater inflater, ViewGroup viewGroup, Bundle bundle) {
        Intrinsics.checkNotNullParameter(inflater, "inflater");
        View viewInflate = inflater.inflate(R$layout.ym_fragment_sbp_bank_list, viewGroup, false);
        int i = R$id.compose_container;
        ComposeView composeView = (ComposeView) ViewBindings.findChildViewById(viewInflate, i);
        if (composeView == null) {
            throw new NullPointerException("Missing required view with ID: ".concat(viewInflate.getResources().getResourceName(i)));
        }
        ViewAnimator viewAnimator = (ViewAnimator) viewInflate;
        this.e = new ru.yoomoney.sdk.kassa.payments.databinding.f(viewAnimator, composeView);
        Intrinsics.checkNotNullExpressionValue(viewAnimator, "getRoot(...)");
        return viewAnimator;
    }

    @Override // androidx.fragment.app.Fragment
    public final void onDestroyView() {
        super.onDestroyView();
        this.e = null;
    }

    @Override // androidx.fragment.app.Fragment
    public final void onViewCreated(View view, Bundle bundle) {
        Intrinsics.checkNotNullParameter(view, "view");
        super.onViewCreated(view, bundle);
        ru.yoomoney.sdk.kassa.payments.databinding.f fVar = this.e;
        if (fVar == null) {
            throw new IllegalArgumentException("Required value was null.");
        }
        ComposeView composeView = fVar.b;
        composeView.setViewCompositionStrategy(ViewCompositionStrategy.DisposeOnViewTreeLifecycleDestroyed.INSTANCE);
        composeView.setContent(ComposableLambdaKt.composableLambdaInstance(1572232132, true, new C2380k(this)));
    }
}

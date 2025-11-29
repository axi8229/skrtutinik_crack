package ru.yoomoney.sdk.kassa.payments.paymentAuth;

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
import androidx.lifecycle.ViewModelProvider;
import androidx.viewbinding.ViewBindings;
import kotlin.Lazy;
import kotlin.LazyKt;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import ru.yoomoney.sdk.kassa.payments.R$id;
import ru.yoomoney.sdk.kassa.payments.R$layout;
import ru.yoomoney.sdk.kassa.payments.ui.MainDialogFragment;

@Metadata(d1 = {"\u0000\f\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\b\u0000\u0018\u00002\u00020\u0001B\u0007¢\u0006\u0004\b\u0002\u0010\u0003¨\u0006\u0004"}, d2 = {"Lru/yoomoney/sdk/kassa/payments/paymentAuth/O0;", "Landroidx/fragment/app/Fragment;", "<init>", "()V", "library_metricaRealRelease"}, k = 1, mv = {1, 9, 0})
/* loaded from: classes5.dex */
public final class O0 extends Fragment {
    public static final /* synthetic */ int $r8$clinit = 0;
    public ViewModelProvider.Factory a;
    public ru.yoomoney.sdk.kassa.payments.errorFormatter.b b;
    public final Lazy c = LazyKt.lazy(new I0(this));
    public final Lazy d = LazyKt.lazy(new J0(this));
    public ru.yoomoney.sdk.kassa.payments.databinding.d e;

    @Override // androidx.fragment.app.Fragment
    public final void onAttach(Context context) {
        Intrinsics.checkNotNullParameter(context, "context");
        Intrinsics.checkNotNullParameter(this, "fragment");
        ru.yoomoney.sdk.kassa.payments.di.component.a aVar = ru.yoomoney.sdk.kassa.payments.di.a.b;
        if (aVar == null) {
            Intrinsics.throwUninitializedPropertyAccessException("checkoutComponent");
            aVar = null;
        }
        this.a = aVar.a();
        this.b = (ru.yoomoney.sdk.kassa.payments.errorFormatter.b) aVar.d.k.get();
        super.onAttach(context);
    }

    @Override // androidx.fragment.app.Fragment
    public final View onCreateView(LayoutInflater inflater, ViewGroup viewGroup, Bundle bundle) {
        Intrinsics.checkNotNullParameter(inflater, "inflater");
        View viewInflate = inflater.inflate(R$layout.ym_fragment_payment_auth, viewGroup, false);
        int i = R$id.compose_container;
        ComposeView composeView = (ComposeView) ViewBindings.findChildViewById(viewInflate, i);
        if (composeView == null) {
            throw new NullPointerException("Missing required view with ID: ".concat(viewInflate.getResources().getResourceName(i)));
        }
        ViewAnimator viewAnimator = (ViewAnimator) viewInflate;
        this.e = new ru.yoomoney.sdk.kassa.payments.databinding.d(viewAnimator, composeView);
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
        if (bundle != null) {
            requireActivity().setResult(0);
            Fragment parentFragment = getParentFragment();
            MainDialogFragment mainDialogFragment = parentFragment instanceof MainDialogFragment ? (MainDialogFragment) parentFragment : null;
            if (mainDialogFragment != null) {
                mainDialogFragment.dismiss();
            }
        }
        ru.yoomoney.sdk.kassa.payments.databinding.d dVar = this.e;
        if (dVar == null) {
            throw new IllegalArgumentException("Required value was null.");
        }
        ComposeView composeView = dVar.b;
        composeView.setViewCompositionStrategy(ViewCompositionStrategy.DisposeOnViewTreeLifecycleDestroyed.INSTANCE);
        composeView.setContent(ComposableLambdaKt.composableLambdaInstance(-295581263, true, new N0(this)));
    }
}

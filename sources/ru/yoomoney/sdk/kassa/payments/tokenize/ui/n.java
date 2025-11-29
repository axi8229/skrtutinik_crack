package ru.yoomoney.sdk.kassa.payments.tokenize.ui;

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
import androidx.fragment.app.FragmentKt;
import androidx.lifecycle.ViewModelProvider;
import androidx.viewbinding.ViewBindings;
import kotlin.Lazy;
import kotlin.LazyKt;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import ru.yoomoney.sdk.kassa.payments.R$id;
import ru.yoomoney.sdk.kassa.payments.R$layout;
import ru.yoomoney.sdk.kassa.payments.tokenize.w;
import ru.yoomoney.sdk.march.RuntimeViewModel;

@Metadata(d1 = {"\u0000\f\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\b\u0000\u0018\u00002\u00020\u0001B\u0007¢\u0006\u0004\b\u0002\u0010\u0003¨\u0006\u0004"}, d2 = {"Lru/yoomoney/sdk/kassa/payments/tokenize/ui/n;", "Landroidx/fragment/app/Fragment;", "<init>", "()V", "library_metricaRealRelease"}, k = 1, mv = {1, 9, 0})
/* loaded from: classes5.dex */
public final class n extends Fragment {
    public static final /* synthetic */ int $r8$clinit = 0;
    public ViewModelProvider.Factory a;
    public ru.yoomoney.sdk.kassa.payments.navigation.c b;
    public ru.yoomoney.sdk.kassa.payments.errorFormatter.b c;
    public final Lazy d = LazyKt.lazy(new l(this, new m(this)));
    public ru.yoomoney.sdk.kassa.payments.databinding.g e;

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
        this.b = (ru.yoomoney.sdk.kassa.payments.navigation.c) aVar.d.h.get();
        this.c = (ru.yoomoney.sdk.kassa.payments.errorFormatter.b) aVar.d.k.get();
        super.onAttach(context);
    }

    @Override // androidx.fragment.app.Fragment
    public final View onCreateView(LayoutInflater inflater, ViewGroup viewGroup, Bundle bundle) {
        Intrinsics.checkNotNullParameter(inflater, "inflater");
        View viewInflate = inflater.inflate(R$layout.ym_fragment_tokenize, viewGroup, false);
        int i = R$id.compose_container;
        ComposeView composeView = (ComposeView) ViewBindings.findChildViewById(viewInflate, i);
        if (composeView == null) {
            throw new NullPointerException("Missing required view with ID: ".concat(viewInflate.getResources().getResourceName(i)));
        }
        ViewAnimator viewAnimator = (ViewAnimator) viewInflate;
        this.e = new ru.yoomoney.sdk.kassa.payments.databinding.g(viewAnimator, composeView);
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
        ru.yoomoney.sdk.kassa.payments.databinding.g gVar = this.e;
        if (gVar == null) {
            throw new IllegalArgumentException("Required value was null.");
        }
        ComposeView composeView = gVar.b;
        composeView.setViewCompositionStrategy(ViewCompositionStrategy.DisposeOnViewTreeLifecycleDestroyed.INSTANCE);
        composeView.setContent(ComposableLambdaKt.composableLambdaInstance(-696098640, true, new j(this)));
        FragmentKt.setFragmentResultListener(this, "ru.yoomoney.sdk.kassa.payments.impl.paymentAuth.PAYMENT_AUTH_RESULT_KEY", new k(this));
        RuntimeViewModel runtimeViewModel = (RuntimeViewModel) this.d.getValue();
        Bundle arguments = getArguments();
        ru.yoomoney.sdk.kassa.payments.payment.tokenize.i iVar = arguments != null ? (ru.yoomoney.sdk.kassa.payments.payment.tokenize.i) arguments.getParcelable("tokenizeInputModel") : null;
        if (iVar == null) {
            throw new IllegalArgumentException("Required value was null.");
        }
        runtimeViewModel.handleAction(new w(iVar));
    }
}

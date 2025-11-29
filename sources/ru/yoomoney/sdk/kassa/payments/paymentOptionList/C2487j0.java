package ru.yoomoney.sdk.kassa.payments.paymentOptionList;

import android.content.Context;
import android.content.DialogInterface;
import android.content.res.Resources;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.FrameLayout;
import android.widget.LinearLayout;
import androidx.appcompat.app.AlertDialog;
import androidx.compose.ui.platform.ComposeView;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentKt;
import androidx.lifecycle.LifecycleOwner;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;
import androidx.viewbinding.ViewBindings;
import dagger.internal.Preconditions;
import kotlin.Lazy;
import kotlin.LazyKt;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import ru.yoomoney.sdk.gui.gui.R$color;
import ru.yoomoney.sdk.kassa.payments.R$bool;
import ru.yoomoney.sdk.kassa.payments.R$dimen;
import ru.yoomoney.sdk.kassa.payments.R$id;
import ru.yoomoney.sdk.kassa.payments.R$layout;
import ru.yoomoney.sdk.kassa.payments.R$string;
import ru.yoomoney.sdk.kassa.payments.R$style;
import ru.yoomoney.sdk.kassa.payments.checkoutParameters.UiParameters;
import ru.yoomoney.sdk.kassa.payments.ui.DialogTopBar;
import ru.yoomoney.sdk.kassa.payments.ui.swipe.SwipeItemHelper;
import ru.yoomoney.sdk.kassa.payments.ui.view.LoadingView;
import ru.yoomoney.sdk.march.CodeKt;
import ru.yoomoney.sdk.march.RuntimeViewModel;

@Metadata(d1 = {"\u0000\u0010\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\b\u0000\u0018\u00002\u00020\u00012\u00020\u0002B\u0007¢\u0006\u0004\b\u0003\u0010\u0004¨\u0006\u0005"}, d2 = {"Lru/yoomoney/sdk/kassa/payments/paymentOptionList/j0;", "Landroidx/fragment/app/Fragment;", "Lru/yoomoney/sdk/kassa/payments/paymentOptionList/o0;", "<init>", "()V", "library_metricaRealRelease"}, k = 1, mv = {1, 9, 0})
/* renamed from: ru.yoomoney.sdk.kassa.payments.paymentOptionList.j0, reason: case insensitive filesystem */
/* loaded from: classes5.dex */
public final class C2487j0 extends Fragment implements InterfaceC2502o0 {
    public static final /* synthetic */ int $r8$clinit = 0;
    public UiParameters a;
    public ru.yoomoney.sdk.kassa.payments.errorFormatter.b b;
    public ru.yoomoney.sdk.kassa.payments.di.j d;
    public ru.yoomoney.sdk.kassa.payments.navigation.c f;
    public RecyclerView g;
    public LoadingView h;
    public ComposeView i;
    public ru.yoomoney.sdk.kassa.payments.databinding.e k;
    public final Lazy c = LazyKt.lazy(new C2460a0(this));
    public final Lazy e = LazyKt.lazy(new C2478g0(this, new C2484i0(this)));
    public final Lazy j = LazyKt.lazy(new C2481h0(this));

    public final ru.yoomoney.sdk.kassa.payments.databinding.e a() {
        ru.yoomoney.sdk.kassa.payments.databinding.e eVar = this.k;
        if (eVar != null) {
            return eVar;
        }
        throw new IllegalArgumentException("Required value was null.");
    }

    public final ru.yoomoney.sdk.kassa.payments.navigation.c b() {
        ru.yoomoney.sdk.kassa.payments.navigation.c cVar = this.f;
        if (cVar != null) {
            return cVar;
        }
        Intrinsics.throwUninitializedPropertyAccessException("router");
        return null;
    }

    /* JADX WARN: Multi-variable type inference failed */
    @Override // androidx.fragment.app.Fragment
    public final void onAttach(Context context) {
        Intrinsics.checkNotNullParameter(context, "context");
        Intrinsics.checkNotNullParameter(this, "fragment");
        ru.yoomoney.sdk.kassa.payments.di.component.a aVar = ru.yoomoney.sdk.kassa.payments.di.a.b;
        if (aVar == null) {
            Intrinsics.throwUninitializedPropertyAccessException("checkoutComponent");
            aVar = null;
        }
        this.a = aVar.a;
        ru.yoomoney.sdk.kassa.payments.di.module.J j = aVar.b;
        ru.yoomoney.sdk.kassa.payments.di.component.c cVar = aVar.d;
        Context context2 = cVar.a;
        ru.yoomoney.sdk.kassa.payments.errorFormatter.b errorFormatter = (ru.yoomoney.sdk.kassa.payments.errorFormatter.b) cVar.k.get();
        j.getClass();
        Intrinsics.checkNotNullParameter(context2, "context");
        Intrinsics.checkNotNullParameter(errorFormatter, "errorFormatter");
        this.b = (ru.yoomoney.sdk.kassa.payments.errorFormatter.b) Preconditions.checkNotNullFromProvides(new U(context2, errorFormatter));
        this.d = (ru.yoomoney.sdk.kassa.payments.di.j) aVar.o.get();
        this.f = (ru.yoomoney.sdk.kassa.payments.navigation.c) aVar.d.h.get();
        super.onAttach(context);
    }

    @Override // androidx.fragment.app.Fragment
    public final View onCreateView(LayoutInflater inflater, ViewGroup viewGroup, Bundle bundle) {
        Intrinsics.checkNotNullParameter(inflater, "inflater");
        View viewInflate = inflater.inflate(R$layout.ym_fragment_payment_options, viewGroup, false);
        int i = R$id.contentContainer;
        FrameLayout frameLayout = (FrameLayout) ViewBindings.findChildViewById(viewInflate, i);
        if (frameLayout != null) {
            i = R$id.topBar;
            DialogTopBar dialogTopBar = (DialogTopBar) ViewBindings.findChildViewById(viewInflate, i);
            if (dialogTopBar != null) {
                this.k = new ru.yoomoney.sdk.kassa.payments.databinding.e((LinearLayout) viewInflate, frameLayout, dialogTopBar);
                return a().a;
            }
        }
        throw new NullPointerException("Missing required view with ID: ".concat(viewInflate.getResources().getResourceName(i)));
    }

    @Override // androidx.fragment.app.Fragment
    public final void onDestroyView() {
        super.onDestroyView();
        a().b.removeAllViews();
        ((SwipeItemHelper) this.j.getValue()).detachFromRecyclerView();
        this.k = null;
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
        Integer numValueOf2 = z ? null : Integer.valueOf(resources.getDimensionPixelSize(R$dimen.ym_payment_options_loading_min_height));
        FragmentKt.setFragmentResultListener(this, "ru.yoomoney.sdk.kassa.payments.impl.paymentAuth.MONEY_AUTH_RESULT_KEY", new V(this));
        FragmentKt.setFragmentResultListener(this, "ru.yoomoney.sdk.kassa.payments.impl.paymentAuth.UNBIND_CARD_RESULT_KEY", new W(this));
        RecyclerView recyclerView = new RecyclerView(view.getContext());
        recyclerView.setLayoutParams(new FrameLayout.LayoutParams(-1, -1, 17));
        recyclerView.setLayoutManager(new LinearLayoutManager(recyclerView.getContext(), 1, false));
        this.g = recyclerView;
        Context context = view.getContext();
        Intrinsics.checkNotNullExpressionValue(context, "getContext(...)");
        LoadingView loadingView = new LoadingView(context);
        loadingView.setLayoutParams(new FrameLayout.LayoutParams(-1, numValueOf2 != null ? numValueOf2.intValue() : -1, 17));
        this.h = loadingView;
        Context context2 = view.getContext();
        Intrinsics.checkNotNullExpressionValue(context2, "getContext(...)");
        ComposeView composeView = new ComposeView(context2, null, 0, 6, null);
        composeView.setLayoutParams(new FrameLayout.LayoutParams(-1, numValueOf != null ? numValueOf.intValue() : -1, 17));
        this.i = composeView;
        RuntimeViewModel runtimeViewModel = (RuntimeViewModel) this.e.getValue();
        LifecycleOwner viewLifecycleOwner = getViewLifecycleOwner();
        Intrinsics.checkNotNullExpressionValue(viewLifecycleOwner, "getViewLifecycleOwner(...)");
        CodeKt.observe(runtimeViewModel, viewLifecycleOwner, new X(this), new Y(this), new Z(this));
    }

    public final void a(final N n) {
        Context contextRequireContext = requireContext();
        Intrinsics.checkNotNullExpressionValue(contextRequireContext, "requireContext(...)");
        new AlertDialog.Builder(contextRequireContext, R$style.ym_DialogStyleColored).setMessage(contextRequireContext.getString(R$string.ym_unbinding_alert_message)).setPositiveButton(R$string.ym_unbind_card_action, new DialogInterface.OnClickListener() { // from class: ru.yoomoney.sdk.kassa.payments.paymentOptionList.j0$$ExternalSyntheticLambda0
            @Override // android.content.DialogInterface.OnClickListener
            public final void onClick(DialogInterface dialogInterface, int i) {
                C2487j0.a(this.f$0, n, dialogInterface, i);
            }
        }).setNegativeButton(R$string.ym_logout_dialog_button_negative, new DialogInterface.OnClickListener() { // from class: ru.yoomoney.sdk.kassa.payments.paymentOptionList.j0$$ExternalSyntheticLambda1
            @Override // android.content.DialogInterface.OnClickListener
            public final void onClick(DialogInterface dialogInterface, int i) {
                C2487j0.a(this.f$0, dialogInterface, i);
            }
        }).setOnCancelListener(new DialogInterface.OnCancelListener() { // from class: ru.yoomoney.sdk.kassa.payments.paymentOptionList.j0$$ExternalSyntheticLambda2
            @Override // android.content.DialogInterface.OnCancelListener
            public final void onCancel(DialogInterface dialogInterface) {
                C2487j0.a(this.f$0, dialogInterface);
            }
        }).show();
    }

    public static final void a(C2487j0 this$0, N state, DialogInterface dialogInterface, int i) {
        Intrinsics.checkNotNullParameter(this$0, "this$0");
        Intrinsics.checkNotNullParameter(state, "$state");
        dialogInterface.dismiss();
        C2501o c2501o = new C2501o(state.d, state.f);
        ((SwipeItemHelper) this$0.j.getValue()).forceCancel();
        ((RuntimeViewModel) this$0.e.getValue()).handleAction(c2501o);
    }

    public static final void a(C2487j0 this$0, DialogInterface dialogInterface, int i) {
        Intrinsics.checkNotNullParameter(this$0, "this$0");
        dialogInterface.dismiss();
        C2498n c2498n = C2498n.a;
        ((SwipeItemHelper) this$0.j.getValue()).forceCancel();
        ((RuntimeViewModel) this$0.e.getValue()).handleAction(c2498n);
    }

    public static final void a(C2487j0 this$0, DialogInterface dialogInterface) {
        Intrinsics.checkNotNullParameter(this$0, "this$0");
        C2498n c2498n = C2498n.a;
        ((SwipeItemHelper) this$0.j.getValue()).forceCancel();
        ((RuntimeViewModel) this$0.e.getValue()).handleAction(c2498n);
    }

    /* JADX WARN: Multi-variable type inference failed */
    /* JADX WARN: Removed duplicated region for block: B:22:0x0078  */
    /* JADX WARN: Removed duplicated region for block: B:61:0x012f  */
    /* JADX WARN: Removed duplicated region for block: B:64:0x0147  */
    /* JADX WARN: Type inference failed for: r9v15 */
    /* JADX WARN: Type inference failed for: r9v16 */
    /* JADX WARN: Type inference failed for: r9v17, types: [android.text.Spannable, java.lang.CharSequence] */
    /* JADX WARN: Type inference failed for: r9v18, types: [android.text.SpannableStringBuilder] */
    /* JADX WARN: Type inference failed for: r9v25 */
    /* JADX WARN: Type inference failed for: r9v26 */
    /* JADX WARN: Type inference failed for: r9v27 */
    /* JADX WARN: Type inference failed for: r9v7 */
    /* JADX WARN: Type inference failed for: r9v8 */
    /* JADX WARN: Type inference failed for: r9v9 */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    public final void a(ru.yoomoney.sdk.kassa.payments.paymentOptionList.AbstractC2499n0 r20) {
        /*
            Method dump skipped, instructions count: 456
            To view this dump change 'Code comments level' option to 'DEBUG'
        */
        throw new UnsupportedOperationException("Method not decompiled: ru.yoomoney.sdk.kassa.payments.paymentOptionList.C2487j0.a(ru.yoomoney.sdk.kassa.payments.paymentOptionList.n0):void");
    }

    public final void a(ru.yoomoney.sdk.kassa.payments.model.Q q, boolean z) {
        if (z) {
            View view = getView();
            if (view != null) {
                String string = getString(R$string.ym_unbinding_card_success, q.b);
                Intrinsics.checkNotNullExpressionValue(string, "getString(...)");
                ru.yoomoney.sdk.kassa.payments.extensions.l.a(view, string, R$color.color_type_inverse, R$color.color_type_success);
                return;
            }
            return;
        }
        View view2 = getView();
        if (view2 != null) {
            String string2 = getString(R$string.ym_unbinding_card_failed, q.b);
            Intrinsics.checkNotNullExpressionValue(string2, "getString(...)");
            ru.yoomoney.sdk.kassa.payments.extensions.l.a(view2, string2, R$color.color_type_inverse, R$color.color_type_alert);
        }
    }
}

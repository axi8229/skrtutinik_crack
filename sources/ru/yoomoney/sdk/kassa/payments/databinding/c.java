package ru.yoomoney.sdk.kassa.payments.databinding;

import android.view.View;
import android.widget.FrameLayout;
import android.widget.LinearLayout;
import android.widget.TextView;
import android.widget.ViewAnimator;
import androidx.compose.ui.platform.ComposeView;
import androidx.core.widget.NestedScrollView;
import androidx.viewbinding.ViewBinding;
import ru.yoomoney.sdk.gui.widget.button.PrimaryButtonView;
import ru.yoomoney.sdk.gui.widget.text.TextBodyView;
import ru.yoomoney.sdk.gui.widget.text.TextCaption1View;
import ru.yoomoney.sdk.kassa.payments.ui.CheckoutTextInputView;
import ru.yoomoney.sdk.kassa.payments.ui.DialogTopBar;
import ru.yoomoney.sdk.kassa.payments.ui.SwitchWithDescriptionView;
import ru.yoomoney.sdk.kassa.payments.ui.view.BankCardView;
import ru.yoomoney.sdk.kassa.payments.ui.view.LoadingView;

/* loaded from: classes5.dex */
public final class c implements ViewBinding {
    public final ViewAnimator a;
    public final SwitchWithDescriptionView b;
    public final BankCardView c;
    public final ComposeView d;
    public final FrameLayout e;
    public final NestedScrollView f;
    public final LinearLayout g;
    public final TextView h;
    public final TextView i;
    public final LoadingView j;
    public final PrimaryButtonView k;
    public final CheckoutTextInputView l;
    public final LinearLayout m;
    public final ViewAnimator n;
    public final TextCaption1View o;
    public final TextCaption1View p;
    public final SwitchWithDescriptionView q;
    public final k r;
    public final m s;
    public final TextBodyView t;
    public final TextView u;
    public final LinearLayout v;
    public final TextView w;
    public final DialogTopBar x;
    public final p y;

    public c(ViewAnimator viewAnimator, SwitchWithDescriptionView switchWithDescriptionView, BankCardView bankCardView, ComposeView composeView, FrameLayout frameLayout, NestedScrollView nestedScrollView, LinearLayout linearLayout, TextView textView, TextView textView2, LoadingView loadingView, PrimaryButtonView primaryButtonView, CheckoutTextInputView checkoutTextInputView, LinearLayout linearLayout2, ViewAnimator viewAnimator2, TextCaption1View textCaption1View, TextCaption1View textCaption1View2, SwitchWithDescriptionView switchWithDescriptionView2, k kVar, m mVar, TextBodyView textBodyView, TextView textView3, LinearLayout linearLayout3, TextView textView4, DialogTopBar dialogTopBar, p pVar) {
        this.a = viewAnimator;
        this.b = switchWithDescriptionView;
        this.c = bankCardView;
        this.d = composeView;
        this.e = frameLayout;
        this.f = nestedScrollView;
        this.g = linearLayout;
        this.h = textView;
        this.i = textView2;
        this.j = loadingView;
        this.k = primaryButtonView;
        this.l = checkoutTextInputView;
        this.m = linearLayout2;
        this.n = viewAnimator2;
        this.o = textCaption1View;
        this.p = textCaption1View2;
        this.q = switchWithDescriptionView2;
        this.r = kVar;
        this.s = mVar;
        this.t = textBodyView;
        this.u = textView3;
        this.v = linearLayout3;
        this.w = textView4;
        this.x = dialogTopBar;
        this.y = pVar;
    }

    @Override // androidx.viewbinding.ViewBinding
    public final View getRoot() {
        return this.a;
    }
}

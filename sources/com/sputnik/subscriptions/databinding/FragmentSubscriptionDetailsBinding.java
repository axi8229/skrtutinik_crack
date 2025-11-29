package com.sputnik.subscriptions.databinding;

import android.view.View;
import android.widget.LinearLayout;
import android.widget.TextView;
import androidx.appcompat.widget.AppCompatButton;
import androidx.appcompat.widget.Toolbar;
import androidx.constraintlayout.widget.ConstraintLayout;
import androidx.coordinatorlayout.widget.CoordinatorLayout;
import androidx.viewbinding.ViewBinding;
import androidx.viewbinding.ViewBindings;
import com.google.android.material.appbar.AppBarLayout;
import com.sputnik.subscriptions.R$id;

/* loaded from: classes3.dex */
public final class FragmentSubscriptionDetailsBinding implements ViewBinding {
    public final AppBarLayout appBar;
    public final AppCompatButton btnSubscribe;
    public final CoordinatorLayout coordinatorLayout;
    public final LayoutSubscriptionDetailsBinding layout;
    public final LinearLayout mainLoader;
    private final ConstraintLayout rootView;
    public final LinearLayout serviceLoader;
    public final Toolbar toolbar;
    public final TextView toolbarTitle;
    public final TextView tvPaymentInProgress;
    public final ConstraintLayout viewMain;

    private FragmentSubscriptionDetailsBinding(ConstraintLayout constraintLayout, AppBarLayout appBarLayout, AppCompatButton appCompatButton, CoordinatorLayout coordinatorLayout, LayoutSubscriptionDetailsBinding layoutSubscriptionDetailsBinding, LinearLayout linearLayout, LinearLayout linearLayout2, Toolbar toolbar, TextView textView, TextView textView2, ConstraintLayout constraintLayout2) {
        this.rootView = constraintLayout;
        this.appBar = appBarLayout;
        this.btnSubscribe = appCompatButton;
        this.coordinatorLayout = coordinatorLayout;
        this.layout = layoutSubscriptionDetailsBinding;
        this.mainLoader = linearLayout;
        this.serviceLoader = linearLayout2;
        this.toolbar = toolbar;
        this.toolbarTitle = textView;
        this.tvPaymentInProgress = textView2;
        this.viewMain = constraintLayout2;
    }

    @Override // androidx.viewbinding.ViewBinding
    public ConstraintLayout getRoot() {
        return this.rootView;
    }

    public static FragmentSubscriptionDetailsBinding bind(View view) {
        View viewFindChildViewById;
        int i = R$id.app_bar;
        AppBarLayout appBarLayout = (AppBarLayout) ViewBindings.findChildViewById(view, i);
        if (appBarLayout != null) {
            i = R$id.btn_subscribe;
            AppCompatButton appCompatButton = (AppCompatButton) ViewBindings.findChildViewById(view, i);
            if (appCompatButton != null) {
                i = R$id.coordinatorLayout;
                CoordinatorLayout coordinatorLayout = (CoordinatorLayout) ViewBindings.findChildViewById(view, i);
                if (coordinatorLayout != null && (viewFindChildViewById = ViewBindings.findChildViewById(view, (i = R$id.layout))) != null) {
                    LayoutSubscriptionDetailsBinding layoutSubscriptionDetailsBindingBind = LayoutSubscriptionDetailsBinding.bind(viewFindChildViewById);
                    i = R$id.mainLoader;
                    LinearLayout linearLayout = (LinearLayout) ViewBindings.findChildViewById(view, i);
                    if (linearLayout != null) {
                        i = R$id.serviceLoader;
                        LinearLayout linearLayout2 = (LinearLayout) ViewBindings.findChildViewById(view, i);
                        if (linearLayout2 != null) {
                            i = R$id.toolbar;
                            Toolbar toolbar = (Toolbar) ViewBindings.findChildViewById(view, i);
                            if (toolbar != null) {
                                i = R$id.toolbar_title;
                                TextView textView = (TextView) ViewBindings.findChildViewById(view, i);
                                if (textView != null) {
                                    i = R$id.tv_payment_in_progress;
                                    TextView textView2 = (TextView) ViewBindings.findChildViewById(view, i);
                                    if (textView2 != null) {
                                        ConstraintLayout constraintLayout = (ConstraintLayout) view;
                                        return new FragmentSubscriptionDetailsBinding(constraintLayout, appBarLayout, appCompatButton, coordinatorLayout, layoutSubscriptionDetailsBindingBind, linearLayout, linearLayout2, toolbar, textView, textView2, constraintLayout);
                                    }
                                }
                            }
                        }
                    }
                }
            }
        }
        throw new NullPointerException("Missing required view with ID: ".concat(view.getResources().getResourceName(i)));
    }
}

package com.sputnik.subscriptions.databinding;

import android.view.View;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;
import androidx.appcompat.widget.Toolbar;
import androidx.constraintlayout.widget.ConstraintLayout;
import androidx.core.widget.NestedScrollView;
import androidx.recyclerview.widget.RecyclerView;
import androidx.swiperefreshlayout.widget.SwipeRefreshLayout;
import androidx.viewbinding.ViewBinding;
import androidx.viewbinding.ViewBindings;
import com.sputnik.common.databinding.LayoutCompleteRegistrationBinding;
import com.sputnik.subscriptions.R$id;

/* loaded from: classes3.dex */
public final class FragmentNewMarketBinding implements ViewBinding {
    public final Button btnKeys;
    public final Button btnServices;
    public final Button btnSubscriptions;
    public final LinearLayout itemInactive;
    public final ImageView ivKeysOnboarding;
    public final ImageView ivServicesOnboarding;
    public final LayoutCompleteRegistrationBinding layoutCompleteRegistration;
    public final SwipeRefreshLayout layoutSwipeRefresh;
    private final LinearLayout rootView;
    public final RecyclerView rvKeys;
    public final RecyclerView rvServices;
    public final RecyclerView rvSubscriptions;
    public final NestedScrollView scrollView2;
    public final LinearLayout serviceLoader;
    public final Toolbar toolbar;
    public final TextView toolbarTitle;
    public final ConstraintLayout viewMain;

    private FragmentNewMarketBinding(LinearLayout linearLayout, Button button, Button button2, Button button3, LinearLayout linearLayout2, ImageView imageView, ImageView imageView2, LayoutCompleteRegistrationBinding layoutCompleteRegistrationBinding, SwipeRefreshLayout swipeRefreshLayout, RecyclerView recyclerView, RecyclerView recyclerView2, RecyclerView recyclerView3, NestedScrollView nestedScrollView, LinearLayout linearLayout3, Toolbar toolbar, TextView textView, ConstraintLayout constraintLayout) {
        this.rootView = linearLayout;
        this.btnKeys = button;
        this.btnServices = button2;
        this.btnSubscriptions = button3;
        this.itemInactive = linearLayout2;
        this.ivKeysOnboarding = imageView;
        this.ivServicesOnboarding = imageView2;
        this.layoutCompleteRegistration = layoutCompleteRegistrationBinding;
        this.layoutSwipeRefresh = swipeRefreshLayout;
        this.rvKeys = recyclerView;
        this.rvServices = recyclerView2;
        this.rvSubscriptions = recyclerView3;
        this.scrollView2 = nestedScrollView;
        this.serviceLoader = linearLayout3;
        this.toolbar = toolbar;
        this.toolbarTitle = textView;
        this.viewMain = constraintLayout;
    }

    @Override // androidx.viewbinding.ViewBinding
    public LinearLayout getRoot() {
        return this.rootView;
    }

    public static FragmentNewMarketBinding bind(View view) {
        View viewFindChildViewById;
        int i = R$id.btn_keys;
        Button button = (Button) ViewBindings.findChildViewById(view, i);
        if (button != null) {
            i = R$id.btn_services;
            Button button2 = (Button) ViewBindings.findChildViewById(view, i);
            if (button2 != null) {
                i = R$id.btn_subscriptions;
                Button button3 = (Button) ViewBindings.findChildViewById(view, i);
                if (button3 != null) {
                    i = R$id.item_inactive;
                    LinearLayout linearLayout = (LinearLayout) ViewBindings.findChildViewById(view, i);
                    if (linearLayout != null) {
                        i = R$id.iv_keys_onboarding;
                        ImageView imageView = (ImageView) ViewBindings.findChildViewById(view, i);
                        if (imageView != null) {
                            i = R$id.iv_services_onboarding;
                            ImageView imageView2 = (ImageView) ViewBindings.findChildViewById(view, i);
                            if (imageView2 != null && (viewFindChildViewById = ViewBindings.findChildViewById(view, (i = R$id.layout_complete_registration))) != null) {
                                LayoutCompleteRegistrationBinding layoutCompleteRegistrationBindingBind = LayoutCompleteRegistrationBinding.bind(viewFindChildViewById);
                                i = R$id.layoutSwipeRefresh;
                                SwipeRefreshLayout swipeRefreshLayout = (SwipeRefreshLayout) ViewBindings.findChildViewById(view, i);
                                if (swipeRefreshLayout != null) {
                                    i = R$id.rv_keys;
                                    RecyclerView recyclerView = (RecyclerView) ViewBindings.findChildViewById(view, i);
                                    if (recyclerView != null) {
                                        i = R$id.rv_services;
                                        RecyclerView recyclerView2 = (RecyclerView) ViewBindings.findChildViewById(view, i);
                                        if (recyclerView2 != null) {
                                            i = R$id.rv_subscriptions;
                                            RecyclerView recyclerView3 = (RecyclerView) ViewBindings.findChildViewById(view, i);
                                            if (recyclerView3 != null) {
                                                i = R$id.scrollView2;
                                                NestedScrollView nestedScrollView = (NestedScrollView) ViewBindings.findChildViewById(view, i);
                                                if (nestedScrollView != null) {
                                                    i = R$id.serviceLoader;
                                                    LinearLayout linearLayout2 = (LinearLayout) ViewBindings.findChildViewById(view, i);
                                                    if (linearLayout2 != null) {
                                                        i = R$id.toolbar;
                                                        Toolbar toolbar = (Toolbar) ViewBindings.findChildViewById(view, i);
                                                        if (toolbar != null) {
                                                            i = R$id.toolbar_title;
                                                            TextView textView = (TextView) ViewBindings.findChildViewById(view, i);
                                                            if (textView != null) {
                                                                i = R$id.viewMain;
                                                                ConstraintLayout constraintLayout = (ConstraintLayout) ViewBindings.findChildViewById(view, i);
                                                                if (constraintLayout != null) {
                                                                    return new FragmentNewMarketBinding((LinearLayout) view, button, button2, button3, linearLayout, imageView, imageView2, layoutCompleteRegistrationBindingBind, swipeRefreshLayout, recyclerView, recyclerView2, recyclerView3, nestedScrollView, linearLayout2, toolbar, textView, constraintLayout);
                                                                }
                                                            }
                                                        }
                                                    }
                                                }
                                            }
                                        }
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

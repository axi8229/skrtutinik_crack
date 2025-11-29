package sputnik.axmor.com.databinding;

import android.view.View;
import android.widget.FrameLayout;
import android.widget.LinearLayout;
import androidx.appcompat.widget.AppCompatButton;
import androidx.appcompat.widget.Toolbar;
import androidx.viewbinding.ViewBinding;
import androidx.viewbinding.ViewBindings;
import com.google.android.material.appbar.AppBarLayout;
import sputnik.axmor.com.R;

/* loaded from: classes5.dex */
public final class SubscriptionActivityBinding implements ViewBinding {
    public final AppBarLayout appBar;
    public final AppCompatButton btnSubscribe;
    public final SubscriptionScrollingLayoutBinding layout;
    private final FrameLayout rootView;
    public final LinearLayout serviceLoader;
    public final Toolbar toolbar;

    private SubscriptionActivityBinding(FrameLayout frameLayout, AppBarLayout appBarLayout, AppCompatButton appCompatButton, SubscriptionScrollingLayoutBinding subscriptionScrollingLayoutBinding, LinearLayout linearLayout, Toolbar toolbar) {
        this.rootView = frameLayout;
        this.appBar = appBarLayout;
        this.btnSubscribe = appCompatButton;
        this.layout = subscriptionScrollingLayoutBinding;
        this.serviceLoader = linearLayout;
        this.toolbar = toolbar;
    }

    @Override // androidx.viewbinding.ViewBinding
    public FrameLayout getRoot() {
        return this.rootView;
    }

    public static SubscriptionActivityBinding bind(View view) {
        int i = R.id.app_bar;
        AppBarLayout appBarLayout = (AppBarLayout) ViewBindings.findChildViewById(view, R.id.app_bar);
        if (appBarLayout != null) {
            i = R.id.btn_subscribe;
            AppCompatButton appCompatButton = (AppCompatButton) ViewBindings.findChildViewById(view, R.id.btn_subscribe);
            if (appCompatButton != null) {
                i = R.id.layout;
                View viewFindChildViewById = ViewBindings.findChildViewById(view, R.id.layout);
                if (viewFindChildViewById != null) {
                    SubscriptionScrollingLayoutBinding subscriptionScrollingLayoutBindingBind = SubscriptionScrollingLayoutBinding.bind(viewFindChildViewById);
                    i = R.id.serviceLoader;
                    LinearLayout linearLayout = (LinearLayout) ViewBindings.findChildViewById(view, R.id.serviceLoader);
                    if (linearLayout != null) {
                        i = R.id.toolbar;
                        Toolbar toolbar = (Toolbar) ViewBindings.findChildViewById(view, R.id.toolbar);
                        if (toolbar != null) {
                            return new SubscriptionActivityBinding((FrameLayout) view, appBarLayout, appCompatButton, subscriptionScrollingLayoutBindingBind, linearLayout, toolbar);
                        }
                    }
                }
            }
        }
        throw new NullPointerException("Missing required view with ID: ".concat(view.getResources().getResourceName(i)));
    }
}

package sputnik.axmor.com.databinding;

import android.view.View;
import android.widget.LinearLayout;
import androidx.appcompat.widget.AppCompatButton;
import androidx.appcompat.widget.Toolbar;
import androidx.constraintlayout.widget.ConstraintLayout;
import androidx.coordinatorlayout.widget.CoordinatorLayout;
import androidx.viewbinding.ViewBinding;
import androidx.viewbinding.ViewBindings;
import sputnik.axmor.com.R;

/* loaded from: classes5.dex */
public final class FragmentMarketItemDetailsBinding implements ViewBinding {
    public final AppCompatButton btnSubscribe;
    public final CoordinatorLayout coordinatorLayout;
    public final LayoutMarketItemDetailsBinding layout;
    public final LinearLayout mainLoader;
    private final ConstraintLayout rootView;
    public final Toolbar toolbar;
    public final ConstraintLayout viewMain;

    private FragmentMarketItemDetailsBinding(ConstraintLayout constraintLayout, AppCompatButton appCompatButton, CoordinatorLayout coordinatorLayout, LayoutMarketItemDetailsBinding layoutMarketItemDetailsBinding, LinearLayout linearLayout, Toolbar toolbar, ConstraintLayout constraintLayout2) {
        this.rootView = constraintLayout;
        this.btnSubscribe = appCompatButton;
        this.coordinatorLayout = coordinatorLayout;
        this.layout = layoutMarketItemDetailsBinding;
        this.mainLoader = linearLayout;
        this.toolbar = toolbar;
        this.viewMain = constraintLayout2;
    }

    @Override // androidx.viewbinding.ViewBinding
    public ConstraintLayout getRoot() {
        return this.rootView;
    }

    public static FragmentMarketItemDetailsBinding bind(View view) {
        int i = R.id.btn_subscribe;
        AppCompatButton appCompatButton = (AppCompatButton) ViewBindings.findChildViewById(view, R.id.btn_subscribe);
        if (appCompatButton != null) {
            i = R.id.coordinatorLayout;
            CoordinatorLayout coordinatorLayout = (CoordinatorLayout) ViewBindings.findChildViewById(view, R.id.coordinatorLayout);
            if (coordinatorLayout != null) {
                i = R.id.layout;
                View viewFindChildViewById = ViewBindings.findChildViewById(view, R.id.layout);
                if (viewFindChildViewById != null) {
                    LayoutMarketItemDetailsBinding layoutMarketItemDetailsBindingBind = LayoutMarketItemDetailsBinding.bind(viewFindChildViewById);
                    i = R.id.mainLoader;
                    LinearLayout linearLayout = (LinearLayout) ViewBindings.findChildViewById(view, R.id.mainLoader);
                    if (linearLayout != null) {
                        i = R.id.toolbar;
                        Toolbar toolbar = (Toolbar) ViewBindings.findChildViewById(view, R.id.toolbar);
                        if (toolbar != null) {
                            ConstraintLayout constraintLayout = (ConstraintLayout) view;
                            return new FragmentMarketItemDetailsBinding(constraintLayout, appCompatButton, coordinatorLayout, layoutMarketItemDetailsBindingBind, linearLayout, toolbar, constraintLayout);
                        }
                    }
                }
            }
        }
        throw new NullPointerException("Missing required view with ID: ".concat(view.getResources().getResourceName(i)));
    }
}

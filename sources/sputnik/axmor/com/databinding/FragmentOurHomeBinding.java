package sputnik.axmor.com.databinding;

import android.view.View;
import android.widget.TextView;
import androidx.appcompat.widget.AppCompatButton;
import androidx.appcompat.widget.Toolbar;
import androidx.constraintlayout.widget.ConstraintLayout;
import androidx.viewbinding.ViewBinding;
import androidx.viewbinding.ViewBindings;
import sputnik.axmor.com.R;

/* loaded from: classes5.dex */
public final class FragmentOurHomeBinding implements ViewBinding {
    public final AppCompatButton btnSubscribe;
    public final LayoutOurHomeDetailsBinding layout;
    public final ConstraintLayout root;
    private final ConstraintLayout rootView;
    public final Toolbar toolbar;
    public final TextView toolbarTitle;

    private FragmentOurHomeBinding(ConstraintLayout constraintLayout, AppCompatButton appCompatButton, LayoutOurHomeDetailsBinding layoutOurHomeDetailsBinding, ConstraintLayout constraintLayout2, Toolbar toolbar, TextView textView) {
        this.rootView = constraintLayout;
        this.btnSubscribe = appCompatButton;
        this.layout = layoutOurHomeDetailsBinding;
        this.root = constraintLayout2;
        this.toolbar = toolbar;
        this.toolbarTitle = textView;
    }

    @Override // androidx.viewbinding.ViewBinding
    public ConstraintLayout getRoot() {
        return this.rootView;
    }

    public static FragmentOurHomeBinding bind(View view) {
        int i = R.id.btn_subscribe;
        AppCompatButton appCompatButton = (AppCompatButton) ViewBindings.findChildViewById(view, R.id.btn_subscribe);
        if (appCompatButton != null) {
            i = R.id.layout;
            View viewFindChildViewById = ViewBindings.findChildViewById(view, R.id.layout);
            if (viewFindChildViewById != null) {
                LayoutOurHomeDetailsBinding layoutOurHomeDetailsBindingBind = LayoutOurHomeDetailsBinding.bind(viewFindChildViewById);
                ConstraintLayout constraintLayout = (ConstraintLayout) view;
                i = R.id.toolbar;
                Toolbar toolbar = (Toolbar) ViewBindings.findChildViewById(view, R.id.toolbar);
                if (toolbar != null) {
                    i = R.id.toolbar_title;
                    TextView textView = (TextView) ViewBindings.findChildViewById(view, R.id.toolbar_title);
                    if (textView != null) {
                        return new FragmentOurHomeBinding(constraintLayout, appCompatButton, layoutOurHomeDetailsBindingBind, constraintLayout, toolbar, textView);
                    }
                }
            }
        }
        throw new NullPointerException("Missing required view with ID: ".concat(view.getResources().getResourceName(i)));
    }
}

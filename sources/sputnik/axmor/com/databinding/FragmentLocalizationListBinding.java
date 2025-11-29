package sputnik.axmor.com.databinding;

import android.view.View;
import android.widget.LinearLayout;
import androidx.appcompat.widget.Toolbar;
import androidx.coordinatorlayout.widget.CoordinatorLayout;
import androidx.recyclerview.widget.RecyclerView;
import androidx.viewbinding.ViewBinding;
import androidx.viewbinding.ViewBindings;
import sputnik.axmor.com.R;

/* loaded from: classes5.dex */
public final class FragmentLocalizationListBinding implements ViewBinding {
    public final LinearLayout loader;
    private final CoordinatorLayout rootView;
    public final RecyclerView rvLanguages;
    public final Toolbar toolbar;

    private FragmentLocalizationListBinding(CoordinatorLayout coordinatorLayout, LinearLayout linearLayout, RecyclerView recyclerView, Toolbar toolbar) {
        this.rootView = coordinatorLayout;
        this.loader = linearLayout;
        this.rvLanguages = recyclerView;
        this.toolbar = toolbar;
    }

    @Override // androidx.viewbinding.ViewBinding
    public CoordinatorLayout getRoot() {
        return this.rootView;
    }

    public static FragmentLocalizationListBinding bind(View view) {
        int i = R.id.loader;
        LinearLayout linearLayout = (LinearLayout) ViewBindings.findChildViewById(view, R.id.loader);
        if (linearLayout != null) {
            i = R.id.rv_languages;
            RecyclerView recyclerView = (RecyclerView) ViewBindings.findChildViewById(view, R.id.rv_languages);
            if (recyclerView != null) {
                i = R.id.toolbar;
                Toolbar toolbar = (Toolbar) ViewBindings.findChildViewById(view, R.id.toolbar);
                if (toolbar != null) {
                    return new FragmentLocalizationListBinding((CoordinatorLayout) view, linearLayout, recyclerView, toolbar);
                }
            }
        }
        throw new NullPointerException("Missing required view with ID: ".concat(view.getResources().getResourceName(i)));
    }
}

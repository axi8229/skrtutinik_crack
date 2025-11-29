package sputnik.axmor.com.databinding;

import android.view.View;
import android.widget.FrameLayout;
import android.widget.LinearLayout;
import androidx.fragment.app.FragmentContainerView;
import androidx.viewbinding.ViewBinding;
import androidx.viewbinding.ViewBindings;
import com.google.android.material.bottomnavigation.BottomNavigationView;
import sputnik.axmor.com.R;

/* loaded from: classes5.dex */
public final class MainHostNoIntercomFragmentBinding implements ViewBinding {
    public final BottomNavigationView bottomNavigation;
    public final FragmentContainerView mainHostFragment;
    public final LinearLayout mainLoader;
    private final FrameLayout rootView;

    private MainHostNoIntercomFragmentBinding(FrameLayout frameLayout, BottomNavigationView bottomNavigationView, FragmentContainerView fragmentContainerView, LinearLayout linearLayout) {
        this.rootView = frameLayout;
        this.bottomNavigation = bottomNavigationView;
        this.mainHostFragment = fragmentContainerView;
        this.mainLoader = linearLayout;
    }

    @Override // androidx.viewbinding.ViewBinding
    public FrameLayout getRoot() {
        return this.rootView;
    }

    public static MainHostNoIntercomFragmentBinding bind(View view) {
        int i = R.id.bottom_navigation;
        BottomNavigationView bottomNavigationView = (BottomNavigationView) ViewBindings.findChildViewById(view, R.id.bottom_navigation);
        if (bottomNavigationView != null) {
            i = R.id.main_host_fragment;
            FragmentContainerView fragmentContainerView = (FragmentContainerView) ViewBindings.findChildViewById(view, R.id.main_host_fragment);
            if (fragmentContainerView != null) {
                i = R.id.main_loader;
                LinearLayout linearLayout = (LinearLayout) ViewBindings.findChildViewById(view, R.id.main_loader);
                if (linearLayout != null) {
                    return new MainHostNoIntercomFragmentBinding((FrameLayout) view, bottomNavigationView, fragmentContainerView, linearLayout);
                }
            }
        }
        throw new NullPointerException("Missing required view with ID: ".concat(view.getResources().getResourceName(i)));
    }
}

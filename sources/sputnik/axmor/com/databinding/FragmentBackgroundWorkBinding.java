package sputnik.axmor.com.databinding;

import android.view.View;
import android.widget.ImageView;
import androidx.constraintlayout.widget.ConstraintLayout;
import androidx.viewbinding.ViewBinding;
import androidx.viewbinding.ViewBindings;
import androidx.viewpager2.widget.ViewPager2;
import com.google.android.material.tabs.TabLayout;
import sputnik.axmor.com.R;

/* loaded from: classes5.dex */
public final class FragmentBackgroundWorkBinding implements ViewBinding {
    public final ViewPager2 instructionsViewpager;
    public final ImageView ivClose;
    public final ConstraintLayout layoutRoot;
    private final ConstraintLayout rootView;
    public final TabLayout tabLayout;

    private FragmentBackgroundWorkBinding(ConstraintLayout constraintLayout, ViewPager2 viewPager2, ImageView imageView, ConstraintLayout constraintLayout2, TabLayout tabLayout) {
        this.rootView = constraintLayout;
        this.instructionsViewpager = viewPager2;
        this.ivClose = imageView;
        this.layoutRoot = constraintLayout2;
        this.tabLayout = tabLayout;
    }

    @Override // androidx.viewbinding.ViewBinding
    public ConstraintLayout getRoot() {
        return this.rootView;
    }

    public static FragmentBackgroundWorkBinding bind(View view) {
        int i = R.id.instructions_viewpager;
        ViewPager2 viewPager2 = (ViewPager2) ViewBindings.findChildViewById(view, R.id.instructions_viewpager);
        if (viewPager2 != null) {
            i = R.id.iv_close;
            ImageView imageView = (ImageView) ViewBindings.findChildViewById(view, R.id.iv_close);
            if (imageView != null) {
                ConstraintLayout constraintLayout = (ConstraintLayout) view;
                i = R.id.tabLayout;
                TabLayout tabLayout = (TabLayout) ViewBindings.findChildViewById(view, R.id.tabLayout);
                if (tabLayout != null) {
                    return new FragmentBackgroundWorkBinding(constraintLayout, viewPager2, imageView, constraintLayout, tabLayout);
                }
            }
        }
        throw new NullPointerException("Missing required view with ID: ".concat(view.getResources().getResourceName(i)));
    }
}

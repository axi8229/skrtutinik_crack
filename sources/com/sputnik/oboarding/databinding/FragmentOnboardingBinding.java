package com.sputnik.oboarding.databinding;

import android.view.View;
import android.widget.FrameLayout;
import androidx.constraintlayout.widget.ConstraintLayout;
import androidx.viewbinding.ViewBinding;
import androidx.viewbinding.ViewBindings;
import androidx.viewpager2.widget.ViewPager2;
import com.sputnik.common.ui.view.stories.StoriesProgressView;
import com.sputnik.oboarding.R$id;

/* loaded from: classes3.dex */
public final class FragmentOnboardingBinding implements ViewBinding {
    public final ViewPager2 onboardingViewpager2;
    public final View reverse;
    public final ConstraintLayout rootView;
    private final ConstraintLayout rootView_;
    public final View skip;
    public final StoriesProgressView stories;
    public final FrameLayout storiesContainer;

    private FragmentOnboardingBinding(ConstraintLayout constraintLayout, ViewPager2 viewPager2, View view, ConstraintLayout constraintLayout2, View view2, StoriesProgressView storiesProgressView, FrameLayout frameLayout) {
        this.rootView_ = constraintLayout;
        this.onboardingViewpager2 = viewPager2;
        this.reverse = view;
        this.rootView = constraintLayout2;
        this.skip = view2;
        this.stories = storiesProgressView;
        this.storiesContainer = frameLayout;
    }

    @Override // androidx.viewbinding.ViewBinding
    public ConstraintLayout getRoot() {
        return this.rootView_;
    }

    public static FragmentOnboardingBinding bind(View view) {
        View viewFindChildViewById;
        int i = R$id.onboarding_viewpager2;
        ViewPager2 viewPager2 = (ViewPager2) ViewBindings.findChildViewById(view, i);
        if (viewPager2 != null && (viewFindChildViewById = ViewBindings.findChildViewById(view, (i = R$id.reverse))) != null) {
            ConstraintLayout constraintLayout = (ConstraintLayout) view;
            i = R$id.skip;
            View viewFindChildViewById2 = ViewBindings.findChildViewById(view, i);
            if (viewFindChildViewById2 != null) {
                i = R$id.stories;
                StoriesProgressView storiesProgressView = (StoriesProgressView) ViewBindings.findChildViewById(view, i);
                if (storiesProgressView != null) {
                    i = R$id.stories_container;
                    FrameLayout frameLayout = (FrameLayout) ViewBindings.findChildViewById(view, i);
                    if (frameLayout != null) {
                        return new FragmentOnboardingBinding(constraintLayout, viewPager2, viewFindChildViewById, constraintLayout, viewFindChildViewById2, storiesProgressView, frameLayout);
                    }
                }
            }
        }
        throw new NullPointerException("Missing required view with ID: ".concat(view.getResources().getResourceName(i)));
    }
}

package sputnik.axmor.com.databinding;

import android.view.View;
import android.widget.FrameLayout;
import android.widget.ImageView;
import androidx.constraintlayout.widget.ConstraintLayout;
import androidx.viewbinding.ViewBinding;
import androidx.viewbinding.ViewBindings;
import androidx.viewpager2.widget.ViewPager2;
import com.sputnik.common.ui.view.stories.StoriesProgressView;
import sputnik.axmor.com.R;

/* loaded from: classes5.dex */
public final class FragmentPopupStoriesBinding implements ViewBinding {
    public final ImageView ivClose;
    public final ViewPager2 onboardingViewpager2;
    public final View reverse;
    public final ConstraintLayout rootView;
    private final ConstraintLayout rootView_;
    public final View skip;
    public final StoriesProgressView stories;
    public final FrameLayout storiesContainer;

    private FragmentPopupStoriesBinding(ConstraintLayout constraintLayout, ImageView imageView, ViewPager2 viewPager2, View view, ConstraintLayout constraintLayout2, View view2, StoriesProgressView storiesProgressView, FrameLayout frameLayout) {
        this.rootView_ = constraintLayout;
        this.ivClose = imageView;
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

    public static FragmentPopupStoriesBinding bind(View view) {
        int i = R.id.iv_close;
        ImageView imageView = (ImageView) ViewBindings.findChildViewById(view, R.id.iv_close);
        if (imageView != null) {
            i = R.id.onboarding_viewpager2;
            ViewPager2 viewPager2 = (ViewPager2) ViewBindings.findChildViewById(view, R.id.onboarding_viewpager2);
            if (viewPager2 != null) {
                i = R.id.reverse;
                View viewFindChildViewById = ViewBindings.findChildViewById(view, R.id.reverse);
                if (viewFindChildViewById != null) {
                    ConstraintLayout constraintLayout = (ConstraintLayout) view;
                    i = R.id.skip;
                    View viewFindChildViewById2 = ViewBindings.findChildViewById(view, R.id.skip);
                    if (viewFindChildViewById2 != null) {
                        i = R.id.stories;
                        StoriesProgressView storiesProgressView = (StoriesProgressView) ViewBindings.findChildViewById(view, R.id.stories);
                        if (storiesProgressView != null) {
                            i = R.id.stories_container;
                            FrameLayout frameLayout = (FrameLayout) ViewBindings.findChildViewById(view, R.id.stories_container);
                            if (frameLayout != null) {
                                return new FragmentPopupStoriesBinding(constraintLayout, imageView, viewPager2, viewFindChildViewById, constraintLayout, viewFindChildViewById2, storiesProgressView, frameLayout);
                            }
                        }
                    }
                }
            }
        }
        throw new NullPointerException("Missing required view with ID: ".concat(view.getResources().getResourceName(i)));
    }
}

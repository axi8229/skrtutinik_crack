package sputnik.axmor.com.databinding;

import android.view.View;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;
import androidx.constraintlayout.widget.ConstraintLayout;
import androidx.viewbinding.ViewBinding;
import androidx.viewbinding.ViewBindings;
import sputnik.axmor.com.R;

/* loaded from: classes5.dex */
public final class FragmentPopupStoryBinding implements ViewBinding {
    public final ImageView ivBackground;
    public final ImageView ivOnboarding;
    public final LinearLayout layoutButtons;
    public final LinearLayout linearLayout9;
    public final ConstraintLayout root;
    private final ConstraintLayout rootView;
    public final TextView subtitle;
    public final TextView title;

    private FragmentPopupStoryBinding(ConstraintLayout constraintLayout, ImageView imageView, ImageView imageView2, LinearLayout linearLayout, LinearLayout linearLayout2, ConstraintLayout constraintLayout2, TextView textView, TextView textView2) {
        this.rootView = constraintLayout;
        this.ivBackground = imageView;
        this.ivOnboarding = imageView2;
        this.layoutButtons = linearLayout;
        this.linearLayout9 = linearLayout2;
        this.root = constraintLayout2;
        this.subtitle = textView;
        this.title = textView2;
    }

    @Override // androidx.viewbinding.ViewBinding
    public ConstraintLayout getRoot() {
        return this.rootView;
    }

    public static FragmentPopupStoryBinding bind(View view) {
        int i = R.id.iv_background;
        ImageView imageView = (ImageView) ViewBindings.findChildViewById(view, R.id.iv_background);
        if (imageView != null) {
            i = R.id.iv_onboarding;
            ImageView imageView2 = (ImageView) ViewBindings.findChildViewById(view, R.id.iv_onboarding);
            if (imageView2 != null) {
                i = R.id.layout_buttons;
                LinearLayout linearLayout = (LinearLayout) ViewBindings.findChildViewById(view, R.id.layout_buttons);
                if (linearLayout != null) {
                    i = R.id.linearLayout9;
                    LinearLayout linearLayout2 = (LinearLayout) ViewBindings.findChildViewById(view, R.id.linearLayout9);
                    if (linearLayout2 != null) {
                        ConstraintLayout constraintLayout = (ConstraintLayout) view;
                        i = R.id.subtitle;
                        TextView textView = (TextView) ViewBindings.findChildViewById(view, R.id.subtitle);
                        if (textView != null) {
                            i = R.id.title;
                            TextView textView2 = (TextView) ViewBindings.findChildViewById(view, R.id.title);
                            if (textView2 != null) {
                                return new FragmentPopupStoryBinding(constraintLayout, imageView, imageView2, linearLayout, linearLayout2, constraintLayout, textView, textView2);
                            }
                        }
                    }
                }
            }
        }
        throw new NullPointerException("Missing required view with ID: ".concat(view.getResources().getResourceName(i)));
    }
}

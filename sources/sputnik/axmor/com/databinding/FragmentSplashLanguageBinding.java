package sputnik.axmor.com.databinding;

import android.view.View;
import android.widget.ImageView;
import android.widget.TextSwitcher;
import android.widget.TextView;
import androidx.constraintlayout.widget.ConstraintLayout;
import androidx.viewbinding.ViewBinding;
import androidx.viewbinding.ViewBindings;
import sputnik.axmor.com.R;

/* loaded from: classes5.dex */
public final class FragmentSplashLanguageBinding implements ViewBinding {
    public final TextView infoNoClos;
    public final ImageView ivDicLogo;
    public final ConstraintLayout rootView;
    private final ConstraintLayout rootView_;
    public final TextSwitcher tvTitleSplash;

    private FragmentSplashLanguageBinding(ConstraintLayout constraintLayout, TextView textView, ImageView imageView, ConstraintLayout constraintLayout2, TextSwitcher textSwitcher) {
        this.rootView_ = constraintLayout;
        this.infoNoClos = textView;
        this.ivDicLogo = imageView;
        this.rootView = constraintLayout2;
        this.tvTitleSplash = textSwitcher;
    }

    @Override // androidx.viewbinding.ViewBinding
    public ConstraintLayout getRoot() {
        return this.rootView_;
    }

    public static FragmentSplashLanguageBinding bind(View view) {
        int i = R.id.info_no_clos;
        TextView textView = (TextView) ViewBindings.findChildViewById(view, R.id.info_no_clos);
        if (textView != null) {
            i = R.id.iv_dic_logo;
            ImageView imageView = (ImageView) ViewBindings.findChildViewById(view, R.id.iv_dic_logo);
            if (imageView != null) {
                ConstraintLayout constraintLayout = (ConstraintLayout) view;
                i = R.id.tv_title_splash;
                TextSwitcher textSwitcher = (TextSwitcher) ViewBindings.findChildViewById(view, R.id.tv_title_splash);
                if (textSwitcher != null) {
                    return new FragmentSplashLanguageBinding(constraintLayout, textView, imageView, constraintLayout, textSwitcher);
                }
            }
        }
        throw new NullPointerException("Missing required view with ID: ".concat(view.getResources().getResourceName(i)));
    }
}

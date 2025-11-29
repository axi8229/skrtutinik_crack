package sputnik.axmor.com.databinding;

import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;
import androidx.constraintlayout.widget.ConstraintLayout;
import androidx.viewbinding.ViewBinding;
import androidx.viewbinding.ViewBindings;
import sputnik.axmor.com.R;

/* loaded from: classes5.dex */
public final class FragmentGorservFeatureBinding implements ViewBinding {
    public final ImageView ivLogo;
    private final ConstraintLayout rootView;
    public final TextView tvGorservSubtitle;
    public final TextView tvGorservTitle;

    private FragmentGorservFeatureBinding(ConstraintLayout constraintLayout, ImageView imageView, TextView textView, TextView textView2) {
        this.rootView = constraintLayout;
        this.ivLogo = imageView;
        this.tvGorservSubtitle = textView;
        this.tvGorservTitle = textView2;
    }

    @Override // androidx.viewbinding.ViewBinding
    public ConstraintLayout getRoot() {
        return this.rootView;
    }

    public static FragmentGorservFeatureBinding bind(View view) {
        int i = R.id.iv_logo;
        ImageView imageView = (ImageView) ViewBindings.findChildViewById(view, R.id.iv_logo);
        if (imageView != null) {
            i = R.id.tv_gorserv_subtitle;
            TextView textView = (TextView) ViewBindings.findChildViewById(view, R.id.tv_gorserv_subtitle);
            if (textView != null) {
                i = R.id.tv_gorserv_title;
                TextView textView2 = (TextView) ViewBindings.findChildViewById(view, R.id.tv_gorserv_title);
                if (textView2 != null) {
                    return new FragmentGorservFeatureBinding((ConstraintLayout) view, imageView, textView, textView2);
                }
            }
        }
        throw new NullPointerException("Missing required view with ID: ".concat(view.getResources().getResourceName(i)));
    }
}

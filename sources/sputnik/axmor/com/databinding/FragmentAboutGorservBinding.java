package sputnik.axmor.com.databinding;

import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;
import androidx.constraintlayout.widget.ConstraintLayout;
import androidx.core.widget.NestedScrollView;
import androidx.viewbinding.ViewBinding;
import androidx.viewbinding.ViewBindings;
import sputnik.axmor.com.R;

/* loaded from: classes5.dex */
public final class FragmentAboutGorservBinding implements ViewBinding {
    public final ImageView btnBack;
    public final ImageView ivLogo;
    public final NestedScrollView nestedScrollView2;
    private final NestedScrollView rootView;
    public final ConstraintLayout toolbar;
    public final TextView tvGorservSubtitle;
    public final TextView tvGorservTitle;
    public final TextView tvToolbarTitle;

    private FragmentAboutGorservBinding(NestedScrollView nestedScrollView, ImageView imageView, ImageView imageView2, NestedScrollView nestedScrollView2, ConstraintLayout constraintLayout, TextView textView, TextView textView2, TextView textView3) {
        this.rootView = nestedScrollView;
        this.btnBack = imageView;
        this.ivLogo = imageView2;
        this.nestedScrollView2 = nestedScrollView2;
        this.toolbar = constraintLayout;
        this.tvGorservSubtitle = textView;
        this.tvGorservTitle = textView2;
        this.tvToolbarTitle = textView3;
    }

    @Override // androidx.viewbinding.ViewBinding
    public NestedScrollView getRoot() {
        return this.rootView;
    }

    public static FragmentAboutGorservBinding bind(View view) {
        int i = R.id.btn_back;
        ImageView imageView = (ImageView) ViewBindings.findChildViewById(view, R.id.btn_back);
        if (imageView != null) {
            i = R.id.iv_logo;
            ImageView imageView2 = (ImageView) ViewBindings.findChildViewById(view, R.id.iv_logo);
            if (imageView2 != null) {
                i = R.id.nestedScrollView2;
                NestedScrollView nestedScrollView = (NestedScrollView) ViewBindings.findChildViewById(view, R.id.nestedScrollView2);
                if (nestedScrollView != null) {
                    i = R.id.toolbar;
                    ConstraintLayout constraintLayout = (ConstraintLayout) ViewBindings.findChildViewById(view, R.id.toolbar);
                    if (constraintLayout != null) {
                        i = R.id.tv_gorserv_subtitle;
                        TextView textView = (TextView) ViewBindings.findChildViewById(view, R.id.tv_gorserv_subtitle);
                        if (textView != null) {
                            i = R.id.tv_gorserv_title;
                            TextView textView2 = (TextView) ViewBindings.findChildViewById(view, R.id.tv_gorserv_title);
                            if (textView2 != null) {
                                i = R.id.tv_toolbar_title;
                                TextView textView3 = (TextView) ViewBindings.findChildViewById(view, R.id.tv_toolbar_title);
                                if (textView3 != null) {
                                    return new FragmentAboutGorservBinding((NestedScrollView) view, imageView, imageView2, nestedScrollView, constraintLayout, textView, textView2, textView3);
                                }
                            }
                        }
                    }
                }
            }
        }
        throw new NullPointerException("Missing required view with ID: ".concat(view.getResources().getResourceName(i)));
    }
}

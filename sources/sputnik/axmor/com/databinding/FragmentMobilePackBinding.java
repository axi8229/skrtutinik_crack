package sputnik.axmor.com.databinding;

import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;
import androidx.appcompat.widget.AppCompatButton;
import androidx.appcompat.widget.Toolbar;
import androidx.core.widget.NestedScrollView;
import androidx.viewbinding.ViewBinding;
import androidx.viewbinding.ViewBindings;
import sputnik.axmor.com.R;

/* loaded from: classes5.dex */
public final class FragmentMobilePackBinding implements ViewBinding {
    public final ImageView imageView12;
    public final LayoutInfoServiceBinding infoLayout;
    private final NestedScrollView rootView;
    public final AppCompatButton subsSettingsButton;
    public final Toolbar toolbar;
    public final TextView tvBody;
    public final TextView tvTitle;

    private FragmentMobilePackBinding(NestedScrollView nestedScrollView, ImageView imageView, LayoutInfoServiceBinding layoutInfoServiceBinding, AppCompatButton appCompatButton, Toolbar toolbar, TextView textView, TextView textView2) {
        this.rootView = nestedScrollView;
        this.imageView12 = imageView;
        this.infoLayout = layoutInfoServiceBinding;
        this.subsSettingsButton = appCompatButton;
        this.toolbar = toolbar;
        this.tvBody = textView;
        this.tvTitle = textView2;
    }

    @Override // androidx.viewbinding.ViewBinding
    public NestedScrollView getRoot() {
        return this.rootView;
    }

    public static FragmentMobilePackBinding bind(View view) {
        int i = R.id.imageView12;
        ImageView imageView = (ImageView) ViewBindings.findChildViewById(view, R.id.imageView12);
        if (imageView != null) {
            i = R.id.info_layout;
            View viewFindChildViewById = ViewBindings.findChildViewById(view, R.id.info_layout);
            if (viewFindChildViewById != null) {
                LayoutInfoServiceBinding layoutInfoServiceBindingBind = LayoutInfoServiceBinding.bind(viewFindChildViewById);
                i = R.id.subsSettingsButton;
                AppCompatButton appCompatButton = (AppCompatButton) ViewBindings.findChildViewById(view, R.id.subsSettingsButton);
                if (appCompatButton != null) {
                    i = R.id.toolbar;
                    Toolbar toolbar = (Toolbar) ViewBindings.findChildViewById(view, R.id.toolbar);
                    if (toolbar != null) {
                        i = R.id.tv_body;
                        TextView textView = (TextView) ViewBindings.findChildViewById(view, R.id.tv_body);
                        if (textView != null) {
                            i = R.id.tv_title;
                            TextView textView2 = (TextView) ViewBindings.findChildViewById(view, R.id.tv_title);
                            if (textView2 != null) {
                                return new FragmentMobilePackBinding((NestedScrollView) view, imageView, layoutInfoServiceBindingBind, appCompatButton, toolbar, textView, textView2);
                            }
                        }
                    }
                }
            }
        }
        throw new NullPointerException("Missing required view with ID: ".concat(view.getResources().getResourceName(i)));
    }
}

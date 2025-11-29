package sputnik.axmor.com.databinding;

import android.view.View;
import android.widget.ImageView;
import android.widget.ScrollView;
import android.widget.TextView;
import androidx.appcompat.widget.AppCompatButton;
import androidx.appcompat.widget.Toolbar;
import androidx.viewbinding.ViewBinding;
import androidx.viewbinding.ViewBindings;
import sputnik.axmor.com.R;

/* loaded from: classes5.dex */
public final class FragmentFrSettingsBinding implements ViewBinding {
    public final AppCompatButton btnNext;
    public final ImageView ivLogo;
    private final ScrollView rootView;
    public final ScrollView scrollView;
    public final Toolbar toolbar;
    public final TextView tvNotice;
    public final TextView tvStart;

    private FragmentFrSettingsBinding(ScrollView scrollView, AppCompatButton appCompatButton, ImageView imageView, ScrollView scrollView2, Toolbar toolbar, TextView textView, TextView textView2) {
        this.rootView = scrollView;
        this.btnNext = appCompatButton;
        this.ivLogo = imageView;
        this.scrollView = scrollView2;
        this.toolbar = toolbar;
        this.tvNotice = textView;
        this.tvStart = textView2;
    }

    @Override // androidx.viewbinding.ViewBinding
    public ScrollView getRoot() {
        return this.rootView;
    }

    public static FragmentFrSettingsBinding bind(View view) {
        int i = R.id.btn_next;
        AppCompatButton appCompatButton = (AppCompatButton) ViewBindings.findChildViewById(view, R.id.btn_next);
        if (appCompatButton != null) {
            i = R.id.iv_logo;
            ImageView imageView = (ImageView) ViewBindings.findChildViewById(view, R.id.iv_logo);
            if (imageView != null) {
                ScrollView scrollView = (ScrollView) view;
                i = R.id.toolbar;
                Toolbar toolbar = (Toolbar) ViewBindings.findChildViewById(view, R.id.toolbar);
                if (toolbar != null) {
                    i = R.id.tv_notice;
                    TextView textView = (TextView) ViewBindings.findChildViewById(view, R.id.tv_notice);
                    if (textView != null) {
                        i = R.id.tv_start;
                        TextView textView2 = (TextView) ViewBindings.findChildViewById(view, R.id.tv_start);
                        if (textView2 != null) {
                            return new FragmentFrSettingsBinding(scrollView, appCompatButton, imageView, scrollView, toolbar, textView, textView2);
                        }
                    }
                }
            }
        }
        throw new NullPointerException("Missing required view with ID: ".concat(view.getResources().getResourceName(i)));
    }
}

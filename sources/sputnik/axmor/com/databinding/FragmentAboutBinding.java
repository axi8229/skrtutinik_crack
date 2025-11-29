package sputnik.axmor.com.databinding;

import android.view.View;
import android.widget.ImageView;
import android.widget.ScrollView;
import android.widget.TextView;
import androidx.appcompat.widget.Toolbar;
import androidx.viewbinding.ViewBinding;
import androidx.viewbinding.ViewBindings;
import sputnik.axmor.com.R;

/* loaded from: classes5.dex */
public final class FragmentAboutBinding implements ViewBinding {
    public final TextView btnPrivacyPolicy;
    public final ImageView btnSkolkovo;
    public final TextView btnUserLicense;
    private final ScrollView rootView;
    public final ScrollView scrollView;
    public final Toolbar toolbar;
    public final TextView tvAppVersion;
    public final TextView tvCopyright;
    public final TextView tvSkolkovo;
    public final TextView tvSkolkovoInfo;
    public final TextView tvTitle;

    private FragmentAboutBinding(ScrollView scrollView, TextView textView, ImageView imageView, TextView textView2, ScrollView scrollView2, Toolbar toolbar, TextView textView3, TextView textView4, TextView textView5, TextView textView6, TextView textView7) {
        this.rootView = scrollView;
        this.btnPrivacyPolicy = textView;
        this.btnSkolkovo = imageView;
        this.btnUserLicense = textView2;
        this.scrollView = scrollView2;
        this.toolbar = toolbar;
        this.tvAppVersion = textView3;
        this.tvCopyright = textView4;
        this.tvSkolkovo = textView5;
        this.tvSkolkovoInfo = textView6;
        this.tvTitle = textView7;
    }

    @Override // androidx.viewbinding.ViewBinding
    public ScrollView getRoot() {
        return this.rootView;
    }

    public static FragmentAboutBinding bind(View view) {
        int i = R.id.btnPrivacyPolicy;
        TextView textView = (TextView) ViewBindings.findChildViewById(view, R.id.btnPrivacyPolicy);
        if (textView != null) {
            i = R.id.btnSkolkovo;
            ImageView imageView = (ImageView) ViewBindings.findChildViewById(view, R.id.btnSkolkovo);
            if (imageView != null) {
                i = R.id.btnUserLicense;
                TextView textView2 = (TextView) ViewBindings.findChildViewById(view, R.id.btnUserLicense);
                if (textView2 != null) {
                    ScrollView scrollView = (ScrollView) view;
                    i = R.id.toolbar;
                    Toolbar toolbar = (Toolbar) ViewBindings.findChildViewById(view, R.id.toolbar);
                    if (toolbar != null) {
                        i = R.id.tvAppVersion;
                        TextView textView3 = (TextView) ViewBindings.findChildViewById(view, R.id.tvAppVersion);
                        if (textView3 != null) {
                            i = R.id.tvCopyright;
                            TextView textView4 = (TextView) ViewBindings.findChildViewById(view, R.id.tvCopyright);
                            if (textView4 != null) {
                                i = R.id.tv_skolkovo;
                                TextView textView5 = (TextView) ViewBindings.findChildViewById(view, R.id.tv_skolkovo);
                                if (textView5 != null) {
                                    i = R.id.tv_skolkovo_info;
                                    TextView textView6 = (TextView) ViewBindings.findChildViewById(view, R.id.tv_skolkovo_info);
                                    if (textView6 != null) {
                                        i = R.id.tv_title;
                                        TextView textView7 = (TextView) ViewBindings.findChildViewById(view, R.id.tv_title);
                                        if (textView7 != null) {
                                            return new FragmentAboutBinding(scrollView, textView, imageView, textView2, scrollView, toolbar, textView3, textView4, textView5, textView6, textView7);
                                        }
                                    }
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

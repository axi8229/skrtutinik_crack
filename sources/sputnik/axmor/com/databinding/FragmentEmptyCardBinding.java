package sputnik.axmor.com.databinding;

import android.view.View;
import android.widget.LinearLayout;
import android.widget.ScrollView;
import android.widget.TextView;
import androidx.appcompat.widget.Toolbar;
import androidx.viewbinding.ViewBinding;
import androidx.viewbinding.ViewBindings;
import sputnik.axmor.com.R;

/* loaded from: classes5.dex */
public final class FragmentEmptyCardBinding implements ViewBinding {
    private final LinearLayout rootView;
    public final ScrollView scrollView;
    public final LinearLayout serviceLoader;
    public final TextView subsButtonGetAccess;
    public final LinearLayout subsNewLayout;
    public final Toolbar toolbar;
    public final TextView tvSubtitle;
    public final TextView tvTitle;

    private FragmentEmptyCardBinding(LinearLayout linearLayout, ScrollView scrollView, LinearLayout linearLayout2, TextView textView, LinearLayout linearLayout3, Toolbar toolbar, TextView textView2, TextView textView3) {
        this.rootView = linearLayout;
        this.scrollView = scrollView;
        this.serviceLoader = linearLayout2;
        this.subsButtonGetAccess = textView;
        this.subsNewLayout = linearLayout3;
        this.toolbar = toolbar;
        this.tvSubtitle = textView2;
        this.tvTitle = textView3;
    }

    @Override // androidx.viewbinding.ViewBinding
    public LinearLayout getRoot() {
        return this.rootView;
    }

    public static FragmentEmptyCardBinding bind(View view) {
        int i = R.id.scroll_view;
        ScrollView scrollView = (ScrollView) ViewBindings.findChildViewById(view, R.id.scroll_view);
        if (scrollView != null) {
            i = R.id.serviceLoader;
            LinearLayout linearLayout = (LinearLayout) ViewBindings.findChildViewById(view, R.id.serviceLoader);
            if (linearLayout != null) {
                i = R.id.subsButtonGetAccess;
                TextView textView = (TextView) ViewBindings.findChildViewById(view, R.id.subsButtonGetAccess);
                if (textView != null) {
                    i = R.id.subs_new_layout;
                    LinearLayout linearLayout2 = (LinearLayout) ViewBindings.findChildViewById(view, R.id.subs_new_layout);
                    if (linearLayout2 != null) {
                        i = R.id.toolbar;
                        Toolbar toolbar = (Toolbar) ViewBindings.findChildViewById(view, R.id.toolbar);
                        if (toolbar != null) {
                            i = R.id.tv_subtitle;
                            TextView textView2 = (TextView) ViewBindings.findChildViewById(view, R.id.tv_subtitle);
                            if (textView2 != null) {
                                i = R.id.tv_title;
                                TextView textView3 = (TextView) ViewBindings.findChildViewById(view, R.id.tv_title);
                                if (textView3 != null) {
                                    return new FragmentEmptyCardBinding((LinearLayout) view, scrollView, linearLayout, textView, linearLayout2, toolbar, textView2, textView3);
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

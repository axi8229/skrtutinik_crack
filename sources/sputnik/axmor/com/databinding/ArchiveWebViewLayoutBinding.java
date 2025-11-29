package sputnik.axmor.com.databinding;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.webkit.WebView;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;
import androidx.constraintlayout.widget.ConstraintLayout;
import androidx.viewbinding.ViewBinding;
import androidx.viewbinding.ViewBindings;
import sputnik.axmor.com.R;

/* loaded from: classes5.dex */
public final class ArchiveWebViewLayoutBinding implements ViewBinding {
    public final ImageView btnAbout;
    public final ImageView btnBack;
    public final LinearLayout loader;
    private final LinearLayout rootView;
    public final ConstraintLayout toolbar;
    public final TextView tvToolbarTitle;
    public final WebView webView;

    private ArchiveWebViewLayoutBinding(LinearLayout linearLayout, ImageView imageView, ImageView imageView2, LinearLayout linearLayout2, ConstraintLayout constraintLayout, TextView textView, WebView webView) {
        this.rootView = linearLayout;
        this.btnAbout = imageView;
        this.btnBack = imageView2;
        this.loader = linearLayout2;
        this.toolbar = constraintLayout;
        this.tvToolbarTitle = textView;
        this.webView = webView;
    }

    @Override // androidx.viewbinding.ViewBinding
    public LinearLayout getRoot() {
        return this.rootView;
    }

    public static ArchiveWebViewLayoutBinding inflate(LayoutInflater layoutInflater, ViewGroup viewGroup, boolean z) {
        View viewInflate = layoutInflater.inflate(R.layout.archive_web_view_layout, viewGroup, false);
        if (z) {
            viewGroup.addView(viewInflate);
        }
        return bind(viewInflate);
    }

    public static ArchiveWebViewLayoutBinding bind(View view) {
        int i = R.id.btn_about;
        ImageView imageView = (ImageView) ViewBindings.findChildViewById(view, R.id.btn_about);
        if (imageView != null) {
            i = R.id.btn_back;
            ImageView imageView2 = (ImageView) ViewBindings.findChildViewById(view, R.id.btn_back);
            if (imageView2 != null) {
                i = R.id.loader;
                LinearLayout linearLayout = (LinearLayout) ViewBindings.findChildViewById(view, R.id.loader);
                if (linearLayout != null) {
                    i = R.id.toolbar;
                    ConstraintLayout constraintLayout = (ConstraintLayout) ViewBindings.findChildViewById(view, R.id.toolbar);
                    if (constraintLayout != null) {
                        i = R.id.tv_toolbar_title;
                        TextView textView = (TextView) ViewBindings.findChildViewById(view, R.id.tv_toolbar_title);
                        if (textView != null) {
                            i = R.id.web_view;
                            WebView webView = (WebView) ViewBindings.findChildViewById(view, R.id.web_view);
                            if (webView != null) {
                                return new ArchiveWebViewLayoutBinding((LinearLayout) view, imageView, imageView2, linearLayout, constraintLayout, textView, webView);
                            }
                        }
                    }
                }
            }
        }
        throw new NullPointerException("Missing required view with ID: ".concat(view.getResources().getResourceName(i)));
    }
}

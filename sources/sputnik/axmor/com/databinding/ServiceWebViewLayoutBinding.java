package sputnik.axmor.com.databinding;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.webkit.WebView;
import android.widget.LinearLayout;
import androidx.appcompat.widget.Toolbar;
import androidx.viewbinding.ViewBinding;
import androidx.viewbinding.ViewBindings;
import sputnik.axmor.com.R;

/* loaded from: classes5.dex */
public final class ServiceWebViewLayoutBinding implements ViewBinding {
    public final LinearLayout loader;
    private final LinearLayout rootView;
    public final Toolbar toolbar;
    public final WebView webView;

    private ServiceWebViewLayoutBinding(LinearLayout linearLayout, LinearLayout linearLayout2, Toolbar toolbar, WebView webView) {
        this.rootView = linearLayout;
        this.loader = linearLayout2;
        this.toolbar = toolbar;
        this.webView = webView;
    }

    @Override // androidx.viewbinding.ViewBinding
    public LinearLayout getRoot() {
        return this.rootView;
    }

    public static ServiceWebViewLayoutBinding inflate(LayoutInflater layoutInflater, ViewGroup viewGroup, boolean z) {
        View viewInflate = layoutInflater.inflate(R.layout.service_web_view_layout, viewGroup, false);
        if (z) {
            viewGroup.addView(viewInflate);
        }
        return bind(viewInflate);
    }

    public static ServiceWebViewLayoutBinding bind(View view) {
        int i = R.id.loader;
        LinearLayout linearLayout = (LinearLayout) ViewBindings.findChildViewById(view, R.id.loader);
        if (linearLayout != null) {
            i = R.id.toolbar;
            Toolbar toolbar = (Toolbar) ViewBindings.findChildViewById(view, R.id.toolbar);
            if (toolbar != null) {
                i = R.id.web_view;
                WebView webView = (WebView) ViewBindings.findChildViewById(view, R.id.web_view);
                if (webView != null) {
                    return new ServiceWebViewLayoutBinding((LinearLayout) view, linearLayout, toolbar, webView);
                }
            }
        }
        throw new NullPointerException("Missing required view with ID: ".concat(view.getResources().getResourceName(i)));
    }
}

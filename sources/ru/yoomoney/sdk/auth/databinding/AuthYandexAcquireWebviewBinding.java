package ru.yoomoney.sdk.auth.databinding;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.webkit.WebView;
import android.widget.LinearLayout;
import androidx.viewbinding.ViewBinding;
import androidx.viewbinding.ViewBindings;
import ru.yoomoney.sdk.auth.R;
import ru.yoomoney.sdk.auth.ui.EmptyStateLargeView;
import ru.yoomoney.sdk.auth.ui.ProgressBar;
import ru.yoomoney.sdk.auth.ui.TopBarDefault;
import ru.yoomoney.sdk.gui.widget.StateFlipViewGroup;

/* loaded from: classes4.dex */
public final class AuthYandexAcquireWebviewBinding implements ViewBinding {
    public final TopBarDefault appBar;
    public final WebView contentContainer;
    public final EmptyStateLargeView errorContainer;
    public final LinearLayout parent;
    public final ProgressBar progressContainer;
    private final LinearLayout rootView;
    public final StateFlipViewGroup stateFlipper;

    private AuthYandexAcquireWebviewBinding(LinearLayout linearLayout, TopBarDefault topBarDefault, WebView webView, EmptyStateLargeView emptyStateLargeView, LinearLayout linearLayout2, ProgressBar progressBar, StateFlipViewGroup stateFlipViewGroup) {
        this.rootView = linearLayout;
        this.appBar = topBarDefault;
        this.contentContainer = webView;
        this.errorContainer = emptyStateLargeView;
        this.parent = linearLayout2;
        this.progressContainer = progressBar;
        this.stateFlipper = stateFlipViewGroup;
    }

    public static AuthYandexAcquireWebviewBinding bind(View view) {
        int i = R.id.appBar;
        TopBarDefault topBarDefault = (TopBarDefault) ViewBindings.findChildViewById(view, i);
        if (topBarDefault != null) {
            i = R.id.content_container;
            WebView webView = (WebView) ViewBindings.findChildViewById(view, i);
            if (webView != null) {
                i = R.id.error_container;
                EmptyStateLargeView emptyStateLargeView = (EmptyStateLargeView) ViewBindings.findChildViewById(view, i);
                if (emptyStateLargeView != null) {
                    LinearLayout linearLayout = (LinearLayout) view;
                    i = R.id.progress_container;
                    ProgressBar progressBar = (ProgressBar) ViewBindings.findChildViewById(view, i);
                    if (progressBar != null) {
                        i = R.id.stateFlipper;
                        StateFlipViewGroup stateFlipViewGroup = (StateFlipViewGroup) ViewBindings.findChildViewById(view, i);
                        if (stateFlipViewGroup != null) {
                            return new AuthYandexAcquireWebviewBinding(linearLayout, topBarDefault, webView, emptyStateLargeView, linearLayout, progressBar, stateFlipViewGroup);
                        }
                    }
                }
            }
        }
        throw new NullPointerException("Missing required view with ID: ".concat(view.getResources().getResourceName(i)));
    }

    public static AuthYandexAcquireWebviewBinding inflate(LayoutInflater layoutInflater) {
        return inflate(layoutInflater, null, false);
    }

    public static AuthYandexAcquireWebviewBinding inflate(LayoutInflater layoutInflater, ViewGroup viewGroup, boolean z) {
        View viewInflate = layoutInflater.inflate(R.layout.auth_yandex_acquire_webview, viewGroup, false);
        if (z) {
            viewGroup.addView(viewInflate);
        }
        return bind(viewInflate);
    }

    @Override // androidx.viewbinding.ViewBinding
    public LinearLayout getRoot() {
        return this.rootView;
    }
}

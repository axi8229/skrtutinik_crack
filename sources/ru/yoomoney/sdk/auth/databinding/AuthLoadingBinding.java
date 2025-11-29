package ru.yoomoney.sdk.auth.databinding;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.FrameLayout;
import androidx.viewbinding.ViewBinding;
import androidx.viewbinding.ViewBindings;
import ru.yoomoney.sdk.auth.R;
import ru.yoomoney.sdk.auth.ui.EmptyStateLargeView;
import ru.yoomoney.sdk.auth.ui.ProgressBar;
import ru.yoomoney.sdk.auth.ui.TopBarDefault;
import ru.yoomoney.sdk.gui.widget.StateFlipViewGroup;

/* loaded from: classes4.dex */
public final class AuthLoadingBinding implements ViewBinding {
    public final TopBarDefault appBar;
    public final EmptyStateLargeView errorContainer;
    public final ProgressBar progressContainer;
    public final FrameLayout root;
    private final FrameLayout rootView;
    public final StateFlipViewGroup stateFlipper;

    private AuthLoadingBinding(FrameLayout frameLayout, TopBarDefault topBarDefault, EmptyStateLargeView emptyStateLargeView, ProgressBar progressBar, FrameLayout frameLayout2, StateFlipViewGroup stateFlipViewGroup) {
        this.rootView = frameLayout;
        this.appBar = topBarDefault;
        this.errorContainer = emptyStateLargeView;
        this.progressContainer = progressBar;
        this.root = frameLayout2;
        this.stateFlipper = stateFlipViewGroup;
    }

    public static AuthLoadingBinding bind(View view) {
        int i = R.id.appBar;
        TopBarDefault topBarDefault = (TopBarDefault) ViewBindings.findChildViewById(view, i);
        if (topBarDefault != null) {
            i = R.id.error_container;
            EmptyStateLargeView emptyStateLargeView = (EmptyStateLargeView) ViewBindings.findChildViewById(view, i);
            if (emptyStateLargeView != null) {
                i = R.id.progress_container;
                ProgressBar progressBar = (ProgressBar) ViewBindings.findChildViewById(view, i);
                if (progressBar != null) {
                    FrameLayout frameLayout = (FrameLayout) view;
                    i = R.id.stateFlipper;
                    StateFlipViewGroup stateFlipViewGroup = (StateFlipViewGroup) ViewBindings.findChildViewById(view, i);
                    if (stateFlipViewGroup != null) {
                        return new AuthLoadingBinding(frameLayout, topBarDefault, emptyStateLargeView, progressBar, frameLayout, stateFlipViewGroup);
                    }
                }
            }
        }
        throw new NullPointerException("Missing required view with ID: ".concat(view.getResources().getResourceName(i)));
    }

    public static AuthLoadingBinding inflate(LayoutInflater layoutInflater) {
        return inflate(layoutInflater, null, false);
    }

    public static AuthLoadingBinding inflate(LayoutInflater layoutInflater, ViewGroup viewGroup, boolean z) {
        View viewInflate = layoutInflater.inflate(R.layout.auth_loading, viewGroup, false);
        if (z) {
            viewGroup.addView(viewInflate);
        }
        return bind(viewInflate);
    }

    @Override // androidx.viewbinding.ViewBinding
    public FrameLayout getRoot() {
        return this.rootView;
    }
}

package ru.yoomoney.sdk.auth.databinding;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.FrameLayout;
import androidx.constraintlayout.widget.ConstraintLayout;
import androidx.viewbinding.ViewBinding;
import androidx.viewbinding.ViewBindings;
import ru.yoomoney.sdk.auth.R;
import ru.yoomoney.sdk.auth.ui.PrimaryButtonView;
import ru.yoomoney.sdk.auth.ui.ProgressBar;
import ru.yoomoney.sdk.auth.ui.SecondaryButtonView;
import ru.yoomoney.sdk.auth.ui.TopBarDefault;
import ru.yoomoney.sdk.gui.widget.StateFlipViewGroup;
import ru.yoomoney.sdk.gui.widget.state_screen.EmptyStateLargeView;
import ru.yoomoney.sdk.gui.widget.text.TextBodyView;
import ru.yoomoney.sdk.gui.widget.text.TextTitle1View;

/* loaded from: classes4.dex */
public final class AuthFinishingSuccessBinding implements ViewBinding {
    public final TopBarDefault appBar;
    public final ConstraintLayout contentContainer;
    public final EmptyStateLargeView errorContainer;
    public final PrimaryButtonView primaryAction;
    public final ProgressBar progressContainer;
    public final FrameLayout root;
    private final FrameLayout rootView;
    public final SecondaryButtonView secondaryAction;
    public final StateFlipViewGroup stateFlipper;
    public final TextBodyView subtitle;
    public final TextTitle1View title;

    private AuthFinishingSuccessBinding(FrameLayout frameLayout, TopBarDefault topBarDefault, ConstraintLayout constraintLayout, EmptyStateLargeView emptyStateLargeView, PrimaryButtonView primaryButtonView, ProgressBar progressBar, FrameLayout frameLayout2, SecondaryButtonView secondaryButtonView, StateFlipViewGroup stateFlipViewGroup, TextBodyView textBodyView, TextTitle1View textTitle1View) {
        this.rootView = frameLayout;
        this.appBar = topBarDefault;
        this.contentContainer = constraintLayout;
        this.errorContainer = emptyStateLargeView;
        this.primaryAction = primaryButtonView;
        this.progressContainer = progressBar;
        this.root = frameLayout2;
        this.secondaryAction = secondaryButtonView;
        this.stateFlipper = stateFlipViewGroup;
        this.subtitle = textBodyView;
        this.title = textTitle1View;
    }

    public static AuthFinishingSuccessBinding bind(View view) {
        int i = R.id.appBar;
        TopBarDefault topBarDefault = (TopBarDefault) ViewBindings.findChildViewById(view, i);
        if (topBarDefault != null) {
            i = R.id.content_container;
            ConstraintLayout constraintLayout = (ConstraintLayout) ViewBindings.findChildViewById(view, i);
            if (constraintLayout != null) {
                i = R.id.error_container;
                EmptyStateLargeView emptyStateLargeView = (EmptyStateLargeView) ViewBindings.findChildViewById(view, i);
                if (emptyStateLargeView != null) {
                    i = R.id.primaryAction;
                    PrimaryButtonView primaryButtonView = (PrimaryButtonView) ViewBindings.findChildViewById(view, i);
                    if (primaryButtonView != null) {
                        i = R.id.progress_container;
                        ProgressBar progressBar = (ProgressBar) ViewBindings.findChildViewById(view, i);
                        if (progressBar != null) {
                            FrameLayout frameLayout = (FrameLayout) view;
                            i = R.id.secondaryAction;
                            SecondaryButtonView secondaryButtonView = (SecondaryButtonView) ViewBindings.findChildViewById(view, i);
                            if (secondaryButtonView != null) {
                                i = R.id.stateFlipper;
                                StateFlipViewGroup stateFlipViewGroup = (StateFlipViewGroup) ViewBindings.findChildViewById(view, i);
                                if (stateFlipViewGroup != null) {
                                    i = R.id.subtitle;
                                    TextBodyView textBodyView = (TextBodyView) ViewBindings.findChildViewById(view, i);
                                    if (textBodyView != null) {
                                        i = R.id.title;
                                        TextTitle1View textTitle1View = (TextTitle1View) ViewBindings.findChildViewById(view, i);
                                        if (textTitle1View != null) {
                                            return new AuthFinishingSuccessBinding(frameLayout, topBarDefault, constraintLayout, emptyStateLargeView, primaryButtonView, progressBar, frameLayout, secondaryButtonView, stateFlipViewGroup, textBodyView, textTitle1View);
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

    public static AuthFinishingSuccessBinding inflate(LayoutInflater layoutInflater) {
        return inflate(layoutInflater, null, false);
    }

    public static AuthFinishingSuccessBinding inflate(LayoutInflater layoutInflater, ViewGroup viewGroup, boolean z) {
        View viewInflate = layoutInflater.inflate(R.layout.auth_finishing_success, viewGroup, false);
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

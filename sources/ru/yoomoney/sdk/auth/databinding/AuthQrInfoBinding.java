package ru.yoomoney.sdk.auth.databinding;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.FrameLayout;
import android.widget.ImageView;
import androidx.constraintlayout.widget.ConstraintLayout;
import androidx.viewbinding.ViewBinding;
import androidx.viewbinding.ViewBindings;
import ru.yoomoney.sdk.auth.R;
import ru.yoomoney.sdk.auth.ui.EmptyStateLargeView;
import ru.yoomoney.sdk.auth.ui.PrimaryButtonView;
import ru.yoomoney.sdk.auth.ui.ProgressBar;
import ru.yoomoney.sdk.auth.ui.SecondaryButtonView;
import ru.yoomoney.sdk.auth.ui.TopBarDefault;
import ru.yoomoney.sdk.gui.widget.StateFlipViewGroup;
import ru.yoomoney.sdk.gui.widget.text.TextBodyView;
import ru.yoomoney.sdk.gui.widget.text.TextTitle3View;

/* loaded from: classes4.dex */
public final class AuthQrInfoBinding implements ViewBinding {
    public final TopBarDefault appBar;
    public final ImageView close;
    public final ConstraintLayout contentContainer;
    public final EmptyStateLargeView errorContainer;
    public final ImageView logo;
    public final FrameLayout parent;
    public final PrimaryButtonView primaryAction;
    public final ProgressBar progressContainer;
    private final FrameLayout rootView;
    public final SecondaryButtonView secondaryAction;
    public final StateFlipViewGroup stateFlipper;
    public final TextBodyView subtitle;
    public final TextTitle3View title;

    private AuthQrInfoBinding(FrameLayout frameLayout, TopBarDefault topBarDefault, ImageView imageView, ConstraintLayout constraintLayout, EmptyStateLargeView emptyStateLargeView, ImageView imageView2, FrameLayout frameLayout2, PrimaryButtonView primaryButtonView, ProgressBar progressBar, SecondaryButtonView secondaryButtonView, StateFlipViewGroup stateFlipViewGroup, TextBodyView textBodyView, TextTitle3View textTitle3View) {
        this.rootView = frameLayout;
        this.appBar = topBarDefault;
        this.close = imageView;
        this.contentContainer = constraintLayout;
        this.errorContainer = emptyStateLargeView;
        this.logo = imageView2;
        this.parent = frameLayout2;
        this.primaryAction = primaryButtonView;
        this.progressContainer = progressBar;
        this.secondaryAction = secondaryButtonView;
        this.stateFlipper = stateFlipViewGroup;
        this.subtitle = textBodyView;
        this.title = textTitle3View;
    }

    public static AuthQrInfoBinding bind(View view) {
        int i = R.id.appBar;
        TopBarDefault topBarDefault = (TopBarDefault) ViewBindings.findChildViewById(view, i);
        if (topBarDefault != null) {
            i = R.id.close;
            ImageView imageView = (ImageView) ViewBindings.findChildViewById(view, i);
            if (imageView != null) {
                i = R.id.content_container;
                ConstraintLayout constraintLayout = (ConstraintLayout) ViewBindings.findChildViewById(view, i);
                if (constraintLayout != null) {
                    i = R.id.error_container;
                    EmptyStateLargeView emptyStateLargeView = (EmptyStateLargeView) ViewBindings.findChildViewById(view, i);
                    if (emptyStateLargeView != null) {
                        i = R.id.logo;
                        ImageView imageView2 = (ImageView) ViewBindings.findChildViewById(view, i);
                        if (imageView2 != null) {
                            FrameLayout frameLayout = (FrameLayout) view;
                            i = R.id.primaryAction;
                            PrimaryButtonView primaryButtonView = (PrimaryButtonView) ViewBindings.findChildViewById(view, i);
                            if (primaryButtonView != null) {
                                i = R.id.progress_container;
                                ProgressBar progressBar = (ProgressBar) ViewBindings.findChildViewById(view, i);
                                if (progressBar != null) {
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
                                                TextTitle3View textTitle3View = (TextTitle3View) ViewBindings.findChildViewById(view, i);
                                                if (textTitle3View != null) {
                                                    return new AuthQrInfoBinding(frameLayout, topBarDefault, imageView, constraintLayout, emptyStateLargeView, imageView2, frameLayout, primaryButtonView, progressBar, secondaryButtonView, stateFlipViewGroup, textBodyView, textTitle3View);
                                                }
                                            }
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

    public static AuthQrInfoBinding inflate(LayoutInflater layoutInflater) {
        return inflate(layoutInflater, null, false);
    }

    public static AuthQrInfoBinding inflate(LayoutInflater layoutInflater, ViewGroup viewGroup, boolean z) {
        View viewInflate = layoutInflater.inflate(R.layout.auth_qr_info, viewGroup, false);
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

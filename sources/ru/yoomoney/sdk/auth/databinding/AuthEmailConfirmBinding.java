package ru.yoomoney.sdk.auth.databinding;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.FrameLayout;
import android.widget.LinearLayout;
import androidx.constraintlayout.widget.ConstraintLayout;
import androidx.coordinatorlayout.widget.CoordinatorLayout;
import androidx.viewbinding.ViewBinding;
import androidx.viewbinding.ViewBindings;
import ru.yoomoney.sdk.auth.R;
import ru.yoomoney.sdk.auth.ui.FlatButtonView;
import ru.yoomoney.sdk.auth.ui.ItemSecondarySwitchView;
import ru.yoomoney.sdk.auth.ui.ItemVectorFadeDetailView;
import ru.yoomoney.sdk.auth.ui.PrimaryButtonView;
import ru.yoomoney.sdk.auth.ui.ProgressBar;
import ru.yoomoney.sdk.auth.ui.TextInputView;
import ru.yoomoney.sdk.auth.ui.TopBarDefault;
import ru.yoomoney.sdk.gui.widget.text.TextBodyView;
import ru.yoomoney.sdk.gui.widget.text.TextTitle1View;

/* loaded from: classes4.dex */
public final class AuthEmailConfirmBinding implements ViewBinding {
    public final PrimaryButtonView action;
    public final TopBarDefault appBar;
    public final TextInputView code;
    public final TextBodyView description;
    public final ItemVectorFadeDetailView emailView;
    public final FlatButtonView forgotAction;
    public final ItemSecondarySwitchView offers;
    public final TextBodyView otherEmail;
    public final ConstraintLayout parent;
    public final ProgressBar progressBar;
    public final FrameLayout retryActionContainer;
    private final CoordinatorLayout rootView;
    public final TextTitle1View title;
    public final LinearLayout webbankirContainer;

    private AuthEmailConfirmBinding(CoordinatorLayout coordinatorLayout, PrimaryButtonView primaryButtonView, TopBarDefault topBarDefault, TextInputView textInputView, TextBodyView textBodyView, ItemVectorFadeDetailView itemVectorFadeDetailView, FlatButtonView flatButtonView, ItemSecondarySwitchView itemSecondarySwitchView, TextBodyView textBodyView2, ConstraintLayout constraintLayout, ProgressBar progressBar, FrameLayout frameLayout, TextTitle1View textTitle1View, LinearLayout linearLayout) {
        this.rootView = coordinatorLayout;
        this.action = primaryButtonView;
        this.appBar = topBarDefault;
        this.code = textInputView;
        this.description = textBodyView;
        this.emailView = itemVectorFadeDetailView;
        this.forgotAction = flatButtonView;
        this.offers = itemSecondarySwitchView;
        this.otherEmail = textBodyView2;
        this.parent = constraintLayout;
        this.progressBar = progressBar;
        this.retryActionContainer = frameLayout;
        this.title = textTitle1View;
        this.webbankirContainer = linearLayout;
    }

    public static AuthEmailConfirmBinding bind(View view) {
        int i = R.id.action;
        PrimaryButtonView primaryButtonView = (PrimaryButtonView) ViewBindings.findChildViewById(view, i);
        if (primaryButtonView != null) {
            i = R.id.app_bar;
            TopBarDefault topBarDefault = (TopBarDefault) ViewBindings.findChildViewById(view, i);
            if (topBarDefault != null) {
                i = R.id.code;
                TextInputView textInputView = (TextInputView) ViewBindings.findChildViewById(view, i);
                if (textInputView != null) {
                    i = R.id.description;
                    TextBodyView textBodyView = (TextBodyView) ViewBindings.findChildViewById(view, i);
                    if (textBodyView != null) {
                        i = R.id.email_view;
                        ItemVectorFadeDetailView itemVectorFadeDetailView = (ItemVectorFadeDetailView) ViewBindings.findChildViewById(view, i);
                        if (itemVectorFadeDetailView != null) {
                            i = R.id.forgot_action;
                            FlatButtonView flatButtonView = (FlatButtonView) ViewBindings.findChildViewById(view, i);
                            if (flatButtonView != null) {
                                i = R.id.offers;
                                ItemSecondarySwitchView itemSecondarySwitchView = (ItemSecondarySwitchView) ViewBindings.findChildViewById(view, i);
                                if (itemSecondarySwitchView != null) {
                                    i = R.id.other_email;
                                    TextBodyView textBodyView2 = (TextBodyView) ViewBindings.findChildViewById(view, i);
                                    if (textBodyView2 != null) {
                                        i = R.id.parent;
                                        ConstraintLayout constraintLayout = (ConstraintLayout) ViewBindings.findChildViewById(view, i);
                                        if (constraintLayout != null) {
                                            i = R.id.progress_bar;
                                            ProgressBar progressBar = (ProgressBar) ViewBindings.findChildViewById(view, i);
                                            if (progressBar != null) {
                                                i = R.id.retry_action_container;
                                                FrameLayout frameLayout = (FrameLayout) ViewBindings.findChildViewById(view, i);
                                                if (frameLayout != null) {
                                                    i = R.id.title;
                                                    TextTitle1View textTitle1View = (TextTitle1View) ViewBindings.findChildViewById(view, i);
                                                    if (textTitle1View != null) {
                                                        i = R.id.webbankir_container;
                                                        LinearLayout linearLayout = (LinearLayout) ViewBindings.findChildViewById(view, i);
                                                        if (linearLayout != null) {
                                                            return new AuthEmailConfirmBinding((CoordinatorLayout) view, primaryButtonView, topBarDefault, textInputView, textBodyView, itemVectorFadeDetailView, flatButtonView, itemSecondarySwitchView, textBodyView2, constraintLayout, progressBar, frameLayout, textTitle1View, linearLayout);
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
            }
        }
        throw new NullPointerException("Missing required view with ID: ".concat(view.getResources().getResourceName(i)));
    }

    public static AuthEmailConfirmBinding inflate(LayoutInflater layoutInflater) {
        return inflate(layoutInflater, null, false);
    }

    public static AuthEmailConfirmBinding inflate(LayoutInflater layoutInflater, ViewGroup viewGroup, boolean z) {
        View viewInflate = layoutInflater.inflate(R.layout.auth_email_confirm, viewGroup, false);
        if (z) {
            viewGroup.addView(viewInflate);
        }
        return bind(viewInflate);
    }

    @Override // androidx.viewbinding.ViewBinding
    public CoordinatorLayout getRoot() {
        return this.rootView;
    }
}

package ru.yoomoney.sdk.auth.databinding;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.LinearLayout;
import androidx.constraintlayout.widget.Barrier;
import androidx.constraintlayout.widget.ConstraintLayout;
import androidx.viewbinding.ViewBinding;
import androidx.viewbinding.ViewBindings;
import ru.yoomoney.sdk.auth.R;
import ru.yoomoney.sdk.auth.ui.FlatButtonView;
import ru.yoomoney.sdk.auth.ui.ProgressBar;
import ru.yoomoney.sdk.auth.ui.TextInputView;
import ru.yoomoney.sdk.auth.ui.TopBarDefault;
import ru.yoomoney.sdk.gui.widget.ConfirmCodeInputView;
import ru.yoomoney.sdk.gui.widget.text.TextBodyView;
import ru.yoomoney.sdk.gui.widget.text.TextCaption2View;
import ru.yoomoney.sdk.gui.widget.text.TextTitle1View;

/* loaded from: classes4.dex */
public final class AuthPhoneConfirmBinding implements ViewBinding {
    public final TopBarDefault appBar;
    public final Barrier barrier;
    public final ConfirmCodeInputView confirmCodeCustom;
    public final TextInputView confirmCodeDefault;
    public final TextBodyView descriptionCustom;
    public final TextBodyView descriptionDefault;
    public final TextCaption2View errorCustom;
    public final FlatButtonView forgotAction;
    public final LinearLayout linearForRetryAction;
    public final ConstraintLayout parent;
    public final ProgressBar progressBar;
    public final FlatButtonView retryAction;
    private final ConstraintLayout rootView;
    public final TextTitle1View title;

    private AuthPhoneConfirmBinding(ConstraintLayout constraintLayout, TopBarDefault topBarDefault, Barrier barrier, ConfirmCodeInputView confirmCodeInputView, TextInputView textInputView, TextBodyView textBodyView, TextBodyView textBodyView2, TextCaption2View textCaption2View, FlatButtonView flatButtonView, LinearLayout linearLayout, ConstraintLayout constraintLayout2, ProgressBar progressBar, FlatButtonView flatButtonView2, TextTitle1View textTitle1View) {
        this.rootView = constraintLayout;
        this.appBar = topBarDefault;
        this.barrier = barrier;
        this.confirmCodeCustom = confirmCodeInputView;
        this.confirmCodeDefault = textInputView;
        this.descriptionCustom = textBodyView;
        this.descriptionDefault = textBodyView2;
        this.errorCustom = textCaption2View;
        this.forgotAction = flatButtonView;
        this.linearForRetryAction = linearLayout;
        this.parent = constraintLayout2;
        this.progressBar = progressBar;
        this.retryAction = flatButtonView2;
        this.title = textTitle1View;
    }

    public static AuthPhoneConfirmBinding bind(View view) {
        int i = R.id.appBar;
        TopBarDefault topBarDefault = (TopBarDefault) ViewBindings.findChildViewById(view, i);
        if (topBarDefault != null) {
            i = R.id.barrier;
            Barrier barrier = (Barrier) ViewBindings.findChildViewById(view, i);
            if (barrier != null) {
                i = R.id.confirmCodeCustom;
                ConfirmCodeInputView confirmCodeInputView = (ConfirmCodeInputView) ViewBindings.findChildViewById(view, i);
                if (confirmCodeInputView != null) {
                    i = R.id.confirmCodeDefault;
                    TextInputView textInputView = (TextInputView) ViewBindings.findChildViewById(view, i);
                    if (textInputView != null) {
                        i = R.id.descriptionCustom;
                        TextBodyView textBodyView = (TextBodyView) ViewBindings.findChildViewById(view, i);
                        if (textBodyView != null) {
                            i = R.id.descriptionDefault;
                            TextBodyView textBodyView2 = (TextBodyView) ViewBindings.findChildViewById(view, i);
                            if (textBodyView2 != null) {
                                i = R.id.errorCustom;
                                TextCaption2View textCaption2View = (TextCaption2View) ViewBindings.findChildViewById(view, i);
                                if (textCaption2View != null) {
                                    i = R.id.forgotAction;
                                    FlatButtonView flatButtonView = (FlatButtonView) ViewBindings.findChildViewById(view, i);
                                    if (flatButtonView != null) {
                                        i = R.id.linearForRetryAction;
                                        LinearLayout linearLayout = (LinearLayout) ViewBindings.findChildViewById(view, i);
                                        if (linearLayout != null) {
                                            ConstraintLayout constraintLayout = (ConstraintLayout) view;
                                            i = R.id.progress_bar;
                                            ProgressBar progressBar = (ProgressBar) ViewBindings.findChildViewById(view, i);
                                            if (progressBar != null) {
                                                i = R.id.retryAction;
                                                FlatButtonView flatButtonView2 = (FlatButtonView) ViewBindings.findChildViewById(view, i);
                                                if (flatButtonView2 != null) {
                                                    i = R.id.title;
                                                    TextTitle1View textTitle1View = (TextTitle1View) ViewBindings.findChildViewById(view, i);
                                                    if (textTitle1View != null) {
                                                        return new AuthPhoneConfirmBinding(constraintLayout, topBarDefault, barrier, confirmCodeInputView, textInputView, textBodyView, textBodyView2, textCaption2View, flatButtonView, linearLayout, constraintLayout, progressBar, flatButtonView2, textTitle1View);
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

    public static AuthPhoneConfirmBinding inflate(LayoutInflater layoutInflater) {
        return inflate(layoutInflater, null, false);
    }

    public static AuthPhoneConfirmBinding inflate(LayoutInflater layoutInflater, ViewGroup viewGroup, boolean z) {
        View viewInflate = layoutInflater.inflate(R.layout.auth_phone_confirm, viewGroup, false);
        if (z) {
            viewGroup.addView(viewInflate);
        }
        return bind(viewInflate);
    }

    @Override // androidx.viewbinding.ViewBinding
    public ConstraintLayout getRoot() {
        return this.rootView;
    }
}

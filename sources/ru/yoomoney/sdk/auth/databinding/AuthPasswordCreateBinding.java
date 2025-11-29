package ru.yoomoney.sdk.auth.databinding;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.LinearLayout;
import androidx.constraintlayout.widget.ConstraintLayout;
import androidx.viewbinding.ViewBinding;
import androidx.viewbinding.ViewBindings;
import ru.yoomoney.sdk.auth.R;
import ru.yoomoney.sdk.auth.ui.PasswordInputView;
import ru.yoomoney.sdk.auth.ui.PrimaryButtonView;
import ru.yoomoney.sdk.auth.ui.ProgressBar;
import ru.yoomoney.sdk.auth.ui.TopBarDefault;
import ru.yoomoney.sdk.auth.ui.ValidateTextView;
import ru.yoomoney.sdk.gui.widget.ContentScrollView;
import ru.yoomoney.sdk.gui.widget.text.TextBodyView;
import ru.yoomoney.sdk.gui.widget.text.TextCaption2View;

/* loaded from: classes4.dex */
public final class AuthPasswordCreateBinding implements ViewBinding {
    public final PrimaryButtonView action;
    public final TextCaption2View agreement;
    public final TopBarDefault appBar;
    public final TextBodyView generatePassword;
    public final ConstraintLayout parent;
    public final PasswordInputView passwordFirst;
    public final PasswordInputView passwordSecond;
    public final ProgressBar progressBar;
    private final LinearLayout rootView;
    public final ContentScrollView scroll;
    public final ValidateTextView validateLength;
    public final ValidateTextView validateLetters;
    public final ValidateTextView validateNumbersContains;

    private AuthPasswordCreateBinding(LinearLayout linearLayout, PrimaryButtonView primaryButtonView, TextCaption2View textCaption2View, TopBarDefault topBarDefault, TextBodyView textBodyView, ConstraintLayout constraintLayout, PasswordInputView passwordInputView, PasswordInputView passwordInputView2, ProgressBar progressBar, ContentScrollView contentScrollView, ValidateTextView validateTextView, ValidateTextView validateTextView2, ValidateTextView validateTextView3) {
        this.rootView = linearLayout;
        this.action = primaryButtonView;
        this.agreement = textCaption2View;
        this.appBar = topBarDefault;
        this.generatePassword = textBodyView;
        this.parent = constraintLayout;
        this.passwordFirst = passwordInputView;
        this.passwordSecond = passwordInputView2;
        this.progressBar = progressBar;
        this.scroll = contentScrollView;
        this.validateLength = validateTextView;
        this.validateLetters = validateTextView2;
        this.validateNumbersContains = validateTextView3;
    }

    public static AuthPasswordCreateBinding bind(View view) {
        int i = R.id.action;
        PrimaryButtonView primaryButtonView = (PrimaryButtonView) ViewBindings.findChildViewById(view, i);
        if (primaryButtonView != null) {
            i = R.id.agreement;
            TextCaption2View textCaption2View = (TextCaption2View) ViewBindings.findChildViewById(view, i);
            if (textCaption2View != null) {
                i = R.id.appBar;
                TopBarDefault topBarDefault = (TopBarDefault) ViewBindings.findChildViewById(view, i);
                if (topBarDefault != null) {
                    i = R.id.generate_password;
                    TextBodyView textBodyView = (TextBodyView) ViewBindings.findChildViewById(view, i);
                    if (textBodyView != null) {
                        i = R.id.parent;
                        ConstraintLayout constraintLayout = (ConstraintLayout) ViewBindings.findChildViewById(view, i);
                        if (constraintLayout != null) {
                            i = R.id.passwordFirst;
                            PasswordInputView passwordInputView = (PasswordInputView) ViewBindings.findChildViewById(view, i);
                            if (passwordInputView != null) {
                                i = R.id.passwordSecond;
                                PasswordInputView passwordInputView2 = (PasswordInputView) ViewBindings.findChildViewById(view, i);
                                if (passwordInputView2 != null) {
                                    i = R.id.progress_bar;
                                    ProgressBar progressBar = (ProgressBar) ViewBindings.findChildViewById(view, i);
                                    if (progressBar != null) {
                                        i = R.id.scroll;
                                        ContentScrollView contentScrollView = (ContentScrollView) ViewBindings.findChildViewById(view, i);
                                        if (contentScrollView != null) {
                                            i = R.id.validateLength;
                                            ValidateTextView validateTextView = (ValidateTextView) ViewBindings.findChildViewById(view, i);
                                            if (validateTextView != null) {
                                                i = R.id.validateLetters;
                                                ValidateTextView validateTextView2 = (ValidateTextView) ViewBindings.findChildViewById(view, i);
                                                if (validateTextView2 != null) {
                                                    i = R.id.validateNumbersContains;
                                                    ValidateTextView validateTextView3 = (ValidateTextView) ViewBindings.findChildViewById(view, i);
                                                    if (validateTextView3 != null) {
                                                        return new AuthPasswordCreateBinding((LinearLayout) view, primaryButtonView, textCaption2View, topBarDefault, textBodyView, constraintLayout, passwordInputView, passwordInputView2, progressBar, contentScrollView, validateTextView, validateTextView2, validateTextView3);
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

    public static AuthPasswordCreateBinding inflate(LayoutInflater layoutInflater) {
        return inflate(layoutInflater, null, false);
    }

    public static AuthPasswordCreateBinding inflate(LayoutInflater layoutInflater, ViewGroup viewGroup, boolean z) {
        View viewInflate = layoutInflater.inflate(R.layout.auth_password_create, viewGroup, false);
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

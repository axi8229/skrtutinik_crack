package ru.yoomoney.sdk.auth.databinding;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import androidx.constraintlayout.widget.ConstraintLayout;
import androidx.viewbinding.ViewBinding;
import androidx.viewbinding.ViewBindings;
import ru.yoomoney.sdk.auth.R;
import ru.yoomoney.sdk.auth.ui.PrimaryButtonView;
import ru.yoomoney.sdk.auth.ui.TextInputView;
import ru.yoomoney.sdk.auth.ui.TopBarDefault;

/* loaded from: classes4.dex */
public final class AuthLoginEnterBinding implements ViewBinding {
    public final PrimaryButtonView action;
    public final TopBarDefault appBar;
    public final AuthBannerActionBinding bannerAction;
    public final TextInputView login;
    public final ConstraintLayout parent;
    private final ConstraintLayout rootView;

    private AuthLoginEnterBinding(ConstraintLayout constraintLayout, PrimaryButtonView primaryButtonView, TopBarDefault topBarDefault, AuthBannerActionBinding authBannerActionBinding, TextInputView textInputView, ConstraintLayout constraintLayout2) {
        this.rootView = constraintLayout;
        this.action = primaryButtonView;
        this.appBar = topBarDefault;
        this.bannerAction = authBannerActionBinding;
        this.login = textInputView;
        this.parent = constraintLayout2;
    }

    public static AuthLoginEnterBinding bind(View view) {
        View viewFindChildViewById;
        int i = R.id.action;
        PrimaryButtonView primaryButtonView = (PrimaryButtonView) ViewBindings.findChildViewById(view, i);
        if (primaryButtonView != null) {
            i = R.id.appBar;
            TopBarDefault topBarDefault = (TopBarDefault) ViewBindings.findChildViewById(view, i);
            if (topBarDefault != null && (viewFindChildViewById = ViewBindings.findChildViewById(view, (i = R.id.banner_action))) != null) {
                AuthBannerActionBinding authBannerActionBindingBind = AuthBannerActionBinding.bind(viewFindChildViewById);
                i = R.id.login;
                TextInputView textInputView = (TextInputView) ViewBindings.findChildViewById(view, i);
                if (textInputView != null) {
                    ConstraintLayout constraintLayout = (ConstraintLayout) view;
                    return new AuthLoginEnterBinding(constraintLayout, primaryButtonView, topBarDefault, authBannerActionBindingBind, textInputView, constraintLayout);
                }
            }
        }
        throw new NullPointerException("Missing required view with ID: ".concat(view.getResources().getResourceName(i)));
    }

    public static AuthLoginEnterBinding inflate(LayoutInflater layoutInflater) {
        return inflate(layoutInflater, null, false);
    }

    public static AuthLoginEnterBinding inflate(LayoutInflater layoutInflater, ViewGroup viewGroup, boolean z) {
        View viewInflate = layoutInflater.inflate(R.layout.auth_login_enter, viewGroup, false);
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

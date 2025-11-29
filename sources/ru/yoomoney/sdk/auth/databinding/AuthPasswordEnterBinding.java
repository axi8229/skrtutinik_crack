package ru.yoomoney.sdk.auth.databinding;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import androidx.constraintlayout.widget.ConstraintLayout;
import androidx.coordinatorlayout.widget.CoordinatorLayout;
import androidx.viewbinding.ViewBinding;
import androidx.viewbinding.ViewBindings;
import ru.yoomoney.sdk.auth.R;
import ru.yoomoney.sdk.auth.ui.ItemImageRoundIconServicesView;
import ru.yoomoney.sdk.auth.ui.PrimaryButtonView;
import ru.yoomoney.sdk.auth.ui.TextInputView;
import ru.yoomoney.sdk.auth.ui.TopBarDefault;
import ru.yoomoney.sdk.gui.widget.ContentScrollView;
import ru.yoomoney.sdk.gui.widget.text.TextBodyView;
import ru.yoomoney.sdk.gui.widget.text.TextTitle1View;

/* loaded from: classes4.dex */
public final class AuthPasswordEnterBinding implements ViewBinding {
    public final ItemImageRoundIconServicesView accountView;
    public final PrimaryButtonView action;
    public final TopBarDefault appBar;
    public final TextBodyView forgot;
    public final ConstraintLayout parent;
    public final TextInputView password;
    private final CoordinatorLayout rootView;
    public final ContentScrollView scroll;
    public final TextTitle1View title;
    public final TextBodyView warning;

    private AuthPasswordEnterBinding(CoordinatorLayout coordinatorLayout, ItemImageRoundIconServicesView itemImageRoundIconServicesView, PrimaryButtonView primaryButtonView, TopBarDefault topBarDefault, TextBodyView textBodyView, ConstraintLayout constraintLayout, TextInputView textInputView, ContentScrollView contentScrollView, TextTitle1View textTitle1View, TextBodyView textBodyView2) {
        this.rootView = coordinatorLayout;
        this.accountView = itemImageRoundIconServicesView;
        this.action = primaryButtonView;
        this.appBar = topBarDefault;
        this.forgot = textBodyView;
        this.parent = constraintLayout;
        this.password = textInputView;
        this.scroll = contentScrollView;
        this.title = textTitle1View;
        this.warning = textBodyView2;
    }

    public static AuthPasswordEnterBinding bind(View view) {
        int i = R.id.accountView;
        ItemImageRoundIconServicesView itemImageRoundIconServicesView = (ItemImageRoundIconServicesView) ViewBindings.findChildViewById(view, i);
        if (itemImageRoundIconServicesView != null) {
            i = R.id.action;
            PrimaryButtonView primaryButtonView = (PrimaryButtonView) ViewBindings.findChildViewById(view, i);
            if (primaryButtonView != null) {
                i = R.id.appBar;
                TopBarDefault topBarDefault = (TopBarDefault) ViewBindings.findChildViewById(view, i);
                if (topBarDefault != null) {
                    i = R.id.forgot;
                    TextBodyView textBodyView = (TextBodyView) ViewBindings.findChildViewById(view, i);
                    if (textBodyView != null) {
                        i = R.id.parent;
                        ConstraintLayout constraintLayout = (ConstraintLayout) ViewBindings.findChildViewById(view, i);
                        if (constraintLayout != null) {
                            i = R.id.password;
                            TextInputView textInputView = (TextInputView) ViewBindings.findChildViewById(view, i);
                            if (textInputView != null) {
                                i = R.id.scroll;
                                ContentScrollView contentScrollView = (ContentScrollView) ViewBindings.findChildViewById(view, i);
                                if (contentScrollView != null) {
                                    i = R.id.title;
                                    TextTitle1View textTitle1View = (TextTitle1View) ViewBindings.findChildViewById(view, i);
                                    if (textTitle1View != null) {
                                        i = R.id.warning;
                                        TextBodyView textBodyView2 = (TextBodyView) ViewBindings.findChildViewById(view, i);
                                        if (textBodyView2 != null) {
                                            return new AuthPasswordEnterBinding((CoordinatorLayout) view, itemImageRoundIconServicesView, primaryButtonView, topBarDefault, textBodyView, constraintLayout, textInputView, contentScrollView, textTitle1View, textBodyView2);
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

    public static AuthPasswordEnterBinding inflate(LayoutInflater layoutInflater) {
        return inflate(layoutInflater, null, false);
    }

    public static AuthPasswordEnterBinding inflate(LayoutInflater layoutInflater, ViewGroup viewGroup, boolean z) {
        View viewInflate = layoutInflater.inflate(R.layout.auth_password_enter, viewGroup, false);
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

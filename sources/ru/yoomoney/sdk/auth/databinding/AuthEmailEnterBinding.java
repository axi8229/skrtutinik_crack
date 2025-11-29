package ru.yoomoney.sdk.auth.databinding;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.LinearLayout;
import androidx.constraintlayout.widget.ConstraintLayout;
import androidx.viewbinding.ViewBinding;
import androidx.viewbinding.ViewBindings;
import ru.yoomoney.sdk.auth.R;
import ru.yoomoney.sdk.auth.ui.ItemSecondarySwitchView;
import ru.yoomoney.sdk.auth.ui.PrimaryButtonView;
import ru.yoomoney.sdk.auth.ui.TextInputView;
import ru.yoomoney.sdk.auth.ui.TopBarDefault;
import ru.yoomoney.sdk.gui.widget.text.TextBodyView;
import ru.yoomoney.sdk.gui.widget.text.TextTitle1View;

/* loaded from: classes4.dex */
public final class AuthEmailEnterBinding implements ViewBinding {
    public final PrimaryButtonView action;
    public final TopBarDefault appBar;
    public final TextInputView email;
    public final ItemSecondarySwitchView offers;
    public final ConstraintLayout parent;
    private final LinearLayout rootView;
    public final TextBodyView subtitle;
    public final TextTitle1View title;

    private AuthEmailEnterBinding(LinearLayout linearLayout, PrimaryButtonView primaryButtonView, TopBarDefault topBarDefault, TextInputView textInputView, ItemSecondarySwitchView itemSecondarySwitchView, ConstraintLayout constraintLayout, TextBodyView textBodyView, TextTitle1View textTitle1View) {
        this.rootView = linearLayout;
        this.action = primaryButtonView;
        this.appBar = topBarDefault;
        this.email = textInputView;
        this.offers = itemSecondarySwitchView;
        this.parent = constraintLayout;
        this.subtitle = textBodyView;
        this.title = textTitle1View;
    }

    public static AuthEmailEnterBinding bind(View view) {
        int i = R.id.action;
        PrimaryButtonView primaryButtonView = (PrimaryButtonView) ViewBindings.findChildViewById(view, i);
        if (primaryButtonView != null) {
            i = R.id.appBar;
            TopBarDefault topBarDefault = (TopBarDefault) ViewBindings.findChildViewById(view, i);
            if (topBarDefault != null) {
                i = R.id.email;
                TextInputView textInputView = (TextInputView) ViewBindings.findChildViewById(view, i);
                if (textInputView != null) {
                    i = R.id.offers;
                    ItemSecondarySwitchView itemSecondarySwitchView = (ItemSecondarySwitchView) ViewBindings.findChildViewById(view, i);
                    if (itemSecondarySwitchView != null) {
                        i = R.id.parent;
                        ConstraintLayout constraintLayout = (ConstraintLayout) ViewBindings.findChildViewById(view, i);
                        if (constraintLayout != null) {
                            i = R.id.subtitle;
                            TextBodyView textBodyView = (TextBodyView) ViewBindings.findChildViewById(view, i);
                            if (textBodyView != null) {
                                i = R.id.title;
                                TextTitle1View textTitle1View = (TextTitle1View) ViewBindings.findChildViewById(view, i);
                                if (textTitle1View != null) {
                                    return new AuthEmailEnterBinding((LinearLayout) view, primaryButtonView, topBarDefault, textInputView, itemSecondarySwitchView, constraintLayout, textBodyView, textTitle1View);
                                }
                            }
                        }
                    }
                }
            }
        }
        throw new NullPointerException("Missing required view with ID: ".concat(view.getResources().getResourceName(i)));
    }

    public static AuthEmailEnterBinding inflate(LayoutInflater layoutInflater) {
        return inflate(layoutInflater, null, false);
    }

    public static AuthEmailEnterBinding inflate(LayoutInflater layoutInflater, ViewGroup viewGroup, boolean z) {
        View viewInflate = layoutInflater.inflate(R.layout.auth_email_enter, viewGroup, false);
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

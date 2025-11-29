package ru.yoomoney.sdk.auth.databinding;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.LinearLayout;
import androidx.constraintlayout.widget.ConstraintLayout;
import androidx.viewbinding.ViewBinding;
import androidx.viewbinding.ViewBindings;
import ru.yoomoney.sdk.auth.R;
import ru.yoomoney.sdk.auth.ui.PrimaryButtonView;
import ru.yoomoney.sdk.auth.ui.SecondaryButtonView;
import ru.yoomoney.sdk.auth.ui.TextInputView;
import ru.yoomoney.sdk.auth.ui.TopBarDefault;
import ru.yoomoney.sdk.gui.widget.text.TextBodyView;
import ru.yoomoney.sdk.gui.widget.text.TextCaption1View;
import ru.yoomoney.sdk.gui.widget.text.TextTitle1View;

/* loaded from: classes4.dex */
public final class AuthPhoneEnterBinding implements ViewBinding {
    public final PrimaryButtonView action;
    public final TopBarDefault appBar;
    public final TextBodyView countries;
    public final TextCaption1View identificationInformer;
    public final ConstraintLayout parent;
    public final TextInputView phone;
    public final SecondaryButtonView phoneDisabled;
    private final LinearLayout rootView;
    public final TextTitle1View title;

    private AuthPhoneEnterBinding(LinearLayout linearLayout, PrimaryButtonView primaryButtonView, TopBarDefault topBarDefault, TextBodyView textBodyView, TextCaption1View textCaption1View, ConstraintLayout constraintLayout, TextInputView textInputView, SecondaryButtonView secondaryButtonView, TextTitle1View textTitle1View) {
        this.rootView = linearLayout;
        this.action = primaryButtonView;
        this.appBar = topBarDefault;
        this.countries = textBodyView;
        this.identificationInformer = textCaption1View;
        this.parent = constraintLayout;
        this.phone = textInputView;
        this.phoneDisabled = secondaryButtonView;
        this.title = textTitle1View;
    }

    public static AuthPhoneEnterBinding bind(View view) {
        int i = R.id.action;
        PrimaryButtonView primaryButtonView = (PrimaryButtonView) ViewBindings.findChildViewById(view, i);
        if (primaryButtonView != null) {
            i = R.id.appBar;
            TopBarDefault topBarDefault = (TopBarDefault) ViewBindings.findChildViewById(view, i);
            if (topBarDefault != null) {
                i = R.id.countries;
                TextBodyView textBodyView = (TextBodyView) ViewBindings.findChildViewById(view, i);
                if (textBodyView != null) {
                    i = R.id.identification_informer;
                    TextCaption1View textCaption1View = (TextCaption1View) ViewBindings.findChildViewById(view, i);
                    if (textCaption1View != null) {
                        i = R.id.parent;
                        ConstraintLayout constraintLayout = (ConstraintLayout) ViewBindings.findChildViewById(view, i);
                        if (constraintLayout != null) {
                            i = R.id.phone;
                            TextInputView textInputView = (TextInputView) ViewBindings.findChildViewById(view, i);
                            if (textInputView != null) {
                                i = R.id.phoneDisabled;
                                SecondaryButtonView secondaryButtonView = (SecondaryButtonView) ViewBindings.findChildViewById(view, i);
                                if (secondaryButtonView != null) {
                                    i = R.id.title;
                                    TextTitle1View textTitle1View = (TextTitle1View) ViewBindings.findChildViewById(view, i);
                                    if (textTitle1View != null) {
                                        return new AuthPhoneEnterBinding((LinearLayout) view, primaryButtonView, topBarDefault, textBodyView, textCaption1View, constraintLayout, textInputView, secondaryButtonView, textTitle1View);
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

    public static AuthPhoneEnterBinding inflate(LayoutInflater layoutInflater) {
        return inflate(layoutInflater, null, false);
    }

    public static AuthPhoneEnterBinding inflate(LayoutInflater layoutInflater, ViewGroup viewGroup, boolean z) {
        View viewInflate = layoutInflater.inflate(R.layout.auth_phone_enter, viewGroup, false);
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

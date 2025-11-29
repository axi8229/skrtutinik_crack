package ru.yoomoney.sdk.auth.databinding;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import androidx.constraintlayout.widget.ConstraintLayout;
import androidx.viewbinding.ViewBinding;
import androidx.viewbinding.ViewBindings;
import ru.yoomoney.sdk.auth.R;
import ru.yoomoney.sdk.auth.ui.FormSelectView;
import ru.yoomoney.sdk.auth.ui.PrimaryButtonView;
import ru.yoomoney.sdk.auth.ui.TopBarDefault;
import ru.yoomoney.sdk.gui.widget.text.TextBodyView;
import ru.yoomoney.sdk.gui.widget.text.TextCaption1View;
import ru.yoomoney.sdk.gui.widget.text.TextTitle1View;

/* loaded from: classes4.dex */
public final class AuthSelectEmailBinding implements ViewBinding {
    public final PrimaryButtonView action;
    public final TopBarDefault appBar;
    public final TextCaption1View error;
    public final ConstraintLayout parent;
    private final ConstraintLayout rootView;
    public final FormSelectView selector;
    public final TextBodyView subtitle;
    public final TextTitle1View title;

    private AuthSelectEmailBinding(ConstraintLayout constraintLayout, PrimaryButtonView primaryButtonView, TopBarDefault topBarDefault, TextCaption1View textCaption1View, ConstraintLayout constraintLayout2, FormSelectView formSelectView, TextBodyView textBodyView, TextTitle1View textTitle1View) {
        this.rootView = constraintLayout;
        this.action = primaryButtonView;
        this.appBar = topBarDefault;
        this.error = textCaption1View;
        this.parent = constraintLayout2;
        this.selector = formSelectView;
        this.subtitle = textBodyView;
        this.title = textTitle1View;
    }

    public static AuthSelectEmailBinding bind(View view) {
        int i = R.id.action;
        PrimaryButtonView primaryButtonView = (PrimaryButtonView) ViewBindings.findChildViewById(view, i);
        if (primaryButtonView != null) {
            i = R.id.appBar;
            TopBarDefault topBarDefault = (TopBarDefault) ViewBindings.findChildViewById(view, i);
            if (topBarDefault != null) {
                i = R.id.error;
                TextCaption1View textCaption1View = (TextCaption1View) ViewBindings.findChildViewById(view, i);
                if (textCaption1View != null) {
                    ConstraintLayout constraintLayout = (ConstraintLayout) view;
                    i = R.id.selector;
                    FormSelectView formSelectView = (FormSelectView) ViewBindings.findChildViewById(view, i);
                    if (formSelectView != null) {
                        i = R.id.subtitle;
                        TextBodyView textBodyView = (TextBodyView) ViewBindings.findChildViewById(view, i);
                        if (textBodyView != null) {
                            i = R.id.title;
                            TextTitle1View textTitle1View = (TextTitle1View) ViewBindings.findChildViewById(view, i);
                            if (textTitle1View != null) {
                                return new AuthSelectEmailBinding(constraintLayout, primaryButtonView, topBarDefault, textCaption1View, constraintLayout, formSelectView, textBodyView, textTitle1View);
                            }
                        }
                    }
                }
            }
        }
        throw new NullPointerException("Missing required view with ID: ".concat(view.getResources().getResourceName(i)));
    }

    public static AuthSelectEmailBinding inflate(LayoutInflater layoutInflater) {
        return inflate(layoutInflater, null, false);
    }

    public static AuthSelectEmailBinding inflate(LayoutInflater layoutInflater, ViewGroup viewGroup, boolean z) {
        View viewInflate = layoutInflater.inflate(R.layout.auth_select_email, viewGroup, false);
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

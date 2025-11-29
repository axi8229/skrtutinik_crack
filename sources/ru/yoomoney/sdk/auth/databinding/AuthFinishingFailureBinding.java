package ru.yoomoney.sdk.auth.databinding;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import androidx.constraintlayout.widget.ConstraintLayout;
import androidx.viewbinding.ViewBinding;
import androidx.viewbinding.ViewBindings;
import ru.yoomoney.sdk.auth.R;
import ru.yoomoney.sdk.auth.ui.PrimaryButtonView;
import ru.yoomoney.sdk.auth.ui.SecondaryButtonView;
import ru.yoomoney.sdk.auth.ui.TopBarDefault;
import ru.yoomoney.sdk.gui.widget.text.TextBodyView;
import ru.yoomoney.sdk.gui.widget.text.TextTitle1View;

/* loaded from: classes4.dex */
public final class AuthFinishingFailureBinding implements ViewBinding {
    public final PrimaryButtonView action;
    public final TopBarDefault appBar;
    public final ConstraintLayout parent;
    private final ConstraintLayout rootView;
    public final SecondaryButtonView secondaryAction;
    public final TextBodyView text;
    public final TextTitle1View title;

    private AuthFinishingFailureBinding(ConstraintLayout constraintLayout, PrimaryButtonView primaryButtonView, TopBarDefault topBarDefault, ConstraintLayout constraintLayout2, SecondaryButtonView secondaryButtonView, TextBodyView textBodyView, TextTitle1View textTitle1View) {
        this.rootView = constraintLayout;
        this.action = primaryButtonView;
        this.appBar = topBarDefault;
        this.parent = constraintLayout2;
        this.secondaryAction = secondaryButtonView;
        this.text = textBodyView;
        this.title = textTitle1View;
    }

    public static AuthFinishingFailureBinding bind(View view) {
        int i = R.id.action;
        PrimaryButtonView primaryButtonView = (PrimaryButtonView) ViewBindings.findChildViewById(view, i);
        if (primaryButtonView != null) {
            i = R.id.appBar;
            TopBarDefault topBarDefault = (TopBarDefault) ViewBindings.findChildViewById(view, i);
            if (topBarDefault != null) {
                ConstraintLayout constraintLayout = (ConstraintLayout) view;
                i = R.id.secondaryAction;
                SecondaryButtonView secondaryButtonView = (SecondaryButtonView) ViewBindings.findChildViewById(view, i);
                if (secondaryButtonView != null) {
                    i = R.id.text;
                    TextBodyView textBodyView = (TextBodyView) ViewBindings.findChildViewById(view, i);
                    if (textBodyView != null) {
                        i = R.id.title;
                        TextTitle1View textTitle1View = (TextTitle1View) ViewBindings.findChildViewById(view, i);
                        if (textTitle1View != null) {
                            return new AuthFinishingFailureBinding(constraintLayout, primaryButtonView, topBarDefault, constraintLayout, secondaryButtonView, textBodyView, textTitle1View);
                        }
                    }
                }
            }
        }
        throw new NullPointerException("Missing required view with ID: ".concat(view.getResources().getResourceName(i)));
    }

    public static AuthFinishingFailureBinding inflate(LayoutInflater layoutInflater) {
        return inflate(layoutInflater, null, false);
    }

    public static AuthFinishingFailureBinding inflate(LayoutInflater layoutInflater, ViewGroup viewGroup, boolean z) {
        View viewInflate = layoutInflater.inflate(R.layout.auth_finishing_failure, viewGroup, false);
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

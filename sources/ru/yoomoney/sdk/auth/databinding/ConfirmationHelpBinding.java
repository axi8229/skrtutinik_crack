package ru.yoomoney.sdk.auth.databinding;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.FrameLayout;
import androidx.constraintlayout.widget.ConstraintLayout;
import androidx.viewbinding.ViewBinding;
import androidx.viewbinding.ViewBindings;
import ru.yoomoney.sdk.auth.R;
import ru.yoomoney.sdk.auth.ui.PrimaryButtonView;
import ru.yoomoney.sdk.auth.ui.TopBarDefault;
import ru.yoomoney.sdk.gui.widget.text.TextBodyView;
import ru.yoomoney.sdk.gui.widget.text.TextTitle1View;

/* loaded from: classes4.dex */
public final class ConfirmationHelpBinding implements ViewBinding {
    public final PrimaryButtonView action;
    public final FrameLayout actionContainer;
    public final TopBarDefault appBar;
    public final ConstraintLayout parent;
    private final ConstraintLayout rootView;
    public final TextBodyView subtitle;
    public final TextTitle1View title;

    private ConfirmationHelpBinding(ConstraintLayout constraintLayout, PrimaryButtonView primaryButtonView, FrameLayout frameLayout, TopBarDefault topBarDefault, ConstraintLayout constraintLayout2, TextBodyView textBodyView, TextTitle1View textTitle1View) {
        this.rootView = constraintLayout;
        this.action = primaryButtonView;
        this.actionContainer = frameLayout;
        this.appBar = topBarDefault;
        this.parent = constraintLayout2;
        this.subtitle = textBodyView;
        this.title = textTitle1View;
    }

    public static ConfirmationHelpBinding bind(View view) {
        int i = R.id.action;
        PrimaryButtonView primaryButtonView = (PrimaryButtonView) ViewBindings.findChildViewById(view, i);
        if (primaryButtonView != null) {
            i = R.id.action_container;
            FrameLayout frameLayout = (FrameLayout) ViewBindings.findChildViewById(view, i);
            if (frameLayout != null) {
                i = R.id.app_bar;
                TopBarDefault topBarDefault = (TopBarDefault) ViewBindings.findChildViewById(view, i);
                if (topBarDefault != null) {
                    ConstraintLayout constraintLayout = (ConstraintLayout) view;
                    i = R.id.subtitle;
                    TextBodyView textBodyView = (TextBodyView) ViewBindings.findChildViewById(view, i);
                    if (textBodyView != null) {
                        i = R.id.title;
                        TextTitle1View textTitle1View = (TextTitle1View) ViewBindings.findChildViewById(view, i);
                        if (textTitle1View != null) {
                            return new ConfirmationHelpBinding(constraintLayout, primaryButtonView, frameLayout, topBarDefault, constraintLayout, textBodyView, textTitle1View);
                        }
                    }
                }
            }
        }
        throw new NullPointerException("Missing required view with ID: ".concat(view.getResources().getResourceName(i)));
    }

    public static ConfirmationHelpBinding inflate(LayoutInflater layoutInflater) {
        return inflate(layoutInflater, null, false);
    }

    public static ConfirmationHelpBinding inflate(LayoutInflater layoutInflater, ViewGroup viewGroup, boolean z) {
        View viewInflate = layoutInflater.inflate(R.layout.confirmation_help, viewGroup, false);
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

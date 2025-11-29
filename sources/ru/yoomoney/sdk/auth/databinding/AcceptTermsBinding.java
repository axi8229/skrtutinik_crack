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
import ru.yoomoney.sdk.auth.ui.TopBarDefault;
import ru.yoomoney.sdk.gui.widget.text.TextBodyView;
import ru.yoomoney.sdk.gui.widget.text.TextTitle2View;

/* loaded from: classes4.dex */
public final class AcceptTermsBinding implements ViewBinding {
    public final PrimaryButtonView action;
    public final TopBarDefault appBar;
    public final TextBodyView description;
    public final ConstraintLayout parent;
    private final LinearLayout rootView;
    public final TextTitle2View title;

    private AcceptTermsBinding(LinearLayout linearLayout, PrimaryButtonView primaryButtonView, TopBarDefault topBarDefault, TextBodyView textBodyView, ConstraintLayout constraintLayout, TextTitle2View textTitle2View) {
        this.rootView = linearLayout;
        this.action = primaryButtonView;
        this.appBar = topBarDefault;
        this.description = textBodyView;
        this.parent = constraintLayout;
        this.title = textTitle2View;
    }

    public static AcceptTermsBinding bind(View view) {
        int i = R.id.action;
        PrimaryButtonView primaryButtonView = (PrimaryButtonView) ViewBindings.findChildViewById(view, i);
        if (primaryButtonView != null) {
            i = R.id.appBar;
            TopBarDefault topBarDefault = (TopBarDefault) ViewBindings.findChildViewById(view, i);
            if (topBarDefault != null) {
                i = R.id.description;
                TextBodyView textBodyView = (TextBodyView) ViewBindings.findChildViewById(view, i);
                if (textBodyView != null) {
                    i = R.id.parent;
                    ConstraintLayout constraintLayout = (ConstraintLayout) ViewBindings.findChildViewById(view, i);
                    if (constraintLayout != null) {
                        i = R.id.title;
                        TextTitle2View textTitle2View = (TextTitle2View) ViewBindings.findChildViewById(view, i);
                        if (textTitle2View != null) {
                            return new AcceptTermsBinding((LinearLayout) view, primaryButtonView, topBarDefault, textBodyView, constraintLayout, textTitle2View);
                        }
                    }
                }
            }
        }
        throw new NullPointerException("Missing required view with ID: ".concat(view.getResources().getResourceName(i)));
    }

    public static AcceptTermsBinding inflate(LayoutInflater layoutInflater) {
        return inflate(layoutInflater, null, false);
    }

    public static AcceptTermsBinding inflate(LayoutInflater layoutInflater, ViewGroup viewGroup, boolean z) {
        View viewInflate = layoutInflater.inflate(R.layout.accept_terms, viewGroup, false);
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

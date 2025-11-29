package ru.yoomoney.sdk.auth.databinding;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import androidx.constraintlayout.widget.ConstraintLayout;
import androidx.viewbinding.ViewBinding;
import androidx.viewbinding.ViewBindings;
import ru.yoomoney.sdk.auth.R;
import ru.yoomoney.sdk.auth.ui.PrimaryButtonView;
import ru.yoomoney.sdk.auth.ui.TopBarDefault;
import ru.yoomoney.sdk.gui.widget.text.TextBodyView;
import ru.yoomoney.sdk.gui.widget.text.TextCaption2View;
import ru.yoomoney.sdk.gui.widget.text.TextTitle1View;

/* loaded from: classes4.dex */
public final class AuthSoftMigrationBinding implements ViewBinding {
    public final PrimaryButtonView action;
    public final TextCaption2View actionSubtitle;
    public final TopBarDefault appBar;
    public final ConstraintLayout parent;
    private final ConstraintLayout rootView;
    public final TextBodyView subtitle;
    public final TextTitle1View title;

    private AuthSoftMigrationBinding(ConstraintLayout constraintLayout, PrimaryButtonView primaryButtonView, TextCaption2View textCaption2View, TopBarDefault topBarDefault, ConstraintLayout constraintLayout2, TextBodyView textBodyView, TextTitle1View textTitle1View) {
        this.rootView = constraintLayout;
        this.action = primaryButtonView;
        this.actionSubtitle = textCaption2View;
        this.appBar = topBarDefault;
        this.parent = constraintLayout2;
        this.subtitle = textBodyView;
        this.title = textTitle1View;
    }

    public static AuthSoftMigrationBinding bind(View view) {
        int i = R.id.action;
        PrimaryButtonView primaryButtonView = (PrimaryButtonView) ViewBindings.findChildViewById(view, i);
        if (primaryButtonView != null) {
            i = R.id.action_subtitle;
            TextCaption2View textCaption2View = (TextCaption2View) ViewBindings.findChildViewById(view, i);
            if (textCaption2View != null) {
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
                            return new AuthSoftMigrationBinding(constraintLayout, primaryButtonView, textCaption2View, topBarDefault, constraintLayout, textBodyView, textTitle1View);
                        }
                    }
                }
            }
        }
        throw new NullPointerException("Missing required view with ID: ".concat(view.getResources().getResourceName(i)));
    }

    public static AuthSoftMigrationBinding inflate(LayoutInflater layoutInflater) {
        return inflate(layoutInflater, null, false);
    }

    public static AuthSoftMigrationBinding inflate(LayoutInflater layoutInflater, ViewGroup viewGroup, boolean z) {
        View viewInflate = layoutInflater.inflate(R.layout.auth_soft_migration, viewGroup, false);
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

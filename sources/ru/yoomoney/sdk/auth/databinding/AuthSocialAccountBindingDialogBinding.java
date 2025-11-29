package ru.yoomoney.sdk.auth.databinding;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.LinearLayout;
import androidx.viewbinding.ViewBinding;
import androidx.viewbinding.ViewBindings;
import ru.yoomoney.sdk.auth.R;
import ru.yoomoney.sdk.auth.ui.PrimaryButtonView;
import ru.yoomoney.sdk.gui.widget.text.TextTitle3View;

/* loaded from: classes4.dex */
public final class AuthSocialAccountBindingDialogBinding implements ViewBinding {
    public final PrimaryButtonView action;
    public final LinearLayout parent;
    private final LinearLayout rootView;
    public final TextTitle3View title;

    private AuthSocialAccountBindingDialogBinding(LinearLayout linearLayout, PrimaryButtonView primaryButtonView, LinearLayout linearLayout2, TextTitle3View textTitle3View) {
        this.rootView = linearLayout;
        this.action = primaryButtonView;
        this.parent = linearLayout2;
        this.title = textTitle3View;
    }

    public static AuthSocialAccountBindingDialogBinding bind(View view) {
        int i = R.id.action;
        PrimaryButtonView primaryButtonView = (PrimaryButtonView) ViewBindings.findChildViewById(view, i);
        if (primaryButtonView != null) {
            LinearLayout linearLayout = (LinearLayout) view;
            int i2 = R.id.title;
            TextTitle3View textTitle3View = (TextTitle3View) ViewBindings.findChildViewById(view, i2);
            if (textTitle3View != null) {
                return new AuthSocialAccountBindingDialogBinding(linearLayout, primaryButtonView, linearLayout, textTitle3View);
            }
            i = i2;
        }
        throw new NullPointerException("Missing required view with ID: ".concat(view.getResources().getResourceName(i)));
    }

    public static AuthSocialAccountBindingDialogBinding inflate(LayoutInflater layoutInflater) {
        return inflate(layoutInflater, null, false);
    }

    public static AuthSocialAccountBindingDialogBinding inflate(LayoutInflater layoutInflater, ViewGroup viewGroup, boolean z) {
        View viewInflate = layoutInflater.inflate(R.layout.auth_social_account_binding_dialog, viewGroup, false);
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

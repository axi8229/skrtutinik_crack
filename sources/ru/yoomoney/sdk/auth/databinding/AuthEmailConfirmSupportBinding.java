package ru.yoomoney.sdk.auth.databinding;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.LinearLayout;
import androidx.viewbinding.ViewBinding;
import androidx.viewbinding.ViewBindings;
import ru.yoomoney.sdk.auth.R;
import ru.yoomoney.sdk.auth.ui.PrimaryButtonView;
import ru.yoomoney.sdk.gui.widget.text.TextBodyView;

/* loaded from: classes4.dex */
public final class AuthEmailConfirmSupportBinding implements ViewBinding {
    public final PrimaryButtonView button;
    public final LinearLayout parent;
    private final LinearLayout rootView;
    public final TextBodyView text;

    private AuthEmailConfirmSupportBinding(LinearLayout linearLayout, PrimaryButtonView primaryButtonView, LinearLayout linearLayout2, TextBodyView textBodyView) {
        this.rootView = linearLayout;
        this.button = primaryButtonView;
        this.parent = linearLayout2;
        this.text = textBodyView;
    }

    public static AuthEmailConfirmSupportBinding bind(View view) {
        int i = R.id.button;
        PrimaryButtonView primaryButtonView = (PrimaryButtonView) ViewBindings.findChildViewById(view, i);
        if (primaryButtonView != null) {
            LinearLayout linearLayout = (LinearLayout) view;
            int i2 = R.id.text;
            TextBodyView textBodyView = (TextBodyView) ViewBindings.findChildViewById(view, i2);
            if (textBodyView != null) {
                return new AuthEmailConfirmSupportBinding(linearLayout, primaryButtonView, linearLayout, textBodyView);
            }
            i = i2;
        }
        throw new NullPointerException("Missing required view with ID: ".concat(view.getResources().getResourceName(i)));
    }

    public static AuthEmailConfirmSupportBinding inflate(LayoutInflater layoutInflater) {
        return inflate(layoutInflater, null, false);
    }

    public static AuthEmailConfirmSupportBinding inflate(LayoutInflater layoutInflater, ViewGroup viewGroup, boolean z) {
        View viewInflate = layoutInflater.inflate(R.layout.auth_email_confirm_support, viewGroup, false);
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

package ru.yoomoney.sdk.auth.databinding;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.LinearLayout;
import androidx.viewbinding.ViewBinding;
import androidx.viewbinding.ViewBindings;
import ru.yoomoney.sdk.auth.R;
import ru.yoomoney.sdk.auth.ui.PrimaryButtonView;

/* loaded from: classes4.dex */
public final class AuthLoginInformationBinding implements ViewBinding {
    public final PrimaryButtonView button;
    private final LinearLayout rootView;

    private AuthLoginInformationBinding(LinearLayout linearLayout, PrimaryButtonView primaryButtonView) {
        this.rootView = linearLayout;
        this.button = primaryButtonView;
    }

    public static AuthLoginInformationBinding bind(View view) {
        int i = R.id.button;
        PrimaryButtonView primaryButtonView = (PrimaryButtonView) ViewBindings.findChildViewById(view, i);
        if (primaryButtonView != null) {
            return new AuthLoginInformationBinding((LinearLayout) view, primaryButtonView);
        }
        throw new NullPointerException("Missing required view with ID: ".concat(view.getResources().getResourceName(i)));
    }

    public static AuthLoginInformationBinding inflate(LayoutInflater layoutInflater) {
        return inflate(layoutInflater, null, false);
    }

    public static AuthLoginInformationBinding inflate(LayoutInflater layoutInflater, ViewGroup viewGroup, boolean z) {
        View viewInflate = layoutInflater.inflate(R.layout.auth_login_information, viewGroup, false);
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

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
public final class AuthChangePhoneInformationBinding implements ViewBinding {
    public final PrimaryButtonView button;
    private final LinearLayout rootView;
    public final TextTitle3View title;

    private AuthChangePhoneInformationBinding(LinearLayout linearLayout, PrimaryButtonView primaryButtonView, TextTitle3View textTitle3View) {
        this.rootView = linearLayout;
        this.button = primaryButtonView;
        this.title = textTitle3View;
    }

    public static AuthChangePhoneInformationBinding bind(View view) {
        int i = R.id.button;
        PrimaryButtonView primaryButtonView = (PrimaryButtonView) ViewBindings.findChildViewById(view, i);
        if (primaryButtonView != null) {
            i = R.id.title;
            TextTitle3View textTitle3View = (TextTitle3View) ViewBindings.findChildViewById(view, i);
            if (textTitle3View != null) {
                return new AuthChangePhoneInformationBinding((LinearLayout) view, primaryButtonView, textTitle3View);
            }
        }
        throw new NullPointerException("Missing required view with ID: ".concat(view.getResources().getResourceName(i)));
    }

    public static AuthChangePhoneInformationBinding inflate(LayoutInflater layoutInflater) {
        return inflate(layoutInflater, null, false);
    }

    public static AuthChangePhoneInformationBinding inflate(LayoutInflater layoutInflater, ViewGroup viewGroup, boolean z) {
        View viewInflate = layoutInflater.inflate(R.layout.auth_change_phone_information, viewGroup, false);
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

package ru.yoomoney.sdk.auth.databinding;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import androidx.constraintlayout.widget.ConstraintLayout;
import androidx.viewbinding.ViewBinding;
import androidx.viewbinding.ViewBindings;
import ru.yoomoney.sdk.auth.R;
import ru.yoomoney.sdk.auth.ui.EmptyStateLargeView;
import ru.yoomoney.sdk.auth.ui.PrimaryButtonView;
import ru.yoomoney.sdk.auth.ui.TopBarDefault;

/* loaded from: classes4.dex */
public final class AuthQrSuccessBinding implements ViewBinding {
    public final TopBarDefault appBar;
    public final ImageView close;
    public final EmptyStateLargeView content;
    public final ConstraintLayout parent;
    public final PrimaryButtonView primaryAction;
    private final ConstraintLayout rootView;

    private AuthQrSuccessBinding(ConstraintLayout constraintLayout, TopBarDefault topBarDefault, ImageView imageView, EmptyStateLargeView emptyStateLargeView, ConstraintLayout constraintLayout2, PrimaryButtonView primaryButtonView) {
        this.rootView = constraintLayout;
        this.appBar = topBarDefault;
        this.close = imageView;
        this.content = emptyStateLargeView;
        this.parent = constraintLayout2;
        this.primaryAction = primaryButtonView;
    }

    public static AuthQrSuccessBinding bind(View view) {
        int i = R.id.appBar;
        TopBarDefault topBarDefault = (TopBarDefault) ViewBindings.findChildViewById(view, i);
        if (topBarDefault != null) {
            i = R.id.close;
            ImageView imageView = (ImageView) ViewBindings.findChildViewById(view, i);
            if (imageView != null) {
                i = R.id.content;
                EmptyStateLargeView emptyStateLargeView = (EmptyStateLargeView) ViewBindings.findChildViewById(view, i);
                if (emptyStateLargeView != null) {
                    ConstraintLayout constraintLayout = (ConstraintLayout) view;
                    i = R.id.primaryAction;
                    PrimaryButtonView primaryButtonView = (PrimaryButtonView) ViewBindings.findChildViewById(view, i);
                    if (primaryButtonView != null) {
                        return new AuthQrSuccessBinding(constraintLayout, topBarDefault, imageView, emptyStateLargeView, constraintLayout, primaryButtonView);
                    }
                }
            }
        }
        throw new NullPointerException("Missing required view with ID: ".concat(view.getResources().getResourceName(i)));
    }

    public static AuthQrSuccessBinding inflate(LayoutInflater layoutInflater) {
        return inflate(layoutInflater, null, false);
    }

    public static AuthQrSuccessBinding inflate(LayoutInflater layoutInflater, ViewGroup viewGroup, boolean z) {
        View viewInflate = layoutInflater.inflate(R.layout.auth_qr_success, viewGroup, false);
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

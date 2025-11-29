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
import ru.yoomoney.sdk.auth.ui.TopBarDefault;

/* loaded from: classes4.dex */
public final class AuthQrFailureBinding implements ViewBinding {
    public final TopBarDefault appBar;
    public final ImageView close;
    public final EmptyStateLargeView errorContainer;
    public final ConstraintLayout parent;
    private final ConstraintLayout rootView;

    private AuthQrFailureBinding(ConstraintLayout constraintLayout, TopBarDefault topBarDefault, ImageView imageView, EmptyStateLargeView emptyStateLargeView, ConstraintLayout constraintLayout2) {
        this.rootView = constraintLayout;
        this.appBar = topBarDefault;
        this.close = imageView;
        this.errorContainer = emptyStateLargeView;
        this.parent = constraintLayout2;
    }

    public static AuthQrFailureBinding bind(View view) {
        int i = R.id.appBar;
        TopBarDefault topBarDefault = (TopBarDefault) ViewBindings.findChildViewById(view, i);
        if (topBarDefault != null) {
            i = R.id.close;
            ImageView imageView = (ImageView) ViewBindings.findChildViewById(view, i);
            if (imageView != null) {
                i = R.id.error_container;
                EmptyStateLargeView emptyStateLargeView = (EmptyStateLargeView) ViewBindings.findChildViewById(view, i);
                if (emptyStateLargeView != null) {
                    ConstraintLayout constraintLayout = (ConstraintLayout) view;
                    return new AuthQrFailureBinding(constraintLayout, topBarDefault, imageView, emptyStateLargeView, constraintLayout);
                }
            }
        }
        throw new NullPointerException("Missing required view with ID: ".concat(view.getResources().getResourceName(i)));
    }

    public static AuthQrFailureBinding inflate(LayoutInflater layoutInflater) {
        return inflate(layoutInflater, null, false);
    }

    public static AuthQrFailureBinding inflate(LayoutInflater layoutInflater, ViewGroup viewGroup, boolean z) {
        View viewInflate = layoutInflater.inflate(R.layout.auth_qr_failure, viewGroup, false);
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

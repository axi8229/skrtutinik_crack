package ru.yoomoney.sdk.auth.databinding;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import androidx.coordinatorlayout.widget.CoordinatorLayout;
import androidx.viewbinding.ViewBinding;
import androidx.viewbinding.ViewBindings;
import ru.yoomoney.sdk.auth.R;
import ru.yoomoney.sdk.auth.ui.PrimaryButtonView;
import ru.yoomoney.sdk.gui.widget.TopBarDefault;

/* loaded from: classes4.dex */
public final class AuthIdentificationInfoBinding implements ViewBinding {
    public final PrimaryButtonView action;
    private final CoordinatorLayout rootView;
    public final TopBarDefault topBar;

    private AuthIdentificationInfoBinding(CoordinatorLayout coordinatorLayout, PrimaryButtonView primaryButtonView, TopBarDefault topBarDefault) {
        this.rootView = coordinatorLayout;
        this.action = primaryButtonView;
        this.topBar = topBarDefault;
    }

    public static AuthIdentificationInfoBinding bind(View view) {
        int i = R.id.action;
        PrimaryButtonView primaryButtonView = (PrimaryButtonView) ViewBindings.findChildViewById(view, i);
        if (primaryButtonView != null) {
            i = R.id.top_bar;
            TopBarDefault topBarDefault = (TopBarDefault) ViewBindings.findChildViewById(view, i);
            if (topBarDefault != null) {
                return new AuthIdentificationInfoBinding((CoordinatorLayout) view, primaryButtonView, topBarDefault);
            }
        }
        throw new NullPointerException("Missing required view with ID: ".concat(view.getResources().getResourceName(i)));
    }

    public static AuthIdentificationInfoBinding inflate(LayoutInflater layoutInflater) {
        return inflate(layoutInflater, null, false);
    }

    public static AuthIdentificationInfoBinding inflate(LayoutInflater layoutInflater, ViewGroup viewGroup, boolean z) {
        View viewInflate = layoutInflater.inflate(R.layout.auth_identification_info, viewGroup, false);
        if (z) {
            viewGroup.addView(viewInflate);
        }
        return bind(viewInflate);
    }

    @Override // androidx.viewbinding.ViewBinding
    public CoordinatorLayout getRoot() {
        return this.rootView;
    }
}

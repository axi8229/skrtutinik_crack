package ru.yoomoney.sdk.auth.databinding;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.LinearLayout;
import androidx.recyclerview.widget.RecyclerView;
import androidx.viewbinding.ViewBinding;
import androidx.viewbinding.ViewBindings;
import ru.yoomoney.sdk.auth.R;
import ru.yoomoney.sdk.gui.widget.headline.HeadlinePrimaryLargeView;

/* loaded from: classes4.dex */
public final class AuthPhoneCountriesBinding implements ViewBinding {
    public final HeadlinePrimaryLargeView header;
    public final RecyclerView list;
    public final LinearLayout parent;
    private final LinearLayout rootView;

    private AuthPhoneCountriesBinding(LinearLayout linearLayout, HeadlinePrimaryLargeView headlinePrimaryLargeView, RecyclerView recyclerView, LinearLayout linearLayout2) {
        this.rootView = linearLayout;
        this.header = headlinePrimaryLargeView;
        this.list = recyclerView;
        this.parent = linearLayout2;
    }

    public static AuthPhoneCountriesBinding bind(View view) {
        int i = R.id.header;
        HeadlinePrimaryLargeView headlinePrimaryLargeView = (HeadlinePrimaryLargeView) ViewBindings.findChildViewById(view, i);
        if (headlinePrimaryLargeView != null) {
            i = R.id.list;
            RecyclerView recyclerView = (RecyclerView) ViewBindings.findChildViewById(view, i);
            if (recyclerView != null) {
                LinearLayout linearLayout = (LinearLayout) view;
                return new AuthPhoneCountriesBinding(linearLayout, headlinePrimaryLargeView, recyclerView, linearLayout);
            }
        }
        throw new NullPointerException("Missing required view with ID: ".concat(view.getResources().getResourceName(i)));
    }

    public static AuthPhoneCountriesBinding inflate(LayoutInflater layoutInflater) {
        return inflate(layoutInflater, null, false);
    }

    public static AuthPhoneCountriesBinding inflate(LayoutInflater layoutInflater, ViewGroup viewGroup, boolean z) {
        View viewInflate = layoutInflater.inflate(R.layout.auth_phone_countries, viewGroup, false);
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

package com.sputnik.service_payments.databinding;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ScrollView;
import android.widget.TextView;
import androidx.viewbinding.ViewBinding;
import androidx.viewbinding.ViewBindings;
import com.sputnik.common.ui.view.VerticalLeafView;
import com.sputnik.service_payments.R$id;
import com.sputnik.service_payments.R$layout;

/* loaded from: classes3.dex */
public final class BottomSheetAboutCompanyBinding implements ViewBinding {
    public final VerticalLeafView layoutOrganizationAddress;
    public final VerticalLeafView layoutOrganizationName;
    public final VerticalLeafView layoutOrganizationPhone;
    private final ScrollView rootView;
    public final TextView tvTitle;

    private BottomSheetAboutCompanyBinding(ScrollView scrollView, VerticalLeafView verticalLeafView, VerticalLeafView verticalLeafView2, VerticalLeafView verticalLeafView3, TextView textView) {
        this.rootView = scrollView;
        this.layoutOrganizationAddress = verticalLeafView;
        this.layoutOrganizationName = verticalLeafView2;
        this.layoutOrganizationPhone = verticalLeafView3;
        this.tvTitle = textView;
    }

    @Override // androidx.viewbinding.ViewBinding
    public ScrollView getRoot() {
        return this.rootView;
    }

    public static BottomSheetAboutCompanyBinding inflate(LayoutInflater layoutInflater, ViewGroup viewGroup, boolean z) {
        View viewInflate = layoutInflater.inflate(R$layout.bottom_sheet_about_company, viewGroup, false);
        if (z) {
            viewGroup.addView(viewInflate);
        }
        return bind(viewInflate);
    }

    public static BottomSheetAboutCompanyBinding bind(View view) {
        int i = R$id.layout_organization_address;
        VerticalLeafView verticalLeafView = (VerticalLeafView) ViewBindings.findChildViewById(view, i);
        if (verticalLeafView != null) {
            i = R$id.layout_organization_name;
            VerticalLeafView verticalLeafView2 = (VerticalLeafView) ViewBindings.findChildViewById(view, i);
            if (verticalLeafView2 != null) {
                i = R$id.layout_organization_phone;
                VerticalLeafView verticalLeafView3 = (VerticalLeafView) ViewBindings.findChildViewById(view, i);
                if (verticalLeafView3 != null) {
                    i = R$id.tv_title;
                    TextView textView = (TextView) ViewBindings.findChildViewById(view, i);
                    if (textView != null) {
                        return new BottomSheetAboutCompanyBinding((ScrollView) view, verticalLeafView, verticalLeafView2, verticalLeafView3, textView);
                    }
                }
            }
        }
        throw new NullPointerException("Missing required view with ID: ".concat(view.getResources().getResourceName(i)));
    }
}

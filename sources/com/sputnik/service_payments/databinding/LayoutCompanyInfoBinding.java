package com.sputnik.service_payments.databinding;

import android.view.View;
import android.widget.LinearLayout;
import android.widget.TextView;
import androidx.constraintlayout.widget.ConstraintLayout;
import androidx.viewbinding.ViewBinding;
import androidx.viewbinding.ViewBindings;
import com.sputnik.service_payments.R$id;

/* loaded from: classes3.dex */
public final class LayoutCompanyInfoBinding implements ViewBinding {
    public final ConstraintLayout lInfoPrice;
    public final LinearLayout layoutAddress;
    public final LinearLayout layoutOrganization;
    public final LinearLayout layoutOrganizationWorkingHours;
    public final LinearLayout phoneLayout;
    private final ConstraintLayout rootView;
    public final TextView tvAddressTitle;
    public final TextView tvAddressValue;
    public final TextView tvOrganizationName;
    public final TextView tvOrganizationNameValue;
    public final TextView tvOrganizationWorkingHours;
    public final TextView tvOrganizationWorkingHoursValue;
    public final TextView tvPhoneTitle;
    public final TextView tvPhoneValue;

    private LayoutCompanyInfoBinding(ConstraintLayout constraintLayout, ConstraintLayout constraintLayout2, LinearLayout linearLayout, LinearLayout linearLayout2, LinearLayout linearLayout3, LinearLayout linearLayout4, TextView textView, TextView textView2, TextView textView3, TextView textView4, TextView textView5, TextView textView6, TextView textView7, TextView textView8) {
        this.rootView = constraintLayout;
        this.lInfoPrice = constraintLayout2;
        this.layoutAddress = linearLayout;
        this.layoutOrganization = linearLayout2;
        this.layoutOrganizationWorkingHours = linearLayout3;
        this.phoneLayout = linearLayout4;
        this.tvAddressTitle = textView;
        this.tvAddressValue = textView2;
        this.tvOrganizationName = textView3;
        this.tvOrganizationNameValue = textView4;
        this.tvOrganizationWorkingHours = textView5;
        this.tvOrganizationWorkingHoursValue = textView6;
        this.tvPhoneTitle = textView7;
        this.tvPhoneValue = textView8;
    }

    @Override // androidx.viewbinding.ViewBinding
    public ConstraintLayout getRoot() {
        return this.rootView;
    }

    public static LayoutCompanyInfoBinding bind(View view) {
        ConstraintLayout constraintLayout = (ConstraintLayout) view;
        int i = R$id.layout_address;
        LinearLayout linearLayout = (LinearLayout) ViewBindings.findChildViewById(view, i);
        if (linearLayout != null) {
            i = R$id.layout_organization;
            LinearLayout linearLayout2 = (LinearLayout) ViewBindings.findChildViewById(view, i);
            if (linearLayout2 != null) {
                i = R$id.layout_organization_working_hours;
                LinearLayout linearLayout3 = (LinearLayout) ViewBindings.findChildViewById(view, i);
                if (linearLayout3 != null) {
                    i = R$id.phone_layout;
                    LinearLayout linearLayout4 = (LinearLayout) ViewBindings.findChildViewById(view, i);
                    if (linearLayout4 != null) {
                        i = R$id.tv_address_title;
                        TextView textView = (TextView) ViewBindings.findChildViewById(view, i);
                        if (textView != null) {
                            i = R$id.tv_address_value;
                            TextView textView2 = (TextView) ViewBindings.findChildViewById(view, i);
                            if (textView2 != null) {
                                i = R$id.tv_organization_name;
                                TextView textView3 = (TextView) ViewBindings.findChildViewById(view, i);
                                if (textView3 != null) {
                                    i = R$id.tv_organization_name_value;
                                    TextView textView4 = (TextView) ViewBindings.findChildViewById(view, i);
                                    if (textView4 != null) {
                                        i = R$id.tv_organization_working_hours;
                                        TextView textView5 = (TextView) ViewBindings.findChildViewById(view, i);
                                        if (textView5 != null) {
                                            i = R$id.tv_organization_working_hours_value;
                                            TextView textView6 = (TextView) ViewBindings.findChildViewById(view, i);
                                            if (textView6 != null) {
                                                i = R$id.tv_phone_title;
                                                TextView textView7 = (TextView) ViewBindings.findChildViewById(view, i);
                                                if (textView7 != null) {
                                                    i = R$id.tv_phone_value;
                                                    TextView textView8 = (TextView) ViewBindings.findChildViewById(view, i);
                                                    if (textView8 != null) {
                                                        return new LayoutCompanyInfoBinding(constraintLayout, constraintLayout, linearLayout, linearLayout2, linearLayout3, linearLayout4, textView, textView2, textView3, textView4, textView5, textView6, textView7, textView8);
                                                    }
                                                }
                                            }
                                        }
                                    }
                                }
                            }
                        }
                    }
                }
            }
        }
        throw new NullPointerException("Missing required view with ID: ".concat(view.getResources().getResourceName(i)));
    }
}

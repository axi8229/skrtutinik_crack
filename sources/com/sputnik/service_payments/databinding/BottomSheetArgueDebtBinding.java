package com.sputnik.service_payments.databinding;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;
import androidx.core.widget.NestedScrollView;
import androidx.viewbinding.ViewBinding;
import androidx.viewbinding.ViewBindings;
import com.sputnik.common.ui.view.LeafView;
import com.sputnik.service_payments.R$id;
import com.sputnik.service_payments.R$layout;

/* loaded from: classes3.dex */
public final class BottomSheetArgueDebtBinding implements ViewBinding {
    public final View divider;
    public final ImageView ivMascotte;
    public final LayoutCompanyInfoBinding lCompanyInfo;
    public final LinearLayout layoutTitle;
    public final LeafView leaf1;
    public final LeafView leaf2;
    public final LeafView leaf3;
    private final NestedScrollView rootView;
    public final TextView tvMascotteLabel;
    public final TextView tvSupport;

    private BottomSheetArgueDebtBinding(NestedScrollView nestedScrollView, View view, ImageView imageView, LayoutCompanyInfoBinding layoutCompanyInfoBinding, LinearLayout linearLayout, LeafView leafView, LeafView leafView2, LeafView leafView3, TextView textView, TextView textView2) {
        this.rootView = nestedScrollView;
        this.divider = view;
        this.ivMascotte = imageView;
        this.lCompanyInfo = layoutCompanyInfoBinding;
        this.layoutTitle = linearLayout;
        this.leaf1 = leafView;
        this.leaf2 = leafView2;
        this.leaf3 = leafView3;
        this.tvMascotteLabel = textView;
        this.tvSupport = textView2;
    }

    @Override // androidx.viewbinding.ViewBinding
    public NestedScrollView getRoot() {
        return this.rootView;
    }

    public static BottomSheetArgueDebtBinding inflate(LayoutInflater layoutInflater, ViewGroup viewGroup, boolean z) {
        View viewInflate = layoutInflater.inflate(R$layout.bottom_sheet_argue_debt, viewGroup, false);
        if (z) {
            viewGroup.addView(viewInflate);
        }
        return bind(viewInflate);
    }

    public static BottomSheetArgueDebtBinding bind(View view) {
        View viewFindChildViewById;
        int i = R$id.divider;
        View viewFindChildViewById2 = ViewBindings.findChildViewById(view, i);
        if (viewFindChildViewById2 != null) {
            i = R$id.iv_mascotte;
            ImageView imageView = (ImageView) ViewBindings.findChildViewById(view, i);
            if (imageView != null && (viewFindChildViewById = ViewBindings.findChildViewById(view, (i = R$id.l_company_info))) != null) {
                LayoutCompanyInfoBinding layoutCompanyInfoBindingBind = LayoutCompanyInfoBinding.bind(viewFindChildViewById);
                i = R$id.layout_title;
                LinearLayout linearLayout = (LinearLayout) ViewBindings.findChildViewById(view, i);
                if (linearLayout != null) {
                    i = R$id.leaf_1;
                    LeafView leafView = (LeafView) ViewBindings.findChildViewById(view, i);
                    if (leafView != null) {
                        i = R$id.leaf_2;
                        LeafView leafView2 = (LeafView) ViewBindings.findChildViewById(view, i);
                        if (leafView2 != null) {
                            i = R$id.leaf_3;
                            LeafView leafView3 = (LeafView) ViewBindings.findChildViewById(view, i);
                            if (leafView3 != null) {
                                i = R$id.tv_mascotte_label;
                                TextView textView = (TextView) ViewBindings.findChildViewById(view, i);
                                if (textView != null) {
                                    i = R$id.tv_support;
                                    TextView textView2 = (TextView) ViewBindings.findChildViewById(view, i);
                                    if (textView2 != null) {
                                        return new BottomSheetArgueDebtBinding((NestedScrollView) view, viewFindChildViewById2, imageView, layoutCompanyInfoBindingBind, linearLayout, leafView, leafView2, leafView3, textView, textView2);
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

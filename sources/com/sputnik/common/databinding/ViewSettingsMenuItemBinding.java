package com.sputnik.common.databinding;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;
import androidx.viewbinding.ViewBinding;
import androidx.viewbinding.ViewBindings;
import com.sputnik.common.R$id;
import com.sputnik.common.R$layout;

/* loaded from: classes3.dex */
public final class ViewSettingsMenuItemBinding implements ViewBinding {
    public final ImageView ivIcon;
    public final LinearLayout layoutNotice;
    private final View rootView;
    public final TextView tvNotice;
    public final TextView tvNumber;
    public final View vDividerCameras;
    public final View viewOnboarding;

    private ViewSettingsMenuItemBinding(View view, ImageView imageView, LinearLayout linearLayout, TextView textView, TextView textView2, View view2, View view3) {
        this.rootView = view;
        this.ivIcon = imageView;
        this.layoutNotice = linearLayout;
        this.tvNotice = textView;
        this.tvNumber = textView2;
        this.vDividerCameras = view2;
        this.viewOnboarding = view3;
    }

    @Override // androidx.viewbinding.ViewBinding
    public View getRoot() {
        return this.rootView;
    }

    public static ViewSettingsMenuItemBinding inflate(LayoutInflater layoutInflater, ViewGroup viewGroup) {
        if (viewGroup == null) {
            throw new NullPointerException("parent");
        }
        layoutInflater.inflate(R$layout.view_settings_menu_item, viewGroup);
        return bind(viewGroup);
    }

    public static ViewSettingsMenuItemBinding bind(View view) {
        View viewFindChildViewById;
        View viewFindChildViewById2;
        int i = R$id.iv_icon;
        ImageView imageView = (ImageView) ViewBindings.findChildViewById(view, i);
        if (imageView != null) {
            i = R$id.layout_notice;
            LinearLayout linearLayout = (LinearLayout) ViewBindings.findChildViewById(view, i);
            if (linearLayout != null) {
                i = R$id.tv_notice;
                TextView textView = (TextView) ViewBindings.findChildViewById(view, i);
                if (textView != null) {
                    i = R$id.tv_number;
                    TextView textView2 = (TextView) ViewBindings.findChildViewById(view, i);
                    if (textView2 != null && (viewFindChildViewById = ViewBindings.findChildViewById(view, (i = R$id.v_divider_cameras))) != null && (viewFindChildViewById2 = ViewBindings.findChildViewById(view, (i = R$id.view_onboarding))) != null) {
                        return new ViewSettingsMenuItemBinding(view, imageView, linearLayout, textView, textView2, viewFindChildViewById, viewFindChildViewById2);
                    }
                }
            }
        }
        throw new NullPointerException("Missing required view with ID: ".concat(view.getResources().getResourceName(i)));
    }
}

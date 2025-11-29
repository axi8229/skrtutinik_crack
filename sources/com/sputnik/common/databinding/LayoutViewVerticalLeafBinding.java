package com.sputnik.common.databinding;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;
import androidx.viewbinding.ViewBinding;
import androidx.viewbinding.ViewBindings;
import com.sputnik.common.R$id;
import com.sputnik.common.R$layout;

/* loaded from: classes3.dex */
public final class LayoutViewVerticalLeafBinding implements ViewBinding {
    private final View rootView;
    public final TextView tvSubtitle;
    public final TextView tvTitle;
    public final View vDividerCameras;

    private LayoutViewVerticalLeafBinding(View view, TextView textView, TextView textView2, View view2) {
        this.rootView = view;
        this.tvSubtitle = textView;
        this.tvTitle = textView2;
        this.vDividerCameras = view2;
    }

    @Override // androidx.viewbinding.ViewBinding
    public View getRoot() {
        return this.rootView;
    }

    public static LayoutViewVerticalLeafBinding inflate(LayoutInflater layoutInflater, ViewGroup viewGroup) {
        if (viewGroup == null) {
            throw new NullPointerException("parent");
        }
        layoutInflater.inflate(R$layout.layout_view_vertical_leaf, viewGroup);
        return bind(viewGroup);
    }

    public static LayoutViewVerticalLeafBinding bind(View view) {
        View viewFindChildViewById;
        int i = R$id.tv_subtitle;
        TextView textView = (TextView) ViewBindings.findChildViewById(view, i);
        if (textView != null) {
            i = R$id.tv_title;
            TextView textView2 = (TextView) ViewBindings.findChildViewById(view, i);
            if (textView2 != null && (viewFindChildViewById = ViewBindings.findChildViewById(view, (i = R$id.v_divider_cameras))) != null) {
                return new LayoutViewVerticalLeafBinding(view, textView, textView2, viewFindChildViewById);
            }
        }
        throw new NullPointerException("Missing required view with ID: ".concat(view.getResources().getResourceName(i)));
    }
}

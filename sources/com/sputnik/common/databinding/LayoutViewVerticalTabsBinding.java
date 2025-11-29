package com.sputnik.common.databinding;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;
import androidx.recyclerview.widget.RecyclerView;
import androidx.viewbinding.ViewBinding;
import androidx.viewbinding.ViewBindings;
import com.sputnik.common.R$id;
import com.sputnik.common.R$layout;

/* loaded from: classes3.dex */
public final class LayoutViewVerticalTabsBinding implements ViewBinding {
    private final View rootView;
    public final RecyclerView tabsRv;
    public final TextView tvCurrentCamera;

    private LayoutViewVerticalTabsBinding(View view, RecyclerView recyclerView, TextView textView) {
        this.rootView = view;
        this.tabsRv = recyclerView;
        this.tvCurrentCamera = textView;
    }

    @Override // androidx.viewbinding.ViewBinding
    public View getRoot() {
        return this.rootView;
    }

    public static LayoutViewVerticalTabsBinding inflate(LayoutInflater layoutInflater, ViewGroup viewGroup) {
        if (viewGroup == null) {
            throw new NullPointerException("parent");
        }
        layoutInflater.inflate(R$layout.layout_view_vertical_tabs, viewGroup);
        return bind(viewGroup);
    }

    public static LayoutViewVerticalTabsBinding bind(View view) {
        int i = R$id.tabs_rv;
        RecyclerView recyclerView = (RecyclerView) ViewBindings.findChildViewById(view, i);
        if (recyclerView != null) {
            i = R$id.tv_current_camera;
            TextView textView = (TextView) ViewBindings.findChildViewById(view, i);
            if (textView != null) {
                return new LayoutViewVerticalTabsBinding(view, recyclerView, textView);
            }
        }
        throw new NullPointerException("Missing required view with ID: ".concat(view.getResources().getResourceName(i)));
    }
}

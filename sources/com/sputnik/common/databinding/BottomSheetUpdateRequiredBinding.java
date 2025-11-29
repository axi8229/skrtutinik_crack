package com.sputnik.common.databinding;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ScrollView;
import android.widget.TextView;
import androidx.appcompat.widget.AppCompatButton;
import androidx.viewbinding.ViewBinding;
import androidx.viewbinding.ViewBindings;
import com.sputnik.common.R$id;
import com.sputnik.common.R$layout;

/* loaded from: classes3.dex */
public final class BottomSheetUpdateRequiredBinding implements ViewBinding {
    public final AppCompatButton btnAccept;
    public final AppCompatButton btnCancel;
    private final ScrollView rootView;
    public final TextView tvHeader;
    public final TextView tvSubtitle;

    private BottomSheetUpdateRequiredBinding(ScrollView scrollView, AppCompatButton appCompatButton, AppCompatButton appCompatButton2, TextView textView, TextView textView2) {
        this.rootView = scrollView;
        this.btnAccept = appCompatButton;
        this.btnCancel = appCompatButton2;
        this.tvHeader = textView;
        this.tvSubtitle = textView2;
    }

    @Override // androidx.viewbinding.ViewBinding
    public ScrollView getRoot() {
        return this.rootView;
    }

    public static BottomSheetUpdateRequiredBinding inflate(LayoutInflater layoutInflater, ViewGroup viewGroup, boolean z) {
        View viewInflate = layoutInflater.inflate(R$layout.bottom_sheet_update_required, viewGroup, false);
        if (z) {
            viewGroup.addView(viewInflate);
        }
        return bind(viewInflate);
    }

    public static BottomSheetUpdateRequiredBinding bind(View view) {
        int i = R$id.btn_accept;
        AppCompatButton appCompatButton = (AppCompatButton) ViewBindings.findChildViewById(view, i);
        if (appCompatButton != null) {
            i = R$id.btn_cancel;
            AppCompatButton appCompatButton2 = (AppCompatButton) ViewBindings.findChildViewById(view, i);
            if (appCompatButton2 != null) {
                i = R$id.tv_header;
                TextView textView = (TextView) ViewBindings.findChildViewById(view, i);
                if (textView != null) {
                    i = R$id.tv_subtitle;
                    TextView textView2 = (TextView) ViewBindings.findChildViewById(view, i);
                    if (textView2 != null) {
                        return new BottomSheetUpdateRequiredBinding((ScrollView) view, appCompatButton, appCompatButton2, textView, textView2);
                    }
                }
            }
        }
        throw new NullPointerException("Missing required view with ID: ".concat(view.getResources().getResourceName(i)));
    }
}

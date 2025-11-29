package com.sputnik.oboarding.databinding;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.LinearLayout;
import android.widget.TextView;
import androidx.appcompat.widget.AppCompatButton;
import androidx.viewbinding.ViewBinding;
import androidx.viewbinding.ViewBindings;
import com.sputnik.oboarding.R$id;
import com.sputnik.oboarding.R$layout;

/* loaded from: classes3.dex */
public final class BottomSheetChooseLanguageBinding implements ViewBinding {
    public final AppCompatButton btnAccept;
    public final AppCompatButton btnReject;
    public final TextView choosingLanguage;
    private final LinearLayout rootView;
    public final TextView tvActionChange;
    public final TextView tvNotice;
    public final TextView tvTitle;

    private BottomSheetChooseLanguageBinding(LinearLayout linearLayout, AppCompatButton appCompatButton, AppCompatButton appCompatButton2, TextView textView, TextView textView2, TextView textView3, TextView textView4) {
        this.rootView = linearLayout;
        this.btnAccept = appCompatButton;
        this.btnReject = appCompatButton2;
        this.choosingLanguage = textView;
        this.tvActionChange = textView2;
        this.tvNotice = textView3;
        this.tvTitle = textView4;
    }

    @Override // androidx.viewbinding.ViewBinding
    public LinearLayout getRoot() {
        return this.rootView;
    }

    public static BottomSheetChooseLanguageBinding inflate(LayoutInflater layoutInflater, ViewGroup viewGroup, boolean z) {
        View viewInflate = layoutInflater.inflate(R$layout.bottom_sheet_choose_language, viewGroup, false);
        if (z) {
            viewGroup.addView(viewInflate);
        }
        return bind(viewInflate);
    }

    public static BottomSheetChooseLanguageBinding bind(View view) {
        int i = R$id.btn_accept;
        AppCompatButton appCompatButton = (AppCompatButton) ViewBindings.findChildViewById(view, i);
        if (appCompatButton != null) {
            i = R$id.btn_reject;
            AppCompatButton appCompatButton2 = (AppCompatButton) ViewBindings.findChildViewById(view, i);
            if (appCompatButton2 != null) {
                i = R$id.choosing_language;
                TextView textView = (TextView) ViewBindings.findChildViewById(view, i);
                if (textView != null) {
                    i = R$id.tv_action_change;
                    TextView textView2 = (TextView) ViewBindings.findChildViewById(view, i);
                    if (textView2 != null) {
                        i = R$id.tv_notice;
                        TextView textView3 = (TextView) ViewBindings.findChildViewById(view, i);
                        if (textView3 != null) {
                            i = R$id.tv_title;
                            TextView textView4 = (TextView) ViewBindings.findChildViewById(view, i);
                            if (textView4 != null) {
                                return new BottomSheetChooseLanguageBinding((LinearLayout) view, appCompatButton, appCompatButton2, textView, textView2, textView3, textView4);
                            }
                        }
                    }
                }
            }
        }
        throw new NullPointerException("Missing required view with ID: ".concat(view.getResources().getResourceName(i)));
    }
}

package com.sputnik.common.databinding;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;
import androidx.appcompat.widget.SwitchCompat;
import androidx.constraintlayout.widget.ConstraintLayout;
import androidx.viewbinding.ViewBinding;
import androidx.viewbinding.ViewBindings;
import com.sputnik.common.R$id;
import com.sputnik.common.R$layout;

/* loaded from: classes3.dex */
public final class ViewCheckboxPreferenceBinding implements ViewBinding {
    public final ImageView btnAbout;
    public final ConstraintLayout domofonCallsContainer;
    public final SwitchCompat optionSwitch;
    private final View rootView;
    public final TextView tvSubtitle;
    public final TextView tvTitle;

    private ViewCheckboxPreferenceBinding(View view, ImageView imageView, ConstraintLayout constraintLayout, SwitchCompat switchCompat, TextView textView, TextView textView2) {
        this.rootView = view;
        this.btnAbout = imageView;
        this.domofonCallsContainer = constraintLayout;
        this.optionSwitch = switchCompat;
        this.tvSubtitle = textView;
        this.tvTitle = textView2;
    }

    @Override // androidx.viewbinding.ViewBinding
    public View getRoot() {
        return this.rootView;
    }

    public static ViewCheckboxPreferenceBinding inflate(LayoutInflater layoutInflater, ViewGroup viewGroup) {
        if (viewGroup == null) {
            throw new NullPointerException("parent");
        }
        layoutInflater.inflate(R$layout.view_checkbox_preference, viewGroup);
        return bind(viewGroup);
    }

    public static ViewCheckboxPreferenceBinding bind(View view) {
        int i = R$id.btn_about;
        ImageView imageView = (ImageView) ViewBindings.findChildViewById(view, i);
        if (imageView != null) {
            i = R$id.domofon_calls_container;
            ConstraintLayout constraintLayout = (ConstraintLayout) ViewBindings.findChildViewById(view, i);
            if (constraintLayout != null) {
                i = R$id.option_switch;
                SwitchCompat switchCompat = (SwitchCompat) ViewBindings.findChildViewById(view, i);
                if (switchCompat != null) {
                    i = R$id.tv_subtitle;
                    TextView textView = (TextView) ViewBindings.findChildViewById(view, i);
                    if (textView != null) {
                        i = R$id.tv_title;
                        TextView textView2 = (TextView) ViewBindings.findChildViewById(view, i);
                        if (textView2 != null) {
                            return new ViewCheckboxPreferenceBinding(view, imageView, constraintLayout, switchCompat, textView, textView2);
                        }
                    }
                }
            }
        }
        throw new NullPointerException("Missing required view with ID: ".concat(view.getResources().getResourceName(i)));
    }
}

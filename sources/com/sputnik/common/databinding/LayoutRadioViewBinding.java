package com.sputnik.common.databinding;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;
import androidx.appcompat.widget.SwitchCompat;
import androidx.viewbinding.ViewBinding;
import androidx.viewbinding.ViewBindings;
import com.sputnik.common.R$id;
import com.sputnik.common.R$layout;

/* loaded from: classes3.dex */
public final class LayoutRadioViewBinding implements ViewBinding {
    public final TextView domofonCallsHint;
    public final SwitchCompat domofonCallsValueView;
    public final TextView domofonCallsView;
    private final View rootView;

    private LayoutRadioViewBinding(View view, TextView textView, SwitchCompat switchCompat, TextView textView2) {
        this.rootView = view;
        this.domofonCallsHint = textView;
        this.domofonCallsValueView = switchCompat;
        this.domofonCallsView = textView2;
    }

    @Override // androidx.viewbinding.ViewBinding
    public View getRoot() {
        return this.rootView;
    }

    public static LayoutRadioViewBinding inflate(LayoutInflater layoutInflater, ViewGroup viewGroup) {
        if (viewGroup == null) {
            throw new NullPointerException("parent");
        }
        layoutInflater.inflate(R$layout.layout_radio_view, viewGroup);
        return bind(viewGroup);
    }

    public static LayoutRadioViewBinding bind(View view) {
        int i = R$id.domofon_calls_hint;
        TextView textView = (TextView) ViewBindings.findChildViewById(view, i);
        if (textView != null) {
            i = R$id.domofon_calls_value_view;
            SwitchCompat switchCompat = (SwitchCompat) ViewBindings.findChildViewById(view, i);
            if (switchCompat != null) {
                i = R$id.domofon_calls_view;
                TextView textView2 = (TextView) ViewBindings.findChildViewById(view, i);
                if (textView2 != null) {
                    return new LayoutRadioViewBinding(view, textView, switchCompat, textView2);
                }
            }
        }
        throw new NullPointerException("Missing required view with ID: ".concat(view.getResources().getResourceName(i)));
    }
}

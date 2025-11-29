package com.sputnik.common.databinding;

import android.view.View;
import android.widget.EditText;
import android.widget.LinearLayout;
import android.widget.TextView;
import androidx.viewbinding.ViewBinding;
import androidx.viewbinding.ViewBindings;
import com.sputnik.common.R$id;

/* loaded from: classes3.dex */
public final class LayoutEditTextWithTitleBinding implements ViewBinding {
    public final EditText etData;
    private final LinearLayout rootView;
    public final TextView tvTitle;

    private LayoutEditTextWithTitleBinding(LinearLayout linearLayout, EditText editText, TextView textView) {
        this.rootView = linearLayout;
        this.etData = editText;
        this.tvTitle = textView;
    }

    @Override // androidx.viewbinding.ViewBinding
    public LinearLayout getRoot() {
        return this.rootView;
    }

    public static LayoutEditTextWithTitleBinding bind(View view) {
        int i = R$id.et_data;
        EditText editText = (EditText) ViewBindings.findChildViewById(view, i);
        if (editText != null) {
            i = R$id.tv_title;
            TextView textView = (TextView) ViewBindings.findChildViewById(view, i);
            if (textView != null) {
                return new LayoutEditTextWithTitleBinding((LinearLayout) view, editText, textView);
            }
        }
        throw new NullPointerException("Missing required view with ID: ".concat(view.getResources().getResourceName(i)));
    }
}

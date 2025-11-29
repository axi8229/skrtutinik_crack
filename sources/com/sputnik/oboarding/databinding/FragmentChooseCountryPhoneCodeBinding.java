package com.sputnik.oboarding.databinding;

import android.view.View;
import android.widget.EditText;
import android.widget.TextView;
import androidx.appcompat.widget.Toolbar;
import androidx.constraintlayout.widget.ConstraintLayout;
import androidx.recyclerview.widget.RecyclerView;
import androidx.viewbinding.ViewBinding;
import androidx.viewbinding.ViewBindings;
import com.sputnik.oboarding.R$id;

/* loaded from: classes3.dex */
public final class FragmentChooseCountryPhoneCodeBinding implements ViewBinding {
    public final EditText etSearchCountryCode;
    private final ConstraintLayout rootView;
    public final RecyclerView rvCountryCodesList;
    public final Toolbar toolbar;
    public final TextView tvTitleSearchCountryCode;

    private FragmentChooseCountryPhoneCodeBinding(ConstraintLayout constraintLayout, EditText editText, RecyclerView recyclerView, Toolbar toolbar, TextView textView) {
        this.rootView = constraintLayout;
        this.etSearchCountryCode = editText;
        this.rvCountryCodesList = recyclerView;
        this.toolbar = toolbar;
        this.tvTitleSearchCountryCode = textView;
    }

    @Override // androidx.viewbinding.ViewBinding
    public ConstraintLayout getRoot() {
        return this.rootView;
    }

    public static FragmentChooseCountryPhoneCodeBinding bind(View view) {
        int i = R$id.et_search_country_code;
        EditText editText = (EditText) ViewBindings.findChildViewById(view, i);
        if (editText != null) {
            i = R$id.rv_country_codes_list;
            RecyclerView recyclerView = (RecyclerView) ViewBindings.findChildViewById(view, i);
            if (recyclerView != null) {
                i = R$id.toolbar;
                Toolbar toolbar = (Toolbar) ViewBindings.findChildViewById(view, i);
                if (toolbar != null) {
                    i = R$id.tv_title_search_country_code;
                    TextView textView = (TextView) ViewBindings.findChildViewById(view, i);
                    if (textView != null) {
                        return new FragmentChooseCountryPhoneCodeBinding((ConstraintLayout) view, editText, recyclerView, toolbar, textView);
                    }
                }
            }
        }
        throw new NullPointerException("Missing required view with ID: ".concat(view.getResources().getResourceName(i)));
    }
}

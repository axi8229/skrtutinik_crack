package com.sputnik.oboarding.databinding;

import android.view.View;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.TextView;
import androidx.appcompat.widget.AppCompatButton;
import androidx.cardview.widget.CardView;
import androidx.constraintlayout.widget.ConstraintLayout;
import androidx.core.widget.NestedScrollView;
import androidx.viewbinding.ViewBinding;
import androidx.viewbinding.ViewBindings;
import com.sputnik.oboarding.R$id;

/* loaded from: classes3.dex */
public final class FragmentRegNumberBinding implements ViewBinding {
    public final AppCompatButton btnAccept;
    public final CardView cardRv;
    public final EditText etEnterPhone;
    public final ImageView ivEnterPhone;
    public final ConstraintLayout lEnterPhone;
    public final ConstraintLayout rootView;
    private final NestedScrollView rootView_;
    public final TextView title;
    public final TextView tvEditCountryCode;
    public final TextView tvEnterPhone;
    public final TextView tvLicences;
    public final TextView tvTitlePhone;
    public final View vVerticalDivider;

    private FragmentRegNumberBinding(NestedScrollView nestedScrollView, AppCompatButton appCompatButton, CardView cardView, EditText editText, ImageView imageView, ConstraintLayout constraintLayout, ConstraintLayout constraintLayout2, TextView textView, TextView textView2, TextView textView3, TextView textView4, TextView textView5, View view) {
        this.rootView_ = nestedScrollView;
        this.btnAccept = appCompatButton;
        this.cardRv = cardView;
        this.etEnterPhone = editText;
        this.ivEnterPhone = imageView;
        this.lEnterPhone = constraintLayout;
        this.rootView = constraintLayout2;
        this.title = textView;
        this.tvEditCountryCode = textView2;
        this.tvEnterPhone = textView3;
        this.tvLicences = textView4;
        this.tvTitlePhone = textView5;
        this.vVerticalDivider = view;
    }

    @Override // androidx.viewbinding.ViewBinding
    public NestedScrollView getRoot() {
        return this.rootView_;
    }

    public static FragmentRegNumberBinding bind(View view) {
        View viewFindChildViewById;
        int i = R$id.btn_accept;
        AppCompatButton appCompatButton = (AppCompatButton) ViewBindings.findChildViewById(view, i);
        if (appCompatButton != null) {
            i = R$id.card_rv;
            CardView cardView = (CardView) ViewBindings.findChildViewById(view, i);
            if (cardView != null) {
                i = R$id.et_enter_phone;
                EditText editText = (EditText) ViewBindings.findChildViewById(view, i);
                if (editText != null) {
                    i = R$id.iv_enter_phone;
                    ImageView imageView = (ImageView) ViewBindings.findChildViewById(view, i);
                    if (imageView != null) {
                        i = R$id.l_enter_phone;
                        ConstraintLayout constraintLayout = (ConstraintLayout) ViewBindings.findChildViewById(view, i);
                        if (constraintLayout != null) {
                            i = R$id.root_view;
                            ConstraintLayout constraintLayout2 = (ConstraintLayout) ViewBindings.findChildViewById(view, i);
                            if (constraintLayout2 != null) {
                                i = R$id.title;
                                TextView textView = (TextView) ViewBindings.findChildViewById(view, i);
                                if (textView != null) {
                                    i = R$id.tv_edit_country_code;
                                    TextView textView2 = (TextView) ViewBindings.findChildViewById(view, i);
                                    if (textView2 != null) {
                                        i = R$id.tv_enter_phone;
                                        TextView textView3 = (TextView) ViewBindings.findChildViewById(view, i);
                                        if (textView3 != null) {
                                            i = R$id.tv_licences;
                                            TextView textView4 = (TextView) ViewBindings.findChildViewById(view, i);
                                            if (textView4 != null) {
                                                i = R$id.tv_title_phone;
                                                TextView textView5 = (TextView) ViewBindings.findChildViewById(view, i);
                                                if (textView5 != null && (viewFindChildViewById = ViewBindings.findChildViewById(view, (i = R$id.v_vertical_divider))) != null) {
                                                    return new FragmentRegNumberBinding((NestedScrollView) view, appCompatButton, cardView, editText, imageView, constraintLayout, constraintLayout2, textView, textView2, textView3, textView4, textView5, viewFindChildViewById);
                                                }
                                            }
                                        }
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

package com.sputnik.oboarding.databinding;

import android.view.View;
import android.widget.TextView;
import androidx.appcompat.widget.AppCompatButton;
import androidx.cardview.widget.CardView;
import androidx.constraintlayout.widget.ConstraintLayout;
import androidx.core.widget.NestedScrollView;
import androidx.viewbinding.ViewBinding;
import androidx.viewbinding.ViewBindings;
import com.sputnik.oboarding.R$id;

/* loaded from: classes3.dex */
public final class FragmentLimitExceededBinding implements ViewBinding {
    public final AppCompatButton btnReturn;
    public final CardView cardRv;
    public final ConstraintLayout rootView;
    private final NestedScrollView rootView_;
    public final View title;
    public final TextView tvLimit;
    public final TextView tvTitle;

    private FragmentLimitExceededBinding(NestedScrollView nestedScrollView, AppCompatButton appCompatButton, CardView cardView, ConstraintLayout constraintLayout, View view, TextView textView, TextView textView2) {
        this.rootView_ = nestedScrollView;
        this.btnReturn = appCompatButton;
        this.cardRv = cardView;
        this.rootView = constraintLayout;
        this.title = view;
        this.tvLimit = textView;
        this.tvTitle = textView2;
    }

    @Override // androidx.viewbinding.ViewBinding
    public NestedScrollView getRoot() {
        return this.rootView_;
    }

    public static FragmentLimitExceededBinding bind(View view) {
        View viewFindChildViewById;
        int i = R$id.btn_return;
        AppCompatButton appCompatButton = (AppCompatButton) ViewBindings.findChildViewById(view, i);
        if (appCompatButton != null) {
            i = R$id.card_rv;
            CardView cardView = (CardView) ViewBindings.findChildViewById(view, i);
            if (cardView != null) {
                i = R$id.root_view;
                ConstraintLayout constraintLayout = (ConstraintLayout) ViewBindings.findChildViewById(view, i);
                if (constraintLayout != null && (viewFindChildViewById = ViewBindings.findChildViewById(view, (i = R$id.title))) != null) {
                    i = R$id.tv_limit;
                    TextView textView = (TextView) ViewBindings.findChildViewById(view, i);
                    if (textView != null) {
                        i = R$id.tv_title;
                        TextView textView2 = (TextView) ViewBindings.findChildViewById(view, i);
                        if (textView2 != null) {
                            return new FragmentLimitExceededBinding((NestedScrollView) view, appCompatButton, cardView, constraintLayout, viewFindChildViewById, textView, textView2);
                        }
                    }
                }
            }
        }
        throw new NullPointerException("Missing required view with ID: ".concat(view.getResources().getResourceName(i)));
    }
}

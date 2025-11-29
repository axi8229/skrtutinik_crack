package com.sputnik.oboarding.databinding;

import android.view.View;
import android.widget.Space;
import android.widget.TextView;
import androidx.appcompat.widget.AppCompatButton;
import androidx.cardview.widget.CardView;
import androidx.coordinatorlayout.widget.CoordinatorLayout;
import androidx.recyclerview.widget.RecyclerView;
import androidx.viewbinding.ViewBinding;
import androidx.viewbinding.ViewBindings;
import com.sputnik.oboarding.R$id;

/* loaded from: classes3.dex */
public final class FragmentStartChooseLanguageBinding implements ViewBinding {
    public final AppCompatButton btnAccept;
    public final Space btnAnchor;
    public final CardView cardRv;
    public final CoordinatorLayout rootView;
    private final CoordinatorLayout rootView_;
    public final RecyclerView rvLanguages;
    public final TextView title;

    private FragmentStartChooseLanguageBinding(CoordinatorLayout coordinatorLayout, AppCompatButton appCompatButton, Space space, CardView cardView, CoordinatorLayout coordinatorLayout2, RecyclerView recyclerView, TextView textView) {
        this.rootView_ = coordinatorLayout;
        this.btnAccept = appCompatButton;
        this.btnAnchor = space;
        this.cardRv = cardView;
        this.rootView = coordinatorLayout2;
        this.rvLanguages = recyclerView;
        this.title = textView;
    }

    @Override // androidx.viewbinding.ViewBinding
    public CoordinatorLayout getRoot() {
        return this.rootView_;
    }

    public static FragmentStartChooseLanguageBinding bind(View view) {
        int i = R$id.btn_accept;
        AppCompatButton appCompatButton = (AppCompatButton) ViewBindings.findChildViewById(view, i);
        if (appCompatButton != null) {
            i = R$id.btn_anchor;
            Space space = (Space) ViewBindings.findChildViewById(view, i);
            if (space != null) {
                i = R$id.card_rv;
                CardView cardView = (CardView) ViewBindings.findChildViewById(view, i);
                if (cardView != null) {
                    CoordinatorLayout coordinatorLayout = (CoordinatorLayout) view;
                    i = R$id.rv_languages;
                    RecyclerView recyclerView = (RecyclerView) ViewBindings.findChildViewById(view, i);
                    if (recyclerView != null) {
                        i = R$id.title;
                        TextView textView = (TextView) ViewBindings.findChildViewById(view, i);
                        if (textView != null) {
                            return new FragmentStartChooseLanguageBinding(coordinatorLayout, appCompatButton, space, cardView, coordinatorLayout, recyclerView, textView);
                        }
                    }
                }
            }
        }
        throw new NullPointerException("Missing required view with ID: ".concat(view.getResources().getResourceName(i)));
    }
}

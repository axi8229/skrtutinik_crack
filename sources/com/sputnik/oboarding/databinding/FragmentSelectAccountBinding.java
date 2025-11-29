package com.sputnik.oboarding.databinding;

import android.view.View;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;
import androidx.cardview.widget.CardView;
import androidx.constraintlayout.widget.ConstraintLayout;
import androidx.core.widget.NestedScrollView;
import androidx.recyclerview.widget.RecyclerView;
import androidx.viewbinding.ViewBinding;
import androidx.viewbinding.ViewBindings;
import com.sputnik.oboarding.R$id;

/* loaded from: classes3.dex */
public final class FragmentSelectAccountBinding implements ViewBinding {
    public final ConstraintLayout btnCreateAccount;
    public final ConstraintLayout constraintLayout;
    public final ImageView imageView2;
    public final ImageView ivConnect1;
    public final ConstraintLayout layoutHasAccounts;
    public final CardView layoutNoAccounts;
    public final LinearLayout layoutProgress;
    public final ConstraintLayout rootView;
    private final NestedScrollView rootView_;
    public final RecyclerView rvAccounts;
    public final TextView title;
    public final TextView tvCreateButton;
    public final TextView tvNoAccount;

    private FragmentSelectAccountBinding(NestedScrollView nestedScrollView, ConstraintLayout constraintLayout, ConstraintLayout constraintLayout2, ImageView imageView, ImageView imageView2, ConstraintLayout constraintLayout3, CardView cardView, LinearLayout linearLayout, ConstraintLayout constraintLayout4, RecyclerView recyclerView, TextView textView, TextView textView2, TextView textView3) {
        this.rootView_ = nestedScrollView;
        this.btnCreateAccount = constraintLayout;
        this.constraintLayout = constraintLayout2;
        this.imageView2 = imageView;
        this.ivConnect1 = imageView2;
        this.layoutHasAccounts = constraintLayout3;
        this.layoutNoAccounts = cardView;
        this.layoutProgress = linearLayout;
        this.rootView = constraintLayout4;
        this.rvAccounts = recyclerView;
        this.title = textView;
        this.tvCreateButton = textView2;
        this.tvNoAccount = textView3;
    }

    @Override // androidx.viewbinding.ViewBinding
    public NestedScrollView getRoot() {
        return this.rootView_;
    }

    public static FragmentSelectAccountBinding bind(View view) {
        int i = R$id.btn_create_account;
        ConstraintLayout constraintLayout = (ConstraintLayout) ViewBindings.findChildViewById(view, i);
        if (constraintLayout != null) {
            i = R$id.constraintLayout;
            ConstraintLayout constraintLayout2 = (ConstraintLayout) ViewBindings.findChildViewById(view, i);
            if (constraintLayout2 != null) {
                i = R$id.imageView2;
                ImageView imageView = (ImageView) ViewBindings.findChildViewById(view, i);
                if (imageView != null) {
                    i = R$id.ivConnect1;
                    ImageView imageView2 = (ImageView) ViewBindings.findChildViewById(view, i);
                    if (imageView2 != null) {
                        i = R$id.layout_has_accounts;
                        ConstraintLayout constraintLayout3 = (ConstraintLayout) ViewBindings.findChildViewById(view, i);
                        if (constraintLayout3 != null) {
                            i = R$id.layout_no_accounts;
                            CardView cardView = (CardView) ViewBindings.findChildViewById(view, i);
                            if (cardView != null) {
                                i = R$id.layout_progress;
                                LinearLayout linearLayout = (LinearLayout) ViewBindings.findChildViewById(view, i);
                                if (linearLayout != null) {
                                    i = R$id.root_view;
                                    ConstraintLayout constraintLayout4 = (ConstraintLayout) ViewBindings.findChildViewById(view, i);
                                    if (constraintLayout4 != null) {
                                        i = R$id.rv_accounts;
                                        RecyclerView recyclerView = (RecyclerView) ViewBindings.findChildViewById(view, i);
                                        if (recyclerView != null) {
                                            i = R$id.title;
                                            TextView textView = (TextView) ViewBindings.findChildViewById(view, i);
                                            if (textView != null) {
                                                i = R$id.tv_create_button;
                                                TextView textView2 = (TextView) ViewBindings.findChildViewById(view, i);
                                                if (textView2 != null) {
                                                    i = R$id.tv_no_account;
                                                    TextView textView3 = (TextView) ViewBindings.findChildViewById(view, i);
                                                    if (textView3 != null) {
                                                        return new FragmentSelectAccountBinding((NestedScrollView) view, constraintLayout, constraintLayout2, imageView, imageView2, constraintLayout3, cardView, linearLayout, constraintLayout4, recyclerView, textView, textView2, textView3);
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
        }
        throw new NullPointerException("Missing required view with ID: ".concat(view.getResources().getResourceName(i)));
    }
}

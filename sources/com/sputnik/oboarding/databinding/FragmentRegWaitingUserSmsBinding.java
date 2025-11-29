package com.sputnik.oboarding.databinding;

import android.view.View;
import android.widget.FrameLayout;
import android.widget.ImageView;
import android.widget.ProgressBar;
import android.widget.TextView;
import androidx.appcompat.widget.AppCompatButton;
import androidx.cardview.widget.CardView;
import androidx.core.widget.NestedScrollView;
import androidx.viewbinding.ViewBinding;
import androidx.viewbinding.ViewBindings;
import com.sputnik.oboarding.R$id;

/* loaded from: classes3.dex */
public final class FragmentRegWaitingUserSmsBinding implements ViewBinding {
    public final TextView btnChangeAuthMethod;
    public final AppCompatButton btnDone;
    public final CardView cardRv;
    public final ImageView ivDone;
    public final ProgressBar progressBar2;
    public final FrameLayout rootView;
    private final NestedScrollView rootView_;
    public final TextView tvDone;
    public final TextView tvTimer;
    public final TextView tvTitle;

    private FragmentRegWaitingUserSmsBinding(NestedScrollView nestedScrollView, TextView textView, AppCompatButton appCompatButton, CardView cardView, ImageView imageView, ProgressBar progressBar, FrameLayout frameLayout, TextView textView2, TextView textView3, TextView textView4) {
        this.rootView_ = nestedScrollView;
        this.btnChangeAuthMethod = textView;
        this.btnDone = appCompatButton;
        this.cardRv = cardView;
        this.ivDone = imageView;
        this.progressBar2 = progressBar;
        this.rootView = frameLayout;
        this.tvDone = textView2;
        this.tvTimer = textView3;
        this.tvTitle = textView4;
    }

    @Override // androidx.viewbinding.ViewBinding
    public NestedScrollView getRoot() {
        return this.rootView_;
    }

    public static FragmentRegWaitingUserSmsBinding bind(View view) {
        int i = R$id.btn_change_auth_method;
        TextView textView = (TextView) ViewBindings.findChildViewById(view, i);
        if (textView != null) {
            i = R$id.btn_done;
            AppCompatButton appCompatButton = (AppCompatButton) ViewBindings.findChildViewById(view, i);
            if (appCompatButton != null) {
                i = R$id.card_rv;
                CardView cardView = (CardView) ViewBindings.findChildViewById(view, i);
                if (cardView != null) {
                    i = R$id.iv_done;
                    ImageView imageView = (ImageView) ViewBindings.findChildViewById(view, i);
                    if (imageView != null) {
                        i = R$id.progressBar2;
                        ProgressBar progressBar = (ProgressBar) ViewBindings.findChildViewById(view, i);
                        if (progressBar != null) {
                            i = R$id.root_view;
                            FrameLayout frameLayout = (FrameLayout) ViewBindings.findChildViewById(view, i);
                            if (frameLayout != null) {
                                i = R$id.tv_done;
                                TextView textView2 = (TextView) ViewBindings.findChildViewById(view, i);
                                if (textView2 != null) {
                                    i = R$id.tv_timer;
                                    TextView textView3 = (TextView) ViewBindings.findChildViewById(view, i);
                                    if (textView3 != null) {
                                        i = R$id.tv_title;
                                        TextView textView4 = (TextView) ViewBindings.findChildViewById(view, i);
                                        if (textView4 != null) {
                                            return new FragmentRegWaitingUserSmsBinding((NestedScrollView) view, textView, appCompatButton, cardView, imageView, progressBar, frameLayout, textView2, textView3, textView4);
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

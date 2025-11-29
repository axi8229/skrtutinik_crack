package com.sputnik.oboarding.databinding;

import android.view.View;
import android.widget.FrameLayout;
import android.widget.TextView;
import androidx.appcompat.widget.AppCompatButton;
import androidx.cardview.widget.CardView;
import androidx.core.widget.NestedScrollView;
import androidx.viewbinding.ViewBinding;
import androidx.viewbinding.ViewBindings;
import com.sputnik.oboarding.R$id;

/* loaded from: classes3.dex */
public final class FragmentRegSendUserSmsBinding implements ViewBinding {
    public final TextView btnRegisterOnTablet;
    public final AppCompatButton btnToSmsMessenger;
    public final CardView cardRv;
    public final FrameLayout rootView;
    private final NestedScrollView rootView_;
    public final TextView tvDescription;
    public final TextView tvTitle;

    private FragmentRegSendUserSmsBinding(NestedScrollView nestedScrollView, TextView textView, AppCompatButton appCompatButton, CardView cardView, FrameLayout frameLayout, TextView textView2, TextView textView3) {
        this.rootView_ = nestedScrollView;
        this.btnRegisterOnTablet = textView;
        this.btnToSmsMessenger = appCompatButton;
        this.cardRv = cardView;
        this.rootView = frameLayout;
        this.tvDescription = textView2;
        this.tvTitle = textView3;
    }

    @Override // androidx.viewbinding.ViewBinding
    public NestedScrollView getRoot() {
        return this.rootView_;
    }

    public static FragmentRegSendUserSmsBinding bind(View view) {
        int i = R$id.btn_register_on_tablet;
        TextView textView = (TextView) ViewBindings.findChildViewById(view, i);
        if (textView != null) {
            i = R$id.btn_to_sms_messenger;
            AppCompatButton appCompatButton = (AppCompatButton) ViewBindings.findChildViewById(view, i);
            if (appCompatButton != null) {
                i = R$id.card_rv;
                CardView cardView = (CardView) ViewBindings.findChildViewById(view, i);
                if (cardView != null) {
                    i = R$id.root_view;
                    FrameLayout frameLayout = (FrameLayout) ViewBindings.findChildViewById(view, i);
                    if (frameLayout != null) {
                        i = R$id.tv_description;
                        TextView textView2 = (TextView) ViewBindings.findChildViewById(view, i);
                        if (textView2 != null) {
                            i = R$id.tv_title;
                            TextView textView3 = (TextView) ViewBindings.findChildViewById(view, i);
                            if (textView3 != null) {
                                return new FragmentRegSendUserSmsBinding((NestedScrollView) view, textView, appCompatButton, cardView, frameLayout, textView2, textView3);
                            }
                        }
                    }
                }
            }
        }
        throw new NullPointerException("Missing required view with ID: ".concat(view.getResources().getResourceName(i)));
    }
}

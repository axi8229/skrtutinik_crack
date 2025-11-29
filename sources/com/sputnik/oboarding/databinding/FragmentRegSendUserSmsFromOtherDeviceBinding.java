package com.sputnik.oboarding.databinding;

import android.view.View;
import android.widget.FrameLayout;
import android.widget.TextView;
import androidx.appcompat.widget.AppCompatButton;
import androidx.cardview.widget.CardView;
import androidx.core.widget.NestedScrollView;
import androidx.viewbinding.ViewBinding;
import androidx.viewbinding.ViewBindings;
import com.chaos.view.PinView;
import com.sputnik.oboarding.R$id;

/* loaded from: classes3.dex */
public final class FragmentRegSendUserSmsFromOtherDeviceBinding implements ViewBinding {
    public final AppCompatButton btnDone;
    public final CardView cardRv;
    public final FrameLayout rootView;
    private final NestedScrollView rootView_;
    public final TextView tvDescription;
    public final TextView tvDescription2;
    public final TextView tvTitle;
    public final TextView tvTitle2;
    public final PinView viewPin;

    private FragmentRegSendUserSmsFromOtherDeviceBinding(NestedScrollView nestedScrollView, AppCompatButton appCompatButton, CardView cardView, FrameLayout frameLayout, TextView textView, TextView textView2, TextView textView3, TextView textView4, PinView pinView) {
        this.rootView_ = nestedScrollView;
        this.btnDone = appCompatButton;
        this.cardRv = cardView;
        this.rootView = frameLayout;
        this.tvDescription = textView;
        this.tvDescription2 = textView2;
        this.tvTitle = textView3;
        this.tvTitle2 = textView4;
        this.viewPin = pinView;
    }

    @Override // androidx.viewbinding.ViewBinding
    public NestedScrollView getRoot() {
        return this.rootView_;
    }

    public static FragmentRegSendUserSmsFromOtherDeviceBinding bind(View view) {
        int i = R$id.btn_done;
        AppCompatButton appCompatButton = (AppCompatButton) ViewBindings.findChildViewById(view, i);
        if (appCompatButton != null) {
            i = R$id.card_rv;
            CardView cardView = (CardView) ViewBindings.findChildViewById(view, i);
            if (cardView != null) {
                i = R$id.root_view;
                FrameLayout frameLayout = (FrameLayout) ViewBindings.findChildViewById(view, i);
                if (frameLayout != null) {
                    i = R$id.tv_description;
                    TextView textView = (TextView) ViewBindings.findChildViewById(view, i);
                    if (textView != null) {
                        i = R$id.tv_description2;
                        TextView textView2 = (TextView) ViewBindings.findChildViewById(view, i);
                        if (textView2 != null) {
                            i = R$id.tv_title;
                            TextView textView3 = (TextView) ViewBindings.findChildViewById(view, i);
                            if (textView3 != null) {
                                i = R$id.tv_title2;
                                TextView textView4 = (TextView) ViewBindings.findChildViewById(view, i);
                                if (textView4 != null) {
                                    i = R$id.view_pin;
                                    PinView pinView = (PinView) ViewBindings.findChildViewById(view, i);
                                    if (pinView != null) {
                                        return new FragmentRegSendUserSmsFromOtherDeviceBinding((NestedScrollView) view, appCompatButton, cardView, frameLayout, textView, textView2, textView3, textView4, pinView);
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

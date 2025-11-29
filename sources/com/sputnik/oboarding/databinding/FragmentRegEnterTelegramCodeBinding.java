package com.sputnik.oboarding.databinding;

import android.view.View;
import android.widget.FrameLayout;
import android.widget.ProgressBar;
import android.widget.TextView;
import androidx.cardview.widget.CardView;
import androidx.core.widget.NestedScrollView;
import androidx.viewbinding.ViewBinding;
import androidx.viewbinding.ViewBindings;
import com.chaos.view.PinView;
import com.sputnik.oboarding.R$id;

/* loaded from: classes3.dex */
public final class FragmentRegEnterTelegramCodeBinding implements ViewBinding {
    public final TextView btnLoginBySms;
    public final CardView cardRv;
    public final ProgressBar pbRequestSms;
    public final FrameLayout rootView;
    private final NestedScrollView rootView_;
    public final TextView tvAboutCode;
    public final TextView tvErrorCode;
    public final TextView tvInfo;
    public final TextView tvSample;
    public final TextView tvTitle;
    public final PinView viewPin;

    private FragmentRegEnterTelegramCodeBinding(NestedScrollView nestedScrollView, TextView textView, CardView cardView, ProgressBar progressBar, FrameLayout frameLayout, TextView textView2, TextView textView3, TextView textView4, TextView textView5, TextView textView6, PinView pinView) {
        this.rootView_ = nestedScrollView;
        this.btnLoginBySms = textView;
        this.cardRv = cardView;
        this.pbRequestSms = progressBar;
        this.rootView = frameLayout;
        this.tvAboutCode = textView2;
        this.tvErrorCode = textView3;
        this.tvInfo = textView4;
        this.tvSample = textView5;
        this.tvTitle = textView6;
        this.viewPin = pinView;
    }

    @Override // androidx.viewbinding.ViewBinding
    public NestedScrollView getRoot() {
        return this.rootView_;
    }

    public static FragmentRegEnterTelegramCodeBinding bind(View view) {
        int i = R$id.btn_login_by_sms;
        TextView textView = (TextView) ViewBindings.findChildViewById(view, i);
        if (textView != null) {
            i = R$id.card_rv;
            CardView cardView = (CardView) ViewBindings.findChildViewById(view, i);
            if (cardView != null) {
                i = R$id.pb_request_sms;
                ProgressBar progressBar = (ProgressBar) ViewBindings.findChildViewById(view, i);
                if (progressBar != null) {
                    i = R$id.root_view;
                    FrameLayout frameLayout = (FrameLayout) ViewBindings.findChildViewById(view, i);
                    if (frameLayout != null) {
                        i = R$id.tv_about_code;
                        TextView textView2 = (TextView) ViewBindings.findChildViewById(view, i);
                        if (textView2 != null) {
                            i = R$id.tv_error_code;
                            TextView textView3 = (TextView) ViewBindings.findChildViewById(view, i);
                            if (textView3 != null) {
                                i = R$id.tv_info;
                                TextView textView4 = (TextView) ViewBindings.findChildViewById(view, i);
                                if (textView4 != null) {
                                    i = R$id.tv_sample;
                                    TextView textView5 = (TextView) ViewBindings.findChildViewById(view, i);
                                    if (textView5 != null) {
                                        i = R$id.tv_title;
                                        TextView textView6 = (TextView) ViewBindings.findChildViewById(view, i);
                                        if (textView6 != null) {
                                            i = R$id.view_pin;
                                            PinView pinView = (PinView) ViewBindings.findChildViewById(view, i);
                                            if (pinView != null) {
                                                return new FragmentRegEnterTelegramCodeBinding((NestedScrollView) view, textView, cardView, progressBar, frameLayout, textView2, textView3, textView4, textView5, textView6, pinView);
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

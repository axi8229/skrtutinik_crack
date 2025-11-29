package com.sputnik.oboarding.databinding;

import android.view.View;
import android.widget.HorizontalScrollView;
import android.widget.ImageView;
import android.widget.TextView;
import androidx.cardview.widget.CardView;
import androidx.constraintlayout.widget.ConstraintLayout;
import androidx.core.widget.NestedScrollView;
import androidx.viewbinding.ViewBinding;
import androidx.viewbinding.ViewBindings;
import com.chaos.view.PinView;
import com.sputnik.oboarding.R$id;

/* loaded from: classes3.dex */
public final class FragmentRegConnectIntercomBinding implements ViewBinding {
    public final ImageView btnClose;
    public final CardView cardRv;
    public final ImageView ivConnect1;
    public final ImageView ivConnect2;
    public final ImageView ivFirstIntercomImage;
    public final PinView llCodes;
    public final ConstraintLayout rootView;
    private final NestedScrollView rootView_;
    public final HorizontalScrollView scrollView;
    public final TextView tvCodeInfo;
    public final TextView tvCodeTitle;
    public final TextView tvSetupLater;
    public final TextView tvTimerConnectCode;
    public final TextView tvTitle;

    private FragmentRegConnectIntercomBinding(NestedScrollView nestedScrollView, ImageView imageView, CardView cardView, ImageView imageView2, ImageView imageView3, ImageView imageView4, PinView pinView, ConstraintLayout constraintLayout, HorizontalScrollView horizontalScrollView, TextView textView, TextView textView2, TextView textView3, TextView textView4, TextView textView5) {
        this.rootView_ = nestedScrollView;
        this.btnClose = imageView;
        this.cardRv = cardView;
        this.ivConnect1 = imageView2;
        this.ivConnect2 = imageView3;
        this.ivFirstIntercomImage = imageView4;
        this.llCodes = pinView;
        this.rootView = constraintLayout;
        this.scrollView = horizontalScrollView;
        this.tvCodeInfo = textView;
        this.tvCodeTitle = textView2;
        this.tvSetupLater = textView3;
        this.tvTimerConnectCode = textView4;
        this.tvTitle = textView5;
    }

    @Override // androidx.viewbinding.ViewBinding
    public NestedScrollView getRoot() {
        return this.rootView_;
    }

    public static FragmentRegConnectIntercomBinding bind(View view) {
        int i = R$id.btn_close;
        ImageView imageView = (ImageView) ViewBindings.findChildViewById(view, i);
        if (imageView != null) {
            i = R$id.card_rv;
            CardView cardView = (CardView) ViewBindings.findChildViewById(view, i);
            if (cardView != null) {
                i = R$id.ivConnect1;
                ImageView imageView2 = (ImageView) ViewBindings.findChildViewById(view, i);
                if (imageView2 != null) {
                    i = R$id.ivConnect2;
                    ImageView imageView3 = (ImageView) ViewBindings.findChildViewById(view, i);
                    if (imageView3 != null) {
                        i = R$id.iv_first_intercom_image;
                        ImageView imageView4 = (ImageView) ViewBindings.findChildViewById(view, i);
                        if (imageView4 != null) {
                            i = R$id.ll_codes;
                            PinView pinView = (PinView) ViewBindings.findChildViewById(view, i);
                            if (pinView != null) {
                                i = R$id.root_view;
                                ConstraintLayout constraintLayout = (ConstraintLayout) ViewBindings.findChildViewById(view, i);
                                if (constraintLayout != null) {
                                    i = R$id.scroll_view;
                                    HorizontalScrollView horizontalScrollView = (HorizontalScrollView) ViewBindings.findChildViewById(view, i);
                                    if (horizontalScrollView != null) {
                                        i = R$id.tv_code_info;
                                        TextView textView = (TextView) ViewBindings.findChildViewById(view, i);
                                        if (textView != null) {
                                            i = R$id.tv_code_title;
                                            TextView textView2 = (TextView) ViewBindings.findChildViewById(view, i);
                                            if (textView2 != null) {
                                                i = R$id.tv_setup_later;
                                                TextView textView3 = (TextView) ViewBindings.findChildViewById(view, i);
                                                if (textView3 != null) {
                                                    i = R$id.tv_timer_connect_code;
                                                    TextView textView4 = (TextView) ViewBindings.findChildViewById(view, i);
                                                    if (textView4 != null) {
                                                        i = R$id.tv_title;
                                                        TextView textView5 = (TextView) ViewBindings.findChildViewById(view, i);
                                                        if (textView5 != null) {
                                                            return new FragmentRegConnectIntercomBinding((NestedScrollView) view, imageView, cardView, imageView2, imageView3, imageView4, pinView, constraintLayout, horizontalScrollView, textView, textView2, textView3, textView4, textView5);
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
        }
        throw new NullPointerException("Missing required view with ID: ".concat(view.getResources().getResourceName(i)));
    }
}

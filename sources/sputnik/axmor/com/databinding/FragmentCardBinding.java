package sputnik.axmor.com.databinding;

import android.view.View;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.ScrollView;
import android.widget.TextView;
import androidx.appcompat.widget.Toolbar;
import androidx.constraintlayout.widget.ConstraintLayout;
import androidx.viewbinding.ViewBinding;
import androidx.viewbinding.ViewBindings;
import sputnik.axmor.com.R;

/* loaded from: classes5.dex */
public final class FragmentCardBinding implements ViewBinding {
    public final LinearLayout btnChange;
    public final LinearLayout btnDelete;
    public final ImageView btnDeletePaymentMethod;
    public final ImageView ivCardType;
    public final ImageView ivPaymentMethod;
    public final LinearLayout layoutHaveCard;
    public final ConstraintLayout layoutNoCard;
    public final ConstraintLayout layoutPaymentMethod;
    public final LinearLayout loader;
    private final LinearLayout rootView;
    public final ScrollView scrollView;
    public final TextView subsButtonGetAccess;
    public final LinearLayout subsNewLayout;
    public final Toolbar toolbar;
    public final TextView tvCardNumber;
    public final TextView tvCardType;
    public final TextView tvChange;
    public final TextView tvDelete;
    public final TextView tvPaymentMethod;
    public final TextView tvPaymentMethodInfo;
    public final TextView tvSubtitleForCard;
    public final TextView tvSubtitleNoCard;
    public final TextView tvTitle;

    private FragmentCardBinding(LinearLayout linearLayout, LinearLayout linearLayout2, LinearLayout linearLayout3, ImageView imageView, ImageView imageView2, ImageView imageView3, LinearLayout linearLayout4, ConstraintLayout constraintLayout, ConstraintLayout constraintLayout2, LinearLayout linearLayout5, ScrollView scrollView, TextView textView, LinearLayout linearLayout6, Toolbar toolbar, TextView textView2, TextView textView3, TextView textView4, TextView textView5, TextView textView6, TextView textView7, TextView textView8, TextView textView9, TextView textView10) {
        this.rootView = linearLayout;
        this.btnChange = linearLayout2;
        this.btnDelete = linearLayout3;
        this.btnDeletePaymentMethod = imageView;
        this.ivCardType = imageView2;
        this.ivPaymentMethod = imageView3;
        this.layoutHaveCard = linearLayout4;
        this.layoutNoCard = constraintLayout;
        this.layoutPaymentMethod = constraintLayout2;
        this.loader = linearLayout5;
        this.scrollView = scrollView;
        this.subsButtonGetAccess = textView;
        this.subsNewLayout = linearLayout6;
        this.toolbar = toolbar;
        this.tvCardNumber = textView2;
        this.tvCardType = textView3;
        this.tvChange = textView4;
        this.tvDelete = textView5;
        this.tvPaymentMethod = textView6;
        this.tvPaymentMethodInfo = textView7;
        this.tvSubtitleForCard = textView8;
        this.tvSubtitleNoCard = textView9;
        this.tvTitle = textView10;
    }

    @Override // androidx.viewbinding.ViewBinding
    public LinearLayout getRoot() {
        return this.rootView;
    }

    public static FragmentCardBinding bind(View view) {
        int i = R.id.btnChange;
        LinearLayout linearLayout = (LinearLayout) ViewBindings.findChildViewById(view, R.id.btnChange);
        if (linearLayout != null) {
            i = R.id.btnDelete;
            LinearLayout linearLayout2 = (LinearLayout) ViewBindings.findChildViewById(view, R.id.btnDelete);
            if (linearLayout2 != null) {
                i = R.id.btn_delete_payment_method;
                ImageView imageView = (ImageView) ViewBindings.findChildViewById(view, R.id.btn_delete_payment_method);
                if (imageView != null) {
                    i = R.id.ivCardType;
                    ImageView imageView2 = (ImageView) ViewBindings.findChildViewById(view, R.id.ivCardType);
                    if (imageView2 != null) {
                        i = R.id.iv_payment_method;
                        ImageView imageView3 = (ImageView) ViewBindings.findChildViewById(view, R.id.iv_payment_method);
                        if (imageView3 != null) {
                            i = R.id.layout_have_card;
                            LinearLayout linearLayout3 = (LinearLayout) ViewBindings.findChildViewById(view, R.id.layout_have_card);
                            if (linearLayout3 != null) {
                                i = R.id.layout_no_card;
                                ConstraintLayout constraintLayout = (ConstraintLayout) ViewBindings.findChildViewById(view, R.id.layout_no_card);
                                if (constraintLayout != null) {
                                    i = R.id.layout_payment_method;
                                    ConstraintLayout constraintLayout2 = (ConstraintLayout) ViewBindings.findChildViewById(view, R.id.layout_payment_method);
                                    if (constraintLayout2 != null) {
                                        i = R.id.loader;
                                        LinearLayout linearLayout4 = (LinearLayout) ViewBindings.findChildViewById(view, R.id.loader);
                                        if (linearLayout4 != null) {
                                            i = R.id.scroll_view;
                                            ScrollView scrollView = (ScrollView) ViewBindings.findChildViewById(view, R.id.scroll_view);
                                            if (scrollView != null) {
                                                i = R.id.subsButtonGetAccess;
                                                TextView textView = (TextView) ViewBindings.findChildViewById(view, R.id.subsButtonGetAccess);
                                                if (textView != null) {
                                                    i = R.id.subs_new_layout;
                                                    LinearLayout linearLayout5 = (LinearLayout) ViewBindings.findChildViewById(view, R.id.subs_new_layout);
                                                    if (linearLayout5 != null) {
                                                        i = R.id.toolbar;
                                                        Toolbar toolbar = (Toolbar) ViewBindings.findChildViewById(view, R.id.toolbar);
                                                        if (toolbar != null) {
                                                            i = R.id.tvCardNumber;
                                                            TextView textView2 = (TextView) ViewBindings.findChildViewById(view, R.id.tvCardNumber);
                                                            if (textView2 != null) {
                                                                i = R.id.tvCardType;
                                                                TextView textView3 = (TextView) ViewBindings.findChildViewById(view, R.id.tvCardType);
                                                                if (textView3 != null) {
                                                                    i = R.id.tv_change;
                                                                    TextView textView4 = (TextView) ViewBindings.findChildViewById(view, R.id.tv_change);
                                                                    if (textView4 != null) {
                                                                        i = R.id.tv_delete;
                                                                        TextView textView5 = (TextView) ViewBindings.findChildViewById(view, R.id.tv_delete);
                                                                        if (textView5 != null) {
                                                                            i = R.id.tv_payment_method;
                                                                            TextView textView6 = (TextView) ViewBindings.findChildViewById(view, R.id.tv_payment_method);
                                                                            if (textView6 != null) {
                                                                                i = R.id.tv_payment_method_info;
                                                                                TextView textView7 = (TextView) ViewBindings.findChildViewById(view, R.id.tv_payment_method_info);
                                                                                if (textView7 != null) {
                                                                                    i = R.id.tv_subtitle_for_card;
                                                                                    TextView textView8 = (TextView) ViewBindings.findChildViewById(view, R.id.tv_subtitle_for_card);
                                                                                    if (textView8 != null) {
                                                                                        i = R.id.tv_subtitle_no_card;
                                                                                        TextView textView9 = (TextView) ViewBindings.findChildViewById(view, R.id.tv_subtitle_no_card);
                                                                                        if (textView9 != null) {
                                                                                            i = R.id.tv_title;
                                                                                            TextView textView10 = (TextView) ViewBindings.findChildViewById(view, R.id.tv_title);
                                                                                            if (textView10 != null) {
                                                                                                return new FragmentCardBinding((LinearLayout) view, linearLayout, linearLayout2, imageView, imageView2, imageView3, linearLayout3, constraintLayout, constraintLayout2, linearLayout4, scrollView, textView, linearLayout5, toolbar, textView2, textView3, textView4, textView5, textView6, textView7, textView8, textView9, textView10);
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

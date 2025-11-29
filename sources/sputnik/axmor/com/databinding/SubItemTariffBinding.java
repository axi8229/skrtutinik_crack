package sputnik.axmor.com.databinding;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;
import androidx.cardview.widget.CardView;
import androidx.constraintlayout.widget.ConstraintLayout;
import androidx.constraintlayout.widget.Guideline;
import androidx.viewbinding.ViewBinding;
import androidx.viewbinding.ViewBindings;
import sputnik.axmor.com.R;

/* loaded from: classes5.dex */
public final class SubItemTariffBinding implements ViewBinding {
    public final ConstraintLayout cardViewLayout;
    public final CardView cardViewTariff;
    public final Guideline guideline4;
    public final ImageView ivSelected;
    private final ConstraintLayout rootView;
    public final TextView saleTariff;
    public final TextView tvSubAdd;
    public final TextView tvSubPrice;
    public final TextView tvSubTitle;

    private SubItemTariffBinding(ConstraintLayout constraintLayout, ConstraintLayout constraintLayout2, CardView cardView, Guideline guideline, ImageView imageView, TextView textView, TextView textView2, TextView textView3, TextView textView4) {
        this.rootView = constraintLayout;
        this.cardViewLayout = constraintLayout2;
        this.cardViewTariff = cardView;
        this.guideline4 = guideline;
        this.ivSelected = imageView;
        this.saleTariff = textView;
        this.tvSubAdd = textView2;
        this.tvSubPrice = textView3;
        this.tvSubTitle = textView4;
    }

    @Override // androidx.viewbinding.ViewBinding
    public ConstraintLayout getRoot() {
        return this.rootView;
    }

    public static SubItemTariffBinding inflate(LayoutInflater layoutInflater, ViewGroup viewGroup, boolean z) {
        View viewInflate = layoutInflater.inflate(R.layout.sub_item_tariff, viewGroup, false);
        if (z) {
            viewGroup.addView(viewInflate);
        }
        return bind(viewInflate);
    }

    public static SubItemTariffBinding bind(View view) {
        int i = R.id.card_view_layout;
        ConstraintLayout constraintLayout = (ConstraintLayout) ViewBindings.findChildViewById(view, R.id.card_view_layout);
        if (constraintLayout != null) {
            i = R.id.card_view_tariff;
            CardView cardView = (CardView) ViewBindings.findChildViewById(view, R.id.card_view_tariff);
            if (cardView != null) {
                i = R.id.guideline4;
                Guideline guideline = (Guideline) ViewBindings.findChildViewById(view, R.id.guideline4);
                if (guideline != null) {
                    i = R.id.iv_selected;
                    ImageView imageView = (ImageView) ViewBindings.findChildViewById(view, R.id.iv_selected);
                    if (imageView != null) {
                        i = R.id.sale_tariff;
                        TextView textView = (TextView) ViewBindings.findChildViewById(view, R.id.sale_tariff);
                        if (textView != null) {
                            i = R.id.tv_sub_add;
                            TextView textView2 = (TextView) ViewBindings.findChildViewById(view, R.id.tv_sub_add);
                            if (textView2 != null) {
                                i = R.id.tv_sub_price;
                                TextView textView3 = (TextView) ViewBindings.findChildViewById(view, R.id.tv_sub_price);
                                if (textView3 != null) {
                                    i = R.id.tv_sub_title;
                                    TextView textView4 = (TextView) ViewBindings.findChildViewById(view, R.id.tv_sub_title);
                                    if (textView4 != null) {
                                        return new SubItemTariffBinding((ConstraintLayout) view, constraintLayout, cardView, guideline, imageView, textView, textView2, textView3, textView4);
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

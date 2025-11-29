package npi.spay;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import androidx.appcompat.widget.AppCompatImageView;
import androidx.appcompat.widget.AppCompatTextView;
import androidx.cardview.widget.CardView;
import androidx.constraintlayout.widget.ConstraintLayout;
import androidx.viewbinding.ViewBinding;
import androidx.viewbinding.ViewBindings;
import ru.yoomoney.sdk.kassa.payments.R$id;
import ru.yoomoney.sdk.kassa.payments.R$layout;
import spay.sdk.view.BnplLogoCompositeView;

/* renamed from: npi.spay.dg, reason: case insensitive filesystem */
/* loaded from: classes4.dex */
public final class C1545dg implements ViewBinding {
    public final CardView a;
    public final BnplLogoCompositeView b;
    public final AppCompatTextView c;
    public final AppCompatTextView d;
    public final CardView e;
    public final AppCompatImageView f;

    public C1545dg(CardView cardView, BnplLogoCompositeView bnplLogoCompositeView, AppCompatTextView appCompatTextView, AppCompatTextView appCompatTextView2, CardView cardView2, AppCompatImageView appCompatImageView) {
        this.a = cardView;
        this.b = bnplLogoCompositeView;
        this.c = appCompatTextView;
        this.d = appCompatTextView2;
        this.e = cardView2;
        this.f = appCompatImageView;
    }

    public static C1545dg a(LayoutInflater layoutInflater, ViewGroup viewGroup) {
        View viewInflate = layoutInflater.inflate(R$layout.spay_composite_layout_bnpl_button, viewGroup, false);
        viewGroup.addView(viewInflate);
        int i = R$id.spay_aciv_bnpl_icon;
        BnplLogoCompositeView bnplLogoCompositeView = (BnplLogoCompositeView) ViewBindings.findChildViewById(viewInflate, i);
        if (bnplLogoCompositeView != null) {
            i = R$id.spay_actv_bnpl_subtitle;
            AppCompatTextView appCompatTextView = (AppCompatTextView) ViewBindings.findChildViewById(viewInflate, i);
            if (appCompatTextView != null) {
                i = R$id.spay_actv_bnpl_title;
                AppCompatTextView appCompatTextView2 = (AppCompatTextView) ViewBindings.findChildViewById(viewInflate, i);
                if (appCompatTextView2 != null) {
                    i = R$id.spay_cl_selected_card;
                    if (((ConstraintLayout) ViewBindings.findChildViewById(viewInflate, i)) != null) {
                        CardView cardView = (CardView) viewInflate;
                        i = R$id.spay_sclbb_aciv_switch;
                        AppCompatImageView appCompatImageView = (AppCompatImageView) ViewBindings.findChildViewById(viewInflate, i);
                        if (appCompatImageView != null) {
                            return new C1545dg(cardView, bnplLogoCompositeView, appCompatTextView, appCompatTextView2, cardView, appCompatImageView);
                        }
                    }
                }
            }
        }
        throw new NullPointerException("Missing required view with ID: ".concat(viewInflate.getResources().getResourceName(i)));
    }

    @Override // androidx.viewbinding.ViewBinding
    public final View getRoot() {
        return this.a;
    }
}

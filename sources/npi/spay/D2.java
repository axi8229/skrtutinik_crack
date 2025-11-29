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
import spay.sdk.view.CardLogoCompositeView;
import spay.sdk.view.SpayBonusCompositeView;

/* loaded from: classes4.dex */
public final class D2 implements ViewBinding {
    public final CardView a;
    public final CardLogoCompositeView b;
    public final ConstraintLayout c;
    public final CardView d;
    public final AppCompatImageView e;
    public final AppCompatTextView f;
    public final AppCompatTextView g;
    public final SpayBonusCompositeView h;

    public D2(CardView cardView, CardLogoCompositeView cardLogoCompositeView, ConstraintLayout constraintLayout, CardView cardView2, AppCompatImageView appCompatImageView, AppCompatTextView appCompatTextView, AppCompatTextView appCompatTextView2, SpayBonusCompositeView spayBonusCompositeView) {
        this.a = cardView;
        this.b = cardLogoCompositeView;
        this.c = constraintLayout;
        this.d = cardView2;
        this.e = appCompatImageView;
        this.f = appCompatTextView;
        this.g = appCompatTextView2;
        this.h = spayBonusCompositeView;
    }

    public static D2 a(LayoutInflater layoutInflater, ViewGroup viewGroup, boolean z) {
        View viewInflate = layoutInflater.inflate(R$layout.spay_rv_item_card_selection, viewGroup, false);
        if (z) {
            viewGroup.addView(viewInflate);
        }
        int i = R$id.spay_rics_card_logo_cv;
        CardLogoCompositeView cardLogoCompositeView = (CardLogoCompositeView) ViewBindings.findChildViewById(viewInflate, i);
        if (cardLogoCompositeView != null) {
            i = R$id.spay_rics_cl_content_container;
            ConstraintLayout constraintLayout = (ConstraintLayout) ViewBindings.findChildViewById(viewInflate, i);
            if (constraintLayout != null) {
                CardView cardView = (CardView) viewInflate;
                i = R$id.spay_rics_iv_status;
                AppCompatImageView appCompatImageView = (AppCompatImageView) ViewBindings.findChildViewById(viewInflate, i);
                if (appCompatImageView != null) {
                    i = R$id.spay_rics_tv_card_description;
                    AppCompatTextView appCompatTextView = (AppCompatTextView) ViewBindings.findChildViewById(viewInflate, i);
                    if (appCompatTextView != null) {
                        i = R$id.spay_rics_tv_card_title;
                        AppCompatTextView appCompatTextView2 = (AppCompatTextView) ViewBindings.findChildViewById(viewInflate, i);
                        if (appCompatTextView2 != null) {
                            i = R$id.spay_sbcv_bonus;
                            SpayBonusCompositeView spayBonusCompositeView = (SpayBonusCompositeView) ViewBindings.findChildViewById(viewInflate, i);
                            if (spayBonusCompositeView != null) {
                                return new D2(cardView, cardLogoCompositeView, constraintLayout, cardView, appCompatImageView, appCompatTextView, appCompatTextView2, spayBonusCompositeView);
                            }
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

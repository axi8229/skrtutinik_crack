package npi.spay;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import androidx.constraintlayout.widget.ConstraintLayout;
import androidx.viewbinding.ViewBinding;
import androidx.viewbinding.ViewBindings;
import ru.yoomoney.sdk.kassa.payments.R$id;
import ru.yoomoney.sdk.kassa.payments.R$layout;
import spay.sdk.view.SpayBonusCompositeView;

/* loaded from: classes4.dex */
public final class Lh implements ViewBinding {
    public final ConstraintLayout a;
    public final SpayBonusCompositeView b;

    public Lh(ConstraintLayout constraintLayout, SpayBonusCompositeView spayBonusCompositeView) {
        this.a = constraintLayout;
        this.b = spayBonusCompositeView;
    }

    public static Lh a(LayoutInflater layoutInflater, ViewGroup viewGroup) {
        View viewInflate = layoutInflater.inflate(R$layout.spay_composite_layout_bonus_overall_view, viewGroup, false);
        viewGroup.addView(viewInflate);
        int i = R$id.spay_sclbov_sbcv_bonuse_count;
        SpayBonusCompositeView spayBonusCompositeView = (SpayBonusCompositeView) ViewBindings.findChildViewById(viewInflate, i);
        if (spayBonusCompositeView != null) {
            return new Lh((ConstraintLayout) viewInflate, spayBonusCompositeView);
        }
        throw new NullPointerException("Missing required view with ID: ".concat(viewInflate.getResources().getResourceName(i)));
    }

    @Override // androidx.viewbinding.ViewBinding
    public final View getRoot() {
        return this.a;
    }
}

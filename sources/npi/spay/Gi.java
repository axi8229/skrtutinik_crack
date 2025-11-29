package npi.spay;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import androidx.appcompat.widget.AppCompatImageView;
import androidx.appcompat.widget.AppCompatTextView;
import androidx.constraintlayout.widget.ConstraintLayout;
import androidx.viewbinding.ViewBinding;
import androidx.viewbinding.ViewBindings;
import ru.yoomoney.sdk.kassa.payments.R$id;
import ru.yoomoney.sdk.kassa.payments.R$layout;

/* loaded from: classes4.dex */
public final class Gi implements ViewBinding {
    public final ConstraintLayout a;
    public final AppCompatTextView b;
    public final AppCompatImageView c;
    public final ConstraintLayout d;

    public Gi(ConstraintLayout constraintLayout, AppCompatTextView appCompatTextView, AppCompatImageView appCompatImageView, ConstraintLayout constraintLayout2) {
        this.a = constraintLayout;
        this.b = appCompatTextView;
        this.c = appCompatImageView;
        this.d = constraintLayout2;
    }

    public static Gi a(LayoutInflater layoutInflater, ViewGroup viewGroup) {
        View viewInflate = layoutInflater.inflate(R$layout.spay_composite_layout_bonus_view, viewGroup, false);
        viewGroup.addView(viewInflate);
        int i = R$id.spay_rics_actv_spasibo_bonus;
        AppCompatTextView appCompatTextView = (AppCompatTextView) ViewBindings.findChildViewById(viewInflate, i);
        if (appCompatTextView != null) {
            i = R$id.spay_rics_iv_spasibo_icon;
            AppCompatImageView appCompatImageView = (AppCompatImageView) ViewBindings.findChildViewById(viewInflate, i);
            if (appCompatImageView != null) {
                ConstraintLayout constraintLayout = (ConstraintLayout) viewInflate;
                return new Gi(constraintLayout, appCompatTextView, appCompatImageView, constraintLayout);
            }
        }
        throw new NullPointerException("Missing required view with ID: ".concat(viewInflate.getResources().getResourceName(i)));
    }

    @Override // androidx.viewbinding.ViewBinding
    public final View getRoot() {
        return this.a;
    }
}

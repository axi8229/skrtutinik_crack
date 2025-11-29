package npi.spay;

import android.view.View;
import androidx.appcompat.widget.AppCompatImageView;
import androidx.appcompat.widget.AppCompatTextView;
import androidx.constraintlayout.widget.ConstraintLayout;
import androidx.viewbinding.ViewBinding;
import spay.sdk.view.CardLogoCompositeView;

/* loaded from: classes4.dex */
public final class Bl implements ViewBinding {
    public final ConstraintLayout a;
    public final CardLogoCompositeView b;
    public final AppCompatImageView c;
    public final AppCompatTextView d;
    public final AppCompatTextView e;

    public Bl(AppCompatImageView appCompatImageView, AppCompatTextView appCompatTextView, AppCompatTextView appCompatTextView2, ConstraintLayout constraintLayout, CardLogoCompositeView cardLogoCompositeView) {
        this.a = constraintLayout;
        this.b = cardLogoCompositeView;
        this.c = appCompatImageView;
        this.d = appCompatTextView;
        this.e = appCompatTextView2;
    }

    @Override // androidx.viewbinding.ViewBinding
    public final View getRoot() {
        return this.a;
    }
}

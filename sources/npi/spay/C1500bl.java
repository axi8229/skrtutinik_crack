package npi.spay;

import android.view.View;
import androidx.appcompat.widget.AppCompatImageView;
import androidx.appcompat.widget.AppCompatTextView;
import androidx.constraintlayout.widget.ConstraintLayout;
import androidx.viewbinding.ViewBinding;
import spay.sdk.view.CardLogoCompositeView;

/* renamed from: npi.spay.bl, reason: case insensitive filesystem */
/* loaded from: classes4.dex */
public final class C1500bl implements ViewBinding {
    public final ConstraintLayout a;
    public final AppCompatImageView b;
    public final AppCompatTextView c;
    public final AppCompatTextView d;
    public final CardLogoCompositeView e;

    public C1500bl(AppCompatImageView appCompatImageView, AppCompatTextView appCompatTextView, AppCompatTextView appCompatTextView2, ConstraintLayout constraintLayout, CardLogoCompositeView cardLogoCompositeView) {
        this.a = constraintLayout;
        this.b = appCompatImageView;
        this.c = appCompatTextView;
        this.d = appCompatTextView2;
        this.e = cardLogoCompositeView;
    }

    @Override // androidx.viewbinding.ViewBinding
    public final View getRoot() {
        return this.a;
    }
}
